# RxAndroid

其实就是rxjava，rxandroid只是对在android平台上的一些扩展，所以这里主要分析rxjava。首先要了解下rxjava是什么，这个库
设计的初衷是解决java异步操作繁琐或者不方便，当然现在不仅仅是这个了，当然其最值得称道的是设计模式观察者模式，这里我们来分
析rxjava3

首先我们先要了解下观察者模式，被观察者（Observable）、订阅（subscribe）、观察者（Observer）、事件，被观察者和观察者
首先要实现订阅关系，然后被观察者才能把事件发送给观察者，与传统的观察者模式不一样的是，除了接收事件（onNext）外，还有工作
过程中发生错误，也会告知观察者（onError），被观察者已经完成所有工作（onCompleted），这两个方法只要有一个被调用，则表示
被观察者即使继续工作，产生新的事件去告知观察者，观察者也接收不到，也就是订阅关系已经结束。

下面我们来看看核心部分代码是如何实现的
主要涉及以下几个类：ObservableCreate、ObservableOnSubscribe、CreateEmitter、ObservableSubscribeOn、ObservableObserveOn、ObserveOnObserver、Observer
先从subscribe方法看，最后实际调用的是ObservableOnSubscribe.subscribe方法，当然中间可能你还会调用subscribeOn、observeOn等方法，
这些方法其实是产生新的Observable,在里面存放之前的Observable，有点类似链表，也就是调用subscribe，实际上除了调用自己的subscribe方法外，
还会调用其存的下一个节点对应的Observable的subscribe，直到最后的ObservableCreate调用ObservableOnSubscribe.subscribe方法，所以我们
可以在这可以知道被观察最终运行的线程由ObservableSubscribeOn决定。同理通知回调观察者也一样，ObservableObserveOn里的subscribe方法会在
其内重新封装一个ObserveOnObserver（类似Observable链表方式）给链表的下一个节点，类似的操作可以无限嵌套，知道最后生成CreateEmitter，然后调用
ObservableOnSubscribe.subscribe。然后就是CreateEmitter里onNext方法怎么把事件传递给观察者，其实看构造方法传Observer就知道实际上调用的是
Observer的onNext方法，再结合上面的链式调用，直到调用我们传的Observer.onNext。Observable的链是在构造函数也就是我们调用操作符时产生，Observer的
链是在subscribe方法内产生。所有上面的链表执行顺序为先进后出。

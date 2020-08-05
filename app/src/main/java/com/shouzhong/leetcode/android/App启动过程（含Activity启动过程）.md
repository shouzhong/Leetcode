# App启动过程（含Activity启动过程）
1. Launcher 捕获点击事件，其过程为 Launcher#onClick -> Launcher#onClickAppShortcut -> 
Launcher#startAppShortcutOrInfoActivity -> Launcher#startActivitySafely -> Activity#startActivity

2. 以 API 27 源码为例，说到了 Acitvity#startActivity，我们点击源码可以发现调用的是 Activity#startActivityForResult，
其中调用到了 Instrumentation#execStartActivity 这个方法

3. 在 Instrumentation#execStartActivity 中我们可以发现它调用了 ActivityManager#getService()#startActivity，
其 ActivityManager#getService() 是采用单例，返回的是实现 IActivityManager 类型的 Binder 对象，它的具体实现是在 
ActivityManagerService 中

4. 我们再到 ActivityManagerService#startActivity 查看其源码，发现其调用了 ActivityManagerService#startActivityAsUser，
该方法又调用了 ActivityStarter#startActivityMayWait

5. 我们查找到 ActivityStarter#startActivityMayWait，其间调用了 ActivityStarter#startActivityLocked，接着是 
ActivityStarter#startActivity，然后是 ActivityStarter#startActivityUnchecked，其调用了 
ActivityStackSupervisor#resumeFocusedStackTopActivityLocked

6. 到 ActivityStackSupervisor#resumeFocusedStackTopActivityLocked 中查看发现其调用了 ActivityStack#resumeTopActivityUncheckedLocked，
然后是 ActivityStack#resumeTopActivityInnerLocked，接着变又回到 ActivityStackSupervisor.java，调用了 
ActivityStackSupervisor#startSpecificActivityLocked，这个方法中会判断要启动 App 的进程是否存在，存在则通知进程
启动 Activity，否则就先将进程创建出来

7. 我们分析进程尚未存在的情况，因为我们后续还会再次遇到 ActivityStackSupervisor#realStartActivityLocked，
ActivityStackSupervisor#startSpecificActivityLocked 中创建进程使用到的 mService 为 ActivityManagerService，
我们查看 ActivityManagerService#startProcessLocked 的源码如下所示：
```
// http://androidxref.com/8.1.0_r33/xref/frameworks/base/services/core/java/com/android/server/am/ActivityManagerService.java#3777
private final void startProcessLocked(ProcessRecord app, String hostingType,
        String hostingNameStr, String abiOverride, String entryPoint, String[] entryPointArgs) {
    ...
    if (entryPoint == null) entryPoint = "android.app.ActivityThread";
    startResult = Process.start(entryPoint,
            app.processName, uid, uid, gids, debugFlags, mountExternal,
            app.info.targetSdkVersion, seInfo, requiredAbi, instructionSet,
            app.info.dataDir, invokeWith, entryPointArgs);
    ...
}
```

8. 发现最终调用的事 Process#start 来启动进程，进程的入口就是在 android.app.ActivityThread.java 类中的 main() 函数，
因此接下来我们从 ActivityThread#main 来分析，其调用了 ActivityThread#attach，其中 ActivityManager.getService() 
之前提到过，返回的是一个是实现 IActivityManager 类型的 Binder 对象，它的具体实现是在 ActivityManagerService 中

9. 我们又回到了 ActivityManagerService 中，查看其 attachApplication 函数，发现调用了 thread#bindApplication 
和 mStackSupervisor#attachApplicationLocked
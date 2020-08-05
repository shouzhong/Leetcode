# RecyclerView性能优化

## 数据处理和视图加载分离
数据最好异步处理，特别是那些耗时的操作

## 数据优化
对于从远端拉的数据，最好进行缓存，加快二次加载速度，能局部刷新最好用局部刷新

## 布局优化
1. 减少布局层级，不推荐使用ConstraintLayout
2. 减少xml文件的inflate时间，不仅包括layout，还有drawable，复用几率低且type多的情况下，建议用代码实现
3. 减少view对象创建，尽可能简化itemview，能共用部分提取出来自定义view

## 其他
1. 升级 RecycleView 版本到 25.1.0 及以上使用 Prefetch 功能
2. 如果 Item 高度是固定的话，可以使用 RecyclerView.setHasFixedSize(true)来避免 requestLayout 浪费资源；
3. 设置 RecyclerView.addOnScrollListener(listener); 来对滑动过程中停止加载的操作。
4. 如果不要求动画，可以通过 ((SimpleItemAnimator) rv.getItemAnimator()).setSupportsChangeAnimations(false); 把默认动画关闭来提升效率。
5. 对 TextView 使用 String.toUpperCase 来替代 android:textAllCaps="true"。
6. 对 TextView 使用 StaticLayout 或者 DynamicLayout 的自定义 View 来代替它。
7. 通过重写 RecyclerView.onViewRecycled(holder) 来回收资源。
8. 通过 RecycleView.setItemViewCacheSize(size); 来加大 RecyclerView 的缓存，用空间换时间来提高滚动的流畅性。
9. 如果多个 RecycledView 的 Adapter 是一样的，比如嵌套的 RecyclerView 中存在一样的 Adapter，可以通过设置 
RecyclerView.setRecycledViewPool(pool); 来共用一个 RecycledViewPool。
10. 对 ItemView 设置监听器，不要对每个 Item 都调用 addXxListener，应该大家公用一个 XxListener，根据 ID 来进行不同的操作，优化了对象的频繁创建带来的资源消耗。
11. 通过 getExtraLayoutSpace 来增加 RecyclerView 预留的额外空间（显示范围之外，应该额外缓存的空间），如下所示：
```
new LinearLayoutManager(this) {
    @Override
    protected int getExtraLayoutSpace(RecyclerView.State state) {
        return size;
    }
};
```
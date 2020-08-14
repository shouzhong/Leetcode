package com.shouzhong.compiler;

public class NameStore {
    private NameStore() {
    }

    public static String getGeneratedClassName(String clsName) {
        return clsName + "$Binding";
    }

    public static class Package {
        public static final String ANDROID_VIEW = "android.view";
    }

    public static class Class {
        // Android
        public static final String ANDROID_VIEW = "View";
        public static final String ANDROID_VIEW_ON_CLICK_LISTENER = "OnClickListener";
    }

    public static class Method {
        // Android
        public static final String ANDROID_VIEW_ON_CLICK = "onClick";

        // Binder
        public static final String BIND_VIEWS = "bindViews";
        public static final String BIND_ON_CLICKS = "bindOnClicks";
        public static final String BIND = "bind";
    }

    public static class Variable {
        public static final String ANDROID_ACTIVITY = "activity";
        public static final String ANDROID_VIEW = "view";
    }
}

package com.shouzhong.binder;

import android.app.Activity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Binding {
    private static <T extends Activity> void instantiateBinder(T target, String suffix) {
        try {
            Class<?> targetClass = target.getClass();
            String className = targetClass.getName();
            Class<?> bindingClass = targetClass.getClassLoader().loadClass(className + suffix);
            Constructor<?> classConstructor = bindingClass.getConstructor(targetClass);
            classConstructor.newInstance(target);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static <T extends Activity> void bind(T activity) {
        instantiateBinder(activity, "$Binding");
    }
}

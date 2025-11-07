package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public class AsyncHandlerUtil {
    public static void sendAsyncMessage(android.os.Handler handler, java.lang.Runnable runnable) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (handler == null) {
            throw new java.lang.NullPointerException();
        }
        android.os.Message messageObtain = android.os.Message.obtain(handler, runnable);
        if (android.os.Build.VERSION.SDK_INT >= 22) {
            messageObtain.setAsynchronous(true);
        } else {
            try {
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName(messageObtain.getClass().getName()).getDeclaredMethod("setAsynchronous", java.lang.Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(messageObtain, true);
            } catch (java.lang.Exception unused) {
            }
        }
        handler.sendMessage(messageObtain);
    }
}

package com.google.android.exoplayer2;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class AsyncHandlerUtil {
    public static void sendAsyncMessage(Handler handler, Runnable runnable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (handler == null) {
            throw new NullPointerException();
        }
        Message messageObtain = Message.obtain(handler, runnable);
        if (Build.VERSION.SDK_INT >= 22) {
            messageObtain.setAsynchronous(true);
        } else {
            try {
                Method declaredMethod = Class.forName(messageObtain.getClass().getName()).getDeclaredMethod("setAsynchronous", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(messageObtain, true);
            } catch (Exception unused) {
            }
        }
        handler.sendMessage(messageObtain);
    }
}

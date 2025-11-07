package com.oplus.compat.p187os;

import android.os.Handler;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;

/* loaded from: classes2.dex */
public class HandlerNative {

    private static class ReflectInfo {
        private static RefMethod<Boolean> hasCallbacks;

        private ReflectInfo() {
        }

        static {
            RefClass.load((Class<?>) ReflectInfo.class, (Class<?>) Handler.class);
        }
    }

    private HandlerNative() {
    }

    public static boolean hasCallbacks(Handler handler, Runnable runnable) throws UnSupportedApiVersionException {
        if (VersionUtils.m24889e()) {
            return handler.hasCallbacks(runnable);
        }
        if (VersionUtils.m24895k()) {
            return ((Boolean) ReflectInfo.hasCallbacks.call(handler, runnable)).booleanValue();
        }
        throw new UnSupportedApiVersionException("Not supported before L");
    }
}

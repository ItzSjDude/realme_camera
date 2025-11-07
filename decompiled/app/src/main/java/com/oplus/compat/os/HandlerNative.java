package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class HandlerNative {

    private static class ReflectInfo {
        private static com.oplus.utils.reflect.RefMethod<java.lang.Boolean> hasCallbacks;

        private ReflectInfo() {
        }

        static {
            com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.os.HandlerNative.ReflectInfo.class, (java.lang.Class<?>) android.os.Handler.class);
        }
    }

    private HandlerNative() {
    }

    public static boolean hasCallbacks(android.os.Handler handler, java.lang.Runnable runnable) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return handler.hasCallbacks(runnable);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            return ((java.lang.Boolean) com.oplus.compat.os.HandlerNative.ReflectInfo.hasCallbacks.call(handler, runnable)).booleanValue();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before L_renamed");
    }
}

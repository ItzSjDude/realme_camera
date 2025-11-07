package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class PerformanceManagerNative {

    private static class ReflectInfo {
        private static com.oplus.utils.reflect.RefMethod<java.lang.Void> disableMultiThreadOptimize;
        private static com.oplus.utils.reflect.RefMethod<java.lang.Void> enableMultiThreadOptimize;

        private ReflectInfo() {
        }

        static {
            com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.os.PerformanceManagerNative.ReflectInfo.class, "android.os.PerformanceManager");
        }
    }

    private PerformanceManagerNative() {
    }

    public static void disableMultiThreadOptimize() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.compat.os.PerformanceManagerNative.ReflectInfo.disableMultiThreadOptimize.call(null, new java.lang.Object[0]);
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }

    public static void enableMultiThreadOptimize() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.compat.os.PerformanceManagerNative.ReflectInfo.enableMultiThreadOptimize.call(null, new java.lang.Object[0]);
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }
}

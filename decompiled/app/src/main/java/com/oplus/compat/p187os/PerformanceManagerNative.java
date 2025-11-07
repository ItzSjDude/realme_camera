package com.oplus.compat.p187os;

import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;

/* loaded from: classes2.dex */
public class PerformanceManagerNative {

    private static class ReflectInfo {
        private static RefMethod<Void> disableMultiThreadOptimize;
        private static RefMethod<Void> enableMultiThreadOptimize;

        private ReflectInfo() {
        }

        static {
            RefClass.load((Class<?>) ReflectInfo.class, "android.os.PerformanceManager");
        }
    }

    private PerformanceManagerNative() {
    }

    public static void disableMultiThreadOptimize() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            ReflectInfo.disableMultiThreadOptimize.call(null, new Object[0]);
            return;
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }

    public static void enableMultiThreadOptimize() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            ReflectInfo.enableMultiThreadOptimize.call(null, new Object[0]);
            return;
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }
}

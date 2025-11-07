package com.oplus.compat.os.customize;

/* loaded from: classes2.dex */
public class OplusCustomizeStateManagerNative {
    private static final java.lang.String TAG = "OplusCustomizeStateManagerNative";

    private static class ReflectInfo {
        private static com.oplus.utils.reflect.RefMethod<java.util.List<java.lang.String>> getAllowedGetUsageStatusList;

        private ReflectInfo() {
        }

        static {
            com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.os.customize.OplusCustomizeStateManagerNative.ReflectInfo.class, "android.os.customize.OplusCustomizeStateManager");
        }
    }

    public static java.util.List<java.lang.String> getAllowedGetUsageStatusList(android.content.Context context) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            try {
                return (java.util.List) com.oplus.compat.os.customize.OplusCustomizeStateManagerNative.ReflectInfo.getAllowedGetUsageStatusList.call(android.os.customize.OplusCustomizeStateManager.getInstance(context), new java.lang.Object[0]);
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.e_renamed(TAG, "getAllowedGetUsageStatusList error: " + e_renamed.toString());
                return java.util.Collections.emptyList();
            }
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }
}

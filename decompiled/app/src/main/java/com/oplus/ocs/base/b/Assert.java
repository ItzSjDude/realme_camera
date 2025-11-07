package com.oplus.ocs.base.b_renamed;

/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f7513a = "a_renamed";

    public static boolean a_renamed(android.content.Context context, java.lang.String str) {
        int i_renamed;
        try {
            i_renamed = context.getPackageManager().getApplicationInfo(str, 128).uid;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(f7513a, java.lang.String.format("%s_renamed not found", str));
            i_renamed = 0;
        }
        return i_renamed != 0;
    }

    public static boolean a_renamed(android.content.Context context) {
        return b_renamed(context, "com.coloros.ocs.opencapabilityservice") || b_renamed(context, "com.oplus.ocs");
    }

    public static boolean b_renamed(android.content.Context context) {
        return c_renamed(context, "com.coloros.ocs.opencapabilityservice") || c_renamed(context, "com.oplus.ocs");
    }

    private static boolean b_renamed(android.content.Context context, java.lang.String str) {
        try {
            android.os.Bundle bundle = context.getPackageManager().getApplicationInfo(str, 128).metaData;
            return bundle != null && bundle.containsKey("ocs_internal") && bundle.getInt("ocs_internal", 0) == 1;
        } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
            com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(f7513a, java.lang.String.format("Unable to fetch metadata from teh manifest %s_renamed", e_renamed.getMessage()));
            return false;
        }
    }

    private static boolean c_renamed(android.content.Context context, java.lang.String str) {
        try {
            android.os.Bundle bundle = context.getPackageManager().getApplicationInfo(str, 128).metaData;
            if (bundle != null && bundle.containsKey("ocs_internal") && bundle.containsKey("ocs_optimize")) {
                int i_renamed = bundle.getInt("ocs_internal", 0);
                int i2 = bundle.getInt("ocs_optimize", 0);
                if (i_renamed == 1 && i2 == 1) {
                    return true;
                }
            }
            return false;
        } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
            com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(f7513a, java.lang.String.format("Unable to fetch metadata from teh manifest %s_renamed", e_renamed.getMessage()));
            return false;
        }
    }
}

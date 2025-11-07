package com.oplus.camera.util;

/* compiled from: NavigateUtils.java */
/* loaded from: classes2.dex */
public class j_renamed {
    public static void a_renamed(androidx.appcompat.app.c_renamed cVar, android.content.Intent intent, java.lang.String str) throws android.content.pm.PackageManager.NameNotFoundException {
        if (intent == null || cVar == null) {
            com.oplus.camera.e_renamed.c_renamed("NavigateUtils", "setNavigateTitle, intent or action bar is_renamed null");
            return;
        }
        java.lang.String stringExtra = intent.getStringExtra("navigate_title_text");
        if (android.text.TextUtils.isEmpty(stringExtra)) {
            stringExtra = a_renamed(cVar, intent);
        }
        com.oplus.camera.e_renamed.c_renamed("NavigateUtils", "setNavigateTitle, contentDescription: " + stringExtra);
        if (!android.text.TextUtils.isEmpty(stringExtra)) {
            cVar.setTitle(stringExtra);
        } else {
            cVar.setTitle(str);
        }
    }

    private static java.lang.String a_renamed(android.content.Context context, android.content.Intent intent) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.Context contextCreatePackageContext;
        if (context != null && intent != null) {
            int intExtra = intent.getIntExtra("navigate_title_id", 0);
            com.oplus.camera.e_renamed.b_renamed("NavigateUtils", "getContentDescriptionById(), id_renamed: " + intExtra);
            if (intExtra != 0) {
                java.lang.String stringExtra = intent.getStringExtra("navigate_parent_package");
                if (!android.text.TextUtils.isEmpty(stringExtra) && !stringExtra.equals(context.getPackageName())) {
                    try {
                        contextCreatePackageContext = context.createPackageContext(stringExtra, 3);
                    } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
                        e_renamed.printStackTrace();
                        contextCreatePackageContext = null;
                    }
                    if (contextCreatePackageContext != null) {
                        return contextCreatePackageContext.getResources().getString(intExtra);
                    }
                } else {
                    return context.getResources().getString(intExtra);
                }
            }
        }
        return null;
    }
}

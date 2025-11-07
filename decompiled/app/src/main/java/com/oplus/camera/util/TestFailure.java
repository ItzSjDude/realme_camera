package com.oplus.camera.util;

/* compiled from: DisableUitl.java */
/* loaded from: classes2.dex */
public class f_renamed {
    public static boolean a_renamed(android.app.Activity activity, java.lang.String str) throws android.content.pm.PackageManager.NameNotFoundException {
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        android.content.pm.ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = activity.getPackageManager().getApplicationInfo(str, 512);
        } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
            com.oplus.camera.e_renamed.a_renamed("DisableUitl", "isAppDiable, Exception: NameNotFoundException.", e_renamed);
        }
        return (applicationInfo == null || applicationInfo.enabled || (applicationInfo.flags & 1) == 0) ? false : true;
    }

    public static java.lang.String b_renamed(android.app.Activity activity, java.lang.String str) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.ApplicationInfo applicationInfo;
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        try {
            applicationInfo = activity.getPackageManager().getApplicationInfo(str, 512);
        } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
            com.oplus.camera.e_renamed.a_renamed("DisableUitl", "getAppName, Exception: NameNotFoundException.", e_renamed);
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            return applicationInfo.loadLabel(activity.getPackageManager()).toString();
        }
        return null;
    }

    public static void a_renamed(android.app.Activity activity, int i_renamed, java.lang.String str, java.lang.String str2) throws android.content.pm.PackageManager.NameNotFoundException {
        a_renamed(activity, activity.getResources().getString(i_renamed), str, str2);
    }

    public static void a_renamed(final android.app.Activity activity, java.lang.String str, final java.lang.String str2, java.lang.String str3) throws android.content.pm.PackageManager.NameNotFoundException {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        android.content.pm.ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = activity.getPackageManager().getApplicationInfo(str2, 512);
        } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
            com.oplus.camera.e_renamed.a_renamed("DisableUitl", "showDisableDialog, Exception: NameNotFoundException.", e_renamed);
        }
        if (android.text.TextUtils.isEmpty(str3)) {
            str3 = applicationInfo.loadLabel(activity.getPackageManager()).toString();
        }
        java.lang.String str4 = java.lang.String.format(activity.getResources().getString(com.oplus.camera.R_renamed.string.camera_is_enable_app), str3);
        android.content.DialogInterface.OnClickListener onClickListener = new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.util.f_renamed.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                if (i_renamed == -2) {
                    dialogInterface.dismiss();
                    return;
                }
                if (i_renamed != -1) {
                    return;
                }
                dialogInterface.dismiss();
                android.content.Intent intent = new android.content.Intent();
                intent.addFlags(com.google.android.exoplayer2.C_renamed.ENCODING_PCM_MU_LAW);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(android.net.Uri.fromParts("package", str2, null));
                activity.startActivity(intent);
            }
        };
        com.coui.appcompat.dialog.app.b_renamed.a_renamed cancelable = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(activity).setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: com.oplus.camera.util.f_renamed.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(android.content.DialogInterface dialogInterface, int i_renamed, android.view.KeyEvent keyEvent) {
                if (i_renamed != 4) {
                    return true;
                }
                dialogInterface.dismiss();
                return true;
            }
        }).setTitle(str4).setPositiveButton(com.oplus.camera.R_renamed.string.camera_app_enable_setting, onClickListener).setNegativeButton(com.oplus.camera.R_renamed.string.camera_app_set_disable, onClickListener).setCancelable(false);
        cancelable.setMessage(str);
        cancelable.show();
    }
}

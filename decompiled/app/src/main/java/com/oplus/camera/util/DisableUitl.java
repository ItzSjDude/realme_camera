package com.oplus.camera.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.google.android.exoplayer2.C1547C;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;

/* compiled from: DisableUitl.java */
/* renamed from: com.oplus.camera.util.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class DisableUitl {
    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24536a(Activity activity, String str) throws PackageManager.NameNotFoundException {
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = activity.getPackageManager().getApplicationInfo(str, 512);
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            CameraLog.m12956a("DisableUitl", "isAppDiable, Exception: NameNotFoundException.", COUIBaseListPopupWindow_8);
        }
        return (applicationInfo == null || applicationInfo.enabled || (applicationInfo.flags & 1) == 0) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m24537b(Activity activity, String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        try {
            applicationInfo = activity.getPackageManager().getApplicationInfo(str, 512);
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            CameraLog.m12956a("DisableUitl", "getAppName, Exception: NameNotFoundException.", COUIBaseListPopupWindow_8);
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            return applicationInfo.loadLabel(activity.getPackageManager()).toString();
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24534a(Activity activity, int OplusGLSurfaceView_13, String str, String str2) throws PackageManager.NameNotFoundException {
        m24535a(activity, activity.getResources().getString(OplusGLSurfaceView_13), str, str2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24535a(final Activity activity, String str, final String str2, String str3) throws PackageManager.NameNotFoundException {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = activity.getPackageManager().getApplicationInfo(str2, 512);
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            CameraLog.m12956a("DisableUitl", "showDisableDialog, Exception: NameNotFoundException.", COUIBaseListPopupWindow_8);
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = applicationInfo.loadLabel(activity.getPackageManager()).toString();
        }
        String str4 = String.format(activity.getResources().getString(R.string.camera_is_enable_app), str3);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.oplus.camera.util.COUIBaseListPopupWindow_12.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                if (OplusGLSurfaceView_13 == -2) {
                    dialogInterface.dismiss();
                    return;
                }
                if (OplusGLSurfaceView_13 != -1) {
                    return;
                }
                dialogInterface.dismiss();
                Intent intent = new Intent();
                intent.addFlags(C1547C.ENCODING_PCM_MU_LAW);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", str2, null));
                activity.startActivity(intent);
            }
        };
        COUIAlertDialog.PlatformImplementations.kt_3 cancelable = new COUIAlertDialog.PlatformImplementations.kt_3(activity).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.oplus.camera.util.COUIBaseListPopupWindow_12.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int OplusGLSurfaceView_13, KeyEvent keyEvent) {
                if (OplusGLSurfaceView_13 != 4) {
                    return true;
                }
                dialogInterface.dismiss();
                return true;
            }
        }).setTitle(str4).setPositiveButton(R.string.camera_app_enable_setting, onClickListener).setNegativeButton(R.string.camera_app_set_disable, onClickListener).setCancelable(false);
        cancelable.setMessage(str);
        cancelable.show();
    }
}

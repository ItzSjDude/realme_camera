package com.oplus.camera.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.oplus.camera.CameraLog;

/* compiled from: NavigateUtils.java */
/* renamed from: com.oplus.camera.util.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class NavigateUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24586a(AppCompatActivity activityC0205c, Intent intent, String str) throws PackageManager.NameNotFoundException {
        if (intent == null || activityC0205c == null) {
            CameraLog.m12962c("NavigateUtils", "setNavigateTitle, intent or action bar is null");
            return;
        }
        String stringExtra = intent.getStringExtra("navigate_title_text");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = m24585a(activityC0205c, intent);
        }
        CameraLog.m12962c("NavigateUtils", "setNavigateTitle, contentDescription: " + stringExtra);
        if (!TextUtils.isEmpty(stringExtra)) {
            activityC0205c.setTitle(stringExtra);
        } else {
            activityC0205c.setTitle(str);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m24585a(Context context, Intent intent) throws PackageManager.NameNotFoundException {
        Context contextCreatePackageContext;
        if (context != null && intent != null) {
            int intExtra = intent.getIntExtra("navigate_title_id", 0);
            CameraLog.m12959b("NavigateUtils", "getContentDescriptionById(), id_renamed: " + intExtra);
            if (intExtra != 0) {
                String stringExtra = intent.getStringExtra("navigate_parent_package");
                if (!TextUtils.isEmpty(stringExtra) && !stringExtra.equals(context.getPackageName())) {
                    try {
                        contextCreatePackageContext = context.createPackageContext(stringExtra, 3);
                    } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
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

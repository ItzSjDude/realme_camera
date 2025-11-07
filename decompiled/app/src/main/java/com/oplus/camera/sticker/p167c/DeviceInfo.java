package com.oplus.camera.sticker.p167c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.oplus.camera.util.Util;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p187os.SystemPropertiesNative;
import com.oplus.os.OplusBuild;

/* compiled from: DeviceInfo.java */
/* renamed from: com.oplus.camera.sticker.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class DeviceInfo {

    /* renamed from: PlatformImplementations.kt_3 */
    private static volatile DeviceInfo f16206a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f16207b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f16208c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f16209d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String f16210e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f16211f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f16212g = -1;

    /* renamed from: PlatformImplementations.kt_3 */
    public static DeviceInfo m16801a() {
        if (f16206a == null) {
            synchronized (DeviceInfo.class) {
                if (f16206a == null) {
                    f16206a = new DeviceInfo();
                }
            }
        }
        return f16206a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m16803b() {
        if (TextUtils.isEmpty(this.f16208c)) {
            try {
                this.f16208c = SystemPropertiesNative.get("ro.product.name");
            } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        return this.f16208c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m16802a(Context context) throws PackageManager.NameNotFoundException {
        if (this.f16212g == -1) {
            PackageInfo packageInfo = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            if (packageInfo != null) {
                this.f16212g = packageInfo.versionCode;
            }
        }
        return this.f16212g;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public String m16805c() {
        if (TextUtils.isEmpty(this.f16209d)) {
            this.f16209d = OplusBuild.VERSION.RELEASE;
        }
        return this.f16209d;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m16806d() {
        if (TextUtils.isEmpty(this.f16210e)) {
            try {
                this.f16210e = SystemPropertiesNative.get("ro.build.version.ota");
            } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        return this.f16210e;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public String m16807e() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public String m16808f() {
        String strM24360aw = Util.m24360aw();
        return TextUtils.isEmpty(strM24360aw) ? "CN" : strM24360aw;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m16804b(Context context) {
        if (TextUtils.isEmpty(this.f16211f)) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if (displayMetrics.widthPixels >= 1080) {
                this.f16211f = "1080P";
            } else {
                this.f16211f = "720P";
            }
        }
        return this.f16211f;
    }
}

package com.oplus.camera.sticker.c_renamed;

/* compiled from: DeviceInfo.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static volatile com.oplus.camera.sticker.c_renamed.a_renamed f5440a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f5441b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f5442c = null;
    private java.lang.String d_renamed = null;
    private java.lang.String e_renamed = null;
    private java.lang.String f_renamed = null;
    private int g_renamed = -1;

    public static com.oplus.camera.sticker.c_renamed.a_renamed a_renamed() {
        if (f5440a == null) {
            synchronized (com.oplus.camera.sticker.c_renamed.a_renamed.class) {
                if (f5440a == null) {
                    f5440a = new com.oplus.camera.sticker.c_renamed.a_renamed();
                }
            }
        }
        return f5440a;
    }

    public java.lang.String b_renamed() {
        if (android.text.TextUtils.isEmpty(this.f5442c)) {
            try {
                this.f5442c = com.oplus.compat.os.SystemPropertiesNative.get("ro.product.name");
            } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        return this.f5442c;
    }

    public int a_renamed(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        if (this.g_renamed == -1) {
            android.content.pm.PackageInfo packageInfo = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
                e_renamed.printStackTrace();
            }
            if (packageInfo != null) {
                this.g_renamed = packageInfo.versionCode;
            }
        }
        return this.g_renamed;
    }

    public java.lang.String c_renamed() {
        if (android.text.TextUtils.isEmpty(this.d_renamed)) {
            this.d_renamed = com.oplus.os.OplusBuild.VERSION.RELEASE;
        }
        return this.d_renamed;
    }

    public java.lang.String d_renamed() {
        if (android.text.TextUtils.isEmpty(this.e_renamed)) {
            try {
                this.e_renamed = com.oplus.compat.os.SystemPropertiesNative.get("ro.build.version.ota");
            } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        return this.e_renamed;
    }

    public java.lang.String e_renamed() {
        return android.os.Build.VERSION.RELEASE;
    }

    public java.lang.String f_renamed() {
        java.lang.String strAw = com.oplus.camera.util.Util.aw_renamed();
        return android.text.TextUtils.isEmpty(strAw) ? "CN" : strAw;
    }

    public java.lang.String b_renamed(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(this.f_renamed)) {
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if (displayMetrics.widthPixels >= 1080) {
                this.f_renamed = "1080P";
            } else {
                this.f_renamed = "720P";
            }
        }
        return this.f_renamed;
    }
}

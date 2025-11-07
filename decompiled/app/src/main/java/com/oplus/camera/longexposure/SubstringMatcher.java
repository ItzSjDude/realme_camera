package com.oplus.camera.longexposure;

/* compiled from: LongExposureTimeControl.java */
/* loaded from: classes2.dex */
public class k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f4858a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.SharedPreferences f4859b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.os.Handler f4860c;
    private com.oplus.camera.capmode.a_renamed d_renamed;
    private com.oplus.camera.ui.CameraUIInterface e_renamed;
    private com.oplus.camera.longexposure.e_renamed f_renamed = null;

    public k_renamed(android.app.Activity activity, android.content.SharedPreferences sharedPreferences, android.os.Handler handler, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        this.f4858a = null;
        this.f4859b = null;
        this.f4860c = null;
        this.e_renamed = null;
        this.f4858a = activity;
        this.f4859b = sharedPreferences;
        this.f4860c = handler;
        this.d_renamed = aVar;
        this.e_renamed = cameraUIInterface;
    }

    public void a_renamed(int i_renamed) {
        if (this.f_renamed == null) {
            android.app.Activity activity = this.f4858a;
            this.f_renamed = new com.oplus.camera.longexposure.e_renamed(activity, activity, this.f4859b, this.f4860c, this.d_renamed);
            this.f_renamed.a_renamed(i_renamed);
        }
    }

    public void b_renamed(int i_renamed) {
        this.f_renamed.b_renamed(i_renamed);
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        this.f_renamed.a_renamed(i_renamed, z_renamed);
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureTimeControl", "showViewWithAnimation  isMoreModeShown: " + this.e_renamed.R_renamed());
        if (this.e_renamed.R_renamed()) {
            return;
        }
        this.f_renamed.a_renamed(z_renamed);
    }

    public void b_renamed(boolean z_renamed) {
        this.f_renamed.b_renamed(z_renamed);
    }

    public float c_renamed(int i_renamed) {
        return this.f_renamed.c_renamed(i_renamed);
    }

    public void d_renamed(int i_renamed) {
        this.f_renamed.d_renamed(i_renamed);
    }
}

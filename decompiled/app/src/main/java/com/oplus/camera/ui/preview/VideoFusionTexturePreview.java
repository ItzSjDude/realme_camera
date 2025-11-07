package com.oplus.camera.ui.preview;

/* compiled from: VideoCaptureAnimManager.java */
/* loaded from: classes2.dex */
public class ad_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.view.animation.Interpolator f6994a = new android.view.animation.DecelerateInterpolator();

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6995b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private long f6996c;
    private float d_renamed;
    private float e_renamed;
    private float f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        this.f6996c = android.os.SystemClock.uptimeMillis();
        this.g_renamed = i3;
        this.h_renamed = i4;
        this.d_renamed = i_renamed;
        this.e_renamed = i2;
        int i5 = this.f6995b;
        if (i5 == 0) {
            this.f_renamed = i3;
            return;
        }
        if (i5 == 90) {
            this.f_renamed = -i4;
        } else if (i5 == 180) {
            this.f_renamed = -i3;
        } else {
            if (i5 != 270) {
                return;
            }
            this.f_renamed = i4;
        }
    }

    public boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.ui.preview.h_renamed hVar2, com.oplus.camera.gl_renamed.s_renamed sVar) {
        long jUptimeMillis = android.os.SystemClock.uptimeMillis() - this.f6996c;
        if (this.i_renamed == 2 && jUptimeMillis > 400) {
            return false;
        }
        if (this.i_renamed == 0 && jUptimeMillis > 800) {
            return false;
        }
        int i_renamed = this.i_renamed;
        if (i_renamed == 0) {
            i_renamed = jUptimeMillis < 400 ? 1 : 2;
            if (i_renamed == 2) {
                jUptimeMillis -= 400;
            }
        }
        if (i_renamed == 1) {
            sVar.a_renamed(hVar, (int) this.d_renamed, (int) this.e_renamed, this.g_renamed, this.h_renamed);
            if (jUptimeMillis < 200) {
                hVar.a_renamed(this.d_renamed, this.e_renamed, this.g_renamed, this.h_renamed, android.graphics.Color.argb((int) ((0.3f - ((jUptimeMillis * 0.3f) / 200.0f)) * 255.0f), 255, 255, 255));
            }
        } else {
            if (i_renamed != 2) {
                return false;
            }
            hVar2.a_renamed(hVar, (int) this.d_renamed, (int) this.e_renamed, this.g_renamed, this.h_renamed);
        }
        return true;
    }
}

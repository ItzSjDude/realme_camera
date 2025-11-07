package com.oplus.camera.gl_renamed.b_renamed;

/* compiled from: MultiVideoSmallSurfaceTouchEventHelper.java */
/* loaded from: classes2.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.oplus.camera.gl_renamed.b_renamed.e_renamed f4602a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f4603b = false;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f4604c = false;
    private float d_renamed = 0.0f;
    private float e_renamed = 0.0f;
    private int f_renamed = 0;
    private int g_renamed = 0;
    private int h_renamed = 0;
    private int i_renamed = 0;

    private e_renamed() {
    }

    public static com.oplus.camera.gl_renamed.b_renamed.e_renamed a_renamed() {
        if (f4602a == null) {
            f4602a = new com.oplus.camera.gl_renamed.b_renamed.e_renamed();
        }
        return f4602a;
    }

    public boolean a_renamed(android.view.MotionEvent motionEvent, com.oplus.camera.ui.preview.h_renamed hVar) {
        int screenWidth;
        int i_renamed;
        int screenHeight;
        int i2;
        android.graphics.Rect rectB = hVar.B_renamed();
        float rawX = motionEvent.getRawX() - hVar.z_renamed();
        float rawY = motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f4603b = false;
            this.f4604c = false;
            if (rectB.contains((int) rawX, (int) rawY)) {
                this.f4603b = true;
                this.d_renamed = rawX;
                this.e_renamed = rawY;
            }
        } else if (action != 1) {
            if (action == 2) {
                float f_renamed = rawX - this.d_renamed;
                float f2 = rawY - this.e_renamed;
                if (this.f4603b && (f_renamed != 0.0f || f2 != 0.0f)) {
                    this.f4604c = true;
                    this.d_renamed = rawX;
                    this.e_renamed = rawY;
                    boolean zU = com.oplus.camera.util.Util.u_renamed();
                    int i3 = (int) (rectB.left + f_renamed);
                    int i4 = (int) (rectB.top + f2);
                    int settingMenuPanelHeight = zU ? this.h_renamed : com.oplus.camera.util.Util.getSettingMenuPanelHeight() + this.h_renamed;
                    if (zU) {
                        screenWidth = hVar.A_renamed() - rectB.width();
                        i_renamed = this.g_renamed;
                    } else {
                        screenWidth = com.oplus.camera.util.Util.getScreenWidth() - rectB.width();
                        i_renamed = this.g_renamed;
                    }
                    int i5 = screenWidth - i_renamed;
                    if (zU) {
                        screenHeight = com.oplus.camera.util.Util.getScreenHeight() - rectB.height();
                        i2 = this.i_renamed;
                    } else {
                        screenHeight = (com.oplus.camera.util.Util.getScreenHeight() - com.oplus.camera.util.Util.O_renamed()) - rectB.height();
                        i2 = this.i_renamed;
                    }
                    hVar.e_renamed(java.lang.Math.min(java.lang.Math.max(i3, this.f_renamed), i5), java.lang.Math.min(java.lang.Math.max(settingMenuPanelHeight, i4), screenHeight - i2));
                    return true;
                }
            }
        } else {
            if (this.f4603b && this.f4604c) {
                this.f4603b = false;
                this.f4604c = false;
                return true;
            }
            this.f4603b = false;
            this.f4604c = false;
        }
        return false;
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        this.f_renamed = i_renamed;
        this.h_renamed = i2;
        this.g_renamed = i3;
        this.i_renamed = i4;
    }

    public boolean b_renamed() {
        return this.f4604c;
    }

    public boolean c_renamed() {
        return this.f4603b;
    }
}

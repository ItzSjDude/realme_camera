package com.oplus.camera.ui.preview;

/* compiled from: AiHintUI.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f7019a;
    private com.oplus.camera.ui.CameraUIListener d_renamed;
    private int i_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.widget.RelativeLayout f7020b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.preview.AiTextHintView f7021c = null;
    private int e_renamed = 0;
    private int f_renamed = 0;
    private int g_renamed = 0;
    private int h_renamed = 0;

    public b_renamed(android.app.Activity activity, int i_renamed, com.oplus.camera.ui.CameraUIListener cameraUIListener) {
        this.f7019a = null;
        this.d_renamed = null;
        this.i_renamed = 0;
        this.f7019a = activity;
        this.i_renamed = i_renamed;
        this.d_renamed = cameraUIListener;
    }

    private void e_renamed() {
        this.f7020b = (android.widget.RelativeLayout) this.f7019a.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        if (this.f7020b == null) {
            return;
        }
        com.oplus.camera.ui.preview.PreviewFrameLayout previewFrameLayout = (com.oplus.camera.ui.preview.PreviewFrameLayout) this.f7019a.findViewById(com.oplus.camera.R_renamed.id_renamed.frame_layout);
        int top = previewFrameLayout.getTop();
        int height = previewFrameLayout.getHeight();
        android.view.LayoutInflater layoutInflater = this.f7019a.getLayoutInflater();
        if (this.f7021c == null) {
            this.f7021c = (com.oplus.camera.ui.preview.AiTextHintView) layoutInflater.inflate(com.oplus.camera.R_renamed.layout.ai_hint_layout, (android.view.ViewGroup) null);
            this.f7020b.addView(this.f7021c);
            this.f7021c.a_renamed(this.e_renamed, top, height, 0, this.i_renamed, this.d_renamed);
        }
    }

    private void f_renamed() {
        com.oplus.camera.ui.preview.AiTextHintView aiTextHintView;
        this.f7020b = (android.widget.RelativeLayout) this.f7019a.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        android.widget.RelativeLayout relativeLayout = this.f7020b;
        if (relativeLayout == null || (aiTextHintView = this.f7021c) == null) {
            return;
        }
        relativeLayout.removeView(aiTextHintView);
        this.f7021c = null;
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        this.e_renamed = i_renamed;
        this.g_renamed = i2;
        this.h_renamed = i3;
        this.f_renamed = i4;
        f_renamed();
        e_renamed();
        com.oplus.camera.ui.preview.AiTextHintView aiTextHintView = this.f7021c;
        if (aiTextHintView != null) {
            aiTextHintView.a_renamed(this.e_renamed, this.f_renamed, i2, i3);
            this.f7021c.clearAnimation();
            this.f7021c.startAnimation(this.f7021c.a_renamed(0.0f, 1.0f));
        }
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.AiTextHintView aiTextHintView = this.f7021c;
        if (aiTextHintView != null && aiTextHintView.getVisibility() == 0) {
            this.f7021c.clearAnimation();
            this.f7021c.startAnimation(this.f7021c.a_renamed(1.0f, 0.0f));
            this.f7021c.a_renamed();
        }
        if (z_renamed) {
            f_renamed();
        }
    }

    public int a_renamed() {
        return this.i_renamed;
    }

    public void a_renamed(int i_renamed) {
        this.i_renamed = i_renamed;
    }

    public boolean b_renamed() {
        com.oplus.camera.ui.preview.AiTextHintView aiTextHintView = this.f7021c;
        return aiTextHintView != null && aiTextHintView.b_renamed();
    }

    public void b_renamed(int i_renamed) {
        this.f_renamed = i_renamed;
        com.oplus.camera.ui.preview.AiTextHintView aiTextHintView = this.f7021c;
        if (aiTextHintView == null || aiTextHintView.getVisibility() != 0) {
            return;
        }
        a_renamed(true);
        a_renamed(this.e_renamed, this.g_renamed, this.h_renamed, i_renamed);
    }

    public boolean c_renamed() {
        int i_renamed = this.g_renamed;
        return com.oplus.camera.R_renamed.string.camera_ai_scene_super_text_hint == i_renamed || com.oplus.camera.R_renamed.string.camera_ai_scene_ultra_wide_tip == i_renamed || com.oplus.camera.R_renamed.string.camera_ai_scene_portrait_mode_hint == i_renamed;
    }

    public void d_renamed() {
        this.f7019a = null;
    }
}

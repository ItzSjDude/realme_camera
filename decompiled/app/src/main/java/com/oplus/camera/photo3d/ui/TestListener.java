package com.oplus.camera.photo3d.ui;

/* compiled from: ThreeDPhotoUIControl.java */
/* loaded from: classes2.dex */
public class g_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.oplus.camera.ui.CameraUIInterface f5080b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.photo3d.ui.e_renamed f5081c;
    private final com.oplus.camera.capmode.a_renamed d_renamed;
    private final android.widget.RelativeLayout e_renamed;
    private com.oplus.camera.ui.RotateImageView f_renamed;
    private com.oplus.camera.photo3d.ui.g_renamed.a_renamed g_renamed;
    private com.oplus.camera.photo3d.ui.c_renamed h_renamed;
    private final android.app.Activity i_renamed;
    private boolean l_renamed;
    private int j_renamed = 0;
    private int k_renamed = 0;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.os.Handler f5079a = new com.oplus.camera.photo3d.ui.g_renamed.b_renamed(android.os.Looper.getMainLooper());

    /* compiled from: ThreeDPhotoUIControl.java */
    public interface a_renamed {
        void a_renamed(com.oplus.camera.photo3d.ui.d_renamed dVar);
    }

    private int a_renamed(boolean z_renamed) {
        return z_renamed ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c_renamed(int i_renamed) {
        return i_renamed > 0;
    }

    public g_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) throws android.content.res.Resources.NotFoundException {
        this.i_renamed = activity;
        this.d_renamed = aVar;
        this.f5080b = cameraUIInterface;
        this.e_renamed = (android.widget.RelativeLayout) this.f5080b.b_renamed();
        a_renamed(activity, aVar);
        i_renamed();
        a_renamed();
    }

    private com.oplus.camera.photo3d.ui.c_renamed i_renamed() {
        this.h_renamed = new com.oplus.camera.photo3d.ui.c_renamed(this.i_renamed, this.e_renamed);
        this.h_renamed.a_renamed(this.d_renamed.u_renamed());
        this.h_renamed.a_renamed(new com.oplus.camera.photo3d.ui.c_renamed.a_renamed() { // from class: com.oplus.camera.photo3d.ui.g_renamed.1
            @Override // com.oplus.camera.photo3d.ui.c_renamed.a_renamed
            public void a_renamed() {
                com.oplus.camera.photo3d.ui.g_renamed.this.f5081c.a_renamed(true);
                com.oplus.camera.photo3d.ui.g_renamed.this.f5080b.j_renamed(true, true);
                com.oplus.camera.photo3d.ui.g_renamed.this.d_renamed.a_renamed((android.animation.AnimatorListenerAdapter) null, true, true);
            }
        });
        return this.h_renamed;
    }

    private void a_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar) {
        this.f5081c = new com.oplus.camera.photo3d.ui.e_renamed(activity, aVar.t_renamed());
        this.f5081c.a_renamed(new com.oplus.camera.photo3d.ui.e_renamed.a_renamed() { // from class: com.oplus.camera.photo3d.ui.g_renamed.2
            @Override // com.oplus.camera.photo3d.ui.e_renamed.a_renamed
            public void a_renamed(com.oplus.camera.photo3d.ui.d_renamed dVar) {
                com.oplus.camera.e_renamed.b_renamed("ThreeDPhotoUIControl", "onMenuItemClick, item: " + dVar.a_renamed());
                if (com.oplus.camera.photo3d.ui.g_renamed.this.g_renamed != null) {
                    com.oplus.camera.photo3d.ui.g_renamed.this.g_renamed.a_renamed(dVar);
                }
            }
        });
    }

    public void a_renamed() throws android.content.res.Resources.NotFoundException {
        this.f_renamed = new com.oplus.camera.ui.RotateImageView(this.i_renamed);
        this.f_renamed.setId(com.oplus.camera.R_renamed.id_renamed.long_exposure_parameter_bottom_guide_entry);
        this.f_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.professional_guide_tip);
        int dimensionPixelSize = this.i_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_bottom_guide_entry_size);
        int settingMenuPanelHeight = com.oplus.camera.util.Util.getSettingMenuPanelHeight() + this.i_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_bottom_guide_entry_margin_top);
        int dimensionPixelSize2 = this.i_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_bottom_guide_entry_margin_end);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.addRule(10);
        layoutParams.addRule(21);
        layoutParams.setMargins(0, settingMenuPanelHeight, 0, 0);
        layoutParams.setMarginEnd(dimensionPixelSize2);
        this.f_renamed.setLayoutParams(layoutParams);
        this.f_renamed.setVisibility(0);
        this.f_renamed.a_renamed(this.d_renamed.u_renamed(), false);
        this.f_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.photo3d.ui.g_renamed.3
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.oplus.camera.photo3d.ui.g_renamed.this.f5080b == null || com.oplus.camera.photo3d.ui.g_renamed.this.d_renamed == null || com.oplus.camera.photo3d.ui.g_renamed.this.d_renamed.F_renamed()) {
                    return;
                }
                com.oplus.camera.photo3d.ui.g_renamed.this.f5080b.k_renamed(9);
            }
        });
        this.f_renamed.a_renamed(this.d_renamed.u_renamed(), false);
        this.f5080b.a_renamed((android.view.View) this.f_renamed, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_3D_PHOTO, 2, true);
    }

    public void a_renamed(int i_renamed) {
        this.f5079a.obtainMessage(107, i_renamed, 0).sendToTarget();
    }

    /* compiled from: ThreeDPhotoUIControl.java */
    private class b_renamed extends android.os.Handler {
        public b_renamed(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            switch (message.what) {
                case 100:
                    com.oplus.camera.photo3d.ui.g_renamed.this.j_renamed();
                    break;
                case 101:
                    com.oplus.camera.photo3d.ui.g_renamed.this.l_renamed();
                    break;
                case 102:
                    com.oplus.camera.photo3d.ui.g_renamed.this.m_renamed();
                    break;
                case 103:
                    com.oplus.camera.photo3d.ui.g_renamed.this.n_renamed();
                    break;
                case 104:
                    com.oplus.camera.photo3d.ui.g_renamed.this.h_renamed.a_renamed(com.oplus.camera.photo3d.ui.g_renamed.this.c_renamed(message.arg1), com.oplus.camera.photo3d.ui.g_renamed.this.c_renamed(message.arg2));
                    break;
                case 105:
                    com.oplus.camera.photo3d.ui.g_renamed.this.h_renamed.b_renamed(com.oplus.camera.photo3d.ui.g_renamed.this.c_renamed(message.arg1), com.oplus.camera.photo3d.ui.g_renamed.this.c_renamed(message.arg2));
                    break;
                case 106:
                    com.oplus.camera.photo3d.ui.g_renamed.this.f5081c.b_renamed(false);
                    break;
                case 107:
                    com.oplus.camera.photo3d.ui.g_renamed.this.h_renamed.a_renamed(message.arg1);
                    com.oplus.camera.photo3d.ui.g_renamed.this.f_renamed.a_renamed(message.arg1, true);
                    break;
                case 108:
                    com.oplus.camera.photo3d.ui.g_renamed gVar = com.oplus.camera.photo3d.ui.g_renamed.this;
                    gVar.d_renamed(gVar.c_renamed(message.arg1), com.oplus.camera.photo3d.ui.g_renamed.this.c_renamed(message.arg2));
                    break;
                case 110:
                    com.oplus.camera.photo3d.ui.g_renamed.this.o_renamed();
                    break;
            }
        }
    }

    public void b_renamed() {
        this.f5079a.sendEmptyMessage(100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j_renamed() {
        if (!this.l_renamed) {
            this.f5080b.a_renamed(com.oplus.camera.R_renamed.string.camera_3d_photo_capture_suggestion, -1, true, false, false);
            this.l_renamed = true;
        }
        k_renamed();
        this.f5080b.a_renamed(com.oplus.camera.R_renamed.string.camera_3d_photo_preview_hint, -1, false, false, true);
        this.h_renamed.a_renamed(false, false);
    }

    private void k_renamed() {
        android.content.SharedPreferences sharedPreferencesT = this.d_renamed.t_renamed();
        if (sharedPreferencesT.getBoolean("key_show_3d_guide", true)) {
            this.f5080b.k_renamed(9);
            sharedPreferencesT.edit().putBoolean("key_show_3d_guide", false).apply();
        }
    }

    public void b_renamed(int i_renamed) {
        this.j_renamed = i_renamed;
        this.f5079a.sendEmptyMessage(101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l_renamed() {
        com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
        bVar.a_renamed("button_color_inside_none");
        bVar.a_renamed(13);
        this.f5080b.h_renamed(this.j_renamed);
        this.f5080b.a_renamed(bVar);
        this.f5080b.a_renamed(false, false);
        this.f5080b.i_renamed(this.i_renamed.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.night_countdown_time_margin_top));
        this.f5080b.a_renamed(this.j_renamed, false);
        this.k_renamed = this.j_renamed;
        this.f5079a.removeMessages(110);
        this.f5079a.sendEmptyMessageDelayed(110, 1000L);
        this.f5080b.g_renamed(4);
        this.f5080b.f_renamed(4);
        this.f5080b.a_renamed(4, false);
        this.f5080b.j_renamed(true, true);
        this.d_renamed.a_renamed((android.animation.AnimatorListenerAdapter) null, true, true);
        this.f5080b.a_renamed(com.oplus.camera.R_renamed.string.camera_3d_photo_preview_hint);
        this.f5081c.b_renamed(false);
        this.h_renamed.b_renamed(true, true);
        this.f_renamed.setVisibility(8);
    }

    public void c_renamed() {
        this.f5079a.sendEmptyMessage(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_renamed() {
        if (this.k_renamed > 0) {
            this.f5080b.g_renamed(false);
            this.f5079a.removeMessages(110);
        }
        this.j_renamed = 0;
        this.k_renamed = 0;
        this.f5080b.a_renamed(new com.oplus.camera.ui.control.b_renamed(1, "button_color_inside_none", "button_shape_ring_none", 0));
        this.f5080b.d_renamed(true, true);
        this.f5080b.a_renamed(com.oplus.camera.R_renamed.string.camera_3d_photo_process_hint);
        this.f5080b.a_renamed(com.oplus.camera.R_renamed.string.camera_3d_photo_preview_hint, -1, false, false, true);
        this.f5080b.g_renamed(0);
        this.f5080b.f_renamed(0);
        this.f5080b.a_renamed(0, false);
        this.f5080b.l_renamed(true, false);
        this.d_renamed.a_renamed(true, false);
        this.h_renamed.a_renamed(false, false);
        this.f_renamed.setVisibility(0);
    }

    public void d_renamed() {
        this.f5079a.sendEmptyMessage(103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n_renamed() {
        this.f5081c.b_renamed(false);
        this.h_renamed.b_renamed(false, false);
        this.f5080b.e_renamed(9, true);
        this.f5079a.removeCallbacksAndMessages(null);
        this.k_renamed = 0;
        this.j_renamed = 0;
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        this.f5079a.obtainMessage(108, a_renamed(z_renamed), a_renamed(z2)).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(boolean z_renamed, boolean z2) {
        if (!z_renamed) {
            this.h_renamed.b_renamed(true, false);
            this.f_renamed.setVisibility(8);
            this.f5081c.b_renamed(false);
        } else {
            if (z2) {
                return;
            }
            this.h_renamed.a_renamed(false, false);
            this.f_renamed.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o_renamed() {
        this.k_renamed -= 1000;
        this.f5080b.a_renamed(this.k_renamed, false);
        if (this.k_renamed > 0) {
            this.f5079a.sendEmptyMessageDelayed(110, 1000L);
        } else {
            p_renamed();
        }
    }

    private void p_renamed() {
        if (this.j_renamed > 0) {
            com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
            bVar.a_renamed("button_color_inside_none");
            bVar.a_renamed(4);
            this.f5080b.a_renamed(bVar);
            this.f5080b.g_renamed(true);
        }
    }

    public boolean e_renamed() {
        return this.f5081c.a_renamed();
    }

    public boolean f_renamed() {
        return this.f_renamed.getVisibility() == 0;
    }

    public void g_renamed() {
        this.f5079a.sendEmptyMessage(106);
    }

    public boolean a_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.e_renamed.a_renamed("ThreeDPhotoUIControl", "onSingleTapUp");
        if (!e_renamed()) {
            return false;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        this.f5080b.p_renamed().getHitRect(rect);
        if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        g_renamed();
        this.h_renamed.a_renamed(true, true);
        this.f5080b.l_renamed(true, true);
        this.d_renamed.a_renamed(true, true);
        this.d_renamed.d_renamed(true);
        return true;
    }

    public void b_renamed(boolean z_renamed, boolean z2) {
        this.f5079a.obtainMessage(104, a_renamed(z_renamed), a_renamed(z2)).sendToTarget();
    }

    public void c_renamed(boolean z_renamed, boolean z2) {
        this.f5079a.obtainMessage(105, a_renamed(z_renamed), a_renamed(z2)).sendToTarget();
    }

    public void a_renamed(com.oplus.camera.photo3d.ui.g_renamed.a_renamed aVar) {
        this.g_renamed = aVar;
    }

    public void h_renamed() {
        d_renamed();
        this.g_renamed = null;
        com.oplus.camera.ui.RotateImageView rotateImageView = this.f_renamed;
        if (rotateImageView != null) {
            rotateImageView.setOnClickListener(null);
        }
        com.oplus.camera.photo3d.ui.c_renamed cVar = this.h_renamed;
        if (cVar != null) {
            cVar.a_renamed();
        }
        com.oplus.camera.photo3d.ui.e_renamed eVar = this.f5081c;
        if (eVar != null) {
            eVar.b_renamed();
        }
    }
}

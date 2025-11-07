package com.oplus.camera.s_renamed;

/* compiled from: StarryUIControl.java */
/* loaded from: classes2.dex */
public class e_renamed {
    private android.app.Activity d_renamed;
    private com.oplus.camera.ui.CameraUIInterface f_renamed;
    private com.oplus.camera.s_renamed.e_renamed.a_renamed h_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f5332a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private long f5333b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f5334c = false;
    private java.util.ArrayList g_renamed = null;
    private android.os.Handler e_renamed = new com.oplus.camera.s_renamed.e_renamed.b_renamed();

    /* compiled from: StarryUIControl.java */
    public interface a_renamed {
        void a_renamed();

        boolean b_renamed();
    }

    public e_renamed(android.app.Activity activity, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.s_renamed.e_renamed.a_renamed aVar) {
        this.h_renamed = null;
        this.d_renamed = activity;
        this.f_renamed = cameraUIInterface;
        this.h_renamed = aVar;
    }

    /* compiled from: StarryUIControl.java */
    private class b_renamed extends android.os.Handler {
        private b_renamed() {
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i_renamed = message.what;
            if (i_renamed == 1) {
                com.oplus.camera.s_renamed.e_renamed.this.e_renamed();
                return;
            }
            if (i_renamed == 2) {
                com.oplus.camera.s_renamed.e_renamed.this.f_renamed();
                return;
            }
            if (i_renamed != 3) {
                if (i_renamed != 4) {
                    return;
                }
                com.oplus.camera.s_renamed.e_renamed.this.b_renamed((com.oplus.camera.ui.control.b_renamed) message.obj, message.arg1 == 1);
            } else {
                com.oplus.camera.s_renamed.e_renamed.this.g_renamed();
                com.oplus.camera.s_renamed.e_renamed eVar = com.oplus.camera.s_renamed.e_renamed.this;
                eVar.b_renamed(eVar.f5332a);
                com.oplus.camera.s_renamed.e_renamed.this.h_renamed();
            }
        }
    }

    public void a_renamed(int i_renamed) {
        if (i_renamed == 1) {
            this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_starry_mode_fixed_tips_oplus_r, -1, false, false, true);
        } else {
            if (i_renamed != 2) {
                return;
            }
            this.f_renamed.a_renamed(true, true, false);
            this.f_renamed.a_renamed(d_renamed(), com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        }
    }

    private java.util.List<java.lang.Integer> d_renamed() {
        java.util.ArrayList arrayList = this.g_renamed;
        if (arrayList != null) {
            return arrayList;
        }
        this.g_renamed = new java.util.ArrayList();
        this.g_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_scene_night_tips));
        this.g_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_scene_night_light_collect_tips_oplus_r));
        this.g_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_scene_night_image_optimizing_tips_oplus_r));
        return this.g_renamed;
    }

    public void a_renamed(long j_renamed) {
        this.f5334c = false;
        this.f5332a = j_renamed;
        this.e_renamed.removeMessages(1);
        this.e_renamed.sendEmptyMessage(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(long j_renamed) {
        com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
        bVar.a_renamed("button_color_inside_none");
        bVar.a_renamed(7);
        this.f_renamed.h_renamed((int) j_renamed);
        this.f_renamed.a_renamed(bVar);
        this.f_renamed.a_renamed(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e_renamed() {
        this.f5333b -= 1000;
        this.f_renamed.a_renamed(this.f5333b, false);
        if (this.f5333b > 0) {
            this.e_renamed.sendEmptyMessageDelayed(1, 1000L);
        } else {
            this.e_renamed.sendEmptyMessage(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StarryUIControl", "doOnCountDownEnd");
        if (!this.f5334c) {
            com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
            bVar.a_renamed("button_color_inside_none");
            bVar.a_renamed(4);
            this.f_renamed.a_renamed(bVar);
            this.f_renamed.g_renamed(true);
            return;
        }
        this.h_renamed.a_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g_renamed() {
        this.f_renamed.d_renamed(4);
        this.f_renamed.g_renamed(4);
        this.f_renamed.b_renamed(4, true);
        this.f_renamed.f_renamed(4);
        this.f_renamed.a_renamed(4, false);
        if (this.h_renamed.b_renamed()) {
            return;
        }
        this.f_renamed.y_renamed(false);
    }

    public void a_renamed() {
        this.e_renamed.removeCallbacksAndMessages(null);
        this.f_renamed.g_renamed(true);
        this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_starry_mode_fixed_tips_oplus_r);
    }

    public void a_renamed(com.oplus.camera.ui.control.b_renamed bVar, boolean z_renamed) {
        this.f5332a = 0L;
        this.e_renamed.removeMessages(1);
        android.os.Message messageObtainMessage = this.e_renamed.obtainMessage(4);
        messageObtainMessage.arg1 = z_renamed ? 1 : 0;
        messageObtainMessage.obj = bVar;
        this.e_renamed.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(com.oplus.camera.ui.control.b_renamed bVar, boolean z_renamed) {
        this.f_renamed.n_renamed();
        this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_starry_mode_fixed_tips_oplus_r, -1, false, false, true);
        this.f_renamed.d_renamed(true, true);
        this.f_renamed.a_renamed(bVar, false);
        this.f_renamed.g_renamed(true);
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_STAR_VIDEO)) {
            this.f_renamed.d_renamed(0);
        }
        this.f_renamed.b_renamed(0, true);
        this.f_renamed.g_renamed(0);
        this.f_renamed.f_renamed(0);
        if (z_renamed) {
            this.f_renamed.as_renamed();
        }
        if (this.h_renamed.b_renamed()) {
            this.f_renamed.a_renamed(0, true);
        } else {
            this.f_renamed.y_renamed(true);
        }
    }

    public void b_renamed() {
        this.f5334c = true;
    }

    public void c_renamed() {
        this.d_renamed = null;
        this.f_renamed = null;
        this.e_renamed = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h_renamed() {
        this.f_renamed.i_renamed(this.d_renamed.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.night_countdown_time_margin_top));
        this.f_renamed.a_renamed(this.f5332a, false);
        this.f5333b = this.f5332a;
        this.e_renamed.sendEmptyMessageDelayed(1, 1000L);
    }
}

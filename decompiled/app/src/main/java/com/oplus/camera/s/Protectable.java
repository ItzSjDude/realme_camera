package com.oplus.camera.s_renamed;

/* compiled from: StarVideoUI.java */
/* loaded from: classes2.dex */
class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f5326a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.SharedPreferences f5327b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.CameraUIInterface f5328c;
    private int d_renamed = 0;
    private com.oplus.camera.ui.widget.b_renamed e_renamed = null;

    public c_renamed(android.app.Activity activity, android.content.SharedPreferences sharedPreferences, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        this.f5326a = null;
        this.f5327b = null;
        this.f5328c = null;
        this.f5326a = activity;
        this.f5327b = sharedPreferences;
        this.f5328c = cameraUIInterface;
    }

    public void a_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
        com.oplus.camera.ui.widget.b_renamed bVar = this.e_renamed;
        if (bVar != null) {
            bVar.a_renamed(i_renamed, true);
        }
    }

    public void a_renamed() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.f5328c;
        if (cameraUIInterface != null) {
            cameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_star_video_mode_fixed_tips, -1, false, false, true);
            b_renamed(false);
        }
    }

    public void a_renamed(int i_renamed, long j_renamed) {
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.f5328c;
        if (cameraUIInterface != null) {
            cameraUIInterface.a_renamed(j_renamed, i_renamed * 1000, true, false, 0L);
            com.oplus.camera.e_renamed.c_renamed("StarVideoUI", "updateRecordingTime, recordingTime: " + j_renamed + ", videoTimeSec: " + i_renamed);
        }
    }

    public void b_renamed() {
        android.app.Activity activity = this.f5326a;
        if (activity == null || this.f5328c == null) {
            return;
        }
        activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.s_renamed.-$$Lambda$c_renamed$M_renamed-5x8FNBauq5dDRGjExSuKf2Aws
            @Override // java.lang.Runnable
            public final void run() throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.f_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f_renamed() throws android.content.res.Resources.NotFoundException {
        c_renamed(false);
        this.f5328c.m_renamed(true);
        this.f5328c.g_renamed(4);
        this.f5328c.b_renamed(4, true);
        this.f5328c.a_renamed(4, false);
        this.f5328c.a_renamed(new com.oplus.camera.ui.control.b_renamed(5, "button_color_inside_red", "button_shape_dial_rotate", 1));
        this.f5328c.a_renamed(true, false);
        a_renamed(0, 0L);
        this.f5328c.a_renamed(java.lang.Float.valueOf(0.1f), this.f5326a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.record_time_margin_top), true, true);
        this.f5328c.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_star_video_mode_fixed_tips);
        this.f5328c.a_renamed(d_renamed(), com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    private java.util.List<java.lang.Integer> d_renamed() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_scene_night_tips));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_scene_night_light_collect_tips_oplus_r));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_star_video_keep_battery_enough));
        return arrayList;
    }

    public void a_renamed(final boolean z_renamed, final com.oplus.camera.ui.control.b_renamed bVar, final boolean z2, final boolean z3) {
        com.oplus.camera.e_renamed.c_renamed("StarVideoUI", "hideRecordingUI");
        android.app.Activity activity = this.f5326a;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.s_renamed.-$$Lambda$c_renamed$MCjS81XJPLL4n_q-c5KWcxvQPr8
                @Override // java.lang.Runnable
                public final void run() throws android.content.res.Resources.NotFoundException {
                    this.f_renamed$0.b_renamed(z_renamed, bVar, z3, z2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(boolean z_renamed, com.oplus.camera.ui.control.b_renamed bVar, boolean z2, boolean z3) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.f5328c;
        if (cameraUIInterface != null) {
            cameraUIInterface.f_renamed(z_renamed);
            this.f5328c.n_renamed();
            this.f5328c.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_star_video_mode_fixed_tips, -1, false, false, true);
            this.f5328c.a_renamed(bVar, false);
            this.f5328c.b_renamed(0, true);
            if (z2) {
                this.f5328c.a_renamed(0, true);
            } else {
                this.f5328c.y_renamed(true);
            }
            this.f5328c.H_renamed();
            b_renamed(false);
            if (z3) {
                this.f5328c.as_renamed();
            }
        }
    }

    public void a_renamed(final boolean z_renamed) {
        android.app.Activity activity = this.f5326a;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.s_renamed.-$$Lambda$c_renamed$ZiZt8qBKlXDRwGvV3Pe__IIp_OU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.d_renamed(z_renamed);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed(boolean z_renamed) {
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.f5328c;
        if (cameraUIInterface != null) {
            cameraUIInterface.f_renamed(z_renamed);
        }
    }

    public void b_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (this.e_renamed == null) {
            e_renamed();
        }
        this.e_renamed.a_renamed(this.f5327b.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_STAR_VIDEO_RECORD_TOTAL_TIME, 5400000));
        this.e_renamed.a_renamed(this.d_renamed, false);
        android.widget.RelativeLayout relativeLayoutP = this.f5328c.p_renamed();
        int dimensionPixelSize = this.f5326a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.star_video_time_seekbar_width);
        int dimensionPixelSize2 = this.f5326a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.star_video_time_seekbar_height);
        int height = relativeLayoutP.getHeight() - (this.f5326a.findViewById(com.oplus.camera.R_renamed.id_renamed.control_panel_layout).getTop() - relativeLayoutP.getTop());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, height);
        this.e_renamed.setLayoutParams(layoutParams);
        if (relativeLayoutP.indexOfChild(this.e_renamed) < 0) {
            relativeLayoutP.addView(this.e_renamed);
        }
        if (z_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.e_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
        } else {
            this.e_renamed.setVisibility(0);
        }
    }

    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.ui.widget.b_renamed bVar;
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.f5328c;
        if (cameraUIInterface == null || cameraUIInterface.b_renamed() == null || (bVar = this.e_renamed) == null) {
            return;
        }
        if (z_renamed) {
            com.oplus.camera.util.Util.a_renamed(bVar, 8, (android.view.animation.Animation.AnimationListener) null, 300L);
        } else {
            bVar.setVisibility(8);
        }
        this.f5328c.b_renamed().removeView(this.e_renamed);
    }

    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    private void e_renamed() {
        this.e_renamed = new com.oplus.camera.ui.widget.b_renamed(this.f5326a);
        this.e_renamed.setModeFrameChangeListener(new com.oplus.camera.ui.widget.b_renamed.SlowVideoModeSeekBar_2() { // from class: com.oplus.camera.s_renamed.-$$Lambda$c_renamed$n7w2dmeCK4Zb0rbtS0w2EXg58L4
            @Override // com.oplus.camera.ui.widget.b_renamed.SlowVideoModeSeekBar_2
            public final void onSlowVideoFrameChange(int i_renamed) {
                this.f_renamed$0.b_renamed(i_renamed);
            }
        });
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.oplus.camera.ui.widget.b_renamed.a_renamed(3600000, this.f5326a.getString(com.oplus.camera.R_renamed.string.camera_star_video_record_time_60m)));
        arrayList.add(new com.oplus.camera.ui.widget.b_renamed.a_renamed(5400000, this.f5326a.getString(com.oplus.camera.R_renamed.string.camera_star_video_record_time_90m)));
        arrayList.add(new com.oplus.camera.ui.widget.b_renamed.a_renamed(7200000, this.f5326a.getString(com.oplus.camera.R_renamed.string.camera_star_video_record_time_120m)));
        arrayList.add(new com.oplus.camera.ui.widget.b_renamed.a_renamed(14400000, this.f5326a.getString(com.oplus.camera.R_renamed.string.camera_star_video_record_time_240m)));
        this.e_renamed.setFrameList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(int i_renamed) {
        android.content.SharedPreferences sharedPreferences = this.f5327b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_STAR_VIDEO_RECORD_TOTAL_TIME, i_renamed).apply();
        }
    }

    public void c_renamed() {
        this.f5326a = null;
        this.f5327b = null;
        this.f5328c = null;
    }
}

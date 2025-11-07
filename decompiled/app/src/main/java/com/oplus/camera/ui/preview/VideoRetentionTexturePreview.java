package com.oplus.camera.ui.preview;

/* compiled from: VideoRecordingTimeUI.java */
/* loaded from: classes2.dex */
public class ae_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f6997a;
    private int k_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.widget.RelativeLayout f6998b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6999c = 0;
    private boolean d_renamed = false;
    private boolean e_renamed = false;
    private int f_renamed = 0;
    private com.oplus.camera.ui.preview.CameraTimeView g_renamed = null;
    private com.oplus.camera.ui.preview.CameraTimeView h_renamed = null;
    private long i_renamed = 0;
    private long j_renamed = 0;
    private int l_renamed = 0;

    public ae_renamed(android.app.Activity activity) {
        this.f6997a = null;
        this.k_renamed = 0;
        this.f6997a = activity;
        this.k_renamed = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_time_margin_top);
    }

    private void e_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        this.f6998b = (android.widget.RelativeLayout) this.f6997a.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        if (this.f6998b == null) {
            return;
        }
        com.oplus.camera.ui.preview.PreviewFrameLayout previewFrameLayout = (com.oplus.camera.ui.preview.PreviewFrameLayout) this.f6997a.findViewById(com.oplus.camera.R_renamed.id_renamed.frame_layout);
        int top = previewFrameLayout.getTop();
        int height = previewFrameLayout.getHeight();
        android.view.LayoutInflater layoutInflater = this.f6997a.getLayoutInflater();
        if (this.g_renamed == null) {
            this.g_renamed = (com.oplus.camera.ui.preview.CameraTimeView) layoutInflater.inflate(com.oplus.camera.R_renamed.layout.record_time, (android.view.ViewGroup) null);
            this.f6998b.addView(this.g_renamed);
            this.g_renamed.a_renamed(false, this.f6999c, top, height, f_renamed(z_renamed));
        }
        this.g_renamed.setScreenLayoutMode(this.l_renamed);
        if (this.d_renamed && this.h_renamed == null) {
            this.h_renamed = (com.oplus.camera.ui.preview.CameraTimeView) layoutInflater.inflate(com.oplus.camera.R_renamed.layout.record_time, (android.view.ViewGroup) null);
            this.f6998b.addView(this.h_renamed);
            this.g_renamed.setScreenLayoutMode(this.l_renamed);
            this.g_renamed.measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.getScreenWidth());
            this.h_renamed.a_renamed(this.d_renamed, this.f6999c, top, height, (this.g_renamed.getMeasuredWidth() - this.g_renamed.getBlinkRecordIconWidth()) / 2);
            this.h_renamed.measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.getScreenWidth());
            this.g_renamed.a_renamed((-this.h_renamed.getMeasuredWidth()) / 2);
            if (180 == this.f_renamed) {
                this.g_renamed.a_renamed(this.h_renamed.getMeasuredWidth() / 2);
                this.h_renamed.a_renamed((this.g_renamed.getBlinkRecordIconWidth() - this.g_renamed.getMeasuredWidth()) / 2);
            } else {
                this.g_renamed.a_renamed((-this.h_renamed.getMeasuredWidth()) / 2);
                this.h_renamed.a_renamed((this.g_renamed.getMeasuredWidth() - this.g_renamed.getBlinkRecordIconWidth()) / 2);
            }
            com.oplus.camera.ui.preview.CameraTimeView.a_renamed aVar = new com.oplus.camera.ui.preview.CameraTimeView.a_renamed() { // from class: com.oplus.camera.ui.preview.ae_renamed.1
                @Override // com.oplus.camera.ui.preview.CameraTimeView.a_renamed
                public void a_renamed(int i_renamed) {
                    if (com.oplus.camera.ui.preview.ae_renamed.this.h_renamed != null) {
                        com.oplus.camera.ui.preview.ae_renamed.this.h_renamed.a_renamed((i_renamed - com.oplus.camera.ui.preview.ae_renamed.this.g_renamed.getBlinkRecordIconWidth()) / 2);
                    }
                }
            };
            com.oplus.camera.ui.preview.CameraTimeView.a_renamed aVar2 = new com.oplus.camera.ui.preview.CameraTimeView.a_renamed() { // from class: com.oplus.camera.ui.preview.ae_renamed.2
                @Override // com.oplus.camera.ui.preview.CameraTimeView.a_renamed
                public void a_renamed(int i_renamed) {
                    if (com.oplus.camera.ui.preview.ae_renamed.this.g_renamed != null) {
                        com.oplus.camera.ui.preview.ae_renamed.this.g_renamed.a_renamed((-i_renamed) / 2);
                    }
                }
            };
            this.g_renamed.setCameraTimeListener(aVar);
            this.h_renamed.setCameraTimeListener(aVar2);
        }
    }

    public boolean a_renamed() {
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView = this.g_renamed;
        if (cameraTimeView != null) {
            return cameraTimeView.getVisibility() == 0;
        }
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView2 = this.h_renamed;
        return cameraTimeView2 != null && cameraTimeView2.getVisibility() == 0;
    }

    private void l_renamed() {
        this.f6998b = (android.widget.RelativeLayout) this.f6997a.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        if (this.f6998b == null) {
            return;
        }
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView = this.g_renamed;
        if (cameraTimeView != null) {
            cameraTimeView.c_renamed();
            this.f6998b.removeView(this.g_renamed);
            this.g_renamed = null;
        }
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView2 = this.h_renamed;
        if (cameraTimeView2 != null) {
            cameraTimeView2.c_renamed();
            this.f6998b.removeView(this.h_renamed);
            this.h_renamed = null;
        }
    }

    public void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        a_renamed(i_renamed, i2, z_renamed, z2, true);
    }

    public void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3) throws android.content.res.Resources.NotFoundException {
        a_renamed(i_renamed, i2, this.f_renamed, z_renamed, z2, z3);
    }

    public void a_renamed(int i_renamed, int i2, int i3, boolean z_renamed, boolean z2, boolean z3) throws android.content.res.Resources.NotFoundException {
        this.f6999c = i_renamed;
        this.d_renamed = z_renamed;
        this.f_renamed = i3;
        l_renamed();
        e_renamed(z2);
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView = this.h_renamed;
        if (cameraTimeView != null) {
            cameraTimeView.a_renamed(i_renamed, i2, i3, z2, z3);
        }
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView2 = this.g_renamed;
        if (cameraTimeView2 != null) {
            cameraTimeView2.a_renamed(i_renamed, i2, i3, z2, z3);
        }
        com.oplus.camera.e_renamed.f_renamed("VideoRecordingTimeUI", "CameraTest Video Shutter Timing Start");
    }

    public void b_renamed() {
        this.i_renamed = 0L;
        this.j_renamed = 0L;
    }

    public void a_renamed(boolean z_renamed) {
        a_renamed(z_renamed, false);
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView = this.h_renamed;
        if (cameraTimeView != null) {
            cameraTimeView.a_renamed(z_renamed, z2);
        }
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView2 = this.g_renamed;
        if (cameraTimeView2 != null) {
            cameraTimeView2.a_renamed(z_renamed, z2);
        }
    }

    public void b_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        if (this.f_renamed == i2) {
            return;
        }
        this.f_renamed = i2;
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView = this.g_renamed;
        if (cameraTimeView != null && cameraTimeView.getVisibility() == 0 && !this.g_renamed.d_renamed()) {
            a_renamed(this.f6999c, i_renamed, this.d_renamed, z_renamed, z2);
        }
        a_renamed(this.i_renamed, this.j_renamed, false);
    }

    public int c_renamed() {
        return this.f_renamed;
    }

    public void d_renamed() {
        com.oplus.camera.e_renamed.a_renamed("VideoRecordingTimeUI", "onPause");
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView = this.h_renamed;
        if (cameraTimeView != null) {
            cameraTimeView.clearAnimation();
            this.h_renamed.setVisibility(8);
        }
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView2 = this.g_renamed;
        if (cameraTimeView2 != null) {
            cameraTimeView2.clearAnimation();
            this.g_renamed.setVisibility(8);
        }
        l_renamed();
    }

    public int e_renamed() {
        return this.f6999c;
    }

    public boolean f_renamed() {
        return this.d_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView = this.g_renamed;
        if (cameraTimeView != null) {
            cameraTimeView.a_renamed(z_renamed);
        }
    }

    public void g_renamed() {
        a_renamed(this.i_renamed, this.j_renamed, false);
    }

    public void a_renamed(long j_renamed, long j2, boolean z_renamed, boolean z2, long j3) {
        this.i_renamed = j_renamed;
        this.j_renamed = j2;
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView = this.g_renamed;
        if (cameraTimeView != null) {
            if (!z2) {
                cameraTimeView.a_renamed(j_renamed, z_renamed);
            } else {
                long j4 = j3 - j_renamed;
                if (300 >= j4) {
                    j4 = 0;
                }
                cameraTimeView.a_renamed(j4, z_renamed, true);
            }
        }
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView2 = this.h_renamed;
        if (cameraTimeView2 != null) {
            cameraTimeView2.a_renamed(j2, false);
        }
    }

    public void a_renamed(long j_renamed, long j2, boolean z_renamed) {
        a_renamed(j_renamed, j2, z_renamed, false, 0L);
    }

    public boolean h_renamed() {
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView = this.g_renamed;
        return cameraTimeView != null && cameraTimeView.e_renamed();
    }

    public void i_renamed() {
        this.f6997a = null;
    }

    public int j_renamed() {
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView = this.g_renamed;
        if (cameraTimeView == null) {
            return 0;
        }
        cameraTimeView.measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.getScreenWidth());
        return this.g_renamed.getMeasuredWidth();
    }

    public boolean k_renamed() {
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView = this.g_renamed;
        return cameraTimeView != null && cameraTimeView.getVisibility() == 0;
    }

    public void c_renamed(boolean z_renamed) {
        this.g_renamed.a_renamed(f_renamed(z_renamed));
    }

    public void d_renamed(boolean z_renamed) {
        this.e_renamed = z_renamed;
    }

    private int f_renamed(boolean z_renamed) {
        if (this.f6997a == null) {
            return 0;
        }
        int iJ = (j_renamed() / 2) + this.k_renamed;
        if (this.e_renamed && z_renamed) {
            return iJ;
        }
        com.oplus.camera.ui.preview.CameraTimeView cameraTimeView = this.h_renamed;
        if (cameraTimeView == null || !this.d_renamed) {
            return 0;
        }
        if (180 == this.f_renamed) {
            return cameraTimeView.getMeasuredWidth() / 2;
        }
        return (-cameraTimeView.getMeasuredWidth()) / 2;
    }

    public void a_renamed(com.oplus.camera.screen.b_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        this.l_renamed = aVar.j_renamed();
        a_renamed(aVar.a_renamed(this.f6997a, this.f6999c), 0, this.d_renamed, false, false);
    }
}

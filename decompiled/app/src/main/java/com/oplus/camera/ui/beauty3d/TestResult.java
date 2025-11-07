package com.oplus.camera.ui.beauty3d;

/* compiled from: FrameAnimation.java */
/* loaded from: classes2.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.widget.ImageView f5951a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int[] f5952b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f5953c;
    private int d_renamed;
    private boolean f_renamed;
    private boolean e_renamed = true;
    private com.oplus.camera.ui.beauty3d.h_renamed.a_renamed g_renamed = new com.oplus.camera.ui.beauty3d.h_renamed.a_renamed();

    public h_renamed(android.widget.ImageView imageView, int[] iArr, int i_renamed, boolean z_renamed) {
        this.f5951a = null;
        this.f5952b = null;
        this.f5953c = 0;
        this.d_renamed = 0;
        this.f_renamed = true;
        this.f5951a = imageView;
        this.f5952b = iArr;
        this.f5953c = i_renamed;
        this.d_renamed = iArr.length - 1;
        this.f_renamed = z_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, boolean z_renamed) {
        android.widget.ImageView imageView = this.f5951a;
        if (imageView == null) {
            return;
        }
        if (i_renamed == 0 && z_renamed) {
            imageView.setBackgroundResource(this.f5952b[0]);
            i_renamed++;
        }
        com.oplus.camera.ui.beauty3d.h_renamed.a_renamed aVar = this.g_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed);
            this.f5951a.postDelayed(this.g_renamed, this.f5953c);
        }
    }

    public void a_renamed() {
        this.e_renamed = true;
        android.widget.ImageView imageView = this.f5951a;
        if (imageView != null) {
            imageView.removeCallbacks(this.g_renamed);
        }
    }

    public boolean b_renamed() {
        return this.e_renamed;
    }

    public boolean c_renamed() {
        return !this.e_renamed;
    }

    public void d_renamed() {
        if (this.e_renamed) {
            this.e_renamed = false;
            a_renamed(0, true);
        }
    }

    /* compiled from: FrameAnimation.java */
    private class a_renamed implements java.lang.Runnable {

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f5955b;

        private a_renamed() {
            this.f5955b = 0;
        }

        public void a_renamed(int i_renamed) {
            this.f5955b = i_renamed;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.oplus.camera.ui.beauty3d.h_renamed.this.e_renamed) {
                com.oplus.camera.ui.beauty3d.h_renamed.this.f5951a.removeCallbacks(com.oplus.camera.ui.beauty3d.h_renamed.this.g_renamed);
                return;
            }
            com.oplus.camera.ui.beauty3d.h_renamed.this.f5951a.setBackgroundResource(com.oplus.camera.ui.beauty3d.h_renamed.this.f5952b[this.f5955b]);
            if (this.f5955b == com.oplus.camera.ui.beauty3d.h_renamed.this.d_renamed) {
                if (com.oplus.camera.ui.beauty3d.h_renamed.this.f_renamed) {
                    com.oplus.camera.ui.beauty3d.h_renamed.this.a_renamed(0, false);
                    return;
                }
                return;
            }
            com.oplus.camera.ui.beauty3d.h_renamed.this.a_renamed(this.f5955b + 1, false);
        }
    }
}

package com.oplus.camera;

/* compiled from: PreviewImageProcess.java */
/* loaded from: classes2.dex */
public class z_renamed {
    private com.oplus.camera.z_renamed.b_renamed e_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f7433a = false;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f7434b = false;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.util.ArrayList<com.oplus.camera.z_renamed.a_renamed> f7435c = new java.util.ArrayList<>();
    private com.oplus.camera.ui.preview.g_renamed.a_renamed d_renamed = null;
    private com.oplus.camera.z_renamed.a_renamed f_renamed = null;

    /* compiled from: PreviewImageProcess.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public android.util.Size f7436a = null;

        /* renamed from: b_renamed, reason: collision with root package name */
        public android.util.Size f7437b = null;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f7438c = 0;
        public int d_renamed = 0;
        public boolean e_renamed = false;
        public int f_renamed = 0;
    }

    /* compiled from: PreviewImageProcess.java */
    public interface b_renamed {
        boolean Y_renamed();

        void a_renamed(android.util.Size size, android.util.Size size2, com.oplus.camera.ui.preview.g_renamed.a_renamed aVar, int i_renamed, int i2, int i3, boolean z_renamed);

        void aa_renamed();
    }

    public z_renamed(com.oplus.camera.z_renamed.b_renamed bVar) {
        this.e_renamed = null;
        this.e_renamed = bVar;
    }

    public void a_renamed() {
        a_renamed(true);
    }

    public boolean a_renamed(android.util.Size size, android.util.Size size2, boolean z_renamed, int i_renamed) {
        synchronized (this) {
            com.oplus.camera.e_renamed.a_renamed("PreviewImageProcess", "setCaptureOnePreviewData, mbShowBlurImage: " + this.f7433a + ", mbDataGetting: " + this.f7434b + ", currSize: " + size.getWidth() + " x_renamed " + size.getHeight() + ", newSize: " + size2.getWidth() + " x_renamed " + size2.getHeight() + ", modeTypeChange: " + z_renamed);
            if (!this.f7434b && !this.f7433a) {
                this.f7434b = true;
                if (!this.e_renamed.Y_renamed()) {
                    synchronized (this) {
                        if (this.f7435c.isEmpty()) {
                            com.oplus.camera.z_renamed.a_renamed aVar = new com.oplus.camera.z_renamed.a_renamed();
                            aVar.f7436a = size;
                            aVar.f7437b = size2;
                            aVar.f7438c = size.getWidth();
                            aVar.d_renamed = size.getHeight();
                            aVar.e_renamed = false;
                            aVar.f_renamed = i_renamed;
                            this.f7435c.add(aVar);
                            this.f7434b = false;
                        } else {
                            com.oplus.camera.e_renamed.f_renamed("PreviewImageProcess", "getPreviewFrame, onPreviewCaptured, setData fail!");
                        }
                    }
                }
                return true;
            }
            return false;
        }
    }

    public synchronized void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("PreviewImageProcess", "resetData allClean: " + z_renamed);
        if (!z_renamed) {
            this.f7434b = false;
            return;
        }
        this.f7433a = false;
        this.f7434b = false;
        this.f7435c.clear();
    }

    public boolean a_renamed(com.oplus.camera.ui.preview.g_renamed.a_renamed aVar, int i_renamed, int i2, boolean z_renamed) {
        synchronized (this) {
            com.oplus.camera.e_renamed.a_renamed("PreviewImageProcess", "showBlurBitmap, mBitmap: mCurrentPreviewData: " + this.f_renamed + ", mbDataGetting: " + this.f7434b + ", mbShowBlurImage: " + this.f7433a);
            if (this.f7433a) {
                com.oplus.camera.e_renamed.a_renamed("PreviewImageProcess", "showBlurBitmap, the blur image has been shown, mbShowBlurImage: " + this.f7433a);
                return true;
            }
            this.d_renamed = aVar;
            this.f7433a = true;
            if (!this.f7435c.isEmpty()) {
                a_renamed(i_renamed, i2, z_renamed);
            }
            return true;
        }
    }

    public synchronized boolean b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("PreviewImageProcess", "isShowBlurBitmap: " + this.f7433a);
        return this.f7433a;
    }

    public boolean c_renamed() {
        boolean z_renamed;
        synchronized (this) {
            z_renamed = !this.f7433a;
        }
        return z_renamed;
    }

    public synchronized void b_renamed(boolean z_renamed) {
        this.f7433a = false;
        com.oplus.camera.e_renamed.a_renamed("PreviewImageProcess", "resetBlurAnimation, mbShowBlurImage: " + this.f7433a);
        if (z_renamed) {
            this.f7435c.clear();
            this.f_renamed = null;
        }
    }

    public synchronized void a_renamed(android.util.Size size, android.util.Size size2) {
        if (this.f_renamed != null) {
            this.f_renamed.f7436a = size;
            this.f_renamed.f7437b = size2;
        }
    }

    private void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("PreviewImageProcess", "handleImage");
        boolean z2 = false;
        if (this.e_renamed.Y_renamed() || !this.f7433a || (this.f7435c.isEmpty() && this.f_renamed == null)) {
            z2 = true;
        } else {
            if (!this.f7435c.isEmpty()) {
                this.f_renamed = this.f7435c.get(0);
            }
            com.oplus.camera.e_renamed.a_renamed("PreviewImageProcess", "handleImage, size: " + this.f_renamed.f7436a.getWidth() + " x_renamed " + this.f_renamed.f7436a.getHeight() + " => " + this.f_renamed.f7437b.getWidth() + " x_renamed " + this.f_renamed.f7437b.getHeight());
            this.e_renamed.a_renamed(this.f_renamed.f7436a, this.f_renamed.f7437b, this.d_renamed, this.f_renamed.f_renamed, i_renamed, i2, z_renamed);
        }
        a_renamed(true);
        if (z2) {
            this.e_renamed.aa_renamed();
            com.oplus.camera.ui.preview.g_renamed.a_renamed aVar = this.d_renamed;
            if (aVar != null) {
                aVar.a_renamed();
            }
        }
    }
}

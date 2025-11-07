package com.oplus.camera.watch;

/* compiled from: WatchAgentHolder.java */
/* loaded from: classes2.dex */
class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.util.Size f7412a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.util.Size f7413b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f7414c = 0;
    private int d_renamed = 0;
    private int e_renamed = 0;
    private int f_renamed = 0;
    private int g_renamed = 0;
    private int h_renamed = 0;
    private boolean i_renamed = false;

    c_renamed() {
    }

    public android.util.Size a_renamed() {
        return this.f7413b;
    }

    public void a_renamed(android.util.Size size) {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentHolder", "setCameraPreviewSize, cameraPreviewSize: " + size);
        this.f7413b = size;
    }

    public void b_renamed(android.util.Size size) {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentHolder", "setWatchPreviewSize, watchPreviewSize: " + size);
        this.f7412a = size;
    }

    public android.util.Size b_renamed() {
        return this.f7412a;
    }

    public android.util.Size c_renamed() {
        int height;
        int height2;
        if (this.f7412a == null || this.f7413b == null) {
            com.oplus.camera.e_renamed.a_renamed("WatchAgentHolder", "createCodecSize, mWatchSize or mCameraSize is_renamed null");
            return null;
        }
        float height3 = r0.getHeight() / this.f7412a.getWidth();
        float width = this.f7413b.getWidth() / this.f7413b.getHeight();
        if (height3 > width) {
            height = this.f7412a.getWidth();
            height2 = (int) ((this.f7413b.getHeight() / this.f7413b.getWidth()) * this.f7412a.getWidth());
        } else {
            height = (int) ((this.f7413b.getHeight() / this.f7413b.getWidth()) * this.f7412a.getHeight());
            height2 = this.f7412a.getHeight();
        }
        if (height % 2 != 0) {
            height++;
        }
        if (height2 % 2 != 0) {
            height2++;
        }
        com.oplus.camera.e_renamed.a_renamed("WatchAgentHolder", "createCodecSize, watchRatio: " + height3 + ", cameraRatio: " + width + ", codecWidth: " + height + ", codecHeight: " + height2);
        return new android.util.Size(height, height2);
    }

    public int d_renamed() {
        return this.f7414c;
    }

    public void a_renamed(int i_renamed) {
        this.f7414c = i_renamed;
    }

    public int e_renamed() {
        return this.d_renamed;
    }

    public void b_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
    }

    public int f_renamed() {
        return this.e_renamed;
    }

    public void c_renamed(int i_renamed) {
        this.e_renamed = i_renamed;
    }

    public int g_renamed() {
        return this.f_renamed;
    }

    public void d_renamed(int i_renamed) {
        this.f_renamed = i_renamed;
    }

    public int h_renamed() {
        return this.g_renamed;
    }

    public void e_renamed(int i_renamed) {
        this.g_renamed = i_renamed;
    }

    public int i_renamed() {
        return this.h_renamed;
    }

    public void f_renamed(int i_renamed) {
        this.h_renamed = i_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.i_renamed = z_renamed;
    }

    public boolean j_renamed() {
        return this.i_renamed;
    }
}

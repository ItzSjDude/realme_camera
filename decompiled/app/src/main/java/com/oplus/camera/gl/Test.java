package com.oplus.camera.gl_renamed;

/* compiled from: BitmapTexture.java */
/* loaded from: classes2.dex */
public class d_renamed extends com.oplus.camera.gl_renamed.x_renamed {
    protected android.graphics.Bitmap h_renamed;
    private final java.lang.Object j_renamed;
    private int k_renamed;

    @Override // com.oplus.camera.gl_renamed.x_renamed
    protected void a_renamed(android.graphics.Bitmap bitmap) {
    }

    public d_renamed(android.graphics.Bitmap bitmap) {
        this(bitmap, false);
    }

    public d_renamed(android.graphics.Bitmap bitmap, boolean z_renamed) {
        super(z_renamed);
        this.j_renamed = new java.lang.Object();
        this.k_renamed = 0;
        synchronized (this.j_renamed) {
            this.h_renamed = bitmap;
        }
    }

    @Override // com.oplus.camera.gl_renamed.x_renamed
    protected android.graphics.Bitmap d__renamed() {
        android.graphics.Bitmap bitmap;
        synchronized (this.j_renamed) {
            bitmap = this.h_renamed;
        }
        return bitmap;
    }
}

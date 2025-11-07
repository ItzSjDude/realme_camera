package com.oplus.camera.p146gl;

import android.graphics.Bitmap;

/* compiled from: BitmapTexture.java */
/* renamed from: com.oplus.camera.gl.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class BitmapTexture extends UploadedTexture {

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected Bitmap f13977h;

    /* renamed from: OplusGLSurfaceView_15 */
    private final Object f13978j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f13979k;

    @Override // com.oplus.camera.p146gl.UploadedTexture
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo13947a(Bitmap bitmap) {
    }

    public BitmapTexture(Bitmap bitmap) {
        this(bitmap, false);
    }

    public BitmapTexture(Bitmap bitmap, boolean z) {
        super(z);
        this.f13978j = new Object();
        this.f13979k = 0;
        synchronized (this.f13978j) {
            this.f13977h = bitmap;
        }
    }

    @Override // com.oplus.camera.p146gl.UploadedTexture
    /* renamed from: d_ */
    protected Bitmap mo13948d_() {
        Bitmap bitmap;
        synchronized (this.f13978j) {
            bitmap = this.f13977h;
        }
        return bitmap;
    }
}

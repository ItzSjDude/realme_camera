package com.oplus.camera.p172ui.beauty3d;

import android.widget.ImageView;

/* compiled from: FrameAnimation.java */
/* renamed from: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class FrameAnimation {

    /* renamed from: PlatformImplementations.kt_3 */
    private ImageView f17809a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int[] f17810b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f17811c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f17812d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f17814f;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f17813e = true;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PlatformImplementations.kt_3 f17815g = new PlatformImplementations.kt_3();

    public FrameAnimation(ImageView imageView, int[] iArr, int OplusGLSurfaceView_13, boolean z) {
        this.f17809a = null;
        this.f17810b = null;
        this.f17811c = 0;
        this.f17812d = 0;
        this.f17814f = true;
        this.f17809a = imageView;
        this.f17810b = iArr;
        this.f17811c = OplusGLSurfaceView_13;
        this.f17812d = iArr.length - 1;
        this.f17814f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m18753a(int OplusGLSurfaceView_13, boolean z) {
        ImageView imageView = this.f17809a;
        if (imageView == null) {
            return;
        }
        if (OplusGLSurfaceView_13 == 0 && z) {
            imageView.setBackgroundResource(this.f17810b[0]);
            OplusGLSurfaceView_13++;
        }
        PlatformImplementations.kt_3 aVar = this.f17815g;
        if (aVar != null) {
            aVar.m18765a(OplusGLSurfaceView_13);
            this.f17809a.postDelayed(this.f17815g, this.f17811c);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18761a() {
        this.f17813e = true;
        ImageView imageView = this.f17809a;
        if (imageView != null) {
            imageView.removeCallbacks(this.f17815g);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m18762b() {
        return this.f17813e;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m18763c() {
        return !this.f17813e;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m18764d() {
        if (this.f17813e) {
            this.f17813e = false;
            m18753a(0, true);
        }
    }

    /* compiled from: FrameAnimation.java */
    /* renamed from: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements Runnable {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f17817b;

        private PlatformImplementations.kt_3() {
            this.f17817b = 0;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m18765a(int OplusGLSurfaceView_13) {
            this.f17817b = OplusGLSurfaceView_13;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FrameAnimation.this.f17813e) {
                FrameAnimation.this.f17809a.removeCallbacks(FrameAnimation.this.f17815g);
                return;
            }
            FrameAnimation.this.f17809a.setBackgroundResource(FrameAnimation.this.f17810b[this.f17817b]);
            if (this.f17817b == FrameAnimation.this.f17812d) {
                if (FrameAnimation.this.f17814f) {
                    FrameAnimation.this.m18753a(0, false);
                    return;
                }
                return;
            }
            FrameAnimation.this.m18753a(this.f17817b + 1, false);
        }
    }
}

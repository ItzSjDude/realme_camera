package com.airbnb.lottie.p084c.p087c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.p080a.LPaint_2;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.ValueCallbackKeyframeAnimation_2;
import com.airbnb.lottie.p091f.Utils_4;
import com.airbnb.lottie.p092g.LottieValueCallback;

/* compiled from: ImageLayer.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class ImageLayer_2 extends BaseLayer_3 {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Paint f5636e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Rect f5637f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Rect f5638g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private BaseKeyframeAnimation_3<ColorFilter, ColorFilter> f5639h;

    ImageLayer_2(LottieDrawable c1187f, Layer_4 c1125d) {
        super(c1187f, c1125d);
        this.f5636e = new LPaint_2(3);
        this.f5637f = new Rect();
        this.f5638g = new Rect();
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo5777b(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        Bitmap bitmapM5784f = m5784f();
        if (bitmapM5784f == null || bitmapM5784f.isRecycled()) {
            return;
        }
        float fM6139a = Utils_4.m6139a();
        this.f5636e.setAlpha(OplusGLSurfaceView_13);
        BaseKeyframeAnimation_3<ColorFilter, ColorFilter> abstractC1068a = this.f5639h;
        if (abstractC1068a != null) {
            this.f5636e.setColorFilter(abstractC1068a.mo5583g());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f5637f.set(0, 0, bitmapM5784f.getWidth(), bitmapM5784f.getHeight());
        this.f5638g.set(0, 0, (int) (bitmapM5784f.getWidth() * fM6139a), (int) (bitmapM5784f.getHeight() * fM6139a));
        canvas.drawBitmap(bitmapM5784f, this.f5637f, this.f5638g, this.f5636e);
        canvas.restore();
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3, com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5532a(RectF rectF, Matrix matrix, boolean z) {
        super.mo5532a(rectF, matrix, z);
        if (m5784f() != null) {
            rectF.set(0.0f, 0.0f, r3.getWidth() * Utils_4.m6139a(), r3.getHeight() * Utils_4.m6139a());
            this.f5602a.mapRect(rectF);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Bitmap m5784f() {
        return this.f5603b.m6061e(this.f5604c.m5792g());
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3, com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        super.mo5534a((ImageLayer_2) t, (LottieValueCallback<ImageLayer_2>) c1199c);
        if (t == InterfaceC1205k.f5926E) {
            if (c1199c == null) {
                this.f5639h = null;
            } else {
                this.f5639h = new ValueCallbackKeyframeAnimation_2(c1199c);
            }
        }
    }
}

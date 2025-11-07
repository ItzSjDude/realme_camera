package com.airbnb.lottie.p084c.p087c;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.p080a.LPaint_2;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.ValueCallbackKeyframeAnimation_2;
import com.airbnb.lottie.p092g.LottieValueCallback;

/* compiled from: SolidLayer.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class SolidLayer_2 extends BaseLayer_3 {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final RectF f5663e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Paint f5664f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final float[] f5665g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Path f5666h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final Layer_4 f5667i;

    /* renamed from: OplusGLSurfaceView_15 */
    private BaseKeyframeAnimation_3<ColorFilter, ColorFilter> f5668j;

    SolidLayer_2(LottieDrawable c1187f, Layer_4 c1125d) {
        super(c1187f, c1125d);
        this.f5663e = new RectF();
        this.f5664f = new LPaint_2();
        this.f5665g = new float[8];
        this.f5666h = new Path();
        this.f5667i = c1125d;
        this.f5664f.setAlpha(0);
        this.f5664f.setStyle(Paint.Style.FILL);
        this.f5664f.setColor(c1125d.m5801p());
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo5777b(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        int iAlpha = Color.alpha(this.f5667i.m5801p());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((OplusGLSurfaceView_13 / 255.0f) * (((iAlpha / 255.0f) * (this.f5605d.m5618a() == null ? 100 : this.f5605d.m5618a().mo5583g().intValue())) / 100.0f) * 255.0f);
        this.f5664f.setAlpha(iIntValue);
        BaseKeyframeAnimation_3<ColorFilter, ColorFilter> abstractC1068a = this.f5668j;
        if (abstractC1068a != null) {
            this.f5664f.setColorFilter(abstractC1068a.mo5583g());
        }
        if (iIntValue > 0) {
            float[] fArr = this.f5665g;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.f5667i.m5803r();
            float[] fArr2 = this.f5665g;
            fArr2[3] = 0.0f;
            fArr2[4] = this.f5667i.m5803r();
            this.f5665g[5] = this.f5667i.m5802q();
            float[] fArr3 = this.f5665g;
            fArr3[6] = 0.0f;
            fArr3[7] = this.f5667i.m5802q();
            matrix.mapPoints(this.f5665g);
            this.f5666h.reset();
            Path path = this.f5666h;
            float[] fArr4 = this.f5665g;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.f5666h;
            float[] fArr5 = this.f5665g;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.f5666h;
            float[] fArr6 = this.f5665g;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.f5666h;
            float[] fArr7 = this.f5665g;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.f5666h;
            float[] fArr8 = this.f5665g;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.f5666h.close();
            canvas.drawPath(this.f5666h, this.f5664f);
        }
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3, com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5532a(RectF rectF, Matrix matrix, boolean z) {
        super.mo5532a(rectF, matrix, z);
        this.f5663e.set(0.0f, 0.0f, this.f5667i.m5803r(), this.f5667i.m5802q());
        this.f5602a.mapRect(this.f5663e);
        rectF.set(this.f5663e);
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3, com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        super.mo5534a((SolidLayer_2) t, (LottieValueCallback<SolidLayer_2>) c1199c);
        if (t == InterfaceC1205k.f5926E) {
            if (c1199c == null) {
                this.f5668j = null;
            } else {
                this.f5668j = new ValueCallbackKeyframeAnimation_2(c1199c);
            }
        }
    }
}

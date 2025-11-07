package com.airbnb.lottie.p084c.p087c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;

/* compiled from: NullLayer.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class NullLayer_2 extends BaseLayer_3 {
    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo5777b(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
    }

    NullLayer_2(LottieDrawable c1187f, Layer_4 c1125d) {
        super(c1187f, c1125d);
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3, com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5532a(RectF rectF, Matrix matrix, boolean z) {
        super.mo5532a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}

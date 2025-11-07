package com.airbnb.lottie.p084c.p087c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p081a.ContentGroup_2;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p084c.p086b.ShapeGroup_2;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeLayer.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class ShapeLayer_2 extends BaseLayer_3 {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final ContentGroup_2 f5662e;

    ShapeLayer_2(LottieDrawable c1187f, Layer_4 c1125d) {
        super(c1187f, c1125d);
        this.f5662e = new ContentGroup_2(c1187f, this, new ShapeGroup_2("__container", c1125d.m5799n(), false));
        this.f5662e.mo5535a(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo5777b(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        this.f5662e.mo5531a(canvas, matrix, OplusGLSurfaceView_13);
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3, com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5532a(RectF rectF, Matrix matrix, boolean z) {
        super.mo5532a(rectF, matrix, z);
        this.f5662e.mo5532a(rectF, this.f5602a, z);
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo5780b(KeyPath_2 c1131e, int OplusGLSurfaceView_13, List<KeyPath_2> list, KeyPath_2 c1131e2) {
        this.f5662e.mo5533a(c1131e, OplusGLSurfaceView_13, list, c1131e2);
    }
}

package com.oplus.anim.p115c.p118c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.oplus.anim.EffectiveAnimationDrawable;

/* compiled from: NullLayer.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class NullLayer extends BaseLayer {
    @Override // com.oplus.anim.p115c.p118c.BaseLayer
    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo9085b(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
    }

    NullLayer(EffectiveAnimationDrawable c2309b, Layer c2350d) {
        super(c2309b, c2350d);
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer, com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8808a(RectF rectF, Matrix matrix, boolean z) {
        super.mo8808a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}

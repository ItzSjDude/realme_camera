package com.oplus.anim.p115c.p118c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.L;
import com.oplus.anim.p111a.p112a.ContentGroup;
import com.oplus.anim.p115c.KeyPath;
import com.oplus.anim.p115c.p117b.ShapeGroup;
import com.oplus.anim.p121f.OplusLog;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeLayer.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class ShapeLayer extends BaseLayer {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final ContentGroup f10279e;

    ShapeLayer(EffectiveAnimationDrawable c2309b, Layer c2350d) {
        super(c2309b, c2350d);
        ShapeGroup c2342n = new ShapeGroup("__container", c2350d.m9106n(), false);
        if (OplusLog.f10388d) {
            OplusLog.m9286b("ShapeLayer::shapeGroup = " + c2342n.toString());
        }
        this.f10279e = new ContentGroup(c2309b, this, c2342n);
        this.f10279e.mo8811a(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer
    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo9085b(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        L.m9349c("ShapeLayer#draw");
        this.f10279e.mo8807a(canvas, matrix, OplusGLSurfaceView_13);
        L.m9350d("ShapeLayer#draw");
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer, com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8808a(RectF rectF, Matrix matrix, boolean z) {
        super.mo8808a(rectF, matrix, z);
        this.f10279e.mo8808a(rectF, this.f10222a, z);
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo9087b(KeyPath c2357f, int OplusGLSurfaceView_13, List<KeyPath> list, KeyPath c2357f2) {
        this.f10279e.mo8809a(c2357f, OplusGLSurfaceView_13, list, c2357f2);
    }
}

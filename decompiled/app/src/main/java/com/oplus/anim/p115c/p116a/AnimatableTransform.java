package com.oplus.anim.p115c.p116a;

import android.graphics.PointF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p112a.Content;
import com.oplus.anim.p111a.p113b.TransformKeyframeAnimation;
import com.oplus.anim.p115c.p117b.ContentModel;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.OplusLog;

/* compiled from: AnimatableTransform.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class AnimatableTransform implements ContentModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private final AnimatablePathValue f10108a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AnimatableValue<PointF, PointF> f10109b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableScaleValue f10110c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableFloatValue f10111d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AnimatableIntegerValue f10112e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final AnimatableFloatValue f10113f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final AnimatableFloatValue f10114g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final AnimatableFloatValue f10115h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final AnimatableFloatValue f10116i;

    @Override // com.oplus.anim.p115c.p117b.ContentModel
    /* renamed from: PlatformImplementations.kt_3 */
    public Content mo8962a(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a) {
        return null;
    }

    public AnimatableTransform() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public AnimatableTransform(AnimatablePathValue c2318e, AnimatableValue<PointF, PointF> interfaceC2326m, AnimatableScaleValue c2320g, AnimatableFloatValue c2315b, AnimatableIntegerValue c2317d, AnimatableFloatValue c2315b2, AnimatableFloatValue c2315b3, AnimatableFloatValue c2315b4, AnimatableFloatValue c2315b5) {
        this.f10108a = c2318e;
        this.f10109b = interfaceC2326m;
        this.f10110c = c2320g;
        this.f10111d = c2315b;
        this.f10112e = c2317d;
        this.f10115h = c2315b2;
        this.f10116i = c2315b3;
        this.f10113f = c2315b4;
        this.f10114g = c2315b5;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public AnimatablePathValue m8963a() {
        return this.f10108a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableValue<PointF, PointF> m8964b() {
        return this.f10109b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableScaleValue m8965c() {
        return this.f10110c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableFloatValue m8966d() {
        return this.f10111d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public AnimatableIntegerValue m8967e() {
        return this.f10112e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public AnimatableFloatValue m8968f() {
        return this.f10115h;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public AnimatableFloatValue m8969g() {
        return this.f10116i;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public AnimatableFloatValue m8970h() {
        return this.f10113f;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public AnimatableFloatValue m8971i() {
        return this.f10114g;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public TransformKeyframeAnimation m8972j() {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("AnimatableTransform create TransformKeyframeAnimation, " + m8961k());
        }
        return new TransformKeyframeAnimation(this);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private String m8961k() {
        StringBuilder sb = new StringBuilder();
        sb.append("AnimatableTransform:{");
        if (this.f10108a != null) {
            sb.append("anchorPoint = ");
            sb.append(this.f10108a.toString());
        }
        if (this.f10110c != null) {
            sb.append("scale = ");
            sb.append(this.f10110c.toString());
        }
        if (this.f10111d != null) {
            sb.append("rotation = ");
            sb.append(this.f10111d.toString());
        }
        if (this.f10112e != null) {
            sb.append("opacity = ");
            sb.append(this.f10112e.toString());
        }
        if (this.f10113f != null) {
            sb.append("skew = ");
            sb.append(this.f10113f.toString());
        }
        if (this.f10114g != null) {
            sb.append("skewAngle = ");
            sb.append(this.f10114g.toString());
        }
        if (this.f10115h != null) {
            sb.append("startOpacity = ");
            sb.append(this.f10115h.toString());
        }
        if (this.f10116i != null) {
            sb.append("endOpacity = ");
            sb.append(this.f10116i.toString());
        }
        sb.append("}");
        return sb.toString();
    }
}

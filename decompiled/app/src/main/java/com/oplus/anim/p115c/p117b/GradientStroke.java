package com.oplus.anim.p115c.p117b;

import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p112a.GradientStrokeContent;
import com.oplus.anim.p111a.p112a.Content;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p116a.AnimatableGradientColorValue;
import com.oplus.anim.p115c.p116a.AnimatableIntegerValue;
import com.oplus.anim.p115c.p116a.AnimatablePointValue;
import com.oplus.anim.p115c.p117b.ShapeStroke;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.OplusLog;
import java.util.List;

/* compiled from: GradientStroke.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class GradientStroke implements ContentModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f10146a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final GradientType f10147b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableGradientColorValue f10148c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableIntegerValue f10149d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AnimatablePointValue f10150e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final AnimatablePointValue f10151f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final AnimatableFloatValue f10152g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final ShapeStroke.PlatformImplementations.kt_3 f10153h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final ShapeStroke.IntrinsicsJvm.kt_4 f10154i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final float f10155j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final List<AnimatableFloatValue> f10156k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final AnimatableFloatValue f10157l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final boolean f10158m;

    public GradientStroke(String str, GradientType enumC2334f, AnimatableGradientColorValue c2316c, AnimatableIntegerValue c2317d, AnimatablePointValue c2319f, AnimatablePointValue c2319f2, AnimatableFloatValue c2315b, ShapeStroke.PlatformImplementations.kt_3 aVar, ShapeStroke.IntrinsicsJvm.kt_4 bVar, float COUIBaseListPopupWindow_12, List<AnimatableFloatValue> list, AnimatableFloatValue c2315b2, boolean z) {
        this.f10146a = str;
        this.f10147b = enumC2334f;
        this.f10148c = c2316c;
        this.f10149d = c2317d;
        this.f10150e = c2319f;
        this.f10151f = c2319f2;
        this.f10152g = c2315b;
        this.f10153h = aVar;
        this.f10154i = bVar;
        this.f10155j = COUIBaseListPopupWindow_12;
        this.f10156k = list;
        this.f10157l = c2315b2;
        this.f10158m = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m8990a() {
        return this.f10146a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public GradientType m8991b() {
        return this.f10147b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableGradientColorValue m8992c() {
        return this.f10148c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableIntegerValue m8993d() {
        return this.f10149d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public AnimatablePointValue m8994e() {
        return this.f10150e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public AnimatablePointValue m8995f() {
        return this.f10151f;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public AnimatableFloatValue m8996g() {
        return this.f10152g;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public ShapeStroke.PlatformImplementations.kt_3 m8997h() {
        return this.f10153h;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public ShapeStroke.IntrinsicsJvm.kt_4 m8998i() {
        return this.f10154i;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public List<AnimatableFloatValue> m8999j() {
        return this.f10156k;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public AnimatableFloatValue m9000k() {
        return this.f10157l;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public float m9001l() {
        return this.f10155j;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean m9002m() {
        return this.f10158m;
    }

    @Override // com.oplus.anim.p115c.p117b.ContentModel
    /* renamed from: PlatformImplementations.kt_3 */
    public Content mo8962a(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a) {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("GradientStroke to GradientStrokeContent, layer = " + abstractC2347a);
        }
        return new GradientStrokeContent(c2309b, abstractC2347a, this);
    }
}

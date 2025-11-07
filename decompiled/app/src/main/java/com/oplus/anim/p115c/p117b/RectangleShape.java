package com.oplus.anim.p115c.p117b;

import android.graphics.PointF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p112a.RectangleContent;
import com.oplus.anim.p111a.p112a.Content;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p116a.AnimatablePointValue;
import com.oplus.anim.p115c.p116a.AnimatableValue;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.OplusLog;

/* compiled from: RectangleShape.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class RectangleShape implements ContentModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f10176a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AnimatableValue<PointF, PointF> f10177b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatablePointValue f10178c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableFloatValue f10179d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean f10180e;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> interfaceC2326m, AnimatablePointValue c2319f, AnimatableFloatValue c2315b, boolean z) {
        this.f10176a = str;
        this.f10177b = interfaceC2326m;
        this.f10178c = c2319f;
        this.f10179d = c2315b;
        this.f10180e = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m9020a() {
        return this.f10176a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableFloatValue m9021b() {
        return this.f10179d;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatablePointValue m9022c() {
        return this.f10178c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableValue<PointF, PointF> m9023d() {
        return this.f10177b;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m9024e() {
        return this.f10180e;
    }

    @Override // com.oplus.anim.p115c.p117b.ContentModel
    /* renamed from: PlatformImplementations.kt_3 */
    public Content mo8962a(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a) {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("RectangleShape to RectangleContent, layer = " + abstractC2347a);
        }
        return new RectangleContent(c2309b, abstractC2347a, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.f10177b + ", size=" + this.f10178c + '}';
    }
}

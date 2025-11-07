package com.oplus.anim.p115c.p117b;

import android.graphics.PointF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p112a.EllipseContent;
import com.oplus.anim.p111a.p112a.Content;
import com.oplus.anim.p115c.p116a.AnimatablePointValue;
import com.oplus.anim.p115c.p116a.AnimatableValue;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.OplusLog;

/* compiled from: CircleShape.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class CircleShape implements ContentModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f10129a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AnimatableValue<PointF, PointF> f10130b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatablePointValue f10131c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final boolean f10132d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean f10133e;

    public CircleShape(String str, AnimatableValue<PointF, PointF> interfaceC2326m, AnimatablePointValue c2319f, boolean z, boolean z2) {
        this.f10129a = str;
        this.f10130b = interfaceC2326m;
        this.f10131c = c2319f;
        this.f10132d = z;
        this.f10133e = z2;
    }

    @Override // com.oplus.anim.p115c.p117b.ContentModel
    /* renamed from: PlatformImplementations.kt_3 */
    public Content mo8962a(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a) {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("CircleShape::toContent layer = " + abstractC2347a);
        }
        return new EllipseContent(c2309b, abstractC2347a, this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m8973a() {
        return this.f10129a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableValue<PointF, PointF> m8974b() {
        return this.f10130b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatablePointValue m8975c() {
        return this.f10131c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m8976d() {
        return this.f10132d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m8977e() {
        return this.f10133e;
    }
}

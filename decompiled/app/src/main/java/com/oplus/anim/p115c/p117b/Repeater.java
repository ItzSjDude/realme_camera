package com.oplus.anim.p115c.p117b;

import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p112a.RepeaterContent;
import com.oplus.anim.p111a.p112a.Content;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p116a.AnimatableTransform;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.OplusLog;

/* compiled from: Repeater.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class Repeater implements ContentModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f10181a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AnimatableFloatValue f10182b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableFloatValue f10183c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableTransform f10184d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean f10185e;

    public Repeater(String str, AnimatableFloatValue c2315b, AnimatableFloatValue c2315b2, AnimatableTransform c2325l, boolean z) {
        this.f10181a = str;
        this.f10182b = c2315b;
        this.f10183c = c2315b2;
        this.f10184d = c2325l;
        this.f10185e = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m9025a() {
        return this.f10181a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableFloatValue m9026b() {
        return this.f10182b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableFloatValue m9027c() {
        return this.f10183c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableTransform m9028d() {
        return this.f10184d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m9029e() {
        return this.f10185e;
    }

    @Override // com.oplus.anim.p115c.p117b.ContentModel
    /* renamed from: PlatformImplementations.kt_3 */
    public Content mo8962a(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a) {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("Repeater to RepeaterContent, layer = " + abstractC2347a);
        }
        return new RepeaterContent(c2309b, abstractC2347a, this);
    }
}

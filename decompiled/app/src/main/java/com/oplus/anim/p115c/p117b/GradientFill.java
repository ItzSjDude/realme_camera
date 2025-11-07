package com.oplus.anim.p115c.p117b;

import android.graphics.Path;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p112a.GradientFillContent;
import com.oplus.anim.p111a.p112a.Content;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p116a.AnimatableGradientColorValue;
import com.oplus.anim.p115c.p116a.AnimatableIntegerValue;
import com.oplus.anim.p115c.p116a.AnimatablePointValue;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.OplusLog;

/* compiled from: GradientFill.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class GradientFill implements ContentModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private final GradientType f10136a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Path.FillType f10137b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableGradientColorValue f10138c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableIntegerValue f10139d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AnimatablePointValue f10140e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final AnimatablePointValue f10141f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final String f10142g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final AnimatableFloatValue f10143h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final AnimatableFloatValue f10144i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final boolean f10145j;

    public GradientFill(String str, GradientType enumC2334f, Path.FillType fillType, AnimatableGradientColorValue c2316c, AnimatableIntegerValue c2317d, AnimatablePointValue c2319f, AnimatablePointValue c2319f2, AnimatableFloatValue c2315b, AnimatableFloatValue c2315b2, boolean z) {
        this.f10136a = enumC2334f;
        this.f10137b = fillType;
        this.f10138c = c2316c;
        this.f10139d = c2317d;
        this.f10140e = c2319f;
        this.f10141f = c2319f2;
        this.f10142g = str;
        this.f10143h = c2315b;
        this.f10144i = c2315b2;
        this.f10145j = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m8982a() {
        return this.f10142g;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public GradientType m8983b() {
        return this.f10136a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Path.FillType m8984c() {
        return this.f10137b;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableGradientColorValue m8985d() {
        return this.f10138c;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public AnimatableIntegerValue m8986e() {
        return this.f10139d;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public AnimatablePointValue m8987f() {
        return this.f10140e;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public AnimatablePointValue m8988g() {
        return this.f10141f;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m8989h() {
        return this.f10145j;
    }

    @Override // com.oplus.anim.p115c.p117b.ContentModel
    /* renamed from: PlatformImplementations.kt_3 */
    public Content mo8962a(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a) {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("GradientFill to GradientFillContent, layer = " + abstractC2347a);
        }
        return new GradientFillContent(c2309b, abstractC2347a, this);
    }
}

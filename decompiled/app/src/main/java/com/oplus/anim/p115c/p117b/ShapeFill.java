package com.oplus.anim.p115c.p117b;

import android.graphics.Path;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p112a.FillContent;
import com.oplus.anim.p111a.p112a.Content;
import com.oplus.anim.p115c.p116a.AnimatableColorValue;
import com.oplus.anim.p115c.p116a.AnimatableIntegerValue;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.OplusLog;

/* compiled from: ShapeFill.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public class ShapeFill implements ContentModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private final boolean f10189a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Path.FillType f10190b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final String f10191c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableColorValue f10192d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AnimatableIntegerValue f10193e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final boolean f10194f;

    public ShapeFill(String str, boolean z, Path.FillType fillType, AnimatableColorValue c2314a, AnimatableIntegerValue c2317d, boolean z2) {
        this.f10191c = str;
        this.f10189a = z;
        this.f10190b = fillType;
        this.f10192d = c2314a;
        this.f10193e = c2317d;
        this.f10194f = z2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m9035a() {
        return this.f10191c;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableColorValue m9036b() {
        return this.f10192d;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableIntegerValue m9037c() {
        return this.f10193e;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Path.FillType m9038d() {
        return this.f10190b;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m9039e() {
        return this.f10194f;
    }

    @Override // com.oplus.anim.p115c.p117b.ContentModel
    /* renamed from: PlatformImplementations.kt_3 */
    public Content mo8962a(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a) {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("ShapeFill to FillContent, layer = " + abstractC2347a);
        }
        return new FillContent(c2309b, abstractC2347a, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f10189a + '}';
    }
}

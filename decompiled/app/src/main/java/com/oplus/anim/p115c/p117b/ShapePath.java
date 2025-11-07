package com.oplus.anim.p115c.p117b;

import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p112a.ShapeContent;
import com.oplus.anim.p111a.p112a.Content;
import com.oplus.anim.p115c.p116a.AnimatableShapeValue;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.OplusLog;

/* compiled from: ShapePath.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.o */
/* loaded from: classes2.dex */
public class ShapePath implements ContentModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f10198a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f10199b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableShapeValue f10200c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final boolean f10201d;

    public ShapePath(String str, int OplusGLSurfaceView_13, AnimatableShapeValue c2321h, boolean z) {
        this.f10198a = str;
        this.f10199b = OplusGLSurfaceView_13;
        this.f10200c = c2321h;
        this.f10201d = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m9043a() {
        return this.f10198a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableShapeValue m9044b() {
        return this.f10200c;
    }

    @Override // com.oplus.anim.p115c.p117b.ContentModel
    /* renamed from: PlatformImplementations.kt_3 */
    public Content mo8962a(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a) {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("ShapePath to ShapeContent, layer = " + abstractC2347a);
        }
        return new ShapeContent(c2309b, abstractC2347a, this);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m9045c() {
        return this.f10201d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f10198a + ", index=" + this.f10199b + '}';
    }
}

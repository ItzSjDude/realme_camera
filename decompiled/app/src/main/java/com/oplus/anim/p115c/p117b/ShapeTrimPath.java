package com.oplus.anim.p115c.p117b;

import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p112a.TrimPathContent;
import com.oplus.anim.p111a.p112a.Content;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.OplusLog;

/* compiled from: ShapeTrimPath.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.q */
/* loaded from: classes2.dex */
public class ShapeTrimPath implements ContentModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f10214a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PlatformImplementations.kt_3 f10215b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableFloatValue f10216c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableFloatValue f10217d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AnimatableFloatValue f10218e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final boolean f10219f;

    public ShapeTrimPath(String str, PlatformImplementations.kt_3 aVar, AnimatableFloatValue c2315b, AnimatableFloatValue c2315b2, AnimatableFloatValue c2315b3, boolean z) {
        this.f10214a = str;
        this.f10215b = aVar;
        this.f10216c = c2315b;
        this.f10217d = c2315b2;
        this.f10218e = c2315b3;
        this.f10219f = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m9056a() {
        return this.f10214a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public PlatformImplementations.kt_3 m9057b() {
        return this.f10215b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableFloatValue m9058c() {
        return this.f10217d;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableFloatValue m9059d() {
        return this.f10216c;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public AnimatableFloatValue m9060e() {
        return this.f10218e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m9061f() {
        return this.f10219f;
    }

    @Override // com.oplus.anim.p115c.p117b.ContentModel
    /* renamed from: PlatformImplementations.kt_3 */
    public Content mo8962a(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a) {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("ShapeTrimPath to TrimPathContent, layer = " + abstractC2347a);
        }
        return new TrimPathContent(abstractC2347a, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.f10216c + ", end: " + this.f10217d + ", offset: " + this.f10218e + "}";
    }

    /* compiled from: ShapeTrimPath.java */
    /* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.q$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static PlatformImplementations.kt_3 forId(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 1) {
                return SIMULTANEOUSLY;
            }
            if (OplusGLSurfaceView_13 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + OplusGLSurfaceView_13);
        }
    }
}

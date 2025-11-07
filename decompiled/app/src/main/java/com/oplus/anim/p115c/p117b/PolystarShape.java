package com.oplus.anim.p115c.p117b;

import android.graphics.PointF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p112a.PolystarContent;
import com.oplus.anim.p111a.p112a.Content;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p116a.AnimatableValue;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.OplusLog;

/* compiled from: PolystarShape.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class PolystarShape implements ContentModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f10166a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PlatformImplementations.kt_3 f10167b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableFloatValue f10168c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableValue<PointF, PointF> f10169d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AnimatableFloatValue f10170e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final AnimatableFloatValue f10171f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final AnimatableFloatValue f10172g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final AnimatableFloatValue f10173h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final AnimatableFloatValue f10174i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final boolean f10175j;

    public PolystarShape(String str, PlatformImplementations.kt_3 aVar, AnimatableFloatValue c2315b, AnimatableValue<PointF, PointF> interfaceC2326m, AnimatableFloatValue c2315b2, AnimatableFloatValue c2315b3, AnimatableFloatValue c2315b4, AnimatableFloatValue c2315b5, AnimatableFloatValue c2315b6, boolean z) {
        this.f10166a = str;
        this.f10167b = aVar;
        this.f10168c = c2315b;
        this.f10169d = interfaceC2326m;
        this.f10170e = c2315b2;
        this.f10171f = c2315b3;
        this.f10172g = c2315b4;
        this.f10173h = c2315b5;
        this.f10174i = c2315b6;
        this.f10175j = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m9010a() {
        return this.f10166a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public PlatformImplementations.kt_3 m9011b() {
        return this.f10167b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableFloatValue m9012c() {
        return this.f10168c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableValue<PointF, PointF> m9013d() {
        return this.f10169d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public AnimatableFloatValue m9014e() {
        return this.f10170e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public AnimatableFloatValue m9015f() {
        return this.f10171f;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public AnimatableFloatValue m9016g() {
        return this.f10172g;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public AnimatableFloatValue m9017h() {
        return this.f10173h;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public AnimatableFloatValue m9018i() {
        return this.f10174i;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m9019j() {
        return this.f10175j;
    }

    @Override // com.oplus.anim.p115c.p117b.ContentModel
    /* renamed from: PlatformImplementations.kt_3 */
    public Content mo8962a(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a) {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("PolystarShape to RepeaterContent, layer = " + abstractC2347a);
        }
        return new PolystarContent(c2309b, abstractC2347a, this);
    }

    /* compiled from: PolystarShape.java */
    /* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        STAR(1),
        POLYGON(2);

        private final int value;

        PlatformImplementations.kt_3(int OplusGLSurfaceView_13) {
            this.value = OplusGLSurfaceView_13;
        }

        public static PlatformImplementations.kt_3 forValue(int OplusGLSurfaceView_13) {
            for (PlatformImplementations.kt_3 aVar : values()) {
                if (aVar.value == OplusGLSurfaceView_13) {
                    return aVar;
                }
            }
            return null;
        }
    }
}

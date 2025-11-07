package com.oplus.anim.p115c.p118c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.LongSparseArray;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.L;
import com.oplus.anim.InterfaceC2361d;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.ValueCallbackKeyframeAnimation;
import com.oplus.anim.p115c.KeyPath;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p118c.Layer;
import com.oplus.anim.p121f.OplusLog;
import com.oplus.anim.p122g.EffectiveValueCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompositionLayer.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class CompositionLayer extends BaseLayer {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final List<BaseLayer> f10248e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final RectF f10249f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final RectF f10250g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private BaseKeyframeAnimation<Float, Float> f10251h;

    public CompositionLayer(EffectiveAnimationDrawable c2309b, Layer c2350d, List<Layer> list, EffectiveAnimationComposition c2272a) {
        int OplusGLSurfaceView_13;
        BaseLayer abstractC2347a;
        super(c2309b, c2350d);
        this.f10248e = new ArrayList();
        this.f10249f = new RectF();
        this.f10250g = new RectF();
        AnimatableFloatValue c2315bM9113u = c2350d.m9113u();
        if (c2315bM9113u != null) {
            if (OplusLog.f10388d) {
                OplusLog.m9286b("CompositionLayer::create timeRemapping animation, this = " + c2350d.m9098f());
            }
            this.f10251h = c2315bM9113u.mo8957a();
            m9082a(this.f10251h);
            this.f10251h.m8847a(this);
        } else {
            this.f10251h = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(c2272a.m8798i().size());
        int size = list.size() - 1;
        BaseLayer abstractC2347a2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer c2350d2 = list.get(size);
            if (OplusLog.f10388d) {
                OplusLog.m9286b("CompositionLayer::OplusGLSurfaceView_13 = " + size + "; lm.type = " + c2350d2.m9103k() + "; lm.name = " + c2350d2.m9098f() + "; lm.id_renamed = " + c2350d2.m9097e());
            }
            BaseLayer abstractC2347aM9065a = BaseLayer.m9065a(c2350d2, c2309b, c2272a);
            if (abstractC2347aM9065a != null) {
                longSparseArray.put(abstractC2347aM9065a.m9088c().m9097e(), abstractC2347aM9065a);
                if (abstractC2347a2 != null) {
                    abstractC2347a2.m9083a(abstractC2347aM9065a);
                    abstractC2347a2 = null;
                } else {
                    this.f10248e.add(0, abstractC2347aM9065a);
                    int i2 = COUIBaseListPopupWindow_2.f10252a[c2350d2.m9104l().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        abstractC2347a2 = abstractC2347aM9065a;
                    }
                }
            }
            size--;
        }
        for (OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < longSparseArray.size(); OplusGLSurfaceView_13++) {
            BaseLayer abstractC2347a3 = (BaseLayer) longSparseArray.get(longSparseArray.keyAt(OplusGLSurfaceView_13));
            if (abstractC2347a3 != null && (abstractC2347a = (BaseLayer) longSparseArray.get(abstractC2347a3.m9088c().m9105m())) != null) {
                abstractC2347a3.m9086b(abstractC2347a);
            }
        }
    }

    /* compiled from: CompositionLayer.java */
    /* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f10252a = new int[Layer.IntrinsicsJvm.kt_4.values().length];

        static {
            try {
                f10252a[Layer.IntrinsicsJvm.kt_4.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10252a[Layer.IntrinsicsJvm.kt_4.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer
    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo9085b(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        L.m9349c("CompositionLayer#draw");
        canvas.save();
        this.f10250g.set(0.0f, 0.0f, this.f10224c.m9100h(), this.f10224c.m9101i());
        matrix.mapRect(this.f10250g);
        for (int size = this.f10248e.size() - 1; size >= 0; size--) {
            if (!this.f10250g.isEmpty() ? canvas.clipRect(this.f10250g) : true) {
                this.f10248e.get(size).mo8807a(canvas, matrix, OplusGLSurfaceView_13);
            }
        }
        canvas.restore();
        L.m9350d("CompositionLayer#draw");
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer, com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8808a(RectF rectF, Matrix matrix, boolean z) {
        super.mo8808a(rectF, matrix, z);
        for (int size = this.f10248e.size() - 1; size >= 0; size--) {
            this.f10249f.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f10248e.get(size).mo8808a(this.f10249f, this.f10222a, true);
            rectF.union(this.f10249f);
        }
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo9081a(float COUIBaseListPopupWindow_12) {
        super.mo9081a(COUIBaseListPopupWindow_12);
        if (this.f10251h != null) {
            COUIBaseListPopupWindow_12 = ((long) (this.f10251h.mo8854g().floatValue() * 1000.0f)) / this.f10223b.m8938r().m8794e();
        }
        if (this.f10224c.m9094b() != 0.0f) {
            COUIBaseListPopupWindow_12 /= this.f10224c.m9094b();
        }
        float fM9095c = COUIBaseListPopupWindow_12 - this.f10224c.m9095c();
        for (int size = this.f10248e.size() - 1; size >= 0; size--) {
            this.f10248e.get(size).mo9081a(fM9095c);
        }
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo9087b(KeyPath c2357f, int OplusGLSurfaceView_13, List<KeyPath> list, KeyPath c2357f2) {
        for (int i2 = 0; i2 < this.f10248e.size(); i2++) {
            this.f10248e.get(i2).mo8809a(c2357f, OplusGLSurfaceView_13, list, c2357f2);
        }
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer, com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo8810a(T t, EffectiveValueCallback<T> c2412b) {
        super.mo8810a((CompositionLayer) t, (EffectiveValueCallback<CompositionLayer>) c2412b);
        if (t == InterfaceC2361d.f10343y) {
            if (c2412b == null) {
                this.f10251h = null;
            } else {
                this.f10251h = new ValueCallbackKeyframeAnimation(c2412b);
                m9082a(this.f10251h);
            }
        }
    }
}

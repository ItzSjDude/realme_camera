package com.oplus.anim.p111a.p112a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.InterfaceC2361d;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.ColorKeyframeAnimation;
import com.oplus.anim.p111a.p113b.ValueCallbackKeyframeAnimation;
import com.oplus.anim.p115c.p117b.ShapeStroke;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p122g.EffectiveValueCallback;

/* compiled from: StrokeContent.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.r */
/* loaded from: classes2.dex */
public class StrokeContent extends BaseStrokeContent {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final BaseLayer f9985b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final String f9986c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final boolean f9987d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final BaseKeyframeAnimation<Integer, Integer> f9988e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f9989f;

    public StrokeContent(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a, ShapeStroke c2344p) {
        super(c2309b, abstractC2347a, c2344p.m9052g().toPaintCap(), c2344p.m9053h().toPaintJoin(), c2344p.m9054i(), c2344p.m9048c(), c2344p.m9049d(), c2344p.m9050e(), c2344p.m9051f());
        this.f9985b = abstractC2347a;
        this.f9986c = c2344p.m9046a();
        this.f9987d = c2344p.m9055j();
        this.f9988e = c2344p.m9047b().mo8957a();
        this.f9988e.m8847a(this);
        abstractC2347a.m9082a(this.f9988e);
    }

    @Override // com.oplus.anim.p111a.p112a.BaseStrokeContent, com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8807a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        if (this.f9987d) {
            return;
        }
        this.f9864a.setColor(((ColorKeyframeAnimation) this.f9988e).m8858i());
        if (this.f9989f != null) {
            this.f9864a.setColorFilter(this.f9989f.mo8854g());
        }
        super.mo8807a(canvas, matrix, OplusGLSurfaceView_13);
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo8816b() {
        return this.f9986c;
    }

    @Override // com.oplus.anim.p111a.p112a.BaseStrokeContent, com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo8810a(T t, EffectiveValueCallback<T> c2412b) {
        super.mo8810a((StrokeContent) t, (EffectiveValueCallback<StrokeContent>) c2412b);
        if (t == InterfaceC2361d.f10320b) {
            this.f9988e.m8848a((EffectiveValueCallback<Integer>) c2412b);
            return;
        }
        if (t == InterfaceC2361d.f10344z) {
            if (c2412b == null) {
                this.f9989f = null;
                return;
            }
            this.f9989f = new ValueCallbackKeyframeAnimation(c2412b);
            this.f9989f.m8847a(this);
            this.f9985b.m9082a(this.f9988e);
        }
    }
}

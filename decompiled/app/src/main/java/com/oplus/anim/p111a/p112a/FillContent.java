package com.oplus.anim.p111a.p112a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.L;
import com.oplus.anim.InterfaceC2361d;
import com.oplus.anim.p111a.LPaint;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.ColorKeyframeAnimation;
import com.oplus.anim.p111a.p113b.ValueCallbackKeyframeAnimation;
import com.oplus.anim.p115c.KeyPath;
import com.oplus.anim.p115c.p117b.ShapeFill;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.MiscUtils;
import com.oplus.anim.p122g.EffectiveValueCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class FillContent implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.PlatformImplementations.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final BaseLayer f9900c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final String f9901d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean f9902e;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final BaseKeyframeAnimation<Integer, Integer> f9904g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final BaseKeyframeAnimation<Integer, Integer> f9905h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final EffectiveAnimationDrawable f9906i;

    /* renamed from: OplusGLSurfaceView_15 */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f9907j;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Path f9898a = new Path();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Paint f9899b = new LPaint(1);

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final List<PathContent> f9903f = new ArrayList();

    public FillContent(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a, ShapeFill c2341m) {
        this.f9900c = abstractC2347a;
        this.f9901d = c2341m.m9035a();
        this.f9902e = c2341m.m9039e();
        this.f9906i = c2309b;
        if (c2341m.m9036b() == null || c2341m.m9037c() == null) {
            this.f9904g = null;
            this.f9905h = null;
            return;
        }
        this.f9898a.setFillType(c2341m.m9038d());
        this.f9904g = c2341m.m9036b().mo8957a();
        this.f9904g.m8847a(this);
        abstractC2347a.m9082a(this.f9904g);
        this.f9905h = c2341m.m9037c().mo8957a();
        this.f9905h.m8847a(this);
        abstractC2347a.m9082a(this.f9905h);
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8806a() {
        this.f9906i.invalidateSelf();
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8811a(List<Content> list, List<Content> list2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list2.size(); OplusGLSurfaceView_13++) {
            Content interfaceC2276c = list2.get(OplusGLSurfaceView_13);
            if (interfaceC2276c instanceof PathContent) {
                this.f9903f.add((PathContent) interfaceC2276c);
            }
        }
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo8816b() {
        return this.f9901d;
    }

    @Override // com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8807a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        if (this.f9902e) {
            return;
        }
        L.m9349c("FillContent#draw");
        this.f9899b.setColor(((ColorKeyframeAnimation) this.f9904g).m8858i());
        this.f9899b.setAlpha(MiscUtils.m9278a((int) ((((OplusGLSurfaceView_13 / 255.0f) * this.f9905h.mo8854g().intValue()) / 100.0f) * 255.0f), 0, 255));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> abstractC2293a = this.f9907j;
        if (abstractC2293a != null) {
            this.f9899b.setColorFilter(abstractC2293a.mo8854g());
        }
        this.f9898a.reset();
        for (int i2 = 0; i2 < this.f9903f.size(); i2++) {
            this.f9898a.addPath(this.f9903f.get(i2).mo8821e(), matrix);
        }
        canvas.drawPath(this.f9898a, this.f9899b);
        L.m9350d("FillContent#draw");
    }

    @Override // com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8808a(RectF rectF, Matrix matrix, boolean z) {
        this.f9898a.reset();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f9903f.size(); OplusGLSurfaceView_13++) {
            this.f9898a.addPath(this.f9903f.get(OplusGLSurfaceView_13).mo8821e(), matrix);
        }
        this.f9898a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8809a(KeyPath c2357f, int OplusGLSurfaceView_13, List<KeyPath> list, KeyPath c2357f2) {
        MiscUtils.m9281a(c2357f, OplusGLSurfaceView_13, list, c2357f2, this);
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo8810a(T t, EffectiveValueCallback<T> c2412b) {
        if (t == InterfaceC2361d.f10319a) {
            this.f9904g.m8848a((EffectiveValueCallback<Integer>) c2412b);
            return;
        }
        if (t == InterfaceC2361d.f10322d) {
            this.f9905h.m8848a((EffectiveValueCallback<Integer>) c2412b);
            return;
        }
        if (t == InterfaceC2361d.f10344z) {
            if (c2412b == null) {
                this.f9907j = null;
                return;
            }
            this.f9907j = new ValueCallbackKeyframeAnimation(c2412b);
            this.f9907j.m8847a(this);
            this.f9900c.m9082a(this.f9907j);
        }
    }
}

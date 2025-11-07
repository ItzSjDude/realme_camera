package com.oplus.anim.p111a.p112a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.FloatKeyframeAnimation;
import com.oplus.anim.p115c.KeyPath;
import com.oplus.anim.p115c.p117b.RectangleShape;
import com.oplus.anim.p115c.p117b.ShapeTrimPath;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.MiscUtils;
import com.oplus.anim.p122g.EffectiveValueCallback;
import java.util.List;

/* compiled from: RectangleContent.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.o */
/* loaded from: classes2.dex */
public class RectangleContent implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.PlatformImplementations.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final String f9960c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final boolean f9961d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final EffectiveAnimationDrawable f9962e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final BaseKeyframeAnimation<?, PointF> f9963f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final BaseKeyframeAnimation<?, PointF> f9964g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final BaseKeyframeAnimation<?, Float> f9965h;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f9967j;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Path f9958a = new Path();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final RectF f9959b = new RectF();

    /* renamed from: OplusGLSurfaceView_13 */
    private CompoundTrimPathContent f9966i = new CompoundTrimPathContent();

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo8810a(T t, EffectiveValueCallback<T> c2412b) {
    }

    public RectangleContent(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a, RectangleShape c2338j) {
        this.f9960c = c2338j.m9020a();
        this.f9961d = c2338j.m9024e();
        this.f9962e = c2309b;
        this.f9963f = c2338j.m9023d().mo8957a();
        this.f9964g = c2338j.m9022c().mo8957a();
        this.f9965h = c2338j.m9021b().mo8957a();
        abstractC2347a.m9082a(this.f9963f);
        abstractC2347a.m9082a(this.f9964g);
        abstractC2347a.m9082a(this.f9965h);
        this.f9963f.m8847a(this);
        this.f9964g.m8847a(this);
        this.f9965h.m8847a(this);
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo8816b() {
        return this.f9960c;
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8806a() {
        m8835c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m8835c() {
        this.f9967j = false;
        this.f9962e.invalidateSelf();
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8811a(List<Content> list, List<Content> list2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            Content interfaceC2276c = list.get(OplusGLSurfaceView_13);
            if (interfaceC2276c instanceof TrimPathContent) {
                TrimPathContent c2292s = (TrimPathContent) interfaceC2276c;
                if (c2292s.m8838c() == ShapeTrimPath.PlatformImplementations.kt_3.SIMULTANEOUSLY) {
                    this.f9966i.m8815a(c2292s);
                    c2292s.m8837a(this);
                }
            }
        }
    }

    @Override // com.oplus.anim.p111a.p112a.PathContent
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Path mo8821e() {
        if (this.f9967j) {
            return this.f9958a;
        }
        this.f9958a.reset();
        if (this.f9961d) {
            this.f9967j = true;
            return this.f9958a;
        }
        PointF pointFMo8854g = this.f9964g.mo8854g();
        float COUIBaseListPopupWindow_12 = pointFMo8854g.x / 2.0f;
        float f2 = pointFMo8854g.y / 2.0f;
        BaseKeyframeAnimation<?, Float> abstractC2293a = this.f9965h;
        float fM8861i = abstractC2293a == null ? 0.0f : ((FloatKeyframeAnimation) abstractC2293a).m8861i();
        float fMin = Math.min(COUIBaseListPopupWindow_12, f2);
        if (fM8861i > fMin) {
            fM8861i = fMin;
        }
        PointF pointFMo8854g2 = this.f9963f.mo8854g();
        this.f9958a.moveTo(pointFMo8854g2.x + COUIBaseListPopupWindow_12, (pointFMo8854g2.y - f2) + fM8861i);
        this.f9958a.lineTo(pointFMo8854g2.x + COUIBaseListPopupWindow_12, (pointFMo8854g2.y + f2) - fM8861i);
        if (fM8861i > 0.0f) {
            float f3 = fM8861i * 2.0f;
            this.f9959b.set((pointFMo8854g2.x + COUIBaseListPopupWindow_12) - f3, (pointFMo8854g2.y + f2) - f3, pointFMo8854g2.x + COUIBaseListPopupWindow_12, pointFMo8854g2.y + f2);
            this.f9958a.arcTo(this.f9959b, 0.0f, 90.0f, false);
        }
        this.f9958a.lineTo((pointFMo8854g2.x - COUIBaseListPopupWindow_12) + fM8861i, pointFMo8854g2.y + f2);
        if (fM8861i > 0.0f) {
            float f4 = fM8861i * 2.0f;
            this.f9959b.set(pointFMo8854g2.x - COUIBaseListPopupWindow_12, (pointFMo8854g2.y + f2) - f4, (pointFMo8854g2.x - COUIBaseListPopupWindow_12) + f4, pointFMo8854g2.y + f2);
            this.f9958a.arcTo(this.f9959b, 90.0f, 90.0f, false);
        }
        this.f9958a.lineTo(pointFMo8854g2.x - COUIBaseListPopupWindow_12, (pointFMo8854g2.y - f2) + fM8861i);
        if (fM8861i > 0.0f) {
            float f5 = fM8861i * 2.0f;
            this.f9959b.set(pointFMo8854g2.x - COUIBaseListPopupWindow_12, pointFMo8854g2.y - f2, (pointFMo8854g2.x - COUIBaseListPopupWindow_12) + f5, (pointFMo8854g2.y - f2) + f5);
            this.f9958a.arcTo(this.f9959b, 180.0f, 90.0f, false);
        }
        this.f9958a.lineTo((pointFMo8854g2.x + COUIBaseListPopupWindow_12) - fM8861i, pointFMo8854g2.y - f2);
        if (fM8861i > 0.0f) {
            float f6 = fM8861i * 2.0f;
            this.f9959b.set((pointFMo8854g2.x + COUIBaseListPopupWindow_12) - f6, pointFMo8854g2.y - f2, pointFMo8854g2.x + COUIBaseListPopupWindow_12, (pointFMo8854g2.y - f2) + f6);
            this.f9958a.arcTo(this.f9959b, 270.0f, 90.0f, false);
        }
        this.f9958a.close();
        this.f9966i.m8814a(this.f9958a);
        this.f9967j = true;
        return this.f9958a;
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8809a(KeyPath c2357f, int OplusGLSurfaceView_13, List<KeyPath> list, KeyPath c2357f2) {
        MiscUtils.m9281a(c2357f, OplusGLSurfaceView_13, list, c2357f2, this);
    }
}

package com.oplus.anim.p111a.p112a;

import android.graphics.Path;
import android.graphics.PointF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.InterfaceC2361d;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p115c.KeyPath;
import com.oplus.anim.p115c.p117b.CircleShape;
import com.oplus.anim.p115c.p117b.ShapeTrimPath;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.MiscUtils;
import com.oplus.anim.p122g.EffectiveValueCallback;
import java.util.List;

/* compiled from: EllipseContent.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class EllipseContent implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.PlatformImplementations.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f9891b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final EffectiveAnimationDrawable f9892c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final BaseKeyframeAnimation<?, PointF> f9893d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final BaseKeyframeAnimation<?, PointF> f9894e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final CircleShape f9895f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f9897h;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Path f9890a = new Path();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CompoundTrimPathContent f9896g = new CompoundTrimPathContent();

    public EllipseContent(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a, CircleShape c2329a) {
        this.f9891b = c2329a.m8973a();
        this.f9892c = c2309b;
        this.f9893d = c2329a.m8975c().mo8957a();
        this.f9894e = c2329a.m8974b().mo8957a();
        this.f9895f = c2329a;
        abstractC2347a.m9082a(this.f9893d);
        abstractC2347a.m9082a(this.f9894e);
        this.f9893d.m8847a(this);
        this.f9894e.m8847a(this);
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8806a() {
        m8822c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m8822c() {
        this.f9897h = false;
        this.f9892c.invalidateSelf();
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8811a(List<Content> list, List<Content> list2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            Content interfaceC2276c = list.get(OplusGLSurfaceView_13);
            if (interfaceC2276c instanceof TrimPathContent) {
                TrimPathContent c2292s = (TrimPathContent) interfaceC2276c;
                if (c2292s.m8838c() == ShapeTrimPath.PlatformImplementations.kt_3.SIMULTANEOUSLY) {
                    this.f9896g.m8815a(c2292s);
                    c2292s.m8837a(this);
                }
            }
        }
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo8816b() {
        return this.f9891b;
    }

    @Override // com.oplus.anim.p111a.p112a.PathContent
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Path mo8821e() {
        if (this.f9897h) {
            return this.f9890a;
        }
        this.f9890a.reset();
        if (this.f9895f.m8977e()) {
            this.f9897h = true;
            return this.f9890a;
        }
        PointF pointFMo8854g = this.f9893d.mo8854g();
        float COUIBaseListPopupWindow_12 = pointFMo8854g.x / 2.0f;
        float f2 = pointFMo8854g.y / 2.0f;
        float f3 = COUIBaseListPopupWindow_12 * 0.55228f;
        float f4 = 0.55228f * f2;
        this.f9890a.reset();
        if (this.f9895f.m8976d()) {
            float f5 = -f2;
            this.f9890a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -COUIBaseListPopupWindow_12;
            float f8 = 0.0f - f4;
            this.f9890a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.f9890a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.f9890a.cubicTo(f10, f2, COUIBaseListPopupWindow_12, f9, COUIBaseListPopupWindow_12, 0.0f);
            this.f9890a.cubicTo(COUIBaseListPopupWindow_12, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.f9890a.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.f9890a.cubicTo(f12, f11, COUIBaseListPopupWindow_12, f13, COUIBaseListPopupWindow_12, 0.0f);
            float f14 = f4 + 0.0f;
            this.f9890a.cubicTo(COUIBaseListPopupWindow_12, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -COUIBaseListPopupWindow_12;
            this.f9890a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.f9890a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFMo8854g2 = this.f9894e.mo8854g();
        this.f9890a.offset(pointFMo8854g2.x, pointFMo8854g2.y);
        this.f9890a.close();
        this.f9896g.m8814a(this.f9890a);
        this.f9897h = true;
        return this.f9890a;
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8809a(KeyPath c2357f, int OplusGLSurfaceView_13, List<KeyPath> list, KeyPath c2357f2) {
        MiscUtils.m9281a(c2357f, OplusGLSurfaceView_13, list, c2357f2, this);
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo8810a(T t, EffectiveValueCallback<T> c2412b) {
        if (t == InterfaceC2361d.f10325g) {
            this.f9893d.m8848a((EffectiveValueCallback<PointF>) c2412b);
        } else if (t == InterfaceC2361d.f10326h) {
            this.f9894e.m8848a((EffectiveValueCallback<PointF>) c2412b);
        }
    }
}

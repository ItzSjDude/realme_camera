package com.oplus.anim.p111a.p112a;

import android.graphics.Path;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p115c.p117b.ShapePath;
import com.oplus.anim.p115c.p117b.ShapeTrimPath;
import com.oplus.anim.p115c.p118c.BaseLayer;
import java.util.List;

/* compiled from: ShapeContent.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.q */
/* loaded from: classes2.dex */
public class ShapeContent implements PathContent, BaseKeyframeAnimation.PlatformImplementations.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f9979b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final boolean f9980c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final EffectiveAnimationDrawable f9981d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final BaseKeyframeAnimation<?, Path> f9982e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f9983f;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Path f9978a = new Path();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CompoundTrimPathContent f9984g = new CompoundTrimPathContent();

    public ShapeContent(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a, ShapePath c2343o) {
        this.f9979b = c2343o.m9043a();
        this.f9980c = c2343o.m9045c();
        this.f9981d = c2309b;
        this.f9982e = c2343o.m9044b().mo8957a();
        abstractC2347a.m9082a(this.f9982e);
        this.f9982e.m8847a(this);
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8806a() {
        m8836c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m8836c() {
        this.f9983f = false;
        this.f9981d.invalidateSelf();
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8811a(List<Content> list, List<Content> list2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            Content interfaceC2276c = list.get(OplusGLSurfaceView_13);
            if (interfaceC2276c instanceof TrimPathContent) {
                TrimPathContent c2292s = (TrimPathContent) interfaceC2276c;
                if (c2292s.m8838c() == ShapeTrimPath.PlatformImplementations.kt_3.SIMULTANEOUSLY) {
                    this.f9984g.m8815a(c2292s);
                    c2292s.m8837a(this);
                }
            }
        }
    }

    @Override // com.oplus.anim.p111a.p112a.PathContent
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Path mo8821e() {
        if (this.f9983f) {
            return this.f9978a;
        }
        this.f9978a.reset();
        if (this.f9980c) {
            this.f9983f = true;
            return this.f9978a;
        }
        this.f9978a.set(this.f9982e.mo8854g());
        this.f9978a.setFillType(Path.FillType.EVEN_ODD);
        this.f9984g.m8814a(this.f9978a);
        this.f9983f = true;
        return this.f9978a;
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo8816b() {
        return this.f9979b;
    }
}

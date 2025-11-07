package com.oplus.anim.p111a.p112a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.InterfaceC2361d;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.TransformKeyframeAnimation;
import com.oplus.anim.p115c.KeyPath;
import com.oplus.anim.p115c.p117b.Repeater;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.MiscUtils;
import com.oplus.anim.p122g.EffectiveValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* compiled from: RepeaterContent.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.p */
/* loaded from: classes2.dex */
public class RepeaterContent implements DrawingContent, GreedyContent, KeyPathElementContent, PathContent, BaseKeyframeAnimation.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Matrix f9968a = new Matrix();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Path f9969b = new Path();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final EffectiveAnimationDrawable f9970c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final BaseLayer f9971d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final String f9972e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final boolean f9973f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final BaseKeyframeAnimation<Float, Float> f9974g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final BaseKeyframeAnimation<Float, Float> f9975h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final TransformKeyframeAnimation f9976i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ContentGroup f9977j;

    public RepeaterContent(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a, Repeater c2339k) {
        this.f9970c = c2309b;
        this.f9971d = abstractC2347a;
        this.f9972e = c2339k.m9025a();
        this.f9973f = c2339k.m9029e();
        this.f9974g = c2339k.m9026b().mo8957a();
        abstractC2347a.m9082a(this.f9974g);
        this.f9974g.m8847a(this);
        this.f9975h = c2339k.m9027c().mo8957a();
        abstractC2347a.m9082a(this.f9975h);
        this.f9975h.m8847a(this);
        this.f9976i = c2339k.m9028d().m8972j();
        this.f9976i.m8882a(abstractC2347a);
        this.f9976i.m8881a(this);
    }

    @Override // com.oplus.anim.p111a.p112a.GreedyContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8829a(ListIterator<Content> listIterator) {
        if (this.f9977j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f9977j = new ContentGroup(this.f9970c, this.f9971d, "Repeater", this.f9973f, arrayList, null);
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo8816b() {
        return this.f9972e;
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8811a(List<Content> list, List<Content> list2) {
        this.f9977j.mo8811a(list, list2);
    }

    @Override // com.oplus.anim.p111a.p112a.PathContent
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Path mo8821e() {
        Path pathMo8821e = this.f9977j.mo8821e();
        this.f9969b.reset();
        float fFloatValue = this.f9974g.mo8854g().floatValue();
        float fFloatValue2 = this.f9975h.mo8854g().floatValue();
        for (int OplusGLSurfaceView_13 = ((int) fFloatValue) - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            this.f9968a.set(this.f9976i.m8884b(OplusGLSurfaceView_13 + fFloatValue2));
            this.f9969b.addPath(pathMo8821e, this.f9968a);
        }
        return this.f9969b;
    }

    @Override // com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8807a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        float fFloatValue = this.f9974g.mo8854g().floatValue();
        float fFloatValue2 = this.f9975h.mo8854g().floatValue();
        float fFloatValue3 = this.f9976i.m8885b().mo8854g().floatValue() / 100.0f;
        float fFloatValue4 = this.f9976i.m8886c().mo8854g().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.f9968a.set(matrix);
            float COUIBaseListPopupWindow_12 = i2;
            this.f9968a.preConcat(this.f9976i.m8884b(COUIBaseListPopupWindow_12 + fFloatValue2));
            this.f9977j.mo8807a(canvas, this.f9968a, (int) (OplusGLSurfaceView_13 * MiscUtils.m9274a(fFloatValue3, fFloatValue4, COUIBaseListPopupWindow_12 / fFloatValue)));
        }
    }

    @Override // com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8808a(RectF rectF, Matrix matrix, boolean z) {
        this.f9977j.mo8808a(rectF, matrix, z);
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8806a() {
        this.f9970c.invalidateSelf();
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8809a(KeyPath c2357f, int OplusGLSurfaceView_13, List<KeyPath> list, KeyPath c2357f2) {
        MiscUtils.m9281a(c2357f, OplusGLSurfaceView_13, list, c2357f2, this);
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo8810a(T t, EffectiveValueCallback<T> c2412b) {
        if (this.f9976i.m8883a(t, c2412b)) {
            return;
        }
        if (t == InterfaceC2361d.f10333o) {
            this.f9974g.m8848a((EffectiveValueCallback<Float>) c2412b);
        } else if (t == InterfaceC2361d.f10334p) {
            this.f9975h.m8848a((EffectiveValueCallback<Float>) c2412b);
        }
    }
}

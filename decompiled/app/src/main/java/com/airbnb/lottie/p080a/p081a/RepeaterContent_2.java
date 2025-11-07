package com.airbnb.lottie.p080a.p081a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.TransformKeyframeAnimation_2;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p084c.p086b.Repeater_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import com.airbnb.lottie.p091f.MiscUtils_2;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* compiled from: RepeaterContent.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.p */
/* loaded from: classes.dex */
public class RepeaterContent_2 implements DrawingContent_2, GreedyContent_2, KeyPathElementContent_2, PathContent_2, BaseKeyframeAnimation_3.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Matrix f5375a = new Matrix();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Path f5376b = new Path();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final LottieDrawable f5377c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final BaseLayer_3 f5378d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final String f5379e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final boolean f5380f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final BaseKeyframeAnimation_3<Float, Float> f5381g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final BaseKeyframeAnimation_3<Float, Float> f5382h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final TransformKeyframeAnimation_2 f5383i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ContentGroup_2 f5384j;

    public RepeaterContent_2(LottieDrawable c1187f, BaseLayer_3 abstractC1122a, Repeater_2 c1114k) {
        this.f5377c = c1187f;
        this.f5378d = abstractC1122a;
        this.f5379e = c1114k.m5714a();
        this.f5380f = c1114k.m5718e();
        this.f5381g = c1114k.m5715b().mo5647a();
        abstractC1122a.m5774a(this.f5381g);
        this.f5381g.m5576a(this);
        this.f5382h = c1114k.m5716c().mo5647a();
        abstractC1122a.m5774a(this.f5382h);
        this.f5382h.m5576a(this);
        this.f5383i = c1114k.m5717d().m5661j();
        this.f5383i.m5621a(abstractC1122a);
        this.f5383i.m5620a(this);
    }

    @Override // com.airbnb.lottie.p080a.p081a.GreedyContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5556a(ListIterator<Content_2> listIterator) {
        if (this.f5384j != null) {
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
        this.f5384j = new ContentGroup_2(this.f5377c, this.f5378d, "Repeater", this.f5380f, arrayList, null);
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo5540b() {
        return this.f5379e;
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5535a(List<Content_2> list, List<Content_2> list2) {
        this.f5384j.mo5535a(list, list2);
    }

    @Override // com.airbnb.lottie.p080a.p081a.PathContent_2
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Path mo5546e() {
        Path pathMo5546e = this.f5384j.mo5546e();
        this.f5376b.reset();
        float fFloatValue = this.f5381g.mo5583g().floatValue();
        float fFloatValue2 = this.f5382h.mo5583g().floatValue();
        for (int OplusGLSurfaceView_13 = ((int) fFloatValue) - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            this.f5375a.set(this.f5383i.m5623b(OplusGLSurfaceView_13 + fFloatValue2));
            this.f5376b.addPath(pathMo5546e, this.f5375a);
        }
        return this.f5376b;
    }

    @Override // com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5531a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        float fFloatValue = this.f5381g.mo5583g().floatValue();
        float fFloatValue2 = this.f5382h.mo5583g().floatValue();
        float fFloatValue3 = this.f5383i.m5624b().mo5583g().floatValue() / 100.0f;
        float fFloatValue4 = this.f5383i.m5625c().mo5583g().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.f5375a.set(matrix);
            float COUIBaseListPopupWindow_12 = i2;
            this.f5375a.preConcat(this.f5383i.m5623b(COUIBaseListPopupWindow_12 + fFloatValue2));
            this.f5384j.mo5531a(canvas, this.f5375a, (int) (OplusGLSurfaceView_13 * MiscUtils_2.m6127a(fFloatValue3, fFloatValue4, COUIBaseListPopupWindow_12 / fFloatValue)));
        }
    }

    @Override // com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5532a(RectF rectF, Matrix matrix, boolean z) {
        this.f5384j.mo5532a(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5530a() {
        this.f5377c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5533a(KeyPath_2 c1131e, int OplusGLSurfaceView_13, List<KeyPath_2> list, KeyPath_2 c1131e2) {
        MiscUtils_2.m6134a(c1131e, OplusGLSurfaceView_13, list, c1131e2, this);
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        if (this.f5383i.m5622a(t, c1199c)) {
            return;
        }
        if (t == InterfaceC1205k.f5946s) {
            this.f5381g.m5577a((LottieValueCallback<Float>) c1199c);
        } else if (t == InterfaceC1205k.f5947t) {
            this.f5382h.m5577a((LottieValueCallback<Float>) c1199c);
        }
    }
}

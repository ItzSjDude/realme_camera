package com.airbnb.lottie.p080a.p081a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.ColorKeyframeAnimation_2;
import com.airbnb.lottie.p080a.p082b.ValueCallbackKeyframeAnimation_2;
import com.airbnb.lottie.p084c.p086b.ShapeStroke_5;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import com.airbnb.lottie.p092g.LottieValueCallback;

/* compiled from: StrokeContent.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.r */
/* loaded from: classes.dex */
public class StrokeContent_2 extends BaseStrokeContent_3 {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final BaseLayer_3 f5392c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final String f5393d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean f5394e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final BaseKeyframeAnimation_3<Integer, Integer> f5395f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private BaseKeyframeAnimation_3<ColorFilter, ColorFilter> f5396g;

    public StrokeContent_2(LottieDrawable c1187f, BaseLayer_3 abstractC1122a, ShapeStroke_5 c1119p) {
        super(c1187f, abstractC1122a, c1119p.m5741g().toPaintCap(), c1119p.m5742h().toPaintJoin(), c1119p.m5743i(), c1119p.m5737c(), c1119p.m5738d(), c1119p.m5739e(), c1119p.m5740f());
        this.f5392c = abstractC1122a;
        this.f5393d = c1119p.m5735a();
        this.f5394e = c1119p.m5744j();
        this.f5395f = c1119p.m5736b().mo5647a();
        this.f5395f.m5576a(this);
        abstractC1122a.m5774a(this.f5395f);
    }

    @Override // com.airbnb.lottie.p080a.p081a.BaseStrokeContent_3, com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5531a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        if (this.f5394e) {
            return;
        }
        this.f5269b.setColor(((ColorKeyframeAnimation_2) this.f5395f).m5594i());
        if (this.f5396g != null) {
            this.f5269b.setColorFilter(this.f5396g.mo5583g());
        }
        super.mo5531a(canvas, matrix, OplusGLSurfaceView_13);
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo5540b() {
        return this.f5393d;
    }

    @Override // com.airbnb.lottie.p080a.p081a.BaseStrokeContent_3, com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        super.mo5534a((StrokeContent_2) t, (LottieValueCallback<StrokeContent_2>) c1199c);
        if (t == InterfaceC1205k.f5929b) {
            this.f5395f.m5577a((LottieValueCallback<Integer>) c1199c);
            return;
        }
        if (t == InterfaceC1205k.f5926E) {
            BaseKeyframeAnimation_3<ColorFilter, ColorFilter> abstractC1068a = this.f5396g;
            if (abstractC1068a != null) {
                this.f5392c.m5778b(abstractC1068a);
            }
            if (c1199c == null) {
                this.f5396g = null;
                return;
            }
            this.f5396g = new ValueCallbackKeyframeAnimation_2(c1199c);
            this.f5396g.m5576a(this);
            this.f5392c.m5774a(this.f5395f);
        }
    }
}

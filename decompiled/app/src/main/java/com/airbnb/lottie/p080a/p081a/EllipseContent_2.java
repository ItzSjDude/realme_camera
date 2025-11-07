package com.airbnb.lottie.p080a.p081a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p084c.p086b.CircleShape_2;
import com.airbnb.lottie.p084c.p086b.ShapeTrimPath_3;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import com.airbnb.lottie.p091f.MiscUtils_2;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.List;

/* compiled from: EllipseContent.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class EllipseContent_2 implements KeyPathElementContent_2, PathContent_2, BaseKeyframeAnimation_3.PlatformImplementations.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f5297b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final LottieDrawable f5298c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final BaseKeyframeAnimation_3<?, PointF> f5299d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final BaseKeyframeAnimation_3<?, PointF> f5300e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final CircleShape_2 f5301f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f5303h;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Path f5296a = new Path();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CompoundTrimPathContent_2 f5302g = new CompoundTrimPathContent_2();

    public EllipseContent_2(LottieDrawable c1187f, BaseLayer_3 abstractC1122a, CircleShape_2 c1104a) {
        this.f5297b = c1104a.m5662a();
        this.f5298c = c1187f;
        this.f5299d = c1104a.m5664c().mo5647a();
        this.f5300e = c1104a.m5663b().mo5647a();
        this.f5301f = c1104a;
        abstractC1122a.m5774a(this.f5299d);
        abstractC1122a.m5774a(this.f5300e);
        this.f5299d.m5576a(this);
        this.f5300e.m5576a(this);
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5530a() {
        m5547c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m5547c() {
        this.f5303h = false;
        this.f5298c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5535a(List<Content_2> list, List<Content_2> list2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            Content_2 interfaceC1051c = list.get(OplusGLSurfaceView_13);
            if (interfaceC1051c instanceof TrimPathContent_2) {
                TrimPathContent_2 c1067s = (TrimPathContent_2) interfaceC1051c;
                if (c1067s.m5565c() == ShapeTrimPath_3.PlatformImplementations.kt_3.SIMULTANEOUSLY) {
                    this.f5302g.m5539a(c1067s);
                    c1067s.m5564a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo5540b() {
        return this.f5297b;
    }

    @Override // com.airbnb.lottie.p080a.p081a.PathContent_2
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Path mo5546e() {
        if (this.f5303h) {
            return this.f5296a;
        }
        this.f5296a.reset();
        if (this.f5301f.m5666e()) {
            this.f5303h = true;
            return this.f5296a;
        }
        PointF pointFMo5583g = this.f5299d.mo5583g();
        float COUIBaseListPopupWindow_12 = pointFMo5583g.x / 2.0f;
        float f2 = pointFMo5583g.y / 2.0f;
        float f3 = COUIBaseListPopupWindow_12 * 0.55228f;
        float f4 = 0.55228f * f2;
        this.f5296a.reset();
        if (this.f5301f.m5665d()) {
            float f5 = -f2;
            this.f5296a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -COUIBaseListPopupWindow_12;
            float f8 = 0.0f - f4;
            this.f5296a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.f5296a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.f5296a.cubicTo(f10, f2, COUIBaseListPopupWindow_12, f9, COUIBaseListPopupWindow_12, 0.0f);
            this.f5296a.cubicTo(COUIBaseListPopupWindow_12, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.f5296a.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.f5296a.cubicTo(f12, f11, COUIBaseListPopupWindow_12, f13, COUIBaseListPopupWindow_12, 0.0f);
            float f14 = f4 + 0.0f;
            this.f5296a.cubicTo(COUIBaseListPopupWindow_12, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -COUIBaseListPopupWindow_12;
            this.f5296a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.f5296a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFMo5583g2 = this.f5300e.mo5583g();
        this.f5296a.offset(pointFMo5583g2.x, pointFMo5583g2.y);
        this.f5296a.close();
        this.f5302g.m5538a(this.f5296a);
        this.f5303h = true;
        return this.f5296a;
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5533a(KeyPath_2 c1131e, int OplusGLSurfaceView_13, List<KeyPath_2> list, KeyPath_2 c1131e2) {
        MiscUtils_2.m6134a(c1131e, OplusGLSurfaceView_13, list, c1131e2, this);
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        if (t == InterfaceC1205k.f5936i) {
            this.f5299d.m5577a((LottieValueCallback<PointF>) c1199c);
        } else if (t == InterfaceC1205k.f5939l) {
            this.f5300e.m5577a((LottieValueCallback<PointF>) c1199c);
        }
    }
}

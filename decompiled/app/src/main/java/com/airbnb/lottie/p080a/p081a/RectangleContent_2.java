package com.airbnb.lottie.p080a.p081a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.FloatKeyframeAnimation_2;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p084c.p086b.RectangleShape_2;
import com.airbnb.lottie.p084c.p086b.ShapeTrimPath_3;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import com.airbnb.lottie.p091f.MiscUtils_2;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.List;

/* compiled from: RectangleContent.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.o */
/* loaded from: classes.dex */
public class RectangleContent_2 implements KeyPathElementContent_2, PathContent_2, BaseKeyframeAnimation_3.PlatformImplementations.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final String f5367c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final boolean f5368d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final LottieDrawable f5369e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final BaseKeyframeAnimation_3<?, PointF> f5370f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final BaseKeyframeAnimation_3<?, PointF> f5371g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final BaseKeyframeAnimation_3<?, Float> f5372h;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f5374j;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Path f5365a = new Path();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final RectF f5366b = new RectF();

    /* renamed from: OplusGLSurfaceView_13 */
    private CompoundTrimPathContent_2 f5373i = new CompoundTrimPathContent_2();

    public RectangleContent_2(LottieDrawable c1187f, BaseLayer_3 abstractC1122a, RectangleShape_2 c1113j) {
        this.f5367c = c1113j.m5709a();
        this.f5368d = c1113j.m5713e();
        this.f5369e = c1187f;
        this.f5370f = c1113j.m5712d().mo5647a();
        this.f5371g = c1113j.m5711c().mo5647a();
        this.f5372h = c1113j.m5710b().mo5647a();
        abstractC1122a.m5774a(this.f5370f);
        abstractC1122a.m5774a(this.f5371g);
        abstractC1122a.m5774a(this.f5372h);
        this.f5370f.m5576a(this);
        this.f5371g.m5576a(this);
        this.f5372h.m5576a(this);
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo5540b() {
        return this.f5367c;
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5530a() {
        m5562c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m5562c() {
        this.f5374j = false;
        this.f5369e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5535a(List<Content_2> list, List<Content_2> list2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            Content_2 interfaceC1051c = list.get(OplusGLSurfaceView_13);
            if (interfaceC1051c instanceof TrimPathContent_2) {
                TrimPathContent_2 c1067s = (TrimPathContent_2) interfaceC1051c;
                if (c1067s.m5565c() == ShapeTrimPath_3.PlatformImplementations.kt_3.SIMULTANEOUSLY) {
                    this.f5373i.m5539a(c1067s);
                    c1067s.m5564a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.p080a.p081a.PathContent_2
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Path mo5546e() {
        if (this.f5374j) {
            return this.f5365a;
        }
        this.f5365a.reset();
        if (this.f5368d) {
            this.f5374j = true;
            return this.f5365a;
        }
        PointF pointFMo5583g = this.f5371g.mo5583g();
        float COUIBaseListPopupWindow_12 = pointFMo5583g.x / 2.0f;
        float f2 = pointFMo5583g.y / 2.0f;
        BaseKeyframeAnimation_3<?, Float> abstractC1068a = this.f5372h;
        float fM5597i = abstractC1068a == null ? 0.0f : ((FloatKeyframeAnimation_2) abstractC1068a).m5597i();
        float fMin = Math.min(COUIBaseListPopupWindow_12, f2);
        if (fM5597i > fMin) {
            fM5597i = fMin;
        }
        PointF pointFMo5583g2 = this.f5370f.mo5583g();
        this.f5365a.moveTo(pointFMo5583g2.x + COUIBaseListPopupWindow_12, (pointFMo5583g2.y - f2) + fM5597i);
        this.f5365a.lineTo(pointFMo5583g2.x + COUIBaseListPopupWindow_12, (pointFMo5583g2.y + f2) - fM5597i);
        if (fM5597i > 0.0f) {
            float f3 = fM5597i * 2.0f;
            this.f5366b.set((pointFMo5583g2.x + COUIBaseListPopupWindow_12) - f3, (pointFMo5583g2.y + f2) - f3, pointFMo5583g2.x + COUIBaseListPopupWindow_12, pointFMo5583g2.y + f2);
            this.f5365a.arcTo(this.f5366b, 0.0f, 90.0f, false);
        }
        this.f5365a.lineTo((pointFMo5583g2.x - COUIBaseListPopupWindow_12) + fM5597i, pointFMo5583g2.y + f2);
        if (fM5597i > 0.0f) {
            float f4 = fM5597i * 2.0f;
            this.f5366b.set(pointFMo5583g2.x - COUIBaseListPopupWindow_12, (pointFMo5583g2.y + f2) - f4, (pointFMo5583g2.x - COUIBaseListPopupWindow_12) + f4, pointFMo5583g2.y + f2);
            this.f5365a.arcTo(this.f5366b, 90.0f, 90.0f, false);
        }
        this.f5365a.lineTo(pointFMo5583g2.x - COUIBaseListPopupWindow_12, (pointFMo5583g2.y - f2) + fM5597i);
        if (fM5597i > 0.0f) {
            float f5 = fM5597i * 2.0f;
            this.f5366b.set(pointFMo5583g2.x - COUIBaseListPopupWindow_12, pointFMo5583g2.y - f2, (pointFMo5583g2.x - COUIBaseListPopupWindow_12) + f5, (pointFMo5583g2.y - f2) + f5);
            this.f5365a.arcTo(this.f5366b, 180.0f, 90.0f, false);
        }
        this.f5365a.lineTo((pointFMo5583g2.x + COUIBaseListPopupWindow_12) - fM5597i, pointFMo5583g2.y - f2);
        if (fM5597i > 0.0f) {
            float f6 = fM5597i * 2.0f;
            this.f5366b.set((pointFMo5583g2.x + COUIBaseListPopupWindow_12) - f6, pointFMo5583g2.y - f2, pointFMo5583g2.x + COUIBaseListPopupWindow_12, (pointFMo5583g2.y - f2) + f6);
            this.f5365a.arcTo(this.f5366b, 270.0f, 90.0f, false);
        }
        this.f5365a.close();
        this.f5373i.m5538a(this.f5365a);
        this.f5374j = true;
        return this.f5365a;
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5533a(KeyPath_2 c1131e, int OplusGLSurfaceView_13, List<KeyPath_2> list, KeyPath_2 c1131e2) {
        MiscUtils_2.m6134a(c1131e, OplusGLSurfaceView_13, list, c1131e2, this);
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        if (t == InterfaceC1205k.f5937j) {
            this.f5371g.m5577a((LottieValueCallback<PointF>) c1199c);
        } else if (t == InterfaceC1205k.f5939l) {
            this.f5370f.m5577a((LottieValueCallback<PointF>) c1199c);
        } else if (t == InterfaceC1205k.f5938k) {
            this.f5372h.m5577a((LottieValueCallback<Float>) c1199c);
        }
    }
}

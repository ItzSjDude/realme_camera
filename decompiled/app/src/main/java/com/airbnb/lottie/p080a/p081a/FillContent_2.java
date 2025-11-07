package com.airbnb.lottie.p080a.p081a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.L_2;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.p080a.LPaint_2;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.ColorKeyframeAnimation_2;
import com.airbnb.lottie.p080a.p082b.ValueCallbackKeyframeAnimation_2;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p084c.p086b.ShapeFill_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import com.airbnb.lottie.p091f.MiscUtils_2;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class FillContent_2 implements DrawingContent_2, KeyPathElementContent_2, BaseKeyframeAnimation_3.PlatformImplementations.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final BaseLayer_3 f5306c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final String f5307d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean f5308e;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final BaseKeyframeAnimation_3<Integer, Integer> f5310g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final BaseKeyframeAnimation_3<Integer, Integer> f5311h;

    /* renamed from: OplusGLSurfaceView_13 */
    private BaseKeyframeAnimation_3<ColorFilter, ColorFilter> f5312i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final LottieDrawable f5313j;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Path f5304a = new Path();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Paint f5305b = new LPaint_2(1);

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final List<PathContent_2> f5309f = new ArrayList();

    public FillContent_2(LottieDrawable c1187f, BaseLayer_3 abstractC1122a, ShapeFill_2 c1116m) {
        this.f5306c = abstractC1122a;
        this.f5307d = c1116m.m5724a();
        this.f5308e = c1116m.m5728e();
        this.f5313j = c1187f;
        if (c1116m.m5725b() == null || c1116m.m5726c() == null) {
            this.f5310g = null;
            this.f5311h = null;
            return;
        }
        this.f5304a.setFillType(c1116m.m5727d());
        this.f5310g = c1116m.m5725b().mo5647a();
        this.f5310g.m5576a(this);
        abstractC1122a.m5774a(this.f5310g);
        this.f5311h = c1116m.m5726c().mo5647a();
        this.f5311h.m5576a(this);
        abstractC1122a.m5774a(this.f5311h);
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5530a() {
        this.f5313j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5535a(List<Content_2> list, List<Content_2> list2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list2.size(); OplusGLSurfaceView_13++) {
            Content_2 interfaceC1051c = list2.get(OplusGLSurfaceView_13);
            if (interfaceC1051c instanceof PathContent_2) {
                this.f5309f.add((PathContent_2) interfaceC1051c);
            }
        }
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo5540b() {
        return this.f5307d;
    }

    @Override // com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5531a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        if (this.f5308e) {
            return;
        }
        L_2.m5637a("FillContent#draw");
        this.f5305b.setColor(((ColorKeyframeAnimation_2) this.f5310g).m5594i());
        this.f5305b.setAlpha(MiscUtils_2.m6131a((int) ((((OplusGLSurfaceView_13 / 255.0f) * this.f5311h.mo5583g().intValue()) / 100.0f) * 255.0f), 0, 255));
        BaseKeyframeAnimation_3<ColorFilter, ColorFilter> abstractC1068a = this.f5312i;
        if (abstractC1068a != null) {
            this.f5305b.setColorFilter(abstractC1068a.mo5583g());
        }
        this.f5304a.reset();
        for (int i2 = 0; i2 < this.f5309f.size(); i2++) {
            this.f5304a.addPath(this.f5309f.get(i2).mo5546e(), matrix);
        }
        canvas.drawPath(this.f5304a, this.f5305b);
        L_2.m5638b("FillContent#draw");
    }

    @Override // com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5532a(RectF rectF, Matrix matrix, boolean z) {
        this.f5304a.reset();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f5309f.size(); OplusGLSurfaceView_13++) {
            this.f5304a.addPath(this.f5309f.get(OplusGLSurfaceView_13).mo5546e(), matrix);
        }
        this.f5304a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5533a(KeyPath_2 c1131e, int OplusGLSurfaceView_13, List<KeyPath_2> list, KeyPath_2 c1131e2) {
        MiscUtils_2.m6134a(c1131e, OplusGLSurfaceView_13, list, c1131e2, this);
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        if (t == InterfaceC1205k.f5928a) {
            this.f5310g.m5577a((LottieValueCallback<Integer>) c1199c);
            return;
        }
        if (t == InterfaceC1205k.f5931d) {
            this.f5311h.m5577a((LottieValueCallback<Integer>) c1199c);
            return;
        }
        if (t == InterfaceC1205k.f5926E) {
            BaseKeyframeAnimation_3<ColorFilter, ColorFilter> abstractC1068a = this.f5312i;
            if (abstractC1068a != null) {
                this.f5306c.m5778b(abstractC1068a);
            }
            if (c1199c == null) {
                this.f5312i = null;
                return;
            }
            this.f5312i = new ValueCallbackKeyframeAnimation_2(c1199c);
            this.f5312i.m5576a(this);
            this.f5306c.m5774a(this.f5312i);
        }
    }
}

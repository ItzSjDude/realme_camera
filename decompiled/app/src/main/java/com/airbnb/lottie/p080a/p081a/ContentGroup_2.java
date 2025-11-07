package com.airbnb.lottie.p080a.p081a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.LPaint_2;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.TransformKeyframeAnimation_2;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p084c.KeyPathElement_2;
import com.airbnb.lottie.p084c.p085a.AnimatableTransform_2;
import com.airbnb.lottie.p084c.p086b.ShapeGroup_2;
import com.airbnb.lottie.p084c.p086b.ContentModel_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import com.airbnb.lottie.p091f.Utils_4;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContentGroup.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class ContentGroup_2 implements DrawingContent_2, PathContent_2, BaseKeyframeAnimation_3.PlatformImplementations.kt_3, KeyPathElement_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private Paint f5285a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private RectF f5286b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Matrix f5287c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Path f5288d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final RectF f5289e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final String f5290f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final boolean f5291g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final List<Content_2> f5292h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final LottieDrawable f5293i;

    /* renamed from: OplusGLSurfaceView_15 */
    private List<PathContent_2> f5294j;

    /* renamed from: OplusGLSurfaceView_5 */
    private TransformKeyframeAnimation_2 f5295k;

    /* renamed from: PlatformImplementations.kt_3 */
    private static List<Content_2> m5542a(LottieDrawable c1187f, BaseLayer_3 abstractC1122a, List<ContentModel_2> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            Content_2 interfaceC1051cMo5651a = list.get(OplusGLSurfaceView_13).mo5651a(c1187f, abstractC1122a);
            if (interfaceC1051cMo5651a != null) {
                arrayList.add(interfaceC1051cMo5651a);
            }
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static AnimatableTransform_2 m5541a(List<ContentModel_2> list) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            ContentModel_2 interfaceC1105b = list.get(OplusGLSurfaceView_13);
            if (interfaceC1105b instanceof AnimatableTransform_2) {
                return (AnimatableTransform_2) interfaceC1105b;
            }
        }
        return null;
    }

    public ContentGroup_2(LottieDrawable c1187f, BaseLayer_3 abstractC1122a, ShapeGroup_2 c1117n) {
        this(c1187f, abstractC1122a, c1117n.m5729a(), c1117n.m5731c(), m5542a(c1187f, abstractC1122a, c1117n.m5730b()), m5541a(c1117n.m5730b()));
    }

    ContentGroup_2(LottieDrawable c1187f, BaseLayer_3 abstractC1122a, String str, boolean z, List<Content_2> list, AnimatableTransform_2 c1100l) {
        this.f5285a = new LPaint_2();
        this.f5286b = new RectF();
        this.f5287c = new Matrix();
        this.f5288d = new Path();
        this.f5289e = new RectF();
        this.f5290f = str;
        this.f5293i = c1187f;
        this.f5291g = z;
        this.f5292h = list;
        if (c1100l != null) {
            this.f5295k = c1100l.m5661j();
            this.f5295k.m5621a(abstractC1122a);
            this.f5295k.m5620a(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content_2 interfaceC1051c = list.get(size);
            if (interfaceC1051c instanceof GreedyContent_2) {
                arrayList.add((GreedyContent_2) interfaceC1051c);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent_2) arrayList.get(size2)).mo5556a(list.listIterator(list.size()));
        }
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5530a() {
        this.f5293i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo5540b() {
        return this.f5290f;
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5535a(List<Content_2> list, List<Content_2> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f5292h.size());
        arrayList.addAll(list);
        for (int size = this.f5292h.size() - 1; size >= 0; size--) {
            Content_2 interfaceC1051c = this.f5292h.get(size);
            interfaceC1051c.mo5535a(arrayList, this.f5292h.subList(0, size));
            arrayList.add(interfaceC1051c);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    List<PathContent_2> m5544c() {
        if (this.f5294j == null) {
            this.f5294j = new ArrayList();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f5292h.size(); OplusGLSurfaceView_13++) {
                Content_2 interfaceC1051c = this.f5292h.get(OplusGLSurfaceView_13);
                if (interfaceC1051c instanceof PathContent_2) {
                    this.f5294j.add((PathContent_2) interfaceC1051c);
                }
            }
        }
        return this.f5294j;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    Matrix m5545d() {
        TransformKeyframeAnimation_2 c1082o = this.f5295k;
        if (c1082o != null) {
            return c1082o.m5626d();
        }
        this.f5287c.reset();
        return this.f5287c;
    }

    @Override // com.airbnb.lottie.p080a.p081a.PathContent_2
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Path mo5546e() {
        this.f5287c.reset();
        TransformKeyframeAnimation_2 c1082o = this.f5295k;
        if (c1082o != null) {
            this.f5287c.set(c1082o.m5626d());
        }
        this.f5288d.reset();
        if (this.f5291g) {
            return this.f5288d;
        }
        for (int size = this.f5292h.size() - 1; size >= 0; size--) {
            Content_2 interfaceC1051c = this.f5292h.get(size);
            if (interfaceC1051c instanceof PathContent_2) {
                this.f5288d.addPath(((PathContent_2) interfaceC1051c).mo5546e(), this.f5287c);
            }
        }
        return this.f5288d;
    }

    @Override // com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5531a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        if (this.f5291g) {
            return;
        }
        this.f5287c.set(matrix);
        TransformKeyframeAnimation_2 c1082o = this.f5295k;
        if (c1082o != null) {
            this.f5287c.preConcat(c1082o.m5626d());
            OplusGLSurfaceView_13 = (int) (((((this.f5295k.m5618a() == null ? 100 : this.f5295k.m5618a().mo5583g().intValue()) / 100.0f) * OplusGLSurfaceView_13) / 255.0f) * 255.0f);
        }
        boolean z = this.f5293i.m6060d() && m5543f() && OplusGLSurfaceView_13 != 255;
        if (z) {
            this.f5286b.set(0.0f, 0.0f, 0.0f, 0.0f);
            mo5532a(this.f5286b, this.f5287c, true);
            this.f5285a.setAlpha(OplusGLSurfaceView_13);
            Utils_4.m6145a(canvas, this.f5286b, this.f5285a);
        }
        if (z) {
            OplusGLSurfaceView_13 = 255;
        }
        for (int size = this.f5292h.size() - 1; size >= 0; size--) {
            Content_2 interfaceC1051c = this.f5292h.get(size);
            if (interfaceC1051c instanceof DrawingContent_2) {
                ((DrawingContent_2) interfaceC1051c).mo5531a(canvas, this.f5287c, OplusGLSurfaceView_13);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m5543f() {
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < this.f5292h.size(); i2++) {
            if ((this.f5292h.get(i2) instanceof DrawingContent_2) && (OplusGLSurfaceView_13 = OplusGLSurfaceView_13 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5532a(RectF rectF, Matrix matrix, boolean z) {
        this.f5287c.set(matrix);
        TransformKeyframeAnimation_2 c1082o = this.f5295k;
        if (c1082o != null) {
            this.f5287c.preConcat(c1082o.m5626d());
        }
        this.f5289e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f5292h.size() - 1; size >= 0; size--) {
            Content_2 interfaceC1051c = this.f5292h.get(size);
            if (interfaceC1051c instanceof DrawingContent_2) {
                ((DrawingContent_2) interfaceC1051c).mo5532a(this.f5289e, this.f5287c, z);
                rectF.union(this.f5289e);
            }
        }
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5533a(KeyPath_2 c1131e, int OplusGLSurfaceView_13, List<KeyPath_2> list, KeyPath_2 c1131e2) {
        if (c1131e.m5830a(mo5540b(), OplusGLSurfaceView_13) || "__container".equals(mo5540b())) {
            if (!"__container".equals(mo5540b())) {
                c1131e2 = c1131e2.m5828a(mo5540b());
                if (c1131e.m5832c(mo5540b(), OplusGLSurfaceView_13)) {
                    list.add(c1131e2.m5827a(this));
                }
            }
            if (c1131e.m5833d(mo5540b(), OplusGLSurfaceView_13)) {
                int iM5831b = OplusGLSurfaceView_13 + c1131e.m5831b(mo5540b(), OplusGLSurfaceView_13);
                for (int i2 = 0; i2 < this.f5292h.size(); i2++) {
                    Content_2 interfaceC1051c = this.f5292h.get(i2);
                    if (interfaceC1051c instanceof KeyPathElement_2) {
                        ((KeyPathElement_2) interfaceC1051c).mo5533a(c1131e, iM5831b, list, c1131e2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        TransformKeyframeAnimation_2 c1082o = this.f5295k;
        if (c1082o != null) {
            c1082o.m5622a(t, c1199c);
        }
    }
}

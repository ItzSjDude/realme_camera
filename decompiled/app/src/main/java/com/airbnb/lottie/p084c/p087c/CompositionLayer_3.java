package com.airbnb.lottie.p084c.p087c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L_2;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.ValueCallbackKeyframeAnimation_2;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p087c.Layer_4;
import com.airbnb.lottie.p091f.Utils_4;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CompositionLayer.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class CompositionLayer_3 extends BaseLayer_3 {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private BaseKeyframeAnimation_3<Float, Float> f5630e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final List<BaseLayer_3> f5631f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final RectF f5632g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final RectF f5633h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Paint f5634i;

    public CompositionLayer_3(LottieDrawable c1187f, Layer_4 c1125d, List<Layer_4> list, LottieComposition c1136d) {
        int OplusGLSurfaceView_13;
        BaseLayer_3 abstractC1122a;
        super(c1187f, c1125d);
        this.f5631f = new ArrayList();
        this.f5632g = new RectF();
        this.f5633h = new RectF();
        this.f5634i = new Paint();
        AnimatableFloatValue_2 c1090bM5806u = c1125d.m5806u();
        if (c1090bM5806u != null) {
            this.f5630e = c1090bM5806u.mo5647a();
            m5774a(this.f5630e);
            this.f5630e.m5576a(this);
        } else {
            this.f5630e = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(c1136d.m5856i().size());
        int size = list.size() - 1;
        BaseLayer_3 abstractC1122a2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer_4 c1125d2 = list.get(size);
            BaseLayer_3 abstractC1122aM5754a = BaseLayer_3.m5754a(c1125d2, c1187f, c1136d);
            if (abstractC1122aM5754a != null) {
                longSparseArray.put(abstractC1122aM5754a.m5781c().m5790e(), abstractC1122aM5754a);
                if (abstractC1122a2 != null) {
                    abstractC1122a2.m5775a(abstractC1122aM5754a);
                    abstractC1122a2 = null;
                } else {
                    this.f5631f.add(0, abstractC1122aM5754a);
                    int i2 = COUIBaseListPopupWindow_2.f5635a[c1125d2.m5797l().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        abstractC1122a2 = abstractC1122aM5754a;
                    }
                }
            }
            size--;
        }
        for (OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < longSparseArray.size(); OplusGLSurfaceView_13++) {
            BaseLayer_3 abstractC1122a3 = (BaseLayer_3) longSparseArray.get(longSparseArray.keyAt(OplusGLSurfaceView_13));
            if (abstractC1122a3 != null && (abstractC1122a = (BaseLayer_3) longSparseArray.get(abstractC1122a3.m5781c().m5798m())) != null) {
                abstractC1122a3.m5779b(abstractC1122a);
            }
        }
    }

    /* compiled from: CompositionLayer.java */
    /* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f5635a = new int[Layer_4.IntrinsicsJvm.kt_4.values().length];

        static {
            try {
                f5635a[Layer_4.IntrinsicsJvm.kt_4.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5635a[Layer_4.IntrinsicsJvm.kt_4.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5776a(boolean z) {
        super.mo5776a(z);
        Iterator<BaseLayer_3> it = this.f5631f.iterator();
        while (it.hasNext()) {
            it.next().mo5776a(z);
        }
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo5777b(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        L_2.m5637a("CompositionLayer#draw");
        this.f5633h.set(0.0f, 0.0f, this.f5604c.m5793h(), this.f5604c.m5794i());
        matrix.mapRect(this.f5633h);
        boolean z = this.f5603b.m6060d() && this.f5631f.size() > 1 && OplusGLSurfaceView_13 != 255;
        if (z) {
            this.f5634i.setAlpha(OplusGLSurfaceView_13);
            Utils_4.m6145a(canvas, this.f5633h, this.f5634i);
        } else {
            canvas.save();
        }
        if (z) {
            OplusGLSurfaceView_13 = 255;
        }
        for (int size = this.f5631f.size() - 1; size >= 0; size--) {
            if (!this.f5633h.isEmpty() ? canvas.clipRect(this.f5633h) : true) {
                this.f5631f.get(size).mo5531a(canvas, matrix, OplusGLSurfaceView_13);
            }
        }
        canvas.restore();
        L_2.m5638b("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3, com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5532a(RectF rectF, Matrix matrix, boolean z) {
        super.mo5532a(rectF, matrix, z);
        for (int size = this.f5631f.size() - 1; size >= 0; size--) {
            this.f5632g.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f5631f.get(size).mo5532a(this.f5632g, this.f5602a, true);
            rectF.union(this.f5632g);
        }
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5773a(float COUIBaseListPopupWindow_12) {
        super.mo5773a(COUIBaseListPopupWindow_12);
        if (this.f5630e != null) {
            COUIBaseListPopupWindow_12 = ((this.f5630e.mo5583g().floatValue() * this.f5604c.m5785a().m5855h()) - this.f5604c.m5785a().m5853f()) / (this.f5603b.m6080t().m5860m() + 0.01f);
        }
        if (this.f5630e == null) {
            COUIBaseListPopupWindow_12 -= this.f5604c.m5788c();
        }
        if (this.f5604c.m5787b() != 0.0f) {
            COUIBaseListPopupWindow_12 /= this.f5604c.m5787b();
        }
        for (int size = this.f5631f.size() - 1; size >= 0; size--) {
            this.f5631f.get(size).mo5773a(COUIBaseListPopupWindow_12);
        }
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo5780b(KeyPath_2 c1131e, int OplusGLSurfaceView_13, List<KeyPath_2> list, KeyPath_2 c1131e2) {
        for (int i2 = 0; i2 < this.f5631f.size(); i2++) {
            this.f5631f.get(i2).mo5533a(c1131e, OplusGLSurfaceView_13, list, c1131e2);
        }
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3, com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        super.mo5534a((CompositionLayer_3) t, (LottieValueCallback<CompositionLayer_3>) c1199c);
        if (t == InterfaceC1205k.f5924C) {
            if (c1199c == null) {
                BaseKeyframeAnimation_3<Float, Float> abstractC1068a = this.f5630e;
                if (abstractC1068a != null) {
                    abstractC1068a.m5577a((LottieValueCallback<Float>) null);
                    return;
                }
                return;
            }
            this.f5630e = new ValueCallbackKeyframeAnimation_2(c1199c);
            this.f5630e.m5576a(this);
            m5774a(this.f5630e);
        }
    }
}

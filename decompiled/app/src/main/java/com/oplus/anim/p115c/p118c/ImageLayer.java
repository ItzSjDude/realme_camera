package com.oplus.anim.p115c.p118c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.L;
import com.oplus.anim.InterfaceC2361d;
import com.oplus.anim.p111a.LPaint;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.ValueCallbackKeyframeAnimation;
import com.oplus.anim.p121f.Utils_2;
import com.oplus.anim.p122g.EffectiveValueCallback;

/* compiled from: ImageLayer.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class ImageLayer extends BaseLayer {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Paint f10253e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Rect f10254f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Rect f10255g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f10256h;

    ImageLayer(EffectiveAnimationDrawable c2309b, Layer c2350d) {
        super(c2309b, c2350d);
        this.f10253e = new LPaint(3);
        this.f10254f = new Rect();
        this.f10255g = new Rect();
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo9085b(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        Bitmap bitmapM9091f = m9091f();
        if (bitmapM9091f == null || bitmapM9091f.isRecycled()) {
            return;
        }
        float fM9288a = Utils_2.m9288a();
        L.m9349c("ImageLayer#draw");
        this.f10253e.setAlpha(OplusGLSurfaceView_13);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> abstractC2293a = this.f10256h;
        if (abstractC2293a != null) {
            this.f10253e.setColorFilter(abstractC2293a.mo8854g());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f10254f.set(0, 0, bitmapM9091f.getWidth(), bitmapM9091f.getHeight());
        this.f10255g.set(0, 0, (int) (bitmapM9091f.getWidth() * fM9288a), (int) (bitmapM9091f.getHeight() * fM9288a));
        canvas.drawBitmap(bitmapM9091f, this.f10254f, this.f10255g, this.f10253e);
        canvas.restore();
        L.m9350d("ImageLayer#draw");
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer, com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8808a(RectF rectF, Matrix matrix, boolean z) {
        super.mo8808a(rectF, matrix, z);
        if (m9091f() != null) {
            rectF.set(0.0f, 0.0f, r3.getWidth() * Utils_2.m9288a(), r3.getHeight() * Utils_2.m9288a());
            this.f10222a.mapRect(rectF);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Bitmap m9091f() {
        return this.f10223b.m8922e(this.f10224c.m9099g());
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer, com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo8810a(T t, EffectiveValueCallback<T> c2412b) {
        super.mo8810a((ImageLayer) t, (EffectiveValueCallback<ImageLayer>) c2412b);
        if (t == InterfaceC2361d.f10344z) {
            if (c2412b == null) {
                this.f10256h = null;
            } else {
                this.f10256h = new ValueCallbackKeyframeAnimation(c2412b);
            }
        }
    }
}

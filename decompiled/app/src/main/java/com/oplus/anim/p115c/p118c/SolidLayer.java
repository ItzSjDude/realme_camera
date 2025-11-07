package com.oplus.anim.p115c.p118c;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.L;
import com.oplus.anim.InterfaceC2361d;
import com.oplus.anim.p111a.LPaint;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.ValueCallbackKeyframeAnimation;
import com.oplus.anim.p122g.EffectiveValueCallback;

/* compiled from: SolidLayer.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class SolidLayer extends BaseLayer {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final RectF f10280e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Paint f10281f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final float[] f10282g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Path f10283h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final Layer f10284i;

    /* renamed from: OplusGLSurfaceView_15 */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f10285j;

    SolidLayer(EffectiveAnimationDrawable c2309b, Layer c2350d) {
        super(c2309b, c2350d);
        this.f10280e = new RectF();
        this.f10281f = new LPaint();
        this.f10282g = new float[8];
        this.f10283h = new Path();
        this.f10284i = c2350d;
        this.f10281f.setAlpha(0);
        this.f10281f.setStyle(Paint.Style.FILL);
        this.f10281f.setColor(c2350d.m9108p());
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo9085b(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        int iAlpha = Color.alpha(this.f10284i.m9108p());
        if (iAlpha == 0) {
            return;
        }
        L.m9349c("SolidLayer#draw");
        int iIntValue = (int) ((OplusGLSurfaceView_13 / 255.0f) * (((iAlpha / 255.0f) * (this.f10225d.m8879a() == null ? 100 : this.f10225d.m8879a().mo8854g().intValue())) / 100.0f) * 255.0f);
        this.f10281f.setAlpha(iIntValue);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> abstractC2293a = this.f10285j;
        if (abstractC2293a != null) {
            this.f10281f.setColorFilter(abstractC2293a.mo8854g());
        }
        if (iIntValue > 0) {
            float[] fArr = this.f10282g;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.f10284i.m9110r();
            float[] fArr2 = this.f10282g;
            fArr2[3] = 0.0f;
            fArr2[4] = this.f10284i.m9110r();
            this.f10282g[5] = this.f10284i.m9109q();
            float[] fArr3 = this.f10282g;
            fArr3[6] = 0.0f;
            fArr3[7] = this.f10284i.m9109q();
            matrix.mapPoints(this.f10282g);
            this.f10283h.reset();
            Path path = this.f10283h;
            float[] fArr4 = this.f10282g;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.f10283h;
            float[] fArr5 = this.f10282g;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.f10283h;
            float[] fArr6 = this.f10282g;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.f10283h;
            float[] fArr7 = this.f10282g;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.f10283h;
            float[] fArr8 = this.f10282g;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.f10283h.close();
            canvas.drawPath(this.f10283h, this.f10281f);
        }
        L.m9350d("SolidLayer#draw");
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer, com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8808a(RectF rectF, Matrix matrix, boolean z) {
        super.mo8808a(rectF, matrix, z);
        this.f10280e.set(0.0f, 0.0f, this.f10284i.m9110r(), this.f10284i.m9109q());
        this.f10222a.mapRect(this.f10280e);
        rectF.set(this.f10280e);
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer, com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo8810a(T t, EffectiveValueCallback<T> c2412b) {
        super.mo8810a((SolidLayer) t, (EffectiveValueCallback<SolidLayer>) c2412b);
        if (t == InterfaceC2361d.f10344z) {
            if (c2412b == null) {
                this.f10285j = null;
            } else {
                this.f10285j = new ValueCallbackKeyframeAnimation(c2412b);
            }
        }
    }
}

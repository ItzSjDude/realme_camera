package com.oplus.camera.p172ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.oplus.camera.R;
import java.lang.reflect.Array;

/* compiled from: HistogramView.java */
/* renamed from: com.oplus.camera.ui.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public class HistogramView extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f18865a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f18866b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float f18867c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f18868d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f18869e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f18870f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f18871g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f18872h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f18873i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f18874j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f18875k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float[][] f18876l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float[] f18877m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float[] f18878n;

    /* renamed from: o */
    private float[] f18879o;

    /* renamed from: p */
    private float f18880p;

    /* renamed from: q */
    private Bitmap f18881q;

    /* renamed from: r */
    private Paint f18882r;

    /* renamed from: s */
    private Paint f18883s;

    /* renamed from: t */
    private Paint f18884t;

    /* renamed from: u */
    private Paint f18885u;

    /* renamed from: v */
    private Paint f18886v;

    /* renamed from: w */
    private Paint f18887w;

    /* renamed from: x */
    private Paint f18888x;

    /* renamed from: y */
    private Paint f18889y;

    /* renamed from: z */
    private Interpolator f18890z;

    public HistogramView(Context context) {
        this(context, null);
    }

    public HistogramView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18865a = "HistogramView";
        this.f18866b = 0.0f;
        this.f18867c = 0.0f;
        this.f18868d = false;
        this.f18869e = 0;
        this.f18870f = 0;
        this.f18871g = 0;
        this.f18872h = false;
        this.f18873i = false;
        this.f18874j = 0.0f;
        this.f18875k = 0.0f;
        this.f18876l = (float[][]) Array.newInstance((Class<?>) float.class, 256, 3);
        this.f18877m = new float[256];
        this.f18878n = new float[256];
        this.f18879o = new float[256];
        this.f18880p = 0.0f;
        this.f18881q = null;
        this.f18882r = new Paint();
        this.f18883s = null;
        this.f18884t = null;
        this.f18885u = null;
        this.f18886v = null;
        this.f18887w = null;
        this.f18888x = null;
        this.f18889y = null;
        this.f18890z = null;
        m20271a();
        this.f18890z = AnimationUtils.loadInterpolator(getContext(), R.anim.accelerate_decelerate_path_interpolator);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20271a() {
        this.f18882r.setFlags(1);
        this.f18882r.setColor(-16777216);
        this.f18882r.setAlpha(0);
        this.f18883s = new Paint();
        this.f18883s.setColor(getResources().getColor(R.color.histogram_red));
        this.f18883s.setStyle(Paint.Style.FILL);
        this.f18884t = new Paint();
        this.f18884t.setColor(getResources().getColor(R.color.histogram_green));
        this.f18884t.setStyle(Paint.Style.FILL);
        this.f18885u = new Paint();
        this.f18885u.setColor(getResources().getColor(R.color.histogram_blue));
        this.f18885u.setStyle(Paint.Style.FILL);
        this.f18886v = new Paint();
        this.f18886v.setColor(getResources().getColor(R.color.histogram_rg_overlay_yellow));
        this.f18886v.setStyle(Paint.Style.FILL);
        this.f18887w = new Paint();
        this.f18887w.setColor(getResources().getColor(R.color.histogram_gb_overlay_cyan));
        this.f18887w.setStyle(Paint.Style.FILL);
        this.f18888x = new Paint();
        this.f18888x.setColor(getResources().getColor(R.color.histogram_rb_overlay_megenta));
        this.f18888x.setStyle(Paint.Style.FILL);
        this.f18889y = new Paint();
        this.f18889y.setColor(-1);
        this.f18889y.setStyle(Paint.Style.FILL);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20273a(float[] fArr, float[] fArr2, float[] fArr3, float COUIBaseListPopupWindow_12) {
        this.f18877m = fArr;
        this.f18878n = fArr2;
        this.f18879o = fArr3;
        this.f18880p = COUIBaseListPopupWindow_12;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f18881q = Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.RGB_565);
        this.f18874j = OplusGLSurfaceView_13;
        this.f18875k = i2;
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = this.f18881q;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f18882r);
            float COUIBaseListPopupWindow_12 = this.f18874j / 256.0f;
            float f2 = this.f18875k / (this.f18880p * 4.0f);
            int OplusGLSurfaceView_13 = 0;
            while (OplusGLSurfaceView_13 < 256) {
                int i2 = OplusGLSurfaceView_13 < 2 ? OplusGLSurfaceView_13 + 2 : OplusGLSurfaceView_13 > 253 ? OplusGLSurfaceView_13 - 2 : OplusGLSurfaceView_13;
                float fM20270a = m20270a(this.f18877m, i2);
                float fM20270a2 = m20270a(this.f18878n, i2);
                float fM20270a3 = m20270a(this.f18879o, i2);
                float[][] fArr = this.f18876l;
                fArr[OplusGLSurfaceView_13][0] = fM20270a * f2;
                fArr[OplusGLSurfaceView_13][1] = fM20270a2 * f2;
                fArr[OplusGLSurfaceView_13][2] = fM20270a3 * f2;
                float f3 = fArr[OplusGLSurfaceView_13][0];
                float f4 = this.f18875k;
                if (f3 > f4) {
                    fArr[OplusGLSurfaceView_13][0] = f4;
                }
                float[][] fArr2 = this.f18876l;
                float f5 = fArr2[OplusGLSurfaceView_13][1];
                float f6 = this.f18875k;
                if (f5 > f6) {
                    fArr2[OplusGLSurfaceView_13][1] = f6;
                }
                float[][] fArr3 = this.f18876l;
                float f7 = fArr3[OplusGLSurfaceView_13][2];
                float f8 = this.f18875k;
                if (f7 > f8) {
                    fArr3[OplusGLSurfaceView_13][2] = f8;
                }
                float f9 = COUIBaseListPopupWindow_12 * OplusGLSurfaceView_13;
                m20272a(canvas, f9, this.f18875k, f9 + ((COUIBaseListPopupWindow_12 * 4.0f) / 2.0f), this.f18876l[OplusGLSurfaceView_13]);
                OplusGLSurfaceView_13 += 4;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m20270a(float[] fArr, int OplusGLSurfaceView_13) {
        return ((((fArr[OplusGLSurfaceView_13 - 2] + fArr[OplusGLSurfaceView_13 - 1]) + fArr[OplusGLSurfaceView_13]) + fArr[OplusGLSurfaceView_13 + 1]) + fArr[OplusGLSurfaceView_13 + 2]) / 5.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20272a(Canvas canvas, float COUIBaseListPopupWindow_12, float f2, float f3, float[] fArr) {
        char c2 = fArr[0] > fArr[1] ? fArr[0] > fArr[2] ? fArr[1] > fArr[2] ? (char) 0 : (char) 1 : (char) 3 : fArr[0] > fArr[2] ? (char) 5 : fArr[1] > fArr[2] ? (char) 4 : (char) 2;
        if (c2 == 0) {
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[2], f3, f2, this.f18889y);
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[1], f3, f2 - fArr[2], this.f18886v);
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[0], f3, f2 - fArr[1], this.f18883s);
            return;
        }
        if (c2 == 1) {
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[1], f3, f2, this.f18889y);
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[2], f3, f2 - fArr[1], this.f18888x);
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[0], f3, f2 - fArr[2], this.f18883s);
            return;
        }
        if (c2 == 2) {
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[0], f3, f2, this.f18889y);
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[1], f3, f2 - fArr[0], this.f18887w);
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[2], f3, f2 - fArr[1], this.f18885u);
            return;
        }
        if (c2 == 3) {
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[1], f3, f2, this.f18889y);
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[0], f3, f2 - fArr[1], this.f18888x);
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[2], f3, f2 - fArr[0], this.f18885u);
        } else if (c2 == 4) {
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[0], f3, f2, this.f18889y);
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[2], f3, f2 - fArr[0], this.f18887w);
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[1], f3, f2 - fArr[2], this.f18884t);
        } else {
            if (c2 != 5) {
                return;
            }
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[2], f3, f2, this.f18889y);
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[0], f3, f2 - fArr[2], this.f18886v);
            canvas.drawRect(COUIBaseListPopupWindow_12, f2 - fArr[1], f3, f2 - fArr[0], this.f18884t);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f18873i) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f18868d = false;
                this.f18866b = rawX;
                this.f18867c = rawY;
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    int[] iArr = new int[2];
                    viewGroup.getLocationInWindow(iArr);
                    this.f18870f = viewGroup.getMeasuredHeight();
                    this.f18869e = viewGroup.getMeasuredWidth();
                    this.f18871g = iArr[0];
                }
            } else if (action != 1) {
                if (action == 2 && rawX >= 0.0f && rawX <= this.f18869e) {
                    if (rawY >= this.f18871g && rawY <= this.f18870f + r2) {
                        float COUIBaseListPopupWindow_12 = rawX - this.f18866b;
                        float f2 = rawY - this.f18867c;
                        if (!this.f18868d) {
                            if (Math.sqrt((COUIBaseListPopupWindow_12 * COUIBaseListPopupWindow_12) + (f2 * f2)) < 2.0d) {
                                this.f18868d = false;
                            } else {
                                this.f18868d = true;
                            }
                        }
                        float x = COUIBaseListPopupWindow_12 + getX();
                        float y = getY() + f2;
                        float width = this.f18869e - getWidth();
                        float height = this.f18870f - getHeight();
                        if (x < 0.0f) {
                            x = 0.0f;
                        } else if (x > width) {
                            x = width;
                        }
                        if (y < 0.0f) {
                            y = 0.0f;
                        } else if (y > height) {
                            y = height;
                        }
                        setX(x);
                        setY(y);
                        this.f18866b = rawX;
                        this.f18867c = rawY;
                    }
                }
            } else if (this.f18872h && this.f18868d) {
                if (this.f18866b <= this.f18869e / 2) {
                    animate().setInterpolator(this.f18890z).setDuration(500L).x(0.0f).start();
                } else {
                    animate().setInterpolator(this.f18890z).setDuration(500L).x(this.f18869e - getWidth()).start();
                }
            }
        }
        boolean z = this.f18868d;
        return z ? z : super.onTouchEvent(motionEvent);
    }
}

package com.oplus.camera.p169t;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: ScaleBar.java */
/* renamed from: com.oplus.camera.t.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ScaleBar extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private static int f16503a = 255;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int f16504b = (int) (f16503a * 0.5d);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int f16505c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static int f16506d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static int f16507e;

    /* renamed from: A */
    private Context f16508A;

    /* renamed from: B */
    private Paint f16509B;

    /* renamed from: C */
    private IntrinsicsJvm.kt_3 f16510C;

    /* renamed from: D */
    private VelocityTracker f16511D;

    /* renamed from: E */
    private IntrinsicsJvm.kt_4 f16512E;

    /* renamed from: F */
    private Handler f16513F;

    /* renamed from: G */
    private int f16514G;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f16515f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f16516g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16517h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f16518i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f16519j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f16520k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f16521l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f16522m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f16523n;

    /* renamed from: o */
    private int f16524o;

    /* renamed from: p */
    private int f16525p;

    /* renamed from: q */
    private int f16526q;

    /* renamed from: r */
    private int f16527r;

    /* renamed from: s */
    private int f16528s;

    /* renamed from: t */
    private int f16529t;

    /* renamed from: u */
    private int f16530u;

    /* renamed from: v */
    private float f16531v;

    /* renamed from: w */
    private boolean f16532w;

    /* renamed from: x */
    private boolean f16533x;

    /* renamed from: y */
    private boolean f16534y;

    /* renamed from: z */
    private boolean f16535z;

    /* compiled from: ScaleBar.java */
    /* renamed from: com.oplus.camera.t.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17239a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17240a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17241a(boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo17242b();
    }

    public ScaleBar(Context context, int OplusGLSurfaceView_13, Handler handler) {
        super(context);
        this.f16515f = 0;
        this.f16516g = 0;
        this.f16517h = 0;
        this.f16521l = 30;
        this.f16527r = 1;
        this.f16529t = 10;
        this.f16531v = 0.0f;
        this.f16535z = true;
        this.f16514G = -1;
        this.f16513F = handler;
        this.f16518i = OplusGLSurfaceView_13;
        this.f16508A = context;
        m17231c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17231c() {
        if (this.f16518i <= 0) {
            this.f16535z = false;
            return;
        }
        this.f16535z = true;
        Resources resources = this.f16508A.getResources();
        this.f16525p = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_big_scale_stroke_width);
        this.f16526q = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_small_scale_stroke_width);
        this.f16524o = resources.getDimensionPixelSize(R.dimen.professional_mode_level_panel_height) / 2;
        this.f16521l = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_margin);
        this.f16522m = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height);
        this.f16523n = resources.getDimensionPixelSize(R.dimen.street_mode_scale_bar_scale_pointer_height);
        this.f16525p = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_big_scale_stroke_width);
        f16505c = this.f16508A.getColor(R.color.camera_white);
        f16506d = resources.getColor(R.color.pointer_scale_color);
        f16507e = Util.m24164A(this.f16508A);
        this.f16509B = new Paint();
        this.f16509B.setAntiAlias(true);
        this.f16509B.setColor(f16505c);
        this.f16509B.setStyle(Paint.Style.FILL);
        this.f16509B.setStrokeWidth(this.f16526q);
        ViewConfiguration.get(this.f16508A);
        this.f16530u = ViewConfiguration.getMaximumFlingVelocity();
        int OplusGLSurfaceView_13 = this.f16518i;
        this.f16528s = OplusGLSurfaceView_13 % 2 == 0 ? (OplusGLSurfaceView_13 / 2) - 1 : OplusGLSurfaceView_13 / 2;
        if (this.f16528s < 0) {
            this.f16528s = 0;
        }
    }

    public void setCurrentIndex(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f16518i) {
            return;
        }
        this.f16517h = OplusGLSurfaceView_13;
    }

    public void setLevelNum(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("ScaleBar", "setLevelNum, levelNum: " + OplusGLSurfaceView_13);
        this.f16518i = OplusGLSurfaceView_13;
        if (this.f16535z) {
            int i2 = this.f16518i;
            this.f16528s = i2 % 2 == 0 ? (i2 / 2) - 1 : i2 / 2;
        } else {
            m17231c();
        }
    }

    public int getCurrentIndex() {
        return this.f16517h;
    }

    public void setScaleBarValueChangeListener(IntrinsicsJvm.kt_3 cVar) {
        this.f16510C = cVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f16535z) {
            if (1 == getLayoutDirection()) {
                canvas.scale(-1.0f, 1.0f, getWidth() / 2, getHeight() / 2);
            }
            this.f16509B.setColor(f16505c);
            int OplusGLSurfaceView_13 = this.f16524o;
            int i2 = this.f16522m;
            int i3 = (i2 / 2) + OplusGLSurfaceView_13;
            int i4 = OplusGLSurfaceView_13 - (i2 / 10);
            int i5 = this.f16527r == 2 ? this.f16528s % this.f16529t : 0;
            for (int i6 = 0; i6 < this.f16518i; i6++) {
                float fMax = Math.max((this.f16519j / 2) - ((Math.abs(this.f16517h - i6) + 1) * this.f16521l), 0) / (this.f16519j / 2);
                if (i6 % this.f16529t == i5 || i6 == this.f16514G) {
                    this.f16509B.setStrokeWidth(this.f16526q);
                    this.f16509B.setAlpha((int) (f16503a * fMax));
                } else {
                    this.f16509B.setStrokeWidth(this.f16526q);
                    this.f16509B.setAlpha((int) (f16504b * fMax));
                }
                int i7 = this.f16515f;
                int i8 = this.f16521l;
                canvas.drawLine((i8 * i6) + i7, i3, i7 + (i8 * i6), i4, this.f16509B);
            }
            int i9 = this.f16524o;
            int i10 = this.f16522m;
            int i11 = (i10 / 2) + i9;
            int i12 = i9 - (i10 / 2);
            if (this.f16532w) {
                this.f16509B.setColor(f16507e);
            } else {
                this.f16509B.setColor(f16506d);
            }
            this.f16509B.setAlpha(f16503a);
            this.f16509B.setStrokeWidth(this.f16525p);
            int i13 = this.f16520k;
            canvas.drawLine(i13, i11, i13, i12, this.f16509B);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f16531v = motionEvent.getX();
            this.f16511D = VelocityTracker.obtain();
            IntrinsicsJvm.kt_4 bVar = this.f16512E;
            if (bVar != null) {
                bVar.m17238a();
                this.f16512E = null;
            }
        } else if (action == 1) {
            float xVelocity = 0.0f;
            VelocityTracker velocityTracker = this.f16511D;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
                this.f16511D.computeCurrentVelocity(1000, this.f16530u);
                xVelocity = this.f16511D.getXVelocity();
                this.f16511D.clear();
            }
            if (Math.abs(xVelocity) >= 1000.0f) {
                if (1 == getLayoutDirection()) {
                    xVelocity = -xVelocity;
                }
                this.f16512E = new IntrinsicsJvm.kt_4(xVelocity);
                this.f16513F.post(this.f16512E);
            } else {
                m17233d();
                IntrinsicsJvm.kt_3 cVar = this.f16510C;
                if (cVar != null) {
                    cVar.mo17242b();
                }
            }
        } else if (action == 2) {
            float x = motionEvent.getX() - this.f16531v;
            this.f16531v = motionEvent.getX();
            VelocityTracker velocityTracker2 = this.f16511D;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (1 == getLayoutDirection()) {
                m17228a(-x);
            } else {
                m17228a(x);
            }
        } else if (action == 3) {
            VelocityTracker velocityTracker3 = this.f16511D;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f16511D = null;
            }
            m17233d();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17233d() {
        int OplusGLSurfaceView_13 = (this.f16515f - this.f16516g) % this.f16521l;
        if (OplusGLSurfaceView_13 != 0) {
            int iAbs = Math.abs(OplusGLSurfaceView_13);
            int i2 = this.f16521l;
            if (iAbs < i2 / 2) {
                this.f16515f -= OplusGLSurfaceView_13;
            } else if (OplusGLSurfaceView_13 > 0) {
                this.f16515f = (this.f16515f - OplusGLSurfaceView_13) + i2;
            } else {
                this.f16515f = (this.f16515f - OplusGLSurfaceView_13) - i2;
            }
            m17234a();
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17228a(float COUIBaseListPopupWindow_12) {
        if (!this.f16535z) {
            CameraLog.m12967f("ScaleBar", "onMove return, is not valid");
            return;
        }
        this.f16515f += (int) COUIBaseListPopupWindow_12;
        int OplusGLSurfaceView_13 = this.f16515f;
        int i2 = this.f16520k;
        if (OplusGLSurfaceView_13 >= i2) {
            this.f16515f = i2;
        } else {
            int i3 = this.f16521l;
            int i4 = this.f16518i;
            if (OplusGLSurfaceView_13 + ((i4 - 1) * i3) <= i2) {
                this.f16515f = i2 - (i3 * (i4 - 1));
            }
        }
        this.f16510C.mo17239a();
        m17234a();
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17234a() {
        if (this.f16518i != 0) {
            int iAbs = Math.abs((this.f16520k - this.f16515f) / this.f16521l) % this.f16518i;
            IntrinsicsJvm.kt_3 cVar = this.f16510C;
            if (cVar != null && iAbs != this.f16517h) {
                cVar.mo17240a(iAbs);
            }
            setCurrentIndex(iAbs);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17236b() {
        if (this.f16518i != 0) {
            int iAbs = Math.abs((this.f16520k - this.f16515f) / this.f16521l) % this.f16518i;
            IntrinsicsJvm.kt_3 cVar = this.f16510C;
            if (cVar != null) {
                cVar.mo17240a(iAbs);
            }
            setCurrentIndex(iAbs);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        if (this.f16519j > 0) {
            return;
        }
        this.f16519j = getMeasuredWidth();
        int i3 = this.f16519j / 2;
        int i4 = this.f16525p;
        this.f16520k = i3 - (i4 / 2);
        this.f16516g = (i3 % this.f16521l) - (i4 / 2);
        this.f16534y = true;
        if (!this.f16533x) {
            this.f16515f = 0;
        }
        int i5 = this.f16517h;
        if (i5 >= 0) {
            m17237b(i5);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17235a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f16518i) {
            return;
        }
        this.f16515f = this.f16520k - (this.f16521l * OplusGLSurfaceView_13);
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17237b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f16518i) {
            return;
        }
        this.f16517h = OplusGLSurfaceView_13;
        if (this.f16534y) {
            this.f16515f = this.f16520k - (this.f16521l * OplusGLSurfaceView_13);
            this.f16533x = true;
            invalidate();
        }
    }

    public void setAuto(boolean z) {
        this.f16532w = z;
        invalidate();
    }

    public void setAlign(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2) {
            this.f16527r = OplusGLSurfaceView_13;
        }
    }

    /* compiled from: ScaleBar.java */
    /* renamed from: com.oplus.camera.t.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends PathInterpolator {
        PlatformImplementations.kt_3() {
            super(0.0f, 0.0f, 0.58f, 1.0f);
        }
    }

    /* compiled from: ScaleBar.java */
    /* renamed from: com.oplus.camera.t.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements Runnable {

        /* renamed from: IntrinsicsJvm.kt_5 */
        private float f16540d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private float f16541e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private float f16542f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private float f16543g;

        /* renamed from: OplusGLSurfaceView_15 */
        private long f16546j;

        /* renamed from: OplusGLSurfaceView_5 */
        private Interpolator f16547k;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f16538b = 400;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f16539c = 16;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private float f16544h = 0.15f;

        /* renamed from: OplusGLSurfaceView_13 */
        private boolean f16545i = false;

        public IntrinsicsJvm.kt_4(float COUIBaseListPopupWindow_12) {
            this.f16547k = ScaleBar.this.new PlatformImplementations.kt_3();
            if (ScaleBar.this.f16510C != null) {
                ScaleBar.this.f16510C.mo17241a(!this.f16545i);
            }
            this.f16543g = 0.0f;
            int OplusGLSurfaceView_13 = this.f16538b;
            this.f16540d = 1.0f / OplusGLSurfaceView_13;
            this.f16541e = COUIBaseListPopupWindow_12;
            this.f16542f = ((OplusGLSurfaceView_13 * this.f16541e) / 1000.0f) * this.f16544h;
            this.f16546j = AnimationUtils.currentAnimationTimeMillis();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m17238a() {
            this.f16545i = true;
            if (ScaleBar.this.f16510C != null) {
                ScaleBar.this.f16510C.mo17241a(!this.f16545i);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f16545i) {
                return;
            }
            int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f16546j);
            float interpolation = this.f16547k.getInterpolation(iCurrentAnimationTimeMillis * this.f16540d);
            float COUIBaseListPopupWindow_12 = (interpolation - this.f16543g) * this.f16542f;
            this.f16543g = interpolation;
            int OplusGLSurfaceView_13 = this.f16538b;
            if (iCurrentAnimationTimeMillis < OplusGLSurfaceView_13) {
                ScaleBar.this.m17228a(COUIBaseListPopupWindow_12);
                ScaleBar.this.f16513F.postDelayed(this, this.f16539c);
            } else if (iCurrentAnimationTimeMillis >= OplusGLSurfaceView_13) {
                this.f16543g = 0.0f;
                ScaleBar.this.m17233d();
                this.f16545i = true;
                if (ScaleBar.this.f16510C != null) {
                    ScaleBar.this.f16510C.mo17241a(!this.f16545i);
                }
            }
        }
    }

    public void setForceBigScaleAlphaPosition(int OplusGLSurfaceView_13) {
        this.f16514G = OplusGLSurfaceView_13;
    }
}

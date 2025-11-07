package com.oplus.camera.p172ui.preview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: GradienterView.java */
/* renamed from: com.oplus.camera.ui.preview.q */
/* loaded from: classes2.dex */
public class GradienterView extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private static String f22331a = "GradienterView";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f22332b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Paint f22333c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Paint f22334d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Path f22335e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Context f22336f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f22337g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f22338h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f22339i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f22340j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f22341k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f22342l;

    /* renamed from: OplusGLSurfaceView_6 */
    private ValueAnimator f22343m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f22344n;

    /* renamed from: o */
    private boolean f22345o;

    public GradienterView(Context context, int OplusGLSurfaceView_13, int i2, int i3) {
        super(context);
        this.f22332b = 0;
        this.f22333c = null;
        this.f22334d = null;
        this.f22335e = null;
        this.f22336f = null;
        this.f22337g = -1;
        this.f22338h = -1;
        this.f22339i = 200;
        this.f22340j = 300;
        this.f22341k = 9;
        this.f22342l = 4.0f;
        this.f22343m = null;
        this.f22344n = true;
        this.f22345o = false;
        this.f22336f = context;
        this.f22340j = this.f22336f.getResources().getDimensionPixelSize(R.dimen.gradienter_dash_width) + (this.f22336f.getResources().getDimensionPixelSize(R.dimen.gradienter_dash_gap) / 2);
        this.f22339i = this.f22336f.getResources().getDimensionPixelSize(R.dimen.gradienter_excircle_radius);
        this.f22341k = this.f22336f.getResources().getDimensionPixelSize(R.dimen.gradienter_inner_circle_radius);
        this.f22342l = this.f22336f.getResources().getDimensionPixelSize(R.dimen.gradienter_line_width);
        this.f22337g = OplusGLSurfaceView_13;
        this.f22338h = i2;
        this.f22332b = i3;
        if ((i3 > 75 && i3 < 105) || (i3 > 255 && i3 < 285)) {
            this.f22344n = false;
        } else {
            this.f22344n = true;
            if (i3 > 345 && i3 < 360) {
                this.f22332b = i3 - 360;
            }
        }
        m23804d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m23804d() {
        this.f22333c = new Paint();
        this.f22333c.setStrokeWidth(this.f22342l);
        this.f22333c.setAntiAlias(true);
        this.f22333c.setStyle(Paint.Style.FILL);
        this.f22333c.setColor(-1);
        this.f22334d = new Paint();
        this.f22334d.setColor(-1);
        this.f22334d.setPathEffect(new DashPathEffect(new float[]{this.f22336f.getResources().getDimensionPixelSize(R.dimen.gradienter_dash_width), this.f22336f.getResources().getDimensionPixelSize(R.dimen.gradienter_dash_gap)}, 0.0f));
        this.f22334d.setStrokeWidth(this.f22342l);
        this.f22334d.setAntiAlias(true);
        this.f22334d.setStyle(Paint.Style.STROKE);
        this.f22335e = new Path();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m23802a(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23802a(Canvas canvas) {
        int OplusGLSurfaceView_13 = this.f22337g;
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        int i2 = this.f22338h;
        float f2 = i2;
        float f3 = OplusGLSurfaceView_13;
        float f4 = i2;
        if (!this.f22344n) {
            int i3 = this.f22340j;
            f2 = i2 - i3;
            f4 = i2 + i3;
        } else {
            int i4 = this.f22340j;
            f3 = OplusGLSurfaceView_13 + i4;
            COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13 - i4;
        }
        this.f22335e.moveTo(COUIBaseListPopupWindow_12, f2);
        this.f22335e.lineTo(f3, f4);
        canvas.drawPath(this.f22335e, this.f22334d);
        this.f22335e.reset();
        canvas.save();
        canvas.drawCircle(this.f22337g, this.f22338h, this.f22341k, this.f22333c);
        canvas.rotate(this.f22332b, this.f22337g, this.f22338h);
        int i5 = this.f22337g;
        float f5 = i5;
        int i6 = this.f22338h;
        float f6 = i6;
        float f7 = i5 + this.f22339i;
        float f8 = i6;
        canvas.drawLine(f5, f6, f7, f8, this.f22333c);
        canvas.drawLine(this.f22337g, f6, r1 - this.f22339i, f8, this.f22333c);
        canvas.restore();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23805a() {
        CameraLog.m12959b(f22331a, "showWithAnimation, mOrientation: " + this.f22332b);
        int OplusGLSurfaceView_13 = this.f22332b;
        if (OplusGLSurfaceView_13 % 90 > 75 || OplusGLSurfaceView_13 % 90 < 15) {
            int i2 = this.f22332b;
            if (i2 % 90 > 89 || Math.abs(i2 % 90) < 1) {
                this.f22333c.setColor(Util.m24164A(getContext()));
            } else {
                this.f22333c.setColor(-1);
            }
            invalidate();
            setVisibilityWithAnimation(0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23807b() {
        CameraLog.m12959b(f22331a, "hideWithAnimation");
        setVisibilityWithAnimation(4);
    }

    private void setVisibilityWithAnimation(final int OplusGLSurfaceView_13) {
        if (this.f22345o) {
            return;
        }
        Util.m24270a(this, OplusGLSurfaceView_13, new Animation.AnimationListener() { // from class: com.oplus.camera.ui.preview.q.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                GradienterView.this.f22345o = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                GradienterView.this.setVisibility(OplusGLSurfaceView_13);
                GradienterView.this.f22345o = false;
            }
        }, 300L);
    }

    public void setOrientation(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 > 315 && OplusGLSurfaceView_13 < 360) {
            this.f22332b = OplusGLSurfaceView_13 - 360;
        } else {
            this.f22332b = OplusGLSurfaceView_13;
        }
    }

    public String getGradienterStatus() {
        int OplusGLSurfaceView_13 = this.f22332b;
        if (OplusGLSurfaceView_13 % 90 <= 75 && OplusGLSurfaceView_13 % 90 >= 15) {
            return "3";
        }
        int i2 = this.f22332b;
        return (i2 % 90 > 89 || Math.abs(i2 % 90) < 1) ? "1" : "2";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23806a(int OplusGLSurfaceView_13) {
        m23808c();
        int i2 = OplusGLSurfaceView_13 % 90;
        if (i2 > 75 || i2 < 15) {
            if ((OplusGLSurfaceView_13 > 75 && OplusGLSurfaceView_13 < 105) || (OplusGLSurfaceView_13 > 255 && OplusGLSurfaceView_13 < 285)) {
                this.f22344n = false;
            } else {
                this.f22344n = true;
                if (OplusGLSurfaceView_13 > 345 && OplusGLSurfaceView_13 < 360) {
                    OplusGLSurfaceView_13 -= 360;
                }
            }
            this.f22343m = ValueAnimator.ofInt(this.f22332b, OplusGLSurfaceView_13);
            this.f22343m.setDuration(100L);
            this.f22343m.setInterpolator(new DecelerateInterpolator());
            this.f22343m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.q.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (GradienterView.this.f22332b != iIntValue) {
                        GradienterView.this.f22332b = iIntValue;
                        GradienterView.this.m23805a();
                    }
                }
            });
            this.f22343m.start();
            return;
        }
        setOrientation(OplusGLSurfaceView_13);
        m23807b();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23808c() {
        ValueAnimator valueAnimator = this.f22343m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f22343m = null;
        }
    }
}

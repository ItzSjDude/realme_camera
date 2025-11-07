package com.oplus.camera.p172ui.menu.p175a;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseAble;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HeadlineBackground.java */
/* renamed from: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class HeadlineBackground extends View implements InverseAble {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f18993a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f18994b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f18995c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f18996d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f18997e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f18998f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Paint f18999g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private RectF f19000h;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f19001i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f19002j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Context f19003k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f19004l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f19005m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f19006n;

    /* renamed from: o */
    private int f19007o;

    /* renamed from: p */
    private int f19008p;

    /* renamed from: q */
    private int f19009q;

    /* renamed from: r */
    private PathInterpolator f19010r;

    /* renamed from: s */
    private ValueAnimator f19011s;

    /* renamed from: t */
    private List<View> f19012t;

    public HeadlineBackground(Context context) {
        super(context);
        this.f18993a = 0;
        this.f18994b = 0;
        this.f18995c = 0;
        this.f18996d = 0;
        this.f18997e = 0;
        this.f18998f = 0.0f;
        this.f18999g = null;
        this.f19000h = null;
        this.f19001i = 1.0f;
        this.f19002j = 0;
        this.f19003k = null;
        this.f19004l = false;
        this.f19005m = 0.0f;
        this.f19006n = 0;
        this.f19007o = 0;
        this.f19008p = 0;
        this.f19009q = 0;
        this.f19010r = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f19011s = null;
        this.f19012t = new ArrayList();
        m20337a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20337a(Context context) {
        this.f19003k = context;
        this.f18995c = getResources().getDimensionPixelSize(R.dimen.headline_bg_radius);
        this.f18996d = context.getResources().getDimensionPixelSize(R.dimen.head_line_check_line_width);
        this.f18997e = context.getResources().getDimensionPixelSize(R.dimen.head_line_background_space);
        this.f18998f = getResources().getDimensionPixelSize(R.dimen.headline_margin_space);
        this.f19002j = context.getColor(R.color.camera_white);
        this.f19007o = getResources().getDimensionPixelSize(R.dimen.head_line_view_margin_top);
        this.f19008p = getResources().getDimensionPixelSize(R.dimen.headline_bg_fold_offset);
        this.f18999g = new Paint();
        this.f18999g.setAntiAlias(true);
        this.f18999g.setColor(this.f19002j);
        this.f19000h = new RectF();
        CameraLog.m12954a("HeadlineBackground", "initialize, mBackgroundRadius: " + this.f18995c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20342a(View view) {
        if (this.f19012t.contains(view)) {
            return;
        }
        this.f19012t.add(view);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20343b(View view) {
        this.f19012t.remove(view);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20340a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        CameraLog.m12954a("HeadlineBackground", "animateView, width: " + OplusGLSurfaceView_13 + ", height: " + i2);
        this.f18994b = i2;
        int i5 = this.f18993a;
        if (OplusGLSurfaceView_13 != i5) {
            if (i5 == 0) {
                this.f18993a = OplusGLSurfaceView_13;
                invalidate();
                return;
            }
            this.f19009q = OplusGLSurfaceView_13;
            this.f19011s = ValueAnimator.ofInt(i5, OplusGLSurfaceView_13);
            this.f19011s.setDuration(i3);
            this.f19011s.setStartDelay(i4);
            this.f19011s.setInterpolator(this.f19010r);
            this.f19011s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HeadlineBackground.this.f18993a = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    HeadlineBackground.this.invalidate();
                }
            });
            this.f19011s.start();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20339a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("HeadlineBackground", "updateView, width: " + OplusGLSurfaceView_13 + ", height: " + i2);
        this.f18994b = i2;
        ValueAnimator valueAnimator = this.f19011s;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            if (OplusGLSurfaceView_13 == this.f19009q) {
                return;
            }
            this.f19011s.cancel();
            this.f19011s = null;
            this.f19009q = 0;
        }
        this.f18993a = OplusGLSurfaceView_13;
    }

    public int getBGWidth() {
        return this.f18993a;
    }

    public int getBGHeight() {
        return this.f18994b;
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("HeadlineBackground", "setVisibility, visibility: " + OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 != 0) {
            this.f19001i = 0.0f;
        }
        super.setVisibility(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m20338b(int OplusGLSurfaceView_13, View view) {
        for (int i2 = 0; i2 < this.f19012t.size(); i2++) {
            View view2 = this.f19012t.get(i2);
            if (view2 != null && view2 != view && view2.getVisibility() == 0 && OplusGLSurfaceView_13 != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20341a(int OplusGLSurfaceView_13, View view) {
        if (m20338b(OplusGLSurfaceView_13, view)) {
            CameraLog.m12954a("HeadlineBackground", "setVisibility, visibility: " + OplusGLSurfaceView_13 + ", fromView:" + view);
            super.setVisibility(OplusGLSurfaceView_13);
        }
    }

    @Override // android.view.View
    public float getAlpha() {
        return this.f19001i;
    }

    @Override // android.view.View
    public void setAlpha(float COUIBaseListPopupWindow_12) {
        CameraLog.m12954a("HeadlineBackground", "setAlpha, alpha: " + COUIBaseListPopupWindow_12);
        super.setAlpha(COUIBaseListPopupWindow_12);
        this.f19001i = COUIBaseListPopupWindow_12;
        postInvalidate();
    }

    public void setOffsetY(float COUIBaseListPopupWindow_12) {
        this.f19005m = COUIBaseListPopupWindow_12;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(0);
        if (this.f18993a <= 0 || this.f18994b <= 0 || this.f18999g == null || getWidth() <= 0 || getHeight() <= 0) {
            CameraLog.m12967f("HeadlineBackground", "onDraw, mBackgroundWidth: " + this.f18993a + ", mBackgroundHeight: " + this.f18994b + ", mPaint: " + this.f18999g + ", getWidth: " + getWidth() + ", getHeight: " + getHeight());
            return;
        }
        CameraLog.m12954a("HeadlineBackground", "onDraw: " + this.f19001i);
        this.f18999g.setAlpha((int) (this.f19001i * 255.0f));
        m20336a();
        RectF rectF = this.f19000h;
        int OplusGLSurfaceView_13 = this.f18995c;
        canvas.drawRoundRect(rectF, OplusGLSurfaceView_13, OplusGLSurfaceView_13, this.f18999g);
        super.onDraw(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20336a() {
        if (this.f19006n == 1) {
            this.f19000h.left = ((getWidth() / 2.0f) - (this.f18993a / 2.0f)) - this.f19003k.getResources().getDimensionPixelSize(R.dimen.vertical_headline_bg_paddingX);
            this.f19000h.right = (getWidth() / 2.0f) + (this.f18993a / 2.0f) + this.f19003k.getResources().getDimensionPixelSize(R.dimen.vertical_headline_bg_paddingX);
            this.f19000h.top = (getHeight() / 2.0f) - (this.f18994b / 2.0f);
            this.f19000h.bottom = (getHeight() / 2.0f) + (this.f18994b / 2.0f);
            return;
        }
        this.f19000h.left = (((getWidth() / 2.0f) - (this.f18993a / 2.0f)) + this.f18997e) - this.f18998f;
        this.f19000h.right = (((getWidth() / 2.0f) + (this.f18993a / 2.0f)) - this.f18997e) + this.f18998f;
        RectF rectF = this.f19000h;
        rectF.top = this.f19005m + this.f19007o + this.f19008p;
        rectF.bottom = ((getHeight() + this.f19005m) - this.f19007o) + this.f19008p;
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        Context context;
        int OplusGLSurfaceView_13;
        this.f19004l = z;
        Paint paint = this.f18999g;
        if (this.f19004l) {
            context = this.f19003k;
            OplusGLSurfaceView_13 = R.color.bg_black;
        } else {
            context = this.f19003k;
            OplusGLSurfaceView_13 = R.color.camera_white;
        }
        paint.setColor(context.getColor(OplusGLSurfaceView_13));
        invalidate();
    }

    public void setScreenLayoutMode(int OplusGLSurfaceView_13) {
        this.f19006n = OplusGLSurfaceView_13;
    }
}

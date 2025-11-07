package com.oplus.camera.p172ui.menu.facebeauty;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.BackgroundSplitManager;
import com.oplus.camera.p172ui.ILightBackgroundView;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseAble;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class RotateAnimationView extends ImageView implements BackgroundSplitManager.PlatformImplementations.kt_3, InverseAble, ILightBackgroundView {

    /* renamed from: PlatformImplementations.kt_3 */
    public int f19167a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f19168b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f19169c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean f19170d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean f19171e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public long f19172f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public long f19173g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected boolean f19174h;

    /* renamed from: OplusGLSurfaceView_13 */
    protected boolean f19175i;

    /* renamed from: OplusGLSurfaceView_15 */
    protected boolean f19176j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final PathInterpolator f19177k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final ArgbEvaluator f19178l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f19179m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f19180n;

    /* renamed from: o */
    private boolean f19181o;

    /* renamed from: p */
    private int f19182p;

    /* renamed from: q */
    private int f19183q;

    /* renamed from: r */
    private int f19184r;

    /* renamed from: s */
    private Paint f19185s;

    /* renamed from: t */
    private boolean f19186t;

    /* renamed from: u */
    private ValueAnimator f19187u;

    /* renamed from: v */
    private ValueAnimator f19188v;

    public RotateAnimationView(Context context) {
        super(context);
        this.f19177k = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f19178l = new ArgbEvaluator();
        this.f19167a = 0;
        this.f19168b = 0;
        this.f19169c = 0;
        this.f19170d = false;
        this.f19171e = true;
        this.f19172f = 0L;
        this.f19173g = 0L;
        this.f19174h = false;
        this.f19175i = false;
        this.f19176j = false;
        this.f19179m = 0;
        this.f19180n = 0;
        this.f19181o = false;
        this.f19182p = 0;
        this.f19183q = 0;
        this.f19184r = 0;
        this.f19185s = null;
        this.f19186t = true;
        this.f19187u = null;
        this.f19188v = null;
        m20505b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m20505b() {
        this.f19180n = Util.m24164A(getContext());
        this.f19179m = getContext().getColor(R.color.camera_white);
    }

    public RotateAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19177k = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f19178l = new ArgbEvaluator();
        this.f19167a = 0;
        this.f19168b = 0;
        this.f19169c = 0;
        this.f19170d = false;
        this.f19171e = true;
        this.f19172f = 0L;
        this.f19173g = 0L;
        this.f19174h = false;
        this.f19175i = false;
        this.f19176j = false;
        this.f19179m = 0;
        this.f19180n = 0;
        this.f19181o = false;
        this.f19182p = 0;
        this.f19183q = 0;
        this.f19184r = 0;
        this.f19185s = null;
        this.f19186t = true;
        this.f19187u = null;
        this.f19188v = null;
        m20505b();
    }

    public RotateAnimationView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f19177k = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f19178l = new ArgbEvaluator();
        this.f19167a = 0;
        this.f19168b = 0;
        this.f19169c = 0;
        this.f19170d = false;
        this.f19171e = true;
        this.f19172f = 0L;
        this.f19173g = 0L;
        this.f19174h = false;
        this.f19175i = false;
        this.f19176j = false;
        this.f19179m = 0;
        this.f19180n = 0;
        this.f19181o = false;
        this.f19182p = 0;
        this.f19183q = 0;
        this.f19184r = 0;
        this.f19185s = null;
        this.f19186t = true;
        this.f19187u = null;
        this.f19188v = null;
        m20505b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20509a(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        if (getVisibility() == 0) {
            this.f19171e = z;
        } else {
            this.f19171e = false;
        }
        if (OplusGLSurfaceView_13 >= 0) {
            i2 = OplusGLSurfaceView_13 % 360;
        } else {
            i2 = (OplusGLSurfaceView_13 % 360) + 360;
        }
        if (i2 == this.f19169c) {
            return;
        }
        this.f19169c = i2;
        if (this.f19171e) {
            this.f19168b = this.f19167a;
            this.f19172f = AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f19169c - this.f19167a;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.f19170d = i3 >= 0;
            this.f19173g = this.f19172f + ((Math.abs(i3) * 1000) / 270);
        } else {
            this.f19167a = this.f19169c;
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) throws Resources.NotFoundException {
        int OplusGLSurfaceView_13;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        int i2 = bounds.right - bounds.left;
        int i3 = bounds.bottom - bounds.top;
        if (i2 == 0 || i3 == 0) {
            return;
        }
        if (this.f19181o && !InverseManager.INS.isInverseColor(getContext().hashCode())) {
            BackgroundSplitManager.m18430a(getContext()).m18443a(this, canvas, this.f19182p);
        }
        if (this.f19167a != this.f19169c) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.f19173g) {
                int i4 = (int) (jCurrentAnimationTimeMillis - this.f19172f);
                int i5 = this.f19168b;
                if (!this.f19170d) {
                    i4 = -i4;
                }
                int i6 = i5 + ((i4 * 270) / 1000);
                if (i6 >= 0) {
                    OplusGLSurfaceView_13 = i6 % 360;
                } else {
                    OplusGLSurfaceView_13 = (i6 % 360) + 360;
                }
                this.f19167a = OplusGLSurfaceView_13;
                invalidate();
            } else {
                this.f19167a = this.f19169c;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        int saveCount = canvas.getSaveCount();
        if (this.f19186t && this.f19185s != null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.rotate_item_radius);
            float COUIBaseListPopupWindow_12 = (width - dimensionPixelSize) + this.f19183q;
            float f2 = this.f19184r + dimensionPixelSize;
            Paint paint = this.f19185s;
            if (paint != null) {
                canvas.drawCircle(COUIBaseListPopupWindow_12, f2, dimensionPixelSize, paint);
            }
        }
        if (getScaleType() == ImageView.ScaleType.FIT_CENTER && (width < i2 || height < i3)) {
            float f3 = width;
            float f4 = height;
            float fMin = Math.min(f3 / i2, f4 / i3);
            canvas.scale(fMin, fMin, f3 * 0.5f, f4 * 0.5f);
        }
        canvas.translate(paddingLeft + (width / 2.0f), paddingTop + (height / 2.0f));
        canvas.rotate(-this.f19167a);
        canvas.translate((-i2) / 2.0f, (-i3) / 2.0f);
        drawable.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 3);
        if (this.f19174h) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        if (this.f19175i) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_high_light});
        }
        if (this.f19176j) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_light_bg_color});
        }
        return iArrOnCreateDrawableState;
    }

    public void setHighLight(boolean z) {
        this.f19175i = z;
        refreshDrawableState();
        invalidate();
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f19174h = z;
        refreshDrawableState();
        invalidate();
    }

    @Override // com.oplus.camera.p172ui.BackgroundSplitManager.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18292a(boolean z, int OplusGLSurfaceView_13) {
        this.f19181o = z;
        this.f19182p = OplusGLSurfaceView_13;
        postInvalidate();
    }

    @Override // com.oplus.camera.p172ui.BackgroundSplitManager.PlatformImplementations.kt_3
    public void setNormalBackground(boolean z) {
        setLightBackground(z);
    }

    @Override // com.oplus.camera.p172ui.ILightBackgroundView
    public void setLightBackground(boolean z) {
        CameraLog.m12954a("RotateAnimationView", "setLightBackground, isLightBackground: " + z);
        if (this.f19176j == z) {
            return;
        }
        this.f19176j = z;
        refreshDrawableState();
        postInvalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z) {
        CameraLog.m12954a("RotateAnimationView", "setSelected, isSelected: " + isSelected() + ", selected: " + z);
        boolean zIsSelected = isSelected();
        super.setSelected(z);
        if (zIsSelected != z) {
            if (z) {
                m20507d();
            } else {
                m20506c();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m20506c() {
        ValueAnimator valueAnimator = this.f19187u;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f19187u.cancel();
        }
        if (this.f19188v == null) {
            this.f19188v = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.f19180n), Integer.valueOf(this.f19179m));
            this.f19188v.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.RotateAnimationView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    RotateAnimationView rotateAnimationView = RotateAnimationView.this;
                    rotateAnimationView.setColorFilter(rotateAnimationView.f19179m);
                }
            });
            this.f19188v.setInterpolator(this.f19177k);
            this.f19188v.setDuration(250L);
            this.f19188v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.facebeauty.RotateAnimationView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    RotateAnimationView.this.setColorFilter(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
        }
        this.f19188v.start();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m20507d() {
        ValueAnimator valueAnimator = this.f19188v;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f19188v.cancel();
        }
        if (this.f19187u == null) {
            this.f19187u = ValueAnimator.ofObject(this.f19178l, Integer.valueOf(this.f19179m), Integer.valueOf(this.f19180n));
            this.f19187u.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.RotateAnimationView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    RotateAnimationView rotateAnimationView = RotateAnimationView.this;
                    rotateAnimationView.setColorFilter(rotateAnimationView.f19180n);
                }
            });
            this.f19187u.setInterpolator(this.f19177k);
            this.f19187u.setDuration(250L);
            this.f19187u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.facebeauty.RotateAnimationView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    RotateAnimationView.this.setColorFilter(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
        }
        this.f19187u.start();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.f19187u;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f19187u.cancel();
        }
        ValueAnimator valueAnimator2 = this.f19188v;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.f19188v.cancel();
        }
        this.f19188v = null;
        this.f19187u = null;
        BackgroundSplitManager.m18430a(getContext()).m18442a(this);
        super.onDetachedFromWindow();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20510a(boolean z, int OplusGLSurfaceView_13, int i2) {
        if (z) {
            if (this.f19185s == null) {
                this.f19185s = new Paint();
                this.f19185s.setAntiAlias(true);
                this.f19185s.setColor(getResources().getColor(R.color.camera_red_dot_hint_color, null));
            }
        } else {
            this.f19185s = null;
        }
        boolean z2 = this.f19186t != z;
        this.f19186t = z;
        this.f19183q = OplusGLSurfaceView_13;
        this.f19184r = i2;
        if (z2) {
            invalidate();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20508a() {
        ValueAnimator valueAnimator = this.f19188v;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f19188v.cancel();
    }
}

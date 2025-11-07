package com.oplus.camera.p172ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.BackgroundSplitManager;
import com.oplus.camera.p172ui.inverse.InverseManager;

/* loaded from: classes2.dex */
public class RotateLottieAnimationView extends LottieAnimationView implements BackgroundSplitManager.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f17242a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f17243b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f17244c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f17245d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f17246e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private long f17247f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private long f17248g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f17249h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f17250i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f17251j;

    public RotateLottieAnimationView(Context context) {
        this(context, null);
    }

    public RotateLottieAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotateLottieAnimationView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17242a = 0;
        this.f17243b = 0;
        this.f17244c = 0;
        this.f17245d = false;
        this.f17246e = true;
        this.f17247f = 0L;
        this.f17248g = 0L;
        this.f17249h = false;
        this.f17250i = false;
        this.f17251j = 0;
        BackgroundSplitManager.m18430a(context).m18445a(this, "RotateLottieAnimationView");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18349a(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        if (getVisibility() == 0) {
            this.f17246e = z;
        } else {
            this.f17246e = false;
        }
        if (OplusGLSurfaceView_13 >= 0) {
            i2 = OplusGLSurfaceView_13 % 360;
        } else {
            i2 = (OplusGLSurfaceView_13 % 360) + 360;
        }
        if (i2 == this.f17244c) {
            return;
        }
        this.f17244c = i2;
        if (this.f17246e) {
            this.f17243b = this.f17242a;
            this.f17247f = AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f17244c - this.f17242a;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.f17245d = i3 >= 0;
            this.f17248g = this.f17247f + ((Math.abs(i3) * 1000) / 270);
        } else {
            this.f17242a = this.f17244c;
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int OplusGLSurfaceView_13;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        if (this.f17249h && !InverseManager.INS.isInverseColor(getContext().hashCode())) {
            BackgroundSplitManager.m18430a(getContext()).m18443a(this, canvas, this.f17251j);
        }
        Rect bounds = drawable.getBounds();
        int i2 = bounds.right - bounds.left;
        int i3 = bounds.bottom - bounds.top;
        if (i2 == 0 || i3 == 0) {
            return;
        }
        if (this.f17242a != this.f17244c) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.f17248g) {
                int i4 = (int) (jCurrentAnimationTimeMillis - this.f17247f);
                int i5 = this.f17243b;
                if (!this.f17245d) {
                    i4 = -i4;
                }
                int i6 = i5 + ((i4 * 270) / 1000);
                if (i6 >= 0) {
                    OplusGLSurfaceView_13 = i6 % 360;
                } else {
                    OplusGLSurfaceView_13 = (i6 % 360) + 360;
                }
                this.f17242a = OplusGLSurfaceView_13;
                invalidate();
            } else {
                this.f17242a = this.f17244c;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        int saveCount = canvas.getSaveCount();
        if (getScaleType() == ImageView.ScaleType.FIT_CENTER && (width < i2 || height < i3)) {
            float COUIBaseListPopupWindow_12 = width;
            float f2 = height;
            float fMin = Math.min(COUIBaseListPopupWindow_12 / i2, f2 / i3);
            canvas.scale(fMin, fMin, COUIBaseListPopupWindow_12 * 0.5f, f2 * 0.5f);
        }
        canvas.translate(paddingLeft + (width / 2), paddingTop + (height / 2));
        canvas.rotate(-this.f17242a);
        canvas.translate((-i2) / 2, (-i3) / 2);
        drawable.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    @Override // com.oplus.camera.p172ui.BackgroundSplitManager.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18292a(boolean z, int OplusGLSurfaceView_13) {
        this.f17249h = z;
        this.f17251j = OplusGLSurfaceView_13;
        postInvalidate();
    }

    @Override // com.oplus.camera.p172ui.BackgroundSplitManager.PlatformImplementations.kt_3
    public void setNormalBackground(boolean z) {
        setLightBackground(z);
    }

    public void setLightBackground(boolean z) {
        CameraLog.m12954a("RotateLottieAnimationView", "setLightBackground, isLightBackground: " + z);
        if (this.f17250i == z) {
            return;
        }
        this.f17250i = z;
        refreshDrawableState();
        postInvalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
        if (this.f17250i) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_light_bg_color});
        }
        return iArrOnCreateDrawableState;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BackgroundSplitManager.m18430a(getContext()).m18442a(this);
    }
}

package com.oplus.camera.p172ui;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.BackgroundSplitManager;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseAble;
import com.oplus.camera.util.AnimUtil;

/* loaded from: classes2.dex */
public class RotateImageView extends TwoStateImageView implements BackgroundSplitManager.PlatformImplementations.kt_3, InverseAble {

    /* renamed from: PlatformImplementations.kt_3 */
    public int f17225a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f17226b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f17227c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean f17228d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean f17229e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public long f17230f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public long f17231g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public float f17232h;

    /* renamed from: OplusGLSurfaceView_13 */
    public float f17233i;

    /* renamed from: OplusGLSurfaceView_15 */
    protected boolean f17234j;

    /* renamed from: OplusGLSurfaceView_5 */
    protected boolean f17235k;

    /* renamed from: OplusGLSurfaceView_14 */
    protected int f17236l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f17237m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f17238n;

    /* renamed from: o */
    private boolean f17239o;

    /* renamed from: p */
    private int f17240p;

    /* renamed from: q */
    private Animator f17241q;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float m18345b(int OplusGLSurfaceView_13, int i2) {
        int i3 = i2 - OplusGLSurfaceView_13;
        if (i3 < 0) {
            i3 += 360;
        }
        if (i3 > 180) {
            i3 -= 360;
        }
        return i3;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        return false;
    }

    public RotateImageView(Context context) {
        this(context, null);
    }

    public RotateImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotateImageView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17225a = 0;
        this.f17226b = 0;
        this.f17227c = 0;
        this.f17228d = false;
        this.f17229e = true;
        this.f17230f = 0L;
        this.f17231g = 0L;
        this.f17232h = 1.0f;
        this.f17233i = 1.0f;
        this.f17234j = false;
        this.f17235k = false;
        this.f17236l = -1;
        this.f17237m = 0;
        this.f17238n = 0;
        this.f17239o = false;
        this.f17240p = 0;
        this.f17241q = null;
    }

    protected int getDegree() {
        return this.f17227c;
    }

    public void setDrawableScale(float COUIBaseListPopupWindow_12) {
        this.f17232h = COUIBaseListPopupWindow_12;
    }

    public void setDrawableAlpha(float COUIBaseListPopupWindow_12) {
        this.f17233i = COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18348a(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        if (getVisibility() == 0) {
            this.f17229e = z;
        } else {
            this.f17229e = false;
        }
        if (OplusGLSurfaceView_13 >= 0) {
            i2 = OplusGLSurfaceView_13 % 360;
        } else {
            i2 = (OplusGLSurfaceView_13 % 360) + 360;
        }
        if (i2 == this.f17227c) {
            return;
        }
        this.f17227c = i2;
        if (this.f17229e) {
            this.f17226b = this.f17225a;
            this.f17230f = AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f17227c - this.f17225a;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.f17228d = i3 >= 0;
            this.f17231g = this.f17230f + ((Math.abs(i3) * 1000) / 270);
        } else {
            this.f17225a = this.f17227c;
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
        Rect bounds = drawable.getBounds();
        int i2 = bounds.right - bounds.left;
        int i3 = bounds.bottom - bounds.top;
        if (i2 == 0 || i3 == 0) {
            return;
        }
        if (this.f17239o && !InverseManager.INS.isInverseColor(getContext().hashCode())) {
            BackgroundSplitManager.m18430a(getContext()).m18443a(this, canvas, this.f17240p);
        }
        if (this.f17225a != this.f17227c) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.f17231g) {
                int i4 = (int) (jCurrentAnimationTimeMillis - this.f17230f);
                int i5 = this.f17226b;
                if (!this.f17228d) {
                    i4 = -i4;
                }
                int i6 = i5 + ((i4 * 270) / 1000);
                if (i6 >= 0) {
                    OplusGLSurfaceView_13 = i6 % 360;
                } else {
                    OplusGLSurfaceView_13 = (i6 % 360) + 360;
                }
                this.f17225a = OplusGLSurfaceView_13;
                invalidate();
            } else {
                this.f17225a = this.f17227c;
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
        float f3 = this.f17232h;
        if (0.0f > f3 || 1.0f < f3) {
            this.f17232h = 1.0f;
        }
        float f4 = this.f17233i;
        if (0.0f > f4 || 1.0f < f4) {
            this.f17233i = 1.0f;
        }
        canvas.translate(paddingLeft + (width / 2), paddingTop + (height / 2));
        float f5 = this.f17232h;
        canvas.scale(f5, f5);
        canvas.rotate(-this.f17225a);
        canvas.translate((-i2) / 2, (-i3) / 2);
        drawable.setAlpha((int) (this.f17233i * 255.0f));
        drawable.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + (-1 == this.f17236l ? 2 : 3));
        if (this.f17234j) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        if (this.f17235k) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_light_bg_color});
        }
        int i2 = this.f17236l;
        if (-1 != i2) {
            if (i2 == 48) {
                mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.type_48M});
            } else if (i2 == 50) {
                mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.type_50M});
            } else if (i2 == 64) {
                mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.type_64M});
            }
        }
        return iArrOnCreateDrawableState;
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f17234j = z;
        refreshDrawableState();
        invalidate();
    }

    @Override // com.oplus.camera.p172ui.BackgroundSplitManager.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18292a(boolean z, int OplusGLSurfaceView_13) {
        this.f17239o = z;
        this.f17240p = OplusGLSurfaceView_13;
        postInvalidate();
    }

    @Override // com.oplus.camera.p172ui.BackgroundSplitManager.PlatformImplementations.kt_3
    public void setNormalBackground(boolean z) {
        if (z) {
            setBackgroundResource(R.drawable.switch_camera_button_gray_bg);
        } else {
            setBackgroundResource(R.drawable.switch_camera_button_bg);
        }
    }

    public void setLightBackground(boolean z) {
        if (this.f17235k == z) {
            return;
        }
        this.f17235k = z;
        refreshDrawableState();
        invalidate();
    }

    public void setHighResolutionType(int OplusGLSurfaceView_13) {
        this.f17236l = OplusGLSurfaceView_13;
        refreshDrawableState();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        Animator animator = this.f17241q;
        if (animator != null && animator.isRunning()) {
            this.f17241q.cancel();
        }
        this.f17241q = null;
        BackgroundSplitManager.m18430a(getContext()).m18442a(this);
        super.onDetachedFromWindow();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18347a(int OplusGLSurfaceView_13, int i2) {
        Animator animatorM24517a = AnimUtil.m24517a(this, OplusGLSurfaceView_13, i2);
        if (animatorM24517a != null) {
            Animator animator = this.f17241q;
            if (animator != null && animator.isRunning()) {
                this.f17241q.cancel();
            }
            this.f17241q = animatorM24517a;
            this.f17241q.start();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static long m18346c(int OplusGLSurfaceView_13, int i2) {
        return (Math.abs((long) m18345b(OplusGLSurfaceView_13, i2)) * 1000) / 270;
    }
}

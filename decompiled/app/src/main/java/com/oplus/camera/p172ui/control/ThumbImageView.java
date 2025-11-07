package com.oplus.camera.p172ui.control;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p137b.SimpleAnimatorListener;
import com.oplus.camera.p172ui.TwoStateImageView;
import com.oplus.camera.perf.CameraPerformance;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class ThumbImageView extends TwoStateImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    public static int f18106a;

    /* renamed from: A */
    private boolean f18107A;

    /* renamed from: B */
    private PathInterpolator f18108B;

    /* renamed from: C */
    private PathInterpolator f18109C;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f18110b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f18111c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f18112d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f18113e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f18114f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f18115g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f18116h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f18117i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f18118j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f18119k;

    /* renamed from: OplusGLSurfaceView_14 */
    private long f18120l;

    /* renamed from: OplusGLSurfaceView_6 */
    private long f18121m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f18122n;

    /* renamed from: o */
    private boolean f18123o;

    /* renamed from: p */
    private boolean f18124p;

    /* renamed from: q */
    private Bitmap f18125q;

    /* renamed from: r */
    private Bitmap f18126r;

    /* renamed from: s */
    private Rect f18127s;

    /* renamed from: t */
    private Rect f18128t;

    /* renamed from: u */
    private Drawable f18129u;

    /* renamed from: v */
    private Drawable f18130v;

    /* renamed from: w */
    private Drawable f18131w;

    /* renamed from: x */
    private ValueAnimator f18132x;

    /* renamed from: y */
    private Paint f18133y;

    /* renamed from: z */
    private int f18134z;

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        return false;
    }

    public ThumbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18110b = 0;
        this.f18111c = 0;
        this.f18112d = 0;
        this.f18113e = 0;
        this.f18114f = 0;
        this.f18115g = 0;
        this.f18116h = 0;
        this.f18117i = 0;
        this.f18118j = 0;
        this.f18119k = 0;
        this.f18120l = 0L;
        this.f18121m = 0L;
        this.f18122n = 0.5f;
        this.f18123o = false;
        this.f18124p = false;
        this.f18125q = null;
        this.f18126r = null;
        this.f18127s = null;
        this.f18128t = null;
        this.f18129u = null;
        this.f18130v = null;
        this.f18131w = null;
        this.f18132x = null;
        this.f18133y = new Paint();
        this.f18134z = 0;
        this.f18107A = false;
        this.f18108B = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f18109C = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        Resources resources = context.getResources();
        this.f18110b = resources.getDimensionPixelSize(R.dimen.thumbnail_round_corner_radius);
        this.f18111c = resources.getDimensionPixelSize(R.dimen.thumbnail_round_stroke_width);
        this.f18129u = resources.getDrawable(R.drawable.thumbnail_bg_normal);
        f18106a = resources.getDimensionPixelSize(R.dimen.thumbnail_width_nomal);
        this.f18134z = context.getResources().getDimensionPixelSize(R.dimen.movie_thumbnail_round_corner_radius);
        this.f18133y.setStrokeWidth(this.f18111c);
        this.f18133y.setAntiAlias(true);
        this.f18133y.setColor(context.getResources().getColor(R.color.color_white_with_10_percent_transparency));
        this.f18133y.setStyle(Paint.Style.STROKE);
    }

    public ThumbImageView(Context context) {
        this(context, null);
    }

    protected int getDegree() {
        return this.f18113e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18984a(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        if (OplusGLSurfaceView_13 >= 0) {
            i2 = OplusGLSurfaceView_13 % 360;
        } else {
            i2 = (OplusGLSurfaceView_13 % 360) + 360;
        }
        if (i2 == this.f18113e) {
            return;
        }
        this.f18113e = i2;
        if (this.f18118j != 0) {
            return;
        }
        if (z) {
            this.f18114f = this.f18112d;
            this.f18120l = AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f18113e - this.f18112d;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.f18123o = i3 >= 0;
            this.f18121m = this.f18120l + ((Math.abs(i3) * 1000) / 270);
        } else {
            this.f18112d = this.f18113e;
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int OplusGLSurfaceView_13;
        int i2;
        int paddingLeft = getPaddingLeft() + this.f18119k;
        int paddingTop = getPaddingTop() + this.f18119k;
        int width = getWidth() - (paddingLeft * 2);
        int height = getHeight() - (paddingTop * 2);
        if (this.f18124p) {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                CameraLog.m12954a("ThumbImageView", "ondraw(), drawable is null 1 ,so return ");
                return;
            }
            Rect bounds = drawable.getBounds();
            int i3 = bounds.right - bounds.left;
            int i4 = bounds.bottom - bounds.top;
            if (i3 == 0 || i4 == 0) {
                CameraLog.m12967f("ThumbImageView", "ondraw w and COUIBaseListPopupWindow_10 is zero,so return ");
                return;
            }
            if (this.f18112d != this.f18113e) {
                long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                if (jCurrentAnimationTimeMillis < this.f18121m) {
                    int i5 = (int) (jCurrentAnimationTimeMillis - this.f18120l);
                    int i6 = this.f18114f;
                    if (!this.f18123o) {
                        i5 = -i5;
                    }
                    int i7 = i6 + ((i5 * 270) / 1000);
                    if (i7 >= 0) {
                        i2 = i7 % 360;
                    } else {
                        i2 = (i7 % 360) + 360;
                    }
                    this.f18112d = i2;
                    invalidate();
                } else {
                    this.f18112d = this.f18113e;
                }
            }
            int saveCount = canvas.getSaveCount();
            if (getScaleType() == ImageView.ScaleType.FIT_CENTER && (width < i3 || height < i4)) {
                float COUIBaseListPopupWindow_12 = width;
                float f2 = height;
                float fMin = Math.min(COUIBaseListPopupWindow_12 / i3, f2 / i4);
                canvas.scale(fMin, fMin, COUIBaseListPopupWindow_12 * 0.5f, f2 * 0.5f);
            }
            float f3 = paddingLeft;
            float f4 = width * 0.5f;
            float f5 = height * 0.5f;
            canvas.translate(f3 + f4, f3 + f5);
            canvas.rotate(-this.f18112d);
            float f6 = -paddingLeft;
            canvas.translate(f6 - f4, f6 - f5);
            drawable.setBounds(paddingLeft, paddingTop, width + paddingLeft, height + paddingTop);
            drawable.draw(canvas);
            canvas.restoreToCount(saveCount);
            m18978a(canvas);
            return;
        }
        int i8 = this.f18118j;
        if (i8 != 0) {
            if (i8 == 2) {
                float f7 = width;
                float f8 = f7 * 0.5f;
                float f9 = height;
                float f10 = 0.5f * f9;
                canvas.translate(paddingLeft + f8, paddingTop + f10);
                canvas.rotate(-this.f18112d);
                canvas.translate((-paddingLeft) - f8, (-paddingTop) - f10);
                float f11 = this.f18122n;
                this.f18116h = (int) (f7 * f11);
                this.f18117i = (int) (f9 * f11);
                Rect rect = this.f18127s;
                int i9 = (width / 2) + paddingLeft;
                int i10 = this.f18116h;
                rect.left = i9 - i10;
                int i11 = (height / 2) + paddingTop;
                int i12 = this.f18117i;
                rect.top = i11 - i12;
                rect.right = i9 + i10;
                rect.bottom = i11 + i12;
                Drawable drawable2 = this.f18131w;
                if (drawable2 != null) {
                    drawable2.setBounds(paddingLeft, paddingTop, width + paddingLeft, height + paddingTop);
                    this.f18131w.draw(canvas);
                }
                Bitmap bitmap = this.f18125q;
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, this.f18128t, this.f18127s, (Paint) null);
                    m18978a(canvas);
                    return;
                }
                return;
            }
            return;
        }
        Drawable drawable3 = getDrawable();
        if (drawable3 == null) {
            return;
        }
        Rect bounds2 = drawable3.getBounds();
        int i13 = bounds2.right - bounds2.left;
        int i14 = bounds2.bottom - bounds2.top;
        if (i13 == 0 || i14 == 0) {
            return;
        }
        if (this.f18112d != this.f18113e) {
            long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis2 < this.f18121m) {
                int i15 = (int) (jCurrentAnimationTimeMillis2 - this.f18120l);
                int i16 = this.f18114f;
                if (!this.f18123o) {
                    i15 = -i15;
                }
                int i17 = i16 + ((i15 * 270) / 1000);
                if (i17 >= 0) {
                    OplusGLSurfaceView_13 = i17 % 360;
                } else {
                    OplusGLSurfaceView_13 = (i17 % 360) + 360;
                }
                this.f18112d = OplusGLSurfaceView_13;
                invalidate();
            } else {
                this.f18112d = this.f18113e;
            }
        }
        int saveCount2 = canvas.getSaveCount();
        if (getScaleType() == ImageView.ScaleType.FIT_CENTER && (width < i13 || height < i14)) {
            float f12 = width;
            float f13 = height;
            float fMin2 = Math.min(f12 / i13, f13 / i14);
            canvas.scale(fMin2, fMin2, f12 * 0.5f, f13 * 0.5f);
        }
        float f14 = width * 0.5f;
        float f15 = height * 0.5f;
        canvas.translate(paddingLeft + f14, paddingTop + f15);
        canvas.rotate(-this.f18112d);
        canvas.translate((-paddingLeft) - f14, (-paddingTop) - f15);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        drawable3.setBounds(paddingLeft, paddingTop, width + paddingLeft, height + paddingTop);
        drawable3.draw(canvas);
        m18978a(canvas);
        canvas.restoreToCount(saveCount2);
    }

    public void setPaddingPlus(int OplusGLSurfaceView_13) {
        this.f18119k = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18978a(Canvas canvas) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (this.f18107A && layoutParams != null) {
            float COUIBaseListPopupWindow_12 = layoutParams.width - ((paddingLeft - this.f18119k) * 2);
            float f2 = layoutParams.height - ((paddingTop - this.f18119k) * 2);
            int OplusGLSurfaceView_13 = this.f18134z;
            canvas.drawRoundRect(0.0f, 0.0f, COUIBaseListPopupWindow_12, f2, OplusGLSurfaceView_13, OplusGLSurfaceView_13, this.f18133y);
            return;
        }
        if (this.f18107A || layoutParams == null) {
            return;
        }
        canvas.drawCircle(layoutParams.width / 2, layoutParams.height / 2, this.f18110b - this.f18119k, this.f18133y);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18986a(Bitmap bitmap, int OplusGLSurfaceView_13, boolean z, boolean z2) {
        CameraLog.m12954a("ThumbImageView", "setBitmap, mAnimationState: " + this.f18118j + ", bitmap: " + bitmap + ", isdefault: " + z + ", mbDefaultBitmap: " + this.f18124p);
        boolean z3 = this.f18124p;
        this.f18124p = z;
        if (bitmap == null) {
            this.f18125q = bitmap;
            this.f18131w = null;
            setImageDrawable(null);
            return;
        }
        if (z2) {
            this.f18131w = this.f18130v;
        } else {
            this.f18131w = null;
        }
        if (z3 && !this.f18124p) {
            setImageDrawable(this.f18129u);
        }
        this.f18126r = bitmap;
        this.f18125q = m18982a(bitmap, true, false);
        this.f18130v = Util.m24227a(getContext(), this.f18125q);
        CameraPerformance.m15188b("capture");
        if (1 == OplusGLSurfaceView_13 && getVisibility() == 0) {
            m18983a();
            return;
        }
        if (2 == OplusGLSurfaceView_13 && getVisibility() == 0) {
            Drawable drawable = this.f18131w;
            if (drawable != null) {
                setImageDrawable(drawable);
            }
            ValueAnimator valueAnimator = this.f18132x;
            if (valueAnimator == null || ((Float) valueAnimator.getAnimatedValue()).floatValue() <= 0.4f) {
                return;
            }
            m18983a();
            return;
        }
        setImageDrawable(this.f18130v);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap m18982a(Bitmap bitmap, boolean z, boolean z2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int paddingLeft = (layoutParams.width - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (layoutParams.height - getPaddingTop()) - getPaddingBottom();
        if (bitmap.getWidth() != paddingLeft || bitmap.getHeight() != paddingTop) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, paddingLeft, paddingTop);
        }
        if (z) {
            return Thumbnail.m19267a(bitmap, this.f18110b, this.f18111c, z2 && this.f18107A);
        }
        return bitmap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18983a() {
        CameraLog.m12954a("ThumbImageView", "startNewThumbAnimation");
        this.f18118j = 2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - (paddingLeft * 2);
        int height = getHeight() - (paddingTop * 2);
        if (this.f18132x == null) {
            m18981c();
        }
        this.f18128t = new Rect(0, 0, width, height);
        int OplusGLSurfaceView_13 = paddingLeft + (width / 2);
        int i2 = paddingTop + (height / 2);
        this.f18127s = new Rect(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13, i2);
        if (this.f18132x.isRunning() || this.f18132x.isStarted()) {
            this.f18132x.cancel();
        }
        this.f18132x.start();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m18981c() {
        this.f18132x = ValueAnimator.ofFloat(0.03f, 0.5f);
        this.f18132x.setDuration(300L);
        this.f18132x.setInterpolator(this.f18108B);
        this.f18132x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.ThumbImageView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ThumbImageView.this.f18118j = 2;
                ThumbImageView.this.f18122n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Float.compare(ThumbImageView.this.f18122n, 0.5f) > 0) {
                    ThumbImageView.this.f18122n = 0.5f;
                    ThumbImageView.this.f18132x.cancel();
                }
                ThumbImageView.this.invalidate();
            }
        });
        this.f18132x.addListener(new C3198a());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18988b(int OplusGLSurfaceView_13, boolean z) {
        AlphaAnimation alphaAnimation;
        ScaleAnimation scaleAnimation;
        if (getVisibility() == OplusGLSurfaceView_13) {
            return;
        }
        if (8 == OplusGLSurfaceView_13 && 4 == getVisibility()) {
            return;
        }
        if (4 == OplusGLSurfaceView_13 && 8 == getVisibility()) {
            return;
        }
        setVisibility(OplusGLSurfaceView_13);
        AnimationSet animationSet = new AnimationSet(false);
        if (OplusGLSurfaceView_13 == 0) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500L);
            scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        } else {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(250L);
            scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        }
        if (!z) {
            scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        }
        scaleAnimation.setDuration(500L);
        alphaAnimation.setInterpolator(this.f18109C);
        scaleAnimation.setInterpolator(this.f18108B);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        clearAnimation();
        startAnimation(animationSet);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        super.setVisibility(OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 == 0) {
            invalidate();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18987b() {
        Bitmap bitmap = this.f18125q;
        if (bitmap != null) {
            bitmap.recycle();
            this.f18125q = null;
        }
        Bitmap bitmap2 = this.f18126r;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f18126r = null;
        }
    }

    /* renamed from: com.oplus.camera.ui.control.ThumbImageView$PlatformImplementations.kt_3 */
    private class C3198a extends SimpleAnimatorListener {
        private C3198a() {
        }

        @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            CameraLog.m12954a("ThumbImageView", "ThumbReboundListener, onAnimationEnd, endNewThumbAnimation");
            ThumbImageView.this.f18118j = 0;
            if (ThumbImageView.this.f18130v != null) {
                ThumbImageView thumbImageView = ThumbImageView.this;
                thumbImageView.setImageDrawable(thumbImageView.f18130v);
            }
        }

        @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            CameraLog.m12954a("ThumbImageView", "ThumbReboundListener, onAnimationCancel, endNewThumbAnimation");
            ThumbImageView.this.f18118j = 0;
            if (ThumbImageView.this.f18130v != null) {
                ThumbImageView thumbImageView = ThumbImageView.this;
                thumbImageView.setImageDrawable(thumbImageView.f18130v);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18985a(int OplusGLSurfaceView_13, boolean z, int i2) {
        this.f18110b = OplusGLSurfaceView_13;
        this.f18107A = z;
        if (this.f18126r != null) {
            m18984a(i2, false);
            m18986a(this.f18126r, 0, this.f18124p, false);
        }
    }
}

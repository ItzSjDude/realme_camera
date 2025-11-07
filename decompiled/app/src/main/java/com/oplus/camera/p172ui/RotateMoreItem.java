package com.oplus.camera.p172ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class RotateMoreItem extends View {

    /* renamed from: A */
    private int f17252A;

    /* renamed from: B */
    private int f17253B;

    /* renamed from: C */
    private boolean f17254C;

    /* renamed from: D */
    private boolean f17255D;

    /* renamed from: PlatformImplementations.kt_3 */
    private final PathInterpolator f17256a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f17257b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f17258c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f17259d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f17260e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private long f17261f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private long f17262g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Bitmap f17263h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Bitmap f17264i;

    /* renamed from: OplusGLSurfaceView_15 */
    private String f17265j;

    /* renamed from: OplusGLSurfaceView_5 */
    private TextPaint f17266k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Paint f17267l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Paint f17268m;

    /* renamed from: OplusGLSurfaceView_11 */
    private Paint f17269n;

    /* renamed from: o */
    private ValueAnimator f17270o;

    /* renamed from: p */
    private ValueAnimator f17271p;

    /* renamed from: q */
    private int f17272q;

    /* renamed from: r */
    private int f17273r;

    /* renamed from: s */
    private int f17274s;

    /* renamed from: t */
    private int f17275t;

    /* renamed from: u */
    private int f17276u;

    /* renamed from: v */
    private int f17277v;

    /* renamed from: w */
    private int f17278w;

    /* renamed from: x */
    private int f17279x;

    /* renamed from: y */
    private float f17280y;

    /* renamed from: z */
    private float f17281z;

    public RotateMoreItem(Context context) {
        this(context, null);
    }

    public RotateMoreItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotateMoreItem(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17256a = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f17257b = 0;
        this.f17258c = 0;
        this.f17259d = 0;
        this.f17260e = false;
        this.f17261f = 0L;
        this.f17262g = 0L;
        this.f17263h = null;
        this.f17264i = null;
        this.f17265j = null;
        this.f17266k = null;
        this.f17267l = null;
        this.f17268m = null;
        this.f17269n = null;
        this.f17270o = null;
        this.f17271p = null;
        this.f17272q = 0;
        this.f17273r = 0;
        this.f17274s = 0;
        this.f17275t = 0;
        this.f17276u = 0;
        this.f17277v = 0;
        this.f17278w = 0;
        this.f17279x = 0;
        this.f17280y = 0.0f;
        this.f17281z = 0.0f;
        this.f17252A = 0;
        this.f17253B = 0;
        this.f17254C = false;
        this.f17255D = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RotateMoreItem, OplusGLSurfaceView_13, 0);
        this.f17272q = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 32);
        this.f17273r = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 32);
        this.f17253B = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 8);
        this.f17275t = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 32);
        this.f17276u = typedArrayObtainStyledAttributes.getColor(0, -1);
        this.f17277v = typedArrayObtainStyledAttributes.getInt(6, 1);
        this.f17281z = typedArrayObtainStyledAttributes.getDimension(8, 12.0f);
        this.f17278w = typedArrayObtainStyledAttributes.getColor(5, -1);
        this.f17279x = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, 70);
        this.f17252A = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, 10);
        typedArrayObtainStyledAttributes.recycle();
        m18353b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m18353b() throws Resources.NotFoundException {
        if (this.f17266k != null) {
            return;
        }
        this.f17266k = new TextPaint();
        this.f17266k.setTextSize(this.f17281z);
        this.f17266k.setColor(this.f17278w);
        this.f17266k.setStyle(Paint.Style.FILL);
        this.f17266k.setFlags(1);
        this.f17266k.setTypeface(Util.m24411c(true));
        this.f17266k.setShadowLayer(getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_text_shadow_radius), 0.0f, getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_text_shadow_y), getResources().getColor(R.color.num_seekbar_thumb_text_shadow_color, null));
        this.f17267l = new Paint();
        this.f17267l.setAntiAlias(false);
        this.f17267l.setColor(-65536);
        this.f17268m = new Paint();
        this.f17268m.setAntiAlias(true);
        this.f17268m.setColor(this.f17276u);
        m18354c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m18354c() throws Resources.NotFoundException {
        this.f17269n = new Paint();
        this.f17269n.setAntiAlias(true);
        this.f17269n.setColor(-1);
        this.f17269n.setStyle(Paint.Style.STROKE);
        float dimension = getResources().getDimension(R.dimen.makeup_item_highlight_stroke_width);
        this.f17269n.setStrokeWidth(dimension);
        this.f17280y = getResources().getDimension(R.dimen.multicamera_layout_select_frame_radius) - (dimension / 2.0f);
        this.f17270o = ValueAnimator.ofInt(0, 255);
        this.f17270o.setDuration(250L);
        this.f17270o.setInterpolator(this.f17256a);
        this.f17270o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.RotateMoreItem.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RotateMoreItem.this.f17269n.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                RotateMoreItem.this.postInvalidate();
            }
        });
        this.f17270o.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.RotateMoreItem.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                RotateMoreItem.this.f17255D = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RotateMoreItem.this.f17269n.setAlpha(255);
            }
        });
        this.f17271p = ValueAnimator.ofInt(255, 0);
        this.f17271p.setDuration(250L);
        this.f17271p.setInterpolator(this.f17256a);
        this.f17271p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.RotateMoreItem.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RotateMoreItem.this.f17269n.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                RotateMoreItem.this.postInvalidate();
            }
        });
        this.f17271p.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.RotateMoreItem.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                RotateMoreItem.this.f17255D = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RotateMoreItem.this.f17255D = false;
                RotateMoreItem.this.f17269n.setAlpha(0);
            }
        });
    }

    public void setText(String str) {
        this.f17265j = str;
        setContentDescription(str);
    }

    public void setFrameShow(boolean z) {
        if (this.f17255D == z) {
            return;
        }
        if (z) {
            ValueAnimator valueAnimator = this.f17271p;
            if (valueAnimator != null && valueAnimator.isStarted()) {
                this.f17271p.cancel();
            }
            this.f17270o.start();
            return;
        }
        ValueAnimator valueAnimator2 = this.f17270o;
        if (valueAnimator2 != null && valueAnimator2.isStarted()) {
            this.f17270o.cancel();
        }
        this.f17271p.start();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        Bitmap bitmap = this.f17263h;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f17263h.recycle();
    }

    public void setImage(Bitmap bitmap) {
        Bitmap bitmap2 = this.f17263h;
        if (bitmap == bitmap2) {
            return;
        }
        if (bitmap2 != null) {
            if (!bitmap2.isRecycled()) {
                this.f17263h.recycle();
            }
            this.f17263h = null;
        }
        this.f17263h = bitmap;
    }

    public void setSubscriptHint(Bitmap bitmap) {
        if (bitmap == null && this.f17264i == null) {
            return;
        }
        Bitmap bitmap2 = this.f17264i;
        if (bitmap2 != null) {
            if (!bitmap2.isRecycled()) {
                this.f17264i.recycle();
            }
            this.f17264i = null;
        }
        this.f17264i = bitmap;
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m18356a() {
        return this.f17264i != null;
    }

    public void setSubscriptHintRTL(boolean z) {
        this.f17254C = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18355a(int OplusGLSurfaceView_13, int i2) {
        int i3;
        this.f17257b = OplusGLSurfaceView_13;
        if (i2 >= 0) {
            i3 = i2 % 360;
        } else {
            i3 = (i2 % 360) + 360;
        }
        this.f17259d = i3;
        this.f17258c = this.f17257b;
        this.f17261f = AnimationUtils.currentAnimationTimeMillis();
        int i4 = this.f17259d - this.f17257b;
        if (i4 < 0) {
            i4 += 360;
        }
        if (i4 > 180) {
            i4 -= 360;
        }
        this.f17260e = i4 >= 0;
        this.f17262g = this.f17261f + ((Math.abs(i4) * 1000) / 270);
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap m18350a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        float COUIBaseListPopupWindow_12 = 1.0f;
        if (width > this.f17272q || height > this.f17273r) {
            COUIBaseListPopupWindow_12 = this.f17272q / width;
            float f2 = this.f17273r / height;
            if (COUIBaseListPopupWindow_12 >= f2) {
                COUIBaseListPopupWindow_12 = f2;
            }
        }
        Matrix matrix = new Matrix();
        matrix.postScale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) throws Resources.NotFoundException {
        int OplusGLSurfaceView_13;
        if (this.f17257b != this.f17259d) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.f17262g) {
                int i2 = (int) (jCurrentAnimationTimeMillis - this.f17261f);
                int i3 = this.f17258c;
                if (!this.f17260e) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 270) / 1000);
                if (i4 >= 0) {
                    OplusGLSurfaceView_13 = i4 % 360;
                } else {
                    OplusGLSurfaceView_13 = (i4 % 360) + 360;
                }
                this.f17257b = OplusGLSurfaceView_13;
                invalidate();
            } else {
                this.f17257b = this.f17259d;
            }
        }
        canvas.rotate(-this.f17257b, getWidth() * 0.5f, getHeight() * 0.5f);
        Bitmap bitmapM18350a = m18350a(this.f17263h);
        float width = getWidth() * 0.5f;
        int i5 = this.f17275t;
        float COUIBaseListPopupWindow_12 = this.f17252A + i5;
        Paint paint = this.f17268m;
        if (paint != null) {
            canvas.drawCircle(width, COUIBaseListPopupWindow_12, i5, paint);
        }
        if (this.f17255D) {
            canvas.drawCircle(width, COUIBaseListPopupWindow_12, this.f17280y, this.f17269n);
        }
        if (bitmapM18350a != null) {
            canvas.drawBitmap(bitmapM18350a, (getWidth() - bitmapM18350a.getWidth()) * 0.5f, (((this.f17275t * 2) - bitmapM18350a.getHeight()) * 0.5f) + this.f17252A, (Paint) null);
        }
        if (m18350a(this.f17264i) != null && bitmapM18350a != null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.rotate_item_radius);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.rotate_item_red_dot_offset);
            float width2 = ((getWidth() * 0.5f) + this.f17275t) - dimensionPixelSize2;
            float f2 = this.f17252A + dimensionPixelSize2;
            Paint paint2 = this.f17267l;
            if (paint2 != null) {
                canvas.drawCircle(width2, f2, dimensionPixelSize, paint2);
            }
        }
        canvas.save();
        if (TextUtils.isEmpty(this.f17265j)) {
            return;
        }
        String str = this.f17265j;
        StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(str, 0, str.length(), this.f17266k, this.f17279x).setMaxLines(this.f17277v).setAlignment(Layout.Alignment.ALIGN_CENTER).setEllipsize(TextUtils.TruncateAt.END).setTextDirection(TextDirectionHeuristics.LOCALE).build();
        canvas.translate((getWidth() - this.f17279x) * 0.5f, (this.f17275t * 2) + this.f17253B + this.f17252A);
        staticLayoutBuild.draw(canvas);
        canvas.restore();
    }

    public String getName() {
        return this.f17265j;
    }

    public void setTextColor(int OplusGLSurfaceView_13) {
        this.f17278w = OplusGLSurfaceView_13;
        this.f17266k.setColor(OplusGLSurfaceView_13);
    }

    public int getTargetDegree() {
        return this.f17259d;
    }
}

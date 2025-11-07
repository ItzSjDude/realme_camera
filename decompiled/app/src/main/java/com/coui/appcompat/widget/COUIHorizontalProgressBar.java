package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.coui.appcompat.p099a.COUIContextUtil;
import com.coui.appcompat.p099a.COUIStateListUtil;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIHorizontalProgressBar extends ProgressBar {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int f7334a = Color.argb(12, 0, 0, 0);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final int f7335b = Color.parseColor("#FF2AD181");

    /* renamed from: OplusGLSurfaceView_6 */
    private static final int[] f7336m = {R.attr.couiSeekBarProgressColorDisabled};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Paint f7337c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ColorStateList f7338d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ColorStateList f7339e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private RectF f7340f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private RectF f7341g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f7342h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Path f7343i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Path f7344j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f7345k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Context f7346l;

    public COUIHorizontalProgressBar(Context context) {
        this(context, null);
    }

    public COUIHorizontalProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiHorizontalProgressBarStyle);
    }

    public COUIHorizontalProgressBar(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, R.attr.couiHorizontalProgressBarStyle);
        this.f7337c = new Paint();
        this.f7340f = new RectF();
        this.f7341g = new RectF();
        this.f7342h = Integer.MAX_VALUE;
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.f7345k = attributeSet.getStyleAttribute();
        } else {
            this.f7345k = OplusGLSurfaceView_13;
        }
        this.f7346l = context;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(f7336m);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.COUIHorizontalProgressBar, OplusGLSurfaceView_13, 0);
        this.f7338d = typedArrayObtainStyledAttributes2.getColorStateList(R.styleable.f24471x75ab1a90);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f7339e = typedArrayObtainStyledAttributes2.getColorStateList(R.styleable.f24472x6e51a7b1);
        } else {
            this.f7339e = COUIStateListUtil.m6465a(COUIContextUtil.m6399a(context, R.attr.couiTintControlNormal, 0), color);
        }
        typedArrayObtainStyledAttributes2.recycle();
        this.f7337c.setDither(true);
        this.f7337c.setAntiAlias(true);
        setLayerType(1, this.f7337c);
        this.f7343i = new Path();
        this.f7344j = new Path();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        int paddingRight = (OplusGLSurfaceView_13 - getPaddingRight()) - getPaddingLeft();
        int paddingTop = (i2 - getPaddingTop()) - getPaddingBottom();
        this.f7342h = paddingRight >= paddingTop ? paddingTop / 2 : paddingRight / 2;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f7344j.reset();
        this.f7343i.reset();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        this.f7337c.setColor(m7141a(this.f7338d, f7334a));
        this.f7340f.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        RectF rectF = this.f7340f;
        int OplusGLSurfaceView_13 = this.f7342h;
        canvas.drawRoundRect(rectF, OplusGLSurfaceView_13, OplusGLSurfaceView_13, this.f7337c);
        Path path = this.f7343i;
        RectF rectF2 = this.f7340f;
        int i2 = this.f7342h;
        path.addRoundRect(rectF2, i2, i2, Path.Direction.CCW);
        boolean z = Build.VERSION.SDK_INT >= 19;
        float progress = getProgress() / getMax();
        if (isLayoutRtl()) {
            if (z) {
                this.f7341g.set(Math.round((getWidth() - getPaddingRight()) - (progress * width)), getPaddingTop(), r1 + width, getHeight() - getPaddingBottom());
            } else {
                this.f7341g.set(getPaddingLeft() + ((1.0f - progress) * width), getPaddingTop(), getPaddingLeft() + width, getHeight() - getPaddingBottom());
            }
        } else if (z) {
            this.f7341g.set(Math.round(getPaddingLeft() - ((1.0f - progress) * width)), getPaddingTop(), r1 + width, getHeight() - getPaddingBottom());
        } else {
            this.f7341g.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (progress * width), getHeight() - getPaddingBottom());
        }
        this.f7337c.setColor(m7141a(this.f7339e, f7335b));
        if (Build.VERSION.SDK_INT >= 19) {
            Path path2 = this.f7344j;
            RectF rectF3 = this.f7341g;
            int i3 = this.f7342h;
            path2.addRoundRect(rectF3, i3, i3, Path.Direction.CCW);
            this.f7344j.op(this.f7343i, Path.Op.INTERSECT);
            canvas.drawPath(this.f7344j, this.f7337c);
            return;
        }
        RectF rectF4 = this.f7341g;
        int i4 = this.f7342h;
        canvas.drawRoundRect(rectF4, i4, i4, this.f7337c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7141a(ColorStateList colorStateList, int OplusGLSurfaceView_13) {
        return colorStateList == null ? OplusGLSurfaceView_13 : colorStateList.getColorForState(getDrawableState(), OplusGLSurfaceView_13);
    }

    public boolean isLayoutRtl() {
        return Build.VERSION.SDK_INT > 16 && getLayoutDirection() == 1;
    }

    public void setProgressColor(ColorStateList colorStateList) {
        this.f7339e = colorStateList;
    }
}

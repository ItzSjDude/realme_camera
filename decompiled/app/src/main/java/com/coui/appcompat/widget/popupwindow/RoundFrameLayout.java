package com.coui.appcompat.widget.popupwindow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class RoundFrameLayout extends FrameLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private Path f8474a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Paint f8475b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RectF f8476c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float f8477d;

    public RoundFrameLayout(Context context) {
        this(context, null);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundFrameLayout);
        this.f8477d = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundFrameLayout_rfRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.f8474a = new Path();
        this.f8475b = new Paint(1);
        this.f8476c = new RectF();
        this.f8475b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void setRadius(float COUIBaseListPopupWindow_12) {
        this.f8477d = COUIBaseListPopupWindow_12;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        this.f8476c.set(getPaddingLeft(), getPaddingTop(), OplusGLSurfaceView_13 - getPaddingRight(), i2 - getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            m8021b(canvas);
        } else {
            m8020a(canvas);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8020a(Canvas canvas) {
        canvas.saveLayer(this.f8476c, null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(m8019a(), this.f8475b);
        canvas.restore();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m8021b(Canvas canvas) {
        canvas.save();
        canvas.clipPath(m8019a());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Path m8019a() {
        this.f8474a.reset();
        Path path = this.f8474a;
        RectF rectF = this.f8476c;
        float COUIBaseListPopupWindow_12 = this.f8477d;
        path.addRoundRect(rectF, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, Path.Direction.CW);
        return this.f8474a;
    }
}

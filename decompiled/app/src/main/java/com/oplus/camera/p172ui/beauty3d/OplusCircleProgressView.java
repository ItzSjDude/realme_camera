package com.oplus.camera.p172ui.beauty3d;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class OplusCircleProgressView extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private Paint f17616a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Paint f17617b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RectF f17618c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f17619d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f17620e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f17621f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int[] f17622g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f17623h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f17624i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f17625j;

    /* renamed from: OplusGLSurfaceView_5 */
    private LinearGradient f17626k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Point f17627l;

    public OplusCircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17616a = null;
        this.f17617b = null;
        this.f17618c = null;
        this.f17619d = 0;
        this.f17620e = 0;
        this.f17621f = 0;
        this.f17622g = new int[2];
        this.f17623h = 0;
        this.f17624i = 0;
        this.f17625j = 0;
        this.f17626k = null;
        this.f17627l = null;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.shapeCircleProgress);
        this.f17620e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f17621f = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        CameraLog.m12954a("OplusCircleProgressView", "OplusCircleProgressView, mDiameter: " + this.f17620e + ", mRingWidth: " + this.f17621f);
        this.f17622g[0] = typedArrayObtainStyledAttributes.getColor(3, 0);
        this.f17622g[1] = typedArrayObtainStyledAttributes.getColor(1, 0);
        this.f17623h = context.getColor(R.color.beauty3d_progress_background);
        typedArrayObtainStyledAttributes.recycle();
        m18569a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18569a() {
        this.f17616a = new Paint();
        this.f17617b = new Paint();
        this.f17618c = new RectF();
        this.f17616a.setAntiAlias(true);
        this.f17616a.setStrokeWidth(this.f17621f);
        this.f17616a.setStyle(Paint.Style.STROKE);
        this.f17616a.setStrokeCap(Paint.Cap.ROUND);
        this.f17616a.setColor(0);
        this.f17617b.setAntiAlias(true);
        this.f17617b.setStrokeWidth(this.f17621f);
        this.f17617b.setStyle(Paint.Style.STROKE);
        this.f17617b.setStrokeCap(Paint.Cap.ROUND);
        this.f17617b.setColor(this.f17623h);
        this.f17616a.setColor(getResources().getColor(R.color.beauty3d_progress_start));
    }

    public Point getCenterPoint() {
        if (this.f17627l == null) {
            this.f17627l = new Point(this.f17624i, this.f17625j);
        }
        return this.f17627l;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int OplusGLSurfaceView_13 = this.f17620e;
        int i2 = this.f17621f;
        int i3 = (OplusGLSurfaceView_13 / 2) + i2;
        int i4 = (OplusGLSurfaceView_13 / 2) + i2;
        canvas.rotate(-90.0f, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
        RectF rectF = this.f17618c;
        int i5 = this.f17624i;
        int i6 = this.f17625j;
        rectF.set(i5 - i3, i6 - i4, i5 + i3, i6 + i4);
        canvas.drawArc(this.f17618c, 0.0f, 360.0f, false, this.f17617b);
        this.f17616a.setShader(this.f17626k);
        canvas.drawArc(this.f17618c, 0.0f, (this.f17619d / 100.0f) * 360.0f, false, this.f17616a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18570a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 >= 100) {
            OplusGLSurfaceView_13 = 100;
        }
        CameraLog.m12954a("OplusCircleProgressView", "progressInvalidate, progressValue: " + OplusGLSurfaceView_13);
        this.f17619d = OplusGLSurfaceView_13;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f17624i = (i3 - OplusGLSurfaceView_13) / 2;
        this.f17625j = (i4 - i2) / 2;
        CameraLog.m12954a("OplusCircleProgressView", "onLayout, mCenterX: " + this.f17624i + ", mCenterY: " + this.f17625j);
        int i5 = (this.f17620e / 2) + this.f17621f;
        int i6 = this.f17624i;
        int i7 = this.f17625j;
        this.f17626k = new LinearGradient((float) (i6 + i5), (float) i7, (float) i6, (float) (i7 + i5), this.f17622g, (float[]) null, Shader.TileMode.CLAMP);
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
    }
}

package com.oplus.camera.photo3d.p159ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Path;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes2.dex */
public final class GifView extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private long f15234a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f15235b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f15236c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f15237d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f15238e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f15239f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f15240g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f15241h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f15242i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f15243j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Movie f15244k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Path f15245l;

    public GifView(Context context) {
        this(context, null, 0);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f15242i = true;
        this.f15243j = true;
        this.f15245l = new Path();
    }

    public void setGifResource(int OplusGLSurfaceView_13) {
        this.f15235b = OplusGLSurfaceView_13;
        this.f15244k = Movie.decodeStream(getResources().openRawResource(this.f15235b));
        requestLayout();
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        if (z) {
            m15251c();
        } else {
            m15252d();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m15249a() {
        return this.f15242i;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final boolean m15250b() {
        return !this.f15242i;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final void m15251c() {
        if (m15249a()) {
            this.f15242i = false;
            this.f15234a = SystemClock.uptimeMillis() - this.f15238e;
            invalidate();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final void m15252d() {
        if (m15250b()) {
            this.f15242i = true;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        Movie movie = this.f15244k;
        if (movie == null) {
            super.onMeasure(OplusGLSurfaceView_13, i2);
            return;
        }
        this.f15241h = 1.0f / Math.max(m15245a(i2, movie.height()), m15245a(OplusGLSurfaceView_13, this.f15244k.width()));
        this.f15236c = (int) (this.f15244k.width() * this.f15241h);
        this.f15237d = (int) (this.f15244k.height() * this.f15241h);
        setMeasuredDimension(this.f15236c, this.f15237d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m15245a(int OplusGLSurfaceView_13, int i2) {
        if (View.MeasureSpec.getMode(OplusGLSurfaceView_13) == 0) {
            return 1.0f;
        }
        return i2 / View.MeasureSpec.getSize(OplusGLSurfaceView_13);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        this.f15239f = (getWidth() - this.f15236c) / 2.0f;
        this.f15240g = (getHeight() - this.f15237d) / 2.0f;
        this.f15243j = getVisibility() == 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f15244k == null) {
            super.onDraw(canvas);
        } else {
            if (this.f15242i) {
                m15246a(canvas);
                return;
            }
            m15248f();
            m15246a(canvas);
            m15247e();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final void m15247e() {
        if (this.f15243j) {
            postInvalidateOnAnimation();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final void m15248f() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long OplusGLSurfaceView_15 = this.f15234a;
        if (OplusGLSurfaceView_15 == 0) {
            OplusGLSurfaceView_15 = jUptimeMillis;
        }
        this.f15234a = OplusGLSurfaceView_15;
        int iDuration = this.f15244k.duration() == 0 ? 1000 : this.f15244k.duration();
        long j2 = jUptimeMillis - this.f15234a;
        this.f15238e = j2 > ((long) iDuration) ? 0 : (int) j2;
        this.f15242i = this.f15238e == 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final void m15246a(Canvas canvas) {
        this.f15244k.setTime(this.f15238e);
        canvas.save();
        this.f15245l.addCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth(), getHeight()) / 2, Path.Direction.CCW);
        canvas.clipPath(this.f15245l);
        float COUIBaseListPopupWindow_12 = this.f15241h;
        canvas.scale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
        this.f15244k.draw(canvas, this.f15239f, this.f15240g);
        canvas.restore();
    }

    @Override // android.view.View
    public void onScreenStateChanged(int OplusGLSurfaceView_13) {
        super.onScreenStateChanged(OplusGLSurfaceView_13);
        this.f15243j = OplusGLSurfaceView_13 == 1;
        m15247e();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int OplusGLSurfaceView_13) {
        super.onVisibilityChanged(view, OplusGLSurfaceView_13);
        this.f15243j = OplusGLSurfaceView_13 == 0;
        m15247e();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int OplusGLSurfaceView_13) {
        super.onWindowVisibilityChanged(OplusGLSurfaceView_13);
        this.f15243j = OplusGLSurfaceView_13 == 0;
        m15247e();
    }
}

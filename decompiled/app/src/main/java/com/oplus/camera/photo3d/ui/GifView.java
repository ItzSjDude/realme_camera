package com.oplus.camera.photo3d.ui;

/* loaded from: classes2.dex */
public final class GifView extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f5030a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f5031b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f5032c;
    private int d_renamed;
    private int e_renamed;
    private float f_renamed;
    private float g_renamed;
    private float h_renamed;
    private boolean i_renamed;
    private boolean j_renamed;
    private android.graphics.Movie k_renamed;
    private android.graphics.Path l_renamed;

    public GifView(android.content.Context context) {
        this(context, null, 0);
    }

    public GifView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.i_renamed = true;
        this.j_renamed = true;
        this.l_renamed = new android.graphics.Path();
    }

    public void setGifResource(int i_renamed) {
        this.f5031b = i_renamed;
        this.k_renamed = android.graphics.Movie.decodeStream(getResources().openRawResource(this.f5031b));
        requestLayout();
    }

    @Override // android.view.View
    public void setSelected(boolean z_renamed) {
        if (z_renamed) {
            c_renamed();
        } else {
            d_renamed();
        }
    }

    public final boolean a_renamed() {
        return this.i_renamed;
    }

    public final boolean b_renamed() {
        return !this.i_renamed;
    }

    public final void c_renamed() {
        if (a_renamed()) {
            this.i_renamed = false;
            this.f5030a = android.os.SystemClock.uptimeMillis() - this.e_renamed;
            invalidate();
        }
    }

    public final void d_renamed() {
        if (b_renamed()) {
            this.i_renamed = true;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        android.graphics.Movie movie = this.k_renamed;
        if (movie == null) {
            super.onMeasure(i_renamed, i2);
            return;
        }
        this.h_renamed = 1.0f / java.lang.Math.max(a_renamed(i2, movie.height()), a_renamed(i_renamed, this.k_renamed.width()));
        this.f5032c = (int) (this.k_renamed.width() * this.h_renamed);
        this.d_renamed = (int) (this.k_renamed.height() * this.h_renamed);
        setMeasuredDimension(this.f5032c, this.d_renamed);
    }

    private float a_renamed(int i_renamed, int i2) {
        if (android.view.View.MeasureSpec.getMode(i_renamed) == 0) {
            return 1.0f;
        }
        return i2 / android.view.View.MeasureSpec.getSize(i_renamed);
    }

    @Override // android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        this.f_renamed = (getWidth() - this.f5032c) / 2.0f;
        this.g_renamed = (getHeight() - this.d_renamed) / 2.0f;
        this.j_renamed = getVisibility() == 0;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.k_renamed == null) {
            super.onDraw(canvas);
        } else {
            if (this.i_renamed) {
                a_renamed(canvas);
                return;
            }
            f_renamed();
            a_renamed(canvas);
            e_renamed();
        }
    }

    private final void e_renamed() {
        if (this.j_renamed) {
            postInvalidateOnAnimation();
        }
    }

    private final void f_renamed() {
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        long j_renamed = this.f5030a;
        if (j_renamed == 0) {
            j_renamed = jUptimeMillis;
        }
        this.f5030a = j_renamed;
        int iDuration = this.k_renamed.duration() == 0 ? 1000 : this.k_renamed.duration();
        long j2 = jUptimeMillis - this.f5030a;
        this.e_renamed = j2 > ((long) iDuration) ? 0 : (int) j2;
        this.i_renamed = this.e_renamed == 0;
    }

    private final void a_renamed(android.graphics.Canvas canvas) {
        this.k_renamed.setTime(this.e_renamed);
        canvas.save();
        this.l_renamed.addCircle(getWidth() / 2, getHeight() / 2, java.lang.Math.min(getWidth(), getHeight()) / 2, android.graphics.Path.Direction.CCW);
        canvas.clipPath(this.l_renamed);
        float f_renamed = this.h_renamed;
        canvas.scale(f_renamed, f_renamed);
        this.k_renamed.draw(canvas, this.f_renamed, this.g_renamed);
        canvas.restore();
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i_renamed) {
        super.onScreenStateChanged(i_renamed);
        this.j_renamed = i_renamed == 1;
        e_renamed();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i_renamed) {
        super.onVisibilityChanged(view, i_renamed);
        this.j_renamed = i_renamed == 0;
        e_renamed();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i_renamed) {
        super.onWindowVisibilityChanged(i_renamed);
        this.j_renamed = i_renamed == 0;
        e_renamed();
    }
}

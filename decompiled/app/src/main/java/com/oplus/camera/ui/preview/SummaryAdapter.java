package com.oplus.camera.ui.preview;

/* compiled from: SuperTextFrameView.java */
/* loaded from: classes2.dex */
public class z_renamed extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.PointF[] f7163a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Paint f7164b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Path f7165c;
    private android.graphics.Path d_renamed;
    private boolean e_renamed;
    private int f_renamed;
    private int g_renamed;
    private android.os.Handler h_renamed;
    private int i_renamed;
    private int j_renamed;

    public z_renamed(android.content.Context context) {
        super(context);
        this.f7163a = null;
        this.f7164b = null;
        this.f7165c = null;
        this.d_renamed = null;
        this.e_renamed = false;
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        this.f7164b = new android.graphics.Paint(1);
        this.f7165c = new android.graphics.Path();
        this.d_renamed = new android.graphics.Path();
        this.f_renamed = com.oplus.camera.util.Util.A_renamed(context);
        this.g_renamed = this.f_renamed & 452984831;
        this.h_renamed = new android.os.Handler(android.os.Looper.getMainLooper());
    }

    public void setMStrokeColor(int i_renamed) {
        this.f_renamed = i_renamed;
        invalidate();
    }

    public void setMSolidColor(int i_renamed) {
        this.g_renamed = i_renamed;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        android.graphics.PointF[] pointFArr = this.f7163a;
        if (pointFArr == null || pointFArr.length != 4) {
            canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
            return;
        }
        canvas.save();
        this.i_renamed = getWidth();
        this.j_renamed = getHeight();
        this.f7164b.setAntiAlias(true);
        this.f7164b.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        this.f7164b.setColor(this.g_renamed);
        this.f7165c.reset();
        this.f7165c.moveTo(this.f7163a[0].x_renamed * this.i_renamed, this.f7163a[0].y_renamed * this.j_renamed);
        this.f7165c.lineTo(this.f7163a[1].x_renamed * this.i_renamed, this.f7163a[1].y_renamed * this.j_renamed);
        this.f7165c.lineTo(this.f7163a[2].x_renamed * this.i_renamed, this.f7163a[2].y_renamed * this.j_renamed);
        this.f7165c.lineTo(this.f7163a[3].x_renamed * this.i_renamed, this.f7163a[3].y_renamed * this.j_renamed);
        this.f7165c.close();
        canvas.drawPath(this.f7165c, this.f7164b);
        this.f7164b.setStyle(android.graphics.Paint.Style.STROKE);
        this.f7164b.setStrokeWidth(4.0f);
        this.f7164b.setColor(this.f_renamed);
        this.d_renamed.reset();
        this.d_renamed.moveTo(this.f7163a[0].x_renamed * this.i_renamed, this.f7163a[0].y_renamed * this.j_renamed);
        this.d_renamed.lineTo(this.f7163a[1].x_renamed * this.i_renamed, this.f7163a[1].y_renamed * this.j_renamed);
        this.d_renamed.lineTo(this.f7163a[2].x_renamed * this.i_renamed, this.f7163a[2].y_renamed * this.j_renamed);
        this.d_renamed.lineTo(this.f7163a[3].x_renamed * this.i_renamed, this.f7163a[3].y_renamed * this.j_renamed);
        this.d_renamed.close();
        canvas.drawPath(this.d_renamed, this.f7164b);
        canvas.restore();
    }

    public void setPointsArray(android.graphics.PointF[] pointFArr) {
        if (pointFArr == null || this.e_renamed) {
            this.f7163a = null;
            this.d_renamed.reset();
            this.f7165c.reset();
            invalidate();
            return;
        }
        this.f7163a = pointFArr;
        invalidate();
    }

    public void a_renamed(com.oplus.camera.u_renamed.a_renamed aVar) {
        com.oplus.camera.e_renamed.a_renamed("SuperTextFrameView", "executeAnimation, mPointsArray: " + java.util.Arrays.toString(this.f7163a));
        this.f7163a = aVar.b_renamed();
        setVisibility(0);
    }
}

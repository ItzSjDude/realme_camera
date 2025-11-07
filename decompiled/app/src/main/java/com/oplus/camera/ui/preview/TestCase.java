package com.oplus.camera.ui.preview;

/* compiled from: BlurCoverBg.java */
/* loaded from: classes2.dex */
public class e_renamed extends android.widget.ImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f7025a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7026b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f7027c;
    private android.graphics.Paint d_renamed;
    private android.graphics.Rect e_renamed;
    private android.graphics.Rect f_renamed;

    public e_renamed(android.content.Context context) {
        super(context);
        this.f7025a = 0;
        this.f7026b = 0;
        this.f7027c = 0;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.d_renamed == null) {
            this.d_renamed = new android.graphics.Paint();
        }
        this.d_renamed.setColor(this.f7027c);
        android.graphics.Rect rect = this.e_renamed;
        if (rect == null) {
            this.e_renamed = new android.graphics.Rect(0, 0, getWidth(), this.f7025a);
        } else {
            rect.set(0, 0, getWidth(), this.f7025a);
        }
        android.graphics.Rect rect2 = this.f_renamed;
        if (rect2 == null) {
            this.f_renamed = new android.graphics.Rect(0, this.f7026b, getWidth(), getHeight());
        } else {
            rect2.set(0, this.f7026b, getWidth(), getHeight());
        }
        canvas.drawRect(this.e_renamed, this.d_renamed);
        canvas.drawRect(this.f_renamed, this.d_renamed);
    }

    public void a_renamed(int i_renamed, int i2) {
        this.f7025a = com.oplus.camera.util.Util.N_renamed() + i_renamed;
        this.f7026b = this.f7025a + i2;
    }

    public void setDrawColor(int i_renamed) {
        this.f7027c = i_renamed;
    }
}

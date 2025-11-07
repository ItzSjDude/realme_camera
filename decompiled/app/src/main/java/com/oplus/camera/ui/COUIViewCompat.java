package com.oplus.camera.ui;

/* compiled from: RotableViewWithText.java */
/* loaded from: classes2.dex */
public class t_renamed extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f7177a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7178b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f7179c;
    private int d_renamed;
    private boolean e_renamed;
    private boolean f_renamed;
    private long g_renamed;
    private long h_renamed;
    private android.graphics.Bitmap i_renamed;
    private java.lang.String j_renamed;
    private android.graphics.Paint k_renamed;

    public t_renamed(android.content.Context context) {
        this(context, null);
    }

    public t_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public t_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f7177a = 0;
        this.f7178b = 0;
        this.f7179c = 0;
        this.d_renamed = 0;
        this.e_renamed = false;
        this.f_renamed = true;
        this.g_renamed = 0L;
        this.h_renamed = 0L;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.k_renamed = new android.graphics.Paint();
        this.k_renamed.setTextSize(getContext().getResources().getDimension(com.oplus.camera.R_renamed.dimen.rotableview_text_size));
        this.k_renamed.setColor(getContext().getColor(com.oplus.camera.R_renamed.color.camera_white));
        this.k_renamed.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.k_renamed.setFlags(1);
    }

    public void setText(java.lang.String str) {
        this.j_renamed = str;
    }

    public void setImage(android.graphics.Bitmap bitmap) {
        this.i_renamed = bitmap;
    }

    public void setViewGap(int i_renamed) {
        this.d_renamed = i_renamed;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        int i2;
        if (isShown()) {
            this.f_renamed = z_renamed;
        } else {
            this.f_renamed = false;
        }
        if (i_renamed >= 0) {
            i2 = i_renamed % 360;
        } else {
            i2 = (i_renamed % 360) + 360;
        }
        if (i2 == this.f7179c) {
            return;
        }
        this.f7179c = i2;
        if (this.f_renamed) {
            this.f7178b = this.f7177a;
            this.g_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f7179c - this.f7177a;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.e_renamed = i3 >= 0;
            this.h_renamed = this.g_renamed + ((java.lang.Math.abs(i3) * 1000) / 270);
        } else {
            this.f7177a = this.f7179c;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        int height;
        int i_renamed;
        if (this.f7177a != this.f7179c) {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.h_renamed) {
                int i2 = (int) (jCurrentAnimationTimeMillis - this.g_renamed);
                int i3 = this.f7178b;
                if (!this.e_renamed) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 270) / 1000);
                if (i4 >= 0) {
                    i_renamed = i4 % 360;
                } else {
                    i_renamed = (i4 % 360) + 360;
                }
                this.f7177a = i_renamed;
                invalidate();
            } else {
                this.f7177a = this.f7179c;
            }
        }
        canvas.rotate(-this.f7177a, getWidth() / 2, getHeight() / 2);
        boolean zIsEmpty = android.text.TextUtils.isEmpty(this.j_renamed);
        int i5 = (int) (this.k_renamed.getFontMetrics().bottom - this.k_renamed.getFontMetrics().top);
        int i6 = this.d_renamed;
        if (!zIsEmpty) {
            canvas.drawText(this.j_renamed, getWidth() / 2.0f, ((getHeight() - (this.i_renamed.getHeight() + i6)) / 2) + this.i_renamed.getHeight() + i6 + (i5 / 2), this.k_renamed);
        }
        if (this.i_renamed != null) {
            int width = (getWidth() - this.i_renamed.getWidth()) / 2;
            if (zIsEmpty) {
                height = (getHeight() - this.i_renamed.getHeight()) / 2;
            } else {
                height = (getHeight() - ((this.i_renamed.getHeight() + i5) + i6)) / 2;
            }
            canvas.drawBitmap(this.i_renamed, width, height, (android.graphics.Paint) null);
        }
    }
}

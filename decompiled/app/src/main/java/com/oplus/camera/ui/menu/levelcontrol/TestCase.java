package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: CameraImageButton.java */
/* loaded from: classes2.dex */
public class e_renamed extends android.widget.ImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Paint f6517a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.drawable.Drawable f6518b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.drawable.Drawable f6519c;
    private android.graphics.drawable.Drawable d_renamed;
    private int e_renamed;
    private java.lang.String f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private long j_renamed;
    private long k_renamed;
    private float l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i_renamed, android.view.KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i_renamed, android.view.KeyEvent keyEvent) {
        return false;
    }

    public void setNormalShape(boolean z_renamed) {
        this.n_renamed = z_renamed;
    }

    public void setBaseShape(boolean z_renamed) {
        this.o_renamed = z_renamed;
    }

    public e_renamed(android.content.Context context) {
        super(context);
        this.f6518b = null;
        this.f6519c = null;
        this.d_renamed = null;
        this.e_renamed = 0;
        this.f_renamed = "";
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0L;
        this.k_renamed = 0L;
        this.l_renamed = 0.0f;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = false;
        a_renamed();
    }

    private void a_renamed() {
        android.content.res.Resources resources = getContext().getResources();
        this.l_renamed = (resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.level_pop_text_circle_diameter) / 2) + resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.level_pop_text_circle_margin_right);
    }

    private void a_renamed(java.lang.String str) {
        if (str == null) {
            return;
        }
        if (this.f6517a == null) {
            android.content.res.Resources resources = getContext().getResources();
            this.f6517a = new android.graphics.Paint(1);
            this.f6517a.setTextSize(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_tool_item_text_size));
            this.f6517a.setColor(-1);
            this.f6517a.setShadowLayer(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.level_pop_text_shadow_radius), 0.0f, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.level_pop_text_shadow_offset_y), resources.getColor(com.oplus.camera.R_renamed.color.level_pop_text_shadow_color));
            this.f6517a.setTypeface(com.oplus.camera.util.Util.l_renamed(getContext()));
        }
        this.f_renamed = str;
    }

    public void a_renamed(boolean z_renamed, java.lang.String str, android.graphics.drawable.Drawable drawable) {
        if (z_renamed) {
            a_renamed(str);
            this.f6518b = drawable;
            this.e_renamed = 0;
        } else {
            if (drawable != null) {
                this.f6519c = drawable;
            }
            this.e_renamed = 1;
        }
        invalidate();
    }

    public void setPopdownButtonImage(android.graphics.drawable.Drawable drawable) {
        if (this.d_renamed == null) {
            this.d_renamed = drawable;
        }
        this.e_renamed = 2;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        android.graphics.drawable.Drawable drawable;
        super.onDraw(canvas);
        int i_renamed = this.e_renamed;
        if (i_renamed == 0) {
            b_renamed();
            canvas.rotate(-this.g_renamed, this.n_renamed ? getWidth() / 2 : getWidth() - this.l_renamed, this.n_renamed ? getHeight() / 2 : getHeight() - this.l_renamed);
            android.graphics.drawable.Drawable drawable2 = this.f6518b;
            if (drawable2 != null) {
                if (this.o_renamed) {
                    int width = (getWidth() - this.f6518b.getIntrinsicWidth()) / 2;
                    int height = (getHeight() - this.f6518b.getIntrinsicHeight()) / 2;
                    android.graphics.drawable.Drawable drawable3 = this.f6518b;
                    drawable3.setBounds(width, height, drawable3.getIntrinsicWidth() + width, this.f6518b.getIntrinsicWidth() + height);
                } else {
                    drawable2.setBounds(0, 0, getWidth(), getHeight());
                }
                this.f6518b.draw(canvas);
            }
            if (this.f6517a != null) {
                canvas.drawText(this.f_renamed, getWidth() - (this.l_renamed + (this.f6517a.measureText(this.f_renamed) / 2.0f)), (getHeight() - this.l_renamed) + ((java.lang.Math.abs(this.f6517a.ascent()) - this.f6517a.descent()) / 2.0f), this.f6517a);
                return;
            }
            return;
        }
        if (i_renamed != 1) {
            if (i_renamed == 2 && (drawable = this.d_renamed) != null) {
                if (this.o_renamed) {
                    int width2 = (getWidth() - this.f6518b.getIntrinsicWidth()) / 2;
                    int height2 = (getHeight() - this.f6518b.getIntrinsicHeight()) / 2;
                    android.graphics.drawable.Drawable drawable4 = this.d_renamed;
                    drawable4.setBounds(width2, height2, drawable4.getIntrinsicWidth() + width2, this.d_renamed.getIntrinsicWidth() + height2);
                } else {
                    drawable.setBounds(0, 0, getWidth(), getHeight());
                }
                this.d_renamed.draw(canvas);
                return;
            }
            return;
        }
        b_renamed();
        canvas.rotate(-this.g_renamed, this.n_renamed ? getWidth() / 2 : getWidth() - this.l_renamed, this.n_renamed ? getHeight() / 2 : getHeight() - this.l_renamed);
        android.graphics.drawable.Drawable drawable5 = this.f6519c;
        if (drawable5 != null) {
            if (this.o_renamed) {
                int width3 = (getWidth() - this.f6518b.getIntrinsicWidth()) / 2;
                int height3 = (getHeight() - this.f6518b.getIntrinsicHeight()) / 2;
                android.graphics.drawable.Drawable drawable6 = this.f6519c;
                drawable6.setBounds(width3, height3, drawable6.getIntrinsicWidth() + width3, this.f6519c.getIntrinsicWidth() + height3);
            } else {
                drawable5.setBounds(0, 0, getWidth(), getHeight());
            }
            this.f6519c.draw(canvas);
        }
    }

    private void b_renamed() {
        int i_renamed;
        if (this.g_renamed != this.i_renamed) {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.k_renamed) {
                int i2 = (int) (jCurrentAnimationTimeMillis - this.j_renamed);
                int i3 = this.h_renamed;
                if (!this.m_renamed) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 360) / 1000);
                if (i4 >= 0) {
                    i_renamed = i4 % 360;
                } else {
                    i_renamed = (i4 % 360) + 360;
                }
                this.g_renamed = i_renamed;
                invalidate();
                return;
            }
            this.g_renamed = this.i_renamed;
        }
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        int i2;
        if (this.e_renamed == 2) {
            z_renamed = false;
        }
        if (i_renamed >= 0) {
            i2 = i_renamed % 360;
        } else {
            i2 = (i_renamed % 360) + 360;
        }
        if (i2 == this.i_renamed) {
            return;
        }
        this.i_renamed = i2;
        if (z_renamed) {
            this.h_renamed = this.g_renamed;
            this.j_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.i_renamed - this.g_renamed;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.m_renamed = i3 >= 0;
            this.k_renamed = this.j_renamed + ((java.lang.Math.abs(i3) * 1000) / 360);
            invalidate();
            return;
        }
        this.g_renamed = this.i_renamed;
    }
}

package com.oplus.camera.ui.widget;

/* compiled from: XPanExposureTickDrawable.java */
/* loaded from: classes2.dex */
public class g_renamed extends android.graphics.drawable.Drawable {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final float f7288a = com.oplus.camera.util.Util.l_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.xpan_mode_exposure_wheel_tick_width);

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f7289b = com.oplus.camera.util.Util.l_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.xpan_mode_exposure_wheel_tick_space);

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f7290c = com.oplus.camera.util.Util.l_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.xpan_mode_exposure_wheel_tick_short);
    private final int d_renamed = com.oplus.camera.util.Util.l_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.xpan_mode_exposure_wheel_tick_long);
    private final int e_renamed = com.oplus.camera.util.Util.l_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.xpan_mode_exposure_wheel_tick_center);
    private final int f_renamed = 19;
    private int g_renamed = 9;
    private android.graphics.Paint h_renamed = new android.graphics.Paint(1);
    private android.graphics.Paint i_renamed = new android.graphics.Paint(this.h_renamed);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
    }

    public g_renamed() {
        this.h_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.h_renamed.setStrokeWidth(this.f7288a);
        this.h_renamed.setColor(-1);
        this.h_renamed.setAlpha(102);
        this.i_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.i_renamed.setStrokeWidth(this.f7288a);
        this.i_renamed.setColor(-1);
        this.i_renamed.setAlpha(255);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.Rect bounds = getBounds();
        for (int i_renamed = 0; i_renamed < 19; i_renamed++) {
            int i2 = this.f7290c;
            if (i_renamed == 9) {
                i2 = this.e_renamed;
            } else if (i_renamed % 3 == 0) {
                i2 = this.d_renamed;
            }
            float f_renamed = bounds.left + (this.f7288a / 2.0f) + (this.f7289b * i_renamed);
            float f2 = bounds.top + this.e_renamed;
            canvas.drawLine(f_renamed, f2, f_renamed, f2 - i2, b_renamed(i_renamed));
        }
    }

    private android.graphics.Paint b_renamed(int i_renamed) {
        int i2 = this.g_renamed;
        if (i2 == 9) {
            if (i_renamed == 9) {
                return this.i_renamed;
            }
            return this.h_renamed;
        }
        if (i2 > 9) {
            if (i_renamed >= 9 && i_renamed <= i2) {
                return this.i_renamed;
            }
            return this.h_renamed;
        }
        if (i_renamed >= i2 && i_renamed <= 9) {
            return this.i_renamed;
        }
        return this.h_renamed;
    }

    public void a_renamed(int i_renamed) {
        this.g_renamed = i_renamed;
    }
}

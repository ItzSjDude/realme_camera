package com.oplus.camera.longexposure;

/* compiled from: LongExposureRotableTextView.java */
/* loaded from: classes2.dex */
public class h_renamed extends android.widget.TextView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f4843a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.res.Resources f4844b;

    public h_renamed(android.content.Context context) {
        super(context);
        this.f4843a = null;
        this.f4844b = null;
        this.f4843a = context;
        if (this.f4844b == null) {
            this.f4844b = context.getResources();
        }
    }

    public void a_renamed(int i_renamed) {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(this.f4844b.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_width), this.f4844b.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_height));
        int dimensionPixelSize = this.f4844b.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_height) / 2;
        int dimensionPixelSize2 = this.f4844b.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_width) / 2;
        int i2 = 270;
        if (i_renamed == 90) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = (((int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_margin_left_90)) + dimensionPixelSize) - dimensionPixelSize2;
            layoutParams.topMargin = (((int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_margin_top_90)) + dimensionPixelSize2) - dimensionPixelSize;
            i2 = 90;
        } else if (i_renamed == 180) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = (int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_margin_left_180);
            layoutParams.topMargin = (int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_margin_top_180);
            i2 = 180;
        } else if (i_renamed == 270) {
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = (((int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_margin_right_270)) + dimensionPixelSize) - dimensionPixelSize2;
            layoutParams.topMargin = (((int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_margin_top_270)) + dimensionPixelSize2) - dimensionPixelSize;
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = (int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_margin_left);
            layoutParams.topMargin = (int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_margin_top);
            i2 = 0;
        }
        setLayoutParams(layoutParams);
        setRotation(-i2);
    }

    public void b_renamed(int i_renamed) {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(this.f4844b.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_width), this.f4844b.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_height));
        int dimensionPixelSize = this.f4844b.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_height) / 2;
        int dimensionPixelSize2 = this.f4844b.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_width) / 2;
        int i2 = 270;
        if (i_renamed == 90) {
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = (((int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_margin_right_90)) + dimensionPixelSize) - dimensionPixelSize2;
            layoutParams.topMargin = (((int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_margin_top_90)) + dimensionPixelSize2) - dimensionPixelSize;
            i2 = 90;
        } else if (i_renamed == 180) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = (int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_margin_left_180);
            layoutParams.topMargin = (int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_margin_top_180);
            i2 = 180;
        } else if (i_renamed == 270) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = (((int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_margin_left_270)) + dimensionPixelSize) - dimensionPixelSize2;
            layoutParams.topMargin = (((int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_margin_top_270)) + dimensionPixelSize2) - dimensionPixelSize;
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = (int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_margin_left);
            layoutParams.topMargin = (int) this.f4844b.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_margin_top);
            i2 = 0;
        }
        setLayoutParams(layoutParams);
        setRotation(-i2);
    }
}

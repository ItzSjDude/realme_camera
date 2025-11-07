package com.oplus.camera.longexposure;

import android.content.Context;
import android.content.res.Resources;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.oplus.camera.R;

/* compiled from: LongExposureRotableTextView.java */
/* renamed from: com.oplus.camera.longexposure.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class LongExposureRotableTextView extends TextView {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f14602a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Resources f14603b;

    public LongExposureRotableTextView(Context context) {
        super(context);
        this.f14602a = null;
        this.f14603b = null;
        this.f14602a = context;
        if (this.f14603b == null) {
            this.f14603b = context.getResources();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14619a(int OplusGLSurfaceView_13) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f14603b.getDimensionPixelSize(R.dimen.long_exposure_exposure_time_text_width), this.f14603b.getDimensionPixelSize(R.dimen.long_exposure_exposure_time_text_height));
        int dimensionPixelSize = this.f14603b.getDimensionPixelSize(R.dimen.long_exposure_exposure_time_text_height) / 2;
        int dimensionPixelSize2 = this.f14603b.getDimensionPixelSize(R.dimen.long_exposure_exposure_time_text_width) / 2;
        int i2 = 270;
        if (OplusGLSurfaceView_13 == 90) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = (((int) this.f14603b.getDimension(R.dimen.long_exposure_exposure_time_text_margin_left_90)) + dimensionPixelSize) - dimensionPixelSize2;
            layoutParams.topMargin = (((int) this.f14603b.getDimension(R.dimen.long_exposure_exposure_time_text_margin_top_90)) + dimensionPixelSize2) - dimensionPixelSize;
            i2 = 90;
        } else if (OplusGLSurfaceView_13 == 180) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = (int) this.f14603b.getDimension(R.dimen.long_exposure_exposure_time_text_margin_left_180);
            layoutParams.topMargin = (int) this.f14603b.getDimension(R.dimen.long_exposure_exposure_time_text_margin_top_180);
            i2 = 180;
        } else if (OplusGLSurfaceView_13 == 270) {
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = (((int) this.f14603b.getDimension(R.dimen.long_exposure_exposure_time_text_margin_right_270)) + dimensionPixelSize) - dimensionPixelSize2;
            layoutParams.topMargin = (((int) this.f14603b.getDimension(R.dimen.long_exposure_exposure_time_text_margin_top_270)) + dimensionPixelSize2) - dimensionPixelSize;
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = (int) this.f14603b.getDimension(R.dimen.long_exposure_exposure_time_text_margin_left);
            layoutParams.topMargin = (int) this.f14603b.getDimension(R.dimen.long_exposure_exposure_time_text_margin_top);
            i2 = 0;
        }
        setLayoutParams(layoutParams);
        setRotation(-i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14620b(int OplusGLSurfaceView_13) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f14603b.getDimensionPixelSize(R.dimen.long_exposure_capture_time_text_width), this.f14603b.getDimensionPixelSize(R.dimen.long_exposure_capture_time_text_height));
        int dimensionPixelSize = this.f14603b.getDimensionPixelSize(R.dimen.long_exposure_capture_time_text_height) / 2;
        int dimensionPixelSize2 = this.f14603b.getDimensionPixelSize(R.dimen.long_exposure_capture_time_text_width) / 2;
        int i2 = 270;
        if (OplusGLSurfaceView_13 == 90) {
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = (((int) this.f14603b.getDimension(R.dimen.long_exposure_capture_time_text_margin_right_90)) + dimensionPixelSize) - dimensionPixelSize2;
            layoutParams.topMargin = (((int) this.f14603b.getDimension(R.dimen.long_exposure_capture_time_text_margin_top_90)) + dimensionPixelSize2) - dimensionPixelSize;
            i2 = 90;
        } else if (OplusGLSurfaceView_13 == 180) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = (int) this.f14603b.getDimension(R.dimen.long_exposure_capture_time_text_margin_left_180);
            layoutParams.topMargin = (int) this.f14603b.getDimension(R.dimen.long_exposure_capture_time_text_margin_top_180);
            i2 = 180;
        } else if (OplusGLSurfaceView_13 == 270) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = (((int) this.f14603b.getDimension(R.dimen.long_exposure_capture_time_text_margin_left_270)) + dimensionPixelSize) - dimensionPixelSize2;
            layoutParams.topMargin = (((int) this.f14603b.getDimension(R.dimen.long_exposure_capture_time_text_margin_top_270)) + dimensionPixelSize2) - dimensionPixelSize;
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = (int) this.f14603b.getDimension(R.dimen.long_exposure_capture_time_text_margin_left);
            layoutParams.topMargin = (int) this.f14603b.getDimension(R.dimen.long_exposure_capture_time_text_margin_top);
            i2 = 0;
        }
        setLayoutParams(layoutParams);
        setRotation(-i2);
    }
}

package com.oplus.camera.p172ui.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class LongExposureTimeView extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Typeface f20829a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PathInterpolator f20830b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private TextView f20831c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TextView f20832d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private TextView f20833e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private TextView f20834f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ObjectAnimator f20835g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ObjectAnimator f20836h;

    public LongExposureTimeView(Context context) {
        this(context, null);
    }

    public LongExposureTimeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LongExposureTimeView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f20830b = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f20831c = null;
        this.f20832d = null;
        this.f20833e = null;
        this.f20834f = null;
        this.f20835g = null;
        this.f20836h = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22176a() {
        this.f20831c = (TextView) findViewById(R.id_renamed.long_exposure_count_down_time_value_text_hundreds);
        this.f20832d = (TextView) findViewById(R.id_renamed.long_exposure_count_down_time_value_text_tens);
        this.f20833e = (TextView) findViewById(R.id_renamed.long_exposure_count_down_time_value_text_digits);
        this.f20834f = (TextView) findViewById(R.id_renamed.long_exposure_count_down_time_value_text_decimal);
        TextView textView = (TextView) findViewById(R.id_renamed.long_exposure_count_down_time_suffix_text);
        TextView textView2 = (TextView) findViewById(R.id_renamed.long_exposure_count_down_time_value_text_decimal_point);
        Typeface fontTypeface = getFontTypeface();
        this.f20831c.setTypeface(fontTypeface);
        this.f20832d.setTypeface(fontTypeface);
        this.f20833e.setTypeface(fontTypeface);
        this.f20834f.setTypeface(fontTypeface);
        textView.setTypeface(fontTypeface);
        textView2.setTypeface(fontTypeface);
    }

    public static Typeface getFontTypeface() {
        Typeface typeface = f20829a;
        if (typeface != null) {
            return typeface;
        }
        try {
            Typeface.Builder builder = new Typeface.Builder("sys-sans-en");
            builder.setFontVariationSettings("'wght' 650");
            f20829a = builder.build();
        } catch (Exception unused) {
            f20829a = Typeface.DEFAULT;
            CameraLog.m12967f("LongExposureTimeView", "getFontTypeface, create special typeface fail");
        }
        return f20829a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22178a(long OplusGLSurfaceView_15) {
        long j2 = OplusGLSurfaceView_15 / 100000;
        long j3 = OplusGLSurfaceView_15 % 100000;
        long j4 = j3 / 10000;
        long j5 = j3 % 10000;
        long j6 = j5 / 1000;
        long j7 = (j5 % 1000) / 100;
        if (j2 > 0) {
            this.f20831c.setVisibility(0);
            this.f20831c.setText(String.valueOf(j2));
        } else {
            this.f20831c.setVisibility(8);
        }
        if (j2 > 0 || j4 > 0) {
            this.f20832d.setVisibility(0);
            this.f20832d.setText(String.valueOf(j4));
        } else {
            this.f20832d.setVisibility(8);
        }
        this.f20833e.setText(String.valueOf(j6));
        this.f20834f.setText(String.valueOf(j7));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22177a(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("LongExposureTimeView", "setVisibility, visibility: " + OplusGLSurfaceView_13 + ", needAnim: " + z);
        if (OplusGLSurfaceView_13 == 0) {
            m22174a(z);
        } else {
            m22175b(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22174a(boolean z) {
        CameraLog.m12954a("LongExposureTimeView", "show, needAnim: " + z);
        ObjectAnimator objectAnimator = this.f20836h;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f20836h.cancel();
        } else if (isShown()) {
            return;
        }
        if (z) {
            if (this.f20835g == null) {
                this.f20835g = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
                this.f20835g.setInterpolator(this.f20830b);
                this.f20835g.setDuration(250L);
                this.f20835g.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.LongExposureTimeView.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        LongExposureTimeView.this.setVisibility(0);
                        LongExposureTimeView.this.setAlpha(0.0f);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        LongExposureTimeView.this.setAlpha(1.0f);
                    }
                });
                this.f20835g.setStartDelay(150L);
            }
            this.f20835g.start();
            return;
        }
        setVisibility(0);
        setAlpha(1.0f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22175b(boolean z) {
        CameraLog.m12954a("LongExposureTimeView", "hide, needAnim: " + z);
        ObjectAnimator objectAnimator = this.f20835g;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f20835g.cancel();
        } else if (!isShown()) {
            return;
        }
        if (z) {
            if (this.f20836h == null) {
                this.f20836h = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
                this.f20836h.setInterpolator(this.f20830b);
                this.f20836h.setDuration(250L);
                this.f20836h.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.LongExposureTimeView.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        LongExposureTimeView.this.setVisibility(0);
                        LongExposureTimeView.this.setAlpha(1.0f);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        LongExposureTimeView.this.setVisibility(8);
                    }
                });
            }
            this.f20836h.start();
            return;
        }
        setVisibility(8);
    }
}

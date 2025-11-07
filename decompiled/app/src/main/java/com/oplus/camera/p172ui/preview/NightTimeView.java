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
public class NightTimeView extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Typeface f20873a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PathInterpolator f20874b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private TextView f20875c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TextView f20876d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private TextView f20877e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private TextView f20878f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ObjectAnimator f20879g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ObjectAnimator f20880h;

    public NightTimeView(Context context) {
        this(context, null);
    }

    public NightTimeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NightTimeView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f20874b = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f20875c = null;
        this.f20876d = null;
        this.f20877e = null;
        this.f20878f = null;
        this.f20879g = null;
        this.f20880h = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22199a() {
        this.f20875c = (TextView) findViewById(R.id_renamed.night_count_down_time_value_text_hundreds);
        this.f20876d = (TextView) findViewById(R.id_renamed.night_count_down_time_value_text_tens);
        this.f20877e = (TextView) findViewById(R.id_renamed.night_count_down_time_value_text_digits);
        this.f20878f = (TextView) findViewById(R.id_renamed.night_count_down_time_value_text_decimal);
        TextView textView = (TextView) findViewById(R.id_renamed.night_count_down_time_suffix_text);
        TextView textView2 = (TextView) findViewById(R.id_renamed.night_count_down_time_value_text_decimal_point);
        Typeface fontTypeface = getFontTypeface();
        this.f20875c.setTypeface(fontTypeface);
        this.f20876d.setTypeface(fontTypeface);
        this.f20877e.setTypeface(fontTypeface);
        this.f20878f.setTypeface(fontTypeface);
        textView.setTypeface(fontTypeface);
        textView2.setTypeface(fontTypeface);
    }

    public static Typeface getFontTypeface() {
        Typeface typeface = f20873a;
        if (typeface != null) {
            return typeface;
        }
        try {
            Typeface.Builder builder = new Typeface.Builder("sys-sans-en");
            builder.setFontVariationSettings("'wght' 750");
            f20873a = builder.build();
        } catch (Exception unused) {
            f20873a = Typeface.DEFAULT;
            CameraLog.m12967f("NightTimeView", "getFontTypeface, create special typeface fail");
        }
        return f20873a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22201a(long OplusGLSurfaceView_15) {
        long j2 = OplusGLSurfaceView_15 / 100000;
        long j3 = (OplusGLSurfaceView_15 % 100000) / 10000;
        long j4 = OplusGLSurfaceView_15 % 10000;
        long j5 = j4 / 1000;
        long j6 = (j4 % 1000) / 100;
        if (j2 > 0) {
            this.f20875c.setVisibility(0);
            this.f20875c.setText(String.valueOf(j2));
            if (j3 >= 0) {
                this.f20876d.setVisibility(0);
                this.f20876d.setText(String.valueOf(j3));
            } else {
                this.f20876d.setVisibility(8);
            }
        } else {
            this.f20875c.setVisibility(8);
            if (j3 > 0) {
                this.f20876d.setVisibility(0);
                this.f20876d.setText(String.valueOf(j3));
            } else {
                this.f20876d.setVisibility(8);
            }
        }
        this.f20877e.setText(String.valueOf(j5));
        this.f20878f.setText(String.valueOf(j6));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22200a(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("NightTimeView", "setVisibility, visibility: " + OplusGLSurfaceView_13 + ", needAnim: " + z);
        if (OplusGLSurfaceView_13 == 0) {
            m22197a(z);
        } else {
            m22198b(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22197a(boolean z) {
        CameraLog.m12954a("NightTimeView", "show, needAnim: " + z);
        ObjectAnimator objectAnimator = this.f20880h;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f20880h.cancel();
        } else if (isShown()) {
            return;
        }
        if (z) {
            if (this.f20879g == null) {
                this.f20879g = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
                this.f20879g.setInterpolator(this.f20874b);
                this.f20879g.setDuration(250L);
                this.f20879g.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.NightTimeView.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        NightTimeView.this.setVisibility(0);
                        NightTimeView.this.setAlpha(0.0f);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        NightTimeView.this.setAlpha(1.0f);
                    }
                });
                this.f20879g.setStartDelay(150L);
            }
            this.f20879g.start();
            return;
        }
        setVisibility(0);
        setAlpha(1.0f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22198b(boolean z) {
        CameraLog.m12954a("NightTimeView", "hide, needAnim: " + z);
        ObjectAnimator objectAnimator = this.f20879g;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f20879g.cancel();
        } else if (!isShown()) {
            return;
        }
        if (z) {
            if (this.f20880h == null) {
                this.f20880h = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
                this.f20880h.setInterpolator(this.f20874b);
                this.f20880h.setDuration(250L);
                this.f20880h.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.NightTimeView.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        NightTimeView.this.setVisibility(0);
                        NightTimeView.this.setAlpha(1.0f);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        NightTimeView.this.setVisibility(8);
                    }
                });
            }
            this.f20880h.start();
            return;
        }
        setVisibility(8);
    }
}

package com.oplus.camera.p172ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class OutCaptureGuideView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private OutCaptureGuideView f17201a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private LottieAnimationView f17202b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private View f17203c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Animation f17204d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private InterfaceC3104a f17205e;

    /* renamed from: com.oplus.camera.ui.OutCaptureGuideView$PlatformImplementations.kt_3 */
    public interface InterfaceC3104a {
        void onExitButtonClick();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18332a(Context context) {
    }

    public OutCaptureGuideView(Context context) {
        super(context);
        this.f17201a = null;
        this.f17202b = null;
        this.f17203c = null;
        this.f17204d = null;
        this.f17205e = null;
        m18332a(context);
    }

    public OutCaptureGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17201a = null;
        this.f17202b = null;
        this.f17203c = null;
        this.f17204d = null;
        this.f17205e = null;
        m18332a(context);
    }

    public OutCaptureGuideView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17201a = null;
        this.f17202b = null;
        this.f17203c = null;
        this.f17204d = null;
        this.f17205e = null;
        m18332a(context);
    }

    public void setListener(InterfaceC3104a interfaceC3104a) {
        this.f17205e = interfaceC3104a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f17201a = (OutCaptureGuideView) findViewById(R.id_renamed.out_capture_guide);
        this.f17201a.setOnClickListener(this);
        this.f17202b = (LottieAnimationView) findViewById(R.id_renamed.out_capture_guide_anim);
        this.f17202b.setAnimation(R.raw.out_capture_guide);
        this.f17203c = findViewById(R.id_renamed.exit_button);
        this.f17203c.setOnClickListener(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18334a() {
        this.f17204d = AnimationUtils.loadAnimation(getContext(), R.anim.out_capture_guide_show);
        this.f17204d.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.ui.OutCaptureGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                OutCaptureGuideView.this.f17201a.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                OutCaptureGuideView.this.f17202b.m5507a();
            }
        });
        this.f17201a.startAnimation(this.f17204d);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18335b() {
        if (this.f17201a.getVisibility() != 0) {
            return;
        }
        Animation animation = this.f17204d;
        if (animation != null) {
            animation.cancel();
        }
        this.f17204d = AnimationUtils.loadAnimation(getContext(), R.anim.out_capture_guide_hide);
        this.f17201a.startAnimation(this.f17204d);
        this.f17204d.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.ui.OutCaptureGuideView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                OutCaptureGuideView.this.f17201a.setVisibility(8);
                OutCaptureGuideView.this.f17202b.setProgress(0.0f);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC3104a interfaceC3104a;
        if (view.getId() != R.id_renamed.exit_button || (interfaceC3104a = this.f17205e) == null) {
            return;
        }
        interfaceC3104a.onExitButtonClick();
    }
}

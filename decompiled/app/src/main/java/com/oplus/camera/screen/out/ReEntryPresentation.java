package com.oplus.camera.screen.out;

import android.app.Presentation;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.airbnb.lottie.LottieAnimationView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.DeviceUtil;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: ReEntryPresentation.java */
/* renamed from: com.oplus.camera.screen.out.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class ReEntryPresentation extends Presentation implements View.OnClickListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private View f16112a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private LottieAnimationView f16113b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private View f16114c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PlatformImplementations.kt_3 f16115d;

    /* compiled from: ReEntryPresentation.java */
    /* renamed from: com.oplus.camera.screen.out.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        void onExitButtonClick();
    }

    public ReEntryPresentation(Context context, Display display) {
        super(context, display);
        this.f16112a = null;
        this.f16113b = null;
        this.f16114c = null;
        this.f16115d = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16711a(PlatformImplementations.kt_3 aVar) {
        this.f16115d = aVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        CameraLog.m12959b("ReEntryPresentation", "onCreate");
        getWindow().getDecorView().setSystemUiVisibility(5636);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(attributes);
        super.onCreate(bundle);
        setContentView(R.layout.presentation_re_entry);
        this.f16112a = findViewById(R.id_renamed.root);
        this.f16113b = (LottieAnimationView) findViewById(R.id_renamed.guide_anim);
        this.f16113b.setAnimation(R.raw.out_capture_exit_guide);
        this.f16113b.m5507a();
        this.f16114c = findViewById(R.id_renamed.exit_button);
        this.f16114c.setOnClickListener(this);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        CameraLog.m12959b("ReEntryPresentation", "onCreate, schedule ts: " + jCurrentTimeMillis);
        new Timer().schedule(new TimerTask() { // from class: com.oplus.camera.screen.out.COUIBaseListPopupWindow_12.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                Animation animationLoadAnimation = AnimationUtils.loadAnimation(ReEntryPresentation.this.getContext(), R.anim.out_capture_guide_hide);
                animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.screen.out.COUIBaseListPopupWindow_12.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (ReEntryPresentation.this.isShowing()) {
                            ReEntryPresentation.this.dismiss();
                            CameraLog.m12959b("ReEntryPresentation", "schedule, requestDeviceFolded ts: " + jCurrentTimeMillis);
                            DeviceUtil.m24533a(-1, false, jCurrentTimeMillis);
                        }
                    }
                });
                ReEntryPresentation.this.f16112a.startAnimation(animationLoadAnimation);
            }
        }, 10000L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PlatformImplementations.kt_3 aVar;
        if (view.getId() != R.id_renamed.exit_button || (aVar = this.f16115d) == null) {
            return;
        }
        aVar.onExitButtonClick();
    }
}

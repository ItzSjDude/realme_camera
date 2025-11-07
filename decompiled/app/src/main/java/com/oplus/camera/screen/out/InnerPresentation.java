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
import android.widget.Button;
import com.airbnb.lottie.LottieAnimationView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.DeviceUtil;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: InnerPresentation.java */
/* renamed from: com.oplus.camera.screen.out.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class InnerPresentation extends Presentation implements View.OnClickListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private View f16075a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private LottieAnimationView f16076b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Button f16077c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PlatformImplementations.kt_3 f16078d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f16079e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Timer f16080f;

    /* compiled from: InnerPresentation.java */
    /* renamed from: com.oplus.camera.screen.out.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        void onExitButtonClick();
    }

    public InnerPresentation(Context context, Display display) {
        super(context, display);
        this.f16075a = null;
        this.f16076b = null;
        this.f16077c = null;
        this.f16078d = null;
        this.f16079e = false;
        this.f16080f = new Timer();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16694a(PlatformImplementations.kt_3 aVar) {
        this.f16078d = aVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        CameraLog.m12959b("InnerPresentation", "onCreate");
        getWindow().getDecorView().setSystemUiVisibility(5636);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(attributes);
        super.onCreate(bundle);
        setContentView(R.layout.presentation_inner);
        this.f16075a = findViewById(R.id_renamed.root);
        this.f16076b = (LottieAnimationView) findViewById(R.id_renamed.inner_guide_anim);
        this.f16076b.setAnimation(R.raw.out_capture_guide2);
        this.f16077c = (Button) findViewById(R.id_renamed.exit_button);
        this.f16077c.setVisibility(this.f16079e ? 0 : 8);
        this.f16077c.setOnClickListener(this);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.out_capture_guide_show);
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.screen.out.IntrinsicsJvm.kt_3.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                InnerPresentation.this.f16076b.m5507a();
            }
        });
        this.f16075a.startAnimation(animationLoadAnimation);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        CameraLog.m12959b("InnerPresentation", "onCreate, schedule ts: " + jCurrentTimeMillis);
        this.f16080f.schedule(new TimerTask() { // from class: com.oplus.camera.screen.out.IntrinsicsJvm.kt_3.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(InnerPresentation.this.getContext(), R.anim.out_capture_guide_hide);
                animationLoadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.screen.out.IntrinsicsJvm.kt_3.2.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (InnerPresentation.this.isShowing()) {
                            InnerPresentation.this.dismiss();
                            CameraLog.m12959b("InnerPresentation", "schedule, requestDeviceFolded ts: " + jCurrentTimeMillis);
                            DeviceUtil.m24533a(0, false, jCurrentTimeMillis);
                        }
                    }
                });
                InnerPresentation.this.f16075a.startAnimation(animationLoadAnimation2);
            }
        }, 10000L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PlatformImplementations.kt_3 aVar;
        if (view.getId() != R.id_renamed.exit_button || (aVar = this.f16078d) == null) {
            return;
        }
        aVar.onExitButtonClick();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16695a(boolean z) {
        this.f16079e = z;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f16080f.cancel();
        super.dismiss();
    }
}

package com.oplus.camera.screen.p163a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.screen.out.OutPresentation;
import com.oplus.camera.util.DeviceUtil;
import com.oplus.camera.util.ToastUtil;

/* compiled from: OutPreviewManager.java */
/* renamed from: com.oplus.camera.screen.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class OutPreviewManager {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Handler f15979e;

    /* renamed from: PlatformImplementations.kt_3 */
    private OutPresentation f15975a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private IntrinsicsJvm.kt_4 f15976b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private LottieAnimationView f15977c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ValueAnimator f15978d = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f15980f = true;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f15981g = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f15982h = false;

    /* compiled from: OutPreviewManager.java */
    /* renamed from: com.oplus.camera.screen.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        void call();
    }

    /* compiled from: OutPreviewManager.java */
    /* renamed from: com.oplus.camera.screen.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo16457a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo16458a(OutPresentation presentationC2959e);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo16459a(int OplusGLSurfaceView_13, KeyEvent keyEvent);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo16460b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo16461b(OutPresentation presentationC2959e);

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo16462b(int OplusGLSurfaceView_13, KeyEvent keyEvent);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo16463c();
    }

    public OutPreviewManager() {
        this.f15979e = null;
        this.f15979e = new Handler();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16450a(Activity activity, IntrinsicsJvm.kt_4 bVar) {
        CameraLog.m12959b("OutPreviewManager", "switchOutPresentation");
        this.f15976b = bVar;
        if (this.f15975a != null) {
            m16451a(false);
        } else if (this.f15981g) {
            CameraLog.m12959b("OutPreviewManager", "switchOutPresentation, highTemperature");
            ToastUtil.m24645c(MyApplication.m11092d(), R.string.camera_high_temperature_out_small_preview_disable);
        } else if (this.f15980f) {
            CameraLog.m12959b("OutPreviewManager", "switchOutPresentation, enable");
            IntrinsicsJvm.kt_4 bVar2 = this.f15976b;
            if (bVar2 != null) {
                bVar2.mo16463c();
            }
            DeviceUtil.m24533a(-1, true, System.currentTimeMillis());
            this.f15975a = new OutPresentation(activity, ((DisplayManager) activity.getSystemService("display")).getDisplay(4096));
            this.f15975a.m16708a(this.f15976b);
            this.f15975a.m16709a(this.f15982h);
            this.f15975a.show();
            if (this.f15976b != null) {
                CameraLog.m12959b("OutPreviewManager", "switchOutPresentation, onPreviewShow");
                this.f15976b.mo16458a(this.f15975a);
            }
        }
        CameraLog.m12959b("OutPreviewManager", "switchOutPresentation X");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16451a(boolean z) {
        CameraLog.m12959b("OutPreviewManager", "closeOutPresentation");
        if (this.f15975a != null) {
            if (this.f15976b != null) {
                CameraLog.m12959b("OutPreviewManager", "closeOutPresentation, onPreviewDismiss");
                this.f15976b.mo16461b(this.f15975a);
            }
            this.f15975a.dismiss();
            this.f15975a = null;
            final long jCurrentTimeMillis = System.currentTimeMillis();
            if (z) {
                CameraLog.m12959b("OutPreviewManager", "closeOutPresentation, requestDeviceFolded ts: " + jCurrentTimeMillis);
                this.f15979e.postDelayed(new Runnable() { // from class: com.oplus.camera.screen.PlatformImplementations.kt_3.-$$Lambda$IntrinsicsJvm.kt_3$Cm6Af0vjVb-VKxbX--kENdyNAZE
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeviceUtil.m24533a(-1, false, jCurrentTimeMillis);
                    }
                }, 500L);
            } else {
                CameraLog.m12959b("OutPreviewManager", "closeOutPresentation, requestDeviceFolded");
                DeviceUtil.m24533a(-1, false, jCurrentTimeMillis);
            }
            if (this.f15981g) {
                ToastUtil.m24645c(MyApplication.m11092d(), R.string.camera_high_temperature_out_small_preview_disable);
                if (this.f15976b != null) {
                    CameraLog.m12959b("OutPreviewManager", "closeOutPresentation, onHighTemperatureDisabled");
                    this.f15976b.mo16460b();
                }
            }
        }
        CameraLog.m12959b("OutPreviewManager", "closeOutPresentation X");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16447a() {
        m16451a(true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16452b(boolean z) {
        this.f15980f = z;
        if (this.f15980f) {
            return;
        }
        m16451a(false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16448a(int OplusGLSurfaceView_13) {
        this.f15981g = OplusGLSurfaceView_13 >= CameraConfig.getConfigIntValue(ConfigDataBase.KEY_OUT_PREVIEW_DISABLE_TEMPERATURE);
        if (this.f15981g) {
            m16451a(false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16455c(boolean z) {
        this.f15982h = z;
        OutPresentation presentationC2959e = this.f15975a;
        if (presentationC2959e != null) {
            presentationC2959e.m16709a(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m16453b() {
        return this.f15975a != null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16449a(Activity activity, ViewGroup viewGroup) {
        if (this.f15977c == null) {
            this.f15977c = new LottieAnimationView(activity);
            this.f15977c.setAnimation(R.raw.out_preview_guide);
            this.f15977c.m5508a(new COUIBaseListPopupWindow_2());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(activity.getResources().getDimensionPixelSize(R.dimen.out_preview_guide_anim_width), activity.getResources().getDimensionPixelSize(R.dimen.out_preview_guide_anim_height));
            layoutParams.addRule(14);
            layoutParams.topMargin = activity.getResources().getDimensionPixelSize(R.dimen.out_preview_guide_anim_margin_top);
            viewGroup.addView(this.f15977c, layoutParams);
        }
        this.f15977c.setVisibility(0);
        this.f15977c.setProgress(0.0f);
        m16443a(this.f15977c, 0, 1, new PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.PlatformImplementations.kt_3.-$$Lambda$IntrinsicsJvm.kt_3$ci5aV7K14Bk4rZE3d0tOxljxgVU
            @Override // com.oplus.camera.screen.p163a.OutPreviewManager.PlatformImplementations.kt_3
            public final void call() {
                this.COUIBaseListPopupWindow_12$0.m16446d();
            }
        });
    }

    /* compiled from: OutPreviewManager.java */
    /* renamed from: com.oplus.camera.screen.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$1, reason: invalid class name */
    class COUIBaseListPopupWindow_2 implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        COUIBaseListPopupWindow_2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public /* synthetic */ void m16456a() {
            OutPreviewManager.this.f15977c.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            OutPreviewManager c2930c = OutPreviewManager.this;
            c2930c.m16443a(c2930c.f15977c, 1, 0, new PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.PlatformImplementations.kt_3.-$$Lambda$IntrinsicsJvm.kt_3$1$IntrinsicsJvm.kt_5-bpmb5zncn0a7E3oaDGzHV4Am8
                @Override // com.oplus.camera.screen.p163a.OutPreviewManager.PlatformImplementations.kt_3
                public final void call() {
                    this.COUIBaseListPopupWindow_12$0.m16456a();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m16446d() {
        this.f15977c.m5507a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16443a(final View view, int OplusGLSurfaceView_13, int i2, final PlatformImplementations.kt_3 aVar) {
        this.f15978d = ValueAnimator.ofFloat(OplusGLSurfaceView_13, i2).setDuration(500L);
        this.f15978d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.screen.PlatformImplementations.kt_3.-$$Lambda$IntrinsicsJvm.kt_3$8Y_yUgSg7Bud2SYWxOlWBwpqo-o
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                OutPreviewManager.m16444a(view, valueAnimator);
            }
        });
        this.f15978d.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.screen.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.2

            /* renamed from: IntrinsicsJvm.kt_3 */
            private boolean f15986c = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.f15986c = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (this.f15986c) {
                    return;
                }
                aVar.call();
            }
        });
        this.f15978d.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16444a(View view, ValueAnimator valueAnimator) {
        view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16454c() {
        ValueAnimator valueAnimator = this.f15978d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        LottieAnimationView lottieAnimationView = this.f15977c;
        if (lottieAnimationView != null) {
            lottieAnimationView.m5518e();
            this.f15977c.setVisibility(8);
        }
    }
}

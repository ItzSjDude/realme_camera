package com.oplus.camera.p172ui.menu.levelcontrol;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.util.Util;

/* compiled from: SwitchFilterMenu.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.r */
/* loaded from: classes2.dex */
public class SwitchFilterMenu {

    /* renamed from: PlatformImplementations.kt_3 */
    private PlatformImplementations.kt_3 f19871a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private TextView f19872b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ObjectAnimator f19873c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ObjectAnimator f19874d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Handler f19875e;

    /* compiled from: SwitchFilterMenu.java */
    /* renamed from: com.oplus.camera.ui.menu.levelcontrol.r$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void m21030a(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        String m21031b(int OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21027a() {
        CameraLog.m12954a("SwitchFilterMenu", "cancelAnimator");
        if (this.f19875e.hasMessages(1)) {
            this.f19875e.removeMessages(1);
            this.f19872b.setAlpha(0.0f);
        }
        ObjectAnimator objectAnimator = this.f19874d;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f19874d.cancel();
            this.f19872b.setAlpha(0.0f);
        }
        ObjectAnimator objectAnimator2 = this.f19873c;
        if (objectAnimator2 == null || !objectAnimator2.isRunning()) {
            return;
        }
        this.f19873c.cancel();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21028b() {
        CameraLog.m12954a("SwitchFilterMenu", "slideToPreviousFilter");
        m21026a(2, (-Util.getScreenWidth()) / 2.0f, 0.0f);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21029c() {
        CameraLog.m12954a("SwitchFilterMenu", "slideToNextFilter");
        m21026a(1, Util.getScreenWidth() / 2.0f, 0.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21026a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, float f2) {
        String strM21031b;
        CameraLog.m12954a("SwitchFilterMenu", "switchFilterAnimator, direction: " + OplusGLSurfaceView_13 + ", startTranslationX: " + COUIBaseListPopupWindow_12 + ", endTranslationX: " + f2);
        m21027a();
        PlatformImplementations.kt_3 aVar = this.f19871a;
        if (aVar != null && (strM21031b = aVar.m21031b(OplusGLSurfaceView_13)) != null) {
            this.f19872b.setText(strM21031b);
        }
        TextView textView = this.f19872b;
        if (textView != null && textView.getVisibility() != 0) {
            this.f19872b.setVisibility(0);
        }
        PlatformImplementations.kt_3 aVar2 = this.f19871a;
        if (aVar2 != null) {
            aVar2.m21030a(OplusGLSurfaceView_13);
        }
        TextView textView2 = this.f19872b;
        if (textView2 != null) {
            textView2.setAlpha(1.0f);
        }
        this.f19873c = ObjectAnimator.ofFloat(this.f19872b, (Property<TextView, Float>) View.TRANSLATION_X, COUIBaseListPopupWindow_12, f2);
        this.f19873c.setDuration(150L);
        this.f19873c.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f19873c.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.levelcontrol.r.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CameraLog.m12954a("SwitchFilterMenu", "switchFilterAnimator, onAnimationStart");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CameraLog.m12954a("SwitchFilterMenu", "switchFilterAnimator, onAnimationEnd");
                if (SwitchFilterMenu.this.f19875e != null) {
                    SwitchFilterMenu.this.f19875e.removeMessages(1);
                    SwitchFilterMenu.this.f19875e.sendEmptyMessageDelayed(1, 1000L);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CameraLog.m12954a("SwitchFilterMenu", "switchFilterAnimator, onAnimationCancel");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                CameraLog.m12954a("SwitchFilterMenu", "switchFilterAnimator, onAnimationRepeat");
            }
        });
        this.f19873c.start();
    }
}

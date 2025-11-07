package com.oplus.camera.p137b;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.preview.ZoomSeekBar;
import com.oplus.camera.util.Util;

/* compiled from: ZoomAnimationListener.java */
/* renamed from: com.oplus.camera.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ZoomAnimationListener implements Animation.AnimationListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f12553a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private View f12554b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private View f12555c;

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    public ZoomAnimationListener(boolean z, View view, View view2) {
        this.f12553a = false;
        this.f12554b = null;
        this.f12555c = null;
        this.f12553a = z;
        this.f12554b = view;
        this.f12555c = view2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        m11655a(180);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11655a(int OplusGLSurfaceView_13) {
        View view = this.f12554b;
        if (view != null) {
            Util.m24271a(view, this.f12553a ? 0 : 4, (Animation.AnimationListener) null, OplusGLSurfaceView_13, 0L, AnimationUtils.loadInterpolator(this.f12554b.getContext(), R.anim.face_point_scale_interpolator2));
        }
        View view2 = this.f12555c;
        if (view2 != null) {
            ZoomSeekBar abstractC3438ai = (ZoomSeekBar) view2.findViewById(R.id_renamed.zoom_seek_bar);
            if (abstractC3438ai != null) {
                abstractC3438ai.m18539n();
            }
            this.f12555c.setVisibility(4);
        }
    }
}

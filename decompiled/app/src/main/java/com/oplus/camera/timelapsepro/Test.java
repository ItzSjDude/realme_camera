package com.oplus.camera.timelapsepro;

/* compiled from: TimeLapseAnimUtil.java */
/* loaded from: classes2.dex */
public class d_renamed {
    public static void a_renamed(com.oplus.camera.ui.inverse.InverseTextView inverseTextView, boolean z_renamed) {
        a_renamed(inverseTextView, z_renamed, true);
    }

    public static void a_renamed(final com.oplus.camera.ui.inverse.InverseTextView inverseTextView, boolean z_renamed, boolean z2) {
        int i_renamed = com.oplus.camera.R_renamed.color.time_lapse_pro_seek_value_desc_color;
        if (z2) {
            int color = com.oplus.camera.MyApplication.d_renamed().getResources().getColor(com.oplus.camera.R_renamed.color.camera_white);
            int color2 = com.oplus.camera.MyApplication.d_renamed().getResources().getColor(com.oplus.camera.R_renamed.color.time_lapse_pro_seek_value_desc_color);
            int[] iArr = new int[2];
            iArr[0] = z_renamed ? color : color2;
            if (z_renamed) {
                color = color2;
            }
            iArr[1] = color;
            android.animation.ValueAnimator valueAnimatorOfArgb = android.animation.ValueAnimator.ofArgb(iArr);
            valueAnimatorOfArgb.setInterpolator(com.oplus.camera.professional.t_renamed.f5227a);
            valueAnimatorOfArgb.setDuration(500L);
            valueAnimatorOfArgb.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$d_renamed$CGamwhk-iQYaN1FDl3uc6-HRu7g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.timelapsepro.d_renamed.a_renamed(inverseTextView, valueAnimator);
                }
            });
            valueAnimatorOfArgb.start();
            return;
        }
        android.content.res.Resources resources = com.oplus.camera.MyApplication.d_renamed().getResources();
        if (!z_renamed) {
            i_renamed = com.oplus.camera.R_renamed.color.camera_white;
        }
        inverseTextView.setTextColor(resources.getColor(i_renamed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(com.oplus.camera.ui.inverse.InverseTextView inverseTextView, android.animation.ValueAnimator valueAnimator) {
        inverseTextView.setTextColor(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}

package com.oplus.camera.timelapsepro;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseTextView;
import com.oplus.camera.professional.ProfessionalAnimConstant;

/* compiled from: TimeLapseAnimUtil.java */
/* renamed from: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class TimeLapseAnimUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m17614a(InverseTextView inverseTextView, boolean z) {
        m17615a(inverseTextView, z, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m17615a(final InverseTextView inverseTextView, boolean z, boolean z2) {
        int OplusGLSurfaceView_13 = R.color.time_lapse_pro_seek_value_desc_color;
        if (z2) {
            int color = MyApplication.m11092d().getResources().getColor(R.color.camera_white);
            int color2 = MyApplication.m11092d().getResources().getColor(R.color.time_lapse_pro_seek_value_desc_color);
            int[] iArr = new int[2];
            iArr[0] = z ? color : color2;
            if (z) {
                color = color2;
            }
            iArr[1] = color;
            ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(iArr);
            valueAnimatorOfArgb.setInterpolator(ProfessionalAnimConstant.f15694a);
            valueAnimatorOfArgb.setDuration(500L);
            valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$IntrinsicsJvm.kt_5$CGamwhk-iQYaN1FDl3uc6-HRu7g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TimeLapseAnimUtil.m17613a(inverseTextView, valueAnimator);
                }
            });
            valueAnimatorOfArgb.start();
            return;
        }
        Resources resources = MyApplication.m11092d().getResources();
        if (!z) {
            OplusGLSurfaceView_13 = R.color.camera_white;
        }
        inverseTextView.setTextColor(resources.getColor(OplusGLSurfaceView_13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m17613a(InverseTextView inverseTextView, ValueAnimator valueAnimator) {
        inverseTextView.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}

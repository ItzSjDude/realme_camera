package com.google.android.material.internal;

/* loaded from: classes.dex */
public class TextScale extends androidx.transition.m_renamed {
    private static final java.lang.String PROPNAME_SCALE = "android:textscale:scale";

    @Override // androidx.transition.m_renamed
    public void captureStartValues(androidx.transition.t_renamed tVar) {
        captureValues(tVar);
    }

    @Override // androidx.transition.m_renamed
    public void captureEndValues(androidx.transition.t_renamed tVar) {
        captureValues(tVar);
    }

    private void captureValues(androidx.transition.t_renamed tVar) {
        if (tVar.f1755b instanceof android.widget.TextView) {
            tVar.f1754a.put(PROPNAME_SCALE, java.lang.Float.valueOf(((android.widget.TextView) tVar.f1755b).getScaleX()));
        }
    }

    @Override // androidx.transition.m_renamed
    public android.animation.Animator createAnimator(android.view.ViewGroup viewGroup, androidx.transition.t_renamed tVar, androidx.transition.t_renamed tVar2) {
        if (tVar == null || tVar2 == null || !(tVar.f1755b instanceof android.widget.TextView) || !(tVar2.f1755b instanceof android.widget.TextView)) {
            return null;
        }
        final android.widget.TextView textView = (android.widget.TextView) tVar2.f1755b;
        java.util.Map<java.lang.String, java.lang.Object> map = tVar.f1754a;
        java.util.Map<java.lang.String, java.lang.Object> map2 = tVar2.f1754a;
        float fFloatValue = map.get(PROPNAME_SCALE) != null ? ((java.lang.Float) map.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        float fFloatValue2 = map2.get(PROPNAME_SCALE) != null ? ((java.lang.Float) map2.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.TextScale.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float fFloatValue3 = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(fFloatValue3);
                textView.setScaleY(fFloatValue3);
            }
        });
        return valueAnimatorOfFloat;
    }
}

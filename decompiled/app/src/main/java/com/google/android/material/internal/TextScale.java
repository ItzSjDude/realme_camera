package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

/* loaded from: classes.dex */
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues c0797t) {
        captureValues(c0797t);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues c0797t) {
        captureValues(c0797t);
    }

    private void captureValues(TransitionValues c0797t) {
        if (c0797t.f4664b instanceof TextView) {
            c0797t.f4663a.put(PROPNAME_SCALE, Float.valueOf(((TextView) c0797t.f4664b).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues c0797t, TransitionValues c0797t2) {
        if (c0797t == null || c0797t2 == null || !(c0797t.f4664b instanceof TextView) || !(c0797t2.f4664b instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) c0797t2.f4664b;
        Map<String, Object> map = c0797t.f4663a;
        Map<String, Object> map2 = c0797t2.f4663a;
        float fFloatValue = map.get(PROPNAME_SCALE) != null ? ((Float) map.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        float fFloatValue2 = map2.get(PROPNAME_SCALE) != null ? ((Float) map2.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.TextScale.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(fFloatValue3);
                textView.setScaleY(fFloatValue3);
            }
        });
        return valueAnimatorOfFloat;
    }
}

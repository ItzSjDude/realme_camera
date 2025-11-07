package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.Preference;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUISpannablePreference extends Preference {

    /* renamed from: PlatformImplementations.kt_3 */
    private CharSequence f6992a;

    public COUISpannablePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6925a(context, attributeSet, 0, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6925a(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIPreference, OplusGLSurfaceView_13, i2);
        this.f6992a = typedArrayObtainStyledAttributes.getText(R.styleable.COUIPreference_couiAssignment);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        final TextView textView = (TextView) c0668l.m4007a(android.R.id_renamed.summary);
        if (textView != null) {
            textView.setHighlightColor(m3800K().getResources().getColor(android.R.color.transparent));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.preference.COUISpannablePreference.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int actionMasked = motionEvent.getActionMasked();
                    int selectionStart = textView.getSelectionStart();
                    int selectionEnd = textView.getSelectionEnd();
                    int offsetForPosition = textView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                    boolean z = selectionStart == selectionEnd || offsetForPosition <= selectionStart || offsetForPosition >= selectionEnd;
                    if (actionMasked != 0) {
                        if (actionMasked == 1 || actionMasked == 3) {
                            textView.setPressed(false);
                            textView.postInvalidateDelayed(70L);
                        }
                    } else {
                        if (z) {
                            return false;
                        }
                        textView.setPressed(true);
                        textView.invalidate();
                    }
                    return false;
                }
            });
        }
        TextView textView2 = (TextView) c0668l.m4007a(R.id_renamed.assignment);
        if (textView2 != null) {
            CharSequence charSequenceM6926b = m6926b();
            if (!TextUtils.isEmpty(charSequenceM6926b)) {
                textView2.setText(charSequenceM6926b);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public CharSequence m6926b() {
        return this.f6992a;
    }
}

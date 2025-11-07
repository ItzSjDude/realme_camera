package com.coui.appcompat.preference;

/* loaded from: classes.dex */
public class COUISpannablePreference extends androidx.preference.Preference {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.CharSequence f2622a;

    public COUISpannablePreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        a_renamed(context, attributeSet, 0, 0);
    }

    private void a_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIPreference, i_renamed, i2);
        this.f2622a = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiAssignment);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        super.a_renamed(lVar);
        final android.widget.TextView textView = (android.widget.TextView) lVar.a_renamed(android.R_renamed.id_renamed.summary);
        if (textView != null) {
            textView.setHighlightColor(K_renamed().getResources().getColor(android.R_renamed.color.transparent));
            textView.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
            textView.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.coui.appcompat.preference.COUISpannablePreference.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    int actionMasked = motionEvent.getActionMasked();
                    int selectionStart = textView.getSelectionStart();
                    int selectionEnd = textView.getSelectionEnd();
                    int offsetForPosition = textView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                    boolean z_renamed = selectionStart == selectionEnd || offsetForPosition <= selectionStart || offsetForPosition >= selectionEnd;
                    if (actionMasked != 0) {
                        if (actionMasked == 1 || actionMasked == 3) {
                            textView.setPressed(false);
                            textView.postInvalidateDelayed(70L);
                        }
                    } else {
                        if (z_renamed) {
                            return false;
                        }
                        textView.setPressed(true);
                        textView.invalidate();
                    }
                    return false;
                }
            });
        }
        android.widget.TextView textView2 = (android.widget.TextView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.assignment);
        if (textView2 != null) {
            java.lang.CharSequence charSequenceB = b_renamed();
            if (!android.text.TextUtils.isEmpty(charSequenceB)) {
                textView2.setText(charSequenceB);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
    }

    public java.lang.CharSequence b_renamed() {
        return this.f2622a;
    }
}

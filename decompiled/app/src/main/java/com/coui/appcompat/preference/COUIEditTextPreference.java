package com.coui.appcompat.preference;

/* loaded from: classes.dex */
public class COUIEditTextPreference extends androidx.preference.EditTextPreference {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f2579a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.CharSequence f2580b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.CharSequence f2581c;
    private java.lang.CharSequence d_renamed;
    private android.graphics.drawable.Drawable e_renamed;
    private boolean f_renamed;
    private android.graphics.drawable.Drawable g_renamed;
    private java.lang.CharSequence h_renamed;
    private boolean i_renamed;

    public COUIEditTextPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f_renamed = true;
        this.f2579a = context;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIJumpPreference, 0, 0);
        this.e_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_mark);
        this.f2580b = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_status1);
        this.f2581c = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_status2);
        this.d_renamed = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_status3);
        typedArrayObtainStyledAttributes.recycle();
        android.content.res.TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIPreference, 0, 0);
        this.f_renamed = typedArrayObtainStyledAttributes2.getBoolean(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiShowDivider, this.f_renamed);
        this.g_renamed = typedArrayObtainStyledAttributes2.getDrawable(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiDividerDrawable);
        this.h_renamed = typedArrayObtainStyledAttributes2.getText(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiAssignment);
        typedArrayObtainStyledAttributes2.recycle();
        android.content.res.TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.couiEditTextPreference, 0, 0);
        this.i_renamed = typedArrayObtainStyledAttributes3.getBoolean(coui.support.appcompat.R_renamed.styleable.couiEditTextPreference_couiSupportEmptyInput, false);
        typedArrayObtainStyledAttributes3.recycle();
    }

    @Override // androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        super.a_renamed(lVar);
        android.widget.ImageView imageView = (android.widget.ImageView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_preference_widget_jump);
        if (imageView != null) {
            android.graphics.drawable.Drawable drawable = this.e_renamed;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        android.widget.TextView textView = (android.widget.TextView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_statusText1);
        if (textView != null) {
            java.lang.CharSequence charSequence = this.f2580b;
            if (!android.text.TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        android.widget.TextView textView2 = (android.widget.TextView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_statusText2);
        if (textView2 != null) {
            java.lang.CharSequence charSequence2 = this.f2581c;
            if (!android.text.TextUtils.isEmpty(charSequence2)) {
                textView2.setText(charSequence2);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        android.widget.TextView textView3 = (android.widget.TextView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_statusText3);
        if (textView3 != null) {
            java.lang.CharSequence charSequence3 = this.d_renamed;
            if (!android.text.TextUtils.isEmpty(charSequence3)) {
                textView3.setText(charSequence3);
                textView3.setVisibility(0);
            } else {
                textView3.setVisibility(8);
            }
        }
        android.widget.TextView textView4 = (android.widget.TextView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.assignment);
        if (textView4 != null) {
            java.lang.CharSequence charSequenceM = m_renamed();
            if (!android.text.TextUtils.isEmpty(charSequenceM)) {
                textView4.setText(charSequenceM);
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(8);
            }
        }
    }

    public java.lang.CharSequence m_renamed() {
        return this.h_renamed;
    }

    public boolean o_renamed() {
        return this.i_renamed;
    }
}

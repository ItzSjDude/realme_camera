package com.coui.appcompat.preference;

/* loaded from: classes.dex */
public class COUIMultiSelectListPreference extends androidx.preference.MultiSelectListPreference {

    /* renamed from: a_renamed, reason: collision with root package name */
    android.content.Context f2598a;

    /* renamed from: b_renamed, reason: collision with root package name */
    java.lang.CharSequence f2599b;

    /* renamed from: c_renamed, reason: collision with root package name */
    java.lang.CharSequence f2600c;
    java.lang.CharSequence d_renamed;
    android.graphics.drawable.Drawable e_renamed;
    private java.util.Set<java.lang.String> f_renamed;
    private java.lang.CharSequence g_renamed;
    private java.lang.CharSequence[] h_renamed;

    public COUIMultiSelectListPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f_renamed = new java.util.HashSet();
        this.f2598a = context;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIJumpPreference, 0, 0);
        this.e_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_mark);
        this.f2599b = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_status1);
        this.f2600c = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_status2);
        this.d_renamed = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_status3);
        typedArrayObtainStyledAttributes.recycle();
        android.content.res.TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIPreference, 0, 0);
        this.g_renamed = typedArrayObtainStyledAttributes2.getText(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiAssignment);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public COUIMultiSelectListPreference(android.content.Context context) {
        super(context, null);
        this.f_renamed = new java.util.HashSet();
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
            java.lang.CharSequence charSequence = this.f2599b;
            if (!android.text.TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        android.widget.TextView textView2 = (android.widget.TextView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_statusText2);
        if (textView2 != null) {
            java.lang.CharSequence charSequence2 = this.f2600c;
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
            java.lang.CharSequence charSequenceO = o_renamed();
            if (!android.text.TextUtils.isEmpty(charSequenceO)) {
                textView4.setText(charSequenceO);
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(8);
            }
        }
    }

    public java.lang.CharSequence o_renamed() {
        return this.g_renamed;
    }

    public void c_renamed(java.lang.CharSequence charSequence) {
        if (android.text.TextUtils.equals(this.g_renamed, charSequence)) {
            return;
        }
        this.g_renamed = charSequence;
        i_renamed();
    }

    public void b_renamed(java.lang.CharSequence[] charSequenceArr) {
        this.h_renamed = charSequenceArr;
    }

    java.lang.CharSequence[] p_renamed() {
        return this.h_renamed;
    }
}

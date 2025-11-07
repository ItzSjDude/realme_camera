package com.coui.appcompat.preference;

/* loaded from: classes.dex */
public class COUIListPreference extends androidx.preference.ListPreference {

    /* renamed from: a_renamed, reason: collision with root package name */
    java.lang.CharSequence f2588a;

    /* renamed from: b_renamed, reason: collision with root package name */
    java.lang.CharSequence f2589b;

    /* renamed from: c_renamed, reason: collision with root package name */
    java.lang.CharSequence f2590c;
    android.graphics.drawable.Drawable d_renamed;
    java.lang.CharSequence[] e_renamed;
    private java.lang.CharSequence f_renamed;

    public COUIListPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIJumpPreference, 0, 0);
        this.d_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_mark);
        this.f2588a = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_status1);
        this.f2589b = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_status2);
        this.f2590c = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_status3);
        typedArrayObtainStyledAttributes.recycle();
        android.content.res.TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIPreference, 0, 0);
        this.f_renamed = typedArrayObtainStyledAttributes2.getText(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiAssignment);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public COUIListPreference(android.content.Context context) {
        this(context, null);
    }

    @Override // androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        super.a_renamed(lVar);
        android.widget.ImageView imageView = (android.widget.ImageView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_preference_widget_jump);
        if (imageView != null) {
            android.graphics.drawable.Drawable drawable = this.d_renamed;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        android.widget.TextView textView = (android.widget.TextView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_statusText1);
        if (textView != null) {
            java.lang.CharSequence charSequence = this.f2588a;
            if (!android.text.TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        android.widget.TextView textView2 = (android.widget.TextView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_statusText2);
        if (textView2 != null) {
            java.lang.CharSequence charSequence2 = this.f2589b;
            if (!android.text.TextUtils.isEmpty(charSequence2)) {
                textView2.setText(charSequence2);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        android.widget.TextView textView3 = (android.widget.TextView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_statusText3);
        if (textView3 != null) {
            java.lang.CharSequence charSequence3 = this.f2590c;
            if (!android.text.TextUtils.isEmpty(charSequence3)) {
                textView3.setText(charSequence3);
                textView3.setVisibility(0);
            } else {
                textView3.setVisibility(8);
            }
        }
        android.widget.TextView textView4 = (android.widget.TextView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.assignment);
        if (textView4 != null) {
            java.lang.CharSequence charSequenceH = h_renamed();
            if (!android.text.TextUtils.isEmpty(charSequenceH)) {
                textView4.setText(charSequenceH);
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(8);
            }
        }
    }

    public java.lang.CharSequence h_renamed() {
        return this.f_renamed;
    }

    public void c_renamed(java.lang.CharSequence charSequence) {
        if (android.text.TextUtils.equals(this.f_renamed, charSequence)) {
            return;
        }
        this.f_renamed = charSequence;
        i_renamed();
    }

    public void a_renamed(java.lang.CharSequence[] charSequenceArr) {
        this.e_renamed = charSequenceArr;
    }

    java.lang.CharSequence[] U_renamed() {
        return this.e_renamed;
    }
}

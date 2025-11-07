package com.coui.appcompat.preference;

/* loaded from: classes.dex */
public class COUIJumpPreference extends com.coui.appcompat.preference.COUIPreference {

    /* renamed from: a_renamed, reason: collision with root package name */
    android.content.Context f2585a;

    /* renamed from: b_renamed, reason: collision with root package name */
    java.lang.CharSequence f2586b;

    /* renamed from: c_renamed, reason: collision with root package name */
    java.lang.CharSequence f2587c;
    java.lang.CharSequence d_renamed;
    android.graphics.drawable.Drawable e_renamed;
    private int f_renamed;

    public COUIJumpPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed);
        this.f_renamed = 0;
        this.f2585a = context;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIJumpPreference, i_renamed, 0);
        this.e_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_mark);
        this.f2586b = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_status1);
        this.f2587c = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_status2);
        this.d_renamed = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_coui_jump_status3);
        this.f_renamed = typedArrayObtainStyledAttributes.getInt(coui.support.appcompat.R_renamed.styleable.COUIJumpPreference_couiClickStyle, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public COUIJumpPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public COUIJumpPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, coui.support.appcompat.R_renamed.attr.couiJumpPreferenceStyle);
    }

    public COUIJumpPreference(android.content.Context context) {
        this(context, null);
    }

    public void b_renamed(android.graphics.drawable.Drawable drawable) {
        if (this.e_renamed != drawable) {
            this.e_renamed = drawable;
            i_renamed();
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        int i_renamed;
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
        android.view.View viewA = lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_preference);
        if (viewA != null && (i_renamed = this.f_renamed) != 0) {
            if (i_renamed == 1) {
                viewA.setClickable(false);
            } else if (i_renamed == 2) {
                viewA.setClickable(true);
            }
        }
        android.widget.TextView textView = (android.widget.TextView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_statusText1);
        if (textView != null) {
            java.lang.CharSequence charSequence = this.f2586b;
            if (!android.text.TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        android.widget.TextView textView2 = (android.widget.TextView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_statusText2);
        if (textView2 != null) {
            java.lang.CharSequence charSequence2 = this.f2587c;
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
    }
}

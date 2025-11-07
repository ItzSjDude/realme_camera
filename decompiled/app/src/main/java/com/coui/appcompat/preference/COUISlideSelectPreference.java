package com.coui.appcompat.preference;

/* loaded from: classes.dex */
public class COUISlideSelectPreference extends com.coui.appcompat.preference.COUIPreference {

    /* renamed from: a_renamed, reason: collision with root package name */
    android.content.Context f2619a;

    /* renamed from: b_renamed, reason: collision with root package name */
    java.lang.CharSequence f2620b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f2621c;
    private android.widget.TextView d_renamed;

    public COUISlideSelectPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, coui.support.appcompat.R_renamed.attr.couiSlideSelectPreferenceStyle);
    }

    public COUISlideSelectPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public COUISlideSelectPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed);
        this.f2621c = 0;
        this.f2619a = context;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUISlideSelectPreference, i_renamed, 0);
        this.f2620b = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUISlideSelectPreference_coui_select_status1);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        int i_renamed;
        super.a_renamed(lVar);
        android.view.View viewA = lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_preference);
        viewA.setTag(new java.lang.Object());
        android.view.View viewFindViewById = viewA.findViewById(coui.support.appcompat.R_renamed.id_renamed.coui_preference);
        if (viewFindViewById != null && (i_renamed = this.f2621c) != 0) {
            if (i_renamed == 1) {
                viewFindViewById.setClickable(false);
            } else if (i_renamed == 2) {
                viewFindViewById.setClickable(true);
            }
        }
        this.d_renamed = (android.widget.TextView) viewA.findViewById(coui.support.appcompat.R_renamed.id_renamed.coui_statusText_select);
        if (this.d_renamed != null) {
            java.lang.CharSequence charSequence = this.f2620b;
            if (!android.text.TextUtils.isEmpty(charSequence)) {
                this.d_renamed.setText(charSequence);
                this.d_renamed.setVisibility(0);
            } else {
                this.d_renamed.setVisibility(8);
            }
        }
    }
}

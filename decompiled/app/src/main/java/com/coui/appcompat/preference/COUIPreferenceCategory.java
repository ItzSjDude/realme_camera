package com.coui.appcompat.preference;

/* loaded from: classes.dex */
public class COUIPreferenceCategory extends androidx.preference.PreferenceCategory {

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f2606b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f2607c;

    public COUIPreferenceCategory(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIPreferenceCategory, 0, 0);
        this.f2606b = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R_renamed.styleable.COUIPreferenceCategory_isFirstCategory, false);
        this.f2607c = context.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.support_preference_category_padding_top);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.PreferenceCategory, androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        super.a_renamed(lVar);
        if (this.f2606b) {
            a_renamed(lVar, coui.support.appcompat.R_renamed.id_renamed.coui_category_top_divider, 8, coui.support.appcompat.R_renamed.id_renamed.coui_category_root, this.f2607c);
        } else {
            a_renamed(lVar, coui.support.appcompat.R_renamed.id_renamed.coui_category_top_divider, 0, coui.support.appcompat.R_renamed.id_renamed.coui_category_root, 0);
        }
    }

    private void a_renamed(androidx.preference.l_renamed lVar, int i_renamed, int i2, int i3, int i4) {
        android.view.View viewA = lVar.a_renamed(i_renamed);
        if (viewA != null) {
            viewA.setVisibility(i2);
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) lVar.a_renamed(i3);
            if (linearLayout != null) {
                linearLayout.setPadding(0, i4, 0, 0);
            }
        }
    }
}

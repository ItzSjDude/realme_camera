package androidx.preference;

/* loaded from: classes.dex */
public class PreferenceCategory extends androidx.preference.PreferenceGroup {
    @Override // androidx.preference.Preference
    public boolean y_renamed() {
        return false;
    }

    public PreferenceCategory(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
    }

    public PreferenceCategory(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public PreferenceCategory(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(context, androidx.preference.R_renamed.attr.preferenceCategoryStyle, android.R_renamed.attr.preferenceCategoryStyle));
    }

    public PreferenceCategory(android.content.Context context) {
        this(context, null);
    }

    @Override // androidx.preference.Preference
    public boolean j_renamed() {
        return !super.y_renamed();
    }

    @Override // androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        android.widget.TextView textView;
        super.a_renamed(lVar);
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            lVar.itemView.setAccessibilityHeading(true);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT < 21) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            if (K_renamed().getTheme().resolveAttribute(androidx.preference.R_renamed.attr.colorAccent, typedValue, true) && (textView = (android.widget.TextView) lVar.a_renamed(android.R_renamed.id_renamed.title)) != null) {
                if (textView.getCurrentTextColor() != androidx.core.a_renamed.a_renamed.c_renamed(K_renamed(), androidx.preference.R_renamed.color.preference_fallback_accent_color)) {
                    return;
                }
                textView.setTextColor(typedValue.data);
            }
        }
    }

    @Override // androidx.preference.Preference
    @java.lang.Deprecated
    public void a_renamed(androidx.core.h_renamed.a_renamed.d_renamed dVar) {
        androidx.core.h_renamed.a_renamed.d_renamed.c_renamed cVarU;
        super.a_renamed(dVar);
        if (android.os.Build.VERSION.SDK_INT >= 28 || (cVarU = dVar.u_renamed()) == null) {
            return;
        }
        dVar.b_renamed(androidx.core.h_renamed.a_renamed.d_renamed.c_renamed.a_renamed(cVarU.c_renamed(), cVarU.d_renamed(), cVarU.a_renamed(), cVarU.b_renamed(), true, cVarU.e_renamed()));
    }
}

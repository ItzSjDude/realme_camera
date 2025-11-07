package androidx.preference;

/* loaded from: classes.dex */
public final class PreferenceScreen extends androidx.preference.PreferenceGroup {

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f1317b;

    @Override // androidx.preference.PreferenceGroup
    protected boolean e_renamed() {
        return false;
    }

    public PreferenceScreen(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet, androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(context, androidx.preference.R_renamed.attr.preferenceScreenStyle, android.R_renamed.attr.preferenceScreenStyle));
        this.f1317b = true;
    }

    @Override // androidx.preference.Preference
    protected void g_renamed() {
        androidx.preference.j_renamed.b_renamed bVarI;
        if (q_renamed() != null || r_renamed() != null || c_renamed() == 0 || (bVarI = N_renamed().i_renamed()) == null) {
            return;
        }
        bVarI.b_renamed(this);
    }

    public boolean l_renamed() {
        return this.f1317b;
    }
}

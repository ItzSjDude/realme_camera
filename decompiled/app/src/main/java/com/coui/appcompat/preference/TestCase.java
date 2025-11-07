package com.coui.appcompat.preference;

/* compiled from: COUIPreferenceFragment.java */
/* loaded from: classes.dex */
public class e_renamed extends androidx.preference.g_renamed {
    @Override // androidx.preference.g_renamed
    public void a_renamed(android.os.Bundle bundle, java.lang.String str) {
    }

    @Override // androidx.preference.g_renamed
    public androidx.recyclerview.widget.RecyclerView a_renamed(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) layoutInflater.inflate(coui.support.appcompat.R_renamed.layout.coui_preference_recyclerview, viewGroup, false);
        recyclerView.setLayoutManager(f_renamed());
        return recyclerView;
    }

    @Override // androidx.preference.g_renamed, androidx.fragment.app.Fragment
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        android.view.View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        a_renamed((android.graphics.drawable.Drawable) null);
        a_renamed(0);
        return viewOnCreateView;
    }

    @Override // androidx.preference.g_renamed, androidx.preference.j_renamed.a_renamed
    public void b_renamed(androidx.preference.Preference preference) {
        androidx.fragment.app.b_renamed bVarB;
        if (getFragmentManager().a_renamed("androidx.preference.PreferenceFragment.DIALOG") != null) {
            return;
        }
        if (preference instanceof com.coui.appcompat.preference.COUIActivityDialogPreference) {
            bVarB = com.coui.appcompat.preference.a_renamed.b_renamed(preference.B_renamed());
        } else if (preference instanceof com.coui.appcompat.preference.COUIEditTextPreference) {
            bVarB = com.coui.appcompat.preference.b_renamed.b_renamed(preference.B_renamed());
        } else if (preference instanceof com.coui.appcompat.preference.COUIMultiSelectListPreference) {
            bVarB = com.coui.appcompat.preference.d_renamed.c_renamed(preference.B_renamed());
        } else if (preference instanceof androidx.preference.ListPreference) {
            bVarB = com.coui.appcompat.preference.c_renamed.b_renamed(preference.B_renamed());
        } else {
            super.b_renamed(preference);
            return;
        }
        bVarB.setTargetFragment(this, 0);
        bVarB.show(getFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
    }
}

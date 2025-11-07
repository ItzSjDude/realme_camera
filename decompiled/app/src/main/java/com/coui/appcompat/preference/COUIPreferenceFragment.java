package com.coui.appcompat.preference;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import coui.support.appcompat.R;

/* compiled from: COUIPreferenceFragment.java */
/* renamed from: com.coui.appcompat.preference.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class COUIPreferenceFragment extends PreferenceFragmentCompat {
    @Override // androidx.preference.PreferenceFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3938a(Bundle bundle, String str) {
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    public RecyclerView mo3935a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView = (RecyclerView) layoutInflater.inflate(R.layout.coui_preference_recyclerview, viewGroup, false);
        recyclerView.setLayoutManager(m3949f());
        return recyclerView;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m3937a((Drawable) null);
        m3936a(0);
        return viewOnCreateView;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3943b(Preference preference) {
        DialogFragment dialogInterfaceOnCancelListenerC0580bM6956b;
        if (getFragmentManager().mo3388a("androidx.preference.PreferenceFragment.DIALOG") != null) {
            return;
        }
        if (preference instanceof COUIActivityDialogPreference) {
            dialogInterfaceOnCancelListenerC0580bM6956b = COUIActivityDialogFragment.m6951b(preference.m3791B());
        } else if (preference instanceof COUIEditTextPreference) {
            dialogInterfaceOnCancelListenerC0580bM6956b = COUIEditTextPreferenceDialogFragment.m6955b(preference.m3791B());
        } else if (preference instanceof COUIMultiSelectListPreference) {
            dialogInterfaceOnCancelListenerC0580bM6956b = COUIMultiSelectListPreferenceDialogFragment.m6958c(preference.m3791B());
        } else if (preference instanceof ListPreference) {
            dialogInterfaceOnCancelListenerC0580bM6956b = COUIListPreferenceDialogFragment.m6956b(preference.m3791B());
        } else {
            super.mo3943b(preference);
            return;
        }
        dialogInterfaceOnCancelListenerC0580bM6956b.setTargetFragment(this, 0);
        dialogInterfaceOnCancelListenerC0580bM6956b.show(getFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
    }
}

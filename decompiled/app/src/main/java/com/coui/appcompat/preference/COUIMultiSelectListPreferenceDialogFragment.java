package com.coui.appcompat.preference;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.preference.MultiSelectListPreferenceDialogFragmentCompat;
import com.coui.appcompat.dialog.panel.COUIListBottomSheetDialog;
import com.coui.appcompat.dialog.panel.COUIBottomSheetDialog;
import coui.support.appcompat.R;

/* compiled from: COUIMultiSelectListPreferenceDialogFragment.java */
/* renamed from: com.coui.appcompat.preference.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class COUIMultiSelectListPreferenceDialogFragment extends MultiSelectListPreferenceDialogFragmentCompat {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CharSequence[] f7075e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private CharSequence f7076f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private COUIListBottomSheetDialog f7077g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private COUIBottomSheetDialog f7078h;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static COUIMultiSelectListPreferenceDialogFragment m6958c(String str) {
        COUIMultiSelectListPreferenceDialogFragment c1345d = new COUIMultiSelectListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        c1345d.setArguments(bundle);
        return c1345d;
    }

    @Override // androidx.preference.MultiSelectListPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        COUIMultiSelectListPreference cOUIMultiSelectListPreference = (COUIMultiSelectListPreference) m3930b();
        if (cOUIMultiSelectListPreference != null) {
            this.f7076f = cOUIMultiSelectListPreference.m3737a();
            this.f7075e = cOUIMultiSelectListPreference.m6912p();
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        final COUIListBottomSheetDialog.PlatformImplementations.kt_3 aVarM6835a = new COUIListBottomSheetDialog.PlatformImplementations.kt_3(getActivity()).setTitle(this.f7076f).m6835a(this.f7075e);
        mo3917a(aVarM6835a);
        aVarM6835a.m6834a(getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.coui.appcompat.preference.IntrinsicsJvm.kt_5.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                COUIMultiSelectListPreferenceDialogFragment.this.onClick(aVarM6835a.m6829a(), -2);
                if (COUIMultiSelectListPreferenceDialogFragment.this.f7077g != null) {
                    COUIMultiSelectListPreferenceDialogFragment.this.f7077g.m6825a();
                }
            }
        }).m6838b(getString(R.string.dialog_ok), new View.OnClickListener() { // from class: com.coui.appcompat.preference.IntrinsicsJvm.kt_5.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                COUIMultiSelectListPreferenceDialogFragment.this.onClick(aVarM6835a.m6829a(), -1);
                if (COUIMultiSelectListPreferenceDialogFragment.this.f7077g != null) {
                    COUIMultiSelectListPreferenceDialogFragment.this.f7077g.m6825a();
                }
            }
        });
        this.f7077g = aVarM6835a.m6839b();
        Dialog dialogM6829a = aVarM6835a.m6829a();
        if (dialogM6829a instanceof COUIBottomSheetDialog) {
            this.f7078h = (COUIBottomSheetDialog) dialogM6829a;
        }
        return dialogM6829a;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (m3930b() == null) {
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        COUIBottomSheetDialog dialogC1309b = this.f7078h;
        if (dialogC1309b != null) {
            dialogC1309b.m6803a(configuration);
        }
    }
}

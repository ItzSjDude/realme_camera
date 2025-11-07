package com.coui.appcompat.preference;

/* compiled from: COUIMultiSelectListPreferenceDialogFragment.java */
/* loaded from: classes.dex */
public class d_renamed extends androidx.preference.d_renamed {
    private java.lang.CharSequence[] e_renamed;
    private java.lang.CharSequence f_renamed;
    private com.coui.appcompat.dialog.panel.c_renamed g_renamed;
    private com.coui.appcompat.dialog.panel.b_renamed h_renamed;

    public static com.coui.appcompat.preference.d_renamed c_renamed(java.lang.String str) {
        com.coui.appcompat.preference.d_renamed dVar = new com.coui.appcompat.preference.d_renamed();
        android.os.Bundle bundle = new android.os.Bundle(1);
        bundle.putString("key", str);
        dVar.setArguments(bundle);
        return dVar;
    }

    @Override // androidx.preference.d_renamed, androidx.preference.f_renamed, androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.coui.appcompat.preference.COUIMultiSelectListPreference cOUIMultiSelectListPreference = (com.coui.appcompat.preference.COUIMultiSelectListPreference) b_renamed();
        if (cOUIMultiSelectListPreference != null) {
            this.f_renamed = cOUIMultiSelectListPreference.a_renamed();
            this.e_renamed = cOUIMultiSelectListPreference.p_renamed();
        }
    }

    @Override // androidx.preference.f_renamed, androidx.fragment.app.b_renamed
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        final com.coui.appcompat.dialog.panel.c_renamed.a_renamed aVarA = new com.coui.appcompat.dialog.panel.c_renamed.a_renamed(getActivity()).setTitle(this.f_renamed).a_renamed(this.e_renamed);
        a_renamed(aVarA);
        aVarA.a_renamed(getString(coui.support.appcompat.R_renamed.string.dialog_cancel), new android.view.View.OnClickListener() { // from class: com.coui.appcompat.preference.d_renamed.2
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.coui.appcompat.preference.d_renamed.this.onClick(aVarA.a_renamed(), -2);
                if (com.coui.appcompat.preference.d_renamed.this.g_renamed != null) {
                    com.coui.appcompat.preference.d_renamed.this.g_renamed.a_renamed();
                }
            }
        }).b_renamed(getString(coui.support.appcompat.R_renamed.string.dialog_ok), new android.view.View.OnClickListener() { // from class: com.coui.appcompat.preference.d_renamed.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.coui.appcompat.preference.d_renamed.this.onClick(aVarA.a_renamed(), -1);
                if (com.coui.appcompat.preference.d_renamed.this.g_renamed != null) {
                    com.coui.appcompat.preference.d_renamed.this.g_renamed.a_renamed();
                }
            }
        });
        this.g_renamed = aVarA.b_renamed();
        android.app.Dialog dialogA = aVarA.a_renamed();
        if (dialogA instanceof com.coui.appcompat.dialog.panel.b_renamed) {
            this.h_renamed = (com.coui.appcompat.dialog.panel.b_renamed) dialogA;
        }
        return dialogA;
    }

    @Override // androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (b_renamed() == null) {
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.coui.appcompat.dialog.panel.b_renamed bVar = this.h_renamed;
        if (bVar != null) {
            bVar.a_renamed(configuration);
        }
    }
}

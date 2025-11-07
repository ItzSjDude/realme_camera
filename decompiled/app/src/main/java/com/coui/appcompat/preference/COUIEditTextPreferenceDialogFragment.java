package com.coui.appcompat.preference;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.preference.EditTextPreferenceDialogFragmentCompat;
import com.coui.appcompat.dialog.panel.COUIBottomSheetDialog;
import com.coui.appcompat.widget.COUIEditText;

/* compiled from: COUIEditTextPreferenceDialogFragment.java */
/* renamed from: com.coui.appcompat.preference.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class COUIEditTextPreferenceDialogFragment extends EditTextPreferenceDialogFragmentCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private COUIEditText f7061a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private COUIBottomSheetDialog f7062b;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static COUIEditTextPreferenceDialogFragment m6955b(String str) {
        COUIEditTextPreferenceDialogFragment c1343b = new COUIEditTextPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        c1343b.setArguments(bundle);
        return c1343b;
    }

    @Override // androidx.preference.EditTextPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        COUIEditText cOUIEditText = this.f7061a;
        if (cOUIEditText != null) {
            bundle.putCharSequence("EditTextPreferenceDialogFragment.text", cOUIEditText.getText());
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        COUIBottomSheetDialog dialogC1309b = this.f7062b;
        if (dialogC1309b != null) {
            dialogC1309b.m6803a(configuration);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0041  */
    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.app.Dialog onCreateDialog(android.os.Bundle r12) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        /*
            r11 = this;
            androidx.fragment.app.IntrinsicsJvm.kt_3 r12 = r11.getActivity()
            com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4 r0 = new com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4
            androidx.fragment.app.IntrinsicsJvm.kt_3 r1 = r11.getActivity()
            int r2 = coui.support.appcompat.R.style.DefaultBottomSheetDialog
            r0.<init>(r1, r2)
            r11.f7062b = r0
            android.view.View r12 = r11.m3929a(r12)
            r0 = 16908291(0x1020003, float:2.3877237E-38)
            android.view.View r0 = r12.findViewById(r0)
            com.coui.appcompat.widget.COUIEditText r0 = (com.coui.appcompat.widget.COUIEditText) r0
            r11.f7061a = r0
            int r0 = coui.support.appcompat.R.id_renamed.normal_bottom_sheet_toolbar
            android.view.View r0 = r12.findViewById(r0)
            com.coui.appcompat.widget.toolbar.COUIToolbar r0 = (com.coui.appcompat.widget.toolbar.COUIToolbar) r0
            androidx.preference.DialogPreference r1 = r11.m3930b()
            r2 = 0
            if (r1 == 0) goto L41
            androidx.preference.DialogPreference r3 = r11.m3930b()
            java.lang.CharSequence r3 = r3.m3737a()
            r0.setTitle(r3)
            boolean r3 = r1 instanceof com.coui.appcompat.preference.COUIEditTextPreference
            if (r3 == 0) goto L41
            com.coui.appcompat.preference.COUIEditTextPreference r1 = (com.coui.appcompat.preference.COUIEditTextPreference) r1
            goto L42
        L41:
            r1 = r2
        L42:
            r3 = 1
            r0.setIsTitleCenterStyle(r3)
            if (r1 == 0) goto L4d
            boolean r0 = r1.m6895o()
            goto L4e
        L4d:
            r0 = 0
        L4e:
            com.coui.appcompat.widget.COUIEditText r1 = r11.f7061a
            com.coui.appcompat.preference.IntrinsicsJvm.kt_4$1 r3 = new com.coui.appcompat.preference.IntrinsicsJvm.kt_4$1
            r3.<init>()
            r1.addTextChangedListener(r3)
            if (r12 == 0) goto La7
            androidx.preference.DialogPreference r0 = r11.m3930b()
            if (r0 == 0) goto L63
            r11.mo3910a(r12)
        L63:
            androidx.preference.DialogPreference r0 = r11.m3930b()
            if (r0 == 0) goto L8e
            androidx.preference.DialogPreference r0 = r11.m3930b()
            java.lang.CharSequence r0 = r0.m3741e()
            if (r0 == 0) goto L8e
            androidx.preference.DialogPreference r0 = r11.m3930b()
            java.lang.CharSequence r0 = r0.m3741e()
            java.lang.String r2 = r0.toString()
            androidx.preference.DialogPreference r0 = r11.m3930b()
            java.lang.CharSequence r0 = r0.m3740d()
            java.lang.String r0 = r0.toString()
            r7 = r0
            r5 = r2
            goto L90
        L8e:
            r5 = r2
            r7 = r5
        L90:
            com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4 r0 = r11.f7062b
            r0.setContentView(r12)
            com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4 r3 = r11.f7062b
            r4 = 0
            com.coui.appcompat.preference.IntrinsicsJvm.kt_4$2 r6 = new com.coui.appcompat.preference.IntrinsicsJvm.kt_4$2
            r6.<init>()
            com.coui.appcompat.preference.IntrinsicsJvm.kt_4$3 r8 = new com.coui.appcompat.preference.IntrinsicsJvm.kt_4$3
            r8.<init>()
            r9 = 0
            r10 = 0
            r3.m6808a(r4, r5, r6, r7, r8, r9, r10)
        La7:
            com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4 r11 = r11.f7062b
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.preference.COUIEditTextPreferenceDialogFragment.onCreateDialog(android.os.Bundle):android.app.Dialog");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        COUIEditText cOUIEditText = this.f7061a;
        if (cOUIEditText != null) {
            cOUIEditText.setFocusable(true);
            this.f7061a.requestFocus();
            if (getDialog() != null) {
                getDialog().getWindow().setSoftInputMode(5);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (m3930b() == null) {
            dismiss();
        }
    }
}

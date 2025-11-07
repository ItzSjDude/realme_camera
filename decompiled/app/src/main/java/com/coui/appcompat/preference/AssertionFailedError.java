package com.coui.appcompat.preference;

/* compiled from: COUIEditTextPreferenceDialogFragment.java */
/* loaded from: classes.dex */
public class b_renamed extends androidx.preference.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.coui.appcompat.widget.COUIEditText f2663a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.coui.appcompat.dialog.panel.b_renamed f2664b;

    public static com.coui.appcompat.preference.b_renamed b_renamed(java.lang.String str) {
        com.coui.appcompat.preference.b_renamed bVar = new com.coui.appcompat.preference.b_renamed();
        android.os.Bundle bundle = new android.os.Bundle(1);
        bundle.putString("key", str);
        bVar.setArguments(bundle);
        return bVar;
    }

    @Override // androidx.preference.a_renamed, androidx.preference.f_renamed, androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        com.coui.appcompat.widget.COUIEditText cOUIEditText = this.f2663a;
        if (cOUIEditText != null) {
            bundle.putCharSequence("EditTextPreferenceDialogFragment.text", cOUIEditText.getText());
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.coui.appcompat.dialog.panel.b_renamed bVar = this.f2664b;
        if (bVar != null) {
            bVar.a_renamed(configuration);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:7:0x0041  */
    @Override // androidx.preference.f_renamed, androidx.fragment.app.b_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.app.Dialog onCreateDialog(android.os.Bundle r12) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        /*
            r11 = this;
            androidx.fragment.app.c_renamed r12 = r11.getActivity()
            com.coui.appcompat.dialog.panel.b_renamed r0 = new com.coui.appcompat.dialog.panel.b_renamed
            androidx.fragment.app.c_renamed r1 = r11.getActivity()
            int r2 = coui.support.appcompat.R_renamed.style.DefaultBottomSheetDialog
            r0.<init>(r1, r2)
            r11.f2664b = r0
            android.view.View r12 = r11.a_renamed(r12)
            r0 = 16908291(0x1020003, float:2.3877237E-38)
            android.view.View r0 = r12.findViewById(r0)
            com.coui.appcompat.widget.COUIEditText r0 = (com.coui.appcompat.widget.COUIEditText) r0
            r11.f2663a = r0
            int r0 = coui.support.appcompat.R_renamed.id_renamed.normal_bottom_sheet_toolbar
            android.view.View r0 = r12.findViewById(r0)
            com.coui.appcompat.widget.toolbar.COUIToolbar r0 = (com.coui.appcompat.widget.toolbar.COUIToolbar) r0
            androidx.preference.DialogPreference r1 = r11.b_renamed()
            r2 = 0
            if (r1 == 0) goto L41
            androidx.preference.DialogPreference r3 = r11.b_renamed()
            java.lang.CharSequence r3 = r3.a_renamed()
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
            boolean r0 = r1.o_renamed()
            goto L4e
        L4d:
            r0 = 0
        L4e:
            com.coui.appcompat.widget.COUIEditText r1 = r11.f2663a
            com.coui.appcompat.preference.b_renamed$1 r3 = new com.coui.appcompat.preference.b_renamed$1
            r3.<init>()
            r1.addTextChangedListener(r3)
            if (r12 == 0) goto La7
            androidx.preference.DialogPreference r0 = r11.b_renamed()
            if (r0 == 0) goto L63
            r11.a_renamed(r12)
        L63:
            androidx.preference.DialogPreference r0 = r11.b_renamed()
            if (r0 == 0) goto L8e
            androidx.preference.DialogPreference r0 = r11.b_renamed()
            java.lang.CharSequence r0 = r0.e_renamed()
            if (r0 == 0) goto L8e
            androidx.preference.DialogPreference r0 = r11.b_renamed()
            java.lang.CharSequence r0 = r0.e_renamed()
            java.lang.String r2 = r0.toString()
            androidx.preference.DialogPreference r0 = r11.b_renamed()
            java.lang.CharSequence r0 = r0.d_renamed()
            java.lang.String r0 = r0.toString()
            r7 = r0
            r5 = r2
            goto L90
        L8e:
            r5 = r2
            r7 = r5
        L90:
            com.coui.appcompat.dialog.panel.b_renamed r0 = r11.f2664b
            r0.setContentView(r12)
            com.coui.appcompat.dialog.panel.b_renamed r3 = r11.f2664b
            r4 = 0
            com.coui.appcompat.preference.b_renamed$2 r6 = new com.coui.appcompat.preference.b_renamed$2
            r6.<init>()
            com.coui.appcompat.preference.b_renamed$3 r8 = new com.coui.appcompat.preference.b_renamed$3
            r8.<init>()
            r9 = 0
            r10 = 0
            r3.a_renamed(r4, r5, r6, r7, r8, r9, r10)
        La7:
            com.coui.appcompat.dialog.panel.b_renamed r11 = r11.f2664b
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.preference.b_renamed.onCreateDialog(android.os.Bundle):android.app.Dialog");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.coui.appcompat.widget.COUIEditText cOUIEditText = this.f2663a;
        if (cOUIEditText != null) {
            cOUIEditText.setFocusable(true);
            this.f2663a.requestFocus();
            if (getDialog() != null) {
                getDialog().getWindow().setSoftInputMode(5);
            }
        }
    }

    @Override // androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (b_renamed() == null) {
            dismiss();
        }
    }
}

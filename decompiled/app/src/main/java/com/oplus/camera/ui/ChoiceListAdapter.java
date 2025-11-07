package com.oplus.camera.ui;

/* compiled from: StatementDialogFragment.java */
/* loaded from: classes2.dex */
public class v_renamed extends androidx.fragment.app.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.coui.appcompat.widget.COUIFullPageStatement f7183a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.v_renamed.a_renamed f7184b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f7185c;
    private java.lang.String d_renamed;
    private java.lang.String e_renamed;

    /* compiled from: StatementDialogFragment.java */
    public interface a_renamed {
        void a_renamed();

        void b_renamed();

        void c_renamed();
    }

    public v_renamed() {
    }

    public v_renamed(java.lang.String str) {
        this.f7185c = str;
    }

    @Override // androidx.fragment.app.b_renamed
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        com.oplus.camera.e_renamed.f_renamed("StatementDialogFragment", "onCreateDialog");
        androidx.fragment.app.c_renamed activity = getActivity();
        if (activity == null) {
            return null;
        }
        androidx.appcompat.app.f_renamed fVar = new androidx.appcompat.app.f_renamed(activity, com.oplus.camera.R_renamed.style.StatementAndGuideTheme);
        fVar.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: com.oplus.camera.ui.v_renamed.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(android.content.DialogInterface dialogInterface, int i_renamed, android.view.KeyEvent keyEvent) {
                if (i_renamed != 4) {
                    return false;
                }
                androidx.fragment.app.c_renamed activity2 = com.oplus.camera.ui.v_renamed.this.getActivity();
                if (activity2 == null) {
                    return true;
                }
                activity2.finish();
                return true;
            }
        });
        android.view.View viewInflate = android.view.LayoutInflater.from(activity).inflate(com.oplus.camera.R_renamed.layout.statement_dialog_layout, (android.view.ViewGroup) null);
        this.f7183a = (com.coui.appcompat.widget.COUIFullPageStatement) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.full_statement_page);
        if (com.oplus.camera.util.Util.u_renamed()) {
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.f7183a.getLayoutParams();
            layoutParams.width = com.oplus.camera.util.Util.V_renamed();
            layoutParams.bottomMargin = (int) getResources().getDimension(com.oplus.camera.R_renamed.dimen.full_page_statement_margin_bottom);
            layoutParams.addRule(14);
            this.f7183a.setLayoutParams(layoutParams);
            this.f7183a.setBackgroundResource(com.oplus.camera.R_renamed.drawable.folder_statement_page_bg);
        } else {
            this.f7183a.setBackgroundResource(com.oplus.camera.R_renamed.drawable.statement_page_bg);
        }
        c_renamed();
        com.oplus.camera.ui.v_renamed.a_renamed aVar = this.f7184b;
        if (aVar != null) {
            aVar.a_renamed();
        }
        viewInflate.setForceDarkAllowed(true);
        fVar.supportRequestWindowFeature(1);
        fVar.getWindow().getDecorView().setBackgroundColor(0);
        if (30 < android.os.Build.VERSION.SDK_INT && com.oplus.camera.util.Util.ab_renamed()) {
            fVar.getWindow().getDecorView().setSystemUiVisibility(5892);
            fVar.getWindow().setNavigationBarContrastEnforced(false);
            fVar.getWindow().setNavigationBarColor(0);
        } else {
            fVar.getWindow().getDecorView().setSystemUiVisibility(5124);
            fVar.getWindow().setNavigationBarColor(getContext().getColor(com.oplus.camera.R_renamed.color.full_page_statement_bg_color));
        }
        fVar.setContentView(viewInflate);
        setShowsDialog(false);
        return fVar;
    }

    public void a_renamed(java.lang.String str) {
        this.d_renamed = str;
    }

    public void b_renamed(java.lang.String str) {
        this.e_renamed = str;
    }

    public boolean a_renamed() {
        android.app.Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public com.coui.appcompat.widget.COUIFullPageStatement b_renamed() {
        return this.f7183a;
    }

    public void a_renamed(com.oplus.camera.ui.v_renamed.a_renamed aVar) {
        this.f7184b = aVar;
    }

    public void c_renamed() {
        if (this.f7183a == null) {
            return;
        }
        if (!android.text.TextUtils.isEmpty(this.f7185c)) {
            this.f7183a.setTitleText(this.f7185c);
        }
        if (!android.text.TextUtils.isEmpty(this.d_renamed)) {
            this.f7183a.setExitButtonText(this.d_renamed);
        }
        if (android.text.TextUtils.isEmpty(this.e_renamed)) {
            return;
        }
        this.f7183a.setButtonText(this.e_renamed);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.oplus.camera.ui.v_renamed.a_renamed aVar = this.f7184b;
        if (aVar != null) {
            aVar.c_renamed();
        }
    }

    @Override // androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        com.oplus.camera.ui.v_renamed.a_renamed aVar = this.f7184b;
        if (aVar != null) {
            aVar.b_renamed();
        }
    }
}

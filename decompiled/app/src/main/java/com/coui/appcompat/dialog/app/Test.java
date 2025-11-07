package com.coui.appcompat.dialog.app;

/* compiled from: COUISpinnerDialog.java */
/* loaded from: classes.dex */
public class d_renamed extends com.coui.appcompat.dialog.app.b_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    protected android.view.View f2475c;
    protected android.widget.TextView d_renamed;
    protected int e_renamed;
    protected int f_renamed;
    protected java.lang.CharSequence g_renamed;
    protected boolean h_renamed;

    public void b_renamed(int i_renamed) {
    }

    public void c_renamed(int i_renamed) {
    }

    public d_renamed(android.content.Context context) {
        super(context);
    }

    @Override // com.coui.appcompat.dialog.app.b_renamed, androidx.appcompat.app.b_renamed, androidx.appcompat.app.f_renamed, android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        int i_renamed = this.e_renamed;
        if (i_renamed > 0) {
            c_renamed(i_renamed);
        }
        int i2 = this.f_renamed;
        if (i2 > 0) {
            b_renamed(i2);
        }
        java.lang.CharSequence charSequence = this.g_renamed;
        if (charSequence != null) {
            a_renamed(charSequence);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.h_renamed = true;
    }

    @Override // androidx.appcompat.app.f_renamed, android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.h_renamed = false;
    }

    @Override // com.coui.appcompat.dialog.app.b_renamed, androidx.appcompat.app.b_renamed
    public void a_renamed(java.lang.CharSequence charSequence) {
        if (this.f2475c != null) {
            this.d_renamed.setText(charSequence);
        } else {
            this.g_renamed = charSequence;
        }
    }
}

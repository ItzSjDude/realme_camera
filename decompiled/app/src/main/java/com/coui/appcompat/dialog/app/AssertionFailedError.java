package com.coui.appcompat.dialog.app;

/* compiled from: COUIAlertDialog.java */
/* loaded from: classes.dex */
public class b_renamed extends androidx.appcompat.app.b_renamed implements android.content.DialogInterface {

    /* renamed from: b_renamed, reason: collision with root package name */
    final com.coui.appcompat.dialog.app.a_renamed f2467b;

    protected b_renamed(android.content.Context context) {
        this(context, 0);
    }

    protected b_renamed(android.content.Context context, int i_renamed) {
        super(context, b_renamed(context, i_renamed));
        this.f2467b = new com.coui.appcompat.dialog.app.COUIAlertController(getContext(), this, getWindow());
    }

    static int b_renamed(android.content.Context context, int i_renamed) {
        if (((i_renamed >>> 24) & 255) >= 1) {
            return i_renamed;
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        context.getTheme().resolveAttribute(coui.support.appcompat.R_renamed.attr.couiAlertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.b_renamed
    public android.widget.Button a_renamed(int i_renamed) {
        return this.f2467b.d_renamed(i_renamed);
    }

    @Override // androidx.appcompat.app.b_renamed
    public android.widget.ListView a_renamed() {
        return this.f2467b.c_renamed();
    }

    @Override // androidx.appcompat.app.b_renamed, androidx.appcompat.app.f_renamed, android.app.Dialog
    public void setTitle(java.lang.CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f2467b.a_renamed(charSequence);
    }

    @Override // androidx.appcompat.app.b_renamed
    public void a_renamed(java.lang.CharSequence charSequence) {
        this.f2467b.b_renamed(charSequence);
    }

    @Override // androidx.appcompat.app.b_renamed
    public void a_renamed(android.view.View view) {
        this.f2467b.c_renamed(view);
    }

    @Override // androidx.appcompat.app.b_renamed
    public void a_renamed(int i_renamed, java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
        this.f2467b.a_renamed(i_renamed, charSequence, onClickListener, (android.os.Message) null, (android.graphics.drawable.Drawable) null);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z_renamed) {
        super.setCancelable(z_renamed);
        com.coui.appcompat.dialog.app.a_renamed aVar = this.f2467b;
        if (aVar instanceof com.coui.appcompat.dialog.app.COUIAlertController) {
            ((com.coui.appcompat.dialog.app.COUIAlertController) aVar).a_renamed(z_renamed);
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z_renamed) {
        super.setCanceledOnTouchOutside(z_renamed);
        com.coui.appcompat.dialog.app.a_renamed aVar = this.f2467b;
        if (aVar instanceof com.coui.appcompat.dialog.app.COUIAlertController) {
            ((com.coui.appcompat.dialog.app.COUIAlertController) aVar).a_renamed(z_renamed);
        }
    }

    @Override // androidx.appcompat.app.b_renamed, androidx.appcompat.app.f_renamed, android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        this.f2467b.a_renamed();
    }

    @Override // androidx.appcompat.app.b_renamed, android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i_renamed, android.view.KeyEvent keyEvent) {
        if (this.f2467b.a_renamed(i_renamed, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i_renamed, keyEvent);
    }

    @Override // androidx.appcompat.app.b_renamed, android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i_renamed, android.view.KeyEvent keyEvent) {
        if (this.f2467b.b_renamed(i_renamed, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i_renamed, keyEvent);
    }

    /* compiled from: COUIAlertDialog.java */
    public static class a_renamed extends androidx.appcompat.app.b_renamed.a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final com.coui.appcompat.dialog.app.COUIAlertController.a_renamed f2468a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int f2469b;

        public a_renamed(android.content.Context context) {
            this(context, com.coui.appcompat.dialog.app.b_renamed.b_renamed(context, 0));
        }

        public a_renamed(android.content.Context context, int i_renamed) {
            super(context, i_renamed);
            this.f2468a = new com.coui.appcompat.dialog.app.COUIAlertController.a_renamed(new android.view.ContextThemeWrapper(context, com.coui.appcompat.dialog.app.b_renamed.b_renamed(context, i_renamed)));
            this.f2469b = i_renamed;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        public android.content.Context getContext() {
            return this.f2468a.f2448a;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setTitle(int i_renamed) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.f_renamed = aVar.f2448a.getText(i_renamed);
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setTitle(java.lang.CharSequence charSequence) {
            this.f2468a.f_renamed = charSequence;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setCustomTitle(android.view.View view) {
            this.f2468a.g_renamed = view;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setMessage(int i_renamed) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.h_renamed = aVar.f2448a.getText(i_renamed);
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setMessage(java.lang.CharSequence charSequence) {
            this.f2468a.h_renamed = charSequence;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: c_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setIcon(int i_renamed) {
            this.f2468a.f2450c = i_renamed;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setIcon(android.graphics.drawable.Drawable drawable) {
            this.f2468a.d_renamed = drawable;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: d_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setIconAttribute(int i_renamed) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            this.f2468a.f2448a.getTheme().resolveAttribute(i_renamed, typedValue, true);
            this.f2468a.f2450c = typedValue.resourceId;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setPositiveButton(int i_renamed, android.content.DialogInterface.OnClickListener onClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.i_renamed = aVar.f2448a.getText(i_renamed);
            this.f2468a.k_renamed = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setPositiveButton(java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.i_renamed = charSequence;
            aVar.k_renamed = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setPositiveButtonIcon(android.graphics.drawable.Drawable drawable) {
            this.f2468a.j_renamed = drawable;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setNegativeButton(int i_renamed, android.content.DialogInterface.OnClickListener onClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.l_renamed = aVar.f2448a.getText(i_renamed);
            this.f2468a.n_renamed = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setNegativeButton(java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.l_renamed = charSequence;
            aVar.n_renamed = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: c_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setNegativeButtonIcon(android.graphics.drawable.Drawable drawable) {
            this.f2468a.m_renamed = drawable;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: c_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setNeutralButton(int i_renamed, android.content.DialogInterface.OnClickListener onClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.o_renamed = aVar.f2448a.getText(i_renamed);
            this.f2468a.q_renamed = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: c_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setNeutralButton(java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.o_renamed = charSequence;
            aVar.q_renamed = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: d_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setNeutralButtonIcon(android.graphics.drawable.Drawable drawable) {
            this.f2468a.p_renamed = drawable;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setCancelable(boolean z_renamed) {
            this.f2468a.r_renamed = z_renamed;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setOnCancelListener(android.content.DialogInterface.OnCancelListener onCancelListener) {
            this.f2468a.t_renamed = onCancelListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setOnDismissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
            this.f2468a.u_renamed = onDismissListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setOnKeyListener(android.content.DialogInterface.OnKeyListener onKeyListener) {
            this.f2468a.v_renamed = onKeyListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: d_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setItems(int i_renamed, android.content.DialogInterface.OnClickListener onClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.w_renamed = aVar.f2448a.getResources().getTextArray(i_renamed);
            this.f2468a.A_renamed = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setItems(java.lang.CharSequence[] charSequenceArr, android.content.DialogInterface.OnClickListener onClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.w_renamed = charSequenceArr;
            aVar.A_renamed = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setAdapter(android.widget.ListAdapter listAdapter, android.content.DialogInterface.OnClickListener onClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.z_renamed = listAdapter;
            aVar.A_renamed = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setCursor(android.database.Cursor cursor, android.content.DialogInterface.OnClickListener onClickListener, java.lang.String str) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.N_renamed = cursor;
            aVar.O_renamed = str;
            aVar.A_renamed = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setMultiChoiceItems(int i_renamed, boolean[] zArr, android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.w_renamed = aVar.f2448a.getResources().getTextArray(i_renamed);
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar2 = this.f2468a;
            aVar2.M_renamed = onMultiChoiceClickListener;
            aVar2.I_renamed = zArr;
            aVar2.J_renamed = true;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setMultiChoiceItems(java.lang.CharSequence[] charSequenceArr, boolean[] zArr, android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.w_renamed = charSequenceArr;
            aVar.M_renamed = onMultiChoiceClickListener;
            aVar.I_renamed = zArr;
            aVar.J_renamed = true;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setMultiChoiceItems(android.database.Cursor cursor, java.lang.String str, java.lang.String str2, android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.N_renamed = cursor;
            aVar.M_renamed = onMultiChoiceClickListener;
            aVar.P_renamed = str;
            aVar.O_renamed = str2;
            aVar.J_renamed = true;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setSingleChoiceItems(int i_renamed, int i2, android.content.DialogInterface.OnClickListener onClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.w_renamed = aVar.f2448a.getResources().getTextArray(i_renamed);
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar2 = this.f2468a;
            aVar2.A_renamed = onClickListener;
            aVar2.L_renamed = i2;
            aVar2.K_renamed = true;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setSingleChoiceItems(android.database.Cursor cursor, int i_renamed, java.lang.String str, android.content.DialogInterface.OnClickListener onClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.N_renamed = cursor;
            aVar.A_renamed = onClickListener;
            aVar.L_renamed = i_renamed;
            aVar.O_renamed = str;
            aVar.K_renamed = true;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setSingleChoiceItems(java.lang.CharSequence[] charSequenceArr, int i_renamed, android.content.DialogInterface.OnClickListener onClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.w_renamed = charSequenceArr;
            aVar.A_renamed = onClickListener;
            aVar.L_renamed = i_renamed;
            aVar.K_renamed = true;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setSingleChoiceItems(android.widget.ListAdapter listAdapter, int i_renamed, android.content.DialogInterface.OnClickListener onClickListener) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.z_renamed = listAdapter;
            aVar.A_renamed = onClickListener;
            aVar.L_renamed = i_renamed;
            aVar.K_renamed = true;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f2468a.R_renamed = onItemSelectedListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: e_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setView(int i_renamed) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.C_renamed = null;
            aVar.B_renamed = i_renamed;
            aVar.H_renamed = false;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setView(android.view.View view) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.C_renamed = view;
            aVar.B_renamed = 0;
            aVar.H_renamed = false;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        @java.lang.Deprecated
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setView(android.view.View view, int i_renamed, int i2, int i3, int i4) {
            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed aVar = this.f2468a;
            aVar.C_renamed = view;
            aVar.B_renamed = 0;
            aVar.H_renamed = true;
            aVar.D_renamed = i_renamed;
            aVar.E_renamed = i2;
            aVar.F_renamed = i3;
            aVar.G_renamed = i4;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        @java.lang.Deprecated
        /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setInverseBackgroundForced(boolean z_renamed) {
            this.f2468a.Q_renamed = z_renamed;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: c_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed.a_renamed setRecycleOnMeasureEnabled(boolean z_renamed) {
            this.f2468a.T_renamed = z_renamed;
            return this;
        }

        public com.coui.appcompat.dialog.app.b_renamed.a_renamed f_renamed(int i_renamed) {
            this.f2468a.U_renamed = i_renamed;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed create() {
            com.coui.appcompat.dialog.app.b_renamed bVar = new com.coui.appcompat.dialog.app.b_renamed(this.f2468a.f2448a, this.f2469b);
            this.f2468a.a_renamed(bVar.f2467b);
            bVar.setCancelable(this.f2468a.r_renamed);
            if (this.f2468a.r_renamed) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f2468a.t_renamed);
            bVar.setOnDismissListener(this.f2468a.u_renamed);
            if (this.f2468a.v_renamed != null) {
                bVar.setOnKeyListener(this.f2468a.v_renamed);
            }
            return bVar;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.app.b_renamed show() {
            com.coui.appcompat.dialog.app.b_renamed bVarCreate = create();
            bVarCreate.show();
            return bVarCreate;
        }
    }
}

package com.coui.appcompat.dialog.panel;

/* compiled from: COUIListBottomSheetDialog.java */
/* loaded from: classes.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.coui.appcompat.dialog.panel.b_renamed f2541a;

    /* compiled from: COUIListBottomSheetDialog.java */
    public static class a_renamed extends androidx.appcompat.app.b_renamed.a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public boolean[] f2542a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f2543b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public android.content.DialogInterface.OnMultiChoiceClickListener f2544c;
        public android.content.DialogInterface.OnClickListener d_renamed;
        private com.coui.appcompat.dialog.panel.c_renamed e_renamed;
        private android.view.View f_renamed;
        private java.lang.CharSequence g_renamed;
        private android.content.Context h_renamed;
        private java.lang.CharSequence[] i_renamed;
        private java.lang.CharSequence[] j_renamed;
        private java.lang.String k_renamed;
        private android.view.View.OnClickListener l_renamed;
        private java.lang.String m_renamed;
        private android.view.View.OnClickListener n_renamed;
        private java.lang.String o_renamed;
        private android.view.View.OnClickListener p_renamed;
        private boolean q_renamed;
        private boolean r_renamed;
        private int s_renamed;

        public a_renamed(android.content.Context context) {
            super(context);
            this.e_renamed = new com.coui.appcompat.dialog.panel.c_renamed();
            this.f2543b = -1;
            this.q_renamed = false;
            a_renamed(context);
        }

        private void a_renamed(android.content.Context context) {
            this.h_renamed = context;
            this.f_renamed = android.view.LayoutInflater.from(this.h_renamed).inflate(coui.support.appcompat.R_renamed.layout.coui_list_bottom_sheet_dialog_layout, (android.view.ViewGroup) null);
        }

        public android.app.Dialog a_renamed() {
            return this.e_renamed.f2541a;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.panel.c_renamed.a_renamed setTitle(java.lang.CharSequence charSequence) {
            this.g_renamed = charSequence;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.panel.c_renamed.a_renamed setTitle(int i_renamed) {
            this.g_renamed = this.h_renamed.getString(i_renamed);
            return this;
        }

        public com.coui.appcompat.dialog.panel.c_renamed.a_renamed a_renamed(java.lang.CharSequence[] charSequenceArr) {
            this.j_renamed = charSequenceArr;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.panel.c_renamed.a_renamed setMultiChoiceItems(int i_renamed, boolean[] zArr, android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.i_renamed = this.h_renamed.getResources().getTextArray(i_renamed);
            this.f2542a = zArr;
            this.q_renamed = true;
            this.f2544c = onMultiChoiceClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.panel.c_renamed.a_renamed setMultiChoiceItems(java.lang.CharSequence[] charSequenceArr, boolean[] zArr, android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.i_renamed = charSequenceArr;
            this.f2542a = zArr;
            this.q_renamed = true;
            this.f2544c = onMultiChoiceClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.panel.c_renamed.a_renamed setSingleChoiceItems(int i_renamed, int i2, android.content.DialogInterface.OnClickListener onClickListener) {
            this.i_renamed = this.h_renamed.getResources().getTextArray(i_renamed);
            this.d_renamed = onClickListener;
            this.f2543b = i2;
            this.q_renamed = false;
            return this;
        }

        @Override // androidx.appcompat.app.b_renamed.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.dialog.panel.c_renamed.a_renamed setSingleChoiceItems(java.lang.CharSequence[] charSequenceArr, int i_renamed, android.content.DialogInterface.OnClickListener onClickListener) {
            this.i_renamed = charSequenceArr;
            this.d_renamed = onClickListener;
            this.f2543b = i_renamed;
            this.q_renamed = false;
            return this;
        }

        public com.coui.appcompat.dialog.panel.c_renamed.a_renamed a_renamed(java.lang.String str, android.view.View.OnClickListener onClickListener) {
            this.k_renamed = str;
            this.l_renamed = onClickListener;
            return this;
        }

        public com.coui.appcompat.dialog.panel.c_renamed.a_renamed b_renamed(java.lang.String str, android.view.View.OnClickListener onClickListener) {
            this.o_renamed = str;
            this.p_renamed = onClickListener;
            return this;
        }

        public com.coui.appcompat.dialog.panel.c_renamed b_renamed() throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
            com.coui.appcompat.dialog.panel.a_renamed aVar;
            this.e_renamed.f2541a = new com.coui.appcompat.dialog.panel.b_renamed(this.h_renamed, coui.support.appcompat.R_renamed.style.DefaultBottomSheetDialog);
            this.e_renamed.f2541a.setContentView(this.f_renamed);
            this.e_renamed.f2541a.a_renamed(this.r_renamed);
            this.e_renamed.f2541a.a_renamed(this.s_renamed);
            androidx.recyclerview.widget.COUIRecyclerView cOUIRecyclerView = (androidx.recyclerview.widget.COUIRecyclerView) this.e_renamed.f2541a.findViewById(coui.support.appcompat.R_renamed.id_renamed.select_dialog_listview);
            androidx.recyclerview.widget.COUIPanelPreferenceLinearLayoutManager cOUIPanelPreferenceLinearLayoutManager = new androidx.recyclerview.widget.COUIPanelPreferenceLinearLayoutManager(this.h_renamed);
            cOUIPanelPreferenceLinearLayoutManager.setOrientation(1);
            cOUIRecyclerView.setLayoutManager(cOUIPanelPreferenceLinearLayoutManager);
            cOUIRecyclerView.setItemAnimator(null);
            com.coui.appcompat.widget.toolbar.COUIToolbar cOUIToolbar = (com.coui.appcompat.widget.toolbar.COUIToolbar) this.e_renamed.f2541a.findViewById(coui.support.appcompat.R_renamed.id_renamed.toolbar);
            cOUIToolbar.setTitle(this.g_renamed);
            cOUIToolbar.setIsTitleCenterStyle(true);
            if (this.q_renamed) {
                this.e_renamed.f2541a.a_renamed(true, this.k_renamed, this.l_renamed, this.m_renamed, this.n_renamed, this.o_renamed, this.p_renamed);
                ((android.widget.LinearLayout.LayoutParams) cOUIRecyclerView.getLayoutParams()).bottomMargin = 0;
                aVar = new com.coui.appcompat.dialog.panel.a_renamed(this.h_renamed, coui.support.appcompat.R_renamed.layout.coui_select_dialog_multichoice, this.i_renamed, this.j_renamed, -1, this.f2542a, true);
            } else {
                aVar = new com.coui.appcompat.dialog.panel.a_renamed(this.h_renamed, coui.support.appcompat.R_renamed.layout.coui_select_dialog_singlechoice, this.i_renamed, this.j_renamed, this.f2543b);
            }
            this.e_renamed.f2541a.c_renamed().getDragView().setVisibility(4);
            cOUIRecyclerView.setAdapter(aVar);
            aVar.a_renamed(new com.coui.appcompat.dialog.panel.a_renamed.COUIBottomSheetChoiceListAdapter_2() { // from class: com.coui.appcompat.dialog.panel.c_renamed.a_renamed.1
                @Override // com.coui.appcompat.dialog.panel.a_renamed.COUIBottomSheetChoiceListAdapter_2
                public void a_renamed(android.view.View view, int i_renamed, int i2) {
                    if (com.coui.appcompat.dialog.panel.c_renamed.a_renamed.this.q_renamed) {
                        if (com.coui.appcompat.dialog.panel.c_renamed.a_renamed.this.f2544c != null) {
                            com.coui.appcompat.dialog.panel.c_renamed.a_renamed.this.f2544c.onClick(com.coui.appcompat.dialog.panel.c_renamed.a_renamed.this.e_renamed.f2541a, i_renamed, i2 == 2);
                        }
                    } else if (com.coui.appcompat.dialog.panel.c_renamed.a_renamed.this.d_renamed != null) {
                        com.coui.appcompat.dialog.panel.c_renamed.a_renamed.this.d_renamed.onClick(com.coui.appcompat.dialog.panel.c_renamed.a_renamed.this.e_renamed.f2541a, i_renamed);
                    }
                }
            });
            return this.e_renamed;
        }
    }

    public void a_renamed() {
        com.coui.appcompat.dialog.panel.b_renamed bVar = this.f2541a;
        if (bVar != null) {
            bVar.dismiss();
        }
    }
}

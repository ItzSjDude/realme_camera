package com.coui.appcompat.dialog.panel;

/* compiled from: COUIBottomSheetChoiceListAdapter.java */
/* loaded from: classes.dex */
class a_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<com.coui.appcompat.dialog.panel.a_renamed.b_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f2505a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.CharSequence[] f2506b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.CharSequence[] f2507c;
    private int d_renamed;
    private boolean e_renamed;
    private java.util.HashSet<java.lang.Integer> f_renamed;
    private com.coui.appcompat.dialog.panel.a_renamed.COUIBottomSheetChoiceListAdapter_2 g_renamed;
    private int h_renamed;

    /* compiled from: COUIBottomSheetChoiceListAdapter.java */
    /* renamed from: com.coui.appcompat.dialog.panel.a_renamed$a_renamed, reason: collision with other inner class name */
    public interface COUIBottomSheetChoiceListAdapter_2 {
        void a_renamed(android.view.View view, int i_renamed, int i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public long getItemId(int i_renamed) {
        return i_renamed;
    }

    public a_renamed(android.content.Context context, int i_renamed, java.lang.CharSequence[] charSequenceArr, java.lang.CharSequence[] charSequenceArr2, int i2, boolean[] zArr, boolean z_renamed) {
        this.h_renamed = -1;
        this.f2505a = context;
        this.d_renamed = i_renamed;
        this.f2506b = charSequenceArr;
        this.f2507c = charSequenceArr2;
        this.e_renamed = z_renamed;
        this.f_renamed = new java.util.HashSet<>();
        this.h_renamed = i2;
        if (zArr != null) {
            a_renamed(zArr);
        }
    }

    public a_renamed(android.content.Context context, int i_renamed, java.lang.CharSequence[] charSequenceArr, java.lang.CharSequence[] charSequenceArr2, int i2) {
        this(context, i_renamed, charSequenceArr, charSequenceArr2, i2, null, false);
    }

    public java.lang.CharSequence a_renamed(int i_renamed) {
        java.lang.CharSequence[] charSequenceArr = this.f2507c;
        if (charSequenceArr == null || i_renamed >= charSequenceArr.length) {
            return null;
        }
        return charSequenceArr[i_renamed];
    }

    public java.lang.CharSequence b_renamed(int i_renamed) {
        java.lang.CharSequence[] charSequenceArr = this.f2506b;
        if (charSequenceArr == null || i_renamed >= charSequenceArr.length) {
            return null;
        }
        return charSequenceArr[i_renamed];
    }

    public void a_renamed(com.coui.appcompat.dialog.panel.a_renamed.COUIBottomSheetChoiceListAdapter_2 interfaceC0056a) {
        this.g_renamed = interfaceC0056a;
    }

    private void a_renamed(boolean[] zArr) {
        for (int i_renamed = 0; i_renamed < zArr.length; i_renamed++) {
            if (zArr[i_renamed]) {
                this.f_renamed.add(java.lang.Integer.valueOf(i_renamed));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemCount() {
        java.lang.CharSequence[] charSequenceArr = this.f2506b;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.coui.appcompat.dialog.panel.a_renamed.b_renamed onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        return new com.coui.appcompat.dialog.panel.a_renamed.b_renamed(android.view.LayoutInflater.from(this.f2505a).inflate(this.d_renamed, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final com.coui.appcompat.dialog.panel.a_renamed.b_renamed bVar, final int i_renamed) {
        if (this.e_renamed) {
            bVar.f2513c.setState(this.f_renamed.contains(java.lang.Integer.valueOf(i_renamed)) ? 2 : 0);
        } else {
            bVar.d_renamed.setChecked(this.h_renamed == i_renamed);
        }
        java.lang.CharSequence charSequenceB = b_renamed(i_renamed);
        java.lang.CharSequence charSequenceA = a_renamed(i_renamed);
        bVar.f2512b.setText(charSequenceB);
        if (android.text.TextUtils.isEmpty(charSequenceA)) {
            bVar.f2511a.setVisibility(8);
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) bVar.f2512b.getLayoutParams();
            layoutParams.addRule(15);
            bVar.f2512b.setLayoutParams(layoutParams);
        } else {
            bVar.f2511a.setVisibility(0);
            bVar.f2511a.setText(charSequenceA);
        }
        if (this.g_renamed != null) {
            bVar.e_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.coui.appcompat.dialog.panel.a_renamed.1
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    int i2;
                    if (!com.coui.appcompat.dialog.panel.a_renamed.this.e_renamed) {
                        if (i_renamed == com.coui.appcompat.dialog.panel.a_renamed.this.h_renamed) {
                            com.coui.appcompat.dialog.panel.a_renamed.this.g_renamed.a_renamed(view, i_renamed, 0);
                            return;
                        }
                        boolean zIsChecked = bVar.d_renamed.isChecked();
                        i2 = !zIsChecked ? 1 : 0;
                        bVar.d_renamed.setChecked(!zIsChecked);
                        com.coui.appcompat.dialog.panel.a_renamed aVar = com.coui.appcompat.dialog.panel.a_renamed.this;
                        aVar.notifyItemChanged(aVar.h_renamed);
                        com.coui.appcompat.dialog.panel.a_renamed.this.h_renamed = i_renamed;
                    } else {
                        if (bVar.f2513c.getState() != 2) {
                            com.coui.appcompat.dialog.panel.a_renamed.this.f_renamed.add(java.lang.Integer.valueOf(i_renamed));
                        } else {
                            com.coui.appcompat.dialog.panel.a_renamed.this.f_renamed.remove(java.lang.Integer.valueOf(i_renamed));
                        }
                        i2 = com.coui.appcompat.dialog.panel.a_renamed.this.f_renamed.contains(java.lang.Integer.valueOf(i_renamed)) ? 2 : 0;
                        bVar.f2513c.setState(i2);
                    }
                    com.coui.appcompat.dialog.panel.a_renamed.this.g_renamed.a_renamed(view, i_renamed, i2);
                }
            });
        }
    }

    /* compiled from: COUIBottomSheetChoiceListAdapter.java */
    class b_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        android.widget.TextView f2511a;

        /* renamed from: b_renamed, reason: collision with root package name */
        android.widget.TextView f2512b;

        /* renamed from: c_renamed, reason: collision with root package name */
        com.coui.appcompat.widget.COUICheckBox f2513c;
        android.widget.RadioButton d_renamed;
        android.view.View e_renamed;

        public b_renamed(android.view.View view) {
            super(view);
            this.f2512b = (android.widget.TextView) view.findViewById(android.R_renamed.id_renamed.text1);
            this.f2511a = (android.widget.TextView) view.findViewById(coui.support.appcompat.R_renamed.id_renamed.summary_text2);
            if (com.coui.appcompat.dialog.panel.a_renamed.this.e_renamed) {
                this.f2513c = (com.coui.appcompat.widget.COUICheckBox) view.findViewById(coui.support.appcompat.R_renamed.id_renamed.checkbox);
            } else {
                this.d_renamed = (android.widget.RadioButton) view.findViewById(coui.support.appcompat.R_renamed.id_renamed.radio_button);
            }
            view.setBackground(com.coui.appcompat.dialog.panel.a_renamed.this.f2505a.getDrawable(coui.support.appcompat.R_renamed.drawable.coui_list_selector_background));
            this.e_renamed = view;
        }
    }
}

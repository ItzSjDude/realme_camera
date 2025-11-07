package com.coui.appcompat.widget;

/* compiled from: ChoiceListAdapter.java */
/* loaded from: classes.dex */
public class v_renamed extends android.widget.BaseAdapter {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f3120a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.CharSequence[] f3121b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.CharSequence[] f3122c;
    private int d_renamed;
    private boolean e_renamed;
    private java.util.HashSet<java.lang.Integer> f_renamed;

    @Override // android.widget.Adapter
    public long getItemId(int i_renamed) {
        return i_renamed;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i_renamed) {
        return i_renamed;
    }

    public v_renamed(android.content.Context context, int i_renamed, java.lang.CharSequence[] charSequenceArr, java.lang.CharSequence[] charSequenceArr2, boolean[] zArr, boolean z_renamed) {
        this.e_renamed = false;
        this.f3120a = context;
        this.d_renamed = i_renamed;
        this.f3121b = charSequenceArr;
        this.f3122c = charSequenceArr2;
        this.e_renamed = z_renamed;
        this.f_renamed = new java.util.HashSet<>();
        if (zArr != null) {
            a_renamed(zArr);
        }
    }

    public v_renamed(android.content.Context context, int i_renamed, java.lang.CharSequence[] charSequenceArr, java.lang.CharSequence[] charSequenceArr2) {
        this(context, i_renamed, charSequenceArr, charSequenceArr2, null, false);
    }

    public java.lang.CharSequence a_renamed(int i_renamed) {
        java.lang.CharSequence[] charSequenceArr = this.f3122c;
        if (charSequenceArr != null && i_renamed < charSequenceArr.length) {
            return charSequenceArr[i_renamed];
        }
        return null;
    }

    private void a_renamed(boolean[] zArr) {
        for (int i_renamed = 0; i_renamed < zArr.length; i_renamed++) {
            if (zArr[i_renamed]) {
                this.f_renamed.add(java.lang.Integer.valueOf(i_renamed));
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        java.lang.CharSequence[] charSequenceArr = this.f3121b;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // android.widget.Adapter
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.CharSequence getItem(int i_renamed) {
        java.lang.CharSequence[] charSequenceArr = this.f3121b;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[i_renamed];
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
        android.view.View viewInflate;
        com.coui.appcompat.widget.v_renamed.a_renamed aVar;
        if (view == null) {
            aVar = new com.coui.appcompat.widget.v_renamed.a_renamed();
            viewInflate = android.view.LayoutInflater.from(this.f3120a).inflate(this.d_renamed, viewGroup, false);
            aVar.f3124b = (android.widget.TextView) viewInflate.findViewById(android.R_renamed.id_renamed.text1);
            aVar.f3123a = (android.widget.TextView) viewInflate.findViewById(coui.support.appcompat.R_renamed.id_renamed.summary_text2);
            if (this.e_renamed) {
                aVar.f3125c = (com.coui.appcompat.widget.COUICheckBox) viewInflate.findViewById(coui.support.appcompat.R_renamed.id_renamed.checkbox);
            } else {
                aVar.d_renamed = (android.widget.RadioButton) viewInflate.findViewById(coui.support.appcompat.R_renamed.id_renamed.radio_button);
            }
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (com.coui.appcompat.widget.v_renamed.a_renamed) view.getTag();
        }
        if (this.e_renamed) {
            aVar.f3125c.setState(this.f_renamed.contains(java.lang.Integer.valueOf(i_renamed)) ? 2 : 0);
        }
        java.lang.CharSequence item = getItem(i_renamed);
        java.lang.CharSequence charSequenceA = a_renamed(i_renamed);
        aVar.f3124b.setText(item);
        if (android.text.TextUtils.isEmpty(charSequenceA)) {
            aVar.f3123a.setVisibility(8);
        } else {
            aVar.f3123a.setVisibility(0);
            aVar.f3123a.setText(charSequenceA);
        }
        return viewInflate;
    }

    public void a_renamed(int i_renamed, int i2, android.widget.ListView listView) {
        int firstVisiblePosition = i2 - listView.getFirstVisiblePosition();
        if (firstVisiblePosition >= 0) {
            ((com.coui.appcompat.widget.v_renamed.a_renamed) listView.getChildAt(firstVisiblePosition).getTag()).f3125c.setState(i_renamed);
            if (i_renamed == 2) {
                this.f_renamed.add(java.lang.Integer.valueOf(i2));
            } else {
                this.f_renamed.remove(java.lang.Integer.valueOf(i2));
            }
        }
    }

    /* compiled from: ChoiceListAdapter.java */
    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        android.widget.TextView f3123a;

        /* renamed from: b_renamed, reason: collision with root package name */
        android.widget.TextView f3124b;

        /* renamed from: c_renamed, reason: collision with root package name */
        com.coui.appcompat.widget.COUICheckBox f3125c;
        android.widget.RadioButton d_renamed;

        a_renamed() {
        }
    }
}

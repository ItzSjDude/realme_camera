package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: VideoSoundSettingSummaryAdapter.java */
/* loaded from: classes2.dex */
public class s_renamed extends android.widget.BaseAdapter {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f6548a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f6549b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.Context f6550c;
    private int d_renamed;
    private boolean e_renamed;
    private java.lang.CharSequence[] f_renamed;
    private java.lang.CharSequence[] g_renamed;

    @Override // android.widget.Adapter
    public long getItemId(int i_renamed) {
        return i_renamed;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public s_renamed(android.content.Context context, boolean z_renamed, boolean z2, int i_renamed, boolean z3, java.lang.CharSequence[] charSequenceArr, java.lang.CharSequence[] charSequenceArr2) {
        this.f6548a = z_renamed;
        this.f6549b = z2;
        this.f6550c = context;
        this.d_renamed = i_renamed;
        this.e_renamed = z3;
        this.f_renamed = charSequenceArr;
        this.g_renamed = charSequenceArr2;
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
        android.view.View viewInflate;
        com.oplus.camera.ui.menu.levelcontrol.s_renamed.a_renamed aVar;
        if (view == null) {
            aVar = new com.oplus.camera.ui.menu.levelcontrol.s_renamed.a_renamed();
            viewInflate = android.view.LayoutInflater.from(this.f6550c).inflate(com.oplus.camera.R_renamed.layout.oplus_preference_select_layout, viewGroup, false);
            aVar.f6551a = (android.widget.TextView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.pref_title);
            aVar.f6552b = (android.widget.TextView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.pref_summary);
            aVar.f6553c = (android.widget.CheckBox) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.pref_checkbox);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (com.oplus.camera.ui.menu.levelcontrol.s_renamed.a_renamed) view.getTag();
        }
        java.lang.CharSequence item = getItem(i_renamed);
        java.lang.CharSequence charSequenceC = c_renamed(i_renamed);
        aVar.f6551a.setText(item);
        if (android.text.TextUtils.isEmpty(charSequenceC)) {
            aVar.f6552b.setVisibility(8);
        } else {
            aVar.f6552b.setVisibility(0);
            aVar.f6552b.setText(charSequenceC);
        }
        aVar.f6553c.setChecked(this.d_renamed == i_renamed);
        if (isEnabled(i_renamed)) {
            aVar.f6551a.setTextColor(this.f6550c.getResources().getColor(com.oplus.camera.R_renamed.color.setting_pref_title_color));
            aVar.f6552b.setTextColor(this.f6550c.getResources().getColor(com.oplus.camera.R_renamed.color.setting_pref_summary_color));
        } else {
            aVar.f6551a.setTextColor(this.f6550c.getResources().getColor(com.oplus.camera.R_renamed.color.setting_pref_text_disable_color));
            aVar.f6552b.setTextColor(this.f6550c.getResources().getColor(com.oplus.camera.R_renamed.color.setting_pref_text_disable_color));
        }
        return viewInflate;
    }

    public void a_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i_renamed) {
        return (this.e_renamed && 2 == i_renamed) ? false : true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        java.lang.CharSequence[] charSequenceArr = this.f_renamed;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // android.widget.Adapter
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.CharSequence getItem(int i_renamed) {
        java.lang.CharSequence[] charSequenceArr = this.f_renamed;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[i_renamed];
    }

    private java.lang.CharSequence c_renamed(int i_renamed) {
        java.lang.CharSequence[] charSequenceArr = this.g_renamed;
        if (charSequenceArr != null && i_renamed < charSequenceArr.length) {
            return charSequenceArr[i_renamed];
        }
        return null;
    }

    /* compiled from: VideoSoundSettingSummaryAdapter.java */
    private final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        android.widget.TextView f6551a;

        /* renamed from: b_renamed, reason: collision with root package name */
        android.widget.TextView f6552b;

        /* renamed from: c_renamed, reason: collision with root package name */
        android.widget.CheckBox f6553c;

        private a_renamed() {
        }
    }
}

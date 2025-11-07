package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: CameraCustomListPreferenceSummaryAdapter.java */
/* loaded from: classes2.dex */
public class d_renamed extends android.widget.BaseAdapter {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f6511a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f6512b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.Context f6513c;
    private int d_renamed;
    private java.lang.CharSequence[] e_renamed;
    private java.lang.CharSequence[] f_renamed;

    @Override // android.widget.Adapter
    public long getItemId(int i_renamed) {
        return i_renamed;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public d_renamed(android.content.Context context, boolean z_renamed, boolean z2, int i_renamed, java.lang.CharSequence[] charSequenceArr, java.lang.CharSequence[] charSequenceArr2) {
        this.f6511a = z_renamed;
        this.f6512b = z2;
        this.f6513c = context;
        this.d_renamed = i_renamed;
        this.e_renamed = charSequenceArr;
        this.f_renamed = charSequenceArr2;
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) throws android.content.res.Resources.NotFoundException {
        android.view.View viewInflate;
        com.oplus.camera.ui.menu.levelcontrol.d_renamed.a_renamed aVar;
        if (view == null) {
            aVar = new com.oplus.camera.ui.menu.levelcontrol.d_renamed.a_renamed();
            viewInflate = android.view.LayoutInflater.from(this.f6513c).inflate(com.oplus.camera.R_renamed.layout.oplus_preference_select_layout, viewGroup, false);
            aVar.f6514a = (android.widget.TextView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.pref_title);
            aVar.f6515b = (android.widget.TextView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.pref_summary);
            aVar.f6516c = (android.widget.CheckBox) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.pref_checkbox);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (com.oplus.camera.ui.menu.levelcontrol.d_renamed.a_renamed) view.getTag();
        }
        java.lang.CharSequence item = getItem(i_renamed);
        java.lang.CharSequence charSequenceB = b_renamed(i_renamed);
        aVar.f6514a.setText(item);
        if (android.text.TextUtils.isEmpty(charSequenceB)) {
            aVar.f6515b.setVisibility(8);
        } else {
            aVar.f6515b.setVisibility(0);
            aVar.f6515b.setText(charSequenceB);
        }
        aVar.f6516c.setChecked(this.d_renamed == i_renamed);
        a_renamed(i_renamed, viewInflate);
        return viewInflate;
    }

    private void a_renamed(int i_renamed, android.view.View view) throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize = this.f6513c.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.alert_dialog_item_padding_offset);
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        if (getCount() > 1) {
            if (i_renamed == getCount() - 1) {
                view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
                view.setPadding(paddingLeft, 0, paddingRight, dimensionPixelSize + 0);
            }
            if (this.f6511a || this.f6512b || i_renamed != 0) {
                return;
            }
            view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
            view.setPadding(paddingLeft, dimensionPixelSize + 0, paddingRight, 0);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        java.lang.CharSequence[] charSequenceArr = this.e_renamed;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // android.widget.Adapter
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.CharSequence getItem(int i_renamed) {
        java.lang.CharSequence[] charSequenceArr = this.e_renamed;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[i_renamed];
    }

    private java.lang.CharSequence b_renamed(int i_renamed) {
        java.lang.CharSequence[] charSequenceArr = this.f_renamed;
        if (charSequenceArr != null && i_renamed < charSequenceArr.length) {
            return charSequenceArr[i_renamed];
        }
        return null;
    }

    /* compiled from: CameraCustomListPreferenceSummaryAdapter.java */
    private final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        android.widget.TextView f6514a;

        /* renamed from: b_renamed, reason: collision with root package name */
        android.widget.TextView f6515b;

        /* renamed from: c_renamed, reason: collision with root package name */
        android.widget.CheckBox f6516c;

        private a_renamed() {
        }
    }
}

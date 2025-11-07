package com.coui.appcompat.widget;

/* compiled from: SummaryAdapter.java */
/* loaded from: classes.dex */
public class z_renamed extends android.widget.BaseAdapter {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int f3141a = coui.support.appcompat.R_renamed.layout.coui_alert_dialog_summary_item;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f3142b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f3143c;
    private android.content.Context d_renamed;
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

    public z_renamed(android.content.Context context, boolean z_renamed, boolean z2, java.lang.CharSequence[] charSequenceArr, java.lang.CharSequence[] charSequenceArr2) {
        this.f3142b = z_renamed;
        this.f3143c = z2;
        this.d_renamed = context;
        this.e_renamed = charSequenceArr;
        this.f_renamed = charSequenceArr2;
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) throws android.content.res.Resources.NotFoundException {
        android.view.View viewInflate = android.view.LayoutInflater.from(this.d_renamed).inflate(f3141a, viewGroup, false);
        android.widget.TextView textView = (android.widget.TextView) viewInflate.findViewById(android.R_renamed.id_renamed.text1);
        android.widget.TextView textView2 = (android.widget.TextView) viewInflate.findViewById(coui.support.appcompat.R_renamed.id_renamed.summary_text2);
        java.lang.CharSequence item = getItem(i_renamed);
        java.lang.CharSequence charSequenceB = b_renamed(i_renamed);
        textView.setText(item);
        if (android.text.TextUtils.isEmpty(charSequenceB)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(charSequenceB);
        }
        a_renamed(i_renamed, viewInflate);
        return viewInflate;
    }

    private void a_renamed(int i_renamed, android.view.View view) throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize = this.d_renamed.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.alert_dialog_item_padding_offset);
        int paddingTop = view.getPaddingTop();
        int paddingLeft = view.getPaddingLeft();
        int paddingBottom = view.getPaddingBottom();
        int paddingRight = view.getPaddingRight();
        if (getCount() > 1) {
            if (i_renamed == getCount() - 1) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom + dimensionPixelSize);
                view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
                return;
            } else {
                if (this.f3142b || this.f3143c) {
                    return;
                }
                if (i_renamed == 0) {
                    view.setPadding(paddingLeft, paddingTop + dimensionPixelSize, paddingRight, paddingBottom);
                    view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
                    return;
                } else {
                    view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    return;
                }
            }
        }
        if (getCount() == 1) {
            if (!this.f3142b && !this.f3143c) {
                view.setPadding(paddingLeft, paddingTop + dimensionPixelSize, paddingRight, paddingBottom + dimensionPixelSize);
                view.setMinimumHeight(view.getMinimumHeight() + (dimensionPixelSize * 2));
            } else {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom + dimensionPixelSize);
                view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
            }
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

    public java.lang.CharSequence b_renamed(int i_renamed) {
        java.lang.CharSequence[] charSequenceArr = this.f_renamed;
        if (charSequenceArr != null && i_renamed < charSequenceArr.length) {
            return charSequenceArr[i_renamed];
        }
        return null;
    }
}

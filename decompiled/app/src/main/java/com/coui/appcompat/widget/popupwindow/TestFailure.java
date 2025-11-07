package com.coui.appcompat.widget.popupwindow;

/* compiled from: DefaultAdapter.java */
/* loaded from: classes.dex */
public class f_renamed extends android.widget.BaseAdapter {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f3066a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.List<com.coui.appcompat.widget.popupwindow.g_renamed> f3067b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f3068c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private android.content.res.ColorStateList j_renamed;
    private int k_renamed;
    private float l_renamed;
    private float m_renamed;
    private android.view.View.AccessibilityDelegate n_renamed;

    @Override // android.widget.Adapter
    public long getItemId(int i_renamed) {
        return i_renamed;
    }

    public f_renamed(android.content.Context context, java.util.List<com.coui.appcompat.widget.popupwindow.g_renamed> list) {
        this.f3066a = context;
        this.f3067b = list;
        android.content.res.Resources resources = context.getResources();
        this.f3068c = resources.getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_popup_list_padding_vertical);
        this.d_renamed = resources.getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_popup_list_window_item_padding_top_and_bottom);
        this.e_renamed = resources.getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_popup_list_window_item_min_height);
        this.f_renamed = resources.getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_popup_list_window_content_min_width_with_checkbox);
        this.g_renamed = this.f3066a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_popup_list_window_item_title_margin_with_no_icon);
        this.h_renamed = this.f3066a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_popup_list_window_item_title_margin_left);
        this.i_renamed = this.f3066a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_popup_list_window_item_title_margin_right);
        this.l_renamed = this.f3066a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_popup_list_window_item_title_text_size);
        this.m_renamed = this.f3066a.getResources().getConfiguration().fontScale;
        this.n_renamed = new android.view.View.AccessibilityDelegate() { // from class: com.coui.appcompat.widget.popupwindow.f_renamed.1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(android.view.View view, android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setClassName("");
            }
        };
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{coui.support.appcompat.R_renamed.attr.couiPopupListWindowTextColor, coui.support.appcompat.R_renamed.attr.couiTintControlNormal});
        this.j_renamed = typedArrayObtainStyledAttributes.getColorStateList(0);
        this.k_renamed = typedArrayObtainStyledAttributes.getColor(1, this.f3066a.getResources().getColor(coui.support.appcompat.R_renamed.color.couiGreenTintControlNormal));
        if (this.j_renamed == null) {
            this.j_renamed = this.f3066a.getResources().getColorStateList(coui.support.appcompat.R_renamed.color.coui_popup_list_window_text_color_light);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3067b.size();
    }

    @Override // android.widget.Adapter
    public java.lang.Object getItem(int i_renamed) {
        return this.f3067b.get(i_renamed);
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) throws android.content.res.Resources.NotFoundException {
        com.coui.appcompat.widget.popupwindow.f_renamed.a_renamed aVar;
        if (view == null) {
            com.coui.appcompat.widget.popupwindow.f_renamed.a_renamed aVar2 = new com.coui.appcompat.widget.popupwindow.f_renamed.a_renamed();
            android.view.View viewInflate = android.view.LayoutInflater.from(this.f3066a).inflate(coui.support.appcompat.R_renamed.layout.coui_popup_list_window_item, viewGroup, false);
            aVar2.f3070a = (android.widget.ImageView) viewInflate.findViewById(coui.support.appcompat.R_renamed.id_renamed.popup_list_window_item_icon);
            aVar2.f3071b = (android.widget.TextView) viewInflate.findViewById(coui.support.appcompat.R_renamed.id_renamed.popup_list_window_item_title);
            aVar2.e_renamed = (android.widget.LinearLayout) viewInflate.findViewById(coui.support.appcompat.R_renamed.id_renamed.content);
            aVar2.d_renamed = (com.coui.appcompat.widget.COUIHintRedDot) viewInflate.findViewById(coui.support.appcompat.R_renamed.id_renamed.red_dot);
            aVar2.f3072c = (android.widget.CheckBox) viewInflate.findViewById(coui.support.appcompat.R_renamed.id_renamed.checkbox);
            if (aVar2.f3072c != null) {
                aVar2.f3072c.setAccessibilityDelegate(this.n_renamed);
            }
            viewInflate.setTag(aVar2);
            aVar = aVar2;
            view = viewInflate;
        } else {
            aVar = (com.coui.appcompat.widget.popupwindow.f_renamed.a_renamed) view.getTag();
        }
        if (getCount() == 1) {
            view.setMinimumHeight(this.e_renamed + (this.f3068c * 2));
            int i2 = this.d_renamed;
            int i3 = this.f3068c;
            view.setPadding(0, i2 + i3, 0, i2 + i3);
        } else if (i_renamed == 0) {
            view.setMinimumHeight(this.e_renamed + this.f3068c);
            int i4 = this.d_renamed;
            view.setPadding(0, this.f3068c + i4, 0, i4);
        } else if (i_renamed == getCount() - 1) {
            view.setMinimumHeight(this.e_renamed + this.f3068c);
            int i5 = this.d_renamed;
            view.setPadding(0, i5, 0, this.f3068c + i5);
        } else {
            view.setMinimumHeight(this.e_renamed);
            int i6 = this.d_renamed;
            view.setPadding(0, i6, 0, i6);
        }
        boolean zD = this.f3067b.get(i_renamed).d_renamed();
        view.setEnabled(zD);
        a_renamed(this.f3067b.get(i_renamed), aVar.d_renamed);
        a_renamed(aVar.f3070a, aVar.f3071b, this.f3067b.get(i_renamed), zD);
        a_renamed(aVar.f3071b, this.f3067b.get(i_renamed), zD);
        a_renamed((android.widget.LinearLayout) view, aVar.f3072c, aVar.f3071b, this.f3067b.get(i_renamed), zD);
        return view;
    }

    private void a_renamed(android.widget.ImageView imageView, android.widget.TextView textView, com.coui.appcompat.widget.popupwindow.g_renamed gVar, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        android.graphics.drawable.Drawable drawableB;
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) textView.getLayoutParams();
        if (gVar.a_renamed() == 0 && gVar.b_renamed() == null) {
            imageView.setVisibility(8);
            layoutParams.setMarginStart(this.g_renamed);
            if (gVar.g_renamed() == -1 && !gVar.e_renamed()) {
                layoutParams.setMarginEnd(this.g_renamed);
            } else {
                layoutParams.setMarginEnd(0);
            }
        } else {
            imageView.setVisibility(0);
            layoutParams.setMarginStart(this.h_renamed);
            if (gVar.g_renamed() == -1 && !gVar.e_renamed()) {
                layoutParams.setMarginEnd(this.i_renamed);
            } else {
                layoutParams.setMarginEnd(0);
            }
            if (gVar.b_renamed() == null) {
                drawableB = this.f3066a.getResources().getDrawable(gVar.a_renamed());
            } else {
                drawableB = gVar.b_renamed();
            }
            imageView.setImageDrawable(drawableB);
        }
        textView.setLayoutParams(layoutParams);
    }

    private void a_renamed(android.widget.TextView textView, com.coui.appcompat.widget.popupwindow.g_renamed gVar, boolean z_renamed) {
        textView.setEnabled(z_renamed);
        textView.setText(gVar.c_renamed());
        textView.setTextColor(this.j_renamed);
        textView.setTextSize(0, com.coui.appcompat.a_renamed.a_renamed.a_renamed(this.l_renamed, this.m_renamed, 5));
    }

    private void a_renamed(android.widget.LinearLayout linearLayout, android.widget.CheckBox checkBox, android.widget.TextView textView, com.coui.appcompat.widget.popupwindow.g_renamed gVar, boolean z_renamed) {
        if (gVar.e_renamed()) {
            int minimumWidth = linearLayout.getMinimumWidth();
            int i_renamed = this.f_renamed;
            if (minimumWidth != i_renamed) {
                linearLayout.setMinimumWidth(i_renamed);
            }
            checkBox.setVisibility(0);
            checkBox.setChecked(gVar.f_renamed());
            checkBox.setEnabled(z_renamed);
            if (gVar.f_renamed()) {
                textView.setTextColor(this.k_renamed);
                return;
            }
            return;
        }
        if (linearLayout.getMinimumWidth() == this.f_renamed) {
            linearLayout.setMinimumWidth(0);
        }
        checkBox.setVisibility(8);
    }

    private void a_renamed(com.coui.appcompat.widget.popupwindow.g_renamed gVar, com.coui.appcompat.widget.COUIHintRedDot cOUIHintRedDot) {
        cOUIHintRedDot.setPointNumber(gVar.g_renamed());
        int iG = gVar.g_renamed();
        if (iG == -1) {
            cOUIHintRedDot.setPointMode(0);
        } else if (iG == 0) {
            cOUIHintRedDot.setPointMode(1);
            cOUIHintRedDot.setVisibility(0);
        } else {
            cOUIHintRedDot.setPointMode(2);
            cOUIHintRedDot.setVisibility(0);
        }
    }

    /* compiled from: DefaultAdapter.java */
    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        android.widget.ImageView f3070a;

        /* renamed from: b_renamed, reason: collision with root package name */
        android.widget.TextView f3071b;

        /* renamed from: c_renamed, reason: collision with root package name */
        android.widget.CheckBox f3072c;
        com.coui.appcompat.widget.COUIHintRedDot d_renamed;
        android.widget.LinearLayout e_renamed;

        a_renamed() {
        }
    }
}

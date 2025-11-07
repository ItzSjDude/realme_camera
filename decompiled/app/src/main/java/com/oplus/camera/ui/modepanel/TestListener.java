package com.oplus.camera.ui.modepanel;

/* compiled from: ModeAdapter.java */
/* loaded from: classes2.dex */
public class g_renamed extends com.oplus.camera.ui.modepanel.a_renamed<com.oplus.camera.ui.modepanel.g_renamed.a_renamed> {

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6728b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6729c;
    private int d_renamed;

    public g_renamed(android.app.Activity activity) {
        super(activity);
        this.f6728b = 0;
        this.f6729c = com.oplus.camera.R_renamed.layout.item_headline;
        this.d_renamed = 0;
        this.d_renamed = activity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_headline_text_max_width);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.camera.ui.modepanel.g_renamed.a_renamed onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        return new com.oplus.camera.ui.modepanel.g_renamed.a_renamed(android.view.LayoutInflater.from(this.f6709a).inflate(this.f6729c, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, int i_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.modepanel.g_renamed.a_renamed aVar = (com.oplus.camera.ui.modepanel.g_renamed.a_renamed) wVar;
        if (aVar == null || aVar.f6731b == null) {
            return;
        }
        com.oplus.camera.ui.modepanel.k_renamed kVar = b_renamed().get(i_renamed);
        a_renamed(aVar, kVar.a_renamed());
        aVar.f6731b.setTextColor(kVar.g_renamed() ? this.f6709a.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency) : this.f6709a.getColor(com.oplus.camera.R_renamed.color.color_white_with_10_percent_transparency));
        aVar.f6731b.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        aVar.itemView.setVisibility(kVar.e_renamed());
        a_renamed(aVar);
        b_renamed(aVar);
        aVar.itemView.setTag(com.oplus.camera.R_renamed.id_renamed.tag_recycle_view_mode_info, kVar);
    }

    /* compiled from: ModeAdapter.java */
    protected class a_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.widget.TextView f6731b;

        public a_renamed(android.view.View view) {
            super(view);
            this.f6731b = (android.widget.TextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.item_mode);
        }
    }

    public void c_renamed(int i_renamed) {
        this.f6728b = i_renamed;
        if (i_renamed == 1) {
            this.f6729c = com.oplus.camera.R_renamed.layout.item_headline_vertical;
        } else {
            this.f6729c = com.oplus.camera.R_renamed.layout.item_headline;
        }
    }

    private void b_renamed(com.oplus.camera.ui.modepanel.g_renamed.a_renamed aVar) {
        if (this.f6728b == 1) {
            android.graphics.drawable.GradientDrawable gradientDrawable = (android.graphics.drawable.GradientDrawable) aVar.f6731b.getBackground();
            gradientDrawable.setColor(this.f6709a.getColor(com.oplus.camera.R_renamed.color.color_white_with_10_percent_transparency));
            aVar.f6731b.setBackground(gradientDrawable);
        } else {
            android.graphics.drawable.GradientDrawable gradientDrawable2 = (android.graphics.drawable.GradientDrawable) aVar.itemView.getBackground();
            gradientDrawable2.setColor(this.f6709a.getColor(com.oplus.camera.R_renamed.color.color_white_with_10_percent_transparency));
            aVar.itemView.setBackground(gradientDrawable2);
        }
    }

    public void a_renamed(com.oplus.camera.ui.modepanel.g_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) aVar.itemView.getLayoutParams();
        android.content.res.Resources resources = this.f6709a.getResources();
        int i_renamed = this.f6728b;
        if (i_renamed != 1) {
            if (i_renamed == 3 || i_renamed == 4) {
                int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_headline_recycle_view_item_padding_left_right);
                marginLayoutParams.setMarginStart(dimensionPixelOffset);
                marginLayoutParams.setMarginEnd(dimensionPixelOffset);
                aVar.itemView.setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        marginLayoutParams.topMargin = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_item_gap);
        aVar.itemView.setLayoutParams(marginLayoutParams);
        java.lang.String strSubstring = (java.lang.String) aVar.f6731b.getText();
        if (strSubstring.contains("\n_renamed")) {
            java.lang.String strSubstring2 = strSubstring.substring(0, strSubstring.indexOf("\n_renamed"));
            strSubstring = strSubstring.substring(strSubstring.indexOf("\n_renamed") + 1);
            if (strSubstring2.length() > strSubstring.length()) {
                strSubstring = strSubstring2;
            }
            aVar.f6731b.setBackground(this.f6709a.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.vertical_mode_edit_bg_double_line_drawable));
        }
        int dimensionPixelOffset2 = (resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_width) - ((int) aVar.f6731b.getPaint().measureText(strSubstring))) / 2;
        if (dimensionPixelOffset2 < resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.headline_recycle_view_vertical_text_padding_left_right)) {
            aVar.f6731b.setPaddingRelative(dimensionPixelOffset2, aVar.f6731b.getPaddingTop(), dimensionPixelOffset2, aVar.f6731b.getPaddingBottom());
        }
    }

    private void a_renamed(com.oplus.camera.ui.modepanel.g_renamed.a_renamed aVar, java.lang.String str) {
        if (this.f6728b != 1) {
            aVar.f6731b.setText(str);
            return;
        }
        android.text.TextPaint paint = aVar.f6731b.getPaint();
        if (paint == null) {
            aVar.f6731b.setText(str);
            return;
        }
        if (paint.measureText(str) <= this.d_renamed) {
            aVar.f6731b.setText(str);
            return;
        }
        if (str.contains(" ") && paint.measureText(str.substring(0, str.indexOf(" "))) < this.d_renamed) {
            aVar.f6731b.setText(str.replaceFirst("\\s_renamed", "\n_renamed"));
            return;
        }
        int i_renamed = 1;
        while (i_renamed < str.length() && paint.measureText(str.substring(0, i_renamed)) < this.d_renamed) {
            i_renamed++;
        }
        int i2 = i_renamed - 1;
        java.lang.String strSubstring = str.substring(0, i2);
        if (paint.measureText(str.substring(i2)) <= this.d_renamed) {
            aVar.f6731b.setText(new java.lang.StringBuffer(str).insert(i2, "\n_renamed").toString());
            return;
        }
        int i3 = i2 + 1;
        while (i3 < str.length()) {
            if (paint.measureText(str.substring(i2, i3) + "...") >= this.d_renamed) {
                break;
            } else {
                i3++;
            }
        }
        aVar.f6731b.setText(strSubstring + str.substring(i2, i3 - 1) + "...");
    }
}

package com.oplus.camera.sticker.ui;

/* compiled from: StickerCategoryAdapter.java */
/* loaded from: classes2.dex */
public class e_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.ArrayList<com.oplus.camera.sticker.ui.h_renamed.b_renamed> f5521a = new java.util.ArrayList<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.HashMap<java.lang.Integer, androidx.recyclerview.widget.RecyclerView.w_renamed> f5522b = new java.util.HashMap<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f5523c = -1;
    private com.oplus.camera.sticker.ui.g_renamed d_renamed;
    private int e_renamed;
    private android.content.Context f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;

    public e_renamed(android.content.Context context, com.oplus.camera.sticker.ui.g_renamed gVar, int i_renamed) {
        this.d_renamed = null;
        this.f_renamed = null;
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.d_renamed = gVar;
        this.f_renamed = context;
        this.j_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_gridview_redpoint_radius);
        this.i_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_type_view_redpoint_margin_top);
        this.h_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_type_thumbnail_display_size);
        this.e_renamed = i_renamed;
        this.g_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_type_view_item_size);
    }

    public void a_renamed(java.util.ArrayList<com.oplus.camera.sticker.ui.h_renamed.b_renamed> arrayList) {
        this.f5521a.clear();
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f5521a.addAll(arrayList.subList(1, arrayList.size()));
    }

    public com.oplus.camera.sticker.ui.h_renamed.b_renamed a_renamed(int i_renamed) {
        return this.f5521a.get(i_renamed);
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("StickerCategoryAdapter", "setSelectIndex, index: " + i_renamed);
        androidx.recyclerview.widget.RecyclerView.w_renamed wVar = this.f5522b.get(java.lang.Integer.valueOf(this.f5523c));
        androidx.recyclerview.widget.RecyclerView.w_renamed wVar2 = this.f5522b.get(java.lang.Integer.valueOf(i_renamed));
        if (wVar != null) {
            ((com.oplus.camera.sticker.ui.e_renamed.a_renamed) wVar).f5524a.setImageDrawable(a_renamed(this.f5523c, false));
        }
        if (wVar2 != null && i_renamed >= 0) {
            ((com.oplus.camera.sticker.ui.e_renamed.a_renamed) wVar2).f5524a.setImageDrawable(a_renamed(i_renamed, true));
        }
        this.f5523c = i_renamed;
    }

    public void c_renamed(int i_renamed) {
        this.e_renamed = i_renamed;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public androidx.recyclerview.widget.RecyclerView.w_renamed onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        com.oplus.camera.ui.RotateImageView rotateImageView = new com.oplus.camera.ui.RotateImageView(this.f_renamed);
        int i2 = this.g_renamed;
        rotateImageView.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(i2, i2));
        com.oplus.camera.sticker.ui.e_renamed.a_renamed aVar = new com.oplus.camera.sticker.ui.e_renamed.a_renamed(rotateImageView, this.d_renamed);
        rotateImageView.a_renamed(this.e_renamed, true);
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, int i_renamed) {
        this.f5522b.put(java.lang.Integer.valueOf(i_renamed), wVar);
        com.oplus.camera.sticker.ui.e_renamed.a_renamed aVar = (com.oplus.camera.sticker.ui.e_renamed.a_renamed) wVar;
        com.oplus.camera.ui.RotateImageView rotateImageView = aVar.f5524a;
        if (i_renamed == this.f5523c) {
            rotateImageView.setImageDrawable(a_renamed(i_renamed, true));
        } else {
            rotateImageView.setImageDrawable(a_renamed(i_renamed, false));
        }
        rotateImageView.setOnClickListener(aVar);
        rotateImageView.a_renamed(this.e_renamed, true);
        rotateImageView.setTag(java.lang.Integer.valueOf(i_renamed));
        rotateImageView.setContentDescription(this.f_renamed.getResources().getString(com.oplus.camera.R_renamed.string.camera_description_sticker_category_item) + i_renamed);
    }

    private android.graphics.drawable.Drawable a_renamed(int i_renamed, boolean z_renamed) {
        if (i_renamed >= this.f5521a.size()) {
            return null;
        }
        android.graphics.drawable.Drawable drawable = this.f5521a.get(i_renamed).f5555b;
        if (z_renamed) {
            drawable = this.f5521a.get(i_renamed).f5554a;
        }
        android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{drawable});
        int i2 = this.h_renamed;
        layerDrawable.setLayerSize(0, i2, i2);
        return this.f5521a.get(i_renamed).d_renamed ? a_renamed(layerDrawable) : layerDrawable;
    }

    private android.graphics.drawable.LayerDrawable a_renamed(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable[] drawableArr = {drawable, this.f_renamed.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.sticker_red_point)};
        android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(drawableArr);
        int intrinsicWidth = drawableArr[0].getIntrinsicWidth();
        int intrinsicWidth2 = drawableArr[1].getIntrinsicWidth();
        int i_renamed = this.g_renamed;
        int i2 = (i_renamed - intrinsicWidth) / 2;
        int i3 = i2 + 0;
        int i4 = i_renamed - (intrinsicWidth + i2);
        int i5 = this.j_renamed;
        int i6 = i_renamed - ((intrinsicWidth2 / 2) + i5);
        int i7 = i5 - this.i_renamed;
        int i8 = i6 + intrinsicWidth2;
        int i9 = i6 - 0;
        int i10 = i7 + 0;
        int i11 = i_renamed - i8;
        int i12 = i_renamed - (intrinsicWidth2 + i7);
        if (i3 < 0 || i3 < 0 || i4 > 0 || i4 > 0) {
            com.oplus.camera.e_renamed.f_renamed("StickerCategoryAdapter", "downloadSuccess, drawable0 out of_renamed thumbnail display!");
        }
        layerDrawable.setLayerInset(0, i3, i3, i4, i4);
        layerDrawable.setLayerInset(1, i9, i10, i11, i12);
        return layerDrawable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemCount() {
        return this.f5521a.size();
    }

    /* compiled from: StickerCategoryAdapter.java */
    public class a_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed implements android.view.View.OnClickListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        public com.oplus.camera.ui.RotateImageView f5524a;

        /* renamed from: c_renamed, reason: collision with root package name */
        private com.oplus.camera.sticker.ui.g_renamed f5526c;

        public a_renamed(android.view.View view, com.oplus.camera.sticker.ui.g_renamed gVar) {
            super(view);
            this.f5524a = (com.oplus.camera.ui.RotateImageView) view;
            this.f5524a.setOnClickListener(this);
            this.f5526c = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            int iIntValue = ((java.lang.Integer) view.getTag()).intValue();
            com.oplus.camera.e_renamed.b_renamed("StickerCategoryAdapter", "onClick, clickIndex: " + iIntValue + ", mSelectedIndexInAdapter: " + com.oplus.camera.sticker.ui.e_renamed.this.f5523c);
            if (com.oplus.camera.sticker.ui.e_renamed.this.f5523c == iIntValue) {
                return;
            }
            com.oplus.camera.sticker.ui.e_renamed.this.b_renamed(iIntValue);
            this.f5526c.a_renamed(com.oplus.camera.sticker.ui.e_renamed.this.f5523c + 1, com.oplus.camera.sticker.ui.e_renamed.this.f5523c, ((com.oplus.camera.sticker.ui.h_renamed.b_renamed) com.oplus.camera.sticker.ui.e_renamed.this.f5521a.get(com.oplus.camera.sticker.ui.e_renamed.this.f5523c)).f5556c, false);
        }
    }
}

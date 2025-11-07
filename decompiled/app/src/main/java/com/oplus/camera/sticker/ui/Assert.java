package com.oplus.camera.sticker.ui;

/* compiled from: GridAdapter.java */
/* loaded from: classes2.dex */
public class a_renamed extends android.widget.BaseAdapter {

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f5501b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.ui.c_renamed f5502c;
    private java.util.List<java.util.Map<java.lang.String, java.lang.Object>> d_renamed;
    private android.view.LayoutInflater e_renamed;
    private android.content.Context f_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.ui.i_renamed f5500a = null;
    private java.lang.String g_renamed = null;
    private android.graphics.drawable.Drawable h_renamed = null;
    private boolean m_renamed = false;
    private boolean n_renamed = false;

    @Override // android.widget.Adapter
    public long getItemId(int i_renamed) {
        return i_renamed;
    }

    public a_renamed(android.content.Context context, com.oplus.camera.sticker.ui.c_renamed cVar, int i_renamed) {
        this.f5501b = 0;
        this.f5502c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.f5502c = cVar;
        this.d_renamed = new java.util.ArrayList();
        this.f_renamed = context;
        this.e_renamed = android.view.LayoutInflater.from(context);
        this.f5501b = i_renamed;
        this.k_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_gridview_image_width);
        this.j_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_gridview_highlight_width);
        this.i_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_gridview_item_size);
        this.l_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_gridview_image_padding);
    }

    public void a_renamed(java.lang.String str) {
        this.g_renamed = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (com.oplus.camera.sticker.data.StickerCategoryItem.isMyCategory(this.g_renamed)) {
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list = this.d_renamed;
            if (list == null) {
                return 0;
            }
            int size = list.size();
            if (size > 1) {
                return size;
            }
            com.oplus.camera.e_renamed.b_renamed("GridAdapter", "getCount, myCategory only has the recycle bin sticker");
            return 0;
        }
        java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list2 = this.d_renamed;
        if (list2 != null) {
            return list2.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public java.lang.Object getItem(int i_renamed) {
        return this.d_renamed.get(i_renamed);
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.sticker.ui.b_renamed bVar;
        com.oplus.camera.e_renamed.a_renamed("GridAdapter_getView_" + i_renamed + "_" + this.m_renamed);
        if (view == null) {
            view = this.e_renamed.inflate(com.oplus.camera.R_renamed.layout.sticker_view, (android.view.ViewGroup) null);
            int iMax = java.lang.Math.max(this.i_renamed, java.lang.Math.max(this.k_renamed, this.j_renamed));
            view.setLayoutParams(new android.widget.AbsListView.LayoutParams(iMax, iMax));
            bVar = new com.oplus.camera.sticker.ui.b_renamed((com.oplus.camera.ui.LoaddingProgress) view.findViewById(com.oplus.camera.R_renamed.id_renamed.loadingView), (com.oplus.camera.ui.RotateImageView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.sticker_image), (android.widget.ImageView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.highlight));
            view.setTag(bVar);
        } else {
            bVar = (com.oplus.camera.sticker.ui.b_renamed) view.getTag();
        }
        if (this.m_renamed) {
            com.oplus.camera.e_renamed.b_renamed("GridAdapter_getView_" + i_renamed + "_" + this.m_renamed);
            return view;
        }
        int iIntValue = ((java.lang.Integer) this.d_renamed.get(i_renamed).get("state_icon")).intValue();
        com.oplus.camera.sticker.data.StickerItem stickerItem = (com.oplus.camera.sticker.data.StickerItem) this.d_renamed.get(i_renamed).get("sticker_item");
        if (this.h_renamed == null) {
            this.h_renamed = this.f_renamed.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.sticker_undownload, null);
        }
        if (this.f5502c != null) {
            com.oplus.camera.sticker.ui.d_renamed dVar = new com.oplus.camera.sticker.ui.d_renamed();
            dVar.a_renamed(bVar);
            dVar.a_renamed(stickerItem.getStickerUUID());
            dVar.a_renamed(stickerItem.isStickerNew());
            dVar.b_renamed(stickerItem.hasMusic());
            dVar.a_renamed(iIntValue);
            this.f5502c.a_renamed(stickerItem.getThumbnailFileUri(), "parse_url", dVar);
        }
        a_renamed(bVar, stickerItem.getStickerUUID());
        if (bVar.f5504b != null) {
            bVar.f5504b.a_renamed(this.f5501b, true);
            if (com.oplus.camera.sticker.data.StickerCategoryItem.isMyCategory(this.g_renamed) && i_renamed == 0) {
                bVar.f5504b.setPadding(0, 0, 0, 0);
            } else {
                com.oplus.camera.ui.RotateImageView rotateImageView = bVar.f5504b;
                int i2 = this.l_renamed;
                rotateImageView.setPadding(i2, i2, i2, i2);
            }
        }
        com.oplus.camera.e_renamed.b_renamed("GridAdapter_getView_" + i_renamed + "_" + this.m_renamed);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.n_renamed = false;
        super.notifyDataSetChanged();
    }

    public void a_renamed() {
        this.n_renamed = true;
        super.notifyDataSetChanged();
    }

    public void a_renamed(boolean z_renamed) {
        this.m_renamed = z_renamed;
    }

    public void a_renamed(com.oplus.camera.sticker.ui.i_renamed iVar) {
        this.f5500a = iVar;
    }

    public void a_renamed(java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list) {
        java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list2 = this.d_renamed;
        if (list2 != null) {
            list2.clear();
            this.d_renamed.addAll(list);
        }
    }

    public void a_renamed(int i_renamed, int i2, android.graphics.drawable.Drawable drawable, boolean z_renamed, com.oplus.camera.sticker.data.StickerItem stickerItem) {
        java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list = this.d_renamed;
        if (list == null || i_renamed >= list.size() || i_renamed < 0) {
            return;
        }
        this.d_renamed.get(i_renamed).put("state_icon", java.lang.Integer.valueOf(i2));
        this.d_renamed.get(i_renamed).put("sticker_item", stickerItem);
        if (z_renamed) {
            notifyDataSetChanged();
        }
    }

    public void a_renamed(com.oplus.camera.sticker.ui.c_renamed cVar) {
        this.f5502c = cVar;
    }

    public void a_renamed(int i_renamed) {
        if (this.f5501b != i_renamed) {
            this.f5501b = i_renamed;
            notifyDataSetChanged();
        }
    }

    public com.oplus.camera.sticker.data.StickerItem b_renamed(int i_renamed) {
        java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list = this.d_renamed;
        if (list == null || i_renamed >= list.size()) {
            return null;
        }
        return (com.oplus.camera.sticker.data.StickerItem) this.d_renamed.get(i_renamed).get("sticker_item");
    }

    private void a_renamed(com.oplus.camera.sticker.ui.b_renamed bVar, java.lang.String str) {
        com.oplus.camera.sticker.ui.i_renamed iVar;
        if (bVar.f5505c == null || (iVar = this.f5500a) == null) {
            return;
        }
        if (iVar.f_renamed() != null && str.equals(this.f5500a.f_renamed().getStickerUUID())) {
            bVar.a_renamed(true, this.n_renamed);
        } else {
            bVar.a_renamed(false, this.n_renamed);
        }
    }
}

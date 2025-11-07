package com.oplus.camera.sticker.ui;

/* compiled from: StickerRecycleBinAdapter.java */
/* loaded from: classes2.dex */
public class k_renamed extends android.widget.CursorAdapter implements android.view.View.OnClickListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.HashMap<java.lang.String, com.oplus.camera.sticker.data.StickerItem> f5568a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.ui.k_renamed.a_renamed f5569b;

    /* compiled from: StickerRecycleBinAdapter.java */
    public interface a_renamed {
        void a_renamed(com.oplus.camera.sticker.ui.k_renamed kVar);
    }

    public k_renamed(android.content.Context context, android.database.Cursor cursor, boolean z_renamed) {
        super(context, cursor, z_renamed);
        this.f5568a = new java.util.HashMap<>();
        this.f5569b = null;
    }

    @Override // android.widget.CursorAdapter
    public android.view.View newView(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup viewGroup) {
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) android.view.LayoutInflater.from(context).inflate(com.oplus.camera.R_renamed.layout.editor_sticker_recycle_bin_item_layout, viewGroup, false);
        relativeLayout.setTag(new com.oplus.camera.sticker.ui.k_renamed.b_renamed(relativeLayout));
        return relativeLayout;
    }

    @Override // android.widget.CursorAdapter
    public void bindView(android.view.View view, android.content.Context context, android.database.Cursor cursor) {
        com.oplus.camera.sticker.ui.k_renamed.b_renamed bVar = (com.oplus.camera.sticker.ui.k_renamed.b_renamed) view.getTag();
        com.oplus.camera.sticker.data.StickerItem stickerItemA = com.oplus.camera.sticker.g_renamed.a_renamed(cursor);
        com.oplus.camera.e_renamed.a_renamed("StickerRecycleBinAdapter", "bindView, item: " + stickerItemA);
        bVar.f5570a.setNormalDrawableUri(stickerItemA.getThumbnailFileUri());
        view.setTag(com.oplus.camera.R_renamed.id_renamed.sticker_recycle_bin_item_tag, stickerItemA);
        view.setOnClickListener(this);
        if (this.f5568a.containsKey(stickerItemA.getStickerUUID())) {
            bVar.f5571b.setChecked(true);
        } else {
            bVar.f5571b.setChecked(false);
        }
    }

    public void a_renamed() {
        for (com.oplus.camera.sticker.data.StickerItem stickerItem : g_renamed()) {
            this.f5568a.put(stickerItem.getStickerUUID(), stickerItem);
        }
        com.oplus.camera.sticker.ui.k_renamed.a_renamed aVar = this.f5569b;
        if (aVar != null) {
            aVar.a_renamed(this);
        }
        notifyDataSetChanged();
    }

    public void b_renamed() {
        this.f5568a.clear();
        com.oplus.camera.sticker.ui.k_renamed.a_renamed aVar = this.f5569b;
        if (aVar != null) {
            aVar.a_renamed(this);
        }
        notifyDataSetChanged();
    }

    public boolean c_renamed() {
        return getCount() != 0 && getCount() == this.f5568a.size();
    }

    public int d_renamed() {
        return this.f5568a.size();
    }

    public java.util.Map<java.lang.String, com.oplus.camera.sticker.data.StickerItem> e_renamed() {
        return this.f5568a;
    }

    @Override // android.widget.CursorAdapter, android.widget.Adapter
    public int getCount() {
        android.database.Cursor cursor = getCursor();
        if (cursor == null || cursor.isClosed()) {
            com.oplus.camera.e_renamed.e_renamed("StickerRecycleBinAdapter", "getCount, cursor is_renamed null or closed! cursor: " + cursor);
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.CursorAdapter, android.widget.Adapter
    public java.lang.Object getItem(int i_renamed) {
        android.database.Cursor cursor = getCursor();
        if (cursor == null || i_renamed >= cursor.getCount()) {
            return null;
        }
        cursor.moveToPosition(i_renamed);
        return com.oplus.camera.sticker.g_renamed.a_renamed(cursor);
    }

    public void f_renamed() {
        this.f5568a.clear();
        if (getCursor() != null) {
            getCursor().close();
        }
    }

    public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        if (stickerItem == null || android.text.TextUtils.isEmpty(stickerItem.getStickerUUID())) {
            return;
        }
        if (this.f5568a.size() > 0 && this.f5568a.remove(stickerItem.getStickerUUID()) != null) {
            com.oplus.camera.e_renamed.b_renamed("StickerRecycleBinAdapter", "onStickerDelete, remove a_renamed selected sticker item!");
            com.oplus.camera.sticker.ui.k_renamed.a_renamed aVar = this.f5569b;
            if (aVar != null) {
                aVar.a_renamed(this);
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        java.lang.Object tag = view.getTag(com.oplus.camera.R_renamed.id_renamed.sticker_recycle_bin_item_tag);
        if (tag instanceof com.oplus.camera.sticker.data.StickerItem) {
            com.oplus.camera.sticker.data.StickerItem stickerItem = (com.oplus.camera.sticker.data.StickerItem) tag;
            if (this.f5568a.containsKey(stickerItem.getStickerUUID())) {
                this.f5568a.remove(stickerItem.getStickerUUID());
            } else {
                this.f5568a.put(stickerItem.getStickerUUID(), stickerItem);
            }
            com.oplus.camera.sticker.ui.k_renamed.a_renamed aVar = this.f5569b;
            if (aVar != null) {
                aVar.a_renamed(this);
            }
            notifyDataSetChanged();
        }
    }

    public void a_renamed(com.oplus.camera.sticker.ui.k_renamed.a_renamed aVar) {
        this.f5569b = aVar;
    }

    private java.util.List<com.oplus.camera.sticker.data.StickerItem> g_renamed() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursor = getCursor();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                arrayList.add(com.oplus.camera.sticker.g_renamed.a_renamed(cursor));
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    /* compiled from: StickerRecycleBinAdapter.java */
    private static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private com.oplus.camera.sticker.ui.StickerRecycleBinThumbnailView f5570a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.widget.CheckBox f5571b;

        public b_renamed(android.view.View view) {
            this.f5570a = null;
            this.f5571b = null;
            this.f5570a = (com.oplus.camera.sticker.ui.StickerRecycleBinThumbnailView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.sticker_thumbnail);
            this.f5571b = (android.widget.CheckBox) view.findViewById(com.oplus.camera.R_renamed.id_renamed.sticker_check_box);
        }
    }
}

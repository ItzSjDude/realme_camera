package com.oplus.camera.sticker.ui;

/* loaded from: classes2.dex */
public class StickerGridViewLayout extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.widget.TextView f5492a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.ui.FooterGridView f5493b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.ui.a_renamed f5494c;
    private com.oplus.camera.sticker.ui.c_renamed d_renamed;
    private android.content.Context e_renamed;
    private com.oplus.camera.sticker.ui.i_renamed f_renamed;
    private int g_renamed;

    public StickerGridViewLayout(android.content.Context context) {
        this(context, null);
    }

    public StickerGridViewLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public StickerGridViewLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, -1, -1);
    }

    public StickerGridViewLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.f5492a = null;
        this.f5493b = null;
        this.f5494c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = 0;
        this.e_renamed = context;
    }

    public void setOrientation(int i_renamed) {
        this.g_renamed = i_renamed;
        com.oplus.camera.sticker.ui.a_renamed aVar = this.f5494c;
        if (aVar != null) {
            aVar.a_renamed(i_renamed);
        }
    }

    public void setStickerMenuListener(com.oplus.camera.sticker.ui.i_renamed iVar) {
        this.f_renamed = iVar;
        com.oplus.camera.sticker.ui.a_renamed aVar = this.f5494c;
        if (aVar != null) {
            aVar.a_renamed(iVar);
        }
    }

    public void setImageDownloader(com.oplus.camera.sticker.ui.c_renamed cVar) {
        this.d_renamed = cVar;
        com.oplus.camera.sticker.ui.a_renamed aVar = this.f5494c;
        if (aVar != null) {
            aVar.a_renamed(cVar);
        }
    }

    public void a_renamed(java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list, int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("StickerGridViewLayout", "setDataList, stickerItemList.size: " + list.size() + ", needNotify: " + z_renamed + ", getTag: " + ((java.lang.String) getTag()));
        this.g_renamed = i_renamed;
        com.oplus.camera.sticker.ui.a_renamed aVar = this.f5494c;
        if (aVar != null) {
            aVar.a_renamed((java.lang.String) getTag());
            this.f5494c.a_renamed(list);
            this.f5494c.a_renamed(this.f_renamed);
            this.f5494c.a_renamed(this.g_renamed);
            if (z_renamed) {
                this.f5494c.notifyDataSetChanged();
            }
            if (this.f5492a == null || !com.oplus.camera.sticker.data.StickerCategoryItem.isMyCategory((java.lang.String) getTag())) {
                return;
            }
            this.f5492a.setVisibility(this.f5494c.getCount() <= 0 ? 0 : 4);
        }
    }

    public void a_renamed(int i_renamed, int i2, android.graphics.drawable.Drawable drawable, boolean z_renamed, com.oplus.camera.sticker.data.StickerItem stickerItem) {
        com.oplus.camera.sticker.ui.a_renamed aVar = this.f5494c;
        if (aVar != null) {
            aVar.a_renamed(i_renamed, i2, drawable, z_renamed, stickerItem);
        }
    }

    public void a_renamed() {
        com.oplus.camera.sticker.ui.a_renamed aVar = this.f5494c;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public void setTag(java.lang.Object obj) {
        super.setTag(obj);
        if (com.oplus.camera.sticker.data.StickerCategoryItem.isMyCategory((java.lang.String) getTag()) && this.f5492a == null) {
            this.f5492a = new android.widget.TextView(this.e_renamed);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(10);
            layoutParams.topMargin = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_tips_margin_top);
            if (com.oplus.camera.sticker.data.StickerCategoryItem.isMyCategory((java.lang.String) getTag())) {
                this.f5492a.setText(com.oplus.camera.R_renamed.string.sticker_tips_none);
            }
            this.f5492a.setTextColor(this.e_renamed.getColor(com.oplus.camera.R_renamed.color.camera_white));
            this.f5492a.setTextSize(0, this.e_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.camera_text_size_smaller));
            this.f5492a.setTypeface(com.oplus.camera.util.Util.l_renamed(getContext()));
            this.f5492a.setVisibility(8);
            addView(this.f5492a, layoutParams);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f5493b = (com.oplus.camera.sticker.ui.FooterGridView) findViewById(com.oplus.camera.R_renamed.id_renamed.sticker_grid_view);
        this.f5494c = new com.oplus.camera.sticker.ui.a_renamed(this.e_renamed, this.d_renamed, this.g_renamed);
        this.f5493b.setAdapter((android.widget.BaseAdapter) this.f5494c);
        this.f5493b.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() { // from class: com.oplus.camera.sticker.ui.StickerGridViewLayout.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i_renamed, long j_renamed) {
                if (com.oplus.camera.sticker.ui.StickerGridViewLayout.this.f_renamed != null && com.oplus.camera.sticker.ui.StickerGridViewLayout.this.f_renamed.i_renamed() && com.oplus.camera.sticker.ui.StickerGridViewLayout.this.f5494c != null) {
                    com.oplus.camera.sticker.data.StickerItem stickerItemB = com.oplus.camera.sticker.ui.StickerGridViewLayout.this.f5494c.b_renamed(i_renamed);
                    if (stickerItemB == null || com.oplus.camera.sticker.ui.StickerGridViewLayout.this.f_renamed.a_renamed(stickerItemB, i_renamed)) {
                        return;
                    }
                    com.oplus.camera.sticker.ui.StickerGridViewLayout.this.f5494c.a_renamed();
                    return;
                }
                com.oplus.camera.e_renamed.a_renamed("StickerGridViewLayout", "onItemClick, return");
            }
        });
        this.f5493b.setOnItemLongClickListener(new android.widget.AdapterView.OnItemLongClickListener() { // from class: com.oplus.camera.sticker.ui.StickerGridViewLayout.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i_renamed, long j_renamed) {
                com.oplus.camera.e_renamed.b_renamed("StickerGridViewLayout", "onItemLongClick, position: " + i_renamed + ", id_renamed: " + j_renamed);
                if (com.oplus.camera.sticker.ui.StickerGridViewLayout.this.f_renamed != null && com.oplus.camera.sticker.ui.StickerGridViewLayout.this.f_renamed.i_renamed()) {
                    com.oplus.camera.sticker.data.StickerItem stickerItemB = com.oplus.camera.sticker.ui.StickerGridViewLayout.this.f5494c.b_renamed(i_renamed);
                    return stickerItemB == null || com.oplus.camera.sticker.ui.StickerGridViewLayout.this.f_renamed.a_renamed(view, stickerItemB, i_renamed);
                }
                com.oplus.camera.e_renamed.a_renamed("StickerGridViewLayout", "onItemLongClick, return");
                return false;
            }
        });
    }

    public void setGridViewEnable(boolean z_renamed) {
        com.oplus.camera.sticker.ui.FooterGridView footerGridView = this.f5493b;
        if (footerGridView != null) {
            footerGridView.setClickable(z_renamed);
            this.f5493b.setEnabled(z_renamed);
        }
    }
}

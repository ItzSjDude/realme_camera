package com.oplus.camera.sticker.ui;

/* compiled from: StickerPageAdapter.java */
/* loaded from: classes2.dex */
public class j_renamed extends androidx.viewpager.widget.a_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f5563b;
    private android.app.Activity d_renamed;
    private com.oplus.camera.sticker.ui.i_renamed e_renamed;
    private com.oplus.camera.sticker.ui.c_renamed f_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.ArrayList<com.oplus.camera.sticker.ui.StickerGridViewLayout> f5562a = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f5564c = 0;

    @Override // androidx.viewpager.widget.a_renamed
    public boolean a_renamed(android.view.View view, java.lang.Object obj) {
        return view == obj;
    }

    public j_renamed(android.app.Activity activity, int i_renamed, com.oplus.camera.sticker.data.StickerItem stickerItem, com.oplus.camera.sticker.ui.i_renamed iVar, com.oplus.camera.sticker.ui.c_renamed cVar) {
        this.f5563b = 0;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.f5563b = i_renamed;
        this.d_renamed = activity;
        this.e_renamed = iVar;
        this.f_renamed = cVar;
        a_renamed(stickerItem, true);
    }

    public void c_renamed(int i_renamed) {
        this.f5564c = i_renamed;
    }

    public int d_renamed() {
        return this.f5564c;
    }

    public void d_renamed(int i_renamed) {
        this.f5563b = i_renamed;
        java.util.ArrayList<com.oplus.camera.sticker.ui.StickerGridViewLayout> arrayList = this.f5562a;
        if (arrayList != null) {
            java.util.Iterator<com.oplus.camera.sticker.ui.StickerGridViewLayout> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setOrientation(this.f5563b);
            }
        }
    }

    public void a_renamed(boolean z_renamed) {
        java.util.ArrayList<com.oplus.camera.sticker.ui.StickerGridViewLayout> arrayList = this.f5562a;
        if (arrayList != null) {
            java.util.Iterator<com.oplus.camera.sticker.ui.StickerGridViewLayout> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setGridViewEnable(z_renamed);
            }
        }
    }

    public void a_renamed(java.lang.String str, final int i_renamed, final int i2, final android.graphics.drawable.Drawable drawable, final boolean z_renamed, final com.oplus.camera.sticker.data.StickerItem stickerItem) {
        java.util.ArrayList<com.oplus.camera.sticker.ui.StickerGridViewLayout> arrayList = this.f5562a;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        final com.oplus.camera.sticker.ui.StickerGridViewLayout stickerGridViewLayoutB = b_renamed(str);
        android.app.Activity activity = this.d_renamed;
        if (activity == null || stickerGridViewLayoutB == null) {
            return;
        }
        activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.sticker.ui.j_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                stickerGridViewLayoutB.a_renamed(i_renamed, i2, drawable, z_renamed, stickerItem);
            }
        });
    }

    @Override // androidx.viewpager.widget.a_renamed
    public int a_renamed() {
        java.util.ArrayList<com.oplus.camera.sticker.ui.StickerGridViewLayout> arrayList = this.f5562a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.a_renamed
    public java.lang.Object a_renamed(android.view.ViewGroup viewGroup, int i_renamed) {
        com.oplus.camera.sticker.ui.StickerGridViewLayout stickerGridViewLayout = this.f5562a.get(i_renamed);
        if (stickerGridViewLayout != null) {
            if (viewGroup.indexOfChild(stickerGridViewLayout) == -1) {
                viewGroup.addView(this.f5562a.get(i_renamed));
            }
            stickerGridViewLayout.setStickerMenuListener(this.e_renamed);
            stickerGridViewLayout.setImageDownloader(this.f_renamed);
        }
        return stickerGridViewLayout;
    }

    @Override // androidx.viewpager.widget.a_renamed
    public void a_renamed(android.view.ViewGroup viewGroup, int i_renamed, java.lang.Object obj) {
        com.oplus.camera.sticker.ui.StickerGridViewLayout stickerGridViewLayout = this.f5562a.get(i_renamed);
        if (stickerGridViewLayout == null || viewGroup.indexOfChild(stickerGridViewLayout) == -1) {
            return;
        }
        viewGroup.removeView(stickerGridViewLayout);
    }

    public void a_renamed(java.lang.String str) {
        com.oplus.camera.sticker.ui.StickerGridViewLayout stickerGridViewLayoutB;
        java.util.ArrayList<com.oplus.camera.sticker.ui.StickerGridViewLayout> arrayList = this.f5562a;
        if (arrayList == null || arrayList.isEmpty() || (stickerGridViewLayoutB = b_renamed(str)) == null) {
            return;
        }
        stickerGridViewLayoutB.a_renamed();
    }

    public void a_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.sticker.ui.StickerGridViewLayout stickerGridViewLayoutB;
        java.util.ArrayList<com.oplus.camera.sticker.ui.StickerGridViewLayout> arrayList = this.f5562a;
        if (arrayList != null && !arrayList.isEmpty() && (stickerGridViewLayoutB = b_renamed(str)) != null) {
            stickerGridViewLayoutB.a_renamed();
        }
        if (z_renamed) {
            c_renamed();
        }
    }

    public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("makeGridView");
        com.oplus.camera.ui.preview.a_renamed.q_renamed.c_renamed cVarB = com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.d_renamed).b_renamed();
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.preview.a_renamed.q_renamed.a_renamed> copyOnWriteArrayListB = cVarB.b_renamed();
        if (copyOnWriteArrayListB != null && copyOnWriteArrayListB.size() > 0) {
            if (this.f5562a == null) {
                this.f5562a = new java.util.ArrayList<>();
            }
            java.util.Iterator<com.oplus.camera.ui.preview.a_renamed.q_renamed.a_renamed> it = copyOnWriteArrayListB.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.preview.a_renamed.q_renamed.a_renamed next = it.next();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator<com.oplus.camera.sticker.data.StickerItem> it2 = next.a_renamed().iterator();
                while (it2.hasNext()) {
                    com.oplus.camera.sticker.data.StickerItem next2 = it2.next();
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("state_icon", java.lang.Integer.valueOf(next2.getDownloadState()));
                    map.put("sticker_item", next2);
                    arrayList.add(map);
                }
                com.oplus.camera.sticker.ui.StickerGridViewLayout stickerGridViewLayoutB = b_renamed(next.b_renamed());
                java.lang.String categoryId = null;
                if (stickerGridViewLayoutB == null) {
                    android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                    com.oplus.camera.sticker.ui.StickerGridViewLayout stickerGridViewLayout = (com.oplus.camera.sticker.ui.StickerGridViewLayout) android.view.LayoutInflater.from(this.d_renamed).inflate(com.oplus.camera.R_renamed.layout.sticker_menu_grid_item, (android.view.ViewGroup) null);
                    stickerGridViewLayout.setLayoutParams(layoutParams);
                    stickerGridViewLayout.setTag(next.b_renamed());
                    java.lang.Integer numE = cVarB.e_renamed(next.b_renamed());
                    int iIntValue = numE != null ? numE.intValue() : -1;
                    if (iIntValue >= 0 && iIntValue < this.f5562a.size()) {
                        this.f5562a.add(iIntValue, stickerGridViewLayout);
                    } else {
                        this.f5562a.add(stickerGridViewLayout);
                    }
                    stickerGridViewLayoutB = stickerGridViewLayout;
                }
                if (stickerItem != null) {
                    categoryId = stickerItem.getCategoryId();
                }
                stickerGridViewLayoutB.a_renamed(arrayList, this.f5563b, next.b_renamed().equals(categoryId));
            }
            if (z_renamed) {
                c_renamed();
            }
        }
        com.oplus.camera.e_renamed.b_renamed("makeGridView");
    }

    private com.oplus.camera.sticker.ui.StickerGridViewLayout b_renamed(java.lang.String str) {
        java.util.ArrayList<com.oplus.camera.sticker.ui.StickerGridViewLayout> arrayList = this.f5562a;
        if (arrayList != null && !arrayList.isEmpty() && str != null) {
            java.lang.Integer numE = com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.d_renamed).b_renamed().e_renamed(str);
            int iIntValue = numE != null ? numE.intValue() : -1;
            if (iIntValue >= 0 && iIntValue < this.f5562a.size()) {
                return this.f5562a.get(iIntValue);
            }
        }
        return null;
    }
}

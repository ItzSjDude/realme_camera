package com.oplus.camera.ui;

/* compiled from: GalleryPreviewAdapter.java */
/* loaded from: classes2.dex */
public class k_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<com.oplus.camera.ui.k_renamed.a_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6267a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6268b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6269c;
    private int d_renamed;
    private int e_renamed;
    private float g_renamed;
    private android.content.Context j_renamed;
    private android.os.Handler u_renamed;
    private com.oplus.camera.ui.CameraUIListener x_renamed;
    private int f_renamed = 0;
    private boolean h_renamed = false;
    private boolean i_renamed = true;
    private android.graphics.Bitmap k_renamed = null;
    private android.graphics.Bitmap l_renamed = null;
    private java.util.HashMap<java.lang.String, java.lang.Integer> m_renamed = new java.util.HashMap<>();
    private com.oplus.camera.ui.k_renamed.c_renamed n_renamed = null;
    private java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> o_renamed = null;
    private java.lang.Object p_renamed = new java.lang.Object();
    private java.util.HashMap<java.lang.String, com.oplus.c_renamed.a_renamed.d_renamed> q_renamed = new java.util.HashMap<>();
    private java.util.HashMap<java.lang.String, android.view.Surface> r_renamed = new java.util.HashMap<>();
    private java.util.HashMap<java.lang.String, com.oplus.camera.ui.k_renamed.d_renamed> s_renamed = new java.util.HashMap<>();
    private androidx.recyclerview.widget.RecyclerView t_renamed = null;
    private boolean v_renamed = false;
    private java.lang.Object w_renamed = new java.lang.Object();
    private volatile boolean y_renamed = false;
    private com.oplus.camera.ui.k_renamed.e_renamed z_renamed = null;
    private com.oplus.camera.ui.inverse.InverseLinearLayout A_renamed = null;
    private android.widget.RelativeLayout B_renamed = null;

    /* compiled from: GalleryPreviewAdapter.java */
    public interface c_renamed {
        void a_renamed(android.view.View view, android.graphics.Bitmap bitmap, int i_renamed);
    }

    public k_renamed(android.content.Context context, int i_renamed, com.oplus.camera.ui.CameraUIListener cameraUIListener) {
        this.f6267a = 0;
        this.f6268b = 0;
        this.f6269c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.g_renamed = 1.0f;
        this.j_renamed = null;
        this.u_renamed = null;
        this.x_renamed = null;
        this.j_renamed = context;
        this.f6269c = i_renamed;
        this.f6267a = this.j_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gallery_preview_view_width);
        this.f6268b = this.j_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gallery_preview_view_height);
        int i2 = this.f6267a;
        if (i2 != 0) {
            this.g_renamed = this.f6268b / i2;
        }
        this.u_renamed = new com.oplus.camera.ui.k_renamed.b_renamed(this.j_renamed.getMainLooper());
        this.x_renamed = cameraUIListener;
        this.d_renamed = this.j_renamed.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.gallery_preview_view_margin_top);
        this.e_renamed = this.j_renamed.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.gallery_preview_video_play_button_margin_top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.camera.ui.k_renamed.a_renamed onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "onCreateViewHolder");
        return new com.oplus.camera.ui.k_renamed.a_renamed(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.oplus.camera.R_renamed.layout.gallery_preview_view, viewGroup, false), i_renamed);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(com.oplus.camera.ui.k_renamed.a_renamed aVar, int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "onBindViewHolder, position:  " + i_renamed);
        if (aVar == null) {
            return;
        }
        com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVarD = d_renamed(i_renamed);
        if (aVarD == null) {
            com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "onBindViewHolder, mediaItem is_renamed null");
        } else if (aVarD.j_renamed()) {
            a_renamed(true, false, aVar);
            a_renamed(aVar, aVarD);
        } else {
            a_renamed(false, this.o_renamed.get(i_renamed).k_renamed(), aVar);
            b_renamed(aVar, aVarD);
        }
    }

    private com.oplus.c_renamed.a_renamed.b_renamed.a_renamed d_renamed(int i_renamed) {
        java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> arrayList = this.o_renamed;
        if (arrayList == null) {
            return null;
        }
        com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar = arrayList.get(i_renamed);
        if (aVar != null && "-1".equals(aVar.f_renamed()) && !aVar.j_renamed()) {
            return aVar;
        }
        for (int i2 = i_renamed; i2 >= 0; i2--) {
            if (new java.io.File(this.o_renamed.get(i2).f_renamed()).exists()) {
                return this.o_renamed.get(i2);
            }
        }
        while (i_renamed < this.o_renamed.size()) {
            if (new java.io.File(this.o_renamed.get(i_renamed).f_renamed()).exists()) {
                return this.o_renamed.get(i_renamed);
            }
            i_renamed++;
        }
        return null;
    }

    private void a_renamed(boolean z_renamed, boolean z2, com.oplus.camera.ui.k_renamed.a_renamed aVar) {
        int i_renamed = z_renamed ? 8 : 0;
        int i2 = z2 ? 0 : 8;
        int i3 = z_renamed ? 0 : 8;
        aVar.f6304c.setVisibility(i_renamed);
        aVar.e_renamed.setVisibility(i2);
        aVar.d_renamed.setVisibility(i3);
        aVar.f_renamed.setVisibility(i3);
        if (!z_renamed) {
            this.A_renamed = null;
            this.B_renamed = null;
        } else {
            this.A_renamed = aVar.h_renamed;
            this.B_renamed = aVar.g_renamed;
            c_renamed(!this.v_renamed);
        }
    }

    private void b_renamed(final com.oplus.camera.ui.k_renamed.a_renamed aVar, final com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar2) {
        if (!"-1".equals(aVar2.f_renamed())) {
            if (!this.y_renamed || this.l_renamed == null) {
                a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.k_renamed.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.ui.k_renamed.this.y_renamed = false;
                        com.oplus.camera.ui.k_renamed kVar = com.oplus.camera.ui.k_renamed.this;
                        int iA = kVar.a_renamed(com.oplus.c_renamed.a_renamed.b_renamed.b_renamed(kVar.j_renamed, aVar2, 1));
                        com.oplus.camera.ui.k_renamed kVar2 = com.oplus.camera.ui.k_renamed.this;
                        kVar2.l_renamed = com.oplus.c_renamed.a_renamed.b_renamed.a_renamed(kVar2.j_renamed, aVar2, iA);
                        if (com.oplus.camera.ui.k_renamed.this.l_renamed == null) {
                            com.oplus.camera.e_renamed.f_renamed("GalleryPreviewAdapter", "setImage, decode failed, mediaItem: " + aVar2);
                            com.oplus.camera.ui.k_renamed.this.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.k_renamed.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (com.oplus.camera.ui.k_renamed.this.k_renamed != null) {
                                        aVar.f6304c.setImageBitmap(com.oplus.camera.ui.k_renamed.this.k_renamed);
                                        com.oplus.camera.ui.k_renamed.this.a_renamed(aVar.f6303b, com.oplus.camera.ui.k_renamed.this.k_renamed.getHeight(), com.oplus.camera.ui.k_renamed.this.k_renamed.getWidth());
                                    } else {
                                        com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "setImage, all available bitmap is_renamed null");
                                    }
                                }
                            });
                            return;
                        }
                        com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "setImage, mImageBitmap: width: " + com.oplus.camera.ui.k_renamed.this.l_renamed.getWidth() + ", height: " + com.oplus.camera.ui.k_renamed.this.l_renamed.getHeight() + ", bytes: " + com.oplus.camera.ui.k_renamed.this.l_renamed.getByteCount() + ", sampleSize: " + iA);
                        com.oplus.camera.ui.k_renamed.this.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.k_renamed.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.f6304c.setImageBitmap(com.oplus.camera.ui.k_renamed.this.l_renamed);
                                com.oplus.camera.ui.k_renamed.this.a_renamed(aVar.f6303b, com.oplus.camera.ui.k_renamed.this.l_renamed.getHeight(), com.oplus.camera.ui.k_renamed.this.l_renamed.getWidth());
                            }
                        });
                    }
                }, "GalleryPreviewAdapter setImage");
                return;
            }
            aVar.f6304c.setImageBitmap(this.l_renamed);
            a_renamed(aVar.f6303b, this.l_renamed.getHeight(), this.l_renamed.getWidth());
            this.y_renamed = false;
            return;
        }
        aVar.f6304c.setImageBitmap(this.k_renamed);
        a_renamed(aVar.f6303b, this.k_renamed.getHeight(), this.k_renamed.getWidth());
    }

    public void a_renamed(final com.oplus.camera.ui.k_renamed.a_renamed aVar, final com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar2) {
        com.oplus.camera.e_renamed.a_renamed("GalleryPreviewAdapter", "setVideo, video path: " + aVar2.f_renamed() + ", id_renamed: " + aVar2.e_renamed());
        if (aVar2.b_renamed() > 0 && aVar2.c_renamed() > 0) {
            int iB = aVar2.b_renamed();
            int iC = aVar2.c_renamed();
            if (aVar2.a_renamed() % 180 != 0) {
                iB = aVar2.c_renamed();
                iC = aVar2.b_renamed();
            }
            a_renamed(aVar.d_renamed, iC, iB);
        }
        a_renamed(aVar.h_renamed);
        com.oplus.camera.e_renamed.a_renamed("GalleryPreviewAdapter", "setVideo, id_renamed: " + aVar2.e_renamed() + ", rotation: " + aVar2.a_renamed() + ", width: " + aVar2.b_renamed() + ", height: " + aVar2.c_renamed());
        aVar.d_renamed.setSurfaceTextureListener(new android.view.TextureView.SurfaceTextureListener() { // from class: com.oplus.camera.ui.k_renamed.5
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
                com.oplus.camera.ui.k_renamed.this.a_renamed(surfaceTexture, aVar2, aVar);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
                com.oplus.camera.e_renamed.a_renamed("GalleryPreviewAdapter", "onSurfaceTextureDestroyed, item: " + aVar2.f_renamed());
                synchronized (com.oplus.camera.ui.k_renamed.this.w_renamed) {
                    com.oplus.camera.ui.k_renamed.this.a_renamed(aVar2.f_renamed());
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a_renamed(int[] iArr) {
        com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "calSampleSize, imageBitmapSize: " + java.util.Arrays.toString(iArr));
        if (iArr == null || 2 != iArr.length || -1 == iArr[0] || -1 == iArr[1]) {
            return 2;
        }
        int i_renamed = iArr[0];
        int i2 = iArr[1];
        int i3 = this.f6267a;
        int i4 = (int) (i3 * (i2 / i_renamed));
        if (i_renamed <= i4 && i2 <= i3) {
            return 1;
        }
        int iFloorDiv = java.lang.Math.floorDiv(i_renamed, i3);
        int iFloorDiv2 = java.lang.Math.floorDiv(i2, i4);
        return iFloorDiv2 < iFloorDiv ? iFloorDiv2 : iFloorDiv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.view.View view, int i_renamed, int i2) {
        int iRound;
        int iRound2;
        int i3;
        float f_renamed = i_renamed / i2;
        if (f_renamed - this.g_renamed > 0.01d) {
            iRound = this.f6268b;
            iRound2 = java.lang.Math.round(iRound / f_renamed);
            i3 = 0;
        } else {
            iRound = java.lang.Math.round(this.f6267a * f_renamed);
            iRound2 = this.f6267a;
            i3 = (this.f6268b - iRound) / 2;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = iRound;
        layoutParams.width = iRound2;
        layoutParams.topMargin = this.d_renamed + i3;
        if (com.oplus.camera.R_renamed.id_renamed.gallery_preview_surface == view.getId()) {
            this.f_renamed = layoutParams.topMargin + layoutParams.height;
        }
        view.setLayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public void onAttachedToRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.t_renamed = recyclerView;
        this.t_renamed.setItemAnimator(null);
        this.t_renamed.setHasFixedSize(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public void onDetachedFromRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        l_renamed();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(com.oplus.camera.ui.k_renamed.a_renamed aVar) {
        super.onViewDetachedFromWindow(aVar);
        l_renamed();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(com.oplus.camera.ui.k_renamed.a_renamed aVar) {
        aVar.f6304c.setImageDrawable(null);
        super.onViewRecycled(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemViewType(int i_renamed) {
        java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> arrayList = this.o_renamed;
        if (arrayList == null || arrayList.size() == 0) {
            return 4;
        }
        if (this.o_renamed.get(i_renamed).j_renamed()) {
            return 2;
        }
        return this.o_renamed.get(i_renamed).k_renamed() ? 3 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemCount() {
        java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> arrayList = this.o_renamed;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public boolean a_renamed() {
        return this.i_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "setShouldShowGallery, " + z_renamed);
        this.i_renamed = z_renamed;
    }

    public void a_renamed(java.util.List<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> list) {
        this.i_renamed = true;
        if (list == null) {
            if (this.o_renamed != null) {
                synchronized (this.p_renamed) {
                    this.o_renamed.clear();
                }
            }
            java.util.HashMap<java.lang.String, java.lang.Integer> map = this.m_renamed;
            if (map != null) {
                map.clear();
            }
            notifyDataSetChanged();
            return;
        }
        if (this.o_renamed == null) {
            this.o_renamed = new java.util.ArrayList<>();
        }
        com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "setDataList, size: " + list.size() + ", first mediaItem: " + list.get(0) + ", last mediaItem: " + list.get(list.size() - 1));
        synchronized (this.p_renamed) {
            this.o_renamed.clear();
            this.o_renamed.addAll(list);
        }
        this.m_renamed.clear();
        for (int i_renamed = 0; i_renamed < this.o_renamed.size(); i_renamed++) {
            this.m_renamed.put(this.o_renamed.get(i_renamed).e_renamed(), java.lang.Integer.valueOf(i_renamed));
        }
        notifyItemRangeChanged(0, this.o_renamed.size());
    }

    public void a_renamed(final java.lang.String str, boolean z_renamed, final int i_renamed) {
        if (str == null && z_renamed && this.o_renamed.size() != 0) {
            if (this.o_renamed.get(r1.size() - 1).k_renamed()) {
                a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.k_renamed.6
                    @Override // java.lang.Runnable
                    public void run() {
                        android.os.Message messageObtain = android.os.Message.obtain();
                        messageObtain.what = 1;
                        messageObtain.arg1 = com.oplus.camera.ui.k_renamed.this.o_renamed.size() - 1;
                        messageObtain.arg2 = 1;
                        com.oplus.camera.ui.k_renamed.this.u_renamed.sendMessage(messageObtain);
                    }
                });
                return;
            }
            return;
        }
        if (com.oplus.camera.util.Util.aR_renamed()) {
            a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.k_renamed.7
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.k_renamed.this.a_renamed(str, i_renamed);
                }
            }, "GalleryPreviewAdapter addItem");
        } else {
            a_renamed(str, i_renamed);
        }
    }

    public void a_renamed(android.graphics.Bitmap bitmap) {
        if (bitmap != null) {
            this.k_renamed = bitmap;
        }
        com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "setCurThumbImage: " + bitmap);
    }

    public void b_renamed() {
        this.v_renamed = true;
        j_renamed();
        c_renamed(false);
    }

    public void c_renamed() {
        this.v_renamed = false;
        c_renamed(true);
    }

    private void c_renamed(final boolean z_renamed) {
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.k_renamed.8
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.ui.k_renamed.this.A_renamed == null || com.oplus.camera.ui.k_renamed.this.B_renamed == null) {
                    return;
                }
                if (com.oplus.camera.ui.k_renamed.this.t_renamed != null && com.oplus.camera.ui.k_renamed.this.t_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_video_play_button) != null) {
                    com.oplus.camera.ui.k_renamed kVar = com.oplus.camera.ui.k_renamed.this;
                    kVar.A_renamed = (com.oplus.camera.ui.inverse.InverseLinearLayout) kVar.t_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_video_play_button);
                }
                if (com.oplus.camera.ui.k_renamed.this.t_renamed != null && com.oplus.camera.ui.k_renamed.this.t_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_video_play_button_touch_region) != null) {
                    com.oplus.camera.ui.k_renamed kVar2 = com.oplus.camera.ui.k_renamed.this;
                    kVar2.B_renamed = (android.widget.RelativeLayout) kVar2.t_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_video_play_button_touch_region);
                }
                com.oplus.camera.ui.k_renamed.this.B_renamed.setEnabled(z_renamed);
                int iC = androidx.core.a_renamed.a_renamed.c_renamed(com.oplus.camera.ui.k_renamed.this.j_renamed, z_renamed ? com.oplus.camera.R_renamed.color.color_play_button_enabled : com.oplus.camera.R_renamed.color.color_play_button_disabled);
                ((android.widget.ImageView) com.oplus.camera.ui.k_renamed.this.A_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_video_play_button_image)).setColorFilter(iC);
                ((android.widget.TextView) com.oplus.camera.ui.k_renamed.this.A_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_video_play_button_text)).setTextColor(iC);
            }
        });
    }

    private void j_renamed() {
        com.oplus.c_renamed.a_renamed.d_renamed dVar;
        com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVarE = e_renamed();
        if (aVarE == null || (dVar = this.q_renamed.get(aVarE.f_renamed())) == null || !dVar.e_renamed()) {
            return;
        }
        dVar.c_renamed();
        com.oplus.camera.ui.k_renamed.d_renamed dVar2 = this.s_renamed.get(aVarE.f_renamed());
        if (dVar2 != null) {
            dVar2.b_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(final java.lang.String str, int i_renamed) {
        if (str == null) {
            return;
        }
        final com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVarA = com.oplus.c_renamed.a_renamed.f_renamed.a_renamed(this.j_renamed, str);
        com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "insertMediaItem, mediaItem: " + aVarA + ", orientation: " + i_renamed);
        if (aVarA == null) {
            return;
        }
        if (aVarA.j_renamed()) {
            aVarA.a_renamed(i_renamed);
        }
        if (aVarA.k_renamed()) {
            java.lang.String strF = aVarA.f_renamed();
            if (!strF.substring(strF.lastIndexOf(47) + 1).contains("COVER")) {
                com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "insertMediaItem, not CShot Cover");
                return;
            }
        }
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.k_renamed.9
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.ui.k_renamed.this.o_renamed == null) {
                    com.oplus.camera.ui.k_renamed.this.o_renamed = new java.util.ArrayList();
                    com.oplus.camera.ui.k_renamed.this.m_renamed.clear();
                }
                boolean z_renamed = false;
                if (com.oplus.camera.ui.k_renamed.this.m_renamed.containsKey(str)) {
                    int iIntValue = ((java.lang.Integer) com.oplus.camera.ui.k_renamed.this.m_renamed.get(str)).intValue();
                    if (iIntValue < com.oplus.camera.ui.k_renamed.this.o_renamed.size() - 1) {
                        synchronized (com.oplus.camera.ui.k_renamed.this.p_renamed) {
                            com.oplus.camera.ui.k_renamed.this.o_renamed.set(iIntValue, aVarA);
                        }
                        com.oplus.camera.ui.k_renamed.this.notifyItemChanged(iIntValue);
                        return;
                    }
                    synchronized (com.oplus.camera.ui.k_renamed.this.p_renamed) {
                        com.oplus.camera.ui.k_renamed.this.o_renamed.set(iIntValue, aVarA);
                    }
                    z_renamed = true;
                } else {
                    com.oplus.camera.ui.k_renamed.this.d_renamed();
                    synchronized (com.oplus.camera.ui.k_renamed.this.p_renamed) {
                        com.oplus.camera.ui.k_renamed.this.o_renamed.add(aVarA);
                    }
                    com.oplus.camera.ui.k_renamed.this.m_renamed.put(str, java.lang.Integer.valueOf(com.oplus.camera.ui.k_renamed.this.o_renamed.size() - 1));
                }
                if (aVarA.j_renamed() || (!z_renamed && !aVarA.k_renamed())) {
                    android.os.Message messageObtain = android.os.Message.obtain();
                    if (com.oplus.camera.ui.k_renamed.this.t_renamed != null && com.oplus.camera.ui.k_renamed.this.t_renamed.isShown()) {
                        messageObtain.what = 1;
                        messageObtain.obj = aVarA;
                        messageObtain.arg1 = com.oplus.camera.ui.k_renamed.this.o_renamed.size() - 1;
                        messageObtain.arg2 = 1;
                        if (com.oplus.camera.ui.k_renamed.this.z_renamed == null) {
                            com.oplus.camera.ui.k_renamed.this.k_renamed();
                        }
                        if (com.oplus.camera.ui.k_renamed.this.z_renamed != null) {
                            com.oplus.camera.ui.k_renamed.this.z_renamed.sendMessage(messageObtain);
                        }
                    } else {
                        messageObtain.what = 1;
                        messageObtain.arg1 = com.oplus.camera.ui.k_renamed.this.o_renamed.size() - 1;
                        messageObtain.arg2 = 1;
                        com.oplus.camera.ui.k_renamed.this.u_renamed.sendMessage(messageObtain);
                    }
                } else if (!aVarA.k_renamed()) {
                    android.os.Message messageObtain2 = android.os.Message.obtain();
                    messageObtain2.what = 2;
                    messageObtain2.arg1 = com.oplus.camera.ui.k_renamed.this.o_renamed.size() - 1;
                    com.oplus.camera.ui.k_renamed.this.u_renamed.sendMessage(messageObtain2);
                }
                com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "insertMediaItem, size of_renamed DataList: " + com.oplus.camera.ui.k_renamed.this.o_renamed.size());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k_renamed() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("Pre Build");
        handlerThread.start();
        this.z_renamed = new com.oplus.camera.ui.k_renamed.e_renamed(handlerThread.getLooper());
    }

    private void l_renamed() {
        com.oplus.camera.ui.k_renamed.e_renamed eVar = this.z_renamed;
        if (eVar != null) {
            eVar.getLooper().quitSafely();
            this.z_renamed = null;
        }
    }

    public void d_renamed() {
        if (this.o_renamed.size() + 1 > 50) {
            this.m_renamed.remove(this.o_renamed.get(0).e_renamed());
            synchronized (this.p_renamed) {
                this.o_renamed.remove(0);
            }
            for (int i_renamed = 0; i_renamed < this.o_renamed.size(); i_renamed++) {
                this.m_renamed.put(this.o_renamed.get(i_renamed).e_renamed(), java.lang.Integer.valueOf(i_renamed));
            }
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 3;
            messageObtain.arg1 = 0;
            this.u_renamed.sendMessage(messageObtain);
        }
    }

    public void a_renamed(com.oplus.camera.ui.control.e_renamed eVar, boolean z_renamed) {
        if (z_renamed) {
            java.lang.String string = eVar.e_renamed().toString();
            this.k_renamed = eVar.h_renamed();
            java.lang.String strSubstring = string.substring(string.lastIndexOf(47) + 1);
            com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar = new com.oplus.c_renamed.a_renamed.b_renamed.a_renamed(strSubstring, "-1", android.net.Uri.parse(string), 0, 10L, false, false);
            if (this.o_renamed == null) {
                this.o_renamed = new java.util.ArrayList<>();
            }
            if (this.m_renamed.containsKey(strSubstring)) {
                return;
            }
            d_renamed();
            synchronized (this.p_renamed) {
                this.o_renamed.add(aVar);
                int size = this.o_renamed.size() - 1;
                this.m_renamed.put(strSubstring, java.lang.Integer.valueOf(size));
                android.os.Message messageObtain = android.os.Message.obtain();
                messageObtain.what = 1;
                messageObtain.arg1 = size;
                messageObtain.arg2 = 1;
                this.u_renamed.sendMessage(messageObtain);
            }
            com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "addThumbnail, uri: " + string + ", path: " + eVar.f_renamed() + ", dataList size: " + this.o_renamed.size());
        }
    }

    public com.oplus.c_renamed.a_renamed.b_renamed.a_renamed a_renamed(int i_renamed) {
        if (i_renamed >= this.o_renamed.size()) {
            return null;
        }
        return this.o_renamed.get(i_renamed);
    }

    public com.oplus.c_renamed.a_renamed.b_renamed.a_renamed e_renamed() {
        int i_renamed = i_renamed();
        java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> arrayList = this.o_renamed;
        if (arrayList == null || i_renamed >= arrayList.size() || -1 == i_renamed) {
            return null;
        }
        return this.o_renamed.get(i_renamed);
    }

    public com.oplus.c_renamed.a_renamed.b_renamed.a_renamed f_renamed() {
        java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> arrayList = this.o_renamed;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return this.o_renamed.get(r1.size() - 1);
    }

    public void g_renamed() {
        android.view.View childAt = this.t_renamed.getChildAt(0);
        if (childAt != null) {
            b_renamed(((androidx.recyclerview.widget.RecyclerView.j_renamed) childAt.getLayoutParams()).h_renamed());
        }
    }

    public void b_renamed(final int i_renamed) {
        if (this.o_renamed == null) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "removeItem, position: " + i_renamed);
        final com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar = this.o_renamed.get(i_renamed);
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.k_renamed.10
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.ui.k_renamed.this.h_renamed ? com.oplus.c_renamed.a_renamed.f_renamed.b_renamed(com.oplus.camera.ui.k_renamed.this.j_renamed, aVar) : com.oplus.c_renamed.a_renamed.f_renamed.a_renamed(com.oplus.camera.ui.k_renamed.this.j_renamed, aVar)) {
                    com.oplus.camera.ui.k_renamed.this.x_renamed.cf_renamed();
                    com.oplus.camera.ui.k_renamed.this.a_renamed(aVar, i_renamed);
                }
            }
        }, "GalleryPreviewAdapter removemediaItem");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar, final int i_renamed) {
        this.m_renamed.remove(aVar.e_renamed());
        synchronized (this.p_renamed) {
            this.o_renamed.remove(i_renamed);
        }
        for (int i2 = i_renamed; i2 < this.o_renamed.size(); i2++) {
            this.m_renamed.replace(this.o_renamed.get(i2).e_renamed(), java.lang.Integer.valueOf(i2));
        }
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.k_renamed.11
            @Override // java.lang.Runnable
            public void run() {
                android.os.Message messageObtain = android.os.Message.obtain();
                messageObtain.what = 3;
                messageObtain.arg1 = i_renamed;
                com.oplus.camera.ui.k_renamed.this.u_renamed.sendMessage(messageObtain);
                if (i_renamed >= com.oplus.camera.ui.k_renamed.this.o_renamed.size()) {
                    com.oplus.camera.ui.k_renamed.this.t_renamed.scrollToPosition(com.oplus.camera.ui.k_renamed.this.o_renamed.size() - 1);
                } else if (i_renamed == 0) {
                    com.oplus.camera.ui.k_renamed.this.t_renamed.scrollToPosition(0);
                } else {
                    com.oplus.camera.ui.k_renamed.this.t_renamed.scrollToPosition(i_renamed - 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(final android.graphics.SurfaceTexture surfaceTexture, final com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar, final com.oplus.camera.ui.k_renamed.a_renamed aVar2) {
        final android.view.Surface surface = new android.view.Surface(surfaceTexture);
        final com.oplus.c_renamed.a_renamed.d_renamed dVar = new com.oplus.c_renamed.a_renamed.d_renamed(this.j_renamed, com.oplus.c_renamed.a_renamed.d_renamed.a_renamed.TBL);
        final com.oplus.camera.ui.k_renamed.d_renamed dVar2 = new com.oplus.camera.ui.k_renamed.d_renamed(dVar, aVar2);
        synchronized (this.w_renamed) {
            this.q_renamed.put(aVar.f_renamed(), dVar);
            this.r_renamed.put(aVar.f_renamed(), surface);
            this.s_renamed.put(aVar.f_renamed(), dVar2);
        }
        aVar2.f_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.k_renamed.12
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "prepareVideoPlayer, click the block region");
            }
        });
        aVar2.g_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.k_renamed.2
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.oplus.camera.ui.k_renamed.this.v_renamed) {
                    return;
                }
                if (dVar.e_renamed()) {
                    dVar.c_renamed();
                    com.oplus.camera.ui.k_renamed.this.a_renamed(false, aVar2);
                    com.oplus.camera.ui.k_renamed.this.x_renamed.f_renamed(82, 1);
                } else {
                    dVar.f_renamed();
                    com.oplus.camera.ui.k_renamed.this.a_renamed(true, aVar2);
                    com.oplus.camera.ui.k_renamed.this.x_renamed.f_renamed(82, 2);
                }
            }
        });
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.k_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.ui.k_renamed.this.w_renamed) {
                    if (!surfaceTexture.isReleased() && surface.isValid()) {
                        dVar.a_renamed(aVar.g_renamed(), surface, dVar2);
                    }
                }
            }
        }, "GalleryPreviewAdapter prepareVideoPlayer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(final boolean z_renamed, final com.oplus.camera.ui.k_renamed.a_renamed aVar) {
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.k_renamed.4
            @Override // java.lang.Runnable
            public void run() {
                if (z_renamed) {
                    aVar.j_renamed.setText(com.oplus.camera.ui.k_renamed.this.j_renamed.getString(com.oplus.camera.R_renamed.string.pause));
                    aVar.i_renamed.setImageDrawable(androidx.core.a_renamed.a_renamed.a_renamed(com.oplus.camera.ui.k_renamed.this.j_renamed, com.oplus.camera.R_renamed.drawable.ic_video_pause));
                } else {
                    aVar.j_renamed.setText(com.oplus.camera.ui.k_renamed.this.j_renamed.getString(com.oplus.camera.R_renamed.string.play));
                    aVar.i_renamed.setImageDrawable(androidx.core.a_renamed.a_renamed.a_renamed(com.oplus.camera.ui.k_renamed.this.j_renamed, com.oplus.camera.R_renamed.drawable.ic_video_play));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str) {
        com.oplus.c_renamed.a_renamed.d_renamed dVar = this.q_renamed.get(str);
        android.view.Surface surface = this.r_renamed.get(str);
        if (dVar != null) {
            com.oplus.camera.e_renamed.a_renamed("GalleryPreviewAdapter", "releaseVideoPlayer, key: " + str);
            dVar.d_renamed();
            this.q_renamed.remove(str);
        }
        if (surface != null) {
            surface.release();
            this.r_renamed.remove(str);
        }
        this.s_renamed.remove(str);
    }

    /* compiled from: GalleryPreviewAdapter.java */
    class d_renamed implements com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed f6311b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private com.oplus.camera.ui.k_renamed.a_renamed f6312c;

        public d_renamed(com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed bVar, com.oplus.camera.ui.k_renamed.a_renamed aVar) {
            this.f6311b = bVar;
            this.f6312c = aVar;
        }

        @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed
        public void a_renamed() {
            if (!com.oplus.camera.ui.k_renamed.this.v_renamed) {
                com.oplus.camera.ui.k_renamed.this.a_renamed(true, this.f6312c);
            } else {
                this.f6311b.c_renamed();
                b_renamed();
            }
            this.f6311b.a_renamed(0.0f);
        }

        public void b_renamed() {
            com.oplus.camera.ui.k_renamed.this.a_renamed(false, this.f6312c);
        }

        @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed
        public boolean a_renamed(int i_renamed, int i2, java.lang.String str) {
            com.oplus.camera.e_renamed.f_renamed("GalleryPreviewAdapter", "onError, " + str);
            return false;
        }

        @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed
        public void c_renamed() {
            com.oplus.camera.ui.k_renamed.this.a_renamed(false, this.f6312c);
        }
    }

    private void a_renamed(java.lang.Runnable runnable, java.lang.String str) {
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(runnable, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.Runnable runnable) {
        ((android.app.Activity) this.j_renamed).runOnUiThread(runnable);
    }

    public void a_renamed(com.oplus.camera.ui.k_renamed.c_renamed cVar) {
        this.n_renamed = cVar;
    }

    /* compiled from: GalleryPreviewAdapter.java */
    protected class a_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.widget.RelativeLayout f6303b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private android.widget.ImageView f6304c;
        private android.view.TextureView d_renamed;
        private android.widget.RelativeLayout e_renamed;
        private android.widget.RelativeLayout f_renamed;
        private android.widget.RelativeLayout g_renamed;
        private com.oplus.camera.ui.inverse.InverseLinearLayout h_renamed;
        private android.widget.ImageView i_renamed;
        private android.widget.TextView j_renamed;

        public a_renamed(android.view.View view, int i_renamed) {
            super(view);
            if (4 == i_renamed) {
                return;
            }
            this.f6303b = (android.widget.RelativeLayout) view.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_image_container);
            this.f6304c = (android.widget.ImageView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_image);
            this.d_renamed = (android.view.TextureView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_surface);
            this.f_renamed = (android.widget.RelativeLayout) view.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_video_play_button_block_region);
            this.g_renamed = (android.widget.RelativeLayout) view.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_video_play_button_touch_region);
            this.h_renamed = (com.oplus.camera.ui.inverse.InverseLinearLayout) view.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_video_play_button);
            this.i_renamed = (android.widget.ImageView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_video_play_button_image);
            this.j_renamed = (android.widget.TextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_video_play_button_text);
            this.e_renamed = (android.widget.RelativeLayout) view.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_image_cshot_tag);
            this.f6303b.setClipToOutline(true);
            this.d_renamed.setClipToOutline(true);
            this.f6303b.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.k_renamed.a_renamed.1
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view2) {
                    com.oplus.camera.ui.k_renamed.this.a_renamed(view2, com.oplus.camera.ui.k_renamed.a_renamed.this.getAbsoluteAdapterPosition());
                }
            });
            this.d_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.k_renamed.a_renamed.2
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view2) {
                    com.oplus.camera.ui.k_renamed.this.a_renamed(view2, com.oplus.camera.ui.k_renamed.a_renamed.this.getAbsoluteAdapterPosition());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.view.View view, int i_renamed) {
        android.view.View viewFindViewById;
        if (this.v_renamed) {
            com.oplus.camera.util.o_renamed.a_renamed(this.j_renamed, com.oplus.camera.R_renamed.string.camera_time_lapse_pro_recording_prevent_gallery_toast);
            return;
        }
        android.graphics.Bitmap bitmapCreateBitmap = null;
        java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> arrayList = this.o_renamed;
        if (arrayList == null || i_renamed >= arrayList.size() || i_renamed <= -1) {
            return;
        }
        if (this.o_renamed.get(i_renamed).j_renamed()) {
            viewFindViewById = view.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_surface);
        } else {
            viewFindViewById = view.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_image);
        }
        if (viewFindViewById == null) {
            com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "onItemClick, current View is_renamed null");
            return;
        }
        viewFindViewById.setDrawingCacheEnabled(true);
        if (viewFindViewById.getDrawingCache() != null) {
            bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(viewFindViewById.getDrawingCache());
        } else {
            com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "onItemClick, fail to get DrawingCache, width: " + viewFindViewById.getWidth() + ", height: " + viewFindViewById.getHeight());
        }
        viewFindViewById.setDrawingCacheEnabled(false);
        this.n_renamed.a_renamed(view, bitmapCreateBitmap, i_renamed);
    }

    public void b_renamed(boolean z_renamed) {
        this.h_renamed = z_renamed;
    }

    public boolean h_renamed() {
        com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVarF;
        if (this.t_renamed == null || this.o_renamed == null || (aVarF = f_renamed()) == null) {
            return false;
        }
        return aVarF.j_renamed();
    }

    public boolean c_renamed(int i_renamed) {
        java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> arrayList = this.o_renamed;
        if (arrayList == null || i_renamed >= arrayList.size()) {
            return false;
        }
        return this.o_renamed.get(i_renamed).j_renamed();
    }

    public void a_renamed(com.oplus.camera.ui.inverse.InverseLinearLayout inverseLinearLayout) {
        if (inverseLinearLayout != null && inverseLinearLayout.getVisibility() == 0) {
            if (this.f_renamed > this.e_renamed) {
                com.oplus.camera.ui.inverse.e_renamed.INS.unRegisterInverse(this.j_renamed, inverseLinearLayout);
                inverseLinearLayout.setInverseColor(true);
            } else {
                com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.j_renamed, inverseLinearLayout);
            }
        }
    }

    public int i_renamed() {
        android.view.View childAt;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.t_renamed;
        if (recyclerView == null || (childAt = recyclerView.getChildAt(0)) == null) {
            return 0;
        }
        return ((androidx.recyclerview.widget.RecyclerView.j_renamed) childAt.getLayoutParams()).h_renamed();
    }

    /* compiled from: GalleryPreviewAdapter.java */
    private class e_renamed extends android.os.Handler {
        public e_renamed(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return;
            }
            com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar = (com.oplus.c_renamed.a_renamed.b_renamed.a_renamed) message.obj;
            com.oplus.camera.ui.k_renamed kVar = com.oplus.camera.ui.k_renamed.this;
            int iA = kVar.a_renamed(com.oplus.c_renamed.a_renamed.b_renamed.b_renamed(kVar.j_renamed, aVar, 1));
            com.oplus.camera.ui.k_renamed kVar2 = com.oplus.camera.ui.k_renamed.this;
            kVar2.l_renamed = com.oplus.c_renamed.a_renamed.b_renamed.a_renamed(kVar2.j_renamed, aVar, iA);
            com.oplus.camera.ui.k_renamed.this.y_renamed = true;
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 1;
            messageObtain.arg1 = message.arg1;
            messageObtain.arg2 = message.arg2;
            if (aVar.f_renamed().endsWith(".dng")) {
                com.oplus.camera.ui.k_renamed.this.u_renamed.sendMessageDelayed(messageObtain, 20L);
            } else {
                com.oplus.camera.ui.k_renamed.this.u_renamed.sendMessage(messageObtain);
            }
        }
    }

    /* compiled from: GalleryPreviewAdapter.java */
    private class b_renamed extends android.os.Handler {
        public b_renamed(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.oplus.camera.e_renamed.b_renamed("GalleryPreviewAdapter", "handleMessage, msg.what: " + message.what);
            int i_renamed = message.what;
            if (i_renamed != 1) {
                if (i_renamed == 2) {
                    com.oplus.camera.ui.k_renamed.this.notifyItemChanged(message.arg1);
                    return;
                } else {
                    if (i_renamed != 3) {
                        return;
                    }
                    int i2 = message.arg1;
                    com.oplus.camera.ui.k_renamed.this.notifyItemChanged(i2);
                    com.oplus.camera.ui.k_renamed.this.notifyItemRangeRemoved(i2, 1);
                    return;
                }
            }
            int i3 = message.arg1;
            int i4 = message.arg2;
            com.oplus.camera.ui.k_renamed.this.notifyItemInserted(i3);
            com.oplus.camera.ui.k_renamed kVar = com.oplus.camera.ui.k_renamed.this;
            kVar.notifyItemRangeChanged(i3, kVar.o_renamed.size() - i3);
            if (1 != i4 || com.oplus.camera.ui.k_renamed.this.t_renamed == null) {
                return;
            }
            com.oplus.camera.ui.k_renamed.this.t_renamed.scrollToPosition(i3);
        }
    }
}

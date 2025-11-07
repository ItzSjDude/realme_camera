package com.oplus.camera.ui;

/* compiled from: GalleryPreviewItemDecoration.java */
/* loaded from: classes2.dex */
public class l_renamed extends androidx.recyclerview.widget.RecyclerView.h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6314a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6315b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6316c;
    private int d_renamed;
    private android.content.Context e_renamed;

    public l_renamed(android.content.Context context, int i_renamed, int i2, int i3, int i4) {
        this.f6314a = 0;
        this.f6315b = 0;
        this.f6316c = 0;
        this.d_renamed = 0;
        this.e_renamed = null;
        this.e_renamed = context;
        this.f6314a = i_renamed;
        this.d_renamed = i3;
        this.f6315b = i2;
        this.f6316c = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h_renamed
    public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        super.getItemOffsets(rect, view, recyclerView, tVar);
        rect.left = this.f6314a;
        rect.right = this.f6315b;
        rect.top = this.f6316c;
        rect.bottom = this.d_renamed;
    }
}

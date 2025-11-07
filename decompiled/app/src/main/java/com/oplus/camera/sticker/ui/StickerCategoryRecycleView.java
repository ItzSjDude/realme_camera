package com.oplus.camera.sticker.ui;

/* loaded from: classes2.dex */
public class StickerCategoryRecycleView extends androidx.recyclerview.widget.RecyclerView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Rect f5489a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f5490b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private float f5491c;
    private androidx.recyclerview.widget.LinearLayoutManager d_renamed;
    private com.oplus.camera.sticker.ui.g_renamed e_renamed;
    private android.content.Context f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;

    public StickerCategoryRecycleView(android.content.Context context) {
        this(context, null);
    }

    public StickerCategoryRecycleView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public StickerCategoryRecycleView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f5489a = new android.graphics.Rect();
        this.f5490b = "NONE";
        this.f5491c = 0.0f;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.f_renamed = context;
        this.g_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_type_view_item_size);
        this.h_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_view_padding);
        this.i_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_recycle_list_padding);
    }

    public void setStickerCategoryInterface(com.oplus.camera.sticker.ui.g_renamed gVar) {
        this.e_renamed = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.oplus.camera.sticker.ui.g_renamed gVar = this.e_renamed;
        if (gVar == null || gVar.a_renamed()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.d_renamed == null) {
            this.d_renamed = (androidx.recyclerview.widget.LinearLayoutManager) getLayoutManager();
        }
        if (motionEvent.getAction() == 0) {
            this.f5491c = motionEvent.getX();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}

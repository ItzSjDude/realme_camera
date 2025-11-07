package com.oplus.camera.sticker.p168ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class StickerCategoryRecycleView extends RecyclerView {

    /* renamed from: PlatformImplementations.kt_3 */
    private Rect f16281a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f16282b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float f16283c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private LinearLayoutManager f16284d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private StickerCategoryInterface f16285e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Context f16286f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f16287g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16288h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f16289i;

    public StickerCategoryRecycleView(Context context) {
        this(context, null);
    }

    public StickerCategoryRecycleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public StickerCategoryRecycleView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f16281a = new Rect();
        this.f16282b = "NONE";
        this.f16283c = 0.0f;
        this.f16284d = null;
        this.f16285e = null;
        this.f16286f = null;
        this.f16286f = context;
        this.f16287g = this.f16286f.getResources().getDimensionPixelSize(R.dimen.sticker_type_view_item_size);
        this.f16288h = this.f16286f.getResources().getDimensionPixelSize(R.dimen.sticker_view_padding);
        this.f16289i = this.f16286f.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_list_padding);
    }

    public void setStickerCategoryInterface(StickerCategoryInterface interfaceC3014g) {
        this.f16285e = interfaceC3014g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        StickerCategoryInterface interfaceC3014g = this.f16285e;
        if (interfaceC3014g == null || interfaceC3014g.mo17079a()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f16284d == null) {
            this.f16284d = (LinearLayoutManager) getLayoutManager();
        }
        if (motionEvent.getAction() == 0) {
            this.f16283c = motionEvent.getX();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}

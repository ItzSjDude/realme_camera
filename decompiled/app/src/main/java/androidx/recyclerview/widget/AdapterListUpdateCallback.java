package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: AdapterListUpdateCallback.java */
/* renamed from: androidx.recyclerview.widget.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {

    /* renamed from: PlatformImplementations.kt_3 */
    private final RecyclerView.AbstractC0685a f4144a;

    public AdapterListUpdateCallback(RecyclerView.AbstractC0685a abstractC0685a) {
        this.f4144a = abstractC0685a;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4370a(int OplusGLSurfaceView_13, int i2) {
        this.f4144a.notifyItemRangeInserted(OplusGLSurfaceView_13, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo4372b(int OplusGLSurfaceView_13, int i2) {
        this.f4144a.notifyItemRangeRemoved(OplusGLSurfaceView_13, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo4373c(int OplusGLSurfaceView_13, int i2) {
        this.f4144a.notifyItemMoved(OplusGLSurfaceView_13, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4371a(int OplusGLSurfaceView_13, int i2, Object obj) {
        this.f4144a.notifyItemRangeChanged(OplusGLSurfaceView_13, i2, obj);
    }
}

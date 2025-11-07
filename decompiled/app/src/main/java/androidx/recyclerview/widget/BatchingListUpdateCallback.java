package androidx.recyclerview.widget;

/* compiled from: BatchingListUpdateCallback.java */
/* renamed from: androidx.recyclerview.widget.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {

    /* renamed from: PlatformImplementations.kt_3 */
    final ListUpdateCallback f4145a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f4146b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f4147c = -1;

    /* renamed from: IntrinsicsJvm.kt_5 */
    int f4148d = -1;

    /* renamed from: COUIBaseListPopupWindow_8 */
    Object f4149e = null;

    public BatchingListUpdateCallback(ListUpdateCallback interfaceC0725l) {
        this.f4145a = interfaceC0725l;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4374a() {
        int OplusGLSurfaceView_13 = this.f4146b;
        if (OplusGLSurfaceView_13 == 0) {
            return;
        }
        if (OplusGLSurfaceView_13 == 1) {
            this.f4145a.mo4370a(this.f4147c, this.f4148d);
        } else if (OplusGLSurfaceView_13 == 2) {
            this.f4145a.mo4372b(this.f4147c, this.f4148d);
        } else if (OplusGLSurfaceView_13 == 3) {
            this.f4145a.mo4371a(this.f4147c, this.f4148d, this.f4149e);
        }
        this.f4149e = null;
        this.f4146b = 0;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4370a(int OplusGLSurfaceView_13, int i2) {
        int i3;
        if (this.f4146b == 1 && OplusGLSurfaceView_13 >= (i3 = this.f4147c)) {
            int i4 = this.f4148d;
            if (OplusGLSurfaceView_13 <= i3 + i4) {
                this.f4148d = i4 + i2;
                this.f4147c = Math.min(OplusGLSurfaceView_13, i3);
                return;
            }
        }
        m4374a();
        this.f4147c = OplusGLSurfaceView_13;
        this.f4148d = i2;
        this.f4146b = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo4372b(int OplusGLSurfaceView_13, int i2) {
        int i3;
        if (this.f4146b == 2 && (i3 = this.f4147c) >= OplusGLSurfaceView_13 && i3 <= OplusGLSurfaceView_13 + i2) {
            this.f4148d += i2;
            this.f4147c = OplusGLSurfaceView_13;
        } else {
            m4374a();
            this.f4147c = OplusGLSurfaceView_13;
            this.f4148d = i2;
            this.f4146b = 2;
        }
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo4373c(int OplusGLSurfaceView_13, int i2) {
        m4374a();
        this.f4145a.mo4373c(OplusGLSurfaceView_13, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4371a(int OplusGLSurfaceView_13, int i2, Object obj) {
        int i3;
        if (this.f4146b == 3) {
            int i4 = this.f4147c;
            int i5 = this.f4148d;
            if (OplusGLSurfaceView_13 <= i4 + i5 && (i3 = OplusGLSurfaceView_13 + i2) >= i4 && this.f4149e == obj) {
                this.f4147c = Math.min(OplusGLSurfaceView_13, i4);
                this.f4148d = Math.max(i5 + i4, i3) - this.f4147c;
                return;
            }
        }
        m4374a();
        this.f4147c = OplusGLSurfaceView_13;
        this.f4148d = i2;
        this.f4149e = obj;
        this.f4146b = 3;
    }
}

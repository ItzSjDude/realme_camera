package p061c.p074h;

import java.util.NoSuchElementException;
import p061c.p062a.Iterators.kt_2;

/* compiled from: ProgressionIterators.kt */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public final class ProgressionIterators.kt extends Iterators.kt_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final int f5062a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f5063b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f5064c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f5065d;

    public ProgressionIterators.kt(int OplusGLSurfaceView_13, int i2, int i3) {
        this.f5065d = i3;
        this.f5062a = i2;
        boolean z = true;
        if (this.f5065d <= 0 ? OplusGLSurfaceView_13 < i2 : OplusGLSurfaceView_13 > i2) {
            z = false;
        }
        this.f5063b = z;
        this.f5064c = this.f5063b ? OplusGLSurfaceView_13 : this.f5062a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f5063b;
    }

    @Override // p061c.p062a.Iterators.kt_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo5243b() {
        int OplusGLSurfaceView_13 = this.f5064c;
        if (OplusGLSurfaceView_13 == this.f5062a) {
            if (!this.f5063b) {
                throw new NoSuchElementException();
            }
            this.f5063b = false;
        } else {
            this.f5064c = this.f5065d + OplusGLSurfaceView_13;
        }
        return OplusGLSurfaceView_13;
    }
}

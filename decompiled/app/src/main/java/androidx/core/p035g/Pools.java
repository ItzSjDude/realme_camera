package androidx.core.p035g;

/* compiled from: Pools.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_11.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public final class Pools {

    /* compiled from: Pools.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_11.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3<T> {
        /* renamed from: PlatformImplementations.kt_3 */
        T mo2532a();

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo2533a(T t);
    }

    /* compiled from: Pools.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_11.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4<T> implements PlatformImplementations.kt_3<T> {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Object[] f2939a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f2940b;

        public IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f2939a = new Object[OplusGLSurfaceView_13];
        }

        @Override // androidx.core.p035g.Pools.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public T mo2532a() {
            int OplusGLSurfaceView_13 = this.f2940b;
            if (OplusGLSurfaceView_13 <= 0) {
                return null;
            }
            int i2 = OplusGLSurfaceView_13 - 1;
            Object[] objArr = this.f2939a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.f2940b = OplusGLSurfaceView_13 - 1;
            return t;
        }

        @Override // androidx.core.p035g.Pools.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo2533a(T t) {
            if (m2534b(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int OplusGLSurfaceView_13 = this.f2940b;
            Object[] objArr = this.f2939a;
            if (OplusGLSurfaceView_13 >= objArr.length) {
                return false;
            }
            objArr[OplusGLSurfaceView_13] = t;
            this.f2940b = OplusGLSurfaceView_13 + 1;
            return true;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean m2534b(T t) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f2940b; OplusGLSurfaceView_13++) {
                if (this.f2939a[OplusGLSurfaceView_13] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: Pools.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_11.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_3 */
    public static class IntrinsicsJvm.kt_3<T> extends IntrinsicsJvm.kt_4<T> {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Object f2941a;

        public IntrinsicsJvm.kt_3(int OplusGLSurfaceView_13) {
            super(OplusGLSurfaceView_13);
            this.f2941a = new Object();
        }

        @Override // androidx.core.p035g.Pools.IntrinsicsJvm.kt_4, androidx.core.p035g.Pools.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public T mo2532a() {
            T t;
            synchronized (this.f2941a) {
                t = (T) super.mo2532a();
            }
            return t;
        }

        @Override // androidx.core.p035g.Pools.IntrinsicsJvm.kt_4, androidx.core.p035g.Pools.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo2533a(T t) {
            boolean zMo2533a;
            synchronized (this.f2941a) {
                zMo2533a = super.mo2533a(t);
            }
            return zMo2533a;
        }
    }
}

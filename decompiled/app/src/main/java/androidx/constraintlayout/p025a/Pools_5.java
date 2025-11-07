package androidx.constraintlayout.p025a;

/* compiled from: Pools.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
final class Pools_5 {

    /* compiled from: Pools.java */
    /* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    interface PlatformImplementations.kt_3<T> {
        /* renamed from: PlatformImplementations.kt_3 */
        T mo2151a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo2152a(T[] tArr, int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo2153a(T t);
    }

    /* compiled from: Pools.java */
    /* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4 */
    static class IntrinsicsJvm.kt_4<T> implements PlatformImplementations.kt_3<T> {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Object[] f2416a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f2417b;

        IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f2416a = new Object[OplusGLSurfaceView_13];
        }

        @Override // androidx.constraintlayout.p025a.Pools_5.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public T mo2151a() {
            int OplusGLSurfaceView_13 = this.f2417b;
            if (OplusGLSurfaceView_13 <= 0) {
                return null;
            }
            int i2 = OplusGLSurfaceView_13 - 1;
            Object[] objArr = this.f2416a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.f2417b = OplusGLSurfaceView_13 - 1;
            return t;
        }

        @Override // androidx.constraintlayout.p025a.Pools_5.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo2153a(T t) {
            int OplusGLSurfaceView_13 = this.f2417b;
            Object[] objArr = this.f2416a;
            if (OplusGLSurfaceView_13 >= objArr.length) {
                return false;
            }
            objArr[OplusGLSurfaceView_13] = t;
            this.f2417b = OplusGLSurfaceView_13 + 1;
            return true;
        }

        @Override // androidx.constraintlayout.p025a.Pools_5.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo2152a(T[] tArr, int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 > tArr.length) {
                OplusGLSurfaceView_13 = tArr.length;
            }
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                T t = tArr[i2];
                int i3 = this.f2417b;
                Object[] objArr = this.f2416a;
                if (i3 < objArr.length) {
                    objArr[i3] = t;
                    this.f2417b = i3 + 1;
                }
            }
        }
    }
}

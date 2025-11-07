package androidx.constraintlayout.a_renamed;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
final class g_renamed {

    /* compiled from: Pools.java */
    interface a_renamed<T_renamed> {
        T_renamed a_renamed();

        void a_renamed(T_renamed[] tArr, int i_renamed);

        boolean a_renamed(T_renamed t_renamed);
    }

    /* compiled from: Pools.java */
    static class b_renamed<T_renamed> implements androidx.constraintlayout.a_renamed.g_renamed.a_renamed<T_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.Object[] f744a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f745b;

        b_renamed(int i_renamed) {
            if (i_renamed <= 0) {
                throw new java.lang.IllegalArgumentException("The max pool size must be_renamed > 0");
            }
            this.f744a = new java.lang.Object[i_renamed];
        }

        @Override // androidx.constraintlayout.a_renamed.g_renamed.a_renamed
        public T_renamed a_renamed() {
            int i_renamed = this.f745b;
            if (i_renamed <= 0) {
                return null;
            }
            int i2 = i_renamed - 1;
            java.lang.Object[] objArr = this.f744a;
            T_renamed t_renamed = (T_renamed) objArr[i2];
            objArr[i2] = null;
            this.f745b = i_renamed - 1;
            return t_renamed;
        }

        @Override // androidx.constraintlayout.a_renamed.g_renamed.a_renamed
        public boolean a_renamed(T_renamed t_renamed) {
            int i_renamed = this.f745b;
            java.lang.Object[] objArr = this.f744a;
            if (i_renamed >= objArr.length) {
                return false;
            }
            objArr[i_renamed] = t_renamed;
            this.f745b = i_renamed + 1;
            return true;
        }

        @Override // androidx.constraintlayout.a_renamed.g_renamed.a_renamed
        public void a_renamed(T_renamed[] tArr, int i_renamed) {
            if (i_renamed > tArr.length) {
                i_renamed = tArr.length;
            }
            for (int i2 = 0; i2 < i_renamed; i2++) {
                T_renamed t_renamed = tArr[i2];
                int i3 = this.f745b;
                java.lang.Object[] objArr = this.f744a;
                if (i3 < objArr.length) {
                    objArr[i3] = t_renamed;
                    this.f745b = i3 + 1;
                }
            }
        }
    }
}

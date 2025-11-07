package androidx.core.g_renamed;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public final class e_renamed {

    /* compiled from: Pools.java */
    public interface a_renamed<T_renamed> {
        T_renamed a_renamed();

        boolean a_renamed(T_renamed t_renamed);
    }

    /* compiled from: Pools.java */
    public static class b_renamed<T_renamed> implements androidx.core.g_renamed.e_renamed.a_renamed<T_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.Object[] f920a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f921b;

        public b_renamed(int i_renamed) {
            if (i_renamed <= 0) {
                throw new java.lang.IllegalArgumentException("The max pool size must be_renamed > 0");
            }
            this.f920a = new java.lang.Object[i_renamed];
        }

        @Override // androidx.core.g_renamed.e_renamed.a_renamed
        public T_renamed a_renamed() {
            int i_renamed = this.f921b;
            if (i_renamed <= 0) {
                return null;
            }
            int i2 = i_renamed - 1;
            java.lang.Object[] objArr = this.f920a;
            T_renamed t_renamed = (T_renamed) objArr[i2];
            objArr[i2] = null;
            this.f921b = i_renamed - 1;
            return t_renamed;
        }

        @Override // androidx.core.g_renamed.e_renamed.a_renamed
        public boolean a_renamed(T_renamed t_renamed) {
            if (b_renamed(t_renamed)) {
                throw new java.lang.IllegalStateException("Already in_renamed the pool!");
            }
            int i_renamed = this.f921b;
            java.lang.Object[] objArr = this.f920a;
            if (i_renamed >= objArr.length) {
                return false;
            }
            objArr[i_renamed] = t_renamed;
            this.f921b = i_renamed + 1;
            return true;
        }

        private boolean b_renamed(T_renamed t_renamed) {
            for (int i_renamed = 0; i_renamed < this.f921b; i_renamed++) {
                if (this.f920a[i_renamed] == t_renamed) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: Pools.java */
    public static class c_renamed<T_renamed> extends androidx.core.g_renamed.e_renamed.b_renamed<T_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.Object f922a;

        public c_renamed(int i_renamed) {
            super(i_renamed);
            this.f922a = new java.lang.Object();
        }

        @Override // androidx.core.g_renamed.e_renamed.b_renamed, androidx.core.g_renamed.e_renamed.a_renamed
        public T_renamed a_renamed() {
            T_renamed t_renamed;
            synchronized (this.f922a) {
                t_renamed = (T_renamed) super.a_renamed();
            }
            return t_renamed;
        }

        @Override // androidx.core.g_renamed.e_renamed.b_renamed, androidx.core.g_renamed.e_renamed.a_renamed
        public boolean a_renamed(T_renamed t_renamed) {
            boolean zA;
            synchronized (this.f922a) {
                zA = super.a_renamed(t_renamed);
            }
            return zA;
        }
    }
}

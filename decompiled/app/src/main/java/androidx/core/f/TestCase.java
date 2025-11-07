package androidx.core.f_renamed;

/* compiled from: TextDirectionHeuristicsCompat.java */
/* loaded from: classes.dex */
public final class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final androidx.core.f_renamed.d_renamed f906a = new androidx.core.f_renamed.e_renamed.TextDirectionHeuristicsCompat_4(null, false);

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final androidx.core.f_renamed.d_renamed f907b = new androidx.core.f_renamed.e_renamed.TextDirectionHeuristicsCompat_4(null, true);

    /* renamed from: c_renamed, reason: collision with root package name */
    public static final androidx.core.f_renamed.d_renamed f908c = new androidx.core.f_renamed.e_renamed.TextDirectionHeuristicsCompat_4(androidx.core.f_renamed.e_renamed.b_renamed.f911a, false);
    public static final androidx.core.f_renamed.d_renamed d_renamed = new androidx.core.f_renamed.e_renamed.TextDirectionHeuristicsCompat_4(androidx.core.f_renamed.e_renamed.b_renamed.f911a, true);
    public static final androidx.core.f_renamed.d_renamed e_renamed = new androidx.core.f_renamed.e_renamed.TextDirectionHeuristicsCompat_4(androidx.core.f_renamed.e_renamed.a_renamed.f909a, false);
    public static final androidx.core.f_renamed.d_renamed f_renamed = androidx.core.f_renamed.e_renamed.f_renamed.f914a;

    /* compiled from: TextDirectionHeuristicsCompat.java */
    private interface c_renamed {
        int a_renamed(java.lang.CharSequence charSequence, int i_renamed, int i2);
    }

    static int a_renamed(int i_renamed) {
        if (i_renamed != 0) {
            return (i_renamed == 1 || i_renamed == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b_renamed(int i_renamed) {
        if (i_renamed != 0) {
            if (i_renamed == 1 || i_renamed == 2) {
                return 0;
            }
            switch (i_renamed) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    private static abstract class d_renamed implements androidx.core.f_renamed.d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final androidx.core.f_renamed.e_renamed.c_renamed f912a;

        protected abstract boolean a_renamed();

        d_renamed(androidx.core.f_renamed.e_renamed.c_renamed cVar) {
            this.f912a = cVar;
        }

        @Override // androidx.core.f_renamed.d_renamed
        public boolean a_renamed(java.lang.CharSequence charSequence, int i_renamed, int i2) {
            if (charSequence == null || i_renamed < 0 || i2 < 0 || charSequence.length() - i2 < i_renamed) {
                throw new java.lang.IllegalArgumentException();
            }
            if (this.f912a == null) {
                return a_renamed();
            }
            return b_renamed(charSequence, i_renamed, i2);
        }

        private boolean b_renamed(java.lang.CharSequence charSequence, int i_renamed, int i2) {
            int iA = this.f912a.a_renamed(charSequence, i_renamed, i2);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return a_renamed();
            }
            return false;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: androidx.core.f_renamed.e_renamed$e_renamed, reason: collision with other inner class name */
    private static class TextDirectionHeuristicsCompat_4 extends androidx.core.f_renamed.e_renamed.d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final boolean f913a;

        TextDirectionHeuristicsCompat_4(androidx.core.f_renamed.e_renamed.c_renamed cVar, boolean z_renamed) {
            super(cVar);
            this.f913a = z_renamed;
        }

        @Override // androidx.core.f_renamed.e_renamed.d_renamed
        protected boolean a_renamed() {
            return this.f913a;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    private static class b_renamed implements androidx.core.f_renamed.e_renamed.c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final androidx.core.f_renamed.e_renamed.b_renamed f911a = new androidx.core.f_renamed.e_renamed.b_renamed();

        @Override // androidx.core.f_renamed.e_renamed.c_renamed
        public int a_renamed(java.lang.CharSequence charSequence, int i_renamed, int i2) {
            int i3 = i2 + i_renamed;
            int iB = 2;
            while (i_renamed < i3 && iB == 2) {
                iB = androidx.core.f_renamed.e_renamed.b_renamed(java.lang.Character.getDirectionality(charSequence.charAt(i_renamed)));
                i_renamed++;
            }
            return iB;
        }

        private b_renamed() {
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    private static class a_renamed implements androidx.core.f_renamed.e_renamed.c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final androidx.core.f_renamed.e_renamed.a_renamed f909a = new androidx.core.f_renamed.e_renamed.a_renamed(true);

        /* renamed from: b_renamed, reason: collision with root package name */
        private final boolean f910b;

        @Override // androidx.core.f_renamed.e_renamed.c_renamed
        public int a_renamed(java.lang.CharSequence charSequence, int i_renamed, int i2) {
            int i3 = i2 + i_renamed;
            boolean z_renamed = false;
            while (i_renamed < i3) {
                int iA = androidx.core.f_renamed.e_renamed.a_renamed(java.lang.Character.getDirectionality(charSequence.charAt(i_renamed)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                        i_renamed++;
                        z_renamed = z_renamed;
                    } else if (!this.f910b) {
                        return 1;
                    }
                } else if (this.f910b) {
                    return 0;
                }
                z_renamed = true;
                i_renamed++;
                z_renamed = z_renamed;
            }
            if (z_renamed) {
                return this.f910b ? 1 : 0;
            }
            return 2;
        }

        private a_renamed(boolean z_renamed) {
            this.f910b = z_renamed;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    private static class f_renamed extends androidx.core.f_renamed.e_renamed.d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final androidx.core.f_renamed.e_renamed.f_renamed f914a = new androidx.core.f_renamed.e_renamed.f_renamed();

        f_renamed() {
            super(null);
        }

        @Override // androidx.core.f_renamed.e_renamed.d_renamed
        protected boolean a_renamed() {
            return androidx.core.f_renamed.f_renamed.a_renamed(java.util.Locale.getDefault()) == 1;
        }
    }
}

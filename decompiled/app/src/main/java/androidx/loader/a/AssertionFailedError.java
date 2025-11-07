package androidx.loader.a_renamed;

/* compiled from: LoaderManagerImpl.java */
/* loaded from: classes.dex */
class b_renamed extends androidx.loader.a_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static boolean f1253a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.lifecycle.h_renamed f1254b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final androidx.loader.a_renamed.b_renamed.c_renamed f1255c;

    /* compiled from: LoaderManagerImpl.java */
    public static class a_renamed<D_renamed> extends androidx.lifecycle.m_renamed<D_renamed> implements androidx.loader.b_renamed.a_renamed.Loader_2<D_renamed> {
        private final int e_renamed;
        private final android.os.Bundle f_renamed;
        private final androidx.loader.b_renamed.a_renamed<D_renamed> g_renamed;
        private androidx.lifecycle.h_renamed h_renamed;
        private androidx.loader.a_renamed.b_renamed.LoaderManagerImpl_3<D_renamed> i_renamed;
        private androidx.loader.b_renamed.a_renamed<D_renamed> j_renamed;

        androidx.loader.b_renamed.a_renamed<D_renamed> e_renamed() {
            return this.g_renamed;
        }

        @Override // androidx.lifecycle.LiveData
        protected void b_renamed() {
            if (androidx.loader.a_renamed.b_renamed.f1253a) {
                android.util.Log.v_renamed("LoaderManager", "  Starting: " + this);
            }
            this.g_renamed.a_renamed();
        }

        @Override // androidx.lifecycle.LiveData
        protected void c_renamed() {
            if (androidx.loader.a_renamed.b_renamed.f1253a) {
                android.util.Log.v_renamed("LoaderManager", "  Stopping: " + this);
            }
            this.g_renamed.e_renamed();
        }

        void f_renamed() {
            androidx.lifecycle.h_renamed hVar = this.h_renamed;
            androidx.loader.a_renamed.b_renamed.LoaderManagerImpl_3<D_renamed> c0033b = this.i_renamed;
            if (hVar == null || c0033b == null) {
                return;
            }
            super.a_renamed((androidx.lifecycle.n_renamed) c0033b);
            a_renamed(hVar, c0033b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void a_renamed(androidx.lifecycle.n_renamed<? super D_renamed> nVar) {
            super.a_renamed((androidx.lifecycle.n_renamed) nVar);
            this.h_renamed = null;
            this.i_renamed = null;
        }

        androidx.loader.b_renamed.a_renamed<D_renamed> a_renamed(boolean z_renamed) {
            if (androidx.loader.a_renamed.b_renamed.f1253a) {
                android.util.Log.v_renamed("LoaderManager", "  Destroying: " + this);
            }
            this.g_renamed.c_renamed();
            this.g_renamed.g_renamed();
            androidx.loader.a_renamed.b_renamed.LoaderManagerImpl_3<D_renamed> c0033b = this.i_renamed;
            if (c0033b != null) {
                a_renamed((androidx.lifecycle.n_renamed) c0033b);
                if (z_renamed) {
                    c0033b.b_renamed();
                }
            }
            this.g_renamed.a_renamed((androidx.loader.b_renamed.a_renamed.Loader_2) this);
            if ((c0033b != null && !c0033b.a_renamed()) || z_renamed) {
                this.g_renamed.i_renamed();
                return this.j_renamed;
            }
            return this.g_renamed;
        }

        @Override // androidx.lifecycle.m_renamed, androidx.lifecycle.LiveData
        public void a_renamed(D_renamed d_renamed) {
            super.a_renamed((androidx.loader.a_renamed.b_renamed.a_renamed<D_renamed>) d_renamed);
            androidx.loader.b_renamed.a_renamed<D_renamed> aVar = this.j_renamed;
            if (aVar != null) {
                aVar.i_renamed();
                this.j_renamed = null;
            }
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.e_renamed);
            sb.append(" : ");
            androidx.core.g_renamed.a_renamed.a_renamed(this.g_renamed, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void a_renamed(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.e_renamed);
            printWriter.print(" mArgs=");
            printWriter.println(this.f_renamed);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.g_renamed);
            this.g_renamed.a_renamed(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.i_renamed != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.i_renamed);
                this.i_renamed.a_renamed(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e_renamed().a_renamed((androidx.loader.b_renamed.a_renamed<D_renamed>) a_renamed()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(d_renamed());
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: androidx.loader.a_renamed.b_renamed$b_renamed, reason: collision with other inner class name */
    static class LoaderManagerImpl_3<D_renamed> implements androidx.lifecycle.n_renamed<D_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final androidx.loader.b_renamed.a_renamed<D_renamed> f1256a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final androidx.loader.a_renamed.a_renamed.LoaderManager_2<D_renamed> f1257b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f1258c;

        @Override // androidx.lifecycle.n_renamed
        public void a_renamed(D_renamed d_renamed) {
            if (androidx.loader.a_renamed.b_renamed.f1253a) {
                android.util.Log.v_renamed("LoaderManager", "  onLoadFinished in_renamed " + this.f1256a + ": " + this.f1256a.a_renamed((androidx.loader.b_renamed.a_renamed<D_renamed>) d_renamed));
            }
            this.f1257b.a_renamed(this.f1256a, d_renamed);
            this.f1258c = true;
        }

        boolean a_renamed() {
            return this.f1258c;
        }

        void b_renamed() {
            if (this.f1258c) {
                if (androidx.loader.a_renamed.b_renamed.f1253a) {
                    android.util.Log.v_renamed("LoaderManager", "  Resetting: " + this.f1256a);
                }
                this.f1257b.a_renamed(this.f1256a);
            }
        }

        public java.lang.String toString() {
            return this.f1257b.toString();
        }

        public void a_renamed(java.lang.String str, java.io.PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f1258c);
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    static class c_renamed extends androidx.lifecycle.q_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final androidx.lifecycle.r_renamed.a_renamed f1259a = new androidx.lifecycle.r_renamed.a_renamed() { // from class: androidx.loader.a_renamed.b_renamed.c_renamed.1
            @Override // androidx.lifecycle.r_renamed.a_renamed
            public <T_renamed extends androidx.lifecycle.q_renamed> T_renamed a_renamed(java.lang.Class<T_renamed> cls) {
                return new androidx.loader.a_renamed.b_renamed.c_renamed();
            }
        };

        /* renamed from: b_renamed, reason: collision with root package name */
        private androidx.collection.SparseArrayCompat<androidx.loader.a_renamed.b_renamed.a_renamed> f1260b = new androidx.collection.SparseArrayCompat<>();

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f1261c = false;

        c_renamed() {
        }

        static androidx.loader.a_renamed.b_renamed.c_renamed a_renamed(androidx.lifecycle.s_renamed sVar) {
            return (androidx.loader.a_renamed.b_renamed.c_renamed) new androidx.lifecycle.r_renamed(sVar, f1259a).a_renamed(androidx.loader.a_renamed.b_renamed.c_renamed.class);
        }

        void b_renamed() {
            int size = this.f1260b.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.f1260b.valueAt(i_renamed).f_renamed();
            }
        }

        @Override // androidx.lifecycle.q_renamed
        protected void a_renamed() {
            super.a_renamed();
            int size = this.f1260b.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.f1260b.valueAt(i_renamed).a_renamed(true);
            }
            this.f1260b.clear();
        }

        public void a_renamed(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
            if (this.f1260b.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                java.lang.String str2 = str + "    ";
                for (int i_renamed = 0; i_renamed < this.f1260b.size(); i_renamed++) {
                    androidx.loader.a_renamed.b_renamed.a_renamed aVarValueAt = this.f1260b.valueAt(i_renamed);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f1260b.keyAt(i_renamed));
                    printWriter.print(": ");
                    printWriter.println(aVarValueAt.toString());
                    aVarValueAt.a_renamed(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    b_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.s_renamed sVar) {
        this.f1254b = hVar;
        this.f1255c = androidx.loader.a_renamed.b_renamed.c_renamed.a_renamed(sVar);
    }

    @Override // androidx.loader.a_renamed.a_renamed
    public void a_renamed() {
        this.f1255c.b_renamed();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
        sb.append(" in_renamed ");
        androidx.core.g_renamed.a_renamed.a_renamed(this.f1254b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // androidx.loader.a_renamed.a_renamed
    @java.lang.Deprecated
    public void a_renamed(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        this.f1255c.a_renamed(str, fileDescriptor, printWriter, strArr);
    }
}

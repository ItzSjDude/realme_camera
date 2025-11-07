package androidx.dynamicanimation.a_renamed;

/* compiled from: AnimationHandler.java */
/* loaded from: classes.dex */
class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.lang.ThreadLocal<androidx.dynamicanimation.a_renamed.a_renamed> f1058a = new java.lang.ThreadLocal<>();
    private androidx.dynamicanimation.a_renamed.a_renamed.c_renamed f_renamed;
    private final androidx.collection.SimpleArrayMap<androidx.dynamicanimation.a_renamed.a_renamed.b_renamed, java.lang.Long> d_renamed = new androidx.collection.SimpleArrayMap<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    final java.util.ArrayList<androidx.dynamicanimation.a_renamed.a_renamed.b_renamed> f1059b = new java.util.ArrayList<>();
    private final androidx.dynamicanimation.a_renamed.a_renamed.AnimationHandler_3 e_renamed = new androidx.dynamicanimation.a_renamed.a_renamed.AnimationHandler_3();

    /* renamed from: c_renamed, reason: collision with root package name */
    long f1060c = 0;
    private boolean g_renamed = false;

    /* compiled from: AnimationHandler.java */
    interface b_renamed {
        boolean a_renamed(long j_renamed);
    }

    a_renamed() {
    }

    /* compiled from: AnimationHandler.java */
    /* renamed from: androidx.dynamicanimation.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    class AnimationHandler_3 {
        AnimationHandler_3() {
        }

        void a_renamed() {
            androidx.dynamicanimation.a_renamed.a_renamed.this.f1060c = android.os.SystemClock.uptimeMillis();
            androidx.dynamicanimation.a_renamed.a_renamed aVar = androidx.dynamicanimation.a_renamed.a_renamed.this;
            aVar.a_renamed(aVar.f1060c);
            if (androidx.dynamicanimation.a_renamed.a_renamed.this.f1059b.size() > 0) {
                androidx.dynamicanimation.a_renamed.a_renamed.this.b_renamed().a_renamed();
            }
        }
    }

    public static androidx.dynamicanimation.a_renamed.a_renamed a_renamed() {
        if (f1058a.get() == null) {
            f1058a.set(new androidx.dynamicanimation.a_renamed.a_renamed());
        }
        return f1058a.get();
    }

    androidx.dynamicanimation.a_renamed.a_renamed.c_renamed b_renamed() {
        if (this.f_renamed == null) {
            if (android.os.Build.VERSION.SDK_INT >= 16) {
                this.f_renamed = new androidx.dynamicanimation.a_renamed.a_renamed.e_renamed(this.e_renamed);
            } else {
                this.f_renamed = new androidx.dynamicanimation.a_renamed.a_renamed.d_renamed(this.e_renamed);
            }
        }
        return this.f_renamed;
    }

    public void a_renamed(androidx.dynamicanimation.a_renamed.a_renamed.b_renamed bVar, long j_renamed) {
        if (this.f1059b.size() == 0) {
            b_renamed().a_renamed();
        }
        if (!this.f1059b.contains(bVar)) {
            this.f1059b.add(bVar);
        }
        if (j_renamed > 0) {
            this.d_renamed.put(bVar, java.lang.Long.valueOf(android.os.SystemClock.uptimeMillis() + j_renamed));
        }
    }

    public void a_renamed(androidx.dynamicanimation.a_renamed.a_renamed.b_renamed bVar) {
        this.d_renamed.remove(bVar);
        int iIndexOf = this.f1059b.indexOf(bVar);
        if (iIndexOf >= 0) {
            this.f1059b.set(iIndexOf, null);
            this.g_renamed = true;
        }
    }

    void a_renamed(long j_renamed) {
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        for (int i_renamed = 0; i_renamed < this.f1059b.size(); i_renamed++) {
            androidx.dynamicanimation.a_renamed.a_renamed.b_renamed bVar = this.f1059b.get(i_renamed);
            if (bVar != null && b_renamed(bVar, jUptimeMillis)) {
                bVar.a_renamed(j_renamed);
            }
        }
        c_renamed();
    }

    private boolean b_renamed(androidx.dynamicanimation.a_renamed.a_renamed.b_renamed bVar, long j_renamed) {
        java.lang.Long l_renamed = this.d_renamed.get(bVar);
        if (l_renamed == null) {
            return true;
        }
        if (l_renamed.longValue() >= j_renamed) {
            return false;
        }
        this.d_renamed.remove(bVar);
        return true;
    }

    private void c_renamed() {
        if (this.g_renamed) {
            for (int size = this.f1059b.size() - 1; size >= 0; size--) {
                if (this.f1059b.get(size) == null) {
                    this.f1059b.remove(size);
                }
            }
            this.g_renamed = false;
        }
    }

    /* compiled from: AnimationHandler.java */
    private static class e_renamed extends androidx.dynamicanimation.a_renamed.a_renamed.c_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.view.Choreographer f1066b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final android.view.Choreographer.FrameCallback f1067c;

        e_renamed(androidx.dynamicanimation.a_renamed.a_renamed.AnimationHandler_3 c0027a) {
            super(c0027a);
            this.f1066b = android.view.Choreographer.getInstance();
            this.f1067c = new android.view.Choreographer.FrameCallback() { // from class: androidx.dynamicanimation.a_renamed.a_renamed.e_renamed.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j_renamed) {
                    androidx.dynamicanimation.a_renamed.a_renamed.e_renamed.this.f1062a.a_renamed();
                }
            };
        }

        @Override // androidx.dynamicanimation.a_renamed.a_renamed.c_renamed
        void a_renamed() {
            this.f1066b.postFrameCallback(this.f1067c);
        }
    }

    /* compiled from: AnimationHandler.java */
    private static class d_renamed extends androidx.dynamicanimation.a_renamed.a_renamed.c_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        long f1063b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final java.lang.Runnable f1064c;
        private final android.os.Handler d_renamed;

        d_renamed(androidx.dynamicanimation.a_renamed.a_renamed.AnimationHandler_3 c0027a) {
            super(c0027a);
            this.f1063b = -1L;
            this.f1064c = new java.lang.Runnable() { // from class: androidx.dynamicanimation.a_renamed.a_renamed.d_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    androidx.dynamicanimation.a_renamed.a_renamed.d_renamed.this.f1063b = android.os.SystemClock.uptimeMillis();
                    androidx.dynamicanimation.a_renamed.a_renamed.d_renamed.this.f1062a.a_renamed();
                }
            };
            this.d_renamed = new android.os.Handler(android.os.Looper.myLooper());
        }

        @Override // androidx.dynamicanimation.a_renamed.a_renamed.c_renamed
        void a_renamed() {
            this.d_renamed.postDelayed(this.f1064c, java.lang.Math.max(10 - (android.os.SystemClock.uptimeMillis() - this.f1063b), 0L));
        }
    }

    /* compiled from: AnimationHandler.java */
    static abstract class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final androidx.dynamicanimation.a_renamed.a_renamed.AnimationHandler_3 f1062a;

        abstract void a_renamed();

        c_renamed(androidx.dynamicanimation.a_renamed.a_renamed.AnimationHandler_3 c0027a) {
            this.f1062a = c0027a;
        }
    }
}

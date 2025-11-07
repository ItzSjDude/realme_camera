package com.a_renamed.a_renamed;

/* compiled from: AndroidSpringLooperFactory.java */
/* loaded from: classes.dex */
abstract class a_renamed {
    public static com.a_renamed.a_renamed.i_renamed a_renamed() {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return com.a_renamed.a_renamed.a_renamed.AndroidSpringLooperFactory_3.a_renamed();
        }
        return com.a_renamed.a_renamed.a_renamed.b_renamed.a_renamed();
    }

    /* compiled from: AndroidSpringLooperFactory.java */
    private static class b_renamed extends com.a_renamed.a_renamed.i_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.os.Handler f1958b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final java.lang.Runnable f1959c = new java.lang.Runnable() { // from class: com.a_renamed.a_renamed.a_renamed.b_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                if (!com.a_renamed.a_renamed.a_renamed.b_renamed.this.d_renamed || com.a_renamed.a_renamed.a_renamed.b_renamed.this.f1975a == null) {
                    return;
                }
                long jUptimeMillis = android.os.SystemClock.uptimeMillis();
                com.a_renamed.a_renamed.a_renamed.b_renamed.this.f1975a.b_renamed(jUptimeMillis - com.a_renamed.a_renamed.a_renamed.b_renamed.this.e_renamed);
                com.a_renamed.a_renamed.a_renamed.b_renamed.this.e_renamed = jUptimeMillis;
                com.a_renamed.a_renamed.a_renamed.b_renamed.this.f1958b.post(com.a_renamed.a_renamed.a_renamed.b_renamed.this.f1959c);
            }
        };
        private boolean d_renamed;
        private long e_renamed;

        public static com.a_renamed.a_renamed.i_renamed a_renamed() {
            return new com.a_renamed.a_renamed.a_renamed.b_renamed(new android.os.Handler());
        }

        public b_renamed(android.os.Handler handler) {
            this.f1958b = handler;
        }

        @Override // com.a_renamed.a_renamed.i_renamed
        public void b_renamed() {
            if (this.d_renamed) {
                return;
            }
            this.d_renamed = true;
            this.e_renamed = android.os.SystemClock.uptimeMillis();
            this.f1958b.removeCallbacks(this.f1959c);
            this.f1958b.post(this.f1959c);
        }

        @Override // com.a_renamed.a_renamed.i_renamed
        public void c_renamed() {
            this.d_renamed = false;
            this.f1958b.removeCallbacks(this.f1959c);
        }
    }

    /* compiled from: AndroidSpringLooperFactory.java */
    @android.annotation.TargetApi(16)
    /* renamed from: com.a_renamed.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private static class AndroidSpringLooperFactory_3 extends com.a_renamed.a_renamed.i_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.view.Choreographer f1955b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final android.view.Choreographer.FrameCallback f1956c = new android.view.Choreographer.FrameCallback() { // from class: com.a_renamed.a_renamed.a_renamed.a_renamed.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j_renamed) {
                if (!com.a_renamed.a_renamed.a_renamed.AndroidSpringLooperFactory_3.this.d_renamed || com.a_renamed.a_renamed.a_renamed.AndroidSpringLooperFactory_3.this.f1975a == null) {
                    return;
                }
                long jUptimeMillis = android.os.SystemClock.uptimeMillis();
                com.a_renamed.a_renamed.a_renamed.AndroidSpringLooperFactory_3.this.f1975a.b_renamed(jUptimeMillis - com.a_renamed.a_renamed.a_renamed.AndroidSpringLooperFactory_3.this.e_renamed);
                com.a_renamed.a_renamed.a_renamed.AndroidSpringLooperFactory_3.this.e_renamed = jUptimeMillis;
                com.a_renamed.a_renamed.a_renamed.AndroidSpringLooperFactory_3.this.f1955b.postFrameCallback(com.a_renamed.a_renamed.a_renamed.AndroidSpringLooperFactory_3.this.f1956c);
            }
        };
        private boolean d_renamed;
        private long e_renamed;

        public static com.a_renamed.a_renamed.a_renamed.AndroidSpringLooperFactory_3 a_renamed() {
            return new com.a_renamed.a_renamed.a_renamed.AndroidSpringLooperFactory_3(android.view.Choreographer.getInstance());
        }

        public AndroidSpringLooperFactory_3(android.view.Choreographer choreographer) {
            this.f1955b = choreographer;
        }

        @Override // com.a_renamed.a_renamed.i_renamed
        public void b_renamed() {
            if (this.d_renamed) {
                return;
            }
            this.d_renamed = true;
            this.e_renamed = android.os.SystemClock.uptimeMillis();
            this.f1955b.removeFrameCallback(this.f1956c);
            this.f1955b.postFrameCallback(this.f1956c);
        }

        @Override // com.a_renamed.a_renamed.i_renamed
        public void c_renamed() {
            this.d_renamed = false;
            this.f1955b.removeFrameCallback(this.f1956c);
        }
    }
}

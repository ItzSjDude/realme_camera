package com.oplus.camera;

/* compiled from: GestureEngineManager.java */
/* loaded from: classes2.dex */
public class o_renamed implements java.io.Closeable {
    private com.crunchfish.touchless_a3d.TouchlessA3D d_renamed;
    private com.crunchfish.touchless_a3d.gesture.Gesture e_renamed;
    private android.content.Context i_renamed;
    private com.oplus.camera.o_renamed.c_renamed o_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.concurrent.ExecutorService f4900a = java.util.concurrent.Executors.newSingleThreadExecutor();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Object f4901b = new java.lang.Object();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.crunchfish.touchless_a3d.gesture.Gesture.Listener f4902c = new com.crunchfish.touchless_a3d.gesture.Gesture.Listener() { // from class: com.oplus.camera.o_renamed.1
        @Override // com.crunchfish.touchless_a3d.gesture.Gesture.Listener
        public void onEvent(com.crunchfish.touchless_a3d.gesture.Event event) {
            com.crunchfish.touchless_a3d.gesture.Pose pose;
            com.oplus.camera.e_renamed.a_renamed("GestureEngineManager", "GestureListener, onEvent, text: " + event.getText());
            synchronized (com.oplus.camera.o_renamed.this.f4901b) {
                if (com.oplus.camera.o_renamed.this.o_renamed == null) {
                    return;
                }
                if (com.oplus.camera.o_renamed.this.a_renamed(event, "open_hand") && (pose = (com.crunchfish.touchless_a3d.gesture.Pose) event.getIdentifiable("the_hand")) != null) {
                    com.oplus.camera.o_renamed.this.o_renamed.a_renamed(pose.getBoundingArea());
                }
            }
        }
    };
    private java.lang.Object f_renamed = new java.lang.Object();
    private boolean g_renamed = false;
    private boolean h_renamed = false;
    private android.os.AsyncTask j_renamed = null;
    private android.os.AsyncTask k_renamed = null;
    private java.util.HashMap<java.lang.Integer, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate> l_renamed = new java.util.HashMap<>();
    private java.util.HashMap<java.lang.Integer, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate> m_renamed = new java.util.HashMap<>();
    private java.util.HashMap<java.lang.Integer, java.util.HashMap<java.lang.Integer, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate>> n_renamed = new java.util.HashMap<>();

    /* compiled from: GestureEngineManager.java */
    public interface c_renamed {
        void a_renamed(android.graphics.Rect rect);
    }

    public o_renamed() {
        this.l_renamed.put(-1, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate.ROTATE_270);
        this.l_renamed.put(0, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate.ROTATE_270);
        this.l_renamed.put(90, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate.ROTATE_180);
        this.l_renamed.put(180, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate.ROTATE_90);
        this.l_renamed.put(270, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate.DO_NOT_ROTATE);
        this.m_renamed.put(-1, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate.ROTATE_90);
        this.m_renamed.put(0, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate.ROTATE_90);
        this.m_renamed.put(90, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate.ROTATE_180);
        this.m_renamed.put(180, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate.ROTATE_270);
        this.m_renamed.put(270, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate.DO_NOT_ROTATE);
        this.n_renamed.put(0, this.m_renamed);
        this.n_renamed.put(1, this.l_renamed);
    }

    public void a_renamed(android.content.Context context, int i_renamed, int i2) {
        this.g_renamed = true;
        this.j_renamed = new com.oplus.camera.o_renamed.a_renamed(context, i_renamed, i2).executeOnExecutor(this.f4900a, new java.lang.Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a_renamed(com.crunchfish.touchless_a3d.gesture.Event event, java.lang.String str) {
        return event.getText().equals(str);
    }

    public void a_renamed(com.oplus.camera.o_renamed.c_renamed cVar) {
        synchronized (this.f4901b) {
            this.o_renamed = cVar;
        }
    }

    public void a_renamed(boolean z_renamed) {
        this.h_renamed = z_renamed;
    }

    public boolean a_renamed() {
        return this.h_renamed;
    }

    public void a_renamed(byte[] bArr, int i_renamed, int i2) {
        synchronized (this.f_renamed) {
            if (this.d_renamed != null) {
                this.d_renamed.handleImage(java.lang.System.currentTimeMillis(), bArr, this.n_renamed.get(java.lang.Integer.valueOf(i_renamed)).get(java.lang.Integer.valueOf(i2)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e_renamed() {
        synchronized (this.f_renamed) {
            if (this.e_renamed != null) {
                this.e_renamed.unregisterListener(this.f4902c);
            }
            if (this.d_renamed != null) {
                this.d_renamed.unregisterGesture(this.e_renamed);
                this.d_renamed.close();
                com.oplus.camera.e_renamed.a_renamed("GestureEngineManager", "gesture detect engine has released");
            }
            this.e_renamed = null;
            this.d_renamed = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.g_renamed = false;
        synchronized (this.f4901b) {
            this.o_renamed = null;
        }
        this.k_renamed = new com.oplus.camera.o_renamed.b_renamed().executeOnExecutor(this.f4900a, new java.lang.Void[0]);
    }

    public boolean b_renamed() {
        return this.g_renamed;
    }

    public void c_renamed() {
        android.os.AsyncTask asyncTask = this.j_renamed;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.j_renamed = null;
        }
        android.os.AsyncTask asyncTask2 = this.k_renamed;
        if (asyncTask2 != null) {
            asyncTask2.cancel(true);
            this.k_renamed = null;
        }
    }

    public void d_renamed() {
        java.util.HashMap<java.lang.Integer, java.util.HashMap<java.lang.Integer, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate>> map = this.n_renamed;
        if (map != null) {
            map.clear();
            this.n_renamed = null;
        }
        java.util.HashMap<java.lang.Integer, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate> map2 = this.m_renamed;
        if (map2 != null) {
            map2.clear();
            this.m_renamed = null;
        }
        java.util.HashMap<java.lang.Integer, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate> map3 = this.l_renamed;
        if (map3 != null) {
            map3.clear();
            this.l_renamed = null;
        }
        this.i_renamed = null;
        synchronized (this.f4901b) {
            this.o_renamed = null;
        }
    }

    /* compiled from: GestureEngineManager.java */
    private class b_renamed extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Void> {
        private b_renamed() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public java.lang.Void doInBackground(java.lang.Void... voidArr) {
            com.oplus.camera.o_renamed.this.e_renamed();
            return null;
        }
    }

    /* compiled from: GestureEngineManager.java */
    private class a_renamed extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Void> {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int f4905b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final int f4906c;
        private boolean d_renamed = true;

        public a_renamed(android.content.Context context, int i_renamed, int i2) {
            com.oplus.camera.o_renamed.this.i_renamed = context;
            this.f4905b = i_renamed;
            this.f4906c = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public java.lang.Void doInBackground(java.lang.Void... voidArr) {
            com.oplus.camera.o_renamed.this.e_renamed();
            if (com.oplus.camera.o_renamed.this.i_renamed == null) {
                return null;
            }
            try {
                com.oplus.camera.o_renamed.this.d_renamed = new com.crunchfish.touchless_a3d.TouchlessA3D(this.f4905b, this.f4906c, com.oplus.camera.o_renamed.this.i_renamed);
                com.oplus.camera.o_renamed.this.d_renamed.setParameter(1002, 1);
                com.oplus.camera.e_renamed.a_renamed("GestureEngineManager", "gesture detect engine has be_renamed inited mImageWidth:" + this.f4905b + " mImageHeight:" + this.f4906c);
                try {
                    com.oplus.camera.o_renamed.this.e_renamed = a_renamed("hand_wink.json");
                    if (com.oplus.camera.o_renamed.this.e_renamed != null) {
                        com.oplus.camera.o_renamed.this.e_renamed.registerListener(com.oplus.camera.o_renamed.this.f4902c);
                        com.oplus.camera.o_renamed.this.d_renamed.registerGesture(com.oplus.camera.o_renamed.this.e_renamed);
                    }
                    return null;
                } catch (java.io.IOException e_renamed) {
                    com.oplus.camera.e_renamed.f_renamed("GestureEngineManager", "GestureEngineLoadTask IOException: " + e_renamed);
                    return null;
                }
            } catch (com.crunchfish.touchless_a3d.exception.LicenseNotValidException e2) {
                com.oplus.camera.e_renamed.f_renamed("GestureEngineManager", "GestureEngineLoadTask LicenseNotValidException: " + e2);
                this.d_renamed = false;
                return null;
            } catch (com.crunchfish.touchless_a3d.exception.LicenseServerUnavailableException e3) {
                com.oplus.camera.e_renamed.f_renamed("GestureEngineManager", "GestureEngineLoadTask LicenseServerUnavailableException: " + e3);
                this.d_renamed = false;
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B_renamed:10:0x001f A_renamed[PHI: r5 r6
          0x001f: PHI (r5v8 'this' ??) = (r5v5 'this' ??), (r5v12 'this' ??) binds: [B_renamed:20:0x0044, B_renamed:9:0x001d] A_renamed[DONT_GENERATE, DONT_INLINE]
          0x001f: PHI (r6v7 byte[]) = (r6v5 byte[]), (r6v11 byte[]) binds: [B_renamed:20:0x0044, B_renamed:9:0x001d] A_renamed[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x0054 A_renamed[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B_renamed:28:0x0058  */
        /* JADX WARN: Type inference failed for: r5v0, types: [com.oplus.camera.o_renamed$a_renamed] */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v12, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v3, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v6 */
        /* JADX WARN: Type inference failed for: r5v8, types: [java.io.InputStream] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private com.crunchfish.touchless_a3d.gesture.Gesture a_renamed(java.lang.String r6) throws java.lang.Throwable {
            /*
                r5 = this;
                r0 = 0
                com.oplus.camera.o_renamed r5 = com.oplus.camera.o_renamed.this     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
                android.content.Context r5 = com.oplus.camera.o_renamed.d_renamed(r5)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
                android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
                java.io.InputStream r5 = r5.open(r6)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
                int r6 = r5.available()     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L55
                byte[] r6 = new byte[r6]     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L55
                int r1 = r5.read(r6)     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L55
                r2 = -1
                if (r2 != r1) goto L1d
                r6 = r0
            L1d:
                if (r5 == 0) goto L47
            L1f:
                r5.close()
                goto L47
            L23:
                r1 = move-exception
                goto L2e
            L25:
                r1 = move-exception
                r6 = r0
                goto L2e
            L28:
                r6 = move-exception
                r5 = r0
                goto L56
            L2b:
                r1 = move-exception
                r5 = r0
                r6 = r5
            L2e:
                java.lang.String r2 = "GestureEngineManager"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55
                r3.<init>()     // Catch: java.lang.Throwable -> L55
                java.lang.String r4 = "readGestureJson Exception: "
                r3.append(r4)     // Catch: java.lang.Throwable -> L55
                r3.append(r1)     // Catch: java.lang.Throwable -> L55
                java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L55
                com.oplus.camera.e_renamed.f_renamed(r2, r1)     // Catch: java.lang.Throwable -> L55
                if (r5 == 0) goto L47
                goto L1f
            L47:
                if (r6 == 0) goto L54
                com.crunchfish.touchless_a3d.gesture.Gesture r5 = new com.crunchfish.touchless_a3d.gesture.Gesture
                java.lang.String r0 = new java.lang.String
                r0.<init>(r6)
                r5.<init>(r0)
                return r5
            L54:
                return r0
            L55:
                r6 = move-exception
            L56:
                if (r5 == 0) goto L5b
                r5.close()
            L5b:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.o_renamed.a_renamed.a_renamed(java.lang.String):com.crunchfish.touchless_a3d.gesture.Gesture");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(java.lang.Void r1) {
            if (this.d_renamed) {
                return;
            }
            com.oplus.camera.e_renamed.f_renamed("GestureEngineManager", "Gesture engine init fail");
        }
    }
}

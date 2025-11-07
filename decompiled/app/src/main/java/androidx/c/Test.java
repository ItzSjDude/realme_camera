package androidx.c_renamed;

/* compiled from: HeifWriter.java */
/* loaded from: classes.dex */
public final class d_renamed implements java.lang.AutoCloseable {

    /* renamed from: a_renamed, reason: collision with root package name */
    int f677a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final int f678b;

    /* renamed from: c_renamed, reason: collision with root package name */
    final int f679c;
    final int d_renamed;
    android.media.MediaMuxer f_renamed;
    int[] h_renamed;
    int i_renamed;
    private final int j_renamed;
    private final android.os.HandlerThread k_renamed;
    private final android.os.Handler l_renamed;
    private androidx.c_renamed.c_renamed m_renamed;
    private boolean n_renamed;
    final androidx.c_renamed.d_renamed.c_renamed e_renamed = new androidx.c_renamed.d_renamed.c_renamed();
    final java.util.concurrent.atomic.AtomicBoolean g_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final java.util.List<android.util.Pair<java.lang.Integer, java.nio.ByteBuffer>> o_renamed = new java.util.ArrayList();

    /* compiled from: HeifWriter.java */
    public static final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.String f681a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final java.io.FileDescriptor f682b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final int f683c;
        private final int d_renamed;
        private final int e_renamed;
        private boolean f_renamed;
        private int g_renamed;
        private int h_renamed;
        private int i_renamed;
        private int j_renamed;
        private android.os.Handler k_renamed;

        public a_renamed(java.io.FileDescriptor fileDescriptor, int i_renamed, int i2, int i3) {
            this(null, fileDescriptor, i_renamed, i2, i3);
        }

        private a_renamed(java.lang.String str, java.io.FileDescriptor fileDescriptor, int i_renamed, int i2, int i3) {
            this.f_renamed = true;
            this.g_renamed = 100;
            this.h_renamed = 1;
            this.i_renamed = 0;
            this.j_renamed = 0;
            if (i_renamed <= 0 || i2 <= 0) {
                throw new java.lang.IllegalArgumentException("Invalid image size: " + i_renamed + "x_renamed" + i2);
            }
            this.f681a = str;
            this.f682b = fileDescriptor;
            this.f683c = i_renamed;
            this.d_renamed = i2;
            this.e_renamed = i3;
        }

        public androidx.c_renamed.d_renamed.a_renamed a_renamed(int i_renamed) {
            if (i_renamed != 0 && i_renamed != 90 && i_renamed != 180 && i_renamed != 270) {
                throw new java.lang.IllegalArgumentException("Invalid rotation angle: " + i_renamed);
            }
            this.j_renamed = i_renamed;
            return this;
        }

        public androidx.c_renamed.d_renamed.a_renamed a_renamed(boolean z_renamed) {
            this.f_renamed = z_renamed;
            return this;
        }

        public androidx.c_renamed.d_renamed.a_renamed b_renamed(int i_renamed) {
            if (i_renamed < 0 || i_renamed > 100) {
                throw new java.lang.IllegalArgumentException("Invalid quality: " + i_renamed);
            }
            this.g_renamed = i_renamed;
            return this;
        }

        public androidx.c_renamed.d_renamed.a_renamed c_renamed(int i_renamed) {
            if (i_renamed <= 0) {
                throw new java.lang.IllegalArgumentException("Invalid maxImage: " + i_renamed);
            }
            this.h_renamed = i_renamed;
            return this;
        }

        public androidx.c_renamed.d_renamed.a_renamed d_renamed(int i_renamed) {
            if (i_renamed < 0) {
                throw new java.lang.IllegalArgumentException("Invalid primaryIndex: " + i_renamed);
            }
            this.i_renamed = i_renamed;
            return this;
        }

        public androidx.c_renamed.d_renamed.a_renamed a_renamed(android.os.Handler handler) {
            this.k_renamed = handler;
            return this;
        }

        public androidx.c_renamed.d_renamed a_renamed() throws java.io.IOException {
            return new androidx.c_renamed.d_renamed(this.f681a, this.f682b, this.f683c, this.d_renamed, this.j_renamed, this.f_renamed, this.g_renamed, this.h_renamed, this.i_renamed, this.e_renamed, this.k_renamed);
        }
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    d_renamed(java.lang.String str, java.io.FileDescriptor fileDescriptor, int i_renamed, int i2, int i3, boolean z_renamed, int i4, int i5, int i6, int i7, android.os.Handler handler) throws java.io.IOException {
        if (i6 >= i5) {
            throw new java.lang.IllegalArgumentException("Invalid maxImages (" + i5 + ") or primaryIndex (" + i6 + ")");
        }
        this.f677a = 1;
        this.f678b = i3;
        this.j_renamed = i7;
        this.f679c = i5;
        this.d_renamed = i6;
        android.os.Looper looper = handler != null ? handler.getLooper() : null;
        if (looper == null) {
            this.k_renamed = new android.os.HandlerThread("HeifEncoderThread", -2);
            this.k_renamed.start();
            looper = this.k_renamed.getLooper();
        } else {
            this.k_renamed = null;
        }
        this.l_renamed = new android.os.Handler(looper);
        this.f_renamed = str != null ? new android.media.MediaMuxer(str, 3) : new android.media.MediaMuxer(fileDescriptor, 3);
        this.m_renamed = new androidx.c_renamed.c_renamed(i_renamed, i2, z_renamed, i4, this.j_renamed, this.l_renamed, new androidx.c_renamed.d_renamed.b_renamed());
    }

    public void a_renamed() {
        a_renamed(false);
        this.n_renamed = true;
        this.m_renamed.a_renamed();
    }

    public void a_renamed(android.graphics.Bitmap bitmap) {
        b_renamed(2);
        synchronized (this) {
            if (this.m_renamed != null) {
                this.m_renamed.a_renamed(bitmap);
            }
        }
    }

    public void a_renamed(int i_renamed, byte[] bArr, int i2, int i3) {
        a_renamed(true);
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(i3);
        byteBufferAllocateDirect.put(bArr, i2, i3);
        byteBufferAllocateDirect.flip();
        synchronized (this.o_renamed) {
            this.o_renamed.add(new android.util.Pair<>(java.lang.Integer.valueOf(i_renamed), byteBufferAllocateDirect));
        }
        b_renamed();
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    void b_renamed() {
        android.util.Pair<java.lang.Integer, java.nio.ByteBuffer> pairRemove;
        if (!this.g_renamed.get()) {
            return;
        }
        while (true) {
            synchronized (this.o_renamed) {
                if (this.o_renamed.isEmpty()) {
                    return;
                } else {
                    pairRemove = this.o_renamed.remove(0);
                }
            }
            android.media.MediaCodec.BufferInfo bufferInfo = new android.media.MediaCodec.BufferInfo();
            bufferInfo.set(((java.nio.ByteBuffer) pairRemove.second).position(), ((java.nio.ByteBuffer) pairRemove.second).remaining(), 0L, 16);
            this.f_renamed.writeSampleData(this.h_renamed[((java.lang.Integer) pairRemove.first).intValue()], (java.nio.ByteBuffer) pairRemove.second, bufferInfo);
        }
    }

    public void a_renamed(long j_renamed) throws java.lang.Exception {
        a_renamed(true);
        synchronized (this) {
            if (this.m_renamed != null) {
                this.m_renamed.b_renamed();
            }
        }
        this.e_renamed.a_renamed(j_renamed);
        b_renamed();
        c_renamed();
    }

    private void a_renamed(boolean z_renamed) {
        if (this.n_renamed != z_renamed) {
            throw new java.lang.IllegalStateException("Already started");
        }
    }

    private void a_renamed(int i_renamed) {
        if (this.j_renamed == i_renamed) {
            return;
        }
        throw new java.lang.IllegalStateException("Not valid in_renamed input mode " + this.j_renamed);
    }

    private void b_renamed(int i_renamed) {
        a_renamed(true);
        a_renamed(i_renamed);
    }

    void c_renamed() {
        android.media.MediaMuxer mediaMuxer = this.f_renamed;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
            this.f_renamed.release();
            this.f_renamed = null;
        }
        androidx.c_renamed.c_renamed cVar = this.m_renamed;
        if (cVar != null) {
            cVar.close();
            synchronized (this) {
                this.m_renamed = null;
            }
        }
    }

    /* compiled from: HeifWriter.java */
    class b_renamed extends androidx.c_renamed.c_renamed.a_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f685b;

        b_renamed() {
        }

        @Override // androidx.c_renamed.c_renamed.a_renamed
        public void a_renamed(androidx.c_renamed.c_renamed cVar, android.media.MediaFormat mediaFormat) {
            if (this.f685b) {
                return;
            }
            if (androidx.c_renamed.d_renamed.this.h_renamed != null) {
                a_renamed(new java.lang.IllegalStateException("Output format changed after muxer started"));
                return;
            }
            try {
                androidx.c_renamed.d_renamed.this.f677a = mediaFormat.getInteger("grid-rows") * mediaFormat.getInteger("grid-cols");
            } catch (java.lang.ClassCastException | java.lang.NullPointerException unused) {
                androidx.c_renamed.d_renamed.this.f677a = 1;
            }
            androidx.c_renamed.d_renamed dVar = androidx.c_renamed.d_renamed.this;
            dVar.h_renamed = new int[dVar.f679c];
            if (androidx.c_renamed.d_renamed.this.f678b > 0) {
                android.util.Log.d_renamed("HeifWriter", "setting rotation: " + androidx.c_renamed.d_renamed.this.f678b);
                androidx.c_renamed.d_renamed.this.f_renamed.setOrientationHint(androidx.c_renamed.d_renamed.this.f678b);
            }
            int i_renamed = 0;
            while (i_renamed < androidx.c_renamed.d_renamed.this.h_renamed.length) {
                mediaFormat.setInteger("is_renamed-default", i_renamed == androidx.c_renamed.d_renamed.this.d_renamed ? 1 : 0);
                androidx.c_renamed.d_renamed.this.h_renamed[i_renamed] = androidx.c_renamed.d_renamed.this.f_renamed.addTrack(mediaFormat);
                i_renamed++;
            }
            androidx.c_renamed.d_renamed.this.f_renamed.start();
            androidx.c_renamed.d_renamed.this.g_renamed.set(true);
            androidx.c_renamed.d_renamed.this.b_renamed();
        }

        @Override // androidx.c_renamed.c_renamed.a_renamed
        public void a_renamed(androidx.c_renamed.c_renamed cVar, java.nio.ByteBuffer byteBuffer) {
            if (this.f685b) {
                return;
            }
            if (androidx.c_renamed.d_renamed.this.h_renamed == null) {
                a_renamed(new java.lang.IllegalStateException("Output buffer received before format info"));
                return;
            }
            if (androidx.c_renamed.d_renamed.this.i_renamed < androidx.c_renamed.d_renamed.this.f679c * androidx.c_renamed.d_renamed.this.f677a) {
                android.media.MediaCodec.BufferInfo bufferInfo = new android.media.MediaCodec.BufferInfo();
                bufferInfo.set(byteBuffer.position(), byteBuffer.remaining(), 0L, 0);
                androidx.c_renamed.d_renamed.this.f_renamed.writeSampleData(androidx.c_renamed.d_renamed.this.h_renamed[androidx.c_renamed.d_renamed.this.i_renamed / androidx.c_renamed.d_renamed.this.f677a], byteBuffer, bufferInfo);
            }
            androidx.c_renamed.d_renamed.this.i_renamed++;
            if (androidx.c_renamed.d_renamed.this.i_renamed == androidx.c_renamed.d_renamed.this.f679c * androidx.c_renamed.d_renamed.this.f677a) {
                a_renamed((java.lang.Exception) null);
            }
        }

        @Override // androidx.c_renamed.c_renamed.a_renamed
        public void a_renamed(androidx.c_renamed.c_renamed cVar) {
            a_renamed((java.lang.Exception) null);
        }

        @Override // androidx.c_renamed.c_renamed.a_renamed
        public void a_renamed(androidx.c_renamed.c_renamed cVar, android.media.MediaCodec.CodecException codecException) {
            a_renamed(codecException);
        }

        private void a_renamed(java.lang.Exception exc) {
            if (this.f685b) {
                return;
            }
            this.f685b = true;
            androidx.c_renamed.d_renamed.this.e_renamed.a_renamed(exc);
        }
    }

    /* compiled from: HeifWriter.java */
    static class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private boolean f686a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.Exception f687b;

        c_renamed() {
        }

        synchronized void a_renamed(long j_renamed) throws java.lang.Exception {
            if (j_renamed < 0) {
                throw new java.lang.IllegalArgumentException("timeoutMs is_renamed negative");
            }
            if (j_renamed == 0) {
                while (!this.f686a) {
                    try {
                        wait();
                    } catch (java.lang.InterruptedException unused) {
                    }
                }
            } else {
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                while (!this.f686a && j_renamed > 0) {
                    try {
                        wait(j_renamed);
                    } catch (java.lang.InterruptedException unused2) {
                    }
                    j_renamed -= java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
                }
            }
            if (!this.f686a) {
                this.f686a = true;
                this.f687b = new java.util.concurrent.TimeoutException("timed out waiting for result");
            }
            if (this.f687b != null) {
                throw this.f687b;
            }
        }

        synchronized void a_renamed(java.lang.Exception exc) {
            if (!this.f686a) {
                this.f686a = true;
                this.f687b = exc;
                notifyAll();
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.l_renamed.postAtFrontOfQueue(new java.lang.Runnable() { // from class: androidx.c_renamed.d_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    androidx.c_renamed.d_renamed.this.c_renamed();
                } catch (java.lang.Exception unused) {
                }
            }
        });
    }
}

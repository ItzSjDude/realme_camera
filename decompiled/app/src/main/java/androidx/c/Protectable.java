package androidx.c_renamed;

/* compiled from: HeifEncoder.java */
/* loaded from: classes.dex */
public final class c_renamed implements android.graphics.SurfaceTexture.OnFrameAvailableListener, java.lang.AutoCloseable {
    private static final android.media.MediaCodecList n_renamed = new android.media.MediaCodecList(0);
    private androidx.c_renamed.b_renamed A_renamed;
    private androidx.c_renamed.a_renamed B_renamed;
    private int C_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    android.media.MediaCodec f666a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final androidx.c_renamed.c_renamed.a_renamed f667b;

    /* renamed from: c_renamed, reason: collision with root package name */
    final android.os.Handler f668c;
    final int d_renamed;
    final int e_renamed;
    final int f_renamed;
    final int g_renamed;
    final int h_renamed;
    final int i_renamed;
    final boolean j_renamed;
    boolean k_renamed;
    androidx.c_renamed.c_renamed.HeifEncoder_3 m_renamed;
    private final android.os.HandlerThread o_renamed;
    private final int p_renamed;
    private final int q_renamed;
    private int r_renamed;
    private final android.graphics.Rect s_renamed;
    private final android.graphics.Rect t_renamed;
    private java.nio.ByteBuffer u_renamed;
    private android.graphics.SurfaceTexture x_renamed;
    private android.view.Surface y_renamed;
    private android.view.Surface z_renamed;
    private final java.util.ArrayList<java.nio.ByteBuffer> v_renamed = new java.util.ArrayList<>();
    private final java.util.ArrayList<java.nio.ByteBuffer> w_renamed = new java.util.ArrayList<>();
    final java.util.ArrayList<java.lang.Integer> l_renamed = new java.util.ArrayList<>();
    private final float[] D_renamed = new float[16];
    private final java.util.concurrent.atomic.AtomicBoolean E_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);

    /* compiled from: HeifEncoder.java */
    public static abstract class a_renamed {
        public abstract void a_renamed(androidx.c_renamed.c_renamed cVar);

        public abstract void a_renamed(androidx.c_renamed.c_renamed cVar, android.media.MediaCodec.CodecException codecException);

        public abstract void a_renamed(androidx.c_renamed.c_renamed cVar, android.media.MediaFormat mediaFormat);

        public abstract void a_renamed(androidx.c_renamed.c_renamed cVar, java.nio.ByteBuffer byteBuffer);
    }

    public c_renamed(int i_renamed, int i2, boolean z_renamed, int i3, int i4, android.os.Handler handler, androidx.c_renamed.c_renamed.a_renamed aVar) throws java.lang.Exception {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities;
        boolean z2;
        int i5;
        int i6;
        android.media.MediaFormat mediaFormatCreateVideoFormat;
        android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType;
        if (i_renamed < 0 || i2 < 0 || i3 < 0 || i3 > 100) {
            throw new java.lang.IllegalArgumentException("invalid encoder inputs");
        }
        int i7 = 512;
        int i8 = 1;
        boolean z3 = z_renamed & (i_renamed > 512 || i2 > 512);
        try {
            this.f666a = android.media.MediaCodec.createEncoderByType("image/vnd.android.heic");
            capabilitiesForType = this.f666a.getCodecInfo().getCapabilitiesForType("image/vnd.android.heic");
        } catch (java.lang.Exception unused) {
            this.f666a = android.media.MediaCodec.createByCodecName(e_renamed());
            android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType2 = this.f666a.getCodecInfo().getCapabilitiesForType(com.google.android.exoplayer2.util.MimeTypes.VIDEO_H265);
            z3 |= !capabilitiesForType2.getVideoCapabilities().isSizeSupported(i_renamed, i2);
            codecCapabilities = capabilitiesForType2;
            z2 = false;
        }
        if (!capabilitiesForType.getVideoCapabilities().isSizeSupported(i_renamed, i2)) {
            this.f666a.release();
            this.f666a = null;
            throw new java.lang.Exception();
        }
        codecCapabilities = capabilitiesForType;
        z2 = true;
        this.p_renamed = i4;
        this.f667b = aVar;
        android.os.Looper looper = handler != null ? handler.getLooper() : null;
        if (looper == null) {
            this.o_renamed = new android.os.HandlerThread("HeifEncoderThread", -2);
            this.o_renamed.start();
            looper = this.o_renamed.getLooper();
        } else {
            this.o_renamed = null;
        }
        this.f668c = new android.os.Handler(looper);
        boolean z4 = i4 == 1 || i4 == 2;
        int i9 = z4 ? 2130708361 : 2135033992;
        boolean z5 = (z3 && !z2) || i4 == 2;
        this.d_renamed = i_renamed;
        this.e_renamed = i2;
        this.j_renamed = z3;
        if (z3) {
            i6 = ((i2 + 512) - 1) / 512;
            i8 = ((i_renamed + 512) - 1) / 512;
            i5 = 512;
        } else {
            i7 = this.d_renamed;
            i5 = this.e_renamed;
            i6 = 1;
        }
        if (z2) {
            mediaFormatCreateVideoFormat = android.media.MediaFormat.createVideoFormat("image/vnd.android.heic", this.d_renamed, this.e_renamed);
        } else {
            mediaFormatCreateVideoFormat = android.media.MediaFormat.createVideoFormat(com.google.android.exoplayer2.util.MimeTypes.VIDEO_H265, i7, i5);
        }
        if (z3) {
            mediaFormatCreateVideoFormat.setInteger("tile-width", i7);
            mediaFormatCreateVideoFormat.setInteger("tile-height", i5);
            mediaFormatCreateVideoFormat.setInteger("grid-cols", i8);
            mediaFormatCreateVideoFormat.setInteger("grid-rows", i6);
        }
        if (z2) {
            this.f_renamed = i_renamed;
            this.g_renamed = i2;
            this.h_renamed = 1;
            this.i_renamed = 1;
        } else {
            this.f_renamed = i7;
            this.g_renamed = i5;
            this.h_renamed = i6;
            this.i_renamed = i8;
        }
        this.q_renamed = this.h_renamed * this.i_renamed;
        mediaFormatCreateVideoFormat.setInteger("i_renamed-frame-interval", 0);
        mediaFormatCreateVideoFormat.setInteger("color-format", i9);
        mediaFormatCreateVideoFormat.setInteger(com.oplus.tblplayer.misc.IMediaFormat.KEY_FRAME_RATE, this.q_renamed);
        if (this.q_renamed > 1) {
            mediaFormatCreateVideoFormat.setInteger("operating-rate", 120);
        } else {
            mediaFormatCreateVideoFormat.setInteger("operating-rate", 30);
        }
        if (z4 && !z5) {
            android.util.Log.d_renamed("HeifEncoder", "Setting fixed pts gap");
            mediaFormatCreateVideoFormat.setLong("max-pts-gap-to-encoder", -1000000L);
        }
        android.media.MediaCodecInfo.EncoderCapabilities encoderCapabilities = codecCapabilities.getEncoderCapabilities();
        if (encoderCapabilities.isBitrateModeSupported(0)) {
            android.util.Log.d_renamed("HeifEncoder", "Setting bitrate mode to constant quality");
            android.util.Range<java.lang.Integer> qualityRange = encoderCapabilities.getQualityRange();
            android.util.Log.d_renamed("HeifEncoder", "Quality range: " + qualityRange);
            mediaFormatCreateVideoFormat.setInteger("bitrate-mode", 0);
            mediaFormatCreateVideoFormat.setInteger("quality", (int) (((double) ((java.lang.Integer) qualityRange.getLower()).intValue()) + (((double) ((((java.lang.Integer) qualityRange.getUpper()).intValue() - ((java.lang.Integer) qualityRange.getLower()).intValue()) * i3)) / 100.0d)));
        } else {
            if (encoderCapabilities.isBitrateModeSupported(2)) {
                android.util.Log.d_renamed("HeifEncoder", "Setting bitrate mode to constant bitrate");
                mediaFormatCreateVideoFormat.setInteger("bitrate-mode", 2);
            } else {
                android.util.Log.d_renamed("HeifEncoder", "Setting bitrate mode to variable bitrate");
                mediaFormatCreateVideoFormat.setInteger("bitrate-mode", 1);
            }
            mediaFormatCreateVideoFormat.setInteger("bitrate", ((java.lang.Integer) codecCapabilities.getVideoCapabilities().getBitrateRange().clamp(java.lang.Integer.valueOf((int) ((((((i_renamed * i2) * 1.5d) * 8.0d) * 0.25d) * i3) / 100.0d)))).intValue());
        }
        this.f666a.setCallback(new androidx.c_renamed.c_renamed.b_renamed(), this.f668c);
        this.f666a.configure(mediaFormatCreateVideoFormat, (android.view.Surface) null, (android.media.MediaCrypto) null, 1);
        if (z4) {
            this.z_renamed = this.f666a.createInputSurface();
            this.m_renamed = new androidx.c_renamed.c_renamed.HeifEncoder_3(z5);
            if (z5) {
                this.A_renamed = new androidx.c_renamed.b_renamed(this.z_renamed);
                this.A_renamed.b_renamed();
                this.B_renamed = new androidx.c_renamed.a_renamed(new androidx.c_renamed.e_renamed(i4 == 2 ? 0 : 1), this.d_renamed, this.e_renamed);
                this.C_renamed = this.B_renamed.a_renamed();
                if (i4 == 1) {
                    this.x_renamed = new android.graphics.SurfaceTexture(this.C_renamed, true);
                    this.x_renamed.setOnFrameAvailableListener(this);
                    this.x_renamed.setDefaultBufferSize(this.d_renamed, this.e_renamed);
                    this.y_renamed = new android.view.Surface(this.x_renamed);
                }
                this.A_renamed.c_renamed();
            } else {
                this.y_renamed = this.z_renamed;
            }
        } else {
            for (int i10 = 0; i10 < 2; i10++) {
                this.v_renamed.add(java.nio.ByteBuffer.allocateDirect(((this.d_renamed * this.e_renamed) * 3) / 2));
            }
        }
        this.t_renamed = new android.graphics.Rect(0, 0, this.f_renamed, this.g_renamed);
        this.s_renamed = new android.graphics.Rect();
    }

    private java.lang.String e_renamed() {
        java.lang.String name = null;
        java.lang.String name2 = null;
        for (android.media.MediaCodecInfo mediaCodecInfo : n_renamed.getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                try {
                    android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(com.google.android.exoplayer2.util.MimeTypes.VIDEO_H265);
                    if (capabilitiesForType.getVideoCapabilities().isSizeSupported(512, 512)) {
                        if (capabilitiesForType.getEncoderCapabilities().isBitrateModeSupported(0)) {
                            if (mediaCodecInfo.isHardwareAccelerated()) {
                                return mediaCodecInfo.getName();
                            }
                            if (name == null) {
                                name = mediaCodecInfo.getName();
                            }
                        }
                        if (name2 == null) {
                            name2 = mediaCodecInfo.getName();
                        }
                    } else {
                        continue;
                    }
                } catch (java.lang.IllegalArgumentException unused) {
                    continue;
                }
            }
        }
        return name != null ? name : name2;
    }

    private void f_renamed() {
        android.opengl.GLES20.glViewport(0, 0, this.f_renamed, this.g_renamed);
        for (int i_renamed = 0; i_renamed < this.h_renamed; i_renamed++) {
            for (int i2 = 0; i2 < this.i_renamed; i2++) {
                int i3 = this.f_renamed;
                int i4 = i2 * i3;
                int i5 = this.g_renamed;
                int i6 = i_renamed * i5;
                this.s_renamed.set(i4, i6, i3 + i4, i5 + i6);
                try {
                    this.B_renamed.a_renamed(this.C_renamed, androidx.c_renamed.e_renamed.f689b, this.s_renamed);
                    androidx.c_renamed.b_renamed bVar = this.A_renamed;
                    int i7 = this.r_renamed;
                    this.r_renamed = i7 + 1;
                    bVar.a_renamed(a_renamed(i7) * 1000);
                    this.A_renamed.d_renamed();
                } catch (java.lang.RuntimeException e_renamed) {
                    if (!this.E_renamed.get()) {
                        throw e_renamed;
                    }
                    return;
                }
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
        synchronized (this) {
            if (this.A_renamed == null) {
                return;
            }
            this.A_renamed.b_renamed();
            surfaceTexture.updateTexImage();
            surfaceTexture.getTransformMatrix(this.D_renamed);
            if (this.m_renamed.a_renamed(surfaceTexture.getTimestamp(), a_renamed((this.r_renamed + this.q_renamed) - 1))) {
                f_renamed();
            }
            surfaceTexture.releaseTexImage();
            this.A_renamed.c_renamed();
        }
    }

    public void a_renamed() {
        this.f666a.start();
    }

    public void a_renamed(android.graphics.Bitmap bitmap) {
        if (this.p_renamed != 2) {
            throw new java.lang.IllegalStateException("addBitmap is_renamed only allowed in_renamed bitmap input mode");
        }
        if (this.m_renamed.a_renamed(a_renamed(this.r_renamed) * 1000, a_renamed((this.r_renamed + this.q_renamed) - 1))) {
            synchronized (this) {
                if (this.A_renamed == null) {
                    return;
                }
                this.A_renamed.b_renamed();
                this.B_renamed.a_renamed(this.C_renamed, bitmap);
                f_renamed();
                this.A_renamed.c_renamed();
            }
        }
    }

    public void b_renamed() {
        int i_renamed = this.p_renamed;
        if (i_renamed == 2) {
            this.m_renamed.a_renamed(0L);
        } else if (i_renamed == 0) {
            a_renamed((byte[]) null);
        }
    }

    private long a_renamed(int i_renamed) {
        return ((i_renamed * 1000000) / this.q_renamed) + 132;
    }

    private void a_renamed(byte[] bArr) {
        java.nio.ByteBuffer byteBufferG = g_renamed();
        if (byteBufferG == null) {
            return;
        }
        byteBufferG.clear();
        if (bArr != null) {
            byteBufferG.put(bArr);
        }
        byteBufferG.flip();
        synchronized (this.w_renamed) {
            this.w_renamed.add(byteBufferG);
        }
        this.f668c.post(new java.lang.Runnable() { // from class: androidx.c_renamed.c_renamed.1
            @Override // java.lang.Runnable
            public void run() throws android.media.MediaCodec.CryptoException {
                androidx.c_renamed.c_renamed.this.c_renamed();
            }
        });
    }

    void c_renamed() throws android.media.MediaCodec.CryptoException {
        while (true) {
            java.nio.ByteBuffer byteBufferH = h_renamed();
            if (byteBufferH == null || this.l_renamed.isEmpty()) {
                return;
            }
            int iIntValue = this.l_renamed.remove(0).intValue();
            boolean z_renamed = this.r_renamed % this.q_renamed == 0 && byteBufferH.remaining() == 0;
            if (!z_renamed) {
                android.media.Image inputImage = this.f666a.getInputImage(iIntValue);
                int i_renamed = this.f_renamed;
                int i2 = this.r_renamed;
                int i3 = this.i_renamed;
                int i4 = (i2 % i3) * i_renamed;
                int i5 = this.g_renamed;
                int i6 = ((i2 / i3) % this.h_renamed) * i5;
                this.s_renamed.set(i4, i6, i_renamed + i4, i5 + i6);
                a_renamed(byteBufferH, inputImage, this.d_renamed, this.e_renamed, this.s_renamed, this.t_renamed);
            }
            android.media.MediaCodec mediaCodec = this.f666a;
            int iCapacity = z_renamed ? 0 : mediaCodec.getInputBuffer(iIntValue).capacity();
            int i7 = this.r_renamed;
            this.r_renamed = i7 + 1;
            mediaCodec.queueInputBuffer(iIntValue, 0, iCapacity, a_renamed(i7), z_renamed ? 4 : 0);
            if (z_renamed || this.r_renamed % this.q_renamed == 0) {
                a_renamed(z_renamed);
            }
        }
    }

    private static void a_renamed(java.nio.ByteBuffer byteBuffer, android.media.Image image, int i_renamed, int i2, android.graphics.Rect rect, android.graphics.Rect rect2) {
        int i3;
        int i4;
        if (rect.width() != rect2.width() || rect.height() != rect2.height()) {
            throw new java.lang.IllegalArgumentException("src and dst rect size are different!");
        }
        if (i_renamed % 2 == 0 && i2 % 2 == 0) {
            int i5 = 2;
            if (rect.left % 2 == 0 && rect.top % 2 == 0 && rect.right % 2 == 0 && rect.bottom % 2 == 0 && rect2.left % 2 == 0 && rect2.top % 2 == 0 && rect2.right % 2 == 0 && rect2.bottom % 2 == 0) {
                android.media.Image.Plane[] planes = image.getPlanes();
                int i6 = 0;
                while (i6 < planes.length) {
                    java.nio.ByteBuffer buffer = planes[i6].getBuffer();
                    int pixelStride = planes[i6].getPixelStride();
                    int iMin = java.lang.Math.min(rect.width(), i_renamed - rect.left);
                    int iMin2 = java.lang.Math.min(rect.height(), i2 - rect.top);
                    if (i6 > 0) {
                        i4 = ((i_renamed * i2) * (i6 + 3)) / 4;
                        i3 = i5;
                    } else {
                        i3 = 1;
                        i4 = 0;
                    }
                    for (int i7 = 0; i7 < iMin2 / i3; i7++) {
                        byteBuffer.position(((((rect.top / i3) + i7) * i_renamed) / i3) + i4 + (rect.left / i3));
                        buffer.position((((rect2.top / i3) + i7) * planes[i6].getRowStride()) + ((rect2.left * pixelStride) / i3));
                        int i8 = 0;
                        while (true) {
                            int i9 = iMin / i3;
                            if (i8 < i9) {
                                buffer.put(byteBuffer.get());
                                if (pixelStride > 1 && i8 != i9 - 1) {
                                    buffer.position((buffer.position() + pixelStride) - 1);
                                }
                                i8++;
                            }
                        }
                    }
                    i6++;
                    i5 = 2;
                }
                return;
            }
        }
        throw new java.lang.IllegalArgumentException("src or dst are not aligned!");
    }

    private java.nio.ByteBuffer g_renamed() {
        java.nio.ByteBuffer byteBufferRemove;
        synchronized (this.v_renamed) {
            while (!this.k_renamed && this.v_renamed.isEmpty()) {
                try {
                    this.v_renamed.wait();
                } catch (java.lang.InterruptedException unused) {
                }
            }
            byteBufferRemove = this.k_renamed ? null : this.v_renamed.remove(0);
        }
        return byteBufferRemove;
    }

    private java.nio.ByteBuffer h_renamed() {
        if (!this.k_renamed && this.u_renamed == null) {
            synchronized (this.w_renamed) {
                this.u_renamed = this.w_renamed.isEmpty() ? null : this.w_renamed.remove(0);
            }
        }
        if (this.k_renamed) {
            return null;
        }
        return this.u_renamed;
    }

    private void a_renamed(boolean z_renamed) {
        synchronized (this.v_renamed) {
            this.k_renamed = z_renamed | this.k_renamed;
            this.v_renamed.add(this.u_renamed);
            this.v_renamed.notifyAll();
        }
        this.u_renamed = null;
    }

    void d_renamed() {
        this.E_renamed.set(true);
        android.media.MediaCodec mediaCodec = this.f666a;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f666a.release();
            this.f666a = null;
        }
        synchronized (this.v_renamed) {
            this.k_renamed = true;
            this.v_renamed.notifyAll();
        }
        synchronized (this) {
            if (this.B_renamed != null) {
                this.B_renamed.a_renamed(false);
                this.B_renamed = null;
            }
            if (this.A_renamed != null) {
                this.A_renamed.a_renamed();
                this.A_renamed = null;
            }
            if (this.x_renamed != null) {
                this.x_renamed.release();
                this.x_renamed = null;
            }
        }
    }

    /* compiled from: HeifEncoder.java */
    /* renamed from: androidx.c_renamed.c_renamed$c_renamed, reason: collision with other inner class name */
    private class HeifEncoder_3 {

        /* renamed from: a_renamed, reason: collision with root package name */
        final boolean f673a;

        /* renamed from: b_renamed, reason: collision with root package name */
        long f674b = -1;

        /* renamed from: c_renamed, reason: collision with root package name */
        long f675c = -1;
        long d_renamed = -1;
        long e_renamed = -1;
        long f_renamed = -1;
        boolean g_renamed;

        HeifEncoder_3(boolean z_renamed) {
            this.f673a = z_renamed;
        }

        synchronized void a_renamed(long j_renamed) {
            if (this.f673a) {
                if (this.f674b < 0) {
                    this.f674b = j_renamed;
                }
            } else if (this.d_renamed < 0) {
                this.d_renamed = j_renamed / 1000;
            }
            a_renamed();
        }

        synchronized boolean a_renamed(long j_renamed, long j2) {
            boolean z_renamed;
            z_renamed = this.f674b < 0 || j_renamed <= this.f674b;
            if (z_renamed) {
                this.e_renamed = j2;
            }
            this.f675c = j_renamed;
            a_renamed();
            return z_renamed;
        }

        synchronized void b_renamed(long j_renamed) {
            this.f_renamed = j_renamed;
            a_renamed();
        }

        private void a_renamed() {
            if (this.g_renamed) {
                return;
            }
            if (this.d_renamed < 0) {
                long j_renamed = this.f674b;
                if (j_renamed >= 0 && this.f675c >= j_renamed) {
                    long j2 = this.e_renamed;
                    if (j2 < 0) {
                        b_renamed();
                        return;
                    }
                    this.d_renamed = j2;
                }
            }
            long j3 = this.d_renamed;
            if (j3 < 0 || j3 > this.f_renamed) {
                return;
            }
            b_renamed();
        }

        private void b_renamed() {
            androidx.c_renamed.c_renamed.this.f668c.post(new java.lang.Runnable() { // from class: androidx.c_renamed.c_renamed.c_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    if (androidx.c_renamed.c_renamed.this.f666a != null) {
                        androidx.c_renamed.c_renamed.this.f666a.signalEndOfInputStream();
                    }
                }
            });
            this.g_renamed = true;
        }
    }

    /* compiled from: HeifEncoder.java */
    class b_renamed extends android.media.MediaCodec.Callback {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f672b;

        b_renamed() {
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(android.media.MediaCodec mediaCodec, android.media.MediaFormat mediaFormat) {
            if (mediaCodec != androidx.c_renamed.c_renamed.this.f666a) {
                return;
            }
            if (!"image/vnd.android.heic".equals(mediaFormat.getString(com.oplus.tblplayer.misc.IMediaFormat.KEY_MIME))) {
                mediaFormat.setString(com.oplus.tblplayer.misc.IMediaFormat.KEY_MIME, "image/vnd.android.heic");
                mediaFormat.setInteger("width", androidx.c_renamed.c_renamed.this.d_renamed);
                mediaFormat.setInteger("height", androidx.c_renamed.c_renamed.this.e_renamed);
                if (androidx.c_renamed.c_renamed.this.j_renamed) {
                    mediaFormat.setInteger("tile-width", androidx.c_renamed.c_renamed.this.f_renamed);
                    mediaFormat.setInteger("tile-height", androidx.c_renamed.c_renamed.this.g_renamed);
                    mediaFormat.setInteger("grid-rows", androidx.c_renamed.c_renamed.this.h_renamed);
                    mediaFormat.setInteger("grid-cols", androidx.c_renamed.c_renamed.this.i_renamed);
                }
            }
            androidx.c_renamed.c_renamed.this.f667b.a_renamed(androidx.c_renamed.c_renamed.this, mediaFormat);
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(android.media.MediaCodec mediaCodec, int i_renamed) throws android.media.MediaCodec.CryptoException {
            if (mediaCodec != androidx.c_renamed.c_renamed.this.f666a || androidx.c_renamed.c_renamed.this.k_renamed) {
                return;
            }
            androidx.c_renamed.c_renamed.this.l_renamed.add(java.lang.Integer.valueOf(i_renamed));
            androidx.c_renamed.c_renamed.this.c_renamed();
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(android.media.MediaCodec mediaCodec, int i_renamed, android.media.MediaCodec.BufferInfo bufferInfo) {
            if (mediaCodec != androidx.c_renamed.c_renamed.this.f666a || this.f672b) {
                return;
            }
            if (bufferInfo.size > 0 && (bufferInfo.flags & 2) == 0) {
                java.nio.ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i_renamed);
                outputBuffer.position(bufferInfo.offset);
                outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                if (androidx.c_renamed.c_renamed.this.m_renamed != null) {
                    androidx.c_renamed.c_renamed.this.m_renamed.b_renamed(bufferInfo.presentationTimeUs);
                }
                androidx.c_renamed.c_renamed.this.f667b.a_renamed(androidx.c_renamed.c_renamed.this, outputBuffer);
            }
            this.f672b = ((bufferInfo.flags & 4) != 0) | this.f672b;
            mediaCodec.releaseOutputBuffer(i_renamed, false);
            if (this.f672b) {
                a_renamed(null);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(android.media.MediaCodec mediaCodec, android.media.MediaCodec.CodecException codecException) {
            if (mediaCodec != androidx.c_renamed.c_renamed.this.f666a) {
                return;
            }
            android.util.Log.e_renamed("HeifEncoder", "onError: " + codecException);
            a_renamed(codecException);
        }

        private void a_renamed(android.media.MediaCodec.CodecException codecException) {
            androidx.c_renamed.c_renamed.this.d_renamed();
            if (codecException == null) {
                androidx.c_renamed.c_renamed.this.f667b.a_renamed(androidx.c_renamed.c_renamed.this);
            } else {
                androidx.c_renamed.c_renamed.this.f667b.a_renamed(androidx.c_renamed.c_renamed.this, codecException);
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.v_renamed) {
            this.k_renamed = true;
            this.v_renamed.notifyAll();
        }
        this.f668c.postAtFrontOfQueue(new java.lang.Runnable() { // from class: androidx.c_renamed.c_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                androidx.c_renamed.c_renamed.this.d_renamed();
            }
        });
    }
}

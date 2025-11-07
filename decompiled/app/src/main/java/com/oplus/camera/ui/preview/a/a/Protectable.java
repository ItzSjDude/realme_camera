package com.oplus.camera.ui.preview.a_renamed.a_renamed;

/* compiled from: VideoDecodeSync.java */
/* loaded from: classes2.dex */
public class c_renamed implements java.lang.Runnable {
    private com.oplus.camera.doubleexposure.b_renamed l_renamed;
    private android.graphics.SurfaceTexture m_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.media.MediaMetadataRetriever f6827a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.media.MediaFormat f6828b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.media.MediaExtractor f6829c = null;
    private android.media.MediaCodec d_renamed = null;
    private int e_renamed = 0;
    private int f_renamed = 0;
    private int g_renamed = 0;
    private int h_renamed = 0;
    private int i_renamed = 0;
    private long j_renamed = 0;
    private long k_renamed = -1;
    private boolean n_renamed = false;
    private boolean o_renamed = false;
    private boolean p_renamed = false;
    private long q_renamed = 0;
    private long r_renamed = 0;
    private boolean s_renamed = false;
    private java.lang.String t_renamed = "";
    private com.oplus.camera.ui.preview.a_renamed.a_renamed.b_renamed u_renamed = null;
    private android.os.ConditionVariable v_renamed = null;
    private java.lang.Object w_renamed = null;
    private android.os.ConditionVariable x_renamed = new android.os.ConditionVariable(true);

    public c_renamed(com.oplus.camera.doubleexposure.b_renamed bVar, android.graphics.SurfaceTexture surfaceTexture) throws java.lang.IllegalArgumentException {
        this.l_renamed = null;
        this.m_renamed = null;
        this.l_renamed = bVar;
        this.m_renamed = surfaceTexture;
        l_renamed();
    }

    public int a_renamed() {
        return this.f_renamed;
    }

    public int b_renamed() {
        return this.g_renamed;
    }

    public int c_renamed() {
        return this.h_renamed;
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.a_renamed.b_renamed bVar) {
        this.u_renamed = bVar;
    }

    public void a_renamed(android.os.ConditionVariable conditionVariable) {
        this.v_renamed = conditionVariable;
    }

    public void a_renamed(java.lang.Object obj) {
        this.w_renamed = obj;
    }

    private void l_renamed() throws java.lang.IllegalArgumentException {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            this.f6827a = new android.media.MediaMetadataRetriever();
            this.f6827a.setDataSource(this.l_renamed.c_renamed());
            java.lang.String strExtractMetadata = this.f6827a.extractMetadata(18);
            java.lang.String strExtractMetadata2 = this.f6827a.extractMetadata(19);
            java.lang.String strExtractMetadata3 = this.f6827a.extractMetadata(24);
            this.f_renamed = java.lang.Integer.parseInt(strExtractMetadata);
            this.g_renamed = java.lang.Integer.parseInt(strExtractMetadata2);
            this.h_renamed = java.lang.Integer.parseInt(strExtractMetadata3);
            com.oplus.camera.e_renamed.a_renamed("VideoDecodeSync", "init, mWidth: " + this.f_renamed + ", mHeight: " + this.g_renamed + ", mRotation: " + this.h_renamed);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            this.n_renamed = true;
            o_renamed();
        }
        com.oplus.camera.e_renamed.a_renamed("VideoDecodeSync", "init, time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + ", this: " + this);
    }

    private void m_renamed() throws java.lang.NumberFormatException {
        android.media.MediaMetadataRetriever mediaMetadataRetriever;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        this.f6829c = new android.media.MediaExtractor();
        if (!this.l_renamed.f_renamed() && (mediaMetadataRetriever = this.f6827a) != null) {
            long j_renamed = Long.MAX_VALUE;
            try {
                j_renamed = java.lang.Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
            this.l_renamed.a_renamed(0L);
            this.l_renamed.b_renamed(j_renamed);
        }
        try {
            this.f6829c.setDataSource(this.l_renamed.c_renamed());
            int trackCount = this.f6829c.getTrackCount();
            int i_renamed = 0;
            while (true) {
                if (i_renamed >= trackCount) {
                    break;
                }
                android.media.MediaFormat trackFormat = this.f6829c.getTrackFormat(i_renamed);
                this.t_renamed = trackFormat.getString(com.oplus.tblplayer.misc.IMediaFormat.KEY_MIME);
                if (this.t_renamed != null && this.t_renamed.startsWith("video")) {
                    this.e_renamed = i_renamed;
                    this.f6828b = trackFormat;
                    this.f6828b.setInteger("i_renamed-frame-interval", 1);
                    this.f6828b.setInteger("color-format", 2135033992);
                    com.oplus.camera.e_renamed.a_renamed("VideoDecodeSync", "config, mVideoFormat: " + this.f6828b.toString() + ", mWidth: " + this.f_renamed + ", mHeight: " + this.g_renamed + ", rotation: " + this.h_renamed + ", this: " + this);
                    break;
                }
                i_renamed++;
            }
            this.d_renamed = android.media.MediaCodec.createDecoderByType(this.t_renamed);
            this.d_renamed.configure(this.f6828b, new android.view.Surface(this.m_renamed), (android.media.MediaCrypto) null, 0);
            this.d_renamed.start();
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            com.oplus.camera.e_renamed.f_renamed("VideoDecodeSync", "config, error: " + e2.getLocalizedMessage());
            this.n_renamed = true;
            o_renamed();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.oplus.camera.e_renamed.f_renamed("VideoDecodeSync", "config, error");
            this.n_renamed = true;
            o_renamed();
        }
        com.oplus.camera.e_renamed.a_renamed("VideoDecodeSync", "config, cost time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public void d_renamed() {
        android.os.ConditionVariable conditionVariable = this.v_renamed;
        if (conditionVariable != null) {
            conditionVariable.close();
        }
        this.s_renamed = true;
    }

    public void e_renamed() {
        this.s_renamed = false;
    }

    public boolean f_renamed() {
        return this.s_renamed;
    }

    private int a_renamed(java.nio.ByteBuffer byteBuffer) {
        if (this.n_renamed) {
            return -1;
        }
        byteBuffer.clear();
        int sampleData = this.f6829c.readSampleData(byteBuffer, 0);
        if (sampleData < 0) {
            return -1;
        }
        this.j_renamed = this.f6829c.getSampleTime();
        this.i_renamed = this.f6829c.getSampleFlags();
        this.f6829c.advance();
        return sampleData;
    }

    public void g_renamed() {
        this.n_renamed = true;
    }

    public void h_renamed() {
        this.p_renamed = true;
    }

    public boolean i_renamed() {
        return !this.n_renamed && this.o_renamed;
    }

    public boolean j_renamed() {
        return (this.n_renamed || this.o_renamed) ? false : true;
    }

    @Override // java.lang.Runnable
    public void run() throws java.lang.NumberFormatException {
        this.x_renamed.close();
        m_renamed();
        android.media.MediaCodec.BufferInfo bufferInfo = new android.media.MediaCodec.BufferInfo();
        e_renamed();
        try {
            try {
                this.f6829c.selectTrack(this.e_renamed);
                if (this.l_renamed.f_renamed() && this.l_renamed.d_renamed() > 0) {
                    this.f6829c.seekTo(this.l_renamed.d_renamed() * 1000, 2);
                }
                while (!this.n_renamed) {
                    int iDequeueInputBuffer = this.d_renamed.dequeueInputBuffer(1000L);
                    if (iDequeueInputBuffer > 0) {
                        int iA = a_renamed(this.d_renamed.getInputBuffer(iDequeueInputBuffer));
                        if (iA > 0 && !this.p_renamed) {
                            this.d_renamed.queueInputBuffer(iDequeueInputBuffer, 0, iA, this.j_renamed, this.i_renamed);
                        } else {
                            this.p_renamed = false;
                            this.d_renamed.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                            this.d_renamed.flush();
                            this.f6829c.seekTo(this.l_renamed.d_renamed() * 1000, 2);
                        }
                    }
                    a_renamed(bufferInfo);
                    int iDequeueOutputBuffer = this.d_renamed.dequeueOutputBuffer(bufferInfo, 1000L);
                    b_renamed(bufferInfo);
                    if (iDequeueOutputBuffer > 0 && bufferInfo.presentationTimeUs / 1000 > this.l_renamed.e_renamed()) {
                        this.p_renamed = true;
                    }
                    if (iDequeueOutputBuffer > 0 && !this.p_renamed) {
                        if (this.k_renamed < 0 || n_renamed()) {
                            this.k_renamed = java.lang.System.currentTimeMillis();
                        }
                        if (this.n_renamed) {
                            continue;
                        } else {
                            if (this.v_renamed != null) {
                                this.v_renamed.close();
                                this.v_renamed.block();
                            }
                            synchronized (this.w_renamed) {
                                this.d_renamed.releaseOutputBuffer(iDequeueOutputBuffer, true);
                            }
                            if (!this.o_renamed) {
                                com.oplus.camera.e_renamed.a_renamed("VideoDecodeSync", "first decode frame arrived");
                                this.o_renamed = true;
                                if (this.u_renamed != null) {
                                    this.u_renamed.a_renamed();
                                }
                            }
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                com.oplus.camera.e_renamed.a_renamed("VideoDecodeSync", "run, decode error, this: " + this);
            }
        } finally {
            com.oplus.camera.e_renamed.a_renamed("VideoDecodeSync", "run, decode thread end");
            this.x_renamed.open();
        }
    }

    private boolean n_renamed() {
        return this.r_renamed < this.q_renamed;
    }

    private void a_renamed(android.media.MediaCodec.BufferInfo bufferInfo) {
        if (bufferInfo != null) {
            this.q_renamed = bufferInfo.presentationTimeUs / 1000;
        }
    }

    private void b_renamed(android.media.MediaCodec.BufferInfo bufferInfo) {
        if (bufferInfo != null) {
            this.r_renamed = bufferInfo.presentationTimeUs / 1000;
        }
    }

    public void k_renamed() {
        android.os.ConditionVariable conditionVariable = this.v_renamed;
        if (conditionVariable != null) {
            conditionVariable.open();
        }
        this.x_renamed.block(1000L);
        com.oplus.camera.e_renamed.a_renamed("VideoDecodeSync", "release, start");
        try {
            try {
                if (this.f6827a != null) {
                    this.f6827a.release();
                    this.f6827a = null;
                }
                if (this.d_renamed != null) {
                    this.d_renamed.stop();
                    this.d_renamed.release();
                    this.f6829c.release();
                }
            } catch (java.lang.IllegalStateException e_renamed) {
                e_renamed.printStackTrace();
            }
        } finally {
            com.oplus.camera.e_renamed.a_renamed("VideoDecodeSync", "release, end");
        }
    }

    private void o_renamed() {
        com.oplus.camera.ui.preview.a_renamed.a_renamed.b_renamed bVar = this.u_renamed;
        if (bVar != null) {
            bVar.b_renamed();
        }
    }
}

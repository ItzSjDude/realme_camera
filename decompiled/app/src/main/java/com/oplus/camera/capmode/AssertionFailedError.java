package com.oplus.camera.capmode;

/* compiled from: CameraMediaCodec.java */
/* loaded from: classes2.dex */
public class b_renamed {
    private com.oplus.camera.capmode.b_renamed.a_renamed M_renamed;
    private volatile boolean az_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Object f4216a = new java.lang.Object();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Object f4217b = new java.lang.Object();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.Object f4218c = new java.lang.Object();
    private final java.lang.Object d_renamed = new java.lang.Object();
    private final java.util.concurrent.atomic.AtomicBoolean e_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
    private volatile long f_renamed = 0;
    private boolean g_renamed = true;
    private boolean h_renamed = false;
    private boolean i_renamed = false;
    private int j_renamed = -1;
    private int k_renamed = -1;
    private int l_renamed = -1;
    private int m_renamed = 0;
    private int n_renamed = 0;
    private int o_renamed = 12;
    private int p_renamed = 28;
    private int q_renamed = 0;
    private long r_renamed = 0;
    private long s_renamed = 0;
    private long t_renamed = 0;
    private long u_renamed = 0;
    private long v_renamed = 0;
    private long w_renamed = -1;
    private long x_renamed = -1;
    private long y_renamed = -1;
    private long z_renamed = -1;
    private android.media.MediaMuxer A_renamed = null;
    private int B_renamed = 3;
    private java.lang.String C_renamed = null;
    private java.io.FileDescriptor D_renamed = null;
    private android.media.MediaCodec E_renamed = null;
    private android.media.MediaCodec F_renamed = null;
    private android.view.Surface G_renamed = null;
    private android.media.MediaFormat H_renamed = null;
    private android.media.MediaFormat I_renamed = null;
    private java.nio.ByteBuffer[] J_renamed = null;
    private android.media.AudioRecord K_renamed = null;
    private com.oplus.camera.capmode.c_renamed L_renamed = null;
    private com.oplus.camera.gl_renamed.q_renamed N_renamed = null;
    private android.os.Handler O_renamed = null;
    private android.os.Handler P_renamed = null;
    private android.os.Handler Q_renamed = null;
    private java.lang.Thread R_renamed = null;
    private android.os.ConditionVariable S_renamed = new android.os.ConditionVariable();
    private android.os.ConditionVariable T_renamed = new android.os.ConditionVariable();
    private com.oplus.camera.capmode.b_renamed.CameraMediaCodec_3 U_renamed = new com.oplus.camera.capmode.b_renamed.CameraMediaCodec_3();
    private java.util.concurrent.CountDownLatch V_renamed = new java.util.concurrent.CountDownLatch(2);
    private float W_renamed = 0.0f;
    private float X_renamed = 0.0f;
    private int Y_renamed = -1;
    private long Z_renamed = -1;
    private long aa_renamed = 0;
    private boolean ab_renamed = true;
    private boolean ac_renamed = false;
    private boolean ad_renamed = false;
    private boolean ae_renamed = false;
    private boolean af_renamed = false;
    private boolean ag_renamed = false;
    private java.lang.String ah_renamed = com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA;
    private java.lang.String ai_renamed = "0";
    private int aj_renamed = 0;
    private java.lang.String ak_renamed = "";
    private com.oplus.camera.gl_renamed.m_renamed<android.view.Surface> al_renamed = null;
    private com.oplus.camera.gl_renamed.z_renamed am_renamed = null;
    private android.os.Handler an_renamed = null;
    private boolean ao_renamed = true;
    private boolean ap_renamed = false;
    private boolean aq_renamed = false;
    private java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.capmode.b_renamed.c_renamed> ar_renamed = new java.util.concurrent.CopyOnWriteArrayList<>();
    private android.os.Handler as_renamed = null;
    private boolean at_renamed = true;
    private volatile boolean au_renamed = false;
    private volatile boolean av_renamed = false;
    private final android.os.ConditionVariable aw_renamed = new android.os.ConditionVariable();
    private java.lang.Object ax_renamed = new java.lang.Object();
    private volatile int ay_renamed = 0;
    private android.media.MediaCodec.Callback aA_renamed = new android.media.MediaCodec.Callback() { // from class: com.oplus.camera.capmode.b_renamed.1
        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(android.media.MediaCodec mediaCodec, int i_renamed) {
            com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "onInputBufferAvailable");
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(android.media.MediaCodec mediaCodec, int i_renamed, android.media.MediaCodec.BufferInfo bufferInfo) {
            com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "onOutputBufferAvailable");
            try {
                java.nio.ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i_renamed);
                if (4 != bufferInfo.flags) {
                    if (com.oplus.camera.capmode.b_renamed.this.at_renamed && 2 == bufferInfo.flags) {
                        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "onOutputBufferAvailable, BUFFER_FLAG_CODEC_CONFIG");
                        mediaCodec.releaseOutputBuffer(i_renamed, false);
                        return;
                    }
                    if (1 == bufferInfo.flags) {
                        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "onOutputBufferAvailable, BUFFER_FLAG_SYNC_FRAME");
                    }
                    if (com.oplus.camera.capmode.b_renamed.this.ac_renamed) {
                        if (0 < com.oplus.camera.capmode.b_renamed.this.v_renamed) {
                            bufferInfo.presentationTimeUs -= com.oplus.camera.capmode.b_renamed.this.v_renamed / 1000;
                        }
                        if (com.oplus.camera.capmode.b_renamed.this.ag_renamed) {
                            bufferInfo.presentationTimeUs = com.oplus.camera.capmode.b_renamed.this.a_renamed(bufferInfo);
                            if (bufferInfo.presentationTimeUs <= 0) {
                                com.oplus.camera.e_renamed.b_renamed("CameraMediaCodec", "onOutputBufferAvailable, skip, info.presentationTime: " + bufferInfo.presentationTimeUs);
                                mediaCodec.releaseOutputBuffer(i_renamed, false);
                                return;
                            }
                        }
                        if (com.oplus.camera.capmode.b_renamed.this.x_renamed < 0) {
                            com.oplus.camera.capmode.b_renamed.this.x_renamed = bufferInfo.presentationTimeUs;
                            com.oplus.camera.capmode.b_renamed.this.i_renamed = true;
                        }
                        if (-1 != com.oplus.camera.capmode.b_renamed.this.Y_renamed) {
                            if ((bufferInfo.flags & 1) != 0) {
                                if (com.oplus.camera.capmode.b_renamed.this.Z_renamed < 0) {
                                    com.oplus.camera.capmode.b_renamed.this.Z_renamed = bufferInfo.presentationTimeUs;
                                } else {
                                    com.oplus.camera.capmode.b_renamed.this.Z_renamed += (int) (1000000.0f / com.oplus.camera.capmode.b_renamed.this.U_renamed.k_renamed);
                                }
                                bufferInfo.presentationTimeUs = com.oplus.camera.capmode.b_renamed.this.Z_renamed;
                            } else {
                                com.oplus.camera.e_renamed.b_renamed("CameraMediaCodec", "onOutputBufferAvailable, skip Frame");
                                mediaCodec.releaseOutputBuffer(i_renamed, false);
                                return;
                            }
                        }
                        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "onOutputBufferAvailable, writeSampleData, info.presentationTimeUs: " + bufferInfo.presentationTimeUs + ", mbVideoCodecSpecialEffect: " + com.oplus.camera.capmode.b_renamed.this.ao_renamed);
                        if (com.oplus.camera.capmode.b_renamed.this.h_renamed) {
                            java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(outputBuffer.capacity());
                            byteBufferAllocate.put(outputBuffer);
                            java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList = com.oplus.camera.capmode.b_renamed.this.ar_renamed;
                            com.oplus.camera.capmode.b_renamed bVar = com.oplus.camera.capmode.b_renamed.this;
                            copyOnWriteArrayList.add(bVar.new c_renamed(bVar.j_renamed, byteBufferAllocate, bufferInfo, false));
                            com.oplus.camera.capmode.b_renamed.this.Q_renamed.sendEmptyMessage(1);
                        } else {
                            com.oplus.camera.capmode.b_renamed bVar2 = com.oplus.camera.capmode.b_renamed.this;
                            bVar2.a_renamed(bVar2.j_renamed, outputBuffer, bufferInfo);
                        }
                        synchronized (com.oplus.camera.capmode.b_renamed.this.f4218c) {
                            com.oplus.camera.capmode.b_renamed.c_renamed(com.oplus.camera.capmode.b_renamed.this, bufferInfo.size);
                        }
                        if (com.oplus.camera.capmode.b_renamed.this.y_renamed > 0 && bufferInfo.presentationTimeUs - com.oplus.camera.capmode.b_renamed.this.x_renamed >= com.oplus.camera.capmode.b_renamed.this.y_renamed) {
                            com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "onOutputBufferAvailable, reach to max duration time");
                            com.oplus.camera.capmode.b_renamed.this.M_renamed.sendMessage(com.oplus.camera.capmode.b_renamed.this.M_renamed.obtainMessage(1, 800, -1));
                            com.oplus.camera.capmode.b_renamed.this.y_renamed = -1L;
                        } else if (com.oplus.camera.capmode.b_renamed.this.z_renamed > 0 && com.oplus.camera.capmode.b_renamed.this.aa_renamed >= com.oplus.camera.capmode.b_renamed.this.z_renamed) {
                            com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "onOutputBufferAvailable, reach to max file size");
                            com.oplus.camera.capmode.b_renamed.this.M_renamed.sendMessage(com.oplus.camera.capmode.b_renamed.this.M_renamed.obtainMessage(1, 801, -1));
                            com.oplus.camera.capmode.b_renamed.this.z_renamed = -1L;
                        }
                        if (2 == com.oplus.camera.capmode.b_renamed.this.B_renamed) {
                            com.oplus.camera.capmode.b_renamed.this.t_renamed = java.lang.System.nanoTime();
                        }
                        mediaCodec.releaseOutputBuffer(i_renamed, false);
                        com.oplus.camera.capmode.b_renamed bVar3 = com.oplus.camera.capmode.b_renamed.this;
                        bVar3.ad_renamed = bVar3.at_renamed;
                        synchronized (com.oplus.camera.capmode.b_renamed.this.ax_renamed) {
                            com.oplus.camera.capmode.b_renamed.x_renamed(com.oplus.camera.capmode.b_renamed.this);
                        }
                        return;
                    }
                    com.oplus.camera.e_renamed.b_renamed("CameraMediaCodec", "onOutputBufferAvailable, mbMuxerStarted: " + com.oplus.camera.capmode.b_renamed.this.ac_renamed);
                    mediaCodec.releaseOutputBuffer(i_renamed, false);
                    return;
                }
                com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "onOutputBufferAvailable, Video encode Stopped");
                if (com.oplus.camera.capmode.b_renamed.this.h_renamed) {
                    java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList2 = com.oplus.camera.capmode.b_renamed.this.ar_renamed;
                    com.oplus.camera.capmode.b_renamed bVar4 = com.oplus.camera.capmode.b_renamed.this;
                    copyOnWriteArrayList2.add(bVar4.new c_renamed(bVar4.j_renamed, null, bufferInfo, false));
                    com.oplus.camera.capmode.b_renamed.this.Q_renamed.sendEmptyMessage(1);
                    mediaCodec.releaseOutputBuffer(i_renamed, false);
                    return;
                }
                com.oplus.camera.capmode.b_renamed.this.x_renamed();
                com.oplus.camera.capmode.b_renamed.this.E_renamed();
                if (com.oplus.camera.capmode.b_renamed.this.G_renamed != null) {
                    com.oplus.camera.capmode.b_renamed.this.G_renamed.release();
                }
            } catch (java.lang.IllegalStateException unused) {
                com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "onOutputBufferAvailable MediaCodec is_renamed already stopped or release, so return");
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(android.media.MediaCodec mediaCodec, android.media.MediaCodec.CodecException codecException) {
            com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "onError, diagnostic Info: " + codecException.getDiagnosticInfo());
            com.oplus.camera.capmode.b_renamed.this.M_renamed.sendMessage(com.oplus.camera.capmode.b_renamed.this.M_renamed.obtainMessage(2, codecException.getErrorCode(), -1));
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(android.media.MediaCodec mediaCodec, android.media.MediaFormat mediaFormat) {
            com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "onOutputFormatChanged");
            synchronized (com.oplus.camera.capmode.b_renamed.this.f4216a) {
                if (com.oplus.camera.capmode.b_renamed.this.j_renamed < 0 && com.oplus.camera.capmode.b_renamed.this.A_renamed != null) {
                    mediaFormat.setInteger("support64BitFileSize", 1);
                    com.oplus.camera.capmode.b_renamed.this.j_renamed = com.oplus.camera.capmode.b_renamed.this.A_renamed.addTrack(mediaFormat);
                    com.oplus.camera.capmode.b_renamed.this.D_renamed();
                    com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "onOutputFormatChanged, addTrack mVideoTrack, format: " + mediaFormat);
                }
            }
        }
    };

    static /* synthetic */ long c_renamed(com.oplus.camera.capmode.b_renamed bVar, long j_renamed) {
        long j2 = bVar.aa_renamed + j_renamed;
        bVar.aa_renamed = j2;
        return j2;
    }

    static /* synthetic */ int x_renamed(com.oplus.camera.capmode.b_renamed bVar) {
        int i_renamed = bVar.ay_renamed;
        bVar.ay_renamed = i_renamed + 1;
        return i_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.at_renamed = z_renamed;
    }

    public boolean a_renamed() {
        return this.ay_renamed > 0;
    }

    public void b_renamed(boolean z_renamed) {
        this.az_renamed = z_renamed;
    }

    /* compiled from: CameraMediaCodec.java */
    private class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public boolean f4234a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f4235b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public java.nio.ByteBuffer f4236c;
        public android.media.MediaCodec.BufferInfo d_renamed;

        public c_renamed(int i_renamed, java.nio.ByteBuffer byteBuffer, android.media.MediaCodec.BufferInfo bufferInfo, boolean z_renamed) {
            this.f4234a = false;
            this.f4235b = -1;
            this.f4236c = null;
            this.d_renamed = null;
            this.f4235b = i_renamed;
            this.f4236c = byteBuffer;
            this.d_renamed = bufferInfo;
            this.f4234a = z_renamed;
        }
    }

    /* compiled from: CameraMediaCodec.java */
    /* renamed from: com.oplus.camera.capmode.b_renamed$b_renamed, reason: collision with other inner class name */
    private class CameraMediaCodec_3 {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f4231a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f4232b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f4233c;
        public int d_renamed;
        public int e_renamed;
        public int f_renamed;
        public int g_renamed;
        public int h_renamed;
        public int i_renamed;
        public int j_renamed;
        public int k_renamed;
        public int l_renamed;

        private CameraMediaCodec_3() {
            this.f4231a = 0;
            this.f4232b = 0;
            this.f4233c = 0;
            this.d_renamed = 0;
            this.e_renamed = 0;
            this.f_renamed = 0;
            this.g_renamed = 0;
            this.h_renamed = 0;
            this.i_renamed = 0;
            this.j_renamed = 0;
            this.k_renamed = 0;
            this.l_renamed = 0;
        }
    }

    public b_renamed() {
        this.M_renamed = null;
        this.M_renamed = new com.oplus.camera.capmode.b_renamed.a_renamed(android.os.Looper.getMainLooper());
    }

    private void i_renamed() {
        if (this.O_renamed == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("video codec thread");
            handlerThread.start();
            this.O_renamed = new android.os.Handler(handlerThread.getLooper());
        }
    }

    public void a_renamed(java.lang.String str) {
        this.ah_renamed = str;
    }

    public void b_renamed(java.lang.String str) {
        this.ak_renamed = str;
    }

    public void c_renamed(java.lang.String str) {
        this.ai_renamed = str;
    }

    public void a_renamed(int i_renamed) {
        this.aj_renamed = i_renamed;
    }

    private void j_renamed() {
        android.os.Handler handler = this.O_renamed;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.O_renamed = null;
        }
    }

    private void k_renamed() {
        if (this.P_renamed == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("audio codec thread");
            handlerThread.start();
            this.P_renamed = new android.os.Handler(handlerThread.getLooper());
        }
    }

    private void l_renamed() {
        if (this.h_renamed && this.Q_renamed == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("frame catch thread");
            handlerThread.start();
            this.Q_renamed = new android.os.Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.capmode.b_renamed.3
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    if (message.what != 1) {
                        return;
                    }
                    com.oplus.camera.capmode.b_renamed.this.h_renamed();
                }
            };
        }
    }

    private void m_renamed() {
        android.os.Handler handler = this.P_renamed;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.P_renamed = null;
        }
    }

    private void n_renamed() {
        android.os.Handler handler = this.Q_renamed;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.Q_renamed = null;
        }
    }

    public void d_renamed(java.lang.String str) {
        this.C_renamed = str;
    }

    public void a_renamed(android.media.CamcorderProfile camcorderProfile) {
        this.U_renamed.k_renamed = camcorderProfile.videoFrameRate;
        this.U_renamed.h_renamed = camcorderProfile.videoBitRate;
        this.U_renamed.i_renamed = camcorderProfile.videoCodec;
        this.U_renamed.f4231a = camcorderProfile.audioBitRate;
        this.U_renamed.f4232b = camcorderProfile.audioChannels;
        this.U_renamed.f4233c = camcorderProfile.audioCodec;
        this.U_renamed.d_renamed = camcorderProfile.audioSampleRate;
        this.U_renamed.e_renamed = camcorderProfile.duration;
        this.U_renamed.f_renamed = camcorderProfile.fileFormat;
        this.U_renamed.g_renamed = camcorderProfile.quality;
        this.U_renamed.j_renamed = camcorderProfile.videoFrameWidth;
        this.U_renamed.l_renamed = camcorderProfile.videoFrameHeight;
    }

    public void a_renamed(com.oplus.camera.gl_renamed.q_renamed qVar) {
        this.N_renamed = qVar;
    }

    private android.media.MediaFormat o_renamed() {
        if (this.H_renamed == null) {
            this.H_renamed = android.media.MediaFormat.createVideoFormat(p_renamed(), this.U_renamed.l_renamed, this.U_renamed.j_renamed);
            this.H_renamed.setInteger("bitrate", this.U_renamed.h_renamed);
            this.H_renamed.setInteger(com.oplus.tblplayer.misc.IMediaFormat.KEY_FRAME_RATE, this.U_renamed.k_renamed);
            this.H_renamed.setInteger("color-format", this.at_renamed ? 2130708361 : 21);
            this.H_renamed.setFloat("i_renamed-frame-interval", b_renamed());
        }
        return this.H_renamed;
    }

    public float b_renamed() {
        int i_renamed = this.Y_renamed;
        if (-1 != i_renamed) {
            return i_renamed / this.U_renamed.k_renamed;
        }
        return 1.0f;
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "setExtractFrameRate, extractFrameRate: " + i_renamed);
        this.Y_renamed = i_renamed;
    }

    private java.lang.String p_renamed() {
        com.oplus.camera.capmode.b_renamed.CameraMediaCodec_3 c0093b = this.U_renamed;
        return (c0093b == null || c0093b.i_renamed != 5) ? com.google.android.exoplayer2.util.MimeTypes.VIDEO_H264 : com.google.android.exoplayer2.util.MimeTypes.VIDEO_H265;
    }

    private android.media.MediaFormat q_renamed() {
        if (this.I_renamed == null) {
            if (com.oplus.camera.util.Util.h_renamed("oplus.software.video.surround_record_support") && com.oplus.camera.util.Util.E_renamed()) {
                if ("normal".equals(this.ah_renamed)) {
                    this.I_renamed = android.media.MediaFormat.createAudioFormat(com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC, r_renamed(), this.U_renamed.f4232b == 0 ? s_renamed() : this.U_renamed.f4232b);
                    this.I_renamed.setInteger("bitrate", this.U_renamed.f4231a == 0 ? 128000 : this.U_renamed.f4231a);
                    this.I_renamed.setString("vendor.ozoaudio.device.value", "");
                    this.I_renamed.setString("vendor.ozoaudio.focus-mode.value", "off");
                } else if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA.equals(this.ah_renamed)) {
                    this.I_renamed = android.media.MediaFormat.createAudioFormat("audio/ozoaudio", r_renamed(), s_renamed());
                    this.I_renamed.setInteger("bitrate", 256000);
                    this.I_renamed.setString("vendor.ozoaudio.device.value", this.ai_renamed);
                    this.I_renamed.setString("vendor.ozoaudio.focus-mode.value", "on_renamed");
                    this.I_renamed.setString("vendor.ozoaudio.mode", "ozoaudio");
                    this.I_renamed.setInteger("vendor.ozoaudio.sample-depth", 16);
                    this.I_renamed.setString("vendor.ozoaudio.focus-azimuth.value", "0.0");
                    this.I_renamed.setString("vendor.ozoaudio.focus-elevation.value", "0.0");
                    this.I_renamed.setString("vendor.ozoaudio.focus-sector-width.value", "100.0");
                    this.I_renamed.setString("vendor.ozoaudio.focus-sector-height.value", "100.0");
                } else if ("focusing".equals(this.ah_renamed)) {
                    this.I_renamed = android.media.MediaFormat.createAudioFormat("audio/ozoaudio", r_renamed(), s_renamed());
                    this.I_renamed.setInteger("bitrate", 256000);
                    this.I_renamed.setString("vendor.ozoaudio.device.value", this.ai_renamed);
                    this.I_renamed.setString("vendor.ozoaudio.focus-mode.value", "on_renamed");
                    this.I_renamed.setString("vendor.ozoaudio.mode", "ozoaudio");
                    this.I_renamed.setInteger("vendor.ozoaudio.sample-depth", 16);
                    this.I_renamed.setString("vendor.ozoaudio.focus-gain.value", java.lang.String.valueOf(com.oplus.camera.util.Util.m_renamed(this.aj_renamed)));
                    this.I_renamed.setString("vendor.ozoaudio.focus-azimuth.value", "0.0");
                    this.I_renamed.setString("vendor.ozoaudio.focus-elevation.value", "0.0");
                    this.I_renamed.setString("vendor.ozoaudio.focus-sector-width.value", "100.0");
                    this.I_renamed.setString("vendor.ozoaudio.focus-sector-height.value", "100.0");
                } else {
                    this.I_renamed = android.media.MediaFormat.createAudioFormat(com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC, r_renamed(), this.U_renamed.f4232b == 0 ? s_renamed() : this.U_renamed.f4232b);
                    this.I_renamed.setInteger("bitrate", this.U_renamed.f4231a == 0 ? 128000 : this.U_renamed.f4231a);
                    this.I_renamed.setString("vendor.ozoaudio.device.value", "");
                    this.I_renamed.setString("vendor.ozoaudio.focus-mode.value", "off");
                }
                if (com.oplus.camera.util.Util.D_renamed()) {
                    this.I_renamed.setString("vendor.ozoaudio.wnr-mode.value", this.ak_renamed);
                }
                this.I_renamed.setInteger("aac-profile", 2);
            } else {
                this.I_renamed = android.media.MediaFormat.createAudioFormat(com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC, r_renamed(), this.U_renamed.f4232b == 0 ? s_renamed() : this.U_renamed.f4232b);
                this.I_renamed.setInteger("bitrate", this.U_renamed.f4231a == 0 ? 128000 : this.U_renamed.f4231a);
                this.I_renamed.setInteger("aac-profile", 2);
            }
        }
        return this.I_renamed;
    }

    private int r_renamed() {
        com.oplus.camera.capmode.b_renamed.CameraMediaCodec_3 c0093b = this.U_renamed;
        if (c0093b == null || c0093b.d_renamed == 0) {
            return 48000;
        }
        return this.U_renamed.d_renamed;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:28:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int s_renamed() {
        /*
            r6 = this;
            java.lang.String r0 = "oplus.software.video.surround_record_support"
            boolean r0 = com.oplus.camera.util.Util.h_renamed(r0)
            if (r0 == 0) goto L2b
            boolean r0 = com.oplus.camera.util.Util.E_renamed()
            if (r0 == 0) goto L2b
            java.lang.String r0 = r6.ah_renamed
            java.lang.String r1 = "panorama"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L1d
            int r0 = r6.p_renamed
            r6.o_renamed = r0
            goto L2b
        L1d:
            java.lang.String r0 = r6.ah_renamed
            java.lang.String r1 = "focusing"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L2b
            int r0 = r6.p_renamed
            r6.o_renamed = r0
        L2b:
            int r6 = r6.o_renamed
            java.lang.String r0 = "CameraMediaCodec"
            r1 = -2
            r2 = 3
            r3 = 2
            r4 = 1
            if (r6 == 0) goto L56
            if (r6 == r4) goto L55
            if (r6 == r3) goto L55
            if (r6 == r2) goto L53
            r5 = 12
            if (r6 == r5) goto L53
            r5 = 16
            if (r6 == r5) goto L55
            r4 = 28
            if (r6 == r4) goto L4c
            r2 = 48
            if (r6 == r2) goto L53
            goto L56
        L4c:
            java.lang.String r6 = "getChannelCount, mChannelConfig: 28"
            com.oplus.camera.e_renamed.c_renamed(r0, r6)
            r1 = r2
            goto L56
        L53:
            r1 = r3
            goto L56
        L55:
            r1 = r4
        L56:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = "getChannelCount, channelCount: "
            r6.append(r2)
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            com.oplus.camera.e_renamed.a_renamed(r0, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.b_renamed.s_renamed():int");
    }

    public void a_renamed(long j_renamed) {
        this.y_renamed = j_renamed * 1000;
    }

    public void b_renamed(long j_renamed) {
        this.z_renamed = (long) (j_renamed * 0.9f);
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "prepare");
        i_renamed();
        k_renamed();
        l_renamed();
        if (this.A_renamed == null) {
            try {
                if (this.D_renamed != null) {
                    this.A_renamed = new android.media.MediaMuxer(this.D_renamed, this.U_renamed.f_renamed);
                } else {
                    this.A_renamed = new android.media.MediaMuxer(this.C_renamed, this.U_renamed.f_renamed);
                }
                this.A_renamed.setOrientationHint(this.m_renamed);
                this.A_renamed.setLocation(this.W_renamed, this.X_renamed);
            } catch (java.io.IOException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    public void c_renamed(int i_renamed) {
        this.m_renamed = i_renamed;
    }

    public boolean d_renamed() throws java.lang.InterruptedException {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", com.google.android.exoplayer2.text.ttml.TtmlNode.START);
        this.ar_renamed.clear();
        if (this.g_renamed) {
            this.g_renamed = com.oplus.camera.util.Util.as_renamed();
        }
        this.O_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.b_renamed.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.oplus.camera.capmode.b_renamed.this.w_renamed();
                } finally {
                    com.oplus.camera.capmode.b_renamed.this.V_renamed.countDown();
                    com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "start, initVideoCodec end");
                }
            }
        });
        this.P_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.b_renamed.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.oplus.camera.capmode.b_renamed.this.g_renamed) {
                        com.oplus.camera.capmode.b_renamed.this.v_renamed();
                    }
                } finally {
                    com.oplus.camera.capmode.b_renamed.this.V_renamed.countDown();
                    com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "start, initAudioCodec end");
                }
            }
        });
        try {
            this.V_renamed.await();
        } catch (java.lang.InterruptedException e_renamed) {
            e_renamed.printStackTrace();
        }
        this.ad_renamed = false;
        this.ae_renamed = false;
        m_renamed(1);
        this.ab_renamed = this.g_renamed ? H_renamed() : true;
        com.oplus.camera.gl_renamed.q_renamed qVar = this.N_renamed;
        if (qVar != null) {
            qVar.k_renamed();
        } else {
            com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "start, mGLSurfaceView is_renamed null");
        }
        return this.ab_renamed;
    }

    public boolean e_renamed() throws java.lang.IllegalStateException, android.media.MediaCodec.CryptoException {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "stop, mRecorderState: " + this.B_renamed);
        if (this.au_renamed) {
            this.au_renamed = false;
            if (this.av_renamed) {
                this.aw_renamed.close();
                this.aw_renamed.block();
            }
        }
        if (3 == this.B_renamed) {
            return true;
        }
        this.T_renamed.close();
        m_renamed(3);
        synchronized (this.f4217b) {
            this.f4217b.notifyAll();
        }
        synchronized (this.f4216a) {
            this.f4216a.notifyAll();
        }
        com.oplus.camera.gl_renamed.q_renamed qVar = this.N_renamed;
        if (qVar != null) {
            qVar.j_renamed();
        } else {
            com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "stop, mGLSurfaceView is_renamed null");
        }
        this.u_renamed = 0L;
        this.t_renamed = 0L;
        C_renamed();
        A_renamed();
        this.aq_renamed = false;
        if (this.g_renamed) {
            t_renamed();
            u_renamed();
        }
        com.oplus.camera.gl_renamed.z_renamed zVar = this.am_renamed;
        if (zVar != null && !this.ao_renamed) {
            zVar.a_renamed();
        }
        android.os.Handler handler = this.an_renamed;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.an_renamed = null;
        }
        android.os.Handler handler2 = this.as_renamed;
        if (handler2 != null) {
            handler2.getLooper().quitSafely();
            this.as_renamed = null;
        }
        this.T_renamed.block();
        return this.ab_renamed;
    }

    private void t_renamed() throws java.lang.IllegalStateException {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "stopAudioInput");
        android.media.AudioRecord audioRecord = this.K_renamed;
        if (audioRecord != null) {
            audioRecord.stop();
            this.K_renamed.release();
        }
    }

    private void u_renamed() throws android.media.MediaCodec.CryptoException {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "stopAudioEncode, mAudioCodec: " + this.F_renamed + ", mbAudioCodecOutputDataCome: " + this.ae_renamed);
        if (this.ae_renamed) {
            android.media.MediaCodec mediaCodec = this.F_renamed;
            if (mediaCodec != null) {
                this.F_renamed.queueInputBuffer(mediaCodec.dequeueInputBuffer(-1L), 0, 0, 0L, 4);
                return;
            }
            return;
        }
        B_renamed();
        E_renamed();
    }

    public void f_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", com.oplus.camera.statistics.model.VideoRecordMsgData.EVENT_PAUSE);
        this.t_renamed = java.lang.System.nanoTime();
        m_renamed(2);
        this.u_renamed = 0L;
        com.oplus.camera.gl_renamed.q_renamed qVar = this.N_renamed;
        if (qVar != null) {
            qVar.j_renamed();
        } else {
            com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "pause, mGLSurfaceView is_renamed null");
        }
    }

    public void g_renamed() {
        this.u_renamed = java.lang.System.nanoTime();
        this.v_renamed += this.u_renamed - this.t_renamed;
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "resume, mPausedTime: " + this.v_renamed);
        m_renamed(1);
        synchronized (this.f4217b) {
            this.f4217b.notifyAll();
        }
        com.oplus.camera.gl_renamed.q_renamed qVar = this.N_renamed;
        if (qVar != null) {
            qVar.k_renamed();
        } else {
            com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "resume, mGLSurfaceView is_renamed null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "initAudioCodec, mAudioType: " + this.ah_renamed);
        try {
            if (!com.oplus.camera.util.Util.h_renamed("oplus.software.video.surround_record_support") || !com.oplus.camera.util.Util.E_renamed() || "normal".equals(this.ah_renamed)) {
                this.F_renamed = android.media.MediaCodec.createEncoderByType(com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC);
            } else if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA.equals(this.ah_renamed) || "focusing".equals(this.ah_renamed)) {
                this.F_renamed = android.media.MediaCodec.createEncoderByType("audio/ozoaudio");
            } else {
                this.F_renamed = android.media.MediaCodec.createEncoderByType(com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC);
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        this.F_renamed.configure(q_renamed(), (android.view.Surface) null, (android.media.MediaCrypto) null, 1);
        this.F_renamed.start();
        this.J_renamed = this.F_renamed.getInputBuffers();
        this.P_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.b_renamed.6
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "initAudioCodec, AudioEncode run");
                com.oplus.camera.capmode.b_renamed.this.z_renamed();
            }
        });
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "initAudioCodec, mInputByteBuffer.length: " + this.J_renamed.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @android.annotation.TargetApi(23)
    public void w_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "initVideoCodec");
        try {
            this.E_renamed = android.media.MediaCodec.createEncoderByType(p_renamed());
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        this.E_renamed.configure(o_renamed(), (android.view.Surface) null, (android.media.MediaCrypto) null, 1);
        if (this.at_renamed) {
            this.E_renamed.setCallback(this.aA_renamed, this.O_renamed);
            this.G_renamed = this.E_renamed.createInputSurface();
            if (this.ao_renamed) {
                this.N_renamed.setOutput(this.G_renamed);
            } else if (this.ap_renamed) {
                this.L_renamed.a_renamed(this.G_renamed);
            } else {
                if (this.an_renamed == null) {
                    android.os.HandlerThread handlerThread = new android.os.HandlerThread("VideoCodecInputThread");
                    handlerThread.start();
                    this.an_renamed = new android.os.Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.capmode.b_renamed.7
                        @Override // android.os.Handler
                        public void handleMessage(android.os.Message message) {
                            if (message.what != 1) {
                                return;
                            }
                            com.oplus.camera.capmode.b_renamed.this.a_renamed((android.hardware.HardwareBuffer) message.obj);
                            message.obj = null;
                        }
                    };
                }
                this.al_renamed = new com.oplus.camera.gl_renamed.m_renamed<>(this.G_renamed);
                this.al_renamed.a_renamed(2);
                this.al_renamed.a_renamed(8, 8, 8, 8, 0, 0);
                this.am_renamed = new com.oplus.camera.gl_renamed.z_renamed();
                this.af_renamed = false;
            }
        } else if (this.as_renamed == null) {
            android.os.HandlerThread handlerThread2 = new android.os.HandlerThread("Encode YUV Thread");
            handlerThread2.start();
            this.as_renamed = new android.os.Handler(handlerThread2.getLooper()) { // from class: com.oplus.camera.capmode.b_renamed.8
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    int i_renamed = message.what;
                    if (i_renamed == 1) {
                        android.os.Message messageObtain = android.os.Message.obtain();
                        messageObtain.obj = com.oplus.camera.capmode.b_renamed.this.a_renamed((com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage) message.obj);
                        messageObtain.what = 2;
                        com.oplus.camera.capmode.b_renamed.this.as_renamed.sendMessage(messageObtain);
                        return;
                    }
                    if (i_renamed != 2) {
                        return;
                    }
                    try {
                        com.oplus.camera.capmode.b_renamed.this.b_renamed((byte[]) message.obj);
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                }
            };
        }
        this.E_renamed.start();
        this.e_renamed.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a_renamed(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        byte[] bArrE;
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "getYuvDataFromImage, time : " + jUptimeMillis + ", image : " + cameraPictureImage);
        int width = cameraPictureImage.getWidth();
        int height = cameraPictureImage.getHeight();
        int stride = cameraPictureImage.getStride();
        int scanline = cameraPictureImage.getScanline();
        int orientation = cameraPictureImage.getOrientation();
        if (cameraPictureImage.getImage() != null) {
            byte[] bArrB = com.oplus.camera.util.Util.b_renamed(cameraPictureImage.getImage(), width, height, stride, scanline);
            com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "getYuvDataFromImage, drop deal byte[] cost : " + (android.os.SystemClock.uptimeMillis() - jUptimeMillis));
            if (height < width) {
                if (orientation == 0 || 90 == orientation || 180 == orientation) {
                    bArrB = com.oplus.camera.util.Util.a_renamed(bArrB, width, height);
                } else if (270 == orientation) {
                    bArrB = com.oplus.camera.util.Util.b_renamed(bArrB, width, height);
                }
            }
            com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "getYuvDataFromImage, rotate deal byte[] cost : " + (android.os.SystemClock.uptimeMillis() - jUptimeMillis));
            bArrE = com.oplus.camera.util.Util.e_renamed(bArrB, width, height);
        } else {
            bArrE = null;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "getYuvDataFromImage, encode deal byte[] cost : " + (android.os.SystemClock.uptimeMillis() - jUptimeMillis));
        return bArrE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(byte[] bArr) throws android.media.MediaCodec.CryptoException {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "encodeYuvData, inputData: " + bArr + ", mRecorderState: " + this.B_renamed);
        if (bArr == null || this.B_renamed == 3) {
            return;
        }
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        this.av_renamed = true;
        int length = bArr.length;
        int iDequeueInputBuffer = this.E_renamed.dequeueInputBuffer(0L);
        java.nio.ByteBuffer inputBuffer = null;
        if (iDequeueInputBuffer >= 0) {
            inputBuffer = this.E_renamed.getInputBuffer(iDequeueInputBuffer);
            inputBuffer.clear();
            inputBuffer.put(bArr);
            long j_renamed = this.Z_renamed;
            if (j_renamed < 0) {
                this.Z_renamed = java.lang.System.nanoTime();
            } else {
                this.Z_renamed = j_renamed + ((int) (1000000.0f / this.U_renamed.k_renamed));
            }
            this.E_renamed.queueInputBuffer(iDequeueInputBuffer, 0, length, this.Z_renamed, 0);
        }
        android.media.MediaCodec.BufferInfo bufferInfo = new android.media.MediaCodec.BufferInfo();
        int iDequeueOutputBuffer = this.E_renamed.dequeueOutputBuffer(bufferInfo, 0L);
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "encodeYuvData, startEncoder out index " + iDequeueOutputBuffer);
        if (-2 == iDequeueOutputBuffer) {
            android.media.MediaCodec.Callback callback = this.aA_renamed;
            android.media.MediaCodec mediaCodec = this.E_renamed;
            callback.onOutputFormatChanged(mediaCodec, mediaCodec.getOutputFormat());
        }
        while (iDequeueOutputBuffer >= 0) {
            this.aA_renamed.onOutputBufferAvailable(this.E_renamed, iDequeueOutputBuffer, bufferInfo);
            iDequeueOutputBuffer = this.E_renamed.dequeueOutputBuffer(bufferInfo, 0L);
        }
        if (inputBuffer != null) {
            inputBuffer.clear();
        }
        this.av_renamed = false;
        this.aw_renamed.open();
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "encodeYuvData, encode cost time : " + (android.os.SystemClock.uptimeMillis() - jUptimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a_renamed(android.media.MediaCodec.BufferInfo bufferInfo) {
        com.oplus.camera.capmode.c_renamed cVar = this.L_renamed;
        if (cVar != null) {
            return cVar.a_renamed(bufferInfo);
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "releaseVideoCodec");
        try {
            try {
                if (this.E_renamed != null) {
                    this.E_renamed.stop();
                    this.E_renamed.release();
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
            com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "releaseVideoCodec, end");
        } finally {
            this.j_renamed = -1;
        }
    }

    private void y_renamed() {
        this.al_renamed.a_renamed(this.am_renamed);
        this.al_renamed.b_renamed(0);
        this.al_renamed.a_renamed((android.view.SurfaceHolder) null);
        this.al_renamed.a_renamed(null, 0, this.U_renamed.l_renamed, this.U_renamed.j_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.hardware.HardwareBuffer hardwareBuffer) {
        if (this.E_renamed == null) {
            hardwareBuffer.close();
            return;
        }
        this.am_renamed.a_renamed(hardwareBuffer);
        if (!this.af_renamed) {
            this.af_renamed = true;
            y_renamed();
        }
        this.al_renamed.d_renamed();
    }

    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "updateSavePatch, mbSaveInSDCard is_renamed " + this.h_renamed);
        this.h_renamed = z_renamed;
    }

    public void a_renamed(byte[] bArr) {
        com.oplus.camera.e_renamed.c_renamed("CameraMediaCodec", "addYuvData " + bArr + ", " + this.au_renamed);
        if (bArr == null || this.at_renamed || 3 == this.B_renamed) {
            return;
        }
        if (!this.au_renamed) {
            this.au_renamed = true;
        }
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.obj = bArr;
        messageObtain.what = 2;
        this.as_renamed.sendMessage(messageObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(byte[] bArr, int i_renamed, int i2) throws android.media.MediaCodec.CryptoException {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("addAudioFrame, mAudioCodec: ");
        sb.append(this.F_renamed);
        sb.append(", mRecorderState: ");
        sb.append(this.B_renamed);
        sb.append(", audioData: ");
        if (bArr == null || 1 > bArr.length) {
            str = "empty";
        } else {
            str = "first : " + ((int) bArr[0]);
        }
        sb.append(str);
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", sb.toString());
        if (this.F_renamed != null) {
            int iDequeueInputBuffer = -1;
            while (true) {
                if (iDequeueInputBuffer >= 0) {
                    break;
                }
                iDequeueInputBuffer = this.F_renamed.dequeueInputBuffer(com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "addAudioFrame, outputBufferIndex: " + iDequeueInputBuffer);
                if (iDequeueInputBuffer < 0 && 1 != this.B_renamed) {
                    com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "addAudioFrame break, mRecorderState: " + this.B_renamed);
                    break;
                }
            }
            int i3 = iDequeueInputBuffer;
            if (bArr == null || i3 < 0) {
                return;
            }
            if (0 == this.s_renamed) {
                this.s_renamed = java.lang.System.nanoTime();
            }
            this.J_renamed[i3].position(0);
            this.J_renamed[i3].put(bArr, i_renamed, i2);
            this.F_renamed.queueInputBuffer(i3, 0, i2, (this.s_renamed + (this.q_renamed * this.r_renamed)) / 1000, 0);
            this.q_renamed++;
        }
    }

    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "setBinauralRecordingState, enable: " + z_renamed);
        this.aq_renamed = z_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z_renamed() {
        android.media.MediaCodec.BufferInfo bufferInfo;
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "audioEncoder, start");
        java.nio.ByteBuffer[] outputBuffers = this.F_renamed.getOutputBuffers();
        while (true) {
            try {
                bufferInfo = new android.media.MediaCodec.BufferInfo();
                int iDequeueOutputBuffer = this.F_renamed.dequeueOutputBuffer(bufferInfo, -1L);
                if (iDequeueOutputBuffer == -3) {
                    outputBuffers = this.F_renamed.getOutputBuffers();
                } else if (iDequeueOutputBuffer == -2) {
                    synchronized (this.f4216a) {
                        if (this.k_renamed < 0) {
                            com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "audioEncoder, addTrack mAudioTrack");
                            if (this.l_renamed < 0 && this.aq_renamed) {
                                com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "audioEncoder, addTrack mMetadataTrack");
                                android.media.MediaFormat mediaFormat = new android.media.MediaFormat(this.I_renamed);
                                mediaFormat.setString(com.oplus.tblplayer.misc.IMediaFormat.KEY_MIME, "application/binaural");
                                this.l_renamed = this.A_renamed.addTrack(mediaFormat);
                            }
                            this.k_renamed = this.A_renamed.addTrack(this.F_renamed.getOutputFormat());
                            D_renamed();
                        }
                    }
                } else if (iDequeueOutputBuffer == -1) {
                    com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "audioEncoder, Audio INFO_TRY_AGAIN_LATER");
                } else {
                    if (bufferInfo.flags == 4) {
                        break;
                    }
                    if (bufferInfo.flags == 2) {
                        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "audioEncoder, Audio BUFFER_FLAG_CODEC_CONFIG");
                    } else if (bufferInfo.flags == 1) {
                        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "audioEncoder, Audio BUFFER_FLAG_SYNC_FRAME");
                    } else if (!this.ac_renamed) {
                        com.oplus.camera.e_renamed.b_renamed("CameraMediaCodec", "audioEncoder, mbMuxerStarted: " + this.ac_renamed);
                    } else {
                        if (this.x_renamed < 0) {
                            this.x_renamed = bufferInfo.presentationTimeUs;
                            this.i_renamed = false;
                        }
                        if (this.i_renamed) {
                            if (-1 == this.w_renamed) {
                                if (bufferInfo.presentationTimeUs - this.x_renamed > 200000) {
                                    this.w_renamed = (bufferInfo.presentationTimeUs - this.x_renamed) - 200000;
                                } else {
                                    this.w_renamed = 0L;
                                }
                            }
                            bufferInfo.presentationTimeUs -= this.w_renamed;
                        }
                        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "audioEncoder, audio bufferInfo.presentationTimeUs: " + bufferInfo.presentationTimeUs);
                        if (this.h_renamed) {
                            java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(outputBuffers[iDequeueOutputBuffer].capacity());
                            byteBufferAllocate.put(outputBuffers[iDequeueOutputBuffer]);
                            this.ar_renamed.add(new com.oplus.camera.capmode.b_renamed.c_renamed(this.k_renamed, byteBufferAllocate, bufferInfo, true));
                            this.Q_renamed.sendEmptyMessage(1);
                        } else {
                            a_renamed(this.k_renamed, outputBuffers[iDequeueOutputBuffer], bufferInfo);
                        }
                        synchronized (this.f4218c) {
                            this.aa_renamed += bufferInfo.size;
                        }
                        this.F_renamed.releaseOutputBuffer(iDequeueOutputBuffer, false);
                        if (this.y_renamed > 0 && bufferInfo.presentationTimeUs - this.x_renamed >= this.y_renamed) {
                            com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "audioEncoder, reach to max duration time");
                            this.M_renamed.sendMessage(this.M_renamed.obtainMessage(1, 800, -1));
                            this.y_renamed = -1L;
                        } else if (this.z_renamed > 0 && this.aa_renamed >= this.z_renamed) {
                            com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "audioEncoder, reach to max file size");
                            this.M_renamed.sendMessage(this.M_renamed.obtainMessage(1, 801, -1));
                            this.z_renamed = -1L;
                        }
                        if (2 == this.B_renamed) {
                            this.t_renamed = java.lang.System.nanoTime();
                        }
                        this.ae_renamed = true;
                    }
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
                android.os.Message messageObtainMessage = this.M_renamed.obtainMessage(3, 1);
                this.M_renamed.removeMessages(3);
                this.M_renamed.sendMessage(messageObtainMessage);
            }
        }
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "audioEncoder, Audio BUFFER_FLAG_END_OF_STREAM");
        if (this.l_renamed >= 0 && this.aq_renamed) {
            com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "audioEncoder, write metadata track");
            java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(new byte[]{0});
            android.media.MediaCodec.BufferInfo bufferInfo2 = new android.media.MediaCodec.BufferInfo();
            bufferInfo2.set(0, byteBufferWrap.capacity(), 0L, 0);
            if (this.i_renamed) {
                bufferInfo2.presentationTimeUs = bufferInfo.presentationTimeUs - this.w_renamed;
            } else {
                bufferInfo2.presentationTimeUs = bufferInfo.presentationTimeUs;
            }
            a_renamed(this.l_renamed, byteBufferWrap, bufferInfo2);
        }
        if (this.h_renamed) {
            this.ar_renamed.add(new com.oplus.camera.capmode.b_renamed.c_renamed(this.k_renamed, null, bufferInfo, true));
            this.Q_renamed.sendEmptyMessage(1);
        } else {
            B_renamed();
            E_renamed();
        }
        this.q_renamed = 0;
        this.r_renamed = 0L;
        this.s_renamed = 0L;
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "audioEncoder, release audio codec");
    }

    private void A_renamed() {
        try {
            try {
                if (this.R_renamed != null && this.R_renamed.isAlive()) {
                    com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "releaseAudioCodec, audio input thread not end and we wait it here");
                    this.R_renamed.join();
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        } finally {
            this.R_renamed = null;
        }
    }

    private void B_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "releaseAudioCodec");
        A_renamed();
        synchronized (this.d_renamed) {
            try {
                try {
                    com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "releaseAudioCodec, mAudioCodec: " + this.F_renamed);
                    if (this.F_renamed != null) {
                        this.F_renamed.stop();
                        this.F_renamed.release();
                    }
                    this.k_renamed = -1;
                    this.F_renamed = null;
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                    this.k_renamed = -1;
                    this.F_renamed = null;
                }
                this.l_renamed = -1;
            } catch (java.lang.Throwable th) {
                this.k_renamed = -1;
                this.F_renamed = null;
                this.l_renamed = -1;
                throw th;
            }
        }
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "releaseAudioCodec, end");
    }

    private void C_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "stopVideoEncode, mbVideoCodecOutputDataCome: " + this.ad_renamed);
        com.oplus.camera.gl_renamed.q_renamed qVar = this.N_renamed;
        if (qVar != null) {
            qVar.h_renamed();
        }
        if (this.ad_renamed) {
            android.media.MediaCodec mediaCodec = this.E_renamed;
            if (mediaCodec != null) {
                mediaCodec.signalEndOfInputStream();
                return;
            }
            return;
        }
        android.os.Handler handler = this.O_renamed;
        if (handler != null) {
            handler.post(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.b_renamed.9
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.capmode.b_renamed.this.x_renamed();
                    com.oplus.camera.capmode.b_renamed.this.E_renamed();
                    if (com.oplus.camera.capmode.b_renamed.this.G_renamed != null) {
                        com.oplus.camera.capmode.b_renamed.this.G_renamed.release();
                    }
                }
            });
        }
    }

    private void m_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "setRecordState, mRecorderState: " + this.B_renamed + " => " + i_renamed);
        this.B_renamed = i_renamed;
    }

    public void d_renamed(int i_renamed) {
        this.U_renamed.h_renamed = i_renamed;
    }

    public void e_renamed(int i_renamed) {
        this.U_renamed.k_renamed = i_renamed;
    }

    public void f_renamed(int i_renamed) {
        this.U_renamed.f_renamed = i_renamed;
    }

    public void a_renamed(float f_renamed, float f2) {
        this.W_renamed = f_renamed;
        this.X_renamed = f2;
    }

    public void a_renamed(java.io.FileDescriptor fileDescriptor) {
        this.D_renamed = fileDescriptor;
    }

    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.capmode.b_renamed.CameraMediaCodec_3 c0093b = this.U_renamed;
        c0093b.l_renamed = i2;
        c0093b.j_renamed = i_renamed;
    }

    public void g_renamed(int i_renamed) {
        this.U_renamed.i_renamed = i_renamed;
    }

    public void h_renamed(int i_renamed) {
        this.U_renamed.f4231a = i_renamed;
    }

    public void i_renamed(int i_renamed) {
        this.U_renamed.f4232b = i_renamed;
    }

    public void j_renamed(int i_renamed) {
        this.U_renamed.d_renamed = i_renamed;
    }

    public void k_renamed(int i_renamed) {
        this.U_renamed.f4233c = i_renamed;
    }

    public void e_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "setAudioEnable, enable: " + z_renamed);
        this.g_renamed = z_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "startMediaMuxer, mVideoTrack: " + this.j_renamed + ", mAudioTrack: " + this.k_renamed);
        if (this.g_renamed) {
            synchronized (this.f4216a) {
                if (this.j_renamed >= 0 && this.k_renamed >= 0) {
                    if (!this.ac_renamed) {
                        this.A_renamed.start();
                        this.ac_renamed = true;
                    }
                    this.f4216a.notifyAll();
                } else {
                    try {
                        if (this.j_renamed < 0 || this.k_renamed < 0) {
                            this.f4216a.wait();
                        }
                    } catch (java.lang.InterruptedException e_renamed) {
                        e_renamed.printStackTrace();
                    }
                }
            }
            return;
        }
        if (this.ac_renamed) {
            return;
        }
        this.A_renamed.start();
        this.ac_renamed = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't_renamed wrap try/catch for region: R_renamed(7:55|6|(3:8|52|(6:53|10|(1:12)|13|14|31))|50|23|(1:27)|31) */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:29:0x00a4, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:30:0x00a5, code lost:
    
        r4.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void E_renamed() {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.b_renamed.E_renamed():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, java.nio.ByteBuffer byteBuffer, android.media.MediaCodec.BufferInfo bufferInfo) {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "writeSampleData");
        android.media.MediaMuxer mediaMuxer = this.A_renamed;
        if (mediaMuxer != null) {
            mediaMuxer.writeSampleData(i_renamed, byteBuffer, bufferInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F_renamed() {
        if (this.n_renamed == 0) {
            this.n_renamed = android.media.AudioRecord.getMinBufferSize(r_renamed(), 12, 2);
            if (this.J_renamed[0].capacity() < this.n_renamed) {
                this.n_renamed = this.J_renamed[0].capacity();
            }
        }
        int iS = s_renamed() * com.oplus.camera.util.Util.p_renamed(2) * 1024;
        if (iS < this.n_renamed) {
            this.n_renamed = iS;
        }
        return this.n_renamed;
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    private void G_renamed() {
        if (this.K_renamed == null) {
            if (com.oplus.camera.util.Util.h_renamed("oplus.software.video.surround_record_support") && com.oplus.camera.util.Util.E_renamed()) {
                if ("normal".equals(this.ah_renamed)) {
                    this.K_renamed = new android.media.AudioRecord(5, r_renamed(), 12, 2, F_renamed());
                    return;
                }
                if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA.equals(this.ah_renamed)) {
                    this.K_renamed = new android.media.AudioRecord(5, r_renamed(), 28, 2, F_renamed());
                    return;
                }
                if ("focusing".equals(this.ah_renamed)) {
                    this.K_renamed = new android.media.AudioRecord(5, r_renamed(), 28, 2, F_renamed());
                    return;
                }
                com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", " mAudioType: " + this.ah_renamed + " is_renamed wrong");
                return;
            }
            this.K_renamed = new android.media.AudioRecord(5, r_renamed(), 12, 2, F_renamed());
        }
    }

    private boolean H_renamed() throws java.lang.IllegalStateException {
        com.oplus.camera.e_renamed.a_renamed("CameraMediaCodec", "startAudioInput");
        if (this.K_renamed == null) {
            G_renamed();
        }
        android.media.AudioRecord audioRecord = this.K_renamed;
        boolean z_renamed = false;
        if (audioRecord == null) {
            return false;
        }
        audioRecord.startRecording();
        if (this.K_renamed.getRecordingState() != 3) {
            com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "startAudioInput, mAudioRecord may be_renamed conflict or have some other exception");
        } else {
            z_renamed = true;
        }
        final byte[] bArr = new byte[F_renamed()];
        this.f_renamed = java.lang.System.currentTimeMillis();
        this.r_renamed = (((F_renamed() * com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND) / this.K_renamed.getChannelCount()) / r_renamed()) / com.oplus.camera.util.Util.p_renamed(this.K_renamed.getAudioFormat());
        this.R_renamed = new java.lang.Thread("audio input thread") { // from class: com.oplus.camera.capmode.b_renamed.10
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws android.media.MediaCodec.CryptoException {
                while (true) {
                    if (1 != com.oplus.camera.capmode.b_renamed.this.B_renamed) {
                        if (3 != com.oplus.camera.capmode.b_renamed.this.B_renamed) {
                            if (2 == com.oplus.camera.capmode.b_renamed.this.B_renamed) {
                                com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "startAudioInput, AudioInput pause");
                                synchronized (com.oplus.camera.capmode.b_renamed.this.f4217b) {
                                    try {
                                        if (2 == com.oplus.camera.capmode.b_renamed.this.B_renamed) {
                                            com.oplus.camera.capmode.b_renamed.this.f4217b.wait();
                                        }
                                    } catch (java.lang.InterruptedException e_renamed) {
                                        e_renamed.printStackTrace();
                                    }
                                }
                            }
                        } else {
                            com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "startAudioInput, AudioInput stop");
                            return;
                        }
                    } else {
                        long jNanoTime = java.lang.System.nanoTime();
                        int i_renamed = com.oplus.camera.capmode.b_renamed.this.K_renamed.read(bArr, 0, com.oplus.camera.capmode.b_renamed.this.F_renamed());
                        if ((java.lang.System.nanoTime() - jNanoTime) / 1000000 < 3 && (java.lang.System.nanoTime() - com.oplus.camera.capmode.b_renamed.this.u_renamed) / 1000000 < 50) {
                            com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "startAudioInput, mAudioRecord.read cost: " + ((java.lang.System.nanoTime() - jNanoTime) / 1000000) + ", drop it");
                        } else {
                            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                            if (i_renamed > 0) {
                                if (500 < jCurrentTimeMillis - com.oplus.camera.capmode.b_renamed.this.f_renamed) {
                                    com.oplus.camera.capmode.b_renamed.this.a_renamed(bArr, 0, i_renamed);
                                } else {
                                    byte[] bArr2 = new byte[i_renamed];
                                    java.util.Arrays.fill(bArr2, (byte) 0);
                                    com.oplus.camera.capmode.b_renamed.this.a_renamed(bArr2, 0, i_renamed);
                                    com.oplus.camera.e_renamed.f_renamed("CameraMediaCodec", "startAudioInput, send empty");
                                }
                            }
                        }
                    }
                }
            }
        };
        this.R_renamed.start();
        return z_renamed;
    }

    public void l_renamed(int i_renamed) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("vendor.ozoaudio.focus-gain.value", java.lang.String.valueOf(com.oplus.camera.util.Util.m_renamed(i_renamed)));
        synchronized (this.d_renamed) {
            if (this.F_renamed != null) {
                this.F_renamed.setParameters(bundle);
            }
        }
    }

    public void a_renamed(com.oplus.camera.capmode.c_renamed cVar) {
        this.L_renamed = cVar;
    }

    public void f_renamed(boolean z_renamed) {
        this.ao_renamed = z_renamed;
    }

    public void g_renamed(boolean z_renamed) {
        this.ag_renamed = z_renamed;
    }

    public void h_renamed(boolean z_renamed) {
        this.ap_renamed = z_renamed;
    }

    /* compiled from: CameraMediaCodec.java */
    private class a_renamed extends android.os.Handler {
        public a_renamed(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i_renamed = message.what;
            if (i_renamed == 1) {
                if (com.oplus.camera.capmode.b_renamed.this.L_renamed != null) {
                    com.oplus.camera.capmode.b_renamed.this.L_renamed.a_renamed(com.oplus.camera.capmode.b_renamed.this, message.arg1, message.arg2);
                }
            } else {
                if (i_renamed != 2) {
                    if (i_renamed == 3 && com.oplus.camera.capmode.b_renamed.this.L_renamed != null) {
                        com.oplus.camera.capmode.b_renamed.this.L_renamed.a_renamed(((java.lang.Integer) message.obj).intValue());
                        return;
                    }
                    return;
                }
                if (com.oplus.camera.capmode.b_renamed.this.L_renamed != null) {
                    com.oplus.camera.capmode.b_renamed.this.L_renamed.b_renamed(com.oplus.camera.capmode.b_renamed.this, message.arg1, message.arg2);
                }
            }
        }
    }

    public void h_renamed() {
        while (!this.ar_renamed.isEmpty()) {
            try {
                com.oplus.camera.capmode.b_renamed.c_renamed cVarRemove = this.ar_renamed.remove(0);
                if (cVarRemove.d_renamed.flags == 4) {
                    if (cVarRemove.f4234a) {
                        B_renamed();
                    } else if (this.O_renamed != null) {
                        this.O_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.b_renamed.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    com.oplus.camera.capmode.b_renamed.this.x_renamed();
                                } finally {
                                    com.oplus.camera.capmode.b_renamed.this.S_renamed.open();
                                }
                            }
                        });
                        this.S_renamed.close();
                        this.S_renamed.block();
                    }
                    if (this.k_renamed < 0 && this.j_renamed < 0) {
                        E_renamed();
                        if (this.G_renamed != null) {
                            this.G_renamed.release();
                        }
                    }
                } else {
                    a_renamed(cVarRemove.f4235b, cVarRemove.f4236c, cVarRemove.d_renamed);
                    cVarRemove.f4236c.clear();
                    cVarRemove.f4236c = null;
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
                android.os.Message messageObtainMessage = this.M_renamed.obtainMessage(3, 1);
                this.M_renamed.removeMessages(3);
                this.M_renamed.sendMessage(messageObtainMessage);
                return;
            }
        }
    }
}

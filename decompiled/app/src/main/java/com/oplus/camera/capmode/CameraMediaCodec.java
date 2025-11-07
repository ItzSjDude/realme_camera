package com.oplus.camera.capmode;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.hardware.HardwareBuffer;
import android.media.AudioRecord;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.C1547C;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.util.MimeTypes;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p146gl.GLProducer;
import com.oplus.camera.p146gl.YUVRenderer;
import com.oplus.camera.p146gl.OplusGLSurfaceView;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraPictureCallback;
import com.oplus.tblplayer.misc.IMediaFormat;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: CameraMediaCodec.java */
/* renamed from: com.oplus.camera.capmode.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class CameraMediaCodec {

    /* renamed from: M */
    private PlatformImplementations.kt_3 f12717M;

    /* renamed from: az */
    private volatile boolean f12758az;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object f12731a = new Object();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Object f12759b = new Object();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Object f12760c = new Object();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Object f12761d = new Object();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AtomicBoolean f12762e = new AtomicBoolean(false);

    /* renamed from: COUIBaseListPopupWindow_12 */
    private volatile long f12763f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f12764g = true;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f12765h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f12766i = false;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f12767j = -1;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f12768k = -1;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f12769l = -1;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f12770m = 0;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f12771n = 0;

    /* renamed from: o */
    private int f12772o = 12;

    /* renamed from: p */
    private int f12773p = 28;

    /* renamed from: q */
    private int f12774q = 0;

    /* renamed from: r */
    private long f12775r = 0;

    /* renamed from: s */
    private long f12776s = 0;

    /* renamed from: t */
    private long f12777t = 0;

    /* renamed from: u */
    private long f12778u = 0;

    /* renamed from: v */
    private long f12779v = 0;

    /* renamed from: w */
    private long f12780w = -1;

    /* renamed from: x */
    private long f12781x = -1;

    /* renamed from: y */
    private long f12782y = -1;

    /* renamed from: z */
    private long f12783z = -1;

    /* renamed from: A */
    private MediaMuxer f12705A = null;

    /* renamed from: B */
    private int f12706B = 3;

    /* renamed from: C */
    private String f12707C = null;

    /* renamed from: D */
    private FileDescriptor f12708D = null;

    /* renamed from: E */
    private MediaCodec f12709E = null;

    /* renamed from: F */
    private MediaCodec f12710F = null;

    /* renamed from: G */
    private Surface f12711G = null;

    /* renamed from: H */
    private MediaFormat f12712H = null;

    /* renamed from: I */
    private MediaFormat f12713I = null;

    /* renamed from: J */
    private ByteBuffer[] f12714J = null;

    /* renamed from: K */
    private AudioRecord f12715K = null;

    /* renamed from: L */
    private CameraMediaCodecListener f12716L = null;

    /* renamed from: N */
    private OplusGLSurfaceView f12718N = null;

    /* renamed from: O */
    private Handler f12719O = null;

    /* renamed from: P */
    private Handler f12720P = null;

    /* renamed from: Q */
    private Handler f12721Q = null;

    /* renamed from: R */
    private Thread f12722R = null;

    /* renamed from: S */
    private ConditionVariable f12723S = new ConditionVariable();

    /* renamed from: T */
    private ConditionVariable f12724T = new ConditionVariable();

    /* renamed from: U */
    private IntrinsicsJvm.kt_4 f12725U = new IntrinsicsJvm.kt_4();

    /* renamed from: V */
    private CountDownLatch f12726V = new CountDownLatch(2);

    /* renamed from: W */
    private float f12727W = 0.0f;

    /* renamed from: X */
    private float f12728X = 0.0f;

    /* renamed from: Y */
    private int f12729Y = -1;

    /* renamed from: Z */
    private long f12730Z = -1;

    /* renamed from: aa */
    private long f12733aa = 0;

    /* renamed from: ab */
    private boolean f12734ab = true;

    /* renamed from: ac */
    private boolean f12735ac = false;

    /* renamed from: ad */
    private boolean f12736ad = false;

    /* renamed from: ae */
    private boolean f12737ae = false;

    /* renamed from: af */
    private boolean f12738af = false;

    /* renamed from: ag */
    private boolean f12739ag = false;

    /* renamed from: ah */
    private String f12740ah = ApsConstant.CAPTURE_MODE_PANORAMA;

    /* renamed from: ai */
    private String f12741ai = "0";

    /* renamed from: aj */
    private int f12742aj = 0;

    /* renamed from: ak */
    private String f12743ak = "";

    /* renamed from: al */
    private GLProducer<Surface> f12744al = null;

    /* renamed from: am */
    private YUVRenderer f12745am = null;

    /* renamed from: an */
    private Handler f12746an = null;

    /* renamed from: ao */
    private boolean f12747ao = true;

    /* renamed from: ap */
    private boolean f12748ap = false;

    /* renamed from: aq */
    private boolean f12749aq = false;

    /* renamed from: ar */
    private CopyOnWriteArrayList<IntrinsicsJvm.kt_3> f12750ar = new CopyOnWriteArrayList<>();

    /* renamed from: as */
    private Handler f12751as = null;

    /* renamed from: at */
    private boolean f12752at = true;

    /* renamed from: au */
    private volatile boolean f12753au = false;

    /* renamed from: av */
    private volatile boolean f12754av = false;

    /* renamed from: aw */
    private final ConditionVariable f12755aw = new ConditionVariable();

    /* renamed from: ax */
    private Object f12756ax = new Object();

    /* renamed from: ay */
    private volatile int f12757ay = 0;

    /* renamed from: aA */
    private MediaCodec.Callback f12732aA = new MediaCodec.Callback() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_4.1
        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(MediaCodec mediaCodec, int OplusGLSurfaceView_13) {
            CameraLog.m12954a("CameraMediaCodec", "onInputBufferAvailable");
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(MediaCodec mediaCodec, int OplusGLSurfaceView_13, MediaCodec.BufferInfo bufferInfo) {
            CameraLog.m12954a("CameraMediaCodec", "onOutputBufferAvailable");
            try {
                ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(OplusGLSurfaceView_13);
                if (4 != bufferInfo.flags) {
                    if (CameraMediaCodec.this.f12752at && 2 == bufferInfo.flags) {
                        CameraLog.m12954a("CameraMediaCodec", "onOutputBufferAvailable, BUFFER_FLAG_CODEC_CONFIG");
                        mediaCodec.releaseOutputBuffer(OplusGLSurfaceView_13, false);
                        return;
                    }
                    if (1 == bufferInfo.flags) {
                        CameraLog.m12954a("CameraMediaCodec", "onOutputBufferAvailable, BUFFER_FLAG_SYNC_FRAME");
                    }
                    if (CameraMediaCodec.this.f12735ac) {
                        if (0 < CameraMediaCodec.this.f12779v) {
                            bufferInfo.presentationTimeUs -= CameraMediaCodec.this.f12779v / 1000;
                        }
                        if (CameraMediaCodec.this.f12739ag) {
                            bufferInfo.presentationTimeUs = CameraMediaCodec.this.m12181a(bufferInfo);
                            if (bufferInfo.presentationTimeUs <= 0) {
                                CameraLog.m12959b("CameraMediaCodec", "onOutputBufferAvailable, skip, info.presentationTime: " + bufferInfo.presentationTimeUs);
                                mediaCodec.releaseOutputBuffer(OplusGLSurfaceView_13, false);
                                return;
                            }
                        }
                        if (CameraMediaCodec.this.f12781x < 0) {
                            CameraMediaCodec.this.f12781x = bufferInfo.presentationTimeUs;
                            CameraMediaCodec.this.f12766i = true;
                        }
                        if (-1 != CameraMediaCodec.this.f12729Y) {
                            if ((bufferInfo.flags & 1) != 0) {
                                if (CameraMediaCodec.this.f12730Z < 0) {
                                    CameraMediaCodec.this.f12730Z = bufferInfo.presentationTimeUs;
                                } else {
                                    CameraMediaCodec.this.f12730Z += (int) (1000000.0f / CameraMediaCodec.this.f12725U.f12806k);
                                }
                                bufferInfo.presentationTimeUs = CameraMediaCodec.this.f12730Z;
                            } else {
                                CameraLog.m12959b("CameraMediaCodec", "onOutputBufferAvailable, skip Frame");
                                mediaCodec.releaseOutputBuffer(OplusGLSurfaceView_13, false);
                                return;
                            }
                        }
                        CameraLog.m12954a("CameraMediaCodec", "onOutputBufferAvailable, writeSampleData, info.presentationTimeUs: " + bufferInfo.presentationTimeUs + ", mbVideoCodecSpecialEffect: " + CameraMediaCodec.this.f12747ao);
                        if (CameraMediaCodec.this.f12765h) {
                            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(outputBuffer.capacity());
                            byteBufferAllocate.put(outputBuffer);
                            CopyOnWriteArrayList copyOnWriteArrayList = CameraMediaCodec.this.f12750ar;
                            CameraMediaCodec c2648b = CameraMediaCodec.this;
                            copyOnWriteArrayList.add(c2648b.new IntrinsicsJvm.kt_3(c2648b.f12767j, byteBufferAllocate, bufferInfo, false));
                            CameraMediaCodec.this.f12721Q.sendEmptyMessage(1);
                        } else {
                            CameraMediaCodec c2648b2 = CameraMediaCodec.this;
                            c2648b2.m12184a(c2648b2.f12767j, outputBuffer, bufferInfo);
                        }
                        synchronized (CameraMediaCodec.this.f12760c) {
                            CameraMediaCodec.m12199c(CameraMediaCodec.this, bufferInfo.size);
                        }
                        if (CameraMediaCodec.this.f12782y > 0 && bufferInfo.presentationTimeUs - CameraMediaCodec.this.f12781x >= CameraMediaCodec.this.f12782y) {
                            CameraLog.m12967f("CameraMediaCodec", "onOutputBufferAvailable, reach to max duration time");
                            CameraMediaCodec.this.f12717M.sendMessage(CameraMediaCodec.this.f12717M.obtainMessage(1, 800, -1));
                            CameraMediaCodec.this.f12782y = -1L;
                        } else if (CameraMediaCodec.this.f12783z > 0 && CameraMediaCodec.this.f12733aa >= CameraMediaCodec.this.f12783z) {
                            CameraLog.m12967f("CameraMediaCodec", "onOutputBufferAvailable, reach to max file size");
                            CameraMediaCodec.this.f12717M.sendMessage(CameraMediaCodec.this.f12717M.obtainMessage(1, 801, -1));
                            CameraMediaCodec.this.f12783z = -1L;
                        }
                        if (2 == CameraMediaCodec.this.f12706B) {
                            CameraMediaCodec.this.f12777t = System.nanoTime();
                        }
                        mediaCodec.releaseOutputBuffer(OplusGLSurfaceView_13, false);
                        CameraMediaCodec c2648b3 = CameraMediaCodec.this;
                        c2648b3.f12736ad = c2648b3.f12752at;
                        synchronized (CameraMediaCodec.this.f12756ax) {
                            CameraMediaCodec.m12240x(CameraMediaCodec.this);
                        }
                        return;
                    }
                    CameraLog.m12959b("CameraMediaCodec", "onOutputBufferAvailable, mbMuxerStarted: " + CameraMediaCodec.this.f12735ac);
                    mediaCodec.releaseOutputBuffer(OplusGLSurfaceView_13, false);
                    return;
                }
                CameraLog.m12954a("CameraMediaCodec", "onOutputBufferAvailable, Video encode Stopped");
                if (CameraMediaCodec.this.f12765h) {
                    CopyOnWriteArrayList copyOnWriteArrayList2 = CameraMediaCodec.this.f12750ar;
                    CameraMediaCodec c2648b4 = CameraMediaCodec.this;
                    copyOnWriteArrayList2.add(c2648b4.new IntrinsicsJvm.kt_3(c2648b4.f12767j, null, bufferInfo, false));
                    CameraMediaCodec.this.f12721Q.sendEmptyMessage(1);
                    mediaCodec.releaseOutputBuffer(OplusGLSurfaceView_13, false);
                    return;
                }
                CameraMediaCodec.this.m12241x();
                CameraMediaCodec.this.m12166E();
                if (CameraMediaCodec.this.f12711G != null) {
                    CameraMediaCodec.this.f12711G.release();
                }
            } catch (IllegalStateException unused) {
                CameraLog.m12967f("CameraMediaCodec", "onOutputBufferAvailable MediaCodec is already stopped or release, so return");
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            CameraLog.m12967f("CameraMediaCodec", "onError, diagnostic Info: " + codecException.getDiagnosticInfo());
            CameraMediaCodec.this.f12717M.sendMessage(CameraMediaCodec.this.f12717M.obtainMessage(2, codecException.getErrorCode(), -1));
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            CameraLog.m12954a("CameraMediaCodec", "onOutputFormatChanged");
            synchronized (CameraMediaCodec.this.f12731a) {
                if (CameraMediaCodec.this.f12767j < 0 && CameraMediaCodec.this.f12705A != null) {
                    mediaFormat.setInteger("support64BitFileSize", 1);
                    CameraMediaCodec.this.f12767j = CameraMediaCodec.this.f12705A.addTrack(mediaFormat);
                    CameraMediaCodec.this.m12164D();
                    CameraLog.m12967f("CameraMediaCodec", "onOutputFormatChanged, addTrack mVideoTrack, format: " + mediaFormat);
                }
            }
        }
    };

    /* renamed from: IntrinsicsJvm.kt_3 */
    static /* synthetic */ long m12199c(CameraMediaCodec c2648b, long OplusGLSurfaceView_15) {
        long j2 = c2648b.f12733aa + OplusGLSurfaceView_15;
        c2648b.f12733aa = j2;
        return j2;
    }

    /* renamed from: x */
    static /* synthetic */ int m12240x(CameraMediaCodec c2648b) {
        int OplusGLSurfaceView_13 = c2648b.f12757ay;
        c2648b.f12757ay = OplusGLSurfaceView_13 + 1;
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12255a(boolean z) {
        this.f12752at = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m12257a() {
        return this.f12757ay > 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12262b(boolean z) {
        this.f12758az = z;
    }

    /* compiled from: CameraMediaCodec.java */
    /* renamed from: com.oplus.camera.capmode.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean f12809a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f12810b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public ByteBuffer f12811c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public MediaCodec.BufferInfo f12812d;

        public IntrinsicsJvm.kt_3(int OplusGLSurfaceView_13, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, boolean z) {
            this.f12809a = false;
            this.f12810b = -1;
            this.f12811c = null;
            this.f12812d = null;
            this.f12810b = OplusGLSurfaceView_13;
            this.f12811c = byteBuffer;
            this.f12812d = bufferInfo;
            this.f12809a = z;
        }
    }

    /* compiled from: CameraMediaCodec.java */
    /* renamed from: com.oplus.camera.capmode.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f12796a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f12797b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f12798c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int f12799d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f12800e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int f12801f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public int f12802g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public int f12803h;

        /* renamed from: OplusGLSurfaceView_13 */
        public int f12804i;

        /* renamed from: OplusGLSurfaceView_15 */
        public int f12805j;

        /* renamed from: OplusGLSurfaceView_5 */
        public int f12806k;

        /* renamed from: OplusGLSurfaceView_14 */
        public int f12807l;

        private IntrinsicsJvm.kt_4() {
            this.f12796a = 0;
            this.f12797b = 0;
            this.f12798c = 0;
            this.f12799d = 0;
            this.f12800e = 0;
            this.f12801f = 0;
            this.f12802g = 0;
            this.f12803h = 0;
            this.f12804i = 0;
            this.f12805j = 0;
            this.f12806k = 0;
            this.f12807l = 0;
        }
    }

    public CameraMediaCodec() {
        this.f12717M = null;
        this.f12717M = new PlatformImplementations.kt_3(Looper.getMainLooper());
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m12209i() {
        if (this.f12719O == null) {
            HandlerThread handlerThread = new HandlerThread("video codec thread");
            handlerThread.start();
            this.f12719O = new Handler(handlerThread.getLooper());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12254a(String str) {
        this.f12740ah = str;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12261b(String str) {
        this.f12743ak = str;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12265c(String str) {
        this.f12741ai = str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12247a(int OplusGLSurfaceView_13) {
        this.f12742aj = OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m12212j() {
        Handler handler = this.f12719O;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.f12719O = null;
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m12213k() {
        if (this.f12720P == null) {
            HandlerThread handlerThread = new HandlerThread("audio codec thread");
            handlerThread.start();
            this.f12720P = new Handler(handlerThread.getLooper());
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m12216l() {
        if (this.f12765h && this.f12721Q == null) {
            HandlerThread handlerThread = new HandlerThread("frame catch thread");
            handlerThread.start();
            this.f12721Q = new Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_4.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what != 1) {
                        return;
                    }
                    CameraMediaCodec.this.m12280h();
                }
            };
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m12218m() {
        Handler handler = this.f12720P;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.f12720P = null;
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m12221n() {
        Handler handler = this.f12721Q;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.f12721Q = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m12268d(String str) {
        this.f12707C = str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12250a(CamcorderProfile camcorderProfile) {
        this.f12725U.f12806k = camcorderProfile.videoFrameRate;
        this.f12725U.f12803h = camcorderProfile.videoBitRate;
        this.f12725U.f12804i = camcorderProfile.videoCodec;
        this.f12725U.f12796a = camcorderProfile.audioBitRate;
        this.f12725U.f12797b = camcorderProfile.audioChannels;
        this.f12725U.f12798c = camcorderProfile.audioCodec;
        this.f12725U.f12799d = camcorderProfile.audioSampleRate;
        this.f12725U.f12800e = camcorderProfile.duration;
        this.f12725U.f12801f = camcorderProfile.fileFormat;
        this.f12725U.f12802g = camcorderProfile.quality;
        this.f12725U.f12805j = camcorderProfile.videoFrameWidth;
        this.f12725U.f12807l = camcorderProfile.videoFrameHeight;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12252a(OplusGLSurfaceView surfaceHolderCallbackC2766q) {
        this.f12718N = surfaceHolderCallbackC2766q;
    }

    /* renamed from: o */
    private MediaFormat m12222o() {
        if (this.f12712H == null) {
            this.f12712H = MediaFormat.createVideoFormat(m12224p(), this.f12725U.f12807l, this.f12725U.f12805j);
            this.f12712H.setInteger("bitrate", this.f12725U.f12803h);
            this.f12712H.setInteger(IMediaFormat.KEY_FRAME_RATE, this.f12725U.f12806k);
            this.f12712H.setInteger("color-format", this.f12752at ? 2130708361 : 21);
            this.f12712H.setFloat("OplusGLSurfaceView_13-frame-interval", m12258b());
        }
        return this.f12712H;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m12258b() {
        int OplusGLSurfaceView_13 = this.f12729Y;
        if (-1 != OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13 / this.f12725U.f12806k;
        }
        return 1.0f;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12259b(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraMediaCodec", "setExtractFrameRate, extractFrameRate: " + OplusGLSurfaceView_13);
        this.f12729Y = OplusGLSurfaceView_13;
    }

    /* renamed from: p */
    private String m12224p() {
        IntrinsicsJvm.kt_4 bVar = this.f12725U;
        return (bVar == null || bVar.f12804i != 5) ? MimeTypes.VIDEO_H264 : MimeTypes.VIDEO_H265;
    }

    /* renamed from: q */
    private MediaFormat m12226q() {
        if (this.f12713I == null) {
            if (Util.m24459h("oplus.software.video.surround_record_support") && Util.m24173E()) {
                if ("normal".equals(this.f12740ah)) {
                    this.f12713I = MediaFormat.createAudioFormat(MimeTypes.AUDIO_AAC, m12228r(), this.f12725U.f12797b == 0 ? m12230s() : this.f12725U.f12797b);
                    this.f12713I.setInteger("bitrate", this.f12725U.f12796a == 0 ? 128000 : this.f12725U.f12796a);
                    this.f12713I.setString("vendor.ozoaudio.device.value", "");
                    this.f12713I.setString("vendor.ozoaudio.focus-mode.value", "off");
                } else if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(this.f12740ah)) {
                    this.f12713I = MediaFormat.createAudioFormat("audio/ozoaudio", m12228r(), m12230s());
                    this.f12713I.setInteger("bitrate", 256000);
                    this.f12713I.setString("vendor.ozoaudio.device.value", this.f12741ai);
                    this.f12713I.setString("vendor.ozoaudio.focus-mode.value", "on");
                    this.f12713I.setString("vendor.ozoaudio.mode", "ozoaudio");
                    this.f12713I.setInteger("vendor.ozoaudio.sample-depth", 16);
                    this.f12713I.setString("vendor.ozoaudio.focus-azimuth.value", "0.0");
                    this.f12713I.setString("vendor.ozoaudio.focus-elevation.value", "0.0");
                    this.f12713I.setString("vendor.ozoaudio.focus-sector-width.value", "100.0");
                    this.f12713I.setString("vendor.ozoaudio.focus-sector-height.value", "100.0");
                } else if ("focusing".equals(this.f12740ah)) {
                    this.f12713I = MediaFormat.createAudioFormat("audio/ozoaudio", m12228r(), m12230s());
                    this.f12713I.setInteger("bitrate", 256000);
                    this.f12713I.setString("vendor.ozoaudio.device.value", this.f12741ai);
                    this.f12713I.setString("vendor.ozoaudio.focus-mode.value", "on");
                    this.f12713I.setString("vendor.ozoaudio.mode", "ozoaudio");
                    this.f12713I.setInteger("vendor.ozoaudio.sample-depth", 16);
                    this.f12713I.setString("vendor.ozoaudio.focus-gain.value", String.valueOf(Util.m24476m(this.f12742aj)));
                    this.f12713I.setString("vendor.ozoaudio.focus-azimuth.value", "0.0");
                    this.f12713I.setString("vendor.ozoaudio.focus-elevation.value", "0.0");
                    this.f12713I.setString("vendor.ozoaudio.focus-sector-width.value", "100.0");
                    this.f12713I.setString("vendor.ozoaudio.focus-sector-height.value", "100.0");
                } else {
                    this.f12713I = MediaFormat.createAudioFormat(MimeTypes.AUDIO_AAC, m12228r(), this.f12725U.f12797b == 0 ? m12230s() : this.f12725U.f12797b);
                    this.f12713I.setInteger("bitrate", this.f12725U.f12796a == 0 ? 128000 : this.f12725U.f12796a);
                    this.f12713I.setString("vendor.ozoaudio.device.value", "");
                    this.f12713I.setString("vendor.ozoaudio.focus-mode.value", "off");
                }
                if (Util.m24170D()) {
                    this.f12713I.setString("vendor.ozoaudio.wnr-mode.value", this.f12743ak);
                }
                this.f12713I.setInteger("aac-profile", 2);
            } else {
                this.f12713I = MediaFormat.createAudioFormat(MimeTypes.AUDIO_AAC, m12228r(), this.f12725U.f12797b == 0 ? m12230s() : this.f12725U.f12797b);
                this.f12713I.setInteger("bitrate", this.f12725U.f12796a == 0 ? 128000 : this.f12725U.f12796a);
                this.f12713I.setInteger("aac-profile", 2);
            }
        }
        return this.f12713I;
    }

    /* renamed from: r */
    private int m12228r() {
        IntrinsicsJvm.kt_4 bVar = this.f12725U;
        if (bVar == null || bVar.f12799d == 0) {
            return 48000;
        }
        return this.f12725U.f12799d;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int m12230s() {
        /*
            r6 = this;
            java.lang.String r0 = "oplus.software.video.surround_record_support"
            boolean r0 = com.oplus.camera.util.Util.m24459h(r0)
            if (r0 == 0) goto L2b
            boolean r0 = com.oplus.camera.util.Util.m24173E()
            if (r0 == 0) goto L2b
            java.lang.String r0 = r6.f12740ah
            java.lang.String r1 = "panorama"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L1d
            int r0 = r6.f12773p
            r6.f12772o = r0
            goto L2b
        L1d:
            java.lang.String r0 = r6.f12740ah
            java.lang.String r1 = "focusing"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L2b
            int r0 = r6.f12773p
            r6.f12772o = r0
        L2b:
            int r6 = r6.f12772o
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
            com.oplus.camera.CameraLog.m12962c(r0, r6)
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
            com.oplus.camera.CameraLog.m12954a(r0, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.CameraMediaCodec.m12230s():int");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12249a(long OplusGLSurfaceView_15) {
        this.f12782y = OplusGLSurfaceView_15 * 1000;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12260b(long OplusGLSurfaceView_15) {
        this.f12783z = (long) (OplusGLSurfaceView_15 * 0.9f);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12263c() {
        CameraLog.m12954a("CameraMediaCodec", "prepare");
        m12209i();
        m12213k();
        m12216l();
        if (this.f12705A == null) {
            try {
                if (this.f12708D != null) {
                    this.f12705A = new MediaMuxer(this.f12708D, this.f12725U.f12801f);
                } else {
                    this.f12705A = new MediaMuxer(this.f12707C, this.f12725U.f12801f);
                }
                this.f12705A.setOrientationHint(this.f12770m);
                this.f12705A.setLocation(this.f12727W, this.f12728X);
            } catch (IOException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12264c(int OplusGLSurfaceView_13) {
        this.f12770m = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m12270d() throws InterruptedException {
        CameraLog.m12954a("CameraMediaCodec", TtmlNode.START);
        this.f12750ar.clear();
        if (this.f12764g) {
            this.f12764g = Util.m24356as();
        }
        this.f12719O.post(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_4.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CameraMediaCodec.this.m12239w();
                } finally {
                    CameraMediaCodec.this.f12726V.countDown();
                    CameraLog.m12954a("CameraMediaCodec", "start, initVideoCodec end");
                }
            }
        });
        this.f12720P.post(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_4.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CameraMediaCodec.this.f12764g) {
                        CameraMediaCodec.this.m12237v();
                    }
                } finally {
                    CameraMediaCodec.this.f12726V.countDown();
                    CameraLog.m12954a("CameraMediaCodec", "start, initAudioCodec end");
                }
            }
        });
        try {
            this.f12726V.await();
        } catch (InterruptedException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        this.f12736ad = false;
        this.f12737ae = false;
        m12219m(1);
        this.f12734ab = this.f12764g ? m12173H() : true;
        OplusGLSurfaceView surfaceHolderCallbackC2766q = this.f12718N;
        if (surfaceHolderCallbackC2766q != null) {
            surfaceHolderCallbackC2766q.m14137k();
        } else {
            CameraLog.m12967f("CameraMediaCodec", "start, mGLSurfaceView is null");
        }
        return this.f12734ab;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m12273e() throws IllegalStateException, MediaCodec.CryptoException {
        CameraLog.m12954a("CameraMediaCodec", "stop, mRecorderState: " + this.f12706B);
        if (this.f12753au) {
            this.f12753au = false;
            if (this.f12754av) {
                this.f12755aw.close();
                this.f12755aw.block();
            }
        }
        if (3 == this.f12706B) {
            return true;
        }
        this.f12724T.close();
        m12219m(3);
        synchronized (this.f12759b) {
            this.f12759b.notifyAll();
        }
        synchronized (this.f12731a) {
            this.f12731a.notifyAll();
        }
        OplusGLSurfaceView surfaceHolderCallbackC2766q = this.f12718N;
        if (surfaceHolderCallbackC2766q != null) {
            surfaceHolderCallbackC2766q.m14136j();
        } else {
            CameraLog.m12967f("CameraMediaCodec", "stop, mGLSurfaceView is null");
        }
        this.f12778u = 0L;
        this.f12777t = 0L;
        m12163C();
        m12158A();
        this.f12749aq = false;
        if (this.f12764g) {
            m12233t();
            m12235u();
        }
        YUVRenderer c2775z = this.f12745am;
        if (c2775z != null && !this.f12747ao) {
            c2775z.m14291a();
        }
        Handler handler = this.f12746an;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.f12746an = null;
        }
        Handler handler2 = this.f12751as;
        if (handler2 != null) {
            handler2.getLooper().quitSafely();
            this.f12751as = null;
        }
        this.f12724T.block();
        return this.f12734ab;
    }

    /* renamed from: t */
    private void m12233t() throws IllegalStateException {
        CameraLog.m12954a("CameraMediaCodec", "stopAudioInput");
        AudioRecord audioRecord = this.f12715K;
        if (audioRecord != null) {
            audioRecord.stop();
            this.f12715K.release();
        }
    }

    /* renamed from: u */
    private void m12235u() throws MediaCodec.CryptoException {
        CameraLog.m12954a("CameraMediaCodec", "stopAudioEncode, mAudioCodec: " + this.f12710F + ", mbAudioCodecOutputDataCome: " + this.f12737ae);
        if (this.f12737ae) {
            MediaCodec mediaCodec = this.f12710F;
            if (mediaCodec != null) {
                this.f12710F.queueInputBuffer(mediaCodec.dequeueInputBuffer(-1L), 0, 0, 0L, 4);
                return;
            }
            return;
        }
        m12160B();
        m12166E();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m12274f() {
        CameraLog.m12954a("CameraMediaCodec", VideoRecordMsgData.EVENT_PAUSE);
        this.f12777t = System.nanoTime();
        m12219m(2);
        this.f12778u = 0L;
        OplusGLSurfaceView surfaceHolderCallbackC2766q = this.f12718N;
        if (surfaceHolderCallbackC2766q != null) {
            surfaceHolderCallbackC2766q.m14136j();
        } else {
            CameraLog.m12967f("CameraMediaCodec", "pause, mGLSurfaceView is null");
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m12277g() {
        this.f12778u = System.nanoTime();
        this.f12779v += this.f12778u - this.f12777t;
        CameraLog.m12954a("CameraMediaCodec", "resume, mPausedTime: " + this.f12779v);
        m12219m(1);
        synchronized (this.f12759b) {
            this.f12759b.notifyAll();
        }
        OplusGLSurfaceView surfaceHolderCallbackC2766q = this.f12718N;
        if (surfaceHolderCallbackC2766q != null) {
            surfaceHolderCallbackC2766q.m14137k();
        } else {
            CameraLog.m12967f("CameraMediaCodec", "resume, mGLSurfaceView is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m12237v() {
        CameraLog.m12954a("CameraMediaCodec", "initAudioCodec, mAudioType: " + this.f12740ah);
        try {
            if (!Util.m24459h("oplus.software.video.surround_record_support") || !Util.m24173E() || "normal".equals(this.f12740ah)) {
                this.f12710F = MediaCodec.createEncoderByType(MimeTypes.AUDIO_AAC);
            } else if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(this.f12740ah) || "focusing".equals(this.f12740ah)) {
                this.f12710F = MediaCodec.createEncoderByType("audio/ozoaudio");
            } else {
                this.f12710F = MediaCodec.createEncoderByType(MimeTypes.AUDIO_AAC);
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        this.f12710F.configure(m12226q(), (Surface) null, (MediaCrypto) null, 1);
        this.f12710F.start();
        this.f12714J = this.f12710F.getInputBuffers();
        this.f12720P.post(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_4.6
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12954a("CameraMediaCodec", "initAudioCodec, AudioEncode run");
                CameraMediaCodec.this.m12245z();
            }
        });
        CameraLog.m12954a("CameraMediaCodec", "initAudioCodec, mInputByteBuffer.length: " + this.f12714J.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    /* renamed from: w */
    public void m12239w() {
        CameraLog.m12954a("CameraMediaCodec", "initVideoCodec");
        try {
            this.f12709E = MediaCodec.createEncoderByType(m12224p());
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        this.f12709E.configure(m12222o(), (Surface) null, (MediaCrypto) null, 1);
        if (this.f12752at) {
            this.f12709E.setCallback(this.f12732aA, this.f12719O);
            this.f12711G = this.f12709E.createInputSurface();
            if (this.f12747ao) {
                this.f12718N.setOutput(this.f12711G);
            } else if (this.f12748ap) {
                this.f12716L.mo12289a(this.f12711G);
            } else {
                if (this.f12746an == null) {
                    HandlerThread handlerThread = new HandlerThread("VideoCodecInputThread");
                    handlerThread.start();
                    this.f12746an = new Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_4.7
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            if (message.what != 1) {
                                return;
                            }
                            CameraMediaCodec.this.m12185a((HardwareBuffer) message.obj);
                            message.obj = null;
                        }
                    };
                }
                this.f12744al = new GLProducer<>(this.f12711G);
                this.f12744al.m14040a(2);
                this.f12744al.m14041a(8, 8, 8, 8, 0, 0);
                this.f12745am = new YUVRenderer();
                this.f12738af = false;
            }
        } else if (this.f12751as == null) {
            HandlerThread handlerThread2 = new HandlerThread("Encode YUV Thread");
            handlerThread2.start();
            this.f12751as = new Handler(handlerThread2.getLooper()) { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_4.8
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int OplusGLSurfaceView_13 = message.what;
                    if (OplusGLSurfaceView_13 == 1) {
                        Message messageObtain = Message.obtain();
                        messageObtain.obj = CameraMediaCodec.this.m12194a((CameraPictureCallback.CameraPictureImage) message.obj);
                        messageObtain.what = 2;
                        CameraMediaCodec.this.f12751as.sendMessage(messageObtain);
                        return;
                    }
                    if (OplusGLSurfaceView_13 != 2) {
                        return;
                    }
                    try {
                        CameraMediaCodec.this.m12197b((byte[]) message.obj);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            };
        }
        this.f12709E.start();
        this.f12762e.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public byte[] m12194a(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        byte[] bArrM24444e;
        long jUptimeMillis = SystemClock.uptimeMillis();
        CameraLog.m12954a("CameraMediaCodec", "getYuvDataFromImage, time : " + jUptimeMillis + ", image : " + cameraPictureImage);
        int width = cameraPictureImage.getWidth();
        int height = cameraPictureImage.getHeight();
        int stride = cameraPictureImage.getStride();
        int scanline = cameraPictureImage.getScanline();
        int orientation = cameraPictureImage.getOrientation();
        if (cameraPictureImage.getImage() != null) {
            byte[] bArrM24400b = Util.m24400b(cameraPictureImage.getImage(), width, height, stride, scanline);
            CameraLog.m12954a("CameraMediaCodec", "getYuvDataFromImage, drop deal byte[] cost : " + (SystemClock.uptimeMillis() - jUptimeMillis));
            if (height < width) {
                if (orientation == 0 || 90 == orientation || 180 == orientation) {
                    bArrM24400b = Util.m24308a(bArrM24400b, width, height);
                } else if (270 == orientation) {
                    bArrM24400b = Util.m24398b(bArrM24400b, width, height);
                }
            }
            CameraLog.m12954a("CameraMediaCodec", "getYuvDataFromImage, rotate deal byte[] cost : " + (SystemClock.uptimeMillis() - jUptimeMillis));
            bArrM24444e = Util.m24444e(bArrM24400b, width, height);
        } else {
            bArrM24444e = null;
        }
        CameraLog.m12954a("CameraMediaCodec", "getYuvDataFromImage, encode deal byte[] cost : " + (SystemClock.uptimeMillis() - jUptimeMillis));
        return bArrM24444e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12197b(byte[] bArr) throws MediaCodec.CryptoException {
        CameraLog.m12954a("CameraMediaCodec", "encodeYuvData, inputData: " + bArr + ", mRecorderState: " + this.f12706B);
        if (bArr == null || this.f12706B == 3) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        this.f12754av = true;
        int length = bArr.length;
        int iDequeueInputBuffer = this.f12709E.dequeueInputBuffer(0L);
        ByteBuffer inputBuffer = null;
        if (iDequeueInputBuffer >= 0) {
            inputBuffer = this.f12709E.getInputBuffer(iDequeueInputBuffer);
            inputBuffer.clear();
            inputBuffer.put(bArr);
            long OplusGLSurfaceView_15 = this.f12730Z;
            if (OplusGLSurfaceView_15 < 0) {
                this.f12730Z = System.nanoTime();
            } else {
                this.f12730Z = OplusGLSurfaceView_15 + ((int) (1000000.0f / this.f12725U.f12806k));
            }
            this.f12709E.queueInputBuffer(iDequeueInputBuffer, 0, length, this.f12730Z, 0);
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int iDequeueOutputBuffer = this.f12709E.dequeueOutputBuffer(bufferInfo, 0L);
        CameraLog.m12954a("CameraMediaCodec", "encodeYuvData, startEncoder out index " + iDequeueOutputBuffer);
        if (-2 == iDequeueOutputBuffer) {
            MediaCodec.Callback callback = this.f12732aA;
            MediaCodec mediaCodec = this.f12709E;
            callback.onOutputFormatChanged(mediaCodec, mediaCodec.getOutputFormat());
        }
        while (iDequeueOutputBuffer >= 0) {
            this.f12732aA.onOutputBufferAvailable(this.f12709E, iDequeueOutputBuffer, bufferInfo);
            iDequeueOutputBuffer = this.f12709E.dequeueOutputBuffer(bufferInfo, 0L);
        }
        if (inputBuffer != null) {
            inputBuffer.clear();
        }
        this.f12754av = false;
        this.f12755aw.open();
        CameraLog.m12954a("CameraMediaCodec", "encodeYuvData, encode cost time : " + (SystemClock.uptimeMillis() - jUptimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public long m12181a(MediaCodec.BufferInfo bufferInfo) {
        CameraMediaCodecListener interfaceC2649c = this.f12716L;
        if (interfaceC2649c != null) {
            return interfaceC2649c.mo12287a(bufferInfo);
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m12241x() {
        CameraLog.m12954a("CameraMediaCodec", "releaseVideoCodec");
        try {
            try {
                if (this.f12709E != null) {
                    this.f12709E.stop();
                    this.f12709E.release();
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            CameraLog.m12954a("CameraMediaCodec", "releaseVideoCodec, end");
        } finally {
            this.f12767j = -1;
        }
    }

    /* renamed from: y */
    private void m12243y() {
        this.f12744al.m14045a(this.f12745am);
        this.f12744al.m14049b(0);
        this.f12744al.m14042a((SurfaceHolder) null);
        this.f12744al.m14043a(null, 0, this.f12725U.f12807l, this.f12725U.f12805j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12185a(HardwareBuffer hardwareBuffer) {
        if (this.f12709E == null) {
            hardwareBuffer.close();
            return;
        }
        this.f12745am.m14292a(hardwareBuffer);
        if (!this.f12738af) {
            this.f12738af = true;
            m12243y();
        }
        this.f12744al.m14052d();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12266c(boolean z) {
        CameraLog.m12954a("CameraMediaCodec", "updateSavePatch, mbSaveInSDCard is " + this.f12765h);
        this.f12765h = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12256a(byte[] bArr) {
        CameraLog.m12962c("CameraMediaCodec", "addYuvData " + bArr + ", " + this.f12753au);
        if (bArr == null || this.f12752at || 3 == this.f12706B) {
            return;
        }
        if (!this.f12753au) {
            this.f12753au = true;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = bArr;
        messageObtain.what = 2;
        this.f12751as.sendMessage(messageObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12190a(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws MediaCodec.CryptoException {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("addAudioFrame, mAudioCodec: ");
        sb.append(this.f12710F);
        sb.append(", mRecorderState: ");
        sb.append(this.f12706B);
        sb.append(", audioData: ");
        if (bArr == null || 1 > bArr.length) {
            str = "empty";
        } else {
            str = "first : " + ((int) bArr[0]);
        }
        sb.append(str);
        CameraLog.m12954a("CameraMediaCodec", sb.toString());
        if (this.f12710F != null) {
            int iDequeueInputBuffer = -1;
            while (true) {
                if (iDequeueInputBuffer >= 0) {
                    break;
                }
                iDequeueInputBuffer = this.f12710F.dequeueInputBuffer(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                CameraLog.m12954a("CameraMediaCodec", "addAudioFrame, outputBufferIndex: " + iDequeueInputBuffer);
                if (iDequeueInputBuffer < 0 && 1 != this.f12706B) {
                    CameraLog.m12967f("CameraMediaCodec", "addAudioFrame break, mRecorderState: " + this.f12706B);
                    break;
                }
            }
            int i3 = iDequeueInputBuffer;
            if (bArr == null || i3 < 0) {
                return;
            }
            if (0 == this.f12776s) {
                this.f12776s = System.nanoTime();
            }
            this.f12714J[i3].position(0);
            this.f12714J[i3].put(bArr, OplusGLSurfaceView_13, i2);
            this.f12710F.queueInputBuffer(i3, 0, i2, (this.f12776s + (this.f12774q * this.f12775r)) / 1000, 0);
            this.f12774q++;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m12269d(boolean z) {
        CameraLog.m12954a("CameraMediaCodec", "setBinauralRecordingState, enable: " + z);
        this.f12749aq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m12245z() {
        MediaCodec.BufferInfo bufferInfo;
        CameraLog.m12954a("CameraMediaCodec", "audioEncoder, start");
        ByteBuffer[] outputBuffers = this.f12710F.getOutputBuffers();
        while (true) {
            try {
                bufferInfo = new MediaCodec.BufferInfo();
                int iDequeueOutputBuffer = this.f12710F.dequeueOutputBuffer(bufferInfo, -1L);
                if (iDequeueOutputBuffer == -3) {
                    outputBuffers = this.f12710F.getOutputBuffers();
                } else if (iDequeueOutputBuffer == -2) {
                    synchronized (this.f12731a) {
                        if (this.f12768k < 0) {
                            CameraLog.m12954a("CameraMediaCodec", "audioEncoder, addTrack mAudioTrack");
                            if (this.f12769l < 0 && this.f12749aq) {
                                CameraLog.m12954a("CameraMediaCodec", "audioEncoder, addTrack mMetadataTrack");
                                MediaFormat mediaFormat = new MediaFormat(this.f12713I);
                                mediaFormat.setString(IMediaFormat.KEY_MIME, "application/binaural");
                                this.f12769l = this.f12705A.addTrack(mediaFormat);
                            }
                            this.f12768k = this.f12705A.addTrack(this.f12710F.getOutputFormat());
                            m12164D();
                        }
                    }
                } else if (iDequeueOutputBuffer == -1) {
                    CameraLog.m12967f("CameraMediaCodec", "audioEncoder, Audio INFO_TRY_AGAIN_LATER");
                } else {
                    if (bufferInfo.flags == 4) {
                        break;
                    }
                    if (bufferInfo.flags == 2) {
                        CameraLog.m12954a("CameraMediaCodec", "audioEncoder, Audio BUFFER_FLAG_CODEC_CONFIG");
                    } else if (bufferInfo.flags == 1) {
                        CameraLog.m12954a("CameraMediaCodec", "audioEncoder, Audio BUFFER_FLAG_SYNC_FRAME");
                    } else if (!this.f12735ac) {
                        CameraLog.m12959b("CameraMediaCodec", "audioEncoder, mbMuxerStarted: " + this.f12735ac);
                    } else {
                        if (this.f12781x < 0) {
                            this.f12781x = bufferInfo.presentationTimeUs;
                            this.f12766i = false;
                        }
                        if (this.f12766i) {
                            if (-1 == this.f12780w) {
                                if (bufferInfo.presentationTimeUs - this.f12781x > 200000) {
                                    this.f12780w = (bufferInfo.presentationTimeUs - this.f12781x) - 200000;
                                } else {
                                    this.f12780w = 0L;
                                }
                            }
                            bufferInfo.presentationTimeUs -= this.f12780w;
                        }
                        CameraLog.m12954a("CameraMediaCodec", "audioEncoder, audio bufferInfo.presentationTimeUs: " + bufferInfo.presentationTimeUs);
                        if (this.f12765h) {
                            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(outputBuffers[iDequeueOutputBuffer].capacity());
                            byteBufferAllocate.put(outputBuffers[iDequeueOutputBuffer]);
                            this.f12750ar.add(new IntrinsicsJvm.kt_3(this.f12768k, byteBufferAllocate, bufferInfo, true));
                            this.f12721Q.sendEmptyMessage(1);
                        } else {
                            m12184a(this.f12768k, outputBuffers[iDequeueOutputBuffer], bufferInfo);
                        }
                        synchronized (this.f12760c) {
                            this.f12733aa += bufferInfo.size;
                        }
                        this.f12710F.releaseOutputBuffer(iDequeueOutputBuffer, false);
                        if (this.f12782y > 0 && bufferInfo.presentationTimeUs - this.f12781x >= this.f12782y) {
                            CameraLog.m12967f("CameraMediaCodec", "audioEncoder, reach to max duration time");
                            this.f12717M.sendMessage(this.f12717M.obtainMessage(1, 800, -1));
                            this.f12782y = -1L;
                        } else if (this.f12783z > 0 && this.f12733aa >= this.f12783z) {
                            CameraLog.m12954a("CameraMediaCodec", "audioEncoder, reach to max file size");
                            this.f12717M.sendMessage(this.f12717M.obtainMessage(1, 801, -1));
                            this.f12783z = -1L;
                        }
                        if (2 == this.f12706B) {
                            this.f12777t = System.nanoTime();
                        }
                        this.f12737ae = true;
                    }
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                Message messageObtainMessage = this.f12717M.obtainMessage(3, 1);
                this.f12717M.removeMessages(3);
                this.f12717M.sendMessage(messageObtainMessage);
            }
        }
        CameraLog.m12954a("CameraMediaCodec", "audioEncoder, Audio BUFFER_FLAG_END_OF_STREAM");
        if (this.f12769l >= 0 && this.f12749aq) {
            CameraLog.m12954a("CameraMediaCodec", "audioEncoder, write metadata track");
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[]{0});
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            bufferInfo2.set(0, byteBufferWrap.capacity(), 0L, 0);
            if (this.f12766i) {
                bufferInfo2.presentationTimeUs = bufferInfo.presentationTimeUs - this.f12780w;
            } else {
                bufferInfo2.presentationTimeUs = bufferInfo.presentationTimeUs;
            }
            m12184a(this.f12769l, byteBufferWrap, bufferInfo2);
        }
        if (this.f12765h) {
            this.f12750ar.add(new IntrinsicsJvm.kt_3(this.f12768k, null, bufferInfo, true));
            this.f12721Q.sendEmptyMessage(1);
        } else {
            m12160B();
            m12166E();
        }
        this.f12774q = 0;
        this.f12775r = 0L;
        this.f12776s = 0L;
        CameraLog.m12954a("CameraMediaCodec", "audioEncoder, release audio codec");
    }

    /* renamed from: A */
    private void m12158A() {
        try {
            try {
                if (this.f12722R != null && this.f12722R.isAlive()) {
                    CameraLog.m12954a("CameraMediaCodec", "releaseAudioCodec, audio input thread not end and we wait it here");
                    this.f12722R.join();
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        } finally {
            this.f12722R = null;
        }
    }

    /* renamed from: B */
    private void m12160B() {
        CameraLog.m12954a("CameraMediaCodec", "releaseAudioCodec");
        m12158A();
        synchronized (this.f12761d) {
            try {
                try {
                    CameraLog.m12954a("CameraMediaCodec", "releaseAudioCodec, mAudioCodec: " + this.f12710F);
                    if (this.f12710F != null) {
                        this.f12710F.stop();
                        this.f12710F.release();
                    }
                    this.f12768k = -1;
                    this.f12710F = null;
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    this.f12768k = -1;
                    this.f12710F = null;
                }
                this.f12769l = -1;
            } catch (Throwable th) {
                this.f12768k = -1;
                this.f12710F = null;
                this.f12769l = -1;
                throw th;
            }
        }
        CameraLog.m12954a("CameraMediaCodec", "releaseAudioCodec, end");
    }

    /* renamed from: C */
    private void m12163C() {
        CameraLog.m12954a("CameraMediaCodec", "stopVideoEncode, mbVideoCodecOutputDataCome: " + this.f12736ad);
        OplusGLSurfaceView surfaceHolderCallbackC2766q = this.f12718N;
        if (surfaceHolderCallbackC2766q != null) {
            surfaceHolderCallbackC2766q.m14134h();
        }
        if (this.f12736ad) {
            MediaCodec mediaCodec = this.f12709E;
            if (mediaCodec != null) {
                mediaCodec.signalEndOfInputStream();
                return;
            }
            return;
        }
        Handler handler = this.f12719O;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_4.9
                @Override // java.lang.Runnable
                public void run() {
                    CameraMediaCodec.this.m12241x();
                    CameraMediaCodec.this.m12166E();
                    if (CameraMediaCodec.this.f12711G != null) {
                        CameraMediaCodec.this.f12711G.release();
                    }
                }
            });
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m12219m(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraMediaCodec", "setRecordState, mRecorderState: " + this.f12706B + " => " + OplusGLSurfaceView_13);
        this.f12706B = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m12267d(int OplusGLSurfaceView_13) {
        this.f12725U.f12803h = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m12271e(int OplusGLSurfaceView_13) {
        this.f12725U.f12806k = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m12275f(int OplusGLSurfaceView_13) {
        this.f12725U.f12801f = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12246a(float COUIBaseListPopupWindow_12, float f2) {
        this.f12727W = COUIBaseListPopupWindow_12;
        this.f12728X = f2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12253a(FileDescriptor fileDescriptor) {
        this.f12708D = fileDescriptor;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12248a(int OplusGLSurfaceView_13, int i2) {
        IntrinsicsJvm.kt_4 bVar = this.f12725U;
        bVar.f12807l = i2;
        bVar.f12805j = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m12278g(int OplusGLSurfaceView_13) {
        this.f12725U.f12804i = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m12281h(int OplusGLSurfaceView_13) {
        this.f12725U.f12796a = OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m12283i(int OplusGLSurfaceView_13) {
        this.f12725U.f12797b = OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m12284j(int OplusGLSurfaceView_13) {
        this.f12725U.f12799d = OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m12285k(int OplusGLSurfaceView_13) {
        this.f12725U.f12798c = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m12272e(boolean z) {
        CameraLog.m12954a("CameraMediaCodec", "setAudioEnable, enable: " + z);
        this.f12764g = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m12164D() {
        CameraLog.m12954a("CameraMediaCodec", "startMediaMuxer, mVideoTrack: " + this.f12767j + ", mAudioTrack: " + this.f12768k);
        if (this.f12764g) {
            synchronized (this.f12731a) {
                if (this.f12767j >= 0 && this.f12768k >= 0) {
                    if (!this.f12735ac) {
                        this.f12705A.start();
                        this.f12735ac = true;
                    }
                    this.f12731a.notifyAll();
                } else {
                    try {
                        if (this.f12767j < 0 || this.f12768k < 0) {
                            this.f12731a.wait();
                        }
                    } catch (InterruptedException COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                    }
                }
            }
            return;
        }
        if (this.f12735ac) {
            return;
        }
        this.f12705A.start();
        this.f12735ac = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:55|6|(3:8|52|(6:53|10|(1:12)|13|14|31))|50|23|(1:27)|31) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a4, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a5, code lost:
    
        r4.printStackTrace();
     */
    /* renamed from: E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m12166E() {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.CameraMediaCodec.m12166E():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12184a(int OplusGLSurfaceView_13, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        CameraLog.m12954a("CameraMediaCodec", "writeSampleData");
        MediaMuxer mediaMuxer = this.f12705A;
        if (mediaMuxer != null) {
            mediaMuxer.writeSampleData(OplusGLSurfaceView_13, byteBuffer, bufferInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public int m12168F() {
        if (this.f12771n == 0) {
            this.f12771n = AudioRecord.getMinBufferSize(m12228r(), 12, 2);
            if (this.f12714J[0].capacity() < this.f12771n) {
                this.f12771n = this.f12714J[0].capacity();
            }
        }
        int iM12230s = m12230s() * Util.m24486p(2) * 1024;
        if (iM12230s < this.f12771n) {
            this.f12771n = iM12230s;
        }
        return this.f12771n;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: G */
    private void m12171G() {
        if (this.f12715K == null) {
            if (Util.m24459h("oplus.software.video.surround_record_support") && Util.m24173E()) {
                if ("normal".equals(this.f12740ah)) {
                    this.f12715K = new AudioRecord(5, m12228r(), 12, 2, m12168F());
                    return;
                }
                if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(this.f12740ah)) {
                    this.f12715K = new AudioRecord(5, m12228r(), 28, 2, m12168F());
                    return;
                }
                if ("focusing".equals(this.f12740ah)) {
                    this.f12715K = new AudioRecord(5, m12228r(), 28, 2, m12168F());
                    return;
                }
                CameraLog.m12967f("CameraMediaCodec", " mAudioType: " + this.f12740ah + " is wrong");
                return;
            }
            this.f12715K = new AudioRecord(5, m12228r(), 12, 2, m12168F());
        }
    }

    /* renamed from: H */
    private boolean m12173H() throws IllegalStateException {
        CameraLog.m12954a("CameraMediaCodec", "startAudioInput");
        if (this.f12715K == null) {
            m12171G();
        }
        AudioRecord audioRecord = this.f12715K;
        boolean z = false;
        if (audioRecord == null) {
            return false;
        }
        audioRecord.startRecording();
        if (this.f12715K.getRecordingState() != 3) {
            CameraLog.m12967f("CameraMediaCodec", "startAudioInput, mAudioRecord may be conflict or have some other exception");
        } else {
            z = true;
        }
        final byte[] bArr = new byte[m12168F()];
        this.f12763f = System.currentTimeMillis();
        this.f12775r = (((m12168F() * C1547C.NANOS_PER_SECOND) / this.f12715K.getChannelCount()) / m12228r()) / Util.m24486p(this.f12715K.getAudioFormat());
        this.f12722R = new Thread("audio input thread") { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_4.10
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws MediaCodec.CryptoException {
                while (true) {
                    if (1 != CameraMediaCodec.this.f12706B) {
                        if (3 != CameraMediaCodec.this.f12706B) {
                            if (2 == CameraMediaCodec.this.f12706B) {
                                CameraLog.m12967f("CameraMediaCodec", "startAudioInput, AudioInput pause");
                                synchronized (CameraMediaCodec.this.f12759b) {
                                    try {
                                        if (2 == CameraMediaCodec.this.f12706B) {
                                            CameraMediaCodec.this.f12759b.wait();
                                        }
                                    } catch (InterruptedException COUIBaseListPopupWindow_8) {
                                        COUIBaseListPopupWindow_8.printStackTrace();
                                    }
                                }
                            }
                        } else {
                            CameraLog.m12967f("CameraMediaCodec", "startAudioInput, AudioInput stop");
                            return;
                        }
                    } else {
                        long jNanoTime = System.nanoTime();
                        int OplusGLSurfaceView_13 = CameraMediaCodec.this.f12715K.read(bArr, 0, CameraMediaCodec.this.m12168F());
                        if ((System.nanoTime() - jNanoTime) / 1000000 < 3 && (System.nanoTime() - CameraMediaCodec.this.f12778u) / 1000000 < 50) {
                            CameraLog.m12967f("CameraMediaCodec", "startAudioInput, mAudioRecord.read cost: " + ((System.nanoTime() - jNanoTime) / 1000000) + ", drop it");
                        } else {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (OplusGLSurfaceView_13 > 0) {
                                if (500 < jCurrentTimeMillis - CameraMediaCodec.this.f12763f) {
                                    CameraMediaCodec.this.m12190a(bArr, 0, OplusGLSurfaceView_13);
                                } else {
                                    byte[] bArr2 = new byte[OplusGLSurfaceView_13];
                                    Arrays.fill(bArr2, (byte) 0);
                                    CameraMediaCodec.this.m12190a(bArr2, 0, OplusGLSurfaceView_13);
                                    CameraLog.m12967f("CameraMediaCodec", "startAudioInput, send empty");
                                }
                            }
                        }
                    }
                }
            }
        };
        this.f12722R.start();
        return z;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m12286l(int OplusGLSurfaceView_13) {
        Bundle bundle = new Bundle();
        bundle.putString("vendor.ozoaudio.focus-gain.value", String.valueOf(Util.m24476m(OplusGLSurfaceView_13)));
        synchronized (this.f12761d) {
            if (this.f12710F != null) {
                this.f12710F.setParameters(bundle);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12251a(CameraMediaCodecListener interfaceC2649c) {
        this.f12716L = interfaceC2649c;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m12276f(boolean z) {
        this.f12747ao = z;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m12279g(boolean z) {
        this.f12739ag = z;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m12282h(boolean z) {
        this.f12748ap = z;
    }

    /* compiled from: CameraMediaCodec.java */
    /* renamed from: com.oplus.camera.capmode.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends Handler {
        public PlatformImplementations.kt_3(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 1) {
                if (CameraMediaCodec.this.f12716L != null) {
                    CameraMediaCodec.this.f12716L.mo12290a(CameraMediaCodec.this, message.arg1, message.arg2);
                }
            } else {
                if (OplusGLSurfaceView_13 != 2) {
                    if (OplusGLSurfaceView_13 == 3 && CameraMediaCodec.this.f12716L != null) {
                        CameraMediaCodec.this.f12716L.mo12288a(((Integer) message.obj).intValue());
                        return;
                    }
                    return;
                }
                if (CameraMediaCodec.this.f12716L != null) {
                    CameraMediaCodec.this.f12716L.mo12291b(CameraMediaCodec.this, message.arg1, message.arg2);
                }
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m12280h() {
        while (!this.f12750ar.isEmpty()) {
            try {
                IntrinsicsJvm.kt_3 cVarRemove = this.f12750ar.remove(0);
                if (cVarRemove.f12812d.flags == 4) {
                    if (cVarRemove.f12809a) {
                        m12160B();
                    } else if (this.f12719O != null) {
                        this.f12719O.post(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_4.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    CameraMediaCodec.this.m12241x();
                                } finally {
                                    CameraMediaCodec.this.f12723S.open();
                                }
                            }
                        });
                        this.f12723S.close();
                        this.f12723S.block();
                    }
                    if (this.f12768k < 0 && this.f12767j < 0) {
                        m12166E();
                        if (this.f12711G != null) {
                            this.f12711G.release();
                        }
                    }
                } else {
                    m12184a(cVarRemove.f12810b, cVarRemove.f12811c, cVarRemove.f12812d);
                    cVarRemove.f12811c.clear();
                    cVarRemove.f12811c = null;
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                Message messageObtainMessage = this.f12717M.obtainMessage(3, 1);
                this.f12717M.removeMessages(3);
                this.f12717M.sendMessage(messageObtainMessage);
                return;
            }
        }
    }
}

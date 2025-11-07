package com.oplus.camera.p172ui.preview.p177a.p178a;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.ConditionVariable;
import android.view.Surface;
import com.oplus.camera.CameraLog;
import com.oplus.camera.doubleexposure.ClipVideoInfo;
import com.oplus.tblplayer.misc.IMediaFormat;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: VideoDecodeSync.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class VideoDecodeSync implements Runnable {

    /* renamed from: OplusGLSurfaceView_14 */
    private ClipVideoInfo f20953l;

    /* renamed from: OplusGLSurfaceView_6 */
    private SurfaceTexture f20954m;

    /* renamed from: PlatformImplementations.kt_3 */
    private MediaMetadataRetriever f20942a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private MediaFormat f20943b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private MediaExtractor f20944c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private MediaCodec f20945d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f20946e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f20947f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f20948g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f20949h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f20950i = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private long f20951j = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private long f20952k = -1;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f20955n = false;

    /* renamed from: o */
    private boolean f20956o = false;

    /* renamed from: p */
    private boolean f20957p = false;

    /* renamed from: q */
    private long f20958q = 0;

    /* renamed from: r */
    private long f20959r = 0;

    /* renamed from: s */
    private boolean f20960s = false;

    /* renamed from: t */
    private String f20961t = "";

    /* renamed from: u */
    private FirstDecodeFrameArriveListener f20962u = null;

    /* renamed from: v */
    private ConditionVariable f20963v = null;

    /* renamed from: w */
    private Object f20964w = null;

    /* renamed from: x */
    private ConditionVariable f20965x = new ConditionVariable(true);

    public VideoDecodeSync(ClipVideoInfo c2683b, SurfaceTexture surfaceTexture) throws IllegalArgumentException {
        this.f20953l = null;
        this.f20954m = null;
        this.f20953l = c2683b;
        this.f20954m = surfaceTexture;
        m22305l();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m22309a() {
        return this.f20947f;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m22313b() {
        return this.f20948g;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m22314c() {
        return this.f20949h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22311a(FirstDecodeFrameArriveListener interfaceC3394b) {
        this.f20962u = interfaceC3394b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22310a(ConditionVariable conditionVariable) {
        this.f20963v = conditionVariable;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22312a(Object obj) {
        this.f20964w = obj;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m22305l() throws IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            this.f20942a = new MediaMetadataRetriever();
            this.f20942a.setDataSource(this.f20953l.m12899c());
            String strExtractMetadata = this.f20942a.extractMetadata(18);
            String strExtractMetadata2 = this.f20942a.extractMetadata(19);
            String strExtractMetadata3 = this.f20942a.extractMetadata(24);
            this.f20947f = Integer.parseInt(strExtractMetadata);
            this.f20948g = Integer.parseInt(strExtractMetadata2);
            this.f20949h = Integer.parseInt(strExtractMetadata3);
            CameraLog.m12954a("VideoDecodeSync", "init, mWidth: " + this.f20947f + ", mHeight: " + this.f20948g + ", mRotation: " + this.f20949h);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            this.f20955n = true;
            m22308o();
        }
        CameraLog.m12954a("VideoDecodeSync", "init, time: " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", this: " + this);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m22306m() throws NumberFormatException {
        MediaMetadataRetriever mediaMetadataRetriever;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f20944c = new MediaExtractor();
        if (!this.f20953l.m12902f() && (mediaMetadataRetriever = this.f20942a) != null) {
            long OplusGLSurfaceView_15 = Long.MAX_VALUE;
            try {
                OplusGLSurfaceView_15 = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            this.f20953l.m12895a(0L);
            this.f20953l.m12898b(OplusGLSurfaceView_15);
        }
        try {
            this.f20944c.setDataSource(this.f20953l.m12899c());
            int trackCount = this.f20944c.getTrackCount();
            int OplusGLSurfaceView_13 = 0;
            while (true) {
                if (OplusGLSurfaceView_13 >= trackCount) {
                    break;
                }
                MediaFormat trackFormat = this.f20944c.getTrackFormat(OplusGLSurfaceView_13);
                this.f20961t = trackFormat.getString(IMediaFormat.KEY_MIME);
                if (this.f20961t != null && this.f20961t.startsWith("video")) {
                    this.f20946e = OplusGLSurfaceView_13;
                    this.f20943b = trackFormat;
                    this.f20943b.setInteger("OplusGLSurfaceView_13-frame-interval", 1);
                    this.f20943b.setInteger("color-format", 2135033992);
                    CameraLog.m12954a("VideoDecodeSync", "config, mVideoFormat: " + this.f20943b.toString() + ", mWidth: " + this.f20947f + ", mHeight: " + this.f20948g + ", rotation: " + this.f20949h + ", this: " + this);
                    break;
                }
                OplusGLSurfaceView_13++;
            }
            this.f20945d = MediaCodec.createDecoderByType(this.f20961t);
            this.f20945d.configure(this.f20943b, new Surface(this.f20954m), (MediaCrypto) null, 0);
            this.f20945d.start();
        } catch (IOException e2) {
            e2.printStackTrace();
            CameraLog.m12967f("VideoDecodeSync", "config, error: " + e2.getLocalizedMessage());
            this.f20955n = true;
            m22308o();
        } catch (Throwable th) {
            th.printStackTrace();
            CameraLog.m12967f("VideoDecodeSync", "config, error");
            this.f20955n = true;
            m22308o();
        }
        CameraLog.m12954a("VideoDecodeSync", "config, cost time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m22315d() {
        ConditionVariable conditionVariable = this.f20963v;
        if (conditionVariable != null) {
            conditionVariable.close();
        }
        this.f20960s = true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m22316e() {
        this.f20960s = false;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m22317f() {
        return this.f20960s;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22302a(ByteBuffer byteBuffer) {
        if (this.f20955n) {
            return -1;
        }
        byteBuffer.clear();
        int sampleData = this.f20944c.readSampleData(byteBuffer, 0);
        if (sampleData < 0) {
            return -1;
        }
        this.f20951j = this.f20944c.getSampleTime();
        this.f20950i = this.f20944c.getSampleFlags();
        this.f20944c.advance();
        return sampleData;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m22318g() {
        this.f20955n = true;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m22319h() {
        this.f20957p = true;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m22320i() {
        return !this.f20955n && this.f20956o;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m22321j() {
        return (this.f20955n || this.f20956o) ? false : true;
    }

    @Override // java.lang.Runnable
    public void run() throws NumberFormatException {
        this.f20965x.close();
        m22306m();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        m22316e();
        try {
            try {
                this.f20944c.selectTrack(this.f20946e);
                if (this.f20953l.m12902f() && this.f20953l.m12900d() > 0) {
                    this.f20944c.seekTo(this.f20953l.m12900d() * 1000, 2);
                }
                while (!this.f20955n) {
                    int iDequeueInputBuffer = this.f20945d.dequeueInputBuffer(1000L);
                    if (iDequeueInputBuffer > 0) {
                        int iM22302a = m22302a(this.f20945d.getInputBuffer(iDequeueInputBuffer));
                        if (iM22302a > 0 && !this.f20957p) {
                            this.f20945d.queueInputBuffer(iDequeueInputBuffer, 0, iM22302a, this.f20951j, this.f20950i);
                        } else {
                            this.f20957p = false;
                            this.f20945d.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                            this.f20945d.flush();
                            this.f20944c.seekTo(this.f20953l.m12900d() * 1000, 2);
                        }
                    }
                    m22303a(bufferInfo);
                    int iDequeueOutputBuffer = this.f20945d.dequeueOutputBuffer(bufferInfo, 1000L);
                    m22304b(bufferInfo);
                    if (iDequeueOutputBuffer > 0 && bufferInfo.presentationTimeUs / 1000 > this.f20953l.m12901e()) {
                        this.f20957p = true;
                    }
                    if (iDequeueOutputBuffer > 0 && !this.f20957p) {
                        if (this.f20952k < 0 || m22307n()) {
                            this.f20952k = System.currentTimeMillis();
                        }
                        if (this.f20955n) {
                            continue;
                        } else {
                            if (this.f20963v != null) {
                                this.f20963v.close();
                                this.f20963v.block();
                            }
                            synchronized (this.f20964w) {
                                this.f20945d.releaseOutputBuffer(iDequeueOutputBuffer, true);
                            }
                            if (!this.f20956o) {
                                CameraLog.m12954a("VideoDecodeSync", "first decode frame arrived");
                                this.f20956o = true;
                                if (this.f20962u != null) {
                                    this.f20962u.mo22300a();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                CameraLog.m12954a("VideoDecodeSync", "run, decode error, this: " + this);
            }
        } finally {
            CameraLog.m12954a("VideoDecodeSync", "run, decode thread end");
            this.f20965x.open();
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean m22307n() {
        return this.f20959r < this.f20958q;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22303a(MediaCodec.BufferInfo bufferInfo) {
        if (bufferInfo != null) {
            this.f20958q = bufferInfo.presentationTimeUs / 1000;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22304b(MediaCodec.BufferInfo bufferInfo) {
        if (bufferInfo != null) {
            this.f20959r = bufferInfo.presentationTimeUs / 1000;
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m22322k() {
        ConditionVariable conditionVariable = this.f20963v;
        if (conditionVariable != null) {
            conditionVariable.open();
        }
        this.f20965x.block(1000L);
        CameraLog.m12954a("VideoDecodeSync", "release, start");
        try {
            try {
                if (this.f20942a != null) {
                    this.f20942a.release();
                    this.f20942a = null;
                }
                if (this.f20945d != null) {
                    this.f20945d.stop();
                    this.f20945d.release();
                    this.f20944c.release();
                }
            } catch (IllegalStateException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        } finally {
            CameraLog.m12954a("VideoDecodeSync", "release, end");
        }
    }

    /* renamed from: o */
    private void m22308o() {
        FirstDecodeFrameArriveListener interfaceC3394b = this.f20962u;
        if (interfaceC3394b != null) {
            interfaceC3394b.mo22301b();
        }
    }
}

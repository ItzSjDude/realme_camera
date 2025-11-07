package com.oplus.camera.watch;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.OplusGLSurfaceView;
import com.oplus.tblplayer.misc.IMediaFormat;
import java.nio.ByteBuffer;

/* compiled from: WatchAgentCodec.java */
/* renamed from: com.oplus.camera.watch.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class WatchAgentCodec {

    /* renamed from: PlatformImplementations.kt_3 */
    private MediaCodec f23159a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private MediaFormat f23160b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Surface f23161c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Handler f23162d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private OplusGLSurfaceView f23163e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f23164f = false;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PlatformImplementations.kt_3 f23165g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f23166h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f23167i = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f23168j = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f23169k = 0;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f23170l = 0;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f23171m = false;

    /* compiled from: WatchAgentCodec.java */
    /* renamed from: com.oplus.camera.watch.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo24727a(byte[] bArr);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String m24714g() {
        return MimeTypes.VIDEO_H264;
    }

    @TargetApi(23)
    /* renamed from: PlatformImplementations.kt_3 */
    public void m24717a() {
        CameraLog.m12954a("WatchAgentCodec", "initVideoCodec");
        try {
            this.f23159a = MediaCodec.createEncoderByType(m24714g());
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        this.f23159a.setCallback(new MediaCodec.Callback() { // from class: com.oplus.camera.watch.PlatformImplementations.kt_3.1
            @Override // android.media.MediaCodec.Callback
            public void onInputBufferAvailable(MediaCodec mediaCodec, int OplusGLSurfaceView_13) {
                CameraLog.m12954a("WatchAgentCodec", "onInputBufferAvailable");
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputBufferAvailable(MediaCodec mediaCodec, int OplusGLSurfaceView_13, MediaCodec.BufferInfo bufferInfo) {
                ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(OplusGLSurfaceView_13);
                byte[] bArr = new byte[bufferInfo.size];
                outputBuffer.get(bArr);
                if (WatchAgentCodec.this.f23165g != null) {
                    WatchAgentCodec.this.f23165g.mo24727a(bArr);
                }
                mediaCodec.releaseOutputBuffer(OplusGLSurfaceView_13, false);
                if (4 == bufferInfo.flags) {
                    CameraLog.m12954a("WatchAgentCodec", "onOutputBufferAvailable, Video encode Stopped");
                    WatchAgentCodec.this.m24715h();
                    WatchAgentCodec.this.m24710d();
                    if (WatchAgentCodec.this.f23161c != null) {
                        WatchAgentCodec.this.f23161c.release();
                        return;
                    }
                    return;
                }
                if (2 == bufferInfo.flags) {
                    CameraLog.m12954a("WatchAgentCodec", "onOutputBufferAvailable, BUFFER_FLAG_CODEC_CONFIG");
                    return;
                }
                if (1 == bufferInfo.flags) {
                    CameraLog.m12954a("WatchAgentCodec", "onOutputBufferAvailable, BUFFER_FLAG_SYNC_FRAME");
                }
                WatchAgentCodec.this.f23164f = true;
            }

            @Override // android.media.MediaCodec.Callback
            public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
                CameraLog.m12967f("WatchAgentCodec", "onError");
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
                CameraLog.m12954a("WatchAgentCodec", "onOutputFormatChanged");
            }
        }, this.f23162d);
        this.f23164f = false;
        this.f23159a.configure(m24713f(), (Surface) null, (MediaCrypto) null, 1);
        this.f23161c = this.f23159a.createInputSurface();
        if (this.f23163e != null) {
            CameraLog.m12954a("WatchAgentCodec", "initVideoCodec, setWatchOutputSurface");
            this.f23163e.setWatchOutputSurface(this.f23161c);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24723b() {
        m24716i();
        this.f23162d.post(new Runnable() { // from class: com.oplus.camera.watch.PlatformImplementations.kt_3.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WatchAgentCodec.this.m24717a();
                    WatchAgentCodec.this.f23159a.start();
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m24710d() {
        Handler handler = this.f23162d;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.f23162d = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m24725c() {
        m24712e();
        this.f23163e = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24719a(Size size) {
        CameraLog.m12954a("WatchAgentCodec", "setCodecSize, size: " + size);
        this.f23166h = size.getWidth();
        this.f23167i = size.getHeight();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24722a(boolean z) {
        this.f23171m = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24721a(PlatformImplementations.kt_3 aVar) {
        this.f23165g = aVar;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m24712e() {
        CameraLog.m12954a("WatchAgentCodec", "stopEncode, mbWatchCodecOutputDataCome: " + this.f23164f);
        OplusGLSurfaceView surfaceHolderCallbackC2766q = this.f23163e;
        if (surfaceHolderCallbackC2766q != null) {
            surfaceHolderCallbackC2766q.m14135i();
        }
        if (this.f23164f) {
            MediaCodec mediaCodec = this.f23159a;
            if (mediaCodec != null) {
                mediaCodec.signalEndOfInputStream();
                return;
            }
            return;
        }
        Handler handler = this.f23162d;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.oplus.camera.watch.PlatformImplementations.kt_3.3
                @Override // java.lang.Runnable
                public void run() {
                    WatchAgentCodec.this.m24715h();
                    WatchAgentCodec.this.m24710d();
                    if (WatchAgentCodec.this.f23161c != null) {
                        WatchAgentCodec.this.f23161c.release();
                    }
                }
            });
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private MediaFormat m24713f() {
        if (this.f23160b == null) {
            this.f23160b = MediaFormat.createVideoFormat(m24714g(), this.f23166h, this.f23167i);
            this.f23160b.setInteger("bitrate-mode", 2);
            this.f23160b.setInteger("bitrate", this.f23171m ? 327680 : 655360);
            MediaFormat mediaFormat = this.f23160b;
            int OplusGLSurfaceView_13 = this.f23169k;
            if (OplusGLSurfaceView_13 == 0) {
                OplusGLSurfaceView_13 = 25;
            }
            mediaFormat.setInteger(IMediaFormat.KEY_FRAME_RATE, OplusGLSurfaceView_13);
            this.f23160b.setInteger("color-format", 2130708361);
            MediaFormat mediaFormat2 = this.f23160b;
            int i2 = this.f23170l;
            if (i2 == 0) {
                i2 = 1;
            }
            mediaFormat2.setInteger("OplusGLSurfaceView_13-frame-interval", i2);
        }
        CameraLog.m12954a("WatchAgentCodec", "getFormat, bitRate: " + this.f23160b.getInteger("bitrate") + ", frameRate: " + this.f23160b.getInteger(IMediaFormat.KEY_FRAME_RATE) + ", frameInterval: " + this.f23160b.getInteger("OplusGLSurfaceView_13-frame-interval") + ", mbLowBit: " + this.f23171m);
        return this.f23160b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m24715h() {
        CameraLog.m12954a("WatchAgentCodec", "releaseCodec");
        try {
            if (this.f23159a != null) {
                this.f23159a.stop();
                this.f23159a.release();
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        CameraLog.m12954a("WatchAgentCodec", "releaseVideoCodec, end");
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m24716i() {
        if (this.f23162d == null) {
            HandlerThread handlerThread = new HandlerThread("watch codec thread");
            handlerThread.start();
            this.f23162d = new Handler(handlerThread.getLooper());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24720a(OplusGLSurfaceView surfaceHolderCallbackC2766q) {
        CameraLog.m12954a("WatchAgentCodec", "setInputGLSurfaceView, glSurfaceView: " + surfaceHolderCallbackC2766q);
        this.f23163e = surfaceHolderCallbackC2766q;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24718a(int OplusGLSurfaceView_13) {
        this.f23168j = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24724b(int OplusGLSurfaceView_13) {
        this.f23169k = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m24726c(int OplusGLSurfaceView_13) {
        this.f23170l = OplusGLSurfaceView_13;
    }
}

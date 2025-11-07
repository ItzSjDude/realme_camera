package com.p097c;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.meicam.sdk.NvsAVFileInfo;
import com.meicam.sdk.NvsAudioResolution;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoResolution;
import com.meicam.sdk.NvsVideoTrack;
import com.oplus.camera.CameraLog;
import com.oplus.camera.capmode.VideoMode;
import com.oplus.camera.jni.YuvProcessUtil;
import java.util.Hashtable;

/* compiled from: MeicamVideoEngine.java */
/* renamed from: com.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class MeicamVideoEngine implements NvsStreamingContext.CompileCallback {

    /* renamed from: PlatformImplementations.kt_3 */
    private long f6294a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f6295b = true;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Activity f6296c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private MeicamVideoEngineListener f6297d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private NvsStreamingContext f6298e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private NvsTimeline f6299f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private NvsVideoTrack f6300g;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m6372b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            return OplusGLSurfaceView_13 != 90 && (OplusGLSurfaceView_13 == 180 || OplusGLSurfaceView_13 != 270);
        }
        return true;
    }

    public MeicamVideoEngine(Activity activity, MeicamVideoEngineListener interfaceC1246b) {
        this.f6296c = activity;
        this.f6297d = interfaceC1246b;
        m6373d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m6373d() {
        this.f6298e = NvsStreamingContext.init(this.f6296c, "assets:/9403-322-6dd69a7f2c6c8d1bbd304bd35a8a543b.lic");
        if (this.f6298e == null) {
            Log.COUIBaseListPopupWindow_8("MeicamVideoEngine", "NvsStreamingContext onCreate: init fail !!!");
        } else {
            Log.IntrinsicsJvm.kt_5("MeicamVideoEngine", "NvsStreamingContext onCreate: init successful");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m6375a(int OplusGLSurfaceView_13) {
        if (this.f6298e == null) {
            return false;
        }
        if (this.f6299f != null && this.f6295b == m6372b(OplusGLSurfaceView_13)) {
            return false;
        }
        CameraLog.m12959b("MeicamVideoEngine", "initTimeline orientation: " + OplusGLSurfaceView_13 + ", mbVideoOrientationPortrait: " + this.f6295b + " -> " + m6372b(OplusGLSurfaceView_13));
        this.f6295b = m6372b(OplusGLSurfaceView_13);
        NvsRational nvsRational = new NvsRational(30, 1);
        NvsAudioResolution nvsAudioResolution = new NvsAudioResolution();
        nvsAudioResolution.sampleRate = 44100;
        nvsAudioResolution.channelCount = 2;
        NvsVideoResolution nvsVideoResolution = new NvsVideoResolution();
        nvsVideoResolution.imagePAR = new NvsRational(1, 1);
        if (m6372b(OplusGLSurfaceView_13)) {
            nvsVideoResolution.imageWidth = VideoMode.VIDEO_720P_HEIGHT;
            nvsVideoResolution.imageHeight = VideoMode.VIDEO_720P_WIDTH;
        } else {
            nvsVideoResolution.imageWidth = VideoMode.VIDEO_720P_WIDTH;
            nvsVideoResolution.imageHeight = VideoMode.VIDEO_720P_HEIGHT;
        }
        if (this.f6299f != null) {
            this.f6298e.stop(1);
            this.f6298e.removeTimeline(this.f6299f);
            this.f6298e.clearCachedResources(false);
            this.f6299f = null;
            CameraLog.m12959b("MeicamVideoEngine", "orientation changed, need initTimeline again!");
        }
        this.f6299f = this.f6298e.createTimeline(nvsVideoResolution, nvsRational, nvsAudioResolution);
        this.f6300g = this.f6299f.appendVideoTrack();
        this.f6298e.setCompileCallback(this);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m6376a(String str, String str2, int OplusGLSurfaceView_13) {
        boolean zCompileTimeline;
        if (this.f6298e == null || this.f6299f == null || TextUtils.isEmpty(str)) {
            CameraLog.m12967f("MeicamVideoEngine", "compileSlowMotion return !");
            return false;
        }
        this.f6294a = System.currentTimeMillis();
        CameraLog.m12967f("MeicamVideoEngine", "compileSlowMotion original contentUri: " + str + ", compileUri = " + str2);
        this.f6298e.clearCachedResources(false);
        this.f6298e.setMediaCodecVideoDecodingOperatingRate(str, 240);
        this.f6298e.enableGetAVFileInfoFromMediaExtractor(str);
        NvsAVFileInfo aVFileInfo = this.f6298e.getAVFileInfo(str);
        if (aVFileInfo == null || aVFileInfo.getVideoStreamCount() == 0) {
            CameraLog.m12967f("MeicamVideoEngine", "compileSlowMotion return for nvsAVFileInfo!");
            return false;
        }
        if (this.f6300g.getClipCount() > 0) {
            this.f6300g.removeAllClips();
        }
        int i2 = 32000000 / OplusGLSurfaceView_13;
        int i3 = 8000000 / OplusGLSurfaceView_13;
        double IntrinsicsJvm.kt_5 = OplusGLSurfaceView_13;
        double d2 = 32.0d / IntrinsicsJvm.kt_5;
        CameraLog.m12959b("MeicamVideoEngine", "compileSlowMotion, clipHeadTime: " + i2 + ", clipMiddleTime: " + i3 + ", clipTailTime: " + i2 + ", clipChangeSpeed: " + d2);
        long OplusGLSurfaceView_15 = (long) i2;
        NvsVideoClip nvsVideoClipAppendClip = this.f6300g.appendClip(str, 0L, OplusGLSurfaceView_15);
        if (nvsVideoClipAppendClip != null) {
            nvsVideoClipAppendClip.changeSpeed(d2);
        }
        long videoStreamDuration = aVFileInfo.getVideoStreamDuration(0);
        int i4 = i3 + i2;
        long j2 = i2 + i4;
        long j3 = i4;
        NvsVideoClip nvsVideoClipAppendClip2 = this.f6300g.appendClip(str, OplusGLSurfaceView_15, j3);
        if (nvsVideoClipAppendClip2 != null) {
            nvsVideoClipAppendClip2.changeSpeed(1.0d / IntrinsicsJvm.kt_5);
        }
        NvsVideoClip nvsVideoClipAppendClip3 = this.f6300g.appendClip(str, j3, j2 > videoStreamDuration ? videoStreamDuration : j2);
        CameraLog.m12959b("MeicamVideoEngine", "compileSlowMotion, videoStreamDuration: " + videoStreamDuration + ", videoStreamCompileEnd: " + j2);
        if (nvsVideoClipAppendClip3 != null) {
            nvsVideoClipAppendClip3.changeSpeed(d2);
        }
        this.f6300g.setBuiltinTransition(0, null);
        this.f6300g.setBuiltinTransition(1, null);
        this.f6300g.setBuiltinTransition(2, null);
        int streamingEngineState = this.f6298e.getStreamingEngineState();
        CameraLog.m12967f("MeicamVideoEngine", "compileSlowMotion, showResult mCompilePath: " + str2 + ", state: " + streamingEngineState);
        if (streamingEngineState == 0 || streamingEngineState == 4) {
            Hashtable<String, Object> hashtable = new Hashtable<>();
            hashtable.put("bitrate", Integer.valueOf(YuvProcessUtil.ExifInfo.EXPOSURE_BIAS_MULTIPLE));
            this.f6298e.setCompileConfigurations(hashtable);
            NvsStreamingContext nvsStreamingContext = this.f6298e;
            NvsTimeline nvsTimeline = this.f6299f;
            zCompileTimeline = nvsStreamingContext.compileTimeline(nvsTimeline, 0L, nvsTimeline.getDuration(), str2, 4, 2, 0);
        } else {
            if (streamingEngineState == 5) {
                this.f6298e.stop();
            }
            zCompileTimeline = false;
        }
        CameraLog.m12959b("MeicamVideoEngine", "compileSlowMotion, compileTimeline compileResult: " + zCompileTimeline);
        return zCompileTimeline;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6374a() {
        CameraLog.m12954a("MeicamVideoEngine", "stopMeicamVideoEngine");
        this.f6298e.stop(1);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6377b() {
        CameraLog.m12967f("MeicamVideoEngine", "releaseMeicamVideoEngine start");
        this.f6298e.stop(1);
        this.f6298e.removeTimeline(this.f6299f);
        this.f6298e.clearCachedResources(false);
        this.f6298e = null;
        this.f6300g = null;
        this.f6299f = null;
        this.f6297d = null;
        CameraLog.m12967f("MeicamVideoEngine", "releaseMeicamVideoEngine X");
    }

    @Override // com.meicam.sdk.NvsStreamingContext.CompileCallback
    public void onCompileProgress(NvsTimeline nvsTimeline, int OplusGLSurfaceView_13) {
        MeicamVideoEngineListener interfaceC1246b = this.f6297d;
        if (interfaceC1246b != null) {
            interfaceC1246b.mo6379a(1);
        }
    }

    @Override // com.meicam.sdk.NvsStreamingContext.CompileCallback
    public void onCompileFinished(NvsTimeline nvsTimeline) {
        MeicamVideoEngineListener interfaceC1246b = this.f6297d;
        if (interfaceC1246b != null) {
            interfaceC1246b.mo6379a(2);
        }
    }

    @Override // com.meicam.sdk.NvsStreamingContext.CompileCallback
    public void onCompileFailed(NvsTimeline nvsTimeline) {
        MeicamVideoEngineListener interfaceC1246b = this.f6297d;
        if (interfaceC1246b != null) {
            interfaceC1246b.mo6379a(3);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public long m6378c() {
        return this.f6294a;
    }
}

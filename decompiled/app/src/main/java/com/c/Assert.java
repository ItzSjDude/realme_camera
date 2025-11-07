package com.c_renamed;

/* compiled from: MeicamVideoEngine.java */
/* loaded from: classes.dex */
public class a_renamed implements com.meicam.sdk.NvsStreamingContext.CompileCallback {

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f2378a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f2379b = true;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.app.Activity f2380c;
    private com.c_renamed.b_renamed d_renamed;
    private com.meicam.sdk.NvsStreamingContext e_renamed;
    private com.meicam.sdk.NvsTimeline f_renamed;
    private com.meicam.sdk.NvsVideoTrack g_renamed;

    private boolean b_renamed(int i_renamed) {
        if (i_renamed != 0) {
            return i_renamed != 90 && (i_renamed == 180 || i_renamed != 270);
        }
        return true;
    }

    public a_renamed(android.app.Activity activity, com.c_renamed.b_renamed bVar) {
        this.f2380c = activity;
        this.d_renamed = bVar;
        d_renamed();
    }

    private void d_renamed() {
        this.e_renamed = com.meicam.sdk.NvsStreamingContext.init(this.f2380c, "assets:/9403-322-6dd69a7f2c6c8d1bbd304bd35a8a543b.lic");
        if (this.e_renamed == null) {
            android.util.Log.e_renamed("MeicamVideoEngine", "NvsStreamingContext onCreate: init fail !!!");
        } else {
            android.util.Log.d_renamed("MeicamVideoEngine", "NvsStreamingContext onCreate: init successful");
        }
    }

    public boolean a_renamed(int i_renamed) {
        if (this.e_renamed == null) {
            return false;
        }
        if (this.f_renamed != null && this.f2379b == b_renamed(i_renamed)) {
            return false;
        }
        com.oplus.camera.e_renamed.b_renamed("MeicamVideoEngine", "initTimeline orientation: " + i_renamed + ", mbVideoOrientationPortrait: " + this.f2379b + " -> " + b_renamed(i_renamed));
        this.f2379b = b_renamed(i_renamed);
        com.meicam.sdk.NvsRational nvsRational = new com.meicam.sdk.NvsRational(30, 1);
        com.meicam.sdk.NvsAudioResolution nvsAudioResolution = new com.meicam.sdk.NvsAudioResolution();
        nvsAudioResolution.sampleRate = 44100;
        nvsAudioResolution.channelCount = 2;
        com.meicam.sdk.NvsVideoResolution nvsVideoResolution = new com.meicam.sdk.NvsVideoResolution();
        nvsVideoResolution.imagePAR = new com.meicam.sdk.NvsRational(1, 1);
        if (b_renamed(i_renamed)) {
            nvsVideoResolution.imageWidth = com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT;
            nvsVideoResolution.imageHeight = com.oplus.camera.capmode.w_renamed.VIDEO_720P_WIDTH;
        } else {
            nvsVideoResolution.imageWidth = com.oplus.camera.capmode.w_renamed.VIDEO_720P_WIDTH;
            nvsVideoResolution.imageHeight = com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT;
        }
        if (this.f_renamed != null) {
            this.e_renamed.stop(1);
            this.e_renamed.removeTimeline(this.f_renamed);
            this.e_renamed.clearCachedResources(false);
            this.f_renamed = null;
            com.oplus.camera.e_renamed.b_renamed("MeicamVideoEngine", "orientation changed, need initTimeline again!");
        }
        this.f_renamed = this.e_renamed.createTimeline(nvsVideoResolution, nvsRational, nvsAudioResolution);
        this.g_renamed = this.f_renamed.appendVideoTrack();
        this.e_renamed.setCompileCallback(this);
        return true;
    }

    public boolean a_renamed(java.lang.String str, java.lang.String str2, int i_renamed) {
        boolean zCompileTimeline;
        if (this.e_renamed == null || this.f_renamed == null || android.text.TextUtils.isEmpty(str)) {
            com.oplus.camera.e_renamed.f_renamed("MeicamVideoEngine", "compileSlowMotion return !");
            return false;
        }
        this.f2378a = java.lang.System.currentTimeMillis();
        com.oplus.camera.e_renamed.f_renamed("MeicamVideoEngine", "compileSlowMotion original contentUri: " + str + ", compileUri = " + str2);
        this.e_renamed.clearCachedResources(false);
        this.e_renamed.setMediaCodecVideoDecodingOperatingRate(str, 240);
        this.e_renamed.enableGetAVFileInfoFromMediaExtractor(str);
        com.meicam.sdk.NvsAVFileInfo aVFileInfo = this.e_renamed.getAVFileInfo(str);
        if (aVFileInfo == null || aVFileInfo.getVideoStreamCount() == 0) {
            com.oplus.camera.e_renamed.f_renamed("MeicamVideoEngine", "compileSlowMotion return for nvsAVFileInfo!");
            return false;
        }
        if (this.g_renamed.getClipCount() > 0) {
            this.g_renamed.removeAllClips();
        }
        int i2 = 32000000 / i_renamed;
        int i3 = 8000000 / i_renamed;
        double d_renamed = i_renamed;
        double d2 = 32.0d / d_renamed;
        com.oplus.camera.e_renamed.b_renamed("MeicamVideoEngine", "compileSlowMotion, clipHeadTime: " + i2 + ", clipMiddleTime: " + i3 + ", clipTailTime: " + i2 + ", clipChangeSpeed: " + d2);
        long j_renamed = (long) i2;
        com.meicam.sdk.NvsVideoClip nvsVideoClipAppendClip = this.g_renamed.appendClip(str, 0L, j_renamed);
        if (nvsVideoClipAppendClip != null) {
            nvsVideoClipAppendClip.changeSpeed(d2);
        }
        long videoStreamDuration = aVFileInfo.getVideoStreamDuration(0);
        int i4 = i3 + i2;
        long j2 = i2 + i4;
        long j3 = i4;
        com.meicam.sdk.NvsVideoClip nvsVideoClipAppendClip2 = this.g_renamed.appendClip(str, j_renamed, j3);
        if (nvsVideoClipAppendClip2 != null) {
            nvsVideoClipAppendClip2.changeSpeed(1.0d / d_renamed);
        }
        com.meicam.sdk.NvsVideoClip nvsVideoClipAppendClip3 = this.g_renamed.appendClip(str, j3, j2 > videoStreamDuration ? videoStreamDuration : j2);
        com.oplus.camera.e_renamed.b_renamed("MeicamVideoEngine", "compileSlowMotion, videoStreamDuration: " + videoStreamDuration + ", videoStreamCompileEnd: " + j2);
        if (nvsVideoClipAppendClip3 != null) {
            nvsVideoClipAppendClip3.changeSpeed(d2);
        }
        this.g_renamed.setBuiltinTransition(0, null);
        this.g_renamed.setBuiltinTransition(1, null);
        this.g_renamed.setBuiltinTransition(2, null);
        int streamingEngineState = this.e_renamed.getStreamingEngineState();
        com.oplus.camera.e_renamed.f_renamed("MeicamVideoEngine", "compileSlowMotion, showResult mCompilePath: " + str2 + ", state: " + streamingEngineState);
        if (streamingEngineState == 0 || streamingEngineState == 4) {
            java.util.Hashtable<java.lang.String, java.lang.Object> hashtable = new java.util.Hashtable<>();
            hashtable.put("bitrate", java.lang.Integer.valueOf(com.oplus.camera.jni.YuvProcessUtil.ExifInfo.EXPOSURE_BIAS_MULTIPLE));
            this.e_renamed.setCompileConfigurations(hashtable);
            com.meicam.sdk.NvsStreamingContext nvsStreamingContext = this.e_renamed;
            com.meicam.sdk.NvsTimeline nvsTimeline = this.f_renamed;
            zCompileTimeline = nvsStreamingContext.compileTimeline(nvsTimeline, 0L, nvsTimeline.getDuration(), str2, 4, 2, 0);
        } else {
            if (streamingEngineState == 5) {
                this.e_renamed.stop();
            }
            zCompileTimeline = false;
        }
        com.oplus.camera.e_renamed.b_renamed("MeicamVideoEngine", "compileSlowMotion, compileTimeline compileResult: " + zCompileTimeline);
        return zCompileTimeline;
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("MeicamVideoEngine", "stopMeicamVideoEngine");
        this.e_renamed.stop(1);
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.f_renamed("MeicamVideoEngine", "releaseMeicamVideoEngine start");
        this.e_renamed.stop(1);
        this.e_renamed.removeTimeline(this.f_renamed);
        this.e_renamed.clearCachedResources(false);
        this.e_renamed = null;
        this.g_renamed = null;
        this.f_renamed = null;
        this.d_renamed = null;
        com.oplus.camera.e_renamed.f_renamed("MeicamVideoEngine", "releaseMeicamVideoEngine X_renamed");
    }

    @Override // com.meicam.sdk.NvsStreamingContext.CompileCallback
    public void onCompileProgress(com.meicam.sdk.NvsTimeline nvsTimeline, int i_renamed) {
        com.c_renamed.b_renamed bVar = this.d_renamed;
        if (bVar != null) {
            bVar.a_renamed(1);
        }
    }

    @Override // com.meicam.sdk.NvsStreamingContext.CompileCallback
    public void onCompileFinished(com.meicam.sdk.NvsTimeline nvsTimeline) {
        com.c_renamed.b_renamed bVar = this.d_renamed;
        if (bVar != null) {
            bVar.a_renamed(2);
        }
    }

    @Override // com.meicam.sdk.NvsStreamingContext.CompileCallback
    public void onCompileFailed(com.meicam.sdk.NvsTimeline nvsTimeline) {
        com.c_renamed.b_renamed bVar = this.d_renamed;
        if (bVar != null) {
            bVar.a_renamed(3);
        }
    }

    public long c_renamed() {
        return this.f2378a;
    }
}

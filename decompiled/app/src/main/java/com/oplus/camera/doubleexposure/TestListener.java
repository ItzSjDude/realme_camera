package com.oplus.camera.doubleexposure;

/* compiled from: VideoClipManager.java */
/* loaded from: classes2.dex */
public class g_renamed implements com.meicam.sdk.NvsStreamingContext.PlaybackCallback2, com.oplus.camera.ui.widget.e_renamed.a_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.meicam.sdk.NvsStreamingContext f4404b;
    private com.oplus.camera.ui.widget.e_renamed g_renamed;
    private android.app.Activity h_renamed;
    private com.oplus.camera.ui.CameraUIInterface i_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f4403a = "";

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.meicam.sdk.NvsTimeline f4405c = null;
    private int d_renamed = 0;
    private int e_renamed = 0;
    private int f_renamed = 0;
    private android.os.Handler j_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.doubleexposure.g_renamed.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i_renamed = message.what;
            if (i_renamed == 1) {
                com.oplus.camera.doubleexposure.g_renamed.this.m_renamed();
            } else {
                if (i_renamed != 2) {
                    return;
                }
                com.oplus.camera.doubleexposure.g_renamed.this.l_renamed();
            }
        }
    };

    /* compiled from: VideoClipManager.java */
    public interface a_renamed {
        void onVideoClipDone();
    }

    public g_renamed(android.view.ViewGroup viewGroup, android.app.Activity activity, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        this.f4404b = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.h_renamed = activity;
        this.i_renamed = cameraUIInterface;
        this.f4404b = com.meicam.sdk.NvsStreamingContext.getInstance();
        this.g_renamed = (com.oplus.camera.ui.widget.e_renamed) viewGroup.findViewById(com.oplus.camera.R_renamed.id_renamed.video_clip_view);
        this.g_renamed.setSeekToCallback(this);
        this.f4404b.setPlaybackCallback2(this);
        this.f4404b.setPlaybackCallback(new com.meicam.sdk.NvsStreamingContext.PlaybackCallback() { // from class: com.oplus.camera.doubleexposure.g_renamed.2
            @Override // com.meicam.sdk.NvsStreamingContext.PlaybackCallback
            public void onPlaybackPreloadingCompletion(com.meicam.sdk.NvsTimeline nvsTimeline) {
                com.oplus.camera.e_renamed.f_renamed("VideoClipManager", "onPlaybackPreloadingCompletion");
            }

            @Override // com.meicam.sdk.NvsStreamingContext.PlaybackCallback
            public void onPlaybackStopped(com.meicam.sdk.NvsTimeline nvsTimeline) {
                com.oplus.camera.e_renamed.f_renamed("VideoClipManager", "onPlaybackStopped");
            }

            @Override // com.meicam.sdk.NvsStreamingContext.PlaybackCallback
            public void onPlaybackEOF(com.meicam.sdk.NvsTimeline nvsTimeline) {
                com.oplus.camera.e_renamed.f_renamed("VideoClipManager", "onPlaybackEOF");
                com.oplus.camera.doubleexposure.g_renamed.this.f_renamed();
            }
        });
    }

    public boolean a_renamed(java.lang.String str) {
        com.meicam.sdk.NvsTimeline nvsTimeline = this.f4405c;
        if (nvsTimeline != null) {
            this.f4404b.removeTimeline(nvsTimeline);
        }
        this.f4403a = str;
        com.meicam.sdk.NvsAVFileInfo aVFileInfo = this.f4404b.getAVFileInfo(this.f4403a);
        if (aVFileInfo != null) {
            com.meicam.sdk.NvsSize videoStreamDimension = aVFileInfo.getVideoStreamDimension(0);
            com.meicam.sdk.NvsRational videoStreamFrameRate = aVFileInfo.getVideoStreamFrameRate(0);
            if (videoStreamDimension != null) {
                int videoStreamRotation = aVFileInfo.getVideoStreamRotation(0);
                if (1 == videoStreamRotation || 3 == videoStreamRotation) {
                    this.d_renamed = videoStreamDimension.width;
                    this.e_renamed = videoStreamDimension.height;
                } else {
                    this.d_renamed = videoStreamDimension.height;
                    this.e_renamed = videoStreamDimension.width;
                }
            }
            if (videoStreamFrameRate != null) {
                this.f_renamed = videoStreamFrameRate.num;
            }
        }
        com.meicam.sdk.NvsVideoResolution nvsVideoResolution = new com.meicam.sdk.NvsVideoResolution();
        nvsVideoResolution.imagePAR = new com.meicam.sdk.NvsRational(1, 1);
        com.meicam.sdk.NvsRational nvsRational = new com.meicam.sdk.NvsRational(30, 1);
        nvsVideoResolution.imageWidth = this.e_renamed;
        nvsVideoResolution.imageHeight = this.d_renamed;
        com.meicam.sdk.NvsAudioResolution nvsAudioResolution = new com.meicam.sdk.NvsAudioResolution();
        nvsAudioResolution.sampleRate = 44100;
        nvsAudioResolution.channelCount = 2;
        this.f4405c = this.f4404b.createTimeline(nvsVideoResolution, nvsRational, nvsAudioResolution);
        com.meicam.sdk.NvsTimeline nvsTimeline2 = this.f4405c;
        if (nvsTimeline2 == null || aVFileInfo == null) {
            com.oplus.camera.e_renamed.a_renamed("VideoClipManager", "setFilePath, video parsing failure");
            com.oplus.camera.util.o_renamed.a_renamed(this.h_renamed, com.oplus.camera.R_renamed.string.mode_double_exposure_video_cannot_resolve);
            com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.i_renamed;
            if (cameraUIInterface != null) {
                cameraUIInterface.t_renamed(com.oplus.camera.R_renamed.string.mode_double_exposure_video_cannot_resolve);
            }
            return false;
        }
        this.f4403a = str;
        com.meicam.sdk.NvsVideoTrack nvsVideoTrackAppendVideoTrack = nvsTimeline2.appendVideoTrack();
        nvsVideoTrackAppendVideoTrack.appendClip(this.f4403a);
        this.f4404b.connectTimelineWithLiveWindow(this.f4405c, this.g_renamed.getLiveWindow());
        this.g_renamed.getThumbnail().setThumbnailImageFillMode(1);
        this.g_renamed.getThumbnail().setThumbnailAspectRatio(1.0f);
        java.util.ArrayList<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc> arrayList = new java.util.ArrayList<>();
        for (int i_renamed = 0; i_renamed < nvsVideoTrackAppendVideoTrack.getClipCount(); i_renamed++) {
            com.meicam.sdk.NvsVideoClip clipByIndex = nvsVideoTrackAppendVideoTrack.getClipByIndex(i_renamed);
            if (clipByIndex != null) {
                com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc thumbnailSequenceDesc = new com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc();
                thumbnailSequenceDesc.mediaFilePath = clipByIndex.getFilePath();
                thumbnailSequenceDesc.trimIn = clipByIndex.getTrimIn();
                thumbnailSequenceDesc.trimOut = clipByIndex.getTrimOut();
                thumbnailSequenceDesc.inPoint = clipByIndex.getInPoint();
                thumbnailSequenceDesc.outPoint = clipByIndex.getOutPoint();
                thumbnailSequenceDesc.stillImageHint = false;
                arrayList.add(thumbnailSequenceDesc);
            }
        }
        com.oplus.camera.e_renamed.b_renamed("VideoClipManager", "setFilePath: " + this.f4403a + " info: " + aVFileInfo);
        this.g_renamed.getThumbnail().setThumbnailSequenceDescArray(arrayList);
        m_renamed();
        try {
            this.g_renamed.a_renamed(this.e_renamed, this.d_renamed);
            this.g_renamed.setTotalTime(this.f4405c.getDuration());
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        b_renamed(0.0f);
        f_renamed();
        return true;
    }

    public void a_renamed() {
        this.g_renamed.setVisibility(0);
    }

    public void b_renamed() {
        this.f4403a = null;
        this.f4405c = null;
        this.g_renamed.setVisibility(8);
        this.f4404b.pausePlayback();
        this.f4404b.stop();
    }

    public void a_renamed(boolean z_renamed) {
        this.f4403a = null;
        this.f4405c = null;
        this.g_renamed.a_renamed(z_renamed);
        this.f4404b.pausePlayback();
        this.f4404b.stop();
    }

    public void c_renamed() {
        this.f4404b.pausePlayback();
    }

    public void d_renamed() {
        this.f4404b.stop();
        this.h_renamed = null;
        this.i_renamed = null;
        this.g_renamed = null;
        this.f4404b = null;
    }

    public void e_renamed() {
        if (o_renamed()) {
            f_renamed();
        } else {
            b_renamed();
        }
    }

    public void f_renamed() {
        a_renamed(-1.0f);
    }

    public void a_renamed(float f_renamed) {
        if (this.f4405c == null) {
            return;
        }
        this.f4404b.setAudioOutputDeviceVolume(0.0f);
        if (0.0f >= f_renamed) {
            f_renamed = this.g_renamed.getLeftVideoProcess();
        }
        if (f_renamed > this.g_renamed.getRightVideoProcess()) {
            f_renamed = this.g_renamed.getLeftVideoProcess();
        }
        this.f4404b.playbackTimeline(this.f4405c, (long) (f_renamed * this.f4405c.getDuration()), (long) (this.g_renamed.getRightVideoProcess() * this.f4405c.getDuration()), 1, true, 0);
    }

    public void g_renamed() {
        this.j_renamed.removeMessages(1);
        this.j_renamed.sendEmptyMessage(1);
    }

    public boolean b_renamed(float f_renamed) {
        if (this.f4405c == null) {
            return false;
        }
        this.f4404b.stopRecording();
        return this.f4404b.seekTimeline(this.f4405c, (long) (f_renamed * r2.getDuration()), 1, 2);
    }

    public void h_renamed() {
        this.j_renamed.sendEmptyMessage(2);
    }

    public void a_renamed(java.lang.String str, com.meicam.sdk.NvsStreamingContext.CompileCallback2 compileCallback2) {
        this.f4404b.pausePlayback();
        this.f4404b.setCompileCallback2(compileCallback2);
        if (this.f4404b.compileTimeline(this.f4405c, (long) (this.g_renamed.getLeftVideoProcess() * this.f4405c.getDuration()), (long) (this.g_renamed.getRightVideoProcess() * this.f4405c.getDuration()), str, 256, 2, 0)) {
            h_renamed();
        }
    }

    public java.lang.String i_renamed() {
        return this.f4403a;
    }

    public com.oplus.camera.doubleexposure.b_renamed j_renamed() {
        long leftVideoProcess = ((long) (this.g_renamed.getLeftVideoProcess() * this.f4405c.getDuration())) / 1000;
        long rightVideoProcess = ((long) (this.g_renamed.getRightVideoProcess() * this.f4405c.getDuration())) / 1000;
        com.oplus.camera.doubleexposure.b_renamed bVar = new com.oplus.camera.doubleexposure.b_renamed(this.f4403a, leftVideoProcess, rightVideoProcess, true);
        bVar.a_renamed(this.f_renamed);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(this.d_renamed);
        stringBuffer.append("x_renamed");
        stringBuffer.append(this.e_renamed);
        bVar.a_renamed(stringBuffer.toString());
        com.oplus.camera.e_renamed.b_renamed("VideoClipManager", "getClipVideoInfo startTime: " + leftVideoProcess + ", endTime: " + rightVideoProcess);
        return bVar;
    }

    @Override // com.meicam.sdk.NvsStreamingContext.PlaybackCallback2
    public void onPlaybackTimelinePosition(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed) {
        this.g_renamed.setThumbProcess((j_renamed * 1.0f) / nvsTimeline.getDuration());
    }

    @Override // com.oplus.camera.ui.widget.e_renamed.a_renamed
    public void c_renamed(float f_renamed) {
        if (android.text.TextUtils.isEmpty(this.f4403a)) {
            return;
        }
        b_renamed(f_renamed);
    }

    @Override // com.oplus.camera.ui.widget.e_renamed.a_renamed
    public void d_renamed(float f_renamed) {
        a_renamed(f_renamed);
    }

    @Override // com.oplus.camera.ui.widget.e_renamed.a_renamed
    public void k_renamed() {
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.i_renamed;
        if (cameraUIInterface != null) {
            cameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_max_recording_hint, 0, true, false, false, false, false, true, 5000, true);
        }
    }

    public void l_renamed() {
        this.g_renamed.a_renamed();
    }

    public void m_renamed() {
        this.g_renamed.b_renamed();
    }

    public boolean n_renamed() {
        return this.g_renamed.c_renamed();
    }

    public boolean o_renamed() {
        return this.g_renamed.d_renamed();
    }

    public void a_renamed(com.oplus.camera.ui.widget.e_renamed.b_renamed bVar) {
        this.g_renamed.setVideoClipClick(bVar);
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.ui.widget.e_renamed eVar = this.g_renamed;
        if (eVar != null) {
            eVar.setOrientation(i_renamed);
        }
    }
}

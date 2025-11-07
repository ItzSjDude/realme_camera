package com.oplus.camera.doubleexposure;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.meicam.sdk.NvsAVFileInfo;
import com.meicam.sdk.NvsAudioResolution;
import com.meicam.sdk.NvsMultiThumbnailSequenceView;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsSize;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoResolution;
import com.meicam.sdk.NvsVideoTrack;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.widget.VideoClipView;
import com.oplus.camera.util.ToastUtil;
import java.util.ArrayList;

/* compiled from: VideoClipManager.java */
/* renamed from: com.oplus.camera.doubleexposure.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class VideoClipManager implements NvsStreamingContext.PlaybackCallback2, VideoClipView.PlatformImplementations.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private NvsStreamingContext f13201b;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private VideoClipView f13206g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Activity f13207h;

    /* renamed from: OplusGLSurfaceView_13 */
    private CameraUIInterface f13208i;

    /* renamed from: PlatformImplementations.kt_3 */
    private String f13200a = "";

    /* renamed from: IntrinsicsJvm.kt_3 */
    private NvsTimeline f13202c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f13203d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f13204e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f13205f = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private Handler f13209j = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.doubleexposure.COUIBaseListPopupWindow_11.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 1) {
                VideoClipManager.this.m12948m();
            } else {
                if (OplusGLSurfaceView_13 != 2) {
                    return;
                }
                VideoClipManager.this.m12947l();
            }
        }
    };

    /* compiled from: VideoClipManager.java */
    /* renamed from: com.oplus.camera.doubleexposure.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        void onVideoClipDone();
    }

    public VideoClipManager(ViewGroup viewGroup, Activity activity, CameraUIInterface cameraUIInterface) {
        this.f13201b = null;
        this.f13206g = null;
        this.f13207h = null;
        this.f13208i = null;
        this.f13207h = activity;
        this.f13208i = cameraUIInterface;
        this.f13201b = NvsStreamingContext.getInstance();
        this.f13206g = (VideoClipView) viewGroup.findViewById(R.id_renamed.video_clip_view);
        this.f13206g.setSeekToCallback(this);
        this.f13201b.setPlaybackCallback2(this);
        this.f13201b.setPlaybackCallback(new NvsStreamingContext.PlaybackCallback() { // from class: com.oplus.camera.doubleexposure.COUIBaseListPopupWindow_11.2
            @Override // com.meicam.sdk.NvsStreamingContext.PlaybackCallback
            public void onPlaybackPreloadingCompletion(NvsTimeline nvsTimeline) {
                CameraLog.m12967f("VideoClipManager", "onPlaybackPreloadingCompletion");
            }

            @Override // com.meicam.sdk.NvsStreamingContext.PlaybackCallback
            public void onPlaybackStopped(NvsTimeline nvsTimeline) {
                CameraLog.m12967f("VideoClipManager", "onPlaybackStopped");
            }

            @Override // com.meicam.sdk.NvsStreamingContext.PlaybackCallback
            public void onPlaybackEOF(NvsTimeline nvsTimeline) {
                CameraLog.m12967f("VideoClipManager", "onPlaybackEOF");
                VideoClipManager.this.m12941f();
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m12933a(String str) {
        NvsTimeline nvsTimeline = this.f13202c;
        if (nvsTimeline != null) {
            this.f13201b.removeTimeline(nvsTimeline);
        }
        this.f13200a = str;
        NvsAVFileInfo aVFileInfo = this.f13201b.getAVFileInfo(this.f13200a);
        if (aVFileInfo != null) {
            NvsSize videoStreamDimension = aVFileInfo.getVideoStreamDimension(0);
            NvsRational videoStreamFrameRate = aVFileInfo.getVideoStreamFrameRate(0);
            if (videoStreamDimension != null) {
                int videoStreamRotation = aVFileInfo.getVideoStreamRotation(0);
                if (1 == videoStreamRotation || 3 == videoStreamRotation) {
                    this.f13203d = videoStreamDimension.width;
                    this.f13204e = videoStreamDimension.height;
                } else {
                    this.f13203d = videoStreamDimension.height;
                    this.f13204e = videoStreamDimension.width;
                }
            }
            if (videoStreamFrameRate != null) {
                this.f13205f = videoStreamFrameRate.num;
            }
        }
        NvsVideoResolution nvsVideoResolution = new NvsVideoResolution();
        nvsVideoResolution.imagePAR = new NvsRational(1, 1);
        NvsRational nvsRational = new NvsRational(30, 1);
        nvsVideoResolution.imageWidth = this.f13204e;
        nvsVideoResolution.imageHeight = this.f13203d;
        NvsAudioResolution nvsAudioResolution = new NvsAudioResolution();
        nvsAudioResolution.sampleRate = 44100;
        nvsAudioResolution.channelCount = 2;
        this.f13202c = this.f13201b.createTimeline(nvsVideoResolution, nvsRational, nvsAudioResolution);
        NvsTimeline nvsTimeline2 = this.f13202c;
        if (nvsTimeline2 == null || aVFileInfo == null) {
            CameraLog.m12954a("VideoClipManager", "setFilePath, video parsing failure");
            ToastUtil.m24640a(this.f13207h, R.string.mode_double_exposure_video_cannot_resolve);
            CameraUIInterface cameraUIInterface = this.f13208i;
            if (cameraUIInterface != null) {
                cameraUIInterface.mo18270t(R.string.mode_double_exposure_video_cannot_resolve);
            }
            return false;
        }
        this.f13200a = str;
        NvsVideoTrack nvsVideoTrackAppendVideoTrack = nvsTimeline2.appendVideoTrack();
        nvsVideoTrackAppendVideoTrack.appendClip(this.f13200a);
        this.f13201b.connectTimelineWithLiveWindow(this.f13202c, this.f13206g.getLiveWindow());
        this.f13206g.getThumbnail().setThumbnailImageFillMode(1);
        this.f13206g.getThumbnail().setThumbnailAspectRatio(1.0f);
        ArrayList<NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc> arrayList = new ArrayList<>();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < nvsVideoTrackAppendVideoTrack.getClipCount(); OplusGLSurfaceView_13++) {
            NvsVideoClip clipByIndex = nvsVideoTrackAppendVideoTrack.getClipByIndex(OplusGLSurfaceView_13);
            if (clipByIndex != null) {
                NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc thumbnailSequenceDesc = new NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc();
                thumbnailSequenceDesc.mediaFilePath = clipByIndex.getFilePath();
                thumbnailSequenceDesc.trimIn = clipByIndex.getTrimIn();
                thumbnailSequenceDesc.trimOut = clipByIndex.getTrimOut();
                thumbnailSequenceDesc.inPoint = clipByIndex.getInPoint();
                thumbnailSequenceDesc.outPoint = clipByIndex.getOutPoint();
                thumbnailSequenceDesc.stillImageHint = false;
                arrayList.add(thumbnailSequenceDesc);
            }
        }
        CameraLog.m12959b("VideoClipManager", "setFilePath: " + this.f13200a + " info: " + aVFileInfo);
        this.f13206g.getThumbnail().setThumbnailSequenceDescArray(arrayList);
        m12948m();
        try {
            this.f13206g.m24128a(this.f13204e, this.f13203d);
            this.f13206g.setTotalTime(this.f13202c.getDuration());
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        m12935b(0.0f);
        m12941f();
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12927a() {
        this.f13206g.setVisibility(0);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12934b() {
        this.f13200a = null;
        this.f13202c = null;
        this.f13206g.setVisibility(8);
        this.f13201b.pausePlayback();
        this.f13201b.stop();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12932a(boolean z) {
        this.f13200a = null;
        this.f13202c = null;
        this.f13206g.m24129a(z);
        this.f13201b.pausePlayback();
        this.f13201b.stop();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12936c() {
        this.f13201b.pausePlayback();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m12938d() {
        this.f13201b.stop();
        this.f13207h = null;
        this.f13208i = null;
        this.f13206g = null;
        this.f13201b = null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m12940e() {
        if (m12950o()) {
            m12941f();
        } else {
            m12934b();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m12941f() {
        m12928a(-1.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12928a(float COUIBaseListPopupWindow_12) {
        if (this.f13202c == null) {
            return;
        }
        this.f13201b.setAudioOutputDeviceVolume(0.0f);
        if (0.0f >= COUIBaseListPopupWindow_12) {
            COUIBaseListPopupWindow_12 = this.f13206g.getLeftVideoProcess();
        }
        if (COUIBaseListPopupWindow_12 > this.f13206g.getRightVideoProcess()) {
            COUIBaseListPopupWindow_12 = this.f13206g.getLeftVideoProcess();
        }
        this.f13201b.playbackTimeline(this.f13202c, (long) (COUIBaseListPopupWindow_12 * this.f13202c.getDuration()), (long) (this.f13206g.getRightVideoProcess() * this.f13202c.getDuration()), 1, true, 0);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m12942g() {
        this.f13209j.removeMessages(1);
        this.f13209j.sendEmptyMessage(1);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m12935b(float COUIBaseListPopupWindow_12) {
        if (this.f13202c == null) {
            return false;
        }
        this.f13201b.stopRecording();
        return this.f13201b.seekTimeline(this.f13202c, (long) (COUIBaseListPopupWindow_12 * r2.getDuration()), 1, 2);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m12943h() {
        this.f13209j.sendEmptyMessage(2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12931a(String str, NvsStreamingContext.CompileCallback2 compileCallback2) {
        this.f13201b.pausePlayback();
        this.f13201b.setCompileCallback2(compileCallback2);
        if (this.f13201b.compileTimeline(this.f13202c, (long) (this.f13206g.getLeftVideoProcess() * this.f13202c.getDuration()), (long) (this.f13206g.getRightVideoProcess() * this.f13202c.getDuration()), str, 256, 2, 0)) {
            m12943h();
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public String m12944i() {
        return this.f13200a;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public ClipVideoInfo m12945j() {
        long leftVideoProcess = ((long) (this.f13206g.getLeftVideoProcess() * this.f13202c.getDuration())) / 1000;
        long rightVideoProcess = ((long) (this.f13206g.getRightVideoProcess() * this.f13202c.getDuration())) / 1000;
        ClipVideoInfo c2683b = new ClipVideoInfo(this.f13200a, leftVideoProcess, rightVideoProcess, true);
        c2683b.m12894a(this.f13205f);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f13203d);
        stringBuffer.append("x");
        stringBuffer.append(this.f13204e);
        c2683b.m12896a(stringBuffer.toString());
        CameraLog.m12959b("VideoClipManager", "getClipVideoInfo startTime: " + leftVideoProcess + ", endTime: " + rightVideoProcess);
        return c2683b;
    }

    @Override // com.meicam.sdk.NvsStreamingContext.PlaybackCallback2
    public void onPlaybackTimelinePosition(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15) {
        this.f13206g.setThumbProcess((OplusGLSurfaceView_15 * 1.0f) / nvsTimeline.getDuration());
    }

    @Override // com.oplus.camera.p172ui.widget.VideoClipView.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo12937c(float COUIBaseListPopupWindow_12) {
        if (TextUtils.isEmpty(this.f13200a)) {
            return;
        }
        m12935b(COUIBaseListPopupWindow_12);
    }

    @Override // com.oplus.camera.p172ui.widget.VideoClipView.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo12939d(float COUIBaseListPopupWindow_12) {
        m12928a(COUIBaseListPopupWindow_12);
    }

    @Override // com.oplus.camera.p172ui.widget.VideoClipView.PlatformImplementations.kt_3
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo12946k() {
        CameraUIInterface cameraUIInterface = this.f13208i;
        if (cameraUIInterface != null) {
            cameraUIInterface.mo18073a(R.string.camera_double_exposure_max_recording_hint, 0, true, false, false, false, false, true, 5000, true);
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m12947l() {
        this.f13206g.m24126a();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m12948m() {
        this.f13206g.m24130b();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public boolean m12949n() {
        return this.f13206g.m24131c();
    }

    /* renamed from: o */
    public boolean m12950o() {
        return this.f13206g.m24132d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12930a(VideoClipView.IntrinsicsJvm.kt_4 bVar) {
        this.f13206g.setVideoClipClick(bVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12929a(int OplusGLSurfaceView_13) {
        VideoClipView viewOnClickListenerC3522e = this.f13206g;
        if (viewOnClickListenerC3522e != null) {
            viewOnClickListenerC3522e.setOrientation(OplusGLSurfaceView_13);
        }
    }
}

package com.oplus.camera.p161r;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.hardware.camera2.CaptureRequest;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.constant.CameraUnitKeys;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.capmode.VideoMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.jni.YuvProcessUtil;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p144g.C2735b;
import com.oplus.camera.p161r.SLVBaseMode;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.control.ThumbImageView;
import com.oplus.camera.p172ui.menu.setting.CameraMenuOption;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.FocusAimMsgData;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPreviewCallback;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SlowVideoMode.java */
/* renamed from: com.oplus.camera.r.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class SlowVideoMode extends VideoMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f15871g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private HashMap<String, String> f15872h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f15873i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f15874j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f15875k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f15876l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f15877m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f15878n;

    /* renamed from: o */
    private SLVBaseMode f15879o;

    /* renamed from: p */
    private CameraMenuOption f15880p;

    /* renamed from: q */
    private final SLVBaseMode.PlatformImplementations.kt_3 f15881q;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m16259b(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 120 ? OplusGLSurfaceView_13 != 240 ? OplusGLSurfaceView_13 != 480 ? OplusGLSurfaceView_13 != 960 ? CameraParameter.VideoFpsValue.VIDEO_FPS_120 : CameraParameter.VideoFpsValue.VIDEO_FPS_960 : CameraParameter.VideoFpsValue.VIDEO_FPS_480 : CameraParameter.VideoFpsValue.VIDEO_FPS_240 : CameraParameter.VideoFpsValue.VIDEO_FPS_120;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean allowSwitchCamera() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.REC_MODE_SLOW_VIDEO;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSlowVideoMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needPreviewMeta(int OplusGLSurfaceView_13) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        return false;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean supportBinauralRecord() {
        return false;
    }

    public SlowVideoMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f15871g = false;
        this.f15872h = new HashMap<>();
        this.f15873i = false;
        this.f15874j = false;
        this.f15875k = false;
        this.f15876l = false;
        this.f15877m = false;
        this.f15878n = false;
        this.f15879o = null;
        this.f15880p = null;
        this.f15881q = new SLVBaseMode.PlatformImplementations.kt_3() { // from class: com.oplus.camera.r.COUIBaseListPopupWindow_11.7
            @Override // com.oplus.camera.p161r.SLVBaseMode.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo16228a(String str) throws Throwable {
                Thumbnail.IntrinsicsJvm.kt_5 dVar = new Thumbnail.IntrinsicsJvm.kt_5();
                dVar.f18298k = 1;
                dVar.f18291d = Uri.parse(str);
                SlowVideoMode c2917g = SlowVideoMode.this;
                c2917g.m16257a(c2917g.getVideoFileName(), str, dVar);
                SlowVideoMode.this.m16252a(dVar, true, true);
                SlowVideoMode.this.f15877m = false;
                CameraLog.m12967f("SlowVideoMode", "onProcessFinished !, videoContentUri = " + str);
            }

            @Override // com.oplus.camera.p161r.SLVBaseMode.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo16229b(String str) {
                SlowVideoMode c2917g = SlowVideoMode.this;
                c2917g.deleteVideoFile(c2917g.getVideoFileName());
                SlowVideoMode.this.m16252a((Thumbnail.IntrinsicsJvm.kt_5) null, true, false);
                SlowVideoMode.this.f15877m = false;
                CameraLog.m12967f("SlowVideoMode", "onCompileFailed !, videoContentUri = " + str);
            }
        };
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SLOW_VIDEO);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return getSupportFunction(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        super.onResume(z);
        this.mCameraInterface.mo10473a(4);
        if (isVideoRecordStopped()) {
            this.f15873i = false;
            this.f15874j = false;
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        super.onDestroy();
        this.f15871g = false;
        m16276j();
        HashMap<String, String> map = this.f15872h;
        if (map != null) {
            map.clear();
            this.f15872h = null;
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getCanAddMenuOption(String str) {
        if (CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str) || CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS.equals(str)) {
            return true;
        }
        return super.getCanAddMenuOption(str);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        this.mbHasDragIntelligentView = false;
        this.mHandler.removeMessages(12);
        super.onPause();
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18067a(R.string.camera_intelligent_high_frame_saving);
            this.mCameraUIInterface.mo18067a(R.string.camera_intelligent_high_frame_not_detected);
        }
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10553b(4);
        }
        if (!getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) || this.f15876l) {
            return;
        }
        if (isVideoRecordStarted() || isVideoRecordStarting() || isVideoRecordStopping()) {
            stopVideoRecordThread();
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        CameraLog.m12954a("SlowVideoMode", "onInitCameraMode");
        super.onInitCameraMode();
        enableVideoRecordingSound(false);
        this.mOrientation = this.mCameraInterface.mo10591u();
        this.mCameraInterface.mo10473a(4);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needUploadOplusStatistics(String str) {
        if (CameraUIInterface.KEY_FACE_DETECTION.equals(str) && isVideoRecording()) {
            return false;
        }
        if (CameraUIInterface.KEY_ZOOM.equals(str)) {
            return !this.mbFrontCamera && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SLOW_VIDEO_ZOOM);
        }
        return super.needUploadOplusStatistics(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16246a() {
        if (getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED)) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, this.mActivity.getString(R.string.camera_intelligent_high_frame_default_selected));
            if (isSlowVideoHighFrame()) {
                String string2 = this.mPreferences.getString(CameraUIInterface.KEY_TEMP_INTELLIGENT_HIGH_FRAME_SELECTED, "");
                if (!TextUtils.isEmpty(string2)) {
                    SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                    editorEdit.putString(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, string2);
                    editorEdit.apply();
                    string = string2;
                }
                this.mPreferences.edit().putString(CameraUIInterface.KEY_TEMP_INTELLIGENT_HIGH_FRAME_SELECTED, string).apply();
                this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, string);
            } else {
                this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, "off");
            }
            if (isSlowVideoHighFrame() && "on".equals(string)) {
                m16247a(0);
            } else {
                m16247a(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16260b() {
        if (this.mCameraUIInterface == null || !getSupportFunction(CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU)) {
            return;
        }
        this.mCameraUIInterface.mo18254p(m16265e());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0102  */
    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p161r.SlowVideoMode.getSupportFunction(java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m16262c() {
        return this.mActivity != null && getSupportFunction(CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU) && "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU, this.mActivity.getString(R.string.camera_slow_video_mode_frame_default_value)));
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        CameraLog.m12954a("SlowVideoMode", "onDeInitCameraMode");
        enableVideoRecordingSound(true);
        m16276j();
        super.onDeInitCameraMode(str);
        this.mCameraInterface.mo10553b(4);
        m16254a(false, false, false);
        m16247a(8);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeModeChanged() {
        super.beforeModeChanged();
        this.mCameraUIInterface.mo18067a(R.string.camera_intelligent_high_frame_hint_on);
        this.mCameraUIInterface.mo18067a(R.string.camera_intelligent_high_frame_hint_off);
        this.mCameraUIInterface.mo18110a(R.string.camera_intelligent_high_frame_slow_selected);
        this.mCameraUIInterface.mo18110a(R.string.camera_intelligent_high_frame_super_selected);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo shutterButtonInfo = super.getShutterButtonInfo();
        shutterButtonInfo.m19235c("button_shape_dial_still");
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        super.onBeforePreview();
        if (getSupportMenu(CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS)) {
            m16274i();
        }
        if (this.mVideoSizeType.equals("video_size_1080p")) {
            this.mProfile.videoBitRate = YuvProcessUtil.ExifInfo.EXPOSURE_BIAS_MULTIPLE;
        } else if (this.mVideoSizeType.equals("video_size_720p")) {
            int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_720P_VIDEO_BIT_RATE);
            if (configIntValue > 0 && CameraParameter.VideoEncoder.H264.equals(getVideoCodec())) {
                this.mProfile.videoBitRate = configIntValue;
            } else {
                this.mProfile.videoBitRate = 7500000;
            }
        }
        CameraLog.m12954a("SlowVideoMode", "onBeforePreview, slowVideoFps: " + getSlowVideoFps());
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        super.onAfterStartPreview(z);
        if (!this.f15871g && z) {
            if (this.mActivity != null) {
                this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.r.COUIBaseListPopupWindow_11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SlowVideoMode.this.mCameraUIInterface != null) {
                            SlowVideoMode.this.mCameraUIInterface.mo18070a(R.string.camera_slow_video_tips, -1, true, false, false);
                        }
                    }
                });
            }
            this.f15871g = true;
        }
        if (this.mHandler == null || !z) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.oplus.camera.r.COUIBaseListPopupWindow_11.2
            @Override // java.lang.Runnable
            public void run() {
                SlowVideoMode.this.m16260b();
                SlowVideoMode.this.m16246a();
                SlowVideoMode c2917g = SlowVideoMode.this;
                c2917g.m16254a(c2917g.m16262c(), false, true);
                if (SlowVideoMode.this.getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED) && SlowVideoMode.this.getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) && "on".equals(SlowVideoMode.this.mPreferences.getString(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, SlowVideoMode.this.mActivity.getString(R.string.camera_intelligent_high_frame_default_selected)))) {
                    SlowVideoMode.this.m16247a(0);
                }
                if (SlowVideoMode.this.mCameraInterface != null) {
                    SlowVideoMode.this.mCameraInterface.mo10574i(false);
                }
            }
        });
    }

    @Override // com.oplus.camera.capmode.VideoMode
    public void checkVideoCodecAndReset() {
        if (Util.m24357at() && getSupportFunction(CameraUIInterface.KEY_SUPPORT_SLOW_VIDEO_H265)) {
            return;
        }
        String string = this.mActivity.getString(R.string.camera_video_codec_default_value);
        if (CameraParameter.VideoEncoder.H265.equals(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_CODEC, string))) {
            CameraLog.m12954a("SlowVideoMode", "checkVideoCodecAndReset, reset video codec to default.");
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_CODEC, string);
            editorEdit.apply();
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode
    public Float getRealVideoTimeRatio() {
        return super.getRealVideoTimeRatio();
    }

    @Override // com.oplus.camera.capmode.VideoMode
    public boolean getNeedReduceBitRate() {
        return CameraParameter.VideoEncoder.H265.equals(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_CODEC, this.mActivity.getString(R.string.camera_video_codec_default_value)));
    }

    @Override // com.oplus.camera.capmode.VideoMode
    public Double getRealCaptureRate() {
        String strM16268f = m16268f();
        if (TextUtils.isEmpty(strM16268f)) {
            return null;
        }
        return Double.valueOf(Double.parseDouble(strM16268f));
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected String getVideoTitle() {
        String strM16268f = m16268f();
        if (!TextUtils.isEmpty(strM16268f)) {
            if (needPostProcessAfterStopRecord()) {
                return this.f15879o.mo16221a(strM16268f);
            }
            return "slow_motion_hfr_" + strM16268f + ":0,0,0,0";
        }
        return super.getVideoTitle();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if (!"type_video_frame".equals(str) || this.mCameraInterface == null) {
            return "type_video".equals(str);
        }
        return this.mCameraInterface.mo10575i() && !isUseMediaCodec() && !isUseMediaRecorderNotUseAPS() && getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHFR() {
        return Util.m24169C();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Range<Integer> getVideoFpsRange() {
        String strM16268f = m16268f();
        if (TextUtils.isEmpty(strM16268f)) {
            return null;
        }
        return Range.create(Integer.valueOf((isVideoRecording() || Util.m24169C()) ? Integer.parseInt(strM16268f) : 30), Integer.valueOf(Integer.parseInt(strM16268f)));
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public String getVideoSizeType() {
        if (this.mPreferences instanceof ComboPreferences) {
            return ((ComboPreferences) this.mPreferences).m11073a(CameraUIInterface.KEY_SLOW_VIDEO_SIZE, getDefaultVideoSize());
        }
        return this.mPreferences.getString(CameraUIInterface.KEY_SLOW_VIDEO_SIZE, getDefaultVideoSize());
    }

    @Override // com.oplus.camera.capmode.VideoMode
    public String getDefaultVideoSize() {
        return Util.m24485o(this.mCameraId);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public int getVideoFps() {
        return getVideoFrameRate();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h) {
        Size videoPreviewSize = getVideoPreviewSize(getVideoSizeType());
        return videoPreviewSize != null ? videoPreviewSize : super.getPreviewSize(c2698h);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11380z(true);
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaRecorderNotUseAPS() {
        return (AlgoSwitchConfig.getSupportApsPreview() && !this.mbFrontCamera && isSlowVideoHighFrame()) ? false : true;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected int getSlowVideoFps() {
        int slowVideoFps = super.getSlowVideoFps();
        if (getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE)) {
            slowVideoFps = m16265e();
        } else if (getSupportMenu(CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS)) {
            slowVideoFps = m16271h();
        } else {
            Range<Integer> videoFpsRange = getVideoFpsRange();
            if (videoFpsRange != null) {
                slowVideoFps = ((Integer) videoFpsRange.getLower()).intValue();
            }
        }
        CameraLog.m12954a("SlowVideoMode", "getSlowVideoFps: " + slowVideoFps);
        return slowVideoFps;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int m16263d() {
        if (this.mbFrontCamera && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO)) {
            return Integer.parseInt(m16245a(Boolean.valueOf(this.mbFrontCamera), ConfigDataBase.KEY_PREVIEW_FPS_HFR_1080P));
        }
        return m16277k();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int m16265e() {
        return this.mPreferences.getInt(CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, m16263d());
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String m16268f() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME) && !this.mbFrontCamera) {
            int iM16265e = m16265e();
            if (iM16265e == 120) {
                return CameraConfig.getConfigFpsValue(ConfigDataBase.KEY_SLOW_VIDEO_HFR_120FPS_VIDOETYPE);
            }
            if (iM16265e == 240) {
                return CameraConfig.getConfigFpsValue(ConfigDataBase.KEY_SLOW_VIDEO_HFR_240FPS_VIDOETYPE);
            }
            if (iM16265e != 480) {
                return iM16265e != 960 ? "" : CameraConfig.getConfigFpsValue(ConfigDataBase.KEY_SLOW_VIDEO_HFR_960FPS_VIDOETYPE);
            }
            return CameraConfig.getConfigFpsValue(ConfigDataBase.KEY_SLOW_VIDEO_HFR_480FPS_VIDOETYPE);
        }
        if (getSupportMenu(CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS)) {
            return SLVModeFactory.m16239b(m16271h());
        }
        String videoSizeType = getVideoSizeType();
        if ("video_size_1080p".equals(videoSizeType)) {
            return m16245a(Boolean.valueOf(this.mbFrontCamera), ConfigDataBase.KEY_PREVIEW_FPS_HFR_1080P);
        }
        return "video_size_720p".equals(videoSizeType) ? CameraConfig.getConfigStringValue(ConfigDataBase.KEY_PREVIEW_FPS_HFR_720P) : "";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m16245a(Boolean bool, String str) {
        if (ConfigDataBase.KEY_PREVIEW_FPS_HFR_1080P.equals(str)) {
            String configStringValue = CameraConfig.getConfigStringValue(ConfigDataBase.KEY_PREVIEW_FPS_HFR_1080P_FRONT);
            String configStringValue2 = CameraConfig.getConfigStringValue(ConfigDataBase.KEY_PREVIEW_FPS_HFR_1080P);
            return (!bool.booleanValue() || configStringValue == null) ? configStringValue2 : configStringValue;
        }
        return CameraConfig.getConfigStringValue(str);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str)) {
            return !this.mbFrontCamera;
        }
        if (CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED.equals(str) || CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU.equals(str) || CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS.equals(str)) {
            return getSupportFunction(str);
        }
        if (CameraUIInterface.KEY_SLOW_VIDEO_SIZE.equals(str)) {
            if (this.f15880p == null) {
                this.f15880p = this.mCameraUIInterface.mo18220h(CameraUIInterface.KEY_SLOW_VIDEO_SIZE);
            }
            if (this.f15880p != null && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_720P_SLOW_VIDEO)) {
                if (this.mbFrontCamera && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO)) {
                    this.f15880p.m21173l(getDefaultVideoSize());
                    this.f15880p.m21139b(CameraUIInterface.KEY_SLOW_VIDEO_SIZE, this.mActivity.getString(R.string.camera_video_size_value_720p));
                } else {
                    this.f15880p.m21173l(getDefaultVideoSize());
                    this.f15880p.mo21123a(CameraUIInterface.KEY_SLOW_VIDEO_SIZE, this.mActivity.getString(R.string.camera_video_size_value_720p));
                }
            } else if (this.f15880p != null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_720P_SLOW_VIDEO) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_1080P_SLOW_VIDEO)) {
                if (this.mbFrontCamera && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO)) {
                    this.f15880p.m21173l(getDefaultVideoSize());
                    this.f15880p.m21139b(CameraUIInterface.KEY_SLOW_VIDEO_SIZE, this.mActivity.getString(R.string.camera_video_size_value_1080p));
                } else {
                    this.f15880p.m21173l(getDefaultVideoSize());
                    this.f15880p.mo21123a(CameraUIInterface.KEY_SLOW_VIDEO_SIZE, this.mActivity.getString(R.string.camera_video_size_value_1080p));
                }
            }
            CameraMenuOption cameraMenuOption = this.f15880p;
            if (cameraMenuOption == null || cameraMenuOption.m21095X() > 1) {
                return getSupportFunction(str);
            }
            return false;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        int OplusGLSurfaceView_13 = (this.mbFrontCamera || !getSupportFunction(CameraUIInterface.KEY_SUPPORT_FOVC)) ? 32781 : 33549;
        if (this.mOneCamera == null || this.mOneCamera.mo13086e().m13262a(getVideoSizeType()) == null) {
            return OplusGLSurfaceView_13;
        }
        return 0;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        if (this.mCameraInterface != null) {
            if (needPostProcessAfterStopRecord()) {
                this.mCameraUIInterface.mo18221h(this.f15879o.mo16225c());
                this.mCameraUIInterface.mo18091a(this.f15879o.mo16220a(2));
            } else {
                m16254a(false, true, true);
                this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
                this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(5, "button_color_inside_red", "button_shape_dial_still", 1));
            }
            this.mCameraUIInterface.mo18110a(R.string.camera_intelligent_high_frame_super_selected, R.string.camera_intelligent_high_frame_slow_selected);
        }
        if (!Util.m24169C()) {
            this.mOneCamera.mo13053a(true, getVideoSizeType());
        }
        super.beforeStartRecording();
        if (this.mOneCamera != null) {
            if (!Util.m24169C() && this.mCameraInterface != null) {
                this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_ORIENTATION, (CaptureRequest.Key) Integer.valueOf(getJpegOrientation(this.mCameraId, this.mCameraInterface.mo10591u())));
            }
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void afterStartRecording() {
        this.mOneCamera.mo13029a(1, AEAFHelp.m11154b(), AEAFHelp.m11154b(), false);
        if (Util.m24169C()) {
            this.mOneCamera.mo13029a(1, AEAFHelp.m11154b(), AEAFHelp.m11154b(), false);
        }
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        if (isMotionDetectOpen()) {
            if (this.mCameraUIInterface != null) {
                this.mCameraUIInterface.mo18070a(R.string.camera_intelligent_high_frame_detecting, -1, false, false, true);
                this.mCameraUIInterface.mo18031E(false);
            }
            if (this.mCameraInterface != null) {
                this.mCameraInterface.mo10470Z();
                this.mCameraInterface.mo10574i(true);
            }
            this.mHandler.removeMessages(12);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(12), 120000L);
        } else if (this.mCameraUIInterface != null && getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE)) {
            this.mCameraUIInterface.mo18107a(false, true);
            this.mCameraUIInterface.mo18070a(R.string.camera_intelligent_high_frame_recording, -1, false, false, true);
        } else if (needPostProcessAfterStopRecord()) {
            this.mCameraUIInterface.mo18107a(false, true);
        }
        if (!this.mbPaused && this.f15875k) {
            this.f15875k = false;
        }
        if (this.mbPaused || !this.f15876l) {
            return;
        }
        this.f15876l = false;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean isMotionDetectOpen() {
        return this.mActivity != null && getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) && "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, this.mActivity.getString(R.string.camera_intelligent_high_frame_default_selected)));
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void forceStopVideoRecording(boolean z) {
        super.forceStopVideoRecording(z);
        this.f15875k = true;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void stopVideoRecordThread() {
        this.f15876l = true;
        super.stopVideoRecordThread();
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean isRecordFileValid() {
        boolean zIsRecordFileValid;
        if (isSlowVideoHighFrame()) {
            zIsRecordFileValid = (this.mbStopVideoFail || this.f15875k) ? false : true;
        } else {
            zIsRecordFileValid = super.isRecordFileValid();
        }
        boolean zIsMotionDetectOpen = isMotionDetectOpen();
        if (zIsMotionDetectOpen) {
            zIsRecordFileValid = zIsRecordFileValid && this.f15873i;
        }
        CameraLog.m12959b("SlowVideoMode", "isRecordFileValid: " + zIsRecordFileValid + ", motionDetectOpen: " + zIsMotionDetectOpen + ", mbMotionDetected: " + this.f15873i + ", motionDetectOpen: " + zIsMotionDetectOpen + ", mbStopVideoFail: " + this.mbStopVideoFail + ", mbForceStopRecord: " + this.f15875k);
        return zIsRecordFileValid;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean isMotionDetected() {
        return this.f15873i;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onMotionDetected() {
        if (!this.f15873i && !this.mbPaused) {
            CameraLog.m12959b("SlowVideoMode", "onMotionDetected");
            this.mHandler.post(new Runnable() { // from class: com.oplus.camera.r.COUIBaseListPopupWindow_11.3
                @Override // java.lang.Runnable
                public void run() {
                    if (SlowVideoMode.this.mCameraUIInterface == null || !SlowVideoMode.this.isMotionDetectOpen() || SlowVideoMode.this.mbPaused) {
                        return;
                    }
                    SlowVideoMode.this.mCameraUIInterface.mo18070a(R.string.camera_intelligent_high_frame_recording, -1, false, false, true);
                    SlowVideoMode.this.mCameraUIInterface.mo18107a(false, true);
                    SlowVideoMode.this.mCameraUIInterface.mo18221h(2800);
                    SlowVideoMode.this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(3, "button_color_inside_none", "button_shape_dial_still", 1));
                    SlowVideoMode.this.mCameraInterface.mo10574i(false);
                }
            });
        }
        if (this.f15873i) {
            return;
        }
        this.f15873i = true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onFrameInterpolationStarted() {
        if (!this.f15874j && !this.mbPaused) {
            CameraLog.m12959b("SlowVideoMode", "onFrameInterpolationStarted");
            this.mHandler.post(new Runnable() { // from class: com.oplus.camera.r.COUIBaseListPopupWindow_11.4
                @Override // java.lang.Runnable
                public void run() {
                    if (SlowVideoMode.this.mCameraUIInterface == null || SlowVideoMode.this.mbPaused) {
                        return;
                    }
                    CameraLog.m12959b("SlowVideoMode", "onFrameInterpolationStarted, onVideoShutterButtonClick");
                    SlowVideoMode.this.m17833aj();
                    SlowVideoMode.this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(4, "button_color_inside_red", "button_shape_dial_still"));
                    SlowVideoMode.this.mCameraUIInterface.mo18070a(R.string.camera_intelligent_high_frame_saving, -1, false, false, true);
                }
            });
        }
        this.f15874j = true;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (!getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE)) {
            return super.onBackPressed();
        }
        if ((960 == getSlowVideoFps() || isSlowVideoHighFrame()) && !this.mbFrontCamera && isVideoRecordStarted() && this.mRecordingTotalTime < getRecordingMinTime(false) && !this.mbPaused && !this.mCameraInterface.mo10583m() && this.mVideoRecorder != null) {
            CameraLog.m12966e("SlowVideoMode", "onBackPressed(), Record Time less than 1 second.");
            return true;
        }
        this.mbBackPressedAfterCapture = true;
        if (!this.f15875k && isSlowVideoHighFrame() && !m16270g() && (isVideoRecordStarted() || isVideoRecordStopping())) {
            forceStopVideoRecording(false);
            if (this.mCameraUIInterface != null) {
                this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(6, "button_color_inside_red", "button_shape_dial_still", 1));
                this.mCameraUIInterface.mo18107a(false, true);
                this.mCameraUIInterface.mo18067a(R.string.camera_intelligent_high_frame_detecting);
                this.mCameraUIInterface.mo18067a(R.string.camera_intelligent_high_frame_recording);
            }
            CameraLog.m12954a("SlowVideoMode", "onBackPressed, return, isVideoRecordStarted: " + isVideoRecordStarted() + ", isVideoRecordStopping: " + isVideoRecordStopping());
            return true;
        }
        if (isVideoRecording() || isVideoRecordStopping() || m16270g()) {
            CameraLog.m12954a("SlowVideoMode", "onBackPressed, return, isVideoRecording: " + isVideoRecording() + ", isVideoRecordStopping: " + isVideoRecordStopping() + ", isSlowVideoFileSaving: " + m16270g());
            return true;
        }
        return super.onBackPressed();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m16270g() {
        return this.f15874j;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void afterStopRecording() {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10492a(true, false);
        }
        this.mOneCamera.mo13029a(3, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        if (this.mCameraUIInterface != null && !this.mbPaused && !needPostProcessAfterStopRecord()) {
            this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(6, "button_color_inside_red", "button_shape_dial_still", 1));
            this.mCameraUIInterface.mo18031E(true);
            this.mCameraUIInterface.mo18067a(R.string.camera_intelligent_high_frame_detecting);
            this.mCameraUIInterface.mo18067a(R.string.camera_intelligent_high_frame_recording);
            m16260b();
            if (isMotionDetectOpen()) {
                if (this.mCameraInterface != null) {
                    this.mCameraInterface.mo10574i(false);
                }
                if (this.f15873i) {
                    this.mCameraUIInterface.mo18200d(true, false);
                } else {
                    this.mCameraUIInterface.mo18070a(R.string.camera_intelligent_high_frame_not_detected, -1, true, false, false);
                }
            }
            this.mCameraUIInterface.mo18067a(R.string.camera_intelligent_high_frame_saving);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(12);
        }
        this.f15873i = false;
        this.f15874j = false;
        this.mbHasDragIntelligentView = false;
        super.afterStopRecording();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        super.onPreviewCaptureResult(cameraPreviewResult);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (this.mCameraUIInterface.mo18233k().m18494b() && CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(this.mCameraUIInterface.mo18233k().m18498d())) {
            if (isVideoFlashTorchOpen()) {
                this.mCameraUIInterface.mo18067a(R.string.hint_flash_off);
                this.mCameraUIInterface.mo18070a(R.string.hint_flash_torch, -1, true, true, false);
            } else {
                this.mCameraUIInterface.mo18067a(R.string.hint_flash_torch);
                this.mCameraUIInterface.mo18070a(R.string.hint_flash_off, -1, true, true, false);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayAllIcon(boolean z, boolean z2) {
        if (isVideoFlashTorchOpen()) {
            return;
        }
        this.mCameraUIInterface.mo18108a(false, true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFlashState() {
        return isVideoFlashTorchOpen();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeSwitchCamera() {
        super.beforeSwitchCamera();
        if (this.mbFrontCamera) {
            this.mCameraUIInterface.mo18110a(R.string.camera_intelligent_high_frame_slow_selected);
            this.mCameraUIInterface.mo18110a(R.string.camera_intelligent_high_frame_super_selected);
            m16247a(4);
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        if (CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU.equals(str) && getSupportFunction(str) && sharedPreferences != null) {
            m16254a("on".equals(sharedPreferences.getString(CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU, this.mActivity.getString(R.string.camera_slow_video_mode_frame_default_value))), true, true);
        }
        if (CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED.equals(str) && getSupportFunction(str) && sharedPreferences != null) {
            String string = sharedPreferences.getString(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, this.mActivity.getString(R.string.camera_intelligent_high_frame_default_selected));
            boolean zEquals = "on".equals(string);
            if (isSlowVideoHighFrame()) {
                sharedPreferences.edit().putString(CameraUIInterface.KEY_TEMP_INTELLIGENT_HIGH_FRAME_SELECTED, string).apply();
            }
            if (zEquals && getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE)) {
                m16247a(0);
                this.mCameraUIInterface.mo18070a(R.string.camera_intelligent_high_frame_hint_on, -1, true, false, false);
            } else {
                m16247a(4);
                this.mCameraUIInterface.mo18070a(R.string.camera_intelligent_high_frame_hint_off, -1, true, false, false);
            }
        }
        if (CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS.equals(str)) {
            m16274i();
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean isSlowVideoHighFrame() {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME) || this.mbFrontCamera) {
            return false;
        }
        int iM16265e = m16265e();
        return 480 == iM16265e || 960 == iM16265e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16254a(boolean z, boolean z2, boolean z3) {
        if (this.mCameraUIInterface != null) {
            if (z) {
                this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
                this.mCameraUIInterface.mo18029D(z2);
                return;
            }
            this.mCameraUIInterface.mo18027C(z2);
            if (z3) {
                this.mCameraInterface.mo10492a(true, false);
                this.mCameraInterface.mo10563d(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16247a(int OplusGLSurfaceView_13) {
        if (this.mCameraUIInterface == null || this.mCameraInterface == null) {
            return;
        }
        if (OplusGLSurfaceView_13 == 0 && this.mCameraInterface.mo10454J()) {
            this.mCameraInterface.mo10452H();
        }
        this.mCameraUIInterface.mo18250o(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void restoreDefaultMode(boolean z) {
        if (this.mPreferences != null) {
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.remove(CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU);
            editorEdit.apply();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSlowVideoFrameChange(int OplusGLSurfaceView_13) {
        String configFpsVideoType;
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        if (120 == OplusGLSurfaceView_13) {
            configFpsVideoType = CameraConfig.getConfigFpsVideoType(ConfigDataBase.KEY_SLOW_VIDEO_HFR_120FPS_VIDOETYPE);
        } else if (240 == OplusGLSurfaceView_13) {
            configFpsVideoType = CameraConfig.getConfigFpsVideoType(ConfigDataBase.KEY_SLOW_VIDEO_HFR_240FPS_VIDOETYPE);
        } else if (480 == OplusGLSurfaceView_13) {
            configFpsVideoType = CameraConfig.getConfigFpsVideoType(ConfigDataBase.KEY_SLOW_VIDEO_HFR_480FPS_VIDOETYPE);
        } else {
            configFpsVideoType = 960 == OplusGLSurfaceView_13 ? CameraConfig.getConfigFpsVideoType(ConfigDataBase.KEY_SLOW_VIDEO_HFR_960FPS_VIDOETYPE) : null;
        }
        editorEdit.putString(CameraUIInterface.KEY_SLOW_VIDEO_SIZE, configFpsVideoType);
        editorEdit.putInt(CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, OplusGLSurfaceView_13).apply();
        String string = this.mPreferences.getString(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, this.mActivity.getString(R.string.camera_intelligent_high_frame_default_selected));
        if (!isSlowVideoHighFrame() || "off".equals(string)) {
            m16247a(4);
        }
        this.mCameraInterface.mo10546av();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void reportIntelligentDragViewMoveToDcs(int OplusGLSurfaceView_13, int i2, boolean z, int i3) {
        this.mbHasDragIntelligentView = true;
        String str = OplusGLSurfaceView_13 + "x" + i2;
        FocusAimMsgData focusAimMsgData = new FocusAimMsgData(this.mActivity);
        focusAimMsgData.mCameraId = getProperCameraId(this.mCameraId);
        focusAimMsgData.mCaptureMode = getCameraMode();
        focusAimMsgData.mOrientation = this.mOrientation;
        focusAimMsgData.mCaptureType = 1;
        focusAimMsgData.mbVideoRecording = false;
        focusAimMsgData.mTouchXY = str;
        if (!this.mbFrontCamera) {
            focusAimMsgData.mAeAfLock = String.valueOf(z);
        }
        focusAimMsgData.mTouchEV = String.valueOf(i3);
        focusAimMsgData.mActType = FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE;
        focusAimMsgData.report();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        VideoRecordMsgData videoRecordMsgData;
        if (dcsMsgData instanceof VideoRecordMsgData) {
            VideoRecordMsgData videoRecordMsgData2 = (VideoRecordMsgData) dcsMsgData;
            videoRecordMsgData2.mLux = String.valueOf(this.mDcsLux);
            videoRecordMsgData2.mIsIntelligentDetect = isMotionDetectOpen() ? "on" : "off";
            videoRecordMsgData = videoRecordMsgData2;
        } else {
            videoRecordMsgData = null;
        }
        return videoRecordMsgData == null ? dcsMsgData : videoRecordMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z, int OplusGLSurfaceView_13, int i2) {
        if (isMotionDetectOpen() && (isVideoRecordStarted() || isVideoRecordStarting())) {
            return false;
        }
        return super.getTouchEnable(z, OplusGLSurfaceView_13, i2);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        super.onZoomMenuExpand();
        if (isMotionDetectOpen()) {
            m16247a(4);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsed() {
        super.onZoomMenuCollapsed();
        if (isMotionDetectOpen()) {
            m16247a(0);
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected String getVideoFileExifTag() {
        return C2735b.m13779b(getCameraMode(), 0);
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void onStopVideoRecording(boolean z) {
        if (this.mRecordingTotalTime < getRecordingMinTime(false) && !this.mbPaused && !this.mCameraInterface.mo10583m() && this.mVideoRecorder != null && z && 960 == getSlowVideoFps() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME)) {
            CameraLog.m12966e("SlowVideoMode", "onStopVideoRecording, Record Time less than 1 second.");
            return;
        }
        super.onStopVideoRecording(z);
        boolean zEquals = "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_STORAGE_PLACE, this.mActivity.getString(R.string.camera_storage_default_value)));
        if (Storage.m11138d() && zEquals) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.r.COUIBaseListPopupWindow_11.5
                @Override // java.lang.Runnable
                public void run() {
                    MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
                    c3200b.m19227a("button_color_inside_none");
                    c3200b.m19226a(4);
                    SlowVideoMode.this.mCameraUIInterface.mo18091a(c3200b);
                }
            });
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int m16271h() {
        return Integer.parseInt(this.mPreferences.getString(CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS, CameraConfig.getConfigStringValue(ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE)));
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private SLVBaseMode m16274i() {
        SLVBaseMode abstractC2911a = this.f15879o;
        if (abstractC2911a == null || abstractC2911a.mo16219a() != m16271h()) {
            m16276j();
            this.f15879o = SLVModeFactory.m16237a(m16271h(), this.mActivity, this.mCameraUIInterface);
            this.f15879o.m16222a(this.f15881q);
            this.mPreferences.edit().putString(CameraUIInterface.KEY_SLOW_VIDEO_SIZE, SLVModeFactory.m16240c(this.f15879o.mo16219a())).apply();
        }
        CameraLog.m12954a("SlowVideoMode", "fpsModeInstanceWrap fpsMode: " + this.f15879o.mo16219a());
        return this.f15879o;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m16276j() {
        if (this.f15879o != null) {
            CameraLog.m12954a("SlowVideoMode", "destroyFpsMode mbCompilingVideo: " + this.f15877m);
            if (this.f15877m) {
                this.f15879o.mo16226d();
            }
            this.f15879o.mo16227e();
            this.f15879o = null;
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected int configVideoBitRate() {
        if (needPostProcessAfterStopRecord()) {
            return YuvProcessUtil.ExifInfo.EXPOSURE_BIAS_MULTIPLE;
        }
        if (this.mVideoSizeType.equals("video_size_1080p")) {
            this.mProfile.videoBitRate = YuvProcessUtil.ExifInfo.EXPOSURE_BIAS_MULTIPLE;
        } else if (this.mVideoSizeType.equals("video_size_720p")) {
            int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_720P_VIDEO_BIT_RATE);
            if (configIntValue > 0 && CameraParameter.VideoEncoder.H264.equals(getVideoCodec())) {
                this.mProfile.videoBitRate = configIntValue;
            } else {
                this.mProfile.videoBitRate = 7500000;
            }
        }
        return super.configVideoBitRate();
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean shouldAutoStop(long OplusGLSurfaceView_15) {
        SLVBaseMode abstractC2911a = this.f15879o;
        if (abstractC2911a != null) {
            this.f15878n = OplusGLSurfaceView_15 > ((long) abstractC2911a.mo16225c());
        }
        return this.f15878n;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void processPlatformSlowVideo() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.r.COUIBaseListPopupWindow_11.6
            @Override // java.lang.Runnable
            public void run() {
                MainShutterButtonInfo c3200bMo16220a = SlowVideoMode.this.f15879o.mo16220a(3);
                if (c3200bMo16220a != null) {
                    SlowVideoMode.this.mCameraUIInterface.mo18091a(c3200bMo16220a);
                }
                SlowVideoMode.this.mCameraUIInterface.mo18200d(false, false);
                SlowVideoMode.this.f15877m = true;
                SlowVideoMode.this.f15879o.mo16223a(SlowVideoMode.this.mVideoOrientation, SlowVideoMode.this.mCurrentVideoUri, SlowVideoMode.this.mCurrentVideoValues, SlowVideoMode.this.getVideoFileExifTag().concat(SlowVideoMode.this.getVideoTitle()));
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needPostProcessAfterStopRecord() {
        SLVBaseMode abstractC2911a = this.f15879o;
        return abstractC2911a != null && abstractC2911a.mo16224b();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void generateImageInfo(Map<String, Object> map) {
        if (this.mCameraUIInterface == null || !isMotionDetectOpen()) {
            return;
        }
        map.put(CameraUnitKeys.KEY_INTELLIGENT_CROP_REGION, this.mCameraUIInterface.mo18257q(getSensorOrientation(this.mCameraId)));
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        Size videoPreviewSize = getVideoPreviewSize(getVideoSizeType());
        if (videoPreviewSize != null) {
            builder.setVideoSize(videoPreviewSize);
            builder.setParameter(CameraParameter.VIDEO_FPS, m16259b(Integer.parseInt(m16268f())));
        }
        if (isSlowVideoHighFrame()) {
            builder.setParameter(CameraParameter.SLOW_VIDEO_INTELLIGENT_HIGH_FRAME_ENABLE, "on");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16253a(String str, Thumbnail.IntrinsicsJvm.kt_5 dVar) throws Throwable {
        MediaMetadataRetriever mediaMetadataRetriever;
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
            } catch (Throwable th) {
                th = th;
                mediaMetadataRetriever = mediaMetadataRetriever2;
            }
        } catch (Exception unused) {
        }
        try {
            mediaMetadataRetriever.setDataSource(this.mActivity.getApplicationContext(), Uri.parse(str));
            dVar.f18300m = Thumbnail.m19282b(mediaMetadataRetriever.getFrameAtTime(-1L), ThumbImageView.f18106a);
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_pending", (Integer) 0);
            this.mActivity.getContentResolver().update(Uri.parse(str), contentValues, null, null);
            mediaMetadataRetriever.release();
        } catch (Exception unused2) {
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            CameraLog.m12954a("SlowVideoMode", "extractMetadataThumbnailFromFile, get video thumbnail fail.");
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.release();
            }
        } catch (Throwable th2) {
            th = th2;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m16257a(String str, String str2, Thumbnail.IntrinsicsJvm.kt_5 dVar) throws Throwable {
        if ("on".equals(Storage.m11139e()) && !Storage.m11128b(true)) {
            this.mCurrentVideoUri = null;
            if (this.mCurrentVideoValues != null) {
                this.mCurrentVideoValues.clear();
                this.mCurrentVideoValues = null;
            }
            CameraLog.m12954a("SlowVideoMode", "deleteUpdateSlowVideoToMediaStore, Exception: sdcard has removed, so not add to mediaStore.");
            return false;
        }
        this.mCameraUIInterface.mo18269t();
        m16253a(str2, dVar);
        CameraLog.m12959b("SlowVideoMode", "deleteUpdateVideo, originalVideoFileName: " + str + ",  compiledSlowVideoUri: " + str2);
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_DUMP_960FPS_ORIGINAL)) {
            deleteVideoFile(str);
        }
        if (this.mCurrentVideoValues != null) {
            this.mCurrentVideoValues.clear();
            this.mCurrentVideoValues = null;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16252a(Thumbnail.IntrinsicsJvm.kt_5 dVar, boolean z, boolean z2) {
        if (this.mCameraUIInterface != null) {
            CameraLog.m12959b("SlowVideoMode", "enableUIView enable: " + z + ", animation: " + z2);
            MainShutterButtonInfo c3200bMo16220a = this.f15879o.mo16220a(1);
            if (c3200bMo16220a != null) {
                this.mCameraUIInterface.mo18091a(c3200bMo16220a);
            }
            this.mCameraUIInterface.mo18093a(dVar, z2);
            this.mCameraUIInterface.mo18200d(z, z2);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private int m16277k() {
        int configIntValue;
        String videoSizeType = getVideoSizeType();
        if ("video_size_1080p".equals(videoSizeType)) {
            configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_1080P_DEFAULT_VALUE);
        } else {
            configIntValue = "video_size_720p".equals(videoSizeType) ? CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE) : 0;
        }
        return this.mPreferences.getInt(CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, configIntValue);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        m16254a(false, false, false);
        if (isMotionDetectOpen()) {
            m16247a(4);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        if (this.mCameraInterface == null || 1 != this.mCameraInterface.mo10570g() || 1 == OplusGLSurfaceView_13) {
            return;
        }
        m16254a(m16262c(), false, false);
        m16260b();
        if (isMotionDetectOpen()) {
            m16247a(0);
        }
    }
}

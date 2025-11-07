package com.oplus.camera.filmvideomode;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.HistogramProcessorManager;
import com.oplus.camera.Camera;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.capmode.VideoMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.filmvideomode.BaseFilmUIControl;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.OplusViewOutlineProvider;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.professional.ProfessionalAnimUtil;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.ReminderMsgData;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPreviewCallback;
import java.util.Arrays;
import java.util.List;

/* compiled from: MovieMode.java */
/* renamed from: com.oplus.camera.filmvideomode.s */
/* loaded from: classes2.dex */
public class MovieMode extends VideoMode implements BaseFilmUIControl.PlatformImplementations.kt_3 {

    /* renamed from: COUIBaseListPopupWindow_11 */
    HistogramProcessorManager.PlatformImplementations.kt_3 f13735g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private BaseFilmUIControl f13736h;

    /* renamed from: OplusGLSurfaceView_13 */
    private HistogramProcessorManager f13737i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f13738j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f13739k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f13740l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f13741m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f13742n;

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean enterNeedShutterButtonAlphaTransition() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return "movie";
    }

    @Override // com.oplus.camera.capmode.VideoMode
    public String getDefaultVideoCodec() {
        return CameraParameter.VideoEncoder.H264;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected String getGuideLineKey() {
        return CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return true;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected int getVideoFrameRate() {
        return 30;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isCropX() {
        return true;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean isMovieMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedSetRecordingMargin() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSloganForceLandscape() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setFlashState() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean supportParameterAdjust() {
        return true;
    }

    public MovieMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f13736h = null;
        this.f13737i = null;
        this.f13735g = null;
        this.f13738j = VideoMode.VIDEO_1080P_WIDTH;
        this.f13739k = VideoMode.VIDEO_1080P_HEIGHT;
        this.f13740l = VideoMode.VIDEO_1080P_HEIGHT;
        this.f13741m = false;
        this.f13742n = -1;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        CameraLog.m12954a("FilmVideoMode", "onInitCameraMode");
        this.f13741m = false;
        this.mHandler.post(new Runnable() { // from class: com.oplus.camera.filmvideomode.s.1
            @Override // java.lang.Runnable
            public void run() {
                MovieMode.this.m13691d();
            }
        });
        super.onInitCameraMode();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        CameraLog.m12954a("FilmVideoMode", "onDeInitCameraMode");
        BaseFilmUIControl viewOnClickListenerC2706a = this.f13736h;
        if (viewOnClickListenerC2706a != null) {
            viewOnClickListenerC2706a.m13453v();
            this.f13736h.m13454w();
        }
        this.mCameraUIInterface.mo18148al();
        if (this.f13736h != null) {
            this.mCameraUIInterface.mo18048N();
            this.f13736h.mo13413a(this.mCameraRootView);
            this.mCameraUIInterface.mo18144ah();
            this.mCameraUIInterface.mo18108a(false, true, true);
            this.mCameraUIInterface.mo18154ar();
        }
        HistogramProcessorManager c2826p = this.f13737i;
        if (c2826p != null) {
            c2826p.m14849c();
        }
        super.onDeInitCameraMode(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010e  */
    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.filmvideomode.MovieMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Byte getMovieHdrEnable() {
        if (getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_HDR)) {
            return Byte.valueOf(m13697i() ? (byte) 1 : (byte) 0);
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return m13695g() ? 32932 : 32931;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        if (m13695g()) {
            builder.setParameter(CameraParameter.VIDEO_STABILIZATION_MODE, CameraParameter.VideoStabilizationMode.VIDEO_STABILIZATION);
        }
        Byte movieHdrEnable = getMovieHdrEnable();
        if (movieHdrEnable != null) {
            builder.setParameter(CameraParameter.KEY_MOVIE_HDR_ENABLE, movieHdrEnable);
        }
        if (getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_LOG)) {
            builder.setParameter(CameraParameter.KEY_MOVIE_LOG_ENABLE, Byte.valueOf(m13696h() ? (byte) 1 : (byte) 0));
        }
        if (isVideo10BitOpen()) {
            builder.setParameter(CameraParameter.VIDEO_10BIT_ENABLE, "on");
        }
        builder.setParameter(CameraParameter.VIDEO_BITRATE, Integer.valueOf(configVideoBitRate()));
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public String getVideoSizeType() {
        return getSupportFunction(CameraFunction.MOVIE_MODE_V2) ? "4K" : "video_size_1080p";
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected int configVideoBitRate() {
        if ("4K".equals(getVideoSizeType())) {
            return 80000000;
        }
        return super.configVideoBitRate();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public String getCameraFeature() {
        return (!AlgoSwitchConfig.getSupportCameraFeature(ApsConstant.FEATURE_REC_MOVIE_NO_EIS, this.mCameraId) || m13695g()) ? "movie" : ApsConstant.FEATURE_REC_MOVIE_NO_EIS;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h) {
        m13689c();
        return new Size(this.f13738j, this.f13739k);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m13689c() {
        Size sizeConfigValue = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_MOVIE_MODE_PICTURE_SIZE);
        if (sizeConfigValue == null) {
            sizeConfigValue = Util.m24379b(getCameraInfo(this.mCameraId).m13257a(), 2.3333333333333335d, VideoMode.VIDEO_1080P_HEIGHT);
        }
        if (sizeConfigValue != null) {
            this.f13738j = sizeConfigValue.getWidth();
            this.f13739k = sizeConfigValue.getHeight();
            this.f13740l = (int) (this.f13739k * (Util.getScreenHeight() / this.f13738j));
        }
        this.mPreviewXScale = Util.m24498u() ? 1.0f : this.f13740l / Util.getScreenWidth();
        CameraLog.m12954a("FilmVideoMode", "initMovieSize, mPreviewSizeWidth: " + this.f13738j + ", mPreviewSizeHeight: " + this.f13739k + ", mDisplayWidth: " + this.f13740l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m13691d() {
        if (Util.m24451g() == 0) {
            this.mCameraUIInterface.mo18229j();
        }
        if (this.f13736h == null || Util.m24451g() != this.f13742n) {
            if (Util.m24498u()) {
                this.f13736h = new FilmUIControlV2Rack(this.mActivity, this.mOneCamera, this.mCameraInterface, this.mCameraRootView);
            } else if (getSupportFunction(CameraFunction.MOVIE_MODE_V2)) {
                this.f13736h = new FilmUIControlV2(this.mActivity, this.mOneCamera, this.mCameraInterface, this.mCameraRootView);
            } else {
                this.f13736h = new FilmUIControlV1(this.mActivity, this.mOneCamera, this.mCameraInterface, this.mCameraRootView);
            }
            if ("camera_ultra_wide".equals(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA_BAR, "camera_main")) && this.mOneCamera != null && this.mOneCamera.mo13086e() != null && !this.mOneCamera.mo13086e().m13284s()) {
                this.f13736h.m13417a(false);
            } else {
                this.f13736h.m13417a(true);
            }
            this.f13736h.m13414a(this);
            this.f13742n = Util.m24451g();
        }
        if (getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM)) {
            m13700l();
        }
        if (this.mCameraUIInterface != null) {
            m13702b();
            this.mCameraUIInterface.mo18145ai();
            this.mCameraUIInterface.mo18282w(true);
            this.mCameraUIInterface.mo18148al();
            this.mCameraUIInterface.mo18024B(true);
            this.mCameraUIInterface.mo18218g(true, true);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT) && TextUtils.isEmpty(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA_BAR, ""))) {
            this.mPreferences.edit().putString(CameraUIInterface.KEY_SWITCH_CAMERA_BAR, "camera_ultra_wide").apply();
        }
        m13693e();
        this.f13741m = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m13693e() {
        if (this.f13736h != null) {
            if ("camera_ultra_wide".equals(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA_BAR, "camera_main")) && this.mOneCamera != null && this.mOneCamera.mo13086e() != null && !this.mOneCamera.mo13086e().m13284s()) {
                this.f13736h.m13408a(4, false);
            } else {
                this.f13736h.m13408a(4, true);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m13694f() {
        if (this.f13736h != null && this.f13741m && Util.m24451g() == this.f13742n) {
            return;
        }
        m13691d();
    }

    @Override // com.oplus.camera.capmode.VideoMode
    public String getVideoCodec() {
        return (getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_LOG) && m13696h()) ? CameraParameter.VideoEncoder.H265 : (getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_HDR) && m13697i()) ? CameraParameter.VideoEncoder.H265 : CameraParameter.VideoEncoder.H264;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeConfig() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18108a(false, true, true);
        }
        this.mHandler.post(new Runnable() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$s$BoVQr2c3WiKG91U5VkdWEIygNoQ
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m13693e();
            }
        });
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        super.onBeforePreview();
        BaseFilmUIControl viewOnClickListenerC2706a = this.f13736h;
        if (viewOnClickListenerC2706a != null) {
            viewOnClickListenerC2706a.m13451t();
        }
        if (this.mOneCamera != null) {
            if (getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_LOG)) {
                this.mOneCamera.mo13020a(m13696h() ? (byte) 1 : (byte) 0);
            }
            if (getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_HDR)) {
                this.mOneCamera.mo13062b(m13697i() ? (byte) 1 : (byte) 0);
            }
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.filmvideomode.s.2
            @Override // java.lang.Runnable
            public void run() {
                MovieMode.this.mCameraUIInterface.mo18235k(MovieMode.this.mPreferences != null && MovieMode.this.mPreferences.getString(CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE, "off").equals("grid"));
            }
        });
        BaseFilmUIControl viewOnClickListenerC2706a = this.f13736h;
        if (viewOnClickListenerC2706a != null) {
            viewOnClickListenerC2706a.m13452u();
        }
        if (Util.m24495t() && getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM)) {
            m13700l();
        }
        super.onAfterStartPreview(z);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        BaseFilmUIControl viewOnClickListenerC2706a;
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (!this.mbCapModeInit || (viewOnClickListenerC2706a = this.f13736h) == null) {
            return;
        }
        viewOnClickListenerC2706a.m13415a(cameraPreviewResult);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if ("type_still_capture_yuv_main".equals(str)) {
            return false;
        }
        if ("type_video_frame".equals(str)) {
            return getSupportFunction(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen();
        }
        if ("type_preview_frame".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13702b() {
        if (this.f13736h != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.filmvideomode.s.3
                @Override // java.lang.Runnable
                public void run() {
                    MovieMode.this.f13736h.m13421a(CameraCharacteristicsUtil.m12983f(), CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MOVIE_ULTRA_WIDE_ANGLE_SUPPORT));
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        BaseFilmUIControl viewOnClickListenerC2706a = this.f13736h;
        if (viewOnClickListenerC2706a != null) {
            viewOnClickListenerC2706a.mo13447p();
        }
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18048N();
        }
        super.onPause();
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void readProfile() {
        super.readProfile();
        Size videoSize = getVideoSize();
        if (videoSize != null) {
            this.mProfile.videoFrameWidth = videoSize.getWidth();
            this.mProfile.videoFrameHeight = videoSize.getHeight();
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode
    public Size getVideoSize() {
        List<Size> listM13254K;
        if (!getSupportFunction(CameraFunction.MOVIE_MODE_V2)) {
            return getPreviewSize(null);
        }
        OplusCameraCharacteristics cameraInfo = getCameraInfo(this.mCameraId);
        if (cameraInfo == null || (listM13254K = cameraInfo.m13254K()) == null) {
            return null;
        }
        return listM13254K.get(0);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) throws Resources.NotFoundException {
        if (CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE.equals(str) && this.mCameraUIInterface != null && this.mPreferences != null) {
            this.mCameraUIInterface.mo18235k(this.mPreferences.getString(CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE, "off").equals("grid"));
        } else if (CameraUIInterface.KEY_MOVIE_FLASH_MODE.equals(str) && this.mCameraUIInterface != null) {
            String flashMode = getFlashMode();
            if (Camera.f10611m || Camera.f10610l) {
                if (!"off".equals(flashMode)) {
                    if (Camera.f10611m) {
                        this.mCameraUIInterface.mo18073a(R.string.camera_high_temperature_flash_disable, -1, true, false, false, false, true, true, 3000, false);
                        reportReminderToDcs(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_TEMPS_FLASH);
                    } else if (Camera.f10610l) {
                        this.mCameraUIInterface.mo18073a(R.string.camera_low_battery_flash_disable, -1, true, false, false, false, true, true, 3000, false);
                        reportReminderToDcs(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_BATTERY_FLASH);
                    }
                    if (this.mPreferences != null) {
                        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                        editorEdit.putString(CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off");
                        editorEdit.apply();
                    }
                }
            } else if (this.mOneCamera != null) {
                this.mOneCamera.mo13069b(flashMode);
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
            BaseFilmUIControl viewOnClickListenerC2706a = this.f13736h;
            if (viewOnClickListenerC2706a != null) {
                viewOnClickListenerC2706a.mo13443l();
            }
            displayScreenHintIconInSwitchOn();
        } else if (CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM.equals(str) && getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM) && this.mPreferences != null && this.f13737i != null) {
            if (this.mPreferences.getString(CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM, "off").equals("on")) {
                this.f13737i.m14845a((ProfessionalAnimUtil.PlatformImplementations.kt_3) null);
            } else {
                this.f13737i.m14847b((ProfessionalAnimUtil.PlatformImplementations.kt_3) null);
            }
        } else if (getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_HDR) && CameraUIInterface.KEY_FILM_VIDEO_HDR.equals(str)) {
            if (m13697i() && m13696h()) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_LOG, "off").apply();
                this.f13736h.mo13430c(false);
            }
        } else if (getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_LOG) && CameraUIInterface.KEY_FILM_VIDEO_LOG.equals(str) && m13696h() && m13697i()) {
            this.mPreferences.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_HDR, "off").apply();
            this.f13736h.mo13433d(false);
        }
        if (this.mCameraUIInterface != null) {
            super.onSharedPreferenceChanged(sharedPreferences, str);
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(5, "button_color_inside_red", "button_shape_ring_none", 1));
        this.mCameraUIInterface.mo18108a(true, true, false);
        BaseFilmUIControl viewOnClickListenerC2706a = this.f13736h;
        if (viewOnClickListenerC2706a != null) {
            viewOnClickListenerC2706a.mo13444m();
        }
        super.beforeStartRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void afterStartRecording() {
        if (m13698j()) {
            displayScreenHintIconInSwitchOn();
        }
        super.afterStartRecording();
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void onStopVideoRecording(boolean z) {
        FilmAnimatorUtil.m13460a();
        BaseFilmUIControl viewOnClickListenerC2706a = this.f13736h;
        if (viewOnClickListenerC2706a != null) {
            viewOnClickListenerC2706a.mo13445n();
        }
        super.onStopVideoRecording(z);
        if (m13698j()) {
            displayScreenHintIconInSwitchOn();
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void afterStopRecording() {
        this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(6, "button_color_inside_red", "button_shape_ring_none", 1));
        super.afterStopRecording();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        m13694f();
        BaseFilmUIControl viewOnClickListenerC2706a = this.f13736h;
        if (viewOnClickListenerC2706a != null) {
            viewOnClickListenerC2706a.m13446o();
        }
        HistogramProcessorManager c2826p = this.f13737i;
        if (c2826p != null) {
            c2826p.m14850d();
            this.f13737i.m14839a();
        }
        super.onResume(z);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        BaseFilmUIControl viewOnClickListenerC2706a = this.f13736h;
        if (viewOnClickListenerC2706a != null) {
            viewOnClickListenerC2706a.m13450s();
        }
        HistogramProcessorManager c2826p = this.f13737i;
        if (c2826p != null) {
            c2826p.m14849c();
            this.f13737i = null;
        }
        super.onDestroy();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.f13736h == null) {
            return false;
        }
        int actionIndex = motionEvent.getActionIndex();
        int x = (int) (motionEvent.getX(actionIndex) + 0.5d);
        int y = (int) (motionEvent.getY(actionIndex) + 0.5d);
        Rect rect = new Rect();
        this.mCameraUIInterface.mo18253p().getHitRect(rect);
        BaseScreenMode currentScreenMode = getCurrentScreenMode();
        boolean z = currentScreenMode != null && currentScreenMode.mo16631r();
        if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && !z) {
            return false;
        }
        this.f13736h.m13448q();
        if (getTouchEnable(true, x, y)) {
            this.f13736h.m13449r();
        }
        return super.onSingleTapUp(motionEvent);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (this.mCameraUIInterface != null) {
            if (m13698j()) {
                this.mCameraUIInterface.mo18070a(-1, R.drawable.flash_torch_hint_icon, false, true, false);
            } else {
                if (Camera.f10611m || Camera.f10610l) {
                    return;
                }
                this.mCameraUIInterface.mo18108a(false, true, true);
            }
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean isQualcommEndOfStreamNeed() {
        if (!Util.m24169C()) {
            return false;
        }
        byte[] bArrM13276k = this.mOneCamera.mo13086e().m13276k();
        CameraLog.m12954a("FilmVideoMode", "isQualcommEndOfStreamNeed, endOfStreamValue: " + Arrays.toString(bArrM13276k));
        return bArrM13276k != null && bArrM13276k.length > 0;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m13695g() {
        return this.mPreferences != null && this.mPreferences.getString(CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "on").equals("on");
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m13696h() {
        return this.mPreferences != null && this.mPreferences.getString(CameraUIInterface.KEY_FILM_VIDEO_LOG, "off").equals("on");
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean m13697i() {
        return this.mPreferences != null && this.mPreferences.getString(CameraUIInterface.KEY_FILM_VIDEO_HDR, "off").equals("on");
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean m13698j() {
        return this.mPreferences != null && this.mPreferences.getString(CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off").equals(CameraParameter.FlashMode.FLASH_TORCH);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean m13699k() {
        return this.mPreferences != null && this.mPreferences.getString(CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM, "off").equals("on");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MOVIE_DEFAULT_VIDEO_FRAME_RECORD_SUPPORT) || !(!"camera_ultra_wide".equals(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA_BAR, "camera_main")) || is4k() || Util.m24169C() || isSloganOpen());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needLutTexture() {
        return getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_HDR) && m13697i();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getPreviewDispalyWidth() {
        return this.f13740l;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z, int OplusGLSurfaceView_13, int i2) {
        BaseFilmUIControl viewOnClickListenerC2706a = this.f13736h;
        return viewOnClickListenerC2706a != null && viewOnClickListenerC2706a.mo13422a(OplusGLSurfaceView_13, i2, getSupportFunction(CameraUIInterface.KEY_MANUAL_EXPOSURE));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getEntryGalleryAnim() {
        return Util.m24495t() ? R.anim.gallery_in_folder : R.anim.gallery_movie_mode_in;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public int getDefaultAFMode() {
        if (this.mPreferences == null || !"auto".equals(this.mPreferences.getString(CameraUIInterface.KEY_FILM_MODE_FOCUS, "auto"))) {
            return 0;
        }
        return super.getDefaultAFMode();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void restoreDefaultMode(boolean z) {
        BaseFilmUIControl viewOnClickListenerC2706a = this.f13736h;
        if (viewOnClickListenerC2706a != null) {
            viewOnClickListenerC2706a.m13455x();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public OplusViewOutlineProvider getPreviewOutlineProvider() throws Resources.NotFoundException {
        if (Util.m24495t()) {
            return null;
        }
        m13689c();
        int screenWidth = Util.getScreenWidth();
        int screenHeight = Util.getScreenHeight();
        int OplusGLSurfaceView_13 = this.f13740l;
        int i2 = (screenWidth - OplusGLSurfaceView_13) / 2;
        return new OplusViewOutlineProvider().m23898a(new Rect(i2, 0, OplusGLSurfaceView_13 + i2, screenHeight + 0), this.mActivity.getResources().getDimensionPixelSize(R.dimen.movie_mode_preview_corners_radius));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        BaseFilmUIControl viewOnClickListenerC2706a = this.f13736h;
        if (viewOnClickListenerC2706a != null) {
            return viewOnClickListenerC2706a.mo13423a(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideo10BitOpen() {
        return (getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_LOG) && m13696h()) || (getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_HDR) && m13697i());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaRecorderNotUseAPS() {
        if (getSupportFunction(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen()) {
            return !needApsToProcessVideoWatermark();
        }
        return super.isUseMediaRecorderNotUseAPS();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isHistogramOpen() {
        return getSupportFunction(CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM) && m13699k();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m13700l() {
        m13701m();
        HistogramProcessorManager c2826p = this.f13737i;
        if (c2826p == null) {
            this.f13737i = new HistogramProcessorManager(this.mActivity, this.mCameraRootView, this.f13735g);
            this.f13737i.m14840a(R.id_renamed.movie_mode_histogram);
        } else {
            c2826p.m14842a(this.f13735g, true);
        }
        Size previewSize = getPreviewSize(null);
        this.f13737i.m14841a(HistogramProcessorManager.m14819a(previewSize.getWidth(), previewSize.getHeight()));
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m13701m() {
        if (this.f13735g == null) {
            this.f13735g = new HistogramProcessorManager.PlatformImplementations.kt_3();
            this.f13735g.f14811a = 12;
        }
        BaseScreenMode currentScreenMode = getCurrentScreenMode();
        if (currentScreenMode != null) {
            currentScreenMode.mo16500a(this.f13735g);
            return;
        }
        HistogramProcessorManager.PlatformImplementations.kt_3 aVar = this.f13735g;
        aVar.f14811a = 12;
        aVar.f14813c = this.mActivity.getResources().getDimensionPixelSize(R.dimen.movie_histogram_margin_bottom) + Util.m24318aG();
        this.f13735g.f14814d = this.mActivity.getResources().getDimensionPixelSize(R.dimen.movie_histogram_margin_left);
        this.f13735g.f14815e = 90;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        BaseFilmUIControl viewOnClickListenerC2706a;
        if ((dcsMsgData instanceof VideoRecordMsgData) && (viewOnClickListenerC2706a = this.f13736h) != null) {
            VideoRecordMsgData videoRecordMsgData = (VideoRecordMsgData) dcsMsgData;
            viewOnClickListenerC2706a.mo13403a(videoRecordMsgData);
            videoRecordMsgData.mLux = String.valueOf(this.mDcsLux);
        }
        return dcsMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onYuvDataReceviced(byte[] bArr) {
        if (this.f13737i == null || !isHistogramOpen()) {
            return;
        }
        this.f13737i.m14846a(bArr);
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public OplusCameraCharacteristics mo13458a(int OplusGLSurfaceView_13) {
        return getCameraInfo(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public Rect mo13457a() {
        Size sizeM24180I = Util.m24180I();
        BaseScreenMode currentScreenMode = getCurrentScreenMode();
        if (currentScreenMode == null) {
            return new Rect(0, 0, 0, 0);
        }
        return currentScreenMode.mo16558b(sizeM24180I.getHeight(), sizeM24180I.getWidth());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ScreenModeConst.PlatformImplementations.kt_3 getPreferredScreenMode(int OplusGLSurfaceView_13) {
        if (!Util.m24498u()) {
            return ScreenModeConst.PlatformImplementations.kt_3.out;
        }
        return ScreenModeConst.PlatformImplementations.kt_3.rack90;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ScreenModeConst.PlatformImplementations.kt_3 getLockedScreenMode() {
        if (Util.m24498u()) {
            return ScreenModeConst.PlatformImplementations.kt_3.rack90;
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        BaseFilmUIControl viewOnClickListenerC2706a = this.f13736h;
        if (viewOnClickListenerC2706a != null) {
            viewOnClickListenerC2706a.m13456y();
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        float configFloatValue = CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_MOVIE_MODE_SECOND_ZOOM_POINT_SPECIFIC_VALUE);
        if (1.0E-6f < configFloatValue) {
            zoomConfigure.m11332c(configFloatValue);
        }
        return zoomConfigure;
    }
}

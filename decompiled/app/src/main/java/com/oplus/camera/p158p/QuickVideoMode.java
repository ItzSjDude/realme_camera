package com.oplus.camera.p158p;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.camera2.CaptureRequest;
import android.media.CamcorderProfile;
import android.util.Size;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.capmode.CommonVideoMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.p172ui.widget.LockViewDragLayout;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.FocusAimMsgData;
import com.oplus.camera.statistics.model.ReminderMsgData;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;

/* compiled from: QuickVideoMode.java */
/* renamed from: com.oplus.camera.p.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class QuickVideoMode extends CommonVideoMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f14819g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String f14820h;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f14821i;

    /* renamed from: OplusGLSurfaceView_15 */
    private String f14822j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Activity f14823k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f14824l;

    /* renamed from: OplusGLSurfaceView_6 */
    private long f14825m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f14826n;

    /* renamed from: o */
    private final Runnable f14827o;

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.BaseMode
    public boolean isCommonVideoMode() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return true;
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    public QuickVideoMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f14819g = 0;
        this.f14820h = "off";
        this.f14821i = "off";
        this.f14822j = "off";
        this.f14823k = null;
        this.f14824l = false;
        this.f14825m = 0L;
        this.f14826n = false;
        this.f14827o = new Runnable() { // from class: com.oplus.camera.p.-$$Lambda$IntrinsicsJvm.kt_4$w7uqxdhNf0vfzEdb5qD5evRz1tI
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m14858n();
            }
        };
        this.f14823k = activity;
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        return super.onBeforeSnapping(c2693c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public /* synthetic */ void m14858n() {
        m17833aj();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void m14861f() {
        if (!isVideoRecordStopped()) {
            CameraLog.m12954a("QuickVideoMode", "mMediaRecorderState is not RECORD_STOPPED, so return");
            return;
        }
        CameraLog.m12954a("QuickVideoMode", "startQuickVideoRecording");
        this.mRecordingStartTemperature = this.mPreferences.getFloat(CameraUIInterface.KEY_CURRENT_TEMPERATURE, -1.0f);
        this.mHandler.removeCallbacks(this.f14827o);
        this.mHandler.post(this.f14827o);
        if (((KeyguardManager) this.f14823k.getApplicationContext().getSystemService("keyguard")).isKeyguardLocked()) {
            this.mbDisplayOnLock = true;
            this.mCameraUIInterface.mo18042K(false);
        } else {
            this.mbDisplayOnLock = false;
        }
        setDisplayOnLock(this.mbDisplayOnLock);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14859a(Size size) {
        m14860b(1);
        m14855b(size);
        this.mWaitRecordStarted.close();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int m14862g() {
        return this.f14819g;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    public void setHalStatus(int OplusGLSurfaceView_13) {
        this.f14819g = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void setVideoRecordState(int OplusGLSurfaceView_13) {
        super.setVideoRecordState(OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected void m14863h() {
        if (isVideoRecordStarting()) {
            this.mWaitRecordStarted.block();
        }
        if (isVideoRecordStopped()) {
            this.mHandler.removeCallbacks(this.f14827o);
        } else {
            CameraLog.m12954a("QuickVideoMode", "stopQuickRecording");
            m17833aj();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -1932966768(0xffffffff8cc94490, float:-3.1010218E-31)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == r1) goto L2b
            r1 = -1221935740(0xffffffffb72abd84, float:-1.0176915E-5)
            if (r0 == r1) goto L21
            r1 = 1640046025(0x61c11dc9, float:4.4529598E20)
            if (r0 == r1) goto L17
            goto L35
        L17:
            java.lang.String r0 = "key_quick_video"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L35
            r0 = r3
            goto L36
        L21:
            java.lang.String r0 = "pref_inertial_zoom_key"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L35
            r0 = r4
            goto L36
        L2b:
            java.lang.String r0 = "key_support_show_dim_hint"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L35
            r0 = r2
            goto L36
        L35:
            r0 = -1
        L36:
            if (r0 == 0) goto L90
            if (r0 == r3) goto L5a
            if (r0 == r2) goto L41
            boolean r5 = super.getSupportFunction(r6)
            return r5
        L41:
            java.lang.String r6 = "pref_camera_videoflashmode_key"
            boolean r6 = r5.getSupportFunction(r6)
            if (r6 == 0) goto L4f
            boolean r6 = r5.isVideoRetentionOpen()
            if (r6 == 0) goto L59
        L4f:
            java.lang.String r6 = "pref_camera_torch_mode_key"
            boolean r5 = r5.getSupportFunction(r6)
            if (r5 == 0) goto L58
            goto L59
        L58:
            r3 = r4
        L59:
            return r3
        L5a:
            android.app.Activity r6 = r5.f14823k
            if (r6 == 0) goto L90
            android.content.SharedPreferences r6 = r5.mPreferences
            if (r6 == 0) goto L90
            java.lang.String r6 = "com.oplus.quick.video.support"
            boolean r6 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r6)
            if (r6 == 0) goto L90
            android.app.Activity r6 = r5.f14823k
            r0 = 2131755866(0x7f10035a, float:1.9142623E38)
            java.lang.String r6 = r6.getString(r0)
            android.content.SharedPreferences r0 = r5.mPreferences
            java.lang.String r1 = "pref_long_process_choice_key"
            java.lang.String r0 = r0.getString(r1, r6)
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L8e
            com.oplus.camera.capmode.PlatformImplementations.kt_3 r6 = r5.mCameraInterface
            if (r6 == 0) goto L8e
            com.oplus.camera.capmode.PlatformImplementations.kt_3 r5 = r5.mCameraInterface
            boolean r5 = r5.mo10575i()
            if (r5 == 0) goto L8e
            goto L8f
        L8e:
            r3 = r4
        L8f:
            return r3
        L90:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p158p.QuickVideoMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onVideoTemperatureThresholdChanged(int OplusGLSurfaceView_13) {
        boolean zIsVideoRecording = isVideoRecording();
        CameraLog.m12954a("QuickVideoMode", "onVideoTemperatureThresholdChanged, isVideoRecording: " + zIsVideoRecording + ", thresholdLevel: " + OplusGLSurfaceView_13);
        if (zIsVideoRecording && !this.mCameraInterface.mo10579k() && 1 == OplusGLSurfaceView_13) {
            CameraLog.m12954a("QuickVideoMode", "onVideoTemperatureThresholdChanged, stop quick video recording because of high temperature");
            this.mCameraUIInterface.mo18070a(R.string.camera_stop_video_recording_hint, -1, true, false, false);
            this.mCameraInterface.mo10562d(5);
            this.mEndType = VideoRecordMsgData.END_TYPE_TEMP_COUNT_DOWN_TO_STOP;
            reportReminderToDcs(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_TEMP_STOP_ALL_VIDEO);
        }
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
        m14866k();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        m14866k();
        this.mCameraUIInterface.mo18113aC();
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void forceStopVideoRecording(boolean z) {
        super.forceStopVideoRecording(z);
        m14866k();
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode
    protected void showRecordingTimeUI() {
        this.mCameraUIInterface.mo18096a(getRealVideoTimeRatio(), this.f14823k.getResources().getDimensionPixelSize(R.dimen.record_quick_time_margin_top), needShowVideoTime(), true);
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void startShutterButtonProgress() {
        super.startShutterButtonProgress();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z) {
        super.onBeforePictureTaken(bArr, z);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        super.onAfterPictureTaken(bArr, z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z, boolean z2) {
        super.onShutterCallback(z, z2);
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void stopShutterButtonProgress() {
        this.mCameraUIInterface.mo18091a(m14864i());
        super.stopShutterButtonProgress();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setQuickVideoBeforeLockTime(boolean z) {
        this.f14825m = this.mRecordingTotalTime;
        this.f14824l = z;
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        VideoRecordMsgData videoRecordMsgData = (dcsMsgData == null || !(dcsMsgData instanceof VideoRecordMsgData)) ? null : (VideoRecordMsgData) dcsMsgData;
        if (videoRecordMsgData == null) {
            return null;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT)) {
            videoRecordMsgData.mCaptureMode = ApsConstant.REC_MODE_QUICK_VIDEO;
            videoRecordMsgData.mVideoMode = ApsConstant.REC_MODE_QUICK_VIDEO;
        }
        if (!isVideoRecording()) {
            if (this.f14824l) {
                long OplusGLSurfaceView_15 = this.mRecordingTotalTime;
                long j2 = this.f14825m;
                videoRecordMsgData.mLockingTime = OplusGLSurfaceView_15 - j2;
                videoRecordMsgData.mHoldingTime = j2;
                this.f14824l = false;
            } else {
                videoRecordMsgData.mHoldingTime = this.mRecordingTotalTime;
            }
        }
        super.onGetBeforeCaptureMsgCommonData(dcsMsgData);
        return dcsMsgData;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public MainShutterButtonInfo m14864i() {
        String str = "button_shape_ring_none";
        if (this.mPreferences != null) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.f14823k.getString(R.string.camera_shutter_mode_default_value));
            if (FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE.equals(string)) {
                str = "button_shape_countdown_ten_seconds";
            } else if ("3".equals(string)) {
                str = "button_shape_countdown_three_seconds";
            }
        }
        return Util.m24352ao() ? new MainShutterButtonInfo(23, "button_color_inside_none", str, 0) : new MainShutterButtonInfo(1, "button_color_inside_none", str, 0);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14855b(Size size) {
        try {
            this.mProfile = m14857m();
        } catch (Exception COUIBaseListPopupWindow_8) {
            this.mProfile = null;
            CameraLog.m12965d("QuickVideoMode", "initProfile, CamcorderProfile.get fail! ", COUIBaseListPopupWindow_8);
        }
        if (this.mProfile == null || size == null) {
            return;
        }
        this.mProfile.videoFrameWidth = size.getWidth();
        this.mProfile.videoFrameHeight = size.getHeight();
        CameraLog.m12954a("QuickVideoMode", "initProfile, record width: " + this.mProfile.videoFrameWidth + ", record height: " + this.mProfile.videoFrameHeight);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private CamcorderProfile m14857m() {
        CamcorderProfile camcorderProfile;
        try {
            if (CamcorderProfile.hasProfile(this.mCameraId, 5)) {
                camcorderProfile = CamcorderProfile.get(this.mCameraId, 5);
            } else {
                camcorderProfile = CamcorderProfile.get(this.mCameraId, 4);
            }
            return camcorderProfile;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            CameraLog.m12967f("QuickVideoMode", "get CamcorderProfile fail");
            return null;
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m14865j() {
        if (this.mPreferences == null || this.mCameraUIInterface == null || this.mCameraInterface == null) {
            return;
        }
        this.f14826n = true;
        this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
        this.mCameraUIInterface.mo18114aD();
        this.mCameraUIInterface.mo18045L(true);
        showRecordingTimeUI();
        this.mCameraInterface.mo10456L();
        if ("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_PI_AI, "off"))) {
            this.f14820h = "on";
            this.mPreferences.edit().putString(CameraUIInterface.KEY_PI_AI, "off").apply();
        }
        this.f14822j = this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId));
        this.mPreferences.edit().putString(CameraUIInterface.KEY_CAMERA_HDR_MODE, "off").apply();
        this.mCameraUIInterface.mo18108a(true, true, false);
        this.mCameraUIInterface.mo18138ab();
        this.mCameraUIInterface.mo18067a(R.string.camera_toast_gesture_take_picture);
        this.mCameraUIInterface.mo18174b(true);
        String string = this.mPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, this.f14823k.getResources().getString(R.string.camera_torch_mode_default_value));
        if (("on".equals(string) || "auto".equals(string)) && !getSupportFunction(CameraFunction.TORCH_SOFT_LIGHT) && CameraCharacteristicsUtil.m12974a(this.mCameraInterface.mo10547aw())) {
            this.f14821i = string;
            InverseManager.INS.setInverseColor((Context) this.f14823k, false, false);
            this.mPreferences.edit().putString(CameraUIInterface.KEY_TORCH_MODE, "off").apply();
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m14866k() {
        if (this.mPreferences == null || this.mCameraUIInterface == null || this.mCameraInterface == null) {
            return;
        }
        if ("on".equals(this.f14820h)) {
            this.f14820h = "off";
            this.mPreferences.edit().putString(CameraUIInterface.KEY_PI_AI, "on").apply();
        }
        this.mCameraUIInterface.mo18280w();
        this.mCameraInterface.mo10458N();
        LockViewDragLayout.setIsQuickVideoStartedByShutterButtonLongClick(false);
        LockViewDragLayout.setLongPressState(false);
        this.mCameraUIInterface.mo18137aa();
        if (18 == this.mCameraInterface.mo10576j()) {
            this.mCameraUIInterface.mo18242m(18);
        } else {
            this.mCameraInterface.mo10464T();
        }
        if (!"off".equals(this.f14822j)) {
            this.mPreferences.edit().putString(CameraUIInterface.KEY_CAMERA_HDR_MODE, this.f14822j).apply();
            this.f14822j = "off";
        }
        if (this.mPreferences.getBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false) && !CameraCharacteristicsUtil.m12974a(this.mCameraId)) {
            this.mCameraUIInterface.mo18166b(R.string.camera_picture_size_standard_high_hint, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, Double.valueOf(getDisplayHighPictureSize()));
        }
        this.mCameraUIInterface.mo18113aC();
        this.mCameraUIInterface.mo18240l(false, false);
        stopShutterButtonProgress();
        if (("on".equals(this.f14821i) || "auto".equals(this.f14821i)) && !getSupportFunction(CameraFunction.TORCH_SOFT_LIGHT) && CameraCharacteristicsUtil.m12974a(this.mCameraInterface.mo10547aw())) {
            this.mPreferences.edit().putString(CameraUIInterface.KEY_TORCH_MODE, this.f14821i).apply();
            InverseManager.INS.setInverseColor((Context) this.f14823k, "on".equals(this.f14821i), false);
            this.f14821i = "off";
        }
        if (this.mCameraUIInterface.mo18023A()) {
            this.mCameraUIInterface.mo18244m(true, false);
        }
        this.mCameraUIInterface.mo18200d(true, true);
        this.f14826n = false;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m14867l() {
        return this.f14826n;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m14860b(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("QuickVideoMode", "setHalQuickVideoState state:" + OplusGLSurfaceView_13);
        m14856c(OplusGLSurfaceView_13);
        setHalStatus(OplusGLSurfaceView_13);
        this.mOneCamera.mo13012B(OplusGLSurfaceView_13 == 0);
        this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.QUICK_VIDEO_RECORD_ENABLE, (CameraParameter.PreviewKey<String>) (1 == OplusGLSurfaceView_13 ? "on" : "off"));
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m14856c(int OplusGLSurfaceView_13) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_QUICK_VIDEO_OIS_CONFIG)) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, (CaptureRequest.Key) Integer.valueOf(1 == OplusGLSurfaceView_13 ? 0 : 1));
        }
    }
}

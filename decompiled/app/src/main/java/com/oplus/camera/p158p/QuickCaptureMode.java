package com.oplus.camera.p158p;

import android.app.Activity;
import android.hardware.camera2.CaptureRequest;
import android.provider.Settings;
import android.util.Size;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.capmode.CommonCapMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.p172ui.widget.LockViewDragLayout;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPreviewCallback;

/* compiled from: QuickCaptureMode.java */
/* renamed from: com.oplus.camera.p.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class QuickCaptureMode extends CommonCapMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f14816g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private QuickVideoMode f14817h;

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean canShowResumeButton() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDelayFaceDetection() {
        return true;
    }

    public QuickCaptureMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f14816g = false;
        this.f14817h = null;
        this.f14817h = new QuickVideoMode(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateOneCamera(OneCamera interfaceC2694d) {
        super.updateOneCamera(interfaceC2694d);
        this.f14817h.updateOneCamera(interfaceC2694d);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    protected void resetAfterPictureTaken(boolean z, boolean z2) {
        boolean supportFunction;
        super.resetAfterPictureTaken(z, z2);
        if ((!this.mbCaptureRawTimeDone && z) || this.mActivity == null || this.mPreferences == null) {
            return;
        }
        String string = this.mActivity.getString(R.string.camera_setting_long_process_shutter_default_value);
        String string2 = this.mPreferences.getString(CameraUIInterface.KEY_LONG_PROCESS_SHUTTER_CHOICE, string);
        if (string.equals(string2)) {
            supportFunction = getSupportFunction(CameraUIInterface.KEY_QUICK_VIDEO);
        } else {
            supportFunction = getSupportFunction(CameraUIInterface.KEY_BURST_SHOT);
        }
        this.mCameraUIInterface.mo18092a(getShutterButtonInfo(), supportFunction);
        CameraLog.m12954a("QuickCaptureMode", "resetAfterPictureTaken, defaultValue: " + string + ", choiceValue: " + string2 + ", longClickable: " + supportFunction);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1633814243: goto L46;
                case -1593450737: goto L3c;
                case -1135915663: goto L32;
                case -681469213: goto L28;
                case -185556839: goto L1e;
                case 1640046025: goto L14;
                case 1706373443: goto La;
                default: goto L9;
            }
        L9:
            goto L50
        La:
            java.lang.String r0 = "pref_support_capture_preview"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L50
            r0 = 4
            goto L51
        L14:
            java.lang.String r0 = "key_quick_video"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L50
            r0 = r1
            goto L51
        L1e:
            java.lang.String r0 = "pref_camera_gesture_shutter_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L50
            r0 = 5
            goto L51
        L28:
            java.lang.String r0 = "key_support_update_thumbnail_user_picture"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L50
            r0 = 3
            goto L51
        L32:
            java.lang.String r0 = "pref_ai_scene_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L50
            r0 = 6
            goto L51
        L3c:
            java.lang.String r0 = "pref_watermark_function_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L50
            r0 = 2
            goto L51
        L46:
            java.lang.String r0 = "support_focus_out_of_range"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L50
            r0 = r2
            goto L51
        L50:
            r0 = -1
        L51:
            switch(r0) {
                case 0: goto Lc0;
                case 1: goto L8a;
                case 2: goto L66;
                case 3: goto L61;
                case 4: goto L61;
                case 5: goto L56;
                case 6: goto L56;
                default: goto L54;
            }
        L54:
            goto Lc1
        L56:
            boolean r0 = r4.f14816g
            if (r0 == 0) goto Lc1
            com.oplus.camera.p.IntrinsicsJvm.kt_4 r4 = r4.f14817h
            boolean r4 = r4.getSupportFunction(r5)
            return r4
        L61:
            boolean r0 = r4.f14816g
            if (r0 == 0) goto Lc1
            return r2
        L66:
            boolean r0 = r4.f14816g
            if (r0 == 0) goto L71
            com.oplus.camera.p.IntrinsicsJvm.kt_4 r4 = r4.f14817h
            boolean r4 = r4.getSupportFunction(r5)
            return r4
        L71:
            java.lang.String r5 = "com.oplus.video.watermark.support"
            boolean r5 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r5)
            if (r5 == 0) goto L88
            java.lang.String r5 = r4.getCameraMode()
            int r4 = r4.mCameraId
            java.lang.String r0 = "aps_algo_watermark"
            boolean r4 = com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(r5, r4, r0)
            if (r4 == 0) goto L88
            goto L89
        L88:
            r1 = r2
        L89:
            return r1
        L8a:
            android.app.Activity r5 = r4.mActivity
            if (r5 == 0) goto Lc0
            android.content.SharedPreferences r5 = r4.mPreferences
            if (r5 == 0) goto Lc0
            java.lang.String r5 = "com.oplus.quick.video.support"
            boolean r5 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r5)
            if (r5 == 0) goto Lc0
            android.app.Activity r5 = r4.mActivity
            r0 = 2131755866(0x7f10035a, float:1.9142623E38)
            java.lang.String r5 = r5.getString(r0)
            android.content.SharedPreferences r0 = r4.mPreferences
            java.lang.String r3 = "pref_long_process_choice_key"
            java.lang.String r0 = r0.getString(r3, r5)
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lbe
            com.oplus.camera.capmode.PlatformImplementations.kt_3 r5 = r4.mCameraInterface
            if (r5 == 0) goto Lbe
            com.oplus.camera.capmode.PlatformImplementations.kt_3 r4 = r4.mCameraInterface
            boolean r4 = r4.mo10575i()
            if (r4 == 0) goto Lbe
            goto Lbf
        Lbe:
            r1 = r2
        Lbf:
            return r1
        Lc0:
            return r2
        Lc1:
            boolean r4 = super.getSupportFunction(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p158p.QuickCaptureMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        return super.getSupportMenu(CameraEntry.m13305d(str));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoModeType() {
        if (this.f14816g) {
            return this.f14817h.isVideoModeType();
        }
        return super.isVideoModeType();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getVideoFps() {
        if (this.f14816g) {
            return this.f14817h.getVideoFps();
        }
        return super.getVideoFps();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onShutterButtonLongClick() {
        if (1 == Settings.System.getInt(this.mActivity.getContentResolver(), "oplus.camera.video", 0)) {
            this.mCameraUIInterface.mo18070a(R.string.camera_high_temperature_video_record_disable, -1, true, false, false);
            this.mCameraUIInterface.mo18113aC();
            this.mCameraUIInterface.mo18068a(0, 2);
            this.mCameraUIInterface.mo18240l(true, false);
            CameraLog.m12967f("QuickCaptureMode", "onShutterButtonLongClick, Can't start recording video due to high temperature, so return");
            return;
        }
        Size previewSize = getPreviewSize(this.mOneCamera.mo13086e());
        this.mCameraUIInterface.mo18091a(m14854a());
        this.f14817h.m14865j();
        this.f14817h.m14859a(previewSize);
        if (this.mbFrontCamera) {
            this.f14816g = true;
            this.f14817h.m14861f();
        }
        if (isGoogleLensEnable()) {
            hideGoogleLensIcon(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onVideoTemperatureThresholdChanged(int OplusGLSurfaceView_13) {
        QuickVideoMode c2828b = this.f14817h;
        if (c2828b != null) {
            c2828b.onVideoTemperatureThresholdChanged(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void resetFiltersList() {
        super.resetFiltersList();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void updateGrandTourCityFiltersPosition(String str) {
        super.updateGrandTourCityFiltersPosition(str);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        if (this.f14816g) {
            return this.f14817h.getPictureSize(c2698h);
        }
        return super.getPictureSize(c2698h);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void stopQuickVideoRecording() {
        CameraLog.m12954a("QuickCaptureMode", "stopQuickVideoRecording");
        if (LockViewDragLayout.m23984a()) {
            LockViewDragLayout.setIsQuickVideoStartedByShutterButtonLongClick(false);
        }
        this.f14817h.m14863h();
        this.f14816g = false;
        this.f14817h.m14866k();
        this.mCameraUIInterface.mo18258q();
        if (isGoogleLensEnable()) {
            showGoogleLensIcon(true);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    public boolean isGoogleLensEnable() {
        return !this.f14816g && super.isGoogleLensEnable();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void afterStopRecording() {
        this.f14816g = false;
        super.afterStopRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean getQuickVideoRecording() {
        return this.f14816g;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setQuickVideoBeforeLockTime(boolean z) {
        this.f14817h.setQuickVideoBeforeLockTime(z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isQuickVideoInRestriction() {
        return this.f14817h.m14867l();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        if (this.f14816g) {
            this.f14816g = false;
            this.f14817h.onPause();
        } else {
            super.onPause();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onApsPreviewCaptureCompleted(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult, boolean z) {
        if (!this.mbFrontCamera && !this.f14816g && z && cameraPreviewResult != null && m14851a(cameraPreviewResult)) {
            this.f14816g = true;
            LockViewDragLayout.setLongPressState(false);
            this.f14817h.m14861f();
        } else {
            if (this.f14816g || z || cameraPreviewResult == null) {
                return;
            }
            m14853b(cameraPreviewResult);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onVideoRecordingPause() {
        return this.f14817h.onVideoRecordingPause();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onVideoRecordingResume() {
        return this.f14817h.onVideoRecordingResume();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStopped() {
        return this.f14817h.isVideoRecordStopped();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecording() {
        return this.f14817h.isVideoRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStarted() {
        return this.f14817h.isVideoRecordStarted();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void forceStopVideoRecording(boolean z) {
        if (isGoogleLensEnable()) {
            showGoogleLensIcon(true);
        }
        this.f14817h.forceStopVideoRecording(z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needApsToProcessVideoWatermark() {
        if (this.f14816g) {
            return this.f14817h.isVideoRecording();
        }
        return super.needApsToProcessVideoWatermark();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStarting() {
        return this.f14817h.isVideoRecordStarting();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStopping() {
        return this.f14817h.isVideoRecordStopping();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z) {
        if (this.f14816g) {
            this.f14817h.onBeforePictureTaken(bArr, z);
        } else {
            super.onBeforePictureTaken(bArr, z);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z, boolean z2) {
        if (this.f14816g) {
            this.f14817h.onShutterCallback(z, z2);
        } else {
            super.onShutterCallback(z, z2);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        if (this.f14816g) {
            this.f14817h.onAfterPictureTaken(bArr, z);
        } else {
            super.onAfterPictureTaken(bArr, z);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean isAISceneOpen() {
        if (this.f14816g) {
            return false;
        }
        return super.isAISceneOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultCaptureNumber() {
        if (this.f14816g) {
            return this.f14817h.getDefaultCaptureNumber();
        }
        return super.getDefaultCaptureNumber();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onZoomChanged() {
        if (this.f14816g) {
            this.f14817h.onZoomChanged();
        } else {
            super.onZoomChanged();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isHalVideoRecording() {
        return 1 == this.f14817h.m14862g();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean isHideHeadLine() {
        return 1 == this.f14817h.m14862g() && LockViewDragLayout.getLongPressState();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (this.f14816g) {
            this.f14816g = false;
            return this.f14817h.onBackPressed();
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        this.f14817h.setOrientation(OplusGLSurfaceView_13);
        super.setOrientation(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int OplusGLSurfaceView_13) {
        this.f14817h.cameraIdChanged(OplusGLSurfaceView_13);
        super.cameraIdChanged(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setCameraId(int OplusGLSurfaceView_13) {
        this.f14817h.setCameraId(OplusGLSurfaceView_13);
        super.setCameraId(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        if (this.f14816g) {
            return this.f14817h.onBeforeSnapping(c2693c);
        }
        boolean zOnBeforeSnapping = super.onBeforeSnapping(c2693c);
        this.mbCheckTakeAnimateDelay = false;
        return zOnBeforeSnapping;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        if (this.f14816g) {
            this.f14817h.onAfterStartPreview(z);
        } else {
            super.onAfterStartPreview(z);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean withinSatMainAndWideRange(float COUIBaseListPopupWindow_12) {
        if (this.f14816g) {
            return false;
        }
        return super.withinSatMainAndWideRange(COUIBaseListPopupWindow_12);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public CameraRequestTag getCaptureRequestTag(CameraApsDecision cameraApsDecision, boolean z) {
        CameraRequestTag captureRequestTag = super.getCaptureRequestTag(cameraApsDecision, z);
        captureRequestTag.f13401ac = this.f14816g;
        return captureRequestTag;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        if (this.mOneCamera != null) {
            if (this.mCameraInterface != null) {
                this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_ORIENTATION, (CaptureRequest.Key) Integer.valueOf(getJpegOrientation(this.mCameraId, this.mCameraInterface.mo10591u())));
            }
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBinauralRecordStateChanged(boolean z) {
        this.f14817h.onBinauralRecordStateChanged(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public MainShutterButtonInfo m14854a() {
        return new MainShutterButtonInfo(1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m14851a(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        return !(cameraPreviewResult == null || cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_VIDEO_EIS) == null || 1 != ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_VIDEO_EIS)).intValue()) || isMonoIndex(getCurrFilterIndex());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14853b(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        if (1 == this.f14817h.m14862g()) {
            this.f14817h.m14860b(0);
            this.mCameraInterface.mo10584n();
            if (this.mActivity != null) {
                this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.p.-$$Lambda$PlatformImplementations.kt_3$y08pV8OfKtc7tprLBj-eUbj-R_U
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m14852b();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m14852b() {
        if (this.f14817h != null && !this.mbFrontCamera) {
            this.f14817h.m14866k();
        }
        if (isGoogleLensEnable()) {
            showGoogleLensIcon(true);
        }
    }
}

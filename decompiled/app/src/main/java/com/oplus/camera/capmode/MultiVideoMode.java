package com.oplus.camera.capmode;

import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.camera2.CaptureRequest;
import android.util.Size;
import android.view.MotionEvent;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.capmode.p139a.MultiCameraDecision;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p146gl.p148b.MultiVideoSmallSurfaceTouchEventHelper;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.menu.p175a.HeadlineHelper;
import com.oplus.camera.p172ui.modepanel.DataBaseOperator;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraUnitClient;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MultiVideoMode.java */
/* renamed from: com.oplus.camera.capmode.q */
/* loaded from: classes2.dex */
public class MultiVideoMode extends VideoMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f12960g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private MultiCameraDecision f12961h;

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean canShowResumeButton() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_MULTI_VIDEO;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getFaceBeautyKey() {
        return CameraUIInterface.KEY_MULTI_VIDEO_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected int getFaceBeautyModeIndex() {
        return 5;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32812;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z, int OplusGLSurfaceView_13, int i2) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isMultiVideoMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedAPSProcess() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needPreviewMeta(int OplusGLSurfaceView_13) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    public MultiVideoMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f12960g = true;
        this.f12961h = null;
        this.f12961h = new MultiCameraDecision(0, 1, 1);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        this.f12960g = true;
        if ("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, "off"))) {
            this.mPreferences.edit().putString(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, "off").apply();
        }
        super.onInitCameraMode();
        MultiVideoSmallSurfaceTouchEventHelper.m13880a().m13881a((int) this.mActivity.getResources().getDimension(R.dimen.multicamera_small_surface_start_margin), (int) this.mActivity.getResources().getDimension(R.dimen.multicamera_small_surface_top_margin), (int) this.mActivity.getResources().getDimension(R.dimen.multicamera_small_surface_end_margin), (int) this.mActivity.getResources().getDimension(R.dimen.multicamera_small_surface_bottom_margin));
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        this.mPreferences.edit().putString(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, "off").apply();
        super.onResume(z);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        return "type_multi_main_preview_frame".equals(str) || "type_multi_sub_preview_frame".equals(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_1080P_SUPPORT)) {
            return new Size(VideoMode.VIDEO_1080P_WIDTH, VideoMode.VIDEO_1080P_HEIGHT);
        }
        return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_PREVIEW_SIZE);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h, String str) {
        Size size;
        if (str != null) {
            int OplusGLSurfaceView_13 = this.mPreferences.getInt(CameraUIInterface.KEY_MULTI_CAMERA_SHOW_POSITION_STATE, 1);
            int i2 = this.mPreferences.getInt(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0);
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2) {
                    size = null;
                } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_1080P_SUPPORT)) {
                    size = m12561a(str, OplusGLSurfaceView_13, i2, VideoMode.VIDEO_1080P_WIDTH, VideoMode.VIDEO_1080P_HEIGHT);
                } else {
                    Size sizeConfigValue = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_PREVIEW_SIZE);
                    size = m12561a(str, OplusGLSurfaceView_13, i2, sizeConfigValue.getWidth(), sizeConfigValue.getHeight());
                }
            } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_1080P_SUPPORT)) {
                size = new Size(CameraParameter.VideoFps.FPS_960, VideoMode.VIDEO_1080P_HEIGHT);
            } else {
                Size sizeConfigValue2 = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_PREVIEW_SIZE);
                size = new Size(sizeConfigValue2.getWidth() / 2, sizeConfigValue2.getHeight());
            }
            CameraLog.m12959b("MultiVideoMode", "getPreviewSize, surfaceType: " + str + ", previewSize: " + size);
            return size;
        }
        return getPreviewSize(c2698h);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Size m12561a(String str, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        OplusCameraCharacteristics cameraInfo = getCameraInfo(1);
        List<Size> listM13246C = cameraInfo != null ? cameraInfo.m13246C() : null;
        if (2 == i2) {
            if ("type_multi_main_preview_frame".equals(str)) {
                if (1 == OplusGLSurfaceView_13) {
                    return new Size(i3, i4);
                }
                return Util.m24238a(listM13246C, (int) (i3 / 3.0f), (int) (i4 / 3.0f));
            }
            if (!"type_multi_sub_preview_frame".equals(str)) {
                return null;
            }
            if (1 == OplusGLSurfaceView_13) {
                return Util.m24238a(listM13246C, (int) (i3 / 3.0f), (int) (i4 / 3.0f));
            }
            return new Size(i3, i4);
        }
        if (1 != i2) {
            return null;
        }
        if ("type_multi_main_preview_frame".equals(str)) {
            if (1 == OplusGLSurfaceView_13) {
                return new Size(i3, i4);
            }
            int i5 = (int) (i4 / 2.33f);
            return Util.m24238a(listM13246C, i5, i5);
        }
        if (!"type_multi_sub_preview_frame".equals(str)) {
            return null;
        }
        if (1 == OplusGLSurfaceView_13) {
            int i6 = (int) (i4 / 2.33f);
            return Util.m24238a(listM13246C, i6, i6);
        }
        return new Size(i3, i4);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public MultiCameraDecision getMultiCameraDecision() {
        return this.f12961h;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU.equals(str)) {
            return true;
        }
        return super.getSupportMenu(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b9  */
    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 0
            java.lang.String r2 = "func_face_beauty_process"
            r3 = 1
            switch(r0) {
                case -2070716397: goto Lae;
                case -1789212585: goto La4;
                case -1593450737: goto L99;
                case -1342983725: goto L91;
                case -1111057913: goto L87;
                case -821536541: goto L7c;
                case -408507050: goto L72;
                case -207649060: goto L67;
                case 121201516: goto L5d;
                case 336270991: goto L53;
                case 663120474: goto L47;
                case 1082475231: goto L3b;
                case 1248329464: goto L2f;
                case 1599576324: goto L24;
                case 1658068003: goto L19;
                case 1961723364: goto Ld;
                default: goto Lb;
            }
        Lb:
            goto Lb9
        Ld:
            java.lang.String r0 = "pref_filter_process_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 10
            goto Lba
        L19:
            java.lang.String r0 = "key_multicamera_type_menu_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = r3
            goto Lba
        L24:
            java.lang.String r0 = "pref_support_switch_camera"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = r1
            goto Lba
        L2f:
            java.lang.String r0 = "func_face_slender_process"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 14
            goto Lba
        L3b:
            java.lang.String r0 = "pref_face_detection_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 9
            goto Lba
        L47:
            java.lang.String r0 = "func_out_capture"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 12
            goto Lba
        L53:
            java.lang.String r0 = "pref_zoom_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 2
            goto Lba
        L5d:
            java.lang.String r0 = "pref_support_recording_capture"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 6
            goto Lba
        L67:
            java.lang.String r0 = "func_out_preview"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 11
            goto Lba
        L72:
            java.lang.String r0 = "pref_camera_videoflashmode_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 5
            goto Lba
        L7c:
            java.lang.String r0 = "func_out_preview_capture"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 13
            goto Lba
        L87:
            java.lang.String r0 = "func_face_beauty_common"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 4
            goto Lba
        L91:
            boolean r0 = r5.equals(r2)
            if (r0 == 0) goto Lb9
            r0 = 3
            goto Lba
        L99:
            java.lang.String r0 = "pref_watermark_function_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 15
            goto Lba
        La4:
            java.lang.String r0 = "pref_assist_gradienter"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 7
            goto Lba
        Lae:
            java.lang.String r0 = "pref_camera_assistant_line_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 8
            goto Lba
        Lb9:
            r0 = -1
        Lba:
            switch(r0) {
                case 0: goto Ld5;
                case 1: goto Ld5;
                case 2: goto Ld5;
                case 3: goto Ld5;
                case 4: goto Ld5;
                case 5: goto Lcf;
                case 6: goto Lce;
                case 7: goto Lce;
                case 8: goto Lce;
                case 9: goto Lce;
                case 10: goto Lce;
                case 11: goto Lce;
                case 12: goto Lce;
                case 13: goto Lce;
                case 14: goto Lc9;
                case 15: goto Lc2;
                default: goto Lbd;
            }
        Lbd:
            boolean r4 = super.getSupportFunction(r5)
            return r4
        Lc2:
            java.lang.String r4 = "com.oplus.video.watermark.support"
            boolean r4 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            return r4
        Lc9:
            boolean r4 = r4.getSupportFunction(r2)
            return r4
        Lce:
            return r1
        Lcf:
            boolean r4 = com.oplus.camera.util.Util.m24328aQ()
            r4 = r4 ^ r3
            return r4
        Ld5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.MultiVideoMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        if (CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU.equals(str) && getSupportFunction(str) && sharedPreferences != null) {
            m12563a("on".equals(sharedPreferences.getString(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, this.mActivity.getString(R.string.camera_multicamera_type_default))), true, "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU_NEED_SHOW_ZOOM, this.mActivity.getString(R.string.camera_multicamera_type_need_zoom_default))));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12563a(boolean z, boolean z2, boolean z3) {
        m12564a(z, z2, z3, true);
        m12562a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12564a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mCameraInterface == null || this.mCameraUIInterface == null) {
            return;
        }
        this.mCameraUIInterface.mo18192c(z, z2, z4, true);
        if (z) {
            this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, true);
            if (this.mCameraUIInterface.mo18043K()) {
                this.mCameraUIInterface.mo18109a(z2, true, true, false);
            }
            this.mCameraUIInterface.mo18223h(z2, true);
            this.mCameraUIInterface.mo18232j(z2, true);
            return;
        }
        if (isVideoRecordStarting() || isVideoRecordStarted()) {
            return;
        }
        if (z3) {
            this.mCameraInterface.mo10492a(true, true);
            this.mCameraInterface.mo10563d(true);
        }
        if (z3 && supportMenuLeftButton()) {
            this.mCameraUIInterface.mo18228i(z2, true);
        }
        if (supportBeautyButton()) {
            this.mCameraUIInterface.mo18240l(z2, true);
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(5, "button_color_inside_red", "button_shape_ring_none", 1));
        this.mCameraInterface.mo10492a(true, this.mCameraUIInterface.mo18111aA());
        this.mCameraInterface.mo10563d(true);
        super.beforeStartRecording();
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void onStopVideoRecording(boolean z) {
        this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(6, "button_color_inside_red", "button_shape_ring_none", 1));
        super.onStopVideoRecording(z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void afterStartRecording() {
        super.afterStartRecording();
        m12564a(false, true, true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void restoreDefaultMode(boolean z) {
        super.restoreDefaultMode(z);
        if (this.mPreferences != null) {
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.remove(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU);
            editorEdit.apply();
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        this.mCameraUIInterface.mo18192c(false, false, false, true);
        if (this.mCameraUIInterface.mo18111aA()) {
            this.mCameraUIInterface.mo18041J(true);
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        int screenWidth;
        int screenWidth2;
        int settingMenuPanelHeight;
        super.onBeforePreview();
        applyBeautyParam();
        int OplusGLSurfaceView_13 = this.mPreferences.getInt(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0);
        int i2 = this.mPreferences.getInt(CameraUIInterface.KEY_MULTI_CAMERA_SHOW_POSITION_STATE, 1);
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key<Integer>>) CameraMetadataKey.f13325bf, (CaptureRequest.Key<Integer>) Integer.valueOf((OplusGLSurfaceView_13 == 0 || 1 == i2) ? 1 : 0));
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18266s(OplusGLSurfaceView_13);
            this.mCameraUIInterface.mo18037H(1 == i2);
            this.mCameraUIInterface.mo18039I(false);
            float fM12560a = m12560a(OplusGLSurfaceView_13);
            Resources resources = this.mActivity.getResources();
            if (Util.m24495t()) {
                int screenHeight = Util.m24498u() ? (int) (Util.getScreenHeight() / 1.7777777777777777d) : Util.getScreenWidth();
                screenWidth = Math.round(screenHeight / fM12560a);
                int dimension = (int) resources.getDimension(R.dimen.fold_multicamera_small_surface_end_margin);
                settingMenuPanelHeight = (int) resources.getDimension(R.dimen.fold_multicamera_small_surface_top_margin);
                screenWidth2 = (screenHeight - dimension) - screenWidth;
            } else {
                int dimension2 = (int) resources.getDimension(R.dimen.multicamera_small_surface_end_margin);
                int dimension3 = (int) resources.getDimension(R.dimen.multicamera_small_surface_top_margin);
                screenWidth = (int) (Util.getScreenWidth() * (1.0f / fM12560a));
                screenWidth2 = (Util.getScreenWidth() - screenWidth) - dimension2;
                settingMenuPanelHeight = dimension3 + Util.getSettingMenuPanelHeight();
            }
            this.mCameraUIInterface.mo18185c(screenWidth2, settingMenuPanelHeight);
            int i3 = (int) (screenWidth * (1 == OplusGLSurfaceView_13 ? 1.0d : 1.7777777777777777d));
            this.mCameraUIInterface.mo18194d(screenWidth, i3);
            CameraLog.m12959b("MultiVideoMode", "onBeforePreview, state: " + i2 + ", type: " + OplusGLSurfaceView_13 + ", smallSurfaceWidth: " + screenWidth + ", smallSurfaceHeight: " + i3 + ", x: " + screenWidth2 + ", y: " + settingMenuPanelHeight);
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        super.onAfterStartPreview(z);
        m12562a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12562a() {
        if (this.mCameraUIInterface == null || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT)) {
            return;
        }
        this.mCameraUIInterface.mo18262r(this.mPreferences.getInt(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedTransAnimWhenRecording() {
        return this.mCameraUIInterface.mo18159aw();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected String[] getCustomBeautyKeys() {
        return CameraUIInterface.KEY_MULTI_VIDEO_CUSTOM_BEAUTY;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getDefaultCommonBeautyValue() {
        return isFaceBeautyDefaultOff() ? 0 : 40;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        VideoRecordMsgData videoRecordMsgData;
        int properCameraId;
        int properCameraId2;
        if (!(dcsMsgData instanceof VideoRecordMsgData) || this.mPreferences == null) {
            videoRecordMsgData = null;
        } else {
            VideoRecordMsgData videoRecordMsgData2 = (VideoRecordMsgData) dcsMsgData;
            int OplusGLSurfaceView_13 = this.mPreferences.getInt(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0);
            if (this.mCameraUIInterface != null && OplusGLSurfaceView_13 != 0) {
                videoRecordMsgData2.mSubScreenValue = String.valueOf(this.mCameraUIInterface.mo18162az());
            }
            if (1 == this.mPreferences.getInt(CameraUIInterface.KEY_MULTI_CAMERA_SHOW_POSITION_STATE, 1)) {
                int properCameraId3 = getProperCameraId(0);
                properCameraId = getProperCameraId(1);
                properCameraId2 = properCameraId3;
            } else {
                properCameraId = getProperCameraId(0);
                properCameraId2 = getProperCameraId(1);
            }
            videoRecordMsgData2.mScreenCompose = "{main: " + properCameraId2 + ", sub: " + properCameraId + "}";
            videoRecordMsgData2.mScreenMode = String.valueOf(OplusGLSurfaceView_13);
            videoRecordMsgData = videoRecordMsgData2;
        }
        return videoRecordMsgData == null ? dcsMsgData : videoRecordMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onSwitchCameraButtonClick() {
        if (!this.f12960g || this.mCameraUIInterface == null) {
            return;
        }
        this.f12960g = false;
        this.mCameraUIInterface.mo18070a(R.string.camera_mode_multi_video_switch_tip, 0, true, false, false);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.mCameraUIInterface != null && this.mCameraUIInterface.mo18111aA()) {
            this.mCameraUIInterface.mo18041J(true);
        }
        return super.onSingleTapUp(motionEvent);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMenuOptionAdded(String str) {
        if (CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU.equals(str) && this.mCameraUIInterface.mo18142af()) {
            this.mCameraUIInterface.mo18102a(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, true, (int) this.mActivity.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.mActivity.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_y));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11354m(false);
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    @SuppressLint({"WrongConstant"})
    public void setConfigureParameter(CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        OplusCameraCharacteristics c2698hM12971a = CameraCharacteristicsUtil.m12971a(getCameraMode(), CameraCharacteristicsUtil.m12985h());
        OplusCameraCharacteristics c2698hM12971a2 = CameraCharacteristicsUtil.m12971a(getCameraMode(), CameraCharacteristicsUtil.m12986i());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CameraDeviceConfig.PreviewConfig(CameraUnitClient.CameraType.REAR_MAIN, getPreviewSize(c2698hM12971a, "type_multi_main_preview_frame"), 5));
        if (Util.m24451g() == 0) {
            arrayList.add(new CameraDeviceConfig.PreviewConfig(CameraUnitClient.CameraType.FRONT_WIDE, getPreviewSize(c2698hM12971a2, "type_multi_sub_preview_frame"), 5));
        } else {
            arrayList.add(new CameraDeviceConfig.PreviewConfig(CameraUnitClient.CameraType.FRONT_MAIN, getPreviewSize(c2698hM12971a2, "type_multi_sub_preview_frame"), 5));
        }
        builder.setPreviewConfig(arrayList);
        builder.setParameter(CameraParameter.KEY_DUAL_SCENE_MASTER, Integer.valueOf((this.mPreferences.getInt(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0) == 0 || 1 == this.mPreferences.getInt(CameraUIInterface.KEY_MULTI_CAMERA_SHOW_POSITION_STATE, 1)) ? 1 : 0));
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        super.onDeInitCameraMode(str);
        this.mCameraUIInterface.mo18192c(false, false, true, this.mCameraUIInterface.mo18111aA());
        if (isPanelMode() || !"position_headline".equals(DataBaseOperator.m21777a().m21781a(HeadlineHelper.m20347b(str)).m21910c())) {
            return;
        }
        this.mCameraUIInterface.mo18068a(0, 1);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        super.onMoreModeShown();
        if ("position_headline".equals(DataBaseOperator.m21777a().m21781a(14).m21910c())) {
            m12564a(false, false, false, true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
        m12563a("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, this.mActivity.getString(R.string.camera_multicamera_type_default))), false, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ScreenModeConst.PlatformImplementations.kt_3 getPreferredScreenMode(int OplusGLSurfaceView_13) {
        if (!Util.m24498u()) {
            return ScreenModeConst.PlatformImplementations.kt_3.out;
        }
        if (270 == OplusGLSurfaceView_13) {
            return ScreenModeConst.PlatformImplementations.kt_3.full90;
        }
        if (90 == OplusGLSurfaceView_13) {
            return ScreenModeConst.PlatformImplementations.kt_3.full270;
        }
        return ScreenModeConst.PlatformImplementations.kt_3.full;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m12560a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return 1.0f;
        }
        boolean z = 1 == OplusGLSurfaceView_13;
        return Util.m24495t() ? Util.m24498u() ? z ? 2.13f : 2.68f : z ? 2.09f : 2.63f : z ? 2.33f : 3.0f;
    }
}

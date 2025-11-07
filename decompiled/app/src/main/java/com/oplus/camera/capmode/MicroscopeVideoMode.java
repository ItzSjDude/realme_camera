package com.oplus.camera.capmode;

import android.app.Activity;
import android.content.res.Resources;
import android.hardware.camera2.CaptureRequest;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.service.CameraCaptureResult;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.MicroscopeHintView;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.FilterTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;
import java.util.List;

/* compiled from: MicroscopeVideoMode.java */
/* renamed from: com.oplus.camera.capmode.p */
/* loaded from: classes2.dex */
public class MicroscopeVideoMode extends VideoMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private SensorHelper f12949g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private MicroscopeHintView.InterfaceC3097a f12950h;

    /* renamed from: OplusGLSurfaceView_13 */
    private View.OnClickListener f12951i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f12952j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f12953k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f12954l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f12955m;

    /* renamed from: OplusGLSurfaceView_11 */
    private TextView f12956n;

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.REC_MODE_MICROSCOPE;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getEffectMenuKeyByMode() {
        return CameraUIInterface.KEY_VIDEO_FILTER_MENU;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        return CameraUIInterface.KEY_FILTER_ANC_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getFilterTitleTexId() {
        return R.string.camera_filter_effect;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFlashMode() {
        return CameraParameter.FlashMode.FLASH_TORCH;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean getNeedReduceBitRate() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32779;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOrientationRectify() {
        return 180;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isMicroscopeMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onLongPress(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean withinSatMainRange(float COUIBaseListPopupWindow_12) {
        return true;
    }

    public MicroscopeVideoMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f12949g = new SensorHelper();
        this.f12950h = null;
        this.f12951i = null;
        this.f12952j = false;
        this.f12953k = false;
        this.f12954l = 0;
        this.f12955m = 0;
        this.f12956n = null;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(str)) {
            return getSupportFunction(str);
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public CameraRequestTag getCaptureRequestTag(CameraApsDecision cameraApsDecision, boolean z) {
        CameraRequestTag captureRequestTag = super.getCaptureRequestTag(cameraApsDecision, z);
        captureRequestTag.f13401ac = true;
        return captureRequestTag;
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult, CameraRequestTag c2693c) {
        super.onCaptureCompleted(cameraCaptureResult, c2693c);
        if (c2693c.f13401ac) {
            this.mCameraInterface.mo10478a(cameraCaptureResult.mIdentity, Util.m24246a(System.currentTimeMillis()), false, false, false);
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        super.setOrientation(OplusGLSurfaceView_13);
        if (3 == AlgoSwitchConfig.getApsVersion() && this.mCameraInterface.mo10575i() && this.mOneCamera != null) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_ORIENTATION, (CaptureRequest.Key) Integer.valueOf((getJpegOrientation(this.mCameraId, this.mOrientation) + getOrientationRectify()) % 360));
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_QUALITY, (CaptureRequest.Key) (byte) 95);
            this.mOneCamera.mo13067b((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_GPS_LOCATION, (CaptureRequest.Key) this.mCameraInterface.mo10595y());
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ac  */
    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = 0
            switch(r0) {
                case -1808424762: goto La2;
                case -1449790675: goto L97;
                case -1135915663: goto L8d;
                case -867604430: goto L82;
                case -408507050: goto L78;
                case -185556839: goto L6e;
                case -100202123: goto L63;
                case 39023177: goto L58;
                case 86895712: goto L4e;
                case 771732173: goto L43;
                case 1062270711: goto L38;
                case 1082475231: goto L2c;
                case 1433615423: goto L20;
                case 1709159627: goto L15;
                case 1961723364: goto La;
                default: goto L8;
            }
        L8:
            goto Lac
        La:
            java.lang.String r0 = "pref_filter_process_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = r1
            goto Lad
        L15:
            java.lang.String r0 = "pref_video_super_eis_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 4
            goto Lad
        L20:
            java.lang.String r0 = "key_high_picture_size"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 10
            goto Lad
        L2c:
            java.lang.String r0 = "pref_face_detection_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 14
            goto Lad
        L38:
            java.lang.String r0 = "pref_time_lapse_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 1
            goto Lad
        L43:
            java.lang.String r0 = "func_enhancement_video"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 12
            goto Lad
        L4e:
            java.lang.String r0 = "key_support_video_high_fps"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 5
            goto Lad
        L58:
            java.lang.String r0 = "func_google_lens"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 13
            goto Lad
        L63:
            java.lang.String r0 = "pref_burst_shot_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 9
            goto Lad
        L6e:
            java.lang.String r0 = "pref_camera_gesture_shutter_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 6
            goto Lad
        L78:
            java.lang.String r0 = "pref_camera_videoflashmode_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 2
            goto Lad
        L82:
            java.lang.String r0 = "key_support_show_soloop"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 11
            goto Lad
        L8d:
            java.lang.String r0 = "pref_ai_scene_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 7
            goto Lad
        L97:
            java.lang.String r0 = "pref_super_clear_portrait"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 8
            goto Lad
        La2:
            java.lang.String r0 = "func_ultra_night_video"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 3
            goto Lad
        Lac:
            r0 = -1
        Lad:
            switch(r0) {
                case 0: goto Lb6;
                case 1: goto Lb5;
                case 2: goto Lb5;
                case 3: goto Lb5;
                case 4: goto Lb5;
                case 5: goto Lb5;
                case 6: goto Lb5;
                case 7: goto Lb5;
                case 8: goto Lb5;
                case 9: goto Lb5;
                case 10: goto Lb5;
                case 11: goto Lb5;
                case 12: goto Lb5;
                case 13: goto Lb5;
                case 14: goto Lb5;
                default: goto Lb0;
            }
        Lb0:
            boolean r2 = super.getSupportFunction(r3)
            return r2
        Lb5:
            return r1
        Lb6:
            java.lang.String r3 = r2.getCameraMode()
            int r2 = r2.mCameraId
            java.lang.String r0 = "aps_algo_filter"
            boolean r2 = com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(r3, r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.MicroscopeVideoMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) throws Resources.NotFoundException {
        super.onAfterStartPreview(z);
        m12553a();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        super.onInitCameraMode();
        this.f12952j = true;
        this.f12955m = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MICRO_GUIDE_ANIM_TYPE);
        sendBoradCastNotifyMicroscopeState(true);
        this.f12949g.m12597a(this.mActivity, this.mCameraInterface);
        this.f12956n = new TextView(this.mActivity);
        this.f12956n.setWillNotDraw(true);
        this.f12956n.setVisibility(4);
        this.mCameraUIInterface.mo18163b().addView(this.f12956n, new RelativeLayout.LayoutParams(this.mActivity.getResources().getDimensionPixelSize(R.dimen.microscope_hint_width), -2));
        this.f12951i = new View.OnClickListener() { // from class: com.oplus.camera.capmode.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MicroscopeVideoMode.this.mCameraUIInterface.mo18158av()) {
                    MicroscopeVideoMode.this.mCameraUIInterface.mo18108a(true, true, false);
                }
                if (MicroscopeVideoMode.this.f12952j) {
                    MicroscopeVideoMode.this.mCameraUIInterface.mo18090a(MicroscopeVideoMode.this.f12950h, true, MicroscopeVideoMode.this.f12954l);
                }
            }
        };
        this.f12950h = new MicroscopeHintView.InterfaceC3097a() { // from class: com.oplus.camera.capmode.p.2
            @Override // com.oplus.camera.p172ui.MicroscopeHintView.InterfaceC3097a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12549a() {
                if (MicroscopeVideoMode.this.mbCapModeInit) {
                    MicroscopeVideoMode.this.mCameraUIInterface.mo18085a(MicroscopeVideoMode.this.f12951i, false, false);
                }
            }

            @Override // com.oplus.camera.p172ui.MicroscopeHintView.InterfaceC3097a
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo12550b() {
                if (MicroscopeVideoMode.this.mbCapModeInit && !MicroscopeVideoMode.this.mCameraUIInterface.mo18057R() && !MicroscopeVideoMode.this.isVideoRecording()) {
                    MicroscopeVideoMode.this.mCameraUIInterface.mo18085a(MicroscopeVideoMode.this.f12951i, true, false);
                }
                MicroscopeVideoMode.this.mCameraUIInterface.mo18148al();
            }

            @Override // com.oplus.camera.p172ui.MicroscopeHintView.InterfaceC3097a
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo12551c() {
                if (MicroscopeVideoMode.this.mbCapModeInit && !MicroscopeVideoMode.this.mCameraUIInterface.mo18057R() && !MicroscopeVideoMode.this.isVideoRecording()) {
                    MicroscopeVideoMode.this.mCameraUIInterface.mo18085a(MicroscopeVideoMode.this.f12951i, true, false);
                }
                MicroscopeVideoMode.this.mCameraUIInterface.mo18148al();
            }
        };
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
        this.f12949g.m12596a(this.mActivity);
        this.mCameraUIInterface.mo18090a(this.f12950h, false, this.f12954l);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        super.onResume(z);
        this.f12949g.m12597a(this.mActivity, this.mCameraInterface);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        super.onDeInitCameraMode(str);
        this.f12952j = false;
        this.f12953k = false;
        this.mCameraUIInterface.mo18163b().removeView(this.f12956n);
        this.mCameraUIInterface.mo18090a(this.f12950h, false, this.f12954l);
        this.mCameraUIInterface.mo18085a(this.f12951i, false, false);
        sendBoradCastNotifyMicroscopeState(false);
        this.f12949g.m12596a(this.mActivity);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTouchFocus() {
        this.mCameraUIInterface.mo18070a(R.string.camera_hint_distance_microscope, -1, true, false, false);
        super.onTouchFocus();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11296A(true);
        zoomConfigure.m11333c(CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MICROSCOPE_ZOOM_SCALE_VALUE));
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        return "type_main_preview_frame".equals(str) && 3 == AlgoSwitchConfig.getApsVersion();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo shutterButtonInfo = super.getShutterButtonInfo();
        shutterButtonInfo.m19235c("button_shape_ring_none");
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h) {
        return getVideoPreviewSize(getVideoSizeType());
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public String getVideoSizeType() {
        return CameraConfig.getConfigStringValue(ConfigDataBase.KEY_MICROSCOPE_VIDEO_SIZE);
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected Size getVideoPreviewSize(String str) {
        Size sizeConfigValue = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_MICROSCOPE_VIDEO_PREVIEW_SIZE);
        return sizeConfigValue != null ? sizeConfigValue : super.getVideoPreviewSize(str);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        return getPreviewSize(c2698h);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public FilterTexturePreview.PlatformImplementations.kt_3 getFilterCategory() {
        return FilterTexturePreview.PlatformImplementations.kt_3.Anc;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected List<Integer> getFilterNameIdList(int OplusGLSurfaceView_13) {
        return FilterHelper.f21316f.f21250d;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected List<String> getFilterTypeList(int OplusGLSurfaceView_13) {
        return FilterHelper.f21316f.f21248b;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        super.beforeStartRecording();
        this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(5, "button_color_inside_red", "button_shape_ring_none", 1));
        this.mCameraUIInterface.mo18070a(R.string.camera_hint_steady_microscope, -1, false, false, true);
        if (this.mOneCamera != null) {
            if (this.mCameraInterface != null) {
                this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_ORIENTATION, (CaptureRequest.Key) Integer.valueOf((getJpegOrientation(this.mCameraId, this.mOrientation) + getOrientationRectify()) % 360));
            }
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        this.mCameraUIInterface.mo18090a(this.f12950h, false, this.f12954l);
        this.mCameraUIInterface.mo18085a(this.f12951i, false, false);
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void onStopVideoRecording(boolean z) {
        super.onStopVideoRecording(z);
        this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(6, "button_color_inside_red", "button_shape_ring_none", 1));
        this.mCameraUIInterface.mo18067a(R.string.camera_hint_steady_microscope);
        if (this.mPreferences.getBoolean(CameraUIInterface.KEY_MICROSCOPE_GUIDE_SHOW_NEED, true)) {
            this.mCameraUIInterface.mo18090a(this.f12950h, true, this.f12954l);
        } else {
            this.mCameraUIInterface.mo18085a(this.f12951i, true, false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        super.onMoreModeShown();
        this.mCameraUIInterface.mo18090a(this.f12950h, false, this.f12954l);
        this.mCameraUIInterface.mo18085a(this.f12951i, false, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        m12553a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12553a() throws Resources.NotFoundException {
        String string;
        if (this.f12953k) {
            if (this.mPreferences.getBoolean(CameraUIInterface.KEY_MICROSCOPE_GUIDE_SHOW_NEED, true)) {
                this.mCameraUIInterface.mo18090a(this.f12950h, true, this.f12954l);
                return;
            } else {
                this.mCameraUIInterface.mo18085a(this.f12951i, true, false);
                return;
            }
        }
        String string2 = this.mActivity.getResources().getString(R.string.camera_hint_microscope_step1);
        String string3 = this.mActivity.getResources().getString(R.string.camera_hint_microscope_step2);
        int OplusGLSurfaceView_13 = this.f12955m;
        if (OplusGLSurfaceView_13 == 0) {
            string = this.mActivity.getResources().getString(R.string.camera_hint_microscope_step2);
        } else {
            string = OplusGLSurfaceView_13 != 1 ? string3 : this.mActivity.getResources().getString(R.string.camera_hint_microscope_step2_lift_head);
        }
        TextView textView = this.f12956n;
        if (string2.length() <= string.length()) {
            string2 = string;
        }
        textView.setText(string2);
        this.f12956n.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.capmode.p.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                MicroscopeVideoMode c2662p = MicroscopeVideoMode.this;
                c2662p.f12954l = c2662p.f12956n.getHeight();
                MicroscopeVideoMode.this.f12953k = true;
                if (MicroscopeVideoMode.this.mPreferences.getBoolean(CameraUIInterface.KEY_MICROSCOPE_GUIDE_SHOW_NEED, true)) {
                    MicroscopeVideoMode.this.mCameraUIInterface.mo18090a(MicroscopeVideoMode.this.f12950h, true, MicroscopeVideoMode.this.f12954l);
                } else {
                    MicroscopeVideoMode.this.mCameraUIInterface.mo18085a(MicroscopeVideoMode.this.f12951i, true, false);
                }
                MicroscopeVideoMode.this.f12956n.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
}

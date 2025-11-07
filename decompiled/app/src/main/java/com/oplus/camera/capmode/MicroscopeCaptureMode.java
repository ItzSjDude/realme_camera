package com.oplus.camera.capmode;

import android.app.Activity;
import android.content.res.Resources;
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
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.MicroscopeHintView;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.FilterTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;
import java.util.List;

/* compiled from: MicroscopeCaptureMode.java */
/* renamed from: com.oplus.camera.capmode.o */
/* loaded from: classes2.dex */
public class MicroscopeCaptureMode extends CommonCapMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f12938g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f12939h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f12940i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f12941j;

    /* renamed from: OplusGLSurfaceView_5 */
    private SensorHelper f12942k;

    /* renamed from: OplusGLSurfaceView_14 */
    private MicroscopeHintView.InterfaceC3097a f12943l;

    /* renamed from: OplusGLSurfaceView_6 */
    private View.OnClickListener f12944m;

    /* renamed from: OplusGLSurfaceView_11 */
    private TextView f12945n;

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_MICROSCOPE;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        return CameraUIInterface.KEY_FILTER_ANC_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getFilterTitleTexId() {
        return R.string.camera_filter_effect;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getFlashMode() {
        return CameraParameter.FlashMode.FLASH_TORCH;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean isFirstTipsEnable(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isMicroscopeMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean isSalientObjectDetectionEnabled() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onLongPress(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean withinSatMainRange(float COUIBaseListPopupWindow_12) {
        return true;
    }

    public MicroscopeCaptureMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f12938g = false;
        this.f12939h = false;
        this.f12940i = 0;
        this.f12941j = 0;
        this.f12942k = new SensorHelper();
        this.f12943l = null;
        this.f12944m = null;
        this.f12945n = null;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        return "type_preview_frame".equals(str) ? 3 == AlgoSwitchConfig.getApsVersion() : "type_still_capture_yuv_main".equals(str) || "type_capture".equals(str);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(str) || CameraUIInterface.KEY_FILTER_MENU.equals(str)) {
            return getSupportFunction(str);
        }
        return super.getSupportMenu(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010e  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.MicroscopeCaptureMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) throws Resources.NotFoundException {
        super.onAfterStartPreview(z);
        m12542a();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        super.onInitCameraMode();
        this.f12938g = true;
        this.f12941j = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MICRO_GUIDE_ANIM_TYPE);
        sendBoradCastNotifyMicroscopeState(true);
        this.f12942k.m12597a(this.mActivity, this.mCameraInterface);
        this.f12945n = new TextView(this.mActivity);
        this.f12945n.setWillNotDraw(true);
        this.f12945n.setVisibility(4);
        this.mCameraUIInterface.mo18163b().addView(this.f12945n, new RelativeLayout.LayoutParams(this.mActivity.getResources().getDimensionPixelSize(R.dimen.microscope_hint_width), -2));
        this.f12944m = new View.OnClickListener() { // from class: com.oplus.camera.capmode.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MicroscopeCaptureMode.this.mCameraUIInterface.mo18158av()) {
                    MicroscopeCaptureMode.this.mCameraUIInterface.mo18108a(true, true, false);
                }
                if (MicroscopeCaptureMode.this.f12938g) {
                    MicroscopeCaptureMode.this.mCameraUIInterface.mo18090a(MicroscopeCaptureMode.this.f12943l, true, MicroscopeCaptureMode.this.f12940i);
                }
            }
        };
        this.f12943l = new MicroscopeHintView.InterfaceC3097a() { // from class: com.oplus.camera.capmode.o.2
            @Override // com.oplus.camera.p172ui.MicroscopeHintView.InterfaceC3097a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12549a() {
                if (MicroscopeCaptureMode.this.mbCapModeInit) {
                    MicroscopeCaptureMode.this.mCameraUIInterface.mo18085a(MicroscopeCaptureMode.this.f12944m, false, true);
                }
            }

            @Override // com.oplus.camera.p172ui.MicroscopeHintView.InterfaceC3097a
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo12550b() {
                if (MicroscopeCaptureMode.this.mbCapModeInit && !MicroscopeCaptureMode.this.mCameraUIInterface.mo18057R()) {
                    MicroscopeCaptureMode.this.mCameraUIInterface.mo18085a(MicroscopeCaptureMode.this.f12944m, true, true);
                }
                MicroscopeCaptureMode.this.mCameraUIInterface.mo18148al();
            }

            @Override // com.oplus.camera.p172ui.MicroscopeHintView.InterfaceC3097a
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo12551c() {
                if (MicroscopeCaptureMode.this.mbCapModeInit && !MicroscopeCaptureMode.this.mCameraUIInterface.mo18057R()) {
                    MicroscopeCaptureMode.this.mCameraUIInterface.mo18085a(MicroscopeCaptureMode.this.f12944m, true, true);
                }
                MicroscopeCaptureMode.this.mCameraUIInterface.mo18148al();
            }
        };
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
        this.f12942k.m12596a(this.mActivity);
        this.mCameraUIInterface.mo18090a(this.f12943l, false, this.f12940i);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        super.onResume(z);
        this.f12942k.m12597a(this.mActivity, this.mCameraInterface);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        super.onDeInitCameraMode(str);
        this.f12938g = false;
        this.f12939h = false;
        this.mCameraUIInterface.mo18163b().removeView(this.f12945n);
        this.mCameraUIInterface.mo18090a(this.f12943l, false, this.f12940i);
        this.mCameraUIInterface.mo18085a(this.f12944m, false, true);
        sendBoradCastNotifyMicroscopeState(false);
        this.f12942k.m12596a(this.mActivity);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTouchFocus() {
        if (!this.mCameraUIInterface.mo18127aQ()) {
            this.mCameraUIInterface.mo18070a(R.string.camera_hint_distance_microscope, -1, true, false, false);
        }
        super.onTouchFocus();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11296A(true);
        zoomConfigure.m11333c(CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MICROSCOPE_ZOOM_SCALE_VALUE));
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo shutterButtonInfo = super.getShutterButtonInfo();
        shutterButtonInfo.m19235c("button_shape_ring_none");
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        return Util.m24378b(c2698h.m13258a(256), "standard".equals(CameraConfig.getConfigStringValue(ConfigDataBase.KEY_MICRO_PICTURE_SIZE_RATIO)) ? 1.3333333333333333d : 1.0d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public FilterTexturePreview.PlatformImplementations.kt_3 getFilterCategory() {
        return FilterTexturePreview.PlatformImplementations.kt_3.Anc;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected List<Integer> getFilterNameIdList(int OplusGLSurfaceView_13) {
        return FilterHelper.f21316f.f21250d;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected List<String> getFilterTypeList(int OplusGLSurfaceView_13) {
        return FilterHelper.f21316f.f21248b;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        super.onMoreModeShown();
        this.mCameraUIInterface.mo18090a(this.f12943l, false, this.f12940i);
        this.mCameraUIInterface.mo18085a(this.f12944m, false, true);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        m12542a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12542a() throws Resources.NotFoundException {
        String string;
        if (this.f12939h) {
            if (this.mPreferences.getBoolean(CameraUIInterface.KEY_MICROSCOPE_GUIDE_SHOW_NEED, true)) {
                this.mCameraUIInterface.mo18090a(this.f12943l, true, this.f12940i);
                return;
            } else {
                this.mCameraUIInterface.mo18085a(this.f12944m, true, true);
                return;
            }
        }
        String string2 = this.mActivity.getResources().getString(R.string.camera_hint_microscope_step1);
        String string3 = this.mActivity.getResources().getString(R.string.camera_hint_microscope_step2);
        int OplusGLSurfaceView_13 = this.f12941j;
        if (OplusGLSurfaceView_13 == 0) {
            string = this.mActivity.getResources().getString(R.string.camera_hint_microscope_step2);
        } else {
            string = OplusGLSurfaceView_13 != 1 ? string3 : this.mActivity.getResources().getString(R.string.camera_hint_microscope_step2_lift_head);
        }
        TextView textView = this.f12945n;
        if (string2.length() <= string.length()) {
            string2 = string;
        }
        textView.setText(string2);
        this.f12945n.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.capmode.o.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                MicroscopeCaptureMode c2661o = MicroscopeCaptureMode.this;
                c2661o.f12940i = c2661o.f12945n.getHeight();
                MicroscopeCaptureMode.this.f12939h = true;
                if (MicroscopeCaptureMode.this.mPreferences.getBoolean(CameraUIInterface.KEY_MICROSCOPE_GUIDE_SHOW_NEED, true)) {
                    MicroscopeCaptureMode.this.mCameraUIInterface.mo18090a(MicroscopeCaptureMode.this.f12943l, true, MicroscopeCaptureMode.this.f12940i);
                } else {
                    MicroscopeCaptureMode.this.mCameraUIInterface.mo18085a(MicroscopeCaptureMode.this.f12944m, true, true);
                }
                MicroscopeCaptureMode.this.f12945n.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        boolean zOnBeforeSnapping = super.onBeforeSnapping(c2693c);
        this.mbCheckTakeAnimateDelay = false;
        return zOnBeforeSnapping;
    }
}

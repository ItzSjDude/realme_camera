package com.oplus.camera.tiltshift;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Size;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.capmode.CommonCapMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.ocs.camera.CameraParameter;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class TiltShiftPhotoMode extends CommonCapMode {
    private static final String TAG = "TiltShiftPhotoMode";

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_TILT_SHIFT;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        return CameraUIInterface.KEY_TILT_SHIFT_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isShowUltraWide() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isTiltShiftSupportBeauty() {
        return true;
    }

    public TiltShiftPhotoMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
    }

    private String getApsCaptureMode() {
        return super.getCameraMode();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_SETTING.equals(str) || CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return true;
        }
        if (CameraUIInterface.KEY_SUB_SETTING.equals(str) || CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            return getSupportFunction(str);
        }
        return super.getSupportMenu(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b9  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.tiltshift.TiltShiftPhotoMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isTiltShiftOpen() {
        return getSupportFunction(CameraFunction.TILT_SHIFT);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        super.onBeforePreview();
        this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.TILT_SHIFT_ENABLE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(isTiltShiftOpen()));
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void updateCaptureParam(CameraRequestTag c2693c) throws Resources.NotFoundException {
        TiltShiftParam tiltShiftParamMo10511aM;
        super.updateCaptureParam(c2693c);
        if (this.mCameraInterface == null || (tiltShiftParamMo10511aM = this.mCameraInterface.mo10511aM()) == null) {
            return;
        }
        String string = Arrays.toString(new float[]{tiltShiftParamMo10511aM.getCenterX(), tiltShiftParamMo10511aM.getCenterY()});
        int OplusGLSurfaceView_13 = !tiltShiftParamMo10511aM.isCircle() ? 1 : 0;
        Size previewSize = tiltShiftParamMo10511aM.getPreviewSize();
        String string2 = Arrays.toString(new int[]{previewSize.getWidth(), previewSize.getHeight()});
        Bundle bundle = new Bundle();
        bundle.putString(CameraParameter.TiltShiftParamKeys.PREVIEW_SIZE, string2);
        bundle.putInt(CameraParameter.TiltShiftParamKeys.BLUR_VALUE, getTiltShiftBlurIndex());
        bundle.putString(CameraParameter.TiltShiftParamKeys.TYPE, String.valueOf(OplusGLSurfaceView_13));
        bundle.putString(CameraParameter.TiltShiftParamKeys.CENTER_POSITION, string);
        bundle.putString(CameraParameter.TiltShiftParamKeys.CLEAR_DISTANCE, String.valueOf(tiltShiftParamMo10511aM.getInnerDistance()));
        bundle.putString(CameraParameter.TiltShiftParamKeys.ROTATE_ANGLE, String.valueOf(tiltShiftParamMo10511aM.getAngle()));
        this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Bundle>>) CameraParameter.TILT_SHIFT_PARAM, (CameraParameter.PreviewKey<Bundle>) bundle);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        boolean zOnBeforeSnapping = super.onBeforeSnapping(c2693c);
        this.mbCheckTakeAnimateDelay = false;
        return zOnBeforeSnapping;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected List<Integer> getFilterNameIdList(int OplusGLSurfaceView_13) {
        if (!getSupportFunction(CameraUIInterface.KEY_PHOTO_MONO_FILTER)) {
            return FilterHelper.f21325o.m22566b(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
        }
        return super.getFilterNameIdList(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected List<String> getFilterTypeList(int OplusGLSurfaceView_13) {
        if (!getSupportFunction(CameraUIInterface.KEY_PHOTO_MONO_FILTER)) {
            return FilterHelper.f21325o.m22561a(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
        }
        return super.getFilterTypeList(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isBlurOpen() {
        return getSupportFunction(CameraFunction.TILT_SHIFT);
    }
}

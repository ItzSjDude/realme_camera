package com.oplus.camera.p136a;

import android.graphics.PointF;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Size;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.constant.CameraUnitKeys;
import com.oplus.camera.aps.service.ThumbnailCategory;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p171u.DetectResult;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.FocusAimMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: CaptureMsgDataReportUtil.java */
/* renamed from: com.oplus.camera.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class CaptureMsgDataReportUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static CaptureMsgData m11160a(CaptureMsgData captureMsgData, ThumbnailCategory thumbnailCategory) {
        if (captureMsgData == null || thumbnailCategory == null) {
            CameraLog.m12954a("CaptureMsgDataReportUtil", "packageFromThumbnail, captureMsgData or category is null");
            return null;
        }
        captureMsgData.mHeight = String.valueOf(thumbnailCategory.mPictureResult.get(CameraParameter.IMAGE_CATEGORY_HEIGHT));
        captureMsgData.mWidth = String.valueOf(thumbnailCategory.mPictureResult.get(CameraParameter.IMAGE_CATEGORY_WIDTH));
        if (((Boolean) thumbnailCategory.mPictureResult.get(CameraParameter.IMAGE_CATEGORY_BURST_SHOT)).booleanValue()) {
            captureMsgData.mBurstCount = ((Integer) thumbnailCategory.mPictureResult.get(CameraParameter.IMAGE_CATEGORY_BURST_COUNT)).intValue();
        }
        if (thumbnailCategory.mPictureResult.get(CameraParameter.IMAGE_CATEGORY_CUSTOM_BEAUTY_PARAM) != null) {
            captureMsgData.parseFaceBeauty(Util.m24401b((int[]) thumbnailCategory.mPictureResult.get(CameraParameter.IMAGE_CATEGORY_CUSTOM_BEAUTY_PARAM)));
        }
        captureMsgData.mFilePath = m11165a(thumbnailCategory);
        return captureMsgData;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m11167a(String str) {
        CameraLog.m12954a("CaptureMsgDataReportUtil", "getFlashTriggerStatus, flashMode: " + str);
        return CameraParameter.FlashMode.FLASH_TORCH.equals(str) ? FocusAimMsgData.KEY_MULTI_VIDEO_SWITCH_SCREEN_FOCUS_TYPE : "16";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static CaptureMsgData m11159a(CaptureMsgData captureMsgData, Storage.CameraPicture cameraPicture) throws IOException {
        if (captureMsgData == null || cameraPicture == null) {
            CameraLog.m12954a("CaptureMsgDataReportUtil", "packageFromThumbnail, captureMsgData or picture is null");
            return null;
        }
        ExifInterface exifInterfaceM24231a = Util.m24231a(cameraPicture.f12132e);
        if (exifInterfaceM24231a == null) {
            return captureMsgData;
        }
        captureMsgData.mFlashTrigger = exifInterfaceM24231a.getAttribute("Flash");
        return captureMsgData;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0275 -> B:167:0x0278). Please report as PlatformImplementations.kt_3 decompilation issue!!! */
    /* renamed from: PlatformImplementations.kt_3 */
    public static CaptureMsgData m11158a(CaptureMsgData captureMsgData, CaptureResult captureResult, CameraRequestTag c2693c, DetectResult c3077a, Size size, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        CaptureResult.Key<int[]> key;
        Object obj;
        int[] iArr;
        int i2;
        float COUIBaseListPopupWindow_12;
        int i3;
        if (captureMsgData == null || captureResult == null || c2693c == null) {
            CameraLog.m12954a("CaptureMsgDataReportUtil", "packageFromCaptureResult, captureMsgData or captureResult or request is null");
            return null;
        }
        try {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL) || -1 == OplusGLSurfaceView_13 || -1 == OplusGLSurfaceView_15) {
                captureMsgData.mISO = (((Integer) captureResult.get(CaptureResult.SENSOR_SENSITIVITY)).intValue() * ((Integer) captureResult.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST)).intValue()) / 100;
                captureMsgData.mEXP = ((Long) captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME)).longValue();
            } else {
                captureMsgData.mISO = OplusGLSurfaceView_13;
                captureMsgData.mEXP = OplusGLSurfaceView_15;
            }
            captureMsgData.mFocalLength = String.valueOf(captureResult.get(CaptureResult.LENS_FOCAL_LENGTH));
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        if (Util.m24169C()) {
            key = CameraMetadataKey.f13254T;
            obj = CameraMetadataKey.f13255U;
        } else {
            key = CameraMetadataKey.f13295ah;
            obj = CameraMetadataKey.f13257W;
        }
        if (key != null) {
            try {
                iArr = (int[]) captureResult.get(key);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (iArr != null && iArr.length > 0) {
                i2 = iArr[0];
            } else {
                CameraLog.m12954a("CaptureMsgDataReportUtil", "packageFromCaptureResult,  cct value: " + iArr);
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        float f2 = 0.0f;
        if (obj != null) {
            try {
                if (Util.m24169C()) {
                    float[] fArr = (float[]) captureResult.get(obj);
                    if (fArr != null && fArr.length > 0) {
                        COUIBaseListPopupWindow_12 = fArr[0];
                    } else {
                        CameraLog.m12954a("CaptureMsgDataReportUtil", "onPreviewCaptureResult, lux value: " + Arrays.toString(fArr));
                        float[] fArr2 = (float[]) captureResult.get(CameraMetadataKey.f13256V);
                        if (fArr2 != null && fArr2.length > 0) {
                            COUIBaseListPopupWindow_12 = fArr2[0];
                        } else {
                            CameraLog.m12954a("CaptureMsgDataReportUtil", "onPreviewCaptureResult, luxForData value: " + Arrays.toString(fArr2));
                        }
                    }
                    f2 = COUIBaseListPopupWindow_12;
                } else {
                    int[] iArr2 = (int[]) captureResult.get(obj);
                    if (iArr2 != null && iArr2.length > 0) {
                        f2 = iArr2[0];
                    } else {
                        CameraLog.m12954a("CaptureMsgDataReportUtil", "onPreviewCaptureResult, key: " + obj + ", luxIntValues: " + Arrays.toString(iArr2));
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        captureMsgData.mCCT = String.valueOf(i2);
        captureMsgData.mLux = String.valueOf(f2);
        captureMsgData.mIsLaserDirty = m11163a(captureResult, CameraMetadataKey.f13342bw, false);
        if (!TextUtils.isEmpty(captureMsgData.mIsLaserDirty)) {
            captureMsgData.mSgwBGRatio = m11162a(captureResult, CameraMetadataKey.f13332bm, 0);
            captureMsgData.mSgwRGRatio = m11162a(captureResult, CameraMetadataKey.f13331bl, 0);
            captureMsgData.mDrcGain = m11162a(captureResult, CameraMetadataKey.f13335bp, 0);
            captureMsgData.mIsAisNeed = m11161a(captureResult, CameraMetadataKey.f13338bs);
            captureMsgData.mAisMotionType = m11161a(captureResult, CameraMetadataKey.f13337br);
            captureMsgData.mFocusROIType = m11161a(captureResult, CameraMetadataKey.f13339bt);
            captureMsgData.mGyroSqrt = m11162a(captureResult, CameraMetadataKey.f13336bq, 0);
            captureMsgData.mFocusState = m11163a(captureResult, (CaptureResult.Key<Integer>) CaptureResult.CONTROL_AF_STATE, true);
            captureMsgData.mAecSettle = m11163a(captureResult, (CaptureResult.Key<Integer>) CaptureResult.CONTROL_AE_STATE, true);
            captureMsgData.mFlickerDetectResult = m11163a(captureResult, (CaptureResult.Key<Integer>) CaptureResult.STATISTICS_SCENE_FLICKER, true);
            captureMsgData.mFocusMethodType = m11161a(captureResult, CameraMetadataKey.f13340bu);
            captureMsgData.mSensorCCT = m11162a(captureResult, CameraMetadataKey.f13334bo, 0);
            captureMsgData.mFocusTimeCost = m11161a(captureResult, CameraMetadataKey.f13341bv);
            captureMsgData.mSharpnessStd = m11162a(captureResult, CameraMetadataKey.f13343bx, 1);
            try {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
                if (num != null) {
                    captureMsgData.mTouchEVValue = num.intValue();
                } else {
                    CameraLog.m12954a("CaptureMsgDataReportUtil", "packageFromCaptureResult,  mTouchEVValue is null");
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            try {
                float[] fArr3 = (float[]) captureResult.get(CameraMetadataKey.f13333bn);
                if (fArr3 != null && fArr3.length > 1) {
                    captureMsgData.mFinalAWBDecision_rg = String.valueOf(fArr3[0]);
                    captureMsgData.mFinalAWBDecision_bg = String.valueOf(fArr3[1]);
                } else {
                    CameraLog.m12954a("CaptureMsgDataReportUtil", "packageFromCaptureResult, key:" + CameraMetadataKey.f13333bn + "value: " + Arrays.toString(fArr3));
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            try {
                MeteringRectangle[] meteringRectangleArr = (MeteringRectangle[]) captureResult.get(CaptureResult.CONTROL_AF_REGIONS);
                if (meteringRectangleArr != null && meteringRectangleArr.length > 0) {
                    MeteringRectangle meteringRectangle = meteringRectangleArr[0];
                    captureMsgData.mFocusRegion = meteringRectangle.getX() + "*" + meteringRectangle.getY() + "*" + meteringRectangle.getWidth() + "*" + meteringRectangle.getHeight();
                } else {
                    CameraLog.m12954a("CaptureMsgDataReportUtil", "packageFromCaptureResult, key:" + CaptureResult.CONTROL_AF_REGIONS + "value: " + Arrays.toString(meteringRectangleArr));
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        captureMsgData.mFocusDistance = String.valueOf(captureResult.get(CaptureResult.LENS_FOCUS_DISTANCE));
        if (c2693c == null) {
            CameraLog.m12954a("CaptureMsgDataReportUtil", "packageFromCaptureResult, requestTag is null");
            return null;
        }
        if (c2693c.f13383L != null) {
            int[] iArr3 = c2693c.f13383L;
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < iArr3.length; i4++) {
                sb.append(iArr3[i4]);
                if (i4 != iArr3.length - 1) {
                    sb.append("*");
                }
            }
            captureMsgData.mHdrEVList = sb.toString();
        }
        captureMsgData.mCaptureMode = c2693c.f13372A;
        captureMsgData.mCameraId = c2693c.f13373B;
        captureMsgData.mOrientation = c2693c.f13381J;
        captureMsgData.mTouchXYValue = c2693c.f13378G;
        captureMsgData.mTouchXYEVValue = c2693c.f13379H;
        captureMsgData.mIsWideAngle = c2693c.f13380I;
        captureMsgData.mHdrMode = c2693c.f13374C;
        captureMsgData.mbHdrTrigger = String.valueOf(c2693c.f13375D);
        captureMsgData.mAeAfLock = String.valueOf(c2693c.f13377F);
        captureMsgData.mShutterType = c2693c.f13376E;
        if ("portrait".equals(c2693c.f13372A)) {
            captureMsgData.mPortraitNewStyleType = c2693c.f13414i;
        } else if (ApsConstant.CAPTURE_MODE_COMMON.equals(c2693c.f13372A)) {
            captureMsgData.mFilterType = c2693c.f13414i;
            captureMsgData.mSCPEnable = c2693c.f13388Q ? "on" : "off";
        } else if (ApsConstant.CAPTURE_MODE_MICROSCOPE.equals(c2693c.f13372A) || ApsConstant.REC_MODE_MICROSCOPE.equals(c2693c.f13372A)) {
            captureMsgData.mAncFilterType = c2693c.f13414i;
        } else if (ApsConstant.CAPTURE_MODE_NIGHT.equals(c2693c.f13372A)) {
            captureMsgData.mNightStyleType = c2693c.f13414i;
        }
        captureMsgData.mSmooth = c2693c.f13407b ? 102 : 0;
        if (c2693c.f13387P != 0) {
            i3 = c2693c.f13387P;
        } else {
            i3 = c2693c.f13386O;
        }
        captureMsgData.mAiScene = i3;
        if (c2693c.f13409d != null || c2693c.f13412g || Util.m24302a(c2693c.f13382K, CameraUnitKeys.ALGO_NAME_BOKEH) || Util.m24302a(c2693c.f13382K, CameraUnitKeys.ALGO_NAME_FRONT_BOKEH)) {
            captureMsgData.mBlurLevel = c2693c.f13389R;
        }
        if (c3077a != null) {
            captureMsgData.mTextSize = m11166a(c3077a, size);
        }
        if (!Util.m24169C()) {
            Object objM13005a = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13293af);
            if (objM13005a != null && (objM13005a instanceof int[])) {
                int[] iArr4 = (int[]) objM13005a;
                if (iArr4.length > 0) {
                    CameraLog.m12954a("CaptureMsgDataReportUtil", "packageFromCaptureResult, beautyLevel: " + iArr4[0]);
                    captureMsgData.mSmooth = iArr4[0];
                }
            }
            Object objM13005a2 = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13294ag);
            if (objM13005a2 != null && (objM13005a2 instanceof int[])) {
                int[] iArrM24401b = Util.m24401b((int[]) objM13005a2);
                if (iArrM24401b.length > 0) {
                    CameraLog.m12954a("CaptureMsgDataReportUtil", "packageFromCaptureResult, customBeautyParam.length: " + iArrM24401b.length);
                    captureMsgData.parseFaceBeauty(iArrM24401b);
                }
            }
        }
        return captureMsgData;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m11163a(CaptureResult captureResult, CaptureResult.Key<Integer> key, boolean z) {
        try {
            Object obj = captureResult.get(key);
            return obj != null ? String.valueOf(obj) : "";
        } catch (Exception COUIBaseListPopupWindow_8) {
            if (!z) {
                return "";
            }
            COUIBaseListPopupWindow_8.printStackTrace();
            return "";
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m11162a(CaptureResult captureResult, CaptureResult.Key<float[]> key, int OplusGLSurfaceView_13) {
        String strValueOf = "";
        try {
            float[] fArr = (float[]) captureResult.get(key);
            if (fArr != null && fArr.length > OplusGLSurfaceView_13) {
                strValueOf = String.valueOf(fArr[OplusGLSurfaceView_13]);
            } else {
                CameraLog.m12954a("CaptureMsgDataReportUtil", "packageFromCaptureResult,  key:" + key + " value: " + Arrays.toString(fArr));
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return strValueOf;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m11161a(CaptureResult captureResult, CaptureResult.Key<int[]> key) {
        String strValueOf = "";
        try {
            int[] iArr = (int[]) captureResult.get(key);
            if (iArr != null && iArr.length > 0) {
                strValueOf = String.valueOf(iArr[0]);
            } else {
                CameraLog.m12954a("CaptureMsgDataReportUtil", "packageFromCaptureResult, key: " + key + " value: " + Arrays.toString(iArr));
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return strValueOf;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m11165a(ThumbnailCategory thumbnailCategory) {
        String str;
        if (thumbnailCategory == null || thumbnailCategory.mPictureResult == null || thumbnailCategory.mThumbnailItem == null) {
            return null;
        }
        if (thumbnailCategory.mThumbnailItem.mJpegName == null && ((Long) thumbnailCategory.mPictureResult.get(CameraParameter.IMAGE_CATEGORY_BURST_SHOT_FLAG_ID)).longValue() == -1) {
            return null;
        }
        String str2 = ("heic_8bits".equalsIgnoreCase(thumbnailCategory.mThumbnailItem.mPictureFormat) || "heic_10bits".equalsIgnoreCase(thumbnailCategory.mThumbnailItem.mPictureFormat)) ? ".heic" : ".jpg";
        if ("off".equals(Storage.f12095u)) {
            str = Storage.f12089o;
        } else {
            str = Storage.f12084j;
        }
        if (((Long) thumbnailCategory.mPictureResult.get(CameraParameter.IMAGE_CATEGORY_BURST_SHOT_FLAG_ID)).longValue() > -1) {
            return (String) thumbnailCategory.mPictureResult.get(CameraParameter.IMAGE_CATEGORY_CSHOT_PATH);
        }
        return str + File.separator + thumbnailCategory.mThumbnailItem.mJpegName + str2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m11164a(Storage.CameraPicture cameraPicture) {
        String str;
        String str2;
        String strM24380b;
        if (cameraPicture == null || cameraPicture.f12139l == 0) {
            return null;
        }
        if ("off".equals(Storage.f12095u)) {
            str = Storage.f12089o;
        } else {
            str = Storage.f12084j;
        }
        String str3 = cameraPicture.f12135h;
        if ("raw".equalsIgnoreCase(str3)) {
            str2 = ".dng";
        } else {
            str2 = ("heic_8bits".equalsIgnoreCase(str3) || "heic_10bits".equalsIgnoreCase(str3)) ? ".heic" : ".jpg";
        }
        if (cameraPicture.f12141n > -1 && cameraPicture.f12134g != null) {
            strM24380b = cameraPicture.f12134g;
        } else {
            strM24380b = Util.m24380b(cameraPicture.f12139l);
        }
        if (cameraPicture.f12140m > -1) {
            return cameraPicture.f12138k;
        }
        return str + File.separator + strM24380b + str2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m11166a(DetectResult c3077a, Size size) {
        if (c3077a == null || !c3077a.m17956c() || size == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (PointF pointF : c3077a.m17955b()) {
            sb.append((int) (pointF.x * size.getWidth()));
            sb.append("x");
            sb.append((int) (pointF.y * size.getHeight()));
            sb.append("-");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}

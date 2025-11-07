package com.oplus.camera.a_renamed;

/* compiled from: CaptureMsgDataReportUtil.java */
/* loaded from: classes2.dex */
public class a_renamed {
    public static com.oplus.camera.statistics.model.CaptureMsgData a_renamed(com.oplus.camera.statistics.model.CaptureMsgData captureMsgData, com.oplus.camera.aps.service.ThumbnailCategory thumbnailCategory) {
        if (captureMsgData == null || thumbnailCategory == null) {
            com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "packageFromThumbnail, captureMsgData or category is_renamed null");
            return null;
        }
        captureMsgData.mHeight = java.lang.String.valueOf(thumbnailCategory.mPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_HEIGHT));
        captureMsgData.mWidth = java.lang.String.valueOf(thumbnailCategory.mPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_WIDTH));
        if (((java.lang.Boolean) thumbnailCategory.mPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_BURST_SHOT)).booleanValue()) {
            captureMsgData.mBurstCount = ((java.lang.Integer) thumbnailCategory.mPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_BURST_COUNT)).intValue();
        }
        if (thumbnailCategory.mPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_CUSTOM_BEAUTY_PARAM) != null) {
            captureMsgData.parseFaceBeauty(com.oplus.camera.util.Util.b_renamed((int[]) thumbnailCategory.mPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_CUSTOM_BEAUTY_PARAM)));
        }
        captureMsgData.mFilePath = a_renamed(thumbnailCategory);
        return captureMsgData;
    }

    public static java.lang.String a_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "getFlashTriggerStatus, flashMode: " + str);
        return com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH.equals(str) ? com.oplus.camera.statistics.model.FocusAimMsgData.KEY_MULTI_VIDEO_SWITCH_SCREEN_FOCUS_TYPE : "16";
    }

    public static com.oplus.camera.statistics.model.CaptureMsgData a_renamed(com.oplus.camera.statistics.model.CaptureMsgData captureMsgData, com.oplus.camera.Storage.CameraPicture cameraPicture) throws java.io.IOException {
        if (captureMsgData == null || cameraPicture == null) {
            com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "packageFromThumbnail, captureMsgData or picture is_renamed null");
            return null;
        }
        android.media.ExifInterface exifInterfaceA = com.oplus.camera.util.Util.a_renamed(cameraPicture.e_renamed);
        if (exifInterfaceA == null) {
            return captureMsgData;
        }
        captureMsgData.mFlashTrigger = exifInterfaceA.getAttribute("Flash");
        return captureMsgData;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B_renamed:88:0x0275 -> B_renamed:167:0x0278). Please report as_renamed a_renamed decompilation issue!!! */
    public static com.oplus.camera.statistics.model.CaptureMsgData a_renamed(com.oplus.camera.statistics.model.CaptureMsgData captureMsgData, android.hardware.camera2.CaptureResult captureResult, com.oplus.camera.e_renamed.c_renamed cVar, com.oplus.camera.u_renamed.a_renamed aVar, android.util.Size size, int i_renamed, long j_renamed) {
        android.hardware.camera2.CaptureResult.Key<int[]> key;
        java.lang.Object obj;
        int[] iArr;
        int i2;
        float f_renamed;
        int i3;
        if (captureMsgData == null || captureResult == null || cVar == null) {
            com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "packageFromCaptureResult, captureMsgData or captureResult or request is_renamed null");
            return null;
        }
        try {
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL) || -1 == i_renamed || -1 == j_renamed) {
                captureMsgData.mISO = (((java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.SENSOR_SENSITIVITY)).intValue() * ((java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST)).intValue()) / 100;
                captureMsgData.mEXP = ((java.lang.Long) captureResult.get(android.hardware.camera2.CaptureResult.SENSOR_EXPOSURE_TIME)).longValue();
            } else {
                captureMsgData.mISO = i_renamed;
                captureMsgData.mEXP = j_renamed;
            }
            captureMsgData.mFocalLength = java.lang.String.valueOf(captureResult.get(android.hardware.camera2.CaptureResult.LENS_FOCAL_LENGTH));
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        if (com.oplus.camera.util.Util.C_renamed()) {
            key = com.oplus.camera.e_renamed.b_renamed.T_renamed;
            obj = com.oplus.camera.e_renamed.b_renamed.U_renamed;
        } else {
            key = com.oplus.camera.e_renamed.b_renamed.ah_renamed;
            obj = com.oplus.camera.e_renamed.b_renamed.W_renamed;
        }
        if (key != null) {
            try {
                iArr = (int[]) captureResult.get(key);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
            if (iArr != null && iArr.length > 0) {
                i2 = iArr[0];
            } else {
                com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "packageFromCaptureResult,  cct value: " + iArr);
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        float f2 = 0.0f;
        if (obj != null) {
            try {
                if (com.oplus.camera.util.Util.C_renamed()) {
                    float[] fArr = (float[]) captureResult.get(obj);
                    if (fArr != null && fArr.length > 0) {
                        f_renamed = fArr[0];
                    } else {
                        com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "onPreviewCaptureResult, lux value: " + java.util.Arrays.toString(fArr));
                        float[] fArr2 = (float[]) captureResult.get(com.oplus.camera.e_renamed.b_renamed.V_renamed);
                        if (fArr2 != null && fArr2.length > 0) {
                            f_renamed = fArr2[0];
                        } else {
                            com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "onPreviewCaptureResult, luxForData value: " + java.util.Arrays.toString(fArr2));
                        }
                    }
                    f2 = f_renamed;
                } else {
                    int[] iArr2 = (int[]) captureResult.get(obj);
                    if (iArr2 != null && iArr2.length > 0) {
                        f2 = iArr2[0];
                    } else {
                        com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "onPreviewCaptureResult, key: " + obj + ", luxIntValues: " + java.util.Arrays.toString(iArr2));
                    }
                }
            } catch (java.lang.Exception e3) {
                e3.printStackTrace();
            }
        }
        captureMsgData.mCCT = java.lang.String.valueOf(i2);
        captureMsgData.mLux = java.lang.String.valueOf(f2);
        captureMsgData.mIsLaserDirty = a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.bw_renamed, false);
        if (!android.text.TextUtils.isEmpty(captureMsgData.mIsLaserDirty)) {
            captureMsgData.mSgwBGRatio = a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.bm_renamed, 0);
            captureMsgData.mSgwRGRatio = a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.bl_renamed, 0);
            captureMsgData.mDrcGain = a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.bp_renamed, 0);
            captureMsgData.mIsAisNeed = a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.bs_renamed);
            captureMsgData.mAisMotionType = a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.br_renamed);
            captureMsgData.mFocusROIType = a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.bt_renamed);
            captureMsgData.mGyroSqrt = a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.bq_renamed, 0);
            captureMsgData.mFocusState = a_renamed(captureResult, (android.hardware.camera2.CaptureResult.Key<java.lang.Integer>) android.hardware.camera2.CaptureResult.CONTROL_AF_STATE, true);
            captureMsgData.mAecSettle = a_renamed(captureResult, (android.hardware.camera2.CaptureResult.Key<java.lang.Integer>) android.hardware.camera2.CaptureResult.CONTROL_AE_STATE, true);
            captureMsgData.mFlickerDetectResult = a_renamed(captureResult, (android.hardware.camera2.CaptureResult.Key<java.lang.Integer>) android.hardware.camera2.CaptureResult.STATISTICS_SCENE_FLICKER, true);
            captureMsgData.mFocusMethodType = a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.bu_renamed);
            captureMsgData.mSensorCCT = a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.bo_renamed, 0);
            captureMsgData.mFocusTimeCost = a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.bv_renamed);
            captureMsgData.mSharpnessStd = a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.bx_renamed, 1);
            try {
                java.lang.Integer num = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
                if (num != null) {
                    captureMsgData.mTouchEVValue = num.intValue();
                } else {
                    com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "packageFromCaptureResult,  mTouchEVValue is_renamed null");
                }
            } catch (java.lang.Exception e4) {
                e4.printStackTrace();
            }
            try {
                float[] fArr3 = (float[]) captureResult.get(com.oplus.camera.e_renamed.b_renamed.bn_renamed);
                if (fArr3 != null && fArr3.length > 1) {
                    captureMsgData.mFinalAWBDecision_rg = java.lang.String.valueOf(fArr3[0]);
                    captureMsgData.mFinalAWBDecision_bg = java.lang.String.valueOf(fArr3[1]);
                } else {
                    com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "packageFromCaptureResult, key:" + com.oplus.camera.e_renamed.b_renamed.bn_renamed + "value: " + java.util.Arrays.toString(fArr3));
                }
            } catch (java.lang.Exception e5) {
                e5.printStackTrace();
            }
            try {
                android.hardware.camera2.params.MeteringRectangle[] meteringRectangleArr = (android.hardware.camera2.params.MeteringRectangle[]) captureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AF_REGIONS);
                if (meteringRectangleArr != null && meteringRectangleArr.length > 0) {
                    android.hardware.camera2.params.MeteringRectangle meteringRectangle = meteringRectangleArr[0];
                    captureMsgData.mFocusRegion = meteringRectangle.getX() + "*" + meteringRectangle.getY() + "*" + meteringRectangle.getWidth() + "*" + meteringRectangle.getHeight();
                } else {
                    com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "packageFromCaptureResult, key:" + android.hardware.camera2.CaptureResult.CONTROL_AF_REGIONS + "value: " + java.util.Arrays.toString(meteringRectangleArr));
                }
            } catch (java.lang.Exception e6) {
                e6.printStackTrace();
            }
        }
        captureMsgData.mFocusDistance = java.lang.String.valueOf(captureResult.get(android.hardware.camera2.CaptureResult.LENS_FOCUS_DISTANCE));
        if (cVar == null) {
            com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "packageFromCaptureResult, requestTag is_renamed null");
            return null;
        }
        if (cVar.L_renamed != null) {
            int[] iArr3 = cVar.L_renamed;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i4 = 0; i4 < iArr3.length; i4++) {
                sb.append(iArr3[i4]);
                if (i4 != iArr3.length - 1) {
                    sb.append("*");
                }
            }
            captureMsgData.mHdrEVList = sb.toString();
        }
        captureMsgData.mCaptureMode = cVar.A_renamed;
        captureMsgData.mCameraId = cVar.B_renamed;
        captureMsgData.mOrientation = cVar.J_renamed;
        captureMsgData.mTouchXYValue = cVar.G_renamed;
        captureMsgData.mTouchXYEVValue = cVar.H_renamed;
        captureMsgData.mIsWideAngle = cVar.I_renamed;
        captureMsgData.mHdrMode = cVar.C_renamed;
        captureMsgData.mbHdrTrigger = java.lang.String.valueOf(cVar.D_renamed);
        captureMsgData.mAeAfLock = java.lang.String.valueOf(cVar.F_renamed);
        captureMsgData.mShutterType = cVar.E_renamed;
        if ("portrait".equals(cVar.A_renamed)) {
            captureMsgData.mPortraitNewStyleType = cVar.i_renamed;
        } else if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON.equals(cVar.A_renamed)) {
            captureMsgData.mFilterType = cVar.i_renamed;
            captureMsgData.mSCPEnable = cVar.Q_renamed ? "on_renamed" : "off";
        } else if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MICROSCOPE.equals(cVar.A_renamed) || com.oplus.camera.aps.constant.ApsConstant.REC_MODE_MICROSCOPE.equals(cVar.A_renamed)) {
            captureMsgData.mAncFilterType = cVar.i_renamed;
        } else if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_NIGHT.equals(cVar.A_renamed)) {
            captureMsgData.mNightStyleType = cVar.i_renamed;
        }
        captureMsgData.mSmooth = cVar.f4424b ? 102 : 0;
        if (cVar.P_renamed != 0) {
            i3 = cVar.P_renamed;
        } else {
            i3 = cVar.O_renamed;
        }
        captureMsgData.mAiScene = i3;
        if (cVar.d_renamed != null || cVar.g_renamed || com.oplus.camera.util.Util.a_renamed(cVar.K_renamed, com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_BOKEH) || com.oplus.camera.util.Util.a_renamed(cVar.K_renamed, com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_FRONT_BOKEH)) {
            captureMsgData.mBlurLevel = cVar.R_renamed;
        }
        if (aVar != null) {
            captureMsgData.mTextSize = a_renamed(aVar, size);
        }
        if (!com.oplus.camera.util.Util.C_renamed()) {
            java.lang.Object objA = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.af_renamed);
            if (objA != null && (objA instanceof int[])) {
                int[] iArr4 = (int[]) objA;
                if (iArr4.length > 0) {
                    com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "packageFromCaptureResult, beautyLevel: " + iArr4[0]);
                    captureMsgData.mSmooth = iArr4[0];
                }
            }
            java.lang.Object objA2 = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.ag_renamed);
            if (objA2 != null && (objA2 instanceof int[])) {
                int[] iArrB = com.oplus.camera.util.Util.b_renamed((int[]) objA2);
                if (iArrB.length > 0) {
                    com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "packageFromCaptureResult, customBeautyParam.length: " + iArrB.length);
                    captureMsgData.parseFaceBeauty(iArrB);
                }
            }
        }
        return captureMsgData;
    }

    private static java.lang.String a_renamed(android.hardware.camera2.CaptureResult captureResult, android.hardware.camera2.CaptureResult.Key<java.lang.Integer> key, boolean z_renamed) {
        try {
            java.lang.Object obj = captureResult.get(key);
            return obj != null ? java.lang.String.valueOf(obj) : "";
        } catch (java.lang.Exception e_renamed) {
            if (!z_renamed) {
                return "";
            }
            e_renamed.printStackTrace();
            return "";
        }
    }

    private static java.lang.String a_renamed(android.hardware.camera2.CaptureResult captureResult, android.hardware.camera2.CaptureResult.Key<float[]> key, int i_renamed) {
        java.lang.String strValueOf = "";
        try {
            float[] fArr = (float[]) captureResult.get(key);
            if (fArr != null && fArr.length > i_renamed) {
                strValueOf = java.lang.String.valueOf(fArr[i_renamed]);
            } else {
                com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "packageFromCaptureResult,  key:" + key + " value: " + java.util.Arrays.toString(fArr));
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        return strValueOf;
    }

    private static java.lang.String a_renamed(android.hardware.camera2.CaptureResult captureResult, android.hardware.camera2.CaptureResult.Key<int[]> key) {
        java.lang.String strValueOf = "";
        try {
            int[] iArr = (int[]) captureResult.get(key);
            if (iArr != null && iArr.length > 0) {
                strValueOf = java.lang.String.valueOf(iArr[0]);
            } else {
                com.oplus.camera.e_renamed.a_renamed("CaptureMsgDataReportUtil", "packageFromCaptureResult, key: " + key + " value: " + java.util.Arrays.toString(iArr));
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        return strValueOf;
    }

    public static java.lang.String a_renamed(com.oplus.camera.aps.service.ThumbnailCategory thumbnailCategory) {
        java.lang.String str;
        if (thumbnailCategory == null || thumbnailCategory.mPictureResult == null || thumbnailCategory.mThumbnailItem == null) {
            return null;
        }
        if (thumbnailCategory.mThumbnailItem.mJpegName == null && ((java.lang.Long) thumbnailCategory.mPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_BURST_SHOT_FLAG_ID)).longValue() == -1) {
            return null;
        }
        java.lang.String str2 = ("heic_8bits".equalsIgnoreCase(thumbnailCategory.mThumbnailItem.mPictureFormat) || "heic_10bits".equalsIgnoreCase(thumbnailCategory.mThumbnailItem.mPictureFormat)) ? ".heic" : ".jpg";
        if ("off".equals(com.oplus.camera.Storage.u_renamed)) {
            str = com.oplus.camera.Storage.o_renamed;
        } else {
            str = com.oplus.camera.Storage.j_renamed;
        }
        if (((java.lang.Long) thumbnailCategory.mPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_BURST_SHOT_FLAG_ID)).longValue() > -1) {
            return (java.lang.String) thumbnailCategory.mPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_CSHOT_PATH);
        }
        return str + java.io.File.separator + thumbnailCategory.mThumbnailItem.mJpegName + str2;
    }

    public static java.lang.String a_renamed(com.oplus.camera.Storage.CameraPicture cameraPicture) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String strB;
        if (cameraPicture == null || cameraPicture.l_renamed == 0) {
            return null;
        }
        if ("off".equals(com.oplus.camera.Storage.u_renamed)) {
            str = com.oplus.camera.Storage.o_renamed;
        } else {
            str = com.oplus.camera.Storage.j_renamed;
        }
        java.lang.String str3 = cameraPicture.h_renamed;
        if ("raw".equalsIgnoreCase(str3)) {
            str2 = ".dng";
        } else {
            str2 = ("heic_8bits".equalsIgnoreCase(str3) || "heic_10bits".equalsIgnoreCase(str3)) ? ".heic" : ".jpg";
        }
        if (cameraPicture.n_renamed > -1 && cameraPicture.g_renamed != null) {
            strB = cameraPicture.g_renamed;
        } else {
            strB = com.oplus.camera.util.Util.b_renamed(cameraPicture.l_renamed);
        }
        if (cameraPicture.m_renamed > -1) {
            return cameraPicture.k_renamed;
        }
        return str + java.io.File.separator + strB + str2;
    }

    private static java.lang.String a_renamed(com.oplus.camera.u_renamed.a_renamed aVar, android.util.Size size) {
        if (aVar == null || !aVar.c_renamed() || size == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (android.graphics.PointF pointF : aVar.b_renamed()) {
            sb.append((int) (pointF.x_renamed * size.getWidth()));
            sb.append("x_renamed");
            sb.append((int) (pointF.y_renamed * size.getHeight()));
            sb.append("-");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}

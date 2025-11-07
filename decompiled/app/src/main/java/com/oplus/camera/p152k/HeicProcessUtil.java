package com.oplus.camera.p152k;

import android.content.Context;
import android.graphics.Bitmap;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.util.CameraApsExifData;
import com.oplus.camera.jni.FormatConverter;
import com.oplus.camera.panorama.PanoRenderScriptUtil;
import com.oplus.camera.util.Util;
import com.oplus.exif.OplusExifInterface;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/* compiled from: HeicProcessUtil.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_5.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class HeicProcessUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static OplusExifInterface m14498a(CameraApsExifData cameraApsExifData, long OplusGLSurfaceView_15) {
        if (cameraApsExifData == null) {
            CameraLog.m12967f("HeicProcessUtil", "buildExifInterface, exifData is null!");
            return null;
        }
        OplusExifInterface oplusExifInterface = new OplusExifInterface();
        if (cameraApsExifData.mExifManufacture != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_MAKE, cameraApsExifData.mExifManufacture));
        }
        if (cameraApsExifData.mExifModel != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_MODEL, cameraApsExifData.mExifModel));
        }
        if (cameraApsExifData.mExifDateTime != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_DATE_TIME, cameraApsExifData.mExifDateTime));
        }
        if (cameraApsExifData.mExifDateTime != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_DATE_TIME_ORIGINAL, cameraApsExifData.mExifDateTime));
        }
        if (cameraApsExifData.mExifDateTime != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_DATE_TIME_DIGITIZED, cameraApsExifData.mExifDateTime));
        }
        if (cameraApsExifData.mExifSubDateTime != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_SUB_SEC_TIME, cameraApsExifData.mExifSubDateTime));
        }
        ZonedDateTime zonedDateTimeOfInstant = ZonedDateTime.ofInstant(Instant.ofEpochMilli(OplusGLSurfaceView_15), ZoneId.systemDefault());
        if (zonedDateTimeOfInstant != null && zonedDateTimeOfInstant.getOffset() != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_OFFSET_TIME_ORIGINAL, 2, zonedDateTimeOfInstant.getOffset().toString()));
        }
        if (cameraApsExifData.mExifSubDateTime != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_SUB_SEC_TIME_ORIGINAL, cameraApsExifData.mExifSubDateTime));
        }
        if (cameraApsExifData.mExifSubDateTime != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_SUB_SEC_TIME_DIGITIZED, cameraApsExifData.mExifSubDateTime));
        }
        if (cameraApsExifData.mExifComments != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_USER_COMMENT, cameraApsExifData.mExifComments));
        }
        if (cameraApsExifData.mExifFNumber != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_F_NUMBER, cameraApsExifData.mExifFNumber));
        }
        if (cameraApsExifData.mExifExpTime != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_EXPOSURE_TIME, cameraApsExifData.mExifExpTime));
        }
        if (cameraApsExifData.mExifAperture != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_APERTURE_VALUE, cameraApsExifData.mExifAperture));
        }
        if (cameraApsExifData.mExifExposureBias != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_EXPOSURE_BIAS_VALUE, cameraApsExifData.mExifExposureBias));
        }
        if (cameraApsExifData.mImageWidth != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_IMAGE_WIDTH, Integer.valueOf(cameraApsExifData.mImageWidth)));
        }
        if (cameraApsExifData.mImageHeight != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_IMAGE_LENGTH, Integer.valueOf(cameraApsExifData.mImageHeight)));
        }
        if (cameraApsExifData.mTiffYcrcbPositioning != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_Y_CB_CR_POSITIONING, Integer.valueOf(cameraApsExifData.mTiffYcrcbPositioning)));
        }
        if (cameraApsExifData.mTiffResolutionUnit != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_RESOLUTION_UNIT, Integer.valueOf(cameraApsExifData.mTiffResolutionUnit)));
        }
        if (cameraApsExifData.mTiffXResolution != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_X_RESOLUTION, cameraApsExifData.mTiffXResolution));
        }
        if (cameraApsExifData.mTiffYResolution != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_Y_RESOLUTION, cameraApsExifData.mTiffYResolution));
        }
        if (cameraApsExifData.mExifFocalLength != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_FOCAL_LENGTH, cameraApsExifData.mExifFocalLength));
        }
        if (cameraApsExifData.mExifRotate >= 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_ORIENTATION, Integer.valueOf(cameraApsExifData.mExifRotate)));
        }
        if (-1 != cameraApsExifData.mExifIso) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_ISO_SPEED_RATINGS, Short.valueOf((short) cameraApsExifData.mExifIso)));
        }
        if (-1 != cameraApsExifData.mExifWhiteBalanceMode) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_WHITE_BALANCE, Integer.valueOf(cameraApsExifData.mExifWhiteBalanceMode)));
        }
        if (-1 != cameraApsExifData.mFlashValue) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_FLASH, Integer.valueOf(cameraApsExifData.mFlashValue)));
        }
        if (cameraApsExifData.mExifExposureProgram != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_EXPOSURE_PROGRAM, Integer.valueOf(cameraApsExifData.mExifExposureProgram)));
        }
        if (cameraApsExifData.mExifVersion != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_EXIF_VERSION, cameraApsExifData.mExifVersion));
        }
        if (cameraApsExifData.mExifComponentsConfig != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_COMPONENTS_CONFIGURATION, cameraApsExifData.mExifComponentsConfig));
        }
        if (cameraApsExifData.mExifShutterSpeed != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_SHUTTER_SPEED_VALUE, cameraApsExifData.mExifShutterSpeed));
        }
        if (cameraApsExifData.mExifBrightness != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_BRIGHTNESS_VALUE, cameraApsExifData.mExifBrightness));
        }
        if (cameraApsExifData.mExifMaxAperture != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_MAX_APERTURE_VALUE, cameraApsExifData.mExifMaxAperture));
        }
        if (cameraApsExifData.mExifMeteringMode != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_METERING_MODE, Integer.valueOf(cameraApsExifData.mExifMeteringMode)));
        }
        if (cameraApsExifData.mExifMakerNote != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_MAKER_NOTE, cameraApsExifData.mExifMakerNote));
        }
        if (cameraApsExifData.mExifFlashPixVersion != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_FLASHPIX_VERSION, cameraApsExifData.mExifFlashPixVersion));
        }
        if (cameraApsExifData.mExifColorSpace != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_COLOR_SPACE, Integer.valueOf(cameraApsExifData.mExifColorSpace)));
        }
        if (cameraApsExifData.mExifSensingMethod != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_SENSING_METHOD, Integer.valueOf(cameraApsExifData.mExifSensingMethod)));
        }
        if (cameraApsExifData.mExifSceneType != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_SCENE_TYPE, cameraApsExifData.mExifSceneType));
        }
        if (cameraApsExifData.mExifExposureMode != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_EXPOSURE_MODE, Integer.valueOf(cameraApsExifData.mExifExposureMode)));
        }
        if (cameraApsExifData.mExifFocalLength35Mm != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_FOCAL_LENGTH_IN_35_MM_FILE, Integer.valueOf(cameraApsExifData.mExifFocalLength35Mm)));
        }
        if (cameraApsExifData.mExifSceneCaptureType != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_SCENE_CAPTURE_TYPE, Integer.valueOf(cameraApsExifData.mExifSceneCaptureType)));
        }
        if (cameraApsExifData.mInteropIndexStr != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_INTEROPERABILITY_INDEX, cameraApsExifData.mInteropIndexStr));
        }
        if (cameraApsExifData.mbSupportLocation) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_GPS_LATITUDE_REF, cameraApsExifData.mExifLatitudeRef));
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_GPS_LATITUDE, cameraApsExifData.mExifLatitude));
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_GPS_LONGITUDE_REF, cameraApsExifData.mExifLongitudeRef));
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_GPS_LONGITUDE, cameraApsExifData.mExifLongitude));
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_GPS_ALTITUDE_REF, Integer.valueOf(cameraApsExifData.mExifAltitudeRef)));
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_GPS_ALTITUDE, cameraApsExifData.mExifAltitude));
        }
        if (cameraApsExifData.mbSupportLocationTimeStamp) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_GPS_DATE_STAMP, cameraApsExifData.mDocExifGpsDateStamp));
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_GPS_TIME_STAMP, cameraApsExifData.mDocExifGpsTimeStamp));
        }
        return oplusExifInterface;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m14499a(Storage.CameraPicture cameraPicture, Context context) {
        if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(cameraPicture.f12136i)) {
            cameraPicture.f12115M = PanoRenderScriptUtil.m14965a(context, cameraPicture.f12132e, cameraPicture.f12142o, cameraPicture.f12143p);
            return;
        }
        cameraPicture.f12115M = Util.m24215a(cameraPicture.f12142o, cameraPicture.f12143p, Bitmap.Config.ARGB_8888);
        FormatConverter formatConverter = new FormatConverter();
        long jNv21ToBitmapInit = formatConverter.nv21ToBitmapInit(cameraPicture.f12142o, cameraPicture.f12143p, cameraPicture.f12144q, cameraPicture.f12145r, cameraPicture.f12144q, cameraPicture.f12142o, cameraPicture.f12143p, 1.0f, 1, 0, 0, 0, 2);
        formatConverter.nv21ToBitmapProcess(jNv21ToBitmapInit, cameraPicture.f12132e, 0, cameraPicture.f12115M, cameraPicture.f12142o);
        formatConverter.nv21ToBitmapUnInit(jNv21ToBitmapInit);
    }
}

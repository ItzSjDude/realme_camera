package com.oplus.camera.k_renamed;

/* compiled from: HeicProcessUtil.java */
/* loaded from: classes2.dex */
public class a_renamed {
    public static com.oplus.exif.OplusExifInterface a_renamed(com.oplus.camera.aps.util.CameraApsExifData cameraApsExifData, long j_renamed) {
        if (cameraApsExifData == null) {
            com.oplus.camera.e_renamed.f_renamed("HeicProcessUtil", "buildExifInterface, exifData is_renamed null!");
            return null;
        }
        com.oplus.exif.OplusExifInterface oplusExifInterface = new com.oplus.exif.OplusExifInterface();
        if (cameraApsExifData.mExifManufacture != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_MAKE, cameraApsExifData.mExifManufacture));
        }
        if (cameraApsExifData.mExifModel != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_MODEL, cameraApsExifData.mExifModel));
        }
        if (cameraApsExifData.mExifDateTime != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_DATE_TIME, cameraApsExifData.mExifDateTime));
        }
        if (cameraApsExifData.mExifDateTime != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_DATE_TIME_ORIGINAL, cameraApsExifData.mExifDateTime));
        }
        if (cameraApsExifData.mExifDateTime != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_DATE_TIME_DIGITIZED, cameraApsExifData.mExifDateTime));
        }
        if (cameraApsExifData.mExifSubDateTime != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_SUB_SEC_TIME, cameraApsExifData.mExifSubDateTime));
        }
        java.time.ZonedDateTime zonedDateTimeOfInstant = java.time.ZonedDateTime.ofInstant(java.time.Instant.ofEpochMilli(j_renamed), java.time.ZoneId.systemDefault());
        if (zonedDateTimeOfInstant != null && zonedDateTimeOfInstant.getOffset() != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_OFFSET_TIME_ORIGINAL, 2, zonedDateTimeOfInstant.getOffset().toString()));
        }
        if (cameraApsExifData.mExifSubDateTime != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_SUB_SEC_TIME_ORIGINAL, cameraApsExifData.mExifSubDateTime));
        }
        if (cameraApsExifData.mExifSubDateTime != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_SUB_SEC_TIME_DIGITIZED, cameraApsExifData.mExifSubDateTime));
        }
        if (cameraApsExifData.mExifComments != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_USER_COMMENT, cameraApsExifData.mExifComments));
        }
        if (cameraApsExifData.mExifFNumber != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_F_NUMBER, cameraApsExifData.mExifFNumber));
        }
        if (cameraApsExifData.mExifExpTime != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_EXPOSURE_TIME, cameraApsExifData.mExifExpTime));
        }
        if (cameraApsExifData.mExifAperture != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_APERTURE_VALUE, cameraApsExifData.mExifAperture));
        }
        if (cameraApsExifData.mExifExposureBias != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_EXPOSURE_BIAS_VALUE, cameraApsExifData.mExifExposureBias));
        }
        if (cameraApsExifData.mImageWidth != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_IMAGE_WIDTH, java.lang.Integer.valueOf(cameraApsExifData.mImageWidth)));
        }
        if (cameraApsExifData.mImageHeight != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_IMAGE_LENGTH, java.lang.Integer.valueOf(cameraApsExifData.mImageHeight)));
        }
        if (cameraApsExifData.mTiffYcrcbPositioning != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_Y_CB_CR_POSITIONING, java.lang.Integer.valueOf(cameraApsExifData.mTiffYcrcbPositioning)));
        }
        if (cameraApsExifData.mTiffResolutionUnit != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_RESOLUTION_UNIT, java.lang.Integer.valueOf(cameraApsExifData.mTiffResolutionUnit)));
        }
        if (cameraApsExifData.mTiffXResolution != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_X_RESOLUTION, cameraApsExifData.mTiffXResolution));
        }
        if (cameraApsExifData.mTiffYResolution != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_Y_RESOLUTION, cameraApsExifData.mTiffYResolution));
        }
        if (cameraApsExifData.mExifFocalLength != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_FOCAL_LENGTH, cameraApsExifData.mExifFocalLength));
        }
        if (cameraApsExifData.mExifRotate >= 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_ORIENTATION, java.lang.Integer.valueOf(cameraApsExifData.mExifRotate)));
        }
        if (-1 != cameraApsExifData.mExifIso) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_ISO_SPEED_RATINGS, java.lang.Short.valueOf((short) cameraApsExifData.mExifIso)));
        }
        if (-1 != cameraApsExifData.mExifWhiteBalanceMode) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_WHITE_BALANCE, java.lang.Integer.valueOf(cameraApsExifData.mExifWhiteBalanceMode)));
        }
        if (-1 != cameraApsExifData.mFlashValue) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_FLASH, java.lang.Integer.valueOf(cameraApsExifData.mFlashValue)));
        }
        if (cameraApsExifData.mExifExposureProgram != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_EXPOSURE_PROGRAM, java.lang.Integer.valueOf(cameraApsExifData.mExifExposureProgram)));
        }
        if (cameraApsExifData.mExifVersion != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_EXIF_VERSION, cameraApsExifData.mExifVersion));
        }
        if (cameraApsExifData.mExifComponentsConfig != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_COMPONENTS_CONFIGURATION, cameraApsExifData.mExifComponentsConfig));
        }
        if (cameraApsExifData.mExifShutterSpeed != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_SHUTTER_SPEED_VALUE, cameraApsExifData.mExifShutterSpeed));
        }
        if (cameraApsExifData.mExifBrightness != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_BRIGHTNESS_VALUE, cameraApsExifData.mExifBrightness));
        }
        if (cameraApsExifData.mExifMaxAperture != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_MAX_APERTURE_VALUE, cameraApsExifData.mExifMaxAperture));
        }
        if (cameraApsExifData.mExifMeteringMode != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_METERING_MODE, java.lang.Integer.valueOf(cameraApsExifData.mExifMeteringMode)));
        }
        if (cameraApsExifData.mExifMakerNote != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_MAKER_NOTE, cameraApsExifData.mExifMakerNote));
        }
        if (cameraApsExifData.mExifFlashPixVersion != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_FLASHPIX_VERSION, cameraApsExifData.mExifFlashPixVersion));
        }
        if (cameraApsExifData.mExifColorSpace != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_COLOR_SPACE, java.lang.Integer.valueOf(cameraApsExifData.mExifColorSpace)));
        }
        if (cameraApsExifData.mExifSensingMethod != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_SENSING_METHOD, java.lang.Integer.valueOf(cameraApsExifData.mExifSensingMethod)));
        }
        if (cameraApsExifData.mExifSceneType != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_SCENE_TYPE, cameraApsExifData.mExifSceneType));
        }
        if (cameraApsExifData.mExifExposureMode != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_EXPOSURE_MODE, java.lang.Integer.valueOf(cameraApsExifData.mExifExposureMode)));
        }
        if (cameraApsExifData.mExifFocalLength35Mm != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_FOCAL_LENGTH_IN_35_MM_FILE, java.lang.Integer.valueOf(cameraApsExifData.mExifFocalLength35Mm)));
        }
        if (cameraApsExifData.mExifSceneCaptureType != 0) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_SCENE_CAPTURE_TYPE, java.lang.Integer.valueOf(cameraApsExifData.mExifSceneCaptureType)));
        }
        if (cameraApsExifData.mInteropIndexStr != null) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_INTEROPERABILITY_INDEX, cameraApsExifData.mInteropIndexStr));
        }
        if (cameraApsExifData.mbSupportLocation) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_GPS_LATITUDE_REF, cameraApsExifData.mExifLatitudeRef));
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_GPS_LATITUDE, cameraApsExifData.mExifLatitude));
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_GPS_LONGITUDE_REF, cameraApsExifData.mExifLongitudeRef));
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_GPS_LONGITUDE, cameraApsExifData.mExifLongitude));
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_GPS_ALTITUDE_REF, java.lang.Integer.valueOf(cameraApsExifData.mExifAltitudeRef)));
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_GPS_ALTITUDE, cameraApsExifData.mExifAltitude));
        }
        if (cameraApsExifData.mbSupportLocationTimeStamp) {
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_GPS_DATE_STAMP, cameraApsExifData.mDocExifGpsDateStamp));
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_GPS_TIME_STAMP, cameraApsExifData.mDocExifGpsTimeStamp));
        }
        return oplusExifInterface;
    }

    public static void a_renamed(com.oplus.camera.Storage.CameraPicture cameraPicture, android.content.Context context) {
        if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA.equals(cameraPicture.i_renamed)) {
            cameraPicture.M_renamed = com.oplus.camera.panorama.e_renamed.a_renamed(context, cameraPicture.e_renamed, cameraPicture.o_renamed, cameraPicture.p_renamed);
            return;
        }
        cameraPicture.M_renamed = com.oplus.camera.util.Util.a_renamed(cameraPicture.o_renamed, cameraPicture.p_renamed, android.graphics.Bitmap.Config.ARGB_8888);
        com.oplus.camera.jni.FormatConverter formatConverter = new com.oplus.camera.jni.FormatConverter();
        long jNv21ToBitmapInit = formatConverter.nv21ToBitmapInit(cameraPicture.o_renamed, cameraPicture.p_renamed, cameraPicture.q_renamed, cameraPicture.r_renamed, cameraPicture.q_renamed, cameraPicture.o_renamed, cameraPicture.p_renamed, 1.0f, 1, 0, 0, 0, 2);
        formatConverter.nv21ToBitmapProcess(jNv21ToBitmapInit, cameraPicture.e_renamed, 0, cameraPicture.M_renamed, cameraPicture.o_renamed);
        formatConverter.nv21ToBitmapUnInit(jNv21ToBitmapInit);
    }
}

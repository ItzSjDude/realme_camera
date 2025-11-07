package com.oplus.camera.jni;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class SuperNight {
    public static final int ALGO_MODE_ASN_REAR_RGGB_SDM845_HDR_PLUS = 16;
    public static final int ALGO_MODE_ASN_REAR_RGGB_SDM845_SUPER_NIGHT = 32;
    public static final int ARC_SN_CAMERA_MODE_OPLUS_SDM670_12MB_IMX362 = 1073;
    public static final int ARC_SN_CAMERA_MODE_OPLUS_SDM670_16MB_IMX519 = 1074;
    public static final int ARC_SN_CAMERA_MODE_OPLUS_SDM710_12MB_IMX362 = 1057;
    public static final int ARC_SN_CAMERA_MODE_OPLUS_SDM710_16MB_IMX519 = 1058;
    public static final int ARC_SN_CAMERA_MODE_OPLUS_SDM845_12MB_IMX362 = 1041;
    public static final int ARC_SN_CAMERA_MODE_OPLUS_SDM845_16MB_IMX519 = 1042;
    public static final int ARC_SN_CAMERA_MODE_UNKNOWN = -1;
    public static final int ARC_SN_FRONT_OPLUS_P70_GRBG_6MB = 1105;
    public static final int ARC_SN_FRONT_OPLUS_P80_GRBG_6MB = 1121;
    public static final int ARC_SN_REAR_OPLUS_P70_GRBG_12MB = 1106;
    public static final int ARC_SN_REAR_OPLUS_P80_GRBG_12MB = 1122;
    public static final int CAMERA_NIGHT_STATE_LENGTH = 3;
    public static final int CAMERA_NIGHT_STATE_POSITION_CAPTURENUM = 1;
    public static final int CAMERA_NIGHT_STATE_POSITION_MAXEXPOSURETIME = 2;
    public static final int CAMERA_NIGHT_STATE_POSITION_STATE = 0;
    public static final int CAMERA_STATE_ARC_SN_CAMERA_STATE_FACE = 3;
    public static final int CAMERA_STATE_ARC_SN_CAMERA_STATE_HAND = 2;
    public static final int CAMERA_STATE_ARC_SN_CAMERA_STATE_INDOOR = 4;
    public static final int CAMERA_STATE_ARC_SN_CAMERA_STATE_TRIPOD = 1;
    public static final int CAMERA_STATE_ARC_SN_CAMERA_STATE_UNKNOWN = 0;
    public static final int SN_STOP_INTERRUPT = 1;
    public static final int SN_STOP_QUIT = 2;

    public native int addFrame(int OplusGLSurfaceView_13, ByteBuffer byteBuffer, int i2, int i3);

    public native int[] getResultImage(ByteBuffer byteBuffer, int OplusGLSurfaceView_13);

    public native int init();

    public native int processImages();

    public native int setGlobalInputParams(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12);

    public native int setInputParams(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6, float f7, long OplusGLSurfaceView_15, float f8, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6);

    public native int setOneFace(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6);

    public native int stop(int OplusGLSurfaceView_13);

    public native int unint();
}

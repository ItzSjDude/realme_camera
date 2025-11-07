package com.oplus.ocs.camera;

import android.graphics.Bitmap;
import com.sensetime.faceapi.FaceLibrary;
import com.sensetime.faceapi.model.FaceAttrInfo;
import com.sensetime.faceapi.model.FaceInfo;

/* loaded from: classes2.dex */
public class FaceLibraryHelper {
    public static void setDebug(boolean z) {
        FaceLibrary.setDebug(z);
    }

    public static int initLiscence(byte[] bArr) {
        return FaceLibrary.initLiscence(bArr);
    }

    public static int initLiscenceStr(String str) {
        return FaceLibrary.initLiscenceStr(str);
    }

    public static long cvFaceCreateDetector(String str, int OplusGLSurfaceView_13) {
        return FaceLibrary.cvFaceCreateDetector(str, OplusGLSurfaceView_13);
    }

    public static void cvFaceDestroyDetector(long OplusGLSurfaceView_15) {
        FaceLibrary.cvFaceDestroyDetector(OplusGLSurfaceView_15);
    }

    public static float getDetectThreshold(long OplusGLSurfaceView_15, int[] iArr) {
        return FaceLibrary.getDetectThreshold(OplusGLSurfaceView_15, iArr);
    }

    public static void setDetectThreshold(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12, int[] iArr) {
        FaceLibrary.setDetectThreshold(OplusGLSurfaceView_15, COUIBaseListPopupWindow_12, iArr);
    }

    public static FaceInfo[] cvFaceDetectBytes(long OplusGLSurfaceView_15, byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int[] iArr) {
        return FaceLibrary.cvFaceDetectBytes(OplusGLSurfaceView_15, bArr, OplusGLSurfaceView_13, i2, i3, i4, i5, iArr);
    }

    public static FaceInfo[] cvFaceDetectInts(long OplusGLSurfaceView_15, int[] iArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int[] iArr2) {
        return FaceLibrary.cvFaceDetectInts(OplusGLSurfaceView_15, iArr, OplusGLSurfaceView_13, i2, i3, i4, i5, iArr2);
    }

    public static void cvFaceShowInsideModel() {
        FaceLibrary.cvFaceShowInsideModel();
    }

    public static long cvFaceCreateTracker(String str, String str2, int OplusGLSurfaceView_13) {
        return FaceLibrary.cvFaceCreateTracker(str, str2, OplusGLSurfaceView_13);
    }

    public static void cvFaceDestroyTracker(long OplusGLSurfaceView_15) {
        FaceLibrary.cvFaceDestroyTracker(OplusGLSurfaceView_15);
    }

    public static FaceInfo[] cvFaceTrackBytes(long OplusGLSurfaceView_15, byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int[] iArr) {
        return FaceLibrary.cvFaceTrackBytes(OplusGLSurfaceView_15, bArr, OplusGLSurfaceView_13, i2, i3, i4, i5, iArr);
    }

    public static FaceInfo[] cvFaceTrackInts(long OplusGLSurfaceView_15, int[] iArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int[] iArr2) {
        return FaceLibrary.cvFaceTrackInts(OplusGLSurfaceView_15, iArr, OplusGLSurfaceView_13, i2, i3, i4, i5, iArr2);
    }

    public static void cvFaceResetTracker(long OplusGLSurfaceView_15) {
        FaceLibrary.cvFaceResetTracker(OplusGLSurfaceView_15);
    }

    public static int cvFaceTrackSetDetectFaceCntLimit(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        return FaceLibrary.cvFaceTrackSetDetectFaceCntLimit(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
    }

    public static int cvFaceTrackSetDetectInterval(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        return FaceLibrary.cvFaceTrackSetDetectInterval(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
    }

    public static long cvFaceCreateVerify(String str) {
        return FaceLibrary.cvFaceCreateVerify(str);
    }

    public static int cvFaceGetVerifyVersion(long OplusGLSurfaceView_15) {
        return FaceLibrary.cvFaceGetVerifyVersion(OplusGLSurfaceView_15);
    }

    public static int cvFaceGetVerifyLength(long OplusGLSurfaceView_15) {
        return FaceLibrary.cvFaceGetVerifyLength(OplusGLSurfaceView_15);
    }

    public static long cvFaceDeserialize(byte[] bArr) {
        return FaceLibrary.cvFaceDeserialize(bArr);
    }

    public static float cvFaceCompareFeature(long OplusGLSurfaceView_15, byte[] bArr, byte[] bArr2, int[] iArr) {
        return FaceLibrary.cvFaceCompareFeature(OplusGLSurfaceView_15, bArr, bArr2, iArr);
    }

    public static byte[] cvFaceGetFeatureInts(long OplusGLSurfaceView_15, int[] iArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, FaceInfo faceInfo, int[] iArr2) {
        return FaceLibrary.cvFaceGetFeatureInts(OplusGLSurfaceView_15, iArr, OplusGLSurfaceView_13, i2, i3, i4, faceInfo, iArr2);
    }

    public static byte[] cvFaceGetFeatureBytes(long OplusGLSurfaceView_15, byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, FaceInfo faceInfo, int[] iArr) {
        return FaceLibrary.cvFaceGetFeatureBytes(OplusGLSurfaceView_15, bArr, OplusGLSurfaceView_13, i2, i3, i4, faceInfo, iArr);
    }

    public static void cvFaceDestroyVerify(long OplusGLSurfaceView_15) {
        FaceLibrary.cvFaceDestroyVerify(OplusGLSurfaceView_15);
    }

    public static long cvFaceCreateAttribute(String str) {
        return FaceLibrary.cvFaceCreateAttribute(str);
    }

    public static FaceAttrInfo cvFaceAttributeInts(long OplusGLSurfaceView_15, int[] iArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, FaceInfo faceInfo, int[] iArr2) {
        return FaceLibrary.cvFaceAttributeInts(OplusGLSurfaceView_15, iArr, OplusGLSurfaceView_13, i2, i3, i4, faceInfo, iArr2);
    }

    public static FaceAttrInfo cvFaceAttributeBytes(long OplusGLSurfaceView_15, byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, FaceInfo faceInfo, int[] iArr) {
        return FaceLibrary.cvFaceAttributeBytes(OplusGLSurfaceView_15, bArr, OplusGLSurfaceView_13, i2, i3, i4, faceInfo, iArr);
    }

    public static void cvFaceDestroyAttribute(long OplusGLSurfaceView_15) {
        FaceLibrary.cvFaceDestroyAttribute(OplusGLSurfaceView_15);
    }

    public static long cvFaceCreateCluster(String str) {
        return FaceLibrary.cvFaceCreateCluster(str);
    }

    public static void cvFaceCluster(long OplusGLSurfaceView_15, byte[][] bArr, int[] iArr, int[] iArr2) {
        FaceLibrary.cvFaceCluster(OplusGLSurfaceView_15, bArr, iArr, iArr2);
    }

    public static void getRepresentative(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2, int[] iArr, int[] iArr2) {
        FaceLibrary.getRepresentative(OplusGLSurfaceView_15, OplusGLSurfaceView_13, i2, iArr, iArr2);
    }

    public static void cvFaceDestroyCluster(long OplusGLSurfaceView_15) {
        FaceLibrary.cvFaceDestroyCluster(OplusGLSurfaceView_15);
    }

    public static long cvFaceCreateFigureSeg(String str, int OplusGLSurfaceView_13) {
        return FaceLibrary.cvFaceCreateFigureSeg(str, OplusGLSurfaceView_13);
    }

    public static int cvFaceFigureSegSetOuputLength(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2, int i3, int[] iArr) {
        return FaceLibrary.cvFaceFigureSegSetOuputLength(OplusGLSurfaceView_15, OplusGLSurfaceView_13, i2, i3, iArr);
    }

    public static int cvFaceFigureSeg(long OplusGLSurfaceView_15, byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, byte[] bArr2, int i6) {
        return FaceLibrary.cvFaceFigureSeg(OplusGLSurfaceView_15, bArr, OplusGLSurfaceView_13, i2, i3, i4, i5, bArr2, i6);
    }

    public static int cvFaceFigureSeg(long OplusGLSurfaceView_15, byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, byte[] bArr2, int i6, int i7, int i8) {
        return FaceLibrary.cvFaceFigureSeg(OplusGLSurfaceView_15, bArr, OplusGLSurfaceView_13, i2, i3, i4, i5, bArr2, i6, i7, i8);
    }

    public static void cvFaceDestroyFigureSeg(long OplusGLSurfaceView_15) {
        FaceLibrary.cvFaceDestroyFigureSeg(OplusGLSurfaceView_15);
    }

    public static long cvFaceCreateHackness(String str) {
        return FaceLibrary.cvFaceCreateHackness(str);
    }

    public static float cvFaceHackness(long OplusGLSurfaceView_15, byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, FaceInfo faceInfo, int[] iArr) {
        return FaceLibrary.cvFaceHackness(OplusGLSurfaceView_15, bArr, OplusGLSurfaceView_13, i2, i3, i4, i5, faceInfo, iArr);
    }

    public static void cvFaceDestroyHackness(long OplusGLSurfaceView_15) {
        FaceLibrary.cvFaceDestroyHackness(OplusGLSurfaceView_15);
    }

    public static void convertColorSpace(byte[] bArr, int OplusGLSurfaceView_13, int i2, byte[] bArr2, int i3) {
        FaceLibrary.convertColorSpace(bArr, OplusGLSurfaceView_13, i2, bArr2, i3);
    }

    public static void getBGRADataFromBitmap(Bitmap bitmap, byte[] bArr) {
        FaceLibrary.getBGRADataFromBitmap(bitmap, bArr);
    }

    public static void getBGRDataFromBitmap(Bitmap bitmap, byte[] bArr) {
        FaceLibrary.getBGRDataFromBitmap(bitmap, bArr);
    }

    public static void cropNv21Data(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, byte[] bArr2) {
        FaceLibrary.cropNv21Data(bArr, OplusGLSurfaceView_13, i2, i3, i4, i5, i6, bArr2);
    }

    public static int faceBrightEvaluate(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return FaceLibrary.faceBrightEvaluate(bArr, OplusGLSurfaceView_13, i2, i3, i4, i5, i6, i7, i8, i9);
    }
}

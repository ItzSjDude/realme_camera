package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public class FaceLibraryHelper {
    public static void setDebug(boolean z_renamed) {
        com.sensetime.faceapi.FaceLibrary.setDebug(z_renamed);
    }

    public static int initLiscence(byte[] bArr) {
        return com.sensetime.faceapi.FaceLibrary.initLiscence(bArr);
    }

    public static int initLiscenceStr(java.lang.String str) {
        return com.sensetime.faceapi.FaceLibrary.initLiscenceStr(str);
    }

    public static long cvFaceCreateDetector(java.lang.String str, int i_renamed) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceCreateDetector(str, i_renamed);
    }

    public static void cvFaceDestroyDetector(long j_renamed) {
        com.sensetime.faceapi.FaceLibrary.cvFaceDestroyDetector(j_renamed);
    }

    public static float getDetectThreshold(long j_renamed, int[] iArr) {
        return com.sensetime.faceapi.FaceLibrary.getDetectThreshold(j_renamed, iArr);
    }

    public static void setDetectThreshold(long j_renamed, float f_renamed, int[] iArr) {
        com.sensetime.faceapi.FaceLibrary.setDetectThreshold(j_renamed, f_renamed, iArr);
    }

    public static com.sensetime.faceapi.model.FaceInfo[] cvFaceDetectBytes(long j_renamed, byte[] bArr, int i_renamed, int i2, int i3, int i4, int i5, int[] iArr) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceDetectBytes(j_renamed, bArr, i_renamed, i2, i3, i4, i5, iArr);
    }

    public static com.sensetime.faceapi.model.FaceInfo[] cvFaceDetectInts(long j_renamed, int[] iArr, int i_renamed, int i2, int i3, int i4, int i5, int[] iArr2) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceDetectInts(j_renamed, iArr, i_renamed, i2, i3, i4, i5, iArr2);
    }

    public static void cvFaceShowInsideModel() {
        com.sensetime.faceapi.FaceLibrary.cvFaceShowInsideModel();
    }

    public static long cvFaceCreateTracker(java.lang.String str, java.lang.String str2, int i_renamed) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceCreateTracker(str, str2, i_renamed);
    }

    public static void cvFaceDestroyTracker(long j_renamed) {
        com.sensetime.faceapi.FaceLibrary.cvFaceDestroyTracker(j_renamed);
    }

    public static com.sensetime.faceapi.model.FaceInfo[] cvFaceTrackBytes(long j_renamed, byte[] bArr, int i_renamed, int i2, int i3, int i4, int i5, int[] iArr) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceTrackBytes(j_renamed, bArr, i_renamed, i2, i3, i4, i5, iArr);
    }

    public static com.sensetime.faceapi.model.FaceInfo[] cvFaceTrackInts(long j_renamed, int[] iArr, int i_renamed, int i2, int i3, int i4, int i5, int[] iArr2) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceTrackInts(j_renamed, iArr, i_renamed, i2, i3, i4, i5, iArr2);
    }

    public static void cvFaceResetTracker(long j_renamed) {
        com.sensetime.faceapi.FaceLibrary.cvFaceResetTracker(j_renamed);
    }

    public static int cvFaceTrackSetDetectFaceCntLimit(long j_renamed, int i_renamed) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceTrackSetDetectFaceCntLimit(j_renamed, i_renamed);
    }

    public static int cvFaceTrackSetDetectInterval(long j_renamed, int i_renamed) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceTrackSetDetectInterval(j_renamed, i_renamed);
    }

    public static long cvFaceCreateVerify(java.lang.String str) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceCreateVerify(str);
    }

    public static int cvFaceGetVerifyVersion(long j_renamed) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceGetVerifyVersion(j_renamed);
    }

    public static int cvFaceGetVerifyLength(long j_renamed) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceGetVerifyLength(j_renamed);
    }

    public static long cvFaceDeserialize(byte[] bArr) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceDeserialize(bArr);
    }

    public static float cvFaceCompareFeature(long j_renamed, byte[] bArr, byte[] bArr2, int[] iArr) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceCompareFeature(j_renamed, bArr, bArr2, iArr);
    }

    public static byte[] cvFaceGetFeatureInts(long j_renamed, int[] iArr, int i_renamed, int i2, int i3, int i4, com.sensetime.faceapi.model.FaceInfo faceInfo, int[] iArr2) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceGetFeatureInts(j_renamed, iArr, i_renamed, i2, i3, i4, faceInfo, iArr2);
    }

    public static byte[] cvFaceGetFeatureBytes(long j_renamed, byte[] bArr, int i_renamed, int i2, int i3, int i4, com.sensetime.faceapi.model.FaceInfo faceInfo, int[] iArr) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceGetFeatureBytes(j_renamed, bArr, i_renamed, i2, i3, i4, faceInfo, iArr);
    }

    public static void cvFaceDestroyVerify(long j_renamed) {
        com.sensetime.faceapi.FaceLibrary.cvFaceDestroyVerify(j_renamed);
    }

    public static long cvFaceCreateAttribute(java.lang.String str) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceCreateAttribute(str);
    }

    public static com.sensetime.faceapi.model.FaceAttrInfo cvFaceAttributeInts(long j_renamed, int[] iArr, int i_renamed, int i2, int i3, int i4, com.sensetime.faceapi.model.FaceInfo faceInfo, int[] iArr2) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceAttributeInts(j_renamed, iArr, i_renamed, i2, i3, i4, faceInfo, iArr2);
    }

    public static com.sensetime.faceapi.model.FaceAttrInfo cvFaceAttributeBytes(long j_renamed, byte[] bArr, int i_renamed, int i2, int i3, int i4, com.sensetime.faceapi.model.FaceInfo faceInfo, int[] iArr) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceAttributeBytes(j_renamed, bArr, i_renamed, i2, i3, i4, faceInfo, iArr);
    }

    public static void cvFaceDestroyAttribute(long j_renamed) {
        com.sensetime.faceapi.FaceLibrary.cvFaceDestroyAttribute(j_renamed);
    }

    public static long cvFaceCreateCluster(java.lang.String str) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceCreateCluster(str);
    }

    public static void cvFaceCluster(long j_renamed, byte[][] bArr, int[] iArr, int[] iArr2) {
        com.sensetime.faceapi.FaceLibrary.cvFaceCluster(j_renamed, bArr, iArr, iArr2);
    }

    public static void getRepresentative(long j_renamed, int i_renamed, int i2, int[] iArr, int[] iArr2) {
        com.sensetime.faceapi.FaceLibrary.getRepresentative(j_renamed, i_renamed, i2, iArr, iArr2);
    }

    public static void cvFaceDestroyCluster(long j_renamed) {
        com.sensetime.faceapi.FaceLibrary.cvFaceDestroyCluster(j_renamed);
    }

    public static long cvFaceCreateFigureSeg(java.lang.String str, int i_renamed) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceCreateFigureSeg(str, i_renamed);
    }

    public static int cvFaceFigureSegSetOuputLength(long j_renamed, int i_renamed, int i2, int i3, int[] iArr) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceFigureSegSetOuputLength(j_renamed, i_renamed, i2, i3, iArr);
    }

    public static int cvFaceFigureSeg(long j_renamed, byte[] bArr, int i_renamed, int i2, int i3, int i4, int i5, byte[] bArr2, int i6) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceFigureSeg(j_renamed, bArr, i_renamed, i2, i3, i4, i5, bArr2, i6);
    }

    public static int cvFaceFigureSeg(long j_renamed, byte[] bArr, int i_renamed, int i2, int i3, int i4, int i5, byte[] bArr2, int i6, int i7, int i8) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceFigureSeg(j_renamed, bArr, i_renamed, i2, i3, i4, i5, bArr2, i6, i7, i8);
    }

    public static void cvFaceDestroyFigureSeg(long j_renamed) {
        com.sensetime.faceapi.FaceLibrary.cvFaceDestroyFigureSeg(j_renamed);
    }

    public static long cvFaceCreateHackness(java.lang.String str) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceCreateHackness(str);
    }

    public static float cvFaceHackness(long j_renamed, byte[] bArr, int i_renamed, int i2, int i3, int i4, int i5, com.sensetime.faceapi.model.FaceInfo faceInfo, int[] iArr) {
        return com.sensetime.faceapi.FaceLibrary.cvFaceHackness(j_renamed, bArr, i_renamed, i2, i3, i4, i5, faceInfo, iArr);
    }

    public static void cvFaceDestroyHackness(long j_renamed) {
        com.sensetime.faceapi.FaceLibrary.cvFaceDestroyHackness(j_renamed);
    }

    public static void convertColorSpace(byte[] bArr, int i_renamed, int i2, byte[] bArr2, int i3) {
        com.sensetime.faceapi.FaceLibrary.convertColorSpace(bArr, i_renamed, i2, bArr2, i3);
    }

    public static void getBGRADataFromBitmap(android.graphics.Bitmap bitmap, byte[] bArr) {
        com.sensetime.faceapi.FaceLibrary.getBGRADataFromBitmap(bitmap, bArr);
    }

    public static void getBGRDataFromBitmap(android.graphics.Bitmap bitmap, byte[] bArr) {
        com.sensetime.faceapi.FaceLibrary.getBGRDataFromBitmap(bitmap, bArr);
    }

    public static void cropNv21Data(byte[] bArr, int i_renamed, int i2, int i3, int i4, int i5, int i6, byte[] bArr2) {
        com.sensetime.faceapi.FaceLibrary.cropNv21Data(bArr, i_renamed, i2, i3, i4, i5, i6, bArr2);
    }

    public static int faceBrightEvaluate(byte[] bArr, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return com.sensetime.faceapi.FaceLibrary.faceBrightEvaluate(bArr, i_renamed, i2, i3, i4, i5, i6, i7, i8, i9);
    }
}

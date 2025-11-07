package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public class BlurFilterLibraryHelper {
    public static int init(int i_renamed, int i2) {
        return com.sensetime.blur.BlurFilterLibrary.init(i_renamed, i2);
    }

    public static int processOESTexture(int i_renamed, android.graphics.Rect[] rectArr, boolean z_renamed, float[] fArr, int i2, int i3, int i4, boolean z2, int[] iArr) {
        return com.sensetime.blur.BlurFilterLibrary.processOESTexture(i_renamed, rectArr, z_renamed, fArr, i2, i3, i4, z2, iArr);
    }

    public static int processTexture(int i_renamed, android.graphics.Rect[] rectArr, boolean z_renamed, float[] fArr, int i2, int i3, int i4, boolean z2, int[] iArr) {
        return com.sensetime.blur.BlurFilterLibrary.processTexture(i_renamed, rectArr, z_renamed, fArr, i2, i3, i4, z2, iArr);
    }

    public static int processMaskTexture(int i_renamed, int i2, int i3, int[] iArr) {
        return com.sensetime.blur.BlurFilterLibrary.processMaskTexture(i_renamed, i2, i3, iArr);
    }

    public static int processMaskBuffer(byte[] bArr, int i_renamed, int i2, boolean z_renamed, int[] iArr) {
        return com.sensetime.blur.BlurFilterLibrary.processMaskBuffer(bArr, i_renamed, i2, z_renamed, iArr);
    }

    public static int rotateMaskTexture(int i_renamed, boolean z_renamed, boolean z2) {
        return com.sensetime.blur.BlurFilterLibrary.rotateMaskTexture(i_renamed, z_renamed, z2);
    }

    public static int rotateGradualTexture(int i_renamed, boolean z_renamed, boolean z2) {
        return com.sensetime.blur.BlurFilterLibrary.rotateGradualTexture(i_renamed, z_renamed, z2);
    }

    public static int getMaskTextureByFace(android.graphics.Rect[] rectArr, boolean z_renamed, float[] fArr, int i_renamed, int i2, int i3, boolean z2) {
        return com.sensetime.blur.BlurFilterLibrary.getMaskTextureByFace(rectArr, z_renamed, fArr, i_renamed, i2, i3, z2);
    }

    public static int processTextureByMask(int i_renamed, int i2, int i3, int i4, boolean z_renamed, int[] iArr) {
        return com.sensetime.blur.BlurFilterLibrary.processTextureByMask(i_renamed, i2, i3, i4, z_renamed, iArr);
    }

    public static int processTexureByMaskGradual(int i_renamed, int i2, int i3, int i4, boolean z_renamed, int i5, float[] fArr, int[] iArr) {
        return com.sensetime.blur.BlurFilterLibrary.processTexureByMaskGradual(i_renamed, i2, i3, i4, z_renamed, i5, fArr, iArr);
    }

    public static int processOESTextureByMask(int i_renamed, int i2, int i3, int i4, boolean z_renamed, int[] iArr) {
        return com.sensetime.blur.BlurFilterLibrary.processOESTextureByMask(i_renamed, i2, i3, i4, z_renamed, iArr);
    }

    public static int processOESTexureByMaskGradual(int i_renamed, int i2, int i3, int i4, boolean z_renamed, int i5, float[] fArr, int[] iArr) {
        return com.sensetime.blur.BlurFilterLibrary.processOESTexureByMaskGradual(i_renamed, i2, i3, i4, z_renamed, i5, fArr, iArr);
    }

    public static int OESTo2DTexture(int i_renamed, int[] iArr) {
        return com.sensetime.blur.BlurFilterLibrary.OESTo2DTexture(i_renamed, iArr);
    }

    public static int copy2DTexture(int i_renamed, int[] iArr) {
        return com.sensetime.blur.BlurFilterLibrary.copy2DTexture(i_renamed, iArr);
    }

    public static int ResizeTexture(int i_renamed, int i2, int i3, int i4) {
        return com.sensetime.blur.BlurFilterLibrary.ResizeTexture(i_renamed, i2, i3, i4);
    }

    public static int setParam(int i_renamed, float f_renamed) {
        return com.sensetime.blur.BlurFilterLibrary.setParam(i_renamed, f_renamed);
    }

    public static int destroy() {
        return com.sensetime.blur.BlurFilterLibrary.destroy();
    }

    public static java.lang.String getVersion() {
        return com.sensetime.blur.BlurFilterLibrary.getVersion();
    }

    public static int setDebug(boolean z_renamed) {
        return com.sensetime.blur.BlurFilterLibrary.setDebug(z_renamed);
    }

    public static int setDebugMask(boolean z_renamed) {
        return com.sensetime.blur.BlurFilterLibrary.setDebugMask(z_renamed);
    }
}

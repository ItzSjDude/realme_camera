package com.oplus.ocs.camera;

import android.graphics.Rect;
import com.sensetime.blur.BlurFilterLibrary;

/* loaded from: classes2.dex */
public class BlurFilterLibraryHelper {
    public static int init(int OplusGLSurfaceView_13, int i2) {
        return BlurFilterLibrary.init(OplusGLSurfaceView_13, i2);
    }

    public static int processOESTexture(int OplusGLSurfaceView_13, Rect[] rectArr, boolean z, float[] fArr, int i2, int i3, int i4, boolean z2, int[] iArr) {
        return BlurFilterLibrary.processOESTexture(OplusGLSurfaceView_13, rectArr, z, fArr, i2, i3, i4, z2, iArr);
    }

    public static int processTexture(int OplusGLSurfaceView_13, Rect[] rectArr, boolean z, float[] fArr, int i2, int i3, int i4, boolean z2, int[] iArr) {
        return BlurFilterLibrary.processTexture(OplusGLSurfaceView_13, rectArr, z, fArr, i2, i3, i4, z2, iArr);
    }

    public static int processMaskTexture(int OplusGLSurfaceView_13, int i2, int i3, int[] iArr) {
        return BlurFilterLibrary.processMaskTexture(OplusGLSurfaceView_13, i2, i3, iArr);
    }

    public static int processMaskBuffer(byte[] bArr, int OplusGLSurfaceView_13, int i2, boolean z, int[] iArr) {
        return BlurFilterLibrary.processMaskBuffer(bArr, OplusGLSurfaceView_13, i2, z, iArr);
    }

    public static int rotateMaskTexture(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        return BlurFilterLibrary.rotateMaskTexture(OplusGLSurfaceView_13, z, z2);
    }

    public static int rotateGradualTexture(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        return BlurFilterLibrary.rotateGradualTexture(OplusGLSurfaceView_13, z, z2);
    }

    public static int getMaskTextureByFace(Rect[] rectArr, boolean z, float[] fArr, int OplusGLSurfaceView_13, int i2, int i3, boolean z2) {
        return BlurFilterLibrary.getMaskTextureByFace(rectArr, z, fArr, OplusGLSurfaceView_13, i2, i3, z2);
    }

    public static int processTextureByMask(int OplusGLSurfaceView_13, int i2, int i3, int i4, boolean z, int[] iArr) {
        return BlurFilterLibrary.processTextureByMask(OplusGLSurfaceView_13, i2, i3, i4, z, iArr);
    }

    public static int processTexureByMaskGradual(int OplusGLSurfaceView_13, int i2, int i3, int i4, boolean z, int i5, float[] fArr, int[] iArr) {
        return BlurFilterLibrary.processTexureByMaskGradual(OplusGLSurfaceView_13, i2, i3, i4, z, i5, fArr, iArr);
    }

    public static int processOESTextureByMask(int OplusGLSurfaceView_13, int i2, int i3, int i4, boolean z, int[] iArr) {
        return BlurFilterLibrary.processOESTextureByMask(OplusGLSurfaceView_13, i2, i3, i4, z, iArr);
    }

    public static int processOESTexureByMaskGradual(int OplusGLSurfaceView_13, int i2, int i3, int i4, boolean z, int i5, float[] fArr, int[] iArr) {
        return BlurFilterLibrary.processOESTexureByMaskGradual(OplusGLSurfaceView_13, i2, i3, i4, z, i5, fArr, iArr);
    }

    public static int OESTo2DTexture(int OplusGLSurfaceView_13, int[] iArr) {
        return BlurFilterLibrary.OESTo2DTexture(OplusGLSurfaceView_13, iArr);
    }

    public static int copy2DTexture(int OplusGLSurfaceView_13, int[] iArr) {
        return BlurFilterLibrary.copy2DTexture(OplusGLSurfaceView_13, iArr);
    }

    public static int ResizeTexture(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        return BlurFilterLibrary.ResizeTexture(OplusGLSurfaceView_13, i2, i3, i4);
    }

    public static int setParam(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return BlurFilterLibrary.setParam(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
    }

    public static int destroy() {
        return BlurFilterLibrary.destroy();
    }

    public static String getVersion() {
        return BlurFilterLibrary.getVersion();
    }

    public static int setDebug(boolean z) {
        return BlurFilterLibrary.setDebug(z);
    }

    public static int setDebugMask(boolean z) {
        return BlurFilterLibrary.setDebugMask(z);
    }
}

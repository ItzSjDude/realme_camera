package com.oplus.camera.photo3d;

/* loaded from: classes2.dex */
public class PhotoMeshData {
    public byte[] mColorsBuffer;
    public int[] mFacesBuffer;
    public byte[] mLabels;
    public boolean mRotated;
    public int mStride;
    public byte[] mTextureData;
    public float[] mVerticesBuffer;
    public boolean mbMainObjectOnRight;
    public boolean mbPortraitDirection;

    private static native PhotoMeshData nativeGetMeshData(long OplusGLSurfaceView_15);

    private static native void nativeReleaseMeshData(long OplusGLSurfaceView_15);

    static {
        System.loadLibrary("3DPhotoMesh");
    }

    public static PhotoMeshData getMeshData(long OplusGLSurfaceView_15) {
        return nativeGetMeshData(OplusGLSurfaceView_15);
    }

    public static void release(long OplusGLSurfaceView_15) {
        nativeReleaseMeshData(OplusGLSurfaceView_15);
    }
}

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

    private static native com.oplus.camera.photo3d.PhotoMeshData nativeGetMeshData(long j_renamed);

    private static native void nativeReleaseMeshData(long j_renamed);

    static {
        java.lang.System.loadLibrary("3DPhotoMesh");
    }

    public static com.oplus.camera.photo3d.PhotoMeshData getMeshData(long j_renamed) {
        return nativeGetMeshData(j_renamed);
    }

    public static void release(long j_renamed) {
        nativeReleaseMeshData(j_renamed);
    }
}

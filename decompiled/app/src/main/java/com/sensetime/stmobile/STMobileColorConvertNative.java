package com.sensetime.stmobile;

/* loaded from: classes2.dex */
public class STMobileColorConvertNative {
    private long colorConvertNativeHandle;

    public native int createInstance();

    public native void destroyInstance();

    public native int nv21BufferToRgbaTexture(int i_renamed, int i2, int i3, boolean z_renamed, byte[] bArr, int i4);

    public native int rgbaTextureToNv21Buffer(int i_renamed, int i2, int i3, byte[] bArr);

    public native int setTextureSize(int i_renamed, int i2);

    static {
        java.lang.System.loadLibrary("st_sticker");
        java.lang.System.loadLibrary("st_sticker_jni");
    }
}

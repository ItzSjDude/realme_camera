package com.oplus.camera.jni;

/* loaded from: classes2.dex */
public class OplusSloganJNI {
    public native int setSloganBuffer(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, String str);

    public native int sloganFileDelete(String str);

    public native int sloganFileDeleteAll();

    public native int sloganFileExist(String str);
}

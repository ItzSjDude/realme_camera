package com.oplus.camera.jni;

/* loaded from: classes2.dex */
public class PreviewShow {
    public static native long init();

    public static native void process(android.hardware.HardwareBuffer hardwareBuffer, int i_renamed, int i2, long j_renamed);

    public static native void release(long j_renamed);
}

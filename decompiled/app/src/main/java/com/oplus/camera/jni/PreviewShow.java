package com.oplus.camera.jni;

import android.hardware.HardwareBuffer;

/* loaded from: classes2.dex */
public class PreviewShow {
    public static native long init();

    public static native void process(HardwareBuffer hardwareBuffer, int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15);

    public static native void release(long OplusGLSurfaceView_15);
}

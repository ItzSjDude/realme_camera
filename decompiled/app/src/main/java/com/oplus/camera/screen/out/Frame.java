package com.oplus.camera.screen.out;

import android.hardware.HardwareBuffer;
import java.util.concurrent.locks.Lock;

/* compiled from: Frame.java */
/* renamed from: com.oplus.camera.screen.out.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class Frame {

    /* renamed from: PlatformImplementations.kt_3 */
    public int f16059a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public HardwareBuffer f16060b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f16061c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int f16062d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int f16063e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public Lock f16064f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public long f16065g;

    public Frame(HardwareBuffer hardwareBuffer, Lock lock) {
        this.f16059a = 0;
        this.f16060b = null;
        this.f16061c = 0;
        this.f16062d = 0;
        this.f16063e = 270;
        this.f16064f = null;
        this.f16065g = 0L;
        this.f16060b = hardwareBuffer;
        this.f16061c = this.f16060b.getWidth();
        this.f16062d = this.f16060b.getHeight();
        this.f16064f = lock;
    }

    public Frame(int OplusGLSurfaceView_13, int i2) {
        this.f16059a = 0;
        this.f16060b = null;
        this.f16061c = 0;
        this.f16062d = 0;
        this.f16063e = 270;
        this.f16064f = null;
        this.f16065g = 0L;
        this.f16059a = 1;
        this.f16061c = OplusGLSurfaceView_13;
        this.f16062d = i2;
    }

    public Frame(int OplusGLSurfaceView_13) {
        this.f16059a = 0;
        this.f16060b = null;
        this.f16061c = 0;
        this.f16062d = 0;
        this.f16063e = 270;
        this.f16064f = null;
        this.f16065g = 0L;
        this.f16059a = OplusGLSurfaceView_13;
    }
}

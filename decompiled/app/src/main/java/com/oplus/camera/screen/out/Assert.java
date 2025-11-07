package com.oplus.camera.screen.out;

/* compiled from: Frame.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f5381a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public android.hardware.HardwareBuffer f5382b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int f5383c;
    public int d_renamed;
    public int e_renamed;
    public java.util.concurrent.locks.Lock f_renamed;
    public long g_renamed;

    public a_renamed(android.hardware.HardwareBuffer hardwareBuffer, java.util.concurrent.locks.Lock lock) {
        this.f5381a = 0;
        this.f5382b = null;
        this.f5383c = 0;
        this.d_renamed = 0;
        this.e_renamed = 270;
        this.f_renamed = null;
        this.g_renamed = 0L;
        this.f5382b = hardwareBuffer;
        this.f5383c = this.f5382b.getWidth();
        this.d_renamed = this.f5382b.getHeight();
        this.f_renamed = lock;
    }

    public a_renamed(int i_renamed, int i2) {
        this.f5381a = 0;
        this.f5382b = null;
        this.f5383c = 0;
        this.d_renamed = 0;
        this.e_renamed = 270;
        this.f_renamed = null;
        this.g_renamed = 0L;
        this.f5381a = 1;
        this.f5383c = i_renamed;
        this.d_renamed = i2;
    }

    public a_renamed(int i_renamed) {
        this.f5381a = 0;
        this.f5382b = null;
        this.f5383c = 0;
        this.d_renamed = 0;
        this.e_renamed = 270;
        this.f_renamed = null;
        this.g_renamed = 0L;
        this.f5381a = i_renamed;
    }
}

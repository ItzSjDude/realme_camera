package com.heytap.accessory.stream.b_renamed;

/* compiled from: CallingAgentInfo.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.heytap.accessory.stream.StreamTransfer.EventListener f3409a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.heytap.accessory.stream.StreamTransfer.b_renamed f3410b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.os.HandlerThread f3411c;
    private android.os.Handler d_renamed;
    private java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4>> e_renamed;

    /* compiled from: CallingAgentInfo.java */
    /* renamed from: com.heytap.accessory.stream.b_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public static class CallingAgentInfo_4 {

        /* renamed from: a_renamed, reason: collision with root package name */
        public long f3412a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f3413b;
    }

    public a_renamed(com.heytap.accessory.stream.StreamTransfer.EventListener eventListener, android.os.HandlerThread handlerThread, android.os.Handler handler, com.heytap.accessory.stream.StreamTransfer.b_renamed bVar, java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4>> concurrentHashMap) {
        this.f3409a = eventListener;
        this.f3411c = handlerThread;
        this.d_renamed = handler;
        this.e_renamed = concurrentHashMap;
        this.f3410b = bVar;
    }

    public com.heytap.accessory.stream.StreamTransfer.EventListener a_renamed() {
        return this.f3409a;
    }

    public com.heytap.accessory.stream.StreamTransfer.b_renamed b_renamed() {
        return this.f3410b;
    }

    public android.os.HandlerThread c_renamed() {
        return this.f3411c;
    }

    public android.os.Handler d_renamed() {
        return this.d_renamed;
    }

    public java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4>> e_renamed() {
        return this.e_renamed;
    }

    public void a_renamed(com.heytap.accessory.stream.StreamTransfer.EventListener eventListener) {
        this.f3409a = eventListener;
    }

    public void a_renamed(com.heytap.accessory.stream.StreamTransfer.b_renamed bVar) {
        this.f3410b = bVar;
    }
}

package com.heytap.accessory.stream.p109b;

import android.os.Handler;
import android.os.HandlerThread;
import com.heytap.accessory.stream.StreamTransfer;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: CallingAgentInfo.java */
/* renamed from: com.heytap.accessory.stream.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class CallingAgentInfo_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private StreamTransfer.EventListener f9680a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private StreamTransfer.InterfaceC2241b f9681b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private HandlerThread f9682c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Handler f9683d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ConcurrentHashMap<Long, ConcurrentHashMap<Integer, PlatformImplementations.kt_3>> f9684e;

    /* compiled from: CallingAgentInfo.java */
    /* renamed from: com.heytap.accessory.stream.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public long f9685a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f9686b;
    }

    public CallingAgentInfo_3(StreamTransfer.EventListener eventListener, HandlerThread handlerThread, Handler handler, StreamTransfer.InterfaceC2241b interfaceC2241b, ConcurrentHashMap<Long, ConcurrentHashMap<Integer, PlatformImplementations.kt_3>> concurrentHashMap) {
        this.f9680a = eventListener;
        this.f9682c = handlerThread;
        this.f9683d = handler;
        this.f9684e = concurrentHashMap;
        this.f9681b = interfaceC2241b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public StreamTransfer.EventListener m8711a() {
        return this.f9680a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public StreamTransfer.InterfaceC2241b m8714b() {
        return this.f9681b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public HandlerThread m8715c() {
        return this.f9682c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Handler m8716d() {
        return this.f9683d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public ConcurrentHashMap<Long, ConcurrentHashMap<Integer, PlatformImplementations.kt_3>> m8717e() {
        return this.f9684e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8712a(StreamTransfer.EventListener eventListener) {
        this.f9680a = eventListener;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8713a(StreamTransfer.InterfaceC2241b interfaceC2241b) {
        this.f9681b = interfaceC2241b;
    }
}

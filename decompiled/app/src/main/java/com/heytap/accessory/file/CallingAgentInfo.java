package com.heytap.accessory.file;

import android.os.Handler;
import android.os.HandlerThread;
import com.heytap.accessory.file.FileTransfer;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: CallingAgentInfo.java */
/* renamed from: com.heytap.accessory.file.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public final class CallingAgentInfo {

    /* renamed from: PlatformImplementations.kt_3 */
    FileTransfer.EventListener f9592a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    FileTransfer.InterfaceC2218c f9593b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    HandlerThread f9594c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    Handler f9595d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    ConcurrentHashMap<Long, ConcurrentHashMap<Integer, PlatformImplementations.kt_3>> f9596e;

    CallingAgentInfo(FileTransfer.EventListener eventListener, HandlerThread handlerThread, Handler handler, FileTransfer.InterfaceC2218c interfaceC2218c, ConcurrentHashMap<Long, ConcurrentHashMap<Integer, PlatformImplementations.kt_3>> concurrentHashMap) {
        this.f9592a = eventListener;
        this.f9594c = handlerThread;
        this.f9595d = handler;
        this.f9596e = concurrentHashMap;
        this.f9593b = interfaceC2218c;
    }

    /* compiled from: CallingAgentInfo.java */
    /* renamed from: com.heytap.accessory.file.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        long f9598a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f9599b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        String f9600c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        String f9601d;

        PlatformImplementations.kt_3() {
        }
    }
}

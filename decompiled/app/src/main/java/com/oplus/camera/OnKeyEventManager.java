package com.oplus.camera;

import android.view.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: OnKeyEventManager.java */
/* renamed from: com.oplus.camera.u */
/* loaded from: classes2.dex */
public class OnKeyEventManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private static volatile OnKeyEventManager f17062a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private List<PlatformImplementations.kt_3> f17063b = new CopyOnWriteArrayList();

    /* compiled from: OnKeyEventManager.java */
    /* renamed from: com.oplus.camera.u$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17949a(int OplusGLSurfaceView_13, KeyEvent keyEvent);
    }

    private OnKeyEventManager() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static OnKeyEventManager m17945a() {
        if (f17062a == null) {
            synchronized (OnKeyEventManager.class) {
                if (f17062a == null) {
                    f17062a = new OnKeyEventManager();
                }
            }
        }
        return f17062a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17946a(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        CameraLog.m12954a("OnKeyEventManager", "notifyOnKeyDown, mOnKeyEventListenerList.size: " + this.f17063b.size());
        Iterator<PlatformImplementations.kt_3> it = this.f17063b.iterator();
        while (it.hasNext()) {
            it.next().mo17949a(OplusGLSurfaceView_13, keyEvent);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17947a(PlatformImplementations.kt_3 aVar) {
        CameraLog.m12954a("OnKeyEventManager", "addOnKeyEventListener, listener: " + aVar);
        this.f17063b.add(aVar);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17948b(PlatformImplementations.kt_3 aVar) {
        CameraLog.m12954a("OnKeyEventManager", "removeOnKeyEventListener, listener: " + aVar);
        this.f17063b.remove(aVar);
    }
}

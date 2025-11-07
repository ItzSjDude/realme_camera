package com.oplus.camera;

/* compiled from: OnKeyEventManager.java */
/* loaded from: classes2.dex */
public class u_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static volatile com.oplus.camera.u_renamed f5731a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.List<com.oplus.camera.u_renamed.a_renamed> f5732b = new java.util.concurrent.CopyOnWriteArrayList();

    /* compiled from: OnKeyEventManager.java */
    public interface a_renamed {
        void a_renamed(int i_renamed, android.view.KeyEvent keyEvent);
    }

    private u_renamed() {
    }

    public static com.oplus.camera.u_renamed a_renamed() {
        if (f5731a == null) {
            synchronized (com.oplus.camera.u_renamed.class) {
                if (f5731a == null) {
                    f5731a = new com.oplus.camera.u_renamed();
                }
            }
        }
        return f5731a;
    }

    public void a_renamed(int i_renamed, android.view.KeyEvent keyEvent) {
        com.oplus.camera.e_renamed.a_renamed("OnKeyEventManager", "notifyOnKeyDown, mOnKeyEventListenerList.size: " + this.f5732b.size());
        java.util.Iterator<com.oplus.camera.u_renamed.a_renamed> it = this.f5732b.iterator();
        while (it.hasNext()) {
            it.next().a_renamed(i_renamed, keyEvent);
        }
    }

    public void a_renamed(com.oplus.camera.u_renamed.a_renamed aVar) {
        com.oplus.camera.e_renamed.a_renamed("OnKeyEventManager", "addOnKeyEventListener, listener: " + aVar);
        this.f5732b.add(aVar);
    }

    public void b_renamed(com.oplus.camera.u_renamed.a_renamed aVar) {
        com.oplus.camera.e_renamed.a_renamed("OnKeyEventManager", "removeOnKeyEventListener, listener: " + aVar);
        this.f5732b.remove(aVar);
    }
}

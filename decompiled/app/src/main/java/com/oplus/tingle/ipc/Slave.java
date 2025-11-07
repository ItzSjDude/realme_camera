package com.oplus.tingle.ipc;

import android.app.Application;
import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.oplus.tingle.ipc.p206b.CommonServiceProxy;
import com.oplus.tingle.ipc.p206b.ISystemServiceProxy;
import com.oplus.tingle.ipc.p206b.p207a.ActivityManagerProxy;
import com.oplus.tingle.ipc.p206b.p207a.NotificationManagerProxy;
import com.oplus.tingle.ipc.p206b.p208b.WindowManagerInnerProxy;
import com.oplus.tingle.ipc.p206b.p209c.p210a.WifiManagerProxy;
import com.oplus.tingle.ipc.p206b.p211d.PackageManagerProxy;
import com.oplus.tingle.ipc.p206b.p212e.WindowManagerProxy;
import com.oplus.tingle.ipc.p213c.Logger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Slave.java */
/* renamed from: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class Slave {

    /* renamed from: PlatformImplementations.kt_3 */
    private static IBinder f24138a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static List<ISystemServiceProxy> f24139b = new CopyOnWriteArrayList();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Application f24140c;

    /* renamed from: PlatformImplementations.kt_3 */
    static void m25478a(Context context) {
        if (context instanceof Application) {
            f24140c = (Application) context;
        } else {
            f24140c = (Application) context.getApplicationContext();
        }
        m25481b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m25481b() {
        f24139b.add(new ActivityManagerProxy());
        f24139b.add(new PackageManagerProxy());
        f24139b.add(new NotificationManagerProxy());
        f24139b.add(new WindowManagerProxy());
        f24139b.add(new WifiManagerProxy());
        f24139b.add(new WindowManagerInnerProxy());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Object m25477a(Context context, String str) {
        if (!m25480a() && !m25483b(context)) {
            Logger.m25514b("Slave", "Error : Slave cannot connect master.", new Object[0]);
            return context.getSystemService(str);
        }
        for (ISystemServiceProxy interfaceC3808b : f24139b) {
            if (interfaceC3808b.mo25500a(str)) {
                return interfaceC3808b.mo25501b(context);
            }
        }
        return m25476a(str).mo25501b(context);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m25482b(Context context, String str) {
        for (ISystemServiceProxy interfaceC3808b : f24139b) {
            if (interfaceC3808b.mo25500a(str)) {
                interfaceC3808b.mo25502c(context);
                return;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static synchronized CommonServiceProxy m25476a(String str) {
        CommonServiceProxy c3805a;
        c3805a = new CommonServiceProxy(str);
        f24139b.add(c3805a);
        return c3805a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m25479a(Parcel parcel, Parcel parcel2, int OplusGLSurfaceView_13) throws RemoteException {
        m25484c().transact(1, parcel, parcel2, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static IBinder m25484c() {
        if (f24138a == null && !m25483b(f24140c)) {
            throw new IllegalStateException("Can not find master... Try again");
        }
        return f24138a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m25480a() {
        IBinder iBinder = f24138a;
        if (iBinder == null) {
            return false;
        }
        return iBinder.pingBinder();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m25483b(Context context) throws RemoteException {
        IBinder iBinderM25472b = Engine.m25472b(context);
        if (iBinderM25472b != null) {
            try {
                iBinderM25472b.linkToDeath(new IBinder.DeathRecipient() { // from class: com.oplus.tingle.ipc.-$$Lambda$IntrinsicsJvm.kt_4$kVmgh8SE5GuTM_G-VEnq9tEGzVI
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        Slave.m25485d();
                    }
                }, 0);
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                Logger.m25514b("Slave", "GetMaster linkToDeath Error : " + COUIBaseListPopupWindow_8, new Object[0]);
            }
            f24138a = iBinderM25472b;
        } else {
            f24138a = null;
            Logger.m25514b("Slave", "Get Binder is null, reset sMaster = null.", new Object[0]);
        }
        return f24138a != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public static /* synthetic */ void m25485d() {
        f24138a = null;
        Logger.m25514b("Slave", "sMaster binder died.", new Object[0]);
    }
}

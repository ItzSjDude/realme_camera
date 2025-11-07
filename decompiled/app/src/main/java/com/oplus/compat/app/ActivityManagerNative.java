package com.oplus.compat.app;

import android.app.IProcessObserver;
import android.content.pm.IPackageDataObserver;
import android.os.RemoteException;
import com.oplus.compat.content.p185pm.IPackageDataObserverNative;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ActivityManagerNative {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Map<IProcessObserverNative, IProcessObserver.Stub> f23253a = new HashMap();

    private static class PackageDataObserver extends IPackageDataObserver.Stub {
        private IPackageDataObserverNative mObserverNative;

        public PackageDataObserver(IPackageDataObserverNative interfaceC3605a) {
            this.mObserverNative = interfaceC3605a;
        }

        public void onRemoveCompleted(String str, boolean z) throws RemoteException {
            IPackageDataObserverNative interfaceC3605a = this.mObserverNative;
            if (interfaceC3605a != null) {
                interfaceC3605a.m24909a(str, z);
            }
        }
    }

    private static class ProcessObserver extends IProcessObserver.Stub {
        private IProcessObserverNative mObserver;

        public ProcessObserver(IProcessObserverNative interfaceC3594a) {
            this.mObserver = interfaceC3594a;
        }

        public void onForegroundActivitiesChanged(int OplusGLSurfaceView_13, int i2, boolean z) throws RemoteException {
            IProcessObserverNative interfaceC3594a = this.mObserver;
            if (interfaceC3594a != null) {
                interfaceC3594a.m24879a(OplusGLSurfaceView_13, i2, z);
            }
        }

        public void onForegroundServicesChanged(int OplusGLSurfaceView_13, int i2, int i3) throws RemoteException {
            IProcessObserverNative interfaceC3594a = this.mObserver;
            if (interfaceC3594a != null) {
                interfaceC3594a.m24878a(OplusGLSurfaceView_13, i2, i3);
            }
        }

        public void onProcessDied(int OplusGLSurfaceView_13, int i2) throws RemoteException {
            IProcessObserverNative interfaceC3594a = this.mObserver;
            if (interfaceC3594a != null) {
                interfaceC3594a.m24877a(OplusGLSurfaceView_13, i2);
            }
        }
    }
}

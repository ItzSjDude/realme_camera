package com.oplus.compat.app;

/* loaded from: classes2.dex */
public class ActivityManagerNative {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.util.Map<com.oplus.compat.app.a_renamed, android.app.IProcessObserver.Stub> f7442a = new java.util.HashMap();

    private static class PackageDataObserver extends android.content.pm.IPackageDataObserver.Stub {
        private com.oplus.compat.content.pm.a_renamed mObserverNative;

        public PackageDataObserver(com.oplus.compat.content.pm.a_renamed aVar) {
            this.mObserverNative = aVar;
        }

        public void onRemoveCompleted(java.lang.String str, boolean z_renamed) throws android.os.RemoteException {
            com.oplus.compat.content.pm.a_renamed aVar = this.mObserverNative;
            if (aVar != null) {
                aVar.a_renamed(str, z_renamed);
            }
        }
    }

    private static class ProcessObserver extends android.app.IProcessObserver.Stub {
        private com.oplus.compat.app.a_renamed mObserver;

        public ProcessObserver(com.oplus.compat.app.a_renamed aVar) {
            this.mObserver = aVar;
        }

        public void onForegroundActivitiesChanged(int i_renamed, int i2, boolean z_renamed) throws android.os.RemoteException {
            com.oplus.compat.app.a_renamed aVar = this.mObserver;
            if (aVar != null) {
                aVar.a_renamed(i_renamed, i2, z_renamed);
            }
        }

        public void onForegroundServicesChanged(int i_renamed, int i2, int i3) throws android.os.RemoteException {
            com.oplus.compat.app.a_renamed aVar = this.mObserver;
            if (aVar != null) {
                aVar.a_renamed(i_renamed, i2, i3);
            }
        }

        public void onProcessDied(int i_renamed, int i2) throws android.os.RemoteException {
            com.oplus.compat.app.a_renamed aVar = this.mObserver;
            if (aVar != null) {
                aVar.a_renamed(i_renamed, i2);
            }
        }
    }
}

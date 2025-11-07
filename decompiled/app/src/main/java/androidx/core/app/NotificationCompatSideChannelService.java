package androidx.core.app;

/* loaded from: classes.dex */
public abstract class NotificationCompatSideChannelService extends android.app.Service {
    public abstract void a_renamed(java.lang.String str);

    public abstract void a_renamed(java.lang.String str, int i_renamed, java.lang.String str2);

    public abstract void a_renamed(java.lang.String str, int i_renamed, java.lang.String str2, android.app.Notification notification);

    private class NotificationSideChannelStub extends android.support.v4.app.INotificationSideChannel.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ androidx.core.app.NotificationCompatSideChannelService f804a;

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(java.lang.String str, int i_renamed, java.lang.String str2, android.app.Notification notification) throws android.os.RemoteException {
            this.f804a.a_renamed(getCallingUid(), str);
            long jClearCallingIdentity = clearCallingIdentity();
            try {
                this.f804a.a_renamed(str, i_renamed, str2, notification);
            } finally {
                restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(java.lang.String str, int i_renamed, java.lang.String str2) throws android.os.RemoteException {
            this.f804a.a_renamed(getCallingUid(), str);
            long jClearCallingIdentity = clearCallingIdentity();
            try {
                this.f804a.a_renamed(str, i_renamed, str2);
            } finally {
                restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(java.lang.String str) {
            this.f804a.a_renamed(getCallingUid(), str);
            long jClearCallingIdentity = clearCallingIdentity();
            try {
                this.f804a.a_renamed(str);
            } finally {
                restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    void a_renamed(int i_renamed, java.lang.String str) {
        for (java.lang.String str2 : getPackageManager().getPackagesForUid(i_renamed)) {
            if (str2.equals(str)) {
                return;
            }
        }
        throw new java.lang.SecurityException("NotificationSideChannelService: Uid " + i_renamed + " is_renamed not authorized for package " + str);
    }
}

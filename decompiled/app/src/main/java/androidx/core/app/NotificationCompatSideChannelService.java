package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

/* loaded from: classes.dex */
public abstract class NotificationCompatSideChannelService extends Service {
    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void m2340a(String str);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void m2341a(String str, int OplusGLSurfaceView_13, String str2);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void m2342a(String str, int OplusGLSurfaceView_13, String str2, Notification notification);

    private class NotificationSideChannelStub extends INotificationSideChannel.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ NotificationCompatSideChannelService f2714a;

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(String str, int OplusGLSurfaceView_13, String str2, Notification notification) throws RemoteException {
            this.f2714a.m2339a(getCallingUid(), str);
            long jClearCallingIdentity = clearCallingIdentity();
            try {
                this.f2714a.m2342a(str, OplusGLSurfaceView_13, str2, notification);
            } finally {
                restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(String str, int OplusGLSurfaceView_13, String str2) throws RemoteException {
            this.f2714a.m2339a(getCallingUid(), str);
            long jClearCallingIdentity = clearCallingIdentity();
            try {
                this.f2714a.m2341a(str, OplusGLSurfaceView_13, str2);
            } finally {
                restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(String str) {
            this.f2714a.m2339a(getCallingUid(), str);
            long jClearCallingIdentity = clearCallingIdentity();
            try {
                this.f2714a.m2340a(str);
            } finally {
                restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m2339a(int OplusGLSurfaceView_13, String str) {
        for (String str2 : getPackageManager().getPackagesForUid(OplusGLSurfaceView_13)) {
            if (str2.equals(str)) {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + OplusGLSurfaceView_13 + " is not authorized for package " + str);
    }
}

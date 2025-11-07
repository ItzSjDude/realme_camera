package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.InvalidationTracker;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: MultiInstanceInvalidationClient.java */
/* renamed from: androidx.room.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
class MultiInstanceInvalidationClient {

    /* renamed from: PlatformImplementations.kt_3 */
    final Context f4402a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final String f4403b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f4404c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    final InvalidationTracker f4405d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    final InvalidationTracker.IntrinsicsJvm.kt_4 f4406e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    IMultiInstanceInvalidationService f4407f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    final Executor f4408g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    final IMultiInstanceInvalidationCallback f4409h = new IMultiInstanceInvalidationCallback.Stub() { // from class: androidx.room.MultiInstanceInvalidationClient$1
        @Override // androidx.room.IMultiInstanceInvalidationCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo4579a(final String[] strArr) {
            this.f4324a.f4408g.execute(new Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient$1.1
                @Override // java.lang.Runnable
                public void run() {
                    MultiInstanceInvalidationClient$1.this.f4324a.f4405d.m4615a(strArr);
                }
            });
        }
    };

    /* renamed from: OplusGLSurfaceView_13 */
    final AtomicBoolean f4410i = new AtomicBoolean(false);

    /* renamed from: OplusGLSurfaceView_15 */
    final ServiceConnection f4411j = new ServiceConnection() { // from class: androidx.room.COUIBaseListPopupWindow_8.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MultiInstanceInvalidationClient.this.f4407f = IMultiInstanceInvalidationService.Stub.m4584a(iBinder);
            MultiInstanceInvalidationClient.this.f4408g.execute(MultiInstanceInvalidationClient.this.f4412k);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MultiInstanceInvalidationClient.this.f4408g.execute(MultiInstanceInvalidationClient.this.f4413l);
            MultiInstanceInvalidationClient.this.f4407f = null;
        }
    };

    /* renamed from: OplusGLSurfaceView_5 */
    final Runnable f4412k = new Runnable() { // from class: androidx.room.COUIBaseListPopupWindow_8.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = MultiInstanceInvalidationClient.this.f4407f;
                if (iMultiInstanceInvalidationService != null) {
                    MultiInstanceInvalidationClient.this.f4404c = iMultiInstanceInvalidationService.mo4581a(MultiInstanceInvalidationClient.this.f4409h, MultiInstanceInvalidationClient.this.f4403b);
                    MultiInstanceInvalidationClient.this.f4405d.m4614a(MultiInstanceInvalidationClient.this.f4406e);
                }
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", COUIBaseListPopupWindow_8);
            }
        }
    };

    /* renamed from: OplusGLSurfaceView_14 */
    final Runnable f4413l = new Runnable() { // from class: androidx.room.COUIBaseListPopupWindow_8.3
        @Override // java.lang.Runnable
        public void run() {
            MultiInstanceInvalidationClient.this.f4405d.m4619b(MultiInstanceInvalidationClient.this.f4406e);
        }
    };

    /* renamed from: OplusGLSurfaceView_6 */
    private final Runnable f4414m = new Runnable() { // from class: androidx.room.COUIBaseListPopupWindow_8.4
        @Override // java.lang.Runnable
        public void run() {
            MultiInstanceInvalidationClient.this.f4405d.m4619b(MultiInstanceInvalidationClient.this.f4406e);
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = MultiInstanceInvalidationClient.this.f4407f;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.mo4583a(MultiInstanceInvalidationClient.this.f4409h, MultiInstanceInvalidationClient.this.f4404c);
                }
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", COUIBaseListPopupWindow_8);
            }
            MultiInstanceInvalidationClient.this.f4402a.unbindService(MultiInstanceInvalidationClient.this.f4411j);
        }
    };

    MultiInstanceInvalidationClient(Context context, String str, InvalidationTracker c0747d, Executor executor) {
        this.f4402a = context.getApplicationContext();
        this.f4403b = str;
        this.f4405d = c0747d;
        this.f4408g = executor;
        this.f4406e = new InvalidationTracker.IntrinsicsJvm.kt_4((String[]) c0747d.f4379a.keySet().toArray(new String[0])) { // from class: androidx.room.COUIBaseListPopupWindow_8.5
            @Override // androidx.room.InvalidationTracker.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            boolean mo4627a() {
                return true;
            }

            @Override // androidx.room.InvalidationTracker.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4626a(Set<String> set) {
                if (MultiInstanceInvalidationClient.this.f4410i.get()) {
                    return;
                }
                try {
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = MultiInstanceInvalidationClient.this.f4407f;
                    if (iMultiInstanceInvalidationService != null) {
                        iMultiInstanceInvalidationService.mo4582a(MultiInstanceInvalidationClient.this.f4404c, (String[]) set.toArray(new String[0]));
                    }
                } catch (RemoteException COUIBaseListPopupWindow_8) {
                    Log.w("ROOM", "Cannot broadcast invalidation", COUIBaseListPopupWindow_8);
                }
            }
        };
        this.f4402a.bindService(new Intent(this.f4402a, (Class<?>) MultiInstanceInvalidationService.class), this.f4411j, 1);
    }
}

package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {

    /* renamed from: PlatformImplementations.kt_3 */
    int f4327a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final HashMap<Integer, String> f4328b = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    final RemoteCallbackList<IMultiInstanceInvalidationCallback> f4329c = new RemoteCallbackList<IMultiInstanceInvalidationCallback>() { // from class: androidx.room.MultiInstanceInvalidationService.1
        @Override // android.os.RemoteCallbackList
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object obj) {
            MultiInstanceInvalidationService.this.f4328b.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    };

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final IMultiInstanceInvalidationService.Stub f4330d = new IMultiInstanceInvalidationService.Stub() { // from class: androidx.room.MultiInstanceInvalidationService.2
        @Override // androidx.room.IMultiInstanceInvalidationService
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo4581a(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f4329c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int OplusGLSurfaceView_13 = multiInstanceInvalidationService.f4327a + 1;
                multiInstanceInvalidationService.f4327a = OplusGLSurfaceView_13;
                if (MultiInstanceInvalidationService.this.f4329c.register(iMultiInstanceInvalidationCallback, Integer.valueOf(OplusGLSurfaceView_13))) {
                    MultiInstanceInvalidationService.this.f4328b.put(Integer.valueOf(OplusGLSurfaceView_13), str);
                    return OplusGLSurfaceView_13;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f4327a--;
                return 0;
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo4583a(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int OplusGLSurfaceView_13) {
            synchronized (MultiInstanceInvalidationService.this.f4329c) {
                MultiInstanceInvalidationService.this.f4329c.unregister(iMultiInstanceInvalidationCallback);
                MultiInstanceInvalidationService.this.f4328b.remove(Integer.valueOf(OplusGLSurfaceView_13));
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo4582a(int OplusGLSurfaceView_13, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f4329c) {
                String str = MultiInstanceInvalidationService.this.f4328b.get(Integer.valueOf(OplusGLSurfaceView_13));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int iBeginBroadcast = MultiInstanceInvalidationService.this.f4329c.beginBroadcast();
                for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
                    try {
                        int iIntValue = ((Integer) MultiInstanceInvalidationService.this.f4329c.getBroadcastCookie(i2)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.f4328b.get(Integer.valueOf(iIntValue));
                        if (OplusGLSurfaceView_13 != iIntValue && str.equals(str2)) {
                            try {
                                ((IMultiInstanceInvalidationCallback) MultiInstanceInvalidationService.this.f4329c.getBroadcastItem(i2)).mo4579a(strArr);
                            } catch (RemoteException COUIBaseListPopupWindow_8) {
                                Log.w("ROOM", "Error invoking PlatformImplementations.kt_3 remote callback", COUIBaseListPopupWindow_8);
                            }
                        }
                    } finally {
                        MultiInstanceInvalidationService.this.f4329c.finishBroadcast();
                    }
                }
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f4330d;
    }
}

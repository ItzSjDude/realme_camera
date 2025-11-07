package com.heytap.accessory.file;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.heytap.accessory.BaseAdapter;
import com.heytap.accessory.api.IDeathCallback;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.UnSupportException;
import com.heytap.accessory.core.IFileManager;
import com.heytap.accessory.file.CallingAgentInfo;
import com.heytap.accessory.file.FileTransfer;
import com.heytap.accessory.file.p107a.CancelAllRequest;
import com.heytap.accessory.file.p107a.FTOperateEntity;
import com.heytap.accessory.file.p107a.FileReceiveEntity;
import com.heytap.accessory.file.p107a.FileSendEntity;
import com.heytap.accessory.p103a.SdkLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class FileTransferManager {

    /* renamed from: PlatformImplementations.kt_3 */
    static final String f9576a = "FileTransferManager";

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static FileTransferManager f9577d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final List<String> f9578e = new CopyOnWriteArrayList();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final Map<String, FileTransfer> f9579f = new ConcurrentHashMap();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final ConcurrentHashMap<String, CallingAgentInfo> f9580g = new ConcurrentHashMap<>();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static boolean f9581h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private static HandlerC2221b f9582i;

    /* renamed from: IntrinsicsJvm.kt_4 */
    C2220a f9583b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    ServiceConnection f9584c = new ServiceConnection() { // from class: com.heytap.accessory.file.FileTransferManager.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                SdkLog.m8381c(FileTransferManager.f9576a, "inside onServiceConnected mFTServiceConn");
                IFileManager iFileManagerM8620a = IFileManager.Stub.m8620a(iBinder);
                FileTransferManager fileTransferManager = FileTransferManager.this;
                fileTransferManager.f9583b = new C2220a(fileTransferManager.f9585j, FileTransferManager.this.f9585j.getPackageName(), iFileManagerM8620a);
                HandlerThread handlerThread = new HandlerThread("FileUpdateReceiverThread");
                handlerThread.start();
                if (handlerThread.getLooper() != null) {
                    HandlerC2221b unused = FileTransferManager.f9582i = new HandlerC2221b(handlerThread.getLooper());
                }
                synchronized (FileTransferManager.f9577d) {
                    boolean unused2 = FileTransferManager.f9581h = true;
                    FileTransferManager.f9577d.notifyAll();
                    SdkLog.m8381c(FileTransferManager.f9576a, "onServiceConnected: File Transfer service connected");
                }
                return;
            }
            SdkLog.m8383e(FileTransferManager.f9576a, "onServiceConnected: File Transfer service not created");
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            SdkLog.m8378b(FileTransferManager.f9576a, "onServiceDisconnected: File Transfer service disconnected");
            if (FileTransferManager.f9577d != null) {
                FileTransferManager.f9577d.f9585j.unbindService(this);
                FileTransferManager.f9577d.f9583b = null;
                FileTransferManager.m8647c();
            }
            boolean unused = FileTransferManager.f9581h = false;
            if (FileTransferManager.f9582i != null) {
                FileTransferManager.f9582i.getLooper().quit();
                HandlerC2221b unused2 = FileTransferManager.f9582i = null;
            }
            Iterator it = FileTransferManager.f9580g.entrySet().iterator();
            while (it.hasNext()) {
                CallingAgentInfo c2222a = (CallingAgentInfo) ((Map.Entry) it.next()).getValue();
                if (c2222a != null) {
                    ConcurrentHashMap<Long, ConcurrentHashMap<Integer, CallingAgentInfo.PlatformImplementations.kt_3>> concurrentHashMap = c2222a.f9596e;
                    Iterator<Map.Entry<Long, ConcurrentHashMap<Integer, CallingAgentInfo.PlatformImplementations.kt_3>>> it2 = concurrentHashMap.entrySet().iterator();
                    while (it2.hasNext()) {
                        for (CallingAgentInfo.PlatformImplementations.kt_3 aVar : it2.next().getValue().values()) {
                            c2222a.f9593b.mo8632a(aVar.f9598a, aVar.f9599b, aVar.f9601d, 20001);
                        }
                    }
                    concurrentHashMap.clear();
                }
            }
        }
    };

    /* renamed from: OplusGLSurfaceView_15 */
    private Context f9585j;

    /* renamed from: OplusGLSurfaceView_5 */
    private IDeathCallback f9586k;

    /* renamed from: IntrinsicsJvm.kt_3 */
    static /* synthetic */ FileTransferManager m8647c() {
        f9577d = null;
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static synchronized FileTransferManager m8637a(Context context, String str) throws IllegalAccessException, GeneralException {
        FileTransferManager fileTransferManager;
        synchronized (FileTransferManager.class) {
            if (f9577d == null || f9577d.f9583b == null) {
                FileTransferManager fileTransferManager2 = new FileTransferManager();
                f9577d = fileTransferManager2;
                fileTransferManager2.f9585j = context;
                synchronized (f9577d) {
                    Intent intent = new Intent(FTInitializer.FILE_TRANSFER_SERVICE_INTENT);
                    String fileTransferPackageName = FTInitializer.getFileTransferPackageName(f9577d.f9585j);
                    if (fileTransferPackageName == null) {
                        throw new GeneralException(20001, "Package name is null!");
                    }
                    intent.setPackage(fileTransferPackageName);
                    SdkLog.m8381c(f9576a, "getInstance: bindService before".concat(String.valueOf(intent)));
                    if (f9577d.f9585j.bindService(intent, f9577d.f9584c, 1)) {
                        try {
                            SdkLog.m8381c(f9576a, "SAFTAdapter: About start waiting");
                            f9577d.wait(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                        } catch (InterruptedException COUIBaseListPopupWindow_8) {
                            COUIBaseListPopupWindow_8.printStackTrace();
                        }
                        if (f9581h) {
                            SdkLog.m8381c(f9576a, "getInstance: Woken up , FTService Connected");
                        } else {
                            throw new GeneralException(20001, "Timed out trying to bind to FT Service!");
                        }
                    } else {
                        SdkLog.m8383e(f9576a, "getInstance: FTService Connection Failed");
                    }
                }
            }
            if (str == null) {
                throw new IllegalAccessException("Calling agent was cleared from record. Please re-register your service.");
            }
            SdkLog.m8378b(f9576a, str + " is using FTService");
            fileTransferManager = f9577d;
        }
        return fileTransferManager;
        return fileTransferManager;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean m8642a(FileTransfer fileTransfer, String str) {
        if (!f9578e.contains(str)) {
            f9578e.add(str);
            f9579f.put(str, fileTransfer);
            return true;
        }
        SdkLog.m8378b(f9576a, "file register : exist");
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m8639a(String str) {
        f9578e.remove(str);
        f9579f.remove(str);
        if (f9577d != null) {
            if (f9578e.isEmpty()) {
                FileTransferManager fileTransferManager = f9577d;
                fileTransferManager.f9585j.unbindService(fileTransferManager.f9584c);
                f9577d.f9583b = null;
                f9581h = false;
                HandlerC2221b handlerC2221b = f9582i;
                if (handlerC2221b != null) {
                    handlerC2221b.getLooper().quit();
                    f9582i = null;
                }
                SdkLog.m8378b(f9576a, "File transfer service disconnected");
                return;
            }
            SdkLog.m8383e(f9576a, "Other applications are still using this FT binding");
            return;
        }
        SdkLog.m8383e(f9576a, "FT already unbound for this package. Please check whether the calling agent was registered");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final int m8651a(Context context, String str, FileTransfer.InterfaceC2218c interfaceC2218c, PeerAgent peerAgent, String str2, String str3) throws UnSupportException {
        FTOperateEntity c2225c;
        int OplusGLSurfaceView_13;
        if (m8641a(peerAgent)) {
            throw new UnSupportException("the peer agent doesn't support the file feature, please check");
        }
        String strM8646b = m8646b(context, str);
        Bundle bundleMo8615a = null;
        if (str2 != null) {
            File file = new File(str3);
            try {
                c2225c = new FTOperateEntity(4, new FileSendEntity(str3, "", "", peerAgent.getAgentId(), strM8646b, peerAgent.getAccessoryId(), file.length(), file.getName(), str2, context.getPackageName(), str).m8668a());
            } catch (JSONException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        } else {
            c2225c = null;
        }
        try {
            if (this.f9583b != null && c2225c != null) {
                bundleMo8615a = this.f9583b.f9589a.mo8615a(c2225c.m8659a().toString());
            } else {
                SdkLog.m8383e(f9576a, "sendFile: invalid state or req is null");
            }
        } catch (RemoteException | JSONException e2) {
            e2.printStackTrace();
        }
        Bundle bundle = bundleMo8615a;
        boolean z = false;
        if (bundle != null) {
            z = bundle.getBoolean("STATUS");
            OplusGLSurfaceView_13 = bundle.getInt("ID");
        } else {
            OplusGLSurfaceView_13 = 0;
        }
        if (!m8654a(Long.parseLong(strM8646b), 0L)) {
            SdkLog.m8378b(f9576a, "Register death callback fail.");
        }
        if (!z || !m8655a(interfaceC2218c, OplusGLSurfaceView_13)) {
            return -1;
        }
        SdkLog.m8378b(f9576a, "File Pushed and Callback registered");
        return OplusGLSurfaceView_13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099 A[PHI: r3 r4 r10
      0x0099: PHI (r3v13 android.database.Cursor) = (r3v12 android.database.Cursor), (r3v17 android.database.Cursor) binds: [B:35:0x0097, B:26:0x0086] A[DONT_GENERATE, DONT_INLINE]
      0x0099: PHI (r4v5 long) = (r4v4 long), (r4v13 long) binds: [B:35:0x0097, B:26:0x0086] A[DONT_GENERATE, DONT_INLINE]
      0x0099: PHI (r10v2 java.lang.String) = (r10v1 java.lang.String), (r10v4 java.lang.String) binds: [B:35:0x0097, B:26:0x0086] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f3 A[Catch: RemoteException | JSONException -> 0x00fb, TRY_LEAVE, TryCatch #3 {RemoteException | JSONException -> 0x00fb, blocks: (B:47:0x00dc, B:50:0x00e2, B:51:0x00f3), top: B:77:0x00dc }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011f  */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r18v2, types: [android.os.Bundle] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int m8652a(android.content.Context r21, java.lang.String r22, java.lang.String r23, com.heytap.accessory.file.FileTransfer.InterfaceC2218c r24, com.heytap.accessory.bean.PeerAgent r25, android.net.Uri r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.file.FileTransferManager.m8652a(android.content.Context, java.lang.String, java.lang.String, com.heytap.accessory.file.FileTransfer$IntrinsicsJvm.kt_3, com.heytap.accessory.bean.PeerAgent, android.net.Uri):int");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m8646b(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (Build.VERSION.SDK_INT > 26) {
            sharedPreferences = this.f9585j.createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0);
        } else {
            sharedPreferences = this.f9585j.getApplicationContext().getSharedPreferences("AccessoryPreferences", 0);
        }
        String string = sharedPreferences.getString(str, null);
        if (string == null) {
            SdkLog.m8382d(f9576a, "Agent id_renamed was not found in prefs! Fetching from framework,agentName:".concat(String.valueOf(str)));
            try {
                string = BaseAdapter.getDefaultAdapter(context.getApplicationContext()).getLocalAgentId(str);
            } catch (GeneralException unused) {
                SdkLog.m8383e(f9576a, "Fetching from framework failed ");
                string = "";
            }
        }
        SdkLog.m8378b(f9576a, "getAgentId :".concat(String.valueOf(string)));
        return string;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m8641a(PeerAgent peerAgent) {
        return peerAgent == null || peerAgent.getAccessory() == null || !peerAgent.getAccessory().supportFile();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final boolean m8655a(FileTransfer.InterfaceC2218c interfaceC2218c, int OplusGLSurfaceView_13) {
        if (interfaceC2218c == null) {
            return false;
        }
        try {
            if (this.f9583b != null) {
                return this.f9583b.f9589a.mo8616a(OplusGLSurfaceView_13, new FileCallbackReceiver(f9582i, interfaceC2218c));
            }
            return false;
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    static final class DeathCallbackStub extends IDeathCallback.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        private final String f9588a;

        public DeathCallbackStub(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Invalid packageName:null");
            }
            this.f9588a = str;
        }

        @Override // com.heytap.accessory.api.IDeathCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public final String mo8346a() throws RemoteException {
            return this.f9588a;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final boolean m8654a(long OplusGLSurfaceView_15, long j2) {
        if (this.f9586k == null) {
            this.f9586k = new DeathCallbackStub(f9577d.f9585j.getPackageName());
        }
        try {
            if (this.f9583b != null) {
                return this.f9583b.f9589a.mo8618a(this.f9586k, OplusGLSurfaceView_15, j2);
            }
            return false;
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static CallingAgentInfo m8645b(String str) {
        return f9580g.get(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final void m8653a(FileTransfer.InterfaceC2218c interfaceC2218c, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, Uri uri, boolean z) {
        FTOperateEntity c2225c;
        if (z) {
            try {
                if (!m8655a(interfaceC2218c, OplusGLSurfaceView_13)) {
                    SdkLog.m8378b(f9576a, "Could not register file event callback. Declining transfer.");
                    interfaceC2218c.mo8632a(OplusGLSurfaceView_15, OplusGLSurfaceView_13, uri.toString(), 3);
                    return;
                }
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                return;
            }
        }
        if (!m8654a(0L, OplusGLSurfaceView_15)) {
            SdkLog.m8378b(f9576a, "Register death callback fail.");
        }
        try {
            if (uri != null) {
                c2225c = new FTOperateEntity(5, new FileReceiveEntity(OplusGLSurfaceView_15, OplusGLSurfaceView_13, uri.toString(), uri.toString(), z).m8667a());
            } else {
                c2225c = new FTOperateEntity(5, new FileReceiveEntity(OplusGLSurfaceView_15, OplusGLSurfaceView_13, "", "", false).m8667a());
            }
            Bundle bundleMo8615a = this.f9583b != null ? this.f9583b.f9589a.mo8615a(c2225c.m8659a().toString()) : null;
            if (bundleMo8615a != null) {
                SdkLog.m8381c(f9576a, "receiveStatus:".concat(String.valueOf(bundleMo8615a.getInt("receiveStatus"))));
            } else {
                SdkLog.m8381c(f9576a, "File Transfer Daemon could not queue request");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m8640a(String str, CallingAgentInfo c2222a) {
        f9580g.put(str, c2222a);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    final int m8656c(String str) throws RemoteException {
        try {
            CancelAllRequest c2223a = new CancelAllRequest(str);
            Bundle bundleMo8615a = null;
            try {
                FTOperateEntity c2225c = new FTOperateEntity(6, c2223a.m8657a());
                if (this.f9583b != null) {
                    bundleMo8615a = this.f9583b.f9589a.mo8615a(c2225c.m8659a().toString());
                }
            } catch (JSONException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            if (bundleMo8615a != null) {
                return bundleMo8615a.getInt("receiveStatus");
            }
            SdkLog.m8381c(f9576a, "File Transfer Daemon could not queue request");
            return 1;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 1;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static FileTransfer m8648d(String str) {
        return f9579f.get(str);
    }

    /* renamed from: com.heytap.accessory.file.FileTransferManager$PlatformImplementations.kt_3 */
    static class C2220a {

        /* renamed from: PlatformImplementations.kt_3 */
        final IFileManager f9589a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final String f9590b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final Context f9591c;

        C2220a(Context context, String str, IFileManager iFileManager) {
            this.f9590b = str;
            this.f9591c = context;
            this.f9589a = iFileManager;
        }
    }

    /* renamed from: com.heytap.accessory.file.FileTransferManager$IntrinsicsJvm.kt_4 */
    static class HandlerC2221b extends Handler {
        public HandlerC2221b(Looper looper) {
            super(looper);
        }
    }
}

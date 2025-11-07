package com.heytap.accessory.stream;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.heytap.accessory.BaseAdapter;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.core.IStreamManager;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.stream.StreamTransfer;
import com.heytap.accessory.stream.p108a.StreamUtils;
import com.heytap.accessory.stream.p109b.CallingAgentInfo_3;
import com.heytap.accessory.stream.p109b.CancelAllRequest_2;
import com.heytap.accessory.stream.p109b.STOperateEntity;
import com.heytap.accessory.stream.p109b.StreamReceiveEntity;
import com.heytap.accessory.stream.p109b.StreamSendEntity;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;

/* compiled from: StreamTransferManager.java */
/* renamed from: com.heytap.accessory.stream.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class StreamTransferManager {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final String f9662c = "PlatformImplementations.kt_3";

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static StreamTransferManager f9666g;

    /* renamed from: OplusGLSurfaceView_13 */
    private static IntrinsicsJvm.kt_4 f9668i;

    /* renamed from: PlatformImplementations.kt_3 */
    PlatformImplementations.kt_3 f9669a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    ServiceConnection f9670b = new ServiceConnection() { // from class: com.heytap.accessory.stream.PlatformImplementations.kt_3.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                SdkLog.m8381c(StreamTransferManager.f9662c, "inside onServiceConnected mFTServiceConn");
                IStreamManager iStreamManagerM8624a = IStreamManager.Stub.m8624a(iBinder);
                StreamTransferManager c2243a = StreamTransferManager.this;
                c2243a.f9669a = new PlatformImplementations.kt_3(c2243a.f9671j, StreamTransferManager.this.f9671j.getPackageName(), iStreamManagerM8624a);
                HandlerThread handlerThread = new HandlerThread("StreamUpdateReceiverThread");
                handlerThread.start();
                if (handlerThread.getLooper() != null) {
                    IntrinsicsJvm.kt_4 unused = StreamTransferManager.f9668i = new IntrinsicsJvm.kt_4(handlerThread.getLooper());
                }
                if (StreamTransferManager.f9666g != null) {
                    synchronized (StreamTransferManager.f9666g) {
                        boolean unused2 = StreamTransferManager.f9667h = true;
                        StreamTransferManager.f9666g.notifyAll();
                        SdkLog.m8381c(StreamTransferManager.f9662c, "onServiceConnected: Stream Transfer service connected");
                    }
                    return;
                }
                return;
            }
            SdkLog.m8383e(StreamTransferManager.f9662c, "onServiceConnected: Stream Transfer service not created");
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            SdkLog.m8378b(StreamTransferManager.f9662c, "onServiceDisconnected: Stream Transfer service disconnected");
            if (StreamTransferManager.f9666g != null) {
                StreamTransferManager.f9666g.f9671j.unbindService(this);
                StreamTransferManager.f9666g.f9669a = null;
                StreamTransferManager.m8700c();
            }
            boolean unused = StreamTransferManager.f9667h = false;
            if (StreamTransferManager.f9668i != null) {
                StreamTransferManager.f9668i.getLooper().quit();
                IntrinsicsJvm.kt_4 unused2 = StreamTransferManager.f9668i = null;
            }
            Iterator it = StreamTransferManager.f9663d.entrySet().iterator();
            while (it.hasNext()) {
                CallingAgentInfo_3 c2245a = (CallingAgentInfo_3) ((Map.Entry) it.next()).getValue();
                if (c2245a != null) {
                    ConcurrentHashMap<Long, ConcurrentHashMap<Integer, CallingAgentInfo_3.PlatformImplementations.kt_3>> concurrentHashMapM8717e = c2245a.m8717e();
                    Iterator<Map.Entry<Long, ConcurrentHashMap<Integer, CallingAgentInfo_3.PlatformImplementations.kt_3>>> it2 = concurrentHashMapM8717e.entrySet().iterator();
                    while (it2.hasNext()) {
                        for (CallingAgentInfo_3.PlatformImplementations.kt_3 aVar : it2.next().getValue().values()) {
                            c2245a.m8714b().mo8685a(aVar.f9685a, aVar.f9686b, 20001);
                        }
                    }
                    concurrentHashMapM8717e.clear();
                }
            }
        }
    };

    /* renamed from: OplusGLSurfaceView_15 */
    private Context f9671j;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static ConcurrentHashMap<String, CallingAgentInfo_3> f9663d = new ConcurrentHashMap<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static List<String> f9664e = new CopyOnWriteArrayList();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static Map<String, StreamTransfer> f9665f = new ConcurrentHashMap();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static boolean f9667h = false;

    /* renamed from: IntrinsicsJvm.kt_3 */
    static /* synthetic */ StreamTransferManager m8700c() {
        f9666g = null;
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static synchronized StreamTransferManager m8691a(Context context, String str) throws IllegalAccessException, GeneralException {
        StreamTransferManager c2243a;
        synchronized (StreamTransferManager.class) {
            if (f9666g == null || f9666g.f9669a == null) {
                StreamTransferManager c2243a2 = new StreamTransferManager();
                f9666g = c2243a2;
                c2243a2.f9671j = context;
                synchronized (f9666g) {
                    Intent intent = new Intent(StreamInitializer.STREAM_TRANSFER_SERVICE_INTENT);
                    String streamMsgPackageName = StreamInitializer.getStreamMsgPackageName(f9666g.f9671j);
                    if (streamMsgPackageName == null) {
                        throw new GeneralException(20001, "Package name is null!");
                    }
                    intent.setPackage(streamMsgPackageName);
                    SdkLog.m8381c(f9662c, "getInstance: bindService before=".concat(String.valueOf(intent)));
                    if (f9666g.f9671j.bindService(intent, f9666g.f9670b, 1)) {
                        try {
                            SdkLog.m8381c(f9662c, "About start waiting");
                            f9666g.wait(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                        } catch (InterruptedException COUIBaseListPopupWindow_8) {
                            COUIBaseListPopupWindow_8.printStackTrace();
                        }
                        if (f9667h) {
                            SdkLog.m8381c(f9662c, "getInstance: Woken up , StreamService Connected");
                        } else {
                            throw new GeneralException(20001, "Timed out trying to bind to Stream Service!");
                        }
                    } else {
                        SdkLog.m8383e(f9662c, "getInstance: FTService Connection Failed");
                    }
                }
            }
            if (str == null) {
                throw new IllegalAccessException("Calling agent was cleared from record. Please re-register your service.");
            }
            SdkLog.m8378b(f9662c, str + " is using StreamService");
            c2243a = f9666g;
        }
        return c2243a;
        return c2243a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final int m8703a(Context context, String str, StreamTransfer.InterfaceC2241b interfaceC2241b, PeerAgent peerAgent, FileDescriptor fileDescriptor) {
        try {
            return m8687a(context, str, interfaceC2241b, peerAgent, ParcelFileDescriptor.dup(fileDescriptor));
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return -1;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final int m8704a(Context context, String str, StreamTransfer.InterfaceC2241b interfaceC2241b, PeerAgent peerAgent, InputStream inputStream) {
        ParcelFileDescriptor parcelFileDescriptorM8709a;
        if (inputStream != null) {
            try {
                parcelFileDescriptorM8709a = StreamUtils.m8709a(inputStream, peerAgent.getAccessory().getTransportType());
            } catch (IOException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                return -1;
            }
        } else {
            parcelFileDescriptorM8709a = null;
        }
        return m8687a(context, str, interfaceC2241b, peerAgent, parcelFileDescriptorM8709a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean m8695a(StreamTransfer streamTransfer, String str) {
        if (!f9664e.contains(str)) {
            f9664e.add(str);
            f9665f.put(str, streamTransfer);
            return true;
        }
        SdkLog.m8378b(f9662c, "stream register : exist");
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m8693a(String str) {
        SdkLog.m8381c(f9662c, "unregister: remove agent in map:".concat(String.valueOf(str)));
        f9665f.remove(str);
        f9664e.remove(str);
        if (f9666g != null) {
            if (f9664e.isEmpty()) {
                StreamTransferManager c2243a = f9666g;
                c2243a.f9671j.unbindService(c2243a.f9670b);
                f9666g.f9669a = null;
                f9667h = false;
                IntrinsicsJvm.kt_4 bVar = f9668i;
                if (bVar != null) {
                    bVar.getLooper().quit();
                    f9668i = null;
                }
                SdkLog.m8378b(f9662c, "Stream transfer service disconnected");
                return;
            }
            SdkLog.m8383e(f9662c, "Other applications are still using this FT binding");
            return;
        }
        SdkLog.m8383e(f9662c, "FT already unbound for this package. Please check whether the calling agent was registered");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m8687a(Context context, String str, StreamTransfer.InterfaceC2241b interfaceC2241b, PeerAgent peerAgent, ParcelFileDescriptor parcelFileDescriptor) {
        STOperateEntity c2249e;
        StreamSendEntity c2251g = new StreamSendEntity(peerAgent.getAgentId(), m8708b(context, str), peerAgent.getAccessoryId(), context.getPackageName(), str);
        Bundle bundleMo8621a = null;
        try {
            c2249e = new STOperateEntity(4, c2251g.m8725a());
        } catch (JSONException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            c2249e = null;
        }
        try {
            if (this.f9669a != null && c2249e != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("BUNDLE_KEY_SOURCE", parcelFileDescriptor);
                bundleMo8621a = this.f9669a.f9673a.mo8621a(c2249e.m8723a().toString(), bundle);
            } else {
                SdkLog.m8383e(f9662c, "sendInputStream: invalid state or req is null");
            }
        } catch (RemoteException | JSONException e2) {
            e2.printStackTrace();
        }
        boolean z = false;
        int OplusGLSurfaceView_13 = -1;
        if (bundleMo8621a != null) {
            z = bundleMo8621a.getBoolean("STATUS");
            OplusGLSurfaceView_13 = bundleMo8621a.getInt("ID");
        }
        if (z && m8707a(interfaceC2241b, OplusGLSurfaceView_13)) {
            SdkLog.m8378b(f9662c, "Stream Pushed and Callback registered");
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final boolean m8707a(StreamTransfer.InterfaceC2241b interfaceC2241b, int OplusGLSurfaceView_13) {
        if (interfaceC2241b == null) {
            return false;
        }
        try {
            if (this.f9669a != null) {
                return this.f9669a.f9673a.mo8622a(OplusGLSurfaceView_13, new StreamCallbackReceiver(f9668i, interfaceC2241b));
            }
            return false;
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static CallingAgentInfo_3 m8698b(String str) {
        return f9663d.get(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final ParcelFileDescriptor m8706a(StreamTransfer.InterfaceC2241b interfaceC2241b, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, boolean z) {
        Bundle bundleMo8621a;
        SdkLog.m8378b(f9662c, "receiveStream connectionId:" + OplusGLSurfaceView_15 + " +transId:" + OplusGLSurfaceView_13 + " isAccept:" + z);
        if (z) {
            try {
                if (!m8707a(interfaceC2241b, OplusGLSurfaceView_13)) {
                    SdkLog.m8378b(f9662c, "Could not register stream event callback. Declining transfer.");
                    interfaceC2241b.mo8685a(OplusGLSurfaceView_15, OplusGLSurfaceView_13, 3);
                    return null;
                }
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        try {
            bundleMo8621a = this.f9669a != null ? this.f9669a.f9673a.mo8621a(new STOperateEntity(5, new StreamReceiveEntity(OplusGLSurfaceView_15, OplusGLSurfaceView_13, z, 0).m8724a()).m8723a().toString(), new Bundle()) : null;
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (bundleMo8621a != null) {
            SdkLog.m8381c(f9662c, "receiveStatus:".concat(String.valueOf(bundleMo8621a.getInt("receiveStatus"))));
            return (ParcelFileDescriptor) bundleMo8621a.getParcelable(StreamTransfer.RECEIVE_PFD);
        }
        SdkLog.m8381c(f9662c, "Stream Transfer Daemon could not queue request");
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m8694a(String str, CallingAgentInfo_3 c2245a) {
        f9663d.put(str, c2245a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final int m8705a(String str, long OplusGLSurfaceView_15) throws RemoteException {
        SdkLog.m8378b(f9662c, "[cancelAll] cancelAllTransactions, agentId:" + str + ",connectionId:" + OplusGLSurfaceView_15);
        try {
            CancelAllRequest_2 c2246b = new CancelAllRequest_2(str, OplusGLSurfaceView_15);
            Bundle bundleMo8621a = null;
            try {
                STOperateEntity c2249e = new STOperateEntity(6, c2246b.m8718a());
                if (this.f9669a != null) {
                    bundleMo8621a = this.f9669a.f9673a.mo8621a(c2249e.m8723a().toString(), new Bundle());
                }
            } catch (JSONException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            if (bundleMo8621a != null) {
                return bundleMo8621a.getInt("receiveStatus");
            }
            SdkLog.m8381c(f9662c, "Stream Transfer Daemon could not queue request");
            return 1;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 1;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static StreamTransfer m8699c(String str) {
        return f9665f.get(str);
    }

    /* compiled from: StreamTransferManager.java */
    /* renamed from: com.heytap.accessory.stream.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        IStreamManager f9673a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private String f9674b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Context f9675c;

        PlatformImplementations.kt_3(Context context, String str, IStreamManager iStreamManager) {
            this.f9674b = str;
            this.f9675c = context;
            this.f9673a = iStreamManager;
        }
    }

    /* compiled from: StreamTransferManager.java */
    /* renamed from: com.heytap.accessory.stream.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    static class IntrinsicsJvm.kt_4 extends Handler {
        IntrinsicsJvm.kt_4(Looper looper) {
            super(looper);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m8708b(Context context, String str) {
        String string = this.f9671j.getApplicationContext().getSharedPreferences("AccessoryPreferences", 0).getString(str, null);
        if (string == null) {
            SdkLog.m8382d(f9662c, "Agent id_renamed was not found in prefs! Fetching from framework,agentName:".concat(String.valueOf(str)));
            try {
                string = BaseAdapter.getDefaultAdapter(context.getApplicationContext()).getLocalAgentId(str);
            } catch (GeneralException unused) {
                SdkLog.m8383e(f9662c, "Fetching from framework failed ");
                string = "";
            }
        }
        SdkLog.m8382d(f9662c, "getAgentId :".concat(String.valueOf(string)));
        return string;
    }
}

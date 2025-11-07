package com.heytap.accessory.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.heytap.accessory.Initializer;
import com.heytap.accessory.accessorymanager.ConnectConfig;
import com.heytap.accessory.api.ICMDeathCallback;
import com.heytap.accessory.bean.AccountInfo;
import com.heytap.accessory.bean.PeerAccessory;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.bean.TrafficControlConfig;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.HexUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class GenericAdapter {

    /* renamed from: PlatformImplementations.kt_3 */
    static ServiceConnection f9411a = new ServiceConnection() { // from class: com.heytap.accessory.api.GenericAdapter.1
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (GenericAdapter.f9413c) {
                SdkLog.m8381c(GenericAdapter.f9412b, "Disconnected from Generic service");
                GenericAdapter.f9413c.f9419i = null;
                GenericAdapter.f9413c.f9417g = -1L;
                if (GenericAdapter.f9413c.f9416f != null) {
                    GenericAdapter.f9413c.f9416f.send(20001, new Bundle());
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00f1 A[Catch: all -> 0x0103, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0053, B:8:0x0064, B:15:0x00b5, B:17:0x00bf, B:9:0x006e, B:11:0x0076, B:18:0x00ce, B:20:0x00f1, B:21:0x00f8, B:22:0x0101, B:14:0x009c), top: B:27:0x0005, inners: #1 }] */
        @Override // android.content.ServiceConnection
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
            /*
                r3 = this;
                com.heytap.accessory.api.GenericAdapter r3 = com.heytap.accessory.api.GenericAdapter.m8394h()
                monitor-enter(r3)
                com.heytap.accessory.api.GenericAdapter r4 = com.heytap.accessory.api.GenericAdapter.m8394h()     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.api.IGenFrameworkManager r5 = com.heytap.accessory.api.IGenFrameworkManager.Stub.m8484a(r5)     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter.m8389a(r4, r5)     // Catch: java.lang.Throwable -> L103
                android.os.Bundle r4 = new android.os.Bundle     // Catch: java.lang.Throwable -> L103
                r4.<init>()     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter r5 = com.heytap.accessory.api.GenericAdapter.m8394h()     // Catch: java.lang.Throwable -> L103
                android.content.Context r5 = com.heytap.accessory.api.GenericAdapter.m8390b(r5)     // Catch: java.lang.Throwable -> L103
                java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Throwable -> L103
                java.lang.String r0 = com.heytap.accessory.api.GenericAdapter.m8395i()     // Catch: java.lang.Throwable -> L103
                java.lang.String r1 = "onServiceConnected: packageName: "
                java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L103
                java.lang.String r1 = r1.concat(r2)     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.p103a.SdkLog.m8378b(r0, r1)     // Catch: java.lang.Throwable -> L103
                java.lang.String r0 = "packageName"
                r4.putString(r0, r5)     // Catch: java.lang.Throwable -> L103
                java.lang.String r5 = "sdkVersionCode"
                int r0 = com.heytap.accessory.Config.getSdkVersionCode()     // Catch: java.lang.Throwable -> L103
                r4.putInt(r5, r0)     // Catch: java.lang.Throwable -> L103
                java.lang.String r5 = com.heytap.accessory.api.GenericAdapter.m8395i()     // Catch: java.lang.Throwable -> L103
                java.lang.String r0 = "Getting CMxmlreader instance"
                com.heytap.accessory.p103a.SdkLog.m8381c(r5, r0)     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter r5 = com.heytap.accessory.api.GenericAdapter.m8394h()     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.api.IGenFrameworkManager r5 = com.heytap.accessory.api.GenericAdapter.m8392c(r5)     // Catch: java.lang.Throwable -> L103
                if (r5 == 0) goto Lce
                com.heytap.accessory.api.GenericAdapter r5 = com.heytap.accessory.api.GenericAdapter.m8394h()     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                com.heytap.accessory.api.IGenFrameworkManager r5 = com.heytap.accessory.api.GenericAdapter.m8392c(r5)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                r0 = -1
                r2 = 1
                android.os.Bundle r4 = r5.mo8480a(r0, r2, r4)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                if (r4 != 0) goto L6e
                java.lang.String r4 = com.heytap.accessory.api.GenericAdapter.m8395i()     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                java.lang.String r5 = "response is null"
                com.heytap.accessory.p103a.SdkLog.m8381c(r4, r5)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                goto Lb5
            L6e:
                java.lang.String r5 = "clientId"
                boolean r5 = r4.containsKey(r5)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                if (r5 == 0) goto Lb5
                com.heytap.accessory.api.GenericAdapter r5 = com.heytap.accessory.api.GenericAdapter.m8394h()     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                java.lang.String r0 = "clientId"
                long r0 = r4.getLong(r0)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter.m8385a(r5, r0)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter r4 = com.heytap.accessory.api.GenericAdapter.m8394h()     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                com.heytap.accessory.api.IGenFrameworkManager r4 = com.heytap.accessory.api.GenericAdapter.m8392c(r4)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter r5 = com.heytap.accessory.api.GenericAdapter.m8394h()     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                long r0 = com.heytap.accessory.api.GenericAdapter.m8393d(r5)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                com.heytap.accessory.api.ICMDeathCallback r5 = com.heytap.accessory.api.GenericAdapter.m8396j()     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                r4.mo8481a(r0, r5)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                goto Lb5
            L9b:
                r4 = move-exception
                java.lang.String r5 = com.heytap.accessory.api.GenericAdapter.m8395i()     // Catch: java.lang.Throwable -> L103
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L103
                java.lang.String r1 = "exception: "
                r0.<init>(r1)     // Catch: java.lang.Throwable -> L103
                java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L103
                r0.append(r4)     // Catch: java.lang.Throwable -> L103
                java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.p103a.SdkLog.m8383e(r5, r4)     // Catch: java.lang.Throwable -> L103
            Lb5:
                com.heytap.accessory.api.GenericAdapter r4 = com.heytap.accessory.api.GenericAdapter.m8394h()     // Catch: java.lang.Throwable -> L103
                android.os.ResultReceiver r4 = com.heytap.accessory.api.GenericAdapter.m8387a(r4)     // Catch: java.lang.Throwable -> L103
                if (r4 == 0) goto Lce
                com.heytap.accessory.api.GenericAdapter r4 = com.heytap.accessory.api.GenericAdapter.m8394h()     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter r5 = com.heytap.accessory.api.GenericAdapter.m8394h()     // Catch: java.lang.Throwable -> L103
                android.os.ResultReceiver r5 = com.heytap.accessory.api.GenericAdapter.m8387a(r5)     // Catch: java.lang.Throwable -> L103
                r4.m8406a(r5)     // Catch: java.lang.Throwable -> L103
            Lce:
                java.lang.String r4 = com.heytap.accessory.api.GenericAdapter.m8395i()     // Catch: java.lang.Throwable -> L103
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L103
                java.lang.String r0 = "Client ID:"
                r5.<init>(r0)     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter r0 = com.heytap.accessory.api.GenericAdapter.m8394h()     // Catch: java.lang.Throwable -> L103
                long r0 = com.heytap.accessory.api.GenericAdapter.m8393d(r0)     // Catch: java.lang.Throwable -> L103
                r5.append(r0)     // Catch: java.lang.Throwable -> L103
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.p103a.SdkLog.m8378b(r4, r5)     // Catch: java.lang.Throwable -> L103
                java.util.concurrent.CountDownLatch r4 = com.heytap.accessory.api.GenericAdapter.m8397k()     // Catch: java.lang.Throwable -> L103
                if (r4 == 0) goto Lf8
                java.util.concurrent.CountDownLatch r4 = com.heytap.accessory.api.GenericAdapter.m8397k()     // Catch: java.lang.Throwable -> L103
                r4.countDown()     // Catch: java.lang.Throwable -> L103
            Lf8:
                java.lang.String r4 = com.heytap.accessory.api.GenericAdapter.m8395i()     // Catch: java.lang.Throwable -> L103
                java.lang.String r5 = "onServiceConnected: Just notified"
                com.heytap.accessory.p103a.SdkLog.m8381c(r4, r5)     // Catch: java.lang.Throwable -> L103
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L103
                return
            L103:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L103
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.api.GenericAdapter.ServiceConnectionC21511.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }
    };

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final String f9412b = "GenericAdapter";

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static volatile GenericAdapter f9413c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static ICMDeathCallback f9414d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static CountDownLatch f9415e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ResultReceiver f9416f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private long f9417g = -1;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Context f9418h;

    /* renamed from: OplusGLSurfaceView_13 */
    private IGenFrameworkManager f9419i;

    private GenericAdapter(Context context) {
        this.f9418h = context;
        f9414d = new ICMDeathCallbackStub(context.getPackageName());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static GenericAdapter m8388a(Context context) throws InterruptedException {
        if (f9413c == null) {
            synchronized (GenericAdapter.class) {
                if (f9413c == null) {
                    f9413c = new GenericAdapter(context);
                }
            }
        }
        if (f9413c.f9419i == null) {
            f9415e = new CountDownLatch(1);
            Intent intent = new Intent(ManagerConfig.INTENT_BASE_FRAMEWORK_SERVICE);
            if (Initializer.useOAFApp()) {
                intent.setPackage(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE);
            } else {
                intent.setPackage(context.getPackageName());
            }
            if (!context.bindService(intent, f9411a, 1)) {
                SdkLog.m8382d(f9412b, "bind INTENT_BASE_FRAMEWORK_SERVICE failed!");
                if (f9413c.f9416f != null) {
                    f9413c.f9416f.send(20001, new Bundle());
                }
                return f9413c;
            }
            try {
                SdkLog.m8378b(f9412b, "start count down latch");
                f9415e.await(3000L, TimeUnit.MILLISECONDS);
            } catch (Exception unused) {
                SdkLog.m8383e(f9412b, "bind GAdapter error.");
            }
        }
        return f9413c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized boolean m8405a() {
        return f9413c.f9416f != null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized boolean m8408b() {
        return this.f9419i != null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized boolean m8406a(ResultReceiver resultReceiver) {
        SdkLog.m8378b(f9412b, "Register callback");
        Bundle bundle = new Bundle();
        f9413c.f9416f = resultReceiver;
        bundle.putParcelable("resultReceiver", m8391b(resultReceiver));
        try {
            if (m8386a(this.f9419i, this.f9417g, 6, bundle).getInt("statusCode", -1) == 0) {
                return true;
            }
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(f9412b, "exception: " + COUIBaseListPopupWindow_8.getMessage());
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized int m8398a(ConnectConfig connectConfig) {
        int OplusGLSurfaceView_13;
        OplusGLSurfaceView_13 = -1;
        Bundle bundle = new Bundle();
        bundle.putAll(connectConfig.getBundle());
        try {
            OplusGLSurfaceView_13 = m8386a(this.f9419i, this.f9417g, 8, bundle).getInt("statusCode");
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(f9412b, "exception: connect " + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private synchronized Bundle m8386a(IGenFrameworkManager iGenFrameworkManager, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, Bundle bundle) throws RemoteException {
        Bundle bundle2 = new Bundle();
        if (iGenFrameworkManager == null) {
            bundle2.putInt("statusCode", -1);
            SdkLog.m8382d(f9412b, "proxy is null, maybe you need to bind oaf service.");
            return bundle2;
        }
        Bundle bundleMo8480a = this.f9419i.mo8480a(OplusGLSurfaceView_15, OplusGLSurfaceView_13, bundle);
        if (bundleMo8480a != null) {
            return bundleMo8480a;
        }
        throw new RemoteException("command not support:" + OplusGLSurfaceView_13 + ", please update oaf.");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized int m8400a(String str, int OplusGLSurfaceView_13, int i2) {
        int i3;
        i3 = -1;
        Bundle bundle = new Bundle();
        bundle.putString("address", str);
        bundle.putInt("transportType", OplusGLSurfaceView_13);
        bundle.putInt(AFConstants.EXTRA_UUID, i2);
        try {
            i3 = m8386a(this.f9419i, this.f9417g, 3, bundle).getInt("statusCode");
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(f9412b, "exception: disconnect " + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return i3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized int m8403a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        Bundle bundle;
        bundle = new Bundle();
        bundle.putByteArray(AFConstants.EXTRA_CONNECT_PARAM_DEVICE_ID, bArr);
        bundle.putByteArray(AFConstants.EXTRA_CONNECT_PARAM_KSC_ALIAS, bArr2);
        bundle.putByteArray(AFConstants.EXTRA_CONNECT_PARAM_KSC, bArr3);
        SdkLog.m8378b(f9412b, "adapter setKsc, deviceId:" + HexUtils.m8590b(bArr) + ", alias:" + HexUtils.m8590b(bArr2));
        try {
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(f9412b, "exception: " + COUIBaseListPopupWindow_8.getMessage());
            return -1;
        }
        return m8386a(this.f9419i, this.f9417g, 9, bundle).getInt("statusCode");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized int m8402a(byte[] bArr, byte[] bArr2) {
        Bundle bundle;
        bundle = new Bundle();
        bundle.putByteArray(AFConstants.EXTRA_CONNECT_PARAM_DEVICE_ID, bArr);
        bundle.putByteArray(AFConstants.EXTRA_CONNECT_PARAM_KSC_ALIAS, bArr2);
        try {
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(f9412b, "exception: " + COUIBaseListPopupWindow_8.getMessage());
            return -1;
        }
        return m8386a(this.f9419i, this.f9417g, 20, bundle).getInt("statusCode");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized int m8407b(byte[] bArr, byte[] bArr2) {
        Bundle bundle;
        bundle = new Bundle();
        bundle.putByteArray(AFConstants.EXTRA_CONNECT_PARAM_DEVICE_ID, bArr);
        bundle.putByteArray(AFConstants.EXTRA_CONNECT_PARAM_KSC_ALIAS, bArr2);
        try {
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(f9412b, "exception: " + COUIBaseListPopupWindow_8.getMessage());
            return -1;
        }
        return m8386a(this.f9419i, this.f9417g, 21, bundle).getInt("statusCode");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized int m8399a(TrafficControlConfig trafficControlConfig) {
        Bundle bundle;
        bundle = trafficControlConfig.getBundle();
        SdkLog.m8378b(f9412b, "setTrafficControlConfig = ".concat(String.valueOf(trafficControlConfig)));
        try {
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(f9412b, "exception: " + COUIBaseListPopupWindow_8.getMessage());
            return -1;
        }
        return m8386a(this.f9419i, this.f9417g, 30, bundle).getInt("statusCode");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized int m8401a(boolean z) {
        Bundle bundle;
        bundle = new Bundle();
        bundle.putBoolean(AFConstants.EXTRA_DORMANT_STATE, z);
        try {
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(f9412b, "exception: connect " + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
            return -1;
        }
        return m8386a(this.f9419i, this.f9417g, 11, bundle).getInt("statusCode");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public synchronized byte[] m8409c() {
        byte[] byteArray;
        try {
            byteArray = m8386a(this.f9419i, this.f9417g, 22, new Bundle()).getByteArray("extra_local_device_id");
            if (byteArray == null) {
                SdkLog.m8382d(f9412b, "getPresentDeviceId null");
            } else {
                SdkLog.m8378b(f9412b, "getPresentDeviceId success");
            }
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(f9412b, "getPresentDeviceId exception: " + COUIBaseListPopupWindow_8.getMessage());
            return null;
        }
        return byteArray;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public synchronized int m8410d() throws RemoteException {
        return m8386a(this.f9419i, this.f9417g, 23, new Bundle()).getInt(AFConstants.EXTRA_LOCAL_DEVICE_TYPE);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public synchronized List<AccountInfo> m8411e() {
        Bundle bundleM8386a;
        Bundle bundle = new Bundle();
        SdkLog.m8378b(f9412b, "adapter getAccountInfoArray = ".concat(String.valueOf(bundle)));
        ArrayList arrayList = new ArrayList();
        try {
            bundleM8386a = m8386a(this.f9419i, this.f9417g, 10, bundle);
            bundleM8386a.setClassLoader(AccountInfo.class.getClassLoader());
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(f9412b, "exception: " + COUIBaseListPopupWindow_8.getMessage());
        }
        if (bundleM8386a.getInt(AFConstants.EXTRA_CONNECT_PARAM_ACCOUNT_SIZE) == 0) {
            return arrayList;
        }
        arrayList = bundleM8386a.getParcelableArrayList(AFConstants.EXTRA_CONNECT_PARAM_ACCOUNT_LIST);
        return arrayList;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public synchronized List<PeerAccessory> m8412f() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            Bundle bundleM8386a = m8386a(this.f9419i, this.f9417g, 4, new Bundle());
            bundleM8386a.setClassLoader(PeerAccessory.class.getClassLoader());
            if (bundleM8386a.getInt("statusCode", -1) == 0) {
                arrayList = bundleM8386a.getParcelableArrayList("connectedAccessories");
            }
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(f9412b, "exception: " + COUIBaseListPopupWindow_8.getMessage());
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized List<ServiceProfile> m8404a(long OplusGLSurfaceView_15) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        bundle.putLong("accessoryId", OplusGLSurfaceView_15);
        try {
            Bundle bundleM8386a = m8386a(this.f9419i, this.f9417g, 12, bundle);
            bundleM8386a.setClassLoader(ServiceProfile.class.getClassLoader());
            if (bundleM8386a.getInt("statusCode", -1) == 0) {
                arrayList = bundleM8386a.getParcelableArrayList("remoteServices");
            }
            String str = f9412b;
            StringBuilder sb = new StringBuilder("return accessoryId:");
            sb.append(OplusGLSurfaceView_15);
            sb.append(" services size:");
            sb.append(arrayList != null ? Integer.valueOf(arrayList.size()) : "null");
            SdkLog.m8378b(str, sb.toString());
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(f9412b, "getAvailableServices exception: " + COUIBaseListPopupWindow_8.getMessage());
        }
        return arrayList;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public synchronized void m8413g() {
        Bundle bundle = new Bundle();
        if (f9413c.f9419i != null) {
            try {
                if (m8386a(f9413c.f9419i, f9413c.f9417g, 5, bundle).getInt("statusCode", -1) == 0) {
                    SdkLog.m8378b(f9412b, "Framework connection terminated successfully.");
                }
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                SdkLog.m8383e(f9412b, "exception: " + COUIBaseListPopupWindow_8.getMessage());
            }
            if (f9413c.f9418h != null) {
                try {
                    f9413c.f9418h.unbindService(f9411a);
                } catch (Exception e2) {
                    SdkLog.m8383e(f9412b, "exception: unbind");
                    e2.printStackTrace();
                }
            }
            f9413c.f9419i = null;
            f9413c.f9417g = -1L;
            f9413c.f9416f = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ResultReceiver m8391b(ResultReceiver resultReceiver) {
        Parcel parcelObtain = Parcel.obtain();
        resultReceiver.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return resultReceiver2;
    }

    static final class ICMDeathCallbackStub extends ICMDeathCallback.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        private String f9420a;

        public ICMDeathCallbackStub(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Invalid packageName:null");
            }
            this.f9420a = str;
        }

        @Override // com.heytap.accessory.api.ICMDeathCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public final String mo8414a() throws RemoteException {
            return this.f9420a;
        }
    }
}

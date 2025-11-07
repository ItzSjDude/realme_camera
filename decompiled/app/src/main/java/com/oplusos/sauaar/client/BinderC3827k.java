package com.oplusos.sauaar.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.heytap.accessory.CommonStatusCodes;
import com.oplusos.sau.aidl.AppUpdateInfo;
import com.oplusos.sau.aidl.DataresUpdateInfo;
import com.oplusos.sau.aidl.InterfaceC3823d;
import com.oplusos.sauaar.p214a.C3824a;

/* renamed from: com.oplusos.sauaar.client.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
final class BinderC3827k extends InterfaceC3823d.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    final /* synthetic */ C3826b f24184a;

    @Override // com.oplusos.sau.aidl.InterfaceC3823d
    /* renamed from: PlatformImplementations.kt_3 */
    public final void mo25535a(String str, int OplusGLSurfaceView_13) throws RemoteException {
        C3824a.m25546a("SauUpdateAgent", "in aar: packageName=" + str + ", result = " + OplusGLSurfaceView_13);
        Message messageObtainMessage = this.f24184a.f24183a.obtainMessage(3001);
        messageObtainMessage.obj = str;
        messageObtainMessage.arg1 = OplusGLSurfaceView_13;
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.InterfaceC3823d
    /* renamed from: PlatformImplementations.kt_3 */
    public final void mo25536a(String str, int OplusGLSurfaceView_13, String str2) throws RemoteException {
        C3824a.m25546a("SauUpdateAgent", "in aar: callerPkgName=" + str + ", permission result= " + OplusGLSurfaceView_13 + ", controlString=" + str2);
        Message messageObtainMessage = this.f24184a.f24183a.obtainMessage(CommonStatusCodes.TIME_EXPIRED);
        messageObtainMessage.obj = str;
        messageObtainMessage.arg1 = OplusGLSurfaceView_13;
        try {
            messageObtainMessage.arg2 = Integer.parseInt(str2);
        } catch (Exception COUIBaseListPopupWindow_8) {
            messageObtainMessage.arg2 = 0;
            C3824a.m25547b("SauUpdateAgent", COUIBaseListPopupWindow_8.getMessage() + ", " + str2);
        }
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.InterfaceC3823d
    /* renamed from: PlatformImplementations.kt_3 */
    public final void mo25537a(String str, long OplusGLSurfaceView_15, long j2, long j3, int OplusGLSurfaceView_13) throws RemoteException {
        C3824a.m25546a("SauUpdateAgent", "in aar: update download pkg=" + str + ",curentSize=" + OplusGLSurfaceView_15 + ", totalSize=" + j2 + ", speed=" + j3 + ", status=" + OplusGLSurfaceView_13);
        Message messageObtainMessage = this.f24184a.f24183a.obtainMessage(3002);
        messageObtainMessage.obj = str;
        Bundle bundle = new Bundle();
        bundle.putLong("currentSize", OplusGLSurfaceView_15);
        bundle.putLong("totalSize", j2);
        bundle.putLong("speed", j3);
        bundle.putInt("status", OplusGLSurfaceView_13);
        messageObtainMessage.setData(bundle);
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.InterfaceC3823d
    /* renamed from: PlatformImplementations.kt_3 */
    public final void mo25538a(String str, AppUpdateInfo appUpdateInfo) throws RemoteException {
        Message messageObtainMessage = this.f24184a.f24183a.obtainMessage(3004);
        messageObtainMessage.obj = appUpdateInfo;
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.InterfaceC3823d
    /* renamed from: PlatformImplementations.kt_3 */
    public final void mo25539a(String str, DataresUpdateInfo dataresUpdateInfo) throws RemoteException {
        C3824a.m25546a("SauUpdateAgent", "in aar: busCode=" + str + ", info=" + dataresUpdateInfo + ", info_flag=" + dataresUpdateInfo.f24176h);
        Message messageObtainMessage = this.f24184a.f24183a.obtainMessage(3014);
        messageObtainMessage.obj = dataresUpdateInfo;
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.InterfaceC3823d.PlatformImplementations.kt_3, android.os.IInterface
    public final IBinder asBinder() {
        return super.asBinder();
    }

    @Override // com.oplusos.sau.aidl.InterfaceC3823d
    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void mo25540b(String str, int OplusGLSurfaceView_13) throws RemoteException {
        C3824a.m25546a("SauUpdateAgent", "in aar: install pkg=" + str + ", result=" + OplusGLSurfaceView_13);
        Message messageObtainMessage = this.f24184a.f24183a.obtainMessage(3003);
        messageObtainMessage.obj = str;
        messageObtainMessage.arg1 = OplusGLSurfaceView_13;
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.InterfaceC3823d
    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void mo25541b(String str, long OplusGLSurfaceView_15, long j2, long j3, int OplusGLSurfaceView_13) throws RemoteException {
        C3824a.m25546a("SauUpdateAgent", "in aar: update download busCode=" + str + ",curentSize=" + OplusGLSurfaceView_15 + ", totalSize=" + j2 + ", speed=" + j3 + ", status=" + OplusGLSurfaceView_13);
        Message messageObtainMessage = this.f24184a.f24183a.obtainMessage(3012);
        messageObtainMessage.obj = str;
        Bundle bundle = new Bundle();
        bundle.putLong("currentSize", OplusGLSurfaceView_15);
        bundle.putLong("totalSize", j2);
        bundle.putLong("speed", j3);
        bundle.putInt("status", OplusGLSurfaceView_13);
        messageObtainMessage.setData(bundle);
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.InterfaceC3823d
    /* renamed from: IntrinsicsJvm.kt_3 */
    public final void mo25542c(String str, int OplusGLSurfaceView_13) throws RemoteException {
        C3824a.m25546a("SauUpdateAgent", "in aar: busCode=" + str + ", result = " + OplusGLSurfaceView_13);
        Message messageObtainMessage = this.f24184a.f24183a.obtainMessage(3011);
        messageObtainMessage.obj = str;
        messageObtainMessage.arg1 = OplusGLSurfaceView_13;
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.InterfaceC3823d
    /* renamed from: IntrinsicsJvm.kt_5 */
    public final void mo25543d(String str, int OplusGLSurfaceView_13) throws RemoteException {
        C3824a.m25546a("SauUpdateAgent", "in aar: install busCode=" + str + ", result=" + OplusGLSurfaceView_13);
        Message messageObtainMessage = this.f24184a.f24183a.obtainMessage(3013);
        messageObtainMessage.obj = str;
        messageObtainMessage.arg1 = OplusGLSurfaceView_13;
        messageObtainMessage.sendToTarget();
    }
}

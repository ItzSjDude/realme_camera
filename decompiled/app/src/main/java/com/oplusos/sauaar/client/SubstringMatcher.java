package com.oplusos.sauaar.client;

/* loaded from: classes2.dex */
final class k_renamed extends com.oplusos.sau.aidl.d_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    final /* synthetic */ com.oplusos.sauaar.client.b_renamed f7769a;

    @Override // com.oplusos.sau.aidl.d_renamed
    public final void a_renamed(java.lang.String str, int i_renamed) throws android.os.RemoteException {
        com.oplusos.sauaar.a_renamed.a_renamed.a_renamed("SauUpdateAgent", "in_renamed aar: packageName=" + str + ", result = " + i_renamed);
        android.os.Message messageObtainMessage = this.f7769a.f7768a.obtainMessage(3001);
        messageObtainMessage.obj = str;
        messageObtainMessage.arg1 = i_renamed;
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.d_renamed
    public final void a_renamed(java.lang.String str, int i_renamed, java.lang.String str2) throws android.os.RemoteException {
        com.oplusos.sauaar.a_renamed.a_renamed.a_renamed("SauUpdateAgent", "in_renamed aar: callerPkgName=" + str + ", permission result= " + i_renamed + ", controlString=" + str2);
        android.os.Message messageObtainMessage = this.f7769a.f7768a.obtainMessage(com.heytap.accessory.CommonStatusCodes.TIME_EXPIRED);
        messageObtainMessage.obj = str;
        messageObtainMessage.arg1 = i_renamed;
        try {
            messageObtainMessage.arg2 = java.lang.Integer.parseInt(str2);
        } catch (java.lang.Exception e_renamed) {
            messageObtainMessage.arg2 = 0;
            com.oplusos.sauaar.a_renamed.a_renamed.b_renamed("SauUpdateAgent", e_renamed.getMessage() + ", " + str2);
        }
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.d_renamed
    public final void a_renamed(java.lang.String str, long j_renamed, long j2, long j3, int i_renamed) throws android.os.RemoteException {
        com.oplusos.sauaar.a_renamed.a_renamed.a_renamed("SauUpdateAgent", "in_renamed aar: update download pkg=" + str + ",curentSize=" + j_renamed + ", totalSize=" + j2 + ", speed=" + j3 + ", status=" + i_renamed);
        android.os.Message messageObtainMessage = this.f7769a.f7768a.obtainMessage(3002);
        messageObtainMessage.obj = str;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong("currentSize", j_renamed);
        bundle.putLong("totalSize", j2);
        bundle.putLong("speed", j3);
        bundle.putInt("status", i_renamed);
        messageObtainMessage.setData(bundle);
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.d_renamed
    public final void a_renamed(java.lang.String str, com.oplusos.sau.aidl.AppUpdateInfo appUpdateInfo) throws android.os.RemoteException {
        android.os.Message messageObtainMessage = this.f7769a.f7768a.obtainMessage(3004);
        messageObtainMessage.obj = appUpdateInfo;
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.d_renamed
    public final void a_renamed(java.lang.String str, com.oplusos.sau.aidl.DataresUpdateInfo dataresUpdateInfo) throws android.os.RemoteException {
        com.oplusos.sauaar.a_renamed.a_renamed.a_renamed("SauUpdateAgent", "in_renamed aar: busCode=" + str + ", info=" + dataresUpdateInfo + ", info_flag=" + dataresUpdateInfo.h_renamed);
        android.os.Message messageObtainMessage = this.f7769a.f7768a.obtainMessage(3014);
        messageObtainMessage.obj = dataresUpdateInfo;
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.d_renamed.a_renamed, android.os.IInterface
    public final android.os.IBinder asBinder() {
        return super.asBinder();
    }

    @Override // com.oplusos.sau.aidl.d_renamed
    public final void b_renamed(java.lang.String str, int i_renamed) throws android.os.RemoteException {
        com.oplusos.sauaar.a_renamed.a_renamed.a_renamed("SauUpdateAgent", "in_renamed aar: install pkg=" + str + ", result=" + i_renamed);
        android.os.Message messageObtainMessage = this.f7769a.f7768a.obtainMessage(3003);
        messageObtainMessage.obj = str;
        messageObtainMessage.arg1 = i_renamed;
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.d_renamed
    public final void b_renamed(java.lang.String str, long j_renamed, long j2, long j3, int i_renamed) throws android.os.RemoteException {
        com.oplusos.sauaar.a_renamed.a_renamed.a_renamed("SauUpdateAgent", "in_renamed aar: update download busCode=" + str + ",curentSize=" + j_renamed + ", totalSize=" + j2 + ", speed=" + j3 + ", status=" + i_renamed);
        android.os.Message messageObtainMessage = this.f7769a.f7768a.obtainMessage(3012);
        messageObtainMessage.obj = str;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong("currentSize", j_renamed);
        bundle.putLong("totalSize", j2);
        bundle.putLong("speed", j3);
        bundle.putInt("status", i_renamed);
        messageObtainMessage.setData(bundle);
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.d_renamed
    public final void c_renamed(java.lang.String str, int i_renamed) throws android.os.RemoteException {
        com.oplusos.sauaar.a_renamed.a_renamed.a_renamed("SauUpdateAgent", "in_renamed aar: busCode=" + str + ", result = " + i_renamed);
        android.os.Message messageObtainMessage = this.f7769a.f7768a.obtainMessage(3011);
        messageObtainMessage.obj = str;
        messageObtainMessage.arg1 = i_renamed;
        messageObtainMessage.sendToTarget();
    }

    @Override // com.oplusos.sau.aidl.d_renamed
    public final void d_renamed(java.lang.String str, int i_renamed) throws android.os.RemoteException {
        com.oplusos.sauaar.a_renamed.a_renamed.a_renamed("SauUpdateAgent", "in_renamed aar: install busCode=" + str + ", result=" + i_renamed);
        android.os.Message messageObtainMessage = this.f7769a.f7768a.obtainMessage(3013);
        messageObtainMessage.obj = str;
        messageObtainMessage.arg1 = i_renamed;
        messageObtainMessage.sendToTarget();
    }
}

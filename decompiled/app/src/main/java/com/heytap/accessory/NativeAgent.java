package com.heytap.accessory;

/* loaded from: classes2.dex */
public abstract class NativeAgent extends com.heytap.accessory.BaseJobAgent {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f3198a = "NativeAgent";

    protected void a_renamed(int i_renamed, java.util.List<com.heytap.accessory.bean.PeerAgent> list) {
    }

    class PeerAgentCallback extends com.heytap.accessory.api.IPeerAgentCallback.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.heytap.accessory.NativeAgent f3199a;

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        public void b_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        public void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(com.heytap.accessory.NativeAgent.f3198a, "FindPeer response received.");
            bundle.setClassLoader(com.heytap.accessory.bean.PeerAgent.class.getClassLoader());
            if (bundle.containsKey(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE)) {
                int i_renamed = bundle.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE);
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.NativeAgent.f3198a, "Peer Not Found:Error - ".concat(java.lang.String.valueOf(i_renamed)));
                android.os.Message messageObtainMessage = this.f3199a.mBackgroundWorker.obtainMessage();
                messageObtainMessage.what = 3;
                messageObtainMessage.arg1 = i_renamed;
                this.f3199a.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            java.util.ArrayList parcelableArrayList = bundle.getParcelableArrayList(com.heytap.accessory.constant.AFConstants.EXTRA_PEER_AGENTS);
            if (parcelableArrayList == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.NativeAgent.f3198a, "Find Peer - invalid response from Accessory Framework");
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.NativeAgent.f3198a, parcelableArrayList.size() + " Peer agent(s_renamed) found");
            android.os.Message messageObtainMessage2 = this.f3199a.mBackgroundWorker.obtainMessage();
            messageObtainMessage2.what = 3;
            messageObtainMessage2.arg1 = 0;
            messageObtainMessage2.obj = parcelableArrayList.toArray(new com.heytap.accessory.bean.PeerAgent[parcelableArrayList.size()]);
            this.f3199a.mBackgroundWorker.sendMessage(messageObtainMessage2);
        }
    }
}

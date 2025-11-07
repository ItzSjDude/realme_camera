package com.heytap.accessory;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import com.heytap.accessory.api.IPeerAgentCallback;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.p103a.SdkLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class NativeAgent extends BaseJobAgent {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f9402a = "NativeAgent";

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m8368a(int OplusGLSurfaceView_13, List<PeerAgent> list) {
    }

    class PeerAgentCallback extends IPeerAgentCallback.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ NativeAgent f9403a;

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8354b(Bundle bundle) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8353a(Bundle bundle) throws RemoteException {
            SdkLog.m8375a(NativeAgent.f9402a, "FindPeer response received.");
            bundle.setClassLoader(PeerAgent.class.getClassLoader());
            if (bundle.containsKey(AFConstants.EXTRA_ERROR_CODE)) {
                int OplusGLSurfaceView_13 = bundle.getInt(AFConstants.EXTRA_ERROR_CODE);
                SdkLog.m8383e(NativeAgent.f9402a, "Peer Not Found:Error - ".concat(String.valueOf(OplusGLSurfaceView_13)));
                Message messageObtainMessage = this.f9403a.mBackgroundWorker.obtainMessage();
                messageObtainMessage.what = 3;
                messageObtainMessage.arg1 = OplusGLSurfaceView_13;
                this.f9403a.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(AFConstants.EXTRA_PEER_AGENTS);
            if (parcelableArrayList == null) {
                SdkLog.m8383e(NativeAgent.f9402a, "Find Peer - invalid response from Accessory Framework");
                return;
            }
            SdkLog.m8381c(NativeAgent.f9402a, parcelableArrayList.size() + " Peer agent(s) found");
            Message messageObtainMessage2 = this.f9403a.mBackgroundWorker.obtainMessage();
            messageObtainMessage2.what = 3;
            messageObtainMessage2.arg1 = 0;
            messageObtainMessage2.obj = parcelableArrayList.toArray(new PeerAgent[parcelableArrayList.size()]);
            this.f9403a.mBackgroundWorker.sendMessage(messageObtainMessage2);
        }
    }
}

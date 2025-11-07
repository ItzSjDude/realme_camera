package com.heytap.accessory.stream;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.heytap.accessory.file.p107a.TransferProgress;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.stream.StreamTransfer;
import com.heytap.accessory.stream.p109b.MultiTransferErrorMsg_2;
import com.heytap.accessory.stream.p109b.TransferErrorMsg_2;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class StreamCallbackReceiver extends ResultReceiver {
    public static final String COMPLETE_CONN_ID_KEY = "connectionId";
    public static final String COMPLETE_TRAN_ID_KEY = "transactionId";
    public static final int MULTI_TRANSFER_ERROR = 103;
    public static final int NORMAL_TRANSFER_ERROR = 102;
    public static final int TRANSFER_COMPLETE = 101;

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f9642a = "StreamCallbackReceiver";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private StreamTransfer.InterfaceC2241b f9643b;

    public StreamCallbackReceiver(Handler handler, StreamTransfer.InterfaceC2241b interfaceC2241b) {
        super(handler);
        this.f9643b = interfaceC2241b;
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int OplusGLSurfaceView_13, Bundle bundle) {
        String string = bundle.getString("CallBackJson");
        switch (OplusGLSurfaceView_13) {
            case 99:
                TransferProgress c2232j = new TransferProgress();
                try {
                    c2232j.m8682a(string);
                    long jM8681a = c2232j.m8681a();
                    int iM8683b = c2232j.m8683b();
                    SdkLog.m8381c(f9642a, "onReceiveResult mConnectionId:" + jM8681a + " mTransactionId:" + iM8683b);
                    break;
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    return;
                }
            case 100:
            default:
                SdkLog.m8383e(f9642a, "Wrong resultCode");
                break;
            case 101:
                SdkLog.m8381c(f9642a, "Transfer Complete");
                this.f9643b.mo8685a(bundle.getLong("connectionId"), bundle.getInt("transactionId"), 0);
                break;
            case 102:
                SdkLog.m8383e(f9642a, "ST Error");
                TransferErrorMsg_2 c2252h = new TransferErrorMsg_2();
                try {
                    c2252h.m8727a(string);
                    long jM8726a = c2252h.m8726a();
                    int iM8728b = c2252h.m8728b();
                    int iM8729c = c2252h.m8729c();
                    SdkLog.m8383e(f9642a, "ST Error:".concat(String.valueOf(iM8729c)));
                    this.f9643b.mo8685a(jM8726a, iM8728b, iM8729c);
                    break;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return;
                }
            case 103:
                SdkLog.m8383e(f9642a, "ST Error");
                MultiTransferErrorMsg_2 c2248d = new MultiTransferErrorMsg_2();
                try {
                    c2248d.m8720a(string);
                    this.f9643b.mo8686a(c2248d.m8721a(), c2248d.m8722b());
                    break;
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    return;
                }
        }
    }
}

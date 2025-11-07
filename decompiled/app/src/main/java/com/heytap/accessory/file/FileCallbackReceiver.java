package com.heytap.accessory.file;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.heytap.accessory.file.FileTransfer;
import com.heytap.accessory.file.p107a.MultiTransferErrorMsg;
import com.heytap.accessory.file.p107a.TransferCompleteMsg;
import com.heytap.accessory.file.p107a.TransferErrorMsg;
import com.heytap.accessory.file.p107a.TransferProgress;
import com.heytap.accessory.p103a.SdkLog;
import org.json.JSONException;

/* loaded from: classes2.dex */
class FileCallbackReceiver extends ResultReceiver {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final String f9544a = "FileCallbackReceiver";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private FileTransfer.InterfaceC2218c f9545b;

    FileCallbackReceiver(Handler handler, FileTransfer.InterfaceC2218c interfaceC2218c) {
        super(handler);
        this.f9545b = interfaceC2218c;
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int OplusGLSurfaceView_13, Bundle bundle) {
        String string = bundle.getString("CallBackJson");
        if (string != null) {
            switch (OplusGLSurfaceView_13) {
                case 99:
                    TransferProgress c2232j = new TransferProgress();
                    try {
                        c2232j.m8682a(string);
                        long jM8681a = c2232j.m8681a();
                        int iM8683b = c2232j.m8683b();
                        SdkLog.m8381c(f9544a, "onReceiveResult mConnectionId:" + jM8681a + " mTransactionId：" + iM8683b);
                        this.f9545b.mo8630a();
                        break;
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                        return;
                    }
                case 100:
                    TransferProgress c2232j2 = new TransferProgress();
                    try {
                        c2232j2.m8682a(string);
                        this.f9545b.mo8631a(c2232j2.m8681a(), c2232j2.m8683b(), (int) c2232j2.m8684c());
                        break;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                case 101:
                    TransferCompleteMsg c2230h = new TransferCompleteMsg();
                    try {
                        SdkLog.m8381c(f9544a, "Transfer Complete:".concat(String.valueOf(string)));
                        c2230h.m8673a(string);
                        long jM8672a = c2230h.m8672a();
                        int iM8674b = c2230h.m8674b();
                        String strM8675c = c2230h.m8675c();
                        String strM8676d = c2230h.m8676d();
                        if (strM8676d.length() == 0) {
                            this.f9545b.mo8632a(jM8672a, iM8674b, strM8675c, 0);
                            break;
                        } else {
                            this.f9545b.mo8632a(jM8672a, iM8674b, strM8676d, 0);
                            break;
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                        return;
                    }
                case 102:
                    SdkLog.m8383e(f9544a, "RESULT_FILE_TRANSFER_ERROR");
                    TransferErrorMsg c2231i = new TransferErrorMsg();
                    try {
                        c2231i.m8678a(string);
                        this.f9545b.mo8632a(c2231i.m8677a(), c2231i.m8679b(), null, c2231i.m8680c());
                        break;
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                        return;
                    }
                case 103:
                    SdkLog.m8383e(f9544a, "RESULT_FILE_TRANSFER_CANCEL_ALL");
                    MultiTransferErrorMsg c2229g = new MultiTransferErrorMsg();
                    try {
                        c2229g.m8669a(string);
                        this.f9545b.mo8633a(c2229g.m8670a(), c2229g.m8671b());
                        break;
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                        return;
                    }
                default:
                    SdkLog.m8383e(f9544a, "Wrong resultCode:".concat(String.valueOf(OplusGLSurfaceView_13)));
                    break;
            }
        }
    }
}

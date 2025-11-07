package com.heytap.accessory.stream;

/* loaded from: classes2.dex */
public class StreamCallbackReceiver extends android.os.ResultReceiver {
    public static final java.lang.String COMPLETE_CONN_ID_KEY = "connectionId";
    public static final java.lang.String COMPLETE_TRAN_ID_KEY = "transactionId";
    public static final int MULTI_TRANSFER_ERROR = 103;
    public static final int NORMAL_TRANSFER_ERROR = 102;
    public static final int TRANSFER_COMPLETE = 101;

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f3380a = "StreamCallbackReceiver";

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.heytap.accessory.stream.StreamTransfer.b_renamed f3381b;

    public StreamCallbackReceiver(android.os.Handler handler, com.heytap.accessory.stream.StreamTransfer.b_renamed bVar) {
        super(handler);
        this.f3381b = bVar;
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i_renamed, android.os.Bundle bundle) {
        java.lang.String string = bundle.getString("CallBackJson");
        switch (i_renamed) {
            case 99:
                com.heytap.accessory.file.a_renamed.j_renamed jVar = new com.heytap.accessory.file.a_renamed.j_renamed();
                try {
                    jVar.a_renamed(string);
                    long jA = jVar.a_renamed();
                    int iB = jVar.b_renamed();
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3380a, "onReceiveResult mConnectionId:" + jA + " mTransactionId:" + iB);
                    break;
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                    return;
                }
            case 100:
            default:
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3380a, "Wrong resultCode");
                break;
            case 101:
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3380a, "Transfer Complete");
                this.f3381b.a_renamed(bundle.getLong("connectionId"), bundle.getInt("transactionId"), 0);
                break;
            case 102:
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3380a, "ST Error");
                com.heytap.accessory.stream.b_renamed.h_renamed hVar = new com.heytap.accessory.stream.b_renamed.h_renamed();
                try {
                    hVar.a_renamed(string);
                    long jA2 = hVar.a_renamed();
                    int iB2 = hVar.b_renamed();
                    int iC = hVar.c_renamed();
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3380a, "ST Error:".concat(java.lang.String.valueOf(iC)));
                    this.f3381b.a_renamed(jA2, iB2, iC);
                    break;
                } catch (org.json.JSONException e2) {
                    e2.printStackTrace();
                    return;
                }
            case 103:
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3380a, "ST Error");
                com.heytap.accessory.stream.b_renamed.d_renamed dVar = new com.heytap.accessory.stream.b_renamed.d_renamed();
                try {
                    dVar.a_renamed(string);
                    this.f3381b.a_renamed(dVar.a_renamed(), dVar.b_renamed());
                    break;
                } catch (org.json.JSONException e3) {
                    e3.printStackTrace();
                    return;
                }
        }
    }
}

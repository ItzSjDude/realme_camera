package com.heytap.accessory.file;

/* loaded from: classes2.dex */
class FileCallbackReceiver extends android.os.ResultReceiver {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.lang.String f3313a = "FileCallbackReceiver";

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.heytap.accessory.file.FileTransfer.c_renamed f3314b;

    FileCallbackReceiver(android.os.Handler handler, com.heytap.accessory.file.FileTransfer.c_renamed cVar) {
        super(handler);
        this.f3314b = cVar;
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i_renamed, android.os.Bundle bundle) {
        java.lang.String string = bundle.getString("CallBackJson");
        if (string != null) {
            switch (i_renamed) {
                case 99:
                    com.heytap.accessory.file.a_renamed.j_renamed jVar = new com.heytap.accessory.file.a_renamed.j_renamed();
                    try {
                        jVar.a_renamed(string);
                        long jA = jVar.a_renamed();
                        int iB = jVar.b_renamed();
                        com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3313a, "onReceiveResult mConnectionId:" + jA + " mTransactionId：" + iB);
                        this.f3314b.a_renamed();
                        break;
                    } catch (java.lang.Exception e_renamed) {
                        e_renamed.printStackTrace();
                        return;
                    }
                case 100:
                    com.heytap.accessory.file.a_renamed.j_renamed jVar2 = new com.heytap.accessory.file.a_renamed.j_renamed();
                    try {
                        jVar2.a_renamed(string);
                        this.f3314b.a_renamed(jVar2.a_renamed(), jVar2.b_renamed(), (int) jVar2.c_renamed());
                        break;
                    } catch (org.json.JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                case 101:
                    com.heytap.accessory.file.a_renamed.h_renamed hVar = new com.heytap.accessory.file.a_renamed.h_renamed();
                    try {
                        com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3313a, "Transfer Complete:".concat(java.lang.String.valueOf(string)));
                        hVar.a_renamed(string);
                        long jA2 = hVar.a_renamed();
                        int iB2 = hVar.b_renamed();
                        java.lang.String strC = hVar.c_renamed();
                        java.lang.String strD = hVar.d_renamed();
                        if (strD.length() == 0) {
                            this.f3314b.a_renamed(jA2, iB2, strC, 0);
                            break;
                        } else {
                            this.f3314b.a_renamed(jA2, iB2, strD, 0);
                            break;
                        }
                    } catch (org.json.JSONException e3) {
                        e3.printStackTrace();
                        return;
                    }
                case 102:
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3313a, "RESULT_FILE_TRANSFER_ERROR");
                    com.heytap.accessory.file.a_renamed.i_renamed iVar = new com.heytap.accessory.file.a_renamed.i_renamed();
                    try {
                        iVar.a_renamed(string);
                        this.f3314b.a_renamed(iVar.a_renamed(), iVar.b_renamed(), null, iVar.c_renamed());
                        break;
                    } catch (org.json.JSONException e4) {
                        e4.printStackTrace();
                        return;
                    }
                case 103:
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3313a, "RESULT_FILE_TRANSFER_CANCEL_ALL");
                    com.heytap.accessory.file.a_renamed.g_renamed gVar = new com.heytap.accessory.file.a_renamed.g_renamed();
                    try {
                        gVar.a_renamed(string);
                        this.f3314b.a_renamed(gVar.a_renamed(), gVar.b_renamed());
                        break;
                    } catch (org.json.JSONException e5) {
                        e5.printStackTrace();
                        return;
                    }
                default:
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3313a, "Wrong resultCode:".concat(java.lang.String.valueOf(i_renamed)));
                    break;
            }
        }
    }
}

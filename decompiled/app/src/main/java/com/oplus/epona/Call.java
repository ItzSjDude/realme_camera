package com.oplus.epona;

/* loaded from: classes2.dex */
public interface Call {

    public interface Callback {
        void onReceive(com.oplus.epona.Response response);
    }

    void asyncExecute(com.oplus.epona.Call.Callback callback);

    com.oplus.epona.Response execute();

    com.oplus.epona.Request request();
}

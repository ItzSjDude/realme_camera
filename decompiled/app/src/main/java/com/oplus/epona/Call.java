package com.oplus.epona;

/* loaded from: classes2.dex */
public interface Call {

    public interface Callback {
        void onReceive(Response response);
    }

    void asyncExecute(Callback callback);

    Response execute();

    Request request();
}

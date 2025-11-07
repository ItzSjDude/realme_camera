package com.oplus.epona;

/* loaded from: classes2.dex */
public interface Interceptor {

    public interface Chain {
        com.oplus.epona.Call.Callback callback();

        boolean isAsync();

        void proceed();

        com.oplus.epona.Request request();
    }

    void intercept(com.oplus.epona.Interceptor.Chain chain);
}

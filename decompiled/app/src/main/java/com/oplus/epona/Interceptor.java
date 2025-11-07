package com.oplus.epona;

import com.oplus.epona.Call;

/* loaded from: classes2.dex */
public interface Interceptor {

    public interface Chain {
        Call.Callback callback();

        boolean isAsync();

        void proceed();

        Request request();
    }

    void intercept(Chain chain);
}

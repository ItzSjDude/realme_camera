package com.oplus.epona;

/* loaded from: classes2.dex */
public interface DynamicProvider {
    java.lang.String getName();

    default boolean needIPC() {
        return false;
    }

    com.oplus.epona.Response onCall(com.oplus.epona.Request request);

    default void onCall(com.oplus.epona.Request request, com.oplus.epona.Call.Callback callback) {
        callback.onReceive(onCall(request));
    }
}

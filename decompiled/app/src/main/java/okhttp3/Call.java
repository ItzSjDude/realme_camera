package okhttp3;

/* loaded from: classes2.dex */
public interface Call extends java.lang.Cloneable {

    public interface Factory {
        okhttp3.Call newCall(okhttp3.Request request);
    }

    void cancel();

    okhttp3.Call clone();

    void enqueue(okhttp3.Callback callback);

    okhttp3.Response execute() throws java.io.IOException;

    boolean isCanceled();

    boolean isExecuted();

    okhttp3.Request request();

    okio.Timeout timeout();
}

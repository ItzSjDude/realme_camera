package okhttp3;

/* loaded from: classes2.dex */
public interface Authenticator {
    public static final okhttp3.Authenticator NONE = new okhttp3.Authenticator() { // from class: okhttp3.Authenticator.1
        @Override // okhttp3.Authenticator
        public okhttp3.Request authenticate(@javax.annotation.Nullable okhttp3.Route route, okhttp3.Response response) {
            return null;
        }
    };

    @javax.annotation.Nullable
    okhttp3.Request authenticate(@javax.annotation.Nullable okhttp3.Route route, okhttp3.Response response) throws java.io.IOException;
}

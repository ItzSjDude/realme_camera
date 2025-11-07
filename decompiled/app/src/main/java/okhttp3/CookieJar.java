package okhttp3;

/* loaded from: classes2.dex */
public interface CookieJar {
    public static final okhttp3.CookieJar NO_COOKIES = new okhttp3.CookieJar() { // from class: okhttp3.CookieJar.1
        @Override // okhttp3.CookieJar
        public void saveFromResponse(okhttp3.HttpUrl httpUrl, java.util.List<okhttp3.Cookie> list) {
        }

        @Override // okhttp3.CookieJar
        public java.util.List<okhttp3.Cookie> loadForRequest(okhttp3.HttpUrl httpUrl) {
            return java.util.Collections.emptyList();
        }
    };

    java.util.List<okhttp3.Cookie> loadForRequest(okhttp3.HttpUrl httpUrl);

    void saveFromResponse(okhttp3.HttpUrl httpUrl, java.util.List<okhttp3.Cookie> list);
}

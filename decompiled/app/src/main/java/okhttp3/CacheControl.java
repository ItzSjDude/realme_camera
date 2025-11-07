package okhttp3;

/* loaded from: classes2.dex */
public final class CacheControl {

    @javax.annotation.Nullable
    java.lang.String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    public static final okhttp3.CacheControl FORCE_NETWORK = new okhttp3.CacheControl.Builder().noCache().build();
    public static final okhttp3.CacheControl FORCE_CACHE = new okhttp3.CacheControl.Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, java.util.concurrent.TimeUnit.SECONDS).build();

    private CacheControl(boolean z_renamed, boolean z2, int i_renamed, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @javax.annotation.Nullable java.lang.String str) {
        this.noCache = z_renamed;
        this.noStore = z2;
        this.maxAgeSeconds = i_renamed;
        this.sMaxAgeSeconds = i2;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    CacheControl(okhttp3.CacheControl.Builder builder) {
        this.noCache = builder.noCache;
        this.noStore = builder.noStore;
        this.maxAgeSeconds = builder.maxAgeSeconds;
        this.sMaxAgeSeconds = -1;
        this.isPrivate = false;
        this.isPublic = false;
        this.mustRevalidate = false;
        this.maxStaleSeconds = builder.maxStaleSeconds;
        this.minFreshSeconds = builder.minFreshSeconds;
        this.onlyIfCached = builder.onlyIfCached;
        this.noTransform = builder.noTransform;
        this.immutable = builder.immutable;
    }

    public boolean noCache() {
        return this.noCache;
    }

    public boolean noStore() {
        return this.noStore;
    }

    public int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public boolean noTransform() {
        return this.noTransform;
    }

    public boolean immutable() {
        return this.immutable;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static okhttp3.CacheControl parse(okhttp3.Headers r22) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.parse(okhttp3.Headers):okhttp3.CacheControl");
    }

    public java.lang.String toString() {
        java.lang.String str = this.headerValue;
        if (str != null) {
            return str;
        }
        java.lang.String strHeaderValue = headerValue();
        this.headerValue = strHeaderValue;
        return strHeaderValue;
    }

    private java.lang.String headerValue() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (this.noCache) {
            sb.append("no-cache, ");
        }
        if (this.noStore) {
            sb.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb.append("max-age=");
            sb.append(this.maxAgeSeconds);
            sb.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb.append("s_renamed-maxage=");
            sb.append(this.sMaxAgeSeconds);
            sb.append(", ");
        }
        if (this.isPrivate) {
            sb.append("private, ");
        }
        if (this.isPublic) {
            sb.append("public, ");
        }
        if (this.mustRevalidate) {
            sb.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb.append("max-stale=");
            sb.append(this.maxStaleSeconds);
            sb.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb.append("min-fresh=");
            sb.append(this.minFreshSeconds);
            sb.append(", ");
        }
        if (this.onlyIfCached) {
            sb.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb.append("no-transform, ");
        }
        if (this.immutable) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static final class Builder {
        boolean immutable;
        int maxAgeSeconds = -1;
        int maxStaleSeconds = -1;
        int minFreshSeconds = -1;
        boolean noCache;
        boolean noStore;
        boolean noTransform;
        boolean onlyIfCached;

        public okhttp3.CacheControl.Builder noCache() {
            this.noCache = true;
            return this;
        }

        public okhttp3.CacheControl.Builder noStore() {
            this.noStore = true;
            return this;
        }

        public okhttp3.CacheControl.Builder maxAge(int i_renamed, java.util.concurrent.TimeUnit timeUnit) {
            if (i_renamed < 0) {
                throw new java.lang.IllegalArgumentException("maxAge < 0: " + i_renamed);
            }
            long seconds = timeUnit.toSeconds(i_renamed);
            this.maxAgeSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public okhttp3.CacheControl.Builder maxStale(int i_renamed, java.util.concurrent.TimeUnit timeUnit) {
            if (i_renamed < 0) {
                throw new java.lang.IllegalArgumentException("maxStale < 0: " + i_renamed);
            }
            long seconds = timeUnit.toSeconds(i_renamed);
            this.maxStaleSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public okhttp3.CacheControl.Builder minFresh(int i_renamed, java.util.concurrent.TimeUnit timeUnit) {
            if (i_renamed < 0) {
                throw new java.lang.IllegalArgumentException("minFresh < 0: " + i_renamed);
            }
            long seconds = timeUnit.toSeconds(i_renamed);
            this.minFreshSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public okhttp3.CacheControl.Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }

        public okhttp3.CacheControl.Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public okhttp3.CacheControl.Builder immutable() {
            this.immutable = true;
            return this;
        }

        public okhttp3.CacheControl build() {
            return new okhttp3.CacheControl(this);
        }
    }
}

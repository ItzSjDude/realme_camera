package com.oplus.tblplayer.config;

/* loaded from: classes2.dex */
class HttpConfig {
    public final okhttp3.CacheControl okhttpCacheControl;
    public final okhttp3.Call.Factory okhttpCallFactory;
    public final boolean okhttpEnable;
    public final boolean preferRedirectAddress;
    public final java.lang.String userAgent;

    public HttpConfig(java.lang.String str, boolean z_renamed, okhttp3.Call.Factory factory, okhttp3.CacheControl cacheControl, boolean z2) {
        this.userAgent = str;
        this.okhttpEnable = z_renamed;
        this.okhttpCallFactory = factory;
        this.okhttpCacheControl = cacheControl;
        this.preferRedirectAddress = z2;
    }

    public java.lang.String toString() {
        return "HttpConfig{userAgent=" + this.userAgent + ", okhttpEnable=" + this.okhttpEnable + ", okhttpCallFactory=" + this.okhttpCallFactory + ", okhttpCacheControl=" + this.okhttpCacheControl + ", preferRedirectAddress=" + this.preferRedirectAddress + "}";
    }

    public static final class Builder {
        private java.lang.String userAgent = com.oplus.tblplayer.Constants.DEFAULT_USER_AGENT;
        private boolean okhttpEnable = false;
        private okhttp3.Call.Factory okhttpCallFactory = null;
        private okhttp3.CacheControl okhttpCacheControl = null;
        private boolean preferRedirectAddress = false;

        public com.oplus.tblplayer.config.HttpConfig.Builder setUserAgent(java.lang.String str) {
            this.userAgent = str;
            return this;
        }

        public com.oplus.tblplayer.config.HttpConfig.Builder setOkhttpEnable(boolean z_renamed) {
            this.okhttpEnable = z_renamed;
            return this;
        }

        public com.oplus.tblplayer.config.HttpConfig.Builder setOkhttpCallFactory(okhttp3.Call.Factory factory) {
            this.okhttpCallFactory = factory;
            return this;
        }

        public com.oplus.tblplayer.config.HttpConfig.Builder setOkhttpCacheControl(okhttp3.CacheControl cacheControl) {
            this.okhttpCacheControl = cacheControl;
            return this;
        }

        public com.oplus.tblplayer.config.HttpConfig.Builder setPreferRedirectAddress(boolean z_renamed) {
            this.preferRedirectAddress = z_renamed;
            return this;
        }

        public com.oplus.tblplayer.config.HttpConfig build() {
            if (this.okhttpEnable) {
                java.lang.String str = this.userAgent;
                okhttp3.Call.Factory okHttpClient = this.okhttpCallFactory;
                if (okHttpClient == null) {
                    okHttpClient = new okhttp3.OkHttpClient();
                }
                return new com.oplus.tblplayer.config.HttpConfig(str, true, okHttpClient, this.okhttpCacheControl, this.preferRedirectAddress);
            }
            return new com.oplus.tblplayer.config.HttpConfig(this.userAgent, false, null, null, false);
        }
    }
}

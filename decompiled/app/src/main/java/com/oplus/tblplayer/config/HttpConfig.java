package com.oplus.tblplayer.config;

import com.oplus.tblplayer.Constants;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* loaded from: classes2.dex */
class HttpConfig {
    public final CacheControl okhttpCacheControl;
    public final Call.Factory okhttpCallFactory;
    public final boolean okhttpEnable;
    public final boolean preferRedirectAddress;
    public final String userAgent;

    public HttpConfig(String str, boolean z, Call.Factory factory, CacheControl cacheControl, boolean z2) {
        this.userAgent = str;
        this.okhttpEnable = z;
        this.okhttpCallFactory = factory;
        this.okhttpCacheControl = cacheControl;
        this.preferRedirectAddress = z2;
    }

    public String toString() {
        return "HttpConfig{userAgent=" + this.userAgent + ", okhttpEnable=" + this.okhttpEnable + ", okhttpCallFactory=" + this.okhttpCallFactory + ", okhttpCacheControl=" + this.okhttpCacheControl + ", preferRedirectAddress=" + this.preferRedirectAddress + "}";
    }

    public static final class Builder {
        private String userAgent = Constants.DEFAULT_USER_AGENT;
        private boolean okhttpEnable = false;
        private Call.Factory okhttpCallFactory = null;
        private CacheControl okhttpCacheControl = null;
        private boolean preferRedirectAddress = false;

        public Builder setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        public Builder setOkhttpEnable(boolean z) {
            this.okhttpEnable = z;
            return this;
        }

        public Builder setOkhttpCallFactory(Call.Factory factory) {
            this.okhttpCallFactory = factory;
            return this;
        }

        public Builder setOkhttpCacheControl(CacheControl cacheControl) {
            this.okhttpCacheControl = cacheControl;
            return this;
        }

        public Builder setPreferRedirectAddress(boolean z) {
            this.preferRedirectAddress = z;
            return this;
        }

        public HttpConfig build() {
            if (this.okhttpEnable) {
                String str = this.userAgent;
                Call.Factory okHttpClient = this.okhttpCallFactory;
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient();
                }
                return new HttpConfig(str, true, okHttpClient, this.okhttpCacheControl, this.preferRedirectAddress);
            }
            return new HttpConfig(this.userAgent, false, null, null, false);
        }
    }
}

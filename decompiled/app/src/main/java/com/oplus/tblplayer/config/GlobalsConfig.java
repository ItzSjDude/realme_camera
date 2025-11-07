package com.oplus.tblplayer.config;

import android.content.Context;
import com.google.android.exoplayer2.util.Assertions;
import com.oplus.tblplayer.config.HttpConfig;
import com.oplus.tblplayer.config.PreCacheConfig;
import okhttp3.CacheControl;
import okhttp3.Call;

/* loaded from: classes2.dex */
public class GlobalsConfig {
    public final Context appContext;
    public final boolean debug;
    public final HttpConfig httpConfig;
    public final PreCacheConfig preCacheConfig;
    public final boolean remoteEnable;

    private GlobalsConfig(Context context, boolean z, boolean z2, HttpConfig httpConfig, PreCacheConfig preCacheConfig) {
        this.appContext = context;
        this.debug = z;
        this.remoteEnable = z2;
        this.httpConfig = httpConfig;
        this.preCacheConfig = preCacheConfig;
    }

    public static final class Builder {
        private Context context;
        private boolean debug = Globals.DEBUG;
        private boolean remoteEnable = false;
        private HttpConfig httpConfig = null;
        private PreCacheConfig preCacheConfig = null;
        private HttpConfig.Builder httpConfigBuilder = new HttpConfig.Builder();
        private PreCacheConfig.Builder preCacheConfigBuilder = new PreCacheConfig.Builder();

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder setRemoteEnable(boolean z) {
            this.remoteEnable = z;
            return this;
        }

        public Builder setUserAgent(String str) {
            this.httpConfigBuilder.setUserAgent(str);
            return this;
        }

        public Builder setOkhttpEnable(boolean z) {
            this.httpConfigBuilder.setOkhttpEnable(z);
            return this;
        }

        public Builder setOkhttpCallFactory(Call.Factory factory) {
            this.httpConfigBuilder.setOkhttpCallFactory(factory);
            return this;
        }

        public Builder setOkhttpCacheControl(CacheControl cacheControl) {
            this.httpConfigBuilder.setOkhttpCacheControl(cacheControl);
            return this;
        }

        public Builder setPreferRedirectAddress(boolean z) {
            this.httpConfigBuilder.setPreferRedirectAddress(z);
            return this;
        }

        public Builder setPreCacheEnable(boolean z) {
            this.preCacheConfigBuilder.setPreCacheEnable(z);
            return this;
        }

        public Builder setPreCacheDir(String str) {
            this.preCacheConfigBuilder.setPreCacheDir(str);
            return this;
        }

        public Builder setMaxCacheDirSize(long OplusGLSurfaceView_15) {
            this.preCacheConfigBuilder.setMaxCacheDirSize(OplusGLSurfaceView_15);
            return this;
        }

        public Builder setMaxCacheFileSize(long OplusGLSurfaceView_15) {
            this.preCacheConfigBuilder.setMaxCacheFileSize(OplusGLSurfaceView_15);
            return this;
        }

        public GlobalsConfig build() {
            Assertions.checkNotNull(this.preCacheConfigBuilder);
            Assertions.checkNotNull(this.httpConfigBuilder);
            this.httpConfig = this.httpConfigBuilder.build();
            this.preCacheConfig = this.preCacheConfigBuilder.build();
            return new GlobalsConfig(this.context, this.debug, this.remoteEnable, this.httpConfig, this.preCacheConfig);
        }
    }
}

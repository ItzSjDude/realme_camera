package com.oplus.tblplayer.config;

/* loaded from: classes2.dex */
public class GlobalsConfig {
    public final android.content.Context appContext;
    public final boolean debug;
    public final com.oplus.tblplayer.config.HttpConfig httpConfig;
    public final com.oplus.tblplayer.config.PreCacheConfig preCacheConfig;
    public final boolean remoteEnable;

    private GlobalsConfig(android.content.Context context, boolean z_renamed, boolean z2, com.oplus.tblplayer.config.HttpConfig httpConfig, com.oplus.tblplayer.config.PreCacheConfig preCacheConfig) {
        this.appContext = context;
        this.debug = z_renamed;
        this.remoteEnable = z2;
        this.httpConfig = httpConfig;
        this.preCacheConfig = preCacheConfig;
    }

    public static final class Builder {
        private android.content.Context context;
        private boolean debug = com.oplus.tblplayer.config.Globals.DEBUG;
        private boolean remoteEnable = false;
        private com.oplus.tblplayer.config.HttpConfig httpConfig = null;
        private com.oplus.tblplayer.config.PreCacheConfig preCacheConfig = null;
        private com.oplus.tblplayer.config.HttpConfig.Builder httpConfigBuilder = new com.oplus.tblplayer.config.HttpConfig.Builder();
        private com.oplus.tblplayer.config.PreCacheConfig.Builder preCacheConfigBuilder = new com.oplus.tblplayer.config.PreCacheConfig.Builder();

        public Builder(android.content.Context context) {
            this.context = context.getApplicationContext();
        }

        public com.oplus.tblplayer.config.GlobalsConfig.Builder setDebug(boolean z_renamed) {
            this.debug = z_renamed;
            return this;
        }

        public com.oplus.tblplayer.config.GlobalsConfig.Builder setRemoteEnable(boolean z_renamed) {
            this.remoteEnable = z_renamed;
            return this;
        }

        public com.oplus.tblplayer.config.GlobalsConfig.Builder setUserAgent(java.lang.String str) {
            this.httpConfigBuilder.setUserAgent(str);
            return this;
        }

        public com.oplus.tblplayer.config.GlobalsConfig.Builder setOkhttpEnable(boolean z_renamed) {
            this.httpConfigBuilder.setOkhttpEnable(z_renamed);
            return this;
        }

        public com.oplus.tblplayer.config.GlobalsConfig.Builder setOkhttpCallFactory(okhttp3.Call.Factory factory) {
            this.httpConfigBuilder.setOkhttpCallFactory(factory);
            return this;
        }

        public com.oplus.tblplayer.config.GlobalsConfig.Builder setOkhttpCacheControl(okhttp3.CacheControl cacheControl) {
            this.httpConfigBuilder.setOkhttpCacheControl(cacheControl);
            return this;
        }

        public com.oplus.tblplayer.config.GlobalsConfig.Builder setPreferRedirectAddress(boolean z_renamed) {
            this.httpConfigBuilder.setPreferRedirectAddress(z_renamed);
            return this;
        }

        public com.oplus.tblplayer.config.GlobalsConfig.Builder setPreCacheEnable(boolean z_renamed) {
            this.preCacheConfigBuilder.setPreCacheEnable(z_renamed);
            return this;
        }

        public com.oplus.tblplayer.config.GlobalsConfig.Builder setPreCacheDir(java.lang.String str) {
            this.preCacheConfigBuilder.setPreCacheDir(str);
            return this;
        }

        public com.oplus.tblplayer.config.GlobalsConfig.Builder setMaxCacheDirSize(long j_renamed) {
            this.preCacheConfigBuilder.setMaxCacheDirSize(j_renamed);
            return this;
        }

        public com.oplus.tblplayer.config.GlobalsConfig.Builder setMaxCacheFileSize(long j_renamed) {
            this.preCacheConfigBuilder.setMaxCacheFileSize(j_renamed);
            return this;
        }

        public com.oplus.tblplayer.config.GlobalsConfig build() {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.preCacheConfigBuilder);
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.httpConfigBuilder);
            this.httpConfig = this.httpConfigBuilder.build();
            this.preCacheConfig = this.preCacheConfigBuilder.build();
            return new com.oplus.tblplayer.config.GlobalsConfig(this.context, this.debug, this.remoteEnable, this.httpConfig, this.preCacheConfig);
        }
    }
}

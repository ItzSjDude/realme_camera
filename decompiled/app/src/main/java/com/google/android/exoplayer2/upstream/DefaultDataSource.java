package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class DefaultDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    private static final java.lang.String SCHEME_ASSET = "asset";
    private static final java.lang.String SCHEME_CONTENT = "content";
    private static final java.lang.String SCHEME_RAW = "rawresource";
    private static final java.lang.String SCHEME_RTMP = "rtmp";
    private static final java.lang.String TAG = "DefaultDataSource";
    private com.google.android.exoplayer2.upstream.DataSource assetDataSource;
    private final com.google.android.exoplayer2.upstream.DataSource baseDataSource;
    private com.google.android.exoplayer2.upstream.DataSource contentDataSource;
    private final android.content.Context context;
    private com.google.android.exoplayer2.upstream.DataSource dataSchemeDataSource;
    private com.google.android.exoplayer2.upstream.DataSource dataSource;
    private com.google.android.exoplayer2.upstream.DataSource fileDataSource;
    private com.google.android.exoplayer2.upstream.DataSource rawResourceDataSource;
    private com.google.android.exoplayer2.upstream.DataSource rtmpDataSource;
    private final java.util.List<com.google.android.exoplayer2.upstream.TransferListener> transferListeners;

    public DefaultDataSource(android.content.Context context, java.lang.String str, boolean z_renamed) {
        this(context, str, 8000, 8000, z_renamed);
    }

    public DefaultDataSource(android.content.Context context, java.lang.String str, int i_renamed, int i2, boolean z_renamed) {
        this(context, new com.google.android.exoplayer2.upstream.DefaultHttpDataSource(str, null, i_renamed, i2, z_renamed, null));
    }

    public DefaultDataSource(android.content.Context context, com.google.android.exoplayer2.upstream.DataSource dataSource) {
        this.context = context.getApplicationContext();
        this.baseDataSource = (com.google.android.exoplayer2.upstream.DataSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(dataSource);
        this.transferListeners = new java.util.ArrayList();
    }

    @java.lang.Deprecated
    public DefaultDataSource(android.content.Context context, com.google.android.exoplayer2.upstream.TransferListener transferListener, java.lang.String str, boolean z_renamed) {
        this(context, transferListener, str, 8000, 8000, z_renamed);
    }

    @java.lang.Deprecated
    public DefaultDataSource(android.content.Context context, com.google.android.exoplayer2.upstream.TransferListener transferListener, java.lang.String str, int i_renamed, int i2, boolean z_renamed) {
        this(context, transferListener, new com.google.android.exoplayer2.upstream.DefaultHttpDataSource(str, null, transferListener, i_renamed, i2, z_renamed, null));
    }

    @java.lang.Deprecated
    public DefaultDataSource(android.content.Context context, com.google.android.exoplayer2.upstream.TransferListener transferListener, com.google.android.exoplayer2.upstream.DataSource dataSource) {
        this(context, dataSource);
        if (transferListener != null) {
            this.transferListeners.add(transferListener);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.baseDataSource.addTransferListener(transferListener);
        this.transferListeners.add(transferListener);
        maybeAddListenerToDataSource(this.fileDataSource, transferListener);
        maybeAddListenerToDataSource(this.assetDataSource, transferListener);
        maybeAddListenerToDataSource(this.contentDataSource, transferListener);
        maybeAddListenerToDataSource(this.rtmpDataSource, transferListener);
        maybeAddListenerToDataSource(this.dataSchemeDataSource, transferListener);
        maybeAddListenerToDataSource(this.rawResourceDataSource, transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkState(this.dataSource == null);
        java.lang.String scheme = dataSpec.uri.getScheme();
        if (com.google.android.exoplayer2.util.Util.isLocalFileUri(dataSpec.uri)) {
            if (dataSpec.uri.getPath().startsWith("/android_asset/")) {
                this.dataSource = getAssetDataSource();
            } else {
                this.dataSource = getFileDataSource();
            }
        } else if (SCHEME_ASSET.equals(scheme)) {
            this.dataSource = getAssetDataSource();
        } else if (SCHEME_CONTENT.equals(scheme)) {
            this.dataSource = getContentDataSource();
        } else if (SCHEME_RTMP.equals(scheme)) {
            this.dataSource = getRtmpDataSource();
        } else if ("data".equals(scheme)) {
            this.dataSource = getDataSchemeDataSource();
        } else if ("rawresource".equals(scheme)) {
            this.dataSource = getRawResourceDataSource();
        } else {
            this.dataSource = this.baseDataSource;
        }
        return this.dataSource.open(dataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        return ((com.google.android.exoplayer2.upstream.DataSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.dataSource)).read(bArr, i_renamed, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public android.net.Uri getUri() {
        com.google.android.exoplayer2.upstream.DataSource dataSource = this.dataSource;
        if (dataSource == null) {
            return null;
        }
        return dataSource.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        com.google.android.exoplayer2.upstream.DataSource dataSource = this.dataSource;
        return dataSource == null ? java.util.Collections.emptyMap() : dataSource.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws java.io.IOException {
        com.google.android.exoplayer2.upstream.DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.dataSource = null;
            }
        }
    }

    private com.google.android.exoplayer2.upstream.DataSource getFileDataSource() {
        if (this.fileDataSource == null) {
            this.fileDataSource = new com.google.android.exoplayer2.upstream.FileDataSource();
            addListenersToDataSource(this.fileDataSource);
        }
        return this.fileDataSource;
    }

    private com.google.android.exoplayer2.upstream.DataSource getAssetDataSource() {
        if (this.assetDataSource == null) {
            this.assetDataSource = new com.google.android.exoplayer2.upstream.AssetDataSource(this.context);
            addListenersToDataSource(this.assetDataSource);
        }
        return this.assetDataSource;
    }

    private com.google.android.exoplayer2.upstream.DataSource getContentDataSource() {
        if (this.contentDataSource == null) {
            this.contentDataSource = new com.google.android.exoplayer2.upstream.ContentDataSource(this.context);
            addListenersToDataSource(this.contentDataSource);
        }
        return this.contentDataSource;
    }

    private com.google.android.exoplayer2.upstream.DataSource getRtmpDataSource() {
        if (this.rtmpDataSource == null) {
            try {
                this.rtmpDataSource = (com.google.android.exoplayer2.upstream.DataSource) java.lang.Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
                addListenersToDataSource(this.rtmpDataSource);
            } catch (java.lang.ClassNotFoundException unused) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Attempting to play RTMP stream without depending on_renamed the RTMP extension");
            } catch (java.lang.Exception e_renamed) {
                throw new java.lang.RuntimeException("Error instantiating RTMP extension", e_renamed);
            }
            if (this.rtmpDataSource == null) {
                this.rtmpDataSource = this.baseDataSource;
            }
        }
        return this.rtmpDataSource;
    }

    private com.google.android.exoplayer2.upstream.DataSource getDataSchemeDataSource() {
        if (this.dataSchemeDataSource == null) {
            this.dataSchemeDataSource = new com.google.android.exoplayer2.upstream.DataSchemeDataSource();
            addListenersToDataSource(this.dataSchemeDataSource);
        }
        return this.dataSchemeDataSource;
    }

    private com.google.android.exoplayer2.upstream.DataSource getRawResourceDataSource() {
        if (this.rawResourceDataSource == null) {
            this.rawResourceDataSource = new com.google.android.exoplayer2.upstream.RawResourceDataSource(this.context);
            addListenersToDataSource(this.rawResourceDataSource);
        }
        return this.rawResourceDataSource;
    }

    private void addListenersToDataSource(com.google.android.exoplayer2.upstream.DataSource dataSource) {
        for (int i_renamed = 0; i_renamed < this.transferListeners.size(); i_renamed++) {
            dataSource.addTransferListener(this.transferListeners.get(i_renamed));
        }
    }

    private void maybeAddListenerToDataSource(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        if (dataSource != null) {
            dataSource.addTransferListener(transferListener);
        }
    }
}

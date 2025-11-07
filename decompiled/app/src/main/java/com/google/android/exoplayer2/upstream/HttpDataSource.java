package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public interface HttpDataSource extends com.google.android.exoplayer2.upstream.DataSource {
    public static final com.google.android.exoplayer2.util.Predicate<java.lang.String> REJECT_PAYWALL_TYPES = new com.google.android.exoplayer2.util.Predicate() { // from class: com.google.android.exoplayer2.upstream.-$$Lambda$HttpDataSource$fz_renamed-i4cgBB9tTB1JUdq8hmlAPFIw
        @Override // com.google.android.exoplayer2.util.Predicate
        public final boolean evaluate(java.lang.Object obj) {
            return com.google.android.exoplayer2.upstream.HttpDataSource.lambda$static$0((java.lang.String) obj);
        }
    };

    public interface Factory extends com.google.android.exoplayer2.upstream.DataSource.Factory {
        @java.lang.Deprecated
        void clearAllDefaultRequestProperties();

        @java.lang.Deprecated
        void clearDefaultRequestProperty(java.lang.String str);

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        com.google.android.exoplayer2.upstream.HttpDataSource createDataSource();

        com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties getDefaultRequestProperties();

        @java.lang.Deprecated
        void setDefaultRequestProperty(java.lang.String str, java.lang.String str2);
    }

    void clearAllRequestProperties();

    void clearRequestProperty(java.lang.String str);

    void close() throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException;

    java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders();

    long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException;

    int read(byte[] bArr, int i_renamed, int i2) throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException;

    void setRequestProperty(java.lang.String str, java.lang.String str2);

    public static final class RequestProperties {
        private final java.util.Map<java.lang.String, java.lang.String> requestProperties = new java.util.HashMap();
        private java.util.Map<java.lang.String, java.lang.String> requestPropertiesSnapshot;

        public synchronized void set(java.lang.String str, java.lang.String str2) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.put(str, str2);
        }

        public synchronized void set(java.util.Map<java.lang.String, java.lang.String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.putAll(map);
        }

        public synchronized void clearAndSet(java.util.Map<java.lang.String, java.lang.String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
            this.requestProperties.putAll(map);
        }

        public synchronized void remove(java.lang.String str) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.remove(str);
        }

        public synchronized void clear() {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
        }

        public synchronized java.util.Map<java.lang.String, java.lang.String> getSnapshot() {
            if (this.requestPropertiesSnapshot == null) {
                this.requestPropertiesSnapshot = java.util.Collections.unmodifiableMap(new java.util.HashMap(this.requestProperties));
            }
            return this.requestPropertiesSnapshot;
        }
    }

    public static abstract class BaseFactory implements com.google.android.exoplayer2.upstream.HttpDataSource.Factory {
        private final com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties defaultRequestProperties = new com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties();

        protected abstract com.google.android.exoplayer2.upstream.HttpDataSource createDataSourceInternal(com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties);

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory, com.google.android.exoplayer2.upstream.DataSource.Factory
        public final com.google.android.exoplayer2.upstream.HttpDataSource createDataSource() {
            return createDataSourceInternal(this.defaultRequestProperties);
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        public final com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties getDefaultRequestProperties() {
            return this.defaultRequestProperties;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        @java.lang.Deprecated
        public final void setDefaultRequestProperty(java.lang.String str, java.lang.String str2) {
            this.defaultRequestProperties.set(str, str2);
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        @java.lang.Deprecated
        public final void clearDefaultRequestProperty(java.lang.String str) {
            this.defaultRequestProperties.remove(str);
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        @java.lang.Deprecated
        public final void clearAllDefaultRequestProperties() {
            this.defaultRequestProperties.clear();
        }
    }

    static /* synthetic */ boolean lambda$static$0(java.lang.String str) {
        java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(str);
        return (android.text.TextUtils.isEmpty(lowerInvariant) || (lowerInvariant.contains(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_TEXT) && !lowerInvariant.contains(com.google.android.exoplayer2.util.MimeTypes.TEXT_VTT)) || lowerInvariant.contains("html") || lowerInvariant.contains("xml")) ? false : true;
    }

    public static class HttpDataSourceException extends java.io.IOException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final com.google.android.exoplayer2.upstream.DataSpec dataSpec;
        public final int type;

        @java.lang.annotation.Documented
        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface Type {
        }

        public HttpDataSourceException(com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i_renamed) {
            this.dataSpec = dataSpec;
            this.type = i_renamed;
        }

        public HttpDataSourceException(java.lang.String str, com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i_renamed) {
            super(str);
            this.dataSpec = dataSpec;
            this.type = i_renamed;
        }

        public HttpDataSourceException(java.io.IOException iOException, com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i_renamed) {
            super(iOException);
            this.dataSpec = dataSpec;
            this.type = i_renamed;
        }

        public HttpDataSourceException(java.lang.String str, java.io.IOException iOException, com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i_renamed) {
            super(str, iOException);
            this.dataSpec = dataSpec;
            this.type = i_renamed;
        }
    }

    public static final class InvalidContentTypeException extends com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        public final java.lang.String contentType;

        public InvalidContentTypeException(java.lang.String str, com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
            super("Invalid content type: " + str, dataSpec, 1);
            this.contentType = str;
        }
    }

    public static final class InvalidResponseCodeException extends com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields;
        public final int responseCode;
        public final java.lang.String responseMessage;

        @java.lang.Deprecated
        public InvalidResponseCodeException(int i_renamed, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
            this(i_renamed, null, map, dataSpec);
        }

        public InvalidResponseCodeException(int i_renamed, java.lang.String str, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
            super("Response code: " + i_renamed, dataSpec, 1);
            this.responseCode = i_renamed;
            this.responseMessage = str;
            this.headerFields = map;
        }
    }
}

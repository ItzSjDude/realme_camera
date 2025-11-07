package com.oplus.tblplayer.misc;

/* loaded from: classes2.dex */
public class MediaUrl implements android.os.Parcelable {
    private static final java.lang.String SCHEME_ASSET = "asset";
    private static final java.lang.String SCHEME_CONTENT = "content";
    private static final java.lang.String SCHEME_DATA = "data";
    private static final java.lang.String SCHEME_LOCAL = "file";
    private static final java.lang.String SCHEME_RAW = "rawresource";
    private static final java.lang.String SCHEME_RTMP = "rtmp";
    protected final java.util.List<com.oplus.tblplayer.misc.MediaUrl> backupUrlList;
    private int backupUrlListIndex;
    protected final java.lang.String customCacheKey;
    protected final java.util.Map<java.lang.String, java.lang.String> headers;
    protected final java.lang.String overrideExtension;
    protected final android.net.Uri uri;
    protected final java.lang.String userAgent;
    public static final com.oplus.tblplayer.misc.MediaUrl.CacheKeyFactory DEFAULT_CACHE_KEY_FACTORY = new com.oplus.tblplayer.misc.MediaUrl.CacheKeyFactory() { // from class: com.oplus.tblplayer.misc.-$$Lambda$MediaUrl$yEz6mtt3iXFScWFrdTdPDv4sveU
        @Override // com.oplus.tblplayer.misc.MediaUrl.CacheKeyFactory
        public final java.lang.String buildCacheKey(android.net.Uri uri) {
            return com.oplus.tblplayer.misc.MediaUrl.lambda$static$0(uri);
        }
    };
    public static final android.os.Parcelable.Creator<com.oplus.tblplayer.misc.MediaUrl> CREATOR = new android.os.Parcelable.Creator<com.oplus.tblplayer.misc.MediaUrl>() { // from class: com.oplus.tblplayer.misc.MediaUrl.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.oplus.tblplayer.misc.MediaUrl createFromParcel(android.os.Parcel parcel) {
            return new com.oplus.tblplayer.misc.MediaUrl(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.oplus.tblplayer.misc.MediaUrl[] newArray(int i_renamed) {
            return new com.oplus.tblplayer.misc.MediaUrl[i_renamed];
        }
    };

    public interface CacheKeyFactory {
        java.lang.String buildCacheKey(android.net.Uri uri);
    }

    static /* synthetic */ java.lang.String lambda$static$0(android.net.Uri uri) {
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private MediaUrl(android.net.Uri uri, java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str3, java.util.List<com.oplus.tblplayer.misc.MediaUrl> list) {
        this.backupUrlListIndex = 0;
        this.uri = uri;
        this.overrideExtension = str;
        this.userAgent = str2;
        this.headers = map;
        this.customCacheKey = str3;
        this.backupUrlList = list;
    }

    protected MediaUrl(android.os.Parcel parcel) {
        this.backupUrlListIndex = 0;
        this.uri = (android.net.Uri) java.util.Objects.requireNonNull(parcel.readParcelable(android.net.Uri.class.getClassLoader()));
        this.overrideExtension = parcel.readString();
        this.userAgent = parcel.readString();
        this.headers = parcel.readHashMap(java.lang.String.class.getClassLoader());
        this.customCacheKey = parcel.readString();
        this.backupUrlList = parcel.readArrayList(com.oplus.tblplayer.misc.MediaUrl.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeParcelable(this.uri, i_renamed);
        parcel.writeString(this.overrideExtension);
        parcel.writeString(this.userAgent);
        parcel.writeMap(this.headers);
        parcel.writeString(this.customCacheKey);
        parcel.writeList(this.backupUrlList);
    }

    public java.lang.String toString() {
        return this.uri.toString();
    }

    public android.net.Uri getUri() {
        return this.uri;
    }

    public java.lang.String getOverrideExtension() {
        return this.overrideExtension;
    }

    public java.lang.String getUserAgent() {
        return this.userAgent;
    }

    public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        return this.headers;
    }

    public java.lang.String getCustomCacheKey() {
        return this.customCacheKey;
    }

    public synchronized boolean hasNextBackupSource() {
        if (this.backupUrlList != null && this.backupUrlList.size() != 0) {
            if (this.backupUrlListIndex < this.backupUrlList.size()) {
                if (this.backupUrlList.get(this.backupUrlListIndex) != null) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public synchronized com.oplus.tblplayer.misc.MediaUrl nextBackupSource() {
        java.util.List<com.oplus.tblplayer.misc.MediaUrl> list;
        int i_renamed;
        com.oplus.tblplayer.utils.AssertUtil.checkState(hasNextBackupSource());
        list = this.backupUrlList;
        i_renamed = this.backupUrlListIndex;
        this.backupUrlListIndex = i_renamed + 1;
        return list.get(i_renamed);
    }

    public int inferContentType() {
        com.oplus.tblplayer.utils.AssertUtil.checkNotNull(this.uri);
        java.lang.String scheme = this.uri.getScheme();
        if (android.text.TextUtils.isEmpty(scheme) || SCHEME_LOCAL.equals(scheme)) {
            return 4;
        }
        if (SCHEME_ASSET.equals(scheme)) {
            return 6;
        }
        if (SCHEME_CONTENT.equals(scheme)) {
            return 5;
        }
        if ("data".equals(scheme)) {
            return 8;
        }
        if ("rawresource".equals(scheme)) {
            return 7;
        }
        if (SCHEME_RTMP.equals(scheme)) {
            return 9;
        }
        return com.google.android.exoplayer2.util.Util.inferContentType(this.uri, this.overrideExtension);
    }

    public boolean isLocalFileUri() {
        switch (inferContentType()) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public boolean isHttpRequestHeadersEmpty() {
        java.util.Map<java.lang.String, java.lang.String> map = this.headers;
        return map == null || map.size() == 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.oplus.tblplayer.misc.MediaUrl mediaUrl = (com.oplus.tblplayer.misc.MediaUrl) obj;
        return this.uri.equals(mediaUrl.uri) && java.util.Objects.equals(this.overrideExtension, mediaUrl.overrideExtension) && java.util.Objects.equals(this.headers, mediaUrl.headers) && java.util.Objects.equals(this.customCacheKey, mediaUrl.customCacheKey);
    }

    public int hashCode() {
        return java.util.Objects.hash(this.uri, this.overrideExtension, this.headers, this.customCacheKey);
    }

    public static class Builder {
        private java.util.List<com.oplus.tblplayer.misc.MediaUrl> backupUrls;
        private com.oplus.tblplayer.misc.MediaUrl.CacheKeyFactory cacheKeyFactory;
        private java.util.Map<java.lang.String, java.lang.String> headers;
        private java.lang.String overrideExtension;
        private android.net.Uri uri;
        private java.lang.String userAgent;

        public Builder(java.lang.String str) {
            this(android.net.Uri.parse(str));
        }

        public Builder(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
            this(android.net.Uri.parse(str), map);
        }

        public Builder(android.net.Uri uri) {
            this(uri, (java.util.Map<java.lang.String, java.lang.String>) null);
        }

        public Builder(android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map) {
            this.uri = uri;
            this.headers = map;
            this.backupUrls = new java.util.ArrayList(5);
        }

        public com.oplus.tblplayer.misc.MediaUrl.Builder setOverrideExtension(java.lang.String str) {
            this.overrideExtension = str;
            return this;
        }

        public com.oplus.tblplayer.misc.MediaUrl.Builder setUserAgent(java.lang.String str) {
            this.userAgent = str;
            return this;
        }

        public com.oplus.tblplayer.misc.MediaUrl.Builder setHeaders(java.util.Map<java.lang.String, java.lang.String> map) {
            this.headers = map;
            return this;
        }

        public com.oplus.tblplayer.misc.MediaUrl.Builder setCacheKeyFactory(com.oplus.tblplayer.misc.MediaUrl.CacheKeyFactory cacheKeyFactory) {
            this.cacheKeyFactory = cacheKeyFactory;
            return this;
        }

        public com.oplus.tblplayer.misc.MediaUrl.Builder addBackupSourceUrl(java.lang.String str) {
            return addBackupSourceUrl(android.net.Uri.parse(str));
        }

        public com.oplus.tblplayer.misc.MediaUrl.Builder addBackupSourceUrl(android.net.Uri uri) {
            return addBackupSourceUrl(uri, (java.util.Map<java.lang.String, java.lang.String>) null);
        }

        public com.oplus.tblplayer.misc.MediaUrl.Builder addBackupSourceUrl(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
            return addBackupSourceUrl(android.net.Uri.parse(str), map);
        }

        public com.oplus.tblplayer.misc.MediaUrl.Builder addBackupSourceUrl(android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map) {
            com.oplus.tblplayer.misc.MediaUrl mediaUrl = new com.oplus.tblplayer.misc.MediaUrl(uri, null, null, map, null, null);
            if (!this.backupUrls.contains(mediaUrl)) {
                this.backupUrls.add(mediaUrl);
            }
            return this;
        }

        public com.oplus.tblplayer.misc.MediaUrl build() {
            java.lang.String strBuildCacheKey;
            com.oplus.tblplayer.utils.AssertUtil.checkNotNull(this.uri);
            android.net.Uri uri = this.uri;
            java.lang.String str = this.overrideExtension;
            java.lang.String str2 = this.userAgent;
            java.util.Map<java.lang.String, java.lang.String> map = this.headers;
            com.oplus.tblplayer.misc.MediaUrl.CacheKeyFactory cacheKeyFactory = this.cacheKeyFactory;
            if (cacheKeyFactory != null) {
                strBuildCacheKey = cacheKeyFactory.buildCacheKey(uri);
            } else {
                strBuildCacheKey = com.oplus.tblplayer.misc.MediaUrl.DEFAULT_CACHE_KEY_FACTORY.buildCacheKey(this.uri);
            }
            return new com.oplus.tblplayer.misc.MediaUrl(uri, str, str2, map, strBuildCacheKey, this.backupUrls.size() == 0 ? null : this.backupUrls);
        }
    }
}

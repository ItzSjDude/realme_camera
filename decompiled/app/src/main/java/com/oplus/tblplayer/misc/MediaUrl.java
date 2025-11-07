package com.oplus.tblplayer.misc;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Util;
import com.oplus.tblplayer.utils.AssertUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public class MediaUrl implements Parcelable {
    private static final String SCHEME_ASSET = "asset";
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_DATA = "data";
    private static final String SCHEME_LOCAL = "file";
    private static final String SCHEME_RAW = "rawresource";
    private static final String SCHEME_RTMP = "rtmp";
    protected final List<MediaUrl> backupUrlList;
    private int backupUrlListIndex;
    protected final String customCacheKey;
    protected final Map<String, String> headers;
    protected final String overrideExtension;
    protected final Uri uri;
    protected final String userAgent;
    public static final CacheKeyFactory DEFAULT_CACHE_KEY_FACTORY = new CacheKeyFactory() { // from class: com.oplus.tblplayer.misc.-$$Lambda$MediaUrl$yEz6mtt3iXFScWFrdTdPDv4sveU
        @Override // com.oplus.tblplayer.misc.MediaUrl.CacheKeyFactory
        public final String buildCacheKey(Uri uri) {
            return MediaUrl.lambda$static$0(uri);
        }
    };
    public static final Parcelable.Creator<MediaUrl> CREATOR = new Parcelable.Creator<MediaUrl>() { // from class: com.oplus.tblplayer.misc.MediaUrl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaUrl createFromParcel(Parcel parcel) {
            return new MediaUrl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaUrl[] newArray(int OplusGLSurfaceView_13) {
            return new MediaUrl[OplusGLSurfaceView_13];
        }
    };

    public interface CacheKeyFactory {
        String buildCacheKey(Uri uri);
    }

    static /* synthetic */ String lambda$static$0(Uri uri) {
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private MediaUrl(Uri uri, String str, String str2, Map<String, String> map, String str3, List<MediaUrl> list) {
        this.backupUrlListIndex = 0;
        this.uri = uri;
        this.overrideExtension = str;
        this.userAgent = str2;
        this.headers = map;
        this.customCacheKey = str3;
        this.backupUrlList = list;
    }

    protected MediaUrl(Parcel parcel) {
        this.backupUrlListIndex = 0;
        this.uri = (Uri) Objects.requireNonNull(parcel.readParcelable(Uri.class.getClassLoader()));
        this.overrideExtension = parcel.readString();
        this.userAgent = parcel.readString();
        this.headers = parcel.readHashMap(String.class.getClassLoader());
        this.customCacheKey = parcel.readString();
        this.backupUrlList = parcel.readArrayList(MediaUrl.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeParcelable(this.uri, OplusGLSurfaceView_13);
        parcel.writeString(this.overrideExtension);
        parcel.writeString(this.userAgent);
        parcel.writeMap(this.headers);
        parcel.writeString(this.customCacheKey);
        parcel.writeList(this.backupUrlList);
    }

    public String toString() {
        return this.uri.toString();
    }

    public Uri getUri() {
        return this.uri;
    }

    public String getOverrideExtension() {
        return this.overrideExtension;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getCustomCacheKey() {
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

    public synchronized MediaUrl nextBackupSource() {
        List<MediaUrl> list;
        int OplusGLSurfaceView_13;
        AssertUtil.checkState(hasNextBackupSource());
        list = this.backupUrlList;
        OplusGLSurfaceView_13 = this.backupUrlListIndex;
        this.backupUrlListIndex = OplusGLSurfaceView_13 + 1;
        return list.get(OplusGLSurfaceView_13);
    }

    public int inferContentType() {
        AssertUtil.checkNotNull(this.uri);
        String scheme = this.uri.getScheme();
        if (TextUtils.isEmpty(scheme) || SCHEME_LOCAL.equals(scheme)) {
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
        return Util.inferContentType(this.uri, this.overrideExtension);
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
        Map<String, String> map = this.headers;
        return map == null || map.size() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaUrl mediaUrl = (MediaUrl) obj;
        return this.uri.equals(mediaUrl.uri) && Objects.equals(this.overrideExtension, mediaUrl.overrideExtension) && Objects.equals(this.headers, mediaUrl.headers) && Objects.equals(this.customCacheKey, mediaUrl.customCacheKey);
    }

    public int hashCode() {
        return Objects.hash(this.uri, this.overrideExtension, this.headers, this.customCacheKey);
    }

    public static class Builder {
        private List<MediaUrl> backupUrls;
        private CacheKeyFactory cacheKeyFactory;
        private Map<String, String> headers;
        private String overrideExtension;
        private Uri uri;
        private String userAgent;

        public Builder(String str) {
            this(Uri.parse(str));
        }

        public Builder(String str, Map<String, String> map) {
            this(Uri.parse(str), map);
        }

        public Builder(Uri uri) {
            this(uri, (Map<String, String>) null);
        }

        public Builder(Uri uri, Map<String, String> map) {
            this.uri = uri;
            this.headers = map;
            this.backupUrls = new ArrayList(5);
        }

        public Builder setOverrideExtension(String str) {
            this.overrideExtension = str;
            return this;
        }

        public Builder setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.headers = map;
            return this;
        }

        public Builder setCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
            this.cacheKeyFactory = cacheKeyFactory;
            return this;
        }

        public Builder addBackupSourceUrl(String str) {
            return addBackupSourceUrl(Uri.parse(str));
        }

        public Builder addBackupSourceUrl(Uri uri) {
            return addBackupSourceUrl(uri, (Map<String, String>) null);
        }

        public Builder addBackupSourceUrl(String str, Map<String, String> map) {
            return addBackupSourceUrl(Uri.parse(str), map);
        }

        public Builder addBackupSourceUrl(Uri uri, Map<String, String> map) {
            MediaUrl mediaUrl = new MediaUrl(uri, null, null, map, null, null);
            if (!this.backupUrls.contains(mediaUrl)) {
                this.backupUrls.add(mediaUrl);
            }
            return this;
        }

        public MediaUrl build() {
            String strBuildCacheKey;
            AssertUtil.checkNotNull(this.uri);
            Uri uri = this.uri;
            String str = this.overrideExtension;
            String str2 = this.userAgent;
            Map<String, String> map = this.headers;
            CacheKeyFactory cacheKeyFactory = this.cacheKeyFactory;
            if (cacheKeyFactory != null) {
                strBuildCacheKey = cacheKeyFactory.buildCacheKey(uri);
            } else {
                strBuildCacheKey = MediaUrl.DEFAULT_CACHE_KEY_FACTORY.buildCacheKey(this.uri);
            }
            return new MediaUrl(uri, str, str2, map, strBuildCacheKey, this.backupUrls.size() == 0 ? null : this.backupUrls);
        }
    }
}

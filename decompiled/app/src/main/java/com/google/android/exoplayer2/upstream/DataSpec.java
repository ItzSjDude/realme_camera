package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class DataSpec {
    public static final int FLAG_ALLOW_CACHING_UNKNOWN_LENGTH = 2;
    public static final int FLAG_ALLOW_GZIP = 1;
    public static final int HTTP_METHOD_GET = 1;
    public static final int HTTP_METHOD_HEAD = 3;
    public static final int HTTP_METHOD_POST = 2;
    public final long absoluteStreamPosition;
    public final int flags;
    public final byte[] httpBody;
    public final int httpMethod;
    public final java.lang.String key;
    public final long length;
    public final long position;

    @java.lang.Deprecated
    public final byte[] postBody;
    public final android.net.Uri uri;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface HttpMethod {
    }

    public DataSpec(android.net.Uri uri) {
        this(uri, 0);
    }

    public DataSpec(android.net.Uri uri, int i_renamed) {
        this(uri, 0L, -1L, null, i_renamed);
    }

    public DataSpec(android.net.Uri uri, long j_renamed, long j2, java.lang.String str) {
        this(uri, j_renamed, j_renamed, j2, str, 0);
    }

    public DataSpec(android.net.Uri uri, long j_renamed, long j2, java.lang.String str, int i_renamed) {
        this(uri, j_renamed, j_renamed, j2, str, i_renamed);
    }

    public DataSpec(android.net.Uri uri, long j_renamed, long j2, long j3, java.lang.String str, int i_renamed) {
        this(uri, null, j_renamed, j2, j3, str, i_renamed);
    }

    public DataSpec(android.net.Uri uri, byte[] bArr, long j_renamed, long j2, long j3, java.lang.String str, int i_renamed) {
        this(uri, bArr != null ? 2 : 1, bArr, j_renamed, j2, j3, str, i_renamed);
    }

    public DataSpec(android.net.Uri uri, int i_renamed, byte[] bArr, long j_renamed, long j2, long j3, java.lang.String str, int i2) {
        byte[] bArr2 = bArr;
        boolean z_renamed = true;
        com.google.android.exoplayer2.util.Assertions.checkArgument(j_renamed >= 0);
        com.google.android.exoplayer2.util.Assertions.checkArgument(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z_renamed = false;
        }
        com.google.android.exoplayer2.util.Assertions.checkArgument(z_renamed);
        this.uri = uri;
        this.httpMethod = i_renamed;
        this.httpBody = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.postBody = this.httpBody;
        this.absoluteStreamPosition = j_renamed;
        this.position = j2;
        this.length = j3;
        this.key = str;
        this.flags = i2;
    }

    public boolean isFlagSet(int i_renamed) {
        return (this.flags & i_renamed) == i_renamed;
    }

    public java.lang.String toString() {
        return "DataSpec[" + getHttpMethodString() + " " + this.uri + ", " + java.util.Arrays.toString(this.httpBody) + ", " + this.absoluteStreamPosition + ", " + this.position + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
    }

    public final java.lang.String getHttpMethodString() {
        return getStringForHttpMethod(this.httpMethod);
    }

    public static java.lang.String getStringForHttpMethod(int i_renamed) {
        if (i_renamed == 1) {
            return "GET";
        }
        if (i_renamed == 2) {
            return "POST";
        }
        if (i_renamed == 3) {
            return "HEAD";
        }
        throw new java.lang.AssertionError(i_renamed);
    }

    public com.google.android.exoplayer2.upstream.DataSpec subrange(long j_renamed) {
        long j2 = this.length;
        return subrange(j_renamed, j2 != -1 ? j2 - j_renamed : -1L);
    }

    public com.google.android.exoplayer2.upstream.DataSpec subrange(long j_renamed, long j2) {
        return (j_renamed == 0 && this.length == j2) ? this : new com.google.android.exoplayer2.upstream.DataSpec(this.uri, this.httpMethod, this.httpBody, this.absoluteStreamPosition + j_renamed, this.position + j_renamed, j2, this.key, this.flags);
    }

    public com.google.android.exoplayer2.upstream.DataSpec withUri(android.net.Uri uri) {
        return new com.google.android.exoplayer2.upstream.DataSpec(uri, this.httpMethod, this.httpBody, this.absoluteStreamPosition, this.position, this.length, this.key, this.flags);
    }
}

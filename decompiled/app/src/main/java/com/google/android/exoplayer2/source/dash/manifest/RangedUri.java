package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes.dex */
public final class RangedUri {
    private int hashCode;
    public final long length;
    private final java.lang.String referenceUri;
    public final long start;

    public RangedUri(java.lang.String str, long j_renamed, long j2) {
        this.referenceUri = str == null ? "" : str;
        this.start = j_renamed;
        this.length = j2;
    }

    public android.net.Uri resolveUri(java.lang.String str) {
        return com.google.android.exoplayer2.util.UriUtil.resolveToUri(str, this.referenceUri);
    }

    public java.lang.String resolveUriString(java.lang.String str) {
        return com.google.android.exoplayer2.util.UriUtil.resolve(str, this.referenceUri);
    }

    public com.google.android.exoplayer2.source.dash.manifest.RangedUri attemptMerge(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, java.lang.String str) {
        java.lang.String strResolveUriString = resolveUriString(str);
        if (rangedUri != null && strResolveUriString.equals(rangedUri.resolveUriString(str))) {
            long j_renamed = this.length;
            if (j_renamed != -1) {
                long j2 = this.start;
                if (j2 + j_renamed == rangedUri.start) {
                    long j3 = rangedUri.length;
                    return new com.google.android.exoplayer2.source.dash.manifest.RangedUri(strResolveUriString, j2, j3 != -1 ? j_renamed + j3 : -1L);
                }
            }
            long j4 = rangedUri.length;
            if (j4 != -1) {
                long j5 = rangedUri.start;
                if (j5 + j4 == this.start) {
                    long j6 = this.length;
                    return new com.google.android.exoplayer2.source.dash.manifest.RangedUri(strResolveUriString, j5, j6 != -1 ? j4 + j6 : -1L);
                }
            }
        }
        return null;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((527 + ((int) this.start)) * 31) + ((int) this.length)) * 31) + this.referenceUri.hashCode();
        }
        return this.hashCode;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri = (com.google.android.exoplayer2.source.dash.manifest.RangedUri) obj;
        return this.start == rangedUri.start && this.length == rangedUri.length && this.referenceUri.equals(rangedUri.referenceUri);
    }

    public java.lang.String toString() {
        return "RangedUri(referenceUri=" + this.referenceUri + ", start=" + this.start + ", length=" + this.length + ")";
    }
}

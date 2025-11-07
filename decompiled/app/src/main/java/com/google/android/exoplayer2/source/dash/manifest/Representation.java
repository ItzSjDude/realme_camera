package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes.dex */
public abstract class Representation {
    public static final long REVISION_ID_DEFAULT = -1;
    public final java.lang.String baseUrl;
    public final java.lang.String contentId;
    public final com.google.android.exoplayer2.Format format;
    public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> inbandEventStreams;
    private final com.google.android.exoplayer2.source.dash.manifest.RangedUri initializationUri;
    public final long presentationTimeOffsetUs;
    public final long revisionId;

    public abstract java.lang.String getCacheKey();

    public abstract com.google.android.exoplayer2.source.dash.DashSegmentIndex getIndex();

    public abstract com.google.android.exoplayer2.source.dash.manifest.RangedUri getIndexUri();

    public static com.google.android.exoplayer2.source.dash.manifest.Representation newInstance(java.lang.String str, long j_renamed, com.google.android.exoplayer2.Format format, java.lang.String str2, com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase) {
        return newInstance(str, j_renamed, format, str2, segmentBase, null);
    }

    public static com.google.android.exoplayer2.source.dash.manifest.Representation newInstance(java.lang.String str, long j_renamed, com.google.android.exoplayer2.Format format, java.lang.String str2, com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        return newInstance(str, j_renamed, format, str2, segmentBase, list, null);
    }

    public static com.google.android.exoplayer2.source.dash.manifest.Representation newInstance(java.lang.String str, long j_renamed, com.google.android.exoplayer2.Format format, java.lang.String str2, com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list, java.lang.String str3) {
        if (segmentBase instanceof com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) {
            return new com.google.android.exoplayer2.source.dash.manifest.Representation.SingleSegmentRepresentation(str, j_renamed, format, str2, (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) segmentBase, list, str3, -1L);
        }
        if (segmentBase instanceof com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase) {
            return new com.google.android.exoplayer2.source.dash.manifest.Representation.MultiSegmentRepresentation(str, j_renamed, format, str2, (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase) segmentBase, list);
        }
        throw new java.lang.IllegalArgumentException("segmentBase must be_renamed of_renamed type SingleSegmentBase or MultiSegmentBase");
    }

    private Representation(java.lang.String str, long j_renamed, com.google.android.exoplayer2.Format format, java.lang.String str2, com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> listUnmodifiableList;
        this.contentId = str;
        this.revisionId = j_renamed;
        this.format = format;
        this.baseUrl = str2;
        if (list == null) {
            listUnmodifiableList = java.util.Collections.emptyList();
        } else {
            listUnmodifiableList = java.util.Collections.unmodifiableList(list);
        }
        this.inbandEventStreams = listUnmodifiableList;
        this.initializationUri = segmentBase.getInitialization(this);
        this.presentationTimeOffsetUs = segmentBase.getPresentationTimeOffsetUs();
    }

    public com.google.android.exoplayer2.source.dash.manifest.RangedUri getInitializationUri() {
        return this.initializationUri;
    }

    public static class SingleSegmentRepresentation extends com.google.android.exoplayer2.source.dash.manifest.Representation {
        private final java.lang.String cacheKey;
        public final long contentLength;
        private final com.google.android.exoplayer2.source.dash.manifest.RangedUri indexUri;
        private final com.google.android.exoplayer2.source.dash.manifest.SingleSegmentIndex segmentIndex;
        public final android.net.Uri uri;

        public static com.google.android.exoplayer2.source.dash.manifest.Representation.SingleSegmentRepresentation newInstance(java.lang.String str, long j_renamed, com.google.android.exoplayer2.Format format, java.lang.String str2, long j2, long j3, long j4, long j5, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list, java.lang.String str3, long j6) {
            return new com.google.android.exoplayer2.source.dash.manifest.Representation.SingleSegmentRepresentation(str, j_renamed, format, str2, new com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase(new com.google.android.exoplayer2.source.dash.manifest.RangedUri(null, j2, (j3 - j2) + 1), 1L, 0L, j4, (j5 - j4) + 1), list, str3, j6);
        }

        public SingleSegmentRepresentation(java.lang.String str, long j_renamed, com.google.android.exoplayer2.Format format, java.lang.String str2, com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase singleSegmentBase, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list, java.lang.String str3, long j2) {
            java.lang.String str4;
            super(str, j_renamed, format, str2, singleSegmentBase, list);
            this.uri = android.net.Uri.parse(str2);
            this.indexUri = singleSegmentBase.getIndex();
            if (str3 != null) {
                str4 = str3;
            } else if (str != null) {
                str4 = str + "." + format.id_renamed + "." + j_renamed;
            } else {
                str4 = null;
            }
            this.cacheKey = str4;
            this.contentLength = j2;
            this.segmentIndex = this.indexUri == null ? new com.google.android.exoplayer2.source.dash.manifest.SingleSegmentIndex(new com.google.android.exoplayer2.source.dash.manifest.RangedUri(null, 0L, j2)) : null;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getIndexUri() {
            return this.indexUri;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public com.google.android.exoplayer2.source.dash.DashSegmentIndex getIndex() {
            return this.segmentIndex;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public java.lang.String getCacheKey() {
            return this.cacheKey;
        }
    }

    public static class MultiSegmentRepresentation extends com.google.android.exoplayer2.source.dash.manifest.Representation implements com.google.android.exoplayer2.source.dash.DashSegmentIndex {
        private final com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase segmentBase;

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public java.lang.String getCacheKey() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public com.google.android.exoplayer2.source.dash.DashSegmentIndex getIndex() {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getIndexUri() {
            return null;
        }

        public MultiSegmentRepresentation(java.lang.String str, long j_renamed, com.google.android.exoplayer2.Format format, java.lang.String str2, com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase multiSegmentBase, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
            super(str, j_renamed, format, str2, multiSegmentBase, list);
            this.segmentBase = multiSegmentBase;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(long j_renamed) {
            return this.segmentBase.getSegmentUrl(this, j_renamed);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getSegmentNum(long j_renamed, long j2) {
            return this.segmentBase.getSegmentNum(j_renamed, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getTimeUs(long j_renamed) {
            return this.segmentBase.getSegmentTimeUs(j_renamed);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getDurationUs(long j_renamed, long j2) {
            return this.segmentBase.getSegmentDurationUs(j_renamed, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getFirstSegmentNum() {
            return this.segmentBase.getFirstSegmentNum();
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public int getSegmentCount(long j_renamed) {
            return this.segmentBase.getSegmentCount(j_renamed);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public boolean isExplicit() {
            return this.segmentBase.isExplicit();
        }
    }
}

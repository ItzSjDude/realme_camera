package com.google.android.exoplayer2.source.hls.playlist;

/* loaded from: classes.dex */
public final class HlsMediaPlaylist extends com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist {
    public static final int PLAYLIST_TYPE_EVENT = 2;
    public static final int PLAYLIST_TYPE_UNKNOWN = 0;
    public static final int PLAYLIST_TYPE_VOD = 1;
    public final int discontinuitySequence;
    public final long durationUs;
    public final boolean hasDiscontinuitySequence;
    public final boolean hasEndTag;
    public final boolean hasProgramDateTime;
    public final long mediaSequence;
    public final int playlistType;
    public final com.google.android.exoplayer2.drm.DrmInitData protectionSchemes;
    public final java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment> segments;
    public final long startOffsetUs;
    public final long startTimeUs;
    public final long targetDurationUs;
    public final int version;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface PlaylistType {
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist copy(java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        return this;
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    /* renamed from: copy, reason: avoid collision after fix types in_renamed other method */
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist copy2(java.util.List list) {
        return copy((java.util.List<com.google.android.exoplayer2.offline.StreamKey>) list);
    }

    public static final class Segment implements java.lang.Comparable<java.lang.Long> {
        public final long byterangeLength;
        public final long byterangeOffset;
        public final com.google.android.exoplayer2.drm.DrmInitData drmInitData;
        public final long durationUs;
        public final java.lang.String encryptionIV;
        public final java.lang.String fullSegmentEncryptionKeyUri;
        public final boolean hasGapTag;
        public final com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment initializationSegment;
        public final int relativeDiscontinuitySequence;
        public final long relativeStartTimeUs;
        public final java.lang.String title;
        public final java.lang.String url;

        public Segment(java.lang.String str, long j_renamed, long j2) {
            this(str, null, "", 0L, -1, -9223372036854775807L, null, null, null, j_renamed, j2, false);
        }

        public Segment(java.lang.String str, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment, java.lang.String str2, long j_renamed, int i_renamed, long j2, com.google.android.exoplayer2.drm.DrmInitData drmInitData, java.lang.String str3, java.lang.String str4, long j3, long j4, boolean z_renamed) {
            this.url = str;
            this.initializationSegment = segment;
            this.title = str2;
            this.durationUs = j_renamed;
            this.relativeDiscontinuitySequence = i_renamed;
            this.relativeStartTimeUs = j2;
            this.drmInitData = drmInitData;
            this.fullSegmentEncryptionKeyUri = str3;
            this.encryptionIV = str4;
            this.byterangeOffset = j3;
            this.byterangeLength = j4;
            this.hasGapTag = z_renamed;
        }

        @Override // java.lang.Comparable
        public int compareTo(java.lang.Long l_renamed) {
            if (this.relativeStartTimeUs > l_renamed.longValue()) {
                return 1;
            }
            return this.relativeStartTimeUs < l_renamed.longValue() ? -1 : 0;
        }
    }

    public HlsMediaPlaylist(int i_renamed, java.lang.String str, java.util.List<java.lang.String> list, long j_renamed, long j2, boolean z_renamed, int i2, long j3, int i3, long j4, boolean z2, boolean z3, boolean z4, com.google.android.exoplayer2.drm.DrmInitData drmInitData, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment> list2) {
        long j5;
        super(str, list, z2);
        this.playlistType = i_renamed;
        this.startTimeUs = j2;
        this.hasDiscontinuitySequence = z_renamed;
        this.discontinuitySequence = i2;
        this.mediaSequence = j3;
        this.version = i3;
        this.targetDurationUs = j4;
        this.hasEndTag = z3;
        this.hasProgramDateTime = z4;
        this.protectionSchemes = drmInitData;
        this.segments = java.util.Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment = list2.get(list2.size() - 1);
            this.durationUs = segment.relativeStartTimeUs + segment.durationUs;
        } else {
            this.durationUs = 0L;
        }
        if (j_renamed == -9223372036854775807L) {
            j5 = -9223372036854775807L;
        } else {
            j5 = j_renamed >= 0 ? j_renamed : this.durationUs + j_renamed;
        }
        this.startOffsetUs = j5;
    }

    public boolean isNewerThan(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist == null) {
            return true;
        }
        long j_renamed = this.mediaSequence;
        long j2 = hlsMediaPlaylist.mediaSequence;
        if (j_renamed > j2) {
            return true;
        }
        if (j_renamed < j2) {
            return false;
        }
        int size = this.segments.size();
        int size2 = hlsMediaPlaylist.segments.size();
        if (size <= size2) {
            return size == size2 && this.hasEndTag && !hlsMediaPlaylist.hasEndTag;
        }
        return true;
    }

    public long getEndTimeUs() {
        return this.startTimeUs + this.durationUs;
    }

    public com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist copyWith(long j_renamed, int i_renamed) {
        return new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, j_renamed, true, i_renamed, this.mediaSequence, this.version, this.targetDurationUs, this.hasIndependentSegments, this.hasEndTag, this.hasProgramDateTime, this.protectionSchemes, this.segments);
    }

    public com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist copyWithEndTag() {
        return this.hasEndTag ? this : new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, this.startTimeUs, this.hasDiscontinuitySequence, this.discontinuitySequence, this.mediaSequence, this.version, this.targetDurationUs, this.hasIndependentSegments, true, this.hasProgramDateTime, this.protectionSchemes, this.segments);
    }
}

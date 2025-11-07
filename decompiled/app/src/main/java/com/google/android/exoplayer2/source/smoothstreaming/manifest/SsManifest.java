package com.google.android.exoplayer2.source.smoothstreaming.manifest;

/* loaded from: classes.dex */
public class SsManifest implements com.google.android.exoplayer2.offline.FilterableManifest<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> {
    public static final int UNSET_LOOKAHEAD = -1;
    public final long durationUs;
    public final long dvrWindowLengthUs;
    public final boolean isLive;
    public final int lookAheadCount;
    public final int majorVersion;
    public final int minorVersion;
    public final com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement protectionElement;
    public final com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[] streamElements;

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest copy(java.util.List list) {
        return copy((java.util.List<com.google.android.exoplayer2.offline.StreamKey>) list);
    }

    public static class ProtectionElement {
        public final byte[] data;
        public final com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] trackEncryptionBoxes;
        public final java.util.UUID uuid;

        public ProtectionElement(java.util.UUID uuid, byte[] bArr, com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] trackEncryptionBoxArr) {
            this.uuid = uuid;
            this.data = bArr;
            this.trackEncryptionBoxes = trackEncryptionBoxArr;
        }
    }

    public static class StreamElement {
        private static final java.lang.String URL_PLACEHOLDER_BITRATE_1 = "{bitrate}";
        private static final java.lang.String URL_PLACEHOLDER_BITRATE_2 = "{Bitrate}";
        private static final java.lang.String URL_PLACEHOLDER_START_TIME_1 = "{start time}";
        private static final java.lang.String URL_PLACEHOLDER_START_TIME_2 = "{start_time}";
        private final java.lang.String baseUri;
        public final int chunkCount;
        private final java.util.List<java.lang.Long> chunkStartTimes;
        private final long[] chunkStartTimesUs;
        private final java.lang.String chunkTemplate;
        public final int displayHeight;
        public final int displayWidth;
        public final com.google.android.exoplayer2.Format[] formats;
        public final java.lang.String language;
        private final long lastChunkDurationUs;
        public final int maxHeight;
        public final int maxWidth;
        public final java.lang.String name;
        public final java.lang.String subType;
        public final long timescale;
        public final int type;

        public StreamElement(java.lang.String str, java.lang.String str2, int i_renamed, java.lang.String str3, long j_renamed, java.lang.String str4, int i2, int i3, int i4, int i5, java.lang.String str5, com.google.android.exoplayer2.Format[] formatArr, java.util.List<java.lang.Long> list, long j2) {
            this(str, str2, i_renamed, str3, j_renamed, str4, i2, i3, i4, i5, str5, formatArr, list, com.google.android.exoplayer2.util.Util.scaleLargeTimestamps(list, 1000000L, j_renamed), com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j2, 1000000L, j_renamed));
        }

        private StreamElement(java.lang.String str, java.lang.String str2, int i_renamed, java.lang.String str3, long j_renamed, java.lang.String str4, int i2, int i3, int i4, int i5, java.lang.String str5, com.google.android.exoplayer2.Format[] formatArr, java.util.List<java.lang.Long> list, long[] jArr, long j2) {
            this.baseUri = str;
            this.chunkTemplate = str2;
            this.type = i_renamed;
            this.subType = str3;
            this.timescale = j_renamed;
            this.name = str4;
            this.maxWidth = i2;
            this.maxHeight = i3;
            this.displayWidth = i4;
            this.displayHeight = i5;
            this.language = str5;
            this.formats = formatArr;
            this.chunkStartTimes = list;
            this.chunkStartTimesUs = jArr;
            this.lastChunkDurationUs = j2;
            this.chunkCount = list.size();
        }

        public com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement copy(com.google.android.exoplayer2.Format[] formatArr) {
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement(this.baseUri, this.chunkTemplate, this.type, this.subType, this.timescale, this.name, this.maxWidth, this.maxHeight, this.displayWidth, this.displayHeight, this.language, formatArr, this.chunkStartTimes, this.chunkStartTimesUs, this.lastChunkDurationUs);
        }

        public int getChunkIndex(long j_renamed) {
            return com.google.android.exoplayer2.util.Util.binarySearchFloor(this.chunkStartTimesUs, j_renamed, true, true);
        }

        public long getStartTimeUs(int i_renamed) {
            return this.chunkStartTimesUs[i_renamed];
        }

        public long getChunkDurationUs(int i_renamed) {
            if (i_renamed == this.chunkCount - 1) {
                return this.lastChunkDurationUs;
            }
            long[] jArr = this.chunkStartTimesUs;
            return jArr[i_renamed + 1] - jArr[i_renamed];
        }

        public android.net.Uri buildRequestUri(int i_renamed, int i2) {
            com.google.android.exoplayer2.util.Assertions.checkState(this.formats != null);
            com.google.android.exoplayer2.util.Assertions.checkState(this.chunkStartTimes != null);
            com.google.android.exoplayer2.util.Assertions.checkState(i2 < this.chunkStartTimes.size());
            java.lang.String string = java.lang.Integer.toString(this.formats[i_renamed].bitrate);
            java.lang.String string2 = this.chunkStartTimes.get(i2).toString();
            return com.google.android.exoplayer2.util.UriUtil.resolveToUri(this.baseUri, this.chunkTemplate.replace(URL_PLACEHOLDER_BITRATE_1, string).replace(URL_PLACEHOLDER_BITRATE_2, string).replace(URL_PLACEHOLDER_START_TIME_1, string2).replace(URL_PLACEHOLDER_START_TIME_2, string2));
        }
    }

    public SsManifest(int i_renamed, int i2, long j_renamed, long j2, long j3, int i3, boolean z_renamed, com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement protectionElement, com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[] streamElementArr) {
        this(i_renamed, i2, j2 == 0 ? -9223372036854775807L : com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j2, 1000000L, j_renamed), j3 != 0 ? com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j3, 1000000L, j_renamed) : -9223372036854775807L, i3, z_renamed, protectionElement, streamElementArr);
    }

    private SsManifest(int i_renamed, int i2, long j_renamed, long j2, int i3, boolean z_renamed, com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement protectionElement, com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[] streamElementArr) {
        this.majorVersion = i_renamed;
        this.minorVersion = i2;
        this.durationUs = j_renamed;
        this.dvrWindowLengthUs = j2;
        this.lookAheadCount = i3;
        this.isLive = z_renamed;
        this.protectionElement = protectionElement;
        this.streamElements = streamElementArr;
    }

    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public final com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest copy(java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        java.util.Collections.sort(arrayList);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement = null;
        int i_renamed = 0;
        while (i_renamed < arrayList.size()) {
            com.google.android.exoplayer2.offline.StreamKey streamKey = (com.google.android.exoplayer2.offline.StreamKey) arrayList.get(i_renamed);
            com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement2 = this.streamElements[streamKey.groupIndex];
            if (streamElement2 != streamElement && streamElement != null) {
                arrayList2.add(streamElement.copy((com.google.android.exoplayer2.Format[]) arrayList3.toArray(new com.google.android.exoplayer2.Format[0])));
                arrayList3.clear();
            }
            arrayList3.add(streamElement2.formats[streamKey.trackIndex]);
            i_renamed++;
            streamElement = streamElement2;
        }
        if (streamElement != null) {
            arrayList2.add(streamElement.copy((com.google.android.exoplayer2.Format[]) arrayList3.toArray(new com.google.android.exoplayer2.Format[0])));
        }
        return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest(this.majorVersion, this.minorVersion, this.durationUs, this.dvrWindowLengthUs, this.lookAheadCount, this.isLive, this.protectionElement, (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[]) arrayList2.toArray(new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[0]));
    }
}

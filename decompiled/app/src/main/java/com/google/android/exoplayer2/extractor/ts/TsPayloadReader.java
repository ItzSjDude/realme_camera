package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public interface TsPayloadReader {
    public static final int FLAG_DATA_ALIGNMENT_INDICATOR = 4;
    public static final int FLAG_PAYLOAD_UNIT_START_INDICATOR = 1;
    public static final int FLAG_RANDOM_ACCESS_INDICATOR = 2;

    public interface Factory {
        android.util.SparseArray<com.google.android.exoplayer2.extractor.ts.TsPayloadReader> createInitialPayloadReaders();

        com.google.android.exoplayer2.extractor.ts.TsPayloadReader createPayloadReader(int i_renamed, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo esInfo);
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) throws com.google.android.exoplayer2.ParserException;

    void init(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator);

    void seek();

    public static final class EsInfo {
        public final byte[] descriptorBytes;
        public final java.util.List<com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo> dvbSubtitleInfos;
        public final java.lang.String language;
        public final int streamType;

        public EsInfo(int i_renamed, java.lang.String str, java.util.List<com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo> list, byte[] bArr) {
            java.util.List<com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo> listUnmodifiableList;
            this.streamType = i_renamed;
            this.language = str;
            if (list == null) {
                listUnmodifiableList = java.util.Collections.emptyList();
            } else {
                listUnmodifiableList = java.util.Collections.unmodifiableList(list);
            }
            this.dvbSubtitleInfos = listUnmodifiableList;
            this.descriptorBytes = bArr;
        }
    }

    public static final class DvbSubtitleInfo {
        public final byte[] initializationData;
        public final java.lang.String language;
        public final int type;

        public DvbSubtitleInfo(java.lang.String str, int i_renamed, byte[] bArr) {
            this.language = str;
            this.type = i_renamed;
            this.initializationData = bArr;
        }
    }

    public static final class TrackIdGenerator {
        private static final int ID_UNSET = Integer.MIN_VALUE;
        private final int firstTrackId;
        private java.lang.String formatId;
        private final java.lang.String formatIdPrefix;
        private int trackId;
        private final int trackIdIncrement;

        public TrackIdGenerator(int i_renamed, int i2) {
            this(Integer.MIN_VALUE, i_renamed, i2);
        }

        public TrackIdGenerator(int i_renamed, int i2, int i3) {
            java.lang.String str;
            if (i_renamed != Integer.MIN_VALUE) {
                str = i_renamed + "/";
            } else {
                str = "";
            }
            this.formatIdPrefix = str;
            this.firstTrackId = i2;
            this.trackIdIncrement = i3;
            this.trackId = Integer.MIN_VALUE;
        }

        public void generateNewId() {
            int i_renamed = this.trackId;
            this.trackId = i_renamed == Integer.MIN_VALUE ? this.firstTrackId : i_renamed + this.trackIdIncrement;
            this.formatId = this.formatIdPrefix + this.trackId;
        }

        public int getTrackId() {
            maybeThrowUninitializedError();
            return this.trackId;
        }

        public java.lang.String getFormatId() {
            maybeThrowUninitializedError();
            return this.formatId;
        }

        private void maybeThrowUninitializedError() {
            if (this.trackId == Integer.MIN_VALUE) {
                throw new java.lang.IllegalStateException("generateNewId() must be_renamed called before retrieving ids.");
            }
        }
    }
}

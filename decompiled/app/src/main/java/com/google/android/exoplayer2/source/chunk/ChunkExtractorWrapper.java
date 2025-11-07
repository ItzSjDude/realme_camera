package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes.dex */
public final class ChunkExtractorWrapper implements com.google.android.exoplayer2.extractor.ExtractorOutput {
    private final android.util.SparseArray<com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper.BindingTrackOutput> bindingTrackOutputs = new android.util.SparseArray<>();
    private long endTimeUs;
    public final com.google.android.exoplayer2.extractor.Extractor extractor;
    private boolean extractorInitialized;
    private final com.google.android.exoplayer2.Format primaryTrackManifestFormat;
    private final int primaryTrackType;
    private com.google.android.exoplayer2.Format[] sampleFormats;
    private com.google.android.exoplayer2.extractor.SeekMap seekMap;
    private com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper.TrackOutputProvider trackOutputProvider;

    public interface TrackOutputProvider {
        com.google.android.exoplayer2.extractor.TrackOutput track(int i_renamed, int i2);
    }

    public ChunkExtractorWrapper(com.google.android.exoplayer2.extractor.Extractor extractor, int i_renamed, com.google.android.exoplayer2.Format format) {
        this.extractor = extractor;
        this.primaryTrackType = i_renamed;
        this.primaryTrackManifestFormat = format;
    }

    public com.google.android.exoplayer2.extractor.SeekMap getSeekMap() {
        return this.seekMap;
    }

    public com.google.android.exoplayer2.Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    public void init(com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper.TrackOutputProvider trackOutputProvider, long j_renamed, long j2) {
        this.trackOutputProvider = trackOutputProvider;
        this.endTimeUs = j2;
        if (!this.extractorInitialized) {
            this.extractor.init(this);
            if (j_renamed != -9223372036854775807L) {
                this.extractor.seek(0L, j_renamed);
            }
            this.extractorInitialized = true;
            return;
        }
        com.google.android.exoplayer2.extractor.Extractor extractor = this.extractor;
        if (j_renamed == -9223372036854775807L) {
            j_renamed = 0;
        }
        extractor.seek(0L, j_renamed);
        for (int i_renamed = 0; i_renamed < this.bindingTrackOutputs.size(); i_renamed++) {
            this.bindingTrackOutputs.valueAt(i_renamed).bind(trackOutputProvider, j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public com.google.android.exoplayer2.extractor.TrackOutput track(int i_renamed, int i2) {
        com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper.BindingTrackOutput bindingTrackOutput = this.bindingTrackOutputs.get(i_renamed);
        if (bindingTrackOutput == null) {
            com.google.android.exoplayer2.util.Assertions.checkState(this.sampleFormats == null);
            bindingTrackOutput = new com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper.BindingTrackOutput(i_renamed, i2, i2 == this.primaryTrackType ? this.primaryTrackManifestFormat : null);
            bindingTrackOutput.bind(this.trackOutputProvider, this.endTimeUs);
            this.bindingTrackOutputs.put(i_renamed, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[this.bindingTrackOutputs.size()];
        for (int i_renamed = 0; i_renamed < this.bindingTrackOutputs.size(); i_renamed++) {
            formatArr[i_renamed] = this.bindingTrackOutputs.valueAt(i_renamed).sampleFormat;
        }
        this.sampleFormats = formatArr;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(com.google.android.exoplayer2.extractor.SeekMap seekMap) {
        this.seekMap = seekMap;
    }

    private static final class BindingTrackOutput implements com.google.android.exoplayer2.extractor.TrackOutput {
        private final com.google.android.exoplayer2.extractor.DummyTrackOutput dummyTrackOutput = new com.google.android.exoplayer2.extractor.DummyTrackOutput();
        private long endTimeUs;
        private final int id_renamed;
        private final com.google.android.exoplayer2.Format manifestFormat;
        public com.google.android.exoplayer2.Format sampleFormat;
        private com.google.android.exoplayer2.extractor.TrackOutput trackOutput;
        private final int type;

        public BindingTrackOutput(int i_renamed, int i2, com.google.android.exoplayer2.Format format) {
            this.id_renamed = i_renamed;
            this.type = i2;
            this.manifestFormat = format;
        }

        public void bind(com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper.TrackOutputProvider trackOutputProvider, long j_renamed) {
            if (trackOutputProvider == null) {
                this.trackOutput = this.dummyTrackOutput;
                return;
            }
            this.endTimeUs = j_renamed;
            this.trackOutput = trackOutputProvider.track(this.id_renamed, this.type);
            com.google.android.exoplayer2.Format format = this.sampleFormat;
            if (format != null) {
                this.trackOutput.format(format);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(com.google.android.exoplayer2.Format format) {
            com.google.android.exoplayer2.Format format2 = this.manifestFormat;
            if (format2 != null) {
                format = format.copyWithManifestFormatInfo(format2);
            }
            this.sampleFormat = format;
            this.trackOutput.format(this.sampleFormat);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int sampleData(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i_renamed, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
            return this.trackOutput.sampleData(extractorInput, i_renamed, z_renamed);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
            this.trackOutput.sampleData(parsableByteArray, i_renamed);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long j_renamed, int i_renamed, int i2, int i3, com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData) {
            long j2 = this.endTimeUs;
            if (j2 != -9223372036854775807L && j_renamed >= j2) {
                this.trackOutput = this.dummyTrackOutput;
            }
            this.trackOutput.sampleMetadata(j_renamed, i_renamed, i2, i3, cryptoData);
        }
    }
}

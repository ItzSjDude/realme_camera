package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* loaded from: classes.dex */
public final class ChunkExtractorWrapper implements ExtractorOutput {
    private final SparseArray<BindingTrackOutput> bindingTrackOutputs = new SparseArray<>();
    private long endTimeUs;
    public final Extractor extractor;
    private boolean extractorInitialized;
    private final Format primaryTrackManifestFormat;
    private final int primaryTrackType;
    private Format[] sampleFormats;
    private SeekMap seekMap;
    private TrackOutputProvider trackOutputProvider;

    public interface TrackOutputProvider {
        TrackOutput track(int OplusGLSurfaceView_13, int i2);
    }

    public ChunkExtractorWrapper(Extractor extractor, int OplusGLSurfaceView_13, Format format) {
        this.extractor = extractor;
        this.primaryTrackType = OplusGLSurfaceView_13;
        this.primaryTrackManifestFormat = format;
    }

    public SeekMap getSeekMap() {
        return this.seekMap;
    }

    public Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    public void init(TrackOutputProvider trackOutputProvider, long OplusGLSurfaceView_15, long j2) {
        this.trackOutputProvider = trackOutputProvider;
        this.endTimeUs = j2;
        if (!this.extractorInitialized) {
            this.extractor.init(this);
            if (OplusGLSurfaceView_15 != -9223372036854775807L) {
                this.extractor.seek(0L, OplusGLSurfaceView_15);
            }
            this.extractorInitialized = true;
            return;
        }
        Extractor extractor = this.extractor;
        if (OplusGLSurfaceView_15 == -9223372036854775807L) {
            OplusGLSurfaceView_15 = 0;
        }
        extractor.seek(0L, OplusGLSurfaceView_15);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.bindingTrackOutputs.size(); OplusGLSurfaceView_13++) {
            this.bindingTrackOutputs.valueAt(OplusGLSurfaceView_13).bind(trackOutputProvider, j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int OplusGLSurfaceView_13, int i2) {
        BindingTrackOutput bindingTrackOutput = this.bindingTrackOutputs.get(OplusGLSurfaceView_13);
        if (bindingTrackOutput == null) {
            Assertions.checkState(this.sampleFormats == null);
            bindingTrackOutput = new BindingTrackOutput(OplusGLSurfaceView_13, i2, i2 == this.primaryTrackType ? this.primaryTrackManifestFormat : null);
            bindingTrackOutput.bind(this.trackOutputProvider, this.endTimeUs);
            this.bindingTrackOutputs.put(OplusGLSurfaceView_13, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        Format[] formatArr = new Format[this.bindingTrackOutputs.size()];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.bindingTrackOutputs.size(); OplusGLSurfaceView_13++) {
            formatArr[OplusGLSurfaceView_13] = this.bindingTrackOutputs.valueAt(OplusGLSurfaceView_13).sampleFormat;
        }
        this.sampleFormats = formatArr;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        this.seekMap = seekMap;
    }

    private static final class BindingTrackOutput implements TrackOutput {
        private final DummyTrackOutput dummyTrackOutput = new DummyTrackOutput();
        private long endTimeUs;

        /* renamed from: id_renamed */
        private final int f9004id;
        private final Format manifestFormat;
        public Format sampleFormat;
        private TrackOutput trackOutput;
        private final int type;

        public BindingTrackOutput(int OplusGLSurfaceView_13, int i2, Format format) {
            this.f9004id = OplusGLSurfaceView_13;
            this.type = i2;
            this.manifestFormat = format;
        }

        public void bind(TrackOutputProvider trackOutputProvider, long OplusGLSurfaceView_15) {
            if (trackOutputProvider == null) {
                this.trackOutput = this.dummyTrackOutput;
                return;
            }
            this.endTimeUs = OplusGLSurfaceView_15;
            this.trackOutput = trackOutputProvider.track(this.f9004id, this.type);
            Format format = this.sampleFormat;
            if (format != null) {
                this.trackOutput.format(format);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(Format format) {
            Format format2 = this.manifestFormat;
            if (format2 != null) {
                format = format.copyWithManifestFormatInfo(format2);
            }
            this.sampleFormat = format;
            this.trackOutput.format(this.sampleFormat);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int sampleData(ExtractorInput extractorInput, int OplusGLSurfaceView_13, boolean z) throws InterruptedException, IOException {
            return this.trackOutput.sampleData(extractorInput, OplusGLSurfaceView_13, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13) {
            this.trackOutput.sampleData(parsableByteArray, OplusGLSurfaceView_13);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2, int i3, TrackOutput.CryptoData cryptoData) {
            long j2 = this.endTimeUs;
            if (j2 != -9223372036854775807L && OplusGLSurfaceView_15 >= j2) {
                this.trackOutput = this.dummyTrackOutput;
            }
            this.trackOutput.sampleMetadata(OplusGLSurfaceView_15, OplusGLSurfaceView_13, i2, i3, cryptoData);
        }
    }
}

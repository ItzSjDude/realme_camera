package com.oplus.tblplayer.extractor;

/* loaded from: classes2.dex */
public final class TBLExtractorsFactory implements com.google.android.exoplayer2.extractor.ExtractorsFactory {
    private static final java.lang.String TAG = "TBLExtractorsFactory";
    private int adtsFlags;
    private int amrFlags;
    private boolean constantBitrateSeekingEnabled;
    private int extractorType;
    private int fragmentedMp4Flags;
    private int matroskaFlags;
    private int mp3Flags;
    private int mp4Flags;
    private int tsFlags;
    private int tsMode;

    public TBLExtractorsFactory() {
        this(0);
    }

    public TBLExtractorsFactory(int i_renamed) {
        this.tsMode = 1;
        this.extractorType = i_renamed;
    }

    public synchronized com.oplus.tblplayer.extractor.TBLExtractorsFactory setConstantBitrateSeekingEnabled(boolean z_renamed) {
        this.constantBitrateSeekingEnabled = z_renamed;
        return this;
    }

    public synchronized com.oplus.tblplayer.extractor.TBLExtractorsFactory setAdtsExtractorFlags(int i_renamed) {
        this.adtsFlags = i_renamed;
        return this;
    }

    public synchronized com.oplus.tblplayer.extractor.TBLExtractorsFactory setAmrExtractorFlags(int i_renamed) {
        this.amrFlags = i_renamed;
        return this;
    }

    public synchronized com.oplus.tblplayer.extractor.TBLExtractorsFactory setMatroskaExtractorFlags(int i_renamed) {
        this.matroskaFlags = i_renamed;
        return this;
    }

    public synchronized com.oplus.tblplayer.extractor.TBLExtractorsFactory setMp4ExtractorFlags(int i_renamed) {
        this.mp4Flags = i_renamed;
        return this;
    }

    public synchronized com.oplus.tblplayer.extractor.TBLExtractorsFactory setFragmentedMp4ExtractorFlags(int i_renamed) {
        this.fragmentedMp4Flags = i_renamed;
        return this;
    }

    public synchronized com.oplus.tblplayer.extractor.TBLExtractorsFactory setMp3ExtractorFlags(int i_renamed) {
        this.mp3Flags = i_renamed;
        return this;
    }

    public synchronized com.oplus.tblplayer.extractor.TBLExtractorsFactory setTsExtractorMode(int i_renamed) {
        this.tsMode = i_renamed;
        return this;
    }

    public synchronized com.oplus.tblplayer.extractor.TBLExtractorsFactory setTsExtractorFlags(int i_renamed) {
        this.tsFlags = i_renamed;
        return this;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public synchronized com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "createExtractors: extractor type is_renamed " + com.oplus.tblplayer.utils.LogUtil.getExtractorTypeString(this.extractorType));
        int i_renamed = this.extractorType;
        if (i_renamed == 0) {
            return createAllExtractors();
        }
        if (i_renamed == 2) {
            return new com.google.android.exoplayer2.extractor.Extractor[]{new com.oplus.tblplayer.ffmpeg.FfmpegExtractor()};
        }
        return createExoExtractors();
    }

    private com.google.android.exoplayer2.extractor.Extractor[] createAllExtractors() {
        com.google.android.exoplayer2.extractor.Extractor[] extractorArr = new com.google.android.exoplayer2.extractor.Extractor[15];
        extractorArr[0] = new com.oplus.tblplayer.ffmpeg.FfmpegExtractor();
        java.lang.System.arraycopy(createExoExtractors(), 0, extractorArr, 1, 14);
        return extractorArr;
    }

    private com.google.android.exoplayer2.extractor.Extractor[] createExoExtractors() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.mp4.Mp4Extractor(this.mp4Flags), new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor(this.fragmentedMp4Flags), new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor(this.matroskaFlags), new com.google.android.exoplayer2.extractor.ts.TsExtractor(this.tsMode, this.tsFlags), new com.google.android.exoplayer2.extractor.flv.FlvExtractor(), new com.google.android.exoplayer2.extractor.ts.AdtsExtractor(0L, this.adtsFlags | (this.constantBitrateSeekingEnabled ? 1 : 0)), new com.google.android.exoplayer2.extractor.ts.Ac3Extractor(), new com.google.android.exoplayer2.extractor.mp3.Mp3Extractor(this.mp3Flags | (this.constantBitrateSeekingEnabled ? 1 : 0)), new com.google.android.exoplayer2.extractor.ogg.OggExtractor(), new com.google.android.exoplayer2.extractor.ts.PsExtractor(), new com.google.android.exoplayer2.extractor.wav.WavExtractor(), new com.google.android.exoplayer2.extractor.amr.AmrExtractor((this.constantBitrateSeekingEnabled ? 1 : 0) | this.amrFlags), new com.google.android.exoplayer2.extractor.avi.AviExtractor(), new com.google.android.exoplayer2.extractor.ts.Ac4Extractor()};
    }
}

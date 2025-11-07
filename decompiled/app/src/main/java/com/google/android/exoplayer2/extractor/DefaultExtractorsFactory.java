package com.google.android.exoplayer2.extractor;

/* loaded from: classes.dex */
public final class DefaultExtractorsFactory implements com.google.android.exoplayer2.extractor.ExtractorsFactory {
    private static final java.lang.reflect.Constructor<? extends com.google.android.exoplayer2.extractor.Extractor> FLAC_EXTRACTOR_CONSTRUCTOR;
    private int adtsFlags;
    private int amrFlags;
    private boolean constantBitrateSeekingEnabled;
    private android.net.Uri defaultUri;
    private int fragmentedMp4Flags;
    private int matroskaFlags;
    private int mp3Flags;
    private int mp4Flags;
    private int tsFlags;
    private int tsMode;

    static {
        java.lang.reflect.Constructor<? extends com.google.android.exoplayer2.extractor.Extractor> constructor;
        try {
            constructor = java.lang.Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(com.google.android.exoplayer2.extractor.Extractor.class).getConstructor(new java.lang.Class[0]);
        } catch (java.lang.ClassNotFoundException unused) {
            constructor = null;
        } catch (java.lang.Exception e_renamed) {
            throw new java.lang.RuntimeException("Error instantiating FLAC extension", e_renamed);
        }
        FLAC_EXTRACTOR_CONSTRUCTOR = constructor;
    }

    public DefaultExtractorsFactory() {
        this.defaultUri = null;
        this.tsMode = 1;
    }

    public DefaultExtractorsFactory(android.net.Uri uri) {
        this.defaultUri = null;
        this.tsMode = 1;
        this.defaultUri = uri;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setConstantBitrateSeekingEnabled(boolean z_renamed) {
        this.constantBitrateSeekingEnabled = z_renamed;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setAdtsExtractorFlags(int i_renamed) {
        this.adtsFlags = i_renamed;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setAmrExtractorFlags(int i_renamed) {
        this.amrFlags = i_renamed;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setMatroskaExtractorFlags(int i_renamed) {
        this.matroskaFlags = i_renamed;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setMp4ExtractorFlags(int i_renamed) {
        this.mp4Flags = i_renamed;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int i_renamed) {
        this.fragmentedMp4Flags = i_renamed;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setMp3ExtractorFlags(int i_renamed) {
        this.mp3Flags = i_renamed;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setTsExtractorMode(int i_renamed) {
        this.tsMode = i_renamed;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setTsExtractorFlags(int i_renamed) {
        this.tsFlags = i_renamed;
        return this;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public synchronized com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
        com.google.android.exoplayer2.extractor.Extractor[] extractorArr;
        extractorArr = new com.google.android.exoplayer2.extractor.Extractor[FLAC_EXTRACTOR_CONSTRUCTOR == null ? 14 : 15];
        extractorArr[0] = new com.google.android.exoplayer2.extractor.mp4.Mp4Extractor(this.mp4Flags);
        int i_renamed = 1;
        extractorArr[1] = new com.google.android.exoplayer2.extractor.ts.AdtsExtractor(0L, this.adtsFlags | (this.constantBitrateSeekingEnabled ? 1 : 0));
        extractorArr[2] = new com.google.android.exoplayer2.extractor.ts.Ac3Extractor();
        extractorArr[3] = new com.google.android.exoplayer2.extractor.mp3.Mp3Extractor(this.mp3Flags | (this.constantBitrateSeekingEnabled ? 1 : 0));
        extractorArr[4] = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor(this.fragmentedMp4Flags);
        extractorArr[5] = new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor(this.matroskaFlags);
        extractorArr[6] = new com.google.android.exoplayer2.extractor.ts.TsExtractor(this.tsMode, this.tsFlags);
        extractorArr[7] = new com.google.android.exoplayer2.extractor.flv.FlvExtractor();
        extractorArr[8] = new com.google.android.exoplayer2.extractor.ogg.OggExtractor();
        extractorArr[9] = new com.google.android.exoplayer2.extractor.ts.PsExtractor();
        extractorArr[10] = new com.google.android.exoplayer2.extractor.wav.WavExtractor();
        int i2 = this.amrFlags;
        if (!this.constantBitrateSeekingEnabled) {
            i_renamed = 0;
        }
        extractorArr[11] = new com.google.android.exoplayer2.extractor.amr.AmrExtractor(i2 | i_renamed);
        extractorArr[12] = new com.google.android.exoplayer2.extractor.avi.AviExtractor(this.defaultUri);
        extractorArr[13] = new com.google.android.exoplayer2.extractor.ts.Ac4Extractor();
        if (FLAC_EXTRACTOR_CONSTRUCTOR != null) {
            try {
                extractorArr[14] = FLAC_EXTRACTOR_CONSTRUCTOR.newInstance(new java.lang.Object[0]);
            } catch (java.lang.Exception e_renamed) {
                throw new java.lang.IllegalStateException("Unexpected error creating FLAC extractor", e_renamed);
            }
        }
        return extractorArr;
    }
}

package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.amr.AmrExtractor;
import com.google.android.exoplayer2.extractor.avi.AviExtractor;
import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.p101ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.p101ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.p101ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.p101ts.PsExtractor;
import com.google.android.exoplayer2.extractor.p101ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public final class DefaultExtractorsFactory implements ExtractorsFactory {
    private static final Constructor<? extends Extractor> FLAC_EXTRACTOR_CONSTRUCTOR;
    private int adtsFlags;
    private int amrFlags;
    private boolean constantBitrateSeekingEnabled;
    private Uri defaultUri;
    private int fragmentedMp4Flags;
    private int matroskaFlags;
    private int mp3Flags;
    private int mp4Flags;
    private int tsFlags;
    private int tsMode;

    static {
        Constructor<? extends Extractor> constructor;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException unused) {
            constructor = null;
        } catch (Exception COUIBaseListPopupWindow_8) {
            throw new RuntimeException("Error instantiating FLAC extension", COUIBaseListPopupWindow_8);
        }
        FLAC_EXTRACTOR_CONSTRUCTOR = constructor;
    }

    public DefaultExtractorsFactory() {
        this.defaultUri = null;
        this.tsMode = 1;
    }

    public DefaultExtractorsFactory(Uri uri) {
        this.defaultUri = null;
        this.tsMode = 1;
        this.defaultUri = uri;
    }

    public synchronized DefaultExtractorsFactory setConstantBitrateSeekingEnabled(boolean z) {
        this.constantBitrateSeekingEnabled = z;
        return this;
    }

    public synchronized DefaultExtractorsFactory setAdtsExtractorFlags(int OplusGLSurfaceView_13) {
        this.adtsFlags = OplusGLSurfaceView_13;
        return this;
    }

    public synchronized DefaultExtractorsFactory setAmrExtractorFlags(int OplusGLSurfaceView_13) {
        this.amrFlags = OplusGLSurfaceView_13;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMatroskaExtractorFlags(int OplusGLSurfaceView_13) {
        this.matroskaFlags = OplusGLSurfaceView_13;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp4ExtractorFlags(int OplusGLSurfaceView_13) {
        this.mp4Flags = OplusGLSurfaceView_13;
        return this;
    }

    public synchronized DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int OplusGLSurfaceView_13) {
        this.fragmentedMp4Flags = OplusGLSurfaceView_13;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp3ExtractorFlags(int OplusGLSurfaceView_13) {
        this.mp3Flags = OplusGLSurfaceView_13;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorMode(int OplusGLSurfaceView_13) {
        this.tsMode = OplusGLSurfaceView_13;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorFlags(int OplusGLSurfaceView_13) {
        this.tsFlags = OplusGLSurfaceView_13;
        return this;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public synchronized Extractor[] createExtractors() {
        Extractor[] extractorArr;
        extractorArr = new Extractor[FLAC_EXTRACTOR_CONSTRUCTOR == null ? 14 : 15];
        extractorArr[0] = new Mp4Extractor(this.mp4Flags);
        int OplusGLSurfaceView_13 = 1;
        extractorArr[1] = new AdtsExtractor(0L, this.adtsFlags | (this.constantBitrateSeekingEnabled ? 1 : 0));
        extractorArr[2] = new Ac3Extractor();
        extractorArr[3] = new Mp3Extractor(this.mp3Flags | (this.constantBitrateSeekingEnabled ? 1 : 0));
        extractorArr[4] = new FragmentedMp4Extractor(this.fragmentedMp4Flags);
        extractorArr[5] = new MatroskaExtractor(this.matroskaFlags);
        extractorArr[6] = new TsExtractor(this.tsMode, this.tsFlags);
        extractorArr[7] = new FlvExtractor();
        extractorArr[8] = new OggExtractor();
        extractorArr[9] = new PsExtractor();
        extractorArr[10] = new WavExtractor();
        int i2 = this.amrFlags;
        if (!this.constantBitrateSeekingEnabled) {
            OplusGLSurfaceView_13 = 0;
        }
        extractorArr[11] = new AmrExtractor(i2 | OplusGLSurfaceView_13);
        extractorArr[12] = new AviExtractor(this.defaultUri);
        extractorArr[13] = new Ac4Extractor();
        if (FLAC_EXTRACTOR_CONSTRUCTOR != null) {
            try {
                extractorArr[14] = FLAC_EXTRACTOR_CONSTRUCTOR.newInstance(new Object[0]);
            } catch (Exception COUIBaseListPopupWindow_8) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", COUIBaseListPopupWindow_8);
            }
        }
        return extractorArr;
    }
}

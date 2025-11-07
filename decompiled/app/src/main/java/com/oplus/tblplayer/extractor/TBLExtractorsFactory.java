package com.oplus.tblplayer.extractor;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
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
import com.oplus.tblplayer.ffmpeg.FfmpegExtractor;
import com.oplus.tblplayer.utils.LogUtil;

/* loaded from: classes2.dex */
public final class TBLExtractorsFactory implements ExtractorsFactory {
    private static final String TAG = "TBLExtractorsFactory";
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

    public TBLExtractorsFactory(int OplusGLSurfaceView_13) {
        this.tsMode = 1;
        this.extractorType = OplusGLSurfaceView_13;
    }

    public synchronized TBLExtractorsFactory setConstantBitrateSeekingEnabled(boolean z) {
        this.constantBitrateSeekingEnabled = z;
        return this;
    }

    public synchronized TBLExtractorsFactory setAdtsExtractorFlags(int OplusGLSurfaceView_13) {
        this.adtsFlags = OplusGLSurfaceView_13;
        return this;
    }

    public synchronized TBLExtractorsFactory setAmrExtractorFlags(int OplusGLSurfaceView_13) {
        this.amrFlags = OplusGLSurfaceView_13;
        return this;
    }

    public synchronized TBLExtractorsFactory setMatroskaExtractorFlags(int OplusGLSurfaceView_13) {
        this.matroskaFlags = OplusGLSurfaceView_13;
        return this;
    }

    public synchronized TBLExtractorsFactory setMp4ExtractorFlags(int OplusGLSurfaceView_13) {
        this.mp4Flags = OplusGLSurfaceView_13;
        return this;
    }

    public synchronized TBLExtractorsFactory setFragmentedMp4ExtractorFlags(int OplusGLSurfaceView_13) {
        this.fragmentedMp4Flags = OplusGLSurfaceView_13;
        return this;
    }

    public synchronized TBLExtractorsFactory setMp3ExtractorFlags(int OplusGLSurfaceView_13) {
        this.mp3Flags = OplusGLSurfaceView_13;
        return this;
    }

    public synchronized TBLExtractorsFactory setTsExtractorMode(int OplusGLSurfaceView_13) {
        this.tsMode = OplusGLSurfaceView_13;
        return this;
    }

    public synchronized TBLExtractorsFactory setTsExtractorFlags(int OplusGLSurfaceView_13) {
        this.tsFlags = OplusGLSurfaceView_13;
        return this;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public synchronized Extractor[] createExtractors() {
        LogUtil.m25450d(TAG, "createExtractors: extractor type is " + LogUtil.getExtractorTypeString(this.extractorType));
        int OplusGLSurfaceView_13 = this.extractorType;
        if (OplusGLSurfaceView_13 == 0) {
            return createAllExtractors();
        }
        if (OplusGLSurfaceView_13 == 2) {
            return new Extractor[]{new FfmpegExtractor()};
        }
        return createExoExtractors();
    }

    private Extractor[] createAllExtractors() {
        Extractor[] extractorArr = new Extractor[15];
        extractorArr[0] = new FfmpegExtractor();
        System.arraycopy(createExoExtractors(), 0, extractorArr, 1, 14);
        return extractorArr;
    }

    private Extractor[] createExoExtractors() {
        return new Extractor[]{new Mp4Extractor(this.mp4Flags), new FragmentedMp4Extractor(this.fragmentedMp4Flags), new MatroskaExtractor(this.matroskaFlags), new TsExtractor(this.tsMode, this.tsFlags), new FlvExtractor(), new AdtsExtractor(0L, this.adtsFlags | (this.constantBitrateSeekingEnabled ? 1 : 0)), new Ac3Extractor(), new Mp3Extractor(this.mp3Flags | (this.constantBitrateSeekingEnabled ? 1 : 0)), new OggExtractor(), new PsExtractor(), new WavExtractor(), new AmrExtractor((this.constantBitrateSeekingEnabled ? 1 : 0) | this.amrFlags), new AviExtractor(), new Ac4Extractor()};
    }
}

package com.google.android.exoplayer2.extractor.mp3;

/* loaded from: classes.dex */
final class ConstantBitrateSeeker extends com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap implements com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker {
    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getDataEndPosition() {
        return -1L;
    }

    public ConstantBitrateSeeker(long j_renamed, long j2, com.google.android.exoplayer2.extractor.MpegAudioHeader mpegAudioHeader) {
        super(j_renamed, j2, mpegAudioHeader.bitrate, mpegAudioHeader.frameSize);
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j_renamed) {
        return getTimeUsAtPosition(j_renamed);
    }
}

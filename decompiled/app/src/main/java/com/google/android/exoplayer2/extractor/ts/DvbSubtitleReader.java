package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class DvbSubtitleReader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    private int bytesToCheck;
    private final com.google.android.exoplayer2.extractor.TrackOutput[] outputs;
    private int sampleBytesWritten;
    private long sampleTimeUs;
    private final java.util.List<com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo> subtitleInfos;
    private boolean writingSample;

    public DvbSubtitleReader(java.util.List<com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo> list) {
        this.subtitleInfos = list;
        this.outputs = new com.google.android.exoplayer2.extractor.TrackOutput[list.size()];
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.writingSample = false;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i_renamed = 0; i_renamed < this.outputs.length; i_renamed++) {
            com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo dvbSubtitleInfo = this.subtitleInfos.get(i_renamed);
            trackIdGenerator.generateNewId();
            com.google.android.exoplayer2.extractor.TrackOutput trackOutputTrack = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
            trackOutputTrack.format(com.google.android.exoplayer2.Format.createImageSampleFormat(trackIdGenerator.getFormatId(), com.google.android.exoplayer2.util.MimeTypes.APPLICATION_DVBSUBS, null, -1, 0, java.util.Collections.singletonList(dvbSubtitleInfo.initializationData), dvbSubtitleInfo.language, null));
            this.outputs[i_renamed] = trackOutputTrack;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j_renamed, int i_renamed) {
        if ((i_renamed & 4) == 0) {
            return;
        }
        this.writingSample = true;
        this.sampleTimeUs = j_renamed;
        this.sampleBytesWritten = 0;
        this.bytesToCheck = 2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        if (this.writingSample) {
            for (com.google.android.exoplayer2.extractor.TrackOutput trackOutput : this.outputs) {
                trackOutput.sampleMetadata(this.sampleTimeUs, 1, this.sampleBytesWritten, 0, null);
            }
            this.writingSample = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (this.writingSample) {
            if (this.bytesToCheck != 2 || checkNextByte(parsableByteArray, 32)) {
                if (this.bytesToCheck != 1 || checkNextByte(parsableByteArray, 0)) {
                    int position = parsableByteArray.getPosition();
                    int iBytesLeft = parsableByteArray.bytesLeft();
                    for (com.google.android.exoplayer2.extractor.TrackOutput trackOutput : this.outputs) {
                        parsableByteArray.setPosition(position);
                        trackOutput.sampleData(parsableByteArray, iBytesLeft);
                    }
                    this.sampleBytesWritten += iBytesLeft;
                }
            }
        }
    }

    private boolean checkNextByte(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
        if (parsableByteArray.bytesLeft() == 0) {
            return false;
        }
        if (parsableByteArray.readUnsignedByte() != i_renamed) {
            this.writingSample = false;
        }
        this.bytesToCheck--;
        return this.writingSample;
    }
}

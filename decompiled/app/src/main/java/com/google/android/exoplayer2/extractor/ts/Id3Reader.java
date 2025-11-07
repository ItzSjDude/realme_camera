package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class Id3Reader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    private static final int ID3_HEADER_SIZE = 10;
    private static final java.lang.String TAG = "Id3Reader";
    private final com.google.android.exoplayer2.util.ParsableByteArray id3Header = new com.google.android.exoplayer2.util.ParsableByteArray(10);
    private com.google.android.exoplayer2.extractor.TrackOutput output;
    private int sampleBytesRead;
    private int sampleSize;
    private long sampleTimeUs;
    private boolean writingSample;

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.writingSample = false;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 4);
        this.output.format(com.google.android.exoplayer2.Format.createSampleFormat(trackIdGenerator.getFormatId(), com.google.android.exoplayer2.util.MimeTypes.APPLICATION_ID3, null, -1, null));
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j_renamed, int i_renamed) {
        if ((i_renamed & 4) == 0) {
            return;
        }
        this.writingSample = true;
        this.sampleTimeUs = j_renamed;
        this.sampleSize = 0;
        this.sampleBytesRead = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (this.writingSample) {
            int iBytesLeft = parsableByteArray.bytesLeft();
            int i_renamed = this.sampleBytesRead;
            if (i_renamed < 10) {
                int iMin = java.lang.Math.min(iBytesLeft, 10 - i_renamed);
                java.lang.System.arraycopy(parsableByteArray.data, parsableByteArray.getPosition(), this.id3Header.data, this.sampleBytesRead, iMin);
                if (this.sampleBytesRead + iMin == 10) {
                    this.id3Header.setPosition(0);
                    if (73 != this.id3Header.readUnsignedByte() || 68 != this.id3Header.readUnsignedByte() || 51 != this.id3Header.readUnsignedByte()) {
                        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Discarding invalid ID3 tag");
                        this.writingSample = false;
                        return;
                    } else {
                        this.id3Header.skipBytes(3);
                        this.sampleSize = this.id3Header.readSynchSafeInt() + 10;
                    }
                }
            }
            int iMin2 = java.lang.Math.min(iBytesLeft, this.sampleSize - this.sampleBytesRead);
            this.output.sampleData(parsableByteArray, iMin2);
            this.sampleBytesRead += iMin2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        int i_renamed;
        if (this.writingSample && (i_renamed = this.sampleSize) != 0 && this.sampleBytesRead == i_renamed) {
            this.output.sampleMetadata(this.sampleTimeUs, 1, i_renamed, 0, null);
            this.writingSample = false;
        }
    }
}

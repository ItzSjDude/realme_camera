package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class SpliceInfoSectionReader implements com.google.android.exoplayer2.extractor.ts.SectionPayloadReader {
    private boolean formatDeclared;
    private com.google.android.exoplayer2.extractor.TrackOutput output;
    private com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster;

    @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
    public void init(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.timestampAdjuster = timestampAdjuster;
        trackIdGenerator.generateNewId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 4);
        this.output.format(com.google.android.exoplayer2.Format.createSampleFormat(trackIdGenerator.getFormatId(), com.google.android.exoplayer2.util.MimeTypes.APPLICATION_SCTE35, null, -1, null));
    }

    @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (!this.formatDeclared) {
            if (this.timestampAdjuster.getTimestampOffsetUs() == -9223372036854775807L) {
                return;
            }
            this.output.format(com.google.android.exoplayer2.Format.createSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.APPLICATION_SCTE35, this.timestampAdjuster.getTimestampOffsetUs()));
            this.formatDeclared = true;
        }
        int iBytesLeft = parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray, iBytesLeft);
        this.output.sampleMetadata(this.timestampAdjuster.getLastAdjustedTimestampUs(), 1, iBytesLeft, 0, null);
    }
}

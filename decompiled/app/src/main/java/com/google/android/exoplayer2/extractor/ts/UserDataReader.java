package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
final class UserDataReader {
    private static final int USER_DATA_START_CODE = 434;
    private final java.util.List<com.google.android.exoplayer2.Format> closedCaptionFormats;
    private final com.google.android.exoplayer2.extractor.TrackOutput[] outputs;

    public UserDataReader(java.util.List<com.google.android.exoplayer2.Format> list) {
        this.closedCaptionFormats = list;
        this.outputs = new com.google.android.exoplayer2.extractor.TrackOutput[list.size()];
    }

    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i_renamed = 0; i_renamed < this.outputs.length; i_renamed++) {
            trackIdGenerator.generateNewId();
            com.google.android.exoplayer2.extractor.TrackOutput trackOutputTrack = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
            com.google.android.exoplayer2.Format format = this.closedCaptionFormats.get(i_renamed);
            java.lang.String str = format.sampleMimeType;
            com.google.android.exoplayer2.util.Assertions.checkArgument(com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA608.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption mime type provided: " + str);
            trackOutputTrack.format(com.google.android.exoplayer2.Format.createTextSampleFormat(trackIdGenerator.getFormatId(), str, null, -1, format.selectionFlags, format.language, format.accessibilityChannel, null, Long.MAX_VALUE, format.initializationData));
            this.outputs[i_renamed] = trackOutputTrack;
        }
    }

    public void consume(long j_renamed, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() < 9) {
            return;
        }
        int i_renamed = parsableByteArray.readInt();
        int i2 = parsableByteArray.readInt();
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if (i_renamed == USER_DATA_START_CODE && i2 == com.google.android.exoplayer2.text.cea.CeaUtil.USER_DATA_IDENTIFIER_GA94 && unsignedByte == 3) {
            com.google.android.exoplayer2.text.cea.CeaUtil.consumeCcData(j_renamed, parsableByteArray, this.outputs);
        }
    }
}

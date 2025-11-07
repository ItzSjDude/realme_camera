package com.google.android.exoplayer2.source.hls;

/* loaded from: classes.dex */
public final class WebvttExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    private static final int HEADER_MAX_LENGTH = 9;
    private static final int HEADER_MIN_LENGTH = 6;
    private static final java.util.regex.Pattern LOCAL_TIMESTAMP = java.util.regex.Pattern.compile("LOCAL:([^,]+)");
    private static final java.util.regex.Pattern MEDIA_TIMESTAMP = java.util.regex.Pattern.compile("MPEGTS:(\\d_renamed+)");
    private final java.lang.String language;
    private com.google.android.exoplayer2.extractor.ExtractorOutput output;
    private int sampleSize;
    private final com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster;
    private final com.google.android.exoplayer2.util.ParsableByteArray sampleDataWrapper = new com.google.android.exoplayer2.util.ParsableByteArray();
    private byte[] sampleData = new byte[1024];

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    public WebvttExtractor(java.lang.String str, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
        this.language = str;
        this.timestampAdjuster = timestampAdjuster;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        extractorInput.peekFully(this.sampleData, 0, 6, false);
        this.sampleDataWrapper.reset(this.sampleData, 6);
        if (com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.isWebvttHeaderLine(this.sampleDataWrapper)) {
            return true;
        }
        extractorInput.peekFully(this.sampleData, 6, 3, false);
        this.sampleDataWrapper.reset(this.sampleData, 9);
        return com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.isWebvttHeaderLine(this.sampleDataWrapper);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
        extractorOutput.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException, java.lang.NumberFormatException {
        int length = (int) extractorInput.getLength();
        int i_renamed = this.sampleSize;
        byte[] bArr = this.sampleData;
        if (i_renamed == bArr.length) {
            this.sampleData = java.util.Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.sampleData;
        int i2 = this.sampleSize;
        int i3 = extractorInput.read(bArr2, i2, bArr2.length - i2);
        if (i3 != -1) {
            this.sampleSize += i3;
            if (length == -1 || this.sampleSize != length) {
                return 0;
            }
        }
        processSample();
        return -1;
    }

    private void processSample() throws com.google.android.exoplayer2.ParserException, java.lang.NumberFormatException {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(this.sampleData);
        com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.validateWebvttHeaderLine(parsableByteArray);
        long jPtsToUs = 0;
        long timestampUs = 0;
        while (true) {
            java.lang.String line = parsableByteArray.readLine();
            if (!android.text.TextUtils.isEmpty(line)) {
                if (line.startsWith("X_renamed-TIMESTAMP-MAP")) {
                    java.util.regex.Matcher matcher = LOCAL_TIMESTAMP.matcher(line);
                    if (!matcher.find()) {
                        throw new com.google.android.exoplayer2.ParserException("X_renamed-TIMESTAMP-MAP doesn't_renamed contain local timestamp: " + line);
                    }
                    java.util.regex.Matcher matcher2 = MEDIA_TIMESTAMP.matcher(line);
                    if (!matcher2.find()) {
                        throw new com.google.android.exoplayer2.ParserException("X_renamed-TIMESTAMP-MAP doesn't_renamed contain media timestamp: " + line);
                    }
                    timestampUs = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.parseTimestampUs(matcher.group(1));
                    jPtsToUs = com.google.android.exoplayer2.util.TimestampAdjuster.ptsToUs(java.lang.Long.parseLong(matcher2.group(1)));
                }
            } else {
                java.util.regex.Matcher matcherFindNextCueHeader = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.findNextCueHeader(parsableByteArray);
                if (matcherFindNextCueHeader == null) {
                    buildTrackOutput(0L);
                    return;
                }
                long timestampUs2 = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.parseTimestampUs(matcherFindNextCueHeader.group(1));
                long jAdjustTsTimestamp = this.timestampAdjuster.adjustTsTimestamp(com.google.android.exoplayer2.util.TimestampAdjuster.usToPts((jPtsToUs + timestampUs2) - timestampUs));
                com.google.android.exoplayer2.extractor.TrackOutput trackOutputBuildTrackOutput = buildTrackOutput(jAdjustTsTimestamp - timestampUs2);
                this.sampleDataWrapper.reset(this.sampleData, this.sampleSize);
                trackOutputBuildTrackOutput.sampleData(this.sampleDataWrapper, this.sampleSize);
                trackOutputBuildTrackOutput.sampleMetadata(jAdjustTsTimestamp, 1, this.sampleSize, 0, null);
                return;
            }
        }
    }

    private com.google.android.exoplayer2.extractor.TrackOutput buildTrackOutput(long j_renamed) {
        com.google.android.exoplayer2.extractor.TrackOutput trackOutputTrack = this.output.track(0, 3);
        trackOutputTrack.format(com.google.android.exoplayer2.Format.createTextSampleFormat((java.lang.String) null, com.google.android.exoplayer2.util.MimeTypes.TEXT_VTT, (java.lang.String) null, -1, 0, this.language, (com.google.android.exoplayer2.drm.DrmInitData) null, j_renamed));
        this.output.endTracks();
        return trackOutputTrack;
    }
}

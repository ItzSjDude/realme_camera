package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes.dex */
final class FlacReader extends com.google.android.exoplayer2.extractor.ogg.StreamReader {
    private static final byte AUDIO_PACKET_TYPE = -1;
    private static final int FRAME_HEADER_SAMPLE_NUMBER_OFFSET = 4;
    private static final byte SEEKTABLE_PACKET_TYPE = 3;
    private com.google.android.exoplayer2.extractor.ogg.FlacReader.FlacOggSeeker flacOggSeeker;
    private com.google.android.exoplayer2.util.FlacStreamInfo streamInfo;

    FlacReader() {
    }

    public static boolean verifyBitstreamType(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        return parsableByteArray.bytesLeft() >= 5 && parsableByteArray.readUnsignedByte() == 127 && parsableByteArray.readUnsignedInt() == 1179402563;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected void reset(boolean z_renamed) {
        super.reset(z_renamed);
        if (z_renamed) {
            this.streamInfo = null;
            this.flacOggSeeker = null;
        }
    }

    private static boolean isAudioPacket(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected long preparePayload(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (isAudioPacket(parsableByteArray.data)) {
            return getFlacFrameBlockSize(parsableByteArray);
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected boolean readHeaders(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed, com.google.android.exoplayer2.extractor.ogg.StreamReader.SetupData setupData) throws java.lang.InterruptedException, java.io.IOException {
        byte[] bArr = parsableByteArray.data;
        if (this.streamInfo == null) {
            this.streamInfo = new com.google.android.exoplayer2.util.FlacStreamInfo(bArr, 17);
            byte[] bArrCopyOfRange = java.util.Arrays.copyOfRange(bArr, 9, parsableByteArray.limit());
            bArrCopyOfRange[4] = -128;
            setupData.format = com.google.android.exoplayer2.Format.createAudioSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.AUDIO_FLAC, null, -1, this.streamInfo.bitRate(), this.streamInfo.channels, this.streamInfo.sampleRate, java.util.Collections.singletonList(bArrCopyOfRange), null, 0, null);
            return true;
        }
        if ((bArr[0] & 127) == 3) {
            this.flacOggSeeker = new com.google.android.exoplayer2.extractor.ogg.FlacReader.FlacOggSeeker();
            this.flacOggSeeker.parseSeekTable(parsableByteArray);
            return true;
        }
        if (!isAudioPacket(bArr)) {
            return true;
        }
        com.google.android.exoplayer2.extractor.ogg.FlacReader.FlacOggSeeker flacOggSeeker = this.flacOggSeeker;
        if (flacOggSeeker != null) {
            flacOggSeeker.setFirstFrameOffset(j_renamed);
            setupData.oggSeeker = this.flacOggSeeker;
        }
        return false;
    }

    private int getFlacFrameBlockSize(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int i_renamed = (parsableByteArray.data[2] & 255) >> 4;
        switch (i_renamed) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i_renamed - 2);
            case 6:
            case 7:
                parsableByteArray.skipBytes(4);
                parsableByteArray.readUtf8EncodedLong();
                int unsignedByte = i_renamed == 6 ? parsableByteArray.readUnsignedByte() : parsableByteArray.readUnsignedShort();
                parsableByteArray.setPosition(0);
                return unsignedByte + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i_renamed - 8);
            default:
                return -1;
        }
    }

    private class FlacOggSeeker implements com.google.android.exoplayer2.extractor.SeekMap, com.google.android.exoplayer2.extractor.ogg.OggSeeker {
        private static final int METADATA_LENGTH_OFFSET = 1;
        private static final int SEEK_POINT_SIZE = 18;
        private long firstFrameOffset = -1;
        private long pendingSeekGranule = -1;
        private long[] seekPointGranules;
        private long[] seekPointOffsets;

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public com.google.android.exoplayer2.extractor.SeekMap createSeekMap() {
            return this;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }

        public FlacOggSeeker() {
        }

        public void setFirstFrameOffset(long j_renamed) {
            this.firstFrameOffset = j_renamed;
        }

        public void parseSeekTable(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
            parsableByteArray.skipBytes(1);
            int unsignedInt24 = parsableByteArray.readUnsignedInt24() / 18;
            this.seekPointGranules = new long[unsignedInt24];
            this.seekPointOffsets = new long[unsignedInt24];
            for (int i_renamed = 0; i_renamed < unsignedInt24; i_renamed++) {
                this.seekPointGranules[i_renamed] = parsableByteArray.readLong();
                this.seekPointOffsets[i_renamed] = parsableByteArray.readLong();
                parsableByteArray.skipBytes(2);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
            long j_renamed = this.pendingSeekGranule;
            if (j_renamed < 0) {
                return -1L;
            }
            long j2 = -(j_renamed + 2);
            this.pendingSeekGranule = -1L;
            return j2;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long startSeek(long j_renamed) {
            long jConvertTimeToGranule = com.google.android.exoplayer2.extractor.ogg.FlacReader.this.convertTimeToGranule(j_renamed);
            this.pendingSeekGranule = this.seekPointGranules[com.google.android.exoplayer2.util.Util.binarySearchFloor(this.seekPointGranules, jConvertTimeToGranule, true, true)];
            return jConvertTimeToGranule;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j_renamed) {
            int iBinarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor(this.seekPointGranules, com.google.android.exoplayer2.extractor.ogg.FlacReader.this.convertTimeToGranule(j_renamed), true, true);
            long jConvertGranuleToTime = com.google.android.exoplayer2.extractor.ogg.FlacReader.this.convertGranuleToTime(this.seekPointGranules[iBinarySearchFloor]);
            com.google.android.exoplayer2.extractor.SeekPoint seekPoint = new com.google.android.exoplayer2.extractor.SeekPoint(jConvertGranuleToTime, this.firstFrameOffset + this.seekPointOffsets[iBinarySearchFloor]);
            if (jConvertGranuleToTime < j_renamed) {
                long[] jArr = this.seekPointGranules;
                if (iBinarySearchFloor != jArr.length - 1) {
                    int i_renamed = iBinarySearchFloor + 1;
                    return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint, new com.google.android.exoplayer2.extractor.SeekPoint(com.google.android.exoplayer2.extractor.ogg.FlacReader.this.convertGranuleToTime(jArr[i_renamed]), this.firstFrameOffset + this.seekPointOffsets[i_renamed]));
                }
            }
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint);
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return com.google.android.exoplayer2.extractor.ogg.FlacReader.this.streamInfo.durationUs();
        }
    }
}

package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes.dex */
final class OpusReader extends com.google.android.exoplayer2.extractor.ogg.StreamReader {
    private static final int DEFAULT_SEEK_PRE_ROLL_SAMPLES = 3840;
    private static final int OPUS_CODE = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("Opus");
    private static final byte[] OPUS_SIGNATURE = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final int SAMPLE_RATE = 48000;
    private boolean headerRead;

    OpusReader() {
    }

    public static boolean verifyBitstreamType(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int iBytesLeft = parsableByteArray.bytesLeft();
        byte[] bArr = OPUS_SIGNATURE;
        if (iBytesLeft < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.readBytes(bArr2, 0, bArr.length);
        return java.util.Arrays.equals(bArr2, OPUS_SIGNATURE);
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected void reset(boolean z_renamed) {
        super.reset(z_renamed);
        if (z_renamed) {
            this.headerRead = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected long preparePayload(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        return convertTimeToGranule(getPacketDurationUs(parsableByteArray.data));
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected boolean readHeaders(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed, com.google.android.exoplayer2.extractor.ogg.StreamReader.SetupData setupData) {
        if (!this.headerRead) {
            byte[] bArrCopyOf = java.util.Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit());
            int i_renamed = bArrCopyOf[9] & 255;
            int i2 = ((bArrCopyOf[11] & 255) << 8) | (bArrCopyOf[10] & 255);
            java.util.ArrayList arrayList = new java.util.ArrayList(3);
            arrayList.add(bArrCopyOf);
            putNativeOrderLong(arrayList, i2);
            putNativeOrderLong(arrayList, 3840);
            setupData.format = com.google.android.exoplayer2.Format.createAudioSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.AUDIO_OPUS, null, -1, -1, i_renamed, SAMPLE_RATE, arrayList, null, 0, null);
            this.headerRead = true;
            return true;
        }
        boolean z_renamed = parsableByteArray.readInt() == OPUS_CODE;
        parsableByteArray.setPosition(0);
        return z_renamed;
    }

    private void putNativeOrderLong(java.util.List<byte[]> list, int i_renamed) {
        list.add(java.nio.ByteBuffer.allocate(8).order(java.nio.ByteOrder.nativeOrder()).putLong((i_renamed * com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND) / 48000).array());
    }

    private long getPacketDurationUs(byte[] bArr) {
        int i_renamed = bArr[0] & 255;
        int i2 = i_renamed & 3;
        int i3 = 2;
        if (i2 == 0) {
            i3 = 1;
        } else if (i2 != 1 && i2 != 2) {
            i3 = bArr[1] & 63;
        }
        int i4 = i_renamed >> 3;
        return i3 * (i4 >= 16 ? 2500 << r0 : i4 >= 12 ? 10000 << (r0 & 1) : (i4 & 3) == 3 ? 60000 : 10000 << r0);
    }
}

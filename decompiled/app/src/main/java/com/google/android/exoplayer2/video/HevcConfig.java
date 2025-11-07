package com.google.android.exoplayer2.video;

/* loaded from: classes.dex */
public final class HevcConfig {
    public final java.util.List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;

    public static com.google.android.exoplayer2.video.HevcConfig parse(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
        try {
            parsableByteArray.skipBytes(21);
            int unsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int unsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i_renamed = 0;
            int i2 = 0;
            while (i_renamed < unsignedByte2) {
                parsableByteArray.skipBytes(1);
                int unsignedShort = parsableByteArray.readUnsignedShort();
                int i3 = i2;
                for (int i4 = 0; i4 < unsignedShort; i4++) {
                    int unsignedShort2 = parsableByteArray.readUnsignedShort();
                    i3 += unsignedShort2 + 4;
                    parsableByteArray.skipBytes(unsignedShort2);
                }
                i_renamed++;
                i2 = i3;
            }
            parsableByteArray.setPosition(position);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < unsignedByte2) {
                parsableByteArray.skipBytes(1);
                int unsignedShort3 = parsableByteArray.readUnsignedShort();
                int i7 = i6;
                for (int i8 = 0; i8 < unsignedShort3; i8++) {
                    int unsignedShort4 = parsableByteArray.readUnsignedShort();
                    java.lang.System.arraycopy(com.google.android.exoplayer2.util.NalUnitUtil.NAL_START_CODE, 0, bArr, i7, com.google.android.exoplayer2.util.NalUnitUtil.NAL_START_CODE.length);
                    int length = i7 + com.google.android.exoplayer2.util.NalUnitUtil.NAL_START_CODE.length;
                    java.lang.System.arraycopy(parsableByteArray.data, parsableByteArray.getPosition(), bArr, length, unsignedShort4);
                    i7 = length + unsignedShort4;
                    parsableByteArray.skipBytes(unsignedShort4);
                }
                i5++;
                i6 = i7;
            }
            return new com.google.android.exoplayer2.video.HevcConfig(i2 == 0 ? null : java.util.Collections.singletonList(bArr), unsignedByte + 1);
        } catch (java.lang.ArrayIndexOutOfBoundsException e_renamed) {
            throw new com.google.android.exoplayer2.ParserException("Error parsing HEVC config", e_renamed);
        }
    }

    private HevcConfig(java.util.List<byte[]> list, int i_renamed) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i_renamed;
    }
}

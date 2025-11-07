package com.google.android.exoplayer2.video;

/* loaded from: classes.dex */
public final class AvcConfig {
    public final int height;
    public final java.util.List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthAspectRatio;
    public final int width;

    public static com.google.android.exoplayer2.video.AvcConfig parse(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
        float f_renamed;
        int i_renamed;
        int i2;
        try {
            parsableByteArray.skipBytes(4);
            int unsignedByte = (parsableByteArray.readUnsignedByte() & 3) + 1;
            if (unsignedByte == 3) {
                throw new java.lang.IllegalStateException();
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int unsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
            for (int i3 = 0; i3 < unsignedByte2; i3++) {
                arrayList.add(buildNalUnitForChild(parsableByteArray));
            }
            int unsignedByte3 = parsableByteArray.readUnsignedByte();
            for (int i4 = 0; i4 < unsignedByte3; i4++) {
                arrayList.add(buildNalUnitForChild(parsableByteArray));
            }
            if (unsignedByte2 > 0) {
                com.google.android.exoplayer2.util.NalUnitUtil.SpsData spsNalUnit = com.google.android.exoplayer2.util.NalUnitUtil.parseSpsNalUnit((byte[]) arrayList.get(0), unsignedByte, ((byte[]) arrayList.get(0)).length);
                int i5 = spsNalUnit.width;
                int i6 = spsNalUnit.height;
                f_renamed = spsNalUnit.pixelWidthAspectRatio;
                i_renamed = i5;
                i2 = i6;
            } else {
                f_renamed = 1.0f;
                i_renamed = -1;
                i2 = -1;
            }
            return new com.google.android.exoplayer2.video.AvcConfig(arrayList, unsignedByte, i_renamed, i2, f_renamed);
        } catch (java.lang.ArrayIndexOutOfBoundsException e_renamed) {
            throw new com.google.android.exoplayer2.ParserException("Error parsing AVC config", e_renamed);
        }
    }

    private AvcConfig(java.util.List<byte[]> list, int i_renamed, int i2, int i3, float f_renamed) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i_renamed;
        this.width = i2;
        this.height = i3;
        this.pixelWidthAspectRatio = f_renamed;
    }

    private static byte[] buildNalUnitForChild(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(unsignedShort);
        return com.google.android.exoplayer2.util.CodecSpecificDataUtil.buildNalUnit(parsableByteArray.data, position, unsignedShort);
    }
}

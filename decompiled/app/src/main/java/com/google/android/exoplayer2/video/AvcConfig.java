package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AvcConfig {
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthAspectRatio;
    public final int width;

    public static AvcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        float COUIBaseListPopupWindow_12;
        int OplusGLSurfaceView_13;
        int i2;
        try {
            parsableByteArray.skipBytes(4);
            int unsignedByte = (parsableByteArray.readUnsignedByte() & 3) + 1;
            if (unsignedByte == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int unsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
            for (int i3 = 0; i3 < unsignedByte2; i3++) {
                arrayList.add(buildNalUnitForChild(parsableByteArray));
            }
            int unsignedByte3 = parsableByteArray.readUnsignedByte();
            for (int i4 = 0; i4 < unsignedByte3; i4++) {
                arrayList.add(buildNalUnitForChild(parsableByteArray));
            }
            if (unsignedByte2 > 0) {
                NalUnitUtil.SpsData spsNalUnit = NalUnitUtil.parseSpsNalUnit((byte[]) arrayList.get(0), unsignedByte, ((byte[]) arrayList.get(0)).length);
                int i5 = spsNalUnit.width;
                int i6 = spsNalUnit.height;
                COUIBaseListPopupWindow_12 = spsNalUnit.pixelWidthAspectRatio;
                OplusGLSurfaceView_13 = i5;
                i2 = i6;
            } else {
                COUIBaseListPopupWindow_12 = 1.0f;
                OplusGLSurfaceView_13 = -1;
                i2 = -1;
            }
            return new AvcConfig(arrayList, unsignedByte, OplusGLSurfaceView_13, i2, COUIBaseListPopupWindow_12);
        } catch (ArrayIndexOutOfBoundsException COUIBaseListPopupWindow_8) {
            throw new ParserException("Error parsing AVC config", COUIBaseListPopupWindow_8);
        }
    }

    private AvcConfig(List<byte[]> list, int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = OplusGLSurfaceView_13;
        this.width = i2;
        this.height = i3;
        this.pixelWidthAspectRatio = COUIBaseListPopupWindow_12;
    }

    private static byte[] buildNalUnitForChild(ParsableByteArray parsableByteArray) {
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(unsignedShort);
        return CodecSpecificDataUtil.buildNalUnit(parsableByteArray.data, position, unsignedShort);
    }
}

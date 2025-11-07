package com.google.android.exoplayer2.text.cea;

/* loaded from: classes.dex */
public final class CeaUtil {
    private static final int COUNTRY_CODE = 181;
    private static final int PAYLOAD_TYPE_CC = 4;
    private static final int PROVIDER_CODE_ATSC = 49;
    private static final int PROVIDER_CODE_DIRECTV = 47;
    private static final java.lang.String TAG = "CeaUtil";
    public static final int USER_DATA_IDENTIFIER_GA94 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("GA94");
    public static final int USER_DATA_TYPE_CODE_MPEG_CC = 3;

    public static void consume(long j_renamed, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.TrackOutput[] trackOutputArr) {
        while (true) {
            if (parsableByteArray.bytesLeft() <= 1) {
                return;
            }
            int non255TerminatedValue = readNon255TerminatedValue(parsableByteArray);
            int non255TerminatedValue2 = readNon255TerminatedValue(parsableByteArray);
            int position = parsableByteArray.getPosition() + non255TerminatedValue2;
            if (non255TerminatedValue2 == -1 || non255TerminatedValue2 > parsableByteArray.bytesLeft()) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Skipping remainder of_renamed malformed SEI NAL unit.");
                position = parsableByteArray.limit();
            } else if (non255TerminatedValue == 4 && non255TerminatedValue2 >= 8) {
                int unsignedByte = parsableByteArray.readUnsignedByte();
                int unsignedShort = parsableByteArray.readUnsignedShort();
                int i_renamed = unsignedShort == 49 ? parsableByteArray.readInt() : 0;
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                if (unsignedShort == 47) {
                    parsableByteArray.skipBytes(1);
                }
                boolean z_renamed = unsignedByte == 181 && (unsignedShort == 49 || unsignedShort == 47) && unsignedByte2 == 3;
                if (unsignedShort == 49) {
                    z_renamed &= i_renamed == USER_DATA_IDENTIFIER_GA94;
                }
                if (z_renamed) {
                    consumeCcData(j_renamed, parsableByteArray, trackOutputArr);
                }
            }
            parsableByteArray.setPosition(position);
        }
    }

    public static void consumeCcData(long j_renamed, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.TrackOutput[] trackOutputArr) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if ((unsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(1);
            int i_renamed = (unsignedByte & 31) * 3;
            int position = parsableByteArray.getPosition();
            for (com.google.android.exoplayer2.extractor.TrackOutput trackOutput : trackOutputArr) {
                parsableByteArray.setPosition(position);
                trackOutput.sampleData(parsableByteArray, i_renamed);
                trackOutput.sampleMetadata(j_renamed, 1, i_renamed, 0, null);
            }
        }
    }

    private static int readNon255TerminatedValue(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int i_renamed = 0;
        while (parsableByteArray.bytesLeft() != 0) {
            int unsignedByte = parsableByteArray.readUnsignedByte();
            i_renamed += unsignedByte;
            if (unsignedByte != 255) {
                return i_renamed;
            }
        }
        return -1;
    }

    private CeaUtil() {
    }
}

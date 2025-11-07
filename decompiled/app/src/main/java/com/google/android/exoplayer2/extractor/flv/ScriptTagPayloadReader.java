package com.google.android.exoplayer2.extractor.flv;

/* loaded from: classes.dex */
final class ScriptTagPayloadReader extends com.google.android.exoplayer2.extractor.flv.TagPayloadReader {
    private static final int AMF_TYPE_BOOLEAN = 1;
    private static final int AMF_TYPE_DATE = 11;
    private static final int AMF_TYPE_ECMA_ARRAY = 8;
    private static final int AMF_TYPE_END_MARKER = 9;
    private static final int AMF_TYPE_NUMBER = 0;
    private static final int AMF_TYPE_OBJECT = 3;
    private static final int AMF_TYPE_STRICT_ARRAY = 10;
    private static final int AMF_TYPE_STRING = 2;
    private static final java.lang.String KEY_DURATION = "duration";
    private static final java.lang.String NAME_METADATA = "onMetaData";
    private long durationUs;

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean parseHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void seek() {
    }

    public ScriptTagPayloadReader() {
        super(null);
        this.durationUs = -9223372036854775807L;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected void parsePayload(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed) throws com.google.android.exoplayer2.ParserException {
        if (readAmfType(parsableByteArray) != 2) {
            throw new com.google.android.exoplayer2.ParserException();
        }
        if (NAME_METADATA.equals(readAmfString(parsableByteArray)) && readAmfType(parsableByteArray) == 8) {
            java.util.HashMap<java.lang.String, java.lang.Object> amfEcmaArray = readAmfEcmaArray(parsableByteArray);
            if (amfEcmaArray.containsKey("duration")) {
                double dDoubleValue = ((java.lang.Double) amfEcmaArray.get("duration")).doubleValue();
                if (dDoubleValue > 0.0d) {
                    this.durationUs = (long) (dDoubleValue * 1000000.0d);
                }
            }
        }
    }

    private static int readAmfType(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        return parsableByteArray.readUnsignedByte();
    }

    private static java.lang.Boolean readAmfBoolean(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        return java.lang.Boolean.valueOf(parsableByteArray.readUnsignedByte() == 1);
    }

    private static java.lang.Double readAmfDouble(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        return java.lang.Double.valueOf(java.lang.Double.longBitsToDouble(parsableByteArray.readLong()));
    }

    private static java.lang.String readAmfString(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(unsignedShort);
        return new java.lang.String(parsableByteArray.data, position, unsignedShort);
    }

    private static java.util.ArrayList<java.lang.Object> readAmfStrictArray(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        java.util.ArrayList<java.lang.Object> arrayList = new java.util.ArrayList<>(unsignedIntToInt);
        for (int i_renamed = 0; i_renamed < unsignedIntToInt; i_renamed++) {
            arrayList.add(readAmfData(parsableByteArray, readAmfType(parsableByteArray)));
        }
        return arrayList;
    }

    private static java.util.HashMap<java.lang.String, java.lang.Object> readAmfObject(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        java.util.HashMap<java.lang.String, java.lang.Object> map = new java.util.HashMap<>();
        while (true) {
            java.lang.String amfString = readAmfString(parsableByteArray);
            int amfType = readAmfType(parsableByteArray);
            if (amfType == 9) {
                return map;
            }
            map.put(amfString, readAmfData(parsableByteArray, amfType));
        }
    }

    private static java.util.HashMap<java.lang.String, java.lang.Object> readAmfEcmaArray(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        java.util.HashMap<java.lang.String, java.lang.Object> map = new java.util.HashMap<>(unsignedIntToInt);
        for (int i_renamed = 0; i_renamed < unsignedIntToInt; i_renamed++) {
            map.put(readAmfString(parsableByteArray), readAmfData(parsableByteArray, readAmfType(parsableByteArray)));
        }
        return map;
    }

    private static java.util.Date readAmfDate(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        java.util.Date date = new java.util.Date((long) readAmfDouble(parsableByteArray).doubleValue());
        parsableByteArray.skipBytes(2);
        return date;
    }

    private static java.lang.Object readAmfData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
        if (i_renamed == 0) {
            return readAmfDouble(parsableByteArray);
        }
        if (i_renamed == 1) {
            return readAmfBoolean(parsableByteArray);
        }
        if (i_renamed == 2) {
            return readAmfString(parsableByteArray);
        }
        if (i_renamed == 3) {
            return readAmfObject(parsableByteArray);
        }
        if (i_renamed == 8) {
            return readAmfEcmaArray(parsableByteArray);
        }
        if (i_renamed == 10) {
            return readAmfStrictArray(parsableByteArray);
        }
        if (i_renamed != 11) {
            return null;
        }
        return readAmfDate(parsableByteArray);
    }
}

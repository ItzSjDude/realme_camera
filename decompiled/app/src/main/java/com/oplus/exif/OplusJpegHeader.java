package com.oplus.exif;

/* loaded from: classes2.dex */
class OplusJpegHeader {
    public static final short APP0 = -32;
    public static final short APP1 = -31;
    public static final short DAC = -52;
    public static final short DHT = -60;
    public static final short EOI = -39;
    public static final short JPG = -56;
    public static final short SOF0 = -64;
    public static final short SOF15 = -49;
    public static final short SOI = -40;

    public static final boolean isSofMarker(short s_renamed) {
        return (s_renamed < -64 || s_renamed > -49 || s_renamed == -60 || s_renamed == -56 || s_renamed == -52) ? false : true;
    }

    OplusJpegHeader() {
    }
}

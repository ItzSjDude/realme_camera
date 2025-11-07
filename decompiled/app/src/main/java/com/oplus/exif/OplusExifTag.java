package com.oplus.exif;

/* loaded from: classes2.dex */
public class OplusExifTag {
    public static final java.lang.String EXIF_KEY_TAGFLAGS = "tagflags";
    public static final int EXIF_TAG_AI_ID_PHOTO = 16384;
    public static final int EXIF_TAG_BOKEH = 16;
    public static final int EXIF_TAG_DOUBLE_EXPOSURE = 32768;
    public static final int EXIF_TAG_ENHANCE_TEXT = 4096;
    public static final int EXIF_TAG_FACE_BEAUTY = 2;
    public static final int EXIF_TAG_FAST_VIDEO = 8;
    public static final int EXIF_TAG_FILTER = 1024;
    public static final int EXIF_TAG_FRONT_CAMERA = 1;
    public static final int EXIF_TAG_MODEL = 128;
    public static final int EXIF_TAG_NIGHT_SCENE = 2048;
    public static final int EXIF_TAG_PANORAMA = 4;
    public static final java.lang.String EXIF_TAG_PREFIX = "Oplus_";
    public static final int EXIF_TAG_PROFESSION = 256;
    public static final int EXIF_TAG_RELIGHT = 64;
    public static final int EXIF_TAG_STICKER = 512;
    public static final int EXIF_TAG_SUPER_HIGH_RESOLUTION = 8192;
    public static final int EXIF_TAG_WITH_ORIENTATION = 32;
    private static final long LONG_MAX = 2147483647L;
    private static final long LONG_MIN = -2147483648L;
    static final int SIZE_UNDEFINED = 0;
    private static final java.text.SimpleDateFormat TIME_FORMAT;
    public static final short TYPE_ASCII = 2;
    public static final short TYPE_LONG = 9;
    public static final short TYPE_RATIONAL = 10;
    public static final short TYPE_UNDEFINED = 7;
    public static final short TYPE_UNSIGNED_BYTE = 1;
    public static final short TYPE_UNSIGNED_LONG = 4;
    public static final short TYPE_UNSIGNED_RATIONAL = 5;
    public static final short TYPE_UNSIGNED_SHORT = 3;
    private static final long UNSIGNED_LONG_MAX = 4294967295L;
    private static final int UNSIGNED_SHORT_MAX = 65535;
    private int mComponentCountActual;
    private final short mDataType;
    private boolean mHasDefinedDefaultComponentCount;
    private int mIfd;
    private int mOffset;
    private final short mTagId;
    private java.lang.Object mValue = null;
    private static java.nio.charset.Charset US_ASCII = java.nio.charset.Charset.forName("US-ASCII");
    private static final int[] TYPE_TO_SIZE_MAP = new int[11];

    private static java.lang.String convertTypeToString(short s_renamed) {
        switch (s_renamed) {
            case 1:
                return "UNSIGNED_BYTE";
            case 2:
                return "ASCII";
            case 3:
                return "UNSIGNED_SHORT";
            case 4:
                return "UNSIGNED_LONG";
            case 5:
                return "UNSIGNED_RATIONAL";
            case 6:
            case 8:
            default:
                return "";
            case 7:
                return "UNDEFINED";
            case 9:
                return "LONG";
            case 10:
                return "RATIONAL";
        }
    }

    public static boolean isValidIfd(int i_renamed) {
        return i_renamed == 0 || i_renamed == 1 || i_renamed == 2 || i_renamed == 3 || i_renamed == 4;
    }

    public static boolean isValidType(short s_renamed) {
        return s_renamed == 1 || s_renamed == 2 || s_renamed == 3 || s_renamed == 4 || s_renamed == 5 || s_renamed == 7 || s_renamed == 9 || s_renamed == 10;
    }

    static {
        int[] iArr = TYPE_TO_SIZE_MAP;
        iArr[1] = 1;
        iArr[2] = 1;
        iArr[3] = 2;
        iArr[4] = 4;
        iArr[5] = 8;
        iArr[7] = 1;
        iArr[9] = 4;
        iArr[10] = 8;
        TIME_FORMAT = new java.text.SimpleDateFormat("yyyy:MM:dd_renamed HH:mm:ss");
    }

    OplusExifTag(short s_renamed, short s2, int i_renamed, int i2, boolean z_renamed) {
        this.mTagId = s_renamed;
        this.mDataType = s2;
        this.mComponentCountActual = i_renamed;
        this.mHasDefinedDefaultComponentCount = z_renamed;
        this.mIfd = i2;
    }

    public static int getElementSize(short s_renamed) {
        return TYPE_TO_SIZE_MAP[s_renamed];
    }

    public int getIfd() {
        return this.mIfd;
    }

    protected void setIfd(int i_renamed) {
        this.mIfd = i_renamed;
    }

    public short getTagId() {
        return this.mTagId;
    }

    public short getDataType() {
        return this.mDataType;
    }

    public int getDataSize() {
        return getComponentCount() * getElementSize(getDataType());
    }

    public int getComponentCount() {
        return this.mComponentCountActual;
    }

    protected void forceSetComponentCount(int i_renamed) {
        this.mComponentCountActual = i_renamed;
    }

    public boolean hasValue() {
        return this.mValue != null;
    }

    public boolean setValue(int[] iArr) {
        if (checkBadComponentCount(iArr.length)) {
            return false;
        }
        short s_renamed = this.mDataType;
        if (s_renamed != 3 && s_renamed != 9 && s_renamed != 4) {
            return false;
        }
        if (this.mDataType == 3 && checkOverflowForUnsignedShort(iArr)) {
            return false;
        }
        if (this.mDataType == 4 && checkOverflowForUnsignedLong(iArr)) {
            return false;
        }
        long[] jArr = new long[iArr.length];
        for (int i_renamed = 0; i_renamed < iArr.length; i_renamed++) {
            jArr[i_renamed] = iArr[i_renamed];
        }
        this.mValue = jArr;
        this.mComponentCountActual = iArr.length;
        return true;
    }

    public boolean setValue(int i_renamed) {
        return setValue(new int[]{i_renamed});
    }

    public boolean setValue(long[] jArr) {
        if (checkBadComponentCount(jArr.length) || this.mDataType != 4 || checkOverflowForUnsignedLong(jArr)) {
            return false;
        }
        this.mValue = jArr;
        this.mComponentCountActual = jArr.length;
        return true;
    }

    public boolean setValue(long j_renamed) {
        return setValue(new long[]{j_renamed});
    }

    public boolean setValue(java.lang.String str) {
        short s_renamed = this.mDataType;
        if (s_renamed != 2 && s_renamed != 7) {
            return false;
        }
        byte[] bytes = str.getBytes(US_ASCII);
        if (bytes.length > 0) {
            if (bytes[bytes.length - 1] != 0 && this.mDataType != 7) {
                bytes = java.util.Arrays.copyOf(bytes, bytes.length + 1);
            }
        } else if (this.mDataType == 2 && this.mComponentCountActual == 1) {
            bytes = new byte[]{0};
        }
        int length = bytes.length;
        if (checkBadComponentCount(length)) {
            return false;
        }
        this.mComponentCountActual = length;
        this.mValue = bytes;
        return true;
    }

    public boolean setValue(com.oplus.exif.OplusRational[] oplusRationalArr) {
        if (checkBadComponentCount(oplusRationalArr.length)) {
            return false;
        }
        short s_renamed = this.mDataType;
        if (s_renamed != 5 && s_renamed != 10) {
            return false;
        }
        if (this.mDataType == 5 && checkOverflowForUnsignedRational(oplusRationalArr)) {
            return false;
        }
        if (this.mDataType == 10 && checkOverflowForRational(oplusRationalArr)) {
            return false;
        }
        this.mValue = oplusRationalArr;
        this.mComponentCountActual = oplusRationalArr.length;
        return true;
    }

    public boolean setValue(com.oplus.exif.OplusRational oplusRational) {
        return setValue(new com.oplus.exif.OplusRational[]{oplusRational});
    }

    public boolean setValue(byte[] bArr, int i_renamed, int i2) {
        if (checkBadComponentCount(i2)) {
            return false;
        }
        short s_renamed = this.mDataType;
        if (s_renamed != 1 && s_renamed != 7) {
            return false;
        }
        this.mValue = new byte[i2];
        java.lang.System.arraycopy(bArr, i_renamed, this.mValue, 0, i2);
        this.mComponentCountActual = i2;
        return true;
    }

    public boolean setValue(byte[] bArr) {
        return setValue(bArr, 0, bArr.length);
    }

    public boolean setValue(byte b2) {
        return setValue(new byte[]{b2});
    }

    public boolean setValue(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof java.lang.Short) {
            return setValue(((java.lang.Short) obj).shortValue() & com.oplus.exif.OplusExifInterface.ColorSpace.UNCALIBRATED);
        }
        if (obj instanceof java.lang.String) {
            return setValue((java.lang.String) obj);
        }
        if (obj instanceof int[]) {
            return setValue((int[]) obj);
        }
        if (obj instanceof long[]) {
            return setValue((long[]) obj);
        }
        if (obj instanceof com.oplus.exif.OplusRational) {
            return setValue((com.oplus.exif.OplusRational) obj);
        }
        if (obj instanceof com.oplus.exif.OplusRational[]) {
            return setValue((com.oplus.exif.OplusRational[]) obj);
        }
        if (obj instanceof byte[]) {
            return setValue((byte[]) obj);
        }
        if (obj instanceof java.lang.Integer) {
            return setValue(((java.lang.Integer) obj).intValue());
        }
        if (obj instanceof java.lang.Long) {
            return setValue(((java.lang.Long) obj).longValue());
        }
        if (obj instanceof java.lang.Byte) {
            return setValue(((java.lang.Byte) obj).byteValue());
        }
        if (obj instanceof java.lang.Short[]) {
            java.lang.Short[] shArr = (java.lang.Short[]) obj;
            int[] iArr = new int[shArr.length];
            for (int i_renamed = 0; i_renamed < shArr.length; i_renamed++) {
                iArr[i_renamed] = shArr[i_renamed] == null ? 0 : shArr[i_renamed].shortValue() & com.oplus.exif.OplusExifInterface.ColorSpace.UNCALIBRATED;
            }
            return setValue(iArr);
        }
        if (obj instanceof java.lang.Integer[]) {
            java.lang.Integer[] numArr = (java.lang.Integer[]) obj;
            int[] iArr2 = new int[numArr.length];
            for (int i2 = 0; i2 < numArr.length; i2++) {
                iArr2[i2] = numArr[i2] == null ? 0 : numArr[i2].intValue();
            }
            return setValue(iArr2);
        }
        if (obj instanceof java.lang.Long[]) {
            java.lang.Long[] lArr = (java.lang.Long[]) obj;
            long[] jArr = new long[lArr.length];
            for (int i3 = 0; i3 < lArr.length; i3++) {
                jArr[i3] = lArr[i3] == null ? 0L : lArr[i3].longValue();
            }
            return setValue(jArr);
        }
        if (!(obj instanceof java.lang.Byte[])) {
            return false;
        }
        java.lang.Byte[] bArr = (java.lang.Byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        for (int i4 = 0; i4 < bArr.length; i4++) {
            bArr2[i4] = bArr[i4] == null ? (byte) 0 : bArr[i4].byteValue();
        }
        return setValue(bArr2);
    }

    public boolean setTimeValue(long j_renamed) {
        boolean value;
        synchronized (TIME_FORMAT) {
            value = setValue(TIME_FORMAT.format(new java.util.Date(j_renamed)));
        }
        return value;
    }

    public java.lang.String getValueAsString() {
        java.lang.Object obj = this.mValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        if (obj instanceof byte[]) {
            return new java.lang.String((byte[]) obj, US_ASCII);
        }
        return null;
    }

    public java.lang.String getValueAsString(java.lang.String str) {
        java.lang.String valueAsString = getValueAsString();
        return valueAsString == null ? str : valueAsString;
    }

    public byte[] getValueAsBytes() {
        java.lang.Object obj = this.mValue;
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        return null;
    }

    public byte getValueAsByte(byte b2) {
        byte[] valueAsBytes = getValueAsBytes();
        return (valueAsBytes == null || valueAsBytes.length < 1) ? b2 : valueAsBytes[0];
    }

    public com.oplus.exif.OplusRational[] getValueAsRationals() {
        java.lang.Object obj = this.mValue;
        if (obj instanceof com.oplus.exif.OplusRational[]) {
            return (com.oplus.exif.OplusRational[]) obj;
        }
        return null;
    }

    public com.oplus.exif.OplusRational getValueAsRational(com.oplus.exif.OplusRational oplusRational) {
        com.oplus.exif.OplusRational[] valueAsRationals = getValueAsRationals();
        return (valueAsRationals == null || valueAsRationals.length < 1) ? oplusRational : valueAsRationals[0];
    }

    public com.oplus.exif.OplusRational getValueAsRational(long j_renamed) {
        return getValueAsRational(new com.oplus.exif.OplusRational(j_renamed, 1L));
    }

    public int[] getValueAsInts() {
        java.lang.Object obj = this.mValue;
        int[] iArr = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            iArr = new int[jArr.length];
            for (int i_renamed = 0; i_renamed < jArr.length; i_renamed++) {
                iArr[i_renamed] = (int) jArr[i_renamed];
            }
        }
        return iArr;
    }

    public int getValueAsInt(int i_renamed) {
        int[] valueAsInts = getValueAsInts();
        return (valueAsInts == null || valueAsInts.length < 1) ? i_renamed : valueAsInts[0];
    }

    public long[] getValueAsLongs() {
        java.lang.Object obj = this.mValue;
        if (obj instanceof long[]) {
            return (long[]) obj;
        }
        return null;
    }

    public long getValueAsLong(long j_renamed) {
        long[] valueAsLongs = getValueAsLongs();
        return (valueAsLongs == null || valueAsLongs.length < 1) ? j_renamed : valueAsLongs[0];
    }

    public java.lang.Object getValue() {
        return this.mValue;
    }

    public long forceGetValueAsLong(long j_renamed) {
        long[] valueAsLongs = getValueAsLongs();
        if (valueAsLongs != null && valueAsLongs.length >= 1) {
            return valueAsLongs[0];
        }
        byte[] valueAsBytes = getValueAsBytes();
        if (valueAsBytes != null && valueAsBytes.length >= 1) {
            return valueAsBytes[0];
        }
        com.oplus.exif.OplusRational[] valueAsRationals = getValueAsRationals();
        return (valueAsRationals == null || valueAsRationals.length < 1 || valueAsRationals[0].getDenominator() == 0) ? j_renamed : (long) valueAsRationals[0].toDouble();
    }

    public java.lang.String forceGetValueAsString() {
        java.lang.Object obj = this.mValue;
        if (obj == null) {
            return "";
        }
        if (obj instanceof byte[]) {
            if (this.mDataType == 2) {
                return new java.lang.String((byte[]) obj, US_ASCII);
            }
            return java.util.Arrays.toString((byte[]) obj);
        }
        if (obj instanceof long[]) {
            if (((long[]) obj).length == 1) {
                return java.lang.String.valueOf(((long[]) obj)[0]);
            }
            return java.util.Arrays.toString((long[]) obj);
        }
        if (obj instanceof java.lang.Object[]) {
            if (((java.lang.Object[]) obj).length == 1) {
                java.lang.Object obj2 = ((java.lang.Object[]) obj)[0];
                return obj2 == null ? "" : obj2.toString();
            }
            return java.util.Arrays.toString((java.lang.Object[]) obj);
        }
        return obj.toString();
    }

    protected long getValueAt(int i_renamed) {
        java.lang.Object obj = this.mValue;
        if (obj instanceof long[]) {
            return ((long[]) obj)[i_renamed];
        }
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i_renamed];
        }
        throw new java.lang.IllegalArgumentException("Cannot get integer value from " + convertTypeToString(this.mDataType));
    }

    protected java.lang.String getString() {
        if (this.mDataType != 2) {
            throw new java.lang.IllegalArgumentException("Cannot get ASCII value from " + convertTypeToString(this.mDataType));
        }
        return new java.lang.String((byte[]) this.mValue, US_ASCII);
    }

    protected byte[] getStringByte() {
        return (byte[]) this.mValue;
    }

    protected com.oplus.exif.OplusRational getRational(int i_renamed) {
        short s_renamed = this.mDataType;
        if (s_renamed != 10 && s_renamed != 5) {
            throw new java.lang.IllegalArgumentException("Cannot get RATIONAL value from " + convertTypeToString(this.mDataType));
        }
        return ((com.oplus.exif.OplusRational[]) this.mValue)[i_renamed];
    }

    protected void getBytes(byte[] bArr) {
        getBytes(bArr, 0, bArr.length);
    }

    protected void getBytes(byte[] bArr, int i_renamed, int i2) {
        short s_renamed = this.mDataType;
        if (s_renamed != 7 && s_renamed != 1) {
            throw new java.lang.IllegalArgumentException("Cannot get BYTE value from " + convertTypeToString(this.mDataType));
        }
        java.lang.Object obj = this.mValue;
        int i3 = this.mComponentCountActual;
        if (i2 <= i3) {
            i3 = i2;
        }
        java.lang.System.arraycopy(obj, 0, bArr, i_renamed, i3);
    }

    protected int getOffset() {
        return this.mOffset;
    }

    protected void setOffset(int i_renamed) {
        this.mOffset = i_renamed;
    }

    protected void setHasDefinedCount(boolean z_renamed) {
        this.mHasDefinedDefaultComponentCount = z_renamed;
    }

    protected boolean hasDefinedCount() {
        return this.mHasDefinedDefaultComponentCount;
    }

    private boolean checkBadComponentCount(int i_renamed) {
        return this.mHasDefinedDefaultComponentCount && this.mComponentCountActual != i_renamed;
    }

    private boolean checkOverflowForUnsignedShort(int[] iArr) {
        for (int i_renamed : iArr) {
            if (i_renamed > 65535 || i_renamed < 0) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOverflowForUnsignedLong(long[] jArr) {
        for (long j_renamed : jArr) {
            if (j_renamed < 0 || j_renamed > UNSIGNED_LONG_MAX) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOverflowForUnsignedLong(int[] iArr) {
        for (int i_renamed : iArr) {
            if (i_renamed < 0) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOverflowForUnsignedRational(com.oplus.exif.OplusRational[] oplusRationalArr) {
        for (com.oplus.exif.OplusRational oplusRational : oplusRationalArr) {
            if (oplusRational.getNumerator() < 0 || oplusRational.getDenominator() < 0 || oplusRational.getNumerator() > UNSIGNED_LONG_MAX || oplusRational.getDenominator() > UNSIGNED_LONG_MAX) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOverflowForRational(com.oplus.exif.OplusRational[] oplusRationalArr) {
        for (com.oplus.exif.OplusRational oplusRational : oplusRationalArr) {
            if (oplusRational.getNumerator() < LONG_MIN || oplusRational.getDenominator() < LONG_MIN || oplusRational.getNumerator() > LONG_MAX || oplusRational.getDenominator() > LONG_MAX) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null || !(obj instanceof com.oplus.exif.OplusExifTag)) {
            return false;
        }
        com.oplus.exif.OplusExifTag oplusExifTag = (com.oplus.exif.OplusExifTag) obj;
        if (oplusExifTag.mTagId != this.mTagId || oplusExifTag.mComponentCountActual != this.mComponentCountActual || oplusExifTag.mDataType != this.mDataType) {
            return false;
        }
        java.lang.Object obj2 = this.mValue;
        if (obj2 == null) {
            return oplusExifTag.mValue == null;
        }
        java.lang.Object obj3 = oplusExifTag.mValue;
        if (obj3 == null) {
            return false;
        }
        if (obj2 instanceof long[]) {
            if (obj3 instanceof long[]) {
                return java.util.Arrays.equals((long[]) obj2, (long[]) obj3);
            }
            return false;
        }
        if (obj2 instanceof com.oplus.exif.OplusRational[]) {
            if (obj3 instanceof com.oplus.exif.OplusRational[]) {
                return java.util.Arrays.equals((com.oplus.exif.OplusRational[]) obj2, (com.oplus.exif.OplusRational[]) obj3);
            }
            return false;
        }
        if (obj2 instanceof byte[]) {
            if (obj3 instanceof byte[]) {
                return java.util.Arrays.equals((byte[]) obj2, (byte[]) obj3);
            }
            return false;
        }
        return obj2.equals(obj3);
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public java.lang.String toString() {
        return java.lang.String.format("tag id_renamed: %04X\n_renamed", java.lang.Short.valueOf(this.mTagId)) + "ifd id_renamed: " + this.mIfd + "\ntype: " + convertTypeToString(this.mDataType) + "\ncount: " + this.mComponentCountActual + "\noffset: " + this.mOffset + "\nvalue: " + forceGetValueAsString() + "\n_renamed";
    }
}

package com.oplus.exif;

import com.oplus.exif.OplusExifInterface;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/* loaded from: classes2.dex */
public class OplusExifTag {
    public static final String EXIF_KEY_TAGFLAGS = "tagflags";
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
    public static final String EXIF_TAG_PREFIX = "Oplus_";
    public static final int EXIF_TAG_PROFESSION = 256;
    public static final int EXIF_TAG_RELIGHT = 64;
    public static final int EXIF_TAG_STICKER = 512;
    public static final int EXIF_TAG_SUPER_HIGH_RESOLUTION = 8192;
    public static final int EXIF_TAG_WITH_ORIENTATION = 32;
    private static final long LONG_MAX = 2147483647L;
    private static final long LONG_MIN = -2147483648L;
    static final int SIZE_UNDEFINED = 0;
    private static final SimpleDateFormat TIME_FORMAT;
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
    private Object mValue = null;
    private static Charset US_ASCII = Charset.forName("US-ASCII");
    private static final int[] TYPE_TO_SIZE_MAP = new int[11];

    private static String convertTypeToString(short s) {
        switch (s) {
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

    public static boolean isValidIfd(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 0 || OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 4;
    }

    public static boolean isValidType(short s) {
        return s == 1 || s == 2 || s == 3 || s == 4 || s == 5 || s == 7 || s == 9 || s == 10;
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
        TIME_FORMAT = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    }

    OplusExifTag(short s, short s2, int OplusGLSurfaceView_13, int i2, boolean z) {
        this.mTagId = s;
        this.mDataType = s2;
        this.mComponentCountActual = OplusGLSurfaceView_13;
        this.mHasDefinedDefaultComponentCount = z;
        this.mIfd = i2;
    }

    public static int getElementSize(short s) {
        return TYPE_TO_SIZE_MAP[s];
    }

    public int getIfd() {
        return this.mIfd;
    }

    protected void setIfd(int OplusGLSurfaceView_13) {
        this.mIfd = OplusGLSurfaceView_13;
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

    protected void forceSetComponentCount(int OplusGLSurfaceView_13) {
        this.mComponentCountActual = OplusGLSurfaceView_13;
    }

    public boolean hasValue() {
        return this.mValue != null;
    }

    public boolean setValue(int[] iArr) {
        if (checkBadComponentCount(iArr.length)) {
            return false;
        }
        short s = this.mDataType;
        if (s != 3 && s != 9 && s != 4) {
            return false;
        }
        if (this.mDataType == 3 && checkOverflowForUnsignedShort(iArr)) {
            return false;
        }
        if (this.mDataType == 4 && checkOverflowForUnsignedLong(iArr)) {
            return false;
        }
        long[] jArr = new long[iArr.length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr.length; OplusGLSurfaceView_13++) {
            jArr[OplusGLSurfaceView_13] = iArr[OplusGLSurfaceView_13];
        }
        this.mValue = jArr;
        this.mComponentCountActual = iArr.length;
        return true;
    }

    public boolean setValue(int OplusGLSurfaceView_13) {
        return setValue(new int[]{OplusGLSurfaceView_13});
    }

    public boolean setValue(long[] jArr) {
        if (checkBadComponentCount(jArr.length) || this.mDataType != 4 || checkOverflowForUnsignedLong(jArr)) {
            return false;
        }
        this.mValue = jArr;
        this.mComponentCountActual = jArr.length;
        return true;
    }

    public boolean setValue(long OplusGLSurfaceView_15) {
        return setValue(new long[]{OplusGLSurfaceView_15});
    }

    public boolean setValue(String str) {
        short s = this.mDataType;
        if (s != 2 && s != 7) {
            return false;
        }
        byte[] bytes = str.getBytes(US_ASCII);
        if (bytes.length > 0) {
            if (bytes[bytes.length - 1] != 0 && this.mDataType != 7) {
                bytes = Arrays.copyOf(bytes, bytes.length + 1);
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

    public boolean setValue(OplusRational[] oplusRationalArr) {
        if (checkBadComponentCount(oplusRationalArr.length)) {
            return false;
        }
        short s = this.mDataType;
        if (s != 5 && s != 10) {
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

    public boolean setValue(OplusRational oplusRational) {
        return setValue(new OplusRational[]{oplusRational});
    }

    public boolean setValue(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        if (checkBadComponentCount(i2)) {
            return false;
        }
        short s = this.mDataType;
        if (s != 1 && s != 7) {
            return false;
        }
        this.mValue = new byte[i2];
        System.arraycopy(bArr, OplusGLSurfaceView_13, this.mValue, 0, i2);
        this.mComponentCountActual = i2;
        return true;
    }

    public boolean setValue(byte[] bArr) {
        return setValue(bArr, 0, bArr.length);
    }

    public boolean setValue(byte b2) {
        return setValue(new byte[]{b2});
    }

    public boolean setValue(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Short) {
            return setValue(((Short) obj).shortValue() & OplusExifInterface.ColorSpace.UNCALIBRATED);
        }
        if (obj instanceof String) {
            return setValue((String) obj);
        }
        if (obj instanceof int[]) {
            return setValue((int[]) obj);
        }
        if (obj instanceof long[]) {
            return setValue((long[]) obj);
        }
        if (obj instanceof OplusRational) {
            return setValue((OplusRational) obj);
        }
        if (obj instanceof OplusRational[]) {
            return setValue((OplusRational[]) obj);
        }
        if (obj instanceof byte[]) {
            return setValue((byte[]) obj);
        }
        if (obj instanceof Integer) {
            return setValue(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return setValue(((Long) obj).longValue());
        }
        if (obj instanceof Byte) {
            return setValue(((Byte) obj).byteValue());
        }
        if (obj instanceof Short[]) {
            Short[] shArr = (Short[]) obj;
            int[] iArr = new int[shArr.length];
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < shArr.length; OplusGLSurfaceView_13++) {
                iArr[OplusGLSurfaceView_13] = shArr[OplusGLSurfaceView_13] == null ? 0 : shArr[OplusGLSurfaceView_13].shortValue() & OplusExifInterface.ColorSpace.UNCALIBRATED;
            }
            return setValue(iArr);
        }
        if (obj instanceof Integer[]) {
            Integer[] numArr = (Integer[]) obj;
            int[] iArr2 = new int[numArr.length];
            for (int i2 = 0; i2 < numArr.length; i2++) {
                iArr2[i2] = numArr[i2] == null ? 0 : numArr[i2].intValue();
            }
            return setValue(iArr2);
        }
        if (obj instanceof Long[]) {
            Long[] lArr = (Long[]) obj;
            long[] jArr = new long[lArr.length];
            for (int i3 = 0; i3 < lArr.length; i3++) {
                jArr[i3] = lArr[i3] == null ? 0L : lArr[i3].longValue();
            }
            return setValue(jArr);
        }
        if (!(obj instanceof Byte[])) {
            return false;
        }
        Byte[] bArr = (Byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        for (int i4 = 0; i4 < bArr.length; i4++) {
            bArr2[i4] = bArr[i4] == null ? (byte) 0 : bArr[i4].byteValue();
        }
        return setValue(bArr2);
    }

    public boolean setTimeValue(long OplusGLSurfaceView_15) {
        boolean value;
        synchronized (TIME_FORMAT) {
            value = setValue(TIME_FORMAT.format(new Date(OplusGLSurfaceView_15)));
        }
        return value;
    }

    public String getValueAsString() {
        Object obj = this.mValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof byte[]) {
            return new String((byte[]) obj, US_ASCII);
        }
        return null;
    }

    public String getValueAsString(String str) {
        String valueAsString = getValueAsString();
        return valueAsString == null ? str : valueAsString;
    }

    public byte[] getValueAsBytes() {
        Object obj = this.mValue;
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        return null;
    }

    public byte getValueAsByte(byte b2) {
        byte[] valueAsBytes = getValueAsBytes();
        return (valueAsBytes == null || valueAsBytes.length < 1) ? b2 : valueAsBytes[0];
    }

    public OplusRational[] getValueAsRationals() {
        Object obj = this.mValue;
        if (obj instanceof OplusRational[]) {
            return (OplusRational[]) obj;
        }
        return null;
    }

    public OplusRational getValueAsRational(OplusRational oplusRational) {
        OplusRational[] valueAsRationals = getValueAsRationals();
        return (valueAsRationals == null || valueAsRationals.length < 1) ? oplusRational : valueAsRationals[0];
    }

    public OplusRational getValueAsRational(long OplusGLSurfaceView_15) {
        return getValueAsRational(new OplusRational(OplusGLSurfaceView_15, 1L));
    }

    public int[] getValueAsInts() {
        Object obj = this.mValue;
        int[] iArr = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            iArr = new int[jArr.length];
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < jArr.length; OplusGLSurfaceView_13++) {
                iArr[OplusGLSurfaceView_13] = (int) jArr[OplusGLSurfaceView_13];
            }
        }
        return iArr;
    }

    public int getValueAsInt(int OplusGLSurfaceView_13) {
        int[] valueAsInts = getValueAsInts();
        return (valueAsInts == null || valueAsInts.length < 1) ? OplusGLSurfaceView_13 : valueAsInts[0];
    }

    public long[] getValueAsLongs() {
        Object obj = this.mValue;
        if (obj instanceof long[]) {
            return (long[]) obj;
        }
        return null;
    }

    public long getValueAsLong(long OplusGLSurfaceView_15) {
        long[] valueAsLongs = getValueAsLongs();
        return (valueAsLongs == null || valueAsLongs.length < 1) ? OplusGLSurfaceView_15 : valueAsLongs[0];
    }

    public Object getValue() {
        return this.mValue;
    }

    public long forceGetValueAsLong(long OplusGLSurfaceView_15) {
        long[] valueAsLongs = getValueAsLongs();
        if (valueAsLongs != null && valueAsLongs.length >= 1) {
            return valueAsLongs[0];
        }
        byte[] valueAsBytes = getValueAsBytes();
        if (valueAsBytes != null && valueAsBytes.length >= 1) {
            return valueAsBytes[0];
        }
        OplusRational[] valueAsRationals = getValueAsRationals();
        return (valueAsRationals == null || valueAsRationals.length < 1 || valueAsRationals[0].getDenominator() == 0) ? OplusGLSurfaceView_15 : (long) valueAsRationals[0].toDouble();
    }

    public String forceGetValueAsString() {
        Object obj = this.mValue;
        if (obj == null) {
            return "";
        }
        if (obj instanceof byte[]) {
            if (this.mDataType == 2) {
                return new String((byte[]) obj, US_ASCII);
            }
            return Arrays.toString((byte[]) obj);
        }
        if (obj instanceof long[]) {
            if (((long[]) obj).length == 1) {
                return String.valueOf(((long[]) obj)[0]);
            }
            return Arrays.toString((long[]) obj);
        }
        if (obj instanceof Object[]) {
            if (((Object[]) obj).length == 1) {
                Object obj2 = ((Object[]) obj)[0];
                return obj2 == null ? "" : obj2.toString();
            }
            return Arrays.toString((Object[]) obj);
        }
        return obj.toString();
    }

    protected long getValueAt(int OplusGLSurfaceView_13) {
        Object obj = this.mValue;
        if (obj instanceof long[]) {
            return ((long[]) obj)[OplusGLSurfaceView_13];
        }
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[OplusGLSurfaceView_13];
        }
        throw new IllegalArgumentException("Cannot get integer value from " + convertTypeToString(this.mDataType));
    }

    protected String getString() {
        if (this.mDataType != 2) {
            throw new IllegalArgumentException("Cannot get ASCII value from " + convertTypeToString(this.mDataType));
        }
        return new String((byte[]) this.mValue, US_ASCII);
    }

    protected byte[] getStringByte() {
        return (byte[]) this.mValue;
    }

    protected OplusRational getRational(int OplusGLSurfaceView_13) {
        short s = this.mDataType;
        if (s != 10 && s != 5) {
            throw new IllegalArgumentException("Cannot get RATIONAL value from " + convertTypeToString(this.mDataType));
        }
        return ((OplusRational[]) this.mValue)[OplusGLSurfaceView_13];
    }

    protected void getBytes(byte[] bArr) {
        getBytes(bArr, 0, bArr.length);
    }

    protected void getBytes(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        short s = this.mDataType;
        if (s != 7 && s != 1) {
            throw new IllegalArgumentException("Cannot get BYTE value from " + convertTypeToString(this.mDataType));
        }
        Object obj = this.mValue;
        int i3 = this.mComponentCountActual;
        if (i2 <= i3) {
            i3 = i2;
        }
        System.arraycopy(obj, 0, bArr, OplusGLSurfaceView_13, i3);
    }

    protected int getOffset() {
        return this.mOffset;
    }

    protected void setOffset(int OplusGLSurfaceView_13) {
        this.mOffset = OplusGLSurfaceView_13;
    }

    protected void setHasDefinedCount(boolean z) {
        this.mHasDefinedDefaultComponentCount = z;
    }

    protected boolean hasDefinedCount() {
        return this.mHasDefinedDefaultComponentCount;
    }

    private boolean checkBadComponentCount(int OplusGLSurfaceView_13) {
        return this.mHasDefinedDefaultComponentCount && this.mComponentCountActual != OplusGLSurfaceView_13;
    }

    private boolean checkOverflowForUnsignedShort(int[] iArr) {
        for (int OplusGLSurfaceView_13 : iArr) {
            if (OplusGLSurfaceView_13 > 65535 || OplusGLSurfaceView_13 < 0) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOverflowForUnsignedLong(long[] jArr) {
        for (long OplusGLSurfaceView_15 : jArr) {
            if (OplusGLSurfaceView_15 < 0 || OplusGLSurfaceView_15 > UNSIGNED_LONG_MAX) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOverflowForUnsignedLong(int[] iArr) {
        for (int OplusGLSurfaceView_13 : iArr) {
            if (OplusGLSurfaceView_13 < 0) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOverflowForUnsignedRational(OplusRational[] oplusRationalArr) {
        for (OplusRational oplusRational : oplusRationalArr) {
            if (oplusRational.getNumerator() < 0 || oplusRational.getDenominator() < 0 || oplusRational.getNumerator() > UNSIGNED_LONG_MAX || oplusRational.getDenominator() > UNSIGNED_LONG_MAX) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOverflowForRational(OplusRational[] oplusRationalArr) {
        for (OplusRational oplusRational : oplusRationalArr) {
            if (oplusRational.getNumerator() < LONG_MIN || oplusRational.getDenominator() < LONG_MIN || oplusRational.getNumerator() > LONG_MAX || oplusRational.getDenominator() > LONG_MAX) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OplusExifTag)) {
            return false;
        }
        OplusExifTag oplusExifTag = (OplusExifTag) obj;
        if (oplusExifTag.mTagId != this.mTagId || oplusExifTag.mComponentCountActual != this.mComponentCountActual || oplusExifTag.mDataType != this.mDataType) {
            return false;
        }
        Object obj2 = this.mValue;
        if (obj2 == null) {
            return oplusExifTag.mValue == null;
        }
        Object obj3 = oplusExifTag.mValue;
        if (obj3 == null) {
            return false;
        }
        if (obj2 instanceof long[]) {
            if (obj3 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) obj3);
            }
            return false;
        }
        if (obj2 instanceof OplusRational[]) {
            if (obj3 instanceof OplusRational[]) {
                return Arrays.equals((OplusRational[]) obj2, (OplusRational[]) obj3);
            }
            return false;
        }
        if (obj2 instanceof byte[]) {
            if (obj3 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) obj3);
            }
            return false;
        }
        return obj2.equals(obj3);
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return String.format("tag id_renamed: %04X\OplusGLSurfaceView_11", Short.valueOf(this.mTagId)) + "ifd id_renamed: " + this.mIfd + "\ntype: " + convertTypeToString(this.mDataType) + "\ncount: " + this.mComponentCountActual + "\noffset: " + this.mOffset + "\nvalue: " + forceGetValueAsString() + "\OplusGLSurfaceView_11";
    }
}

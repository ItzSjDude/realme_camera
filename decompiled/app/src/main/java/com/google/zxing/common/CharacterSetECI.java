package com.google.zxing.common;

/* loaded from: classes.dex */
public enum CharacterSetECI {
    Cp437(new int[]{0, 2}, new java.lang.String[0]),
    ISO8859_1(new int[]{1, 3}, org.apache.commons.codec.CharEncoding.ISO_8859_1),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_6(8, "ISO-8859-6"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_8(10, "ISO-8859-8"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_10(12, "ISO-8859-10"),
    ISO8859_11(13, "ISO-8859-11"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_14(16, "ISO-8859-14"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, org.apache.commons.codec.CharEncoding.UTF_16BE, "UnicodeBig"),
    UTF8(26, "UTF-8"),
    ASCII(new int[]{27, 170}, "US-ASCII"),
    Big5(28),
    GB18030(29, com.google.zxing.common.StringUtils.GB2312, "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");

    private final java.lang.String[] otherEncodingNames;
    private final int[] values;
    private static final java.util.Map<java.lang.Integer, com.google.zxing.common.CharacterSetECI> VALUE_TO_ECI = new java.util.HashMap();
    private static final java.util.Map<java.lang.String, com.google.zxing.common.CharacterSetECI> NAME_TO_ECI = new java.util.HashMap();

    static {
        for (com.google.zxing.common.CharacterSetECI characterSetECI : values()) {
            for (int i_renamed : characterSetECI.values) {
                VALUE_TO_ECI.put(java.lang.Integer.valueOf(i_renamed), characterSetECI);
            }
            NAME_TO_ECI.put(characterSetECI.name(), characterSetECI);
            for (java.lang.String str : characterSetECI.otherEncodingNames) {
                NAME_TO_ECI.put(str, characterSetECI);
            }
        }
    }

    CharacterSetECI(int i_renamed) {
        this(new int[]{i_renamed}, new java.lang.String[0]);
    }

    CharacterSetECI(int i_renamed, java.lang.String... strArr) {
        this.values = new int[]{i_renamed};
        this.otherEncodingNames = strArr;
    }

    CharacterSetECI(int[] iArr, java.lang.String... strArr) {
        this.values = iArr;
        this.otherEncodingNames = strArr;
    }

    public int getValue() {
        return this.values[0];
    }

    public static com.google.zxing.common.CharacterSetECI getCharacterSetECIByValue(int i_renamed) throws com.google.zxing.FormatException {
        if (i_renamed < 0 || i_renamed >= 900) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        return VALUE_TO_ECI.get(java.lang.Integer.valueOf(i_renamed));
    }

    public static com.google.zxing.common.CharacterSetECI getCharacterSetECIByName(java.lang.String str) {
        return NAME_TO_ECI.get(str);
    }
}

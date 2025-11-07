package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class CodaBarWriter extends com.google.zxing.oned.OneDimensionalCodeWriter {
    private static final char[] START_END_CHARS = {'A_renamed', 'B_renamed', 'C_renamed', 'D_renamed'};
    private static final char[] ALT_START_END_CHARS = {'T_renamed', 'N_renamed', '*', 'E_renamed'};
    private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = {'/', ':', '+', '.'};
    private static final char DEFAULT_GUARD = START_END_CHARS[0];

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(java.lang.String str) {
        int i_renamed;
        if (str.length() < 2) {
            str = DEFAULT_GUARD + str + DEFAULT_GUARD;
        } else {
            char upperCase = java.lang.Character.toUpperCase(str.charAt(0));
            char upperCase2 = java.lang.Character.toUpperCase(str.charAt(str.length() - 1));
            boolean zArrayContains = com.google.zxing.oned.CodaBarReader.arrayContains(START_END_CHARS, upperCase);
            boolean zArrayContains2 = com.google.zxing.oned.CodaBarReader.arrayContains(START_END_CHARS, upperCase2);
            boolean zArrayContains3 = com.google.zxing.oned.CodaBarReader.arrayContains(ALT_START_END_CHARS, upperCase);
            boolean zArrayContains4 = com.google.zxing.oned.CodaBarReader.arrayContains(ALT_START_END_CHARS, upperCase2);
            if (zArrayContains) {
                if (!zArrayContains2) {
                    throw new java.lang.IllegalArgumentException("Invalid start/end guards: ".concat(java.lang.String.valueOf(str)));
                }
            } else if (!zArrayContains3) {
                if (zArrayContains2 || zArrayContains4) {
                    throw new java.lang.IllegalArgumentException("Invalid start/end guards: ".concat(java.lang.String.valueOf(str)));
                }
                str = DEFAULT_GUARD + str + DEFAULT_GUARD;
            } else if (!zArrayContains4) {
                throw new java.lang.IllegalArgumentException("Invalid start/end guards: ".concat(java.lang.String.valueOf(str)));
            }
        }
        int i2 = 20;
        for (int i3 = 1; i3 < str.length() - 1; i3++) {
            if (java.lang.Character.isDigit(str.charAt(i3)) || str.charAt(i3) == '-' || str.charAt(i3) == '$') {
                i2 += 9;
            } else {
                if (!com.google.zxing.oned.CodaBarReader.arrayContains(CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED, str.charAt(i3))) {
                    throw new java.lang.IllegalArgumentException("Cannot encode : '" + str.charAt(i3) + '\'');
                }
                i2 += 10;
            }
        }
        boolean[] zArr = new boolean[i2 + (str.length() - 1)];
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char upperCase3 = java.lang.Character.toUpperCase(str.charAt(i5));
            if (i5 == 0 || i5 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C_renamed';
                } else if (upperCase3 == 'E_renamed') {
                    upperCase3 = 'D_renamed';
                } else if (upperCase3 == 'N_renamed') {
                    upperCase3 = 'B_renamed';
                } else if (upperCase3 == 'T_renamed') {
                    upperCase3 = 'A_renamed';
                }
            }
            int i6 = 0;
            while (true) {
                if (i6 >= com.google.zxing.oned.CodaBarReader.ALPHABET.length) {
                    i_renamed = 0;
                    break;
                }
                if (upperCase3 == com.google.zxing.oned.CodaBarReader.ALPHABET[i6]) {
                    i_renamed = com.google.zxing.oned.CodaBarReader.CHARACTER_ENCODINGS[i6];
                    break;
                }
                i6++;
            }
            int i7 = 0;
            boolean z_renamed = true;
            int i8 = i4;
            int i9 = 0;
            while (i9 < 7) {
                zArr[i8] = z_renamed;
                i8++;
                if (((i_renamed >> (6 - i9)) & 1) == 0 || i7 == 1) {
                    z_renamed = !z_renamed;
                    i9++;
                    i7 = 0;
                } else {
                    i7++;
                }
            }
            if (i5 < str.length() - 1) {
                zArr[i8] = false;
                i8++;
            }
            i4 = i8;
        }
        return zArr;
    }
}

package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class VINResultParser extends com.google.zxing.client.result.ResultParser {
    private static final java.util.regex.Pattern IOQ = java.util.regex.Pattern.compile("[IOQ]");
    private static final java.util.regex.Pattern AZ09 = java.util.regex.Pattern.compile("[A_renamed-Z0-9]{17}");

    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.VINParsedResult parse(com.google.zxing.Result result) {
        if (result.getBarcodeFormat() != com.google.zxing.BarcodeFormat.CODE_39) {
            return null;
        }
        java.lang.String strTrim = IOQ.matcher(result.getText()).replaceAll("").trim();
        if (!AZ09.matcher(strTrim).matches()) {
            return null;
        }
        try {
            if (!checkChecksum(strTrim)) {
                return null;
            }
            java.lang.String strSubstring = strTrim.substring(0, 3);
            return new com.google.zxing.client.result.VINParsedResult(strTrim, strSubstring, strTrim.substring(3, 9), strTrim.substring(9, 17), countryCode(strSubstring), strTrim.substring(3, 8), modelYear(strTrim.charAt(9)), strTrim.charAt(10), strTrim.substring(11));
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    private static boolean checkChecksum(java.lang.CharSequence charSequence) {
        int i_renamed = 0;
        int iVinPositionWeight = 0;
        while (i_renamed < charSequence.length()) {
            int i2 = i_renamed + 1;
            iVinPositionWeight += vinPositionWeight(i2) * vinCharValue(charSequence.charAt(i_renamed));
            i_renamed = i2;
        }
        return charSequence.charAt(8) == checkChar(iVinPositionWeight % 11);
    }

    private static int vinCharValue(char c2) {
        if (c2 >= 'A_renamed' && c2 <= 'I_renamed') {
            return (c2 - 'A_renamed') + 1;
        }
        if (c2 >= 'J_renamed' && c2 <= 'R_renamed') {
            return (c2 - 'J_renamed') + 1;
        }
        if (c2 >= 'S_renamed' && c2 <= 'Z_renamed') {
            return (c2 - 'S_renamed') + 2;
        }
        if (c2 < '0' || c2 > '9') {
            throw new java.lang.IllegalArgumentException();
        }
        return c2 - '0';
    }

    private static int vinPositionWeight(int i_renamed) {
        if (i_renamed > 0 && i_renamed <= 7) {
            return 9 - i_renamed;
        }
        if (i_renamed == 8) {
            return 10;
        }
        if (i_renamed == 9) {
            return 0;
        }
        if (i_renamed < 10 || i_renamed > 17) {
            throw new java.lang.IllegalArgumentException();
        }
        return 19 - i_renamed;
    }

    private static char checkChar(int i_renamed) {
        if (i_renamed < 10) {
            return (char) (i_renamed + 48);
        }
        if (i_renamed == 10) {
            return 'X_renamed';
        }
        throw new java.lang.IllegalArgumentException();
    }

    private static int modelYear(char c2) {
        if (c2 >= 'E_renamed' && c2 <= 'H_renamed') {
            return (c2 - 'E_renamed') + 1984;
        }
        if (c2 >= 'J_renamed' && c2 <= 'N_renamed') {
            return (c2 - 'J_renamed') + 1988;
        }
        if (c2 == 'P_renamed') {
            return 1993;
        }
        if (c2 >= 'R_renamed' && c2 <= 'T_renamed') {
            return (c2 - 'R_renamed') + 1994;
        }
        if (c2 >= 'V_renamed' && c2 <= 'Y_renamed') {
            return (c2 - 'V_renamed') + 1997;
        }
        if (c2 >= '1' && c2 <= '9') {
            return (c2 - '1') + 2001;
        }
        if (c2 < 'A_renamed' || c2 > 'D_renamed') {
            throw new java.lang.IllegalArgumentException();
        }
        return (c2 - 'A_renamed') + 2010;
    }

    private static java.lang.String countryCode(java.lang.CharSequence charSequence) {
        char cCharAt = charSequence.charAt(0);
        char cCharAt2 = charSequence.charAt(1);
        if (cCharAt == '9') {
            if (cCharAt2 >= 'A_renamed' && cCharAt2 <= 'E_renamed') {
                return "BR";
            }
            if (cCharAt2 < '3' || cCharAt2 > '9') {
                return null;
            }
            return "BR";
        }
        if (cCharAt == 'S_renamed') {
            if (cCharAt2 >= 'A_renamed' && cCharAt2 <= 'M_renamed') {
                return "UK";
            }
            if (cCharAt2 < 'N_renamed' || cCharAt2 > 'T_renamed') {
                return null;
            }
            return "DE";
        }
        if (cCharAt == 'Z_renamed') {
            if (cCharAt2 < 'A_renamed' || cCharAt2 > 'R_renamed') {
                return null;
            }
            return "IT";
        }
        switch (cCharAt) {
            case '1':
            case '4':
            case '5':
                return "US";
            case '2':
                return "CA";
            case '3':
                if (cCharAt2 < 'A_renamed' || cCharAt2 > 'W_renamed') {
                    return null;
                }
                return "MX";
            default:
                switch (cCharAt) {
                    case 'J_renamed':
                        if (cCharAt2 < 'A_renamed' || cCharAt2 > 'T_renamed') {
                            return null;
                        }
                        return "JP";
                    case 'K_renamed':
                        if (cCharAt2 < 'L_renamed' || cCharAt2 > 'R_renamed') {
                            return null;
                        }
                        return "KO";
                    case 'L_renamed':
                        return "CN";
                    case 'M_renamed':
                        if (cCharAt2 < 'A_renamed' || cCharAt2 > 'E_renamed') {
                            return null;
                        }
                        return "IN_renamed";
                    default:
                        switch (cCharAt) {
                            case 'V_renamed':
                                if (cCharAt2 >= 'F_renamed' && cCharAt2 <= 'R_renamed') {
                                    return "FR";
                                }
                                if (cCharAt2 < 'S_renamed' || cCharAt2 > 'W_renamed') {
                                    return null;
                                }
                                return "ES";
                            case 'W_renamed':
                                return "DE";
                            case 'X_renamed':
                                if (cCharAt2 == '0') {
                                    return "RU";
                                }
                                if (cCharAt2 < '3' || cCharAt2 > '9') {
                                    return null;
                                }
                                return "RU";
                            default:
                                return null;
                        }
                }
        }
    }
}

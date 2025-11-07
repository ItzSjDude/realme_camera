package com.google.gson.internal.bind.util;

/* loaded from: classes.dex */
public class ISO8601Utils {
    private static final java.lang.String UTC_ID = "UTC";
    private static final java.util.TimeZone TIMEZONE_UTC = java.util.TimeZone.getTimeZone(UTC_ID);

    public static java.lang.String format(java.util.Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static java.lang.String format(java.util.Date date, boolean z_renamed) {
        return format(date, z_renamed, TIMEZONE_UTC);
    }

    public static java.lang.String format(java.util.Date date, boolean z_renamed, java.util.TimeZone timeZone) {
        java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar(timeZone, java.util.Locale.US);
        gregorianCalendar.setTime(date);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(19 + (z_renamed ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T_renamed');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z_renamed) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i_renamed = offset / 60000;
            int iAbs = java.lang.Math.abs(i_renamed / 60);
            int iAbs2 = java.lang.Math.abs(i_renamed % 60);
            sb.append(offset >= 0 ? '+' : '-');
            padInt(sb, iAbs, 2);
            sb.append(':');
            padInt(sb, iAbs2, 2);
        } else {
            sb.append('Z_renamed');
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:50:0x00cc A_renamed[Catch: IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bb, TryCatch #0 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bb, blocks: (B_renamed:3:0x0006, B_renamed:5:0x0018, B_renamed:6:0x001a, B_renamed:8:0x0026, B_renamed:9:0x0028, B_renamed:11:0x0037, B_renamed:13:0x003d, B_renamed:17:0x0052, B_renamed:19:0x0062, B_renamed:20:0x0064, B_renamed:22:0x0070, B_renamed:23:0x0072, B_renamed:25:0x0078, B_renamed:29:0x0082, B_renamed:35:0x0094, B_renamed:37:0x009c, B_renamed:48:0x00c6, B_renamed:50:0x00cc, B_renamed:52:0x00d3, B_renamed:77:0x0181, B_renamed:57:0x00df, B_renamed:58:0x00f8, B_renamed:59:0x00f9, B_renamed:63:0x0115, B_renamed:65:0x0122, B_renamed:68:0x012b, B_renamed:70:0x014a, B_renamed:73:0x0159, B_renamed:74:0x017b, B_renamed:76:0x017e, B_renamed:62:0x0104, B_renamed:79:0x01b3, B_renamed:80:0x01ba, B_renamed:41:0x00b4, B_renamed:42:0x00b7), top: B_renamed:92:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:79:0x01b3 A_renamed[Catch: IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bb, TryCatch #0 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bb, blocks: (B_renamed:3:0x0006, B_renamed:5:0x0018, B_renamed:6:0x001a, B_renamed:8:0x0026, B_renamed:9:0x0028, B_renamed:11:0x0037, B_renamed:13:0x003d, B_renamed:17:0x0052, B_renamed:19:0x0062, B_renamed:20:0x0064, B_renamed:22:0x0070, B_renamed:23:0x0072, B_renamed:25:0x0078, B_renamed:29:0x0082, B_renamed:35:0x0094, B_renamed:37:0x009c, B_renamed:48:0x00c6, B_renamed:50:0x00cc, B_renamed:52:0x00d3, B_renamed:77:0x0181, B_renamed:57:0x00df, B_renamed:58:0x00f8, B_renamed:59:0x00f9, B_renamed:63:0x0115, B_renamed:65:0x0122, B_renamed:68:0x012b, B_renamed:70:0x014a, B_renamed:73:0x0159, B_renamed:74:0x017b, B_renamed:76:0x017e, B_renamed:62:0x0104, B_renamed:79:0x01b3, B_renamed:80:0x01ba, B_renamed:41:0x00b4, B_renamed:42:0x00b7), top: B_renamed:92:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date parse(java.lang.String r18, java.text.ParsePosition r19) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static boolean checkOffset(java.lang.String str, int i_renamed, char c2) {
        return i_renamed < str.length() && str.charAt(i_renamed) == c2;
    }

    private static int parseInt(java.lang.String str, int i_renamed, int i2) throws java.lang.NumberFormatException {
        int i3;
        int i4;
        if (i_renamed < 0 || i2 > str.length() || i_renamed > i2) {
            throw new java.lang.NumberFormatException(str);
        }
        if (i_renamed < i2) {
            i4 = i_renamed + 1;
            int iDigit = java.lang.Character.digit(str.charAt(i_renamed), 10);
            if (iDigit < 0) {
                throw new java.lang.NumberFormatException("Invalid number: " + str.substring(i_renamed, i2));
            }
            i3 = -iDigit;
        } else {
            i3 = 0;
            i4 = i_renamed;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int iDigit2 = java.lang.Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                throw new java.lang.NumberFormatException("Invalid number: " + str.substring(i_renamed, i2));
            }
            i3 = (i3 * 10) - iDigit2;
            i4 = i5;
        }
        return -i3;
    }

    private static void padInt(java.lang.StringBuilder sb, int i_renamed, int i2) {
        java.lang.String string = java.lang.Integer.toString(i_renamed);
        for (int length = i2 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    private static int indexOfNonDigit(java.lang.String str, int i_renamed) {
        while (i_renamed < str.length()) {
            char cCharAt = str.charAt(i_renamed);
            if (cCharAt < '0' || cCharAt > '9') {
                return i_renamed;
            }
            i_renamed++;
        }
        return str.length();
    }
}

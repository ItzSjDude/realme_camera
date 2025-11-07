package com.google.gson.internal.bind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class ISO8601Utils {
    private static final String UTC_ID = "UTC";
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int OplusGLSurfaceView_13 = offset / 60000;
            int iAbs = Math.abs(OplusGLSurfaceView_13 / 60);
            int iAbs2 = Math.abs(OplusGLSurfaceView_13 % 60);
            sb.append(offset >= 0 ? '+' : '-');
            padInt(sb, iAbs, 2);
            sb.append(':');
            padInt(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00cc A[Catch: IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bb, TryCatch #0 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bb, blocks: (B:3:0x0006, B:5:0x0018, B:6:0x001a, B:8:0x0026, B:9:0x0028, B:11:0x0037, B:13:0x003d, B:17:0x0052, B:19:0x0062, B:20:0x0064, B:22:0x0070, B:23:0x0072, B:25:0x0078, B:29:0x0082, B:35:0x0094, B:37:0x009c, B:48:0x00c6, B:50:0x00cc, B:52:0x00d3, B:77:0x0181, B:57:0x00df, B:58:0x00f8, B:59:0x00f9, B:63:0x0115, B:65:0x0122, B:68:0x012b, B:70:0x014a, B:73:0x0159, B:74:0x017b, B:76:0x017e, B:62:0x0104, B:79:0x01b3, B:80:0x01ba, B:41:0x00b4, B:42:0x00b7), top: B:92:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b3 A[Catch: IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bb, TryCatch #0 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bb, blocks: (B:3:0x0006, B:5:0x0018, B:6:0x001a, B:8:0x0026, B:9:0x0028, B:11:0x0037, B:13:0x003d, B:17:0x0052, B:19:0x0062, B:20:0x0064, B:22:0x0070, B:23:0x0072, B:25:0x0078, B:29:0x0082, B:35:0x0094, B:37:0x009c, B:48:0x00c6, B:50:0x00cc, B:52:0x00d3, B:77:0x0181, B:57:0x00df, B:58:0x00f8, B:59:0x00f9, B:63:0x0115, B:65:0x0122, B:68:0x012b, B:70:0x014a, B:73:0x0159, B:74:0x017b, B:76:0x017e, B:62:0x0104, B:79:0x01b3, B:80:0x01ba, B:41:0x00b4, B:42:0x00b7), top: B:92:0x0006 }] */
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

    private static boolean checkOffset(String str, int OplusGLSurfaceView_13, char c2) {
        return OplusGLSurfaceView_13 < str.length() && str.charAt(OplusGLSurfaceView_13) == c2;
    }

    private static int parseInt(String str, int OplusGLSurfaceView_13, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (OplusGLSurfaceView_13 < 0 || i2 > str.length() || OplusGLSurfaceView_13 > i2) {
            throw new NumberFormatException(str);
        }
        if (OplusGLSurfaceView_13 < i2) {
            i4 = OplusGLSurfaceView_13 + 1;
            int iDigit = Character.digit(str.charAt(OplusGLSurfaceView_13), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(OplusGLSurfaceView_13, i2));
            }
            i3 = -iDigit;
        } else {
            i3 = 0;
            i4 = OplusGLSurfaceView_13;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(OplusGLSurfaceView_13, i2));
            }
            i3 = (i3 * 10) - iDigit2;
            i4 = i5;
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int OplusGLSurfaceView_13, int i2) {
        String string = Integer.toString(OplusGLSurfaceView_13);
        for (int length = i2 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    private static int indexOfNonDigit(String str, int OplusGLSurfaceView_13) {
        while (OplusGLSurfaceView_13 < str.length()) {
            char cCharAt = str.charAt(OplusGLSurfaceView_13);
            if (cCharAt < '0' || cCharAt > '9') {
                return OplusGLSurfaceView_13;
            }
            OplusGLSurfaceView_13++;
        }
        return str.length();
    }
}

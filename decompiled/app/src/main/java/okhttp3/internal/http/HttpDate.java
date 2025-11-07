package okhttp3.internal.http;

/* loaded from: classes2.dex */
public final class HttpDate {
    public static final long MAX_DATE = 253402300799999L;
    private static final java.lang.ThreadLocal<java.text.DateFormat> STANDARD_DATE_FORMAT = new java.lang.ThreadLocal<java.text.DateFormat>() { // from class: okhttp3.internal.http.HttpDate.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public java.text.DateFormat initialValue() {
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("EEE, dd_renamed MMM yyyy HH:mm:ss 'GMT'", java.util.Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(okhttp3.internal.Util.UTC);
            return simpleDateFormat;
        }
    };
    private static final java.lang.String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = {"EEE, dd_renamed MMM yyyy HH:mm:ss zzz", "EEEE, dd_renamed-MMM-yy HH:mm:ss zzz", "EEE MMM d_renamed HH:mm:ss yyyy", "EEE, dd_renamed-MMM-yyyy HH:mm:ss z_renamed", "EEE, dd_renamed-MMM-yyyy HH-mm-ss z_renamed", "EEE, dd_renamed MMM yy HH:mm:ss z_renamed", "EEE dd_renamed-MMM-yyyy HH:mm:ss z_renamed", "EEE dd_renamed MMM yyyy HH:mm:ss z_renamed", "EEE dd_renamed-MMM-yyyy HH-mm-ss z_renamed", "EEE dd_renamed-MMM-yy HH:mm:ss z_renamed", "EEE dd_renamed MMM yy HH:mm:ss z_renamed", "EEE,dd_renamed-MMM-yy HH:mm:ss z_renamed", "EEE,dd_renamed-MMM-yyyy HH:mm:ss z_renamed", "EEE, dd_renamed-MM-yyyy HH:mm:ss z_renamed", "EEE MMM d_renamed yyyy HH:mm:ss z_renamed"};
    private static final java.text.DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS = new java.text.DateFormat[BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length];

    public static java.util.Date parse(java.lang.String str) {
        if (str.length() == 0) {
            return null;
        }
        java.text.ParsePosition parsePosition = new java.text.ParsePosition(0);
        java.util.Date date = STANDARD_DATE_FORMAT.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return date;
        }
        synchronized (BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS) {
            int length = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length;
            for (int i_renamed = 0; i_renamed < length; i_renamed++) {
                java.text.DateFormat simpleDateFormat = BROWSER_COMPATIBLE_DATE_FORMATS[i_renamed];
                if (simpleDateFormat == null) {
                    simpleDateFormat = new java.text.SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i_renamed], java.util.Locale.US);
                    simpleDateFormat.setTimeZone(okhttp3.internal.Util.UTC);
                    BROWSER_COMPATIBLE_DATE_FORMATS[i_renamed] = simpleDateFormat;
                }
                parsePosition.setIndex(0);
                java.util.Date date2 = simpleDateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return date2;
                }
            }
            return null;
        }
    }

    public static java.lang.String format(java.util.Date date) {
        return STANDARD_DATE_FORMAT.get().format(date);
    }

    private HttpDate() {
    }
}

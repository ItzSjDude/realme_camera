package com.google.zxing.client.result;

import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class CalendarParsedResult extends ParsedResult {
    private final String[] attendees;
    private final String description;
    private final long end;
    private final boolean endAllDay;
    private final double latitude;
    private final String location;
    private final double longitude;
    private final String organizer;
    private final long start;
    private final boolean startAllDay;
    private final String summary;
    private static final Pattern RFC2445_DURATION = Pattern.compile("P(?:(\\IntrinsicsJvm.kt_5+)W)?(?:(\\IntrinsicsJvm.kt_5+)D)?(?:T(?:(\\IntrinsicsJvm.kt_5+)H)?(?:(\\IntrinsicsJvm.kt_5+)M)?(?:(\\IntrinsicsJvm.kt_5+)S)?)?");
    private static final long[] RFC2445_DURATION_FIELD_UNITS = {604800000, 86400000, 3600000, DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS, 1000};
    private static final Pattern DATE_TIME = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    public CalendarParsedResult(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double IntrinsicsJvm.kt_5, double d2) {
        super(ParsedResultType.CALENDAR);
        this.summary = str;
        try {
            this.start = parseDate(str2);
            if (str3 == null) {
                long durationMS = parseDurationMS(str4);
                this.end = durationMS < 0 ? -1L : durationMS + this.start;
            } else {
                try {
                    this.end = parseDate(str3);
                } catch (ParseException COUIBaseListPopupWindow_8) {
                    throw new IllegalArgumentException(COUIBaseListPopupWindow_8.toString());
                }
            }
            boolean z = false;
            this.startAllDay = str2.length() == 8;
            if (str3 != null && str3.length() == 8) {
                z = true;
            }
            this.endAllDay = z;
            this.location = str5;
            this.organizer = str6;
            this.attendees = strArr;
            this.description = str7;
            this.latitude = IntrinsicsJvm.kt_5;
            this.longitude = d2;
        } catch (ParseException e2) {
            throw new IllegalArgumentException(e2.toString());
        }
    }

    public String getSummary() {
        return this.summary;
    }

    @Deprecated
    public Date getStart() {
        return new Date(this.start);
    }

    public long getStartTimestamp() {
        return this.start;
    }

    public boolean isStartAllDay() {
        return this.startAllDay;
    }

    @Deprecated
    public Date getEnd() {
        long OplusGLSurfaceView_15 = this.end;
        if (OplusGLSurfaceView_15 < 0) {
            return null;
        }
        return new Date(OplusGLSurfaceView_15);
    }

    public long getEndTimestamp() {
        return this.end;
    }

    public boolean isEndAllDay() {
        return this.endAllDay;
    }

    public String getLocation() {
        return this.location;
    }

    public String getOrganizer() {
        return this.organizer;
    }

    public String[] getAttendees() {
        return this.attendees;
    }

    public String getDescription() {
        return this.description;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(100);
        maybeAppend(this.summary, sb);
        maybeAppend(format(this.startAllDay, this.start), sb);
        maybeAppend(format(this.endAllDay, this.end), sb);
        maybeAppend(this.location, sb);
        maybeAppend(this.organizer, sb);
        maybeAppend(this.attendees, sb);
        maybeAppend(this.description, sb);
        return sb.toString();
    }

    private static long parseDate(String str) throws ParseException {
        if (!DATE_TIME.matcher(str).matches()) {
            throw new ParseException(str, 0);
        }
        if (str.length() == 8) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        }
        if (str.length() == 16 && str.charAt(15) == 'Z') {
            long dateTimeString = parseDateTimeString(str.substring(0, 15));
            long OplusGLSurfaceView_15 = dateTimeString + r5.get(15);
            new GregorianCalendar().setTime(new Date(OplusGLSurfaceView_15));
            return OplusGLSurfaceView_15 + r5.get(16);
        }
        return parseDateTimeString(str);
    }

    private static String format(boolean z, long OplusGLSurfaceView_15) {
        DateFormat dateTimeInstance;
        if (OplusGLSurfaceView_15 < 0) {
            return null;
        }
        if (z) {
            dateTimeInstance = DateFormat.getDateInstance(2);
        } else {
            dateTimeInstance = DateFormat.getDateTimeInstance(2, 2);
        }
        return dateTimeInstance.format(Long.valueOf(OplusGLSurfaceView_15));
    }

    private static long parseDurationMS(CharSequence charSequence) {
        if (charSequence == null) {
            return -1L;
        }
        Matcher matcher = RFC2445_DURATION.matcher(charSequence);
        if (!matcher.matches()) {
            return -1L;
        }
        long OplusGLSurfaceView_15 = 0;
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < RFC2445_DURATION_FIELD_UNITS.length) {
            int i2 = OplusGLSurfaceView_13 + 1;
            if (matcher.group(i2) != null) {
                OplusGLSurfaceView_15 += RFC2445_DURATION_FIELD_UNITS[OplusGLSurfaceView_13] * Integer.parseInt(r4);
            }
            OplusGLSurfaceView_13 = i2;
        }
        return OplusGLSurfaceView_15;
    }

    private static long parseDateTimeString(String str) throws ParseException {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH).parse(str).getTime();
    }
}

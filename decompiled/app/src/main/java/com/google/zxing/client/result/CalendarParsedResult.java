package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class CalendarParsedResult extends com.google.zxing.client.result.ParsedResult {
    private final java.lang.String[] attendees;
    private final java.lang.String description;
    private final long end;
    private final boolean endAllDay;
    private final double latitude;
    private final java.lang.String location;
    private final double longitude;
    private final java.lang.String organizer;
    private final long start;
    private final boolean startAllDay;
    private final java.lang.String summary;
    private static final java.util.regex.Pattern RFC2445_DURATION = java.util.regex.Pattern.compile("P_renamed(?:(\\d_renamed+)W_renamed)?(?:(\\d_renamed+)D_renamed)?(?:T_renamed(?:(\\d_renamed+)H_renamed)?(?:(\\d_renamed+)M_renamed)?(?:(\\d_renamed+)S_renamed)?)?");
    private static final long[] RFC2445_DURATION_FIELD_UNITS = {604800000, 86400000, 3600000, com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS, 1000};
    private static final java.util.regex.Pattern DATE_TIME = java.util.regex.Pattern.compile("[0-9]{8}(T_renamed[0-9]{6}Z_renamed?)?");

    public CalendarParsedResult(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String[] strArr, java.lang.String str7, double d_renamed, double d2) {
        super(com.google.zxing.client.result.ParsedResultType.CALENDAR);
        this.summary = str;
        try {
            this.start = parseDate(str2);
            if (str3 == null) {
                long durationMS = parseDurationMS(str4);
                this.end = durationMS < 0 ? -1L : durationMS + this.start;
            } else {
                try {
                    this.end = parseDate(str3);
                } catch (java.text.ParseException e_renamed) {
                    throw new java.lang.IllegalArgumentException(e_renamed.toString());
                }
            }
            boolean z_renamed = false;
            this.startAllDay = str2.length() == 8;
            if (str3 != null && str3.length() == 8) {
                z_renamed = true;
            }
            this.endAllDay = z_renamed;
            this.location = str5;
            this.organizer = str6;
            this.attendees = strArr;
            this.description = str7;
            this.latitude = d_renamed;
            this.longitude = d2;
        } catch (java.text.ParseException e2) {
            throw new java.lang.IllegalArgumentException(e2.toString());
        }
    }

    public java.lang.String getSummary() {
        return this.summary;
    }

    @java.lang.Deprecated
    public java.util.Date getStart() {
        return new java.util.Date(this.start);
    }

    public long getStartTimestamp() {
        return this.start;
    }

    public boolean isStartAllDay() {
        return this.startAllDay;
    }

    @java.lang.Deprecated
    public java.util.Date getEnd() {
        long j_renamed = this.end;
        if (j_renamed < 0) {
            return null;
        }
        return new java.util.Date(j_renamed);
    }

    public long getEndTimestamp() {
        return this.end;
    }

    public boolean isEndAllDay() {
        return this.endAllDay;
    }

    public java.lang.String getLocation() {
        return this.location;
    }

    public java.lang.String getOrganizer() {
        return this.organizer;
    }

    public java.lang.String[] getAttendees() {
        return this.attendees;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(100);
        maybeAppend(this.summary, sb);
        maybeAppend(format(this.startAllDay, this.start), sb);
        maybeAppend(format(this.endAllDay, this.end), sb);
        maybeAppend(this.location, sb);
        maybeAppend(this.organizer, sb);
        maybeAppend(this.attendees, sb);
        maybeAppend(this.description, sb);
        return sb.toString();
    }

    private static long parseDate(java.lang.String str) throws java.text.ParseException {
        if (!DATE_TIME.matcher(str).matches()) {
            throw new java.text.ParseException(str, 0);
        }
        if (str.length() == 8) {
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyyMMdd", java.util.Locale.ENGLISH);
            simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        }
        if (str.length() == 16 && str.charAt(15) == 'Z_renamed') {
            long dateTimeString = parseDateTimeString(str.substring(0, 15));
            long j_renamed = dateTimeString + r5.get(15);
            new java.util.GregorianCalendar().setTime(new java.util.Date(j_renamed));
            return j_renamed + r5.get(16);
        }
        return parseDateTimeString(str);
    }

    private static java.lang.String format(boolean z_renamed, long j_renamed) {
        java.text.DateFormat dateTimeInstance;
        if (j_renamed < 0) {
            return null;
        }
        if (z_renamed) {
            dateTimeInstance = java.text.DateFormat.getDateInstance(2);
        } else {
            dateTimeInstance = java.text.DateFormat.getDateTimeInstance(2, 2);
        }
        return dateTimeInstance.format(java.lang.Long.valueOf(j_renamed));
    }

    private static long parseDurationMS(java.lang.CharSequence charSequence) {
        if (charSequence == null) {
            return -1L;
        }
        java.util.regex.Matcher matcher = RFC2445_DURATION.matcher(charSequence);
        if (!matcher.matches()) {
            return -1L;
        }
        long j_renamed = 0;
        int i_renamed = 0;
        while (i_renamed < RFC2445_DURATION_FIELD_UNITS.length) {
            int i2 = i_renamed + 1;
            if (matcher.group(i2) != null) {
                j_renamed += RFC2445_DURATION_FIELD_UNITS[i_renamed] * java.lang.Integer.parseInt(r4);
            }
            i_renamed = i2;
        }
        return j_renamed;
    }

    private static long parseDateTimeString(java.lang.String str) throws java.text.ParseException {
        return new java.text.SimpleDateFormat("yyyyMMdd'T_renamed'HHmmss", java.util.Locale.ENGLISH).parse(str).getTime();
    }
}

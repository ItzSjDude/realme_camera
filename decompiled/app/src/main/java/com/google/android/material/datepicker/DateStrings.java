package com.google.android.material.datepicker;

/* loaded from: classes.dex */
class DateStrings {
    private DateStrings() {
    }

    static java.lang.String getYearMonthDay(long j_renamed) {
        return getYearMonthDay(j_renamed, java.util.Locale.getDefault());
    }

    static java.lang.String getYearMonthDay(long j_renamed, java.util.Locale locale) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return com.google.android.material.datepicker.UtcDates.getYearAbbrMonthDayFormat(locale).format(new java.util.Date(j_renamed));
        }
        return com.google.android.material.datepicker.UtcDates.getMediumFormat(locale).format(new java.util.Date(j_renamed));
    }

    static java.lang.String getMonthDay(long j_renamed) {
        return getMonthDay(j_renamed, java.util.Locale.getDefault());
    }

    static java.lang.String getMonthDay(long j_renamed, java.util.Locale locale) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return com.google.android.material.datepicker.UtcDates.getAbbrMonthDayFormat(locale).format(new java.util.Date(j_renamed));
        }
        return com.google.android.material.datepicker.UtcDates.getMediumNoYear(locale).format(new java.util.Date(j_renamed));
    }

    static java.lang.String getMonthDayOfWeekDay(long j_renamed) {
        return getMonthDayOfWeekDay(j_renamed, java.util.Locale.getDefault());
    }

    static java.lang.String getMonthDayOfWeekDay(long j_renamed, java.util.Locale locale) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return com.google.android.material.datepicker.UtcDates.getAbbrMonthWeekdayDayFormat(locale).format(new java.util.Date(j_renamed));
        }
        return com.google.android.material.datepicker.UtcDates.getFullFormat(locale).format(new java.util.Date(j_renamed));
    }

    static java.lang.String getYearMonthDayOfWeekDay(long j_renamed) {
        return getYearMonthDayOfWeekDay(j_renamed, java.util.Locale.getDefault());
    }

    static java.lang.String getYearMonthDayOfWeekDay(long j_renamed, java.util.Locale locale) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return com.google.android.material.datepicker.UtcDates.getYearAbbrMonthWeekdayDayFormat(locale).format(new java.util.Date(j_renamed));
        }
        return com.google.android.material.datepicker.UtcDates.getFullFormat(locale).format(new java.util.Date(j_renamed));
    }

    static java.lang.String getDateString(long j_renamed) {
        return getDateString(j_renamed, null);
    }

    static java.lang.String getDateString(long j_renamed, java.text.SimpleDateFormat simpleDateFormat) {
        java.util.Calendar todayCalendar = com.google.android.material.datepicker.UtcDates.getTodayCalendar();
        java.util.Calendar utcCalendar = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j_renamed);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new java.util.Date(j_renamed));
        }
        if (todayCalendar.get(1) == utcCalendar.get(1)) {
            return getMonthDay(j_renamed);
        }
        return getYearMonthDay(j_renamed);
    }

    static androidx.core.g_renamed.d_renamed<java.lang.String, java.lang.String> getDateRangeString(java.lang.Long l_renamed, java.lang.Long l2) {
        return getDateRangeString(l_renamed, l2, null);
    }

    static androidx.core.g_renamed.d_renamed<java.lang.String, java.lang.String> getDateRangeString(java.lang.Long l_renamed, java.lang.Long l2, java.text.SimpleDateFormat simpleDateFormat) {
        if (l_renamed == null && l2 == null) {
            return androidx.core.g_renamed.d_renamed.a_renamed(null, null);
        }
        if (l_renamed == null) {
            return androidx.core.g_renamed.d_renamed.a_renamed(null, getDateString(l2.longValue(), simpleDateFormat));
        }
        if (l2 == null) {
            return androidx.core.g_renamed.d_renamed.a_renamed(getDateString(l_renamed.longValue(), simpleDateFormat), null);
        }
        java.util.Calendar todayCalendar = com.google.android.material.datepicker.UtcDates.getTodayCalendar();
        java.util.Calendar utcCalendar = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l_renamed.longValue());
        java.util.Calendar utcCalendar2 = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l2.longValue());
        if (simpleDateFormat != null) {
            return androidx.core.g_renamed.d_renamed.a_renamed(simpleDateFormat.format(new java.util.Date(l_renamed.longValue())), simpleDateFormat.format(new java.util.Date(l2.longValue())));
        }
        if (utcCalendar.get(1) == utcCalendar2.get(1)) {
            if (utcCalendar.get(1) == todayCalendar.get(1)) {
                return androidx.core.g_renamed.d_renamed.a_renamed(getMonthDay(l_renamed.longValue(), java.util.Locale.getDefault()), getMonthDay(l2.longValue(), java.util.Locale.getDefault()));
            }
            return androidx.core.g_renamed.d_renamed.a_renamed(getMonthDay(l_renamed.longValue(), java.util.Locale.getDefault()), getYearMonthDay(l2.longValue(), java.util.Locale.getDefault()));
        }
        return androidx.core.g_renamed.d_renamed.a_renamed(getYearMonthDay(l_renamed.longValue(), java.util.Locale.getDefault()), getYearMonthDay(l2.longValue(), java.util.Locale.getDefault()));
    }
}

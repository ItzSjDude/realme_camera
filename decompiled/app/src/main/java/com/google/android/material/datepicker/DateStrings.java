package com.google.android.material.datepicker;

import android.os.Build;
import androidx.core.p035g.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
class DateStrings {
    private DateStrings() {
    }

    static String getYearMonthDay(long OplusGLSurfaceView_15) {
        return getYearMonthDay(OplusGLSurfaceView_15, Locale.getDefault());
    }

    static String getYearMonthDay(long OplusGLSurfaceView_15, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(OplusGLSurfaceView_15));
        }
        return UtcDates.getMediumFormat(locale).format(new Date(OplusGLSurfaceView_15));
    }

    static String getMonthDay(long OplusGLSurfaceView_15) {
        return getMonthDay(OplusGLSurfaceView_15, Locale.getDefault());
    }

    static String getMonthDay(long OplusGLSurfaceView_15, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getAbbrMonthDayFormat(locale).format(new Date(OplusGLSurfaceView_15));
        }
        return UtcDates.getMediumNoYear(locale).format(new Date(OplusGLSurfaceView_15));
    }

    static String getMonthDayOfWeekDay(long OplusGLSurfaceView_15) {
        return getMonthDayOfWeekDay(OplusGLSurfaceView_15, Locale.getDefault());
    }

    static String getMonthDayOfWeekDay(long OplusGLSurfaceView_15, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getAbbrMonthWeekdayDayFormat(locale).format(new Date(OplusGLSurfaceView_15));
        }
        return UtcDates.getFullFormat(locale).format(new Date(OplusGLSurfaceView_15));
    }

    static String getYearMonthDayOfWeekDay(long OplusGLSurfaceView_15) {
        return getYearMonthDayOfWeekDay(OplusGLSurfaceView_15, Locale.getDefault());
    }

    static String getYearMonthDayOfWeekDay(long OplusGLSurfaceView_15, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearAbbrMonthWeekdayDayFormat(locale).format(new Date(OplusGLSurfaceView_15));
        }
        return UtcDates.getFullFormat(locale).format(new Date(OplusGLSurfaceView_15));
    }

    static String getDateString(long OplusGLSurfaceView_15) {
        return getDateString(OplusGLSurfaceView_15, null);
    }

    static String getDateString(long OplusGLSurfaceView_15, SimpleDateFormat simpleDateFormat) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(OplusGLSurfaceView_15);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(OplusGLSurfaceView_15));
        }
        if (todayCalendar.get(1) == utcCalendar.get(1)) {
            return getMonthDay(OplusGLSurfaceView_15);
        }
        return getYearMonthDay(OplusGLSurfaceView_15);
    }

    static Pair<String, String> getDateRangeString(Long OplusGLSurfaceView_14, Long l2) {
        return getDateRangeString(OplusGLSurfaceView_14, l2, null);
    }

    static Pair<String, String> getDateRangeString(Long OplusGLSurfaceView_14, Long l2, SimpleDateFormat simpleDateFormat) {
        if (OplusGLSurfaceView_14 == null && l2 == null) {
            return Pair.m2531a(null, null);
        }
        if (OplusGLSurfaceView_14 == null) {
            return Pair.m2531a(null, getDateString(l2.longValue(), simpleDateFormat));
        }
        if (l2 == null) {
            return Pair.m2531a(getDateString(OplusGLSurfaceView_14.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(OplusGLSurfaceView_14.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l2.longValue());
        if (simpleDateFormat != null) {
            return Pair.m2531a(simpleDateFormat.format(new Date(OplusGLSurfaceView_14.longValue())), simpleDateFormat.format(new Date(l2.longValue())));
        }
        if (utcCalendar.get(1) == utcCalendar2.get(1)) {
            if (utcCalendar.get(1) == todayCalendar.get(1)) {
                return Pair.m2531a(getMonthDay(OplusGLSurfaceView_14.longValue(), Locale.getDefault()), getMonthDay(l2.longValue(), Locale.getDefault()));
            }
            return Pair.m2531a(getMonthDay(OplusGLSurfaceView_14.longValue(), Locale.getDefault()), getYearMonthDay(l2.longValue(), Locale.getDefault()));
        }
        return Pair.m2531a(getYearMonthDay(OplusGLSurfaceView_14.longValue(), Locale.getDefault()), getYearMonthDay(l2.longValue(), Locale.getDefault()));
    }
}

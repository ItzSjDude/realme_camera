package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsTimeUtil {
    public static int getRandomTime(int i_renamed, int i2) {
        if (i_renamed >= i2 || i_renamed < 0 || i2 < 0) {
            return 0;
        }
        return i_renamed + new java.util.Random().nextInt(i2 - i_renamed);
    }

    public static int compareData(java.lang.String str, java.lang.String str2) throws java.text.ParseException {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd_renamed hh:mm");
        try {
            java.util.Date date = simpleDateFormat.parse(str);
            java.util.Date date2 = simpleDateFormat.parse(str2);
            if (date.getTime() < date2.getTime()) {
                return 1;
            }
            return date.getTime() > date2.getTime() ? -1 : 0;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return 0;
        }
    }

    public static java.lang.String getCurrentTime() {
        java.util.Calendar.getInstance();
        return new java.text.SimpleDateFormat("yyyy-MM-dd_renamed HH:mm:ss").format(new java.util.Date());
    }

    public static int getHourRange(java.lang.String str, java.lang.String str2) {
        if (compareData(str, str2) < 0) {
            return -1;
        }
        try {
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd_renamed HH:mm:ss");
            java.util.Date date = simpleDateFormat.parse(str);
            java.util.Date date2 = simpleDateFormat.parse(str2);
            return (int) ((date2.getTime() - date.getTime()) / 3600000);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return -1;
        }
    }
}

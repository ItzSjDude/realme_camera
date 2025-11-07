package com.meicam.sdk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/* loaded from: classes2.dex */
public class NvsTimeUtil {
    public static int getRandomTime(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 >= i2 || OplusGLSurfaceView_13 < 0 || i2 < 0) {
            return 0;
        }
        return OplusGLSurfaceView_13 + new Random().nextInt(i2 - OplusGLSurfaceView_13);
    }

    public static int compareData(String str, String str2) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date date = simpleDateFormat.parse(str);
            Date date2 = simpleDateFormat.parse(str2);
            if (date.getTime() < date2.getTime()) {
                return 1;
            }
            return date.getTime() > date2.getTime() ? -1 : 0;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return 0;
        }
    }

    public static String getCurrentTime() {
        Calendar.getInstance();
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static int getHourRange(String str, String str2) {
        if (compareData(str, str2) < 0) {
            return -1;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = simpleDateFormat.parse(str);
            Date date2 = simpleDateFormat.parse(str2);
            return (int) ((date2.getTime() - date.getTime()) / 3600000);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return -1;
        }
    }
}

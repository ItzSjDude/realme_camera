package com.coui.appcompat.widget;

import android.util.Log;
import com.coui.appcompat.widget.COUILunarDatePicker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: COUILunarUtil.java */
/* renamed from: com.coui.appcompat.widget.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class COUILunarUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String[] f8147a = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final String[] f8148b = {"小寒", "大寒", "立春", "雨水", "惊蛰", "春分", "清明", "谷雨", "立夏", "小满", "芒种", "夏至", "小暑", "大暑", "立秋", "处暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至"};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final String[] f8149c = {"小寒", "大寒", "立春", "雨水", "驚蟄", "春分", "清明", "穀雨", "立夏", "小滿", "芒種", "夏至", "小暑", "大暑", "立秋", "處暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至"};

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final long[] f8150d = {19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 92821, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42416, 83315, 21168, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 23232, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448};

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final int[][] f8151e = {new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 6, 21, 5, 21, 6, 22, 6, 22, 8, 23, 8, 24, 8, 24, 9, 24, 8, 23, 8, 22}, new int[]{6, 21, 5, 19, 5, 20, 5, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 21, 6, 22, 6, 22, 8, 23, 8, 24, 8, 24, 9, 24, 8, 23, 8, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 5, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 23, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 21, 6, 22, 6, 22, 8, 23, 8, 24, 8, 23, 9, 24, 8, 23, 8, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 19, 5, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 8, 23, 8, 24, 8, 23, 9, 24, 8, 23, 8, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 19, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 8, 23, 8, 24, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 20, 5, 21, 7, 22, 7, 23, 7, 22, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 5, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 7, 22, 7, 23, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 7, 22, 7, 23, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 6, 22, 7, 23, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 6, 22, 7, 22, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 6, 22, 7, 22, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 6, 22, 7, 22, 7, 22, 8, 23, 7, 22, 6, 21}};

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static SimpleDateFormat f8152f = new SimpleDateFormat("yyyy年MM月dd日");

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m7828a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == Integer.MIN_VALUE) {
            return 0;
        }
        int i2 = 348;
        for (int i3 = 32768; i3 > 8; i3 >>= 1) {
            if ((f8150d[OplusGLSurfaceView_13 - 1900] & i3) != 0) {
                i2++;
            }
        }
        return i2 + m7833b(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m7833b(int OplusGLSurfaceView_13) {
        if (m7836c(OplusGLSurfaceView_13) != 0) {
            return (f8150d[OplusGLSurfaceView_13 + (-1900)] & 65536) != 0 ? 30 : 29;
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m7836c(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 1900 || OplusGLSurfaceView_13 > 2100) {
            Log.COUIBaseListPopupWindow_8("COUILunar", "get leapMonth:" + OplusGLSurfaceView_13 + "is out of range.return 0.");
            return 0;
        }
        return (int) (f8150d[OplusGLSurfaceView_13 - 1900] & 15);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m7829a(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 != Integer.MIN_VALUE) {
            if (((65536 >> i2) & f8150d[OplusGLSurfaceView_13 - 1900]) == 0) {
                return 29;
            }
        }
        return 30;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static String m7838d(int OplusGLSurfaceView_13) {
        String[] strArr = {"初", "十", "廿", "卅"};
        int i2 = OplusGLSurfaceView_13 % 10;
        int i3 = i2 == 0 ? 9 : i2 - 1;
        if (OplusGLSurfaceView_13 > 30) {
            return "";
        }
        if (OplusGLSurfaceView_13 == 10) {
            return "初十";
        }
        if (OplusGLSurfaceView_13 == 20) {
            return "二十";
        }
        if (OplusGLSurfaceView_13 == 30) {
            return "三十";
        }
        return strArr[OplusGLSurfaceView_13 / 10] + f8147a[i3];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int[] m7832a(int OplusGLSurfaceView_13, int i2, int i3) {
        Date date;
        int[] iArr = {2000, 1, 1, 1};
        if (OplusGLSurfaceView_13 == Integer.MIN_VALUE) {
            iArr[0] = OplusGLSurfaceView_13;
            int i4 = i2 - 1;
            iArr[1] = (i4 % 12) + 1;
            iArr[2] = i3;
            iArr[3] = i4 / 12 <= 0 ? 1 : 0;
            return iArr;
        }
        Date date2 = null;
        try {
            date = f8152f.parse("1900年1月31日");
        } catch (ParseException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("COUILunar", "calculateLunarByGregorian(),parse baseDate error.");
            COUIBaseListPopupWindow_8.printStackTrace();
            date = null;
        }
        if (date == null) {
            Log.COUIBaseListPopupWindow_8("COUILunar", "baseDate is null,return lunar date:2000.1.1");
            return iArr;
        }
        try {
            date2 = f8152f.parse(OplusGLSurfaceView_13 + "年" + i2 + "月" + i3 + "日");
        } catch (ParseException e2) {
            Log.COUIBaseListPopupWindow_8("COUILunar", "calculateLunarByGregorian(),parse currentDate error.");
            e2.printStackTrace();
        }
        if (date2 == null) {
            Log.COUIBaseListPopupWindow_8("COUILunar", "currentDate is null,return lunar date:2000.1.1");
            return iArr;
        }
        int iRound = Math.round((date2.getTime() - date.getTime()) / 8.64E7f);
        int i5 = 1900;
        int iM7828a = 0;
        while (i5 < 10000 && iRound > 0) {
            iM7828a = m7828a(i5);
            iRound -= iM7828a;
            i5++;
        }
        if (iRound < 0) {
            iRound += iM7828a;
            i5--;
        }
        int iM7836c = m7836c(i5);
        int i6 = iRound;
        int i7 = 0;
        int iM7829a = 0;
        int i8 = 1;
        while (i8 < 13 && i6 > 0) {
            if (iM7836c > 0 && i8 == iM7836c + 1 && i7 == 0) {
                i8--;
                iM7829a = m7833b(i5);
                i7 = 1;
            } else {
                iM7829a = m7829a(i5, i8);
            }
            i6 -= iM7829a;
            if (i7 != 0 && i8 == iM7836c + 1) {
                i7 = 0;
            }
            i8++;
        }
        if (i6 == 0 && iM7836c > 0 && i8 == iM7836c + 1) {
            if (i7 != 0) {
                i7 = 0;
            } else {
                i8--;
                i7 = 1;
            }
        }
        if (i6 < 0) {
            i6 += iM7829a;
            i8--;
        }
        iArr[0] = i5;
        iArr[1] = i8;
        iArr[2] = i6 + 1;
        iArr[3] = i7 ^ 1;
        return iArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static COUILunarDatePicker.C1403a m7830a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int[] iArrM7835b = m7835b(OplusGLSurfaceView_13, i2, i4);
        Date dateM7831a = m7831a(OplusGLSurfaceView_13, iArrM7835b[0], m7834b(OplusGLSurfaceView_13, iArrM7835b[0], i3, iArrM7835b[1] == 0), iArrM7835b[1] == 0);
        COUILunarDatePicker.C1403a c1403a = new COUILunarDatePicker.C1403a();
        if (dateM7831a != null) {
            c1403a.m7236a(dateM7831a.getTime());
        }
        return c1403a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Date m7831a(int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        if (!m7837c(OplusGLSurfaceView_13, i2, i3, z)) {
            return null;
        }
        int iM7829a = 0;
        for (int i4 = 1900; i4 < OplusGLSurfaceView_13; i4++) {
            iM7829a += m7839e(i4);
        }
        int iM7836c = m7836c(OplusGLSurfaceView_13);
        int i5 = 1;
        if ((iM7836c != i2) && z) {
            return null;
        }
        if (iM7836c == 0 || i2 < iM7836c || (i2 == iM7836c && !z)) {
            while (i5 < i2) {
                iM7829a += m7829a(OplusGLSurfaceView_13, i5);
                i5++;
            }
            if (i3 > m7829a(OplusGLSurfaceView_13, i2)) {
                return null;
            }
        } else {
            while (i5 < i2) {
                iM7829a += m7829a(OplusGLSurfaceView_13, i5);
                i5++;
            }
            if (i2 > iM7836c) {
                iM7829a += m7833b(OplusGLSurfaceView_13);
                if (i3 > m7829a(OplusGLSurfaceView_13, i2)) {
                    return null;
                }
            } else {
                iM7829a += m7829a(OplusGLSurfaceView_13, i2);
                if (i3 > m7833b(OplusGLSurfaceView_13)) {
                    return null;
                }
            }
        }
        int i6 = iM7829a + i3;
        try {
            Date date = new SimpleDateFormat("yyyyMMdd").parse("19000130");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(5, i6);
            return calendar.getTime();
        } catch (ParseException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean m7837c(int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        if (OplusGLSurfaceView_13 < 1900 || OplusGLSurfaceView_13 > 2049 || i2 < 1 || i2 > 12 || i3 < 1 || i3 > 30) {
            return false;
        }
        return !z || i2 == m7836c(OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static int m7839e(int OplusGLSurfaceView_13) {
        int i2 = 348;
        for (int i3 = 32768; i3 >= 8; i3 >>= 1) {
            if ((f8150d[OplusGLSurfaceView_13 - 1900] & 65520 & i3) != 0) {
                i2++;
            }
        }
        return i2 + m7833b(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int[] m7835b(int OplusGLSurfaceView_13, int i2, int i3) {
        return new int[]{i2, ((i3 == 0 && m7836c(OplusGLSurfaceView_13) == i2) ? 1 : 0) ^ 1};
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static int m7834b(int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        int iM7833b;
        if (!z) {
            iM7833b = m7829a(OplusGLSurfaceView_13, i2);
        } else {
            iM7833b = m7833b(OplusGLSurfaceView_13);
        }
        return i3 > iM7833b ? iM7833b : i3;
    }
}

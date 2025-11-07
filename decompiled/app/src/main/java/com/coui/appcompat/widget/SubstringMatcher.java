package com.coui.appcompat.widget;

/* compiled from: COUILunarUtil.java */
/* loaded from: classes.dex */
public class k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String[] f2966a = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.String[] f2967b = {"小寒", "大寒", "立春", "雨水", "惊蛰", "春分", "清明", "谷雨", "立夏", "小满", "芒种", "夏至", "小暑", "大暑", "立秋", "处暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至"};

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.lang.String[] f2968c = {"小寒", "大寒", "立春", "雨水", "驚蟄", "春分", "清明", "穀雨", "立夏", "小滿", "芒種", "夏至", "小暑", "大暑", "立秋", "處暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至"};
    private static final long[] d_renamed = {19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 92821, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42416, 83315, 21168, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 23232, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448};
    private static final int[][] e_renamed = {new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 6, 21, 5, 21, 6, 22, 6, 22, 8, 23, 8, 24, 8, 24, 9, 24, 8, 23, 8, 22}, new int[]{6, 21, 5, 19, 5, 20, 5, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 21, 6, 22, 6, 22, 8, 23, 8, 24, 8, 24, 9, 24, 8, 23, 8, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 5, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 23, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 21, 6, 22, 6, 22, 8, 23, 8, 24, 8, 23, 9, 24, 8, 23, 8, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 19, 5, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 8, 23, 8, 24, 8, 23, 9, 24, 8, 23, 8, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 19, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 8, 23, 8, 24, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 20, 5, 21, 7, 22, 7, 23, 7, 22, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 5, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 7, 22, 7, 23, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 7, 22, 7, 23, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 6, 22, 7, 23, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 6, 22, 7, 22, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 6, 22, 7, 22, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 6, 22, 7, 22, 7, 22, 8, 23, 7, 22, 6, 21}};
    private static java.text.SimpleDateFormat f_renamed = new java.text.SimpleDateFormat("yyyy年MM月dd日");

    public static int a_renamed(int i_renamed) {
        if (i_renamed == Integer.MIN_VALUE) {
            return 0;
        }
        int i2 = 348;
        for (int i3 = 32768; i3 > 8; i3 >>= 1) {
            if ((d_renamed[i_renamed - 1900] & i3) != 0) {
                i2++;
            }
        }
        return i2 + b_renamed(i_renamed);
    }

    public static int b_renamed(int i_renamed) {
        if (c_renamed(i_renamed) != 0) {
            return (d_renamed[i_renamed + (-1900)] & 65536) != 0 ? 30 : 29;
        }
        return 0;
    }

    public static int c_renamed(int i_renamed) {
        if (i_renamed < 1900 || i_renamed > 2100) {
            android.util.Log.e_renamed("COUILunar", "get leapMonth:" + i_renamed + "is_renamed out of_renamed range.return 0.");
            return 0;
        }
        return (int) (d_renamed[i_renamed - 1900] & 15);
    }

    public static int a_renamed(int i_renamed, int i2) {
        if (i_renamed != Integer.MIN_VALUE) {
            if (((65536 >> i2) & d_renamed[i_renamed - 1900]) == 0) {
                return 29;
            }
        }
        return 30;
    }

    public static java.lang.String d_renamed(int i_renamed) {
        java.lang.String[] strArr = {"初", "十", "廿", "卅"};
        int i2 = i_renamed % 10;
        int i3 = i2 == 0 ? 9 : i2 - 1;
        if (i_renamed > 30) {
            return "";
        }
        if (i_renamed == 10) {
            return "初十";
        }
        if (i_renamed == 20) {
            return "二十";
        }
        if (i_renamed == 30) {
            return "三十";
        }
        return strArr[i_renamed / 10] + f2966a[i3];
    }

    public static int[] a_renamed(int i_renamed, int i2, int i3) {
        java.util.Date date;
        int[] iArr = {2000, 1, 1, 1};
        if (i_renamed == Integer.MIN_VALUE) {
            iArr[0] = i_renamed;
            int i4 = i2 - 1;
            iArr[1] = (i4 % 12) + 1;
            iArr[2] = i3;
            iArr[3] = i4 / 12 <= 0 ? 1 : 0;
            return iArr;
        }
        java.util.Date date2 = null;
        try {
            date = f_renamed.parse("1900年1月31日");
        } catch (java.text.ParseException e2) {
            android.util.Log.e_renamed("COUILunar", "calculateLunarByGregorian(),parse baseDate error.");
            e2.printStackTrace();
            date = null;
        }
        if (date == null) {
            android.util.Log.e_renamed("COUILunar", "baseDate is_renamed null,return lunar date:2000.1.1");
            return iArr;
        }
        try {
            date2 = f_renamed.parse(i_renamed + "年" + i2 + "月" + i3 + "日");
        } catch (java.text.ParseException e3) {
            android.util.Log.e_renamed("COUILunar", "calculateLunarByGregorian(),parse currentDate error.");
            e3.printStackTrace();
        }
        if (date2 == null) {
            android.util.Log.e_renamed("COUILunar", "currentDate is_renamed null,return lunar date:2000.1.1");
            return iArr;
        }
        int iRound = java.lang.Math.round((date2.getTime() - date.getTime()) / 8.64E7f);
        int i5 = 1900;
        int iA = 0;
        while (i5 < 10000 && iRound > 0) {
            iA = a_renamed(i5);
            iRound -= iA;
            i5++;
        }
        if (iRound < 0) {
            iRound += iA;
            i5--;
        }
        int iC = c_renamed(i5);
        int i6 = iRound;
        int i7 = 0;
        int iA2 = 0;
        int i8 = 1;
        while (i8 < 13 && i6 > 0) {
            if (iC > 0 && i8 == iC + 1 && i7 == 0) {
                i8--;
                iA2 = b_renamed(i5);
                i7 = 1;
            } else {
                iA2 = a_renamed(i5, i8);
            }
            i6 -= iA2;
            if (i7 != 0 && i8 == iC + 1) {
                i7 = 0;
            }
            i8++;
        }
        if (i6 == 0 && iC > 0 && i8 == iC + 1) {
            if (i7 != 0) {
                i7 = 0;
            } else {
                i8--;
                i7 = 1;
            }
        }
        if (i6 < 0) {
            i6 += iA2;
            i8--;
        }
        iArr[0] = i5;
        iArr[1] = i8;
        iArr[2] = i6 + 1;
        iArr[3] = i7 ^ 1;
        return iArr;
    }

    public static com.coui.appcompat.widget.COUILunarDatePicker.a_renamed a_renamed(int i_renamed, int i2, int i3, int i4) {
        int[] iArrB = b_renamed(i_renamed, i2, i4);
        java.util.Date dateA = a_renamed(i_renamed, iArrB[0], b_renamed(i_renamed, iArrB[0], i3, iArrB[1] == 0), iArrB[1] == 0);
        com.coui.appcompat.widget.COUILunarDatePicker.a_renamed aVar = new com.coui.appcompat.widget.COUILunarDatePicker.a_renamed();
        if (dateA != null) {
            aVar.a_renamed(dateA.getTime());
        }
        return aVar;
    }

    public static java.util.Date a_renamed(int i_renamed, int i2, int i3, boolean z_renamed) {
        if (!c_renamed(i_renamed, i2, i3, z_renamed)) {
            return null;
        }
        int iA = 0;
        for (int i4 = 1900; i4 < i_renamed; i4++) {
            iA += e_renamed(i4);
        }
        int iC = c_renamed(i_renamed);
        int i5 = 1;
        if ((iC != i2) && z_renamed) {
            return null;
        }
        if (iC == 0 || i2 < iC || (i2 == iC && !z_renamed)) {
            while (i5 < i2) {
                iA += a_renamed(i_renamed, i5);
                i5++;
            }
            if (i3 > a_renamed(i_renamed, i2)) {
                return null;
            }
        } else {
            while (i5 < i2) {
                iA += a_renamed(i_renamed, i5);
                i5++;
            }
            if (i2 > iC) {
                iA += b_renamed(i_renamed);
                if (i3 > a_renamed(i_renamed, i2)) {
                    return null;
                }
            } else {
                iA += a_renamed(i_renamed, i2);
                if (i3 > b_renamed(i_renamed)) {
                    return null;
                }
            }
        }
        int i6 = iA + i3;
        try {
            java.util.Date date = new java.text.SimpleDateFormat("yyyyMMdd").parse("19000130");
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(5, i6);
            return calendar.getTime();
        } catch (java.text.ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static boolean c_renamed(int i_renamed, int i2, int i3, boolean z_renamed) {
        if (i_renamed < 1900 || i_renamed > 2049 || i2 < 1 || i2 > 12 || i3 < 1 || i3 > 30) {
            return false;
        }
        return !z_renamed || i2 == c_renamed(i_renamed);
    }

    private static int e_renamed(int i_renamed) {
        int i2 = 348;
        for (int i3 = 32768; i3 >= 8; i3 >>= 1) {
            if ((d_renamed[i_renamed - 1900] & 65520 & i3) != 0) {
                i2++;
            }
        }
        return i2 + b_renamed(i_renamed);
    }

    private static int[] b_renamed(int i_renamed, int i2, int i3) {
        return new int[]{i2, ((i3 == 0 && c_renamed(i_renamed) == i2) ? 1 : 0) ^ 1};
    }

    static int b_renamed(int i_renamed, int i2, int i3, boolean z_renamed) {
        int iB;
        if (!z_renamed) {
            iB = a_renamed(i_renamed, i2);
        } else {
            iB = b_renamed(i_renamed);
        }
        return i3 > iB ? iB : i3;
    }
}

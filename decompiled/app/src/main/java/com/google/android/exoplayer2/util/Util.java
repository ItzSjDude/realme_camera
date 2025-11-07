package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class Util {
    private static final java.lang.String TAG = "Util";
    public static final int SDK_INT = android.os.Build.VERSION.SDK_INT;
    public static final java.lang.String DEVICE = android.os.Build.DEVICE;
    public static final java.lang.String MANUFACTURER = android.os.Build.MANUFACTURER;
    public static final java.lang.String MODEL = android.os.Build.MODEL;
    public static final java.lang.String DEVICE_DEBUG_INFO = DEVICE + ", " + MODEL + ", " + MANUFACTURER + ", " + SDK_INT;
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final java.util.regex.Pattern XS_DATE_TIME_PATTERN = java.util.regex.Pattern.compile("(\\d_renamed\\d_renamed\\d_renamed\\d_renamed)\\-(\\d_renamed\\d_renamed)\\-(\\d_renamed\\d_renamed)[Tt](\\d_renamed\\d_renamed):(\\d_renamed\\d_renamed):(\\d_renamed\\d_renamed)([\\.,](\\d_renamed+))?([Zz]|((\\+|\\-)(\\d_renamed?\\d_renamed):?(\\d_renamed\\d_renamed)))?");
    private static final java.util.regex.Pattern XS_DURATION_PATTERN = java.util.regex.Pattern.compile("^(-)?P_renamed(([0-9]*)Y_renamed)?(([0-9]*)M_renamed)?(([0-9]*)D_renamed)?(T_renamed(([0-9]*)H_renamed)?(([0-9]*)M_renamed)?(([0-9.]*)S_renamed)?)?$");
    private static final java.util.regex.Pattern ESCAPED_CHARACTER_PATTERN = java.util.regex.Pattern.compile("%([A_renamed-Fa-f0-9]{2})");
    private static final int[] CRC32_BYTES_MSBF = {0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};

    public static long addWithOverflowDefault(long j_renamed, long j2, long j3) {
        long j4 = j_renamed + j2;
        return ((j_renamed ^ j4) & (j2 ^ j4)) < 0 ? j3 : j4;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    public static <T_renamed> T_renamed castNonNull(T_renamed t_renamed) {
        return t_renamed;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    public static <T_renamed> T_renamed[] castNonNullTypeArray(T_renamed[] tArr) {
        return tArr;
    }

    public static int compareLong(long j_renamed, long j2) {
        if (j_renamed < j2) {
            return -1;
        }
        return j_renamed == j2 ? 0 : 1;
    }

    public static int getAudioContentTypeForStreamType(int i_renamed) {
        if (i_renamed != 0) {
            return (i_renamed == 1 || i_renamed == 2 || i_renamed == 4 || i_renamed == 5 || i_renamed == 8) ? 4 : 2;
        }
        return 1;
    }

    public static int getAudioUsageForStreamType(int i_renamed) {
        if (i_renamed == 0) {
            return 2;
        }
        if (i_renamed == 1) {
            return 13;
        }
        if (i_renamed == 2) {
            return 6;
        }
        int i2 = 4;
        if (i_renamed != 4) {
            i2 = 5;
            if (i_renamed != 5) {
                return i_renamed != 8 ? 1 : 3;
            }
        }
        return i2;
    }

    public static int getPcmEncoding(int i_renamed) {
        if (i_renamed == 8) {
            return 3;
        }
        if (i_renamed == 16) {
            return 2;
        }
        if (i_renamed != 24) {
            return i_renamed != 32 ? 0 : 1073741824;
        }
        return Integer.MIN_VALUE;
    }

    public static int getStreamTypeForAudioUsage(int i_renamed) {
        switch (i_renamed) {
        }
        return 3;
    }

    public static boolean isEncodingHighResolutionIntegerPcm(int i_renamed) {
        return i_renamed == Integer.MIN_VALUE || i_renamed == 1073741824;
    }

    public static boolean isEncodingLinearPcm(int i_renamed) {
        return i_renamed == 3 || i_renamed == 2 || i_renamed == Integer.MIN_VALUE || i_renamed == 1073741824 || i_renamed == 4;
    }

    public static boolean isLinebreak(int i_renamed) {
        return i_renamed == 10 || i_renamed == 13;
    }

    private static boolean shouldEscapeCharacter(char c2) {
        return c2 == '\"' || c2 == '%' || c2 == '*' || c2 == '/' || c2 == ':' || c2 == '<' || c2 == '\\' || c2 == '|' || c2 == '>' || c2 == '?';
    }

    public static long subtractWithOverflowDefault(long j_renamed, long j2, long j3) {
        long j4 = j_renamed - j2;
        return ((j_renamed ^ j4) & (j2 ^ j_renamed)) < 0 ? j3 : j4;
    }

    private Util() {
    }

    public static byte[] toByteArray(java.io.InputStream inputStream) throws java.io.IOException {
        byte[] bArr = new byte[4096];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        while (true) {
            int i_renamed = inputStream.read(bArr);
            if (i_renamed != -1) {
                byteArrayOutputStream.write(bArr, 0, i_renamed);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static android.content.ComponentName startForegroundService(android.content.Context context, android.content.Intent intent) {
        if (SDK_INT >= 26) {
            return context.startForegroundService(intent);
        }
        return context.startService(intent);
    }

    @android.annotation.TargetApi(23)
    public static boolean maybeRequestReadExternalStoragePermission(android.app.Activity activity, android.net.Uri... uriArr) {
        if (SDK_INT < 23) {
            return false;
        }
        int length = uriArr.length;
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= length) {
                break;
            }
            if (!isLocalFileUri(uriArr[i_renamed])) {
                i_renamed++;
            } else if (activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                activity.requestPermissions(new java.lang.String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
                return true;
            }
        }
        return false;
    }

    @android.annotation.TargetApi(24)
    public static boolean checkCleartextTrafficPermitted(android.net.Uri... uriArr) {
        if (SDK_INT < 24) {
            return true;
        }
        for (android.net.Uri uri : uriArr) {
            if ("http".equals(uri.getScheme()) && !android.security.NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(uri.getHost())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLocalFileUri(android.net.Uri uri) {
        java.lang.String scheme = uri.getScheme();
        return android.text.TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static boolean areEqual(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean contains(java.lang.Object[] objArr, java.lang.Object obj) {
        for (java.lang.Object obj2 : objArr) {
            if (areEqual(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static <T_renamed> void removeRange(java.util.List<T_renamed> list, int i_renamed, int i2) {
        if (i_renamed < 0 || i2 > list.size() || i_renamed > i2) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i_renamed != i2) {
            list.subList(i_renamed, i2).clear();
        }
    }

    public static <T_renamed> T_renamed[] nullSafeArrayCopy(T_renamed[] tArr, int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed <= tArr.length);
        return (T_renamed[]) java.util.Arrays.copyOf(tArr, i_renamed);
    }

    public static android.os.Handler createHandler(android.os.Handler.Callback callback) {
        return createHandler(getLooper(), callback);
    }

    public static android.os.Handler createHandler(android.os.Looper looper, android.os.Handler.Callback callback) {
        return new android.os.Handler(looper, callback);
    }

    public static android.os.Looper getLooper() {
        android.os.Looper looperMyLooper = android.os.Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : android.os.Looper.getMainLooper();
    }

    static /* synthetic */ java.lang.Thread lambda$newSingleThreadExecutor$0(java.lang.String str, java.lang.Runnable runnable) {
        return new java.lang.Thread(runnable, str);
    }

    public static java.util.concurrent.ExecutorService newSingleThreadExecutor(final java.lang.String str) {
        return java.util.concurrent.Executors.newSingleThreadExecutor(new java.util.concurrent.ThreadFactory() { // from class: com.google.android.exoplayer2.util.-$$Lambda$Util$MRC4FgxCpRGDforKj-F0m_7VaCA
            @Override // java.util.concurrent.ThreadFactory
            public final java.lang.Thread newThread(java.lang.Runnable runnable) {
                return com.google.android.exoplayer2.util.Util.lambda$newSingleThreadExecutor$0(str, runnable);
            }
        });
    }

    public static void closeQuietly(com.google.android.exoplayer2.upstream.DataSource dataSource) {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void closeQuietly(java.io.Closeable closeable) throws java.io.IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static boolean readBoolean(android.os.Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void writeBoolean(android.os.Parcel parcel, boolean z_renamed) {
        parcel.writeInt(z_renamed ? 1 : 0);
    }

    public static java.lang.String normalizeLanguageCode(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            return new java.util.Locale(str).getISO3Language();
        } catch (java.util.MissingResourceException unused) {
            return toLowerInvariant(str);
        }
    }

    public static java.lang.String fromUtf8Bytes(byte[] bArr) {
        return new java.lang.String(bArr, java.nio.charset.Charset.forName("UTF-8"));
    }

    public static java.lang.String fromUtf8Bytes(byte[] bArr, int i_renamed, int i2) {
        return new java.lang.String(bArr, i_renamed, i2, java.nio.charset.Charset.forName("UTF-8"));
    }

    public static byte[] getUtf8Bytes(java.lang.String str) {
        return str.getBytes(java.nio.charset.Charset.forName("UTF-8"));
    }

    public static java.lang.String[] split(java.lang.String str, java.lang.String str2) {
        return str.split(str2, -1);
    }

    public static java.lang.String[] splitAtFirst(java.lang.String str, java.lang.String str2) {
        return str.split(str2, 2);
    }

    public static java.lang.String toLowerInvariant(java.lang.String str) {
        return str == null ? str : str.toLowerCase(java.util.Locale.US);
    }

    public static java.lang.String toUpperInvariant(java.lang.String str) {
        return str == null ? str : str.toUpperCase(java.util.Locale.US);
    }

    public static java.lang.String formatInvariant(java.lang.String str, java.lang.Object... objArr) {
        return java.lang.String.format(java.util.Locale.US, str, objArr);
    }

    public static int ceilDivide(int i_renamed, int i2) {
        return ((i_renamed + i2) - 1) / i2;
    }

    public static long ceilDivide(long j_renamed, long j2) {
        return ((j_renamed + j2) - 1) / j2;
    }

    public static int constrainValue(int i_renamed, int i2, int i3) {
        return java.lang.Math.max(i2, java.lang.Math.min(i_renamed, i3));
    }

    public static long constrainValue(long j_renamed, long j2, long j3) {
        return java.lang.Math.max(j2, java.lang.Math.min(j_renamed, j3));
    }

    public static float constrainValue(float f_renamed, float f2, float f3) {
        return java.lang.Math.max(f2, java.lang.Math.min(f_renamed, f3));
    }

    public static int binarySearchFloor(int[] iArr, int i_renamed, boolean z_renamed, boolean z2) {
        int i2;
        int iBinarySearch = java.util.Arrays.binarySearch(iArr, i_renamed);
        if (iBinarySearch < 0) {
            i2 = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (iArr[iBinarySearch] == i_renamed);
            i2 = z_renamed ? iBinarySearch + 1 : iBinarySearch;
        }
        return z2 ? java.lang.Math.max(0, i2) : i2;
    }

    public static int binarySearchFloor(long[] jArr, long j_renamed, boolean z_renamed, boolean z2) {
        int i_renamed;
        int iBinarySearch = java.util.Arrays.binarySearch(jArr, j_renamed);
        if (iBinarySearch < 0) {
            i_renamed = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (jArr[iBinarySearch] == j_renamed);
            i_renamed = z_renamed ? iBinarySearch + 1 : iBinarySearch;
        }
        return z2 ? java.lang.Math.max(0, i_renamed) : i_renamed;
    }

    public static <T_renamed extends java.lang.Comparable<? super T_renamed>> int binarySearchFloor(java.util.List<? extends java.lang.Comparable<? super T_renamed>> list, T_renamed t_renamed, boolean z_renamed, boolean z2) {
        int i_renamed;
        int iBinarySearch = java.util.Collections.binarySearch(list, t_renamed);
        if (iBinarySearch < 0) {
            i_renamed = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(t_renamed) == 0);
            i_renamed = z_renamed ? iBinarySearch + 1 : iBinarySearch;
        }
        return z2 ? java.lang.Math.max(0, i_renamed) : i_renamed;
    }

    public static int binarySearchCeil(long[] jArr, long j_renamed, boolean z_renamed, boolean z2) {
        int i_renamed;
        int iBinarySearch = java.util.Arrays.binarySearch(jArr, j_renamed);
        if (iBinarySearch < 0) {
            i_renamed = ~iBinarySearch;
        } else {
            do {
                iBinarySearch++;
                if (iBinarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[iBinarySearch] == j_renamed);
            i_renamed = z_renamed ? iBinarySearch - 1 : iBinarySearch;
        }
        return z2 ? java.lang.Math.min(jArr.length - 1, i_renamed) : i_renamed;
    }

    public static <T_renamed extends java.lang.Comparable<? super T_renamed>> int binarySearchCeil(java.util.List<? extends java.lang.Comparable<? super T_renamed>> list, T_renamed t_renamed, boolean z_renamed, boolean z2) {
        int i_renamed;
        int iBinarySearch = java.util.Collections.binarySearch(list, t_renamed);
        if (iBinarySearch < 0) {
            i_renamed = ~iBinarySearch;
        } else {
            int size = list.size();
            do {
                iBinarySearch++;
                if (iBinarySearch >= size) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(t_renamed) == 0);
            i_renamed = z_renamed ? iBinarySearch - 1 : iBinarySearch;
        }
        return z2 ? java.lang.Math.min(list.size() - 1, i_renamed) : i_renamed;
    }

    public static long parseXsDuration(java.lang.String str) {
        java.util.regex.Matcher matcher = XS_DURATION_PATTERN.matcher(str);
        if (matcher.matches()) {
            boolean zIsEmpty = true ^ android.text.TextUtils.isEmpty(matcher.group(1));
            java.lang.String strGroup = matcher.group(3);
            double d_renamed = strGroup != null ? java.lang.Double.parseDouble(strGroup) * 3.1556908E7d : 0.0d;
            java.lang.String strGroup2 = matcher.group(5);
            double d2 = d_renamed + (strGroup2 != null ? java.lang.Double.parseDouble(strGroup2) * 2629739.0d : 0.0d);
            java.lang.String strGroup3 = matcher.group(7);
            double d3 = d2 + (strGroup3 != null ? java.lang.Double.parseDouble(strGroup3) * 86400.0d : 0.0d);
            java.lang.String strGroup4 = matcher.group(10);
            double d4 = d3 + (strGroup4 != null ? 3600.0d * java.lang.Double.parseDouble(strGroup4) : 0.0d);
            java.lang.String strGroup5 = matcher.group(12);
            double d5 = d4 + (strGroup5 != null ? java.lang.Double.parseDouble(strGroup5) * 60.0d : 0.0d);
            java.lang.String strGroup6 = matcher.group(14);
            long j_renamed = (long) ((d5 + (strGroup6 != null ? java.lang.Double.parseDouble(strGroup6) : 0.0d)) * 1000.0d);
            return zIsEmpty ? -j_renamed : j_renamed;
        }
        return (long) (java.lang.Double.parseDouble(str) * 3600.0d * 1000.0d);
    }

    public static long parseXsDateTime(java.lang.String str) throws com.google.android.exoplayer2.ParserException {
        java.util.regex.Matcher matcher = XS_DATE_TIME_PATTERN.matcher(str);
        if (!matcher.matches()) {
            throw new com.google.android.exoplayer2.ParserException("Invalid date/time format: " + str);
        }
        int i_renamed = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z_renamed")) {
            i_renamed = (java.lang.Integer.parseInt(matcher.group(12)) * 60) + java.lang.Integer.parseInt(matcher.group(13));
            if ("-".equals(matcher.group(11))) {
                i_renamed *= -1;
            }
        }
        java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar(java.util.TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(java.lang.Integer.parseInt(matcher.group(1)), java.lang.Integer.parseInt(matcher.group(2)) - 1, java.lang.Integer.parseInt(matcher.group(3)), java.lang.Integer.parseInt(matcher.group(4)), java.lang.Integer.parseInt(matcher.group(5)), java.lang.Integer.parseInt(matcher.group(6)));
        if (!android.text.TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new java.math.BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i_renamed != 0 ? timeInMillis - (i_renamed * 60000) : timeInMillis;
    }

    public static long scaleLargeTimestamp(long j_renamed, long j2, long j3) {
        if (j3 >= j2 && j3 % j2 == 0) {
            return j_renamed / (j3 / j2);
        }
        if (j3 < j2 && j2 % j3 == 0) {
            return j_renamed * (j2 / j3);
        }
        return (long) (j_renamed * (j2 / j3));
    }

    public static long[] scaleLargeTimestamps(java.util.List<java.lang.Long> list, long j_renamed, long j2) {
        long[] jArr = new long[list.size()];
        int i_renamed = 0;
        if (j2 >= j_renamed && j2 % j_renamed == 0) {
            long j3 = j2 / j_renamed;
            while (i_renamed < jArr.length) {
                jArr[i_renamed] = list.get(i_renamed).longValue() / j3;
                i_renamed++;
            }
        } else if (j2 < j_renamed && j_renamed % j2 == 0) {
            long j4 = j_renamed / j2;
            while (i_renamed < jArr.length) {
                jArr[i_renamed] = list.get(i_renamed).longValue() * j4;
                i_renamed++;
            }
        } else {
            double d_renamed = j_renamed / j2;
            while (i_renamed < jArr.length) {
                jArr[i_renamed] = (long) (list.get(i_renamed).longValue() * d_renamed);
                i_renamed++;
            }
        }
        return jArr;
    }

    public static void scaleLargeTimestampsInPlace(long[] jArr, long j_renamed, long j2) {
        int i_renamed = 0;
        if (j2 >= j_renamed && j2 % j_renamed == 0) {
            long j3 = j2 / j_renamed;
            while (i_renamed < jArr.length) {
                jArr[i_renamed] = jArr[i_renamed] / j3;
                i_renamed++;
            }
            return;
        }
        if (j2 < j_renamed && j_renamed % j2 == 0) {
            long j4 = j_renamed / j2;
            while (i_renamed < jArr.length) {
                jArr[i_renamed] = jArr[i_renamed] * j4;
                i_renamed++;
            }
            return;
        }
        double d_renamed = j_renamed / j2;
        while (i_renamed < jArr.length) {
            jArr[i_renamed] = (long) (jArr[i_renamed] * d_renamed);
            i_renamed++;
        }
    }

    public static long getMediaDurationForPlayoutDuration(long j_renamed, float f_renamed) {
        return f_renamed == 1.0f ? j_renamed : java.lang.Math.round(j_renamed * f_renamed);
    }

    public static long getPlayoutDurationForMediaDuration(long j_renamed, float f_renamed) {
        return f_renamed == 1.0f ? j_renamed : java.lang.Math.round(j_renamed / f_renamed);
    }

    public static long resolveSeekPositionUs(long j_renamed, com.google.android.exoplayer2.SeekParameters seekParameters, long j2, long j3) {
        if (com.google.android.exoplayer2.SeekParameters.EXACT.equals(seekParameters)) {
            return j_renamed;
        }
        long jSubtractWithOverflowDefault = subtractWithOverflowDefault(j_renamed, seekParameters.toleranceBeforeUs, Long.MIN_VALUE);
        long jAddWithOverflowDefault = addWithOverflowDefault(j_renamed, seekParameters.toleranceAfterUs, Long.MAX_VALUE);
        boolean z_renamed = jSubtractWithOverflowDefault <= j2 && j2 <= jAddWithOverflowDefault;
        boolean z2 = jSubtractWithOverflowDefault <= j3 && j3 <= jAddWithOverflowDefault;
        return (z_renamed && z2) ? java.lang.Math.abs(j2 - j_renamed) <= java.lang.Math.abs(j3 - j_renamed) ? j2 : j3 : z_renamed ? j2 : z2 ? j3 : jSubtractWithOverflowDefault;
    }

    public static int[] toArray(java.util.List<java.lang.Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            iArr[i_renamed] = list.get(i_renamed).intValue();
        }
        return iArr;
    }

    public static int getIntegerCodeForString(java.lang.String str) {
        int length = str.length();
        com.google.android.exoplayer2.util.Assertions.checkArgument(length <= 4);
        int iCharAt = 0;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            iCharAt = (iCharAt << 8) | str.charAt(i_renamed);
        }
        return iCharAt;
    }

    public static byte[] getBytesFromHexString(java.lang.String str) {
        byte[] bArr = new byte[str.length() / 2];
        for (int i_renamed = 0; i_renamed < bArr.length; i_renamed++) {
            int i2 = i_renamed * 2;
            bArr[i_renamed] = (byte) ((java.lang.Character.digit(str.charAt(i2), 16) << 4) + java.lang.Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public static java.lang.String getCommaDelimitedSimpleClassNames(java.lang.Object[] objArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i_renamed = 0; i_renamed < objArr.length; i_renamed++) {
            sb.append(objArr[i_renamed].getClass().getSimpleName());
            if (i_renamed < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static java.lang.String getUserAgent(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + "/" + str2 + " (Linux;Android " + android.os.Build.VERSION.RELEASE + ") " + com.google.android.exoplayer2.ExoPlayerLibraryInfo.VERSION_SLASHY;
    }

    public static java.lang.String getCodecsOfType(java.lang.String str, int i_renamed) {
        java.lang.String[] strArrSplitCodecs = splitCodecs(str);
        if (strArrSplitCodecs.length == 0) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str2 : strArrSplitCodecs) {
            if (i_renamed == com.google.android.exoplayer2.util.MimeTypes.getTrackTypeOfCodec(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static java.lang.String[] splitCodecs(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return new java.lang.String[0];
        }
        return split(str.trim(), "(\\s_renamed*,\\s_renamed*)");
    }

    public static int getAudioTrackChannelConfig(int i_renamed) {
        switch (i_renamed) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                int i2 = SDK_INT;
                return (i2 < 23 && i2 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static int getPcmFrameSize(int i_renamed, int i2) {
        if (i_renamed == Integer.MIN_VALUE) {
            return i2 * 3;
        }
        if (i_renamed != 1073741824) {
            if (i_renamed == 2) {
                return i2 * 2;
            }
            if (i_renamed == 3) {
                return i2;
            }
            if (i_renamed != 4) {
                throw new java.lang.IllegalArgumentException();
            }
        }
        return i2 * 4;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:18:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.UUID getDrmUuid(java.lang.String r5) {
        /*
            java.lang.String r0 = toLowerInvariant(r5)
            int r1 = r0.hashCode()
            r2 = -1860423953(0xffffffff911c2eef, float:-1.2320693E-28)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L2e
            r2 = -1400551171(0xffffffffac8548fd, float:-3.7881907E-12)
            if (r1 == r2) goto L24
            r2 = 790309106(0x2f1b28f2, float:1.4111715E-10)
            if (r1 == r2) goto L1a
            goto L38
        L1a:
            java.lang.String r1 = "clearkey"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L38
            r0 = r3
            goto L39
        L24:
            java.lang.String r1 = "widevine"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L38
            r0 = 0
            goto L39
        L2e:
            java.lang.String r1 = "playready"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L38
            r0 = r4
            goto L39
        L38:
            r0 = -1
        L39:
            if (r0 == 0) goto L4c
            if (r0 == r4) goto L49
            if (r0 == r3) goto L46
            java.util.UUID r5 = java.util.UUID.fromString(r5)     // Catch: java.lang.RuntimeException -> L44
            return r5
        L44:
            r5 = 0
            return r5
        L46:
            java.util.UUID r5 = com.google.android.exoplayer2.C_renamed.CLEARKEY_UUID
            return r5
        L49:
            java.util.UUID r5 = com.google.android.exoplayer2.C_renamed.PLAYREADY_UUID
            return r5
        L4c:
            java.util.UUID r5 = com.google.android.exoplayer2.C_renamed.WIDEVINE_UUID
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.getDrmUuid(java.lang.String):java.util.UUID");
    }

    public static int inferContentType(android.net.Uri uri, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return inferContentType(uri);
        }
        return inferContentType("." + str);
    }

    public static int inferContentType(android.net.Uri uri) {
        java.lang.String path = uri.getPath();
        if (path == null) {
            return 3;
        }
        return inferContentType(path);
    }

    public static int inferContentType(java.lang.String str) {
        java.lang.String lowerInvariant = toLowerInvariant(str);
        if (lowerInvariant.endsWith(".mpd")) {
            return 0;
        }
        if (lowerInvariant.endsWith(".m3u8")) {
            return 2;
        }
        return lowerInvariant.matches(".*\\.ism(l_renamed)?(/manifest(\\(.+\\))?)?") ? 1 : 3;
    }

    public static java.lang.String getStringForTime(java.lang.StringBuilder sb, java.util.Formatter formatter, long j_renamed) {
        if (j_renamed == -9223372036854775807L) {
            j_renamed = 0;
        }
        long j2 = (j_renamed + 500) / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 / 60) % 60;
        long j5 = j2 / 3600;
        sb.setLength(0);
        return j5 > 0 ? formatter.format("%d_renamed:%02d:%02d", java.lang.Long.valueOf(j5), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j3)).toString() : formatter.format("%02d:%02d", java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j3)).toString();
    }

    public static java.lang.String escapeFileName(java.lang.String str) {
        int length = str.length();
        int i_renamed = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (shouldEscapeCharacter(str.charAt(i3))) {
                i2++;
            }
        }
        if (i2 == 0) {
            return str;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder((i2 * 2) + length);
        while (i2 > 0) {
            int i4 = i_renamed + 1;
            char cCharAt = str.charAt(i_renamed);
            if (shouldEscapeCharacter(cCharAt)) {
                sb.append('%');
                sb.append(java.lang.Integer.toHexString(cCharAt));
                i2--;
            } else {
                sb.append(cCharAt);
            }
            i_renamed = i4;
        }
        if (i_renamed < length) {
            sb.append((java.lang.CharSequence) str, i_renamed, length);
        }
        return sb.toString();
    }

    public static java.lang.String unescapeFileName(java.lang.String str) {
        int length = str.length();
        int iEnd = 0;
        int i_renamed = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) == '%') {
                i_renamed++;
            }
        }
        if (i_renamed == 0) {
            return str;
        }
        int i3 = length - (i_renamed * 2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(i3);
        java.util.regex.Matcher matcher = ESCAPED_CHARACTER_PATTERN.matcher(str);
        while (i_renamed > 0 && matcher.find()) {
            char c2 = (char) java.lang.Integer.parseInt(matcher.group(1), 16);
            sb.append((java.lang.CharSequence) str, iEnd, matcher.start());
            sb.append(c2);
            iEnd = matcher.end();
            i_renamed--;
        }
        if (iEnd < length) {
            sb.append((java.lang.CharSequence) str, iEnd, length);
        }
        if (sb.length() != i3) {
            return null;
        }
        return sb.toString();
    }

    public static void sneakyThrow(java.lang.Throwable th) throws java.lang.Throwable {
        sneakyThrowInternal(th);
    }

    private static <T_renamed extends java.lang.Throwable> void sneakyThrowInternal(java.lang.Throwable th) throws java.lang.Throwable {
        throw th;
    }

    public static void recursiveDelete(java.io.File file) {
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (java.io.File file2 : fileArrListFiles) {
                recursiveDelete(file2);
            }
        }
        file.delete();
    }

    public static java.io.File createTempDirectory(android.content.Context context, java.lang.String str) throws java.io.IOException {
        java.io.File fileCreateTempFile = createTempFile(context, str);
        fileCreateTempFile.delete();
        fileCreateTempFile.mkdir();
        return fileCreateTempFile;
    }

    public static java.io.File createTempFile(android.content.Context context, java.lang.String str) throws java.io.IOException {
        return java.io.File.createTempFile(str, null, context.getCacheDir());
    }

    public static int crc(byte[] bArr, int i_renamed, int i2, int i3) {
        while (i_renamed < i2) {
            i3 = CRC32_BYTES_MSBF[((i3 >>> 24) ^ (bArr[i_renamed] & 255)) & 255] ^ (i3 << 8);
            i_renamed++;
        }
        return i3;
    }

    public static int getNetworkType(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        int i_renamed = 0;
        if (context == null) {
            return 0;
        }
        try {
            connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        } catch (java.lang.SecurityException unused) {
        }
        if (connectivityManager == null) {
            return 0;
        }
        android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        i_renamed = 1;
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            int type = activeNetworkInfo.getType();
            if (type != 0) {
                if (type == 1) {
                    return 2;
                }
                if (type != 4 && type != 5) {
                    if (type != 6) {
                        return type != 9 ? 8 : 7;
                    }
                    return 5;
                }
            }
            return getMobileNetworkType(activeNetworkInfo);
        }
        return i_renamed;
    }

    public static java.lang.String getCountryCode(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone")) != null) {
            java.lang.String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!android.text.TextUtils.isEmpty(networkCountryIso)) {
                return toUpperInvariant(networkCountryIso);
            }
        }
        return toUpperInvariant(java.util.Locale.getDefault().getCountry());
    }

    public static boolean inflate(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2, java.util.zip.Inflater inflater) {
        if (parsableByteArray.bytesLeft() <= 0) {
            return false;
        }
        byte[] bArrCopyOf = parsableByteArray2.data;
        if (bArrCopyOf.length < parsableByteArray.bytesLeft()) {
            bArrCopyOf = new byte[parsableByteArray.bytesLeft() * 2];
        }
        if (inflater == null) {
            inflater = new java.util.zip.Inflater();
        }
        inflater.setInput(parsableByteArray.data, parsableByteArray.getPosition(), parsableByteArray.bytesLeft());
        int iInflate = 0;
        while (true) {
            try {
                iInflate += inflater.inflate(bArrCopyOf, iInflate, bArrCopyOf.length - iInflate);
                if (inflater.finished()) {
                    parsableByteArray2.reset(bArrCopyOf, iInflate);
                    return true;
                }
                if (inflater.needsDictionary() || inflater.needsInput()) {
                    break;
                }
                if (iInflate == bArrCopyOf.length) {
                    bArrCopyOf = java.util.Arrays.copyOf(bArrCopyOf, bArrCopyOf.length * 2);
                }
            } catch (java.util.zip.DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static android.graphics.Point getPhysicalDisplaySize(android.content.Context context) {
        return getPhysicalDisplaySize(context, ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay());
    }

    public static android.graphics.Point getPhysicalDisplaySize(android.content.Context context, android.view.Display display) throws java.lang.ClassNotFoundException, java.lang.NumberFormatException {
        if (SDK_INT < 25 && display.getDisplayId() == 0) {
            if ("Sony".equals(MANUFACTURER) && MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new android.graphics.Point(com.oplus.camera.capmode.w_renamed.VIDEO_4K_FRAME_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_4K_FRAME_HEIGHT);
            }
            if (("NVIDIA".equals(MANUFACTURER) && MODEL.contains("SHIELD")) || ("philips".equals(toLowerInvariant(MANUFACTURER)) && (MODEL.startsWith("QM1") || MODEL.equals("QV151E") || MODEL.equals("TPM171E")))) {
                java.lang.String str = null;
                try {
                    java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
                    str = (java.lang.String) cls.getMethod("get", java.lang.String.class).invoke(cls, "sys.display-size");
                } catch (java.lang.Exception e_renamed) {
                    com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Failed to read sys.display-size", e_renamed);
                }
                if (!android.text.TextUtils.isEmpty(str)) {
                    try {
                        java.lang.String[] strArrSplit = split(str.trim(), "x_renamed");
                        if (strArrSplit.length == 2) {
                            int i_renamed = java.lang.Integer.parseInt(strArrSplit[0]);
                            int i2 = java.lang.Integer.parseInt(strArrSplit[1]);
                            if (i_renamed > 0 && i2 > 0) {
                                return new android.graphics.Point(i_renamed, i2);
                            }
                        }
                    } catch (java.lang.NumberFormatException unused) {
                    }
                    com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Invalid sys.display-size: " + str);
                }
            }
        }
        android.graphics.Point point = new android.graphics.Point();
        int i3 = SDK_INT;
        if (i3 >= 23) {
            getDisplaySizeV23(display, point);
        } else if (i3 >= 17) {
            getDisplaySizeV17(display, point);
        } else if (i3 >= 16) {
            getDisplaySizeV16(display, point);
        } else {
            getDisplaySizeV9(display, point);
        }
        return point;
    }

    @android.annotation.TargetApi(23)
    private static void getDisplaySizeV23(android.view.Display display, android.graphics.Point point) {
        android.view.Display.Mode mode = display.getMode();
        point.x_renamed = mode.getPhysicalWidth();
        point.y_renamed = mode.getPhysicalHeight();
    }

    @android.annotation.TargetApi(17)
    private static void getDisplaySizeV17(android.view.Display display, android.graphics.Point point) {
        display.getRealSize(point);
    }

    @android.annotation.TargetApi(16)
    private static void getDisplaySizeV16(android.view.Display display, android.graphics.Point point) {
        display.getSize(point);
    }

    private static void getDisplaySizeV9(android.view.Display display, android.graphics.Point point) {
        point.x_renamed = display.getWidth();
        point.y_renamed = display.getHeight();
    }

    private static int getMobileNetworkType(android.net.NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            default:
                return 6;
            case 18:
                return 2;
        }
    }
}

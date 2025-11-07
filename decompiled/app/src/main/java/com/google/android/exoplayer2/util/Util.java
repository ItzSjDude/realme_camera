package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.upstream.DataSource;
import com.oplus.camera.capmode.VideoMode;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes.dex */
public final class Util {
    private static final String TAG = "Util";
    public static final int SDK_INT = Build.VERSION.SDK_INT;
    public static final String DEVICE = Build.DEVICE;
    public static final String MANUFACTURER = Build.MANUFACTURER;
    public static final String MODEL = Build.MODEL;
    public static final String DEVICE_DEBUG_INFO = DEVICE + ", " + MODEL + ", " + MANUFACTURER + ", " + SDK_INT;
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final Pattern XS_DATE_TIME_PATTERN = Pattern.compile("(\\IntrinsicsJvm.kt_5\\IntrinsicsJvm.kt_5\\IntrinsicsJvm.kt_5\\IntrinsicsJvm.kt_5)\\-(\\IntrinsicsJvm.kt_5\\IntrinsicsJvm.kt_5)\\-(\\IntrinsicsJvm.kt_5\\IntrinsicsJvm.kt_5)[Tt](\\IntrinsicsJvm.kt_5\\IntrinsicsJvm.kt_5):(\\IntrinsicsJvm.kt_5\\IntrinsicsJvm.kt_5):(\\IntrinsicsJvm.kt_5\\IntrinsicsJvm.kt_5)([\\.,](\\IntrinsicsJvm.kt_5+))?([Zz]|((\\+|\\-)(\\IntrinsicsJvm.kt_5?\\IntrinsicsJvm.kt_5):?(\\IntrinsicsJvm.kt_5\\IntrinsicsJvm.kt_5)))?");
    private static final Pattern XS_DURATION_PATTERN = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    private static final Pattern ESCAPED_CHARACTER_PATTERN = Pattern.compile("%([A-Fa-f0-9]{2})");
    private static final int[] CRC32_BYTES_MSBF = {0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};

    public static long addWithOverflowDefault(long OplusGLSurfaceView_15, long j2, long j3) {
        long j4 = OplusGLSurfaceView_15 + j2;
        return ((OplusGLSurfaceView_15 ^ j4) & (j2 ^ j4)) < 0 ? j3 : j4;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T castNonNull(T t) {
        return t;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[] castNonNullTypeArray(T[] tArr) {
        return tArr;
    }

    public static int compareLong(long OplusGLSurfaceView_15, long j2) {
        if (OplusGLSurfaceView_15 < j2) {
            return -1;
        }
        return OplusGLSurfaceView_15 == j2 ? 0 : 1;
    }

    public static int getAudioContentTypeForStreamType(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            return (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 4 || OplusGLSurfaceView_13 == 5 || OplusGLSurfaceView_13 == 8) ? 4 : 2;
        }
        return 1;
    }

    public static int getAudioUsageForStreamType(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return 2;
        }
        if (OplusGLSurfaceView_13 == 1) {
            return 13;
        }
        if (OplusGLSurfaceView_13 == 2) {
            return 6;
        }
        int i2 = 4;
        if (OplusGLSurfaceView_13 != 4) {
            i2 = 5;
            if (OplusGLSurfaceView_13 != 5) {
                return OplusGLSurfaceView_13 != 8 ? 1 : 3;
            }
        }
        return i2;
    }

    public static int getPcmEncoding(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 8) {
            return 3;
        }
        if (OplusGLSurfaceView_13 == 16) {
            return 2;
        }
        if (OplusGLSurfaceView_13 != 24) {
            return OplusGLSurfaceView_13 != 32 ? 0 : 1073741824;
        }
        return Integer.MIN_VALUE;
    }

    public static int getStreamTypeForAudioUsage(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
        }
        return 3;
    }

    public static boolean isEncodingHighResolutionIntegerPcm(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == Integer.MIN_VALUE || OplusGLSurfaceView_13 == 1073741824;
    }

    public static boolean isEncodingLinearPcm(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == Integer.MIN_VALUE || OplusGLSurfaceView_13 == 1073741824 || OplusGLSurfaceView_13 == 4;
    }

    public static boolean isLinebreak(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 10 || OplusGLSurfaceView_13 == 13;
    }

    private static boolean shouldEscapeCharacter(char c2) {
        return c2 == '\"' || c2 == '%' || c2 == '*' || c2 == '/' || c2 == ':' || c2 == '<' || c2 == '\\' || c2 == '|' || c2 == '>' || c2 == '?';
    }

    public static long subtractWithOverflowDefault(long OplusGLSurfaceView_15, long j2, long j3) {
        long j4 = OplusGLSurfaceView_15 - j2;
        return ((OplusGLSurfaceView_15 ^ j4) & (j2 ^ OplusGLSurfaceView_15)) < 0 ? j3 : j4;
    }

    private Util() {
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int OplusGLSurfaceView_13 = inputStream.read(bArr);
            if (OplusGLSurfaceView_13 != -1) {
                byteArrayOutputStream.write(bArr, 0, OplusGLSurfaceView_13);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static ComponentName startForegroundService(Context context, Intent intent) {
        if (SDK_INT >= 26) {
            return context.startForegroundService(intent);
        }
        return context.startService(intent);
    }

    @TargetApi(23)
    public static boolean maybeRequestReadExternalStoragePermission(Activity activity, Uri... uriArr) {
        if (SDK_INT < 23) {
            return false;
        }
        int length = uriArr.length;
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            if (OplusGLSurfaceView_13 >= length) {
                break;
            }
            if (!isLocalFileUri(uriArr[OplusGLSurfaceView_13])) {
                OplusGLSurfaceView_13++;
            } else if (activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
                return true;
            }
        }
        return false;
    }

    @TargetApi(24)
    public static boolean checkCleartextTrafficPermitted(Uri... uriArr) {
        if (SDK_INT < 24) {
            return true;
        }
        for (Uri uri : uriArr) {
            if ("http".equals(uri.getScheme()) && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(uri.getHost())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLocalFileUri(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean contains(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (areEqual(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static <T> void removeRange(List<T> list, int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 < 0 || i2 > list.size() || OplusGLSurfaceView_13 > i2) {
            throw new IllegalArgumentException();
        }
        if (OplusGLSurfaceView_13 != i2) {
            list.subList(OplusGLSurfaceView_13, i2).clear();
        }
    }

    public static <T> T[] nullSafeArrayCopy(T[] tArr, int OplusGLSurfaceView_13) {
        Assertions.checkArgument(OplusGLSurfaceView_13 <= tArr.length);
        return (T[]) Arrays.copyOf(tArr, OplusGLSurfaceView_13);
    }

    public static Handler createHandler(Handler.Callback callback) {
        return createHandler(getLooper(), callback);
    }

    public static Handler createHandler(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static Looper getLooper() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    static /* synthetic */ Thread lambda$newSingleThreadExecutor$0(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static ExecutorService newSingleThreadExecutor(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.google.android.exoplayer2.util.-$$Lambda$Util$MRC4FgxCpRGDforKj-F0m_7VaCA
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return Util.lambda$newSingleThreadExecutor$0(str, runnable);
            }
        });
    }

    public static void closeQuietly(DataSource dataSource) {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean readBoolean(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void writeBoolean(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static String normalizeLanguageCode(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new Locale(str).getISO3Language();
        } catch (MissingResourceException unused) {
            return toLowerInvariant(str);
        }
    }

    public static String fromUtf8Bytes(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }

    public static String fromUtf8Bytes(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        return new String(bArr, OplusGLSurfaceView_13, i2, Charset.forName("UTF-8"));
    }

    public static byte[] getUtf8Bytes(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public static String[] split(String str, String str2) {
        return str.split(str2, -1);
    }

    public static String[] splitAtFirst(String str, String str2) {
        return str.split(str2, 2);
    }

    public static String toLowerInvariant(String str) {
        return str == null ? str : str.toLowerCase(Locale.US);
    }

    public static String toUpperInvariant(String str) {
        return str == null ? str : str.toUpperCase(Locale.US);
    }

    public static String formatInvariant(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static int ceilDivide(int OplusGLSurfaceView_13, int i2) {
        return ((OplusGLSurfaceView_13 + i2) - 1) / i2;
    }

    public static long ceilDivide(long OplusGLSurfaceView_15, long j2) {
        return ((OplusGLSurfaceView_15 + j2) - 1) / j2;
    }

    public static int constrainValue(int OplusGLSurfaceView_13, int i2, int i3) {
        return Math.max(i2, Math.min(OplusGLSurfaceView_13, i3));
    }

    public static long constrainValue(long OplusGLSurfaceView_15, long j2, long j3) {
        return Math.max(j2, Math.min(OplusGLSurfaceView_15, j3));
    }

    public static float constrainValue(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return Math.max(f2, Math.min(COUIBaseListPopupWindow_12, f3));
    }

    public static int binarySearchFloor(int[] iArr, int OplusGLSurfaceView_13, boolean z, boolean z2) {
        int i2;
        int iBinarySearch = Arrays.binarySearch(iArr, OplusGLSurfaceView_13);
        if (iBinarySearch < 0) {
            i2 = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (iArr[iBinarySearch] == OplusGLSurfaceView_13);
            i2 = z ? iBinarySearch + 1 : iBinarySearch;
        }
        return z2 ? Math.max(0, i2) : i2;
    }

    public static int binarySearchFloor(long[] jArr, long OplusGLSurfaceView_15, boolean z, boolean z2) {
        int OplusGLSurfaceView_13;
        int iBinarySearch = Arrays.binarySearch(jArr, OplusGLSurfaceView_15);
        if (iBinarySearch < 0) {
            OplusGLSurfaceView_13 = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (jArr[iBinarySearch] == OplusGLSurfaceView_15);
            OplusGLSurfaceView_13 = z ? iBinarySearch + 1 : iBinarySearch;
        }
        return z2 ? Math.max(0, OplusGLSurfaceView_13) : OplusGLSurfaceView_13;
    }

    public static <T extends Comparable<? super T>> int binarySearchFloor(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int OplusGLSurfaceView_13;
        int iBinarySearch = Collections.binarySearch(list, t);
        if (iBinarySearch < 0) {
            OplusGLSurfaceView_13 = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(t) == 0);
            OplusGLSurfaceView_13 = z ? iBinarySearch + 1 : iBinarySearch;
        }
        return z2 ? Math.max(0, OplusGLSurfaceView_13) : OplusGLSurfaceView_13;
    }

    public static int binarySearchCeil(long[] jArr, long OplusGLSurfaceView_15, boolean z, boolean z2) {
        int OplusGLSurfaceView_13;
        int iBinarySearch = Arrays.binarySearch(jArr, OplusGLSurfaceView_15);
        if (iBinarySearch < 0) {
            OplusGLSurfaceView_13 = ~iBinarySearch;
        } else {
            do {
                iBinarySearch++;
                if (iBinarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[iBinarySearch] == OplusGLSurfaceView_15);
            OplusGLSurfaceView_13 = z ? iBinarySearch - 1 : iBinarySearch;
        }
        return z2 ? Math.min(jArr.length - 1, OplusGLSurfaceView_13) : OplusGLSurfaceView_13;
    }

    public static <T extends Comparable<? super T>> int binarySearchCeil(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int OplusGLSurfaceView_13;
        int iBinarySearch = Collections.binarySearch(list, t);
        if (iBinarySearch < 0) {
            OplusGLSurfaceView_13 = ~iBinarySearch;
        } else {
            int size = list.size();
            do {
                iBinarySearch++;
                if (iBinarySearch >= size) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(t) == 0);
            OplusGLSurfaceView_13 = z ? iBinarySearch - 1 : iBinarySearch;
        }
        return z2 ? Math.min(list.size() - 1, OplusGLSurfaceView_13) : OplusGLSurfaceView_13;
    }

    public static long parseXsDuration(String str) {
        Matcher matcher = XS_DURATION_PATTERN.matcher(str);
        if (matcher.matches()) {
            boolean zIsEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
            String strGroup = matcher.group(3);
            double IntrinsicsJvm.kt_5 = strGroup != null ? Double.parseDouble(strGroup) * 3.1556908E7d : 0.0d;
            String strGroup2 = matcher.group(5);
            double d2 = IntrinsicsJvm.kt_5 + (strGroup2 != null ? Double.parseDouble(strGroup2) * 2629739.0d : 0.0d);
            String strGroup3 = matcher.group(7);
            double d3 = d2 + (strGroup3 != null ? Double.parseDouble(strGroup3) * 86400.0d : 0.0d);
            String strGroup4 = matcher.group(10);
            double d4 = d3 + (strGroup4 != null ? 3600.0d * Double.parseDouble(strGroup4) : 0.0d);
            String strGroup5 = matcher.group(12);
            double d5 = d4 + (strGroup5 != null ? Double.parseDouble(strGroup5) * 60.0d : 0.0d);
            String strGroup6 = matcher.group(14);
            long OplusGLSurfaceView_15 = (long) ((d5 + (strGroup6 != null ? Double.parseDouble(strGroup6) : 0.0d)) * 1000.0d);
            return zIsEmpty ? -OplusGLSurfaceView_15 : OplusGLSurfaceView_15;
        }
        return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
    }

    public static long parseXsDateTime(String str) throws ParserException {
        Matcher matcher = XS_DATE_TIME_PATTERN.matcher(str);
        if (!matcher.matches()) {
            throw new ParserException("Invalid date/time format: " + str);
        }
        int OplusGLSurfaceView_13 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            OplusGLSurfaceView_13 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
            if ("-".equals(matcher.group(11))) {
                OplusGLSurfaceView_13 *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return OplusGLSurfaceView_13 != 0 ? timeInMillis - (OplusGLSurfaceView_13 * 60000) : timeInMillis;
    }

    public static long scaleLargeTimestamp(long OplusGLSurfaceView_15, long j2, long j3) {
        if (j3 >= j2 && j3 % j2 == 0) {
            return OplusGLSurfaceView_15 / (j3 / j2);
        }
        if (j3 < j2 && j2 % j3 == 0) {
            return OplusGLSurfaceView_15 * (j2 / j3);
        }
        return (long) (OplusGLSurfaceView_15 * (j2 / j3));
    }

    public static long[] scaleLargeTimestamps(List<Long> list, long OplusGLSurfaceView_15, long j2) {
        long[] jArr = new long[list.size()];
        int OplusGLSurfaceView_13 = 0;
        if (j2 >= OplusGLSurfaceView_15 && j2 % OplusGLSurfaceView_15 == 0) {
            long j3 = j2 / OplusGLSurfaceView_15;
            while (OplusGLSurfaceView_13 < jArr.length) {
                jArr[OplusGLSurfaceView_13] = list.get(OplusGLSurfaceView_13).longValue() / j3;
                OplusGLSurfaceView_13++;
            }
        } else if (j2 < OplusGLSurfaceView_15 && OplusGLSurfaceView_15 % j2 == 0) {
            long j4 = OplusGLSurfaceView_15 / j2;
            while (OplusGLSurfaceView_13 < jArr.length) {
                jArr[OplusGLSurfaceView_13] = list.get(OplusGLSurfaceView_13).longValue() * j4;
                OplusGLSurfaceView_13++;
            }
        } else {
            double IntrinsicsJvm.kt_5 = OplusGLSurfaceView_15 / j2;
            while (OplusGLSurfaceView_13 < jArr.length) {
                jArr[OplusGLSurfaceView_13] = (long) (list.get(OplusGLSurfaceView_13).longValue() * IntrinsicsJvm.kt_5);
                OplusGLSurfaceView_13++;
            }
        }
        return jArr;
    }

    public static void scaleLargeTimestampsInPlace(long[] jArr, long OplusGLSurfaceView_15, long j2) {
        int OplusGLSurfaceView_13 = 0;
        if (j2 >= OplusGLSurfaceView_15 && j2 % OplusGLSurfaceView_15 == 0) {
            long j3 = j2 / OplusGLSurfaceView_15;
            while (OplusGLSurfaceView_13 < jArr.length) {
                jArr[OplusGLSurfaceView_13] = jArr[OplusGLSurfaceView_13] / j3;
                OplusGLSurfaceView_13++;
            }
            return;
        }
        if (j2 < OplusGLSurfaceView_15 && OplusGLSurfaceView_15 % j2 == 0) {
            long j4 = OplusGLSurfaceView_15 / j2;
            while (OplusGLSurfaceView_13 < jArr.length) {
                jArr[OplusGLSurfaceView_13] = jArr[OplusGLSurfaceView_13] * j4;
                OplusGLSurfaceView_13++;
            }
            return;
        }
        double IntrinsicsJvm.kt_5 = OplusGLSurfaceView_15 / j2;
        while (OplusGLSurfaceView_13 < jArr.length) {
            jArr[OplusGLSurfaceView_13] = (long) (jArr[OplusGLSurfaceView_13] * IntrinsicsJvm.kt_5);
            OplusGLSurfaceView_13++;
        }
    }

    public static long getMediaDurationForPlayoutDuration(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12) {
        return COUIBaseListPopupWindow_12 == 1.0f ? OplusGLSurfaceView_15 : Math.round(OplusGLSurfaceView_15 * COUIBaseListPopupWindow_12);
    }

    public static long getPlayoutDurationForMediaDuration(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12) {
        return COUIBaseListPopupWindow_12 == 1.0f ? OplusGLSurfaceView_15 : Math.round(OplusGLSurfaceView_15 / COUIBaseListPopupWindow_12);
    }

    public static long resolveSeekPositionUs(long OplusGLSurfaceView_15, SeekParameters seekParameters, long j2, long j3) {
        if (SeekParameters.EXACT.equals(seekParameters)) {
            return OplusGLSurfaceView_15;
        }
        long jSubtractWithOverflowDefault = subtractWithOverflowDefault(OplusGLSurfaceView_15, seekParameters.toleranceBeforeUs, Long.MIN_VALUE);
        long jAddWithOverflowDefault = addWithOverflowDefault(OplusGLSurfaceView_15, seekParameters.toleranceAfterUs, Long.MAX_VALUE);
        boolean z = jSubtractWithOverflowDefault <= j2 && j2 <= jAddWithOverflowDefault;
        boolean z2 = jSubtractWithOverflowDefault <= j3 && j3 <= jAddWithOverflowDefault;
        return (z && z2) ? Math.abs(j2 - OplusGLSurfaceView_15) <= Math.abs(j3 - OplusGLSurfaceView_15) ? j2 : j3 : z ? j2 : z2 ? j3 : jSubtractWithOverflowDefault;
    }

    public static int[] toArray(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            iArr[OplusGLSurfaceView_13] = list.get(OplusGLSurfaceView_13).intValue();
        }
        return iArr;
    }

    public static int getIntegerCodeForString(String str) {
        int length = str.length();
        Assertions.checkArgument(length <= 4);
        int iCharAt = 0;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            iCharAt = (iCharAt << 8) | str.charAt(OplusGLSurfaceView_13);
        }
        return iCharAt;
    }

    public static byte[] getBytesFromHexString(String str) {
        byte[] bArr = new byte[str.length() / 2];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bArr.length; OplusGLSurfaceView_13++) {
            int i2 = OplusGLSurfaceView_13 * 2;
            bArr[OplusGLSurfaceView_13] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public static String getCommaDelimitedSimpleClassNames(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < objArr.length; OplusGLSurfaceView_13++) {
            sb.append(objArr[OplusGLSurfaceView_13].getClass().getSimpleName());
            if (OplusGLSurfaceView_13 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static String getUserAgent(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") " + ExoPlayerLibraryInfo.VERSION_SLASHY;
    }

    public static String getCodecsOfType(String str, int OplusGLSurfaceView_13) {
        String[] strArrSplitCodecs = splitCodecs(str);
        if (strArrSplitCodecs.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplitCodecs) {
            if (OplusGLSurfaceView_13 == MimeTypes.getTrackTypeOfCodec(str2)) {
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

    public static String[] splitCodecs(String str) {
        if (TextUtils.isEmpty(str)) {
            return new String[0];
        }
        return split(str.trim(), "(\\s*,\\s*)");
    }

    public static int getAudioTrackChannelConfig(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
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

    public static int getPcmFrameSize(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 == Integer.MIN_VALUE) {
            return i2 * 3;
        }
        if (OplusGLSurfaceView_13 != 1073741824) {
            if (OplusGLSurfaceView_13 == 2) {
                return i2 * 2;
            }
            if (OplusGLSurfaceView_13 == 3) {
                return i2;
            }
            if (OplusGLSurfaceView_13 != 4) {
                throw new IllegalArgumentException();
            }
        }
        return i2 * 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
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
            java.util.UUID r5 = com.google.android.exoplayer2.C1547C.CLEARKEY_UUID
            return r5
        L49:
            java.util.UUID r5 = com.google.android.exoplayer2.C1547C.PLAYREADY_UUID
            return r5
        L4c:
            java.util.UUID r5 = com.google.android.exoplayer2.C1547C.WIDEVINE_UUID
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.getDrmUuid(java.lang.String):java.util.UUID");
    }

    public static int inferContentType(Uri uri, String str) {
        if (TextUtils.isEmpty(str)) {
            return inferContentType(uri);
        }
        return inferContentType("." + str);
    }

    public static int inferContentType(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return 3;
        }
        return inferContentType(path);
    }

    public static int inferContentType(String str) {
        String lowerInvariant = toLowerInvariant(str);
        if (lowerInvariant.endsWith(".mpd")) {
            return 0;
        }
        if (lowerInvariant.endsWith(".m3u8")) {
            return 2;
        }
        return lowerInvariant.matches(".*\\.ism(OplusGLSurfaceView_14)?(/manifest(\\(.+\\))?)?") ? 1 : 3;
    }

    public static String getStringForTime(StringBuilder sb, Formatter formatter, long OplusGLSurfaceView_15) {
        if (OplusGLSurfaceView_15 == -9223372036854775807L) {
            OplusGLSurfaceView_15 = 0;
        }
        long j2 = (OplusGLSurfaceView_15 + 500) / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 / 60) % 60;
        long j5 = j2 / 3600;
        sb.setLength(0);
        return j5 > 0 ? formatter.format("%IntrinsicsJvm.kt_5:%02d:%02d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)).toString() : formatter.format("%02d:%02d", Long.valueOf(j4), Long.valueOf(j3)).toString();
    }

    public static String escapeFileName(String str) {
        int length = str.length();
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (shouldEscapeCharacter(str.charAt(i3))) {
                i2++;
            }
        }
        if (i2 == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder((i2 * 2) + length);
        while (i2 > 0) {
            int i4 = OplusGLSurfaceView_13 + 1;
            char cCharAt = str.charAt(OplusGLSurfaceView_13);
            if (shouldEscapeCharacter(cCharAt)) {
                sb.append('%');
                sb.append(Integer.toHexString(cCharAt));
                i2--;
            } else {
                sb.append(cCharAt);
            }
            OplusGLSurfaceView_13 = i4;
        }
        if (OplusGLSurfaceView_13 < length) {
            sb.append((CharSequence) str, OplusGLSurfaceView_13, length);
        }
        return sb.toString();
    }

    public static String unescapeFileName(String str) {
        int length = str.length();
        int iEnd = 0;
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) == '%') {
                OplusGLSurfaceView_13++;
            }
        }
        if (OplusGLSurfaceView_13 == 0) {
            return str;
        }
        int i3 = length - (OplusGLSurfaceView_13 * 2);
        StringBuilder sb = new StringBuilder(i3);
        Matcher matcher = ESCAPED_CHARACTER_PATTERN.matcher(str);
        while (OplusGLSurfaceView_13 > 0 && matcher.find()) {
            char c2 = (char) Integer.parseInt(matcher.group(1), 16);
            sb.append((CharSequence) str, iEnd, matcher.start());
            sb.append(c2);
            iEnd = matcher.end();
            OplusGLSurfaceView_13--;
        }
        if (iEnd < length) {
            sb.append((CharSequence) str, iEnd, length);
        }
        if (sb.length() != i3) {
            return null;
        }
        return sb.toString();
    }

    public static void sneakyThrow(Throwable th) throws Throwable {
        sneakyThrowInternal(th);
    }

    private static <T extends Throwable> void sneakyThrowInternal(Throwable th) throws Throwable {
        throw th;
    }

    public static void recursiveDelete(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                recursiveDelete(file2);
            }
        }
        file.delete();
    }

    public static File createTempDirectory(Context context, String str) throws IOException {
        File fileCreateTempFile = createTempFile(context, str);
        fileCreateTempFile.delete();
        fileCreateTempFile.mkdir();
        return fileCreateTempFile;
    }

    public static File createTempFile(Context context, String str) throws IOException {
        return File.createTempFile(str, null, context.getCacheDir());
    }

    public static int crc(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3) {
        while (OplusGLSurfaceView_13 < i2) {
            i3 = CRC32_BYTES_MSBF[((i3 >>> 24) ^ (bArr[OplusGLSurfaceView_13] & 255)) & 255] ^ (i3 << 8);
            OplusGLSurfaceView_13++;
        }
        return i3;
    }

    public static int getNetworkType(Context context) {
        ConnectivityManager connectivityManager;
        int OplusGLSurfaceView_13 = 0;
        if (context == null) {
            return 0;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (SecurityException unused) {
        }
        if (connectivityManager == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        OplusGLSurfaceView_13 = 1;
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
        return OplusGLSurfaceView_13;
    }

    public static String getCountryCode(Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return toUpperInvariant(networkCountryIso);
            }
        }
        return toUpperInvariant(Locale.getDefault().getCountry());
    }

    public static boolean inflate(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, Inflater inflater) {
        if (parsableByteArray.bytesLeft() <= 0) {
            return false;
        }
        byte[] bArrCopyOf = parsableByteArray2.data;
        if (bArrCopyOf.length < parsableByteArray.bytesLeft()) {
            bArrCopyOf = new byte[parsableByteArray.bytesLeft() * 2];
        }
        if (inflater == null) {
            inflater = new Inflater();
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
                    bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length * 2);
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static Point getPhysicalDisplaySize(Context context) {
        return getPhysicalDisplaySize(context, ((WindowManager) context.getSystemService("window")).getDefaultDisplay());
    }

    public static Point getPhysicalDisplaySize(Context context, Display display) throws ClassNotFoundException, NumberFormatException {
        if (SDK_INT < 25 && display.getDisplayId() == 0) {
            if ("Sony".equals(MANUFACTURER) && MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(VideoMode.VIDEO_4K_FRAME_WIDTH, VideoMode.VIDEO_4K_FRAME_HEIGHT);
            }
            if (("NVIDIA".equals(MANUFACTURER) && MODEL.contains("SHIELD")) || ("philips".equals(toLowerInvariant(MANUFACTURER)) && (MODEL.startsWith("QM1") || MODEL.equals("QV151E") || MODEL.equals("TPM171E")))) {
                String str = null;
                try {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    str = (String) cls.getMethod("get", String.class).invoke(cls, "sys.display-size");
                } catch (Exception COUIBaseListPopupWindow_8) {
                    Log.m8321e(TAG, "Failed to read sys.display-size", COUIBaseListPopupWindow_8);
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        String[] strArrSplit = split(str.trim(), "x");
                        if (strArrSplit.length == 2) {
                            int OplusGLSurfaceView_13 = Integer.parseInt(strArrSplit[0]);
                            int i2 = Integer.parseInt(strArrSplit[1]);
                            if (OplusGLSurfaceView_13 > 0 && i2 > 0) {
                                return new Point(OplusGLSurfaceView_13, i2);
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                    Log.m8320e(TAG, "Invalid sys.display-size: " + str);
                }
            }
        }
        Point point = new Point();
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

    @TargetApi(23)
    private static void getDisplaySizeV23(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    @TargetApi(17)
    private static void getDisplaySizeV17(Display display, Point point) {
        display.getRealSize(point);
    }

    @TargetApi(16)
    private static void getDisplaySizeV16(Display display, Point point) {
        display.getSize(point);
    }

    private static void getDisplaySizeV9(Display display, Point point) {
        point.x = display.getWidth();
        point.y = display.getHeight();
    }

    private static int getMobileNetworkType(NetworkInfo networkInfo) {
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

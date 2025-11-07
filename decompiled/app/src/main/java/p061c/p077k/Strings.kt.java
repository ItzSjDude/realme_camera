package p061c.p077k;

import p061c.p062a.C0881b;
import p061c.p070f.p072b.Intrinsics;
import p061c.p074h.Ranges.kt_2;
import p061c.p074h.C0987d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
/* renamed from: IntrinsicsJvm.kt_3.OplusGLSurfaceView_5.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
public class Strings.kt extends StringsJVM.kt {
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final int m5370b(CharSequence charSequence) {
        Intrinsics.m5305d(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m5366a(String str, char c2, String str2, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            str2 = str;
        }
        return C1005d.m5365a(str, c2, str2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final String m5365a(String str, char c2, String str2) {
        Intrinsics.m5305d(str, "$this$substringBefore");
        Intrinsics.m5305d(str2, "missingDelimiterValue");
        int iA = C1005d.m5358a((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (iA == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iA);
        Intrinsics.m5301b(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m5368a(String str, String str2, String str3, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            str3 = str;
        }
        return C1005d.m5367a(str, str2, str3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final String m5367a(String str, String str2, String str3) {
        Intrinsics.m5305d(str, "$this$substringBefore");
        Intrinsics.m5305d(str2, "delimiter");
        Intrinsics.m5305d(str3, "missingDelimiterValue");
        int iA = C1005d.m5362a((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iA == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iA);
        Intrinsics.m5301b(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ String m5379b(String str, String str2, String str3, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            str3 = str;
        }
        return C1005d.m5378b(str, str2, str3);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final String m5378b(String str, String str2, String str3) {
        Intrinsics.m5305d(str, "$this$substringAfter");
        Intrinsics.m5305d(str2, "delimiter");
        Intrinsics.m5305d(str3, "missingDelimiterValue");
        int iA = C1005d.m5362a((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iA == -1) {
            return str3;
        }
        String strSubstring = str.substring(iA + str2.length(), str.length());
        Intrinsics.m5301b(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ String m5377b(String str, char c2, String str2, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            str2 = str;
        }
        return C1005d.m5376b(str, c2, str2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final String m5376b(String str, char c2, String str2) {
        Intrinsics.m5305d(str, "$this$substringAfterLast");
        Intrinsics.m5305d(str2, "missingDelimiterValue");
        int iB = C1005d.m5372b((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (iB == -1) {
            return str2;
        }
        String strSubstring = str.substring(iB + 1, str.length());
        Intrinsics.m5301b(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final boolean m5369a(CharSequence charSequence, int OplusGLSurfaceView_13, CharSequence charSequence2, int i2, int i3, boolean z) {
        Intrinsics.m5305d(charSequence, "$this$regionMatchesImpl");
        Intrinsics.m5305d(charSequence2, "other");
        if (i2 < 0 || OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!C1002a.m5349a(charSequence.charAt(OplusGLSurfaceView_13 + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final int m5363a(CharSequence charSequence, char[] cArr, int OplusGLSurfaceView_13, boolean z) {
        boolean z2;
        Intrinsics.m5305d(charSequence, "$this$indexOfAny");
        Intrinsics.m5305d(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(C0881b.m5218a(cArr), OplusGLSurfaceView_13);
        }
        int iB = C0987d.m5336b(OplusGLSurfaceView_13, 0);
        int iB2 = C1005d.m5370b(charSequence);
        if (iB > iB2) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iB);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                }
                if (C1002a.m5349a(cArr[i2], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return iB;
            }
            if (iB == iB2) {
                return -1;
            }
            iB++;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final int m5375b(CharSequence charSequence, char[] cArr, int OplusGLSurfaceView_13, boolean z) {
        Intrinsics.m5305d(charSequence, "$this$lastIndexOfAny");
        Intrinsics.m5305d(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(C0881b.m5218a(cArr), OplusGLSurfaceView_13);
        }
        for (int iC = C0987d.m5338c(OplusGLSurfaceView_13, C1005d.m5370b(charSequence)); iC >= 0; iC--) {
            char cCharAt = charSequence.charAt(iC);
            int length = cArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (C1002a.m5349a(cArr[i2], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return iC;
            }
        }
        return -1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static /* synthetic */ int m5360a(CharSequence charSequence, CharSequence charSequence2, int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return m5359a(charSequence, charSequence2, OplusGLSurfaceView_13, i2, z, z2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int m5359a(CharSequence charSequence, CharSequence charSequence2, int OplusGLSurfaceView_13, int i2, boolean z, boolean z2) {
        Ranges.kt_2 c0986cA;
        if (!z2) {
            c0986cA = new Ranges.kt_2(C0987d.m5336b(OplusGLSurfaceView_13, 0), C0987d.m5338c(i2, charSequence.length()));
        } else {
            c0986cA = C0987d.m5335a(C0987d.m5338c(OplusGLSurfaceView_13, C1005d.m5370b(charSequence)), C0987d.m5336b(i2, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iM5327a = c0986cA.m5327a();
            int iM5328b = c0986cA.m5328b();
            int iM5329c = c0986cA.m5329c();
            if (iM5329c >= 0) {
                if (iM5327a > iM5328b) {
                    return -1;
                }
            } else if (iM5327a < iM5328b) {
                return -1;
            }
            while (!C1005d.m5354a((String) charSequence2, 0, (String) charSequence, iM5327a, charSequence2.length(), z)) {
                if (iM5327a == iM5328b) {
                    return -1;
                }
                iM5327a += iM5329c;
            }
            return iM5327a;
        }
        int iM5327a2 = c0986cA.m5327a();
        int iM5328b2 = c0986cA.m5328b();
        int iM5329c2 = c0986cA.m5329c();
        if (iM5329c2 >= 0) {
            if (iM5327a2 > iM5328b2) {
                return -1;
            }
        } else if (iM5327a2 < iM5328b2) {
            return -1;
        }
        while (!C1005d.m5369a(charSequence2, 0, charSequence, iM5327a2, charSequence2.length(), z)) {
            if (iM5327a2 == iM5328b2) {
                return -1;
            }
            iM5327a2 += iM5329c2;
        }
        return iM5327a2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ int m5358a(CharSequence charSequence, char c2, int OplusGLSurfaceView_13, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            OplusGLSurfaceView_13 = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return C1005d.m5357a(charSequence, c2, OplusGLSurfaceView_13, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final int m5357a(CharSequence charSequence, char c2, int OplusGLSurfaceView_13, boolean z) {
        Intrinsics.m5305d(charSequence, "$this$indexOf");
        return (z || !(charSequence instanceof String)) ? C1005d.m5363a(charSequence, new char[]{c2}, OplusGLSurfaceView_13, z) : ((String) charSequence).indexOf(c2, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ int m5362a(CharSequence charSequence, String str, int OplusGLSurfaceView_13, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            OplusGLSurfaceView_13 = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return C1005d.m5361a(charSequence, str, OplusGLSurfaceView_13, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final int m5361a(CharSequence charSequence, String str, int OplusGLSurfaceView_13, boolean z) {
        Intrinsics.m5305d(charSequence, "$this$indexOf");
        Intrinsics.m5305d(str, "string");
        if (z || !(charSequence instanceof String)) {
            return m5360a(charSequence, str, OplusGLSurfaceView_13, charSequence.length(), z, false, 16, null);
        }
        return ((String) charSequence).indexOf(str, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ int m5372b(CharSequence charSequence, char c2, int OplusGLSurfaceView_13, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            OplusGLSurfaceView_13 = C1005d.m5370b(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return C1005d.m5371b(charSequence, c2, OplusGLSurfaceView_13, z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final int m5371b(CharSequence charSequence, char c2, int OplusGLSurfaceView_13, boolean z) {
        Intrinsics.m5305d(charSequence, "$this$lastIndexOf");
        return (z || !(charSequence instanceof String)) ? C1005d.m5375b(charSequence, new char[]{c2}, OplusGLSurfaceView_13, z) : ((String) charSequence).lastIndexOf(c2, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ int m5374b(CharSequence charSequence, String str, int OplusGLSurfaceView_13, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            OplusGLSurfaceView_13 = C1005d.m5370b(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return C1005d.m5373b(charSequence, str, OplusGLSurfaceView_13, z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final int m5373b(CharSequence charSequence, String str, int OplusGLSurfaceView_13, boolean z) {
        Intrinsics.m5305d(charSequence, "$this$lastIndexOf");
        Intrinsics.m5305d(str, "string");
        if (z || !(charSequence instanceof String)) {
            return m5359a(charSequence, (CharSequence) str, OplusGLSurfaceView_13, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final CharSequence m5364a(CharSequence charSequence) {
        Intrinsics.m5305d(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int OplusGLSurfaceView_13 = 0;
        boolean z = false;
        while (OplusGLSurfaceView_13 <= length) {
            boolean zA = C1002a.m5348a(charSequence.charAt(!z ? OplusGLSurfaceView_13 : length));
            if (z) {
                if (!zA) {
                    break;
                }
                length--;
            } else if (zA) {
                OplusGLSurfaceView_13++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(OplusGLSurfaceView_13, length + 1);
    }
}

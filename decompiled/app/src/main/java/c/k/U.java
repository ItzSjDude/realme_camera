package c_renamed.k_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
/* loaded from: classes.dex */
public class n_renamed extends c_renamed.k_renamed.m_renamed {
    public static final int b_renamed(java.lang.CharSequence charSequence) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static /* synthetic */ java.lang.String a_renamed(java.lang.String str, char c2, java.lang.String str2, int i_renamed, java.lang.Object obj) {
        if ((i_renamed & 2) != 0) {
            str2 = str;
        }
        return c_renamed.k_renamed.d_renamed.a_renamed(str, c2, str2);
    }

    public static final java.lang.String a_renamed(java.lang.String str, char c2, java.lang.String str2) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str, "$this$substringBefore");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str2, "missingDelimiterValue");
        int iA = c_renamed.k_renamed.d_renamed.a_renamed((java.lang.CharSequence) str, c2, 0, false, 6, (java.lang.Object) null);
        if (iA == -1) {
            return str2;
        }
        java.lang.String strSubstring = str.substring(0, iA);
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(strSubstring, "(this as_renamed java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ java.lang.String a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, java.lang.Object obj) {
        if ((i_renamed & 2) != 0) {
            str3 = str;
        }
        return c_renamed.k_renamed.d_renamed.a_renamed(str, str2, str3);
    }

    public static final java.lang.String a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str, "$this$substringBefore");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str2, "delimiter");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str3, "missingDelimiterValue");
        int iA = c_renamed.k_renamed.d_renamed.a_renamed((java.lang.CharSequence) str, str2, 0, false, 6, (java.lang.Object) null);
        if (iA == -1) {
            return str3;
        }
        java.lang.String strSubstring = str.substring(0, iA);
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(strSubstring, "(this as_renamed java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ java.lang.String b_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, java.lang.Object obj) {
        if ((i_renamed & 2) != 0) {
            str3 = str;
        }
        return c_renamed.k_renamed.d_renamed.b_renamed(str, str2, str3);
    }

    public static final java.lang.String b_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str, "$this$substringAfter");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str2, "delimiter");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str3, "missingDelimiterValue");
        int iA = c_renamed.k_renamed.d_renamed.a_renamed((java.lang.CharSequence) str, str2, 0, false, 6, (java.lang.Object) null);
        if (iA == -1) {
            return str3;
        }
        java.lang.String strSubstring = str.substring(iA + str2.length(), str.length());
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(strSubstring, "(this as_renamed java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ java.lang.String b_renamed(java.lang.String str, char c2, java.lang.String str2, int i_renamed, java.lang.Object obj) {
        if ((i_renamed & 2) != 0) {
            str2 = str;
        }
        return c_renamed.k_renamed.d_renamed.b_renamed(str, c2, str2);
    }

    public static final java.lang.String b_renamed(java.lang.String str, char c2, java.lang.String str2) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str, "$this$substringAfterLast");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str2, "missingDelimiterValue");
        int iB = c_renamed.k_renamed.d_renamed.b_renamed((java.lang.CharSequence) str, c2, 0, false, 6, (java.lang.Object) null);
        if (iB == -1) {
            return str2;
        }
        java.lang.String strSubstring = str.substring(iB + 1, str.length());
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(strSubstring, "(this as_renamed java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final boolean a_renamed(java.lang.CharSequence charSequence, int i_renamed, java.lang.CharSequence charSequence2, int i2, int i3, boolean z_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(charSequence, "$this$regionMatchesImpl");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(charSequence2, "other");
        if (i2 < 0 || i_renamed < 0 || i_renamed > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!c_renamed.k_renamed.a_renamed.a_renamed(charSequence.charAt(i_renamed + i4), charSequence2.charAt(i2 + i4), z_renamed)) {
                return false;
            }
        }
        return true;
    }

    public static final int a_renamed(java.lang.CharSequence charSequence, char[] cArr, int i_renamed, boolean z_renamed) {
        boolean z2;
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(charSequence, "$this$indexOfAny");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cArr, "chars");
        if (!z_renamed && cArr.length == 1 && (charSequence instanceof java.lang.String)) {
            return ((java.lang.String) charSequence).indexOf(c_renamed.a_renamed.b_renamed.a_renamed(cArr), i_renamed);
        }
        int iB = c_renamed.h_renamed.d_renamed.b_renamed(i_renamed, 0);
        int iB2 = c_renamed.k_renamed.d_renamed.b_renamed(charSequence);
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
                if (c_renamed.k_renamed.a_renamed.a_renamed(cArr[i2], cCharAt, z_renamed)) {
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

    public static final int b_renamed(java.lang.CharSequence charSequence, char[] cArr, int i_renamed, boolean z_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(charSequence, "$this$lastIndexOfAny");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cArr, "chars");
        if (!z_renamed && cArr.length == 1 && (charSequence instanceof java.lang.String)) {
            return ((java.lang.String) charSequence).lastIndexOf(c_renamed.a_renamed.b_renamed.a_renamed(cArr), i_renamed);
        }
        for (int iC = c_renamed.h_renamed.d_renamed.c_renamed(i_renamed, c_renamed.k_renamed.d_renamed.b_renamed(charSequence)); iC >= 0; iC--) {
            char cCharAt = charSequence.charAt(iC);
            int length = cArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (c_renamed.k_renamed.a_renamed.a_renamed(cArr[i2], cCharAt, z_renamed)) {
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

    static /* synthetic */ int a_renamed(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, int i_renamed, int i2, boolean z_renamed, boolean z2, int i3, java.lang.Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return a_renamed(charSequence, charSequence2, i_renamed, i2, z_renamed, z2);
    }

    private static final int a_renamed(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, int i_renamed, int i2, boolean z_renamed, boolean z2) {
        c_renamed.h_renamed.c_renamed cVarA;
        if (!z2) {
            cVarA = new c_renamed.h_renamed.c_renamed(c_renamed.h_renamed.d_renamed.b_renamed(i_renamed, 0), c_renamed.h_renamed.d_renamed.c_renamed(i2, charSequence.length()));
        } else {
            cVarA = c_renamed.h_renamed.d_renamed.a_renamed(c_renamed.h_renamed.d_renamed.c_renamed(i_renamed, c_renamed.k_renamed.d_renamed.b_renamed(charSequence)), c_renamed.h_renamed.d_renamed.b_renamed(i2, 0));
        }
        if ((charSequence instanceof java.lang.String) && (charSequence2 instanceof java.lang.String)) {
            int iA = cVarA.a_renamed();
            int iB = cVarA.b_renamed();
            int iC = cVarA.c_renamed();
            if (iC >= 0) {
                if (iA > iB) {
                    return -1;
                }
            } else if (iA < iB) {
                return -1;
            }
            while (!c_renamed.k_renamed.d_renamed.a_renamed((java.lang.String) charSequence2, 0, (java.lang.String) charSequence, iA, charSequence2.length(), z_renamed)) {
                if (iA == iB) {
                    return -1;
                }
                iA += iC;
            }
            return iA;
        }
        int iA2 = cVarA.a_renamed();
        int iB2 = cVarA.b_renamed();
        int iC2 = cVarA.c_renamed();
        if (iC2 >= 0) {
            if (iA2 > iB2) {
                return -1;
            }
        } else if (iA2 < iB2) {
            return -1;
        }
        while (!c_renamed.k_renamed.d_renamed.a_renamed(charSequence2, 0, charSequence, iA2, charSequence2.length(), z_renamed)) {
            if (iA2 == iB2) {
                return -1;
            }
            iA2 += iC2;
        }
        return iA2;
    }

    public static /* synthetic */ int a_renamed(java.lang.CharSequence charSequence, char c2, int i_renamed, boolean z_renamed, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i_renamed = 0;
        }
        if ((i2 & 4) != 0) {
            z_renamed = false;
        }
        return c_renamed.k_renamed.d_renamed.a_renamed(charSequence, c2, i_renamed, z_renamed);
    }

    public static final int a_renamed(java.lang.CharSequence charSequence, char c2, int i_renamed, boolean z_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(charSequence, "$this$indexOf");
        return (z_renamed || !(charSequence instanceof java.lang.String)) ? c_renamed.k_renamed.d_renamed.a_renamed(charSequence, new char[]{c2}, i_renamed, z_renamed) : ((java.lang.String) charSequence).indexOf(c2, i_renamed);
    }

    public static /* synthetic */ int a_renamed(java.lang.CharSequence charSequence, java.lang.String str, int i_renamed, boolean z_renamed, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i_renamed = 0;
        }
        if ((i2 & 4) != 0) {
            z_renamed = false;
        }
        return c_renamed.k_renamed.d_renamed.a_renamed(charSequence, str, i_renamed, z_renamed);
    }

    public static final int a_renamed(java.lang.CharSequence charSequence, java.lang.String str, int i_renamed, boolean z_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(charSequence, "$this$indexOf");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str, "string");
        if (z_renamed || !(charSequence instanceof java.lang.String)) {
            return a_renamed(charSequence, str, i_renamed, charSequence.length(), z_renamed, false, 16, null);
        }
        return ((java.lang.String) charSequence).indexOf(str, i_renamed);
    }

    public static /* synthetic */ int b_renamed(java.lang.CharSequence charSequence, char c2, int i_renamed, boolean z_renamed, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i_renamed = c_renamed.k_renamed.d_renamed.b_renamed(charSequence);
        }
        if ((i2 & 4) != 0) {
            z_renamed = false;
        }
        return c_renamed.k_renamed.d_renamed.b_renamed(charSequence, c2, i_renamed, z_renamed);
    }

    public static final int b_renamed(java.lang.CharSequence charSequence, char c2, int i_renamed, boolean z_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(charSequence, "$this$lastIndexOf");
        return (z_renamed || !(charSequence instanceof java.lang.String)) ? c_renamed.k_renamed.d_renamed.b_renamed(charSequence, new char[]{c2}, i_renamed, z_renamed) : ((java.lang.String) charSequence).lastIndexOf(c2, i_renamed);
    }

    public static /* synthetic */ int b_renamed(java.lang.CharSequence charSequence, java.lang.String str, int i_renamed, boolean z_renamed, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i_renamed = c_renamed.k_renamed.d_renamed.b_renamed(charSequence);
        }
        if ((i2 & 4) != 0) {
            z_renamed = false;
        }
        return c_renamed.k_renamed.d_renamed.b_renamed(charSequence, str, i_renamed, z_renamed);
    }

    public static final int b_renamed(java.lang.CharSequence charSequence, java.lang.String str, int i_renamed, boolean z_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(charSequence, "$this$lastIndexOf");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str, "string");
        if (z_renamed || !(charSequence instanceof java.lang.String)) {
            return a_renamed(charSequence, (java.lang.CharSequence) str, i_renamed, 0, z_renamed, true);
        }
        return ((java.lang.String) charSequence).lastIndexOf(str, i_renamed);
    }

    public static final java.lang.CharSequence a_renamed(java.lang.CharSequence charSequence) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i_renamed = 0;
        boolean z_renamed = false;
        while (i_renamed <= length) {
            boolean zA = c_renamed.k_renamed.a_renamed.a_renamed(charSequence.charAt(!z_renamed ? i_renamed : length));
            if (z_renamed) {
                if (!zA) {
                    break;
                }
                length--;
            } else if (zA) {
                i_renamed++;
            } else {
                z_renamed = true;
            }
        }
        return charSequence.subSequence(i_renamed, length + 1);
    }
}

package androidx.core.f_renamed;

/* compiled from: BidiFormatter.java */
/* loaded from: classes.dex */
public final class a_renamed {
    private final boolean f_renamed;
    private final int g_renamed;
    private final androidx.core.f_renamed.d_renamed h_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    static final androidx.core.f_renamed.d_renamed f886a = androidx.core.f_renamed.e_renamed.f908c;
    private static final java.lang.String d_renamed = java.lang.Character.toString(8206);
    private static final java.lang.String e_renamed = java.lang.Character.toString(8207);

    /* renamed from: b_renamed, reason: collision with root package name */
    static final androidx.core.f_renamed.a_renamed f887b = new androidx.core.f_renamed.a_renamed(false, 2, f886a);

    /* renamed from: c_renamed, reason: collision with root package name */
    static final androidx.core.f_renamed.a_renamed f888c = new androidx.core.f_renamed.a_renamed(true, 2, f886a);

    /* compiled from: BidiFormatter.java */
    /* renamed from: androidx.core.f_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public static final class BidiFormatter_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        private boolean f889a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f890b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private androidx.core.f_renamed.d_renamed f891c;

        public BidiFormatter_2() {
            a_renamed(androidx.core.f_renamed.a_renamed.a_renamed(java.util.Locale.getDefault()));
        }

        public BidiFormatter_2(boolean z_renamed) {
            a_renamed(z_renamed);
        }

        private void a_renamed(boolean z_renamed) {
            this.f889a = z_renamed;
            this.f891c = androidx.core.f_renamed.a_renamed.f886a;
            this.f890b = 2;
        }

        private static androidx.core.f_renamed.a_renamed b_renamed(boolean z_renamed) {
            return z_renamed ? androidx.core.f_renamed.a_renamed.f888c : androidx.core.f_renamed.a_renamed.f887b;
        }

        public androidx.core.f_renamed.a_renamed a_renamed() {
            if (this.f890b == 2 && this.f891c == androidx.core.f_renamed.a_renamed.f886a) {
                return b_renamed(this.f889a);
            }
            return new androidx.core.f_renamed.a_renamed(this.f889a, this.f890b, this.f891c);
        }
    }

    public static androidx.core.f_renamed.a_renamed a_renamed() {
        return new androidx.core.f_renamed.a_renamed.BidiFormatter_2().a_renamed();
    }

    public static androidx.core.f_renamed.a_renamed a_renamed(boolean z_renamed) {
        return new androidx.core.f_renamed.a_renamed.BidiFormatter_2(z_renamed).a_renamed();
    }

    a_renamed(boolean z_renamed, int i_renamed, androidx.core.f_renamed.d_renamed dVar) {
        this.f_renamed = z_renamed;
        this.g_renamed = i_renamed;
        this.h_renamed = dVar;
    }

    public boolean b_renamed() {
        return (this.g_renamed & 2) != 0;
    }

    private java.lang.String b_renamed(java.lang.CharSequence charSequence, androidx.core.f_renamed.d_renamed dVar) {
        boolean zA = dVar.a_renamed(charSequence, 0, charSequence.length());
        if (this.f_renamed || !(zA || b_renamed(charSequence) == 1)) {
            return this.f_renamed ? (!zA || b_renamed(charSequence) == -1) ? e_renamed : "" : "";
        }
        return d_renamed;
    }

    private java.lang.String c_renamed(java.lang.CharSequence charSequence, androidx.core.f_renamed.d_renamed dVar) {
        boolean zA = dVar.a_renamed(charSequence, 0, charSequence.length());
        if (this.f_renamed || !(zA || c_renamed(charSequence) == 1)) {
            return this.f_renamed ? (!zA || c_renamed(charSequence) == -1) ? e_renamed : "" : "";
        }
        return d_renamed;
    }

    public java.lang.String a_renamed(java.lang.String str, androidx.core.f_renamed.d_renamed dVar, boolean z_renamed) {
        if (str == null) {
            return null;
        }
        return a_renamed((java.lang.CharSequence) str, dVar, z_renamed).toString();
    }

    public java.lang.CharSequence a_renamed(java.lang.CharSequence charSequence, androidx.core.f_renamed.d_renamed dVar, boolean z_renamed) {
        if (charSequence == null) {
            return null;
        }
        boolean zA = dVar.a_renamed(charSequence, 0, charSequence.length());
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        if (b_renamed() && z_renamed) {
            spannableStringBuilder.append((java.lang.CharSequence) c_renamed(charSequence, zA ? androidx.core.f_renamed.e_renamed.f907b : androidx.core.f_renamed.e_renamed.f906a));
        }
        if (zA != this.f_renamed) {
            spannableStringBuilder.append(zA ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z_renamed) {
            spannableStringBuilder.append((java.lang.CharSequence) b_renamed(charSequence, zA ? androidx.core.f_renamed.e_renamed.f907b : androidx.core.f_renamed.e_renamed.f906a));
        }
        return spannableStringBuilder;
    }

    public java.lang.CharSequence a_renamed(java.lang.CharSequence charSequence, androidx.core.f_renamed.d_renamed dVar) {
        return a_renamed(charSequence, dVar, true);
    }

    public java.lang.String a_renamed(java.lang.String str) {
        return a_renamed(str, this.h_renamed, true);
    }

    public java.lang.CharSequence a_renamed(java.lang.CharSequence charSequence) {
        return a_renamed(charSequence, this.h_renamed, true);
    }

    static boolean a_renamed(java.util.Locale locale) {
        return androidx.core.f_renamed.f_renamed.a_renamed(locale) == 1;
    }

    private static int b_renamed(java.lang.CharSequence charSequence) {
        return new androidx.core.f_renamed.a_renamed.b_renamed(charSequence, false).b_renamed();
    }

    private static int c_renamed(java.lang.CharSequence charSequence) {
        return new androidx.core.f_renamed.a_renamed.b_renamed(charSequence, false).a_renamed();
    }

    /* compiled from: BidiFormatter.java */
    private static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final byte[] f892a = new byte[1792];

        /* renamed from: b_renamed, reason: collision with root package name */
        private final java.lang.CharSequence f893b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final boolean f894c;
        private final int d_renamed;
        private int e_renamed;
        private char f_renamed;

        static {
            for (int i_renamed = 0; i_renamed < 1792; i_renamed++) {
                f892a[i_renamed] = java.lang.Character.getDirectionality(i_renamed);
            }
        }

        b_renamed(java.lang.CharSequence charSequence, boolean z_renamed) {
            this.f893b = charSequence;
            this.f894c = z_renamed;
            this.d_renamed = charSequence.length();
        }

        int a_renamed() {
            this.e_renamed = 0;
            int i_renamed = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.e_renamed < this.d_renamed && i_renamed == 0) {
                byte bC_renamed = c_renamed();
                if (bC_renamed != 0) {
                    if (bC_renamed == 1 || bC_renamed == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (bC_renamed != 9) {
                        switch (bC_renamed) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i_renamed = i3;
            }
            if (i_renamed == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.e_renamed > 0) {
                switch (d_renamed()) {
                    case 14:
                    case 15:
                        if (i_renamed == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i_renamed == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        int b_renamed() {
            this.e_renamed = this.d_renamed;
            int i_renamed = 0;
            int i2 = 0;
            while (this.e_renamed > 0) {
                byte bD_renamed = d_renamed();
                if (bD_renamed != 0) {
                    if (bD_renamed == 1 || bD_renamed == 2) {
                        if (i2 == 0) {
                            return 1;
                        }
                        if (i_renamed == 0) {
                            i_renamed = i2;
                        }
                    } else if (bD_renamed != 9) {
                        switch (bD_renamed) {
                            case 14:
                            case 15:
                                if (i_renamed == i2) {
                                    return -1;
                                }
                                i2--;
                                break;
                            case 16:
                            case 17:
                                if (i_renamed == i2) {
                                    return 1;
                                }
                                i2--;
                                break;
                            case 18:
                                i2++;
                                break;
                            default:
                                if (i_renamed != 0) {
                                    break;
                                } else {
                                    i_renamed = i2;
                                    break;
                                }
                        }
                    } else {
                        continue;
                    }
                } else {
                    if (i2 == 0) {
                        return -1;
                    }
                    if (i_renamed == 0) {
                        i_renamed = i2;
                    }
                }
            }
            return 0;
        }

        private static byte a_renamed(char c2) {
            return c2 < 1792 ? f892a[c2] : java.lang.Character.getDirectionality(c2);
        }

        byte c_renamed() {
            this.f_renamed = this.f893b.charAt(this.e_renamed);
            if (java.lang.Character.isHighSurrogate(this.f_renamed)) {
                int iCodePointAt = java.lang.Character.codePointAt(this.f893b, this.e_renamed);
                this.e_renamed += java.lang.Character.charCount(iCodePointAt);
                return java.lang.Character.getDirectionality(iCodePointAt);
            }
            this.e_renamed++;
            byte bA_renamed = a_renamed(this.f_renamed);
            if (!this.f894c) {
                return bA_renamed;
            }
            char c2 = this.f_renamed;
            if (c2 == '<') {
                return e_renamed();
            }
            return c2 == '&' ? g_renamed() : bA_renamed;
        }

        byte d_renamed() {
            this.f_renamed = this.f893b.charAt(this.e_renamed - 1);
            if (java.lang.Character.isLowSurrogate(this.f_renamed)) {
                int iCodePointBefore = java.lang.Character.codePointBefore(this.f893b, this.e_renamed);
                this.e_renamed -= java.lang.Character.charCount(iCodePointBefore);
                return java.lang.Character.getDirectionality(iCodePointBefore);
            }
            this.e_renamed--;
            byte bA_renamed = a_renamed(this.f_renamed);
            if (!this.f894c) {
                return bA_renamed;
            }
            char c2 = this.f_renamed;
            if (c2 == '>') {
                return f_renamed();
            }
            return c2 == ';' ? h_renamed() : bA_renamed;
        }

        private byte e_renamed() {
            char cCharAt;
            int i_renamed = this.e_renamed;
            while (true) {
                int i2 = this.e_renamed;
                if (i2 < this.d_renamed) {
                    java.lang.CharSequence charSequence = this.f893b;
                    this.e_renamed = i2 + 1;
                    this.f_renamed = charSequence.charAt(i2);
                    char c2 = this.f_renamed;
                    if (c2 == '>') {
                        return (byte) 12;
                    }
                    if (c2 == '\"' || c2 == '\'') {
                        char c3 = this.f_renamed;
                        do {
                            int i3 = this.e_renamed;
                            if (i3 < this.d_renamed) {
                                java.lang.CharSequence charSequence2 = this.f893b;
                                this.e_renamed = i3 + 1;
                                cCharAt = charSequence2.charAt(i3);
                                this.f_renamed = cCharAt;
                            }
                        } while (cCharAt != c3);
                    }
                } else {
                    this.e_renamed = i_renamed;
                    this.f_renamed = '<';
                    return (byte) 13;
                }
            }
        }

        private byte f_renamed() {
            char cCharAt;
            int i_renamed = this.e_renamed;
            while (true) {
                int i2 = this.e_renamed;
                if (i2 <= 0) {
                    break;
                }
                java.lang.CharSequence charSequence = this.f893b;
                int i3 = i2 - 1;
                this.e_renamed = i3;
                this.f_renamed = charSequence.charAt(i3);
                char c2 = this.f_renamed;
                if (c2 == '<') {
                    return (byte) 12;
                }
                if (c2 == '>') {
                    break;
                }
                if (c2 == '\"' || c2 == '\'') {
                    char c3 = this.f_renamed;
                    do {
                        int i4 = this.e_renamed;
                        if (i4 > 0) {
                            java.lang.CharSequence charSequence2 = this.f893b;
                            int i5 = i4 - 1;
                            this.e_renamed = i5;
                            cCharAt = charSequence2.charAt(i5);
                            this.f_renamed = cCharAt;
                        }
                    } while (cCharAt != c3);
                }
            }
            this.e_renamed = i_renamed;
            this.f_renamed = '>';
            return (byte) 13;
        }

        private byte g_renamed() {
            char cCharAt;
            do {
                int i_renamed = this.e_renamed;
                if (i_renamed >= this.d_renamed) {
                    return (byte) 12;
                }
                java.lang.CharSequence charSequence = this.f893b;
                this.e_renamed = i_renamed + 1;
                cCharAt = charSequence.charAt(i_renamed);
                this.f_renamed = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        private byte h_renamed() {
            char c2;
            int i_renamed = this.e_renamed;
            do {
                int i2 = this.e_renamed;
                if (i2 <= 0) {
                    break;
                }
                java.lang.CharSequence charSequence = this.f893b;
                int i3 = i2 - 1;
                this.e_renamed = i3;
                this.f_renamed = charSequence.charAt(i3);
                c2 = this.f_renamed;
                if (c2 == '&') {
                    return (byte) 12;
                }
            } while (c2 != ';');
            this.e_renamed = i_renamed;
            this.f_renamed = ';';
            return (byte) 13;
        }
    }
}

package androidx.core.p034f;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* compiled from: BidiFormatter.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public final class BidiFormatter {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final boolean f2894f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final int f2895g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final TextDirectionHeuristicCompat f2896h;

    /* renamed from: PlatformImplementations.kt_3 */
    static final TextDirectionHeuristicCompat f2889a = TextDirectionHeuristicsCompat.f2924c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final String f2892d = Character.toString(8206);

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final String f2893e = Character.toString(8207);

    /* renamed from: IntrinsicsJvm.kt_4 */
    static final BidiFormatter f2890b = new BidiFormatter(false, 2, f2889a);

    /* renamed from: IntrinsicsJvm.kt_3 */
    static final BidiFormatter f2891c = new BidiFormatter(true, 2, f2889a);

    /* compiled from: BidiFormatter.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean f2897a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f2898b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private TextDirectionHeuristicCompat f2899c;

        public PlatformImplementations.kt_3() {
            m2493a(BidiFormatter.m2482a(Locale.getDefault()));
        }

        public PlatformImplementations.kt_3(boolean z) {
            m2493a(z);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m2493a(boolean z) {
            this.f2897a = z;
            this.f2899c = BidiFormatter.f2889a;
            this.f2898b = 2;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private static BidiFormatter m2494b(boolean z) {
            return z ? BidiFormatter.f2891c : BidiFormatter.f2890b;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public BidiFormatter m2495a() {
            if (this.f2898b == 2 && this.f2899c == BidiFormatter.f2889a) {
                return m2494b(this.f2897a);
            }
            return new BidiFormatter(this.f2897a, this.f2898b, this.f2899c);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static BidiFormatter m2480a() {
        return new PlatformImplementations.kt_3().m2495a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static BidiFormatter m2481a(boolean z) {
        return new PlatformImplementations.kt_3(z).m2495a();
    }

    BidiFormatter(boolean z, int OplusGLSurfaceView_13, TextDirectionHeuristicCompat interfaceC0451d) {
        this.f2894f = z;
        this.f2895g = OplusGLSurfaceView_13;
        this.f2896h = interfaceC0451d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m2492b() {
        return (this.f2895g & 2) != 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m2484b(CharSequence charSequence, TextDirectionHeuristicCompat interfaceC0451d) {
        boolean zMo2519a = interfaceC0451d.mo2519a(charSequence, 0, charSequence.length());
        if (this.f2894f || !(zMo2519a || m2483b(charSequence) == 1)) {
            return this.f2894f ? (!zMo2519a || m2483b(charSequence) == -1) ? f2893e : "" : "";
        }
        return f2892d;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String m2486c(CharSequence charSequence, TextDirectionHeuristicCompat interfaceC0451d) {
        boolean zMo2519a = interfaceC0451d.mo2519a(charSequence, 0, charSequence.length());
        if (this.f2894f || !(zMo2519a || m2485c(charSequence) == 1)) {
            return this.f2894f ? (!zMo2519a || m2485c(charSequence) == -1) ? f2893e : "" : "";
        }
        return f2892d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m2491a(String str, TextDirectionHeuristicCompat interfaceC0451d, boolean z) {
        if (str == null) {
            return null;
        }
        return m2489a((CharSequence) str, interfaceC0451d, z).toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public CharSequence m2489a(CharSequence charSequence, TextDirectionHeuristicCompat interfaceC0451d, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean zMo2519a = interfaceC0451d.mo2519a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (m2492b() && z) {
            spannableStringBuilder.append((CharSequence) m2486c(charSequence, zMo2519a ? TextDirectionHeuristicsCompat.f2923b : TextDirectionHeuristicsCompat.f2922a));
        }
        if (zMo2519a != this.f2894f) {
            spannableStringBuilder.append(zMo2519a ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) m2484b(charSequence, zMo2519a ? TextDirectionHeuristicsCompat.f2923b : TextDirectionHeuristicsCompat.f2922a));
        }
        return spannableStringBuilder;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public CharSequence m2488a(CharSequence charSequence, TextDirectionHeuristicCompat interfaceC0451d) {
        return m2489a(charSequence, interfaceC0451d, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m2490a(String str) {
        return m2491a(str, this.f2896h, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public CharSequence m2487a(CharSequence charSequence) {
        return m2489a(charSequence, this.f2896h, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean m2482a(Locale locale) {
        return TextUtilsCompat.m2525a(locale) == 1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int m2483b(CharSequence charSequence) {
        return new IntrinsicsJvm.kt_4(charSequence, false).m2502b();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int m2485c(CharSequence charSequence) {
        return new IntrinsicsJvm.kt_4(charSequence, false).m2501a();
    }

    /* compiled from: BidiFormatter.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final byte[] f2900a = new byte[1792];

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final CharSequence f2901b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final boolean f2902c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final int f2903d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f2904e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private char f2905f;

        static {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 1792; OplusGLSurfaceView_13++) {
                f2900a[OplusGLSurfaceView_13] = Character.getDirectionality(OplusGLSurfaceView_13);
            }
        }

        IntrinsicsJvm.kt_4(CharSequence charSequence, boolean z) {
            this.f2901b = charSequence;
            this.f2902c = z;
            this.f2903d = charSequence.length();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m2501a() {
            this.f2904e = 0;
            int OplusGLSurfaceView_13 = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f2904e < this.f2903d && OplusGLSurfaceView_13 == 0) {
                byte bM2503c = m2503c();
                if (bM2503c != 0) {
                    if (bM2503c == 1 || bM2503c == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (bM2503c != 9) {
                        switch (bM2503c) {
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
                OplusGLSurfaceView_13 = i3;
            }
            if (OplusGLSurfaceView_13 == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f2904e > 0) {
                switch (m2504d()) {
                    case 14:
                    case 15:
                        if (OplusGLSurfaceView_13 == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (OplusGLSurfaceView_13 == i3) {
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

        /* renamed from: IntrinsicsJvm.kt_4 */
        int m2502b() {
            this.f2904e = this.f2903d;
            int OplusGLSurfaceView_13 = 0;
            int i2 = 0;
            while (this.f2904e > 0) {
                byte bM2504d = m2504d();
                if (bM2504d != 0) {
                    if (bM2504d == 1 || bM2504d == 2) {
                        if (i2 == 0) {
                            return 1;
                        }
                        if (OplusGLSurfaceView_13 == 0) {
                            OplusGLSurfaceView_13 = i2;
                        }
                    } else if (bM2504d != 9) {
                        switch (bM2504d) {
                            case 14:
                            case 15:
                                if (OplusGLSurfaceView_13 == i2) {
                                    return -1;
                                }
                                i2--;
                                break;
                            case 16:
                            case 17:
                                if (OplusGLSurfaceView_13 == i2) {
                                    return 1;
                                }
                                i2--;
                                break;
                            case 18:
                                i2++;
                                break;
                            default:
                                if (OplusGLSurfaceView_13 != 0) {
                                    break;
                                } else {
                                    OplusGLSurfaceView_13 = i2;
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
                    if (OplusGLSurfaceView_13 == 0) {
                        OplusGLSurfaceView_13 = i2;
                    }
                }
            }
            return 0;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private static byte m2496a(char c2) {
            return c2 < 1792 ? f2900a[c2] : Character.getDirectionality(c2);
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        byte m2503c() {
            this.f2905f = this.f2901b.charAt(this.f2904e);
            if (Character.isHighSurrogate(this.f2905f)) {
                int iCodePointAt = Character.codePointAt(this.f2901b, this.f2904e);
                this.f2904e += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f2904e++;
            byte bM2496a = m2496a(this.f2905f);
            if (!this.f2902c) {
                return bM2496a;
            }
            char c2 = this.f2905f;
            if (c2 == '<') {
                return m2497e();
            }
            return c2 == '&' ? m2499g() : bM2496a;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        byte m2504d() {
            this.f2905f = this.f2901b.charAt(this.f2904e - 1);
            if (Character.isLowSurrogate(this.f2905f)) {
                int iCodePointBefore = Character.codePointBefore(this.f2901b, this.f2904e);
                this.f2904e -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f2904e--;
            byte bM2496a = m2496a(this.f2905f);
            if (!this.f2902c) {
                return bM2496a;
            }
            char c2 = this.f2905f;
            if (c2 == '>') {
                return m2498f();
            }
            return c2 == ';' ? m2500h() : bM2496a;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        private byte m2497e() {
            char cCharAt;
            int OplusGLSurfaceView_13 = this.f2904e;
            while (true) {
                int i2 = this.f2904e;
                if (i2 < this.f2903d) {
                    CharSequence charSequence = this.f2901b;
                    this.f2904e = i2 + 1;
                    this.f2905f = charSequence.charAt(i2);
                    char c2 = this.f2905f;
                    if (c2 == '>') {
                        return (byte) 12;
                    }
                    if (c2 == '\"' || c2 == '\'') {
                        char c3 = this.f2905f;
                        do {
                            int i3 = this.f2904e;
                            if (i3 < this.f2903d) {
                                CharSequence charSequence2 = this.f2901b;
                                this.f2904e = i3 + 1;
                                cCharAt = charSequence2.charAt(i3);
                                this.f2905f = cCharAt;
                            }
                        } while (cCharAt != c3);
                    }
                } else {
                    this.f2904e = OplusGLSurfaceView_13;
                    this.f2905f = '<';
                    return (byte) 13;
                }
            }
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        private byte m2498f() {
            char cCharAt;
            int OplusGLSurfaceView_13 = this.f2904e;
            while (true) {
                int i2 = this.f2904e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2901b;
                int i3 = i2 - 1;
                this.f2904e = i3;
                this.f2905f = charSequence.charAt(i3);
                char c2 = this.f2905f;
                if (c2 == '<') {
                    return (byte) 12;
                }
                if (c2 == '>') {
                    break;
                }
                if (c2 == '\"' || c2 == '\'') {
                    char c3 = this.f2905f;
                    do {
                        int i4 = this.f2904e;
                        if (i4 > 0) {
                            CharSequence charSequence2 = this.f2901b;
                            int i5 = i4 - 1;
                            this.f2904e = i5;
                            cCharAt = charSequence2.charAt(i5);
                            this.f2905f = cCharAt;
                        }
                    } while (cCharAt != c3);
                }
            }
            this.f2904e = OplusGLSurfaceView_13;
            this.f2905f = '>';
            return (byte) 13;
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        private byte m2499g() {
            char cCharAt;
            do {
                int OplusGLSurfaceView_13 = this.f2904e;
                if (OplusGLSurfaceView_13 >= this.f2903d) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f2901b;
                this.f2904e = OplusGLSurfaceView_13 + 1;
                cCharAt = charSequence.charAt(OplusGLSurfaceView_13);
                this.f2905f = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        private byte m2500h() {
            char c2;
            int OplusGLSurfaceView_13 = this.f2904e;
            do {
                int i2 = this.f2904e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2901b;
                int i3 = i2 - 1;
                this.f2904e = i3;
                this.f2905f = charSequence.charAt(i3);
                c2 = this.f2905f;
                if (c2 == '&') {
                    return (byte) 12;
                }
            } while (c2 != ';');
            this.f2904e = OplusGLSurfaceView_13;
            this.f2905f = ';';
            return (byte) 13;
        }
    }
}

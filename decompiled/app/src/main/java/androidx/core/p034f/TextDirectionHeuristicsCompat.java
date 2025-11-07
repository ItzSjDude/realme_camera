package androidx.core.p034f;

import java.util.Locale;

/* compiled from: TextDirectionHeuristicsCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public final class TextDirectionHeuristicsCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final TextDirectionHeuristicCompat f2922a = new COUIBaseListPopupWindow_8(null, false);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final TextDirectionHeuristicCompat f2923b = new COUIBaseListPopupWindow_8(null, true);

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final TextDirectionHeuristicCompat f2924c = new COUIBaseListPopupWindow_8(IntrinsicsJvm.kt_4.f2930a, false);

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static final TextDirectionHeuristicCompat f2925d = new COUIBaseListPopupWindow_8(IntrinsicsJvm.kt_4.f2930a, true);

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static final TextDirectionHeuristicCompat f2926e = new COUIBaseListPopupWindow_8(PlatformImplementations.kt_3.f2928a, false);

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static final TextDirectionHeuristicCompat f2927f = COUIBaseListPopupWindow_12.f2933a;

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_3 */
    private interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        int mo2522a(CharSequence charSequence, int OplusGLSurfaceView_13, int i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m2520a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            return (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2) ? 0 : 2;
        }
        return 1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static int m2521b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2) {
                return 0;
            }
            switch (OplusGLSurfaceView_13) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5 */
    private static abstract class IntrinsicsJvm.kt_5 implements TextDirectionHeuristicCompat {

        /* renamed from: PlatformImplementations.kt_3 */
        private final IntrinsicsJvm.kt_3 f2931a;

        /* renamed from: PlatformImplementations.kt_3 */
        protected abstract boolean mo2524a();

        IntrinsicsJvm.kt_5(IntrinsicsJvm.kt_3 cVar) {
            this.f2931a = cVar;
        }

        @Override // androidx.core.p034f.TextDirectionHeuristicCompat
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo2519a(CharSequence charSequence, int OplusGLSurfaceView_13, int i2) {
            if (charSequence == null || OplusGLSurfaceView_13 < 0 || i2 < 0 || charSequence.length() - i2 < OplusGLSurfaceView_13) {
                throw new IllegalArgumentException();
            }
            if (this.f2931a == null) {
                return mo2524a();
            }
            return m2523b(charSequence, OplusGLSurfaceView_13, i2);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean m2523b(CharSequence charSequence, int OplusGLSurfaceView_13, int i2) {
            int iMo2522a = this.f2931a.mo2522a(charSequence, OplusGLSurfaceView_13, i2);
            if (iMo2522a == 0) {
                return true;
            }
            if (iMo2522a != 1) {
                return mo2524a();
            }
            return false;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_8$COUIBaseListPopupWindow_8 */
    private static class COUIBaseListPopupWindow_8 extends IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final boolean f2932a;

        COUIBaseListPopupWindow_8(IntrinsicsJvm.kt_3 cVar, boolean z) {
            super(cVar);
            this.f2932a = z;
        }

        @Override // androidx.core.p034f.TextDirectionHeuristicsCompat.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        protected boolean mo2524a() {
            return this.f2932a;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 implements IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final IntrinsicsJvm.kt_4 f2930a = new IntrinsicsJvm.kt_4();

        @Override // androidx.core.p034f.TextDirectionHeuristicsCompat.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo2522a(CharSequence charSequence, int OplusGLSurfaceView_13, int i2) {
            int i3 = i2 + OplusGLSurfaceView_13;
            int iM2521b = 2;
            while (OplusGLSurfaceView_13 < i3 && iM2521b == 2) {
                iM2521b = TextDirectionHeuristicsCompat.m2521b(Character.getDirectionality(charSequence.charAt(OplusGLSurfaceView_13)));
                OplusGLSurfaceView_13++;
            }
            return iM2521b;
        }

        private IntrinsicsJvm.kt_4() {
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 implements IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final PlatformImplementations.kt_3 f2928a = new PlatformImplementations.kt_3(true);

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final boolean f2929b;

        @Override // androidx.core.p034f.TextDirectionHeuristicsCompat.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo2522a(CharSequence charSequence, int OplusGLSurfaceView_13, int i2) {
            int i3 = i2 + OplusGLSurfaceView_13;
            boolean z = false;
            while (OplusGLSurfaceView_13 < i3) {
                int iM2520a = TextDirectionHeuristicsCompat.m2520a(Character.getDirectionality(charSequence.charAt(OplusGLSurfaceView_13)));
                if (iM2520a != 0) {
                    if (iM2520a != 1) {
                        continue;
                        OplusGLSurfaceView_13++;
                        z = z;
                    } else if (!this.f2929b) {
                        return 1;
                    }
                } else if (this.f2929b) {
                    return 0;
                }
                z = true;
                OplusGLSurfaceView_13++;
                z = z;
            }
            if (z) {
                return this.f2929b ? 1 : 0;
            }
            return 2;
        }

        private PlatformImplementations.kt_3(boolean z) {
            this.f2929b = z;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_8$COUIBaseListPopupWindow_12 */
    private static class COUIBaseListPopupWindow_12 extends IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final COUIBaseListPopupWindow_12 f2933a = new COUIBaseListPopupWindow_12();

        COUIBaseListPopupWindow_12() {
            super(null);
        }

        @Override // androidx.core.p034f.TextDirectionHeuristicsCompat.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        protected boolean mo2524a() {
            return TextUtilsCompat.m2525a(Locale.getDefault()) == 1;
        }
    }
}

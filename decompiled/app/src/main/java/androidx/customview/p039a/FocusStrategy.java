package androidx.customview.p039a;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: FocusStrategy.java */
/* renamed from: androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
class FocusStrategy {

    /* compiled from: FocusStrategy.java */
    /* renamed from: androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3<T> {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo3068a(T t, Rect rect);
    }

    /* compiled from: FocusStrategy.java */
    /* renamed from: androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4<T, V> {
        /* renamed from: PlatformImplementations.kt_3 */
        int mo3069a(T t);

        /* renamed from: PlatformImplementations.kt_3 */
        V mo3070a(T t, int OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m3071a(int OplusGLSurfaceView_13, int i2) {
        return (OplusGLSurfaceView_13 * 13 * OplusGLSurfaceView_13) + (i2 * i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <L, T> T m3072a(L OplusGLSurfaceView_14, IntrinsicsJvm.kt_4<L, T> bVar, PlatformImplementations.kt_3<T> aVar, T t, int OplusGLSurfaceView_13, boolean z, boolean z2) {
        int iMo3069a = bVar.mo3069a(OplusGLSurfaceView_14);
        ArrayList arrayList = new ArrayList(iMo3069a);
        for (int i2 = 0; i2 < iMo3069a; i2++) {
            arrayList.add(bVar.mo3070a(OplusGLSurfaceView_14, i2));
        }
        Collections.sort(arrayList, new IntrinsicsJvm.kt_3(z, aVar));
        if (OplusGLSurfaceView_13 == 1) {
            return (T) m3078b(t, arrayList, z2);
        }
        if (OplusGLSurfaceView_13 == 2) {
            return (T) m3074a(t, arrayList, z2);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T> T m3074a(T t, ArrayList<T> arrayList, boolean z) {
        int size = arrayList.size();
        int iLastIndexOf = (t == null ? -1 : arrayList.lastIndexOf(t)) + 1;
        if (iLastIndexOf < size) {
            return arrayList.get(iLastIndexOf);
        }
        if (!z || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static <T> T m3078b(T t, ArrayList<T> arrayList, boolean z) {
        int size = arrayList.size();
        int iIndexOf = (t == null ? size : arrayList.indexOf(t)) - 1;
        if (iIndexOf >= 0) {
            return arrayList.get(iIndexOf);
        }
        if (!z || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    /* compiled from: FocusStrategy.java */
    /* renamed from: androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_3 */
    private static class IntrinsicsJvm.kt_3<T> implements Comparator<T> {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Rect f3185a = new Rect();

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Rect f3186b = new Rect();

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final boolean f3187c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final PlatformImplementations.kt_3<T> f3188d;

        IntrinsicsJvm.kt_3(boolean z, PlatformImplementations.kt_3<T> aVar) {
            this.f3187c = z;
            this.f3188d = aVar;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            Rect rect = this.f3185a;
            Rect rect2 = this.f3186b;
            this.f3188d.mo3068a(t, rect);
            this.f3188d.mo3068a(t2, rect2);
            if (rect.top < rect2.top) {
                return -1;
            }
            if (rect.top > rect2.top) {
                return 1;
            }
            if (rect.left < rect2.left) {
                return this.f3187c ? 1 : -1;
            }
            if (rect.left > rect2.left) {
                return this.f3187c ? -1 : 1;
            }
            if (rect.bottom < rect2.bottom) {
                return -1;
            }
            if (rect.bottom > rect2.bottom) {
                return 1;
            }
            if (rect.right < rect2.right) {
                return this.f3187c ? 1 : -1;
            }
            if (rect.right > rect2.right) {
                return this.f3187c ? -1 : 1;
            }
            return 0;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <L, T> T m3073a(L OplusGLSurfaceView_14, IntrinsicsJvm.kt_4<L, T> bVar, PlatformImplementations.kt_3<T> aVar, T t, Rect rect, int OplusGLSurfaceView_13) {
        Rect rect2 = new Rect(rect);
        if (OplusGLSurfaceView_13 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (OplusGLSurfaceView_13 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (OplusGLSurfaceView_13 == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else if (OplusGLSurfaceView_13 == 130) {
            rect2.offset(0, -(rect.height() + 1));
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        T t2 = null;
        int iMo3069a = bVar.mo3069a(OplusGLSurfaceView_14);
        Rect rect3 = new Rect();
        for (int i2 = 0; i2 < iMo3069a; i2++) {
            T tMo3070a = bVar.mo3070a(OplusGLSurfaceView_14, i2);
            if (tMo3070a != t) {
                aVar.mo3068a(tMo3070a, rect3);
                if (m3076a(OplusGLSurfaceView_13, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t2 = tMo3070a;
                }
            }
        }
        return t2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m3076a(int OplusGLSurfaceView_13, Rect rect, Rect rect2, Rect rect3) {
        if (!m3077a(rect, rect2, OplusGLSurfaceView_13)) {
            return false;
        }
        if (m3077a(rect, rect3, OplusGLSurfaceView_13) && !m3080b(OplusGLSurfaceView_13, rect, rect2, rect3)) {
            return !m3080b(OplusGLSurfaceView_13, rect, rect3, rect2) && m3071a(m3081c(OplusGLSurfaceView_13, rect, rect2), m3085g(OplusGLSurfaceView_13, rect, rect2)) < m3071a(m3081c(OplusGLSurfaceView_13, rect, rect3), m3085g(OplusGLSurfaceView_13, rect, rect3));
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m3080b(int OplusGLSurfaceView_13, Rect rect, Rect rect2, Rect rect3) {
        boolean zM3075a = m3075a(OplusGLSurfaceView_13, rect, rect2);
        if (m3075a(OplusGLSurfaceView_13, rect, rect3) || !zM3075a) {
            return false;
        }
        return !m3079b(OplusGLSurfaceView_13, rect, rect3) || OplusGLSurfaceView_13 == 17 || OplusGLSurfaceView_13 == 66 || m3081c(OplusGLSurfaceView_13, rect, rect2) < m3083e(OplusGLSurfaceView_13, rect, rect3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m3077a(Rect rect, Rect rect2, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 17) {
            return (rect.right > rect2.right || rect.left >= rect2.right) && rect.left > rect2.left;
        }
        if (OplusGLSurfaceView_13 == 33) {
            return (rect.bottom > rect2.bottom || rect.top >= rect2.bottom) && rect.top > rect2.top;
        }
        if (OplusGLSurfaceView_13 == 66) {
            return (rect.left < rect2.left || rect.right <= rect2.left) && rect.right < rect2.right;
        }
        if (OplusGLSurfaceView_13 == 130) {
            return (rect.top < rect2.top || rect.bottom <= rect2.top) && rect.bottom < rect2.bottom;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m3075a(int OplusGLSurfaceView_13, Rect rect, Rect rect2) {
        if (OplusGLSurfaceView_13 != 17) {
            if (OplusGLSurfaceView_13 != 33) {
                if (OplusGLSurfaceView_13 != 66) {
                    if (OplusGLSurfaceView_13 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m3079b(int OplusGLSurfaceView_13, Rect rect, Rect rect2) {
        if (OplusGLSurfaceView_13 == 17) {
            return rect.left >= rect2.right;
        }
        if (OplusGLSurfaceView_13 == 33) {
            return rect.top >= rect2.bottom;
        }
        if (OplusGLSurfaceView_13 == 66) {
            return rect.right <= rect2.left;
        }
        if (OplusGLSurfaceView_13 == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int m3081c(int OplusGLSurfaceView_13, Rect rect, Rect rect2) {
        return Math.max(0, m3082d(OplusGLSurfaceView_13, rect, rect2));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static int m3082d(int OplusGLSurfaceView_13, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (OplusGLSurfaceView_13 == 17) {
            i2 = rect.left;
            i3 = rect2.right;
        } else if (OplusGLSurfaceView_13 == 33) {
            i2 = rect.top;
            i3 = rect2.bottom;
        } else if (OplusGLSurfaceView_13 == 66) {
            i2 = rect2.left;
            i3 = rect.right;
        } else if (OplusGLSurfaceView_13 == 130) {
            i2 = rect2.top;
            i3 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i2 - i3;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static int m3083e(int OplusGLSurfaceView_13, Rect rect, Rect rect2) {
        return Math.max(1, m3084f(OplusGLSurfaceView_13, rect, rect2));
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static int m3084f(int OplusGLSurfaceView_13, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (OplusGLSurfaceView_13 == 17) {
            i2 = rect.left;
            i3 = rect2.left;
        } else if (OplusGLSurfaceView_13 == 33) {
            i2 = rect.top;
            i3 = rect2.top;
        } else if (OplusGLSurfaceView_13 == 66) {
            i2 = rect2.right;
            i3 = rect.right;
        } else if (OplusGLSurfaceView_13 == 130) {
            i2 = rect2.bottom;
            i3 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i2 - i3;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static int m3085g(int OplusGLSurfaceView_13, Rect rect, Rect rect2) {
        if (OplusGLSurfaceView_13 != 17) {
            if (OplusGLSurfaceView_13 != 33) {
                if (OplusGLSurfaceView_13 != 66) {
                    if (OplusGLSurfaceView_13 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}

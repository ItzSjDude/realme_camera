package androidx.customview.a_renamed;

/* compiled from: FocusStrategy.java */
/* loaded from: classes.dex */
class b_renamed {

    /* compiled from: FocusStrategy.java */
    public interface a_renamed<T_renamed> {
        void a_renamed(T_renamed t_renamed, android.graphics.Rect rect);
    }

    /* compiled from: FocusStrategy.java */
    /* renamed from: androidx.customview.a_renamed.b_renamed$b_renamed, reason: collision with other inner class name */
    public interface FocusStrategy_3<T_renamed, V_renamed> {
        int a_renamed(T_renamed t_renamed);

        V_renamed a_renamed(T_renamed t_renamed, int i_renamed);
    }

    private static int a_renamed(int i_renamed, int i2) {
        return (i_renamed * 13 * i_renamed) + (i2 * i2);
    }

    public static <L_renamed, T_renamed> T_renamed a_renamed(L_renamed l_renamed, androidx.customview.a_renamed.b_renamed.FocusStrategy_3<L_renamed, T_renamed> interfaceC0026b, androidx.customview.a_renamed.b_renamed.a_renamed<T_renamed> aVar, T_renamed t_renamed, int i_renamed, boolean z_renamed, boolean z2) {
        int iA = interfaceC0026b.a_renamed(l_renamed);
        java.util.ArrayList arrayList = new java.util.ArrayList(iA);
        for (int i2 = 0; i2 < iA; i2++) {
            arrayList.add(interfaceC0026b.a_renamed(l_renamed, i2));
        }
        java.util.Collections.sort(arrayList, new androidx.customview.a_renamed.b_renamed.c_renamed(z_renamed, aVar));
        if (i_renamed == 1) {
            return (T_renamed) b_renamed(t_renamed, arrayList, z2);
        }
        if (i_renamed == 2) {
            return (T_renamed) a_renamed(t_renamed, arrayList, z2);
        }
        throw new java.lang.IllegalArgumentException("direction must be_renamed one of_renamed {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    private static <T_renamed> T_renamed a_renamed(T_renamed t_renamed, java.util.ArrayList<T_renamed> arrayList, boolean z_renamed) {
        int size = arrayList.size();
        int iLastIndexOf = (t_renamed == null ? -1 : arrayList.lastIndexOf(t_renamed)) + 1;
        if (iLastIndexOf < size) {
            return arrayList.get(iLastIndexOf);
        }
        if (!z_renamed || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    private static <T_renamed> T_renamed b_renamed(T_renamed t_renamed, java.util.ArrayList<T_renamed> arrayList, boolean z_renamed) {
        int size = arrayList.size();
        int iIndexOf = (t_renamed == null ? size : arrayList.indexOf(t_renamed)) - 1;
        if (iIndexOf >= 0) {
            return arrayList.get(iIndexOf);
        }
        if (!z_renamed || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    /* compiled from: FocusStrategy.java */
    private static class c_renamed<T_renamed> implements java.util.Comparator<T_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final android.graphics.Rect f1037a = new android.graphics.Rect();

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.graphics.Rect f1038b = new android.graphics.Rect();

        /* renamed from: c_renamed, reason: collision with root package name */
        private final boolean f1039c;
        private final androidx.customview.a_renamed.b_renamed.a_renamed<T_renamed> d_renamed;

        c_renamed(boolean z_renamed, androidx.customview.a_renamed.b_renamed.a_renamed<T_renamed> aVar) {
            this.f1039c = z_renamed;
            this.d_renamed = aVar;
        }

        @Override // java.util.Comparator
        public int compare(T_renamed t_renamed, T_renamed t2) {
            android.graphics.Rect rect = this.f1037a;
            android.graphics.Rect rect2 = this.f1038b;
            this.d_renamed.a_renamed(t_renamed, rect);
            this.d_renamed.a_renamed(t2, rect2);
            if (rect.top < rect2.top) {
                return -1;
            }
            if (rect.top > rect2.top) {
                return 1;
            }
            if (rect.left < rect2.left) {
                return this.f1039c ? 1 : -1;
            }
            if (rect.left > rect2.left) {
                return this.f1039c ? -1 : 1;
            }
            if (rect.bottom < rect2.bottom) {
                return -1;
            }
            if (rect.bottom > rect2.bottom) {
                return 1;
            }
            if (rect.right < rect2.right) {
                return this.f1039c ? 1 : -1;
            }
            if (rect.right > rect2.right) {
                return this.f1039c ? -1 : 1;
            }
            return 0;
        }
    }

    public static <L_renamed, T_renamed> T_renamed a_renamed(L_renamed l_renamed, androidx.customview.a_renamed.b_renamed.FocusStrategy_3<L_renamed, T_renamed> interfaceC0026b, androidx.customview.a_renamed.b_renamed.a_renamed<T_renamed> aVar, T_renamed t_renamed, android.graphics.Rect rect, int i_renamed) {
        android.graphics.Rect rect2 = new android.graphics.Rect(rect);
        if (i_renamed == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i_renamed == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i_renamed == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else if (i_renamed == 130) {
            rect2.offset(0, -(rect.height() + 1));
        } else {
            throw new java.lang.IllegalArgumentException("direction must be_renamed one of_renamed {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        T_renamed t2 = null;
        int iA = interfaceC0026b.a_renamed(l_renamed);
        android.graphics.Rect rect3 = new android.graphics.Rect();
        for (int i2 = 0; i2 < iA; i2++) {
            T_renamed tA = interfaceC0026b.a_renamed(l_renamed, i2);
            if (tA != t_renamed) {
                aVar.a_renamed(tA, rect3);
                if (a_renamed(i_renamed, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t2 = tA;
                }
            }
        }
        return t2;
    }

    private static boolean a_renamed(int i_renamed, android.graphics.Rect rect, android.graphics.Rect rect2, android.graphics.Rect rect3) {
        if (!a_renamed(rect, rect2, i_renamed)) {
            return false;
        }
        if (a_renamed(rect, rect3, i_renamed) && !b_renamed(i_renamed, rect, rect2, rect3)) {
            return !b_renamed(i_renamed, rect, rect3, rect2) && a_renamed(c_renamed(i_renamed, rect, rect2), g_renamed(i_renamed, rect, rect2)) < a_renamed(c_renamed(i_renamed, rect, rect3), g_renamed(i_renamed, rect, rect3));
        }
        return true;
    }

    private static boolean b_renamed(int i_renamed, android.graphics.Rect rect, android.graphics.Rect rect2, android.graphics.Rect rect3) {
        boolean zA = a_renamed(i_renamed, rect, rect2);
        if (a_renamed(i_renamed, rect, rect3) || !zA) {
            return false;
        }
        return !b_renamed(i_renamed, rect, rect3) || i_renamed == 17 || i_renamed == 66 || c_renamed(i_renamed, rect, rect2) < e_renamed(i_renamed, rect, rect3);
    }

    private static boolean a_renamed(android.graphics.Rect rect, android.graphics.Rect rect2, int i_renamed) {
        if (i_renamed == 17) {
            return (rect.right > rect2.right || rect.left >= rect2.right) && rect.left > rect2.left;
        }
        if (i_renamed == 33) {
            return (rect.bottom > rect2.bottom || rect.top >= rect2.bottom) && rect.top > rect2.top;
        }
        if (i_renamed == 66) {
            return (rect.left < rect2.left || rect.right <= rect2.left) && rect.right < rect2.right;
        }
        if (i_renamed == 130) {
            return (rect.top < rect2.top || rect.bottom <= rect2.top) && rect.bottom < rect2.bottom;
        }
        throw new java.lang.IllegalArgumentException("direction must be_renamed one of_renamed {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static boolean a_renamed(int i_renamed, android.graphics.Rect rect, android.graphics.Rect rect2) {
        if (i_renamed != 17) {
            if (i_renamed != 33) {
                if (i_renamed != 66) {
                    if (i_renamed != 130) {
                        throw new java.lang.IllegalArgumentException("direction must be_renamed one of_renamed {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    private static boolean b_renamed(int i_renamed, android.graphics.Rect rect, android.graphics.Rect rect2) {
        if (i_renamed == 17) {
            return rect.left >= rect2.right;
        }
        if (i_renamed == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i_renamed == 66) {
            return rect.right <= rect2.left;
        }
        if (i_renamed == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new java.lang.IllegalArgumentException("direction must be_renamed one of_renamed {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int c_renamed(int i_renamed, android.graphics.Rect rect, android.graphics.Rect rect2) {
        return java.lang.Math.max(0, d_renamed(i_renamed, rect, rect2));
    }

    private static int d_renamed(int i_renamed, android.graphics.Rect rect, android.graphics.Rect rect2) {
        int i2;
        int i3;
        if (i_renamed == 17) {
            i2 = rect.left;
            i3 = rect2.right;
        } else if (i_renamed == 33) {
            i2 = rect.top;
            i3 = rect2.bottom;
        } else if (i_renamed == 66) {
            i2 = rect2.left;
            i3 = rect.right;
        } else if (i_renamed == 130) {
            i2 = rect2.top;
            i3 = rect.bottom;
        } else {
            throw new java.lang.IllegalArgumentException("direction must be_renamed one of_renamed {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i2 - i3;
    }

    private static int e_renamed(int i_renamed, android.graphics.Rect rect, android.graphics.Rect rect2) {
        return java.lang.Math.max(1, f_renamed(i_renamed, rect, rect2));
    }

    private static int f_renamed(int i_renamed, android.graphics.Rect rect, android.graphics.Rect rect2) {
        int i2;
        int i3;
        if (i_renamed == 17) {
            i2 = rect.left;
            i3 = rect2.left;
        } else if (i_renamed == 33) {
            i2 = rect.top;
            i3 = rect2.top;
        } else if (i_renamed == 66) {
            i2 = rect2.right;
            i3 = rect.right;
        } else if (i_renamed == 130) {
            i2 = rect2.bottom;
            i3 = rect.bottom;
        } else {
            throw new java.lang.IllegalArgumentException("direction must be_renamed one of_renamed {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i2 - i3;
    }

    private static int g_renamed(int i_renamed, android.graphics.Rect rect, android.graphics.Rect rect2) {
        if (i_renamed != 17) {
            if (i_renamed != 33) {
                if (i_renamed != 66) {
                    if (i_renamed != 130) {
                        throw new java.lang.IllegalArgumentException("direction must be_renamed one of_renamed {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return java.lang.Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return java.lang.Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}

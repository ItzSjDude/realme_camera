package com.coui.appcompat.p099a;

/* compiled from: COUICompatUtil.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class COUICompatUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static COUICompatUtil f6306a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final char[] f6307b = {'PlatformImplementations.kt_3', 'IntrinsicsJvm.kt_4', 'IntrinsicsJvm.kt_3', 'IntrinsicsJvm.kt_5', 'COUIBaseListPopupWindow_8', 'COUIBaseListPopupWindow_12', 'COUIBaseListPopupWindow_11', 'COUIBaseListPopupWindow_10', 'OplusGLSurfaceView_13', 'OplusGLSurfaceView_15', 'OplusGLSurfaceView_5', 'OplusGLSurfaceView_14', 'OplusGLSurfaceView_6', 'OplusGLSurfaceView_11', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '.'};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final int[] f6308c = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 8, 13, 13, 4, 17, 52, 21, 8, 4, 22, 52, 47, 8, 4, 22, 48, 17, 0, 15, 15, 4, 17};

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final int[] f6309d = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 14, 18, 52, 28, 14, 11, 14, 17, 27, 20, 8, 11, 3};

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final int[] f6310e = {6, 4, 19, 28, 14, 11, 14, 17, 40, 44, 47, 30, 43, 44, 34, 40, 39};

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final int[] f6311f = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 8, 13, 13, 4, 17, 52, 2, 14, 13, 19, 4, 13, 19, 52, 17, 4, 18, 52, 28, 14, 13, 5, 8, 6, 20, 17, 0, 19, 8, 14, 13, 48, 17, 0, 15, 15, 4, 17};

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final int[] f6312g = {0, 13, 3, 17, 14, 8, 3, 52, 21, 8, 4, 22, 52, 40, 15, 15, 14, 27, 0, 18, 4, 47, 8, 4, 22};

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static final int[] f6313h = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 2, 11, 8, 2, 10, 19, 14, 15};

    /* renamed from: OplusGLSurfaceView_13 */
    private static final int[] f6314i = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 8, 13, 13, 4, 17, 52, 22, 8, 3, 6, 4, 19, 52, 26, 1, 18, 37, 8, 18, 19, 47, 8, 4, 22, 48, 17, 0, 15, 15, 4, 17};

    /* renamed from: OplusGLSurfaceView_15 */
    private static final int[] f6315j = {17, 14, 52, 14, 15, 15, 14, 52, 19, 7, 4, 12, 4, 52, 21, 4, 17, 18, 8, 14, 13};

    private COUICompatUtil() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static COUICompatUtil m6393a() {
        if (f6306a == null) {
            synchronized (COUICompatUtil.class) {
                if (f6306a == null) {
                    f6306a = new COUICompatUtil();
                }
            }
        }
        return f6306a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m6394b() {
        int length = f6308c.length;
        char[] cArr = new char[length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            cArr[OplusGLSurfaceView_13] = f6307b[f6308c[OplusGLSurfaceView_13]];
        }
        return String.valueOf(cArr);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public String m6395c() {
        int length = f6309d.length;
        char[] cArr = new char[length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            cArr[OplusGLSurfaceView_13] = f6307b[f6309d[OplusGLSurfaceView_13]];
        }
        return String.valueOf(cArr);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m6396d() {
        int length = f6310e.length;
        char[] cArr = new char[length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            cArr[OplusGLSurfaceView_13] = f6307b[f6310e[OplusGLSurfaceView_13]];
        }
        return String.valueOf(cArr);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public String m6397e() {
        int length = f6311f.length;
        char[] cArr = new char[length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            cArr[OplusGLSurfaceView_13] = f6307b[f6311f[OplusGLSurfaceView_13]];
        }
        return String.valueOf(cArr);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public String m6398f() {
        int length = f6315j.length;
        char[] cArr = new char[length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            cArr[OplusGLSurfaceView_13] = f6307b[f6315j[OplusGLSurfaceView_13]];
        }
        return String.valueOf(cArr);
    }
}

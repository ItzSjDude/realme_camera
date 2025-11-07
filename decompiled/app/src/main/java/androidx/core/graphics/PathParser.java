package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: PathParser.java */
/* renamed from: androidx.core.graphics.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class PathParser {
    /* renamed from: PlatformImplementations.kt_3 */
    static float[] m2597a(float[] fArr, int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - OplusGLSurfaceView_13;
        int iMin = Math.min(i3, length - OplusGLSurfaceView_13);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, OplusGLSurfaceView_13, fArr2, 0, iMin);
        return fArr2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Path m2593a(String str) {
        Path path = new Path();
        IntrinsicsJvm.kt_4[] bVarArrM2600b = m2600b(str);
        if (bVarArrM2600b == null) {
            return null;
        }
        try {
            IntrinsicsJvm.kt_4.m2605a(bVarArrM2600b, path);
            return path;
        } catch (RuntimeException COUIBaseListPopupWindow_8) {
            throw new RuntimeException("Error in parsing " + str, COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static IntrinsicsJvm.kt_4[] m2600b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int OplusGLSurfaceView_13 = 1;
        int i2 = 0;
        while (OplusGLSurfaceView_13 < str.length()) {
            int iM2592a = m2592a(str, OplusGLSurfaceView_13);
            String strTrim = str.substring(i2, iM2592a).trim();
            if (strTrim.length() > 0) {
                m2595a((ArrayList<IntrinsicsJvm.kt_4>) arrayList, strTrim.charAt(0), m2601c(strTrim));
            }
            i2 = iM2592a;
            OplusGLSurfaceView_13 = iM2592a + 1;
        }
        if (OplusGLSurfaceView_13 - i2 == 1 && i2 < str.length()) {
            m2595a((ArrayList<IntrinsicsJvm.kt_4>) arrayList, str.charAt(i2), new float[0]);
        }
        return (IntrinsicsJvm.kt_4[]) arrayList.toArray(new IntrinsicsJvm.kt_4[arrayList.size()]);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static IntrinsicsJvm.kt_4[] m2598a(IntrinsicsJvm.kt_4[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        IntrinsicsJvm.kt_4[] bVarArr2 = new IntrinsicsJvm.kt_4[bVarArr.length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bVarArr.length; OplusGLSurfaceView_13++) {
            bVarArr2[OplusGLSurfaceView_13] = new IntrinsicsJvm.kt_4(bVarArr[OplusGLSurfaceView_13]);
        }
        return bVarArr2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2596a(IntrinsicsJvm.kt_4[] bVarArr, IntrinsicsJvm.kt_4[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bVarArr.length; OplusGLSurfaceView_13++) {
            if (bVarArr[OplusGLSurfaceView_13].f2972a != bVarArr2[OplusGLSurfaceView_13].f2972a || bVarArr[OplusGLSurfaceView_13].f2973b.length != bVarArr2[OplusGLSurfaceView_13].f2973b.length) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m2599b(IntrinsicsJvm.kt_4[] bVarArr, IntrinsicsJvm.kt_4[] bVarArr2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bVarArr2.length; OplusGLSurfaceView_13++) {
            bVarArr[OplusGLSurfaceView_13].f2972a = bVarArr2[OplusGLSurfaceView_13].f2972a;
            for (int i2 = 0; i2 < bVarArr2[OplusGLSurfaceView_13].f2973b.length; i2++) {
                bVarArr[OplusGLSurfaceView_13].f2973b[i2] = bVarArr2[OplusGLSurfaceView_13].f2973b[i2];
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m2592a(String str, int OplusGLSurfaceView_13) {
        while (OplusGLSurfaceView_13 < str.length()) {
            char cCharAt = str.charAt(OplusGLSurfaceView_13);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'PlatformImplementations.kt_3') * (cCharAt - 'z') <= 0) && cCharAt != 'COUIBaseListPopupWindow_8' && cCharAt != 'E') {
                return OplusGLSurfaceView_13;
            }
            OplusGLSurfaceView_13++;
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m2595a(ArrayList<IntrinsicsJvm.kt_4> arrayList, char c2, float[] fArr) {
        arrayList.add(new IntrinsicsJvm.kt_4(c2, fArr));
    }

    /* compiled from: PathParser.java */
    /* renamed from: androidx.core.graphics.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        int f2970a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean f2971b;

        PlatformImplementations.kt_3() {
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static float[] m2601c(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3();
            int length = str.length();
            int OplusGLSurfaceView_13 = 1;
            int i2 = 0;
            while (OplusGLSurfaceView_13 < length) {
                m2594a(str, OplusGLSurfaceView_13, aVar);
                int i3 = aVar.f2970a;
                if (OplusGLSurfaceView_13 < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(OplusGLSurfaceView_13, i3));
                    i2++;
                }
                OplusGLSurfaceView_13 = aVar.f2971b ? i3 : i3 + 1;
            }
            return m2597a(fArr, 0, i2);
        } catch (NumberFormatException COUIBaseListPopupWindow_8) {
            throw new RuntimeException("error in parsing \"" + str + "\"", COUIBaseListPopupWindow_8);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a A[LOOP:0: B:3:0x0007->B:24:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003d A[SYNTHETIC] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void m2594a(java.lang.String r8, int r9, androidx.core.graphics.PathParser.PlatformImplementations.kt_3 r10) {
        /*
            r0 = 0
            r10.f2971b = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3d
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L35
            r6 = 69
            if (r5 == r6) goto L33
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L33
            switch(r5) {
                case 44: goto L35;
                case 45: goto L2a;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L31
        L22:
            if (r3 != 0) goto L27
            r2 = r0
            r3 = r7
            goto L37
        L27:
            r10.f2971b = r7
            goto L35
        L2a:
            if (r1 == r9) goto L31
            if (r2 != 0) goto L31
            r10.f2971b = r7
            goto L35
        L31:
            r2 = r0
            goto L37
        L33:
            r2 = r7
            goto L37
        L35:
            r2 = r0
            r4 = r7
        L37:
            if (r4 == 0) goto L3a
            goto L3d
        L3a:
            int r1 = r1 + 1
            goto L7
        L3d:
            r10.f2970a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.m2594a(java.lang.String, int, androidx.core.graphics.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3):void");
    }

    /* compiled from: PathParser.java */
    /* renamed from: androidx.core.graphics.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public char f2972a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public float[] f2973b;

        IntrinsicsJvm.kt_4(char c2, float[] fArr) {
            this.f2972a = c2;
            this.f2973b = fArr;
        }

        IntrinsicsJvm.kt_4(IntrinsicsJvm.kt_4 bVar) {
            this.f2972a = bVar.f2972a;
            float[] fArr = bVar.f2973b;
            this.f2973b = PathParser.m2597a(fArr, 0, fArr.length);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static void m2605a(IntrinsicsJvm.kt_4[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c2 = 'OplusGLSurfaceView_6';
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bVarArr.length; OplusGLSurfaceView_13++) {
                m2604a(path, fArr, c2, bVarArr[OplusGLSurfaceView_13].f2972a, bVarArr[OplusGLSurfaceView_13].f2973b);
                c2 = bVarArr[OplusGLSurfaceView_13].f2972a;
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m2606a(IntrinsicsJvm.kt_4 bVar, IntrinsicsJvm.kt_4 bVar2, float COUIBaseListPopupWindow_12) {
            this.f2972a = bVar.f2972a;
            int OplusGLSurfaceView_13 = 0;
            while (true) {
                float[] fArr = bVar.f2973b;
                if (OplusGLSurfaceView_13 >= fArr.length) {
                    return;
                }
                this.f2973b[OplusGLSurfaceView_13] = (fArr[OplusGLSurfaceView_13] * (1.0f - COUIBaseListPopupWindow_12)) + (bVar2.f2973b[OplusGLSurfaceView_13] * COUIBaseListPopupWindow_12);
                OplusGLSurfaceView_13++;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* renamed from: PlatformImplementations.kt_3 */
        private static void m2604a(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int OplusGLSurfaceView_13;
            int i2;
            int i3;
            float COUIBaseListPopupWindow_12;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            char c4 = c3;
            boolean z = false;
            float f9 = fArr[0];
            float f10 = fArr[1];
            float f11 = fArr[2];
            float f12 = fArr[3];
            float f13 = fArr[4];
            float f14 = fArr[5];
            switch (c4) {
                case 'A':
                case 'PlatformImplementations.kt_3':
                    OplusGLSurfaceView_13 = 7;
                    i2 = OplusGLSurfaceView_13;
                    break;
                case 'C':
                case 'IntrinsicsJvm.kt_3':
                    OplusGLSurfaceView_13 = 6;
                    i2 = OplusGLSurfaceView_13;
                    break;
                case 'H':
                case 'V':
                case 'COUIBaseListPopupWindow_10':
                case 'v':
                    i2 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'OplusGLSurfaceView_14':
                case 'OplusGLSurfaceView_6':
                case 't':
                default:
                    i2 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f13, f14);
                    f9 = f13;
                    f11 = f9;
                    f10 = f14;
                    f12 = f10;
                    i2 = 2;
                    break;
            }
            float f15 = f9;
            float f16 = f10;
            float f17 = f13;
            float f18 = f14;
            int i4 = 0;
            char c5 = c2;
            while (i4 < fArr2.length) {
                if (c4 != 'A') {
                    if (c4 == 'C') {
                        i3 = i4;
                        int i5 = i3 + 2;
                        int i6 = i3 + 3;
                        int i7 = i3 + 4;
                        int i8 = i3 + 5;
                        path.cubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i5], fArr2[i6], fArr2[i7], fArr2[i8]);
                        f15 = fArr2[i7];
                        float f19 = fArr2[i8];
                        float f20 = fArr2[i5];
                        float f21 = fArr2[i6];
                        f16 = f19;
                        f12 = f21;
                        f11 = f20;
                    } else if (c4 == 'H') {
                        i3 = i4;
                        int i9 = i3 + 0;
                        path.lineTo(fArr2[i9], f16);
                        f15 = fArr2[i9];
                    } else if (c4 == 'Q') {
                        i3 = i4;
                        int i10 = i3 + 0;
                        int i11 = i3 + 1;
                        int i12 = i3 + 2;
                        int i13 = i3 + 3;
                        path.quadTo(fArr2[i10], fArr2[i11], fArr2[i12], fArr2[i13]);
                        float f22 = fArr2[i10];
                        float f23 = fArr2[i11];
                        f15 = fArr2[i12];
                        f16 = fArr2[i13];
                        f11 = f22;
                        f12 = f23;
                    } else if (c4 == 'V') {
                        i3 = i4;
                        int i14 = i3 + 0;
                        path.lineTo(f15, fArr2[i14]);
                        f16 = fArr2[i14];
                    } else if (c4 != 'PlatformImplementations.kt_3') {
                        if (c4 != 'IntrinsicsJvm.kt_3') {
                            if (c4 == 'COUIBaseListPopupWindow_10') {
                                int i15 = i4 + 0;
                                path.rLineTo(fArr2[i15], 0.0f);
                                f15 += fArr2[i15];
                            } else if (c4 != 'q') {
                                if (c4 == 'v') {
                                    int i16 = i4 + 0;
                                    path.rLineTo(0.0f, fArr2[i16]);
                                    f4 = fArr2[i16];
                                } else if (c4 == 'L') {
                                    int i17 = i4 + 0;
                                    int i18 = i4 + 1;
                                    path.lineTo(fArr2[i17], fArr2[i18]);
                                    f15 = fArr2[i17];
                                    f16 = fArr2[i18];
                                } else if (c4 == 'M') {
                                    int i19 = i4 + 0;
                                    f15 = fArr2[i19];
                                    int i20 = i4 + 1;
                                    f16 = fArr2[i20];
                                    if (i4 > 0) {
                                        path.lineTo(fArr2[i19], fArr2[i20]);
                                    } else {
                                        path.moveTo(fArr2[i19], fArr2[i20]);
                                        f18 = f16;
                                        f17 = f15;
                                    }
                                } else if (c4 == 'S') {
                                    if (c5 == 'IntrinsicsJvm.kt_3' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                        f15 = (f15 * 2.0f) - f11;
                                        f16 = (f16 * 2.0f) - f12;
                                    }
                                    float f24 = f16;
                                    int i21 = i4 + 0;
                                    int i22 = i4 + 1;
                                    int i23 = i4 + 2;
                                    int i24 = i4 + 3;
                                    path.cubicTo(f15, f24, fArr2[i21], fArr2[i22], fArr2[i23], fArr2[i24]);
                                    COUIBaseListPopupWindow_12 = fArr2[i21];
                                    f2 = fArr2[i22];
                                    f15 = fArr2[i23];
                                    f16 = fArr2[i24];
                                    f11 = COUIBaseListPopupWindow_12;
                                    f12 = f2;
                                } else if (c4 == 'T') {
                                    if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                        f15 = (f15 * 2.0f) - f11;
                                        f16 = (f16 * 2.0f) - f12;
                                    }
                                    int i25 = i4 + 0;
                                    int i26 = i4 + 1;
                                    path.quadTo(f15, f16, fArr2[i25], fArr2[i26]);
                                    float f25 = fArr2[i25];
                                    float f26 = fArr2[i26];
                                    f12 = f16;
                                    f11 = f15;
                                    i3 = i4;
                                    f15 = f25;
                                    f16 = f26;
                                } else if (c4 == 'OplusGLSurfaceView_14') {
                                    int i27 = i4 + 0;
                                    int i28 = i4 + 1;
                                    path.rLineTo(fArr2[i27], fArr2[i28]);
                                    f15 += fArr2[i27];
                                    f4 = fArr2[i28];
                                } else if (c4 == 'OplusGLSurfaceView_6') {
                                    int i29 = i4 + 0;
                                    f15 += fArr2[i29];
                                    int i30 = i4 + 1;
                                    f16 += fArr2[i30];
                                    if (i4 > 0) {
                                        path.rLineTo(fArr2[i29], fArr2[i30]);
                                    } else {
                                        path.rMoveTo(fArr2[i29], fArr2[i30]);
                                        f18 = f16;
                                        f17 = f15;
                                    }
                                } else if (c4 == 's') {
                                    if (c5 == 'IntrinsicsJvm.kt_3' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                        float f27 = f15 - f11;
                                        f5 = f16 - f12;
                                        f6 = f27;
                                    } else {
                                        f6 = 0.0f;
                                        f5 = 0.0f;
                                    }
                                    int i31 = i4 + 0;
                                    int i32 = i4 + 1;
                                    int i33 = i4 + 2;
                                    int i34 = i4 + 3;
                                    path.rCubicTo(f6, f5, fArr2[i31], fArr2[i32], fArr2[i33], fArr2[i34]);
                                    COUIBaseListPopupWindow_12 = fArr2[i31] + f15;
                                    f2 = fArr2[i32] + f16;
                                    f15 += fArr2[i33];
                                    f3 = fArr2[i34];
                                } else if (c4 == 't') {
                                    if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                        f7 = f15 - f11;
                                        f8 = f16 - f12;
                                    } else {
                                        f8 = 0.0f;
                                        f7 = 0.0f;
                                    }
                                    int i35 = i4 + 0;
                                    int i36 = i4 + 1;
                                    path.rQuadTo(f7, f8, fArr2[i35], fArr2[i36]);
                                    float f28 = f7 + f15;
                                    float f29 = f8 + f16;
                                    f15 += fArr2[i35];
                                    f16 += fArr2[i36];
                                    f12 = f29;
                                    f11 = f28;
                                }
                                f16 += f4;
                            } else {
                                int i37 = i4 + 0;
                                int i38 = i4 + 1;
                                int i39 = i4 + 2;
                                int i40 = i4 + 3;
                                path.rQuadTo(fArr2[i37], fArr2[i38], fArr2[i39], fArr2[i40]);
                                COUIBaseListPopupWindow_12 = fArr2[i37] + f15;
                                f2 = fArr2[i38] + f16;
                                f15 += fArr2[i39];
                                f3 = fArr2[i40];
                            }
                            i3 = i4;
                        } else {
                            int i41 = i4 + 2;
                            int i42 = i4 + 3;
                            int i43 = i4 + 4;
                            int i44 = i4 + 5;
                            path.rCubicTo(fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i41], fArr2[i42], fArr2[i43], fArr2[i44]);
                            COUIBaseListPopupWindow_12 = fArr2[i41] + f15;
                            f2 = fArr2[i42] + f16;
                            f15 += fArr2[i43];
                            f3 = fArr2[i44];
                        }
                        f16 += f3;
                        f11 = COUIBaseListPopupWindow_12;
                        f12 = f2;
                        i3 = i4;
                    } else {
                        int i45 = i4 + 5;
                        float f30 = fArr2[i45] + f15;
                        int i46 = i4 + 6;
                        float f31 = fArr2[i46] + f16;
                        float f32 = fArr2[i4 + 0];
                        float f33 = fArr2[i4 + 1];
                        float f34 = fArr2[i4 + 2];
                        float f35 = f15;
                        i3 = i4;
                        m2603a(path, f15, f16, f30, f31, f32, f33, f34, fArr2[i4 + 3] != 0.0f, fArr2[i4 + 4] != 0.0f);
                        f15 = f35 + fArr2[i45];
                        f16 += fArr2[i46];
                    }
                    i4 = i3 + i2;
                    c5 = c3;
                    c4 = c5;
                    z = false;
                } else {
                    i3 = i4;
                    int i47 = i3 + 5;
                    int i48 = i3 + 6;
                    m2603a(path, f15, f16, fArr2[i47], fArr2[i48], fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                    f15 = fArr2[i47];
                    f16 = fArr2[i48];
                }
                f12 = f16;
                f11 = f15;
                i4 = i3 + i2;
                c5 = c3;
                c4 = c5;
                z = false;
            }
            fArr[z ? 1 : 0] = f15;
            fArr[1] = f16;
            fArr[2] = f11;
            fArr[3] = f12;
            fArr[4] = f17;
            fArr[5] = f18;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private static void m2603a(Path path, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double IntrinsicsJvm.kt_5;
            double d2;
            double radians = Math.toRadians(f7);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d3 = COUIBaseListPopupWindow_12;
            double d4 = d3 * dCos;
            double d5 = f2;
            double d6 = f5;
            double d7 = (d4 + (d5 * dSin)) / d6;
            double d8 = ((-COUIBaseListPopupWindow_12) * dSin) + (d5 * dCos);
            double d9 = f6;
            double d10 = d8 / d9;
            double d11 = f4;
            double d12 = ((f3 * dCos) + (d11 * dSin)) / d6;
            double d13 = (((-f3) * dSin) + (d11 * dCos)) / d9;
            double d14 = d7 - d12;
            double d15 = d10 - d13;
            double d16 = (d7 + d12) / 2.0d;
            double d17 = (d10 + d13) / 2.0d;
            double d18 = (d14 * d14) + (d15 * d15);
            if (d18 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d19 = (1.0d / d18) - 0.25d;
            if (d19 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d18);
                float fSqrt = (float) (Math.sqrt(d18) / 1.99999d);
                m2603a(path, COUIBaseListPopupWindow_12, f2, f3, f4, f5 * fSqrt, f6 * fSqrt, f7, z, z2);
                return;
            }
            double dSqrt = Math.sqrt(d19);
            double d20 = d14 * dSqrt;
            double d21 = dSqrt * d15;
            if (z == z2) {
                IntrinsicsJvm.kt_5 = d16 - d21;
                d2 = d17 + d20;
            } else {
                IntrinsicsJvm.kt_5 = d16 + d21;
                d2 = d17 - d20;
            }
            double dAtan2 = Math.atan2(d10 - d2, d7 - IntrinsicsJvm.kt_5);
            double dAtan22 = Math.atan2(d13 - d2, d12 - IntrinsicsJvm.kt_5) - dAtan2;
            if (z2 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d22 = IntrinsicsJvm.kt_5 * d6;
            double d23 = d2 * d9;
            m2602a(path, (d22 * dCos) - (d23 * dSin), (d22 * dSin) + (d23 * dCos), d6, d9, d3, d5, radians, dAtan2, dAtan22);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private static void m2602a(Path path, double IntrinsicsJvm.kt_5, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int iCeil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d7);
            double dSin = Math.sin(d7);
            double dCos2 = Math.cos(d8);
            double dSin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * dCos;
            double d13 = d4 * dSin;
            double d14 = (d12 * dSin2) - (d13 * dCos2);
            double d15 = d11 * dSin;
            double d16 = d4 * dCos;
            double d17 = (dSin2 * d15) + (dCos2 * d16);
            double d18 = d9 / iCeil;
            double d19 = d6;
            double d20 = d17;
            double d21 = d14;
            int OplusGLSurfaceView_13 = 0;
            double d22 = d5;
            double d23 = d8;
            while (OplusGLSurfaceView_13 < iCeil) {
                double d24 = d23 + d18;
                double dSin3 = Math.sin(d24);
                double dCos3 = Math.cos(d24);
                double d25 = (IntrinsicsJvm.kt_5 + ((d10 * dCos) * dCos3)) - (d13 * dSin3);
                double d26 = d2 + (d10 * dSin * dCos3) + (d16 * dSin3);
                double d27 = (d12 * dSin3) - (d13 * dCos3);
                double d28 = (dSin3 * d15) + (dCos3 * d16);
                double d29 = d24 - d23;
                double dTan = Math.tan(d29 / 2.0d);
                double dSin4 = (Math.sin(d29) * (Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) (d22 + (d21 * dSin4)), (float) (d19 + (d20 * dSin4)), (float) (d25 - (dSin4 * d27)), (float) (d26 - (dSin4 * d28)), (float) d25, (float) d26);
                OplusGLSurfaceView_13++;
                d18 = d18;
                iCeil = iCeil;
                dSin = dSin;
                d19 = d26;
                d15 = d15;
                d23 = d24;
                d20 = d28;
                d21 = d27;
                dCos = dCos;
                d10 = d3;
                d22 = d25;
            }
        }
    }
}

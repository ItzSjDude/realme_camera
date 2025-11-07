package androidx.core.graphics;

/* compiled from: PathParser.java */
/* loaded from: classes.dex */
public class e_renamed {
    static float[] a_renamed(float[] fArr, int i_renamed, int i2) {
        if (i_renamed > i2) {
            throw new java.lang.IllegalArgumentException();
        }
        int length = fArr.length;
        if (i_renamed < 0 || i_renamed > length) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i_renamed;
        int iMin = java.lang.Math.min(i3, length - i_renamed);
        float[] fArr2 = new float[i3];
        java.lang.System.arraycopy(fArr, i_renamed, fArr2, 0, iMin);
        return fArr2;
    }

    public static android.graphics.Path a_renamed(java.lang.String str) {
        android.graphics.Path path = new android.graphics.Path();
        androidx.core.graphics.e_renamed.b_renamed[] bVarArrB = b_renamed(str);
        if (bVarArrB == null) {
            return null;
        }
        try {
            androidx.core.graphics.e_renamed.b_renamed.a_renamed(bVarArrB, path);
            return path;
        } catch (java.lang.RuntimeException e_renamed) {
            throw new java.lang.RuntimeException("Error in_renamed parsing " + str, e_renamed);
        }
    }

    public static androidx.core.graphics.e_renamed.b_renamed[] b_renamed(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i_renamed = 1;
        int i2 = 0;
        while (i_renamed < str.length()) {
            int iA = a_renamed(str, i_renamed);
            java.lang.String strTrim = str.substring(i2, iA).trim();
            if (strTrim.length() > 0) {
                a_renamed((java.util.ArrayList<androidx.core.graphics.e_renamed.b_renamed>) arrayList, strTrim.charAt(0), c_renamed(strTrim));
            }
            i2 = iA;
            i_renamed = iA + 1;
        }
        if (i_renamed - i2 == 1 && i2 < str.length()) {
            a_renamed((java.util.ArrayList<androidx.core.graphics.e_renamed.b_renamed>) arrayList, str.charAt(i2), new float[0]);
        }
        return (androidx.core.graphics.e_renamed.b_renamed[]) arrayList.toArray(new androidx.core.graphics.e_renamed.b_renamed[arrayList.size()]);
    }

    public static androidx.core.graphics.e_renamed.b_renamed[] a_renamed(androidx.core.graphics.e_renamed.b_renamed[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        androidx.core.graphics.e_renamed.b_renamed[] bVarArr2 = new androidx.core.graphics.e_renamed.b_renamed[bVarArr.length];
        for (int i_renamed = 0; i_renamed < bVarArr.length; i_renamed++) {
            bVarArr2[i_renamed] = new androidx.core.graphics.e_renamed.b_renamed(bVarArr[i_renamed]);
        }
        return bVarArr2;
    }

    public static boolean a_renamed(androidx.core.graphics.e_renamed.b_renamed[] bVarArr, androidx.core.graphics.e_renamed.b_renamed[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < bVarArr.length; i_renamed++) {
            if (bVarArr[i_renamed].f939a != bVarArr2[i_renamed].f939a || bVarArr[i_renamed].f940b.length != bVarArr2[i_renamed].f940b.length) {
                return false;
            }
        }
        return true;
    }

    public static void b_renamed(androidx.core.graphics.e_renamed.b_renamed[] bVarArr, androidx.core.graphics.e_renamed.b_renamed[] bVarArr2) {
        for (int i_renamed = 0; i_renamed < bVarArr2.length; i_renamed++) {
            bVarArr[i_renamed].f939a = bVarArr2[i_renamed].f939a;
            for (int i2 = 0; i2 < bVarArr2[i_renamed].f940b.length; i2++) {
                bVarArr[i_renamed].f940b[i2] = bVarArr2[i_renamed].f940b[i2];
            }
        }
    }

    private static int a_renamed(java.lang.String str, int i_renamed) {
        while (i_renamed < str.length()) {
            char cCharAt = str.charAt(i_renamed);
            if (((cCharAt - 'A_renamed') * (cCharAt - 'Z_renamed') <= 0 || (cCharAt - 'a_renamed') * (cCharAt - 'z_renamed') <= 0) && cCharAt != 'e_renamed' && cCharAt != 'E_renamed') {
                return i_renamed;
            }
            i_renamed++;
        }
        return i_renamed;
    }

    private static void a_renamed(java.util.ArrayList<androidx.core.graphics.e_renamed.b_renamed> arrayList, char c2, float[] fArr) {
        arrayList.add(new androidx.core.graphics.e_renamed.b_renamed(c2, fArr));
    }

    /* compiled from: PathParser.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f937a;

        /* renamed from: b_renamed, reason: collision with root package name */
        boolean f938b;

        a_renamed() {
        }
    }

    private static float[] c_renamed(java.lang.String str) {
        if (str.charAt(0) == 'z_renamed' || str.charAt(0) == 'Z_renamed') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            androidx.core.graphics.e_renamed.a_renamed aVar = new androidx.core.graphics.e_renamed.a_renamed();
            int length = str.length();
            int i_renamed = 1;
            int i2 = 0;
            while (i_renamed < length) {
                a_renamed(str, i_renamed, aVar);
                int i3 = aVar.f937a;
                if (i_renamed < i3) {
                    fArr[i2] = java.lang.Float.parseFloat(str.substring(i_renamed, i3));
                    i2++;
                }
                i_renamed = aVar.f938b ? i3 : i3 + 1;
            }
            return a_renamed(fArr, 0, i2);
        } catch (java.lang.NumberFormatException e_renamed) {
            throw new java.lang.RuntimeException("error in_renamed parsing \"" + str + "\"", e_renamed);
        }
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:24:0x003a A_renamed[LOOP:0: B_renamed:3:0x0007->B_renamed:24:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:28:0x003d A_renamed[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a_renamed(java.lang.String r8, int r9, androidx.core.graphics.e_renamed.a_renamed r10) {
        /*
            r0 = 0
            r10.f938b = r0
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
            r10.f938b = r7
            goto L35
        L2a:
            if (r1 == r9) goto L31
            if (r2 != 0) goto L31
            r10.f938b = r7
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
            r10.f937a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.e_renamed.a_renamed(java.lang.String, int, androidx.core.graphics.e_renamed$a_renamed):void");
    }

    /* compiled from: PathParser.java */
    public static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public char f939a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public float[] f940b;

        b_renamed(char c2, float[] fArr) {
            this.f939a = c2;
            this.f940b = fArr;
        }

        b_renamed(androidx.core.graphics.e_renamed.b_renamed bVar) {
            this.f939a = bVar.f939a;
            float[] fArr = bVar.f940b;
            this.f940b = androidx.core.graphics.e_renamed.a_renamed(fArr, 0, fArr.length);
        }

        public static void a_renamed(androidx.core.graphics.e_renamed.b_renamed[] bVarArr, android.graphics.Path path) {
            float[] fArr = new float[6];
            char c2 = 'm_renamed';
            for (int i_renamed = 0; i_renamed < bVarArr.length; i_renamed++) {
                a_renamed(path, fArr, c2, bVarArr[i_renamed].f939a, bVarArr[i_renamed].f940b);
                c2 = bVarArr[i_renamed].f939a;
            }
        }

        public void a_renamed(androidx.core.graphics.e_renamed.b_renamed bVar, androidx.core.graphics.e_renamed.b_renamed bVar2, float f_renamed) {
            this.f939a = bVar.f939a;
            int i_renamed = 0;
            while (true) {
                float[] fArr = bVar.f940b;
                if (i_renamed >= fArr.length) {
                    return;
                }
                this.f940b[i_renamed] = (fArr[i_renamed] * (1.0f - f_renamed)) + (bVar2.f940b[i_renamed] * f_renamed);
                i_renamed++;
            }
        }

        /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
        private static void a_renamed(android.graphics.Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i_renamed;
            int i2;
            int i3;
            float f_renamed;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            char c4 = c3;
            boolean z_renamed = false;
            float f9 = fArr[0];
            float f10 = fArr[1];
            float f11 = fArr[2];
            float f12 = fArr[3];
            float f13 = fArr[4];
            float f14 = fArr[5];
            switch (c4) {
                case 'A_renamed':
                case 'a_renamed':
                    i_renamed = 7;
                    i2 = i_renamed;
                    break;
                case 'C_renamed':
                case 'c_renamed':
                    i_renamed = 6;
                    i2 = i_renamed;
                    break;
                case 'H_renamed':
                case 'V_renamed':
                case 'h_renamed':
                case 'v_renamed':
                    i2 = 1;
                    break;
                case 'L_renamed':
                case 'M_renamed':
                case 'T_renamed':
                case 'l_renamed':
                case 'm_renamed':
                case 't_renamed':
                default:
                    i2 = 2;
                    break;
                case 'Q_renamed':
                case 'S_renamed':
                case 'q_renamed':
                case 's_renamed':
                    i2 = 4;
                    break;
                case 'Z_renamed':
                case 'z_renamed':
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
                if (c4 != 'A_renamed') {
                    if (c4 == 'C_renamed') {
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
                    } else if (c4 == 'H_renamed') {
                        i3 = i4;
                        int i9 = i3 + 0;
                        path.lineTo(fArr2[i9], f16);
                        f15 = fArr2[i9];
                    } else if (c4 == 'Q_renamed') {
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
                    } else if (c4 == 'V_renamed') {
                        i3 = i4;
                        int i14 = i3 + 0;
                        path.lineTo(f15, fArr2[i14]);
                        f16 = fArr2[i14];
                    } else if (c4 != 'a_renamed') {
                        if (c4 != 'c_renamed') {
                            if (c4 == 'h_renamed') {
                                int i15 = i4 + 0;
                                path.rLineTo(fArr2[i15], 0.0f);
                                f15 += fArr2[i15];
                            } else if (c4 != 'q_renamed') {
                                if (c4 == 'v_renamed') {
                                    int i16 = i4 + 0;
                                    path.rLineTo(0.0f, fArr2[i16]);
                                    f4 = fArr2[i16];
                                } else if (c4 == 'L_renamed') {
                                    int i17 = i4 + 0;
                                    int i18 = i4 + 1;
                                    path.lineTo(fArr2[i17], fArr2[i18]);
                                    f15 = fArr2[i17];
                                    f16 = fArr2[i18];
                                } else if (c4 == 'M_renamed') {
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
                                } else if (c4 == 'S_renamed') {
                                    if (c5 == 'c_renamed' || c5 == 's_renamed' || c5 == 'C_renamed' || c5 == 'S_renamed') {
                                        f15 = (f15 * 2.0f) - f11;
                                        f16 = (f16 * 2.0f) - f12;
                                    }
                                    float f24 = f16;
                                    int i21 = i4 + 0;
                                    int i22 = i4 + 1;
                                    int i23 = i4 + 2;
                                    int i24 = i4 + 3;
                                    path.cubicTo(f15, f24, fArr2[i21], fArr2[i22], fArr2[i23], fArr2[i24]);
                                    f_renamed = fArr2[i21];
                                    f2 = fArr2[i22];
                                    f15 = fArr2[i23];
                                    f16 = fArr2[i24];
                                    f11 = f_renamed;
                                    f12 = f2;
                                } else if (c4 == 'T_renamed') {
                                    if (c5 == 'q_renamed' || c5 == 't_renamed' || c5 == 'Q_renamed' || c5 == 'T_renamed') {
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
                                } else if (c4 == 'l_renamed') {
                                    int i27 = i4 + 0;
                                    int i28 = i4 + 1;
                                    path.rLineTo(fArr2[i27], fArr2[i28]);
                                    f15 += fArr2[i27];
                                    f4 = fArr2[i28];
                                } else if (c4 == 'm_renamed') {
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
                                } else if (c4 == 's_renamed') {
                                    if (c5 == 'c_renamed' || c5 == 's_renamed' || c5 == 'C_renamed' || c5 == 'S_renamed') {
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
                                    f_renamed = fArr2[i31] + f15;
                                    f2 = fArr2[i32] + f16;
                                    f15 += fArr2[i33];
                                    f3 = fArr2[i34];
                                } else if (c4 == 't_renamed') {
                                    if (c5 == 'q_renamed' || c5 == 't_renamed' || c5 == 'Q_renamed' || c5 == 'T_renamed') {
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
                                f_renamed = fArr2[i37] + f15;
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
                            f_renamed = fArr2[i41] + f15;
                            f2 = fArr2[i42] + f16;
                            f15 += fArr2[i43];
                            f3 = fArr2[i44];
                        }
                        f16 += f3;
                        f11 = f_renamed;
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
                        a_renamed(path, f15, f16, f30, f31, f32, f33, f34, fArr2[i4 + 3] != 0.0f, fArr2[i4 + 4] != 0.0f);
                        f15 = f35 + fArr2[i45];
                        f16 += fArr2[i46];
                    }
                    i4 = i3 + i2;
                    c5 = c3;
                    c4 = c5;
                    z_renamed = false;
                } else {
                    i3 = i4;
                    int i47 = i3 + 5;
                    int i48 = i3 + 6;
                    a_renamed(path, f15, f16, fArr2[i47], fArr2[i48], fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                    f15 = fArr2[i47];
                    f16 = fArr2[i48];
                }
                f12 = f16;
                f11 = f15;
                i4 = i3 + i2;
                c5 = c3;
                c4 = c5;
                z_renamed = false;
            }
            fArr[z_renamed ? 1 : 0] = f15;
            fArr[1] = f16;
            fArr[2] = f11;
            fArr[3] = f12;
            fArr[4] = f17;
            fArr[5] = f18;
        }

        private static void a_renamed(android.graphics.Path path, float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7, boolean z_renamed, boolean z2) {
            double d_renamed;
            double d2;
            double radians = java.lang.Math.toRadians(f7);
            double dCos = java.lang.Math.cos(radians);
            double dSin = java.lang.Math.sin(radians);
            double d3 = f_renamed;
            double d4 = d3 * dCos;
            double d5 = f2;
            double d6 = f5;
            double d7 = (d4 + (d5 * dSin)) / d6;
            double d8 = ((-f_renamed) * dSin) + (d5 * dCos);
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
                android.util.Log.w_renamed("PathParser", " Points are coincident");
                return;
            }
            double d19 = (1.0d / d18) - 0.25d;
            if (d19 < 0.0d) {
                android.util.Log.w_renamed("PathParser", "Points are too far apart " + d18);
                float fSqrt = (float) (java.lang.Math.sqrt(d18) / 1.99999d);
                a_renamed(path, f_renamed, f2, f3, f4, f5 * fSqrt, f6 * fSqrt, f7, z_renamed, z2);
                return;
            }
            double dSqrt = java.lang.Math.sqrt(d19);
            double d20 = d14 * dSqrt;
            double d21 = dSqrt * d15;
            if (z_renamed == z2) {
                d_renamed = d16 - d21;
                d2 = d17 + d20;
            } else {
                d_renamed = d16 + d21;
                d2 = d17 - d20;
            }
            double dAtan2 = java.lang.Math.atan2(d10 - d2, d7 - d_renamed);
            double dAtan22 = java.lang.Math.atan2(d13 - d2, d12 - d_renamed) - dAtan2;
            if (z2 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d22 = d_renamed * d6;
            double d23 = d2 * d9;
            a_renamed(path, (d22 * dCos) - (d23 * dSin), (d22 * dSin) + (d23 * dCos), d6, d9, d3, d5, radians, dAtan2, dAtan22);
        }

        private static void a_renamed(android.graphics.Path path, double d_renamed, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int iCeil = (int) java.lang.Math.ceil(java.lang.Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double dCos = java.lang.Math.cos(d7);
            double dSin = java.lang.Math.sin(d7);
            double dCos2 = java.lang.Math.cos(d8);
            double dSin2 = java.lang.Math.sin(d8);
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
            int i_renamed = 0;
            double d22 = d5;
            double d23 = d8;
            while (i_renamed < iCeil) {
                double d24 = d23 + d18;
                double dSin3 = java.lang.Math.sin(d24);
                double dCos3 = java.lang.Math.cos(d24);
                double d25 = (d_renamed + ((d10 * dCos) * dCos3)) - (d13 * dSin3);
                double d26 = d2 + (d10 * dSin * dCos3) + (d16 * dSin3);
                double d27 = (d12 * dSin3) - (d13 * dCos3);
                double d28 = (dSin3 * d15) + (dCos3 * d16);
                double d29 = d24 - d23;
                double dTan = java.lang.Math.tan(d29 / 2.0d);
                double dSin4 = (java.lang.Math.sin(d29) * (java.lang.Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) (d22 + (d21 * dSin4)), (float) (d19 + (d20 * dSin4)), (float) (d25 - (dSin4 * d27)), (float) (d26 - (dSin4 * d28)), (float) d25, (float) d26);
                i_renamed++;
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

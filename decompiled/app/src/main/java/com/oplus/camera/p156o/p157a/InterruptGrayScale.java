package com.oplus.camera.p156o.p157a;

import android.graphics.Rect;

/* compiled from: InterruptGrayScale.java */
/* renamed from: com.oplus.camera.o.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
class InterruptGrayScale implements Dispatch {
    InterruptGrayScale() {
    }

    @Override // com.oplus.camera.p156o.p157a.Dispatch
    /* renamed from: PlatformImplementations.kt_3 */
    public byte[] mo14799a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        int iRandom = ((int) (Math.random() * 3.0d)) + 1;
        Rect rect = new Rect(0, 0, OplusGLSurfaceView_13, i2);
        for (int i3 = 0; i3 < iRandom; i3++) {
            m14800a(bArr, OplusGLSurfaceView_13, rect, i3);
            m14801b(bArr, OplusGLSurfaceView_13, rect, i3);
        }
        return bArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14800a(byte[] bArr, int OplusGLSurfaceView_13, Rect rect, int i2) {
        int i3 = rect.top + i2;
        while (true) {
            int i4 = i3 + 2;
            if (i4 >= rect.bottom) {
                return;
            }
            int i5 = rect.left + i2;
            while (true) {
                int i6 = i5 + 2;
                if (i6 < rect.right) {
                    int i7 = 0;
                    int i8 = Integer.MAX_VALUE;
                    int i9 = 0;
                    int i10 = i3;
                    while (i10 < i4) {
                        int i11 = i8;
                        int i12 = i9;
                        int i13 = i7;
                        for (int i14 = i5; i14 < i6; i14++) {
                            int i15 = (i10 * OplusGLSurfaceView_13) + i14;
                            if ((bArr[i15] & 255) < 150) {
                                i13++;
                            }
                            i12 += bArr[i15] & 255;
                            if ((bArr[i15] & 255) < i11) {
                                i11 = bArr[i15] & 255;
                            }
                        }
                        i10++;
                        i7 = i13;
                        i9 = i12;
                        i8 = i11;
                    }
                    if (i7 != 0) {
                        int i16 = i9 / 4;
                        for (int i17 = i3; i17 < i4; i17++) {
                            for (int i18 = i5; i18 < i6; i18++) {
                                bArr[(i17 * OplusGLSurfaceView_13) + i18] = (byte) ((i8 / 5) * 4);
                            }
                        }
                    }
                    i5 = i6;
                }
            }
            i3 = i4;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14801b(byte[] bArr, int OplusGLSurfaceView_13, Rect rect, int i2) {
        int i3 = rect.top + i2;
        while (true) {
            int i4 = i3 + 2;
            if (i4 >= rect.bottom) {
                return;
            }
            int i5 = rect.left + i2;
            while (true) {
                int i6 = i5 + 2;
                if (i6 < rect.right) {
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = i3;
                    while (i9 < i4) {
                        int i10 = i8;
                        int i11 = i7;
                        for (int i12 = i5; i12 < i6; i12++) {
                            int i13 = (i9 * OplusGLSurfaceView_13) + i12;
                            if ((bArr[i13] & 255) < 150) {
                                i11++;
                            }
                            if ((bArr[i13] & 255) > i10) {
                                i10 = bArr[i13] & 255;
                            }
                        }
                        i9++;
                        i7 = i11;
                        i8 = i10;
                    }
                    if (i7 <= 2) {
                        for (int i14 = i3; i14 < i4; i14++) {
                            for (int i15 = i5; i15 < i6; i15++) {
                                bArr[(i14 * OplusGLSurfaceView_13) + i15] = (byte) i8;
                            }
                        }
                    }
                    i5 = i6;
                }
            }
            i3 = i4;
        }
    }
}

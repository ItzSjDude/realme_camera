package com.oplus.camera.p156o.p157a;

/* compiled from: OverDarkScale.java */
/* renamed from: com.oplus.camera.o.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
class OverDarkScale implements Dispatch {
    OverDarkScale() {
    }

    @Override // com.oplus.camera.p156o.p157a.Dispatch
    /* renamed from: PlatformImplementations.kt_3 */
    public byte[] mo14799a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        double dRandom = (Math.random() / 2.0d) + 0.4000000059604645d;
        for (int i3 = 0; i3 < OplusGLSurfaceView_13 * i2; i3++) {
            bArr[i3] = (byte) (Math.pow((bArr[i3] & 255) / 255.0f, dRandom) * 255.0d);
        }
        return bArr;
    }
}

package com.oplus.camera.p156o.p157a;

/* compiled from: OverBrightScale.java */
/* renamed from: com.oplus.camera.o.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
class OverBrightScale implements Dispatch {
    OverBrightScale() {
    }

    @Override // com.oplus.camera.p156o.p157a.Dispatch
    /* renamed from: PlatformImplementations.kt_3 */
    public byte[] mo14799a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        double dRandom = (Math.random() * 10.0d) + 2.0d;
        for (int i3 = 0; i3 < OplusGLSurfaceView_13 * i2; i3++) {
            bArr[i3] = (byte) (Math.pow((bArr[i3] & 255) / 255.0f, dRandom) * 255.0d);
        }
        return bArr;
    }
}

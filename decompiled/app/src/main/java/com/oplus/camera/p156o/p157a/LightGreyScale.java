package com.oplus.camera.p156o.p157a;

/* compiled from: LightGreyScale.java */
/* renamed from: com.oplus.camera.o.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
class LightGreyScale implements Dispatch {
    LightGreyScale() {
    }

    @Override // com.oplus.camera.p156o.p157a.Dispatch
    /* renamed from: PlatformImplementations.kt_3 */
    public byte[] mo14799a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        short sRandom = (short) ((Math.random() * 5.0d) + 2.0d);
        for (int i3 = 0; i3 < OplusGLSurfaceView_13 * i2; i3++) {
            bArr[i3] = (byte) (bArr[i3] * sRandom);
        }
        return bArr;
    }
}

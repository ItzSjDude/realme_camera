package com.oplus.camera.p156o.p157a;

/* compiled from: RevGrayScale.java */
/* renamed from: com.oplus.camera.o.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
class RevGrayScale implements Dispatch {
    RevGrayScale() {
    }

    @Override // com.oplus.camera.p156o.p157a.Dispatch
    /* renamed from: PlatformImplementations.kt_3 */
    public byte[] mo14799a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        for (int i3 = 0; i3 < OplusGLSurfaceView_13 * i2; i3++) {
            bArr[i3] = (byte) ((255 - bArr[i3]) & 255);
        }
        return bArr;
    }
}

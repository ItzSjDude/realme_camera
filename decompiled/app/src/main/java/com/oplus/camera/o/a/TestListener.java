package com.oplus.camera.o_renamed.a_renamed;

/* compiled from: RevGrayScale.java */
/* loaded from: classes2.dex */
class g_renamed implements com.oplus.camera.o_renamed.a_renamed.a_renamed {
    g_renamed() {
    }

    @Override // com.oplus.camera.o_renamed.a_renamed.a_renamed
    public byte[] a_renamed(byte[] bArr, int i_renamed, int i2) {
        for (int i3 = 0; i3 < i_renamed * i2; i3++) {
            bArr[i3] = (byte) ((255 - bArr[i3]) & 255);
        }
        return bArr;
    }
}

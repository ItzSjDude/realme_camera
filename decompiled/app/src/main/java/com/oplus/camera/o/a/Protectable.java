package com.oplus.camera.o_renamed.a_renamed;

/* compiled from: LightGreyScale.java */
/* loaded from: classes2.dex */
class c_renamed implements com.oplus.camera.o_renamed.a_renamed.a_renamed {
    c_renamed() {
    }

    @Override // com.oplus.camera.o_renamed.a_renamed.a_renamed
    public byte[] a_renamed(byte[] bArr, int i_renamed, int i2) {
        short sRandom = (short) ((java.lang.Math.random() * 5.0d) + 2.0d);
        for (int i3 = 0; i3 < i_renamed * i2; i3++) {
            bArr[i3] = (byte) (bArr[i3] * sRandom);
        }
        return bArr;
    }
}

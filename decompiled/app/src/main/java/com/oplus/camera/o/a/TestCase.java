package com.oplus.camera.o_renamed.a_renamed;

/* compiled from: OverDarkScale.java */
/* loaded from: classes2.dex */
class e_renamed implements com.oplus.camera.o_renamed.a_renamed.a_renamed {
    e_renamed() {
    }

    @Override // com.oplus.camera.o_renamed.a_renamed.a_renamed
    public byte[] a_renamed(byte[] bArr, int i_renamed, int i2) {
        double dRandom = (java.lang.Math.random() / 2.0d) + 0.4000000059604645d;
        for (int i3 = 0; i3 < i_renamed * i2; i3++) {
            bArr[i3] = (byte) (java.lang.Math.pow((bArr[i3] & 255) / 255.0f, dRandom) * 255.0d);
        }
        return bArr;
    }
}

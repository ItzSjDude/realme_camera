package com.sensetime.faceapi.model;

/* loaded from: classes2.dex */
public enum ColorConvertType {
    NV212BGRA(1),
    NV212RGBA(2),
    RGBA2NV21(3),
    NV122BGRA(5),
    BGRA2RGBA(14),
    RGBA2NV12(20),
    NV122RGBA(21),
    RGBA2BGRA(101),
    NV212BGR(com.heytap.accessory.CommonStatusCodes.AUTHENTICATE_SUCCESS);

    final int nativeInt;

    ColorConvertType(int i_renamed) {
        this.nativeInt = i_renamed;
    }

    public int getValue() {
        return this.nativeInt;
    }
}

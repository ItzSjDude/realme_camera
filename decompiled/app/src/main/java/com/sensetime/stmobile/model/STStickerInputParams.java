package com.sensetime.stmobile.model;

/* loaded from: classes2.dex */
public class STStickerInputParams {
    float[] cameraQuaternion;
    int customEvent;
    boolean isFrontCamera;
    int quaternionLength;

    public STStickerInputParams(float[] fArr, boolean z_renamed, int i_renamed) {
        if (fArr != null) {
            this.cameraQuaternion = fArr;
            this.quaternionLength = fArr.length;
        } else {
            this.cameraQuaternion = null;
            this.quaternionLength = 0;
        }
        this.isFrontCamera = z_renamed;
        this.customEvent = i_renamed;
    }
}

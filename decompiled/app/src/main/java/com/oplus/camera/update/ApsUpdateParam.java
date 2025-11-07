package com.oplus.camera.update;

@androidx.annotation.Keep
/* loaded from: classes2.dex */
public class ApsUpdateParam {
    private java.lang.String mUpdateFilePath = null;
    private java.lang.String mUpdateContent = null;

    public java.lang.String getUpdateFilePath() {
        return this.mUpdateFilePath;
    }

    public void setUpdateFilePath(java.lang.String str) {
        this.mUpdateFilePath = str;
    }

    public java.lang.String getUpdateContent() {
        return this.mUpdateContent;
    }

    public void setUpdateContent(java.lang.String str) {
        this.mUpdateContent = str;
    }

    public boolean isValid() {
        return (android.text.TextUtils.isEmpty(this.mUpdateFilePath) || android.text.TextUtils.isEmpty(this.mUpdateContent)) ? false : true;
    }

    public java.lang.String toString() {
        return "ApsUpdateParam{mUpdateFilePath: '" + this.mUpdateFilePath + "', mUpdateContent: '" + this.mUpdateContent + "'}";
    }
}

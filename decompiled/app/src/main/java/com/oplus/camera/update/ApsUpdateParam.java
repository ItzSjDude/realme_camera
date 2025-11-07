package com.oplus.camera.update;

import android.text.TextUtils;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes2.dex */
public class ApsUpdateParam {
    private String mUpdateFilePath = null;
    private String mUpdateContent = null;

    public String getUpdateFilePath() {
        return this.mUpdateFilePath;
    }

    public void setUpdateFilePath(String str) {
        this.mUpdateFilePath = str;
    }

    public String getUpdateContent() {
        return this.mUpdateContent;
    }

    public void setUpdateContent(String str) {
        this.mUpdateContent = str;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mUpdateFilePath) || TextUtils.isEmpty(this.mUpdateContent)) ? false : true;
    }

    public String toString() {
        return "ApsUpdateParam{mUpdateFilePath: '" + this.mUpdateFilePath + "', mUpdateContent: '" + this.mUpdateContent + "'}";
    }
}

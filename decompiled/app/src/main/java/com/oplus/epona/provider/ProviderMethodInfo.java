package com.oplus.epona.provider;

/* loaded from: classes2.dex */
public class ProviderMethodInfo {
    private java.lang.String[] mAllAppOp;
    private java.lang.String[] mAnyAppOp;
    private java.lang.String mMethodName;
    private java.lang.String[] mMethodParams;
    private java.lang.String mSpecifyAppOp;

    public ProviderMethodInfo(java.lang.String str, java.lang.String[] strArr, java.lang.String str2, java.lang.String[] strArr2, java.lang.String[] strArr3) {
        this.mMethodName = str;
        this.mMethodParams = strArr;
        this.mSpecifyAppOp = str2;
        this.mAnyAppOp = strArr2;
        this.mAllAppOp = strArr3;
    }

    public java.lang.String getMethodName() {
        return this.mMethodName;
    }

    public java.lang.String[] getMethodParams() {
        return this.mMethodParams;
    }

    public java.lang.String getSpecifyAppOp() {
        return this.mSpecifyAppOp;
    }

    public java.lang.String[] getAnyAppOp() {
        return this.mAnyAppOp;
    }

    public java.lang.String[] getAllAppOp() {
        return this.mAllAppOp;
    }

    public boolean hasAppOpStrAnnotation() {
        return !this.mSpecifyAppOp.isEmpty() || this.mAnyAppOp.length > 0 || this.mAllAppOp.length > 0;
    }
}

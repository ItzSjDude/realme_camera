package com.oplus.ocs.camera;

import com.oplus.ocs.camera.common.util.ErrorResult;

/* loaded from: classes2.dex */
class ErrorResultAdapterV2 extends ErrorResultAdapter {
    private ErrorResult mErrorResult;

    ErrorResultAdapterV2(ErrorResult errorResult) {
        this.mErrorResult = null;
        this.mErrorResult = errorResult;
    }

    @Override // com.oplus.ocs.camera.ErrorResultAdapter
    public int getErrorCode() {
        ErrorResult errorResult = this.mErrorResult;
        if (errorResult != null) {
            return errorResult.getErrorCode();
        }
        return 0;
    }

    @Override // com.oplus.ocs.camera.ErrorResultAdapter
    public String getErrorInfo() {
        ErrorResult errorResult = this.mErrorResult;
        if (errorResult != null) {
            return errorResult.getErrorInfo();
        }
        return null;
    }
}

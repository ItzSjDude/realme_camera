package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
class ErrorResultAdapterV2 extends com.oplus.ocs.camera.ErrorResultAdapter {
    private com.oplus.ocs.camera.common.util.ErrorResult mErrorResult;

    ErrorResultAdapterV2(com.oplus.ocs.camera.common.util.ErrorResult errorResult) {
        this.mErrorResult = null;
        this.mErrorResult = errorResult;
    }

    @Override // com.oplus.ocs.camera.ErrorResultAdapter
    public int getErrorCode() {
        com.oplus.ocs.camera.common.util.ErrorResult errorResult = this.mErrorResult;
        if (errorResult != null) {
            return errorResult.getErrorCode();
        }
        return 0;
    }

    @Override // com.oplus.ocs.camera.ErrorResultAdapter
    public java.lang.String getErrorInfo() {
        com.oplus.ocs.camera.common.util.ErrorResult errorResult = this.mErrorResult;
        if (errorResult != null) {
            return errorResult.getErrorInfo();
        }
        return null;
    }
}

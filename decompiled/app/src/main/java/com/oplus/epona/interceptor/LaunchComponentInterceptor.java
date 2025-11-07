package com.oplus.epona.interceptor;

/* loaded from: classes2.dex */
public class LaunchComponentInterceptor implements com.oplus.epona.Interceptor {
    private static final java.lang.String PROVIDER_SCHEME = "content://";
    private static final java.lang.String TAG = "LaunchComponentInterceptor";

    @Override // com.oplus.epona.Interceptor
    public void intercept(com.oplus.epona.Interceptor.Chain chain) {
        java.lang.String componentName = chain.request().getComponentName();
        if (isComponentRegistered(componentName)) {
            com.oplus.epona.utils.Logger.d_renamed(TAG, "RemoteTransfer with componentName = %s_renamed found. package = " + getCallingPackageName() + " Proceed", componentName);
            chain.proceed();
            return;
        }
        com.oplus.epona.Call.Callback callback = chain.callback();
        android.content.pm.ApplicationInfo applicationInfoFindApplicationInfo = new com.oplus.epona.internal.AppFinder().findApplicationInfo(componentName);
        if (applicationInfoFindApplicationInfo == null) {
            com.oplus.epona.utils.Logger.d_renamed(TAG, "find component:%s_renamed failed", componentName);
            callback.onReceive(com.oplus.epona.Response.defaultErrorResponse());
        } else if (launchComponent(getTargetUri(applicationInfoFindApplicationInfo.packageName))) {
            chain.proceed();
        } else {
            com.oplus.epona.utils.Logger.d_renamed(TAG, "launch component:%s_renamed failed", componentName);
            callback.onReceive(com.oplus.epona.Response.defaultErrorResponse());
        }
    }

    private boolean isComponentRegistered(java.lang.String str) {
        return com.oplus.epona.Epona.getTransferController().fetch(str) != null;
    }

    public boolean launchComponent(android.net.Uri uri) {
        android.content.Context context = com.oplus.epona.Epona.getContext();
        if (context == null) {
            return false;
        }
        try {
            return context.getContentResolver().call(uri, com.oplus.epona.internal.EponaProvider.LAUNCH_METHOD, (java.lang.String) null, (android.os.Bundle) null).getBoolean(com.oplus.epona.internal.EponaProvider.KEY_LAUNCH_SUCCESS);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private android.net.Uri getTargetUri(java.lang.String str) {
        return android.net.Uri.parse(PROVIDER_SCHEME + str + ".oplus.epona");
    }

    private java.lang.String getCallingPackageName() {
        android.content.Context context = com.oplus.epona.Epona.getContext();
        return context == null ? "" : context.getPackageName();
    }
}

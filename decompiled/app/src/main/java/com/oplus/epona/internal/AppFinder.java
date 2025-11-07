package com.oplus.epona.internal;

/* loaded from: classes2.dex */
public class AppFinder {
    private static final java.lang.String META_DATA_KEY = "epona_components";
    private static final java.lang.String META_PACKAGE_KEY = "epona_packages";
    private static final java.lang.String SEPARATOR = "\\|";
    private static final java.lang.String TAG = "AppFinder";

    public android.content.pm.ApplicationInfo findApplicationInfo(java.lang.String str) {
        android.content.pm.ApplicationInfo applicationInfoFindApplicationInfo;
        android.content.Context context = com.oplus.epona.Epona.getContext();
        if (context == null) {
            return null;
        }
        for (java.lang.String str2 : getPackages(context)) {
            android.content.pm.ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(getAuthority(str2), 128);
            if (providerInfoResolveContentProvider != null && (applicationInfoFindApplicationInfo = findApplicationInfo(str, providerInfoResolveContentProvider)) != null) {
                return applicationInfoFindApplicationInfo;
            }
        }
        return null;
    }

    private java.lang.String getAuthority(java.lang.String str) {
        return str + ".oplus.epona";
    }

    private android.content.pm.ApplicationInfo findApplicationInfo(java.lang.String str, android.content.pm.ProviderInfo providerInfo) {
        android.content.pm.ApplicationInfo applicationInfo = providerInfo.applicationInfo;
        for (java.lang.String str2 : splitMetaData(applicationInfo, META_DATA_KEY)) {
            if (str2.trim().equals(str)) {
                return applicationInfo;
            }
        }
        return null;
    }

    private java.lang.String[] getPackages(android.content.Context context) {
        try {
            return splitMetaData(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128), META_PACKAGE_KEY);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.oplus.epona.utils.Logger.e_renamed(TAG, "not find application info", new java.lang.Object[0]);
            return new java.lang.String[0];
        }
    }

    private java.lang.String[] splitMetaData(android.content.pm.ApplicationInfo applicationInfo, java.lang.String str) {
        java.lang.String string;
        java.lang.String[] strArr = new java.lang.String[0];
        android.os.Bundle bundle = applicationInfo.metaData;
        return (bundle == null || (string = bundle.getString(str)) == null) ? strArr : string.split(SEPARATOR);
    }
}

package com.oplus.epona.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Bundle;
import com.oplus.epona.Epona;
import com.oplus.epona.utils.Logger;

/* loaded from: classes2.dex */
public class AppFinder {
    private static final String META_DATA_KEY = "epona_components";
    private static final String META_PACKAGE_KEY = "epona_packages";
    private static final String SEPARATOR = "\\|";
    private static final String TAG = "AppFinder";

    public ApplicationInfo findApplicationInfo(String str) {
        ApplicationInfo applicationInfoFindApplicationInfo;
        Context context = Epona.getContext();
        if (context == null) {
            return null;
        }
        for (String str2 : getPackages(context)) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(getAuthority(str2), 128);
            if (providerInfoResolveContentProvider != null && (applicationInfoFindApplicationInfo = findApplicationInfo(str, providerInfoResolveContentProvider)) != null) {
                return applicationInfoFindApplicationInfo;
            }
        }
        return null;
    }

    private String getAuthority(String str) {
        return str + ".oplus.epona";
    }

    private ApplicationInfo findApplicationInfo(String str, ProviderInfo providerInfo) {
        ApplicationInfo applicationInfo = providerInfo.applicationInfo;
        for (String str2 : splitMetaData(applicationInfo, META_DATA_KEY)) {
            if (str2.trim().equals(str)) {
                return applicationInfo;
            }
        }
        return null;
    }

    private String[] getPackages(Context context) {
        try {
            return splitMetaData(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128), META_PACKAGE_KEY);
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.m25000e(TAG, "not find application info", new Object[0]);
            return new String[0];
        }
    }

    private String[] splitMetaData(ApplicationInfo applicationInfo, String str) {
        String string;
        String[] strArr = new String[0];
        Bundle bundle = applicationInfo.metaData;
        return (bundle == null || (string = bundle.getString(str)) == null) ? strArr : string.split(SEPARATOR);
    }
}

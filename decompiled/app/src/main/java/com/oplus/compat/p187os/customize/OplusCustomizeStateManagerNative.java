package com.oplus.compat.p187os.customize;

import android.content.Context;
import android.os.customize.OplusCustomizeStateManager;
import android.util.Log;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class OplusCustomizeStateManagerNative {
    private static final String TAG = "OplusCustomizeStateManagerNative";

    private static class ReflectInfo {
        private static RefMethod<List<String>> getAllowedGetUsageStatusList;

        private ReflectInfo() {
        }

        static {
            RefClass.load((Class<?>) ReflectInfo.class, "android.os.customize.OplusCustomizeStateManager");
        }
    }

    public static List<String> getAllowedGetUsageStatusList(Context context) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            try {
                return (List) ReflectInfo.getAllowedGetUsageStatusList.call(OplusCustomizeStateManager.getInstance(context), new Object[0]);
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8(TAG, "getAllowedGetUsageStatusList error: " + COUIBaseListPopupWindow_8.toString());
                return Collections.emptyList();
            }
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }
}

package com.oplus.compat.p187os;

import com.android.providers.downloads.Downloads;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;

/* loaded from: classes2.dex */
public class RecoverySystemNative {
    public static void setWipeProperty(String str) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            throw new UnSupportedApiVersionException("not supported in S");
        }
        if (VersionUtils.m24888d()) {
            Epona.newCall(new Request.Builder().setComponentName("android.os.RecoverySystem").setActionName("setWipeProperty").withString(Downloads.Impl.RequestHeaders.COLUMN_VALUE, str).build()).execute();
            return;
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }
}

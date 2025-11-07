package com.oplus.epona.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.oplus.epona.Constants;

/* loaded from: classes2.dex */
public class ProviderUtils {
    private static final String CONTENT_PREFIX = "content://";
    public static final String FIND_TRANSFER = "find_transfer";
    private static final String TAG = "ProviderUtils";

    public static Bundle findRemoteBundle(Context context, String str) throws Throwable {
        Bundle providerBundleFromQuery = getProviderBundleFromQuery(context, Uri.parse("content://com.oplus.appplatform.dispatcher/find_transfer/" + str));
        return providerBundleFromQuery == null ? getProviderBundleFromCall(context, str) : providerBundleFromQuery;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[Catch: Exception -> 0x003f, SYNTHETIC, TRY_LEAVE, TryCatch #0 {Exception -> 0x003f, blocks: (B:3:0x0004, B:7:0x0017, B:11:0x0021, B:21:0x0032, B:25:0x003b, B:24:0x0037, B:26:0x003e), top: B:30:0x0004, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.os.Bundle getProviderBundleFromQuery(android.content.Context r5, android.net.Uri r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "ProviderUtils"
            r1 = 0
            r2 = 0
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Exception -> L3f
            android.database.Cursor r5 = r5.query(r6, r2, r2, r2)     // Catch: java.lang.Exception -> L3f
            if (r5 != 0) goto L1b
            java.lang.String r6 = "Get cursor null."
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L28
            com.oplus.epona.utils.Logger.m25000e(r0, r6, r3)     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L28
            if (r5 == 0) goto L1a
            r5.close()     // Catch: java.lang.Exception -> L3f
        L1a:
            return r2
        L1b:
            android.os.Bundle r6 = com.oplus.epona.ipc.cursor.ProviderCursor.stripBundle(r5)     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L28
            if (r5 == 0) goto L24
            r5.close()     // Catch: java.lang.Exception -> L3f
        L24:
            return r6
        L25:
            r6 = move-exception
            r3 = r2
            goto L2e
        L28:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L2a
        L2a:
            r3 = move-exception
            r4 = r3
            r3 = r6
            r6 = r4
        L2e:
            if (r5 == 0) goto L3e
            if (r3 == 0) goto L3b
            r5.close()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3f
            goto L3e
        L36:
            r5 = move-exception
            r3.addSuppressed(r5)     // Catch: java.lang.Exception -> L3f
            goto L3e
        L3b:
            r5.close()     // Catch: java.lang.Exception -> L3f
        L3e:
            throw r6     // Catch: java.lang.Exception -> L3f
        L3f:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r3 = "Get cursor Exception : "
            r6.append(r3)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.oplus.epona.utils.Logger.m25000e(r0, r6, r1)
            r5.printStackTrace()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.epona.utils.ProviderUtils.getProviderBundleFromQuery(android.content.Context, android.net.Uri):android.os.Bundle");
    }

    private static Bundle getProviderBundleFromCall(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.TRANSFER_KEY, str);
        try {
            return context.getContentResolver().call(Constants.DISPATCHER_PROVIDER_URI, Constants.FIND_TRANSFER, (String) null, bundle);
        } catch (Exception unused) {
            Logger.m25000e(TAG, "failed to call provider: com.oplus.appplatform.dispatcher", new Object[0]);
            return null;
        }
    }
}

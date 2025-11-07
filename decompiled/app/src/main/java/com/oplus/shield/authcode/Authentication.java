package com.oplus.shield.authcode;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import android.text.TextUtils;
import com.heytap.accessory.CommonStatusCodes;
import com.oplus.shield.authcode.dao.AuthenticationDb;
import com.oplus.shield.authcode.dao.AuthenticationDbBean;
import com.oplus.shield.authcode.p197a.AuthResult;
import com.oplus.shield.p198b.Base64Utils;
import com.oplus.shield.p198b.PLog;
import com.oplus.shield.p198b.PackageUtils;
import com.oplus.shield.p198b.ParseUtils;
import com.oplus.shield.p198b.SignVerifyUtils;
import com.oplus.shield.p198b.SystemUtils;
import com.oplus.shield.p198b.TimeUtils;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.Executors;

/* compiled from: Authentication.java */
/* renamed from: com.oplus.shield.authcode.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class Authentication {
    /* renamed from: PlatformImplementations.kt_3 */
    public static AuthResult m25145a(Context context, String str) {
        int iM25197a = PackageUtils.m25197a(context, str);
        if (TextUtils.isEmpty(str)) {
            PLog.m25195b("Get target packageName is empty");
            return new AuthResult("", CommonStatusCodes.AUTHCODE_EXPECTED, new byte[0]);
        }
        String strM25201b = PackageUtils.m25201b(context, str);
        if (TextUtils.isEmpty(strM25201b)) {
            PLog.m25195b("Get target application authCode is empty");
            return new AuthResult("", CommonStatusCodes.AUTHCODE_EXPECTED, new byte[0]);
        }
        try {
            Iterator<String> it = SystemUtils.m25211a(strM25201b, ";").iterator();
            while (it.hasNext()) {
                byte[][] bArrM25150a = m25150a(str, it.next(), context);
                if (bArrM25150a[0][0] == 1) {
                    byte[] bArr = bArrM25150a[1];
                    m25147a(context, strM25201b, str, iM25197a, TimeUtils.m25215a(bArrM25150a[2]), bArr);
                    PLog.m25196c("Auth code check ok");
                    return new AuthResult(str, CommonStatusCodes.AUTHENTICATE_SUCCESS, bArr);
                }
            }
            PLog.m25195b("Signature verify failed, package : " + str);
            return new AuthResult(str, 1002, new byte[0]);
        } catch (Exception COUIBaseListPopupWindow_8) {
            PLog.m25195b("Check key get exception " + COUIBaseListPopupWindow_8.getMessage());
            return new AuthResult(str, 1002, new byte[0]);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static byte[][] m25150a(String str, String str2, Context context) {
        byte[][] bArr = {new byte[]{0}};
        try {
            byte[] bArrM25182a = Base64Utils.m25182a(str2);
            byte[] bArrM25202a = ParseUtils.m25202a(bArrM25182a);
            byte[] bArr2 = {8};
            int iM25210a = SystemUtils.m25210a(ParseUtils.m25204b(bArrM25182a));
            byte[] bArrM25203a = ParseUtils.m25203a(bArrM25182a, iM25210a);
            byte[] bArrM25205b = ParseUtils.m25205b(bArrM25182a, iM25210a);
            if (!SignVerifyUtils.m25209a(context, str, bArrM25202a, iM25210a, bArr2, bArrM25205b, bArrM25203a, ParseUtils.m25206c(bArrM25182a, iM25210a))) {
                PLog.m25196c("Signature verify failed.");
                return bArr;
            }
            return new byte[][]{new byte[]{1}, bArrM25203a, bArrM25205b};
        } catch (Exception COUIBaseListPopupWindow_8) {
            PLog.m25195b("Check key get exception " + COUIBaseListPopupWindow_8.getMessage());
            return bArr;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static AuthResult m25146a(Context context, String str, String str2) {
        if (!m25149a(context)) {
            PLog.m25194a("Not get data from db cause user is locked.");
            return null;
        }
        AuthenticationDbBean c3699cMo25166a = AuthenticationDb.m25153a(context).mo25154l().mo25166a(PackageUtils.m25197a(context, str), str, "APP_PLATFORM_CLIENT", str2);
        if (c3699cMo25166a != null) {
            return new AuthResult(str, CommonStatusCodes.AUTHENTICATE_SUCCESS, c3699cMo25166a.m25176h());
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m25147a(final Context context, final String str, final String str2, final int OplusGLSurfaceView_13, final Calendar calendar, final byte[] bArr) {
        if (!m25149a(context)) {
            PLog.m25194a("Not save to db cause user is locked.");
        } else {
            if (str2 == null) {
                return;
            }
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.oplus.shield.authcode.-$$Lambda$IntrinsicsJvm.kt_4$-d4UtFE33EUDbHCkqeQqqlF2qT0
                @Override // java.lang.Runnable
                public final void run() {
                    Authentication.m25148a(str, OplusGLSurfaceView_13, str2, calendar, bArr, context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m25148a(String str, int OplusGLSurfaceView_13, String str2, Calendar calendar, byte[] bArr, Context context) {
        AuthenticationDb.m25153a(context).mo25154l().mo25167a(new AuthenticationDbBean(str, true, OplusGLSurfaceView_13, str2, "APP_PLATFORM_CLIENT", calendar.getTimeInMillis(), bArr, System.currentTimeMillis(), 0L));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m25149a(Context context) {
        if (context == null) {
            return false;
        }
        UserManager userManager = (UserManager) context.getSystemService("user");
        if (Build.VERSION.SDK_INT >= 24) {
            return userManager.isUserUnlocked();
        }
        return false;
    }
}

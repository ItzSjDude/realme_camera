package com.oplus.shield.authcode;

/* compiled from: Authentication.java */
/* loaded from: classes2.dex */
public class b_renamed {
    public static com.oplus.shield.authcode.a_renamed.a_renamed a_renamed(android.content.Context context, java.lang.String str) {
        int iA = com.oplus.shield.b_renamed.e_renamed.a_renamed(context, str);
        if (android.text.TextUtils.isEmpty(str)) {
            com.oplus.shield.b_renamed.d_renamed.b_renamed("Get target packageName is_renamed empty");
            return new com.oplus.shield.authcode.a_renamed.a_renamed("", com.heytap.accessory.CommonStatusCodes.AUTHCODE_EXPECTED, new byte[0]);
        }
        java.lang.String strB = com.oplus.shield.b_renamed.e_renamed.b_renamed(context, str);
        if (android.text.TextUtils.isEmpty(strB)) {
            com.oplus.shield.b_renamed.d_renamed.b_renamed("Get target application authCode is_renamed empty");
            return new com.oplus.shield.authcode.a_renamed.a_renamed("", com.heytap.accessory.CommonStatusCodes.AUTHCODE_EXPECTED, new byte[0]);
        }
        try {
            java.util.Iterator<java.lang.String> it = com.oplus.shield.b_renamed.h_renamed.a_renamed(strB, ";").iterator();
            while (it.hasNext()) {
                byte[][] bArrA = a_renamed(str, it.next(), context);
                if (bArrA[0][0] == 1) {
                    byte[] bArr = bArrA[1];
                    a_renamed(context, strB, str, iA, com.oplus.shield.b_renamed.i_renamed.a_renamed(bArrA[2]), bArr);
                    com.oplus.shield.b_renamed.d_renamed.c_renamed("Auth code check ok");
                    return new com.oplus.shield.authcode.a_renamed.a_renamed(str, com.heytap.accessory.CommonStatusCodes.AUTHENTICATE_SUCCESS, bArr);
                }
            }
            com.oplus.shield.b_renamed.d_renamed.b_renamed("Signature verify failed, package : " + str);
            return new com.oplus.shield.authcode.a_renamed.a_renamed(str, 1002, new byte[0]);
        } catch (java.lang.Exception e_renamed) {
            com.oplus.shield.b_renamed.d_renamed.b_renamed("Check key get exception " + e_renamed.getMessage());
            return new com.oplus.shield.authcode.a_renamed.a_renamed(str, 1002, new byte[0]);
        }
    }

    private static byte[][] a_renamed(java.lang.String str, java.lang.String str2, android.content.Context context) {
        byte[][] bArr = {new byte[]{0}};
        try {
            byte[] bArrA = com.oplus.shield.b_renamed.a_renamed.a_renamed(str2);
            byte[] bArrA2 = com.oplus.shield.b_renamed.f_renamed.a_renamed(bArrA);
            byte[] bArr2 = {8};
            int iA = com.oplus.shield.b_renamed.h_renamed.a_renamed(com.oplus.shield.b_renamed.f_renamed.b_renamed(bArrA));
            byte[] bArrA3 = com.oplus.shield.b_renamed.f_renamed.a_renamed(bArrA, iA);
            byte[] bArrB = com.oplus.shield.b_renamed.f_renamed.b_renamed(bArrA, iA);
            if (!com.oplus.shield.b_renamed.g_renamed.a_renamed(context, str, bArrA2, iA, bArr2, bArrB, bArrA3, com.oplus.shield.b_renamed.f_renamed.c_renamed(bArrA, iA))) {
                com.oplus.shield.b_renamed.d_renamed.c_renamed("Signature verify failed.");
                return bArr;
            }
            return new byte[][]{new byte[]{1}, bArrA3, bArrB};
        } catch (java.lang.Exception e_renamed) {
            com.oplus.shield.b_renamed.d_renamed.b_renamed("Check key get exception " + e_renamed.getMessage());
            return bArr;
        }
    }

    static com.oplus.shield.authcode.a_renamed.a_renamed a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (!a_renamed(context)) {
            com.oplus.shield.b_renamed.d_renamed.a_renamed("Not get data from db_renamed cause user is_renamed locked.");
            return null;
        }
        com.oplus.shield.authcode.dao.c_renamed cVarA = com.oplus.shield.authcode.dao.AuthenticationDb.a_renamed(context).l_renamed().a_renamed(com.oplus.shield.b_renamed.e_renamed.a_renamed(context, str), str, "APP_PLATFORM_CLIENT", str2);
        if (cVarA != null) {
            return new com.oplus.shield.authcode.a_renamed.a_renamed(str, com.heytap.accessory.CommonStatusCodes.AUTHENTICATE_SUCCESS, cVarA.h_renamed());
        }
        return null;
    }

    private static void a_renamed(final android.content.Context context, final java.lang.String str, final java.lang.String str2, final int i_renamed, final java.util.Calendar calendar, final byte[] bArr) {
        if (!a_renamed(context)) {
            com.oplus.shield.b_renamed.d_renamed.a_renamed("Not save to db_renamed cause user is_renamed locked.");
        } else {
            if (str2 == null) {
                return;
            }
            java.util.concurrent.Executors.newSingleThreadExecutor().execute(new java.lang.Runnable() { // from class: com.oplus.shield.authcode.-$$Lambda$b_renamed$-d4UtFE33EUDbHCkqeQqqlF2qT0
                @Override // java.lang.Runnable
                public final void run() {
                    com.oplus.shield.authcode.b_renamed.a_renamed(str, i_renamed, str2, calendar, bArr, context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(java.lang.String str, int i_renamed, java.lang.String str2, java.util.Calendar calendar, byte[] bArr, android.content.Context context) {
        com.oplus.shield.authcode.dao.AuthenticationDb.a_renamed(context).l_renamed().a_renamed(new com.oplus.shield.authcode.dao.c_renamed(str, true, i_renamed, str2, "APP_PLATFORM_CLIENT", calendar.getTimeInMillis(), bArr, java.lang.System.currentTimeMillis(), 0L));
    }

    private static boolean a_renamed(android.content.Context context) {
        if (context == null) {
            return false;
        }
        android.os.UserManager userManager = (android.os.UserManager) context.getSystemService("user");
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return userManager.isUserUnlocked();
        }
        return false;
    }
}

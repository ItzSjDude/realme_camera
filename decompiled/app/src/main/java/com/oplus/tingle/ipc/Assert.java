package com.oplus.tingle.ipc;

/* compiled from: Engine.java */
/* loaded from: classes2.dex */
public class a_renamed {
    public static void a_renamed(android.content.Context context) {
        if (context.getApplicationInfo().packageName.equals(com.oplus.tingle.a_renamed.d_renamed())) {
            return;
        }
        com.oplus.tingle.ipc.b_renamed.a_renamed(context);
    }

    public static android.os.IBinder b_renamed(android.content.Context context) {
        android.os.IBinder iBinderC = c_renamed(context);
        return iBinderC == null ? d_renamed(context) : iBinderC;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:36:? A_renamed[Catch: Exception -> 0x0058, SYNTHETIC, TRY_LEAVE, TryCatch #3 {Exception -> 0x0058, blocks: (B_renamed:3:0x0004, B_renamed:7:0x0030, B_renamed:11:0x003a, B_renamed:21:0x004b, B_renamed:25:0x0054, B_renamed:24:0x0050, B_renamed:26:0x0057), top: B_renamed:34:0x0004, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.os.IBinder c_renamed(android.content.Context r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Engine"
            r1 = 0
            r2 = 0
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.Exception -> L58
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L58
            r3.<init>()     // Catch: java.lang.Exception -> L58
            java.lang.String r4 = "content://"
            r3.append(r4)     // Catch: java.lang.Exception -> L58
            java.lang.String r4 = com.oplus.tingle.a_renamed.c_renamed()     // Catch: java.lang.Exception -> L58
            r3.append(r4)     // Catch: java.lang.Exception -> L58
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L58
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Exception -> L58
            android.database.Cursor r6 = r6.query(r3, r2, r2, r2)     // Catch: java.lang.Exception -> L58
            if (r6 != 0) goto L34
            java.lang.String r3 = "Get query cursor null."
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L3e java.lang.Throwable -> L41
            com.oplus.tingle.ipc.c_renamed.a_renamed.b_renamed(r0, r3, r4)     // Catch: java.lang.Throwable -> L3e java.lang.Throwable -> L41
            if (r6 == 0) goto L33
            r6.close()     // Catch: java.lang.Exception -> L58
        L33:
            return r2
        L34:
            android.os.IBinder r3 = com.oplus.tingle.ipc.a_renamed.a_renamed.a_renamed(r6)     // Catch: java.lang.Throwable -> L3e java.lang.Throwable -> L41
            if (r6 == 0) goto L3d
            r6.close()     // Catch: java.lang.Exception -> L58
        L3d:
            return r3
        L3e:
            r3 = move-exception
            r4 = r2
            goto L47
        L41:
            r3 = move-exception
            throw r3     // Catch: java.lang.Throwable -> L43
        L43:
            r4 = move-exception
            r5 = r4
            r4 = r3
            r3 = r5
        L47:
            if (r6 == 0) goto L57
            if (r4 == 0) goto L54
            r6.close()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L58
            goto L57
        L4f:
            r6 = move-exception
            r4.addSuppressed(r6)     // Catch: java.lang.Exception -> L58
            goto L57
        L54:
            r6.close()     // Catch: java.lang.Exception -> L58
        L57:
            throw r3     // Catch: java.lang.Exception -> L58
        L58:
            r6 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Close cursor failed : "
            r3.append(r4)
            java.lang.String r6 = r6.toString()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.oplus.tingle.ipc.c_renamed.a_renamed.b_renamed(r0, r6, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.tingle.ipc.a_renamed.c_renamed(android.content.Context):android.os.IBinder");
    }

    private static android.os.IBinder d_renamed(android.content.Context context) {
        android.os.Bundle bundleCall = context.getContentResolver().call(com.oplus.tingle.a_renamed.c_renamed(), "sendBinder", (java.lang.String) null, (android.os.Bundle) null);
        if (bundleCall != null) {
            return bundleCall.getBinder(com.oplus.tingle.a_renamed.b_renamed());
        }
        com.oplus.tingle.ipc.c_renamed.a_renamed.b_renamed("Engine", "Get Master IBinder from provider call is_renamed null", new java.lang.Object[0]);
        return null;
    }
}

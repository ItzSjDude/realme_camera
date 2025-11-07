package com.oplus.b_renamed.a_renamed;

/* compiled from: AppFeatureProviderUtils.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.net.Uri f3728a = android.net.Uri.parse("content://com.oplus.customize.coreapp.configmanager.configprovider.AppFeatureProvider").buildUpon().appendPath("app_feature").build();

    public static java.lang.String a_renamed(android.content.ContentResolver contentResolver, java.lang.String str, java.lang.String str2) {
        java.lang.String strB = b_renamed(contentResolver, str, "String");
        return strB != null ? strB : str2;
    }

    public static boolean a_renamed(android.content.ContentResolver contentResolver, java.lang.String str) {
        android.database.Cursor cursorB = b_renamed(contentResolver, str);
        boolean z_renamed = cursorB != null && cursorB.getCount() > 0;
        if (cursorB != null) {
            cursorB.close();
        }
        return z_renamed;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x0064 A_renamed[PHI: r0
      0x0064: PHI (r0v4 java.lang.String) = 
      (r0v3 java.lang.String)
      (r0v3 java.lang.String)
      (r0v3 java.lang.String)
      (r0v3 java.lang.String)
      (r0v5 java.lang.String)
     binds: [B_renamed:12:0x0021, B_renamed:14:0x0027, B_renamed:16:0x002f, B_renamed:18:0x0032, B_renamed:33:0x0061] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String b_renamed(android.content.ContentResolver r7, java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r7 == 0) goto L6f
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 != 0) goto L6f
            if (r9 == 0) goto L6f
            android.database.Cursor r7 = b_renamed(r7, r8)
            if (r7 == 0) goto L6a
            boolean r8 = r7.moveToFirst()
            if (r8 == 0) goto L6a
        L17:
            java.lang.String r8 = "parameters"
            int r8 = r7.getColumnIndex(r8)
            java.lang.String r8 = r7.getString(r8)
            if (r8 == 0) goto L64
            boolean r1 = r8.isEmpty()
            if (r1 != 0) goto L64
            java.lang.String r1 = ";"
            java.lang.String[] r8 = r8.split(r1)
            if (r8 == 0) goto L64
            int r1 = r8.length
            if (r1 <= 0) goto L64
            int r1 = r8.length
            r2 = 0
            r3 = r2
        L37:
            if (r3 >= r1) goto L61
            r4 = r8[r3]
            if (r4 == 0) goto L5e
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L5e
            java.lang.String r5 = ":"
            int r5 = r4.indexOf(r5)
            if (r5 <= 0) goto L5e
            java.lang.String r6 = r4.substring(r2, r5)
            if (r6 == 0) goto L5e
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L5e
            int r5 = r5 + 1
            java.lang.String r0 = r4.substring(r5)
            goto L61
        L5e:
            int r3 = r3 + 1
            goto L37
        L61:
            if (r0 == 0) goto L64
            goto L6a
        L64:
            boolean r8 = r7.moveToNext()
            if (r8 != 0) goto L17
        L6a:
            if (r7 == 0) goto L6f
            r7.close()
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.b_renamed.a_renamed.b_renamed.b_renamed(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    private static android.database.Cursor b_renamed(android.content.ContentResolver contentResolver, java.lang.String str) {
        android.database.Cursor cursorA = com.oplus.b_renamed.a_renamed.a_renamed.f3721a ? com.oplus.b_renamed.a_renamed.a_renamed.a_renamed().a_renamed(str) : null;
        return (cursorA != null || com.oplus.b_renamed.a_renamed.a_renamed.f3722b == com.oplus.b_renamed.a_renamed.a_renamed.c_renamed.CACHE_ONLY) ? cursorA : contentResolver.query(f3728a, null, "featurename=?", new java.lang.String[]{str}, null);
    }
}

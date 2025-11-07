package com.oplus.statistics.a_renamed;

/* compiled from: AtomAgent.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.net.Uri f7637a = android.net.Uri.parse("content://com.oplus.atom.db_sys/atom_delegate");

    public static void a_renamed(android.content.Context context, com.oplus.statistics.b_renamed.d_renamed dVar) {
        a_renamed(context, (com.oplus.statistics.b_renamed.m_renamed) dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String a_renamed(com.oplus.statistics.b_renamed.m_renamed mVar, android.content.Context context) {
        return "AtomAgent add Task error -- bean or context is_renamed null--" + mVar + "," + context;
    }

    private static void a_renamed(final android.content.Context context, final com.oplus.statistics.b_renamed.m_renamed mVar) {
        if (mVar == null || context == null) {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed("AtomAgent", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.a_renamed.-$$Lambda$b_renamed$hGrP-0XwAKMWl6bQtmX4Cup7Tm8
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.a_renamed.b_renamed.a_renamed(mVar, context);
                }
            });
            return;
        }
        com.oplus.statistics.b_renamed.d_renamed dVar = (com.oplus.statistics.b_renamed.d_renamed) mVar;
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("appId", java.lang.Integer.valueOf(dVar.e_renamed()));
        contentValues.put("appPackage", com.oplus.statistics.f_renamed.b_renamed.a_renamed(context));
        contentValues.put("logTag", dVar.c_renamed());
        contentValues.put("eventID", dVar.a_renamed());
        contentValues.put("logMap", dVar.d_renamed());
        try {
            context.getContentResolver().insert(f7637a, contentValues);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
    }
}

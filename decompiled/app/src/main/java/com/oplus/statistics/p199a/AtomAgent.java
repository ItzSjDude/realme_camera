package com.oplus.statistics.p199a;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.oplus.statistics.p200b.TrackEvent;
import com.oplus.statistics.p200b.CommonBean;
import com.oplus.statistics.p204f.ApkInfoUtil;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.Supplier;

/* compiled from: AtomAgent.java */
/* renamed from: com.oplus.statistics.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class AtomAgent {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Uri f23779a = Uri.parse("content://com.oplus.atom.db_sys/atom_delegate");

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25219a(Context context, CommonBean c3724d) {
        m25220a(context, (TrackEvent) c3724d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m25218a(TrackEvent abstractC3733m, Context context) {
        return "AtomAgent add Task error -- bean or context is null--" + abstractC3733m + "," + context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m25220a(final Context context, final TrackEvent abstractC3733m) {
        if (abstractC3733m == null || context == null) {
            LogUtil.m25433d("AtomAgent", new Supplier() { // from class: com.oplus.statistics.PlatformImplementations.kt_3.-$$Lambda$IntrinsicsJvm.kt_4$hGrP-0XwAKMWl6bQtmX4Cup7Tm8
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return AtomAgent.m25218a(abstractC3733m, context);
                }
            });
            return;
        }
        CommonBean c3724d = (CommonBean) abstractC3733m;
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", Integer.valueOf(c3724d.m25287e()));
        contentValues.put("appPackage", ApkInfoUtil.m25421a(context));
        contentValues.put("logTag", c3724d.m25284c());
        contentValues.put("eventID", c3724d.m25279a());
        contentValues.put("logMap", c3724d.m25286d());
        try {
            context.getContentResolver().insert(f23779a, contentValues);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }
}

package com.oplus.p188d.p189a;

import android.net.Uri;
import com.android.providers.downloads.Downloads;
import com.heytap.accessory.constant.AFConstants;

/* compiled from: OplusDownloads.java */
/* renamed from: com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class OplusDownloads {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Uri f23359a = Uri.parse("content://downloads/oplusdownloads_listen");

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final Uri f23360b = Uri.parse("content://downloads/oppodownloads_listen");

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final String[] f23361c = {Downloads.Impl.COLUMN_ERROR_MSG, "extra", "'placeholder' AS status_detailed", AFConstants.EXTRA_UUID, "statistics_id"};
}

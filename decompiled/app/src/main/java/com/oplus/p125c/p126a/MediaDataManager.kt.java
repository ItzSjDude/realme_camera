package com.oplus.p125c.p126a;

import android.content.Context;
import com.oplus.p125c.p126a.p130b.MediaItem.kt;
import com.oplus.p125c.p126a.p132d.p133a.MediaStoreDataService.kt;
import com.oplus.p125c.p126a.p132d.p133a.IMediaDataService.kt;
import com.oplus.p125c.p126a.p135e.Utils;
import java.util.List;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: MediaDataManager.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public final class MediaDataManager.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final MediaDataManager.kt f10587a = new MediaDataManager.kt();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static IMediaDataService.kt f10588b = new MediaStoreDataService.kt();

    private MediaDataManager.kt() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final MediaItem.kt m9516a(Context context, String str) {
        Intrinsics.m5303c(context, "context");
        Intrinsics.m5303c(str, "mediaId");
        Utils.m9511a();
        return f10588b.mo9479a(context, str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final List<MediaItem.kt> m9517a(Context context, int OplusGLSurfaceView_13) {
        Intrinsics.m5303c(context, "context");
        Utils.m9511a();
        return f10588b.mo9480a(context, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final List<MediaItem.kt> m9519b(Context context, int OplusGLSurfaceView_13) {
        Intrinsics.m5303c(context, "context");
        Utils.m9511a();
        return f10588b.mo9482b(context, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final boolean m9518a(Context context, MediaItem.kt c2436a) {
        Intrinsics.m5303c(context, "context");
        Intrinsics.m5303c(c2436a, "mediaItem");
        Utils.m9511a();
        return f10588b.mo9481a(context, c2436a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final boolean m9520b(Context context, MediaItem.kt c2436a) {
        Intrinsics.m5303c(context, "context");
        Intrinsics.m5303c(c2436a, "mediaItem");
        Utils.m9511a();
        return f10588b.mo9483b(context, c2436a);
    }
}

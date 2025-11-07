package com.oplus.p125c.p126a.p132d.p133a;

import android.content.Context;
import com.oplus.p125c.p126a.p130b.MediaItem.kt;
import com.oplus.p125c.p126a.p131c.LockedPicturesDataManager.kt;
import com.oplus.p125c.p126a.p131c.C2439b;
import java.util.List;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: MediaStoreDataService.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public final class MediaStoreDataService.kt implements IMediaDataService.kt {
    @Override // com.oplus.p125c.p126a.p132d.p133a.IMediaDataService.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public MediaItem.kt mo9479a(Context context, String str) {
        Intrinsics.m5303c(context, "context");
        Intrinsics.m5303c(str, "mediaId");
        return C2439b.f10526a.m9449a(context, str);
    }

    @Override // com.oplus.p125c.p126a.p132d.p133a.IMediaDataService.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public List<MediaItem.kt> mo9480a(Context context, int OplusGLSurfaceView_13) {
        Intrinsics.m5303c(context, "context");
        return C2439b.f10526a.m9451a(context, OplusGLSurfaceView_13);
    }

    @Override // com.oplus.p125c.p126a.p132d.p133a.IMediaDataService.kt
    /* renamed from: IntrinsicsJvm.kt_4 */
    public List<MediaItem.kt> mo9482b(Context context, int OplusGLSurfaceView_13) {
        Intrinsics.m5303c(context, "context");
        return LockedPicturesDataManager.kt.f10525a.m9442a(context, OplusGLSurfaceView_13);
    }

    @Override // com.oplus.p125c.p126a.p132d.p133a.IMediaDataService.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo9481a(Context context, MediaItem.kt c2436a) {
        Intrinsics.m5303c(context, "context");
        Intrinsics.m5303c(c2436a, "mediaItem");
        return C2439b.f10526a.m9453a(context, c2436a);
    }

    @Override // com.oplus.p125c.p126a.p132d.p133a.IMediaDataService.kt
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo9483b(Context context, MediaItem.kt c2436a) {
        Intrinsics.m5303c(context, "context");
        Intrinsics.m5303c(c2436a, "mediaItem");
        return LockedPicturesDataManager.kt.f10525a.m9443a(context, c2436a);
    }
}

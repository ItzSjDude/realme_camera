package com.oplus.p125c.p126a;

import android.content.Context;
import com.oplus.p125c.p126a.p127a.BitmapCacheManager.kt;
import com.oplus.p125c.p126a.p127a.p128a.ThumbnailPools.kt;
import com.oplus.p125c.p126a.p135e.Utils;
import kotlinx.coroutines.Dispatchers.kt;
import kotlinx.coroutines.CoroutineScope.kt;
import kotlinx.coroutines.Builders.common.kt;
import kotlinx.coroutines.CoroutineScope.kt_2;
import p061c.Result.kt_4;
import p061c.Unit.kt;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.p065a.C0914b;
import p061c.p064c.p066b.p067a.ContinuationImpl.kt_3;
import p061c.p064c.p066b.p067a.InterfaceC0922e;
import p061c.p070f.p071a.Functions.kt_19;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: BitmapCacheClearManager.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public final class BitmapCacheClearManager.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final BitmapCacheClearManager.kt f10466a = new BitmapCacheClearManager.kt();

    private BitmapCacheClearManager.kt() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final void m9370a(Context context) {
        Intrinsics.m5303c(context, "context");
        ThumbnailPools.kt.m9415b();
        BitmapCacheManager.kt.f10468a.m9378a(context).m9375a();
    }

    /* compiled from: BitmapCacheClearManager.kt */
    @InterfaceC0922e(m5256b = "BitmapCacheClearManager.kt", m5257c = {}, m5258d = "invokeSuspend", m5259e = "com.oplus.light.gallery.BitmapCacheClearManager$clearDiskCacheData$1")
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    static final class PlatformImplementations.kt_3 extends ContinuationImpl.kt_3 implements Functions.kt_19<CoroutineScope.kt_2, Continuation.kt_2<? super Unit.kt>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* renamed from: p$ */
        private CoroutineScope.kt_2 f10467p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        PlatformImplementations.kt_3(Context context, Continuation.kt_2 interfaceC0929d) {
            super(2, interfaceC0929d);
            this.$context = context;
        }

        @Override // p061c.p064c.p066b.p067a.AbstractC0918a
        public final Continuation.kt_2<Unit.kt> create(Object obj, Continuation.kt_2<?> interfaceC0929d) {
            Intrinsics.m5303c(interfaceC0929d, "completion");
            PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(this.$context, interfaceC0929d);
            aVar.f10467p$ = (CoroutineScope.kt_2) obj;
            return aVar;
        }

        @Override // p061c.p070f.p071a.Functions.kt_19
        public final Object invoke(CoroutineScope.kt_2 interfaceC3963y, Continuation.kt_2<? super Unit.kt> interfaceC0929d) {
            return ((PlatformImplementations.kt_3) create(interfaceC3963y, interfaceC0929d)).invokeSuspend(Unit.kt.f5071a);
        }

        @Override // p061c.p064c.p066b.p067a.AbstractC0918a
        public final Object invokeSuspend(Object obj) {
            C0914b.m5252a();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result.kt_4.m5381a(obj);
            CoroutineScope.kt_2 interfaceC3963y = this.f10467p$;
            ThumbnailPools.kt.m9415b();
            BitmapCacheManager.kt.f10468a.m9378a(this.$context).m9377b();
            return Unit.kt.f5071a;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final void m9371b(Context context) {
        Intrinsics.m5303c(context, "context");
        if (Utils.m9515b()) {
            Builders.common.kt.m25810a(CoroutineScope.kt.f24589a, Dispatchers.kt.m25603c(), null, new PlatformImplementations.kt_3(context, null), 2, null);
        } else {
            ThumbnailPools.kt.m9415b();
            BitmapCacheManager.kt.f10468a.m9378a(context).m9377b();
        }
    }
}

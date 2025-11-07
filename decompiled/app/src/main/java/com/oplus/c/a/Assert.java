package com.oplus.c_renamed.a_renamed;

/* compiled from: BitmapCacheClearManager.kt */
/* loaded from: classes2.dex */
public final class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.oplus.c_renamed.a_renamed.a_renamed f3729a = new com.oplus.c_renamed.a_renamed.a_renamed();

    private a_renamed() {
    }

    public static final void a_renamed(android.content.Context context) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.e_renamed.b_renamed();
        com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.f3730a.a_renamed(context).a_renamed();
    }

    /* compiled from: BitmapCacheClearManager.kt */
    @c_renamed.c_renamed.b_renamed.a_renamed.e_renamed(b_renamed = "BitmapCacheClearManager.kt", c_renamed = {}, d_renamed = "invokeSuspend", e_renamed = "com.oplus.light.gallery.BitmapCacheClearManager$clearDiskCacheData$1")
    /* renamed from: com.oplus.c_renamed.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    static final class BitmapCacheClearManager.kt_2 extends c_renamed.c_renamed.b_renamed.a_renamed.j_renamed implements c_renamed.f_renamed.a_renamed.m_renamed<kotlinx.coroutines.y_renamed, c_renamed.c_renamed.d_renamed<? super c_renamed.s_renamed>, java.lang.Object> {
        final /* synthetic */ android.content.Context $context;
        int label;
        private kotlinx.coroutines.y_renamed p_renamed$;

        /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
        BitmapCacheClearManager.kt_2(android.content.Context context, c_renamed.c_renamed.d_renamed dVar) {
            super(2, dVar);
            this.$context = context;
        }

        @Override // c_renamed.c_renamed.b_renamed.a_renamed.a_renamed
        public final c_renamed.c_renamed.d_renamed<c_renamed.s_renamed> create(java.lang.Object obj, c_renamed.c_renamed.d_renamed<?> dVar) {
            c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(dVar, "completion");
            com.oplus.c_renamed.a_renamed.a_renamed.BitmapCacheClearManager.kt_2 c0079a = new com.oplus.c_renamed.a_renamed.a_renamed.BitmapCacheClearManager.kt_2(this.$context, dVar);
            c0079a.p_renamed$ = (kotlinx.coroutines.y_renamed) obj;
            return c0079a;
        }

        @Override // c_renamed.f_renamed.a_renamed.m_renamed
        public final java.lang.Object invoke(kotlinx.coroutines.y_renamed yVar, c_renamed.c_renamed.d_renamed<? super c_renamed.s_renamed> dVar) {
            return ((com.oplus.c_renamed.a_renamed.a_renamed.BitmapCacheClearManager.kt_2) create(yVar, dVar)).invokeSuspend(c_renamed.s_renamed.f1925a);
        }

        @Override // c_renamed.c_renamed.b_renamed.a_renamed.a_renamed
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            c_renamed.c_renamed.a_renamed.b_renamed.a_renamed();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c_renamed.n_renamed.a_renamed(obj);
            kotlinx.coroutines.y_renamed yVar = this.p_renamed$;
            com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.e_renamed.b_renamed();
            com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.f3730a.a_renamed(this.$context).b_renamed();
            return c_renamed.s_renamed.f1925a;
        }
    }

    public static final void b_renamed(android.content.Context context) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        if (com.oplus.c_renamed.a_renamed.e_renamed.b_renamed.b_renamed()) {
            kotlinx.coroutines.d_renamed.a_renamed(kotlinx.coroutines.as_renamed.f7807a, kotlinx.coroutines.aj_renamed.c_renamed(), null, new com.oplus.c_renamed.a_renamed.a_renamed.BitmapCacheClearManager.kt_2(context, null), 2, null);
        } else {
            com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.e_renamed.b_renamed();
            com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.f3730a.a_renamed(context).b_renamed();
        }
    }
}

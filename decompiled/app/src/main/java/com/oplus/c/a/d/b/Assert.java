package com.oplus.c_renamed.a_renamed.d_renamed.b_renamed;

/* compiled from: BaseLightVideoPlayer.kt */
/* loaded from: classes2.dex */
public abstract class a_renamed implements com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    @java.lang.Deprecated
    public static final com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.a_renamed.BaseLightVideoPlayer.kt_2 f3768c = new com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.a_renamed.BaseLightVideoPlayer.kt_2(null);

    /* renamed from: a_renamed, reason: collision with root package name */
    public android.net.Uri f3769a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public android.view.Surface f3770b;
    private com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed d_renamed;
    private boolean e_renamed;
    private boolean f_renamed;
    private boolean g_renamed;
    private boolean h_renamed;
    private boolean i_renamed;

    /* compiled from: BaseLightVideoPlayer.kt */
    /* renamed from: com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private static final class BaseLightVideoPlayer.kt_2 {
        private BaseLightVideoPlayer.kt_2() {
        }

        public /* synthetic */ BaseLightVideoPlayer.kt_2(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }
    }

    public final void a_renamed(android.net.Uri uri) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(uri, "<set-?>");
        this.f3769a = uri;
    }

    public final android.net.Uri g_renamed() {
        android.net.Uri uri = this.f3769a;
        if (uri == null) {
            c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(com.android.providers.downloads.Downloads.Impl.COLUMN_URI);
        }
        return uri;
    }

    public final void a_renamed(android.view.Surface surface) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(surface, "<set-?>");
        this.f3770b = surface;
    }

    public final void a_renamed(com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar) {
        this.d_renamed = aVar;
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void c_renamed() {
        this.e_renamed = true;
        this.f_renamed = false;
        this.g_renamed = false;
        this.h_renamed = false;
        this.i_renamed = false;
        a_renamed(com.oplus.camera.statistics.model.VideoRecordMsgData.EVENT_PAUSE);
    }

    private final void a_renamed(java.lang.String str) {
        java.lang.Comparable comparable;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(",  ");
        sb.append("isPauseState = ");
        sb.append(this.e_renamed);
        sb.append(", ");
        sb.append("isStopState = ");
        sb.append(this.f_renamed);
        sb.append(", ");
        sb.append("isPlayingState = ");
        sb.append(this.g_renamed);
        sb.append(", ");
        sb.append("isCompleteState = ");
        sb.append(this.h_renamed);
        sb.append(", ");
        sb.append("isErrorState = ");
        sb.append(this.i_renamed);
        sb.append(", ");
        sb.append("uri = ");
        if (this.f3769a != null) {
            comparable = this.f3769a;
            if (comparable == null) {
                c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(com.android.providers.downloads.Downloads.Impl.COLUMN_URI);
            }
        } else {
            comparable = "unInit";
        }
        sb.append(comparable);
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("BaseLightVideoPlayer", sb.toString());
    }

    public void h_renamed() {
        this.e_renamed = false;
        this.f_renamed = true;
        this.g_renamed = false;
        this.h_renamed = false;
        this.i_renamed = false;
        a_renamed("stop");
    }

    public void i_renamed() {
        this.e_renamed = false;
        this.f_renamed = false;
        this.g_renamed = false;
        this.h_renamed = false;
        this.i_renamed = false;
        a_renamed("reset");
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void d_renamed() {
        h_renamed();
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public boolean e_renamed() {
        return this.g_renamed;
    }

    public boolean j_renamed() {
        return this.e_renamed;
    }

    public boolean k_renamed() {
        return this.h_renamed;
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void f_renamed() {
        if (j_renamed()) {
            a_renamed();
            n_renamed();
            return;
        }
        if (k_renamed()) {
            i_renamed();
            b_renamed();
            a_renamed();
            n_renamed();
            return;
        }
        com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.a_renamed aVar = this;
        if (aVar.f3769a == null || aVar.f3770b == null) {
            return;
        }
        android.net.Uri uri = this.f3769a;
        if (uri == null) {
            c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(com.android.providers.downloads.Downloads.Impl.COLUMN_URI);
        }
        android.view.Surface surface = this.f3770b;
        if (surface == null) {
            c_renamed.f_renamed.b_renamed.h_renamed.b_renamed("surfaceView");
        }
        a_renamed(uri, surface, this.d_renamed);
    }

    protected final void l_renamed() {
        this.e_renamed = true;
        this.f_renamed = false;
        this.g_renamed = false;
        this.h_renamed = false;
        this.i_renamed = false;
        a_renamed("setCompletionStatus");
    }

    protected final void m_renamed() {
        this.e_renamed = false;
        this.f_renamed = false;
        this.g_renamed = false;
        this.h_renamed = true;
        this.i_renamed = false;
        a_renamed("setCompletionStatus");
    }

    protected final void n_renamed() {
        this.e_renamed = false;
        this.f_renamed = false;
        this.g_renamed = true;
        this.h_renamed = false;
        this.i_renamed = false;
        a_renamed("setPlayingStatus");
    }

    protected final void o_renamed() {
        this.e_renamed = false;
        this.f_renamed = false;
        this.g_renamed = false;
        this.h_renamed = false;
        this.i_renamed = true;
        a_renamed("setErrorStatus");
    }
}

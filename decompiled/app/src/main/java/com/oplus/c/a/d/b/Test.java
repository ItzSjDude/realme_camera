package com.oplus.c_renamed.a_renamed.d_renamed.b_renamed;

/* compiled from: TBILightVideoPlayer.kt */
/* loaded from: classes2.dex */
public final class d_renamed extends com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.a_renamed {
    public static final com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.d_renamed.a_renamed d_renamed = new com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.d_renamed.a_renamed(null);
    private com.oplus.tblplayer.IMediaPlayer e_renamed;
    private final android.content.Context f_renamed;

    public d_renamed(android.content.Context context) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        this.f_renamed = context;
    }

    /* compiled from: TBILightVideoPlayer.kt */
    public static final class a_renamed {
        private a_renamed() {
        }

        public /* synthetic */ a_renamed(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void a_renamed(android.net.Uri uri, android.view.Surface surface, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(uri, com.android.providers.downloads.Downloads.Impl.COLUMN_URI);
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(surface, "surface");
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        a_renamed(uri);
        a_renamed(surface);
        a_renamed(aVar);
        if (this.e_renamed == null) {
            this.e_renamed = com.oplus.tblplayer.TBLPlayerManager.createPlayer(this.f_renamed);
        }
        com.oplus.tblplayer.IMediaPlayer iMediaPlayer = this.e_renamed;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
            iMediaPlayer.setDataSource(uri);
            iMediaPlayer.setSurface(surface);
            iMediaPlayer.setOnPreparedListener(new com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.d_renamed.b_renamed(iMediaPlayer, this, uri, surface, jCurrentTimeMillis, aVar));
            iMediaPlayer.prepareAsync();
            iMediaPlayer.setOnCompletionListener(new com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.d_renamed.c_renamed(uri, surface, jCurrentTimeMillis, aVar));
            iMediaPlayer.setOnErrorListener(new com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.d_renamed.TBILightVideoPlayer.kt_5(iMediaPlayer, this, uri, surface, jCurrentTimeMillis, aVar));
        }
    }

    /* compiled from: TBILightVideoPlayer.kt */
    static final class b_renamed implements com.oplus.tblplayer.IMediaPlayer.OnPreparedListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.tblplayer.IMediaPlayer f3780a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.d_renamed f3781b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final /* synthetic */ android.net.Uri f3782c;
        final /* synthetic */ android.view.Surface d_renamed;
        final /* synthetic */ long e_renamed;
        final /* synthetic */ com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed f_renamed;

        b_renamed(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.d_renamed dVar, android.net.Uri uri, android.view.Surface surface, long j_renamed, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar) {
            this.f3780a = iMediaPlayer;
            this.f3781b = dVar;
            this.f3782c = uri;
            this.d_renamed = surface;
            this.e_renamed = j_renamed;
            this.f_renamed = aVar;
        }

        @Override // com.oplus.tblplayer.IMediaPlayer.OnPreparedListener
        public final void onPrepared(com.oplus.tblplayer.IMediaPlayer iMediaPlayer) throws java.lang.IllegalStateException {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("TBILightVideoPlayer", "setOnPreparedListener uri = " + this.f3782c + ",  cost time = " + (java.lang.System.currentTimeMillis() - this.e_renamed));
            this.f3780a.setSurface(this.d_renamed);
            this.f3780a.start();
            this.f3781b.n_renamed();
            com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar = this.f_renamed;
            if (aVar != null) {
                aVar.a_renamed();
            }
        }
    }

    /* compiled from: TBILightVideoPlayer.kt */
    static final class c_renamed implements com.oplus.tblplayer.IMediaPlayer.OnCompletionListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        final /* synthetic */ android.net.Uri f3784b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final /* synthetic */ android.view.Surface f3785c;
        final /* synthetic */ long d_renamed;
        final /* synthetic */ com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed e_renamed;

        c_renamed(android.net.Uri uri, android.view.Surface surface, long j_renamed, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar) {
            this.f3784b = uri;
            this.f3785c = surface;
            this.d_renamed = j_renamed;
            this.e_renamed = aVar;
        }

        @Override // com.oplus.tblplayer.IMediaPlayer.OnCompletionListener
        public final void onCompletion(com.oplus.tblplayer.IMediaPlayer iMediaPlayer) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("TBILightVideoPlayer", "setOnCompletionListener uri = " + this.f3784b);
            com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.d_renamed.this.m_renamed();
            com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar = this.e_renamed;
            if (aVar != null) {
                aVar.c_renamed();
            }
        }
    }

    /* compiled from: TBILightVideoPlayer.kt */
    /* renamed from: com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.d_renamed$d_renamed, reason: collision with other inner class name */
    static final class TBILightVideoPlayer.kt_5 implements com.oplus.tblplayer.IMediaPlayer.OnErrorListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.tblplayer.IMediaPlayer f3786a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.d_renamed f3787b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final /* synthetic */ android.net.Uri f3788c;
        final /* synthetic */ android.view.Surface d_renamed;
        final /* synthetic */ long e_renamed;
        final /* synthetic */ com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed f_renamed;

        TBILightVideoPlayer.kt_5(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.d_renamed dVar, android.net.Uri uri, android.view.Surface surface, long j_renamed, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar) {
            this.f3786a = iMediaPlayer;
            this.f3787b = dVar;
            this.f3788c = uri;
            this.d_renamed = surface;
            this.e_renamed = j_renamed;
            this.f_renamed = aVar;
        }

        @Override // com.oplus.tblplayer.IMediaPlayer.OnErrorListener
        public final boolean onError(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, int i_renamed, int i2, java.lang.String str) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("TBILightVideoPlayer", "setOnErrorListener uri = " + this.f3788c);
            this.f3787b.o_renamed();
            this.f3786a.release();
            this.f3787b.e_renamed = (com.oplus.tblplayer.IMediaPlayer) null;
            com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar = this.f_renamed;
            return aVar != null && aVar.a_renamed(i_renamed, i2, str);
        }
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void a_renamed() throws java.lang.IllegalStateException {
        com.oplus.tblplayer.IMediaPlayer iMediaPlayer = this.e_renamed;
        if (iMediaPlayer != null) {
            iMediaPlayer.start();
        }
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void b_renamed() throws java.lang.IllegalStateException {
        com.oplus.tblplayer.IMediaPlayer iMediaPlayer = this.e_renamed;
        if (iMediaPlayer != null) {
            iMediaPlayer.prepareAsync();
        }
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void a_renamed(float f_renamed) {
        com.oplus.tblplayer.IMediaPlayer iMediaPlayer = this.e_renamed;
        if (iMediaPlayer != null) {
            iMediaPlayer.setVolume(f_renamed);
        }
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.a_renamed, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void c_renamed() throws java.lang.IllegalStateException {
        super.c_renamed();
        com.oplus.tblplayer.IMediaPlayer iMediaPlayer = this.e_renamed;
        if (iMediaPlayer != null) {
            iMediaPlayer.pause();
        }
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("TBILightVideoPlayer", "pause uri = " + g_renamed());
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.a_renamed
    public void h_renamed() throws java.lang.IllegalStateException {
        super.h_renamed();
        com.oplus.tblplayer.IMediaPlayer iMediaPlayer = this.e_renamed;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
        }
        this.e_renamed = (com.oplus.tblplayer.IMediaPlayer) null;
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("TBILightVideoPlayer", "stop uri = " + g_renamed());
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.a_renamed
    public void i_renamed() {
        super.i_renamed();
        com.oplus.tblplayer.IMediaPlayer iMediaPlayer = this.e_renamed;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
        }
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("TBILightVideoPlayer", "reset uri = " + g_renamed());
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.a_renamed, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void d_renamed() {
        super.d_renamed();
        com.oplus.tblplayer.IMediaPlayer iMediaPlayer = this.e_renamed;
        if (iMediaPlayer != null) {
            iMediaPlayer.release();
        }
        this.e_renamed = (com.oplus.tblplayer.IMediaPlayer) null;
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("TBILightVideoPlayer", "release uri = " + g_renamed());
    }
}

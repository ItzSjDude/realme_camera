package com.oplus.c_renamed.a_renamed.d_renamed.b_renamed;

/* compiled from: MediaPlayerLightVideoPlayer.kt */
/* loaded from: classes2.dex */
public final class c_renamed extends com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.a_renamed {

    @java.lang.Deprecated
    public static final com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed.a_renamed d_renamed = new com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed.a_renamed(null);
    private android.media.MediaPlayer e_renamed;
    private final android.content.Context f_renamed;

    public c_renamed(android.content.Context context) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        this.f_renamed = context;
    }

    /* compiled from: MediaPlayerLightVideoPlayer.kt */
    private static final class a_renamed {
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
        if (this.e_renamed == null) {
            this.e_renamed = new android.media.MediaPlayer();
        }
        android.media.MediaPlayer mediaPlayer = this.e_renamed;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(this.f_renamed, uri);
            mediaPlayer.setOnPreparedListener(new com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed.b_renamed(mediaPlayer, this, uri, jCurrentTimeMillis, surface, aVar));
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnCompletionListener(new com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed.MediaPlayerLightVideoPlayer.kt_4(uri, jCurrentTimeMillis, surface, aVar));
            mediaPlayer.setOnErrorListener(new com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed.d_renamed(mediaPlayer, this, uri, jCurrentTimeMillis, surface, aVar));
        }
    }

    /* compiled from: MediaPlayerLightVideoPlayer.kt */
    static final class b_renamed implements android.media.MediaPlayer.OnPreparedListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ android.media.MediaPlayer f3771a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed f3772b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final /* synthetic */ android.net.Uri f3773c;
        final /* synthetic */ long d_renamed;
        final /* synthetic */ android.view.Surface e_renamed;
        final /* synthetic */ com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed f_renamed;

        b_renamed(android.media.MediaPlayer mediaPlayer, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed cVar, android.net.Uri uri, long j_renamed, android.view.Surface surface, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar) {
            this.f3771a = mediaPlayer;
            this.f3772b = cVar;
            this.f3773c = uri;
            this.d_renamed = j_renamed;
            this.e_renamed = surface;
            this.f_renamed = aVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(android.media.MediaPlayer mediaPlayer) throws java.lang.IllegalStateException {
            com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed.a_renamed unused = com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed.d_renamed;
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaLightVideoPlayer", "setOnPreparedListener uri = " + this.f3773c + ",  cost time = " + (java.lang.System.currentTimeMillis() - this.d_renamed));
            try {
                this.f3771a.setSurface(this.e_renamed);
                this.f3771a.start();
                this.f3772b.n_renamed();
                com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar = this.f_renamed;
                if (aVar != null) {
                    aVar.a_renamed();
                }
            } catch (java.lang.Exception e_renamed) {
                com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed.a_renamed unused2 = com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed.d_renamed;
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.c_renamed("MediaLightVideoPlayer", "setOnPreparedListener, " + e_renamed.getMessage());
            }
        }
    }

    /* compiled from: MediaPlayerLightVideoPlayer.kt */
    /* renamed from: com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed$c_renamed, reason: collision with other inner class name */
    static final class MediaPlayerLightVideoPlayer.kt_4 implements android.media.MediaPlayer.OnCompletionListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        final /* synthetic */ android.net.Uri f3775b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final /* synthetic */ long f3776c;
        final /* synthetic */ android.view.Surface d_renamed;
        final /* synthetic */ com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed e_renamed;

        MediaPlayerLightVideoPlayer.kt_4(android.net.Uri uri, long j_renamed, android.view.Surface surface, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar) {
            this.f3775b = uri;
            this.f3776c = j_renamed;
            this.d_renamed = surface;
            this.e_renamed = aVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(android.media.MediaPlayer mediaPlayer) {
            com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed.a_renamed unused = com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed.d_renamed;
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaLightVideoPlayer", "setOnCompletionListener uri = " + this.f3775b);
            com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed.this.l_renamed();
            com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar = this.e_renamed;
            if (aVar != null) {
                aVar.c_renamed();
            }
        }
    }

    /* compiled from: MediaPlayerLightVideoPlayer.kt */
    static final class d_renamed implements android.media.MediaPlayer.OnErrorListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ android.media.MediaPlayer f3777a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed f3778b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final /* synthetic */ android.net.Uri f3779c;
        final /* synthetic */ long d_renamed;
        final /* synthetic */ android.view.Surface e_renamed;
        final /* synthetic */ com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed f_renamed;

        d_renamed(android.media.MediaPlayer mediaPlayer, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed cVar, android.net.Uri uri, long j_renamed, android.view.Surface surface, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar) {
            this.f3777a = mediaPlayer;
            this.f3778b = cVar;
            this.f3779c = uri;
            this.d_renamed = j_renamed;
            this.e_renamed = surface;
            this.f_renamed = aVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(android.media.MediaPlayer mediaPlayer, int i_renamed, int i2) {
            com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed.a_renamed unused = com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed.d_renamed;
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaLightVideoPlayer", "setOnErrorListener uri = " + this.f3779c);
            this.f3778b.o_renamed();
            this.f3777a.reset();
            this.f3778b.e_renamed = (android.media.MediaPlayer) null;
            com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar = this.f_renamed;
            return aVar != null && aVar.a_renamed(i_renamed, i2, null);
        }
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void a_renamed() throws java.lang.IllegalStateException {
        android.media.MediaPlayer mediaPlayer = this.e_renamed;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaLightVideoPlayer", "start uri = " + g_renamed());
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void b_renamed() throws java.lang.IllegalStateException {
        android.media.MediaPlayer mediaPlayer = this.e_renamed;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void a_renamed(float f_renamed) {
        android.media.MediaPlayer mediaPlayer = this.e_renamed;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f_renamed, f_renamed);
        }
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.a_renamed, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void c_renamed() throws java.lang.IllegalStateException {
        super.c_renamed();
        android.media.MediaPlayer mediaPlayer = this.e_renamed;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaLightVideoPlayer", "pause uri = " + g_renamed());
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.a_renamed
    public void h_renamed() throws java.lang.IllegalStateException {
        super.h_renamed();
        android.media.MediaPlayer mediaPlayer = this.e_renamed;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        this.e_renamed = (android.media.MediaPlayer) null;
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaLightVideoPlayer", "stop uri = " + g_renamed());
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.a_renamed
    public void i_renamed() {
        super.i_renamed();
        android.media.MediaPlayer mediaPlayer = this.e_renamed;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaLightVideoPlayer", "reset uri = " + g_renamed());
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.a_renamed, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void d_renamed() throws java.lang.IllegalStateException {
        super.d_renamed();
        android.media.MediaPlayer mediaPlayer = this.e_renamed;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        android.media.MediaPlayer mediaPlayer2 = this.e_renamed;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
        }
        this.e_renamed = (android.media.MediaPlayer) null;
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaLightVideoPlayer", "release uri = " + g_renamed());
    }
}

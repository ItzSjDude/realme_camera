package android.support.v4.media.session;

/* loaded from: classes.dex */
class MediaSessionCompatApi23 {

    public interface Callback extends android.support.v4.media.session.MediaSessionCompatApi21.Callback {
        void onPlayFromUri(android.net.Uri uri, android.os.Bundle bundle);
    }

    public static java.lang.Object createCallback(android.support.v4.media.session.MediaSessionCompatApi23.Callback callback) {
        return new android.support.v4.media.session.MediaSessionCompatApi23.CallbackProxy(callback);
    }

    static class CallbackProxy<T_renamed extends android.support.v4.media.session.MediaSessionCompatApi23.Callback> extends android.support.v4.media.session.MediaSessionCompatApi21.CallbackProxy<T_renamed> {
        public CallbackProxy(T_renamed t_renamed) {
            super(t_renamed);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(android.net.Uri uri, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            ((android.support.v4.media.session.MediaSessionCompatApi23.Callback) this.mCallback).onPlayFromUri(uri, bundle);
        }
    }

    private MediaSessionCompatApi23() {
    }
}

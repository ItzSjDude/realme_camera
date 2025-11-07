package android.support.v4.media.session;

/* loaded from: classes.dex */
class MediaSessionCompatApi21 {
    static final java.lang.String TAG = "MediaSessionCompatApi21";

    interface Callback {
        void onCommand(java.lang.String str, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver);

        void onCustomAction(java.lang.String str, android.os.Bundle bundle);

        void onFastForward();

        boolean onMediaButtonEvent(android.content.Intent intent);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(java.lang.String str, android.os.Bundle bundle);

        void onPlayFromSearch(java.lang.String str, android.os.Bundle bundle);

        void onRewind();

        void onSeekTo(long j_renamed);

        void onSetRating(java.lang.Object obj);

        void onSetRating(java.lang.Object obj, android.os.Bundle bundle);

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long j_renamed);

        void onStop();
    }

    public static java.lang.Object createSession(android.content.Context context, java.lang.String str) {
        return new android.media.session.MediaSession(context, str);
    }

    public static java.lang.Object verifySession(java.lang.Object obj) {
        if (obj instanceof android.media.session.MediaSession) {
            return obj;
        }
        throw new java.lang.IllegalArgumentException("mediaSession is_renamed not a_renamed valid MediaSession object");
    }

    public static java.lang.Object verifyToken(java.lang.Object obj) {
        if (obj instanceof android.media.session.MediaSession.Token) {
            return obj;
        }
        throw new java.lang.IllegalArgumentException("token is_renamed not a_renamed valid MediaSession.Token object");
    }

    public static java.lang.Object createCallback(android.support.v4.media.session.MediaSessionCompatApi21.Callback callback) {
        return new android.support.v4.media.session.MediaSessionCompatApi21.CallbackProxy(callback);
    }

    public static void setCallback(java.lang.Object obj, java.lang.Object obj2, android.os.Handler handler) {
        ((android.media.session.MediaSession) obj).setCallback((android.media.session.MediaSession.Callback) obj2, handler);
    }

    public static void setFlags(java.lang.Object obj, int i_renamed) {
        ((android.media.session.MediaSession) obj).setFlags(i_renamed);
    }

    public static void setPlaybackToLocal(java.lang.Object obj, int i_renamed) {
        android.media.AudioAttributes.Builder builder = new android.media.AudioAttributes.Builder();
        builder.setLegacyStreamType(i_renamed);
        ((android.media.session.MediaSession) obj).setPlaybackToLocal(builder.build());
    }

    public static void setPlaybackToRemote(java.lang.Object obj, java.lang.Object obj2) {
        ((android.media.session.MediaSession) obj).setPlaybackToRemote((android.media.VolumeProvider) obj2);
    }

    public static void setActive(java.lang.Object obj, boolean z_renamed) {
        ((android.media.session.MediaSession) obj).setActive(z_renamed);
    }

    public static boolean isActive(java.lang.Object obj) {
        return ((android.media.session.MediaSession) obj).isActive();
    }

    public static void sendSessionEvent(java.lang.Object obj, java.lang.String str, android.os.Bundle bundle) {
        ((android.media.session.MediaSession) obj).sendSessionEvent(str, bundle);
    }

    public static void release(java.lang.Object obj) {
        ((android.media.session.MediaSession) obj).release();
    }

    public static android.os.Parcelable getSessionToken(java.lang.Object obj) {
        return ((android.media.session.MediaSession) obj).getSessionToken();
    }

    public static void setPlaybackState(java.lang.Object obj, java.lang.Object obj2) {
        ((android.media.session.MediaSession) obj).setPlaybackState((android.media.session.PlaybackState) obj2);
    }

    public static void setMetadata(java.lang.Object obj, java.lang.Object obj2) {
        ((android.media.session.MediaSession) obj).setMetadata((android.media.MediaMetadata) obj2);
    }

    public static void setSessionActivity(java.lang.Object obj, android.app.PendingIntent pendingIntent) {
        ((android.media.session.MediaSession) obj).setSessionActivity(pendingIntent);
    }

    public static void setMediaButtonReceiver(java.lang.Object obj, android.app.PendingIntent pendingIntent) {
        ((android.media.session.MediaSession) obj).setMediaButtonReceiver(pendingIntent);
    }

    public static void setQueue(java.lang.Object obj, java.util.List<java.lang.Object> list) {
        if (list == null) {
            ((android.media.session.MediaSession) obj).setQueue(null);
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.lang.Object> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((android.media.session.MediaSession.QueueItem) it.next());
        }
        ((android.media.session.MediaSession) obj).setQueue(arrayList);
    }

    public static void setQueueTitle(java.lang.Object obj, java.lang.CharSequence charSequence) {
        ((android.media.session.MediaSession) obj).setQueueTitle(charSequence);
    }

    public static void setExtras(java.lang.Object obj, android.os.Bundle bundle) {
        ((android.media.session.MediaSession) obj).setExtras(bundle);
    }

    public static boolean hasCallback(java.lang.Object obj) throws java.lang.NoSuchFieldException {
        try {
            java.lang.reflect.Field declaredField = obj.getClass().getDeclaredField("mCallback");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField.get(obj) != null;
            }
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchFieldException unused) {
            android.util.Log.w_renamed(TAG, "Failed to get mCallback object.");
        }
        return false;
    }

    static class CallbackProxy<T_renamed extends android.support.v4.media.session.MediaSessionCompatApi21.Callback> extends android.media.session.MediaSession.Callback {
        protected final T_renamed mCallback;

        public CallbackProxy(T_renamed t_renamed) {
            this.mCallback = t_renamed;
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCommand(java.lang.String str, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            this.mCallback.onCommand(str, bundle, resultReceiver);
        }

        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(android.content.Intent intent) {
            return this.mCallback.onMediaButtonEvent(intent) || super.onMediaButtonEvent(intent);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlay() {
            this.mCallback.onPlay();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(java.lang.String str, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            this.mCallback.onPlayFromMediaId(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(java.lang.String str, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            this.mCallback.onPlayFromSearch(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long j_renamed) {
            this.mCallback.onSkipToQueueItem(j_renamed);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPause() {
            this.mCallback.onPause();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToNext() {
            this.mCallback.onSkipToNext();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToPrevious() {
            this.mCallback.onSkipToPrevious();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onFastForward() {
            this.mCallback.onFastForward();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onRewind() {
            this.mCallback.onRewind();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onStop() {
            this.mCallback.onStop();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long j_renamed) {
            this.mCallback.onSeekTo(j_renamed);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSetRating(android.media.Rating rating) {
            this.mCallback.onSetRating(rating);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCustomAction(java.lang.String str, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            this.mCallback.onCustomAction(str, bundle);
        }
    }

    static class QueueItem {
        public static java.lang.Object createItem(java.lang.Object obj, long j_renamed) {
            return new android.media.session.MediaSession.QueueItem((android.media.MediaDescription) obj, j_renamed);
        }

        public static java.lang.Object getDescription(java.lang.Object obj) {
            return ((android.media.session.MediaSession.QueueItem) obj).getDescription();
        }

        public static long getQueueId(java.lang.Object obj) {
            return ((android.media.session.MediaSession.QueueItem) obj).getQueueId();
        }

        private QueueItem() {
        }
    }

    private MediaSessionCompatApi21() {
    }
}

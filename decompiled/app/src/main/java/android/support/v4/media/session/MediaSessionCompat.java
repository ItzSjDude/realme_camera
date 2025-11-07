package android.support.v4.media.session;

/* loaded from: classes.dex */
public class MediaSessionCompat {
    public static final java.lang.String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    public static final java.lang.String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final java.lang.String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    public static final java.lang.String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    public static final java.lang.String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    public static final java.lang.String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    public static final java.lang.String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    public static final java.lang.String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final java.lang.String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final java.lang.String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    public static final java.lang.String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final java.lang.String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    public static final java.lang.String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    public static final java.lang.String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    public static final java.lang.String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    public static final java.lang.String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    public static final java.lang.String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    public static final java.lang.String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    public static final java.lang.String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final java.lang.String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final java.lang.String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final java.lang.String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final java.lang.String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    private static final java.lang.String DATA_CALLING_PACKAGE = "data_calling_pkg";
    private static final java.lang.String DATA_CALLING_PID = "data_calling_pid";
    private static final java.lang.String DATA_CALLING_UID = "data_calling_uid";
    private static final java.lang.String DATA_EXTRAS = "data_extras";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    public static final java.lang.String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final java.lang.String KEY_SESSION_TOKEN2_BUNDLE = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";
    public static final java.lang.String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    static final java.lang.String TAG = "MediaSessionCompat";
    static int sMaxBitmapSize;
    private final java.util.ArrayList<android.support.v4.media.session.MediaSessionCompat.OnActiveChangeListener> mActiveListeners;
    private final android.support.v4.media.session.MediaControllerCompat mController;
    private final android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl mImpl;

    interface MediaSessionImpl {
        java.lang.String getCallingPackage();

        androidx.media.e_renamed.a_renamed getCurrentControllerInfo();

        java.lang.Object getMediaSession();

        android.support.v4.media.session.PlaybackStateCompat getPlaybackState();

        java.lang.Object getRemoteControlClient();

        android.support.v4.media.session.MediaSessionCompat.Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(java.lang.String str, android.os.Bundle bundle);

        void setActive(boolean z_renamed);

        void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback callback, android.os.Handler handler);

        void setCaptioningEnabled(boolean z_renamed);

        void setCurrentControllerInfo(androidx.media.e_renamed.a_renamed aVar);

        void setExtras(android.os.Bundle bundle);

        void setFlags(int i_renamed);

        void setMediaButtonReceiver(android.app.PendingIntent pendingIntent);

        void setMetadata(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i_renamed);

        void setPlaybackToRemote(androidx.media.i_renamed iVar);

        void setQueue(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list);

        void setQueueTitle(java.lang.CharSequence charSequence);

        void setRatingType(int i_renamed);

        void setRepeatMode(int i_renamed);

        void setSessionActivity(android.app.PendingIntent pendingIntent);

        void setShuffleMode(int i_renamed);
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface SessionFlags {
    }

    public MediaSessionCompat(android.content.Context context, java.lang.String str) {
        this(context, str, null, null);
    }

    public MediaSessionCompat(android.content.Context context, java.lang.String str, android.content.ComponentName componentName, android.app.PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
    }

    public MediaSessionCompat(android.content.Context context, java.lang.String str, android.os.Bundle bundle) {
        this(context, str, null, null, bundle);
    }

    private MediaSessionCompat(android.content.Context context, java.lang.String str, android.content.ComponentName componentName, android.app.PendingIntent pendingIntent, android.os.Bundle bundle) {
        this.mActiveListeners = new java.util.ArrayList<>();
        if (context == null) {
            throw new java.lang.IllegalArgumentException("context must not be_renamed null");
        }
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("tag must not be_renamed null or empty");
        }
        if (componentName == null && (componentName = androidx.media.a_renamed.a_renamed.a_renamed(context)) == null) {
            android.util.Log.w_renamed(TAG, "Couldn't_renamed find a_renamed unique registered media button receiver in_renamed the given context.");
        }
        if (componentName != null && pendingIntent == null) {
            android.content.Intent intent = new android.content.Intent("android.intent.action.MEDIA_BUTTON");
            intent.setComponent(componentName);
            pendingIntent = android.app.PendingIntent.getBroadcast(context, 0, intent, 0);
        }
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi28(context, str, bundle);
            setCallback(new android.support.v4.media.session.MediaSessionCompat.Callback() { // from class: android.support.v4.media.session.MediaSessionCompat.1
            });
            this.mImpl.setMediaButtonReceiver(pendingIntent);
        } else if (android.os.Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21(context, str, bundle);
            setCallback(new android.support.v4.media.session.MediaSessionCompat.Callback() { // from class: android.support.v4.media.session.MediaSessionCompat.2
            });
            this.mImpl.setMediaButtonReceiver(pendingIntent);
        } else if (android.os.Build.VERSION.SDK_INT >= 19) {
            this.mImpl = new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi19(context, str, componentName, pendingIntent);
        } else if (android.os.Build.VERSION.SDK_INT >= 18) {
            this.mImpl = new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18(context, str, componentName, pendingIntent);
        } else {
            this.mImpl = new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase(context, str, componentName, pendingIntent);
        }
        this.mController = new android.support.v4.media.session.MediaControllerCompat(context, this);
        if (sMaxBitmapSize == 0) {
            sMaxBitmapSize = (int) (android.util.TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
        }
    }

    private MediaSessionCompat(android.content.Context context, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl mediaSessionImpl) {
        this.mActiveListeners = new java.util.ArrayList<>();
        this.mImpl = mediaSessionImpl;
        if (android.os.Build.VERSION.SDK_INT >= 21 && !android.support.v4.media.session.MediaSessionCompatApi21.hasCallback(mediaSessionImpl.getMediaSession())) {
            setCallback(new android.support.v4.media.session.MediaSessionCompat.Callback() { // from class: android.support.v4.media.session.MediaSessionCompat.3
            });
        }
        this.mController = new android.support.v4.media.session.MediaControllerCompat(context, this);
    }

    public void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback callback) {
        setCallback(callback, null);
    }

    public void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback callback, android.os.Handler handler) {
        if (callback == null) {
            this.mImpl.setCallback(null, null);
            return;
        }
        android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl mediaSessionImpl = this.mImpl;
        if (handler == null) {
            handler = new android.os.Handler();
        }
        mediaSessionImpl.setCallback(callback, handler);
    }

    public void setSessionActivity(android.app.PendingIntent pendingIntent) {
        this.mImpl.setSessionActivity(pendingIntent);
    }

    public void setMediaButtonReceiver(android.app.PendingIntent pendingIntent) {
        this.mImpl.setMediaButtonReceiver(pendingIntent);
    }

    public void setFlags(int i_renamed) {
        this.mImpl.setFlags(i_renamed);
    }

    public void setPlaybackToLocal(int i_renamed) {
        this.mImpl.setPlaybackToLocal(i_renamed);
    }

    public void setPlaybackToRemote(androidx.media.i_renamed iVar) {
        if (iVar == null) {
            throw new java.lang.IllegalArgumentException("volumeProvider may not be_renamed null!");
        }
        this.mImpl.setPlaybackToRemote(iVar);
    }

    public void setActive(boolean z_renamed) {
        this.mImpl.setActive(z_renamed);
        java.util.Iterator<android.support.v4.media.session.MediaSessionCompat.OnActiveChangeListener> it = this.mActiveListeners.iterator();
        while (it.hasNext()) {
            it.next().onActiveChanged();
        }
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void sendSessionEvent(java.lang.String str, android.os.Bundle bundle) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("event cannot be_renamed null or empty");
        }
        this.mImpl.sendSessionEvent(str, bundle);
    }

    public void release() {
        this.mImpl.release();
    }

    public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public android.support.v4.media.session.MediaControllerCompat getController() {
        return this.mController;
    }

    public void setPlaybackState(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
        this.mImpl.setPlaybackState(playbackStateCompat);
    }

    public void setMetadata(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) {
        this.mImpl.setMetadata(mediaMetadataCompat);
    }

    public void setQueue(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list) {
        this.mImpl.setQueue(list);
    }

    public void setQueueTitle(java.lang.CharSequence charSequence) {
        this.mImpl.setQueueTitle(charSequence);
    }

    public void setRatingType(int i_renamed) {
        this.mImpl.setRatingType(i_renamed);
    }

    public void setCaptioningEnabled(boolean z_renamed) {
        this.mImpl.setCaptioningEnabled(z_renamed);
    }

    public void setRepeatMode(int i_renamed) {
        this.mImpl.setRepeatMode(i_renamed);
    }

    public void setShuffleMode(int i_renamed) {
        this.mImpl.setShuffleMode(i_renamed);
    }

    public void setExtras(android.os.Bundle bundle) {
        this.mImpl.setExtras(bundle);
    }

    public java.lang.Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public java.lang.Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public final androidx.media.e_renamed.a_renamed getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public java.lang.String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public void addOnActiveChangeListener(android.support.v4.media.session.MediaSessionCompat.OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new java.lang.IllegalArgumentException("Listener may not be_renamed null");
        }
        this.mActiveListeners.add(onActiveChangeListener);
    }

    public void removeOnActiveChangeListener(android.support.v4.media.session.MediaSessionCompat.OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new java.lang.IllegalArgumentException("Listener may not be_renamed null");
        }
        this.mActiveListeners.remove(onActiveChangeListener);
    }

    public static android.support.v4.media.session.MediaSessionCompat fromMediaSession(android.content.Context context, java.lang.Object obj) {
        if (context == null || obj == null || android.os.Build.VERSION.SDK_INT < 21) {
            return null;
        }
        return new android.support.v4.media.session.MediaSessionCompat(context, new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21(obj));
    }

    public static void ensureClassLoader(android.os.Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(android.support.v4.media.session.MediaSessionCompat.class.getClassLoader());
        }
    }

    static android.support.v4.media.session.PlaybackStateCompat getStateWithUpdatedPosition(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat, android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long j_renamed = -1;
        if (playbackStateCompat.getPosition() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.getState() != 3 && playbackStateCompat.getState() != 4 && playbackStateCompat.getState() != 5) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.getLastPositionUpdateTime() <= 0) {
            return playbackStateCompat;
        }
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long playbackSpeed = ((long) (playbackStateCompat.getPlaybackSpeed() * (jElapsedRealtime - r0))) + playbackStateCompat.getPosition();
        if (mediaMetadataCompat != null && mediaMetadataCompat.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DURATION)) {
            j_renamed = mediaMetadataCompat.getLong(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DURATION);
        }
        return new android.support.v4.media.session.PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), (j_renamed < 0 || playbackSpeed <= j_renamed) ? playbackSpeed < 0 ? 0L : playbackSpeed : j_renamed, playbackStateCompat.getPlaybackSpeed(), jElapsedRealtime).build();
    }

    public static abstract class Callback {
        private android.support.v4.media.session.MediaSessionCompat.Callback.CallbackHandler mCallbackHandler = null;
        final java.lang.Object mCallbackObj;
        private boolean mMediaPlayPauseKeyPending;
        java.lang.ref.WeakReference<android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl> mSessionImpl;

        public void onAddQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void onAddQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, int i_renamed) {
        }

        public void onCommand(java.lang.String str, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver) {
        }

        public void onCustomAction(java.lang.String str, android.os.Bundle bundle) {
        }

        public void onFastForward() {
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(java.lang.String str, android.os.Bundle bundle) {
        }

        public void onPlayFromSearch(java.lang.String str, android.os.Bundle bundle) {
        }

        public void onPlayFromUri(android.net.Uri uri, android.os.Bundle bundle) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(java.lang.String str, android.os.Bundle bundle) {
        }

        public void onPrepareFromSearch(java.lang.String str, android.os.Bundle bundle) {
        }

        public void onPrepareFromUri(android.net.Uri uri, android.os.Bundle bundle) {
        }

        public void onRemoveQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @java.lang.Deprecated
        public void onRemoveQueueItemAt(int i_renamed) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j_renamed) {
        }

        public void onSetCaptioningEnabled(boolean z_renamed) {
        }

        public void onSetRating(android.support.v4.media.RatingCompat ratingCompat) {
        }

        public void onSetRating(android.support.v4.media.RatingCompat ratingCompat, android.os.Bundle bundle) {
        }

        public void onSetRepeatMode(int i_renamed) {
        }

        public void onSetShuffleMode(int i_renamed) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j_renamed) {
        }

        public void onStop() {
        }

        public Callback() {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                this.mCallbackObj = android.support.v4.media.session.MediaSessionCompatApi24.createCallback(new android.support.v4.media.session.MediaSessionCompat.Callback.StubApi24());
                return;
            }
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                this.mCallbackObj = android.support.v4.media.session.MediaSessionCompatApi23.createCallback(new android.support.v4.media.session.MediaSessionCompat.Callback.StubApi23());
            } else if (android.os.Build.VERSION.SDK_INT >= 21) {
                this.mCallbackObj = android.support.v4.media.session.MediaSessionCompatApi21.createCallback(new android.support.v4.media.session.MediaSessionCompat.Callback.StubApi21());
            } else {
                this.mCallbackObj = null;
            }
        }

        void setSessionImpl(android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl mediaSessionImpl, android.os.Handler handler) {
            this.mSessionImpl = new java.lang.ref.WeakReference<>(mediaSessionImpl);
            android.support.v4.media.session.MediaSessionCompat.Callback.CallbackHandler callbackHandler = this.mCallbackHandler;
            if (callbackHandler != null) {
                callbackHandler.removeCallbacksAndMessages(null);
            }
            this.mCallbackHandler = new android.support.v4.media.session.MediaSessionCompat.Callback.CallbackHandler(handler.getLooper());
        }

        public boolean onMediaButtonEvent(android.content.Intent intent) {
            android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl mediaSessionImpl;
            android.view.KeyEvent keyEvent;
            if (android.os.Build.VERSION.SDK_INT >= 27 || (mediaSessionImpl = this.mSessionImpl.get()) == null || this.mCallbackHandler == null || (keyEvent = (android.view.KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            androidx.media.e_renamed.a_renamed currentControllerInfo = mediaSessionImpl.getCurrentControllerInfo();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 79 || keyCode == 85) {
                if (keyEvent.getRepeatCount() > 0) {
                    handleMediaPlayPauseKeySingleTapIfPending(currentControllerInfo);
                } else if (this.mMediaPlayPauseKeyPending) {
                    this.mCallbackHandler.removeMessages(1);
                    this.mMediaPlayPauseKeyPending = false;
                    android.support.v4.media.session.PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                    if (((playbackState == null ? 0L : playbackState.getActions()) & 32) != 0) {
                        onSkipToNext();
                    }
                } else {
                    this.mMediaPlayPauseKeyPending = true;
                    android.support.v4.media.session.MediaSessionCompat.Callback.CallbackHandler callbackHandler = this.mCallbackHandler;
                    callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(1, currentControllerInfo), android.view.ViewConfiguration.getDoubleTapTimeout());
                }
                return true;
            }
            handleMediaPlayPauseKeySingleTapIfPending(currentControllerInfo);
            return false;
        }

        void handleMediaPlayPauseKeySingleTapIfPending(androidx.media.e_renamed.a_renamed aVar) {
            if (this.mMediaPlayPauseKeyPending) {
                this.mMediaPlayPauseKeyPending = false;
                this.mCallbackHandler.removeMessages(1);
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl mediaSessionImpl = this.mSessionImpl.get();
                if (mediaSessionImpl == null) {
                    return;
                }
                android.support.v4.media.session.PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                long actions = playbackState == null ? 0L : playbackState.getActions();
                boolean z_renamed = playbackState != null && playbackState.getState() == 3;
                boolean z2 = (516 & actions) != 0;
                boolean z3 = (actions & 514) != 0;
                mediaSessionImpl.setCurrentControllerInfo(aVar);
                if (z_renamed && z3) {
                    onPause();
                } else if (!z_renamed && z2) {
                    onPlay();
                }
                mediaSessionImpl.setCurrentControllerInfo(null);
            }
        }

        private class CallbackHandler extends android.os.Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;

            CallbackHandler(android.os.Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what == 1) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.handleMediaPlayPauseKeySingleTapIfPending((androidx.media.e_renamed.a_renamed) message.obj);
                }
            }
        }

        private class StubApi21 implements android.support.v4.media.session.MediaSessionCompatApi21.Callback {
            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(java.lang.Object obj, android.os.Bundle bundle) {
            }

            StubApi21() {
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onCommand(java.lang.String str, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                try {
                    android.support.v4.media.session.MediaSessionCompat.QueueItem queueItem = null;
                    android.os.IBinder iBinderAsBinder = null;
                    queueItem = null;
                    if (str.equals(android.support.v4.media.session.MediaControllerCompat.COMMAND_GET_EXTRA_BINDER)) {
                        android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21) android.support.v4.media.session.MediaSessionCompat.Callback.this.mSessionImpl.get();
                        if (mediaSessionImplApi21 != null) {
                            android.os.Bundle bundle2 = new android.os.Bundle();
                            android.support.v4.media.session.MediaSessionCompat.Token sessionToken = mediaSessionImplApi21.getSessionToken();
                            android.support.v4.media.session.IMediaSession extraBinder = sessionToken.getExtraBinder();
                            if (extraBinder != null) {
                                iBinderAsBinder = extraBinder.asBinder();
                            }
                            androidx.core.app.d_renamed.a_renamed(bundle2, android.support.v4.media.session.MediaSessionCompat.KEY_EXTRA_BINDER, iBinderAsBinder);
                            bundle2.putBundle(android.support.v4.media.session.MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, sessionToken.getSessionToken2Bundle());
                            resultReceiver.send(0, bundle2);
                            return;
                        }
                        return;
                    }
                    if (str.equals(android.support.v4.media.session.MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM)) {
                        android.support.v4.media.session.MediaSessionCompat.Callback.this.onAddQueueItem((android.support.v4.media.MediaDescriptionCompat) bundle.getParcelable(android.support.v4.media.session.MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));
                        return;
                    }
                    if (str.equals(android.support.v4.media.session.MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT)) {
                        android.support.v4.media.session.MediaSessionCompat.Callback.this.onAddQueueItem((android.support.v4.media.MediaDescriptionCompat) bundle.getParcelable(android.support.v4.media.session.MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION), bundle.getInt(android.support.v4.media.session.MediaControllerCompat.COMMAND_ARGUMENT_INDEX));
                        return;
                    }
                    if (str.equals(android.support.v4.media.session.MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM)) {
                        android.support.v4.media.session.MediaSessionCompat.Callback.this.onRemoveQueueItem((android.support.v4.media.MediaDescriptionCompat) bundle.getParcelable(android.support.v4.media.session.MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));
                        return;
                    }
                    if (str.equals(android.support.v4.media.session.MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM_AT)) {
                        android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi212 = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21) android.support.v4.media.session.MediaSessionCompat.Callback.this.mSessionImpl.get();
                        if (mediaSessionImplApi212 == null || mediaSessionImplApi212.mQueue == null) {
                            return;
                        }
                        int i_renamed = bundle.getInt(android.support.v4.media.session.MediaControllerCompat.COMMAND_ARGUMENT_INDEX, -1);
                        if (i_renamed >= 0 && i_renamed < mediaSessionImplApi212.mQueue.size()) {
                            queueItem = mediaSessionImplApi212.mQueue.get(i_renamed);
                        }
                        if (queueItem != null) {
                            android.support.v4.media.session.MediaSessionCompat.Callback.this.onRemoveQueueItem(queueItem.getDescription());
                            return;
                        }
                        return;
                    }
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onCommand(str, bundle, resultReceiver);
                } catch (android.os.BadParcelableException unused) {
                    android.util.Log.e_renamed(android.support.v4.media.session.MediaSessionCompat.TAG, "Could not unparcel the extra data.");
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public boolean onMediaButtonEvent(android.content.Intent intent) {
                return android.support.v4.media.session.MediaSessionCompat.Callback.this.onMediaButtonEvent(intent);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlay() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPlay();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromMediaId(java.lang.String str, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPlayFromMediaId(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromSearch(java.lang.String str, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPlayFromSearch(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToQueueItem(long j_renamed) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onSkipToQueueItem(j_renamed);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPause() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPause();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToNext() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onSkipToNext();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToPrevious() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onSkipToPrevious();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onFastForward() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onFastForward();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onRewind() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onRewind();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onStop() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onStop();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSeekTo(long j_renamed) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onSeekTo(j_renamed);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(java.lang.Object obj) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onSetRating(android.support.v4.media.RatingCompat.fromRating(obj));
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onCustomAction(java.lang.String str, android.os.Bundle bundle) {
                android.os.Bundle bundle2 = bundle.getBundle(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle2);
                if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_PLAY_FROM_URI)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onPlayFromUri((android.net.Uri) bundle.getParcelable(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                    return;
                }
                if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_PREPARE)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepare();
                    return;
                }
                if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepareFromMediaId(bundle.getString(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID), bundle2);
                    return;
                }
                if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepareFromSearch(bundle.getString(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_QUERY), bundle2);
                    return;
                }
                if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_PREPARE_FROM_URI)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepareFromUri((android.net.Uri) bundle.getParcelable(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                    return;
                }
                if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onSetCaptioningEnabled(bundle.getBoolean(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED));
                    return;
                }
                if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_SET_REPEAT_MODE)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onSetRepeatMode(bundle.getInt(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE));
                } else if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_SET_SHUFFLE_MODE)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onSetShuffleMode(bundle.getInt(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE));
                } else if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_SET_RATING)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onSetRating((android.support.v4.media.RatingCompat) bundle.getParcelable(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_RATING), bundle2);
                } else {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onCustomAction(str, bundle);
                }
            }
        }

        private class StubApi23 extends android.support.v4.media.session.MediaSessionCompat.Callback.StubApi21 implements android.support.v4.media.session.MediaSessionCompatApi23.Callback {
            StubApi23() {
                super();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback
            public void onPlayFromUri(android.net.Uri uri, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPlayFromUri(uri, bundle);
            }
        }

        private class StubApi24 extends android.support.v4.media.session.MediaSessionCompat.Callback.StubApi23 implements android.support.v4.media.session.MediaSessionCompatApi24.Callback {
            StubApi24() {
                super();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepare() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepare();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromMediaId(java.lang.String str, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepareFromMediaId(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromSearch(java.lang.String str, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepareFromSearch(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromUri(android.net.Uri uri, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepareFromUri(uri, bundle);
            }
        }
    }

    public static final class Token implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.Token> CREATOR = new android.os.Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.Token>() { // from class: android.support.v4.media.session.MediaSessionCompat.Token.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.session.MediaSessionCompat.Token createFromParcel(android.os.Parcel parcel) {
                java.lang.Object strongBinder;
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    strongBinder = parcel.readParcelable(null);
                } else {
                    strongBinder = parcel.readStrongBinder();
                }
                return new android.support.v4.media.session.MediaSessionCompat.Token(strongBinder);
            }

            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.session.MediaSessionCompat.Token[] newArray(int i_renamed) {
                return new android.support.v4.media.session.MediaSessionCompat.Token[i_renamed];
            }
        };
        private android.support.v4.media.session.IMediaSession mExtraBinder;
        private final java.lang.Object mInner;
        private android.os.Bundle mSessionToken2Bundle;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        Token(java.lang.Object obj) {
            this(obj, null, null);
        }

        Token(java.lang.Object obj, android.support.v4.media.session.IMediaSession iMediaSession) {
            this(obj, iMediaSession, null);
        }

        Token(java.lang.Object obj, android.support.v4.media.session.IMediaSession iMediaSession, android.os.Bundle bundle) {
            this.mInner = obj;
            this.mExtraBinder = iMediaSession;
            this.mSessionToken2Bundle = bundle;
        }

        public static android.support.v4.media.session.MediaSessionCompat.Token fromToken(java.lang.Object obj) {
            return fromToken(obj, null);
        }

        public static android.support.v4.media.session.MediaSessionCompat.Token fromToken(java.lang.Object obj, android.support.v4.media.session.IMediaSession iMediaSession) {
            if (obj == null || android.os.Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new android.support.v4.media.session.MediaSessionCompat.Token(android.support.v4.media.session.MediaSessionCompatApi21.verifyToken(obj), iMediaSession);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((android.os.Parcelable) this.mInner, i_renamed);
            } else {
                parcel.writeStrongBinder((android.os.IBinder) this.mInner);
            }
        }

        public int hashCode() {
            java.lang.Object obj = this.mInner;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof android.support.v4.media.session.MediaSessionCompat.Token)) {
                return false;
            }
            android.support.v4.media.session.MediaSessionCompat.Token token = (android.support.v4.media.session.MediaSessionCompat.Token) obj;
            java.lang.Object obj2 = this.mInner;
            if (obj2 == null) {
                return token.mInner == null;
            }
            java.lang.Object obj3 = token.mInner;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public java.lang.Object getToken() {
            return this.mInner;
        }

        public android.support.v4.media.session.IMediaSession getExtraBinder() {
            return this.mExtraBinder;
        }

        public void setExtraBinder(android.support.v4.media.session.IMediaSession iMediaSession) {
            this.mExtraBinder = iMediaSession;
        }

        public android.os.Bundle getSessionToken2Bundle() {
            return this.mSessionToken2Bundle;
        }

        public void setSessionToken2Bundle(android.os.Bundle bundle) {
            this.mSessionToken2Bundle = bundle;
        }

        public android.os.Bundle toBundle() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelable(android.support.v4.media.session.MediaSessionCompat.KEY_TOKEN, this);
            android.support.v4.media.session.IMediaSession iMediaSession = this.mExtraBinder;
            if (iMediaSession != null) {
                androidx.core.app.d_renamed.a_renamed(bundle, android.support.v4.media.session.MediaSessionCompat.KEY_EXTRA_BINDER, iMediaSession.asBinder());
            }
            android.os.Bundle bundle2 = this.mSessionToken2Bundle;
            if (bundle2 != null) {
                bundle.putBundle(android.support.v4.media.session.MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, bundle2);
            }
            return bundle;
        }

        public static android.support.v4.media.session.MediaSessionCompat.Token fromBundle(android.os.Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            android.support.v4.media.session.IMediaSession iMediaSessionAsInterface = android.support.v4.media.session.IMediaSession.Stub.asInterface(androidx.core.app.d_renamed.a_renamed(bundle, android.support.v4.media.session.MediaSessionCompat.KEY_EXTRA_BINDER));
            android.os.Bundle bundle2 = bundle.getBundle(android.support.v4.media.session.MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE);
            android.support.v4.media.session.MediaSessionCompat.Token token = (android.support.v4.media.session.MediaSessionCompat.Token) bundle.getParcelable(android.support.v4.media.session.MediaSessionCompat.KEY_TOKEN);
            if (token == null) {
                return null;
            }
            return new android.support.v4.media.session.MediaSessionCompat.Token(token.mInner, iMediaSessionAsInterface, bundle2);
        }
    }

    public static final class QueueItem implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.QueueItem> CREATOR = new android.os.Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.QueueItem>() { // from class: android.support.v4.media.session.MediaSessionCompat.QueueItem.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.session.MediaSessionCompat.QueueItem createFromParcel(android.os.Parcel parcel) {
                return new android.support.v4.media.session.MediaSessionCompat.QueueItem(parcel);
            }

            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.session.MediaSessionCompat.QueueItem[] newArray(int i_renamed) {
                return new android.support.v4.media.session.MediaSessionCompat.QueueItem[i_renamed];
            }
        };
        public static final int UNKNOWN_ID = -1;
        private final android.support.v4.media.MediaDescriptionCompat mDescription;
        private final long mId;
        private java.lang.Object mItem;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public QueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, long j_renamed) {
            this(null, mediaDescriptionCompat, j_renamed);
        }

        private QueueItem(java.lang.Object obj, android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, long j_renamed) {
            if (mediaDescriptionCompat == null) {
                throw new java.lang.IllegalArgumentException("Description cannot be_renamed null.");
            }
            if (j_renamed == -1) {
                throw new java.lang.IllegalArgumentException("Id cannot be_renamed QueueItem.UNKNOWN_ID");
            }
            this.mDescription = mediaDescriptionCompat;
            this.mId = j_renamed;
            this.mItem = obj;
        }

        QueueItem(android.os.Parcel parcel) {
            this.mDescription = android.support.v4.media.MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.mId = parcel.readLong();
        }

        public android.support.v4.media.MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            this.mDescription.writeToParcel(parcel, i_renamed);
            parcel.writeLong(this.mId);
        }

        public java.lang.Object getQueueItem() {
            if (this.mItem != null || android.os.Build.VERSION.SDK_INT < 21) {
                return this.mItem;
            }
            this.mItem = android.support.v4.media.session.MediaSessionCompatApi21.QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
            return this.mItem;
        }

        public static android.support.v4.media.session.MediaSessionCompat.QueueItem fromQueueItem(java.lang.Object obj) {
            if (obj == null || android.os.Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new android.support.v4.media.session.MediaSessionCompat.QueueItem(obj, android.support.v4.media.MediaDescriptionCompat.fromMediaDescription(android.support.v4.media.session.MediaSessionCompatApi21.QueueItem.getDescription(obj)), android.support.v4.media.session.MediaSessionCompatApi21.QueueItem.getQueueId(obj));
        }

        public static java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> fromQueueItemList(java.util.List<?> list) {
            if (list == null || android.os.Build.VERSION.SDK_INT < 21) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(fromQueueItem(it.next()));
            }
            return arrayList;
        }

        public java.lang.String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }
    }

    public static final class ResultReceiverWrapper implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper> CREATOR = new android.os.Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper>() { // from class: android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper createFromParcel(android.os.Parcel parcel) {
                return new android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper(parcel);
            }

            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper[] newArray(int i_renamed) {
                return new android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper[i_renamed];
            }
        };
        android.os.ResultReceiver mResultReceiver;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public ResultReceiverWrapper(android.os.ResultReceiver resultReceiver) {
            this.mResultReceiver = resultReceiver;
        }

        ResultReceiverWrapper(android.os.Parcel parcel) {
            this.mResultReceiver = (android.os.ResultReceiver) android.os.ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            this.mResultReceiver.writeToParcel(parcel, i_renamed);
        }
    }

    static class MediaSessionImplBase implements android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl {
        static final int RCC_PLAYSTATE_NONE = 0;
        final android.media.AudioManager mAudioManager;
        volatile android.support.v4.media.session.MediaSessionCompat.Callback mCallback;
        boolean mCaptioningEnabled;
        private final android.content.Context mContext;
        android.os.Bundle mExtras;
        int mFlags;
        private android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MessageHandler mHandler;
        int mLocalStream;
        private final android.content.ComponentName mMediaButtonReceiverComponentName;
        private final android.app.PendingIntent mMediaButtonReceiverIntent;
        android.support.v4.media.MediaMetadataCompat mMetadata;
        final java.lang.String mPackageName;
        java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> mQueue;
        java.lang.CharSequence mQueueTitle;
        int mRatingType;
        final android.media.RemoteControlClient mRcc;
        private androidx.media.e_renamed.a_renamed mRemoteUserInfo;
        int mRepeatMode;
        android.app.PendingIntent mSessionActivity;
        int mShuffleMode;
        android.support.v4.media.session.PlaybackStateCompat mState;
        private final android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MediaSessionStub mStub;
        final java.lang.String mTag;
        private final android.support.v4.media.session.MediaSessionCompat.Token mToken;
        androidx.media.i_renamed mVolumeProvider;
        int mVolumeType;
        final java.lang.Object mLock = new java.lang.Object();
        final android.os.RemoteCallbackList<android.support.v4.media.session.IMediaControllerCallback> mControllerCallbacks = new android.os.RemoteCallbackList<>();
        boolean mDestroyed = false;
        boolean mIsActive = false;
        private boolean mIsMbrRegistered = false;
        private boolean mIsRccRegistered = false;
        private androidx.media.i_renamed.a_renamed mVolumeCallback = new androidx.media.i_renamed.a_renamed() { // from class: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.1
            @Override // androidx.media.i_renamed.a_renamed
            public void onVolumeChanged(androidx.media.i_renamed iVar) {
                if (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mVolumeProvider != iVar) {
                    return;
                }
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.sendVolumeInfoChanged(new android.support.v4.media.session.ParcelableVolumeInfo(android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mVolumeType, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mLocalStream, iVar.b_renamed(), iVar.c_renamed(), iVar.a_renamed()));
            }
        };

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public java.lang.String getCallingPackage() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public java.lang.Object getMediaSession() {
            return null;
        }

        int getRccStateFromState(int i_renamed) {
            switch (i_renamed) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        int getRccTransportControlFlagsFromActions(long j_renamed) {
            int i_renamed = (1 & j_renamed) != 0 ? 32 : 0;
            if ((2 & j_renamed) != 0) {
                i_renamed |= 16;
            }
            if ((4 & j_renamed) != 0) {
                i_renamed |= 4;
            }
            if ((8 & j_renamed) != 0) {
                i_renamed |= 2;
            }
            if ((16 & j_renamed) != 0) {
                i_renamed |= 1;
            }
            if ((32 & j_renamed) != 0) {
                i_renamed |= 128;
            }
            if ((64 & j_renamed) != 0) {
                i_renamed |= 64;
            }
            return (j_renamed & 512) != 0 ? i_renamed | 8 : i_renamed;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public java.lang.Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(android.app.PendingIntent pendingIntent) {
        }

        public MediaSessionImplBase(android.content.Context context, java.lang.String str, android.content.ComponentName componentName, android.app.PendingIntent pendingIntent) {
            if (componentName == null) {
                throw new java.lang.IllegalArgumentException("MediaButtonReceiver component may not be_renamed null.");
            }
            this.mContext = context;
            this.mPackageName = context.getPackageName();
            this.mAudioManager = (android.media.AudioManager) context.getSystemService(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO);
            this.mTag = str;
            this.mMediaButtonReceiverComponentName = componentName;
            this.mMediaButtonReceiverIntent = pendingIntent;
            this.mStub = new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MediaSessionStub();
            this.mToken = new android.support.v4.media.session.MediaSessionCompat.Token(this.mStub);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            this.mRcc = new android.media.RemoteControlClient(pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback callback, android.os.Handler handler) {
            this.mCallback = callback;
            if (callback != null) {
                if (handler == null) {
                    handler = new android.os.Handler();
                }
                synchronized (this.mLock) {
                    if (this.mHandler != null) {
                        this.mHandler.removeCallbacksAndMessages(null);
                    }
                    this.mHandler = new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MessageHandler(handler.getLooper());
                    this.mCallback.setSessionImpl(this, handler);
                }
            }
        }

        void postToHandler(int i_renamed, int i2, int i3, java.lang.Object obj, android.os.Bundle bundle) {
            synchronized (this.mLock) {
                if (this.mHandler != null) {
                    android.os.Message messageObtainMessage = this.mHandler.obtainMessage(i_renamed, i2, i3, obj);
                    android.os.Bundle bundle2 = new android.os.Bundle();
                    bundle2.putString(android.support.v4.media.session.MediaSessionCompat.DATA_CALLING_PACKAGE, "android.media.session.MediaController");
                    bundle2.putInt(android.support.v4.media.session.MediaSessionCompat.DATA_CALLING_PID, android.os.Binder.getCallingPid());
                    bundle2.putInt(android.support.v4.media.session.MediaSessionCompat.DATA_CALLING_UID, android.os.Binder.getCallingUid());
                    if (bundle != null) {
                        bundle2.putBundle(android.support.v4.media.session.MediaSessionCompat.DATA_EXTRAS, bundle);
                    }
                    messageObtainMessage.setData(bundle2);
                    messageObtainMessage.sendToTarget();
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int i_renamed) {
            synchronized (this.mLock) {
                this.mFlags = i_renamed;
            }
            update();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int i_renamed) {
            androidx.media.i_renamed iVar = this.mVolumeProvider;
            if (iVar != null) {
                iVar.a_renamed((androidx.media.i_renamed.a_renamed) null);
            }
            this.mLocalStream = i_renamed;
            this.mVolumeType = 1;
            int i2 = this.mVolumeType;
            int i3 = this.mLocalStream;
            sendVolumeInfoChanged(new android.support.v4.media.session.ParcelableVolumeInfo(i2, i3, 2, this.mAudioManager.getStreamMaxVolume(i3), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(androidx.media.i_renamed iVar) {
            if (iVar == null) {
                throw new java.lang.IllegalArgumentException("volumeProvider may not be_renamed null");
            }
            androidx.media.i_renamed iVar2 = this.mVolumeProvider;
            if (iVar2 != null) {
                iVar2.a_renamed((androidx.media.i_renamed.a_renamed) null);
            }
            this.mVolumeType = 2;
            this.mVolumeProvider = iVar;
            sendVolumeInfoChanged(new android.support.v4.media.session.ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.b_renamed(), this.mVolumeProvider.c_renamed(), this.mVolumeProvider.a_renamed()));
            iVar.a_renamed(this.mVolumeCallback);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean z_renamed) {
            if (z_renamed == this.mIsActive) {
                return;
            }
            this.mIsActive = z_renamed;
            if (update()) {
                setMetadata(this.mMetadata);
                setPlaybackState(this.mState);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return this.mIsActive;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(java.lang.String str, android.os.Bundle bundle) {
            sendEvent(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            update();
            sendSessionDestroyed();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
            return this.mToken;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
            synchronized (this.mLock) {
                this.mState = playbackStateCompat;
            }
            sendState(playbackStateCompat);
            if (this.mIsActive) {
                if (playbackStateCompat == null) {
                    this.mRcc.setPlaybackState(0);
                    this.mRcc.setTransportControlFlags(0);
                } else {
                    setRccState(playbackStateCompat);
                    this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(playbackStateCompat.getActions()));
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public android.support.v4.media.session.PlaybackStateCompat getPlaybackState() {
            android.support.v4.media.session.PlaybackStateCompat playbackStateCompat;
            synchronized (this.mLock) {
                playbackStateCompat = this.mState;
            }
            return playbackStateCompat;
        }

        void setRccState(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) {
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new android.support.v4.media.MediaMetadataCompat.Builder(mediaMetadataCompat, android.support.v4.media.session.MediaSessionCompat.sMaxBitmapSize).build();
            }
            synchronized (this.mLock) {
                this.mMetadata = mediaMetadataCompat;
            }
            sendMetadata(mediaMetadataCompat);
            if (this.mIsActive) {
                buildRccMetadata(mediaMetadataCompat == null ? null : mediaMetadataCompat.getBundle()).apply();
            }
        }

        android.media.RemoteControlClient.MetadataEditor buildRccMetadata(android.os.Bundle bundle) throws java.lang.IllegalArgumentException {
            android.media.RemoteControlClient.MetadataEditor metadataEditorEditMetadata = this.mRcc.editMetadata(true);
            if (bundle == null) {
                return metadataEditorEditMetadata;
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ART)) {
                android.graphics.Bitmap bitmapCopy = (android.graphics.Bitmap) bundle.getParcelable(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ART);
                if (bitmapCopy != null) {
                    bitmapCopy = bitmapCopy.copy(bitmapCopy.getConfig(), false);
                }
                metadataEditorEditMetadata.putBitmap(100, bitmapCopy);
            } else if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM_ART)) {
                android.graphics.Bitmap bitmapCopy2 = (android.graphics.Bitmap) bundle.getParcelable(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
                if (bitmapCopy2 != null) {
                    bitmapCopy2 = bitmapCopy2.copy(bitmapCopy2.getConfig(), false);
                }
                metadataEditorEditMetadata.putBitmap(100, bitmapCopy2);
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM)) {
                metadataEditorEditMetadata.putString(1, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST)) {
                metadataEditorEditMetadata.putString(13, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ARTIST)) {
                metadataEditorEditMetadata.putString(2, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ARTIST));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_AUTHOR)) {
                metadataEditorEditMetadata.putString(3, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_AUTHOR));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_COMPILATION)) {
                metadataEditorEditMetadata.putString(15, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_COMPILATION));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_COMPOSER)) {
                metadataEditorEditMetadata.putString(4, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_COMPOSER));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DATE)) {
                metadataEditorEditMetadata.putString(5, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DATE));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DISC_NUMBER)) {
                metadataEditorEditMetadata.putLong(14, bundle.getLong(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DISC_NUMBER));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DURATION)) {
                metadataEditorEditMetadata.putLong(9, bundle.getLong(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DURATION));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_GENRE)) {
                metadataEditorEditMetadata.putString(6, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_GENRE));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_TITLE)) {
                metadataEditorEditMetadata.putString(7, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_TITLE));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER)) {
                metadataEditorEditMetadata.putLong(0, bundle.getLong(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_WRITER)) {
                metadataEditorEditMetadata.putString(11, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_WRITER));
            }
            return metadataEditorEditMetadata;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(android.app.PendingIntent pendingIntent) {
            synchronized (this.mLock) {
                this.mSessionActivity = pendingIntent;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list) {
            this.mQueue = list;
            sendQueue(list);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(java.lang.CharSequence charSequence) {
            this.mQueueTitle = charSequence;
            sendQueueTitle(charSequence);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int i_renamed) {
            this.mRatingType = i_renamed;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean z_renamed) {
            if (this.mCaptioningEnabled != z_renamed) {
                this.mCaptioningEnabled = z_renamed;
                sendCaptioningEnabled(z_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int i_renamed) {
            if (this.mRepeatMode != i_renamed) {
                this.mRepeatMode = i_renamed;
                sendRepeatMode(i_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int i_renamed) {
            if (this.mShuffleMode != i_renamed) {
                this.mShuffleMode = i_renamed;
                sendShuffleMode(i_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(android.os.Bundle bundle) {
            this.mExtras = bundle;
            sendExtras(bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public androidx.media.e_renamed.a_renamed getCurrentControllerInfo() {
            androidx.media.e_renamed.a_renamed aVar;
            synchronized (this.mLock) {
                aVar = this.mRemoteUserInfo;
            }
            return aVar;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(androidx.media.e_renamed.a_renamed aVar) {
            synchronized (this.mLock) {
                this.mRemoteUserInfo = aVar;
            }
        }

        boolean update() {
            if (this.mIsActive) {
                if (!this.mIsMbrRegistered && (this.mFlags & 1) != 0) {
                    registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    this.mIsMbrRegistered = true;
                } else if (this.mIsMbrRegistered && (this.mFlags & 1) == 0) {
                    unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    this.mIsMbrRegistered = false;
                }
                if (!this.mIsRccRegistered && (this.mFlags & 2) != 0) {
                    this.mAudioManager.registerRemoteControlClient(this.mRcc);
                    this.mIsRccRegistered = true;
                    return true;
                }
                if (this.mIsRccRegistered && (this.mFlags & 2) == 0) {
                    this.mRcc.setPlaybackState(0);
                    this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
                    this.mIsRccRegistered = false;
                }
            } else {
                if (this.mIsMbrRegistered) {
                    unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    this.mIsMbrRegistered = false;
                }
                if (this.mIsRccRegistered) {
                    this.mRcc.setPlaybackState(0);
                    this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
                    this.mIsRccRegistered = false;
                }
            }
            return false;
        }

        void registerMediaButtonEventReceiver(android.app.PendingIntent pendingIntent, android.content.ComponentName componentName) {
            this.mAudioManager.registerMediaButtonEventReceiver(componentName);
        }

        void unregisterMediaButtonEventReceiver(android.app.PendingIntent pendingIntent, android.content.ComponentName componentName) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(componentName);
        }

        void adjustVolume(int i_renamed, int i2) {
            if (this.mVolumeType == 2) {
                androidx.media.i_renamed iVar = this.mVolumeProvider;
                if (iVar != null) {
                    iVar.b_renamed(i_renamed);
                    return;
                }
                return;
            }
            this.mAudioManager.adjustStreamVolume(this.mLocalStream, i_renamed, i2);
        }

        void setVolumeTo(int i_renamed, int i2) {
            if (this.mVolumeType == 2) {
                androidx.media.i_renamed iVar = this.mVolumeProvider;
                if (iVar != null) {
                    iVar.a_renamed(i_renamed);
                    return;
                }
                return;
            }
            this.mAudioManager.setStreamVolume(this.mLocalStream, i_renamed, i2);
        }

        void sendVolumeInfoChanged(android.support.v4.media.session.ParcelableVolumeInfo parcelableVolumeInfo) {
            for (int iBeginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onVolumeInfoChanged(parcelableVolumeInfo);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendSessionDestroyed() {
            for (int iBeginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onSessionDestroyed();
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
            this.mControllerCallbacks.kill();
        }

        private void sendEvent(java.lang.String str, android.os.Bundle bundle) {
            for (int iBeginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onEvent(str, bundle);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendState(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
            for (int iBeginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onPlaybackStateChanged(playbackStateCompat);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) {
            for (int iBeginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onMetadataChanged(mediaMetadataCompat);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list) {
            for (int iBeginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onQueueChanged(list);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(java.lang.CharSequence charSequence) {
            for (int iBeginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onQueueTitleChanged(charSequence);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendCaptioningEnabled(boolean z_renamed) {
            for (int iBeginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onCaptioningEnabledChanged(z_renamed);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendRepeatMode(int i_renamed) {
            for (int iBeginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onRepeatModeChanged(i_renamed);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendShuffleMode(int i_renamed) {
            for (int iBeginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onShuffleModeChanged(i_renamed);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendExtras(android.os.Bundle bundle) {
            for (int iBeginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onExtrasChanged(bundle);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        class MediaSessionStub extends android.support.v4.media.session.IMediaSession.Stub {
            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z_renamed) throws android.os.RemoteException {
            }

            MediaSessionStub() {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) {
                postToHandler(1, new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.Command(str, bundle, resultReceiverWrapper.mResultReceiver));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(android.view.KeyEvent keyEvent) {
                boolean z_renamed = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mFlags & 1) != 0;
                if (z_renamed) {
                    postToHandler(21, keyEvent);
                }
                return z_renamed;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(android.support.v4.media.session.IMediaControllerCallback iMediaControllerCallback) {
                if (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mDestroyed) {
                    try {
                        iMediaControllerCallback.onSessionDestroyed();
                    } catch (java.lang.Exception unused) {
                    }
                } else {
                    android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mControllerCallbacks.register(iMediaControllerCallback, new androidx.media.e_renamed.a_renamed("android.media.session.MediaController", getCallingPid(), getCallingUid()));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(android.support.v4.media.session.IMediaControllerCallback iMediaControllerCallback) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mControllerCallbacks.unregister(iMediaControllerCallback);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.lang.String getPackageName() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mPackageName;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.lang.String getTag() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mTag;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.app.PendingIntent getLaunchPendingIntent() {
                android.app.PendingIntent pendingIntent;
                synchronized (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mLock) {
                    pendingIntent = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mSessionActivity;
                }
                return pendingIntent;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                long j_renamed;
                synchronized (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mLock) {
                    j_renamed = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mFlags;
                }
                return j_renamed;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.support.v4.media.session.ParcelableVolumeInfo getVolumeAttributes() {
                int i_renamed;
                int i2;
                int streamVolume;
                int i3;
                int i4;
                synchronized (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mLock) {
                    i_renamed = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mVolumeType;
                    i2 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mLocalStream;
                    androidx.media.i_renamed iVar = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mVolumeProvider;
                    if (i_renamed == 2) {
                        int iB = iVar.b_renamed();
                        int iC = iVar.c_renamed();
                        i4 = iB;
                        streamVolume = iVar.a_renamed();
                        i3 = iC;
                    } else {
                        int streamMaxVolume = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mAudioManager.getStreamMaxVolume(i2);
                        streamVolume = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mAudioManager.getStreamVolume(i2);
                        i3 = streamMaxVolume;
                        i4 = 2;
                    }
                }
                return new android.support.v4.media.session.ParcelableVolumeInfo(i_renamed, i2, i4, i3, streamVolume);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int i_renamed, int i2, java.lang.String str) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.adjustVolume(i_renamed, i2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int i_renamed, int i2, java.lang.String str) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.setVolumeTo(i_renamed, i2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws android.os.RemoteException {
                postToHandler(3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(4, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(5, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(android.net.Uri uri, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(6, uri, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws android.os.RemoteException {
                postToHandler(7);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(8, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(9, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(android.net.Uri uri, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(10, uri, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long j_renamed) {
                postToHandler(11, java.lang.Long.valueOf(j_renamed));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws android.os.RemoteException {
                postToHandler(12);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws android.os.RemoteException {
                postToHandler(13);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws android.os.RemoteException {
                postToHandler(14);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws android.os.RemoteException {
                postToHandler(15);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws android.os.RemoteException {
                postToHandler(16);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws android.os.RemoteException {
                postToHandler(17);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long j_renamed) throws android.os.RemoteException {
                postToHandler(18, java.lang.Long.valueOf(j_renamed));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(android.support.v4.media.RatingCompat ratingCompat) throws android.os.RemoteException {
                postToHandler(19, ratingCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(android.support.v4.media.RatingCompat ratingCompat, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(31, ratingCompat, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z_renamed) throws android.os.RemoteException {
                postToHandler(29, java.lang.Boolean.valueOf(z_renamed));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int i_renamed) throws android.os.RemoteException {
                postToHandler(23, i_renamed);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int i_renamed) throws android.os.RemoteException {
                postToHandler(30, i_renamed);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(20, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.support.v4.media.MediaMetadataCompat getMetadata() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mMetadata;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.support.v4.media.session.PlaybackStateCompat getPlaybackState() {
                android.support.v4.media.session.PlaybackStateCompat playbackStateCompat;
                android.support.v4.media.MediaMetadataCompat mediaMetadataCompat;
                synchronized (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mLock) {
                    playbackStateCompat = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mState;
                    mediaMetadataCompat = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mMetadata;
                }
                return android.support.v4.media.session.MediaSessionCompat.getStateWithUpdatedPosition(playbackStateCompat, mediaMetadataCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> getQueue() {
                java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list;
                synchronized (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mLock) {
                    list = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mQueue;
                }
                return list;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(25, mediaDescriptionCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, int i_renamed) {
                postToHandler(26, mediaDescriptionCompat, i_renamed);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(27, mediaDescriptionCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int i_renamed) {
                postToHandler(28, i_renamed);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.lang.CharSequence getQueueTitle() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mQueueTitle;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.os.Bundle getExtras() {
                android.os.Bundle bundle;
                synchronized (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mLock) {
                    bundle = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mExtras;
                }
                return bundle;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mRatingType;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mCaptioningEnabled;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mRepeatMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mShuffleMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                return (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mFlags & 2) != 0;
            }

            void postToHandler(int i_renamed) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.postToHandler(i_renamed, 0, 0, null, null);
            }

            void postToHandler(int i_renamed, int i2) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.postToHandler(i_renamed, i2, 0, null, null);
            }

            void postToHandler(int i_renamed, java.lang.Object obj) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.postToHandler(i_renamed, 0, 0, obj, null);
            }

            void postToHandler(int i_renamed, java.lang.Object obj, int i2) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.postToHandler(i_renamed, i2, 0, obj, null);
            }

            void postToHandler(int i_renamed, java.lang.Object obj, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.postToHandler(i_renamed, 0, 0, obj, bundle);
            }
        }

        private static final class Command {
            public final java.lang.String command;
            public final android.os.Bundle extras;
            public final android.os.ResultReceiver stub;

            public Command(java.lang.String str, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver) {
                this.command = str;
                this.extras = bundle;
                this.stub = resultReceiver;
            }
        }

        class MessageHandler extends android.os.Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 127;
            private static final int KEYCODE_MEDIA_PLAY = 126;
            private static final int MSG_ADD_QUEUE_ITEM = 25;
            private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            private static final int MSG_ADJUST_VOLUME = 2;
            private static final int MSG_COMMAND = 1;
            private static final int MSG_CUSTOM_ACTION = 20;
            private static final int MSG_FAST_FORWARD = 16;
            private static final int MSG_MEDIA_BUTTON = 21;
            private static final int MSG_NEXT = 14;
            private static final int MSG_PAUSE = 12;
            private static final int MSG_PLAY = 7;
            private static final int MSG_PLAY_MEDIA_ID = 8;
            private static final int MSG_PLAY_SEARCH = 9;
            private static final int MSG_PLAY_URI = 10;
            private static final int MSG_PREPARE = 3;
            private static final int MSG_PREPARE_MEDIA_ID = 4;
            private static final int MSG_PREPARE_SEARCH = 5;
            private static final int MSG_PREPARE_URI = 6;
            private static final int MSG_PREVIOUS = 15;
            private static final int MSG_RATE = 19;
            private static final int MSG_RATE_EXTRA = 31;
            private static final int MSG_REMOVE_QUEUE_ITEM = 27;
            private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            private static final int MSG_REWIND = 17;
            private static final int MSG_SEEK_TO = 18;
            private static final int MSG_SET_CAPTIONING_ENABLED = 29;
            private static final int MSG_SET_REPEAT_MODE = 23;
            private static final int MSG_SET_SHUFFLE_MODE = 30;
            private static final int MSG_SET_VOLUME = 22;
            private static final int MSG_SKIP_TO_ITEM = 11;
            private static final int MSG_STOP = 13;

            public MessageHandler(android.os.Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                android.support.v4.media.session.MediaSessionCompat.Callback callback = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mCallback;
                if (callback == null) {
                    return;
                }
                android.os.Bundle data = message.getData();
                android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(data);
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.setCurrentControllerInfo(new androidx.media.e_renamed.a_renamed(data.getString(android.support.v4.media.session.MediaSessionCompat.DATA_CALLING_PACKAGE), data.getInt(android.support.v4.media.session.MediaSessionCompat.DATA_CALLING_PID), data.getInt(android.support.v4.media.session.MediaSessionCompat.DATA_CALLING_UID)));
                android.os.Bundle bundle = data.getBundle(android.support.v4.media.session.MediaSessionCompat.DATA_EXTRAS);
                android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
                try {
                    switch (message.what) {
                        case 1:
                            android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.Command command = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.Command) message.obj;
                            callback.onCommand(command.command, command.extras, command.stub);
                            break;
                        case 2:
                            android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.adjustVolume(message.arg1, 0);
                            break;
                        case 3:
                            callback.onPrepare();
                            break;
                        case 4:
                            callback.onPrepareFromMediaId((java.lang.String) message.obj, bundle);
                            break;
                        case 5:
                            callback.onPrepareFromSearch((java.lang.String) message.obj, bundle);
                            break;
                        case 6:
                            callback.onPrepareFromUri((android.net.Uri) message.obj, bundle);
                            break;
                        case 7:
                            callback.onPlay();
                            break;
                        case 8:
                            callback.onPlayFromMediaId((java.lang.String) message.obj, bundle);
                            break;
                        case 9:
                            callback.onPlayFromSearch((java.lang.String) message.obj, bundle);
                            break;
                        case 10:
                            callback.onPlayFromUri((android.net.Uri) message.obj, bundle);
                            break;
                        case 11:
                            callback.onSkipToQueueItem(((java.lang.Long) message.obj).longValue());
                            break;
                        case 12:
                            callback.onPause();
                            break;
                        case 13:
                            callback.onStop();
                            break;
                        case 14:
                            callback.onSkipToNext();
                            break;
                        case 15:
                            callback.onSkipToPrevious();
                            break;
                        case 16:
                            callback.onFastForward();
                            break;
                        case 17:
                            callback.onRewind();
                            break;
                        case 18:
                            callback.onSeekTo(((java.lang.Long) message.obj).longValue());
                            break;
                        case 19:
                            callback.onSetRating((android.support.v4.media.RatingCompat) message.obj);
                            break;
                        case 20:
                            callback.onCustomAction((java.lang.String) message.obj, bundle);
                            break;
                        case 21:
                            android.view.KeyEvent keyEvent = (android.view.KeyEvent) message.obj;
                            android.content.Intent intent = new android.content.Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!callback.onMediaButtonEvent(intent)) {
                                onMediaButtonEvent(keyEvent, callback);
                                break;
                            }
                            break;
                        case 22:
                            android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.setVolumeTo(message.arg1, 0);
                            break;
                        case 23:
                            callback.onSetRepeatMode(message.arg1);
                            break;
                        case 25:
                            callback.onAddQueueItem((android.support.v4.media.MediaDescriptionCompat) message.obj);
                            break;
                        case 26:
                            callback.onAddQueueItem((android.support.v4.media.MediaDescriptionCompat) message.obj, message.arg1);
                            break;
                        case 27:
                            callback.onRemoveQueueItem((android.support.v4.media.MediaDescriptionCompat) message.obj);
                            break;
                        case 28:
                            if (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mQueue != null) {
                                android.support.v4.media.session.MediaSessionCompat.QueueItem queueItem = (message.arg1 < 0 || message.arg1 >= android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mQueue.size()) ? null : android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mQueue.get(message.arg1);
                                if (queueItem != null) {
                                    callback.onRemoveQueueItem(queueItem.getDescription());
                                    break;
                                }
                            }
                            break;
                        case 29:
                            callback.onSetCaptioningEnabled(((java.lang.Boolean) message.obj).booleanValue());
                            break;
                        case 30:
                            callback.onSetShuffleMode(message.arg1);
                            break;
                        case 31:
                            callback.onSetRating((android.support.v4.media.RatingCompat) message.obj, bundle);
                            break;
                    }
                } finally {
                    android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.setCurrentControllerInfo(null);
                }
            }

            private void onMediaButtonEvent(android.view.KeyEvent keyEvent, android.support.v4.media.session.MediaSessionCompat.Callback callback) {
                if (keyEvent == null || keyEvent.getAction() != 0) {
                    return;
                }
                long actions = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mState == null ? 0L : android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mState.getActions();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 79) {
                    if (keyCode == 126) {
                        if ((4 & actions) != 0) {
                            callback.onPlay();
                            return;
                        }
                        return;
                    }
                    if (keyCode == 127) {
                        if ((2 & actions) != 0) {
                            callback.onPause();
                            return;
                        }
                        return;
                    }
                    switch (keyCode) {
                        case 86:
                            if ((1 & actions) != 0) {
                                callback.onStop();
                                break;
                            }
                            break;
                        case 87:
                            if ((32 & actions) != 0) {
                                callback.onSkipToNext();
                                break;
                            }
                            break;
                        case 88:
                            if ((16 & actions) != 0) {
                                callback.onSkipToPrevious();
                                break;
                            }
                            break;
                        case 89:
                            if ((8 & actions) != 0) {
                                callback.onRewind();
                                break;
                            }
                            break;
                        case 90:
                            if ((64 & actions) != 0) {
                                callback.onFastForward();
                                break;
                            }
                            break;
                    }
                }
                android.util.Log.w_renamed(android.support.v4.media.session.MediaSessionCompat.TAG, "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
            }
        }
    }

    static class MediaSessionImplApi18 extends android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        MediaSessionImplApi18(android.content.Context context, java.lang.String str, android.content.ComponentName componentName, android.app.PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback callback, android.os.Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setPlaybackPositionUpdateListener(null);
            } else {
                this.mRcc.setPlaybackPositionUpdateListener(new android.media.RemoteControlClient.OnPlaybackPositionUpdateListener() { // from class: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18.1
                    @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
                    public void onPlaybackPositionUpdate(long j_renamed) {
                        android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18.this.postToHandler(18, -1, -1, java.lang.Long.valueOf(j_renamed), null);
                    }
                });
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        void setRccState(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
            long position = playbackStateCompat.getPosition();
            float playbackSpeed = playbackStateCompat.getPlaybackSpeed();
            long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            if (playbackStateCompat.getState() == 3) {
                long j_renamed = 0;
                if (position > 0) {
                    if (lastPositionUpdateTime > 0) {
                        j_renamed = jElapsedRealtime - lastPositionUpdateTime;
                        if (playbackSpeed > 0.0f && playbackSpeed != 1.0f) {
                            j_renamed = (long) (j_renamed * playbackSpeed);
                        }
                    }
                    position += j_renamed;
                }
            }
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()), position, playbackSpeed);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        int getRccTransportControlFlagsFromActions(long j_renamed) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j_renamed);
            return (j_renamed & 256) != 0 ? rccTransportControlFlagsFromActions | 256 : rccTransportControlFlagsFromActions;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        void registerMediaButtonEventReceiver(android.app.PendingIntent pendingIntent, android.content.ComponentName componentName) {
            if (sIsMbrPendingIntentSupported) {
                try {
                    this.mAudioManager.registerMediaButtonEventReceiver(pendingIntent);
                } catch (java.lang.NullPointerException unused) {
                    android.util.Log.w_renamed(android.support.v4.media.session.MediaSessionCompat.TAG, "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                    sIsMbrPendingIntentSupported = false;
                }
            }
            if (sIsMbrPendingIntentSupported) {
                return;
            }
            super.registerMediaButtonEventReceiver(pendingIntent, componentName);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        void unregisterMediaButtonEventReceiver(android.app.PendingIntent pendingIntent, android.content.ComponentName componentName) {
            if (sIsMbrPendingIntentSupported) {
                this.mAudioManager.unregisterMediaButtonEventReceiver(pendingIntent);
            } else {
                super.unregisterMediaButtonEventReceiver(pendingIntent, componentName);
            }
        }
    }

    static class MediaSessionImplApi19 extends android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18 {
        MediaSessionImplApi19(android.content.Context context, java.lang.String str, android.content.ComponentName componentName, android.app.PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback callback, android.os.Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setMetadataUpdateListener(null);
            } else {
                this.mRcc.setMetadataUpdateListener(new android.media.RemoteControlClient.OnMetadataUpdateListener() { // from class: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi19.1
                    @Override // android.media.RemoteControlClient.OnMetadataUpdateListener
                    public void onMetadataUpdate(int i_renamed, java.lang.Object obj) {
                        if (i_renamed == 268435457 && (obj instanceof android.media.Rating)) {
                            android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi19.this.postToHandler(19, -1, -1, android.support.v4.media.RatingCompat.fromRating(obj), null);
                        }
                    }
                });
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        int getRccTransportControlFlagsFromActions(long j_renamed) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j_renamed);
            return (j_renamed & 128) != 0 ? rccTransportControlFlagsFromActions | 512 : rccTransportControlFlagsFromActions;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        android.media.RemoteControlClient.MetadataEditor buildRccMetadata(android.os.Bundle bundle) throws java.lang.IllegalArgumentException {
            android.media.RemoteControlClient.MetadataEditor metadataEditorBuildRccMetadata = super.buildRccMetadata(bundle);
            if (((this.mState == null ? 0L : this.mState.getActions()) & 128) != 0) {
                metadataEditorBuildRccMetadata.addEditableKey(268435457);
            }
            if (bundle == null) {
                return metadataEditorBuildRccMetadata;
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_YEAR)) {
                metadataEditorBuildRccMetadata.putLong(8, bundle.getLong(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_YEAR));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_RATING)) {
                metadataEditorBuildRccMetadata.putObject(101, (java.lang.Object) bundle.getParcelable(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_RATING));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_USER_RATING)) {
                metadataEditorBuildRccMetadata.putObject(268435457, (java.lang.Object) bundle.getParcelable(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_USER_RATING));
            }
            return metadataEditorBuildRccMetadata;
        }
    }

    static class MediaSessionImplApi21 implements android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl {
        boolean mCaptioningEnabled;
        boolean mDestroyed = false;
        final android.os.RemoteCallbackList<android.support.v4.media.session.IMediaControllerCallback> mExtraControllerCallbacks = new android.os.RemoteCallbackList<>();
        android.support.v4.media.MediaMetadataCompat mMetadata;
        android.support.v4.media.session.PlaybackStateCompat mPlaybackState;
        java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> mQueue;
        int mRatingType;
        int mRepeatMode;
        final java.lang.Object mSessionObj;
        int mShuffleMode;
        final android.support.v4.media.session.MediaSessionCompat.Token mToken;

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public androidx.media.e_renamed.a_renamed getCurrentControllerInfo() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public java.lang.Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(androidx.media.e_renamed.a_renamed aVar) {
        }

        MediaSessionImplApi21(android.content.Context context, java.lang.String str, android.os.Bundle bundle) {
            this.mSessionObj = android.support.v4.media.session.MediaSessionCompatApi21.createSession(context, str);
            this.mToken = new android.support.v4.media.session.MediaSessionCompat.Token(android.support.v4.media.session.MediaSessionCompatApi21.getSessionToken(this.mSessionObj), new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.ExtraSession(), bundle);
        }

        MediaSessionImplApi21(java.lang.Object obj) {
            this.mSessionObj = android.support.v4.media.session.MediaSessionCompatApi21.verifySession(obj);
            this.mToken = new android.support.v4.media.session.MediaSessionCompat.Token(android.support.v4.media.session.MediaSessionCompatApi21.getSessionToken(this.mSessionObj), new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.ExtraSession());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback callback, android.os.Handler handler) {
            android.support.v4.media.session.MediaSessionCompatApi21.setCallback(this.mSessionObj, callback == null ? null : callback.mCallbackObj, handler);
            if (callback != null) {
                callback.setSessionImpl(this, handler);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int i_renamed) {
            android.support.v4.media.session.MediaSessionCompatApi21.setFlags(this.mSessionObj, i_renamed);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int i_renamed) {
            android.support.v4.media.session.MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, i_renamed);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(androidx.media.i_renamed iVar) {
            android.support.v4.media.session.MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, iVar.d_renamed());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean z_renamed) {
            android.support.v4.media.session.MediaSessionCompatApi21.setActive(this.mSessionObj, z_renamed);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return android.support.v4.media.session.MediaSessionCompatApi21.isActive(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(java.lang.String str, android.os.Bundle bundle) {
            if (android.os.Build.VERSION.SDK_INT < 23) {
                for (int iBeginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((android.support.v4.media.session.IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onEvent(str, bundle);
                    } catch (android.os.RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
            android.support.v4.media.session.MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mDestroyed = true;
            android.support.v4.media.session.MediaSessionCompatApi21.release(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
            return this.mToken;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
            this.mPlaybackState = playbackStateCompat;
            for (int iBeginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onPlaybackStateChanged(playbackStateCompat);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mExtraControllerCallbacks.finishBroadcast();
            android.support.v4.media.session.MediaSessionCompatApi21.setPlaybackState(this.mSessionObj, playbackStateCompat == null ? null : playbackStateCompat.getPlaybackState());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public android.support.v4.media.session.PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) {
            this.mMetadata = mediaMetadataCompat;
            android.support.v4.media.session.MediaSessionCompatApi21.setMetadata(this.mSessionObj, mediaMetadataCompat == null ? null : mediaMetadataCompat.getMediaMetadata());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(android.app.PendingIntent pendingIntent) {
            android.support.v4.media.session.MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(android.app.PendingIntent pendingIntent) {
            android.support.v4.media.session.MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list) {
            java.util.ArrayList arrayList;
            this.mQueue = list;
            if (list != null) {
                arrayList = new java.util.ArrayList();
                java.util.Iterator<android.support.v4.media.session.MediaSessionCompat.QueueItem> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getQueueItem());
                }
            } else {
                arrayList = null;
            }
            android.support.v4.media.session.MediaSessionCompatApi21.setQueue(this.mSessionObj, arrayList);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(java.lang.CharSequence charSequence) {
            android.support.v4.media.session.MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, charSequence);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int i_renamed) {
            if (android.os.Build.VERSION.SDK_INT < 22) {
                this.mRatingType = i_renamed;
            } else {
                android.support.v4.media.session.MediaSessionCompatApi22.setRatingType(this.mSessionObj, i_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean z_renamed) {
            if (this.mCaptioningEnabled != z_renamed) {
                this.mCaptioningEnabled = z_renamed;
                for (int iBeginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((android.support.v4.media.session.IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onCaptioningEnabledChanged(z_renamed);
                    } catch (android.os.RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int i_renamed) {
            if (this.mRepeatMode != i_renamed) {
                this.mRepeatMode = i_renamed;
                for (int iBeginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((android.support.v4.media.session.IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onRepeatModeChanged(i_renamed);
                    } catch (android.os.RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int i_renamed) {
            if (this.mShuffleMode != i_renamed) {
                this.mShuffleMode = i_renamed;
                for (int iBeginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((android.support.v4.media.session.IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(iBeginBroadcast)).onShuffleModeChanged(i_renamed);
                    } catch (android.os.RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompatApi21.setExtras(this.mSessionObj, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public java.lang.Object getMediaSession() {
            return this.mSessionObj;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public java.lang.String getCallingPackage() {
            if (android.os.Build.VERSION.SDK_INT < 24) {
                return null;
            }
            return android.support.v4.media.session.MediaSessionCompatApi24.getCallingPackage(this.mSessionObj);
        }

        class ExtraSession extends android.support.v4.media.session.IMediaSession.Stub {
            @Override // android.support.v4.media.session.IMediaSession
            public java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> getQueue() {
                return null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z_renamed) throws android.os.RemoteException {
            }

            ExtraSession() {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(android.view.KeyEvent keyEvent) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(android.support.v4.media.session.IMediaControllerCallback iMediaControllerCallback) {
                if (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mDestroyed) {
                    return;
                }
                java.lang.String callingPackage = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.getCallingPackage();
                if (callingPackage == null) {
                    callingPackage = "android.media.session.MediaController";
                }
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mExtraControllerCallbacks.register(iMediaControllerCallback, new androidx.media.e_renamed.a_renamed(callingPackage, getCallingPid(), getCallingUid()));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(android.support.v4.media.session.IMediaControllerCallback iMediaControllerCallback) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mExtraControllerCallbacks.unregister(iMediaControllerCallback);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.lang.String getPackageName() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.lang.String getTag() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.app.PendingIntent getLaunchPendingIntent() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.support.v4.media.session.ParcelableVolumeInfo getVolumeAttributes() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int i_renamed, int i2, java.lang.String str) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int i_renamed, int i2, java.lang.String str) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(android.net.Uri uri, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(android.net.Uri uri, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long j_renamed) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long j_renamed) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(android.support.v4.media.RatingCompat ratingCompat) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(android.support.v4.media.RatingCompat ratingCompat, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z_renamed) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int i_renamed) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int i_renamed) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.support.v4.media.MediaMetadataCompat getMetadata() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.support.v4.media.session.PlaybackStateCompat getPlaybackState() {
                return android.support.v4.media.session.MediaSessionCompat.getStateWithUpdatedPosition(android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mPlaybackState, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mMetadata);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, int i_renamed) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int i_renamed) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.lang.CharSequence getQueueTitle() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.os.Bundle getExtras() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mRatingType;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mCaptioningEnabled;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mRepeatMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mShuffleMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                throw new java.lang.AssertionError();
            }
        }
    }

    static class MediaSessionImplApi28 extends android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21 {
        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(androidx.media.e_renamed.a_renamed aVar) {
        }

        MediaSessionImplApi28(android.content.Context context, java.lang.String str, android.os.Bundle bundle) {
            super(context, str, bundle);
        }

        MediaSessionImplApi28(java.lang.Object obj) {
            super(obj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public final androidx.media.e_renamed.a_renamed getCurrentControllerInfo() {
            return new androidx.media.e_renamed.a_renamed(((android.media.session.MediaSession) this.mSessionObj).getCurrentControllerInfo());
        }
    }
}

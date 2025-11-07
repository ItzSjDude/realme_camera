package android.support.v4.media.session;

/* loaded from: classes.dex */
public final class MediaControllerCompat {
    public static final java.lang.String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    public static final java.lang.String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    public static final java.lang.String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    public static final java.lang.String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    public static final java.lang.String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    public static final java.lang.String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    public static final java.lang.String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    static final java.lang.String TAG = "MediaControllerCompat";
    private final android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl mImpl;
    private final java.util.HashSet<android.support.v4.media.session.MediaControllerCompat.Callback> mRegisteredCallbacks = new java.util.HashSet<>();
    private final android.support.v4.media.session.MediaSessionCompat.Token mToken;

    interface MediaControllerImpl {
        void addQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat);

        void addQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, int i_renamed);

        void adjustVolume(int i_renamed, int i2);

        boolean dispatchMediaButtonEvent(android.view.KeyEvent keyEvent);

        android.os.Bundle getExtras();

        long getFlags();

        java.lang.Object getMediaController();

        android.support.v4.media.MediaMetadataCompat getMetadata();

        java.lang.String getPackageName();

        android.support.v4.media.session.MediaControllerCompat.PlaybackInfo getPlaybackInfo();

        android.support.v4.media.session.PlaybackStateCompat getPlaybackState();

        java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> getQueue();

        java.lang.CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        android.app.PendingIntent getSessionActivity();

        int getShuffleMode();

        android.support.v4.media.session.MediaControllerCompat.TransportControls getTransportControls();

        boolean isCaptioningEnabled();

        boolean isSessionReady();

        void registerCallback(android.support.v4.media.session.MediaControllerCompat.Callback callback, android.os.Handler handler);

        void removeQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat);

        void sendCommand(java.lang.String str, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver);

        void setVolumeTo(int i_renamed, int i2);

        void unregisterCallback(android.support.v4.media.session.MediaControllerCompat.Callback callback);
    }

    private static class MediaControllerExtraData extends androidx.core.app.e_renamed.a_renamed {
        private final android.support.v4.media.session.MediaControllerCompat mMediaController;

        MediaControllerExtraData(android.support.v4.media.session.MediaControllerCompat mediaControllerCompat) {
            this.mMediaController = mediaControllerCompat;
        }

        android.support.v4.media.session.MediaControllerCompat getMediaController() {
            return this.mMediaController;
        }
    }

    public static void setMediaController(android.app.Activity activity, android.support.v4.media.session.MediaControllerCompat mediaControllerCompat) {
        if (activity instanceof androidx.core.app.e_renamed) {
            ((androidx.core.app.e_renamed) activity).a_renamed(new android.support.v4.media.session.MediaControllerCompat.MediaControllerExtraData(mediaControllerCompat));
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            android.support.v4.media.session.MediaControllerCompatApi21.setMediaController(activity, mediaControllerCompat != null ? android.support.v4.media.session.MediaControllerCompatApi21.fromToken(activity, mediaControllerCompat.getSessionToken().getToken()) : null);
        }
    }

    public static android.support.v4.media.session.MediaControllerCompat getMediaController(android.app.Activity activity) {
        java.lang.Object mediaController;
        if (activity instanceof androidx.core.app.e_renamed) {
            android.support.v4.media.session.MediaControllerCompat.MediaControllerExtraData mediaControllerExtraData = (android.support.v4.media.session.MediaControllerCompat.MediaControllerExtraData) ((androidx.core.app.e_renamed) activity).a_renamed(android.support.v4.media.session.MediaControllerCompat.MediaControllerExtraData.class);
            if (mediaControllerExtraData != null) {
                return mediaControllerExtraData.getMediaController();
            }
            return null;
        }
        if (android.os.Build.VERSION.SDK_INT < 21 || (mediaController = android.support.v4.media.session.MediaControllerCompatApi21.getMediaController(activity)) == null) {
            return null;
        }
        try {
            return new android.support.v4.media.session.MediaControllerCompat(activity, android.support.v4.media.session.MediaSessionCompat.Token.fromToken(android.support.v4.media.session.MediaControllerCompatApi21.getSessionToken(mediaController)));
        } catch (android.os.RemoteException e_renamed) {
            android.util.Log.e_renamed(TAG, "Dead object in_renamed getMediaController.", e_renamed);
            return null;
        }
    }

    static void validateCustomAction(java.lang.String str, android.os.Bundle bundle) {
        if (str == null) {
            return;
        }
        char c2 = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != -1348483723) {
            if (iHashCode == 503011406 && str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_UNFOLLOW)) {
                c2 = 1;
            }
        } else if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_FOLLOW)) {
            c2 = 0;
        }
        if (c2 == 0 || c2 == 1) {
            if (bundle == null || !bundle.containsKey(android.support.v4.media.session.MediaSessionCompat.ARGUMENT_MEDIA_ATTRIBUTE)) {
                throw new java.lang.IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is_renamed required for this action " + str + ".");
            }
        }
    }

    public MediaControllerCompat(android.content.Context context, android.support.v4.media.session.MediaSessionCompat mediaSessionCompat) {
        android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl mediaControllerImplApi21;
        if (mediaSessionCompat == null) {
            throw new java.lang.IllegalArgumentException("session must not be_renamed null");
        }
        this.mToken = mediaSessionCompat.getSessionToken();
        android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl mediaControllerImplBase = null;
        try {
        } catch (android.os.RemoteException e_renamed) {
            android.util.Log.w_renamed(TAG, "Failed to create MediaControllerImpl.", e_renamed);
        }
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            mediaControllerImplApi21 = new android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi24(context, this.mToken);
        } else if (android.os.Build.VERSION.SDK_INT >= 23) {
            mediaControllerImplApi21 = new android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi23(context, this.mToken);
        } else if (android.os.Build.VERSION.SDK_INT >= 21) {
            mediaControllerImplApi21 = new android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21(context, this.mToken);
        } else {
            mediaControllerImplBase = new android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase(this.mToken);
            this.mImpl = mediaControllerImplBase;
        }
        mediaControllerImplBase = mediaControllerImplApi21;
        this.mImpl = mediaControllerImplBase;
    }

    public MediaControllerCompat(android.content.Context context, android.support.v4.media.session.MediaSessionCompat.Token token) throws android.os.RemoteException {
        if (token == null) {
            throw new java.lang.IllegalArgumentException("sessionToken must not be_renamed null");
        }
        this.mToken = token;
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            this.mImpl = new android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi24(context, token);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.mImpl = new android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi23(context, token);
        } else if (android.os.Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21(context, token);
        } else {
            this.mImpl = new android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase(token);
        }
    }

    public android.support.v4.media.session.MediaControllerCompat.TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    public boolean dispatchMediaButtonEvent(android.view.KeyEvent keyEvent) {
        if (keyEvent == null) {
            throw new java.lang.IllegalArgumentException("KeyEvent may not be_renamed null");
        }
        return this.mImpl.dispatchMediaButtonEvent(keyEvent);
    }

    public android.support.v4.media.session.PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public android.support.v4.media.MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> getQueue() {
        return this.mImpl.getQueue();
    }

    public void addQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.addQueueItem(mediaDescriptionCompat);
    }

    public void addQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, int i_renamed) {
        this.mImpl.addQueueItem(mediaDescriptionCompat, i_renamed);
    }

    public void removeQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.removeQueueItem(mediaDescriptionCompat);
    }

    @java.lang.Deprecated
    public void removeQueueItemAt(int i_renamed) {
        android.support.v4.media.session.MediaSessionCompat.QueueItem queueItem;
        java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> queue = getQueue();
        if (queue == null || i_renamed < 0 || i_renamed >= queue.size() || (queueItem = queue.get(i_renamed)) == null) {
            return;
        }
        removeQueueItem(queueItem.getDescription());
    }

    public java.lang.CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }

    public android.os.Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public boolean isCaptioningEnabled() {
        return this.mImpl.isCaptioningEnabled();
    }

    public int getRepeatMode() {
        return this.mImpl.getRepeatMode();
    }

    public int getShuffleMode() {
        return this.mImpl.getShuffleMode();
    }

    public long getFlags() {
        return this.mImpl.getFlags();
    }

    public android.support.v4.media.session.MediaControllerCompat.PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public android.app.PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }

    public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
        return this.mToken;
    }

    public android.os.Bundle getSessionToken2Bundle() {
        return this.mToken.getSessionToken2Bundle();
    }

    public void setVolumeTo(int i_renamed, int i2) {
        this.mImpl.setVolumeTo(i_renamed, i2);
    }

    public void adjustVolume(int i_renamed, int i2) {
        this.mImpl.adjustVolume(i_renamed, i2);
    }

    public void registerCallback(android.support.v4.media.session.MediaControllerCompat.Callback callback) {
        registerCallback(callback, null);
    }

    public void registerCallback(android.support.v4.media.session.MediaControllerCompat.Callback callback, android.os.Handler handler) {
        if (callback == null) {
            throw new java.lang.IllegalArgumentException("callback must not be_renamed null");
        }
        if (handler == null) {
            handler = new android.os.Handler();
        }
        callback.setHandler(handler);
        this.mImpl.registerCallback(callback, handler);
        this.mRegisteredCallbacks.add(callback);
    }

    public void unregisterCallback(android.support.v4.media.session.MediaControllerCompat.Callback callback) {
        if (callback == null) {
            throw new java.lang.IllegalArgumentException("callback must not be_renamed null");
        }
        try {
            this.mRegisteredCallbacks.remove(callback);
            this.mImpl.unregisterCallback(callback);
        } finally {
            callback.setHandler(null);
        }
    }

    public void sendCommand(java.lang.String str, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("command must neither be_renamed null nor empty");
        }
        this.mImpl.sendCommand(str, bundle, resultReceiver);
    }

    public boolean isSessionReady() {
        return this.mImpl.isSessionReady();
    }

    public java.lang.String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public java.lang.Object getMediaController() {
        return this.mImpl.getMediaController();
    }

    public static abstract class Callback implements android.os.IBinder.DeathRecipient {
        final java.lang.Object mCallbackObj;
        android.support.v4.media.session.MediaControllerCompat.Callback.MessageHandler mHandler;
        android.support.v4.media.session.IMediaControllerCallback mIControllerCallback;

        public void onAudioInfoChanged(android.support.v4.media.session.MediaControllerCompat.PlaybackInfo playbackInfo) {
        }

        public void onCaptioningEnabledChanged(boolean z_renamed) {
        }

        public void onExtrasChanged(android.os.Bundle bundle) {
        }

        public void onMetadataChanged(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) {
        }

        public void onPlaybackStateChanged(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
        }

        public void onQueueChanged(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list) {
        }

        public void onQueueTitleChanged(java.lang.CharSequence charSequence) {
        }

        public void onRepeatModeChanged(int i_renamed) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(java.lang.String str, android.os.Bundle bundle) {
        }

        public void onSessionReady() {
        }

        public void onShuffleModeChanged(int i_renamed) {
        }

        public Callback() {
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                this.mCallbackObj = android.support.v4.media.session.MediaControllerCompatApi21.createCallback(new android.support.v4.media.session.MediaControllerCompat.Callback.StubApi21(this));
                return;
            }
            android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat stubCompat = new android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat(this);
            this.mIControllerCallback = stubCompat;
            this.mCallbackObj = stubCompat;
        }

        public android.support.v4.media.session.IMediaControllerCallback getIControllerCallback() {
            return this.mIControllerCallback;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            postToHandler(8, null, null);
        }

        void setHandler(android.os.Handler handler) {
            if (handler == null) {
                android.support.v4.media.session.MediaControllerCompat.Callback.MessageHandler messageHandler = this.mHandler;
                if (messageHandler != null) {
                    messageHandler.mRegistered = false;
                    messageHandler.removeCallbacksAndMessages(null);
                    this.mHandler = null;
                    return;
                }
                return;
            }
            this.mHandler = new android.support.v4.media.session.MediaControllerCompat.Callback.MessageHandler(handler.getLooper());
            this.mHandler.mRegistered = true;
        }

        void postToHandler(int i_renamed, java.lang.Object obj, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompat.Callback.MessageHandler messageHandler = this.mHandler;
            if (messageHandler != null) {
                android.os.Message messageObtainMessage = messageHandler.obtainMessage(i_renamed, obj);
                messageObtainMessage.setData(bundle);
                messageObtainMessage.sendToTarget();
            }
        }

        private static class StubApi21 implements android.support.v4.media.session.MediaControllerCompatApi21.Callback {
            private final java.lang.ref.WeakReference<android.support.v4.media.session.MediaControllerCompat.Callback> mCallback;

            StubApi21(android.support.v4.media.session.MediaControllerCompat.Callback callback) {
                this.mCallback = new java.lang.ref.WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionDestroyed() {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onSessionDestroyed();
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionEvent(java.lang.String str, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    if (callback.mIControllerCallback == null || android.os.Build.VERSION.SDK_INT >= 23) {
                        callback.onSessionEvent(str, bundle);
                    }
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onPlaybackStateChanged(java.lang.Object obj) {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback == null || callback.mIControllerCallback != null) {
                    return;
                }
                callback.onPlaybackStateChanged(android.support.v4.media.session.PlaybackStateCompat.fromPlaybackState(obj));
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onMetadataChanged(java.lang.Object obj) {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onMetadataChanged(android.support.v4.media.MediaMetadataCompat.fromMediaMetadata(obj));
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onQueueChanged(java.util.List<?> list) {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onQueueChanged(android.support.v4.media.session.MediaSessionCompat.QueueItem.fromQueueItemList(list));
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onQueueTitleChanged(java.lang.CharSequence charSequence) {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onQueueTitleChanged(charSequence);
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onExtrasChanged(android.os.Bundle bundle) {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onExtrasChanged(bundle);
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onAudioInfoChanged(int i_renamed, int i2, int i3, int i4, int i5) {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onAudioInfoChanged(new android.support.v4.media.session.MediaControllerCompat.PlaybackInfo(i_renamed, i2, i3, i4, i5));
                }
            }
        }

        private static class StubCompat extends android.support.v4.media.session.IMediaControllerCallback.Stub {
            private final java.lang.ref.WeakReference<android.support.v4.media.session.MediaControllerCompat.Callback> mCallback;

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean z_renamed) throws android.os.RemoteException {
            }

            StubCompat(android.support.v4.media.session.MediaControllerCompat.Callback callback) {
                this.mCallback = new java.lang.ref.WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(1, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws android.os.RemoteException {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(8, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) throws android.os.RemoteException {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) throws android.os.RemoteException {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(3, mediaMetadataCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list) throws android.os.RemoteException {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(5, list, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(java.lang.CharSequence charSequence) throws android.os.RemoteException {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(6, charSequence, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean z_renamed) throws android.os.RemoteException {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(11, java.lang.Boolean.valueOf(z_renamed), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int i_renamed) throws android.os.RemoteException {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(9, java.lang.Integer.valueOf(i_renamed), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int i_renamed) throws android.os.RemoteException {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(12, java.lang.Integer.valueOf(i_renamed), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(android.os.Bundle bundle) throws android.os.RemoteException {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(7, bundle, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(android.support.v4.media.session.ParcelableVolumeInfo parcelableVolumeInfo) throws android.os.RemoteException {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(4, parcelableVolumeInfo != null ? new android.support.v4.media.session.MediaControllerCompat.PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume) : null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws android.os.RemoteException {
                android.support.v4.media.session.MediaControllerCompat.Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(13, null, null);
                }
            }
        }

        private class MessageHandler extends android.os.Handler {
            private static final int MSG_DESTROYED = 8;
            private static final int MSG_EVENT = 1;
            private static final int MSG_SESSION_READY = 13;
            private static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
            private static final int MSG_UPDATE_EXTRAS = 7;
            private static final int MSG_UPDATE_METADATA = 3;
            private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
            private static final int MSG_UPDATE_QUEUE = 5;
            private static final int MSG_UPDATE_QUEUE_TITLE = 6;
            private static final int MSG_UPDATE_REPEAT_MODE = 9;
            private static final int MSG_UPDATE_SHUFFLE_MODE = 12;
            private static final int MSG_UPDATE_VOLUME = 4;
            boolean mRegistered;

            MessageHandler(android.os.Looper looper) {
                super(looper);
                this.mRegistered = false;
            }

            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (this.mRegistered) {
                    switch (message.what) {
                        case 1:
                            android.os.Bundle data = message.getData();
                            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(data);
                            android.support.v4.media.session.MediaControllerCompat.Callback.this.onSessionEvent((java.lang.String) message.obj, data);
                            break;
                        case 2:
                            android.support.v4.media.session.MediaControllerCompat.Callback.this.onPlaybackStateChanged((android.support.v4.media.session.PlaybackStateCompat) message.obj);
                            break;
                        case 3:
                            android.support.v4.media.session.MediaControllerCompat.Callback.this.onMetadataChanged((android.support.v4.media.MediaMetadataCompat) message.obj);
                            break;
                        case 4:
                            android.support.v4.media.session.MediaControllerCompat.Callback.this.onAudioInfoChanged((android.support.v4.media.session.MediaControllerCompat.PlaybackInfo) message.obj);
                            break;
                        case 5:
                            android.support.v4.media.session.MediaControllerCompat.Callback.this.onQueueChanged((java.util.List) message.obj);
                            break;
                        case 6:
                            android.support.v4.media.session.MediaControllerCompat.Callback.this.onQueueTitleChanged((java.lang.CharSequence) message.obj);
                            break;
                        case 7:
                            android.os.Bundle bundle = (android.os.Bundle) message.obj;
                            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
                            android.support.v4.media.session.MediaControllerCompat.Callback.this.onExtrasChanged(bundle);
                            break;
                        case 8:
                            android.support.v4.media.session.MediaControllerCompat.Callback.this.onSessionDestroyed();
                            break;
                        case 9:
                            android.support.v4.media.session.MediaControllerCompat.Callback.this.onRepeatModeChanged(((java.lang.Integer) message.obj).intValue());
                            break;
                        case 11:
                            android.support.v4.media.session.MediaControllerCompat.Callback.this.onCaptioningEnabledChanged(((java.lang.Boolean) message.obj).booleanValue());
                            break;
                        case 12:
                            android.support.v4.media.session.MediaControllerCompat.Callback.this.onShuffleModeChanged(((java.lang.Integer) message.obj).intValue());
                            break;
                        case 13:
                            android.support.v4.media.session.MediaControllerCompat.Callback.this.onSessionReady();
                            break;
                    }
                }
            }
        }
    }

    public static abstract class TransportControls {
        public static final java.lang.String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(java.lang.String str, android.os.Bundle bundle);

        public abstract void playFromSearch(java.lang.String str, android.os.Bundle bundle);

        public abstract void playFromUri(android.net.Uri uri, android.os.Bundle bundle);

        public abstract void prepare();

        public abstract void prepareFromMediaId(java.lang.String str, android.os.Bundle bundle);

        public abstract void prepareFromSearch(java.lang.String str, android.os.Bundle bundle);

        public abstract void prepareFromUri(android.net.Uri uri, android.os.Bundle bundle);

        public abstract void rewind();

        public abstract void seekTo(long j_renamed);

        public abstract void sendCustomAction(android.support.v4.media.session.PlaybackStateCompat.CustomAction customAction, android.os.Bundle bundle);

        public abstract void sendCustomAction(java.lang.String str, android.os.Bundle bundle);

        public abstract void setCaptioningEnabled(boolean z_renamed);

        public abstract void setRating(android.support.v4.media.RatingCompat ratingCompat);

        public abstract void setRating(android.support.v4.media.RatingCompat ratingCompat, android.os.Bundle bundle);

        public abstract void setRepeatMode(int i_renamed);

        public abstract void setShuffleMode(int i_renamed);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j_renamed);

        public abstract void stop();

        TransportControls() {
        }
    }

    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        private final int mAudioStream;
        private final int mCurrentVolume;
        private final int mMaxVolume;
        private final int mPlaybackType;
        private final int mVolumeControl;

        PlaybackInfo(int i_renamed, int i2, int i3, int i4, int i5) {
            this.mPlaybackType = i_renamed;
            this.mAudioStream = i2;
            this.mVolumeControl = i3;
            this.mMaxVolume = i4;
            this.mCurrentVolume = i5;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public int getAudioStream() {
            return this.mAudioStream;
        }

        public int getVolumeControl() {
            return this.mVolumeControl;
        }

        public int getMaxVolume() {
            return this.mMaxVolume;
        }

        public int getCurrentVolume() {
            return this.mCurrentVolume;
        }
    }

    static class MediaControllerImplBase implements android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl {
        private android.support.v4.media.session.IMediaSession mBinder;
        private android.support.v4.media.session.MediaControllerCompat.TransportControls mTransportControls;

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public java.lang.Object getMediaController() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            return true;
        }

        public MediaControllerImplBase(android.support.v4.media.session.MediaSessionCompat.Token token) {
            this.mBinder = android.support.v4.media.session.IMediaSession.Stub.asInterface((android.os.IBinder) token.getToken());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void registerCallback(android.support.v4.media.session.MediaControllerCompat.Callback callback, android.os.Handler handler) throws android.os.RemoteException {
            if (callback == null) {
                throw new java.lang.IllegalArgumentException("callback may not be_renamed null.");
            }
            try {
                this.mBinder.asBinder().linkToDeath(callback, 0);
                this.mBinder.registerCallbackListener((android.support.v4.media.session.IMediaControllerCallback) callback.mCallbackObj);
                callback.postToHandler(13, null, null);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed registerCallback.", e_renamed);
                callback.postToHandler(8, null, null);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void unregisterCallback(android.support.v4.media.session.MediaControllerCompat.Callback callback) {
            if (callback == null) {
                throw new java.lang.IllegalArgumentException("callback may not be_renamed null.");
            }
            try {
                this.mBinder.unregisterCallbackListener((android.support.v4.media.session.IMediaControllerCallback) callback.mCallbackObj);
                this.mBinder.asBinder().unlinkToDeath(callback, 0);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed unregisterCallback.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(android.view.KeyEvent keyEvent) {
            if (keyEvent == null) {
                throw new java.lang.IllegalArgumentException("event may not be_renamed null.");
            }
            try {
                this.mBinder.sendMediaButton(keyEvent);
                return false;
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed dispatchMediaButtonEvent.", e_renamed);
                return false;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public android.support.v4.media.session.MediaControllerCompat.TransportControls getTransportControls() {
            if (this.mTransportControls == null) {
                this.mTransportControls = new android.support.v4.media.session.MediaControllerCompat.TransportControlsBase(this.mBinder);
            }
            return this.mTransportControls;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public android.support.v4.media.session.PlaybackStateCompat getPlaybackState() {
            try {
                return this.mBinder.getPlaybackState();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getPlaybackState.", e_renamed);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public android.support.v4.media.MediaMetadataCompat getMetadata() {
            try {
                return this.mBinder.getMetadata();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getMetadata.", e_renamed);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> getQueue() {
            try {
                return this.mBinder.getQueue();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getQueue.", e_renamed);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.mBinder.getFlags() & 4) == 0) {
                    throw new java.lang.UnsupportedOperationException("This session doesn't_renamed support queue management operations");
                }
                this.mBinder.addQueueItem(mediaDescriptionCompat);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed addQueueItem.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, int i_renamed) {
            try {
                if ((this.mBinder.getFlags() & 4) == 0) {
                    throw new java.lang.UnsupportedOperationException("This session doesn't_renamed support queue management operations");
                }
                this.mBinder.addQueueItemAt(mediaDescriptionCompat, i_renamed);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed addQueueItemAt.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.mBinder.getFlags() & 4) == 0) {
                    throw new java.lang.UnsupportedOperationException("This session doesn't_renamed support queue management operations");
                }
                this.mBinder.removeQueueItem(mediaDescriptionCompat);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed removeQueueItem.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public java.lang.CharSequence getQueueTitle() {
            try {
                return this.mBinder.getQueueTitle();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getQueueTitle.", e_renamed);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public android.os.Bundle getExtras() {
            try {
                return this.mBinder.getExtras();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getExtras.", e_renamed);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            try {
                return this.mBinder.getRatingType();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getRatingType.", e_renamed);
                return 0;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isCaptioningEnabled() {
            try {
                return this.mBinder.isCaptioningEnabled();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed isCaptioningEnabled.", e_renamed);
                return false;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            try {
                return this.mBinder.getRepeatMode();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getRepeatMode.", e_renamed);
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            try {
                return this.mBinder.getShuffleMode();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getShuffleMode.", e_renamed);
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public long getFlags() {
            try {
                return this.mBinder.getFlags();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getFlags.", e_renamed);
                return 0L;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public android.support.v4.media.session.MediaControllerCompat.PlaybackInfo getPlaybackInfo() {
            try {
                android.support.v4.media.session.ParcelableVolumeInfo volumeAttributes = this.mBinder.getVolumeAttributes();
                return new android.support.v4.media.session.MediaControllerCompat.PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioStream, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getPlaybackInfo.", e_renamed);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public android.app.PendingIntent getSessionActivity() {
            try {
                return this.mBinder.getLaunchPendingIntent();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getSessionActivity.", e_renamed);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int i_renamed, int i2) {
            try {
                this.mBinder.setVolumeTo(i_renamed, i2, null);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed setVolumeTo.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int i_renamed, int i2) {
            try {
                this.mBinder.adjustVolume(i_renamed, i2, null);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed adjustVolume.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(java.lang.String str, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver) {
            try {
                this.mBinder.sendCommand(str, bundle, new android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper(resultReceiver));
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed sendCommand.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public java.lang.String getPackageName() {
            try {
                return this.mBinder.getPackageName();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getPackageName.", e_renamed);
                return null;
            }
        }
    }

    static class TransportControlsBase extends android.support.v4.media.session.MediaControllerCompat.TransportControls {
        private android.support.v4.media.session.IMediaSession mBinder;

        public TransportControlsBase(android.support.v4.media.session.IMediaSession iMediaSession) {
            this.mBinder = iMediaSession;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            try {
                this.mBinder.prepare();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed prepare.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(java.lang.String str, android.os.Bundle bundle) {
            try {
                this.mBinder.prepareFromMediaId(str, bundle);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed prepareFromMediaId.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(java.lang.String str, android.os.Bundle bundle) {
            try {
                this.mBinder.prepareFromSearch(str, bundle);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed prepareFromSearch.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(android.net.Uri uri, android.os.Bundle bundle) {
            try {
                this.mBinder.prepareFromUri(uri, bundle);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed prepareFromUri.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            try {
                this.mBinder.play();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed play.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(java.lang.String str, android.os.Bundle bundle) {
            try {
                this.mBinder.playFromMediaId(str, bundle);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed playFromMediaId.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(java.lang.String str, android.os.Bundle bundle) {
            try {
                this.mBinder.playFromSearch(str, bundle);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed playFromSearch.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(android.net.Uri uri, android.os.Bundle bundle) {
            try {
                this.mBinder.playFromUri(uri, bundle);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed playFromUri.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long j_renamed) {
            try {
                this.mBinder.skipToQueueItem(j_renamed);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed skipToQueueItem.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            try {
                this.mBinder.pause();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed pause.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            try {
                this.mBinder.stop();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed stop.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long j_renamed) {
            try {
                this.mBinder.seekTo(j_renamed);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed seekTo.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            try {
                this.mBinder.fastForward();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed fastForward.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            try {
                this.mBinder.next();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed skipToNext.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            try {
                this.mBinder.rewind();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed rewind.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            try {
                this.mBinder.previous();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed skipToPrevious.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(android.support.v4.media.RatingCompat ratingCompat) {
            try {
                this.mBinder.rate(ratingCompat);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed setRating.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(android.support.v4.media.RatingCompat ratingCompat, android.os.Bundle bundle) {
            try {
                this.mBinder.rateWithExtras(ratingCompat, bundle);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed setRating.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean z_renamed) {
            try {
                this.mBinder.setCaptioningEnabled(z_renamed);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed setCaptioningEnabled.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int i_renamed) {
            try {
                this.mBinder.setRepeatMode(i_renamed);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed setRepeatMode.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int i_renamed) {
            try {
                this.mBinder.setShuffleMode(i_renamed);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed setShuffleMode.", e_renamed);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(android.support.v4.media.session.PlaybackStateCompat.CustomAction customAction, android.os.Bundle bundle) {
            sendCustomAction(customAction.getAction(), bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(java.lang.String str, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompat.validateCustomAction(str, bundle);
            try {
                this.mBinder.sendCustomAction(str, bundle);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed sendCustomAction.", e_renamed);
            }
        }
    }

    static class MediaControllerImplApi21 implements android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl {
        protected final java.lang.Object mControllerObj;
        final android.support.v4.media.session.MediaSessionCompat.Token mSessionToken;
        final java.lang.Object mLock = new java.lang.Object();
        private final java.util.List<android.support.v4.media.session.MediaControllerCompat.Callback> mPendingCallbacks = new java.util.ArrayList();
        private java.util.HashMap<android.support.v4.media.session.MediaControllerCompat.Callback, android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.ExtraCallback> mCallbackMap = new java.util.HashMap<>();

        public MediaControllerImplApi21(android.content.Context context, android.support.v4.media.session.MediaSessionCompat.Token token) throws android.os.RemoteException {
            this.mSessionToken = token;
            this.mControllerObj = android.support.v4.media.session.MediaControllerCompatApi21.fromToken(context, this.mSessionToken.getToken());
            if (this.mControllerObj == null) {
                throw new android.os.RemoteException();
            }
            if (this.mSessionToken.getExtraBinder() == null) {
                requestExtraBinder();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void registerCallback(android.support.v4.media.session.MediaControllerCompat.Callback callback, android.os.Handler handler) {
            android.support.v4.media.session.MediaControllerCompatApi21.registerCallback(this.mControllerObj, callback.mCallbackObj, handler);
            synchronized (this.mLock) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.ExtraCallback extraCallback = new android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.ExtraCallback(callback);
                    this.mCallbackMap.put(callback, extraCallback);
                    callback.mIControllerCallback = extraCallback;
                    try {
                        this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
                        callback.postToHandler(13, null, null);
                    } catch (android.os.RemoteException e_renamed) {
                        android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed registerCallback.", e_renamed);
                    }
                } else {
                    callback.mIControllerCallback = null;
                    this.mPendingCallbacks.add(callback);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void unregisterCallback(android.support.v4.media.session.MediaControllerCompat.Callback callback) {
            android.support.v4.media.session.MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, callback.mCallbackObj);
            synchronized (this.mLock) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    try {
                        android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.ExtraCallback extraCallbackRemove = this.mCallbackMap.remove(callback);
                        if (extraCallbackRemove != null) {
                            callback.mIControllerCallback = null;
                            this.mSessionToken.getExtraBinder().unregisterCallbackListener(extraCallbackRemove);
                        }
                    } catch (android.os.RemoteException e_renamed) {
                        android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed unregisterCallback.", e_renamed);
                    }
                }
                this.mPendingCallbacks.remove(callback);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(android.view.KeyEvent keyEvent) {
            return android.support.v4.media.session.MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, keyEvent);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public android.support.v4.media.session.MediaControllerCompat.TransportControls getTransportControls() {
            java.lang.Object transportControls = android.support.v4.media.session.MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (transportControls != null) {
                return new android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21(transportControls);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public android.support.v4.media.session.PlaybackStateCompat getPlaybackState() {
            if (this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().getPlaybackState();
                } catch (android.os.RemoteException e_renamed) {
                    android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getPlaybackState.", e_renamed);
                }
            }
            java.lang.Object playbackState = android.support.v4.media.session.MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
            if (playbackState != null) {
                return android.support.v4.media.session.PlaybackStateCompat.fromPlaybackState(playbackState);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public android.support.v4.media.MediaMetadataCompat getMetadata() {
            java.lang.Object metadata = android.support.v4.media.session.MediaControllerCompatApi21.getMetadata(this.mControllerObj);
            if (metadata != null) {
                return android.support.v4.media.MediaMetadataCompat.fromMediaMetadata(metadata);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> getQueue() {
            java.util.List<java.lang.Object> queue = android.support.v4.media.session.MediaControllerCompatApi21.getQueue(this.mControllerObj);
            if (queue != null) {
                return android.support.v4.media.session.MediaSessionCompat.QueueItem.fromQueueItemList(queue);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) == 0) {
                throw new java.lang.UnsupportedOperationException("This session doesn't_renamed support queue management operations");
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelable(android.support.v4.media.session.MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
            sendCommand(android.support.v4.media.session.MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM, bundle, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, int i_renamed) {
            if ((getFlags() & 4) == 0) {
                throw new java.lang.UnsupportedOperationException("This session doesn't_renamed support queue management operations");
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelable(android.support.v4.media.session.MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
            bundle.putInt(android.support.v4.media.session.MediaControllerCompat.COMMAND_ARGUMENT_INDEX, i_renamed);
            sendCommand(android.support.v4.media.session.MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT, bundle, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) == 0) {
                throw new java.lang.UnsupportedOperationException("This session doesn't_renamed support queue management operations");
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelable(android.support.v4.media.session.MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
            sendCommand(android.support.v4.media.session.MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM, bundle, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public java.lang.CharSequence getQueueTitle() {
            return android.support.v4.media.session.MediaControllerCompatApi21.getQueueTitle(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public android.os.Bundle getExtras() {
            return android.support.v4.media.session.MediaControllerCompatApi21.getExtras(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            if (android.os.Build.VERSION.SDK_INT < 22 && this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().getRatingType();
                } catch (android.os.RemoteException e_renamed) {
                    android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getRatingType.", e_renamed);
                }
            }
            return android.support.v4.media.session.MediaControllerCompatApi21.getRatingType(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isCaptioningEnabled() {
            if (this.mSessionToken.getExtraBinder() == null) {
                return false;
            }
            try {
                return this.mSessionToken.getExtraBinder().isCaptioningEnabled();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed isCaptioningEnabled.", e_renamed);
                return false;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            if (this.mSessionToken.getExtraBinder() == null) {
                return -1;
            }
            try {
                return this.mSessionToken.getExtraBinder().getRepeatMode();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getRepeatMode.", e_renamed);
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            if (this.mSessionToken.getExtraBinder() == null) {
                return -1;
            }
            try {
                return this.mSessionToken.getExtraBinder().getShuffleMode();
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed getShuffleMode.", e_renamed);
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public long getFlags() {
            return android.support.v4.media.session.MediaControllerCompatApi21.getFlags(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public android.support.v4.media.session.MediaControllerCompat.PlaybackInfo getPlaybackInfo() {
            java.lang.Object playbackInfo = android.support.v4.media.session.MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
            if (playbackInfo != null) {
                return new android.support.v4.media.session.MediaControllerCompat.PlaybackInfo(android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(playbackInfo), android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(playbackInfo), android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(playbackInfo), android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(playbackInfo), android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(playbackInfo));
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public android.app.PendingIntent getSessionActivity() {
            return android.support.v4.media.session.MediaControllerCompatApi21.getSessionActivity(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int i_renamed, int i2) {
            android.support.v4.media.session.MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, i_renamed, i2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int i_renamed, int i2) {
            android.support.v4.media.session.MediaControllerCompatApi21.adjustVolume(this.mControllerObj, i_renamed, i2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(java.lang.String str, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver) {
            android.support.v4.media.session.MediaControllerCompatApi21.sendCommand(this.mControllerObj, str, bundle, resultReceiver);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            return this.mSessionToken.getExtraBinder() != null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public java.lang.String getPackageName() {
            return android.support.v4.media.session.MediaControllerCompatApi21.getPackageName(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public java.lang.Object getMediaController() {
            return this.mControllerObj;
        }

        private void requestExtraBinder() {
            sendCommand(android.support.v4.media.session.MediaControllerCompat.COMMAND_GET_EXTRA_BINDER, null, new android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.ExtraBinderRequestResultReceiver(this));
        }

        void processPendingCallbacksLocked() {
            if (this.mSessionToken.getExtraBinder() == null) {
                return;
            }
            for (android.support.v4.media.session.MediaControllerCompat.Callback callback : this.mPendingCallbacks) {
                android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.ExtraCallback extraCallback = new android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.ExtraCallback(callback);
                this.mCallbackMap.put(callback, extraCallback);
                callback.mIControllerCallback = extraCallback;
                try {
                    this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
                    callback.postToHandler(13, null, null);
                } catch (android.os.RemoteException e_renamed) {
                    android.util.Log.e_renamed(android.support.v4.media.session.MediaControllerCompat.TAG, "Dead object in_renamed registerCallback.", e_renamed);
                }
            }
            this.mPendingCallbacks.clear();
        }

        private static class ExtraBinderRequestResultReceiver extends android.os.ResultReceiver {
            private java.lang.ref.WeakReference<android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21> mMediaControllerImpl;

            ExtraBinderRequestResultReceiver(android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.mMediaControllerImpl = new java.lang.ref.WeakReference<>(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i_renamed, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21 mediaControllerImplApi21 = this.mMediaControllerImpl.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.mLock) {
                    mediaControllerImplApi21.mSessionToken.setExtraBinder(android.support.v4.media.session.IMediaSession.Stub.asInterface(androidx.core.app.d_renamed.a_renamed(bundle, android.support.v4.media.session.MediaSessionCompat.KEY_EXTRA_BINDER)));
                    mediaControllerImplApi21.mSessionToken.setSessionToken2Bundle(bundle.getBundle(android.support.v4.media.session.MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE));
                    mediaControllerImplApi21.processPendingCallbacksLocked();
                }
            }
        }

        private static class ExtraCallback extends android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat {
            ExtraCallback(android.support.v4.media.session.MediaControllerCompat.Callback callback) {
                super(callback);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(java.lang.CharSequence charSequence) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(android.support.v4.media.session.ParcelableVolumeInfo parcelableVolumeInfo) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }
        }
    }

    static class TransportControlsApi21 extends android.support.v4.media.session.MediaControllerCompat.TransportControls {
        protected final java.lang.Object mControlsObj;

        public TransportControlsApi21(java.lang.Object obj) {
            this.mControlsObj = obj;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            sendCustomAction(android.support.v4.media.session.MediaSessionCompat.ACTION_PREPARE, (android.os.Bundle) null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(java.lang.String str, android.os.Bundle bundle) {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID, str);
            bundle2.putBundle(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(android.support.v4.media.session.MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(java.lang.String str, android.os.Bundle bundle) {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_QUERY, str);
            bundle2.putBundle(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(android.support.v4.media.session.MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(android.net.Uri uri, android.os.Bundle bundle) {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putParcelable(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
            bundle2.putBundle(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(android.support.v4.media.session.MediaSessionCompat.ACTION_PREPARE_FROM_URI, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.play(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.pause(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.stop(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long j_renamed) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.seekTo(this.mControlsObj, j_renamed);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.fastForward(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.rewind(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.skipToNext(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.skipToPrevious(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(android.support.v4.media.RatingCompat ratingCompat) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.setRating(this.mControlsObj, ratingCompat != null ? ratingCompat.getRating() : null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(android.support.v4.media.RatingCompat ratingCompat, android.os.Bundle bundle) {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putParcelable(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_RATING, ratingCompat);
            bundle2.putBundle(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(android.support.v4.media.session.MediaSessionCompat.ACTION_SET_RATING, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean z_renamed) {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putBoolean(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED, z_renamed);
            sendCustomAction(android.support.v4.media.session.MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int i_renamed) {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE, i_renamed);
            sendCustomAction(android.support.v4.media.session.MediaSessionCompat.ACTION_SET_REPEAT_MODE, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int i_renamed) {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE, i_renamed);
            sendCustomAction(android.support.v4.media.session.MediaSessionCompat.ACTION_SET_SHUFFLE_MODE, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(java.lang.String str, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.playFromMediaId(this.mControlsObj, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(java.lang.String str, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.playFromSearch(this.mControlsObj, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(android.net.Uri uri, android.os.Bundle bundle) {
            if (uri == null || android.net.Uri.EMPTY.equals(uri)) {
                throw new java.lang.IllegalArgumentException("You must specify a_renamed non-empty Uri for playFromUri.");
            }
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putParcelable(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
            bundle2.putBundle(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(android.support.v4.media.session.MediaSessionCompat.ACTION_PLAY_FROM_URI, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long j_renamed) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.mControlsObj, j_renamed);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(android.support.v4.media.session.PlaybackStateCompat.CustomAction customAction, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompat.validateCustomAction(customAction.getAction(), bundle);
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, customAction.getAction(), bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(java.lang.String str, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompat.validateCustomAction(str, bundle);
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, str, bundle);
        }
    }

    static class MediaControllerImplApi23 extends android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21 {
        public MediaControllerImplApi23(android.content.Context context, android.support.v4.media.session.MediaSessionCompat.Token token) throws android.os.RemoteException {
            super(context, token);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public android.support.v4.media.session.MediaControllerCompat.TransportControls getTransportControls() {
            java.lang.Object transportControls = android.support.v4.media.session.MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (transportControls != null) {
                return new android.support.v4.media.session.MediaControllerCompat.TransportControlsApi23(transportControls);
            }
            return null;
        }
    }

    static class TransportControlsApi23 extends android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21 {
        public TransportControlsApi23(java.lang.Object obj) {
            super(obj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(android.net.Uri uri, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi23.TransportControls.playFromUri(this.mControlsObj, uri, bundle);
        }
    }

    static class MediaControllerImplApi24 extends android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi23 {
        public MediaControllerImplApi24(android.content.Context context, android.support.v4.media.session.MediaSessionCompat.Token token) throws android.os.RemoteException {
            super(context, token);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi23, android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public android.support.v4.media.session.MediaControllerCompat.TransportControls getTransportControls() {
            java.lang.Object transportControls = android.support.v4.media.session.MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (transportControls != null) {
                return new android.support.v4.media.session.MediaControllerCompat.TransportControlsApi24(transportControls);
            }
            return null;
        }
    }

    static class TransportControlsApi24 extends android.support.v4.media.session.MediaControllerCompat.TransportControlsApi23 {
        public TransportControlsApi24(java.lang.Object obj) {
            super(obj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            android.support.v4.media.session.MediaControllerCompatApi24.TransportControls.prepare(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(java.lang.String str, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi24.TransportControls.prepareFromMediaId(this.mControlsObj, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(java.lang.String str, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi24.TransportControls.prepareFromSearch(this.mControlsObj, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(android.net.Uri uri, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi24.TransportControls.prepareFromUri(this.mControlsObj, uri, bundle);
        }
    }
}

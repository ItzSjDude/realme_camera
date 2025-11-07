package android.support.v4.media;

/* loaded from: classes.dex */
public final class MediaBrowserCompat {
    public static final java.lang.String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final java.lang.String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    public static final java.lang.String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final java.lang.String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final java.lang.String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final java.lang.String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    private final android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl mImpl;
    static final java.lang.String TAG = "MediaBrowserCompat";
    static final boolean DEBUG = android.util.Log.isLoggable(TAG, 3);

    public static abstract class CustomActionCallback {
        public void onError(java.lang.String str, android.os.Bundle bundle, android.os.Bundle bundle2) {
        }

        public void onProgressUpdate(java.lang.String str, android.os.Bundle bundle, android.os.Bundle bundle2) {
        }

        public void onResult(java.lang.String str, android.os.Bundle bundle, android.os.Bundle bundle2) {
        }
    }

    interface MediaBrowserImpl {
        void connect();

        void disconnect();

        android.os.Bundle getExtras();

        void getItem(java.lang.String str, android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback);

        android.os.Bundle getNotifyChildrenChangedOptions();

        java.lang.String getRoot();

        android.content.ComponentName getServiceComponent();

        android.support.v4.media.session.MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void search(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback);

        void sendCustomAction(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback);

        void subscribe(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback);

        void unsubscribe(java.lang.String str, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback);
    }

    interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(android.os.Messenger messenger);

        void onLoadChildren(android.os.Messenger messenger, java.lang.String str, java.util.List list, android.os.Bundle bundle, android.os.Bundle bundle2);

        void onServiceConnected(android.os.Messenger messenger, java.lang.String str, android.support.v4.media.session.MediaSessionCompat.Token token, android.os.Bundle bundle);
    }

    public static abstract class SearchCallback {
        public void onError(java.lang.String str, android.os.Bundle bundle) {
        }

        public void onSearchResult(java.lang.String str, android.os.Bundle bundle, java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list) {
        }
    }

    public MediaBrowserCompat(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mImpl = new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi26(context, componentName, connectionCallback, bundle);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.mImpl = new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi23(context, componentName, connectionCallback, bundle);
        } else if (android.os.Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21(context, componentName, connectionCallback, bundle);
        } else {
            this.mImpl = new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase(context, componentName, connectionCallback, bundle);
        }
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public android.content.ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    public java.lang.String getRoot() {
        return this.mImpl.getRoot();
    }

    public android.os.Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public void subscribe(java.lang.String str, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("parentId is_renamed empty");
        }
        if (subscriptionCallback == null) {
            throw new java.lang.IllegalArgumentException("callback is_renamed null");
        }
        this.mImpl.subscribe(str, null, subscriptionCallback);
    }

    public void subscribe(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("parentId is_renamed empty");
        }
        if (subscriptionCallback == null) {
            throw new java.lang.IllegalArgumentException("callback is_renamed null");
        }
        if (bundle == null) {
            throw new java.lang.IllegalArgumentException("options are null");
        }
        this.mImpl.subscribe(str, bundle, subscriptionCallback);
    }

    public void unsubscribe(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("parentId is_renamed empty");
        }
        this.mImpl.unsubscribe(str, null);
    }

    public void unsubscribe(java.lang.String str, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("parentId is_renamed empty");
        }
        if (subscriptionCallback == null) {
            throw new java.lang.IllegalArgumentException("callback is_renamed null");
        }
        this.mImpl.unsubscribe(str, subscriptionCallback);
    }

    public void getItem(java.lang.String str, android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback) {
        this.mImpl.getItem(str, itemCallback);
    }

    public void search(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("query cannot be_renamed empty");
        }
        if (searchCallback == null) {
            throw new java.lang.IllegalArgumentException("callback cannot be_renamed null");
        }
        this.mImpl.search(str, bundle, searchCallback);
    }

    public void sendCustomAction(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("action cannot be_renamed empty");
        }
        this.mImpl.sendCustomAction(str, bundle, customActionCallback);
    }

    public android.os.Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    public static class MediaItem implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<android.support.v4.media.MediaBrowserCompat.MediaItem> CREATOR = new android.os.Parcelable.Creator<android.support.v4.media.MediaBrowserCompat.MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.MediaBrowserCompat.MediaItem createFromParcel(android.os.Parcel parcel) {
                return new android.support.v4.media.MediaBrowserCompat.MediaItem(parcel);
            }

            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.MediaBrowserCompat.MediaItem[] newArray(int i_renamed) {
                return new android.support.v4.media.MediaBrowserCompat.MediaItem[i_renamed];
            }
        };
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final android.support.v4.media.MediaDescriptionCompat mDescription;
        private final int mFlags;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface Flags {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public static android.support.v4.media.MediaBrowserCompat.MediaItem fromMediaItem(java.lang.Object obj) {
            if (obj == null || android.os.Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new android.support.v4.media.MediaBrowserCompat.MediaItem(android.support.v4.media.MediaDescriptionCompat.fromMediaDescription(android.support.v4.media.MediaBrowserCompatApi21.MediaItem.getDescription(obj)), android.support.v4.media.MediaBrowserCompatApi21.MediaItem.getFlags(obj));
        }

        public static java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> fromMediaItemList(java.util.List<?> list) {
            if (list == null || android.os.Build.VERSION.SDK_INT < 21) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
            java.util.Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(fromMediaItem(it.next()));
            }
            return arrayList;
        }

        public MediaItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, int i_renamed) {
            if (mediaDescriptionCompat == null) {
                throw new java.lang.IllegalArgumentException("description cannot be_renamed null");
            }
            if (android.text.TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                throw new java.lang.IllegalArgumentException("description must have a_renamed non-empty media id_renamed");
            }
            this.mFlags = i_renamed;
            this.mDescription = mediaDescriptionCompat;
        }

        MediaItem(android.os.Parcel parcel) {
            this.mFlags = parcel.readInt();
            this.mDescription = android.support.v4.media.MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            parcel.writeInt(this.mFlags);
            this.mDescription.writeToParcel(parcel, i_renamed);
        }

        public java.lang.String toString() {
            return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
        }

        public int getFlags() {
            return this.mFlags;
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        public android.support.v4.media.MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public java.lang.String getMediaId() {
            return this.mDescription.getMediaId();
        }
    }

    public static class ConnectionCallback {
        android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal mConnectionCallbackInternal;
        final java.lang.Object mConnectionCallbackObj;

        interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        public ConnectionCallback() {
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                this.mConnectionCallbackObj = android.support.v4.media.MediaBrowserCompatApi21.createConnectionCallback(new android.support.v4.media.MediaBrowserCompat.ConnectionCallback.StubApi21());
            } else {
                this.mConnectionCallbackObj = null;
            }
        }

        void setInternalConnectionCallback(android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal connectionCallbackInternal) {
            this.mConnectionCallbackInternal = connectionCallbackInternal;
        }

        private class StubApi21 implements android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback {
            StubApi21() {
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnected() {
                if (android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal.onConnected();
                }
                android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.onConnected();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnectionSuspended() {
                if (android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal.onConnectionSuspended();
                }
                android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.onConnectionSuspended();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnectionFailed() {
                if (android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal.onConnectionFailed();
                }
                android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.onConnectionFailed();
            }
        }
    }

    public static abstract class SubscriptionCallback {
        final java.lang.Object mSubscriptionCallbackObj;
        java.lang.ref.WeakReference<android.support.v4.media.MediaBrowserCompat.Subscription> mSubscriptionRef;
        final android.os.IBinder mToken = new android.os.Binder();

        public void onChildrenLoaded(java.lang.String str, java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list) {
        }

        public void onChildrenLoaded(java.lang.String str, java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list, android.os.Bundle bundle) {
        }

        public void onError(java.lang.String str) {
        }

        public void onError(java.lang.String str, android.os.Bundle bundle) {
        }

        public SubscriptionCallback() {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                this.mSubscriptionCallbackObj = android.support.v4.media.MediaBrowserCompatApi26.createSubscriptionCallback(new android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.StubApi26());
            } else if (android.os.Build.VERSION.SDK_INT >= 21) {
                this.mSubscriptionCallbackObj = android.support.v4.media.MediaBrowserCompatApi21.createSubscriptionCallback(new android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.StubApi21());
            } else {
                this.mSubscriptionCallbackObj = null;
            }
        }

        void setSubscription(android.support.v4.media.MediaBrowserCompat.Subscription subscription) {
            this.mSubscriptionRef = new java.lang.ref.WeakReference<>(subscription);
        }

        private class StubApi21 implements android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback {
            StubApi21() {
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onChildrenLoaded(java.lang.String str, java.util.List<?> list) {
                android.support.v4.media.MediaBrowserCompat.Subscription subscription = android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.mSubscriptionRef == null ? null : android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.mSubscriptionRef.get();
                if (subscription == null) {
                    android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(str, android.support.v4.media.MediaBrowserCompat.MediaItem.fromMediaItemList(list));
                    return;
                }
                java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> listFromMediaItemList = android.support.v4.media.MediaBrowserCompat.MediaItem.fromMediaItemList(list);
                java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks = subscription.getCallbacks();
                java.util.List<android.os.Bundle> optionsList = subscription.getOptionsList();
                for (int i_renamed = 0; i_renamed < callbacks.size(); i_renamed++) {
                    android.os.Bundle bundle = optionsList.get(i_renamed);
                    if (bundle == null) {
                        android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(str, listFromMediaItemList);
                    } else {
                        android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(str, applyOptions(listFromMediaItemList, bundle), bundle);
                    }
                }
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onError(java.lang.String str) {
                android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onError(str);
            }

            java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> applyOptions(java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list, android.os.Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i_renamed = bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE, -1);
                int i2 = bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (i_renamed == -1 && i2 == -1) {
                    return list;
                }
                int i3 = i2 * i_renamed;
                int size = i3 + i2;
                if (i_renamed < 0 || i2 < 1 || i3 >= list.size()) {
                    return java.util.Collections.emptyList();
                }
                if (size > list.size()) {
                    size = list.size();
                }
                return list.subList(i3, size);
            }
        }

        private class StubApi26 extends android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.StubApi21 implements android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback {
            StubApi26() {
                super();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void onChildrenLoaded(java.lang.String str, java.util.List<?> list, android.os.Bundle bundle) {
                android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(str, android.support.v4.media.MediaBrowserCompat.MediaItem.fromMediaItemList(list), bundle);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void onError(java.lang.String str, android.os.Bundle bundle) {
                android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onError(str, bundle);
            }
        }
    }

    public static abstract class ItemCallback {
        final java.lang.Object mItemCallbackObj;

        public void onError(java.lang.String str) {
        }

        public void onItemLoaded(android.support.v4.media.MediaBrowserCompat.MediaItem mediaItem) {
        }

        public ItemCallback() {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                this.mItemCallbackObj = android.support.v4.media.MediaBrowserCompatApi23.createItemCallback(new android.support.v4.media.MediaBrowserCompat.ItemCallback.StubApi23());
            } else {
                this.mItemCallbackObj = null;
            }
        }

        private class StubApi23 implements android.support.v4.media.MediaBrowserCompatApi23.ItemCallback {
            StubApi23() {
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onItemLoaded(android.os.Parcel parcel) {
                if (parcel == null) {
                    android.support.v4.media.MediaBrowserCompat.ItemCallback.this.onItemLoaded(null);
                    return;
                }
                parcel.setDataPosition(0);
                android.support.v4.media.MediaBrowserCompat.MediaItem mediaItemCreateFromParcel = android.support.v4.media.MediaBrowserCompat.MediaItem.CREATOR.createFromParcel(parcel);
                parcel.recycle();
                android.support.v4.media.MediaBrowserCompat.ItemCallback.this.onItemLoaded(mediaItemCreateFromParcel);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onError(java.lang.String str) {
                android.support.v4.media.MediaBrowserCompat.ItemCallback.this.onError(str);
            }
        }
    }

    static class MediaBrowserImplBase implements android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl, android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl {
        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final android.support.v4.media.MediaBrowserCompat.ConnectionCallback mCallback;
        android.os.Messenger mCallbacksMessenger;
        final android.content.Context mContext;
        private android.os.Bundle mExtras;
        private android.support.v4.media.session.MediaSessionCompat.Token mMediaSessionToken;
        private android.os.Bundle mNotifyChildrenChangedOptions;
        final android.os.Bundle mRootHints;
        private java.lang.String mRootId;
        android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
        final android.content.ComponentName mServiceComponent;
        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection mServiceConnection;
        final android.support.v4.media.MediaBrowserCompat.CallbackHandler mHandler = new android.support.v4.media.MediaBrowserCompat.CallbackHandler(this);
        private final androidx.collection.ArrayMap<java.lang.String, android.support.v4.media.MediaBrowserCompat.Subscription> mSubscriptions = new androidx.collection.ArrayMap<>();
        int mState = 1;

        public MediaBrowserImplBase(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
            if (context == null) {
                throw new java.lang.IllegalArgumentException("context must not be_renamed null");
            }
            if (componentName == null) {
                throw new java.lang.IllegalArgumentException("service component must not be_renamed null");
            }
            if (connectionCallback == null) {
                throw new java.lang.IllegalArgumentException("connection callback must not be_renamed null");
            }
            this.mContext = context;
            this.mServiceComponent = componentName;
            this.mCallback = connectionCallback;
            this.mRootHints = bundle == null ? null : new android.os.Bundle(bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            int i_renamed = this.mState;
            if (i_renamed != 0 && i_renamed != 1) {
                throw new java.lang.IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + getStateLabel(this.mState) + ")");
            }
            this.mState = 2;
            this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.1
                @Override // java.lang.Runnable
                public void run() {
                    if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState == 0) {
                        return;
                    }
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState = 2;
                    if (android.support.v4.media.MediaBrowserCompat.DEBUG && android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection != null) {
                        throw new java.lang.RuntimeException("mServiceConnection should be_renamed null. Instead it is_renamed " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection);
                    }
                    if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper != null) {
                        throw new java.lang.RuntimeException("mServiceBinderWrapper should be_renamed null. Instead it is_renamed " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper);
                    }
                    if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger != null) {
                        throw new java.lang.RuntimeException("mCallbacksMessenger should be_renamed null. Instead it is_renamed " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
                    }
                    android.content.Intent intent = new android.content.Intent("android.media.browse.MediaBrowserService");
                    intent.setComponent(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                    mediaBrowserImplBase.mServiceConnection = mediaBrowserImplBase.new MediaServiceConnection();
                    boolean zBindService = false;
                    try {
                        zBindService = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mContext.bindService(intent, android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection, 1);
                    } catch (java.lang.Exception unused) {
                        android.util.Log.e_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Failed binding to service " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                    }
                    if (!zBindService) {
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.forceCloseConnection();
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                    }
                    if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                        android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "connect...");
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                    }
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.2
                @Override // java.lang.Runnable
                public void run() {
                    if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger != null) {
                        try {
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper.disconnect(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
                        } catch (android.os.RemoteException unused) {
                            android.util.Log.w_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "RemoteException during connect for " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                        }
                    }
                    int i_renamed = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState;
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.forceCloseConnection();
                    if (i_renamed != 0) {
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState = i_renamed;
                    }
                    if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                        android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "disconnect...");
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                    }
                }
            });
        }

        void forceCloseConnection() {
            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection mediaServiceConnection = this.mServiceConnection;
            if (mediaServiceConnection != null) {
                this.mContext.unbindService(mediaServiceConnection);
            }
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return this.mState == 3;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public android.content.ComponentName getServiceComponent() {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
            }
            return this.mServiceComponent;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public java.lang.String getRoot() {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
            }
            return this.mRootId;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public android.os.Bundle getExtras() {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
            }
            return this.mExtras;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
            }
            return this.mMediaSessionToken;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                subscription = new android.support.v4.media.MediaBrowserCompat.Subscription();
                this.mSubscriptions.put(str, subscription);
            }
            android.os.Bundle bundle2 = bundle == null ? null : new android.os.Bundle(bundle);
            subscription.putCallback(bundle2, subscriptionCallback);
            if (isConnected()) {
                try {
                    this.mServiceBinderWrapper.addSubscription(str, subscriptionCallback.mToken, bundle2, this.mCallbacksMessenger);
                } catch (android.os.RemoteException unused) {
                    android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "addSubscription failed with RemoteException parentId=" + str);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(java.lang.String str, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                return;
            }
            try {
                if (subscriptionCallback == null) {
                    if (isConnected()) {
                        this.mServiceBinderWrapper.removeSubscription(str, null, this.mCallbacksMessenger);
                    }
                } else {
                    java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks = subscription.getCallbacks();
                    java.util.List<android.os.Bundle> optionsList = subscription.getOptionsList();
                    for (int size = callbacks.size() - 1; size >= 0; size--) {
                        if (callbacks.get(size) == subscriptionCallback) {
                            if (isConnected()) {
                                this.mServiceBinderWrapper.removeSubscription(str, subscriptionCallback.mToken, this.mCallbacksMessenger);
                            }
                            callbacks.remove(size);
                            optionsList.remove(size);
                        }
                    }
                }
            } catch (android.os.RemoteException unused) {
                android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + str);
            }
            if (subscription.isEmpty() || subscriptionCallback == null) {
                this.mSubscriptions.remove(str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(final java.lang.String str, final android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback) {
            if (android.text.TextUtils.isEmpty(str)) {
                throw new java.lang.IllegalArgumentException("mediaId is_renamed empty");
            }
            if (itemCallback == null) {
                throw new java.lang.IllegalArgumentException("cb_renamed is_renamed null");
            }
            if (!isConnected()) {
                android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.3
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
                return;
            }
            try {
                this.mServiceBinderWrapper.getMediaItem(str, new android.support.v4.media.MediaBrowserCompat.ItemReceiver(str, itemCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException unused) {
                android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error getting media item: " + str);
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.4
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(final java.lang.String str, final android.os.Bundle bundle, final android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback) {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("search() called while not connected (state=" + getStateLabel(this.mState) + ")");
            }
            try {
                this.mServiceBinderWrapper.search(str, bundle, new android.support.v4.media.MediaBrowserCompat.SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error searching items with query: " + str, e_renamed);
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        searchCallback.onError(str, bundle);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(final java.lang.String str, final android.os.Bundle bundle, final android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback) {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("Cannot send a_renamed custom action (" + str + ") with extras " + bundle + " because the browser is_renamed not connected to the service.");
            }
            try {
                this.mServiceBinderWrapper.sendCustomAction(str, bundle, new android.support.v4.media.MediaBrowserCompat.CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error sending a_renamed custom action: action=" + str + ", extras=" + bundle, e_renamed);
                if (customActionCallback != null) {
                    this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.6
                        @Override // java.lang.Runnable
                        public void run() {
                            customActionCallback.onError(str, bundle, null);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(android.os.Messenger messenger, java.lang.String str, android.support.v4.media.session.MediaSessionCompat.Token token, android.os.Bundle bundle) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (isCurrent(messenger, "onConnect")) {
                if (this.mState != 2) {
                    android.util.Log.w_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
                    return;
                }
                this.mRootId = str;
                this.mMediaSessionToken = token;
                this.mExtras = bundle;
                this.mState = 3;
                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                    android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                    dump();
                }
                this.mCallback.onConnected();
                try {
                    for (java.util.Map.Entry<java.lang.String, android.support.v4.media.MediaBrowserCompat.Subscription> entry : this.mSubscriptions.entrySet()) {
                        java.lang.String key = entry.getKey();
                        android.support.v4.media.MediaBrowserCompat.Subscription value = entry.getValue();
                        java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks = value.getCallbacks();
                        java.util.List<android.os.Bundle> optionsList = value.getOptionsList();
                        for (int i_renamed = 0; i_renamed < callbacks.size(); i_renamed++) {
                            this.mServiceBinderWrapper.addSubscription(key, callbacks.get(i_renamed).mToken, optionsList.get(i_renamed), this.mCallbacksMessenger);
                        }
                    }
                } catch (android.os.RemoteException unused) {
                    android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "addSubscription failed with RemoteException.");
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(android.os.Messenger messenger) {
            android.util.Log.e_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "onConnectFailed for " + this.mServiceComponent);
            if (isCurrent(messenger, "onConnectFailed")) {
                if (this.mState != 2) {
                    android.util.Log.w_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
                    return;
                }
                forceCloseConnection();
                this.mCallback.onConnectionFailed();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(android.os.Messenger messenger, java.lang.String str, java.util.List list, android.os.Bundle bundle, android.os.Bundle bundle2) {
            if (isCurrent(messenger, "onLoadChildren")) {
                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                    android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "onLoadChildren for " + this.mServiceComponent + " id_renamed=" + str);
                }
                android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
                if (subscription == null) {
                    if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                        android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "onLoadChildren for id_renamed that isn't_renamed subscribed id_renamed=" + str);
                        return;
                    }
                    return;
                }
                android.support.v4.media.MediaBrowserCompat.SubscriptionCallback callback = subscription.getCallback(bundle);
                if (callback != null) {
                    if (bundle == null) {
                        if (list == null) {
                            callback.onError(str);
                            return;
                        }
                        this.mNotifyChildrenChangedOptions = bundle2;
                        callback.onChildrenLoaded(str, list);
                        this.mNotifyChildrenChangedOptions = null;
                        return;
                    }
                    if (list == null) {
                        callback.onError(str, bundle);
                        return;
                    }
                    this.mNotifyChildrenChangedOptions = bundle2;
                    callback.onChildrenLoaded(str, list, bundle);
                    this.mNotifyChildrenChangedOptions = null;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public android.os.Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        private static java.lang.String getStateLabel(int i_renamed) {
            if (i_renamed == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (i_renamed == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (i_renamed == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (i_renamed == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (i_renamed == 4) {
                return "CONNECT_STATE_SUSPENDED";
            }
            return "UNKNOWN/" + i_renamed;
        }

        private boolean isCurrent(android.os.Messenger messenger, java.lang.String str) {
            int i_renamed;
            if (this.mCallbacksMessenger == messenger && (i_renamed = this.mState) != 0 && i_renamed != 1) {
                return true;
            }
            int i2 = this.mState;
            if (i2 == 0 || i2 == 1) {
                return false;
            }
            android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, str + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
            return false;
        }

        void dump() {
            android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "MediaBrowserCompat...");
            android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "  mServiceComponent=" + this.mServiceComponent);
            android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "  mCallback=" + this.mCallback);
            android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "  mRootHints=" + this.mRootHints);
            android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "  mState=" + getStateLabel(this.mState));
            android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "  mServiceConnection=" + this.mServiceConnection);
            android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
            android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "  mCallbacksMessenger=" + this.mCallbacksMessenger);
            android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "  mRootId=" + this.mRootId);
            android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "  mMediaSessionToken=" + this.mMediaSessionToken);
        }

        private class MediaServiceConnection implements android.content.ServiceConnection {
            MediaServiceConnection() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final android.content.ComponentName componentName, final android.os.IBinder iBinder) {
                postOrRun(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                            android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "MediaServiceConnection.onServiceConnected name=" + componentName + " binder=" + iBinder);
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                        }
                        if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper = new android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper(iBinder, android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mRootHints);
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger = new android.os.Messenger(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mHandler);
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState = 2;
                            try {
                                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                                    android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                                }
                                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper.connect(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mContext, android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
                            } catch (android.os.RemoteException unused) {
                                android.util.Log.w_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "RemoteException during connect for " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                                    android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                                }
                            }
                        }
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final android.content.ComponentName componentName) {
                postOrRun(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                            android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "MediaServiceConnection.onServiceDisconnected name=" + componentName + " this=" + this + " mServiceConnection=" + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection);
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                        }
                        if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper = null;
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger = null;
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(null);
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState = 4;
                            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallback.onConnectionSuspended();
                        }
                    }
                });
            }

            private void postOrRun(java.lang.Runnable runnable) {
                if (java.lang.Thread.currentThread() == android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
                    runnable.run();
                } else {
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.post(runnable);
                }
            }

            boolean isCurrent(java.lang.String str) {
                if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection == this && android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState != 0 && android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState != 1) {
                    return true;
                }
                if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState == 0 || android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState == 1) {
                    return false;
                }
                android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, str + " for " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent + " with mServiceConnection=" + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection + " this=" + this);
                return false;
            }
        }
    }

    static class MediaBrowserImplApi21 implements android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl, android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl {
        protected final java.lang.Object mBrowserObj;
        protected android.os.Messenger mCallbacksMessenger;
        final android.content.Context mContext;
        private android.support.v4.media.session.MediaSessionCompat.Token mMediaSessionToken;
        private android.os.Bundle mNotifyChildrenChangedOptions;
        protected final android.os.Bundle mRootHints;
        protected android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
        protected int mServiceVersion;
        protected final android.support.v4.media.MediaBrowserCompat.CallbackHandler mHandler = new android.support.v4.media.MediaBrowserCompat.CallbackHandler(this);
        private final androidx.collection.ArrayMap<java.lang.String, android.support.v4.media.MediaBrowserCompat.Subscription> mSubscriptions = new androidx.collection.ArrayMap<>();

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(android.os.Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(android.os.Messenger messenger, java.lang.String str, android.support.v4.media.session.MediaSessionCompat.Token token, android.os.Bundle bundle) {
        }

        MediaBrowserImplApi21(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
            this.mContext = context;
            this.mRootHints = bundle != null ? new android.os.Bundle(bundle) : new android.os.Bundle();
            this.mRootHints.putInt("extra_client_version", 1);
            connectionCallback.setInternalConnectionCallback(this);
            this.mBrowserObj = android.support.v4.media.MediaBrowserCompatApi21.createBrowser(context, componentName, connectionCallback.mConnectionCallbackObj, this.mRootHints);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            android.support.v4.media.MediaBrowserCompatApi21.connect(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            android.os.Messenger messenger;
            android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper != null && (messenger = this.mCallbacksMessenger) != null) {
                try {
                    serviceBinderWrapper.unregisterCallbackMessenger(messenger);
                } catch (android.os.RemoteException unused) {
                    android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error unregistering client messenger.");
                }
            }
            android.support.v4.media.MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return android.support.v4.media.MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public android.content.ComponentName getServiceComponent() {
            return android.support.v4.media.MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public java.lang.String getRoot() {
            return android.support.v4.media.MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public android.os.Bundle getExtras() {
            return android.support.v4.media.MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
            if (this.mMediaSessionToken == null) {
                this.mMediaSessionToken = android.support.v4.media.session.MediaSessionCompat.Token.fromToken(android.support.v4.media.MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
            }
            return this.mMediaSessionToken;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                subscription = new android.support.v4.media.MediaBrowserCompat.Subscription();
                this.mSubscriptions.put(str, subscription);
            }
            subscriptionCallback.setSubscription(subscription);
            android.os.Bundle bundle2 = bundle == null ? null : new android.os.Bundle(bundle);
            subscription.putCallback(bundle2, subscriptionCallback);
            android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper == null) {
                android.support.v4.media.MediaBrowserCompatApi21.subscribe(this.mBrowserObj, str, subscriptionCallback.mSubscriptionCallbackObj);
                return;
            }
            try {
                serviceBinderWrapper.addSubscription(str, subscriptionCallback.mToken, bundle2, this.mCallbacksMessenger);
            } catch (android.os.RemoteException unused) {
                android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error subscribing media item: " + str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(java.lang.String str, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                return;
            }
            android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper != null) {
                try {
                    if (subscriptionCallback == null) {
                        serviceBinderWrapper.removeSubscription(str, null, this.mCallbacksMessenger);
                    } else {
                        java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks = subscription.getCallbacks();
                        java.util.List<android.os.Bundle> optionsList = subscription.getOptionsList();
                        for (int size = callbacks.size() - 1; size >= 0; size--) {
                            if (callbacks.get(size) == subscriptionCallback) {
                                this.mServiceBinderWrapper.removeSubscription(str, subscriptionCallback.mToken, this.mCallbacksMessenger);
                                callbacks.remove(size);
                                optionsList.remove(size);
                            }
                        }
                    }
                } catch (android.os.RemoteException unused) {
                    android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + str);
                }
            } else if (subscriptionCallback == null) {
                android.support.v4.media.MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, str);
            } else {
                java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks2 = subscription.getCallbacks();
                java.util.List<android.os.Bundle> optionsList2 = subscription.getOptionsList();
                for (int size2 = callbacks2.size() - 1; size2 >= 0; size2--) {
                    if (callbacks2.get(size2) == subscriptionCallback) {
                        callbacks2.remove(size2);
                        optionsList2.remove(size2);
                    }
                }
                if (callbacks2.size() == 0) {
                    android.support.v4.media.MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, str);
                }
            }
            if (subscription.isEmpty() || subscriptionCallback == null) {
                this.mSubscriptions.remove(str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(final java.lang.String str, final android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback) {
            if (android.text.TextUtils.isEmpty(str)) {
                throw new java.lang.IllegalArgumentException("mediaId is_renamed empty");
            }
            if (itemCallback == null) {
                throw new java.lang.IllegalArgumentException("cb_renamed is_renamed null");
            }
            if (!android.support.v4.media.MediaBrowserCompatApi21.isConnected(this.mBrowserObj)) {
                android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
                return;
            }
            if (this.mServiceBinderWrapper == null) {
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.2
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
                return;
            }
            try {
                this.mServiceBinderWrapper.getMediaItem(str, new android.support.v4.media.MediaBrowserCompat.ItemReceiver(str, itemCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException unused) {
                android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error getting media item: " + str);
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.3
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(final java.lang.String str, final android.os.Bundle bundle, final android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback) {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("search() called while not connected");
            }
            if (this.mServiceBinderWrapper == null) {
                android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "The connected service doesn't_renamed support search.");
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.4
                    @Override // java.lang.Runnable
                    public void run() {
                        searchCallback.onError(str, bundle);
                    }
                });
                return;
            }
            try {
                this.mServiceBinderWrapper.search(str, bundle, new android.support.v4.media.MediaBrowserCompat.SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error searching items with query: " + str, e_renamed);
                this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.5
                    @Override // java.lang.Runnable
                    public void run() {
                        searchCallback.onError(str, bundle);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(final java.lang.String str, final android.os.Bundle bundle, final android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback) {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("Cannot send a_renamed custom action (" + str + ") with extras " + bundle + " because the browser is_renamed not connected to the service.");
            }
            if (this.mServiceBinderWrapper == null) {
                android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "The connected service doesn't_renamed support sendCustomAction.");
                if (customActionCallback != null) {
                    this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.6
                        @Override // java.lang.Runnable
                        public void run() {
                            customActionCallback.onError(str, bundle, null);
                        }
                    });
                }
            }
            try {
                this.mServiceBinderWrapper.sendCustomAction(str, bundle, new android.support.v4.media.MediaBrowserCompat.CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error sending a_renamed custom action: action=" + str + ", extras=" + bundle, e_renamed);
                if (customActionCallback != null) {
                    this.mHandler.post(new java.lang.Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.7
                        @Override // java.lang.Runnable
                        public void run() {
                            customActionCallback.onError(str, bundle, null);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnected() {
            android.os.Bundle extras = android.support.v4.media.MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
            if (extras == null) {
                return;
            }
            this.mServiceVersion = extras.getInt("extra_service_version", 0);
            android.os.IBinder iBinderA = androidx.core.app.d_renamed.a_renamed(extras, "extra_messenger");
            if (iBinderA != null) {
                this.mServiceBinderWrapper = new android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper(iBinderA, this.mRootHints);
                this.mCallbacksMessenger = new android.os.Messenger(this.mHandler);
                this.mHandler.setCallbacksMessenger(this.mCallbacksMessenger);
                try {
                    this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);
                } catch (android.os.RemoteException unused) {
                    android.util.Log.i_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Remote error registering client messenger.");
                }
            }
            android.support.v4.media.session.IMediaSession iMediaSessionAsInterface = android.support.v4.media.session.IMediaSession.Stub.asInterface(androidx.core.app.d_renamed.a_renamed(extras, "extra_session_binder"));
            if (iMediaSessionAsInterface != null) {
                this.mMediaSessionToken = android.support.v4.media.session.MediaSessionCompat.Token.fromToken(android.support.v4.media.MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj), iMediaSessionAsInterface);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(android.os.Messenger messenger, java.lang.String str, java.util.List list, android.os.Bundle bundle, android.os.Bundle bundle2) {
            if (this.mCallbacksMessenger != messenger) {
                return;
            }
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                    android.util.Log.d_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "onLoadChildren for id_renamed that isn't_renamed subscribed id_renamed=" + str);
                    return;
                }
                return;
            }
            android.support.v4.media.MediaBrowserCompat.SubscriptionCallback callback = subscription.getCallback(bundle);
            if (callback != null) {
                if (bundle == null) {
                    if (list == null) {
                        callback.onError(str);
                        return;
                    }
                    this.mNotifyChildrenChangedOptions = bundle2;
                    callback.onChildrenLoaded(str, list);
                    this.mNotifyChildrenChangedOptions = null;
                    return;
                }
                if (list == null) {
                    callback.onError(str, bundle);
                    return;
                }
                this.mNotifyChildrenChangedOptions = bundle2;
                callback.onChildrenLoaded(str, list, bundle);
                this.mNotifyChildrenChangedOptions = null;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public android.os.Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }
    }

    static class MediaBrowserImplApi23 extends android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21 {
        MediaBrowserImplApi23(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(java.lang.String str, android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback) {
            if (this.mServiceBinderWrapper == null) {
                android.support.v4.media.MediaBrowserCompatApi23.getItem(this.mBrowserObj, str, itemCallback.mItemCallbackObj);
            } else {
                super.getItem(str, itemCallback);
            }
        }
    }

    static class MediaBrowserImplApi26 extends android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi23 {
        MediaBrowserImplApi26(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                super.subscribe(str, bundle, subscriptionCallback);
            } else if (bundle == null) {
                android.support.v4.media.MediaBrowserCompatApi21.subscribe(this.mBrowserObj, str, subscriptionCallback.mSubscriptionCallbackObj);
            } else {
                android.support.v4.media.MediaBrowserCompatApi26.subscribe(this.mBrowserObj, str, bundle, subscriptionCallback.mSubscriptionCallbackObj);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(java.lang.String str, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                super.unsubscribe(str, subscriptionCallback);
            } else if (subscriptionCallback == null) {
                android.support.v4.media.MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, str);
            } else {
                android.support.v4.media.MediaBrowserCompatApi26.unsubscribe(this.mBrowserObj, str, subscriptionCallback.mSubscriptionCallbackObj);
            }
        }
    }

    private static class Subscription {
        private final java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> mCallbacks = new java.util.ArrayList();
        private final java.util.List<android.os.Bundle> mOptionsList = new java.util.ArrayList();

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public java.util.List<android.os.Bundle> getOptionsList() {
            return this.mOptionsList;
        }

        public java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public android.support.v4.media.MediaBrowserCompat.SubscriptionCallback getCallback(android.os.Bundle bundle) {
            for (int i_renamed = 0; i_renamed < this.mOptionsList.size(); i_renamed++) {
                if (androidx.media.d_renamed.a_renamed(this.mOptionsList.get(i_renamed), bundle)) {
                    return this.mCallbacks.get(i_renamed);
                }
            }
            return null;
        }

        public void putCallback(android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            for (int i_renamed = 0; i_renamed < this.mOptionsList.size(); i_renamed++) {
                if (androidx.media.d_renamed.a_renamed(this.mOptionsList.get(i_renamed), bundle)) {
                    this.mCallbacks.set(i_renamed, subscriptionCallback);
                    return;
                }
            }
            this.mCallbacks.add(subscriptionCallback);
            this.mOptionsList.add(bundle);
        }
    }

    private static class CallbackHandler extends android.os.Handler {
        private final java.lang.ref.WeakReference<android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl> mCallbackImplRef;
        private java.lang.ref.WeakReference<android.os.Messenger> mCallbacksMessengerRef;

        CallbackHandler(android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.mCallbackImplRef = new java.lang.ref.WeakReference<>(mediaBrowserServiceCallbackImpl);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            java.lang.ref.WeakReference<android.os.Messenger> weakReference = this.mCallbacksMessengerRef;
            if (weakReference == null || weakReference.get() == null || this.mCallbackImplRef.get() == null) {
                return;
            }
            android.os.Bundle data = message.getData();
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(data);
            android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = this.mCallbackImplRef.get();
            android.os.Messenger messenger = this.mCallbacksMessengerRef.get();
            try {
                int i_renamed = message.what;
                if (i_renamed == 1) {
                    android.os.Bundle bundle = data.getBundle("data_root_hints");
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
                    mediaBrowserServiceCallbackImpl.onServiceConnected(messenger, data.getString("data_media_item_id"), (android.support.v4.media.session.MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), bundle);
                } else if (i_renamed == 2) {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                } else if (i_renamed == 3) {
                    android.os.Bundle bundle2 = data.getBundle("data_options");
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle2);
                    android.os.Bundle bundle3 = data.getBundle("data_notify_children_changed_options");
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle3);
                    mediaBrowserServiceCallbackImpl.onLoadChildren(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), bundle2, bundle3);
                } else {
                    android.util.Log.w_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Unhandled message: " + message + "\n_renamed  Client version: 1\n_renamed  Service version: " + message.arg1);
                }
            } catch (android.os.BadParcelableException unused) {
                android.util.Log.e_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Could not unparcel the data.");
                if (message.what == 1) {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                }
            }
        }

        void setCallbacksMessenger(android.os.Messenger messenger) {
            this.mCallbacksMessengerRef = new java.lang.ref.WeakReference<>(messenger);
        }
    }

    private static class ServiceBinderWrapper {
        private android.os.Messenger mMessenger;
        private android.os.Bundle mRootHints;

        public ServiceBinderWrapper(android.os.IBinder iBinder, android.os.Bundle bundle) {
            this.mMessenger = new android.os.Messenger(iBinder);
            this.mRootHints = bundle;
        }

        void connect(android.content.Context context, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.mRootHints);
            sendRequest(1, bundle, messenger);
        }

        void disconnect(android.os.Messenger messenger) throws android.os.RemoteException {
            sendRequest(2, null, messenger);
        }

        void addSubscription(java.lang.String str, android.os.IBinder iBinder, android.os.Bundle bundle, android.os.Messenger messenger) throws java.lang.IllegalAccessException, android.os.RemoteException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString("data_media_item_id", str);
            androidx.core.app.d_renamed.a_renamed(bundle2, "data_callback_token", iBinder);
            bundle2.putBundle("data_options", bundle);
            sendRequest(3, bundle2, messenger);
        }

        void removeSubscription(java.lang.String str, android.os.IBinder iBinder, android.os.Messenger messenger) throws java.lang.IllegalAccessException, android.os.RemoteException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("data_media_item_id", str);
            androidx.core.app.d_renamed.a_renamed(bundle, "data_callback_token", iBinder);
            sendRequest(4, bundle, messenger);
        }

        void getMediaItem(java.lang.String str, android.support.v4.os.ResultReceiver resultReceiver, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("data_media_item_id", str);
            bundle.putParcelable("data_result_receiver", resultReceiver);
            sendRequest(5, bundle, messenger);
        }

        void registerCallbackMessenger(android.content.Context context, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.mRootHints);
            sendRequest(6, bundle, messenger);
        }

        void unregisterCallbackMessenger(android.os.Messenger messenger) throws android.os.RemoteException {
            sendRequest(7, null, messenger);
        }

        void search(java.lang.String str, android.os.Bundle bundle, android.support.v4.os.ResultReceiver resultReceiver, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString("data_search_query", str);
            bundle2.putBundle("data_search_extras", bundle);
            bundle2.putParcelable("data_result_receiver", resultReceiver);
            sendRequest(8, bundle2, messenger);
        }

        void sendCustomAction(java.lang.String str, android.os.Bundle bundle, android.support.v4.os.ResultReceiver resultReceiver, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString("data_custom_action", str);
            bundle2.putBundle("data_custom_action_extras", bundle);
            bundle2.putParcelable("data_result_receiver", resultReceiver);
            sendRequest(9, bundle2, messenger);
        }

        private void sendRequest(int i_renamed, android.os.Bundle bundle, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = i_renamed;
            messageObtain.arg1 = 1;
            messageObtain.setData(bundle);
            messageObtain.replyTo = messenger;
            this.mMessenger.send(messageObtain);
        }
    }

    private static class ItemReceiver extends android.support.v4.os.ResultReceiver {
        private final android.support.v4.media.MediaBrowserCompat.ItemCallback mCallback;
        private final java.lang.String mMediaId;

        ItemReceiver(java.lang.String str, android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback, android.os.Handler handler) {
            super(handler);
            this.mMediaId = str;
            this.mCallback = itemCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int i_renamed, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            if (i_renamed != 0 || bundle == null || !bundle.containsKey("media_item")) {
                this.mCallback.onError(this.mMediaId);
                return;
            }
            android.os.Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable == null || (parcelable instanceof android.support.v4.media.MediaBrowserCompat.MediaItem)) {
                this.mCallback.onItemLoaded((android.support.v4.media.MediaBrowserCompat.MediaItem) parcelable);
            } else {
                this.mCallback.onError(this.mMediaId);
            }
        }
    }

    private static class SearchResultReceiver extends android.support.v4.os.ResultReceiver {
        private final android.support.v4.media.MediaBrowserCompat.SearchCallback mCallback;
        private final android.os.Bundle mExtras;
        private final java.lang.String mQuery;

        SearchResultReceiver(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback, android.os.Handler handler) {
            super(handler);
            this.mQuery = str;
            this.mExtras = bundle;
            this.mCallback = searchCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int i_renamed, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            if (i_renamed != 0 || bundle == null || !bundle.containsKey("search_results")) {
                this.mCallback.onError(this.mQuery, this.mExtras);
                return;
            }
            android.os.Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            java.util.ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new java.util.ArrayList();
                for (android.os.Parcelable parcelable : parcelableArray) {
                    arrayList.add((android.support.v4.media.MediaBrowserCompat.MediaItem) parcelable);
                }
            }
            this.mCallback.onSearchResult(this.mQuery, this.mExtras, arrayList);
        }
    }

    private static class CustomActionResultReceiver extends android.support.v4.os.ResultReceiver {
        private final java.lang.String mAction;
        private final android.support.v4.media.MediaBrowserCompat.CustomActionCallback mCallback;
        private final android.os.Bundle mExtras;

        CustomActionResultReceiver(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback, android.os.Handler handler) {
            super(handler);
            this.mAction = str;
            this.mExtras = bundle;
            this.mCallback = customActionCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int i_renamed, android.os.Bundle bundle) {
            if (this.mCallback == null) {
                return;
            }
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            if (i_renamed == -1) {
                this.mCallback.onError(this.mAction, this.mExtras, bundle);
                return;
            }
            if (i_renamed == 0) {
                this.mCallback.onResult(this.mAction, this.mExtras, bundle);
                return;
            }
            if (i_renamed == 1) {
                this.mCallback.onProgressUpdate(this.mAction, this.mExtras, bundle);
                return;
            }
            android.util.Log.w_renamed(android.support.v4.media.MediaBrowserCompat.TAG, "Unknown result code: " + i_renamed + " (extras=" + this.mExtras + ", resultData=" + bundle + ")");
        }
    }
}

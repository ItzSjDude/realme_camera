package android.support.v4.media;

/* loaded from: classes.dex */
class MediaBrowserCompatApi21 {
    static final java.lang.String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";

    interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    interface SubscriptionCallback {
        void onChildrenLoaded(java.lang.String str, java.util.List<?> list);

        void onError(java.lang.String str);
    }

    public static java.lang.Object createConnectionCallback(android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback connectionCallback) {
        return new android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallbackProxy(connectionCallback);
    }

    public static java.lang.Object createBrowser(android.content.Context context, android.content.ComponentName componentName, java.lang.Object obj, android.os.Bundle bundle) {
        return new android.media.browse.MediaBrowser(context, componentName, (android.media.browse.MediaBrowser.ConnectionCallback) obj, bundle);
    }

    public static void connect(java.lang.Object obj) {
        ((android.media.browse.MediaBrowser) obj).connect();
    }

    public static void disconnect(java.lang.Object obj) {
        ((android.media.browse.MediaBrowser) obj).disconnect();
    }

    public static boolean isConnected(java.lang.Object obj) {
        return ((android.media.browse.MediaBrowser) obj).isConnected();
    }

    public static android.content.ComponentName getServiceComponent(java.lang.Object obj) {
        return ((android.media.browse.MediaBrowser) obj).getServiceComponent();
    }

    public static java.lang.String getRoot(java.lang.Object obj) {
        return ((android.media.browse.MediaBrowser) obj).getRoot();
    }

    public static android.os.Bundle getExtras(java.lang.Object obj) {
        return ((android.media.browse.MediaBrowser) obj).getExtras();
    }

    public static java.lang.Object getSessionToken(java.lang.Object obj) {
        return ((android.media.browse.MediaBrowser) obj).getSessionToken();
    }

    public static java.lang.Object createSubscriptionCallback(android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback subscriptionCallback) {
        return new android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallbackProxy(subscriptionCallback);
    }

    public static void subscribe(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        ((android.media.browse.MediaBrowser) obj).subscribe(str, (android.media.browse.MediaBrowser.SubscriptionCallback) obj2);
    }

    public static void unsubscribe(java.lang.Object obj, java.lang.String str) {
        ((android.media.browse.MediaBrowser) obj).unsubscribe(str);
    }

    static class ConnectionCallbackProxy<T_renamed extends android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback> extends android.media.browse.MediaBrowser.ConnectionCallback {
        protected final T_renamed mConnectionCallback;

        public ConnectionCallbackProxy(T_renamed t_renamed) {
            this.mConnectionCallback = t_renamed;
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.mConnectionCallback.onConnected();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.mConnectionCallback.onConnectionSuspended();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.mConnectionCallback.onConnectionFailed();
        }
    }

    static class SubscriptionCallbackProxy<T_renamed extends android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback> extends android.media.browse.MediaBrowser.SubscriptionCallback {
        protected final T_renamed mSubscriptionCallback;

        public SubscriptionCallbackProxy(T_renamed t_renamed) {
            this.mSubscriptionCallback = t_renamed;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(java.lang.String str, java.util.List<android.media.browse.MediaBrowser.MediaItem> list) {
            this.mSubscriptionCallback.onChildrenLoaded(str, list);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(java.lang.String str) {
            this.mSubscriptionCallback.onError(str);
        }
    }

    static class MediaItem {
        public static int getFlags(java.lang.Object obj) {
            return ((android.media.browse.MediaBrowser.MediaItem) obj).getFlags();
        }

        public static java.lang.Object getDescription(java.lang.Object obj) {
            return ((android.media.browse.MediaBrowser.MediaItem) obj).getDescription();
        }

        private MediaItem() {
        }
    }

    private MediaBrowserCompatApi21() {
    }
}

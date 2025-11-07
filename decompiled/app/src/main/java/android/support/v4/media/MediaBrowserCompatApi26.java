package android.support.v4.media;

/* loaded from: classes.dex */
class MediaBrowserCompatApi26 {

    interface SubscriptionCallback extends android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback {
        void onChildrenLoaded(java.lang.String str, java.util.List<?> list, android.os.Bundle bundle);

        void onError(java.lang.String str, android.os.Bundle bundle);
    }

    static java.lang.Object createSubscriptionCallback(android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback subscriptionCallback) {
        return new android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallbackProxy(subscriptionCallback);
    }

    public static void subscribe(java.lang.Object obj, java.lang.String str, android.os.Bundle bundle, java.lang.Object obj2) {
        ((android.media.browse.MediaBrowser) obj).subscribe(str, bundle, (android.media.browse.MediaBrowser.SubscriptionCallback) obj2);
    }

    public static void unsubscribe(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        ((android.media.browse.MediaBrowser) obj).unsubscribe(str, (android.media.browse.MediaBrowser.SubscriptionCallback) obj2);
    }

    static class SubscriptionCallbackProxy<T_renamed extends android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback> extends android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallbackProxy<T_renamed> {
        SubscriptionCallbackProxy(T_renamed t_renamed) {
            super(t_renamed);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(java.lang.String str, java.util.List<android.media.browse.MediaBrowser.MediaItem> list, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            ((android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback) this.mSubscriptionCallback).onChildrenLoaded(str, list, bundle);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(java.lang.String str, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            ((android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback) this.mSubscriptionCallback).onError(str, bundle);
        }
    }

    private MediaBrowserCompatApi26() {
    }
}

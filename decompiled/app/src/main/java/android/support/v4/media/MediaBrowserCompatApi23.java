package android.support.v4.media;

/* loaded from: classes.dex */
class MediaBrowserCompatApi23 {

    interface ItemCallback {
        void onError(java.lang.String str);

        void onItemLoaded(android.os.Parcel parcel);
    }

    public static java.lang.Object createItemCallback(android.support.v4.media.MediaBrowserCompatApi23.ItemCallback itemCallback) {
        return new android.support.v4.media.MediaBrowserCompatApi23.ItemCallbackProxy(itemCallback);
    }

    public static void getItem(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        ((android.media.browse.MediaBrowser) obj).getItem(str, (android.media.browse.MediaBrowser.ItemCallback) obj2);
    }

    static class ItemCallbackProxy<T_renamed extends android.support.v4.media.MediaBrowserCompatApi23.ItemCallback> extends android.media.browse.MediaBrowser.ItemCallback {
        protected final T_renamed mItemCallback;

        public ItemCallbackProxy(T_renamed t_renamed) {
            this.mItemCallback = t_renamed;
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onItemLoaded(android.media.browse.MediaBrowser.MediaItem mediaItem) {
            if (mediaItem == null) {
                this.mItemCallback.onItemLoaded(null);
                return;
            }
            android.os.Parcel parcelObtain = android.os.Parcel.obtain();
            mediaItem.writeToParcel(parcelObtain, 0);
            this.mItemCallback.onItemLoaded(parcelObtain);
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onError(java.lang.String str) {
            this.mItemCallback.onError(str);
        }
    }

    private MediaBrowserCompatApi23() {
    }
}

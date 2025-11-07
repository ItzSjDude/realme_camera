package androidx.media;

/* compiled from: MediaBrowserCompatUtils.java */
/* loaded from: classes.dex */
public class d_renamed {
    public static boolean a_renamed(android.os.Bundle bundle, android.os.Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        return bundle == null ? bundle2.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle2.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1 : bundle2 == null ? bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1 : bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE, -1) == bundle2.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE, -1) && bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == bundle2.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
    }
}

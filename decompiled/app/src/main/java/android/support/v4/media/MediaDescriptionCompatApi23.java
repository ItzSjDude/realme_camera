package android.support.v4.media;

/* loaded from: classes.dex */
class MediaDescriptionCompatApi23 {
    public static android.net.Uri getMediaUri(java.lang.Object obj) {
        return ((android.media.MediaDescription) obj).getMediaUri();
    }

    static class Builder {
        public static void setMediaUri(java.lang.Object obj, android.net.Uri uri) {
            ((android.media.MediaDescription.Builder) obj).setMediaUri(uri);
        }

        private Builder() {
        }
    }

    private MediaDescriptionCompatApi23() {
    }
}

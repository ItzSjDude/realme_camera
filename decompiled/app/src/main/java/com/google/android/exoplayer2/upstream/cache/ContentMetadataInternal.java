package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
final class ContentMetadataInternal {
    private static final java.lang.String METADATA_NAME_CONTENT_LENGTH = "exo_len";
    private static final java.lang.String METADATA_NAME_REDIRECTED_URI = "exo_redir";
    private static final java.lang.String PREFIX = "exo_";

    public static long getContentLength(com.google.android.exoplayer2.upstream.cache.ContentMetadata contentMetadata) {
        return contentMetadata.get(METADATA_NAME_CONTENT_LENGTH, -1L);
    }

    public static void setContentLength(com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations, long j_renamed) {
        contentMetadataMutations.set(METADATA_NAME_CONTENT_LENGTH, j_renamed);
    }

    public static void removeContentLength(com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations) {
        contentMetadataMutations.remove(METADATA_NAME_CONTENT_LENGTH);
    }

    public static android.net.Uri getRedirectedUri(com.google.android.exoplayer2.upstream.cache.ContentMetadata contentMetadata) {
        java.lang.String str = contentMetadata.get(METADATA_NAME_REDIRECTED_URI, (java.lang.String) null);
        if (str == null) {
            return null;
        }
        return android.net.Uri.parse(str);
    }

    public static void setRedirectedUri(com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations, android.net.Uri uri) {
        contentMetadataMutations.set(METADATA_NAME_REDIRECTED_URI, uri.toString());
    }

    public static void removeRedirectedUri(com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations) {
        contentMetadataMutations.remove(METADATA_NAME_REDIRECTED_URI);
    }

    private ContentMetadataInternal() {
    }
}

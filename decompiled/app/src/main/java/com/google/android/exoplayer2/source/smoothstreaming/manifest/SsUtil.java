package com.google.android.exoplayer2.source.smoothstreaming.manifest;

/* loaded from: classes.dex */
public final class SsUtil {
    public static android.net.Uri fixManifestUri(android.net.Uri uri) {
        return com.google.android.exoplayer2.util.Util.toLowerInvariant(uri.getLastPathSegment()).matches("manifest(\\(.+\\))?") ? uri : android.net.Uri.withAppendedPath(uri, "Manifest");
    }

    private SsUtil() {
    }
}

package com.google.android.exoplayer2.source.hls.offline;

/* loaded from: classes.dex */
public final class HlsDownloader extends com.google.android.exoplayer2.offline.SegmentDownloader<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> {
    public HlsDownloader(android.net.Uri uri, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list, com.google.android.exoplayer2.offline.DownloaderConstructorHelper downloaderConstructorHelper) {
        super(uri, list, downloaderConstructorHelper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist getManifest(com.google.android.exoplayer2.upstream.DataSource dataSource, android.net.Uri uri) throws java.io.IOException {
        return loadManifest(dataSource, uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public java.util.List<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> getSegments(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist hlsPlaylist, boolean z_renamed) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (hlsPlaylist instanceof com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist) {
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist = (com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist) hlsPlaylist;
            addResolvedUris(hlsMasterPlaylist.baseUri, hlsMasterPlaylist.variants, arrayList);
            addResolvedUris(hlsMasterPlaylist.baseUri, hlsMasterPlaylist.audios, arrayList);
            addResolvedUris(hlsMasterPlaylist.baseUri, hlsMasterPlaylist.subtitles, arrayList);
        } else {
            arrayList.add(android.net.Uri.parse(hlsPlaylist.baseUri));
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            android.net.Uri uri = (android.net.Uri) it.next();
            try {
                com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist = (com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist) loadManifest(dataSource, uri);
                arrayList2.add(new com.google.android.exoplayer2.offline.SegmentDownloader.Segment(hlsMediaPlaylist.startTimeUs, new com.google.android.exoplayer2.upstream.DataSpec(uri)));
                com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment = null;
                java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
                for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
                    com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment2 = list.get(i_renamed);
                    com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment3 = segment2.initializationSegment;
                    if (segment3 != null && segment3 != segment) {
                        addSegment(arrayList2, hlsMediaPlaylist, segment3, hashSet);
                        segment = segment3;
                    }
                    addSegment(arrayList2, hlsMediaPlaylist, segment2, hashSet);
                }
            } catch (java.io.IOException e_renamed) {
                if (!z_renamed) {
                    throw e_renamed;
                }
                arrayList2.add(new com.google.android.exoplayer2.offline.SegmentDownloader.Segment(0L, new com.google.android.exoplayer2.upstream.DataSpec(uri)));
            }
        }
        return arrayList2;
    }

    private static com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist loadManifest(com.google.android.exoplayer2.upstream.DataSource dataSource, android.net.Uri uri) throws java.io.IOException {
        return (com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist) com.google.android.exoplayer2.upstream.ParsingLoadable.load(dataSource, new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser(), uri, 4);
    }

    private static void addSegment(java.util.ArrayList<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> arrayList, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment, java.util.HashSet<android.net.Uri> hashSet) {
        long j_renamed = hlsMediaPlaylist.startTimeUs + segment.relativeStartTimeUs;
        if (segment.fullSegmentEncryptionKeyUri != null) {
            android.net.Uri uriResolveToUri = com.google.android.exoplayer2.util.UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.fullSegmentEncryptionKeyUri);
            if (hashSet.add(uriResolveToUri)) {
                arrayList.add(new com.google.android.exoplayer2.offline.SegmentDownloader.Segment(j_renamed, new com.google.android.exoplayer2.upstream.DataSpec(uriResolveToUri)));
            }
        }
        arrayList.add(new com.google.android.exoplayer2.offline.SegmentDownloader.Segment(j_renamed, new com.google.android.exoplayer2.upstream.DataSpec(com.google.android.exoplayer2.util.UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.url), segment.byterangeOffset, segment.byterangeLength, null)));
    }

    private static void addResolvedUris(java.lang.String str, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> list, java.util.List<android.net.Uri> list2) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            list2.add(com.google.android.exoplayer2.util.UriUtil.resolveToUri(str, list.get(i_renamed).url));
        }
    }
}

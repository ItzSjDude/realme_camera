package com.google.android.exoplayer2.source.hls.playlist;

/* loaded from: classes.dex */
public final class HlsMasterPlaylist extends com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist {
    public static final com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist EMPTY = new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist("", java.util.Collections.emptyList(), java.util.Collections.emptyList(), java.util.Collections.emptyList(), java.util.Collections.emptyList(), null, java.util.Collections.emptyList(), false, java.util.Collections.emptyMap());
    public static final int GROUP_INDEX_AUDIO = 1;
    public static final int GROUP_INDEX_SUBTITLE = 2;
    public static final int GROUP_INDEX_VARIANT = 0;
    public final java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> audios;
    public final com.google.android.exoplayer2.Format muxedAudioFormat;
    public final java.util.List<com.google.android.exoplayer2.Format> muxedCaptionFormats;
    public final java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> subtitles;
    public final java.util.Map<java.lang.String, java.lang.String> variableDefinitions;
    public final java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> variants;

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    /* renamed from: copy, reason: avoid collision after fix types in_renamed other method */
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist copy2(java.util.List list) {
        return copy((java.util.List<com.google.android.exoplayer2.offline.StreamKey>) list);
    }

    public static final class HlsUrl {
        public final com.google.android.exoplayer2.Format format;
        public final java.lang.String url;

        public static com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl createMediaPlaylistHlsUrl(java.lang.String str) {
            return new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl(str, com.google.android.exoplayer2.Format.createContainerFormat("0", null, com.google.android.exoplayer2.util.MimeTypes.APPLICATION_M3U8, null, null, -1, 0, null));
        }

        public HlsUrl(java.lang.String str, com.google.android.exoplayer2.Format format) {
            this.url = str;
            this.format = format;
        }
    }

    public HlsMasterPlaylist(java.lang.String str, java.util.List<java.lang.String> list, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> list2, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> list3, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> list4, com.google.android.exoplayer2.Format format, java.util.List<com.google.android.exoplayer2.Format> list5, boolean z_renamed, java.util.Map<java.lang.String, java.lang.String> map) {
        super(str, list, z_renamed);
        this.variants = java.util.Collections.unmodifiableList(list2);
        this.audios = java.util.Collections.unmodifiableList(list3);
        this.subtitles = java.util.Collections.unmodifiableList(list4);
        this.muxedAudioFormat = format;
        this.muxedCaptionFormats = list5 != null ? java.util.Collections.unmodifiableList(list5) : null;
        this.variableDefinitions = java.util.Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist copy(java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        return new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist(this.baseUri, this.tags, copyRenditionsList(this.variants, 0, list), copyRenditionsList(this.audios, 1, list), copyRenditionsList(this.subtitles, 2, list), this.muxedAudioFormat, this.muxedCaptionFormats, this.hasIndependentSegments, this.variableDefinitions);
    }

    public static com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist createSingleVariantMasterPlaylist(java.lang.String str) {
        java.util.List listSingletonList = java.util.Collections.singletonList(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl.createMediaPlaylistHlsUrl(str));
        java.util.List listEmptyList = java.util.Collections.emptyList();
        return new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist(null, java.util.Collections.emptyList(), listSingletonList, listEmptyList, listEmptyList, null, null, false, java.util.Collections.emptyMap());
    }

    private static java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> copyRenditionsList(java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> list, int i_renamed, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list2) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl = list.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 < list2.size()) {
                    com.google.android.exoplayer2.offline.StreamKey streamKey = list2.get(i3);
                    if (streamKey.groupIndex == i_renamed && streamKey.trackIndex == i2) {
                        arrayList.add(hlsUrl);
                        break;
                    }
                    i3++;
                }
            }
        }
        return arrayList;
    }
}

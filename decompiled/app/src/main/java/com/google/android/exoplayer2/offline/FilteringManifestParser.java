package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public final class FilteringManifestParser<T_renamed extends com.google.android.exoplayer2.offline.FilterableManifest<T_renamed>> implements com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<T_renamed> {
    private final com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<T_renamed> parser;
    private final java.util.List<com.google.android.exoplayer2.offline.StreamKey> streamKeys;

    public FilteringManifestParser(com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<T_renamed> parser, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        this.parser = parser;
        this.streamKeys = list;
    }

    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public T_renamed parse(android.net.Uri uri, java.io.InputStream inputStream) throws java.io.IOException {
        T_renamed t_renamed = this.parser.parse(uri, inputStream);
        java.util.List<com.google.android.exoplayer2.offline.StreamKey> list = this.streamKeys;
        return (list == null || list.isEmpty()) ? t_renamed : (T_renamed) t_renamed.copy(this.streamKeys);
    }
}

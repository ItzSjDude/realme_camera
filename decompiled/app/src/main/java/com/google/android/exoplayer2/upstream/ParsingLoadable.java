package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class ParsingLoadable<T_renamed> implements com.google.android.exoplayer2.upstream.Loader.Loadable {
    private final com.google.android.exoplayer2.upstream.StatsDataSource dataSource;
    public final com.google.android.exoplayer2.upstream.DataSpec dataSpec;
    private final com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends T_renamed> parser;
    private volatile T_renamed result;
    public final int type;

    public interface Parser<T_renamed> {
        T_renamed parse(android.net.Uri uri, java.io.InputStream inputStream) throws java.io.IOException;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
    }

    public static <T_renamed> T_renamed load(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends T_renamed> parser, android.net.Uri uri, int i_renamed) throws java.io.IOException {
        com.google.android.exoplayer2.upstream.ParsingLoadable parsingLoadable = new com.google.android.exoplayer2.upstream.ParsingLoadable(dataSource, uri, i_renamed, parser);
        parsingLoadable.load();
        return (T_renamed) com.google.android.exoplayer2.util.Assertions.checkNotNull(parsingLoadable.getResult());
    }

    public ParsingLoadable(com.google.android.exoplayer2.upstream.DataSource dataSource, android.net.Uri uri, int i_renamed, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends T_renamed> parser) {
        this(dataSource, new com.google.android.exoplayer2.upstream.DataSpec(uri, 3), i_renamed, parser);
    }

    public ParsingLoadable(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i_renamed, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends T_renamed> parser) {
        this.dataSource = new com.google.android.exoplayer2.upstream.StatsDataSource(dataSource);
        this.dataSpec = dataSpec;
        this.type = i_renamed;
        this.parser = parser;
    }

    public final T_renamed getResult() {
        return this.result;
    }

    public long bytesLoaded() {
        return this.dataSource.getBytesRead();
    }

    public android.net.Uri getUri() {
        return this.dataSource.getLastOpenedUri();
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        return this.dataSource.getLastResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws java.io.IOException {
        this.dataSource.resetBytesRead();
        com.google.android.exoplayer2.upstream.DataSourceInputStream dataSourceInputStream = new com.google.android.exoplayer2.upstream.DataSourceInputStream(this.dataSource, this.dataSpec);
        try {
            dataSourceInputStream.open();
            this.result = this.parser.parse((android.net.Uri) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.dataSource.getUri()), dataSourceInputStream);
        } finally {
            com.google.android.exoplayer2.util.Util.closeQuietly(dataSourceInputStream);
        }
    }
}

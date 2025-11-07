package com.google.android.exoplayer2.source.dash;

/* loaded from: classes.dex */
public final class DashUtil {
    public static com.google.android.exoplayer2.source.dash.manifest.DashManifest loadManifest(com.google.android.exoplayer2.upstream.DataSource dataSource, android.net.Uri uri) throws java.io.IOException {
        return (com.google.android.exoplayer2.source.dash.manifest.DashManifest) com.google.android.exoplayer2.upstream.ParsingLoadable.load(dataSource, new com.google.android.exoplayer2.source.dash.manifest.DashManifestParser(), uri, 4);
    }

    public static com.google.android.exoplayer2.drm.DrmInitData loadDrmInitData(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.source.dash.manifest.Period period) throws java.lang.InterruptedException, java.io.IOException {
        int i_renamed = 2;
        com.google.android.exoplayer2.source.dash.manifest.Representation firstRepresentation = getFirstRepresentation(period, 2);
        if (firstRepresentation == null) {
            i_renamed = 1;
            firstRepresentation = getFirstRepresentation(period, 1);
            if (firstRepresentation == null) {
                return null;
            }
        }
        com.google.android.exoplayer2.Format format = firstRepresentation.format;
        com.google.android.exoplayer2.Format formatLoadSampleFormat = loadSampleFormat(dataSource, i_renamed, firstRepresentation);
        if (formatLoadSampleFormat == null) {
            return format.drmInitData;
        }
        return formatLoadSampleFormat.copyWithManifestFormatInfo(format).drmInitData;
    }

    public static com.google.android.exoplayer2.Format loadSampleFormat(com.google.android.exoplayer2.upstream.DataSource dataSource, int i_renamed, com.google.android.exoplayer2.source.dash.manifest.Representation representation) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper chunkExtractorWrapperLoadInitializationData = loadInitializationData(dataSource, i_renamed, representation, false);
        if (chunkExtractorWrapperLoadInitializationData == null) {
            return null;
        }
        return chunkExtractorWrapperLoadInitializationData.getSampleFormats()[0];
    }

    public static com.google.android.exoplayer2.extractor.ChunkIndex loadChunkIndex(com.google.android.exoplayer2.upstream.DataSource dataSource, int i_renamed, com.google.android.exoplayer2.source.dash.manifest.Representation representation) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper chunkExtractorWrapperLoadInitializationData = loadInitializationData(dataSource, i_renamed, representation, true);
        if (chunkExtractorWrapperLoadInitializationData == null) {
            return null;
        }
        return (com.google.android.exoplayer2.extractor.ChunkIndex) chunkExtractorWrapperLoadInitializationData.getSeekMap();
    }

    private static com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper loadInitializationData(com.google.android.exoplayer2.upstream.DataSource dataSource, int i_renamed, com.google.android.exoplayer2.source.dash.manifest.Representation representation, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.source.dash.manifest.RangedUri initializationUri = representation.getInitializationUri();
        if (initializationUri == null) {
            return null;
        }
        com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper chunkExtractorWrapperNewWrappedExtractor = newWrappedExtractor(i_renamed, representation.format);
        if (z_renamed) {
            com.google.android.exoplayer2.source.dash.manifest.RangedUri indexUri = representation.getIndexUri();
            if (indexUri == null) {
                return null;
            }
            com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUriAttemptMerge = initializationUri.attemptMerge(indexUri, representation.baseUrl);
            if (rangedUriAttemptMerge == null) {
                loadInitializationData(dataSource, representation, chunkExtractorWrapperNewWrappedExtractor, initializationUri);
                initializationUri = indexUri;
            } else {
                initializationUri = rangedUriAttemptMerge;
            }
        }
        loadInitializationData(dataSource, representation, chunkExtractorWrapperNewWrappedExtractor, initializationUri);
        return chunkExtractorWrapperNewWrappedExtractor;
    }

    private static void loadInitializationData(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.source.dash.manifest.Representation representation, com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper chunkExtractorWrapper, com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri) throws java.lang.InterruptedException, java.io.IOException {
        new com.google.android.exoplayer2.source.chunk.InitializationChunk(dataSource, new com.google.android.exoplayer2.upstream.DataSpec(rangedUri.resolveUri(representation.baseUrl), rangedUri.start, rangedUri.length, representation.getCacheKey()), representation.format, 0, null, chunkExtractorWrapper).load();
    }

    private static com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper newWrappedExtractor(int i_renamed, com.google.android.exoplayer2.Format format) {
        java.lang.String str = format.containerMimeType;
        return new com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper(str != null && (str.startsWith(com.google.android.exoplayer2.util.MimeTypes.VIDEO_WEBM) || str.startsWith(com.google.android.exoplayer2.util.MimeTypes.AUDIO_WEBM)) ? new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor() : new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor(), i_renamed, format);
    }

    private static com.google.android.exoplayer2.source.dash.manifest.Representation getFirstRepresentation(com.google.android.exoplayer2.source.dash.manifest.Period period, int i_renamed) {
        int adaptationSetIndex = period.getAdaptationSetIndex(i_renamed);
        if (adaptationSetIndex == -1) {
            return null;
        }
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> list = period.adaptationSets.get(adaptationSetIndex).representations;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private DashUtil() {
    }
}

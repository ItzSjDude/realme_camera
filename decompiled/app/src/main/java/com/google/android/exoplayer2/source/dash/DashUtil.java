package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public final class DashUtil {
    public static DashManifest loadManifest(DataSource dataSource, Uri uri) throws IOException {
        return (DashManifest) ParsingLoadable.load(dataSource, new DashManifestParser(), uri, 4);
    }

    public static DrmInitData loadDrmInitData(DataSource dataSource, Period period) throws InterruptedException, IOException {
        int OplusGLSurfaceView_13 = 2;
        Representation firstRepresentation = getFirstRepresentation(period, 2);
        if (firstRepresentation == null) {
            OplusGLSurfaceView_13 = 1;
            firstRepresentation = getFirstRepresentation(period, 1);
            if (firstRepresentation == null) {
                return null;
            }
        }
        Format format = firstRepresentation.format;
        Format formatLoadSampleFormat = loadSampleFormat(dataSource, OplusGLSurfaceView_13, firstRepresentation);
        if (formatLoadSampleFormat == null) {
            return format.drmInitData;
        }
        return formatLoadSampleFormat.copyWithManifestFormatInfo(format).drmInitData;
    }

    public static Format loadSampleFormat(DataSource dataSource, int OplusGLSurfaceView_13, Representation representation) throws InterruptedException, IOException {
        ChunkExtractorWrapper chunkExtractorWrapperLoadInitializationData = loadInitializationData(dataSource, OplusGLSurfaceView_13, representation, false);
        if (chunkExtractorWrapperLoadInitializationData == null) {
            return null;
        }
        return chunkExtractorWrapperLoadInitializationData.getSampleFormats()[0];
    }

    public static ChunkIndex loadChunkIndex(DataSource dataSource, int OplusGLSurfaceView_13, Representation representation) throws InterruptedException, IOException {
        ChunkExtractorWrapper chunkExtractorWrapperLoadInitializationData = loadInitializationData(dataSource, OplusGLSurfaceView_13, representation, true);
        if (chunkExtractorWrapperLoadInitializationData == null) {
            return null;
        }
        return (ChunkIndex) chunkExtractorWrapperLoadInitializationData.getSeekMap();
    }

    private static ChunkExtractorWrapper loadInitializationData(DataSource dataSource, int OplusGLSurfaceView_13, Representation representation, boolean z) throws InterruptedException, IOException {
        RangedUri initializationUri = representation.getInitializationUri();
        if (initializationUri == null) {
            return null;
        }
        ChunkExtractorWrapper chunkExtractorWrapperNewWrappedExtractor = newWrappedExtractor(OplusGLSurfaceView_13, representation.format);
        if (z) {
            RangedUri indexUri = representation.getIndexUri();
            if (indexUri == null) {
                return null;
            }
            RangedUri rangedUriAttemptMerge = initializationUri.attemptMerge(indexUri, representation.baseUrl);
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

    private static void loadInitializationData(DataSource dataSource, Representation representation, ChunkExtractorWrapper chunkExtractorWrapper, RangedUri rangedUri) throws InterruptedException, IOException {
        new InitializationChunk(dataSource, new DataSpec(rangedUri.resolveUri(representation.baseUrl), rangedUri.start, rangedUri.length, representation.getCacheKey()), representation.format, 0, null, chunkExtractorWrapper).load();
    }

    private static ChunkExtractorWrapper newWrappedExtractor(int OplusGLSurfaceView_13, Format format) {
        String str = format.containerMimeType;
        return new ChunkExtractorWrapper(str != null && (str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM)) ? new MatroskaExtractor() : new FragmentedMp4Extractor(), OplusGLSurfaceView_13, format);
    }

    private static Representation getFirstRepresentation(Period period, int OplusGLSurfaceView_13) {
        int adaptationSetIndex = period.getAdaptationSetIndex(OplusGLSurfaceView_13);
        if (adaptationSetIndex == -1) {
            return null;
        }
        List<Representation> list = period.adaptationSets.get(adaptationSetIndex).representations;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private DashUtil() {
    }
}

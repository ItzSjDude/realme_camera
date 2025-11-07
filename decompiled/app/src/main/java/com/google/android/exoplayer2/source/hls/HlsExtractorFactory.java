package com.google.android.exoplayer2.source.hls;

/* loaded from: classes.dex */
public interface HlsExtractorFactory {
    public static final com.google.android.exoplayer2.source.hls.HlsExtractorFactory DEFAULT = new com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory();

    android.util.Pair<com.google.android.exoplayer2.extractor.Extractor, java.lang.Boolean> createExtractor(com.google.android.exoplayer2.extractor.Extractor extractor, android.net.Uri uri, com.google.android.exoplayer2.Format format, java.util.List<com.google.android.exoplayer2.Format> list, com.google.android.exoplayer2.drm.DrmInitData drmInitData, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException;
}

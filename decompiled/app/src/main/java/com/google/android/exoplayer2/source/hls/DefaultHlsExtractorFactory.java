package com.google.android.exoplayer2.source.hls;

/* loaded from: classes.dex */
public final class DefaultHlsExtractorFactory implements com.google.android.exoplayer2.source.hls.HlsExtractorFactory {
    public static final java.lang.String AAC_FILE_EXTENSION = ".aac";
    public static final java.lang.String AC3_FILE_EXTENSION = ".ac3";
    public static final java.lang.String AC4_FILE_EXTENSION = ".ac4";
    public static final java.lang.String CMF_FILE_EXTENSION_PREFIX = ".cmf";
    public static final java.lang.String EC3_FILE_EXTENSION = ".ec3";
    public static final java.lang.String M4_FILE_EXTENSION_PREFIX = ".m4";
    public static final java.lang.String MP3_FILE_EXTENSION = ".mp3";
    public static final java.lang.String MP4_FILE_EXTENSION = ".mp4";
    public static final java.lang.String MP4_FILE_EXTENSION_PREFIX = ".mp4";
    public static final java.lang.String VTT_FILE_EXTENSION = ".vtt";
    public static final java.lang.String WEBVTT_FILE_EXTENSION = ".webvtt";
    private final int payloadReaderFactoryFlags;

    public DefaultHlsExtractorFactory() {
        this(0);
    }

    public DefaultHlsExtractorFactory(int i_renamed) {
        this.payloadReaderFactoryFlags = i_renamed;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsExtractorFactory
    public android.util.Pair<com.google.android.exoplayer2.extractor.Extractor, java.lang.Boolean> createExtractor(com.google.android.exoplayer2.extractor.Extractor extractor, android.net.Uri uri, com.google.android.exoplayer2.Format format, java.util.List<com.google.android.exoplayer2.Format> list, com.google.android.exoplayer2.drm.DrmInitData drmInitData, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        if (extractor != null) {
            if ((extractor instanceof com.google.android.exoplayer2.extractor.ts.TsExtractor) || (extractor instanceof com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor)) {
                return buildResult(extractor);
            }
            if (extractor instanceof com.google.android.exoplayer2.source.hls.WebvttExtractor) {
                return buildResult(new com.google.android.exoplayer2.source.hls.WebvttExtractor(format.language, timestampAdjuster));
            }
            if (extractor instanceof com.google.android.exoplayer2.extractor.ts.AdtsExtractor) {
                return buildResult(new com.google.android.exoplayer2.extractor.ts.AdtsExtractor());
            }
            if (extractor instanceof com.google.android.exoplayer2.extractor.ts.Ac3Extractor) {
                return buildResult(new com.google.android.exoplayer2.extractor.ts.Ac3Extractor());
            }
            if (extractor instanceof com.google.android.exoplayer2.extractor.ts.Ac4Extractor) {
                return buildResult(new com.google.android.exoplayer2.extractor.ts.Ac4Extractor());
            }
            if (extractor instanceof com.google.android.exoplayer2.extractor.mp3.Mp3Extractor) {
                return buildResult(new com.google.android.exoplayer2.extractor.mp3.Mp3Extractor());
            }
            throw new java.lang.IllegalArgumentException("Unexpected previousExtractor type: " + extractor.getClass().getSimpleName());
        }
        com.google.android.exoplayer2.extractor.Extractor extractorCreateExtractorByFileExtension = createExtractorByFileExtension(uri, format, list, drmInitData, timestampAdjuster);
        extractorInput.resetPeekPosition();
        if (sniffQuietly(extractorCreateExtractorByFileExtension, extractorInput)) {
            return buildResult(extractorCreateExtractorByFileExtension);
        }
        if (!(extractorCreateExtractorByFileExtension instanceof com.google.android.exoplayer2.source.hls.WebvttExtractor)) {
            com.google.android.exoplayer2.source.hls.WebvttExtractor webvttExtractor = new com.google.android.exoplayer2.source.hls.WebvttExtractor(format.language, timestampAdjuster);
            if (sniffQuietly(webvttExtractor, extractorInput)) {
                return buildResult(webvttExtractor);
            }
        }
        if (!(extractorCreateExtractorByFileExtension instanceof com.google.android.exoplayer2.extractor.ts.AdtsExtractor)) {
            com.google.android.exoplayer2.extractor.ts.AdtsExtractor adtsExtractor = new com.google.android.exoplayer2.extractor.ts.AdtsExtractor();
            if (sniffQuietly(adtsExtractor, extractorInput)) {
                return buildResult(adtsExtractor);
            }
        }
        if (!(extractorCreateExtractorByFileExtension instanceof com.google.android.exoplayer2.extractor.ts.Ac3Extractor)) {
            com.google.android.exoplayer2.extractor.ts.Ac3Extractor ac3Extractor = new com.google.android.exoplayer2.extractor.ts.Ac3Extractor();
            if (sniffQuietly(ac3Extractor, extractorInput)) {
                return buildResult(ac3Extractor);
            }
        }
        if (!(extractorCreateExtractorByFileExtension instanceof com.google.android.exoplayer2.extractor.ts.Ac4Extractor)) {
            com.google.android.exoplayer2.extractor.ts.Ac4Extractor ac4Extractor = new com.google.android.exoplayer2.extractor.ts.Ac4Extractor();
            if (sniffQuietly(ac4Extractor, extractorInput)) {
                return buildResult(ac4Extractor);
            }
        }
        if (!(extractorCreateExtractorByFileExtension instanceof com.google.android.exoplayer2.extractor.mp3.Mp3Extractor)) {
            com.google.android.exoplayer2.extractor.mp3.Mp3Extractor mp3Extractor = new com.google.android.exoplayer2.extractor.mp3.Mp3Extractor(0, 0L);
            if (sniffQuietly(mp3Extractor, extractorInput)) {
                return buildResult(mp3Extractor);
            }
        }
        if (!(extractorCreateExtractorByFileExtension instanceof com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor)) {
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor fragmentedMp4Extractor = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor(0, timestampAdjuster, null, drmInitData, list != null ? list : java.util.Collections.emptyList());
            if (sniffQuietly(fragmentedMp4Extractor, extractorInput)) {
                return buildResult(fragmentedMp4Extractor);
            }
        }
        if (!(extractorCreateExtractorByFileExtension instanceof com.google.android.exoplayer2.extractor.ts.TsExtractor)) {
            com.google.android.exoplayer2.extractor.ts.TsExtractor tsExtractorCreateTsExtractor = createTsExtractor(this.payloadReaderFactoryFlags, format, list, timestampAdjuster);
            if (sniffQuietly(tsExtractorCreateTsExtractor, extractorInput)) {
                return buildResult(tsExtractorCreateTsExtractor);
            }
        }
        return buildResult(extractorCreateExtractorByFileExtension);
    }

    private com.google.android.exoplayer2.extractor.Extractor createExtractorByFileExtension(android.net.Uri uri, com.google.android.exoplayer2.Format format, java.util.List<com.google.android.exoplayer2.Format> list, com.google.android.exoplayer2.drm.DrmInitData drmInitData, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
        java.lang.String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = "";
        }
        if (com.google.android.exoplayer2.util.MimeTypes.TEXT_VTT.equals(format.sampleMimeType) || lastPathSegment.endsWith(WEBVTT_FILE_EXTENSION) || lastPathSegment.endsWith(VTT_FILE_EXTENSION)) {
            return new com.google.android.exoplayer2.source.hls.WebvttExtractor(format.language, timestampAdjuster);
        }
        if (lastPathSegment.endsWith(AAC_FILE_EXTENSION)) {
            return new com.google.android.exoplayer2.extractor.ts.AdtsExtractor();
        }
        if (lastPathSegment.endsWith(AC3_FILE_EXTENSION) || lastPathSegment.endsWith(EC3_FILE_EXTENSION)) {
            return new com.google.android.exoplayer2.extractor.ts.Ac3Extractor();
        }
        if (lastPathSegment.endsWith(AC4_FILE_EXTENSION)) {
            return new com.google.android.exoplayer2.extractor.ts.Ac4Extractor();
        }
        if (lastPathSegment.endsWith(MP3_FILE_EXTENSION)) {
            return new com.google.android.exoplayer2.extractor.mp3.Mp3Extractor(0, 0L);
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(M4_FILE_EXTENSION_PREFIX, lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(CMF_FILE_EXTENSION_PREFIX, lastPathSegment.length() - 5)) {
            if (list == null) {
                list = java.util.Collections.emptyList();
            }
            return new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor(0, timestampAdjuster, null, drmInitData, list);
        }
        return createTsExtractor(this.payloadReaderFactoryFlags, format, list, timestampAdjuster);
    }

    private static com.google.android.exoplayer2.extractor.ts.TsExtractor createTsExtractor(int i_renamed, com.google.android.exoplayer2.Format format, java.util.List<com.google.android.exoplayer2.Format> list, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
        int i2 = i_renamed | 16;
        if (list != null) {
            i2 |= 32;
        } else {
            list = java.util.Collections.singletonList(com.google.android.exoplayer2.Format.createTextSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA608, 0, null));
        }
        java.lang.String str = format.codecs;
        if (!android.text.TextUtils.isEmpty(str)) {
            if (!com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC.equals(com.google.android.exoplayer2.util.MimeTypes.getAudioMediaMimeType(str))) {
                i2 |= 2;
            }
            if (!com.google.android.exoplayer2.util.MimeTypes.VIDEO_H264.equals(com.google.android.exoplayer2.util.MimeTypes.getVideoMediaMimeType(str))) {
                i2 |= 4;
            }
        }
        return new com.google.android.exoplayer2.extractor.ts.TsExtractor(2, timestampAdjuster, new com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory(i2, list));
    }

    private static android.util.Pair<com.google.android.exoplayer2.extractor.Extractor, java.lang.Boolean> buildResult(com.google.android.exoplayer2.extractor.Extractor extractor) {
        return new android.util.Pair<>(extractor, java.lang.Boolean.valueOf((extractor instanceof com.google.android.exoplayer2.extractor.ts.AdtsExtractor) || (extractor instanceof com.google.android.exoplayer2.extractor.ts.Ac3Extractor) || (extractor instanceof com.google.android.exoplayer2.extractor.ts.Ac4Extractor) || (extractor instanceof com.google.android.exoplayer2.extractor.mp3.Mp3Extractor)));
    }

    private static boolean sniffQuietly(com.google.android.exoplayer2.extractor.Extractor extractor, com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        try {
            boolean zSniff = extractor.sniff(extractorInput);
            extractorInput.resetPeekPosition();
            return zSniff;
        } catch (java.io.EOFException unused) {
            extractorInput.resetPeekPosition();
            return false;
        } catch (java.lang.Throwable th) {
            extractorInput.resetPeekPosition();
            throw th;
        }
    }
}

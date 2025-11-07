package com.google.android.exoplayer2.source.hls;

/* loaded from: classes.dex */
public final class HlsMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener {
    private final com.google.android.exoplayer2.upstream.Allocator allocator;
    private final boolean allowChunklessPreparation;
    private com.google.android.exoplayer2.source.MediaPeriod.Callback callback;
    private com.google.android.exoplayer2.source.SequenceableLoader compositeSequenceableLoader;
    private final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final com.google.android.exoplayer2.source.hls.HlsDataSourceFactory dataSourceFactory;
    private final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher;
    private final com.google.android.exoplayer2.source.hls.HlsExtractorFactory extractorFactory;
    private final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final com.google.android.exoplayer2.upstream.TransferListener mediaTransferListener;
    private boolean notifiedReadingStarted;
    private int pendingPrepareCount;
    private final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker playlistTracker;
    private com.google.android.exoplayer2.source.TrackGroupArray trackGroups;
    private final java.util.IdentityHashMap<com.google.android.exoplayer2.source.SampleStream, java.lang.Integer> streamWrapperIndices = new java.util.IdentityHashMap<>();
    private final com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider timestampAdjusterProvider = new com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider();
    private com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] sampleStreamWrappers = new com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[0];
    private com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] enabledSampleStreamWrappers = new com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[0];

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j_renamed, com.google.android.exoplayer2.SeekParameters seekParameters) {
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getLargestQueuedTimeUsByType(int i_renamed) {
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextKeyFramePositionUs(long j_renamed) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public boolean seekToUsInGop(long j_renamed, boolean z_renamed) {
        return false;
    }

    public HlsMediaPeriod(com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker hlsPlaylistTracker, com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.upstream.TransferListener transferListener, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.upstream.Allocator allocator, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, boolean z_renamed) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.mediaTransferListener = transferListener;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.eventDispatcher = eventDispatcher;
        this.allocator = allocator;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.allowChunklessPreparation = z_renamed;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(new com.google.android.exoplayer2.source.SequenceableLoader[0]);
        eventDispatcher.mediaPeriodCreated();
    }

    public void release() {
        this.playlistTracker.removeListener(this);
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.release();
        }
        this.callback = null;
        this.eventDispatcher.mediaPeriodReleased();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j_renamed) {
        this.callback = callback;
        this.playlistTracker.addListener(this);
        buildAndPrepareSampleStreamWrappers(j_renamed);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws java.io.IOException {
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:61:0x00ed  */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] r21, boolean[] r22, com.google.android.exoplayer2.source.SampleStream[] r23, boolean[] r24, long r25) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaPeriod.selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long):long");
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j_renamed, boolean z_renamed) {
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper : this.enabledSampleStreamWrappers) {
            hlsSampleStreamWrapper.discardBuffer(j_renamed, z_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j_renamed) {
        this.compositeSequenceableLoader.reevaluateBuffer(j_renamed);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j_renamed) {
        if (this.trackGroups == null) {
            for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
                hlsSampleStreamWrapper.continuePreparing();
            }
            return false;
        }
        return this.compositeSequenceableLoader.continueLoading(j_renamed);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (this.notifiedReadingStarted) {
            return -9223372036854775807L;
        }
        this.eventDispatcher.readingStarted();
        this.notifiedReadingStarted = true;
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j_renamed) {
        com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.enabledSampleStreamWrappers;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean zSeekToUs = hlsSampleStreamWrapperArr[0].seekToUs(j_renamed, false);
            int i_renamed = 1;
            while (true) {
                com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.enabledSampleStreamWrappers;
                if (i_renamed >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i_renamed].seekToUs(j_renamed, zSeekToUs);
                i_renamed++;
            }
            if (zSeekToUs) {
                this.timestampAdjusterProvider.reset();
            }
        }
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
    public void onPrepared() {
        int i_renamed = this.pendingPrepareCount - 1;
        this.pendingPrepareCount = i_renamed;
        if (i_renamed > 0) {
            return;
        }
        int i2 = 0;
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            i2 += hlsSampleStreamWrapper.getTrackGroups().length;
        }
        com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[i2];
        com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.sampleStreamWrappers;
        int length = hlsSampleStreamWrapperArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper2 = hlsSampleStreamWrapperArr[i3];
            int i5 = hlsSampleStreamWrapper2.getTrackGroups().length;
            int i6 = i4;
            int i7 = 0;
            while (i7 < i5) {
                trackGroupArr[i6] = hlsSampleStreamWrapper2.getTrackGroups().get(i7);
                i7++;
                i6++;
            }
            i3++;
            i4 = i6;
        }
        this.trackGroups = new com.google.android.exoplayer2.source.TrackGroupArray(trackGroupArr);
        this.callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
    public void onPlaylistRefreshRequired(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl) {
        this.playlistTracker.refreshPlaylist(hlsUrl);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.callback.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public void onPlaylistChanged() {
        this.callback.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public boolean onPlaylistError(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl, long j_renamed) {
        boolean zOnPlaylistError = true;
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            zOnPlaylistError &= hlsSampleStreamWrapper.onPlaylistError(hlsUrl, j_renamed);
        }
        this.callback.onContinueLoadingRequested(this);
        return zOnPlaylistError;
    }

    private void buildAndPrepareSampleStreamWrappers(long j_renamed) {
        com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist masterPlaylist = this.playlistTracker.getMasterPlaylist();
        java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> list = masterPlaylist.audios;
        java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> list2 = masterPlaylist.subtitles;
        int size = list.size() + 1 + list2.size();
        this.sampleStreamWrappers = new com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[size];
        this.pendingPrepareCount = size;
        buildAndPrepareMainSampleStreamWrapper(masterPlaylist, j_renamed);
        char c2 = 0;
        int i_renamed = 1;
        int i2 = 0;
        while (i2 < list.size()) {
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl = list.get(i2);
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl[] hlsUrlArr = new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl[1];
            hlsUrlArr[c2] = hlsUrl;
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapperBuildSampleStreamWrapper = buildSampleStreamWrapper(1, hlsUrlArr, null, java.util.Collections.emptyList(), j_renamed);
            int i3 = i_renamed + 1;
            this.sampleStreamWrappers[i_renamed] = hlsSampleStreamWrapperBuildSampleStreamWrapper;
            com.google.android.exoplayer2.Format format = hlsUrl.format;
            if (this.allowChunklessPreparation && format.codecs != null) {
                hlsSampleStreamWrapperBuildSampleStreamWrapper.prepareWithMasterPlaylistInfo(new com.google.android.exoplayer2.source.TrackGroupArray(new com.google.android.exoplayer2.source.TrackGroup(hlsUrl.format)), 0, com.google.android.exoplayer2.source.TrackGroupArray.EMPTY);
            } else {
                hlsSampleStreamWrapperBuildSampleStreamWrapper.continuePreparing();
            }
            i2++;
            i_renamed = i3;
            c2 = 0;
        }
        int i4 = 0;
        while (i4 < list2.size()) {
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl2 = list2.get(i4);
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapperBuildSampleStreamWrapper2 = buildSampleStreamWrapper(3, new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl[]{hlsUrl2}, null, java.util.Collections.emptyList(), j_renamed);
            this.sampleStreamWrappers[i_renamed] = hlsSampleStreamWrapperBuildSampleStreamWrapper2;
            hlsSampleStreamWrapperBuildSampleStreamWrapper2.prepareWithMasterPlaylistInfo(new com.google.android.exoplayer2.source.TrackGroupArray(new com.google.android.exoplayer2.source.TrackGroup(hlsUrl2.format)), 0, com.google.android.exoplayer2.source.TrackGroupArray.EMPTY);
            i4++;
            i_renamed++;
        }
        this.enabledSampleStreamWrappers = this.sampleStreamWrappers;
    }

    private void buildAndPrepareMainSampleStreamWrapper(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist, long j_renamed) {
        java.util.ArrayList arrayList;
        java.util.ArrayList arrayList2 = new java.util.ArrayList(hlsMasterPlaylist.variants);
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed < arrayList2.size(); i_renamed++) {
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl = (com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl) arrayList2.get(i_renamed);
            com.google.android.exoplayer2.Format format = hlsUrl.format;
            if (format.height > 0 || com.google.android.exoplayer2.util.Util.getCodecsOfType(format.codecs, 2) != null) {
                arrayList3.add(hlsUrl);
            } else if (com.google.android.exoplayer2.util.Util.getCodecsOfType(format.codecs, 1) != null) {
                arrayList4.add(hlsUrl);
            }
        }
        if (arrayList3.isEmpty()) {
            if (arrayList4.size() < arrayList2.size()) {
                arrayList2.removeAll(arrayList4);
            }
            arrayList = arrayList2;
        } else {
            arrayList = arrayList3;
        }
        com.google.android.exoplayer2.util.Assertions.checkArgument(!arrayList.isEmpty());
        com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl[] hlsUrlArr = (com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl[]) arrayList.toArray(new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl[0]);
        java.lang.String str = hlsUrlArr[0].format.codecs;
        com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapperBuildSampleStreamWrapper = buildSampleStreamWrapper(0, hlsUrlArr, hlsMasterPlaylist.muxedAudioFormat, hlsMasterPlaylist.muxedCaptionFormats, j_renamed);
        this.sampleStreamWrappers[0] = hlsSampleStreamWrapperBuildSampleStreamWrapper;
        if (this.allowChunklessPreparation && str != null) {
            boolean z_renamed = com.google.android.exoplayer2.util.Util.getCodecsOfType(str, 2) != null;
            boolean z2 = com.google.android.exoplayer2.util.Util.getCodecsOfType(str, 1) != null;
            java.util.ArrayList arrayList5 = new java.util.ArrayList();
            if (z_renamed) {
                com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[arrayList.size()];
                for (int i2 = 0; i2 < formatArr.length; i2++) {
                    formatArr[i2] = deriveVideoFormat(hlsUrlArr[i2].format);
                }
                arrayList5.add(new com.google.android.exoplayer2.source.TrackGroup(formatArr));
                if (z2 && (hlsMasterPlaylist.muxedAudioFormat != null || hlsMasterPlaylist.audios.isEmpty())) {
                    arrayList5.add(new com.google.android.exoplayer2.source.TrackGroup(deriveAudioFormat(hlsUrlArr[0].format, hlsMasterPlaylist.muxedAudioFormat, false)));
                }
                java.util.List<com.google.android.exoplayer2.Format> list = hlsMasterPlaylist.muxedCaptionFormats;
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        arrayList5.add(new com.google.android.exoplayer2.source.TrackGroup(list.get(i3)));
                    }
                }
            } else if (z2) {
                com.google.android.exoplayer2.Format[] formatArr2 = new com.google.android.exoplayer2.Format[arrayList.size()];
                for (int i4 = 0; i4 < formatArr2.length; i4++) {
                    formatArr2[i4] = deriveAudioFormat(hlsUrlArr[i4].format, hlsMasterPlaylist.muxedAudioFormat, true);
                }
                arrayList5.add(new com.google.android.exoplayer2.source.TrackGroup(formatArr2));
            } else {
                throw new java.lang.IllegalArgumentException("Unexpected codecs attribute: " + str);
            }
            com.google.android.exoplayer2.source.TrackGroup trackGroup = new com.google.android.exoplayer2.source.TrackGroup(com.google.android.exoplayer2.Format.createSampleFormat("ID3", com.google.android.exoplayer2.util.MimeTypes.APPLICATION_ID3, null, -1, null));
            arrayList5.add(trackGroup);
            hlsSampleStreamWrapperBuildSampleStreamWrapper.prepareWithMasterPlaylistInfo(new com.google.android.exoplayer2.source.TrackGroupArray((com.google.android.exoplayer2.source.TrackGroup[]) arrayList5.toArray(new com.google.android.exoplayer2.source.TrackGroup[0])), 0, new com.google.android.exoplayer2.source.TrackGroupArray(trackGroup));
            return;
        }
        hlsSampleStreamWrapperBuildSampleStreamWrapper.setIsTimestampMaster(true);
        hlsSampleStreamWrapperBuildSampleStreamWrapper.continuePreparing();
    }

    private com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper buildSampleStreamWrapper(int i_renamed, com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl[] hlsUrlArr, com.google.android.exoplayer2.Format format, java.util.List<com.google.android.exoplayer2.Format> list, long j_renamed) {
        return new com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper(i_renamed, this, new com.google.android.exoplayer2.source.hls.HlsChunkSource(this.extractorFactory, this.playlistTracker, hlsUrlArr, this.dataSourceFactory, this.mediaTransferListener, this.timestampAdjusterProvider, list), this.allocator, j_renamed, format, this.loadErrorHandlingPolicy, this.eventDispatcher);
    }

    private static com.google.android.exoplayer2.Format deriveVideoFormat(com.google.android.exoplayer2.Format format) {
        java.lang.String codecsOfType = com.google.android.exoplayer2.util.Util.getCodecsOfType(format.codecs, 2);
        return com.google.android.exoplayer2.Format.createVideoContainerFormat(format.id_renamed, format.label, format.containerMimeType, com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(codecsOfType), codecsOfType, format.bitrate, format.width, format.height, format.frameRate, null, format.selectionFlags);
    }

    private static com.google.android.exoplayer2.Format deriveAudioFormat(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2, boolean z_renamed) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        int i_renamed;
        int i2;
        if (format2 != null) {
            java.lang.String str4 = format2.codecs;
            int i3 = format2.channelCount;
            int i4 = format2.selectionFlags;
            java.lang.String str5 = format2.language;
            str2 = format2.label;
            str = str4;
            i_renamed = i3;
            i2 = i4;
            str3 = str5;
        } else {
            java.lang.String codecsOfType = com.google.android.exoplayer2.util.Util.getCodecsOfType(format.codecs, 1);
            if (z_renamed) {
                int i5 = format.channelCount;
                int i6 = format.selectionFlags;
                str = codecsOfType;
                i_renamed = i5;
                str3 = format.label;
                i2 = i6;
                str2 = format.label;
            } else {
                str = codecsOfType;
                str2 = null;
                str3 = null;
                i_renamed = -1;
                i2 = 0;
            }
        }
        return com.google.android.exoplayer2.Format.createAudioContainerFormat(format.id_renamed, str2, format.containerMimeType, com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(str), str, z_renamed ? format.bitrate : -1, i_renamed, -1, null, i2, str3);
    }
}

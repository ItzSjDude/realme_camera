package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
final class MergingMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.MediaPeriod.Callback {
    private com.google.android.exoplayer2.source.MediaPeriod.Callback callback;
    private com.google.android.exoplayer2.source.SequenceableLoader compositeSequenceableLoader;
    private final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private com.google.android.exoplayer2.source.MediaPeriod[] enabledPeriods;
    public final com.google.android.exoplayer2.source.MediaPeriod[] periods;
    private com.google.android.exoplayer2.source.TrackGroupArray trackGroups;
    private final java.util.ArrayList<com.google.android.exoplayer2.source.MediaPeriod> childrenPendingPreparation = new java.util.ArrayList<>();
    private final java.util.IdentityHashMap<com.google.android.exoplayer2.source.SampleStream, java.lang.Integer> streamPeriodIndices = new java.util.IdentityHashMap<>();

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

    public MergingMediaPeriod(com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.source.MediaPeriod... mediaPeriodArr) {
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.periods = mediaPeriodArr;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(new com.google.android.exoplayer2.source.SequenceableLoader[0]);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j_renamed) {
        this.callback = callback;
        java.util.Collections.addAll(this.childrenPendingPreparation, this.periods);
        for (com.google.android.exoplayer2.source.MediaPeriod mediaPeriod : this.periods) {
            mediaPeriod.prepare(this, j_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws java.io.IOException {
        for (com.google.android.exoplayer2.source.MediaPeriod mediaPeriod : this.periods) {
            mediaPeriod.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j_renamed) {
        int[] iArr = new int[trackSelectionArr.length];
        int[] iArr2 = new int[trackSelectionArr.length];
        for (int i_renamed = 0; i_renamed < trackSelectionArr.length; i_renamed++) {
            iArr[i_renamed] = sampleStreamArr[i_renamed] == null ? -1 : this.streamPeriodIndices.get(sampleStreamArr[i_renamed]).intValue();
            iArr2[i_renamed] = -1;
            if (trackSelectionArr[i_renamed] != null) {
                com.google.android.exoplayer2.source.TrackGroup trackGroup = trackSelectionArr[i_renamed].getTrackGroup();
                int i2 = 0;
                while (true) {
                    com.google.android.exoplayer2.source.MediaPeriod[] mediaPeriodArr = this.periods;
                    if (i2 >= mediaPeriodArr.length) {
                        break;
                    }
                    if (mediaPeriodArr[i2].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i_renamed] = i2;
                        break;
                    }
                    i2++;
                }
            }
        }
        this.streamPeriodIndices.clear();
        com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr2 = new com.google.android.exoplayer2.source.SampleStream[trackSelectionArr.length];
        com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr3 = new com.google.android.exoplayer2.source.SampleStream[trackSelectionArr.length];
        com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr2 = new com.google.android.exoplayer2.trackselection.TrackSelection[trackSelectionArr.length];
        java.util.ArrayList arrayList = new java.util.ArrayList(this.periods.length);
        long j2 = j_renamed;
        int i3 = 0;
        while (i3 < this.periods.length) {
            for (int i4 = 0; i4 < trackSelectionArr.length; i4++) {
                com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = null;
                sampleStreamArr3[i4] = iArr[i4] == i3 ? sampleStreamArr[i4] : null;
                if (iArr2[i4] == i3) {
                    trackSelection = trackSelectionArr[i4];
                }
                trackSelectionArr2[i4] = trackSelection;
            }
            com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr3 = trackSelectionArr2;
            java.util.ArrayList arrayList2 = arrayList;
            com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr4 = trackSelectionArr2;
            int i5 = i3;
            long jSelectTracks = this.periods[i3].selectTracks(trackSelectionArr3, zArr, sampleStreamArr3, zArr2, j2);
            if (i5 == 0) {
                j2 = jSelectTracks;
            } else if (jSelectTracks != j2) {
                throw new java.lang.IllegalStateException("Children enabled at_renamed different positions.");
            }
            boolean z_renamed = false;
            for (int i6 = 0; i6 < trackSelectionArr.length; i6++) {
                if (iArr2[i6] == i5) {
                    com.google.android.exoplayer2.util.Assertions.checkState(sampleStreamArr3[i6] != null);
                    sampleStreamArr2[i6] = sampleStreamArr3[i6];
                    this.streamPeriodIndices.put(sampleStreamArr3[i6], java.lang.Integer.valueOf(i5));
                    z_renamed = true;
                } else if (iArr[i6] == i5) {
                    com.google.android.exoplayer2.util.Assertions.checkState(sampleStreamArr3[i6] == null);
                }
            }
            if (z_renamed) {
                arrayList2.add(this.periods[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            trackSelectionArr2 = trackSelectionArr4;
        }
        java.util.ArrayList arrayList3 = arrayList;
        java.lang.System.arraycopy(sampleStreamArr2, 0, sampleStreamArr, 0, sampleStreamArr2.length);
        this.enabledPeriods = new com.google.android.exoplayer2.source.MediaPeriod[arrayList3.size()];
        arrayList3.toArray(this.enabledPeriods);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.enabledPeriods);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j_renamed, boolean z_renamed) {
        for (com.google.android.exoplayer2.source.MediaPeriod mediaPeriod : this.enabledPeriods) {
            mediaPeriod.discardBuffer(j_renamed, z_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j_renamed) {
        this.compositeSequenceableLoader.reevaluateBuffer(j_renamed);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j_renamed) {
        if (!this.childrenPendingPreparation.isEmpty()) {
            int size = this.childrenPendingPreparation.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.childrenPendingPreparation.get(i_renamed).continueLoading(j_renamed);
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
        long discontinuity = this.periods[0].readDiscontinuity();
        int i_renamed = 1;
        while (true) {
            com.google.android.exoplayer2.source.MediaPeriod[] mediaPeriodArr = this.periods;
            if (i_renamed >= mediaPeriodArr.length) {
                if (discontinuity != -9223372036854775807L) {
                    for (com.google.android.exoplayer2.source.MediaPeriod mediaPeriod : this.enabledPeriods) {
                        if (mediaPeriod != this.periods[0] && mediaPeriod.seekToUs(discontinuity) != discontinuity) {
                            throw new java.lang.IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                }
                return discontinuity;
            }
            if (mediaPeriodArr[i_renamed].readDiscontinuity() != -9223372036854775807L) {
                throw new java.lang.IllegalStateException("Child reported discontinuity.");
            }
            i_renamed++;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j_renamed) {
        long jSeekToUs = this.enabledPeriods[0].seekToUs(j_renamed);
        int i_renamed = 1;
        while (true) {
            com.google.android.exoplayer2.source.MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
            if (i_renamed >= mediaPeriodArr.length) {
                return jSeekToUs;
            }
            if (mediaPeriodArr[i_renamed].seekToUs(jSeekToUs) != jSeekToUs) {
                throw new java.lang.IllegalStateException("Unexpected child seekToUs result.");
            }
            i_renamed++;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j_renamed, com.google.android.exoplayer2.SeekParameters seekParameters) {
        return this.enabledPeriods[0].getAdjustedSeekPositionUs(j_renamed, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        this.childrenPendingPreparation.remove(mediaPeriod);
        if (this.childrenPendingPreparation.isEmpty()) {
            int i_renamed = 0;
            for (com.google.android.exoplayer2.source.MediaPeriod mediaPeriod2 : this.periods) {
                i_renamed += mediaPeriod2.getTrackGroups().length;
            }
            com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[i_renamed];
            com.google.android.exoplayer2.source.MediaPeriod[] mediaPeriodArr = this.periods;
            int length = mediaPeriodArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                com.google.android.exoplayer2.source.TrackGroupArray trackGroups = mediaPeriodArr[i2].getTrackGroups();
                int i4 = trackGroups.length;
                int i5 = i3;
                int i6 = 0;
                while (i6 < i4) {
                    trackGroupArr[i5] = trackGroups.get(i6);
                    i6++;
                    i5++;
                }
                i2++;
                i3 = i5;
            }
            this.trackGroups = new com.google.android.exoplayer2.source.TrackGroupArray(trackGroupArr);
            this.callback.onPrepared(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        this.callback.onContinueLoadingRequested(this);
    }
}

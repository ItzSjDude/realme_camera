package com.google.android.exoplayer2;

/* loaded from: classes.dex */
final class MediaPeriodQueue {
    private static final int MAXIMUM_BUFFER_AHEAD_PERIODS = 100;
    private int length;
    private com.google.android.exoplayer2.MediaPeriodHolder loading;
    private long nextWindowSequenceNumber;
    private java.lang.Object oldFrontPeriodUid;
    private long oldFrontPeriodWindowSequenceNumber;
    private com.google.android.exoplayer2.MediaPeriodHolder playing;
    private com.google.android.exoplayer2.MediaPeriodHolder reading;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private final com.google.android.exoplayer2.Timeline.Period period = new com.google.android.exoplayer2.Timeline.Period();
    private final com.google.android.exoplayer2.Timeline.Window window = new com.google.android.exoplayer2.Timeline.Window();
    private com.google.android.exoplayer2.Timeline timeline = com.google.android.exoplayer2.Timeline.EMPTY;

    public void setTimeline(com.google.android.exoplayer2.Timeline timeline) {
        this.timeline = timeline;
    }

    public boolean updateRepeatMode(int i_renamed) {
        this.repeatMode = i_renamed;
        return updateForPlaybackModeChange();
    }

    public boolean updateShuffleModeEnabled(boolean z_renamed) {
        this.shuffleModeEnabled = z_renamed;
        return updateForPlaybackModeChange();
    }

    public boolean isLoading(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.loading;
        return mediaPeriodHolder != null && mediaPeriodHolder.mediaPeriod == mediaPeriod;
    }

    public void reevaluateBuffer(long j_renamed) {
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.reevaluateBuffer(j_renamed);
        }
    }

    public boolean shouldLoadNextMediaPeriod() {
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.loading;
        return mediaPeriodHolder == null || (!mediaPeriodHolder.info.isFinal && this.loading.isFullyBuffered() && this.loading.info.durationUs != -9223372036854775807L && this.length < 100);
    }

    public com.google.android.exoplayer2.MediaPeriodInfo getNextMediaPeriodInfo(long j_renamed, com.google.android.exoplayer2.PlaybackInfo playbackInfo) {
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null) {
            return getFirstMediaPeriodInfo(playbackInfo);
        }
        return getFollowingMediaPeriodInfo(mediaPeriodHolder, j_renamed);
    }

    public com.google.android.exoplayer2.source.MediaPeriod enqueueNextMediaPeriod(com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.upstream.Allocator allocator, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo) {
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.loading;
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder2 = new com.google.android.exoplayer2.MediaPeriodHolder(rendererCapabilitiesArr, mediaPeriodHolder == null ? mediaPeriodInfo.startPositionUs : mediaPeriodHolder.getRendererOffset() + this.loading.info.durationUs, trackSelector, allocator, mediaSource, mediaPeriodInfo);
        if (this.loading != null) {
            com.google.android.exoplayer2.util.Assertions.checkState(hasPlayingPeriod());
            this.loading.next = mediaPeriodHolder2;
        }
        this.oldFrontPeriodUid = null;
        this.loading = mediaPeriodHolder2;
        this.length++;
        return mediaPeriodHolder2.mediaPeriod;
    }

    public com.google.android.exoplayer2.MediaPeriodHolder getLoadingPeriod() {
        return this.loading;
    }

    public com.google.android.exoplayer2.MediaPeriodHolder getPlayingPeriod() {
        return this.playing;
    }

    public com.google.android.exoplayer2.MediaPeriodHolder getReadingPeriod() {
        return this.reading;
    }

    public com.google.android.exoplayer2.MediaPeriodHolder getFrontPeriod() {
        return hasPlayingPeriod() ? this.playing : this.loading;
    }

    public boolean hasPlayingPeriod() {
        return this.playing != null;
    }

    public com.google.android.exoplayer2.MediaPeriodHolder advanceReadingPeriod() {
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.reading;
        com.google.android.exoplayer2.util.Assertions.checkState((mediaPeriodHolder == null || mediaPeriodHolder.next == null) ? false : true);
        this.reading = this.reading.next;
        return this.reading;
    }

    public com.google.android.exoplayer2.MediaPeriodHolder advancePlayingPeriod() {
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder != null) {
            if (mediaPeriodHolder == this.reading) {
                this.reading = mediaPeriodHolder.next;
            }
            this.playing.release();
            this.length--;
            if (this.length == 0) {
                this.loading = null;
                this.oldFrontPeriodUid = this.playing.uid;
                this.oldFrontPeriodWindowSequenceNumber = this.playing.info.id_renamed.windowSequenceNumber;
            }
            this.playing = this.playing.next;
        } else {
            com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder2 = this.loading;
            this.playing = mediaPeriodHolder2;
            this.reading = mediaPeriodHolder2;
        }
        return this.playing;
    }

    public boolean removeAfter(com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder) {
        boolean z_renamed = false;
        com.google.android.exoplayer2.util.Assertions.checkState(mediaPeriodHolder != null);
        this.loading = mediaPeriodHolder;
        while (mediaPeriodHolder.next != null) {
            mediaPeriodHolder = mediaPeriodHolder.next;
            if (mediaPeriodHolder == this.reading) {
                this.reading = this.playing;
                z_renamed = true;
            }
            mediaPeriodHolder.release();
            this.length--;
        }
        this.loading.next = null;
        return z_renamed;
    }

    public void clear(boolean z_renamed) {
        com.google.android.exoplayer2.MediaPeriodHolder frontPeriod = getFrontPeriod();
        if (frontPeriod != null) {
            this.oldFrontPeriodUid = z_renamed ? frontPeriod.uid : null;
            this.oldFrontPeriodWindowSequenceNumber = frontPeriod.info.id_renamed.windowSequenceNumber;
            frontPeriod.release();
            removeAfter(frontPeriod);
        } else if (!z_renamed) {
            this.oldFrontPeriodUid = null;
        }
        this.playing = null;
        this.loading = null;
        this.reading = null;
        this.length = 0;
    }

    public boolean updateQueuedPeriods(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j_renamed) {
        int indexOfPeriod = this.timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = null;
        com.google.android.exoplayer2.MediaPeriodHolder frontPeriod = getFrontPeriod();
        while (frontPeriod != null) {
            if (mediaPeriodHolder == null) {
                frontPeriod.info = getUpdatedMediaPeriodInfo(frontPeriod.info);
            } else {
                if (indexOfPeriod == -1 || !frontPeriod.uid.equals(this.timeline.getUidOfPeriod(indexOfPeriod))) {
                    return !removeAfter(mediaPeriodHolder);
                }
                com.google.android.exoplayer2.MediaPeriodInfo followingMediaPeriodInfo = getFollowingMediaPeriodInfo(mediaPeriodHolder, j_renamed);
                if (followingMediaPeriodInfo == null) {
                    return !removeAfter(mediaPeriodHolder);
                }
                frontPeriod.info = getUpdatedMediaPeriodInfo(frontPeriod.info);
                if (!canKeepMediaPeriodHolder(frontPeriod, followingMediaPeriodInfo)) {
                    return !removeAfter(mediaPeriodHolder);
                }
            }
            if (frontPeriod.info.isLastInTimelinePeriod) {
                indexOfPeriod = this.timeline.getNextPeriodIndex(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            }
            com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder2 = frontPeriod;
            frontPeriod = frontPeriod.next;
            mediaPeriodHolder = mediaPeriodHolder2;
        }
        return true;
    }

    public com.google.android.exoplayer2.MediaPeriodInfo getUpdatedMediaPeriodInfo(com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo) {
        long durationUs;
        boolean zIsLastInPeriod = isLastInPeriod(mediaPeriodInfo.id_renamed);
        boolean zIsLastInTimeline = isLastInTimeline(mediaPeriodInfo.id_renamed, zIsLastInPeriod);
        this.timeline.getPeriodByUid(mediaPeriodInfo.id_renamed.periodUid, this.period);
        if (mediaPeriodInfo.id_renamed.isAd()) {
            durationUs = this.period.getAdDurationUs(mediaPeriodInfo.id_renamed.adGroupIndex, mediaPeriodInfo.id_renamed.adIndexInAdGroup);
        } else {
            durationUs = mediaPeriodInfo.id_renamed.endPositionUs == Long.MIN_VALUE ? this.period.getDurationUs() : mediaPeriodInfo.id_renamed.endPositionUs;
        }
        return new com.google.android.exoplayer2.MediaPeriodInfo(mediaPeriodInfo.id_renamed, mediaPeriodInfo.startPositionUs, mediaPeriodInfo.contentPositionUs, durationUs, zIsLastInPeriod, zIsLastInTimeline);
    }

    public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(java.lang.Object obj, long j_renamed) {
        return resolveMediaPeriodIdForAds(obj, j_renamed, resolvePeriodIndexToWindowSequenceNumber(obj));
    }

    private com.google.android.exoplayer2.source.MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(java.lang.Object obj, long j_renamed, long j2) {
        this.timeline.getPeriodByUid(obj, this.period);
        int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(j_renamed);
        if (adGroupIndexForPositionUs == -1) {
            int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(j_renamed);
            return new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(obj, j2, adGroupIndexAfterPositionUs == -1 ? Long.MIN_VALUE : this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs));
        }
        return new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(obj, adGroupIndexForPositionUs, this.period.getFirstAdIndexToPlay(adGroupIndexForPositionUs), j2);
    }

    private long resolvePeriodIndexToWindowSequenceNumber(java.lang.Object obj) {
        int indexOfPeriod;
        int i_renamed = this.timeline.getPeriodByUid(obj, this.period).windowIndex;
        java.lang.Object obj2 = this.oldFrontPeriodUid;
        if (obj2 != null && (indexOfPeriod = this.timeline.getIndexOfPeriod(obj2)) != -1 && this.timeline.getPeriod(indexOfPeriod, this.period).windowIndex == i_renamed) {
            return this.oldFrontPeriodWindowSequenceNumber;
        }
        for (com.google.android.exoplayer2.MediaPeriodHolder frontPeriod = getFrontPeriod(); frontPeriod != null; frontPeriod = frontPeriod.next) {
            if (frontPeriod.uid.equals(obj)) {
                return frontPeriod.info.id_renamed.windowSequenceNumber;
            }
        }
        for (com.google.android.exoplayer2.MediaPeriodHolder frontPeriod2 = getFrontPeriod(); frontPeriod2 != null; frontPeriod2 = frontPeriod2.next) {
            int indexOfPeriod2 = this.timeline.getIndexOfPeriod(frontPeriod2.uid);
            if (indexOfPeriod2 != -1 && this.timeline.getPeriod(indexOfPeriod2, this.period).windowIndex == i_renamed) {
                return frontPeriod2.info.id_renamed.windowSequenceNumber;
            }
        }
        long j_renamed = this.nextWindowSequenceNumber;
        this.nextWindowSequenceNumber = 1 + j_renamed;
        return j_renamed;
    }

    private boolean canKeepMediaPeriodHolder(com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder, com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo) {
        com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder.info;
        return mediaPeriodInfo2.startPositionUs == mediaPeriodInfo.startPositionUs && mediaPeriodInfo2.id_renamed.equals(mediaPeriodInfo.id_renamed);
    }

    private boolean updateForPlaybackModeChange() {
        com.google.android.exoplayer2.MediaPeriodHolder frontPeriod = getFrontPeriod();
        if (frontPeriod == null) {
            return true;
        }
        int indexOfPeriod = this.timeline.getIndexOfPeriod(frontPeriod.uid);
        while (true) {
            indexOfPeriod = this.timeline.getNextPeriodIndex(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            while (frontPeriod.next != null && !frontPeriod.info.isLastInTimelinePeriod) {
                frontPeriod = frontPeriod.next;
            }
            if (indexOfPeriod == -1 || frontPeriod.next == null || this.timeline.getIndexOfPeriod(frontPeriod.next.uid) != indexOfPeriod) {
                break;
            }
            frontPeriod = frontPeriod.next;
        }
        boolean zRemoveAfter = removeAfter(frontPeriod);
        frontPeriod.info = getUpdatedMediaPeriodInfo(frontPeriod.info);
        return (zRemoveAfter && hasPlayingPeriod()) ? false : true;
    }

    private com.google.android.exoplayer2.MediaPeriodInfo getFirstMediaPeriodInfo(com.google.android.exoplayer2.PlaybackInfo playbackInfo) {
        return getMediaPeriodInfo(playbackInfo.periodId, playbackInfo.contentPositionUs, playbackInfo.startPositionUs);
    }

    private com.google.android.exoplayer2.MediaPeriodInfo getFollowingMediaPeriodInfo(com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder, long j_renamed) {
        long jLongValue;
        java.lang.Object obj;
        long j2;
        long j3;
        com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
        long rendererOffset = (mediaPeriodHolder.getRendererOffset() + mediaPeriodInfo.durationUs) - j_renamed;
        long j4 = 0;
        if (mediaPeriodInfo.isLastInTimelinePeriod) {
            int nextPeriodIndex = this.timeline.getNextPeriodIndex(this.timeline.getIndexOfPeriod(mediaPeriodInfo.id_renamed.periodUid), this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if (nextPeriodIndex == -1) {
                return null;
            }
            int i_renamed = this.timeline.getPeriod(nextPeriodIndex, this.period, true).windowIndex;
            java.lang.Object obj2 = this.period.uid;
            long j5 = mediaPeriodInfo.id_renamed.windowSequenceNumber;
            if (this.timeline.getWindow(i_renamed, this.window).firstPeriodIndex == nextPeriodIndex) {
                android.util.Pair<java.lang.Object, java.lang.Long> periodPosition = this.timeline.getPeriodPosition(this.window, this.period, i_renamed, -9223372036854775807L, java.lang.Math.max(0L, rendererOffset));
                if (periodPosition == null) {
                    return null;
                }
                java.lang.Object obj3 = periodPosition.first;
                long jLongValue2 = ((java.lang.Long) periodPosition.second).longValue();
                if (mediaPeriodHolder.next != null && mediaPeriodHolder.next.uid.equals(obj3)) {
                    j3 = mediaPeriodHolder.next.info.id_renamed.windowSequenceNumber;
                } else {
                    j3 = this.nextWindowSequenceNumber;
                    this.nextWindowSequenceNumber = 1 + j3;
                }
                j4 = jLongValue2;
                j2 = j3;
                obj = obj3;
            } else {
                obj = obj2;
                j2 = j5;
            }
            long j6 = j4;
            return getMediaPeriodInfo(resolveMediaPeriodIdForAds(obj, j6, j2), j6, j4);
        }
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.id_renamed;
        this.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        if (!mediaPeriodId.isAd()) {
            if (mediaPeriodInfo.id_renamed.endPositionUs != Long.MIN_VALUE) {
                int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(mediaPeriodInfo.id_renamed.endPositionUs);
                if (adGroupIndexForPositionUs == -1) {
                    return getMediaPeriodInfoForContent(mediaPeriodId.periodUid, mediaPeriodInfo.id_renamed.endPositionUs, mediaPeriodId.windowSequenceNumber);
                }
                int firstAdIndexToPlay = this.period.getFirstAdIndexToPlay(adGroupIndexForPositionUs);
                if (this.period.isAdAvailable(adGroupIndexForPositionUs, firstAdIndexToPlay)) {
                    return getMediaPeriodInfoForAd(mediaPeriodId.periodUid, adGroupIndexForPositionUs, firstAdIndexToPlay, mediaPeriodInfo.id_renamed.endPositionUs, mediaPeriodId.windowSequenceNumber);
                }
                return null;
            }
            int adGroupCount = this.period.getAdGroupCount();
            if (adGroupCount == 0) {
                return null;
            }
            int i2 = adGroupCount - 1;
            if (this.period.getAdGroupTimeUs(i2) != Long.MIN_VALUE || this.period.hasPlayedAdGroup(i2)) {
                return null;
            }
            int firstAdIndexToPlay2 = this.period.getFirstAdIndexToPlay(i2);
            if (!this.period.isAdAvailable(i2, firstAdIndexToPlay2)) {
                return null;
            }
            return getMediaPeriodInfoForAd(mediaPeriodId.periodUid, i2, firstAdIndexToPlay2, this.period.getDurationUs(), mediaPeriodId.windowSequenceNumber);
        }
        int i3 = mediaPeriodId.adGroupIndex;
        int adCountInAdGroup = this.period.getAdCountInAdGroup(i3);
        if (adCountInAdGroup == -1) {
            return null;
        }
        int nextAdIndexToPlay = this.period.getNextAdIndexToPlay(i3, mediaPeriodId.adIndexInAdGroup);
        if (nextAdIndexToPlay < adCountInAdGroup) {
            if (this.period.isAdAvailable(i3, nextAdIndexToPlay)) {
                return getMediaPeriodInfoForAd(mediaPeriodId.periodUid, i3, nextAdIndexToPlay, mediaPeriodInfo.contentPositionUs, mediaPeriodId.windowSequenceNumber);
            }
            return null;
        }
        long j7 = mediaPeriodInfo.contentPositionUs;
        if (this.period.getAdGroupCount() == 1 && this.period.getAdGroupTimeUs(0) == 0) {
            com.google.android.exoplayer2.Timeline timeline = this.timeline;
            com.google.android.exoplayer2.Timeline.Window window = this.window;
            com.google.android.exoplayer2.Timeline.Period period = this.period;
            android.util.Pair<java.lang.Object, java.lang.Long> periodPosition2 = timeline.getPeriodPosition(window, period, period.windowIndex, -9223372036854775807L, java.lang.Math.max(0L, rendererOffset));
            if (periodPosition2 == null) {
                return null;
            }
            jLongValue = ((java.lang.Long) periodPosition2.second).longValue();
        } else {
            jLongValue = j7;
        }
        return getMediaPeriodInfoForContent(mediaPeriodId.periodUid, jLongValue, mediaPeriodId.windowSequenceNumber);
    }

    private com.google.android.exoplayer2.MediaPeriodInfo getMediaPeriodInfo(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j_renamed, long j2) {
        this.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        if (mediaPeriodId.isAd()) {
            if (this.period.isAdAvailable(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup)) {
                return getMediaPeriodInfoForAd(mediaPeriodId.periodUid, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, j_renamed, mediaPeriodId.windowSequenceNumber);
            }
            return null;
        }
        return getMediaPeriodInfoForContent(mediaPeriodId.periodUid, j2, mediaPeriodId.windowSequenceNumber);
    }

    private com.google.android.exoplayer2.MediaPeriodInfo getMediaPeriodInfoForAd(java.lang.Object obj, int i_renamed, int i2, long j_renamed, long j2) {
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(obj, i_renamed, i2, j2);
        boolean zIsLastInPeriod = isLastInPeriod(mediaPeriodId);
        boolean zIsLastInTimeline = isLastInTimeline(mediaPeriodId, zIsLastInPeriod);
        return new com.google.android.exoplayer2.MediaPeriodInfo(mediaPeriodId, i2 == this.period.getFirstAdIndexToPlay(i_renamed) ? this.period.getAdResumePositionUs() : 0L, j_renamed, this.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup), zIsLastInPeriod, zIsLastInTimeline);
    }

    private com.google.android.exoplayer2.MediaPeriodInfo getMediaPeriodInfoForContent(java.lang.Object obj, long j_renamed, long j2) {
        int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(j_renamed);
        long adGroupTimeUs = adGroupIndexAfterPositionUs == -1 ? Long.MIN_VALUE : this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs);
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(obj, j2, adGroupTimeUs);
        this.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        boolean zIsLastInPeriod = isLastInPeriod(mediaPeriodId);
        return new com.google.android.exoplayer2.MediaPeriodInfo(mediaPeriodId, j_renamed, -9223372036854775807L, adGroupTimeUs == Long.MIN_VALUE ? this.period.getDurationUs() : adGroupTimeUs, zIsLastInPeriod, isLastInTimeline(mediaPeriodId, zIsLastInPeriod));
    }

    private boolean isLastInPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        int adGroupCount = this.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).getAdGroupCount();
        if (adGroupCount == 0) {
            return true;
        }
        int i_renamed = adGroupCount - 1;
        boolean zIsAd = mediaPeriodId.isAd();
        if (this.period.getAdGroupTimeUs(i_renamed) != Long.MIN_VALUE) {
            return !zIsAd && mediaPeriodId.endPositionUs == Long.MIN_VALUE;
        }
        int adCountInAdGroup = this.period.getAdCountInAdGroup(i_renamed);
        if (adCountInAdGroup == -1) {
            return false;
        }
        if (zIsAd && mediaPeriodId.adGroupIndex == i_renamed && mediaPeriodId.adIndexInAdGroup == adCountInAdGroup + (-1)) {
            return true;
        }
        return !zIsAd && this.period.getFirstAdIndexToPlay(i_renamed) == adCountInAdGroup;
    }

    private boolean isLastInTimeline(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, boolean z_renamed) {
        int indexOfPeriod = this.timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        return !this.timeline.getWindow(this.timeline.getPeriod(indexOfPeriod, this.period).windowIndex, this.window).isDynamic && this.timeline.isLastPeriod(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled) && z_renamed;
    }
}

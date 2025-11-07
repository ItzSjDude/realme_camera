package com.google.android.exoplayer2.source.ads;

/* loaded from: classes.dex */
public final class AdPlaybackState {
    public static final int AD_STATE_AVAILABLE = 1;
    public static final int AD_STATE_ERROR = 4;
    public static final int AD_STATE_PLAYED = 3;
    public static final int AD_STATE_SKIPPED = 2;
    public static final int AD_STATE_UNAVAILABLE = 0;
    public static final com.google.android.exoplayer2.source.ads.AdPlaybackState NONE = new com.google.android.exoplayer2.source.ads.AdPlaybackState(new long[0]);
    public final int adGroupCount;
    public final long[] adGroupTimesUs;
    public final com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroups;
    public final long adResumePositionUs;
    public final long contentDurationUs;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    public static final class AdGroup {
        public final int count;
        public final long[] durationsUs;
        public final int[] states;
        public final android.net.Uri[] uris;

        public AdGroup() {
            this(-1, new int[0], new android.net.Uri[0], new long[0]);
        }

        private AdGroup(int i_renamed, int[] iArr, android.net.Uri[] uriArr, long[] jArr) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(iArr.length == uriArr.length);
            this.count = i_renamed;
            this.states = iArr;
            this.uris = uriArr;
            this.durationsUs = jArr;
        }

        public int getFirstAdIndexToPlay() {
            return getNextAdIndexToPlay(-1);
        }

        public int getNextAdIndexToPlay(int i_renamed) {
            int i2 = i_renamed + 1;
            while (true) {
                int[] iArr = this.states;
                if (i2 >= iArr.length || iArr[i2] == 0 || iArr[i2] == 1) {
                    break;
                }
                i2++;
            }
            return i2;
        }

        public boolean hasUnplayedAds() {
            return this.count == -1 || getFirstAdIndexToPlay() < this.count;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup adGroup = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup) obj;
            return this.count == adGroup.count && java.util.Arrays.equals(this.uris, adGroup.uris) && java.util.Arrays.equals(this.states, adGroup.states) && java.util.Arrays.equals(this.durationsUs, adGroup.durationsUs);
        }

        public int hashCode() {
            return (((((this.count * 31) + java.util.Arrays.hashCode(this.uris)) * 31) + java.util.Arrays.hashCode(this.states)) * 31) + java.util.Arrays.hashCode(this.durationsUs);
        }

        public com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup withAdCount(int i_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(this.count == -1 && this.states.length <= i_renamed);
            return new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup(i_renamed, copyStatesWithSpaceForAdCount(this.states, i_renamed), (android.net.Uri[]) java.util.Arrays.copyOf(this.uris, i_renamed), copyDurationsUsWithSpaceForAdCount(this.durationsUs, i_renamed));
        }

        public com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup withAdUri(android.net.Uri uri, int i_renamed) {
            int i2 = this.count;
            com.google.android.exoplayer2.util.Assertions.checkArgument(i2 == -1 || i_renamed < i2);
            int[] iArrCopyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i_renamed + 1);
            com.google.android.exoplayer2.util.Assertions.checkArgument(iArrCopyStatesWithSpaceForAdCount[i_renamed] == 0);
            long[] jArrCopyDurationsUsWithSpaceForAdCount = this.durationsUs;
            if (jArrCopyDurationsUsWithSpaceForAdCount.length != iArrCopyStatesWithSpaceForAdCount.length) {
                jArrCopyDurationsUsWithSpaceForAdCount = copyDurationsUsWithSpaceForAdCount(jArrCopyDurationsUsWithSpaceForAdCount, iArrCopyStatesWithSpaceForAdCount.length);
            }
            android.net.Uri[] uriArr = (android.net.Uri[]) java.util.Arrays.copyOf(this.uris, iArrCopyStatesWithSpaceForAdCount.length);
            uriArr[i_renamed] = uri;
            iArrCopyStatesWithSpaceForAdCount[i_renamed] = 1;
            return new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup(this.count, iArrCopyStatesWithSpaceForAdCount, uriArr, jArrCopyDurationsUsWithSpaceForAdCount);
        }

        public com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup withAdState(int i_renamed, int i2) {
            int i3 = this.count;
            com.google.android.exoplayer2.util.Assertions.checkArgument(i3 == -1 || i2 < i3);
            int[] iArrCopyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i2 + 1);
            com.google.android.exoplayer2.util.Assertions.checkArgument(iArrCopyStatesWithSpaceForAdCount[i2] == 0 || iArrCopyStatesWithSpaceForAdCount[i2] == 1 || iArrCopyStatesWithSpaceForAdCount[i2] == i_renamed);
            long[] jArrCopyDurationsUsWithSpaceForAdCount = this.durationsUs;
            if (jArrCopyDurationsUsWithSpaceForAdCount.length != iArrCopyStatesWithSpaceForAdCount.length) {
                jArrCopyDurationsUsWithSpaceForAdCount = copyDurationsUsWithSpaceForAdCount(jArrCopyDurationsUsWithSpaceForAdCount, iArrCopyStatesWithSpaceForAdCount.length);
            }
            android.net.Uri[] uriArr = this.uris;
            if (uriArr.length != iArrCopyStatesWithSpaceForAdCount.length) {
                uriArr = (android.net.Uri[]) java.util.Arrays.copyOf(uriArr, iArrCopyStatesWithSpaceForAdCount.length);
            }
            iArrCopyStatesWithSpaceForAdCount[i2] = i_renamed;
            return new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup(this.count, iArrCopyStatesWithSpaceForAdCount, uriArr, jArrCopyDurationsUsWithSpaceForAdCount);
        }

        public com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup withAdDurationsUs(long[] jArr) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(this.count == -1 || jArr.length <= this.uris.length);
            int length = jArr.length;
            android.net.Uri[] uriArr = this.uris;
            if (length < uriArr.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, uriArr.length);
            }
            return new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup(this.count, this.states, this.uris, jArr);
        }

        public com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup withAllAdsSkipped() {
            if (this.count == -1) {
                return new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup(0, new int[0], new android.net.Uri[0], new long[0]);
            }
            int[] iArr = this.states;
            int length = iArr.length;
            int[] iArrCopyOf = java.util.Arrays.copyOf(iArr, length);
            for (int i_renamed = 0; i_renamed < length; i_renamed++) {
                if (iArrCopyOf[i_renamed] == 1 || iArrCopyOf[i_renamed] == 0) {
                    iArrCopyOf[i_renamed] = 2;
                }
            }
            return new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup(length, iArrCopyOf, this.uris, this.durationsUs);
        }

        private static int[] copyStatesWithSpaceForAdCount(int[] iArr, int i_renamed) {
            int length = iArr.length;
            int iMax = java.lang.Math.max(i_renamed, length);
            int[] iArrCopyOf = java.util.Arrays.copyOf(iArr, iMax);
            java.util.Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        private static long[] copyDurationsUsWithSpaceForAdCount(long[] jArr, int i_renamed) {
            int length = jArr.length;
            int iMax = java.lang.Math.max(i_renamed, length);
            long[] jArrCopyOf = java.util.Arrays.copyOf(jArr, iMax);
            java.util.Arrays.fill(jArrCopyOf, length, iMax, -9223372036854775807L);
            return jArrCopyOf;
        }
    }

    public AdPlaybackState(long... jArr) {
        int length = jArr.length;
        this.adGroupCount = length;
        this.adGroupTimesUs = java.util.Arrays.copyOf(jArr, length);
        this.adGroups = new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[length];
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            this.adGroups[i_renamed] = new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup();
        }
        this.adResumePositionUs = 0L;
        this.contentDurationUs = -9223372036854775807L;
    }

    private AdPlaybackState(long[] jArr, com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr, long j_renamed, long j2) {
        this.adGroupCount = adGroupArr.length;
        this.adGroupTimesUs = jArr;
        this.adGroups = adGroupArr;
        this.adResumePositionUs = j_renamed;
        this.contentDurationUs = j2;
    }

    public int getAdGroupIndexForPositionUs(long j_renamed) {
        int length = this.adGroupTimesUs.length - 1;
        while (length >= 0 && isPositionBeforeAdGroup(j_renamed, length)) {
            length--;
        }
        if (length < 0 || !this.adGroups[length].hasUnplayedAds()) {
            return -1;
        }
        return length;
    }

    public int getAdGroupIndexAfterPositionUs(long j_renamed) {
        int i_renamed = 0;
        while (true) {
            long[] jArr = this.adGroupTimesUs;
            if (i_renamed >= jArr.length || jArr[i_renamed] == Long.MIN_VALUE || (j_renamed < jArr[i_renamed] && this.adGroups[i_renamed].hasUnplayedAds())) {
                break;
            }
            i_renamed++;
        }
        if (i_renamed < this.adGroupTimesUs.length) {
            return i_renamed;
        }
        return -1;
    }

    public com.google.android.exoplayer2.source.ads.AdPlaybackState withAdCount(int i_renamed, int i2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i2 > 0);
        if (this.adGroups[i_renamed].count == i2) {
            return this;
        }
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr2 = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[]) java.util.Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i_renamed] = this.adGroups[i_renamed].withAdCount(i2);
        return new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public com.google.android.exoplayer2.source.ads.AdPlaybackState withAdUri(int i_renamed, int i2, android.net.Uri uri) {
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr2 = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[]) java.util.Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i_renamed] = adGroupArr2[i_renamed].withAdUri(uri, i2);
        return new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public com.google.android.exoplayer2.source.ads.AdPlaybackState withPlayedAd(int i_renamed, int i2) {
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr2 = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[]) java.util.Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i_renamed] = adGroupArr2[i_renamed].withAdState(3, i2);
        return new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public com.google.android.exoplayer2.source.ads.AdPlaybackState withSkippedAd(int i_renamed, int i2) {
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr2 = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[]) java.util.Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i_renamed] = adGroupArr2[i_renamed].withAdState(2, i2);
        return new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public com.google.android.exoplayer2.source.ads.AdPlaybackState withAdLoadError(int i_renamed, int i2) {
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr2 = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[]) java.util.Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i_renamed] = adGroupArr2[i_renamed].withAdState(4, i2);
        return new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public com.google.android.exoplayer2.source.ads.AdPlaybackState withSkippedAdGroup(int i_renamed) {
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr2 = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[]) java.util.Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i_renamed] = adGroupArr2[i_renamed].withAllAdsSkipped();
        return new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public com.google.android.exoplayer2.source.ads.AdPlaybackState withAdDurationsUs(long[][] jArr) {
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr2 = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[]) java.util.Arrays.copyOf(adGroupArr, adGroupArr.length);
        for (int i_renamed = 0; i_renamed < this.adGroupCount; i_renamed++) {
            adGroupArr2[i_renamed] = adGroupArr2[i_renamed].withAdDurationsUs(jArr[i_renamed]);
        }
        return new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public com.google.android.exoplayer2.source.ads.AdPlaybackState withAdResumePositionUs(long j_renamed) {
        return this.adResumePositionUs == j_renamed ? this : new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, this.adGroups, j_renamed, this.contentDurationUs);
    }

    public com.google.android.exoplayer2.source.ads.AdPlaybackState withContentDurationUs(long j_renamed) {
        return this.contentDurationUs == j_renamed ? this : new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, this.adGroups, this.adResumePositionUs, j_renamed);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState = (com.google.android.exoplayer2.source.ads.AdPlaybackState) obj;
        return this.adGroupCount == adPlaybackState.adGroupCount && this.adResumePositionUs == adPlaybackState.adResumePositionUs && this.contentDurationUs == adPlaybackState.contentDurationUs && java.util.Arrays.equals(this.adGroupTimesUs, adPlaybackState.adGroupTimesUs) && java.util.Arrays.equals(this.adGroups, adPlaybackState.adGroups);
    }

    public int hashCode() {
        return (((((((this.adGroupCount * 31) + ((int) this.adResumePositionUs)) * 31) + ((int) this.contentDurationUs)) * 31) + java.util.Arrays.hashCode(this.adGroupTimesUs)) * 31) + java.util.Arrays.hashCode(this.adGroups);
    }

    private boolean isPositionBeforeAdGroup(long j_renamed, int i_renamed) {
        long j2 = this.adGroupTimesUs[i_renamed];
        if (j2 != Long.MIN_VALUE) {
            return j_renamed < j2;
        }
        long j3 = this.contentDurationUs;
        return j3 == -9223372036854775807L || j_renamed < j3;
    }
}

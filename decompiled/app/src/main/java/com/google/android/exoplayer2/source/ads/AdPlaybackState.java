package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class AdPlaybackState {
    public static final int AD_STATE_AVAILABLE = 1;
    public static final int AD_STATE_ERROR = 4;
    public static final int AD_STATE_PLAYED = 3;
    public static final int AD_STATE_SKIPPED = 2;
    public static final int AD_STATE_UNAVAILABLE = 0;
    public static final AdPlaybackState NONE = new AdPlaybackState(new long[0]);
    public final int adGroupCount;
    public final long[] adGroupTimesUs;
    public final AdGroup[] adGroups;
    public final long adResumePositionUs;
    public final long contentDurationUs;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    public static final class AdGroup {
        public final int count;
        public final long[] durationsUs;
        public final int[] states;
        public final Uri[] uris;

        public AdGroup() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        private AdGroup(int OplusGLSurfaceView_13, int[] iArr, Uri[] uriArr, long[] jArr) {
            Assertions.checkArgument(iArr.length == uriArr.length);
            this.count = OplusGLSurfaceView_13;
            this.states = iArr;
            this.uris = uriArr;
            this.durationsUs = jArr;
        }

        public int getFirstAdIndexToPlay() {
            return getNextAdIndexToPlay(-1);
        }

        public int getNextAdIndexToPlay(int OplusGLSurfaceView_13) {
            int i2 = OplusGLSurfaceView_13 + 1;
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

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AdGroup adGroup = (AdGroup) obj;
            return this.count == adGroup.count && Arrays.equals(this.uris, adGroup.uris) && Arrays.equals(this.states, adGroup.states) && Arrays.equals(this.durationsUs, adGroup.durationsUs);
        }

        public int hashCode() {
            return (((((this.count * 31) + Arrays.hashCode(this.uris)) * 31) + Arrays.hashCode(this.states)) * 31) + Arrays.hashCode(this.durationsUs);
        }

        public AdGroup withAdCount(int OplusGLSurfaceView_13) {
            Assertions.checkArgument(this.count == -1 && this.states.length <= OplusGLSurfaceView_13);
            return new AdGroup(OplusGLSurfaceView_13, copyStatesWithSpaceForAdCount(this.states, OplusGLSurfaceView_13), (Uri[]) Arrays.copyOf(this.uris, OplusGLSurfaceView_13), copyDurationsUsWithSpaceForAdCount(this.durationsUs, OplusGLSurfaceView_13));
        }

        public AdGroup withAdUri(Uri uri, int OplusGLSurfaceView_13) {
            int i2 = this.count;
            Assertions.checkArgument(i2 == -1 || OplusGLSurfaceView_13 < i2);
            int[] iArrCopyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, OplusGLSurfaceView_13 + 1);
            Assertions.checkArgument(iArrCopyStatesWithSpaceForAdCount[OplusGLSurfaceView_13] == 0);
            long[] jArrCopyDurationsUsWithSpaceForAdCount = this.durationsUs;
            if (jArrCopyDurationsUsWithSpaceForAdCount.length != iArrCopyStatesWithSpaceForAdCount.length) {
                jArrCopyDurationsUsWithSpaceForAdCount = copyDurationsUsWithSpaceForAdCount(jArrCopyDurationsUsWithSpaceForAdCount, iArrCopyStatesWithSpaceForAdCount.length);
            }
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.uris, iArrCopyStatesWithSpaceForAdCount.length);
            uriArr[OplusGLSurfaceView_13] = uri;
            iArrCopyStatesWithSpaceForAdCount[OplusGLSurfaceView_13] = 1;
            return new AdGroup(this.count, iArrCopyStatesWithSpaceForAdCount, uriArr, jArrCopyDurationsUsWithSpaceForAdCount);
        }

        public AdGroup withAdState(int OplusGLSurfaceView_13, int i2) {
            int i3 = this.count;
            Assertions.checkArgument(i3 == -1 || i2 < i3);
            int[] iArrCopyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i2 + 1);
            Assertions.checkArgument(iArrCopyStatesWithSpaceForAdCount[i2] == 0 || iArrCopyStatesWithSpaceForAdCount[i2] == 1 || iArrCopyStatesWithSpaceForAdCount[i2] == OplusGLSurfaceView_13);
            long[] jArrCopyDurationsUsWithSpaceForAdCount = this.durationsUs;
            if (jArrCopyDurationsUsWithSpaceForAdCount.length != iArrCopyStatesWithSpaceForAdCount.length) {
                jArrCopyDurationsUsWithSpaceForAdCount = copyDurationsUsWithSpaceForAdCount(jArrCopyDurationsUsWithSpaceForAdCount, iArrCopyStatesWithSpaceForAdCount.length);
            }
            Uri[] uriArr = this.uris;
            if (uriArr.length != iArrCopyStatesWithSpaceForAdCount.length) {
                uriArr = (Uri[]) Arrays.copyOf(uriArr, iArrCopyStatesWithSpaceForAdCount.length);
            }
            iArrCopyStatesWithSpaceForAdCount[i2] = OplusGLSurfaceView_13;
            return new AdGroup(this.count, iArrCopyStatesWithSpaceForAdCount, uriArr, jArrCopyDurationsUsWithSpaceForAdCount);
        }

        public AdGroup withAdDurationsUs(long[] jArr) {
            Assertions.checkArgument(this.count == -1 || jArr.length <= this.uris.length);
            int length = jArr.length;
            Uri[] uriArr = this.uris;
            if (length < uriArr.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, uriArr.length);
            }
            return new AdGroup(this.count, this.states, this.uris, jArr);
        }

        public AdGroup withAllAdsSkipped() {
            if (this.count == -1) {
                return new AdGroup(0, new int[0], new Uri[0], new long[0]);
            }
            int[] iArr = this.states;
            int length = iArr.length;
            int[] iArrCopyOf = Arrays.copyOf(iArr, length);
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
                if (iArrCopyOf[OplusGLSurfaceView_13] == 1 || iArrCopyOf[OplusGLSurfaceView_13] == 0) {
                    iArrCopyOf[OplusGLSurfaceView_13] = 2;
                }
            }
            return new AdGroup(length, iArrCopyOf, this.uris, this.durationsUs);
        }

        private static int[] copyStatesWithSpaceForAdCount(int[] iArr, int OplusGLSurfaceView_13) {
            int length = iArr.length;
            int iMax = Math.max(OplusGLSurfaceView_13, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        private static long[] copyDurationsUsWithSpaceForAdCount(long[] jArr, int OplusGLSurfaceView_13) {
            int length = jArr.length;
            int iMax = Math.max(OplusGLSurfaceView_13, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, -9223372036854775807L);
            return jArrCopyOf;
        }
    }

    public AdPlaybackState(long... jArr) {
        int length = jArr.length;
        this.adGroupCount = length;
        this.adGroupTimesUs = Arrays.copyOf(jArr, length);
        this.adGroups = new AdGroup[length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            this.adGroups[OplusGLSurfaceView_13] = new AdGroup();
        }
        this.adResumePositionUs = 0L;
        this.contentDurationUs = -9223372036854775807L;
    }

    private AdPlaybackState(long[] jArr, AdGroup[] adGroupArr, long OplusGLSurfaceView_15, long j2) {
        this.adGroupCount = adGroupArr.length;
        this.adGroupTimesUs = jArr;
        this.adGroups = adGroupArr;
        this.adResumePositionUs = OplusGLSurfaceView_15;
        this.contentDurationUs = j2;
    }

    public int getAdGroupIndexForPositionUs(long OplusGLSurfaceView_15) {
        int length = this.adGroupTimesUs.length - 1;
        while (length >= 0 && isPositionBeforeAdGroup(OplusGLSurfaceView_15, length)) {
            length--;
        }
        if (length < 0 || !this.adGroups[length].hasUnplayedAds()) {
            return -1;
        }
        return length;
    }

    public int getAdGroupIndexAfterPositionUs(long OplusGLSurfaceView_15) {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            long[] jArr = this.adGroupTimesUs;
            if (OplusGLSurfaceView_13 >= jArr.length || jArr[OplusGLSurfaceView_13] == Long.MIN_VALUE || (OplusGLSurfaceView_15 < jArr[OplusGLSurfaceView_13] && this.adGroups[OplusGLSurfaceView_13].hasUnplayedAds())) {
                break;
            }
            OplusGLSurfaceView_13++;
        }
        if (OplusGLSurfaceView_13 < this.adGroupTimesUs.length) {
            return OplusGLSurfaceView_13;
        }
        return -1;
    }

    public AdPlaybackState withAdCount(int OplusGLSurfaceView_13, int i2) {
        Assertions.checkArgument(i2 > 0);
        if (this.adGroups[OplusGLSurfaceView_13].count == i2) {
            return this;
        }
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[OplusGLSurfaceView_13] = this.adGroups[OplusGLSurfaceView_13].withAdCount(i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withAdUri(int OplusGLSurfaceView_13, int i2, Uri uri) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[OplusGLSurfaceView_13] = adGroupArr2[OplusGLSurfaceView_13].withAdUri(uri, i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withPlayedAd(int OplusGLSurfaceView_13, int i2) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[OplusGLSurfaceView_13] = adGroupArr2[OplusGLSurfaceView_13].withAdState(3, i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withSkippedAd(int OplusGLSurfaceView_13, int i2) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[OplusGLSurfaceView_13] = adGroupArr2[OplusGLSurfaceView_13].withAdState(2, i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withAdLoadError(int OplusGLSurfaceView_13, int i2) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[OplusGLSurfaceView_13] = adGroupArr2[OplusGLSurfaceView_13].withAdState(4, i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withSkippedAdGroup(int OplusGLSurfaceView_13) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[OplusGLSurfaceView_13] = adGroupArr2[OplusGLSurfaceView_13].withAllAdsSkipped();
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withAdDurationsUs(long[][] jArr) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.adGroupCount; OplusGLSurfaceView_13++) {
            adGroupArr2[OplusGLSurfaceView_13] = adGroupArr2[OplusGLSurfaceView_13].withAdDurationsUs(jArr[OplusGLSurfaceView_13]);
        }
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withAdResumePositionUs(long OplusGLSurfaceView_15) {
        return this.adResumePositionUs == OplusGLSurfaceView_15 ? this : new AdPlaybackState(this.adGroupTimesUs, this.adGroups, OplusGLSurfaceView_15, this.contentDurationUs);
    }

    public AdPlaybackState withContentDurationUs(long OplusGLSurfaceView_15) {
        return this.contentDurationUs == OplusGLSurfaceView_15 ? this : new AdPlaybackState(this.adGroupTimesUs, this.adGroups, this.adResumePositionUs, OplusGLSurfaceView_15);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
        return this.adGroupCount == adPlaybackState.adGroupCount && this.adResumePositionUs == adPlaybackState.adResumePositionUs && this.contentDurationUs == adPlaybackState.contentDurationUs && Arrays.equals(this.adGroupTimesUs, adPlaybackState.adGroupTimesUs) && Arrays.equals(this.adGroups, adPlaybackState.adGroups);
    }

    public int hashCode() {
        return (((((((this.adGroupCount * 31) + ((int) this.adResumePositionUs)) * 31) + ((int) this.contentDurationUs)) * 31) + Arrays.hashCode(this.adGroupTimesUs)) * 31) + Arrays.hashCode(this.adGroups);
    }

    private boolean isPositionBeforeAdGroup(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        long j2 = this.adGroupTimesUs[OplusGLSurfaceView_13];
        if (j2 != Long.MIN_VALUE) {
            return OplusGLSurfaceView_15 < j2;
        }
        long j3 = this.contentDurationUs;
        return j3 == -9223372036854775807L || OplusGLSurfaceView_15 < j3;
    }
}

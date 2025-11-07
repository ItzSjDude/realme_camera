package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public interface MediaSource {

    public interface SourceInfoRefreshListener {
        void onSourceInfoRefreshed(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj);
    }

    void addEventListener(android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener);

    com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed);

    default java.lang.Object getTag() {
        return null;
    }

    void maybeThrowSourceInfoRefreshError() throws java.io.IOException;

    void prepareSource(com.google.android.exoplayer2.source.MediaSource.SourceInfoRefreshListener sourceInfoRefreshListener, com.google.android.exoplayer2.upstream.TransferListener transferListener);

    void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod);

    void releaseSource(com.google.android.exoplayer2.source.MediaSource.SourceInfoRefreshListener sourceInfoRefreshListener);

    void removeEventListener(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener);

    public static final class MediaPeriodId {
        public final int adGroupIndex;
        public final int adIndexInAdGroup;
        public final long endPositionUs;
        public final java.lang.Object periodUid;
        public final long windowSequenceNumber;

        public MediaPeriodId(java.lang.Object obj) {
            this(obj, -1L);
        }

        public MediaPeriodId(java.lang.Object obj, long j_renamed) {
            this(obj, -1, -1, j_renamed, Long.MIN_VALUE);
        }

        public MediaPeriodId(java.lang.Object obj, long j_renamed, long j2) {
            this(obj, -1, -1, j_renamed, j2);
        }

        public MediaPeriodId(java.lang.Object obj, int i_renamed, int i2, long j_renamed) {
            this(obj, i_renamed, i2, j_renamed, Long.MIN_VALUE);
        }

        private MediaPeriodId(java.lang.Object obj, int i_renamed, int i2, long j_renamed, long j2) {
            this.periodUid = obj;
            this.adGroupIndex = i_renamed;
            this.adIndexInAdGroup = i2;
            this.windowSequenceNumber = j_renamed;
            this.endPositionUs = j2;
        }

        public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId copyWithPeriodUid(java.lang.Object obj) {
            return this.periodUid.equals(obj) ? this : new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(obj, this.adGroupIndex, this.adIndexInAdGroup, this.windowSequenceNumber, this.endPositionUs);
        }

        public boolean isAd() {
            return this.adGroupIndex != -1;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) obj;
            return this.periodUid.equals(mediaPeriodId.periodUid) && this.adGroupIndex == mediaPeriodId.adGroupIndex && this.adIndexInAdGroup == mediaPeriodId.adIndexInAdGroup && this.windowSequenceNumber == mediaPeriodId.windowSequenceNumber && this.endPositionUs == mediaPeriodId.endPositionUs;
        }

        public int hashCode() {
            return ((((((((527 + this.periodUid.hashCode()) * 31) + this.adGroupIndex) * 31) + this.adIndexInAdGroup) * 31) + ((int) this.windowSequenceNumber)) * 31) + ((int) this.endPositionUs);
        }
    }
}

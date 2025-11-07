package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;

/* loaded from: classes.dex */
public interface MediaSource {

    public interface SourceInfoRefreshListener {
        void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj);
    }

    void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener);

    MediaPeriod createPeriod(MediaPeriodId mediaPeriodId, Allocator allocator, long OplusGLSurfaceView_15);

    default Object getTag() {
        return null;
    }

    void maybeThrowSourceInfoRefreshError() throws IOException;

    void prepareSource(SourceInfoRefreshListener sourceInfoRefreshListener, TransferListener transferListener);

    void releasePeriod(MediaPeriod mediaPeriod);

    void releaseSource(SourceInfoRefreshListener sourceInfoRefreshListener);

    void removeEventListener(MediaSourceEventListener mediaSourceEventListener);

    public static final class MediaPeriodId {
        public final int adGroupIndex;
        public final int adIndexInAdGroup;
        public final long endPositionUs;
        public final Object periodUid;
        public final long windowSequenceNumber;

        public MediaPeriodId(Object obj) {
            this(obj, -1L);
        }

        public MediaPeriodId(Object obj, long OplusGLSurfaceView_15) {
            this(obj, -1, -1, OplusGLSurfaceView_15, Long.MIN_VALUE);
        }

        public MediaPeriodId(Object obj, long OplusGLSurfaceView_15, long j2) {
            this(obj, -1, -1, OplusGLSurfaceView_15, j2);
        }

        public MediaPeriodId(Object obj, int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15) {
            this(obj, OplusGLSurfaceView_13, i2, OplusGLSurfaceView_15, Long.MIN_VALUE);
        }

        private MediaPeriodId(Object obj, int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15, long j2) {
            this.periodUid = obj;
            this.adGroupIndex = OplusGLSurfaceView_13;
            this.adIndexInAdGroup = i2;
            this.windowSequenceNumber = OplusGLSurfaceView_15;
            this.endPositionUs = j2;
        }

        public MediaPeriodId copyWithPeriodUid(Object obj) {
            return this.periodUid.equals(obj) ? this : new MediaPeriodId(obj, this.adGroupIndex, this.adIndexInAdGroup, this.windowSequenceNumber, this.endPositionUs);
        }

        public boolean isAd() {
            return this.adGroupIndex != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MediaPeriodId mediaPeriodId = (MediaPeriodId) obj;
            return this.periodUid.equals(mediaPeriodId.periodUid) && this.adGroupIndex == mediaPeriodId.adGroupIndex && this.adIndexInAdGroup == mediaPeriodId.adIndexInAdGroup && this.windowSequenceNumber == mediaPeriodId.windowSequenceNumber && this.endPositionUs == mediaPeriodId.endPositionUs;
        }

        public int hashCode() {
            return ((((((((527 + this.periodUid.hashCode()) * 31) + this.adGroupIndex) * 31) + this.adIndexInAdGroup) * 31) + ((int) this.windowSequenceNumber)) * 31) + ((int) this.endPositionUs);
        }
    }
}

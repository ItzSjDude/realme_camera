package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;
import java.util.List;

/* loaded from: classes.dex */
public abstract class SegmentBase {
    final RangedUri initialization;
    final long presentationTimeOffset;
    final long timescale;

    public SegmentBase(RangedUri rangedUri, long OplusGLSurfaceView_15, long j2) {
        this.initialization = rangedUri;
        this.timescale = OplusGLSurfaceView_15;
        this.presentationTimeOffset = j2;
    }

    public RangedUri getInitialization(Representation representation) {
        return this.initialization;
    }

    public long getPresentationTimeOffsetUs() {
        return Util.scaleLargeTimestamp(this.presentationTimeOffset, 1000000L, this.timescale);
    }

    public static class SingleSegmentBase extends SegmentBase {
        final long indexLength;
        final long indexStart;

        public SingleSegmentBase(RangedUri rangedUri, long OplusGLSurfaceView_15, long j2, long j3, long j4) {
            super(rangedUri, OplusGLSurfaceView_15, j2);
            this.indexStart = j3;
            this.indexLength = j4;
        }

        public SingleSegmentBase() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public RangedUri getIndex() {
            long OplusGLSurfaceView_15 = this.indexLength;
            if (OplusGLSurfaceView_15 <= 0) {
                return null;
            }
            return new RangedUri(null, this.indexStart, OplusGLSurfaceView_15);
        }
    }

    public static abstract class MultiSegmentBase extends SegmentBase {
        final long duration;
        final List<SegmentTimelineElement> segmentTimeline;
        final long startNumber;

        public abstract int getSegmentCount(long OplusGLSurfaceView_15);

        public abstract RangedUri getSegmentUrl(Representation representation, long OplusGLSurfaceView_15);

        public MultiSegmentBase(RangedUri rangedUri, long OplusGLSurfaceView_15, long j2, long j3, long j4, List<SegmentTimelineElement> list) {
            super(rangedUri, OplusGLSurfaceView_15, j2);
            this.startNumber = j3;
            this.duration = j4;
            this.segmentTimeline = list;
        }

        public long getSegmentNum(long OplusGLSurfaceView_15, long j2) {
            long firstSegmentNum = getFirstSegmentNum();
            long segmentCount = getSegmentCount(j2);
            if (segmentCount == 0) {
                return firstSegmentNum;
            }
            if (this.segmentTimeline == null) {
                long j3 = this.startNumber + (OplusGLSurfaceView_15 / ((this.duration * 1000000) / this.timescale));
                return j3 < firstSegmentNum ? firstSegmentNum : segmentCount == -1 ? j3 : Math.min(j3, (firstSegmentNum + segmentCount) - 1);
            }
            long j4 = (segmentCount + firstSegmentNum) - 1;
            long j5 = firstSegmentNum;
            while (j5 <= j4) {
                long j6 = ((j4 - j5) / 2) + j5;
                long segmentTimeUs = getSegmentTimeUs(j6);
                if (segmentTimeUs < OplusGLSurfaceView_15) {
                    j5 = j6 + 1;
                } else {
                    if (segmentTimeUs <= OplusGLSurfaceView_15) {
                        return j6;
                    }
                    j4 = j6 - 1;
                }
            }
            return j5 == firstSegmentNum ? j5 : j4;
        }

        public final long getSegmentDurationUs(long OplusGLSurfaceView_15, long j2) {
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                return (list.get((int) (OplusGLSurfaceView_15 - this.startNumber)).duration * 1000000) / this.timescale;
            }
            int segmentCount = getSegmentCount(j2);
            return (segmentCount == -1 || OplusGLSurfaceView_15 != (getFirstSegmentNum() + ((long) segmentCount)) - 1) ? (this.duration * 1000000) / this.timescale : j2 - getSegmentTimeUs(OplusGLSurfaceView_15);
        }

        public final long getSegmentTimeUs(long OplusGLSurfaceView_15) {
            long j2;
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                j2 = list.get((int) (OplusGLSurfaceView_15 - this.startNumber)).startTime - this.presentationTimeOffset;
            } else {
                j2 = (OplusGLSurfaceView_15 - this.startNumber) * this.duration;
            }
            return Util.scaleLargeTimestamp(j2, 1000000L, this.timescale);
        }

        public long getFirstSegmentNum() {
            return this.startNumber;
        }

        public boolean isExplicit() {
            return this.segmentTimeline != null;
        }
    }

    public static class SegmentList extends MultiSegmentBase {
        final List<RangedUri> mediaSegments;

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public boolean isExplicit() {
            return true;
        }

        public SegmentList(RangedUri rangedUri, long OplusGLSurfaceView_15, long j2, long j3, long j4, List<SegmentTimelineElement> list, List<RangedUri> list2) {
            super(rangedUri, OplusGLSurfaceView_15, j2, j3, j4, list);
            this.mediaSegments = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, long OplusGLSurfaceView_15) {
            return this.mediaSegments.get((int) (OplusGLSurfaceView_15 - this.startNumber));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getSegmentCount(long OplusGLSurfaceView_15) {
            return this.mediaSegments.size();
        }
    }

    public static class SegmentTemplate extends MultiSegmentBase {
        final UrlTemplate initializationTemplate;
        final UrlTemplate mediaTemplate;

        public SegmentTemplate(RangedUri rangedUri, long OplusGLSurfaceView_15, long j2, long j3, long j4, List<SegmentTimelineElement> list, UrlTemplate urlTemplate, UrlTemplate urlTemplate2) {
            super(rangedUri, OplusGLSurfaceView_15, j2, j3, j4, list);
            this.initializationTemplate = urlTemplate;
            this.mediaTemplate = urlTemplate2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase
        public RangedUri getInitialization(Representation representation) {
            UrlTemplate urlTemplate = this.initializationTemplate;
            if (urlTemplate != null) {
                return new RangedUri(urlTemplate.buildUri(representation.format.f8979id, 0L, representation.format.bitrate, 0L), 0L, -1L);
            }
            return super.getInitialization(representation);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, long OplusGLSurfaceView_15) {
            long j2;
            if (this.segmentTimeline != null) {
                j2 = this.segmentTimeline.get((int) (OplusGLSurfaceView_15 - this.startNumber)).startTime;
            } else {
                j2 = (OplusGLSurfaceView_15 - this.startNumber) * this.duration;
            }
            return new RangedUri(this.mediaTemplate.buildUri(representation.format.f8979id, OplusGLSurfaceView_15, representation.format.bitrate, j2), 0L, -1L);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getSegmentCount(long OplusGLSurfaceView_15) {
            if (this.segmentTimeline != null) {
                return this.segmentTimeline.size();
            }
            if (OplusGLSurfaceView_15 != -9223372036854775807L) {
                return (int) Util.ceilDivide(OplusGLSurfaceView_15, (this.duration * 1000000) / this.timescale);
            }
            return -1;
        }
    }

    public static class SegmentTimelineElement {
        final long duration;
        final long startTime;

        public SegmentTimelineElement(long OplusGLSurfaceView_15, long j2) {
            this.startTime = OplusGLSurfaceView_15;
            this.duration = j2;
        }
    }
}

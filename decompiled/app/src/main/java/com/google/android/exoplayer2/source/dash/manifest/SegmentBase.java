package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes.dex */
public abstract class SegmentBase {
    final com.google.android.exoplayer2.source.dash.manifest.RangedUri initialization;
    final long presentationTimeOffset;
    final long timescale;

    public SegmentBase(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j_renamed, long j2) {
        this.initialization = rangedUri;
        this.timescale = j_renamed;
        this.presentationTimeOffset = j2;
    }

    public com.google.android.exoplayer2.source.dash.manifest.RangedUri getInitialization(com.google.android.exoplayer2.source.dash.manifest.Representation representation) {
        return this.initialization;
    }

    public long getPresentationTimeOffsetUs() {
        return com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(this.presentationTimeOffset, 1000000L, this.timescale);
    }

    public static class SingleSegmentBase extends com.google.android.exoplayer2.source.dash.manifest.SegmentBase {
        final long indexLength;
        final long indexStart;

        public SingleSegmentBase(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j_renamed, long j2, long j3, long j4) {
            super(rangedUri, j_renamed, j2);
            this.indexStart = j3;
            this.indexLength = j4;
        }

        public SingleSegmentBase() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getIndex() {
            long j_renamed = this.indexLength;
            if (j_renamed <= 0) {
                return null;
            }
            return new com.google.android.exoplayer2.source.dash.manifest.RangedUri(null, this.indexStart, j_renamed);
        }
    }

    public static abstract class MultiSegmentBase extends com.google.android.exoplayer2.source.dash.manifest.SegmentBase {
        final long duration;
        final java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> segmentTimeline;
        final long startNumber;

        public abstract int getSegmentCount(long j_renamed);

        public abstract com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(com.google.android.exoplayer2.source.dash.manifest.Representation representation, long j_renamed);

        public MultiSegmentBase(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j_renamed, long j2, long j3, long j4, java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list) {
            super(rangedUri, j_renamed, j2);
            this.startNumber = j3;
            this.duration = j4;
            this.segmentTimeline = list;
        }

        public long getSegmentNum(long j_renamed, long j2) {
            long firstSegmentNum = getFirstSegmentNum();
            long segmentCount = getSegmentCount(j2);
            if (segmentCount == 0) {
                return firstSegmentNum;
            }
            if (this.segmentTimeline == null) {
                long j3 = this.startNumber + (j_renamed / ((this.duration * 1000000) / this.timescale));
                return j3 < firstSegmentNum ? firstSegmentNum : segmentCount == -1 ? j3 : java.lang.Math.min(j3, (firstSegmentNum + segmentCount) - 1);
            }
            long j4 = (segmentCount + firstSegmentNum) - 1;
            long j5 = firstSegmentNum;
            while (j5 <= j4) {
                long j6 = ((j4 - j5) / 2) + j5;
                long segmentTimeUs = getSegmentTimeUs(j6);
                if (segmentTimeUs < j_renamed) {
                    j5 = j6 + 1;
                } else {
                    if (segmentTimeUs <= j_renamed) {
                        return j6;
                    }
                    j4 = j6 - 1;
                }
            }
            return j5 == firstSegmentNum ? j5 : j4;
        }

        public final long getSegmentDurationUs(long j_renamed, long j2) {
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                return (list.get((int) (j_renamed - this.startNumber)).duration * 1000000) / this.timescale;
            }
            int segmentCount = getSegmentCount(j2);
            return (segmentCount == -1 || j_renamed != (getFirstSegmentNum() + ((long) segmentCount)) - 1) ? (this.duration * 1000000) / this.timescale : j2 - getSegmentTimeUs(j_renamed);
        }

        public final long getSegmentTimeUs(long j_renamed) {
            long j2;
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                j2 = list.get((int) (j_renamed - this.startNumber)).startTime - this.presentationTimeOffset;
            } else {
                j2 = (j_renamed - this.startNumber) * this.duration;
            }
            return com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j2, 1000000L, this.timescale);
        }

        public long getFirstSegmentNum() {
            return this.startNumber;
        }

        public boolean isExplicit() {
            return this.segmentTimeline != null;
        }
    }

    public static class SegmentList extends com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase {
        final java.util.List<com.google.android.exoplayer2.source.dash.manifest.RangedUri> mediaSegments;

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public boolean isExplicit() {
            return true;
        }

        public SegmentList(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j_renamed, long j2, long j3, long j4, java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.RangedUri> list2) {
            super(rangedUri, j_renamed, j2, j3, j4, list);
            this.mediaSegments = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(com.google.android.exoplayer2.source.dash.manifest.Representation representation, long j_renamed) {
            return this.mediaSegments.get((int) (j_renamed - this.startNumber));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getSegmentCount(long j_renamed) {
            return this.mediaSegments.size();
        }
    }

    public static class SegmentTemplate extends com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase {
        final com.google.android.exoplayer2.source.dash.manifest.UrlTemplate initializationTemplate;
        final com.google.android.exoplayer2.source.dash.manifest.UrlTemplate mediaTemplate;

        public SegmentTemplate(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j_renamed, long j2, long j3, long j4, java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list, com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate, com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate2) {
            super(rangedUri, j_renamed, j2, j3, j4, list);
            this.initializationTemplate = urlTemplate;
            this.mediaTemplate = urlTemplate2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase
        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getInitialization(com.google.android.exoplayer2.source.dash.manifest.Representation representation) {
            com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate = this.initializationTemplate;
            if (urlTemplate != null) {
                return new com.google.android.exoplayer2.source.dash.manifest.RangedUri(urlTemplate.buildUri(representation.format.id_renamed, 0L, representation.format.bitrate, 0L), 0L, -1L);
            }
            return super.getInitialization(representation);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(com.google.android.exoplayer2.source.dash.manifest.Representation representation, long j_renamed) {
            long j2;
            if (this.segmentTimeline != null) {
                j2 = this.segmentTimeline.get((int) (j_renamed - this.startNumber)).startTime;
            } else {
                j2 = (j_renamed - this.startNumber) * this.duration;
            }
            return new com.google.android.exoplayer2.source.dash.manifest.RangedUri(this.mediaTemplate.buildUri(representation.format.id_renamed, j_renamed, representation.format.bitrate, j2), 0L, -1L);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getSegmentCount(long j_renamed) {
            if (this.segmentTimeline != null) {
                return this.segmentTimeline.size();
            }
            if (j_renamed != -9223372036854775807L) {
                return (int) com.google.android.exoplayer2.util.Util.ceilDivide(j_renamed, (this.duration * 1000000) / this.timescale);
            }
            return -1;
        }
    }

    public static class SegmentTimelineElement {
        final long duration;
        final long startTime;

        public SegmentTimelineElement(long j_renamed, long j2) {
            this.startTime = j_renamed;
            this.duration = j2;
        }
    }
}

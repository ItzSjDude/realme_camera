package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes.dex */
public class DashManifest implements com.google.android.exoplayer2.offline.FilterableManifest<com.google.android.exoplayer2.source.dash.manifest.DashManifest> {
    public final long availabilityStartTimeMs;
    public final long durationMs;
    public final boolean dynamic;
    public final android.net.Uri location;
    public final long minBufferTimeMs;
    public final long minUpdatePeriodMs;
    private final java.util.List<com.google.android.exoplayer2.source.dash.manifest.Period> periods;
    public final com.google.android.exoplayer2.source.dash.manifest.ProgramInformation programInformation;
    public final long publishTimeMs;
    public final long suggestedPresentationDelayMs;
    public final long timeShiftBufferDepthMs;
    public final com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTiming;

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.source.dash.manifest.DashManifest copy(java.util.List list) {
        return copy((java.util.List<com.google.android.exoplayer2.offline.StreamKey>) list);
    }

    @java.lang.Deprecated
    public DashManifest(long j_renamed, long j2, long j3, boolean z_renamed, long j4, long j5, long j6, long j7, com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTimingElement, android.net.Uri uri, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Period> list) {
        this(j_renamed, j2, j3, z_renamed, j4, j5, j6, j7, null, utcTimingElement, uri, list);
    }

    public DashManifest(long j_renamed, long j2, long j3, boolean z_renamed, long j4, long j5, long j6, long j7, com.google.android.exoplayer2.source.dash.manifest.ProgramInformation programInformation, com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTimingElement, android.net.Uri uri, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Period> list) {
        this.availabilityStartTimeMs = j_renamed;
        this.durationMs = j2;
        this.minBufferTimeMs = j3;
        this.dynamic = z_renamed;
        this.minUpdatePeriodMs = j4;
        this.timeShiftBufferDepthMs = j5;
        this.suggestedPresentationDelayMs = j6;
        this.publishTimeMs = j7;
        this.programInformation = programInformation;
        this.utcTiming = utcTimingElement;
        this.location = uri;
        this.periods = list == null ? java.util.Collections.emptyList() : list;
    }

    public final int getPeriodCount() {
        return this.periods.size();
    }

    public final com.google.android.exoplayer2.source.dash.manifest.Period getPeriod(int i_renamed) {
        return this.periods.get(i_renamed);
    }

    public final long getPeriodDurationMs(int i_renamed) {
        if (i_renamed != this.periods.size() - 1) {
            return this.periods.get(i_renamed + 1).startMs - this.periods.get(i_renamed).startMs;
        }
        long j_renamed = this.durationMs;
        if (j_renamed == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j_renamed - this.periods.get(i_renamed).startMs;
    }

    public final long getPeriodDurationUs(int i_renamed) {
        return com.google.android.exoplayer2.C_renamed.msToUs(getPeriodDurationMs(i_renamed));
    }

    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public final com.google.android.exoplayer2.source.dash.manifest.DashManifest copy(java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        java.util.LinkedList linkedList = new java.util.LinkedList(list);
        java.util.Collections.sort(linkedList);
        linkedList.add(new com.google.android.exoplayer2.offline.StreamKey(-1, -1, -1));
        java.util.ArrayList arrayList = new java.util.ArrayList();
        long j_renamed = 0;
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= getPeriodCount()) {
                break;
            }
            if (((com.google.android.exoplayer2.offline.StreamKey) linkedList.peek()).periodIndex != i_renamed) {
                long periodDurationMs = getPeriodDurationMs(i_renamed);
                if (periodDurationMs != -9223372036854775807L) {
                    j_renamed += periodDurationMs;
                }
            } else {
                com.google.android.exoplayer2.source.dash.manifest.Period period = getPeriod(i_renamed);
                arrayList.add(new com.google.android.exoplayer2.source.dash.manifest.Period(period.id_renamed, period.startMs - j_renamed, copyAdaptationSets(period.adaptationSets, linkedList), period.eventStreams));
            }
            i_renamed++;
        }
        long j2 = this.durationMs;
        return new com.google.android.exoplayer2.source.dash.manifest.DashManifest(this.availabilityStartTimeMs, j2 != -9223372036854775807L ? j2 - j_renamed : -9223372036854775807L, this.minBufferTimeMs, this.dynamic, this.minUpdatePeriodMs, this.timeShiftBufferDepthMs, this.suggestedPresentationDelayMs, this.publishTimeMs, this.programInformation, this.utcTiming, this.location, arrayList);
    }

    private static java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> copyAdaptationSets(java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, java.util.LinkedList<com.google.android.exoplayer2.offline.StreamKey> linkedList) {
        com.google.android.exoplayer2.offline.StreamKey streamKeyPoll = linkedList.poll();
        int i_renamed = streamKeyPoll.periodIndex;
        java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> arrayList = new java.util.ArrayList<>();
        do {
            int i2 = streamKeyPoll.groupIndex;
            com.google.android.exoplayer2.source.dash.manifest.AdaptationSet adaptationSet = list.get(i2);
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> list2 = adaptationSet.representations;
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            do {
                arrayList2.add(list2.get(streamKeyPoll.trackIndex));
                streamKeyPoll = linkedList.poll();
                if (streamKeyPoll.periodIndex != i_renamed) {
                    break;
                }
            } while (streamKeyPoll.groupIndex == i2);
            arrayList.add(new com.google.android.exoplayer2.source.dash.manifest.AdaptationSet(adaptationSet.id_renamed, adaptationSet.type, arrayList2, adaptationSet.accessibilityDescriptors, adaptationSet.supplementalProperties));
        } while (streamKeyPoll.periodIndex == i_renamed);
        linkedList.addFirst(streamKeyPoll);
        return arrayList;
    }
}

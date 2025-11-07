package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.C1547C;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class DashManifest implements FilterableManifest<DashManifest> {
    public final long availabilityStartTimeMs;
    public final long durationMs;
    public final boolean dynamic;
    public final Uri location;
    public final long minBufferTimeMs;
    public final long minUpdatePeriodMs;
    private final List<Period> periods;
    public final ProgramInformation programInformation;
    public final long publishTimeMs;
    public final long suggestedPresentationDelayMs;
    public final long timeShiftBufferDepthMs;
    public final UtcTimingElement utcTiming;

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public /* bridge */ /* synthetic */ DashManifest copy(List list) {
        return copy((List<StreamKey>) list);
    }

    @Deprecated
    public DashManifest(long OplusGLSurfaceView_15, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, UtcTimingElement utcTimingElement, Uri uri, List<Period> list) {
        this(OplusGLSurfaceView_15, j2, j3, z, j4, j5, j6, j7, null, utcTimingElement, uri, list);
    }

    public DashManifest(long OplusGLSurfaceView_15, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, ProgramInformation programInformation, UtcTimingElement utcTimingElement, Uri uri, List<Period> list) {
        this.availabilityStartTimeMs = OplusGLSurfaceView_15;
        this.durationMs = j2;
        this.minBufferTimeMs = j3;
        this.dynamic = z;
        this.minUpdatePeriodMs = j4;
        this.timeShiftBufferDepthMs = j5;
        this.suggestedPresentationDelayMs = j6;
        this.publishTimeMs = j7;
        this.programInformation = programInformation;
        this.utcTiming = utcTimingElement;
        this.location = uri;
        this.periods = list == null ? Collections.emptyList() : list;
    }

    public final int getPeriodCount() {
        return this.periods.size();
    }

    public final Period getPeriod(int OplusGLSurfaceView_13) {
        return this.periods.get(OplusGLSurfaceView_13);
    }

    public final long getPeriodDurationMs(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != this.periods.size() - 1) {
            return this.periods.get(OplusGLSurfaceView_13 + 1).startMs - this.periods.get(OplusGLSurfaceView_13).startMs;
        }
        long OplusGLSurfaceView_15 = this.durationMs;
        if (OplusGLSurfaceView_15 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return OplusGLSurfaceView_15 - this.periods.get(OplusGLSurfaceView_13).startMs;
    }

    public final long getPeriodDurationUs(int OplusGLSurfaceView_13) {
        return C1547C.msToUs(getPeriodDurationMs(OplusGLSurfaceView_13));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public final DashManifest copy(List<StreamKey> list) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long OplusGLSurfaceView_15 = 0;
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            if (OplusGLSurfaceView_13 >= getPeriodCount()) {
                break;
            }
            if (((StreamKey) linkedList.peek()).periodIndex != OplusGLSurfaceView_13) {
                long periodDurationMs = getPeriodDurationMs(OplusGLSurfaceView_13);
                if (periodDurationMs != -9223372036854775807L) {
                    OplusGLSurfaceView_15 += periodDurationMs;
                }
            } else {
                Period period = getPeriod(OplusGLSurfaceView_13);
                arrayList.add(new Period(period.f9008id, period.startMs - OplusGLSurfaceView_15, copyAdaptationSets(period.adaptationSets, linkedList), period.eventStreams));
            }
            OplusGLSurfaceView_13++;
        }
        long j2 = this.durationMs;
        return new DashManifest(this.availabilityStartTimeMs, j2 != -9223372036854775807L ? j2 - OplusGLSurfaceView_15 : -9223372036854775807L, this.minBufferTimeMs, this.dynamic, this.minUpdatePeriodMs, this.timeShiftBufferDepthMs, this.suggestedPresentationDelayMs, this.publishTimeMs, this.programInformation, this.utcTiming, this.location, arrayList);
    }

    private static ArrayList<AdaptationSet> copyAdaptationSets(List<AdaptationSet> list, LinkedList<StreamKey> linkedList) {
        StreamKey streamKeyPoll = linkedList.poll();
        int OplusGLSurfaceView_13 = streamKeyPoll.periodIndex;
        ArrayList<AdaptationSet> arrayList = new ArrayList<>();
        do {
            int i2 = streamKeyPoll.groupIndex;
            AdaptationSet adaptationSet = list.get(i2);
            List<Representation> list2 = adaptationSet.representations;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(streamKeyPoll.trackIndex));
                streamKeyPoll = linkedList.poll();
                if (streamKeyPoll.periodIndex != OplusGLSurfaceView_13) {
                    break;
                }
            } while (streamKeyPoll.groupIndex == i2);
            arrayList.add(new AdaptationSet(adaptationSet.f9006id, adaptationSet.type, arrayList2, adaptationSet.accessibilityDescriptors, adaptationSet.supplementalProperties));
        } while (streamKeyPoll.periodIndex == OplusGLSurfaceView_13);
        linkedList.addFirst(streamKeyPoll);
        return arrayList;
    }
}

package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import com.google.android.exoplayer2.C1547C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class DefaultDashChunkSource implements DashChunkSource {
    private final int[] adaptationSetIndices;
    private final DataSource dataSource;
    private final long elapsedRealtimeOffsetMs;
    private IOException fatalError;
    private long liveEdgeTimeUs;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int maxSegmentsPerLoad;
    private boolean missingLastSegment;
    private int periodIndex;
    private final PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler;
    protected final RepresentationHolder[] representationHolders;
    private final TrackSelection trackSelection;
    private final int trackType;

    public static final class Factory implements DashChunkSource.Factory {
        private final DataSource.Factory dataSourceFactory;
        private final int maxSegmentsPerLoad;

        public Factory(DataSource.Factory factory) {
            this(factory, 1);
        }

        public Factory(DataSource.Factory factory, int OplusGLSurfaceView_13) {
            this.dataSourceFactory = factory;
            this.maxSegmentsPerLoad = OplusGLSurfaceView_13;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashChunkSource.Factory
        public DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int OplusGLSurfaceView_13, int[] iArr, TrackSelection trackSelection, int i2, long OplusGLSurfaceView_15, boolean z, boolean z2, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, TransferListener transferListener) {
            DataSource dataSourceCreateDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener != null) {
                dataSourceCreateDataSource.addTransferListener(transferListener);
            }
            return new DefaultDashChunkSource(loaderErrorThrower, dashManifest, OplusGLSurfaceView_13, iArr, trackSelection, i2, dataSourceCreateDataSource, OplusGLSurfaceView_15, this.maxSegmentsPerLoad, z, z2, playerTrackEmsgHandler);
        }
    }

    public DefaultDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int OplusGLSurfaceView_13, int[] iArr, TrackSelection trackSelection, int i2, DataSource dataSource, long OplusGLSurfaceView_15, int i3, boolean z, boolean z2, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler) {
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = dashManifest;
        this.adaptationSetIndices = iArr;
        this.trackSelection = trackSelection;
        this.trackType = i2;
        this.dataSource = dataSource;
        this.periodIndex = OplusGLSurfaceView_13;
        this.elapsedRealtimeOffsetMs = OplusGLSurfaceView_15;
        this.maxSegmentsPerLoad = i3;
        this.playerTrackEmsgHandler = playerTrackEmsgHandler;
        long periodDurationUs = dashManifest.getPeriodDurationUs(OplusGLSurfaceView_13);
        this.liveEdgeTimeUs = -9223372036854775807L;
        ArrayList<Representation> representations = getRepresentations();
        this.representationHolders = new RepresentationHolder[trackSelection.length()];
        for (int i4 = 0; i4 < this.representationHolders.length; i4++) {
            this.representationHolders[i4] = new RepresentationHolder(periodDurationUs, i2, representations.get(trackSelection.getIndexInTrackGroup(i4)), z, z2, playerTrackEmsgHandler);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public long getAdjustedSeekPositionUs(long OplusGLSurfaceView_15, SeekParameters seekParameters) {
        for (RepresentationHolder representationHolder : this.representationHolders) {
            if (representationHolder.segmentIndex != null) {
                long segmentNum = representationHolder.getSegmentNum(OplusGLSurfaceView_15);
                long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(segmentNum);
                return Util.resolveSeekPositionUs(OplusGLSurfaceView_15, seekParameters, segmentStartTimeUs, (segmentStartTimeUs >= OplusGLSurfaceView_15 || segmentNum >= ((long) (representationHolder.getSegmentCount() + (-1)))) ? segmentStartTimeUs : representationHolder.getSegmentStartTimeUs(segmentNum + 1));
            }
        }
        return OplusGLSurfaceView_15;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void updateManifest(DashManifest dashManifest, int OplusGLSurfaceView_13) {
        try {
            this.manifest = dashManifest;
            this.periodIndex = OplusGLSurfaceView_13;
            long periodDurationUs = this.manifest.getPeriodDurationUs(this.periodIndex);
            ArrayList<Representation> representations = getRepresentations();
            for (int i2 = 0; i2 < this.representationHolders.length; i2++) {
                this.representationHolders[i2] = this.representationHolders[i2].copyWithNewRepresentation(periodDurationUs, representations.get(this.trackSelection.getIndexInTrackGroup(i2)));
            }
        } catch (BehindLiveWindowException COUIBaseListPopupWindow_8) {
            this.fatalError = COUIBaseListPopupWindow_8;
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long OplusGLSurfaceView_15, List<? extends MediaChunk> list) {
        if (this.fatalError != null || this.trackSelection.length() < 2) {
            return list.size();
        }
        return this.trackSelection.evaluateQueueSize(OplusGLSurfaceView_15, list);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void getNextChunk(long OplusGLSurfaceView_15, long j2, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        int OplusGLSurfaceView_13;
        if (this.fatalError != null) {
            return;
        }
        long j3 = j2 - OplusGLSurfaceView_15;
        long jResolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(OplusGLSurfaceView_15);
        long jMsToUs = C1547C.msToUs(this.manifest.availabilityStartTimeMs) + C1547C.msToUs(this.manifest.getPeriod(this.periodIndex).startMs) + j2;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler == null || !playerTrackEmsgHandler.maybeRefreshManifestBeforeLoadingNextChunk(jMsToUs)) {
            long nowUnixTimeUs = getNowUnixTimeUs();
            MediaChunk mediaChunk = list.isEmpty() ? null : list.get(list.size() - 1);
            MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[this.trackSelection.length()];
            int i2 = 0;
            while (i2 < mediaChunkIteratorArr.length) {
                RepresentationHolder representationHolder = this.representationHolders[i2];
                if (representationHolder.segmentIndex == null) {
                    mediaChunkIteratorArr[i2] = MediaChunkIterator.EMPTY;
                    OplusGLSurfaceView_13 = i2;
                } else {
                    long firstAvailableSegmentNum = representationHolder.getFirstAvailableSegmentNum(this.manifest, this.periodIndex, nowUnixTimeUs);
                    long lastAvailableSegmentNum = representationHolder.getLastAvailableSegmentNum(this.manifest, this.periodIndex, nowUnixTimeUs);
                    OplusGLSurfaceView_13 = i2;
                    long segmentNum = getSegmentNum(representationHolder, mediaChunk, j2, firstAvailableSegmentNum, lastAvailableSegmentNum);
                    if (segmentNum < firstAvailableSegmentNum) {
                        mediaChunkIteratorArr[OplusGLSurfaceView_13] = MediaChunkIterator.EMPTY;
                    } else {
                        mediaChunkIteratorArr[OplusGLSurfaceView_13] = new RepresentationSegmentIterator(representationHolder, segmentNum, lastAvailableSegmentNum);
                    }
                }
                i2 = OplusGLSurfaceView_13 + 1;
            }
            this.trackSelection.updateSelectedTrack(OplusGLSurfaceView_15, j3, jResolveTimeToLiveEdgeUs, list, mediaChunkIteratorArr);
            RepresentationHolder representationHolder2 = this.representationHolders[this.trackSelection.getSelectedIndex()];
            if (representationHolder2.extractorWrapper != null) {
                Representation representation = representationHolder2.representation;
                RangedUri initializationUri = representationHolder2.extractorWrapper.getSampleFormats() == null ? representation.getInitializationUri() : null;
                RangedUri indexUri = representationHolder2.segmentIndex == null ? representation.getIndexUri() : null;
                if (initializationUri != null || indexUri != null) {
                    chunkHolder.chunk = newInitializationChunk(representationHolder2, this.dataSource, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), initializationUri, indexUri);
                    return;
                }
            }
            long j4 = representationHolder2.periodDurationUs;
            boolean z = j4 != -9223372036854775807L;
            if (representationHolder2.getSegmentCount() == 0) {
                chunkHolder.endOfStream = z;
                return;
            }
            long firstAvailableSegmentNum2 = representationHolder2.getFirstAvailableSegmentNum(this.manifest, this.periodIndex, nowUnixTimeUs);
            long lastAvailableSegmentNum2 = representationHolder2.getLastAvailableSegmentNum(this.manifest, this.periodIndex, nowUnixTimeUs);
            updateLiveEdgeTimeUs(representationHolder2, lastAvailableSegmentNum2);
            boolean z2 = z;
            long segmentNum2 = getSegmentNum(representationHolder2, mediaChunk, j2, firstAvailableSegmentNum2, lastAvailableSegmentNum2);
            if (segmentNum2 < firstAvailableSegmentNum2) {
                this.fatalError = new BehindLiveWindowException();
                return;
            }
            if (segmentNum2 > lastAvailableSegmentNum2 || (this.missingLastSegment && segmentNum2 >= lastAvailableSegmentNum2)) {
                chunkHolder.endOfStream = z2;
                return;
            }
            if (z2 && representationHolder2.getSegmentStartTimeUs(segmentNum2) >= j4) {
                chunkHolder.endOfStream = true;
                return;
            }
            int iMin = (int) Math.min(this.maxSegmentsPerLoad, (lastAvailableSegmentNum2 - segmentNum2) + 1);
            if (j4 != -9223372036854775807L) {
                while (iMin > 1 && representationHolder2.getSegmentStartTimeUs((iMin + segmentNum2) - 1) >= j4) {
                    iMin--;
                }
            }
            chunkHolder.chunk = newMediaChunk(representationHolder2, this.dataSource, this.trackType, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), segmentNum2, iMin, list.isEmpty() ? j2 : -9223372036854775807L);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(Chunk chunk) {
        SeekMap seekMap;
        if (chunk instanceof InitializationChunk) {
            int iIndexOf = this.trackSelection.indexOf(((InitializationChunk) chunk).trackFormat);
            RepresentationHolder representationHolder = this.representationHolders[iIndexOf];
            if (representationHolder.segmentIndex == null && (seekMap = representationHolder.extractorWrapper.getSeekMap()) != null) {
                this.representationHolders[iIndexOf] = representationHolder.copyWithNewSegmentIndex(new DashWrappingSegmentIndex((ChunkIndex) seekMap, representationHolder.representation.presentationTimeOffsetUs));
            }
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler != null) {
            playerTrackEmsgHandler.onChunkLoadCompleted(chunk);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc, long OplusGLSurfaceView_15) {
        RepresentationHolder representationHolder;
        int segmentCount;
        if (!z) {
            return false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler != null && playerTrackEmsgHandler.maybeRefreshManifestOnLoadingError(chunk)) {
            return true;
        }
        if (!this.manifest.dynamic && (chunk instanceof MediaChunk) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (segmentCount = (representationHolder = this.representationHolders[this.trackSelection.indexOf(chunk.trackFormat)]).getSegmentCount()) != -1 && segmentCount != 0) {
            if (((MediaChunk) chunk).getNextChunkIndex() > (representationHolder.getFirstSegmentNum() + segmentCount) - 1) {
                this.missingLastSegment = true;
                return true;
            }
        }
        if (OplusGLSurfaceView_15 == -9223372036854775807L) {
            return false;
        }
        TrackSelection trackSelection = this.trackSelection;
        return trackSelection.blacklist(trackSelection.indexOf(chunk.trackFormat), OplusGLSurfaceView_15);
    }

    private long getSegmentNum(RepresentationHolder representationHolder, MediaChunk mediaChunk, long OplusGLSurfaceView_15, long j2, long j3) {
        if (mediaChunk != null) {
            return mediaChunk.getNextChunkIndex();
        }
        return Util.constrainValue(representationHolder.getSegmentNum(OplusGLSurfaceView_15), j2, j3);
    }

    private ArrayList<Representation> getRepresentations() {
        List<AdaptationSet> list = this.manifest.getPeriod(this.periodIndex).adaptationSets;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int OplusGLSurfaceView_13 : this.adaptationSetIndices) {
            arrayList.addAll(list.get(OplusGLSurfaceView_13).representations);
        }
        return arrayList;
    }

    private void updateLiveEdgeTimeUs(RepresentationHolder representationHolder, long OplusGLSurfaceView_15) {
        this.liveEdgeTimeUs = this.manifest.dynamic ? representationHolder.getSegmentEndTimeUs(OplusGLSurfaceView_15) : -9223372036854775807L;
    }

    private long getNowUnixTimeUs() {
        long jCurrentTimeMillis;
        if (this.elapsedRealtimeOffsetMs != 0) {
            jCurrentTimeMillis = SystemClock.elapsedRealtime() + this.elapsedRealtimeOffsetMs;
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        return jCurrentTimeMillis * 1000;
    }

    private long resolveTimeToLiveEdgeUs(long OplusGLSurfaceView_15) {
        if (this.manifest.dynamic && this.liveEdgeTimeUs != -9223372036854775807L) {
            return this.liveEdgeTimeUs - OplusGLSurfaceView_15;
        }
        return -9223372036854775807L;
    }

    protected Chunk newInitializationChunk(RepresentationHolder representationHolder, DataSource dataSource, Format format, int OplusGLSurfaceView_13, Object obj, RangedUri rangedUri, RangedUri rangedUri2) {
        String str = representationHolder.representation.baseUrl;
        if (rangedUri != null && (rangedUri2 = rangedUri.attemptMerge(rangedUri2, str)) == null) {
            rangedUri2 = rangedUri;
        }
        return new InitializationChunk(dataSource, new DataSpec(rangedUri2.resolveUri(str), rangedUri2.start, rangedUri2.length, representationHolder.representation.getCacheKey()), format, OplusGLSurfaceView_13, obj, representationHolder.extractorWrapper);
    }

    protected Chunk newMediaChunk(RepresentationHolder representationHolder, DataSource dataSource, int OplusGLSurfaceView_13, Format format, int i2, Object obj, long OplusGLSurfaceView_15, int i3, long j2) {
        Representation representation = representationHolder.representation;
        long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(OplusGLSurfaceView_15);
        RangedUri segmentUrl = representationHolder.getSegmentUrl(OplusGLSurfaceView_15);
        String str = representation.baseUrl;
        if (representationHolder.extractorWrapper == null) {
            return new SingleSampleMediaChunk(dataSource, new DataSpec(segmentUrl.resolveUri(str), segmentUrl.start, segmentUrl.length, representation.getCacheKey()), format, i2, obj, segmentStartTimeUs, representationHolder.getSegmentEndTimeUs(OplusGLSurfaceView_15), OplusGLSurfaceView_15, OplusGLSurfaceView_13, format);
        }
        int i4 = 1;
        RangedUri rangedUri = segmentUrl;
        int i5 = 1;
        while (i4 < i3) {
            RangedUri rangedUriAttemptMerge = rangedUri.attemptMerge(representationHolder.getSegmentUrl(i4 + OplusGLSurfaceView_15), str);
            if (rangedUriAttemptMerge == null) {
                break;
            }
            i5++;
            i4++;
            rangedUri = rangedUriAttemptMerge;
        }
        long segmentEndTimeUs = representationHolder.getSegmentEndTimeUs((i5 + OplusGLSurfaceView_15) - 1);
        long j3 = representationHolder.periodDurationUs;
        return new ContainerMediaChunk(dataSource, new DataSpec(rangedUri.resolveUri(str), rangedUri.start, rangedUri.length, representation.getCacheKey()), format, i2, obj, segmentStartTimeUs, segmentEndTimeUs, j2, (j3 == -9223372036854775807L || j3 > segmentEndTimeUs) ? -9223372036854775807L : j3, OplusGLSurfaceView_15, i5, -representation.presentationTimeOffsetUs, representationHolder.extractorWrapper);
    }

    protected static final class RepresentationSegmentIterator extends BaseMediaChunkIterator {
        private final RepresentationHolder representationHolder;

        public RepresentationSegmentIterator(RepresentationHolder representationHolder, long OplusGLSurfaceView_15, long j2) {
            super(OplusGLSurfaceView_15, j2);
            this.representationHolder = representationHolder;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public DataSpec getDataSpec() {
            checkInBounds();
            Representation representation = this.representationHolder.representation;
            RangedUri segmentUrl = this.representationHolder.getSegmentUrl(getCurrentIndex());
            return new DataSpec(segmentUrl.resolveUri(representation.baseUrl), segmentUrl.start, segmentUrl.length, representation.getCacheKey());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentStartTimeUs(getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentEndTimeUs(getCurrentIndex());
        }
    }

    protected static final class RepresentationHolder {
        final ChunkExtractorWrapper extractorWrapper;
        private final long periodDurationUs;
        public final Representation representation;
        public final DashSegmentIndex segmentIndex;
        private final long segmentNumShift;

        RepresentationHolder(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, Representation representation, boolean z, boolean z2, TrackOutput trackOutput) {
            this(OplusGLSurfaceView_15, representation, createExtractorWrapper(OplusGLSurfaceView_13, representation, z, z2, trackOutput), 0L, representation.getIndex());
        }

        private RepresentationHolder(long OplusGLSurfaceView_15, Representation representation, ChunkExtractorWrapper chunkExtractorWrapper, long j2, DashSegmentIndex dashSegmentIndex) {
            this.periodDurationUs = OplusGLSurfaceView_15;
            this.representation = representation;
            this.segmentNumShift = j2;
            this.extractorWrapper = chunkExtractorWrapper;
            this.segmentIndex = dashSegmentIndex;
        }

        RepresentationHolder copyWithNewRepresentation(long OplusGLSurfaceView_15, Representation representation) throws BehindLiveWindowException {
            long segmentNum;
            DashSegmentIndex index = this.representation.getIndex();
            DashSegmentIndex index2 = representation.getIndex();
            if (index == null) {
                return new RepresentationHolder(OplusGLSurfaceView_15, representation, this.extractorWrapper, this.segmentNumShift, index);
            }
            if (!index.isExplicit()) {
                return new RepresentationHolder(OplusGLSurfaceView_15, representation, this.extractorWrapper, this.segmentNumShift, index2);
            }
            int segmentCount = index.getSegmentCount(OplusGLSurfaceView_15);
            if (segmentCount == 0) {
                return new RepresentationHolder(OplusGLSurfaceView_15, representation, this.extractorWrapper, this.segmentNumShift, index2);
            }
            long firstSegmentNum = (index.getFirstSegmentNum() + segmentCount) - 1;
            long timeUs = index.getTimeUs(firstSegmentNum) + index.getDurationUs(firstSegmentNum, OplusGLSurfaceView_15);
            long firstSegmentNum2 = index2.getFirstSegmentNum();
            long timeUs2 = index2.getTimeUs(firstSegmentNum2);
            long j2 = this.segmentNumShift;
            if (timeUs == timeUs2) {
                segmentNum = j2 + ((firstSegmentNum + 1) - firstSegmentNum2);
            } else {
                if (timeUs < timeUs2) {
                    throw new BehindLiveWindowException();
                }
                segmentNum = j2 + (index.getSegmentNum(timeUs2, OplusGLSurfaceView_15) - firstSegmentNum2);
            }
            return new RepresentationHolder(OplusGLSurfaceView_15, representation, this.extractorWrapper, segmentNum, index2);
        }

        RepresentationHolder copyWithNewSegmentIndex(DashSegmentIndex dashSegmentIndex) {
            return new RepresentationHolder(this.periodDurationUs, this.representation, this.extractorWrapper, this.segmentNumShift, dashSegmentIndex);
        }

        public long getFirstSegmentNum() {
            return this.segmentIndex.getFirstSegmentNum() + this.segmentNumShift;
        }

        public int getSegmentCount() {
            return this.segmentIndex.getSegmentCount(this.periodDurationUs);
        }

        public long getSegmentStartTimeUs(long OplusGLSurfaceView_15) {
            return this.segmentIndex.getTimeUs(OplusGLSurfaceView_15 - this.segmentNumShift);
        }

        public long getSegmentEndTimeUs(long OplusGLSurfaceView_15) {
            return getSegmentStartTimeUs(OplusGLSurfaceView_15) + this.segmentIndex.getDurationUs(OplusGLSurfaceView_15 - this.segmentNumShift, this.periodDurationUs);
        }

        public long getSegmentNum(long OplusGLSurfaceView_15) {
            return this.segmentIndex.getSegmentNum(OplusGLSurfaceView_15, this.periodDurationUs) + this.segmentNumShift;
        }

        public RangedUri getSegmentUrl(long OplusGLSurfaceView_15) {
            return this.segmentIndex.getSegmentUrl(OplusGLSurfaceView_15 - this.segmentNumShift);
        }

        public long getFirstAvailableSegmentNum(DashManifest dashManifest, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            if (getSegmentCount() == -1 && dashManifest.timeShiftBufferDepthMs != -9223372036854775807L) {
                return Math.max(getFirstSegmentNum(), getSegmentNum(((OplusGLSurfaceView_15 - C1547C.msToUs(dashManifest.availabilityStartTimeMs)) - C1547C.msToUs(dashManifest.getPeriod(OplusGLSurfaceView_13).startMs)) - C1547C.msToUs(dashManifest.timeShiftBufferDepthMs)));
            }
            return getFirstSegmentNum();
        }

        public long getLastAvailableSegmentNum(DashManifest dashManifest, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            long firstSegmentNum;
            int segmentCount = getSegmentCount();
            if (segmentCount == -1) {
                firstSegmentNum = getSegmentNum((OplusGLSurfaceView_15 - C1547C.msToUs(dashManifest.availabilityStartTimeMs)) - C1547C.msToUs(dashManifest.getPeriod(OplusGLSurfaceView_13).startMs));
            } else {
                firstSegmentNum = getFirstSegmentNum() + segmentCount;
            }
            return firstSegmentNum - 1;
        }

        private static boolean mimeTypeIsWebm(String str) {
            return str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM) || str.startsWith(MimeTypes.APPLICATION_WEBM);
        }

        private static boolean mimeTypeIsRawText(String str) {
            return MimeTypes.isText(str) || MimeTypes.APPLICATION_TTML.equals(str);
        }

        private static ChunkExtractorWrapper createExtractorWrapper(int OplusGLSurfaceView_13, Representation representation, boolean z, boolean z2, TrackOutput trackOutput) {
            List listEmptyList;
            Extractor fragmentedMp4Extractor;
            String str = representation.format.containerMimeType;
            if (mimeTypeIsRawText(str)) {
                return null;
            }
            if (MimeTypes.APPLICATION_RAWCC.equals(str)) {
                fragmentedMp4Extractor = new RawCcExtractor(representation.format);
            } else if (mimeTypeIsWebm(str)) {
                fragmentedMp4Extractor = new MatroskaExtractor(1);
            } else {
                int i2 = z ? 4 : 0;
                if (z2) {
                    listEmptyList = Collections.singletonList(Format.createTextSampleFormat(null, MimeTypes.APPLICATION_CEA608, 0, null));
                } else {
                    listEmptyList = Collections.emptyList();
                }
                fragmentedMp4Extractor = new FragmentedMp4Extractor(i2, null, null, null, listEmptyList, trackOutput);
            }
            return new ChunkExtractorWrapper(fragmentedMp4Extractor, OplusGLSurfaceView_13, representation.format);
        }
    }
}

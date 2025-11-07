package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Mp4Extractor implements Extractor, SeekMap {
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;
    private static final long MAXIMUM_READ_AHEAD_BYTES_STREAM = 10485760;
    private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 262144;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int ac4SampleHeaderSize;
    private long[][] accumulatedSampleSizes;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final ArrayDeque<Atom.ContainerAtom> containerAtoms;
    private long durationUs;
    private ExtractorOutput extractorOutput;
    private int firstVideoTrackIndex;
    private final int flags;
    private boolean isAc4HeaderAdded;
    private boolean isQuickTime;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleTrackIndex;
    private Mp4Track[] tracks;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp4.-$$Lambda$Mp4Extractor$quy71uYOGsneho91FZy1d2UGE1Q
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return Mp4Extractor.lambda$static$0();
        }
    };
    private static final int BRAND_QUICKTIME = Util.getIntegerCodeForString("qt  ");

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new Mp4Extractor()};
    }

    public Mp4Extractor() {
        this(0);
    }

    public Mp4Extractor(int OplusGLSurfaceView_13) {
        this.flags = OplusGLSurfaceView_13;
        this.atomHeader = new ParsableByteArray(16);
        this.containerAtoms = new ArrayDeque<>();
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleTrackIndex = -1;
        this.isAc4HeaderAdded = false;
        this.ac4SampleHeaderSize = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws InterruptedException, IOException {
        return Sniffer.sniffUnfragmented(extractorInput);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long OplusGLSurfaceView_15, long j2) {
        this.containerAtoms.clear();
        this.atomHeaderBytesRead = 0;
        this.sampleTrackIndex = -1;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        if (OplusGLSurfaceView_15 == 0) {
            enterReadingAtomHeaderState();
        } else if (this.tracks != null) {
            updateSampleIndices(j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws InterruptedException, IOException {
        while (true) {
            int OplusGLSurfaceView_13 = this.parserState;
            if (OplusGLSurfaceView_13 != 0) {
                if (OplusGLSurfaceView_13 != 1) {
                    if (OplusGLSurfaceView_13 == 2) {
                        return readSample(extractorInput, positionHolder);
                    }
                    throw new IllegalStateException();
                }
                if (readAtomPayload(extractorInput, positionHolder)) {
                    return 1;
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long OplusGLSurfaceView_15) {
        long j2;
        long jMaybeAdjustSeekOffset;
        long j3;
        long j4;
        int indexOfLaterOrEqualSynchronizationSample;
        Mp4Track[] mp4TrackArr = this.tracks;
        if (mp4TrackArr.length == 0) {
            return new SeekMap.SeekPoints(SeekPoint.START);
        }
        int OplusGLSurfaceView_13 = this.firstVideoTrackIndex;
        if (OplusGLSurfaceView_13 != -1) {
            TrackSampleTable trackSampleTable = mp4TrackArr[OplusGLSurfaceView_13].sampleTable;
            int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, OplusGLSurfaceView_15);
            if (synchronizationSampleIndex == -1) {
                return new SeekMap.SeekPoints(SeekPoint.START);
            }
            long j5 = trackSampleTable.timestampsUs[synchronizationSampleIndex];
            j2 = trackSampleTable.offsets[synchronizationSampleIndex];
            if (j5 >= OplusGLSurfaceView_15 || synchronizationSampleIndex >= trackSampleTable.sampleCount - 1 || (indexOfLaterOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(OplusGLSurfaceView_15)) == -1 || indexOfLaterOrEqualSynchronizationSample == synchronizationSampleIndex) {
                j4 = -1;
                j3 = -9223372036854775807L;
            } else {
                j3 = trackSampleTable.timestampsUs[indexOfLaterOrEqualSynchronizationSample];
                j4 = trackSampleTable.offsets[indexOfLaterOrEqualSynchronizationSample];
            }
            jMaybeAdjustSeekOffset = j4;
            OplusGLSurfaceView_15 = j5;
        } else {
            j2 = Long.MAX_VALUE;
            jMaybeAdjustSeekOffset = -1;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            Mp4Track[] mp4TrackArr2 = this.tracks;
            if (i2 >= mp4TrackArr2.length) {
                break;
            }
            if (i2 != this.firstVideoTrackIndex) {
                TrackSampleTable trackSampleTable2 = mp4TrackArr2[i2].sampleTable;
                long jMaybeAdjustSeekOffset2 = maybeAdjustSeekOffset(trackSampleTable2, OplusGLSurfaceView_15, j2);
                if (j3 != -9223372036854775807L) {
                    jMaybeAdjustSeekOffset = maybeAdjustSeekOffset(trackSampleTable2, j3, jMaybeAdjustSeekOffset);
                }
                j2 = jMaybeAdjustSeekOffset2;
            }
            i2++;
        }
        SeekPoint seekPoint = new SeekPoint(OplusGLSurfaceView_15, j2);
        if (j3 == -9223372036854775807L) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(j3, jMaybeAdjustSeekOffset));
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws InterruptedException, IOException {
        if (this.atomHeaderBytesRead == 0) {
            if (!extractorInput.readFully(this.atomHeader.data, 0, 8, true)) {
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        long OplusGLSurfaceView_15 = this.atomSize;
        if (OplusGLSurfaceView_15 == 1) {
            extractorInput.readFully(this.atomHeader.data, 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        } else if (OplusGLSurfaceView_15 == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && !this.containerAtoms.isEmpty()) {
                length = this.containerAtoms.peek().endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - extractorInput.getPosition()) + this.atomHeaderBytesRead;
            }
        }
        if (this.atomSize < this.atomHeaderBytesRead) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        if (shouldParseContainerAtom(this.atomType)) {
            long position = (extractorInput.getPosition() + this.atomSize) - this.atomHeaderBytesRead;
            this.containerAtoms.push(new Atom.ContainerAtom(this.atomType, position));
            if (this.atomSize == this.atomHeaderBytesRead) {
                processAtomEnded(position);
            } else {
                enterReadingAtomHeaderState();
            }
        } else if (shouldParseLeafAtom(this.atomType)) {
            Assertions.checkState(this.atomHeaderBytesRead == 8);
            Assertions.checkState(this.atomSize <= 2147483647L);
            this.atomData = new ParsableByteArray((int) this.atomSize);
            System.arraycopy(this.atomHeader.data, 0, this.atomData.data, 0, 8);
            this.parserState = 1;
        } else {
            this.atomData = null;
            this.parserState = 1;
        }
        return true;
    }

    private boolean readAtomPayload(ExtractorInput extractorInput, PositionHolder positionHolder) throws InterruptedException, IOException {
        boolean z;
        long OplusGLSurfaceView_15 = this.atomSize - this.atomHeaderBytesRead;
        long position = extractorInput.getPosition() + OplusGLSurfaceView_15;
        ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.data, this.atomHeaderBytesRead, (int) OplusGLSurfaceView_15);
            if (this.atomType == Atom.TYPE_ftyp) {
                this.isQuickTime = processFtypAtom(this.atomData);
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(new Atom.LeafAtom(this.atomType, this.atomData));
            }
        } else if (OplusGLSurfaceView_15 < 262144) {
            extractorInput.skipFully((int) OplusGLSurfaceView_15);
        } else {
            positionHolder.position = extractorInput.getPosition() + OplusGLSurfaceView_15;
            z = true;
            processAtomEnded(position);
            return (z || this.parserState == 2) ? false : true;
        }
        z = false;
        processAtomEnded(position);
        if (z) {
        }
    }

    private void processAtomEnded(long OplusGLSurfaceView_15) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == OplusGLSurfaceView_15) {
            Atom.ContainerAtom containerAtomPop = this.containerAtoms.pop();
            if (containerAtomPop.type == Atom.TYPE_moov) {
                processMoovAtom(containerAtomPop);
                this.containerAtoms.clear();
                this.parserState = 2;
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(containerAtomPop);
            }
        }
        if (this.parserState != 2) {
            enterReadingAtomHeaderState();
        }
    }

    private void processMoovAtom(Atom.ContainerAtom containerAtom) throws ParserException {
        Metadata udta;
        boolean z;
        ArrayList arrayList = new ArrayList();
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_udta);
        if (leafAtomOfType != null) {
            udta = AtomParsers.parseUdta(leafAtomOfType, this.isQuickTime);
            if (udta != null) {
                gaplessInfoHolder.setFromMetadata(udta);
            }
        } else {
            udta = null;
        }
        Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_meta);
        Metadata mdtaFromMeta = containerAtomOfType != null ? AtomParsers.parseMdtaFromMeta(containerAtomOfType) : null;
        int OplusGLSurfaceView_13 = 0;
        ArrayList<TrackSampleTable> trackSampleTables = getTrackSampleTables(containerAtom, gaplessInfoHolder, (this.flags & 1) != 0);
        int size = trackSampleTables.size();
        long OplusGLSurfaceView_15 = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        int size2 = -1;
        while (OplusGLSurfaceView_13 < size) {
            TrackSampleTable trackSampleTable = trackSampleTables.get(OplusGLSurfaceView_13);
            Track track = trackSampleTable.track;
            int i2 = OplusGLSurfaceView_13;
            long j3 = track.durationUs != OplusGLSurfaceView_15 ? track.durationUs : trackSampleTable.durationUs;
            long jMax = Math.max(j2, j3);
            ArrayList<TrackSampleTable> arrayList2 = trackSampleTables;
            int i3 = size;
            Mp4Track mp4Track = new Mp4Track(track, trackSampleTable, this.extractorOutput.track(i2, track.type));
            Format formatCopyWithMaxInputSize = track.format.copyWithMaxInputSize(trackSampleTable.maximumSize + 30);
            if (track.type != 2 || j3 <= 0) {
                z = true;
            } else {
                z = true;
                if (trackSampleTable.sampleCount > 1) {
                    formatCopyWithMaxInputSize = formatCopyWithMaxInputSize.copyWithFrameRate(trackSampleTable.sampleCount / (j3 / 1000000.0f));
                }
            }
            mp4Track.trackOutput.format(MetadataUtil.getFormatWithMetadata(track.type, formatCopyWithMaxInputSize, udta, mdtaFromMeta, gaplessInfoHolder));
            if (track.type == 2 && size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(mp4Track);
            OplusGLSurfaceView_13 = i2 + 1;
            trackSampleTables = arrayList2;
            size = i3;
            j2 = jMax;
            OplusGLSurfaceView_15 = -9223372036854775807L;
        }
        this.firstVideoTrackIndex = size2;
        this.durationUs = j2;
        this.tracks = (Mp4Track[]) arrayList.toArray(new Mp4Track[arrayList.size()]);
        this.accumulatedSampleSizes = calculateAccumulatedSampleSizes(this.tracks);
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(this);
    }

    private ArrayList<TrackSampleTable> getTrackSampleTables(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, boolean z) throws ParserException {
        Track trak;
        ArrayList<TrackSampleTable> arrayList = new ArrayList<>();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < containerAtom.containerChildren.size(); OplusGLSurfaceView_13++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(OplusGLSurfaceView_13);
            if (containerAtom2.type == Atom.TYPE_trak && (trak = AtomParsers.parseTrak(containerAtom2, containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd), -9223372036854775807L, null, z, this.isQuickTime)) != null) {
                TrackSampleTable stbl = AtomParsers.parseStbl(trak, containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia).getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl), gaplessInfoHolder);
                if (stbl.sampleCount != 0) {
                    arrayList.add(stbl);
                }
            }
        }
        return arrayList;
    }

    private int readSample(ExtractorInput extractorInput, PositionHolder positionHolder) throws InterruptedException, IOException {
        long position = extractorInput.getPosition();
        if (this.sampleTrackIndex == -1) {
            this.sampleTrackIndex = getTrackIndexOfNextReadSample(position);
            if (this.sampleTrackIndex == -1) {
                return -1;
            }
            this.isAc4HeaderAdded = false;
        }
        Mp4Track mp4Track = this.tracks[this.sampleTrackIndex];
        TrackOutput trackOutput = mp4Track.trackOutput;
        int OplusGLSurfaceView_13 = mp4Track.sampleIndex;
        long OplusGLSurfaceView_15 = mp4Track.sampleTable.offsets[OplusGLSurfaceView_13];
        int i2 = mp4Track.sampleTable.sizes[OplusGLSurfaceView_13];
        long j2 = (OplusGLSurfaceView_15 - position) + this.sampleBytesWritten;
        if (j2 < 0 || j2 >= 262144) {
            positionHolder.position = OplusGLSurfaceView_15;
            return 1;
        }
        if (mp4Track.track.sampleTransformation == 1) {
            j2 += 8;
            i2 -= 8;
        }
        extractorInput.skipFully((int) j2);
        if (mp4Track.track.nalUnitLengthFieldLength != 0) {
            byte[] bArr = this.nalLength.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i3 = mp4Track.track.nalUnitLengthFieldLength;
            int i4 = 4 - mp4Track.track.nalUnitLengthFieldLength;
            while (this.sampleBytesWritten < i2) {
                int i5 = this.sampleCurrentNalBytesRemaining;
                if (i5 == 0) {
                    extractorInput.readFully(this.nalLength.data, i4, i3);
                    this.nalLength.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                    i2 += i4;
                } else {
                    int iSampleData = trackOutput.sampleData(extractorInput, i5, false);
                    this.sampleBytesWritten += iSampleData;
                    this.sampleCurrentNalBytesRemaining -= iSampleData;
                }
            }
        } else {
            if (MimeTypes.AUDIO_AC4.equals(mp4Track.track.format.sampleMimeType) && !this.isAc4HeaderAdded) {
                ParsableByteArray ac4SampleHeader = Ac4Util.getAc4SampleHeader(i2);
                trackOutput.sampleData(ac4SampleHeader, ac4SampleHeader.capacity());
                this.ac4SampleHeaderSize = ac4SampleHeader.capacity();
                this.isAc4HeaderAdded = true;
            }
            while (true) {
                int i6 = this.sampleBytesWritten;
                if (i6 >= i2) {
                    break;
                }
                int iSampleData2 = trackOutput.sampleData(extractorInput, i2 - i6, false);
                this.sampleBytesWritten += iSampleData2;
                this.sampleCurrentNalBytesRemaining -= iSampleData2;
            }
            if (MimeTypes.AUDIO_AC4.equals(mp4Track.track.format.sampleMimeType)) {
                i2 += this.ac4SampleHeaderSize;
                this.isAc4HeaderAdded = false;
            }
        }
        trackOutput.sampleMetadata(mp4Track.sampleTable.timestampsUs[OplusGLSurfaceView_13], mp4Track.sampleTable.flags[OplusGLSurfaceView_13], i2, 0, null);
        mp4Track.sampleIndex++;
        this.sampleTrackIndex = -1;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        return 0;
    }

    private int getTrackIndexOfNextReadSample(long OplusGLSurfaceView_15) {
        int OplusGLSurfaceView_13 = -1;
        int i2 = -1;
        int i3 = 0;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        while (true) {
            Mp4Track[] mp4TrackArr = this.tracks;
            if (i3 >= mp4TrackArr.length) {
                break;
            }
            Mp4Track mp4Track = mp4TrackArr[i3];
            int i4 = mp4Track.sampleIndex;
            if (i4 != mp4Track.sampleTable.sampleCount) {
                long j5 = mp4Track.sampleTable.offsets[i4];
                long j6 = this.accumulatedSampleSizes[i3][i4];
                long j7 = j5 - OplusGLSurfaceView_15;
                boolean z3 = j7 < 0 || j7 >= 262144;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    i2 = i3;
                    j4 = j7;
                    j3 = j6;
                }
                if (j6 < j2) {
                    z = z3;
                    OplusGLSurfaceView_13 = i3;
                    j2 = j6;
                }
            }
            i3++;
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + MAXIMUM_READ_AHEAD_BYTES_STREAM) ? i2 : OplusGLSurfaceView_13;
    }

    private void updateSampleIndices(long OplusGLSurfaceView_15) {
        for (Mp4Track mp4Track : this.tracks) {
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(OplusGLSurfaceView_15);
            if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(OplusGLSurfaceView_15);
            }
            mp4Track.sampleIndex = indexOfEarlierOrEqualSynchronizationSample;
        }
    }

    private static long[][] calculateAccumulatedSampleSizes(Mp4Track[] mp4TrackArr) {
        long[][] jArr = new long[mp4TrackArr.length][];
        int[] iArr = new int[mp4TrackArr.length];
        long[] jArr2 = new long[mp4TrackArr.length];
        boolean[] zArr = new boolean[mp4TrackArr.length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < mp4TrackArr.length; OplusGLSurfaceView_13++) {
            jArr[OplusGLSurfaceView_13] = new long[mp4TrackArr[OplusGLSurfaceView_13].sampleTable.sampleCount];
            jArr2[OplusGLSurfaceView_13] = mp4TrackArr[OplusGLSurfaceView_13].sampleTable.timestampsUs[0];
        }
        long OplusGLSurfaceView_15 = 0;
        int i2 = 0;
        while (i2 < mp4TrackArr.length) {
            int i3 = -1;
            long j2 = Long.MAX_VALUE;
            for (int i4 = 0; i4 < mp4TrackArr.length; i4++) {
                if (!zArr[i4] && jArr2[i4] <= j2) {
                    j2 = jArr2[i4];
                    i3 = i4;
                }
            }
            int i5 = iArr[i3];
            jArr[i3][i5] = OplusGLSurfaceView_15;
            OplusGLSurfaceView_15 += mp4TrackArr[i3].sampleTable.sizes[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr[i3].length) {
                jArr2[i3] = mp4TrackArr[i3].sampleTable.timestampsUs[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    private static long maybeAdjustSeekOffset(TrackSampleTable trackSampleTable, long OplusGLSurfaceView_15, long j2) {
        int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, OplusGLSurfaceView_15);
        return synchronizationSampleIndex == -1 ? j2 : Math.min(trackSampleTable.offsets[synchronizationSampleIndex], j2);
    }

    private static int getSynchronizationSampleIndex(TrackSampleTable trackSampleTable, long OplusGLSurfaceView_15) {
        int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(OplusGLSurfaceView_15);
        return indexOfEarlierOrEqualSynchronizationSample == -1 ? trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(OplusGLSurfaceView_15) : indexOfEarlierOrEqualSynchronizationSample;
    }

    private static boolean processFtypAtom(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        if (parsableByteArray.readInt() == BRAND_QUICKTIME) {
            return true;
        }
        parsableByteArray.skipBytes(4);
        while (parsableByteArray.bytesLeft() > 0) {
            if (parsableByteArray.readInt() == BRAND_QUICKTIME) {
                return true;
            }
        }
        return false;
    }

    private static boolean shouldParseLeafAtom(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == Atom.TYPE_mdhd || OplusGLSurfaceView_13 == Atom.TYPE_mvhd || OplusGLSurfaceView_13 == Atom.TYPE_hdlr || OplusGLSurfaceView_13 == Atom.TYPE_stsd || OplusGLSurfaceView_13 == Atom.TYPE_stts || OplusGLSurfaceView_13 == Atom.TYPE_stss || OplusGLSurfaceView_13 == Atom.TYPE_ctts || OplusGLSurfaceView_13 == Atom.TYPE_elst || OplusGLSurfaceView_13 == Atom.TYPE_stsc || OplusGLSurfaceView_13 == Atom.TYPE_stsz || OplusGLSurfaceView_13 == Atom.TYPE_stz2 || OplusGLSurfaceView_13 == Atom.TYPE_stco || OplusGLSurfaceView_13 == Atom.TYPE_co64 || OplusGLSurfaceView_13 == Atom.TYPE_tkhd || OplusGLSurfaceView_13 == Atom.TYPE_ftyp || OplusGLSurfaceView_13 == Atom.TYPE_udta || OplusGLSurfaceView_13 == Atom.TYPE_keys || OplusGLSurfaceView_13 == Atom.TYPE_ilst;
    }

    private static boolean shouldParseContainerAtom(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == Atom.TYPE_moov || OplusGLSurfaceView_13 == Atom.TYPE_trak || OplusGLSurfaceView_13 == Atom.TYPE_mdia || OplusGLSurfaceView_13 == Atom.TYPE_minf || OplusGLSurfaceView_13 == Atom.TYPE_stbl || OplusGLSurfaceView_13 == Atom.TYPE_edts || OplusGLSurfaceView_13 == Atom.TYPE_meta;
    }

    private static final class Mp4Track {
        public int sampleIndex;
        public final TrackSampleTable sampleTable;
        public final Track track;
        public final TrackOutput trackOutput;

        public Mp4Track(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
            this.track = track;
            this.sampleTable = trackSampleTable;
            this.trackOutput = trackOutput;
        }
    }
}

package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer2.C1547C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 3;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_vide = Util.getIntegerCodeForString("vide");
    private static final int TYPE_soun = Util.getIntegerCodeForString("soun");
    private static final int TYPE_text = Util.getIntegerCodeForString(MimeTypes.BASE_TYPE_TEXT);
    private static final int TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
    private static final int TYPE_subt = Util.getIntegerCodeForString("subt");
    private static final int TYPE_clcp = Util.getIntegerCodeForString("clcp");
    private static final int TYPE_meta = Util.getIntegerCodeForString("meta");
    private static final int TYPE_mdta = Util.getIntegerCodeForString("mdta");
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    private interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long OplusGLSurfaceView_15, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        Atom.LeafAtom leafAtom2;
        long j2;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mdia);
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_hdlr).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData tkhd = parseTkhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tkhd).data);
        if (OplusGLSurfaceView_15 == -9223372036854775807L) {
            j2 = tkhd.duration;
            leafAtom2 = leafAtom;
        } else {
            leafAtom2 = leafAtom;
            j2 = OplusGLSurfaceView_15;
        }
        long mvhd = parseMvhd(leafAtom2.data);
        long jScaleLargeTimestamp = j2 != -9223372036854775807L ? Util.scaleLargeTimestamp(j2, 1000000L, mvhd) : -9223372036854775807L;
        Atom.ContainerAtom containerAtomOfType2 = containerAtomOfType.getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
        Pair<Long, String> mdhd = parseMdhd(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_mdhd).data);
        StsdData stsd = parseStsd(containerAtomOfType2.getLeafAtomOfType(Atom.TYPE_stsd).data, tkhd.f8988id, tkhd.rotationDegrees, (String) mdhd.second, drmInitData, z2);
        if (z) {
            jArr = null;
            jArr2 = null;
        } else {
            Pair<long[], long[]> edts = parseEdts(containerAtom.getContainerAtomOfType(Atom.TYPE_edts));
            long[] jArr3 = (long[]) edts.first;
            jArr2 = (long[]) edts.second;
            jArr = jArr3;
        }
        if (stsd.format == null) {
            return null;
        }
        return new Track(tkhd.f8988id, trackTypeForHdlr, ((Long) mdhd.first).longValue(), mvhd, jScaleLargeTimestamp, stsd.format, stsd.requiredSampleTransformation, stsd.trackEncryptionBoxes, stsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    public static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        boolean z;
        int unsignedIntToInt;
        int unsignedIntToInt2;
        int OplusGLSurfaceView_13;
        long[] jArr;
        int[] iArr;
        int i2;
        long[] jArr2;
        int[] iArrCopyOf;
        long OplusGLSurfaceView_15;
        int[] iArr2;
        int i3;
        long[] jArr3;
        int[] iArr3;
        int[] iArr4;
        int i4;
        boolean z2;
        int i5;
        int i6;
        boolean z3;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Track track2 = track;
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_stsz);
        if (leafAtomOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafAtomOfType);
        } else {
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stz2);
            if (leafAtomOfType2 == null) {
                throw new ParserException("Track has no sample table size information");
            }
            stz2SampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stco);
        if (leafAtomOfType3 == null) {
            leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_co64);
            z = true;
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType3.data;
        ParsableByteArray parsableByteArray2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stsc).data;
        ParsableByteArray parsableByteArray3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stts).data;
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_stss);
        ParsableByteArray parsableByteArray4 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
        Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_ctts);
        ParsableByteArray parsableByteArray5 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z);
        parsableByteArray3.setPosition(12);
        int unsignedIntToInt3 = parsableByteArray3.readUnsignedIntToInt() - 1;
        int unsignedIntToInt4 = parsableByteArray3.readUnsignedIntToInt();
        int unsignedIntToInt5 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            unsignedIntToInt = parsableByteArray5.readUnsignedIntToInt();
        } else {
            unsignedIntToInt = 0;
        }
        int unsignedIntToInt6 = -1;
        if (parsableByteArray4 != null) {
            parsableByteArray4.setPosition(12);
            unsignedIntToInt2 = parsableByteArray4.readUnsignedIntToInt();
            if (unsignedIntToInt2 > 0) {
                unsignedIntToInt6 = parsableByteArray4.readUnsignedIntToInt() - 1;
            } else {
                parsableByteArray4 = null;
            }
        } else {
            unsignedIntToInt2 = 0;
        }
        if (!(stz2SampleSizeBox.isFixedSampleSize() && MimeTypes.AUDIO_RAW.equals(track2.format.sampleMimeType) && unsignedIntToInt3 == 0 && unsignedIntToInt == 0 && unsignedIntToInt2 == 0)) {
            long[] jArrCopyOf = new long[sampleCount];
            int[] iArrCopyOf2 = new int[sampleCount];
            long[] jArrCopyOf2 = new long[sampleCount];
            int i12 = unsignedIntToInt2;
            iArrCopyOf = new int[sampleCount];
            int i13 = unsignedIntToInt3;
            int i14 = unsignedIntToInt5;
            long j2 = 0;
            long j3 = 0;
            int i15 = 0;
            int i16 = 0;
            int unsignedIntToInt7 = 0;
            int i17 = 0;
            int i18 = i12;
            int i19 = unsignedIntToInt;
            int i20 = unsignedIntToInt4;
            int unsignedIntToInt8 = unsignedIntToInt6;
            int i21 = 0;
            while (true) {
                if (i16 >= sampleCount) {
                    OplusGLSurfaceView_13 = sampleCount;
                    i5 = i18;
                    i6 = i20;
                    break;
                }
                long j4 = j3;
                boolean zMoveNext = true;
                while (i21 == 0) {
                    zMoveNext = chunkIterator.moveNext();
                    if (!zMoveNext) {
                        break;
                    }
                    int i22 = i18;
                    long j5 = chunkIterator.offset;
                    i21 = chunkIterator.numSamples;
                    j4 = j5;
                    i18 = i22;
                    i20 = i20;
                    sampleCount = sampleCount;
                }
                int i23 = sampleCount;
                i5 = i18;
                i6 = i20;
                if (!zMoveNext) {
                    Log.m8324w(TAG, "Unexpected end of chunk data");
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i16);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i16);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i16);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i16);
                    OplusGLSurfaceView_13 = i16;
                    break;
                }
                if (parsableByteArray5 != null) {
                    int i24 = i19;
                    while (unsignedIntToInt7 == 0 && i24 > 0) {
                        unsignedIntToInt7 = parsableByteArray5.readUnsignedIntToInt();
                        i17 = parsableByteArray5.readInt();
                        i24--;
                    }
                    unsignedIntToInt7--;
                    i9 = i24;
                } else {
                    i9 = i19;
                }
                int i25 = i17;
                jArrCopyOf[i16] = j4;
                iArrCopyOf2[i16] = stz2SampleSizeBox.readNextSampleSize();
                if (iArrCopyOf2[i16] > i15) {
                    i15 = iArrCopyOf2[i16];
                }
                jArrCopyOf2[i16] = j2 + i25;
                iArrCopyOf[i16] = parsableByteArray4 == null ? 1 : 0;
                if (i16 == unsignedIntToInt8) {
                    iArrCopyOf[i16] = 1;
                    int i26 = i5 - 1;
                    if (i26 > 0) {
                        unsignedIntToInt8 = parsableByteArray4.readUnsignedIntToInt() - 1;
                    }
                    i10 = i15;
                    i18 = i26;
                    i11 = i25;
                } else {
                    i10 = i15;
                    i11 = i25;
                    i18 = i5;
                }
                j2 += i14;
                int unsignedIntToInt9 = i6 - 1;
                if (unsignedIntToInt9 == 0 && i13 > 0) {
                    unsignedIntToInt9 = parsableByteArray3.readUnsignedIntToInt();
                    i13--;
                    i14 = parsableByteArray3.readInt();
                }
                int i27 = unsignedIntToInt9;
                long j6 = j4 + iArrCopyOf2[i16];
                i21--;
                i16++;
                i17 = i11;
                i20 = i27;
                j3 = j6;
                i15 = i10;
                i19 = i9;
                sampleCount = i23;
            }
            int i28 = i21;
            OplusGLSurfaceView_15 = j2 + i17;
            int i29 = i19;
            while (true) {
                if (i29 <= 0) {
                    z3 = true;
                    break;
                }
                if (parsableByteArray5.readUnsignedIntToInt() != 0) {
                    z3 = false;
                    break;
                }
                parsableByteArray5.readInt();
                i29--;
            }
            if (i5 == 0 && i6 == 0 && i28 == 0 && i13 == 0) {
                i7 = unsignedIntToInt7;
                if (i7 == 0 && z3) {
                    i8 = i15;
                    track2 = track;
                }
                jArr = jArrCopyOf;
                jArr2 = jArrCopyOf2;
                i2 = i8;
                iArr = iArrCopyOf2;
            } else {
                i7 = unsignedIntToInt7;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Inconsistent stbl box for track ");
            i8 = i15;
            track2 = track;
            sb.append(track2.f8989id);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i5);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i6);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i28);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i13);
            sb.append(", remainingSamplesAtTimestampOffset ");
            sb.append(i7);
            sb.append(!z3 ? ", ctts invalid" : "");
            Log.m8324w(TAG, sb.toString());
            jArr = jArrCopyOf;
            jArr2 = jArrCopyOf2;
            i2 = i8;
            iArr = iArrCopyOf2;
        } else {
            OplusGLSurfaceView_13 = sampleCount;
            long[] jArr4 = new long[chunkIterator.length];
            int[] iArr5 = new int[chunkIterator.length];
            while (chunkIterator.moveNext()) {
                jArr4[chunkIterator.index] = chunkIterator.offset;
                iArr5[chunkIterator.index] = chunkIterator.numSamples;
            }
            FixedSampleSizeRechunker.Results resultsRechunk = FixedSampleSizeRechunker.rechunk(Util.getPcmFrameSize(track2.format.pcmEncoding, track2.format.channelCount), jArr4, iArr5, unsignedIntToInt5);
            jArr = resultsRechunk.offsets;
            iArr = resultsRechunk.sizes;
            i2 = resultsRechunk.maximumSize;
            jArr2 = resultsRechunk.timestamps;
            iArrCopyOf = resultsRechunk.flags;
            OplusGLSurfaceView_15 = resultsRechunk.duration;
        }
        int i30 = OplusGLSurfaceView_13;
        long jScaleLargeTimestamp = Util.scaleLargeTimestamp(OplusGLSurfaceView_15, 1000000L, track2.timescale);
        if (track2.editListDurations == null || gaplessInfoHolder.hasGaplessInfo()) {
            long[] jArr5 = jArr2;
            Util.scaleLargeTimestampsInPlace(jArr5, 1000000L, track2.timescale);
            return new TrackSampleTable(track, jArr, iArr, i2, jArr5, iArrCopyOf, jScaleLargeTimestamp);
        }
        if (track2.editListDurations.length == 1 && track2.type == 1 && jArr2.length >= 2) {
            long j7 = track2.editListMediaTimes[0];
            long jScaleLargeTimestamp2 = j7 + Util.scaleLargeTimestamp(track2.editListDurations[0], track2.timescale, track2.movieTimescale);
            iArr2 = iArr;
            i3 = i2;
            if (canApplyEditWithGaplessInfo(jArr2, OplusGLSurfaceView_15, j7, jScaleLargeTimestamp2)) {
                long j8 = OplusGLSurfaceView_15 - jScaleLargeTimestamp2;
                long jScaleLargeTimestamp3 = Util.scaleLargeTimestamp(j7 - jArr2[0], track2.format.sampleRate, track2.timescale);
                long jScaleLargeTimestamp4 = Util.scaleLargeTimestamp(j8, track2.format.sampleRate, track2.timescale);
                if ((jScaleLargeTimestamp3 != 0 || jScaleLargeTimestamp4 != 0) && jScaleLargeTimestamp3 <= 2147483647L && jScaleLargeTimestamp4 <= 2147483647L) {
                    gaplessInfoHolder.encoderDelay = (int) jScaleLargeTimestamp3;
                    gaplessInfoHolder.encoderPadding = (int) jScaleLargeTimestamp4;
                    Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
                    return new TrackSampleTable(track, jArr, iArr2, i3, jArr2, iArrCopyOf, Util.scaleLargeTimestamp(track2.editListDurations[0], 1000000L, track2.movieTimescale));
                }
            }
        } else {
            iArr2 = iArr;
            i3 = i2;
        }
        if (track2.editListDurations.length == 1 && track2.editListDurations[0] == 0) {
            long j9 = track2.editListMediaTimes[0];
            for (int i31 = 0; i31 < jArr2.length; i31++) {
                jArr2[i31] = Util.scaleLargeTimestamp(jArr2[i31] - j9, 1000000L, track2.timescale);
            }
            return new TrackSampleTable(track, jArr, iArr2, i3, jArr2, iArrCopyOf, Util.scaleLargeTimestamp(OplusGLSurfaceView_15 - j9, 1000000L, track2.timescale));
        }
        boolean z4 = track2.type == 1;
        int[] iArr6 = new int[track2.editListDurations.length];
        int[] iArr7 = new int[track2.editListDurations.length];
        int i32 = 0;
        boolean z5 = false;
        int i33 = 0;
        int i34 = 0;
        while (i32 < track2.editListDurations.length) {
            long j10 = track2.editListMediaTimes[i32];
            if (j10 != -1) {
                boolean z6 = z5;
                int i35 = i33;
                long jScaleLargeTimestamp5 = Util.scaleLargeTimestamp(track2.editListDurations[i32], track2.timescale, track2.movieTimescale);
                iArr6[i32] = Util.binarySearchCeil(jArr2, j10, true, true);
                iArr7[i32] = Util.binarySearchCeil(jArr2, j10 + jScaleLargeTimestamp5, z4, false);
                while (iArr6[i32] < iArr7[i32] && (iArrCopyOf[iArr6[i32]] & 1) == 0) {
                    iArr6[i32] = iArr6[i32] + 1;
                }
                i33 = i35 + (iArr7[i32] - iArr6[i32]);
                z2 = z6 | (i34 != iArr6[i32]);
                i4 = iArr7[i32];
            } else {
                i4 = i34;
                z2 = z5;
            }
            i32++;
            z5 = z2;
            i34 = i4;
        }
        boolean z7 = z5;
        int i36 = 0;
        boolean z8 = z7 | (i33 != i30);
        long[] jArr6 = z8 ? new long[i33] : jArr;
        int[] iArr8 = z8 ? new int[i33] : iArr2;
        int i37 = z8 ? 0 : i3;
        int[] iArr9 = z8 ? new int[i33] : iArrCopyOf;
        long[] jArr7 = new long[i33];
        int i38 = 0;
        int i39 = i37;
        long j11 = 0;
        while (i36 < track2.editListDurations.length) {
            long j12 = track2.editListMediaTimes[i36];
            int i40 = iArr6[i36];
            int[] iArr10 = iArr6;
            int i41 = iArr7[i36];
            if (z8) {
                iArr3 = iArr7;
                int i42 = i41 - i40;
                System.arraycopy(jArr, i40, jArr6, i38, i42);
                jArr3 = jArr;
                iArr4 = iArr2;
                System.arraycopy(iArr4, i40, iArr8, i38, i42);
                System.arraycopy(iArrCopyOf, i40, iArr9, i38, i42);
            } else {
                jArr3 = jArr;
                iArr3 = iArr7;
                iArr4 = iArr2;
            }
            int i43 = i39;
            while (i40 < i41) {
                long[] jArr8 = jArr6;
                int i44 = i41;
                long[] jArr9 = jArr2;
                int[] iArr11 = iArrCopyOf;
                jArr7[i38] = Util.scaleLargeTimestamp(j11, 1000000L, track2.movieTimescale) + Util.scaleLargeTimestamp(jArr2[i40] - j12, 1000000L, track2.timescale);
                if (z8 && iArr8[i38] > i43) {
                    i43 = iArr4[i40];
                }
                i38++;
                i40++;
                i41 = i44;
                jArr6 = jArr8;
                jArr2 = jArr9;
                iArrCopyOf = iArr11;
            }
            j11 += track2.editListDurations[i36];
            i36++;
            i39 = i43;
            jArr6 = jArr6;
            iArr6 = iArr10;
            iArr7 = iArr3;
            iArr2 = iArr4;
            jArr = jArr3;
        }
        return new TrackSampleTable(track, jArr6, iArr8, i39, jArr7, iArr9, Util.scaleLargeTimestamp(j11, 1000000L, track2.movieTimescale));
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom, boolean z) {
        if (z) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int OplusGLSurfaceView_13 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_meta) {
                parsableByteArray.setPosition(position);
                return parseUdtaMeta(parsableByteArray, position + OplusGLSurfaceView_13);
            }
            parsableByteArray.setPosition(position + OplusGLSurfaceView_13);
        }
        return null;
    }

    public static Metadata parseMdtaFromMeta(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_hdlr);
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_keys);
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_ilst);
        if (leafAtomOfType == null || leafAtomOfType2 == null || leafAtomOfType3 == null || parseHdlr(leafAtomOfType.data) != TYPE_mdta) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType2.data;
        parsableByteArray.setPosition(12);
        int OplusGLSurfaceView_13 = parsableByteArray.readInt();
        String[] strArr = new String[OplusGLSurfaceView_13];
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            int i3 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i2] = parsableByteArray.readString(i3 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int i4 = parsableByteArray2.readInt();
            int i5 = parsableByteArray2.readInt() - 1;
            if (i5 >= 0 && i5 < strArr.length) {
                MdtaMetadataEntry mdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + i4, strArr[i5]);
                if (mdtaMetadataEntryFromIlst != null) {
                    arrayList.add(mdtaMetadataEntryFromIlst);
                }
            } else {
                Log.m8324w(TAG, "Skipped metadata with unknown key index: " + i5);
            }
            parsableByteArray2.setPosition(position + i4);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < OplusGLSurfaceView_13) {
            int position = parsableByteArray.getPosition();
            int i2 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_ilst) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + i2);
            }
            parsableByteArray.setPosition(position + i2);
        }
        return null;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < OplusGLSurfaceView_13) {
            Metadata.Entry ilstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (ilstElement != null) {
                arrayList.add(ilstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        parsableByteArray.skipBytes(Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0 ? 16 : 8);
        return parsableByteArray.readUnsignedInt();
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        boolean z;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        int OplusGLSurfaceView_13 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        int i2 = fullAtomVersion == 0 ? 4 : 8;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                z = true;
                break;
            }
            if (parsableByteArray.data[position + i4] != -1) {
                z = false;
                break;
            }
            i4++;
        }
        long OplusGLSurfaceView_15 = -9223372036854775807L;
        if (z) {
            parsableByteArray.skipBytes(i2);
        } else {
            long unsignedInt = fullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (unsignedInt != 0) {
                OplusGLSurfaceView_15 = unsignedInt;
            }
        }
        parsableByteArray.skipBytes(16);
        int i5 = parsableByteArray.readInt();
        int i6 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int i7 = parsableByteArray.readInt();
        int i8 = parsableByteArray.readInt();
        if (i5 == 0 && i6 == 65536 && i7 == -65536 && i8 == 0) {
            i3 = 90;
        } else if (i5 == 0 && i6 == -65536 && i7 == 65536 && i8 == 0) {
            i3 = 270;
        } else if (i5 == -65536 && i6 == 0 && i7 == 0 && i8 == -65536) {
            i3 = 180;
        }
        return new TkhdData(OplusGLSurfaceView_13, OplusGLSurfaceView_15, i3);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static int getTrackTypeForHdlr(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == TYPE_soun) {
            return 1;
        }
        if (OplusGLSurfaceView_13 == TYPE_vide) {
            return 2;
        }
        if (OplusGLSurfaceView_13 == TYPE_text || OplusGLSurfaceView_13 == TYPE_sbtl || OplusGLSurfaceView_13 == TYPE_subt || OplusGLSurfaceView_13 == TYPE_clcp) {
            return 3;
        }
        return OplusGLSurfaceView_13 == TYPE_meta ? 4 : -1;
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 4 : 8);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(unsignedInt), "" + ((char) (((unsignedShort >> 10) & 31) + 96)) + ((char) (((unsignedShort >> 5) & 31) + 96)) + ((char) ((unsignedShort & 31) + 96)));
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        parsableByteArray.setPosition(12);
        int i3 = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            int position = parsableByteArray.getPosition();
            int i5 = parsableByteArray.readInt();
            Assertions.checkArgument(i5 > 0, "childAtomSize should be positive");
            int i6 = parsableByteArray.readInt();
            if (i6 == Atom.TYPE_avc1 || i6 == Atom.TYPE_avc3 || i6 == Atom.TYPE_encv || i6 == Atom.TYPE_mp4v || i6 == Atom.TYPE_hvc1 || i6 == Atom.TYPE_hev1 || i6 == Atom.TYPE_s263 || i6 == Atom.TYPE_vp08 || i6 == Atom.TYPE_vp09 || i6 == Atom.TYPE_av01) {
                parseVideoSampleEntry(parsableByteArray, i6, position, i5, OplusGLSurfaceView_13, i2, drmInitData, stsdData, i4);
            } else if (i6 == Atom.TYPE_mp4a || i6 == Atom.TYPE_enca || i6 == Atom.TYPE_ac_3 || i6 == Atom.TYPE_ec_3 || i6 == Atom.TYPE_ac_4 || i6 == Atom.TYPE_dtsc || i6 == Atom.TYPE_dtse || i6 == Atom.TYPE_dtsh || i6 == Atom.TYPE_dtsl || i6 == Atom.TYPE_samr || i6 == Atom.TYPE_sawb || i6 == Atom.TYPE_lpcm || i6 == Atom.TYPE_sowt || i6 == Atom.TYPE__mp3 || i6 == Atom.TYPE_alac || i6 == Atom.TYPE_alaw || i6 == Atom.TYPE_ulaw || i6 == Atom.TYPE_Opus || i6 == Atom.TYPE_fLaC) {
                parseAudioSampleEntry(parsableByteArray, i6, position, i5, OplusGLSurfaceView_13, str, z, drmInitData, stsdData, i4);
            } else if (i6 == Atom.TYPE_TTML || i6 == Atom.TYPE_tx3g || i6 == Atom.TYPE_wvtt || i6 == Atom.TYPE_stpp || i6 == Atom.TYPE_c608) {
                parseTextSampleEntry(parsableByteArray, i6, position, i5, OplusGLSurfaceView_13, str, stsdData);
            } else if (i6 == Atom.TYPE_camm) {
                stsdData.format = Format.createSampleFormat(Integer.toString(OplusGLSurfaceView_13), MimeTypes.APPLICATION_CAMERA_MOTION, null, -1, null);
            }
            parsableByteArray.setPosition(position + i5);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13, int i2, int i3, int i4, String str, StsdData stsdData) throws ParserException {
        parsableByteArray.setPosition(i2 + 8 + 8);
        int i5 = Atom.TYPE_TTML;
        String str2 = MimeTypes.APPLICATION_TTML;
        List listSingletonList = null;
        long OplusGLSurfaceView_15 = Long.MAX_VALUE;
        if (OplusGLSurfaceView_13 != i5) {
            if (OplusGLSurfaceView_13 == Atom.TYPE_tx3g) {
                int i6 = (i3 - 8) - 8;
                byte[] bArr = new byte[i6];
                parsableByteArray.readBytes(bArr, 0, i6);
                listSingletonList = Collections.singletonList(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (OplusGLSurfaceView_13 == Atom.TYPE_wvtt) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (OplusGLSurfaceView_13 == Atom.TYPE_stpp) {
                OplusGLSurfaceView_15 = 0;
            } else if (OplusGLSurfaceView_13 == Atom.TYPE_c608) {
                stsdData.requiredSampleTransformation = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.format = Format.createTextSampleFormat(Integer.toString(i4), str2, null, -1, 0, str, -1, null, OplusGLSurfaceView_15, listSingletonList);
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        parsableByteArray.setPosition(i2 + 8 + 8);
        parsableByteArray.skipBytes(16);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        String str = null;
        int iIntValue = OplusGLSurfaceView_13;
        if (iIntValue == Atom.TYPE_encv) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i2, i3);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i6] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        DrmInitData drmInitData2 = drmInitDataCopyWithSchemeType;
        int i7 = -1;
        List<byte[]> listSingletonList = null;
        byte[] projFromParent = null;
        float paspFromParent = 1.0f;
        boolean z = false;
        while (position - i2 < i3) {
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int i8 = parsableByteArray.readInt();
            if (i8 == 0 && parsableByteArray.getPosition() - i2 == i3) {
                break;
            }
            Assertions.checkArgument(i8 > 0, "childAtomSize should be positive");
            int i9 = parsableByteArray.readInt();
            if (i9 == Atom.TYPE_avcC) {
                Assertions.checkState(str == null);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig avcConfig = AvcConfig.parse(parsableByteArray);
                listSingletonList = avcConfig.initializationData;
                stsdData.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                if (!z) {
                    paspFromParent = avcConfig.pixelWidthAspectRatio;
                }
                str = MimeTypes.VIDEO_H264;
            } else if (i9 == Atom.TYPE_hvcC) {
                Assertions.checkState(str == null);
                parsableByteArray.setPosition(position2 + 8);
                HevcConfig hevcConfig = HevcConfig.parse(parsableByteArray);
                listSingletonList = hevcConfig.initializationData;
                stsdData.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                str = MimeTypes.VIDEO_H265;
            } else if (i9 == Atom.TYPE_vpcC) {
                Assertions.checkState(str == null);
                str = iIntValue == Atom.TYPE_vp08 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
            } else if (i9 == Atom.TYPE_av1C) {
                Assertions.checkState(str == null);
                str = MimeTypes.VIDEO_AV1;
            } else if (i9 == Atom.TYPE_d263) {
                Assertions.checkState(str == null);
                str = MimeTypes.VIDEO_H263;
            } else if (i9 == Atom.TYPE_esds) {
                Assertions.checkState(str == null);
                Pair<String, byte[]> esdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                str = (String) esdsFromParent.first;
                listSingletonList = Collections.singletonList(esdsFromParent.second);
            } else if (i9 == Atom.TYPE_pasp) {
                paspFromParent = parsePaspFromParent(parsableByteArray, position2);
                z = true;
            } else if (i9 == Atom.TYPE_sv3d) {
                projFromParent = parseProjFromParent(parsableByteArray, position2, i8);
            } else if (i9 == Atom.TYPE_st3d) {
                int unsignedByte = parsableByteArray.readUnsignedByte();
                parsableByteArray.skipBytes(3);
                if (unsignedByte == 0) {
                    int unsignedByte2 = parsableByteArray.readUnsignedByte();
                    if (unsignedByte2 == 0) {
                        i7 = 0;
                    } else if (unsignedByte2 == 1) {
                        i7 = 1;
                    } else if (unsignedByte2 == 2) {
                        i7 = 2;
                    } else if (unsignedByte2 == 3) {
                        i7 = 3;
                    }
                }
            }
            position += i8;
        }
        if (str == null) {
            return;
        }
        stsdData.format = Format.createVideoSampleFormat(Integer.toString(i4), str, null, -1, -1, unsignedShort, unsignedShort2, -1.0f, listSingletonList, i5, paspFromParent, projFromParent, i7, null, drmInitData2);
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType;
        if (containerAtom == null || (leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst)) == null) {
            return Pair.create(null, null);
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[unsignedIntToInt];
        long[] jArr2 = new long[unsignedIntToInt];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < unsignedIntToInt; OplusGLSurfaceView_13++) {
            jArr[OplusGLSurfaceView_13] = fullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[OplusGLSurfaceView_13] = fullAtomVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13) {
        parsableByteArray.setPosition(OplusGLSurfaceView_13 + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, StsdData stsdData, int i5) throws ParserException {
        int unsignedShort;
        int unsignedShort2;
        int unsignedFixedPoint1616;
        String str2;
        int i6;
        String str3;
        int i7;
        String str4;
        DrmInitData drmInitData2;
        boolean z2;
        int i8;
        int i9;
        int i10 = i2;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        parsableByteArray.setPosition(i10 + 8 + 8);
        int i11 = 0;
        if (z) {
            unsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            unsignedShort = 0;
        }
        int i12 = 2;
        boolean z3 = true;
        if (unsignedShort == 0 || unsignedShort == 1) {
            unsignedShort2 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            unsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            if (unsignedShort == 1) {
                parsableByteArray.skipBytes(16);
            }
        } else {
            if (unsignedShort != 2) {
                return;
            }
            parsableByteArray.skipBytes(16);
            unsignedFixedPoint1616 = (int) Math.round(parsableByteArray.readDouble());
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(20);
            unsignedShort2 = unsignedIntToInt;
        }
        int position = parsableByteArray.getPosition();
        int iIntValue = OplusGLSurfaceView_13;
        if (iIntValue == Atom.TYPE_enca) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i10, i3);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i5] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        DrmInitData drmInitData3 = drmInitDataCopyWithSchemeType;
        int i13 = Atom.TYPE_ac_3;
        String str5 = MimeTypes.AUDIO_RAW;
        if (iIntValue == i13) {
            str2 = MimeTypes.AUDIO_AC3;
        } else if (iIntValue == Atom.TYPE_ec_3) {
            str2 = MimeTypes.AUDIO_E_AC3;
        } else if (iIntValue == Atom.TYPE_ac_4) {
            str2 = MimeTypes.AUDIO_AC4;
        } else if (iIntValue == Atom.TYPE_dtsc) {
            str2 = MimeTypes.AUDIO_DTS;
        } else if (iIntValue == Atom.TYPE_dtsh || iIntValue == Atom.TYPE_dtsl) {
            str2 = MimeTypes.AUDIO_DTS_HD;
        } else if (iIntValue == Atom.TYPE_dtse) {
            str2 = MimeTypes.AUDIO_DTS_EXPRESS;
        } else if (iIntValue == Atom.TYPE_samr) {
            str2 = MimeTypes.AUDIO_AMR_NB;
        } else if (iIntValue == Atom.TYPE_sawb) {
            str2 = MimeTypes.AUDIO_AMR_WB;
        } else if (iIntValue == Atom.TYPE_lpcm || iIntValue == Atom.TYPE_sowt) {
            str2 = MimeTypes.AUDIO_RAW;
        } else if (iIntValue == Atom.TYPE__mp3) {
            str2 = MimeTypes.AUDIO_MPEG;
        } else if (iIntValue == Atom.TYPE_alac) {
            str2 = MimeTypes.AUDIO_ALAC;
        } else if (iIntValue == Atom.TYPE_alaw) {
            str2 = MimeTypes.AUDIO_ALAW;
        } else if (iIntValue == Atom.TYPE_ulaw) {
            str2 = MimeTypes.AUDIO_MLAW;
        } else if (iIntValue == Atom.TYPE_Opus) {
            str2 = MimeTypes.AUDIO_OPUS;
        } else {
            str2 = iIntValue == Atom.TYPE_fLaC ? MimeTypes.AUDIO_FLAC : null;
        }
        int iIntValue2 = unsignedFixedPoint1616;
        int i14 = position;
        int iIntValue3 = unsignedShort2;
        byte[] bArr = null;
        String str6 = str2;
        while (i14 - i10 < i3) {
            parsableByteArray.setPosition(i14);
            int i15 = parsableByteArray.readInt();
            Assertions.checkArgument(i15 > 0 ? z3 : i11, "childAtomSize should be positive");
            int i16 = parsableByteArray.readInt();
            if (i16 == Atom.TYPE_esds || (z && i16 == Atom.TYPE_wave)) {
                i6 = i15;
                str3 = str6;
                i7 = i14;
                str4 = str5;
                drmInitData2 = drmInitData3;
                z2 = z3;
                i8 = i12;
                i9 = i11;
                int iFindEsdsPosition = i16 == Atom.TYPE_esds ? i7 : findEsdsPosition(parsableByteArray, i7, i6);
                if (iFindEsdsPosition != -1) {
                    Pair<String, byte[]> esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindEsdsPosition);
                    str6 = (String) esdsFromParent.first;
                    bArr = (byte[]) esdsFromParent.second;
                    if (MimeTypes.AUDIO_AAC.equals(str6)) {
                        Pair<Integer, Integer> aacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArr);
                        iIntValue2 = ((Integer) aacAudioSpecificConfig.first).intValue();
                        iIntValue3 = ((Integer) aacAudioSpecificConfig.second).intValue();
                    }
                }
                i14 = i7 + i6;
                i11 = i9;
                drmInitData3 = drmInitData2;
                z3 = z2;
                i12 = i8;
                str5 = str4;
                i10 = i2;
            } else {
                if (i16 == Atom.TYPE_dac3) {
                    parsableByteArray.setPosition(i14 + 8);
                    stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitData3);
                } else if (i16 == Atom.TYPE_dec3) {
                    parsableByteArray.setPosition(i14 + 8);
                    stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitData3);
                } else if (i16 == Atom.TYPE_dac4) {
                    parsableByteArray.setPosition(i14 + 8);
                    stsdData.format = Ac4Util.parseAc4AnnexEFormat(parsableByteArray, Integer.toString(i4), str, drmInitData3);
                } else if (i16 == Atom.TYPE_ddts) {
                    str3 = str6;
                    str4 = str5;
                    drmInitData2 = drmInitData3;
                    z2 = z3;
                    i8 = i12;
                    i9 = i11;
                    stsdData.format = Format.createAudioSampleFormat(Integer.toString(i4), str6, null, -1, -1, iIntValue3, iIntValue2, null, drmInitData2, 0, str);
                    i6 = i15;
                    i7 = i14;
                } else {
                    str3 = str6;
                    int i17 = i14;
                    str4 = str5;
                    drmInitData2 = drmInitData3;
                    z2 = z3;
                    i8 = i12;
                    i9 = i11;
                    if (i16 == Atom.TYPE_alac) {
                        i6 = i15;
                        byte[] bArr2 = new byte[i6];
                        i7 = i17;
                        parsableByteArray.setPosition(i7);
                        parsableByteArray.readBytes(bArr2, i9, i6);
                        bArr = bArr2;
                    } else {
                        i6 = i15;
                        i7 = i17;
                        if (i16 == Atom.TYPE_dOps) {
                            int i18 = i6 - 8;
                            byte[] bArr3 = opusMagic;
                            byte[] bArr4 = new byte[bArr3.length + i18];
                            System.arraycopy(bArr3, i9, bArr4, i9, bArr3.length);
                            parsableByteArray.setPosition(i7 + 8);
                            parsableByteArray.readBytes(bArr4, opusMagic.length, i18);
                            bArr = bArr4;
                        } else if (i6 == Atom.TYPE_dfLa) {
                            int i19 = i6 - 12;
                            byte[] bArr5 = new byte[i19];
                            parsableByteArray.setPosition(i7 + 12);
                            parsableByteArray.readBytes(bArr5, i9, i19);
                            bArr = bArr5;
                        }
                    }
                }
                i6 = i15;
                str3 = str6;
                i7 = i14;
                str4 = str5;
                drmInitData2 = drmInitData3;
                z2 = z3;
                i8 = i12;
                i9 = i11;
            }
            str6 = str3;
            i14 = i7 + i6;
            i11 = i9;
            drmInitData3 = drmInitData2;
            z3 = z2;
            i12 = i8;
            str5 = str4;
            i10 = i2;
        }
        String str7 = str6;
        String str8 = str5;
        DrmInitData drmInitData4 = drmInitData3;
        int i20 = i12;
        if (stsdData.format != null || str7 == null) {
            return;
        }
        if (!str8.equals(str7)) {
            i20 = -1;
        }
        stsdData.format = Format.createAudioSampleFormat(Integer.toString(i4), str7, null, -1, -1, iIntValue3, iIntValue2, i20, bArr == null ? null : Collections.singletonList(bArr), drmInitData4, 0, str);
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13, int i2) {
        int position = parsableByteArray.getPosition();
        while (position - OplusGLSurfaceView_13 < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            Assertions.checkArgument(i3 > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_esds) {
                return position;
            }
            position += i3;
        }
        return -1;
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13) {
        parsableByteArray.setPosition(OplusGLSurfaceView_13 + 8 + 4);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if ((unsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((unsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((unsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if (MimeTypes.AUDIO_MPEG.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int expandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[expandableClassSize];
        parsableByteArray.readBytes(bArr, 0, expandableClassSize);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13, int i2) {
        Pair<Integer, TrackEncryptionBox> commonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - OplusGLSurfaceView_13 < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            Assertions.checkArgument(i3 > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_sinf && (commonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, i3)) != null) {
                return commonEncryptionSinfFromParent;
            }
            position += i3;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 + 8;
        int i4 = -1;
        String string = null;
        Integer numValueOf = null;
        int i5 = 0;
        while (i3 - OplusGLSurfaceView_13 < i2) {
            parsableByteArray.setPosition(i3);
            int i6 = parsableByteArray.readInt();
            int i7 = parsableByteArray.readInt();
            if (i7 == Atom.TYPE_frma) {
                numValueOf = Integer.valueOf(parsableByteArray.readInt());
            } else if (i7 == Atom.TYPE_schm) {
                parsableByteArray.skipBytes(4);
                string = parsableByteArray.readString(4);
            } else if (i7 == Atom.TYPE_schi) {
                i4 = i3;
                i5 = i6;
            }
            i3 += i6;
        }
        if (!C1547C.CENC_TYPE_cenc.equals(string) && !C1547C.CENC_TYPE_cbc1.equals(string) && !C1547C.CENC_TYPE_cens.equals(string) && !C1547C.CENC_TYPE_cbcs.equals(string)) {
            return null;
        }
        Assertions.checkArgument(numValueOf != null, "frma atom is mandatory");
        Assertions.checkArgument(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox schiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, string);
        Assertions.checkArgument(schiFromParent != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, schiFromParent);
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13, int i2, String str) {
        int i3;
        int i4;
        int i5 = OplusGLSurfaceView_13 + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - OplusGLSurfaceView_13 >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int i6 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_tenc) {
                int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (fullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = unsignedByte & 15;
                    i4 = (unsignedByte & 240) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, bArr2.length);
                if (z && unsignedByte2 == 0) {
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[unsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, unsignedByte3);
                }
                return new TrackEncryptionBox(z, str, unsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += i6;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 + 8;
        while (i3 - OplusGLSurfaceView_13 < i2) {
            parsableByteArray.setPosition(i3);
            int i4 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_proj) {
                return Arrays.copyOfRange(parsableByteArray.data, i3, i4 + i3);
            }
            i3 += i4;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int OplusGLSurfaceView_13 = unsignedByte & 127;
        while ((unsignedByte & 128) == 128) {
            unsignedByte = parsableByteArray.readUnsignedByte();
            OplusGLSurfaceView_13 = (OplusGLSurfaceView_13 << 7) | (unsignedByte & 127);
        }
        return OplusGLSurfaceView_13;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long OplusGLSurfaceView_15, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[Util.constrainValue(3, 0, length)] && jArr[Util.constrainValue(jArr.length - 3, 0, length)] < j3 && j3 <= OplusGLSurfaceView_15;
    }

    private AtomParsers() {
    }

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            int OplusGLSurfaceView_13 = this.index + 1;
            this.index = OplusGLSurfaceView_13;
            if (OplusGLSurfaceView_13 == this.length) {
                return false;
            }
            this.offset = this.chunkOffsetsAreLongs ? this.chunkOffsets.readUnsignedLongToLong() : this.chunkOffsets.readUnsignedInt();
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    private static final class TkhdData {
        private final long duration;

        /* renamed from: id_renamed */
        private final int f8988id;
        private final int rotationDegrees;

        public TkhdData(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, int i2) {
            this.f8988id = OplusGLSurfaceView_13;
            this.duration = OplusGLSurfaceView_15;
            this.rotationDegrees = i2;
        }
    }

    private static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int OplusGLSurfaceView_13) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[OplusGLSurfaceView_13];
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom) {
            this.data = leafAtom.data;
            this.data.setPosition(12);
            this.fixedSampleSize = this.data.readUnsignedIntToInt();
            this.sampleCount = this.data.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int OplusGLSurfaceView_13 = this.fixedSampleSize;
            return OplusGLSurfaceView_13 == 0 ? this.data.readUnsignedIntToInt() : OplusGLSurfaceView_13;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            return this.fixedSampleSize != 0;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            return false;
        }

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            this.data = leafAtom.data;
            this.data.setPosition(12);
            this.fieldSize = this.data.readUnsignedIntToInt() & 255;
            this.sampleCount = this.data.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int OplusGLSurfaceView_13 = this.fieldSize;
            if (OplusGLSurfaceView_13 == 8) {
                return this.data.readUnsignedByte();
            }
            if (OplusGLSurfaceView_13 == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 == 0) {
                this.currentByte = this.data.readUnsignedByte();
                return (this.currentByte & 240) >> 4;
            }
            return this.currentByte & 15;
        }
    }
}

package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public final class Ac3Util {
    private static final int AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT = 1536;
    private static final int AUDIO_SAMPLES_PER_AUDIO_BLOCK = 256;
    public static final int TRUEHD_RECHUNK_SAMPLE_COUNT = 16;
    public static final int TRUEHD_SYNCFRAME_PREFIX_LENGTH = 10;
    private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = {1, 2, 3, 6};
    private static final int[] SAMPLE_RATE_BY_FSCOD = {48000, 44100, 32000};
    private static final int[] SAMPLE_RATE_BY_FSCOD2 = {com.oplus.tblplayer.monitor.ErrorCode.REASON_HLS_PLAYLIST_RESET, 22050, com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_CONTENT};
    private static final int[] CHANNEL_COUNT_BY_ACMOD = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] BITRATE_BY_HALF_FRMSIZECOD = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int getAc3SyncframeAudioSampleCount() {
        return AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT;
    }

    public static final class SyncFrameInfo {
        public static final int STREAM_TYPE_TYPE0 = 0;
        public static final int STREAM_TYPE_TYPE1 = 1;
        public static final int STREAM_TYPE_TYPE2 = 2;
        public static final int STREAM_TYPE_UNDEFINED = -1;
        public final int channelCount;
        public final int frameSize;
        public final java.lang.String mimeType;
        public final int sampleCount;
        public final int sampleRate;
        public final int streamType;

        @java.lang.annotation.Documented
        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface StreamType {
        }

        private SyncFrameInfo(java.lang.String str, int i_renamed, int i2, int i3, int i4, int i5) {
            this.mimeType = str;
            this.streamType = i_renamed;
            this.channelCount = i2;
            this.sampleRate = i3;
            this.frameSize = i4;
            this.sampleCount = i5;
        }
    }

    public static com.google.android.exoplayer2.Format parseAc3AnnexFFormat(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, java.lang.String str, java.lang.String str2, com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        int i_renamed = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & 192) >> 6];
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(unsignedByte & 56) >> 3];
        if ((unsignedByte & 4) != 0) {
            i2++;
        }
        return com.google.android.exoplayer2.Format.createAudioSampleFormat(str, com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC3, null, -1, -1, i2, i_renamed, null, drmInitData, 0, str2);
    }

    public static com.google.android.exoplayer2.Format parseEAc3AnnexFFormat(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, java.lang.String str, java.lang.String str2, com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        parsableByteArray.skipBytes(2);
        int i_renamed = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & 192) >> 6];
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(unsignedByte & 14) >> 1];
        if ((unsignedByte & 1) != 0) {
            i2++;
        }
        if (((parsableByteArray.readUnsignedByte() & 30) >> 1) > 0 && (2 & parsableByteArray.readUnsignedByte()) != 0) {
            i2 += 2;
        }
        return com.google.android.exoplayer2.Format.createAudioSampleFormat(str, (parsableByteArray.bytesLeft() <= 0 || (parsableByteArray.readUnsignedByte() & 1) == 0) ? com.google.android.exoplayer2.util.MimeTypes.AUDIO_E_AC3 : com.google.android.exoplayer2.util.MimeTypes.AUDIO_E_AC3_JOC, null, -1, -1, i2, i_renamed, null, drmInitData, 0, str2);
    }

    public static com.google.android.exoplayer2.audio.Ac3Util.SyncFrameInfo parseAc3SyncframeInfo(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) {
        int ac3SyncframeSize;
        int i_renamed;
        int i2;
        int i3;
        java.lang.String str;
        int bits;
        int i4;
        int i5;
        int position = parsableBitArray.getPosition();
        parsableBitArray.skipBits(40);
        boolean z_renamed = parsableBitArray.readBits(5) == 16;
        parsableBitArray.setPosition(position);
        int i6 = -1;
        if (z_renamed) {
            parsableBitArray.skipBits(16);
            int bits2 = parsableBitArray.readBits(2);
            if (bits2 == 0) {
                i6 = 0;
            } else if (bits2 == 1) {
                i6 = 1;
            } else if (bits2 == 2) {
                i6 = 2;
            }
            parsableBitArray.skipBits(3);
            ac3SyncframeSize = (parsableBitArray.readBits(11) + 1) * 2;
            int bits3 = parsableBitArray.readBits(2);
            if (bits3 == 3) {
                i4 = 6;
                i_renamed = SAMPLE_RATE_BY_FSCOD2[parsableBitArray.readBits(2)];
                bits = 3;
            } else {
                bits = parsableBitArray.readBits(2);
                i4 = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[bits];
                i_renamed = SAMPLE_RATE_BY_FSCOD[bits3];
            }
            i2 = i4 * 256;
            int bits4 = parsableBitArray.readBits(3);
            boolean bit = parsableBitArray.readBit();
            i3 = CHANNEL_COUNT_BY_ACMOD[bits4] + (bit ? 1 : 0);
            parsableBitArray.skipBits(10);
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(8);
            }
            if (bits4 == 0) {
                parsableBitArray.skipBits(5);
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
            }
            if (i6 == 1 && parsableBitArray.readBit()) {
                parsableBitArray.skipBits(16);
            }
            if (parsableBitArray.readBit()) {
                if (bits4 > 2) {
                    parsableBitArray.skipBits(2);
                }
                if ((bits4 & 1) != 0 && bits4 > 2) {
                    parsableBitArray.skipBits(6);
                }
                if ((bits4 & 4) != 0) {
                    parsableBitArray.skipBits(6);
                }
                if (bit && parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(5);
                }
                if (i6 == 0) {
                    if (parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(6);
                    }
                    if (bits4 == 0 && parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(6);
                    }
                    if (parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(6);
                    }
                    int bits5 = parsableBitArray.readBits(2);
                    if (bits5 == 1) {
                        parsableBitArray.skipBits(5);
                    } else if (bits5 == 2) {
                        parsableBitArray.skipBits(12);
                    } else if (bits5 == 3) {
                        int bits6 = parsableBitArray.readBits(5);
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                            }
                        }
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(7);
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(8);
                                }
                            }
                        }
                        parsableBitArray.skipBits((bits6 + 2) * 8);
                        parsableBitArray.byteAlign();
                    }
                    if (bits4 < 2) {
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(14);
                        }
                        if (bits4 == 0 && parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(14);
                        }
                    }
                    if (parsableBitArray.readBit()) {
                        if (bits == 0) {
                            parsableBitArray.skipBits(5);
                        } else {
                            for (int i7 = 0; i7 < i4; i7++) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(5);
                                }
                            }
                        }
                    }
                }
            }
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(5);
                if (bits4 == 2) {
                    parsableBitArray.skipBits(4);
                }
                if (bits4 >= 6) {
                    parsableBitArray.skipBits(2);
                }
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
                if (bits4 == 0 && parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
                i5 = 3;
                if (bits3 < 3) {
                    parsableBitArray.skipBit();
                }
            } else {
                i5 = 3;
            }
            if (i6 == 0 && bits != i5) {
                parsableBitArray.skipBit();
            }
            if (i6 == 2 && (bits == i5 || parsableBitArray.readBit())) {
                parsableBitArray.skipBits(6);
            }
            str = (parsableBitArray.readBit() && parsableBitArray.readBits(6) == 1 && parsableBitArray.readBits(8) == 1) ? com.google.android.exoplayer2.util.MimeTypes.AUDIO_E_AC3_JOC : com.google.android.exoplayer2.util.MimeTypes.AUDIO_E_AC3;
        } else {
            parsableBitArray.skipBits(32);
            int bits7 = parsableBitArray.readBits(2);
            ac3SyncframeSize = getAc3SyncframeSize(bits7, parsableBitArray.readBits(6));
            parsableBitArray.skipBits(8);
            int bits8 = parsableBitArray.readBits(3);
            if ((bits8 & 1) != 0 && bits8 != 1) {
                parsableBitArray.skipBits(2);
            }
            if ((bits8 & 4) != 0) {
                parsableBitArray.skipBits(2);
            }
            if (bits8 == 2) {
                parsableBitArray.skipBits(2);
            }
            i_renamed = SAMPLE_RATE_BY_FSCOD[bits7];
            i2 = AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT;
            i3 = CHANNEL_COUNT_BY_ACMOD[bits8] + (parsableBitArray.readBit() ? 1 : 0);
            str = com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC3;
        }
        return new com.google.android.exoplayer2.audio.Ac3Util.SyncFrameInfo(str, i6, i3, i_renamed, ac3SyncframeSize, i2);
    }

    public static int parseAc3SyncframeSize(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 255) >> 3) == 16) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        return getAc3SyncframeSize((bArr[4] & 192) >> 6, bArr[4] & 63);
    }

    public static int parseEAc3SyncframeAudioSampleCount(java.nio.ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }

    public static int findTrueHdSyncframeOffset(java.nio.ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i_renamed = iPosition; i_renamed <= iLimit; i_renamed++) {
            if ((byteBuffer.getInt(i_renamed + 4) & (-16777217)) == -1167101192) {
                return i_renamed - iPosition;
            }
        }
        return -1;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            return 40 << ((bArr[(bArr[7] & 255) == 187 ? '\t_renamed' : '\b_renamed'] >> 4) & 7);
        }
        return 0;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(java.nio.ByteBuffer byteBuffer, int i_renamed) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i_renamed) + ((byteBuffer.get((byteBuffer.position() + i_renamed) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    private static int getAc3SyncframeSize(int i_renamed, int i2) {
        int i3 = i2 / 2;
        if (i_renamed < 0) {
            return -1;
        }
        int[] iArr = SAMPLE_RATE_BY_FSCOD;
        if (i_renamed >= iArr.length || i2 < 0) {
            return -1;
        }
        int[] iArr2 = SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1;
        if (i3 >= iArr2.length) {
            return -1;
        }
        int i4 = iArr[i_renamed];
        if (i4 == 44100) {
            return (iArr2[i3] + (i2 % 2)) * 2;
        }
        int i5 = BITRATE_BY_HALF_FRMSIZECOD[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }

    private Ac3Util() {
    }
}

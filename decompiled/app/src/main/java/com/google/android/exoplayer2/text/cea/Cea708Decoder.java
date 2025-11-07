package com.google.android.exoplayer2.text.cea;

/* loaded from: classes.dex */
public final class Cea708Decoder extends com.google.android.exoplayer2.text.cea.CeaDecoder {
    private static final int CC_VALID_FLAG = 4;
    private static final int CHARACTER_BIG_CARONS = 42;
    private static final int CHARACTER_BIG_OE = 44;
    private static final int CHARACTER_BOLD_BULLET = 53;
    private static final int CHARACTER_CLOSE_DOUBLE_QUOTE = 52;
    private static final int CHARACTER_CLOSE_SINGLE_QUOTE = 50;
    private static final int CHARACTER_DIAERESIS_Y = 63;
    private static final int CHARACTER_ELLIPSIS = 37;
    private static final int CHARACTER_FIVE_EIGHTHS = 120;
    private static final int CHARACTER_HORIZONTAL_BORDER = 125;
    private static final int CHARACTER_LOWER_LEFT_BORDER = 124;
    private static final int CHARACTER_LOWER_RIGHT_BORDER = 126;
    private static final int CHARACTER_MN = 127;
    private static final int CHARACTER_NBTSP = 33;
    private static final int CHARACTER_ONE_EIGHTH = 118;
    private static final int CHARACTER_OPEN_DOUBLE_QUOTE = 51;
    private static final int CHARACTER_OPEN_SINGLE_QUOTE = 49;
    private static final int CHARACTER_SEVEN_EIGHTHS = 121;
    private static final int CHARACTER_SM = 61;
    private static final int CHARACTER_SMALL_CARONS = 58;
    private static final int CHARACTER_SMALL_OE = 60;
    private static final int CHARACTER_SOLID_BLOCK = 48;
    private static final int CHARACTER_THREE_EIGHTHS = 119;
    private static final int CHARACTER_TM = 57;
    private static final int CHARACTER_TSP = 32;
    private static final int CHARACTER_UPPER_LEFT_BORDER = 127;
    private static final int CHARACTER_UPPER_RIGHT_BORDER = 123;
    private static final int CHARACTER_VERTICAL_BORDER = 122;
    private static final int COMMAND_BS = 8;
    private static final int COMMAND_CLW = 136;
    private static final int COMMAND_CR = 13;
    private static final int COMMAND_CW0 = 128;
    private static final int COMMAND_CW1 = 129;
    private static final int COMMAND_CW2 = 130;
    private static final int COMMAND_CW3 = 131;
    private static final int COMMAND_CW4 = 132;
    private static final int COMMAND_CW5 = 133;
    private static final int COMMAND_CW6 = 134;
    private static final int COMMAND_CW7 = 135;
    private static final int COMMAND_DF0 = 152;
    private static final int COMMAND_DF1 = 153;
    private static final int COMMAND_DF2 = 154;
    private static final int COMMAND_DF3 = 155;
    private static final int COMMAND_DF4 = 156;
    private static final int COMMAND_DF5 = 157;
    private static final int COMMAND_DF6 = 158;
    private static final int COMMAND_DF7 = 159;
    private static final int COMMAND_DLC = 142;
    private static final int COMMAND_DLW = 140;
    private static final int COMMAND_DLY = 141;
    private static final int COMMAND_DSW = 137;
    private static final int COMMAND_ETX = 3;
    private static final int COMMAND_EXT1 = 16;
    private static final int COMMAND_EXT1_END = 23;
    private static final int COMMAND_EXT1_START = 17;
    private static final int COMMAND_FF = 12;
    private static final int COMMAND_HCR = 14;
    private static final int COMMAND_HDW = 138;
    private static final int COMMAND_NUL = 0;
    private static final int COMMAND_P16_END = 31;
    private static final int COMMAND_P16_START = 24;
    private static final int COMMAND_RST = 143;
    private static final int COMMAND_SPA = 144;
    private static final int COMMAND_SPC = 145;
    private static final int COMMAND_SPL = 146;
    private static final int COMMAND_SWA = 151;
    private static final int COMMAND_TGW = 139;
    private static final int DTVCC_PACKET_DATA = 2;
    private static final int DTVCC_PACKET_START = 3;
    private static final int GROUP_C0_END = 31;
    private static final int GROUP_C1_END = 159;
    private static final int GROUP_C2_END = 31;
    private static final int GROUP_C3_END = 159;
    private static final int GROUP_G0_END = 127;
    private static final int GROUP_G1_END = 255;
    private static final int GROUP_G2_END = 127;
    private static final int GROUP_G3_END = 255;
    private static final int NUM_WINDOWS = 8;
    private static final java.lang.String TAG = "Cea708Decoder";
    private final com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder[] cueBuilders;
    private java.util.List<com.google.android.exoplayer2.text.Cue> cues;
    private com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder currentCueBuilder;
    private com.google.android.exoplayer2.text.cea.Cea708Decoder.DtvCcPacket currentDtvCcPacket;
    private int currentWindow;
    private java.util.List<com.google.android.exoplayer2.text.Cue> lastCues;
    private final int selectedServiceNumber;
    private final com.google.android.exoplayer2.util.ParsableByteArray ccData = new com.google.android.exoplayer2.util.ParsableByteArray();
    private final com.google.android.exoplayer2.util.ParsableBitArray serviceBlockPacket = new com.google.android.exoplayer2.util.ParsableBitArray();

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public java.lang.String getName() {
        return TAG;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.text.SubtitleInputBuffer dequeueInputBuffer() throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.text.SubtitleOutputBuffer dequeueOutputBuffer() throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public /* bridge */ /* synthetic */ void queueInputBuffer(com.google.android.exoplayer2.text.SubtitleInputBuffer subtitleInputBuffer) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j_renamed) {
        super.setPositionUs(j_renamed);
    }

    public Cea708Decoder(int i_renamed, java.util.List<byte[]> list) {
        this.selectedServiceNumber = i_renamed == -1 ? 1 : i_renamed;
        this.cueBuilders = new com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.cueBuilders[i2] = new com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder();
        }
        this.currentCueBuilder = this.cueBuilders[0];
        resetCueBuilders();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        this.currentWindow = 0;
        this.currentCueBuilder = this.cueBuilders[this.currentWindow];
        resetCueBuilders();
        this.currentDtvCcPacket = null;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    protected boolean isNewSubtitleDataAvailable() {
        return this.cues != this.lastCues;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    protected com.google.android.exoplayer2.text.Subtitle createSubtitle() {
        java.util.List<com.google.android.exoplayer2.text.Cue> list = this.cues;
        this.lastCues = list;
        return new com.google.android.exoplayer2.text.cea.CeaSubtitle(list);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    protected void decode(com.google.android.exoplayer2.text.SubtitleInputBuffer subtitleInputBuffer) {
        this.ccData.reset(subtitleInputBuffer.data.array(), subtitleInputBuffer.data.limit());
        while (this.ccData.bytesLeft() >= 3) {
            int unsignedByte = this.ccData.readUnsignedByte() & 7;
            int i_renamed = unsignedByte & 3;
            boolean z_renamed = (unsignedByte & 4) == 4;
            byte unsignedByte2 = (byte) this.ccData.readUnsignedByte();
            byte unsignedByte3 = (byte) this.ccData.readUnsignedByte();
            if (i_renamed == 2 || i_renamed == 3) {
                if (z_renamed) {
                    if (i_renamed == 3) {
                        finalizeCurrentPacket();
                        int i2 = (unsignedByte2 & 192) >> 6;
                        int i3 = unsignedByte2 & 63;
                        if (i3 == 0) {
                            i3 = 64;
                        }
                        this.currentDtvCcPacket = new com.google.android.exoplayer2.text.cea.Cea708Decoder.DtvCcPacket(i2, i3);
                        byte[] bArr = this.currentDtvCcPacket.packetData;
                        com.google.android.exoplayer2.text.cea.Cea708Decoder.DtvCcPacket dtvCcPacket = this.currentDtvCcPacket;
                        int i4 = dtvCcPacket.currentIndex;
                        dtvCcPacket.currentIndex = i4 + 1;
                        bArr[i4] = unsignedByte3;
                    } else {
                        com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed == 2);
                        com.google.android.exoplayer2.text.cea.Cea708Decoder.DtvCcPacket dtvCcPacket2 = this.currentDtvCcPacket;
                        if (dtvCcPacket2 == null) {
                            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = dtvCcPacket2.packetData;
                            com.google.android.exoplayer2.text.cea.Cea708Decoder.DtvCcPacket dtvCcPacket3 = this.currentDtvCcPacket;
                            int i5 = dtvCcPacket3.currentIndex;
                            dtvCcPacket3.currentIndex = i5 + 1;
                            bArr2[i5] = unsignedByte2;
                            byte[] bArr3 = this.currentDtvCcPacket.packetData;
                            com.google.android.exoplayer2.text.cea.Cea708Decoder.DtvCcPacket dtvCcPacket4 = this.currentDtvCcPacket;
                            int i6 = dtvCcPacket4.currentIndex;
                            dtvCcPacket4.currentIndex = i6 + 1;
                            bArr3[i6] = unsignedByte3;
                        }
                    }
                    if (this.currentDtvCcPacket.currentIndex == (this.currentDtvCcPacket.packetSize * 2) - 1) {
                        finalizeCurrentPacket();
                    }
                }
            }
        }
    }

    private void finalizeCurrentPacket() {
        if (this.currentDtvCcPacket == null) {
            return;
        }
        processCurrentPacket();
        this.currentDtvCcPacket = null;
    }

    private void processCurrentPacket() {
        if (this.currentDtvCcPacket.currentIndex != (this.currentDtvCcPacket.packetSize * 2) - 1) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "DtvCcPacket ended prematurely; size is_renamed " + ((this.currentDtvCcPacket.packetSize * 2) - 1) + ", but current index is_renamed " + this.currentDtvCcPacket.currentIndex + " (sequence number " + this.currentDtvCcPacket.sequenceNumber + "); ignoring packet");
            return;
        }
        this.serviceBlockPacket.reset(this.currentDtvCcPacket.packetData, this.currentDtvCcPacket.currentIndex);
        int bits = this.serviceBlockPacket.readBits(3);
        int bits2 = this.serviceBlockPacket.readBits(5);
        if (bits == 7) {
            this.serviceBlockPacket.skipBits(2);
            bits = this.serviceBlockPacket.readBits(6);
            if (bits < 7) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Invalid extended service number: " + bits);
            }
        }
        if (bits2 == 0) {
            if (bits != 0) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "serviceNumber is_renamed non-zero (" + bits + ") when blockSize is_renamed 0");
                return;
            }
            return;
        }
        if (bits != this.selectedServiceNumber) {
            return;
        }
        boolean z_renamed = false;
        while (this.serviceBlockPacket.bitsLeft() > 0) {
            int bits3 = this.serviceBlockPacket.readBits(8);
            if (bits3 == 16) {
                int bits4 = this.serviceBlockPacket.readBits(8);
                if (bits4 <= 31) {
                    handleC2Command(bits4);
                } else {
                    if (bits4 <= 127) {
                        handleG2Character(bits4);
                    } else if (bits4 <= 159) {
                        handleC3Command(bits4);
                    } else if (bits4 <= 255) {
                        handleG3Character(bits4);
                    } else {
                        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Invalid extended command: " + bits4);
                    }
                    z_renamed = true;
                }
            } else if (bits3 <= 31) {
                handleC0Command(bits3);
            } else {
                if (bits3 <= 127) {
                    handleG0Character(bits3);
                } else if (bits3 <= 159) {
                    handleC1Command(bits3);
                } else if (bits3 <= 255) {
                    handleG1Character(bits3);
                } else {
                    com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Invalid base command: " + bits3);
                }
                z_renamed = true;
            }
        }
        if (z_renamed) {
            this.cues = getDisplayCues();
        }
    }

    private void handleC0Command(int i_renamed) {
        if (i_renamed != 0) {
            if (i_renamed == 3) {
                this.cues = getDisplayCues();
            }
            if (i_renamed == 8) {
                this.currentCueBuilder.backspace();
                return;
            }
            switch (i_renamed) {
                case 12:
                    resetCueBuilders();
                    break;
                case 13:
                    this.currentCueBuilder.append('\n_renamed');
                    break;
                case 14:
                    break;
                default:
                    if (i_renamed >= 17 && i_renamed <= 23) {
                        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Currently unsupported COMMAND_EXT1 Command: " + i_renamed);
                        this.serviceBlockPacket.skipBits(8);
                        break;
                    } else if (i_renamed >= 24 && i_renamed <= 31) {
                        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Currently unsupported COMMAND_P16 Command: " + i_renamed);
                        this.serviceBlockPacket.skipBits(16);
                        break;
                    } else {
                        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Invalid C0 command: " + i_renamed);
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    private void handleC1Command(int i_renamed) {
        int i2 = 1;
        switch (i_renamed) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i3 = i_renamed - 128;
                if (this.currentWindow != i3) {
                    this.currentWindow = i3;
                    this.currentCueBuilder = this.cueBuilders[i3];
                    break;
                }
                break;
            case 136:
                while (i2 <= 8) {
                    if (this.serviceBlockPacket.readBit()) {
                        this.cueBuilders[8 - i2].clear();
                    }
                    i2++;
                }
                break;
            case 137:
                for (int i4 = 1; i4 <= 8; i4++) {
                    if (this.serviceBlockPacket.readBit()) {
                        this.cueBuilders[8 - i4].setVisibility(true);
                    }
                }
                break;
            case 138:
                while (i2 <= 8) {
                    if (this.serviceBlockPacket.readBit()) {
                        this.cueBuilders[8 - i2].setVisibility(false);
                    }
                    i2++;
                }
                break;
            case 139:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.serviceBlockPacket.readBit()) {
                        this.cueBuilders[8 - i5].setVisibility(!r0.isVisible());
                    }
                }
                break;
            case 140:
                while (i2 <= 8) {
                    if (this.serviceBlockPacket.readBit()) {
                        this.cueBuilders[8 - i2].reset();
                    }
                    i2++;
                }
                break;
            case 141:
                this.serviceBlockPacket.skipBits(8);
                break;
            case 142:
                break;
            case 143:
                resetCueBuilders();
                break;
            case 144:
                if (!this.currentCueBuilder.isDefined()) {
                    this.serviceBlockPacket.skipBits(16);
                    break;
                } else {
                    handleSetPenAttributes();
                    break;
                }
            case 145:
                if (!this.currentCueBuilder.isDefined()) {
                    this.serviceBlockPacket.skipBits(24);
                    break;
                } else {
                    handleSetPenColor();
                    break;
                }
            case 146:
                if (!this.currentCueBuilder.isDefined()) {
                    this.serviceBlockPacket.skipBits(16);
                    break;
                } else {
                    handleSetPenLocation();
                    break;
                }
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Invalid C1 command: " + i_renamed);
                break;
            case 151:
                if (!this.currentCueBuilder.isDefined()) {
                    this.serviceBlockPacket.skipBits(32);
                    break;
                } else {
                    handleSetWindowAttributes();
                    break;
                }
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i6 = i_renamed - 152;
                handleDefineWindow(i6);
                if (this.currentWindow != i6) {
                    this.currentWindow = i6;
                    this.currentCueBuilder = this.cueBuilders[i6];
                    break;
                }
                break;
        }
    }

    private void handleC2Command(int i_renamed) {
        if (i_renamed <= 7) {
            return;
        }
        if (i_renamed <= 15) {
            this.serviceBlockPacket.skipBits(8);
        } else if (i_renamed <= 23) {
            this.serviceBlockPacket.skipBits(16);
        } else if (i_renamed <= 31) {
            this.serviceBlockPacket.skipBits(24);
        }
    }

    private void handleC3Command(int i_renamed) {
        if (i_renamed <= 135) {
            this.serviceBlockPacket.skipBits(32);
            return;
        }
        if (i_renamed <= 143) {
            this.serviceBlockPacket.skipBits(40);
        } else if (i_renamed <= 159) {
            this.serviceBlockPacket.skipBits(2);
            this.serviceBlockPacket.skipBits(this.serviceBlockPacket.readBits(6) * 8);
        }
    }

    private void handleG0Character(int i_renamed) {
        if (i_renamed == 127) {
            this.currentCueBuilder.append((char) 9835);
        } else {
            this.currentCueBuilder.append((char) (i_renamed & 255));
        }
    }

    private void handleG1Character(int i_renamed) {
        this.currentCueBuilder.append((char) (i_renamed & 255));
    }

    private void handleG2Character(int i_renamed) {
        if (i_renamed == 32) {
            this.currentCueBuilder.append(' ');
            return;
        }
        if (i_renamed == 33) {
            this.currentCueBuilder.append((char) 160);
            return;
        }
        if (i_renamed == 37) {
            this.currentCueBuilder.append((char) 8230);
            return;
        }
        if (i_renamed == 42) {
            this.currentCueBuilder.append((char) 352);
            return;
        }
        if (i_renamed == 44) {
            this.currentCueBuilder.append((char) 338);
            return;
        }
        if (i_renamed == 63) {
            this.currentCueBuilder.append((char) 376);
            return;
        }
        if (i_renamed == 57) {
            this.currentCueBuilder.append((char) 8482);
            return;
        }
        if (i_renamed == 58) {
            this.currentCueBuilder.append((char) 353);
            return;
        }
        if (i_renamed == 60) {
            this.currentCueBuilder.append((char) 339);
            return;
        }
        if (i_renamed != 61) {
            switch (i_renamed) {
                case 48:
                    this.currentCueBuilder.append((char) 9608);
                    break;
                case 49:
                    this.currentCueBuilder.append((char) 8216);
                    break;
                case 50:
                    this.currentCueBuilder.append((char) 8217);
                    break;
                case 51:
                    this.currentCueBuilder.append((char) 8220);
                    break;
                case 52:
                    this.currentCueBuilder.append((char) 8221);
                    break;
                case 53:
                    this.currentCueBuilder.append((char) 8226);
                    break;
                default:
                    switch (i_renamed) {
                        case 118:
                            this.currentCueBuilder.append((char) 8539);
                            break;
                        case 119:
                            this.currentCueBuilder.append((char) 8540);
                            break;
                        case 120:
                            this.currentCueBuilder.append((char) 8541);
                            break;
                        case 121:
                            this.currentCueBuilder.append((char) 8542);
                            break;
                        case 122:
                            this.currentCueBuilder.append((char) 9474);
                            break;
                        case 123:
                            this.currentCueBuilder.append((char) 9488);
                            break;
                        case 124:
                            this.currentCueBuilder.append((char) 9492);
                            break;
                        case 125:
                            this.currentCueBuilder.append((char) 9472);
                            break;
                        case 126:
                            this.currentCueBuilder.append((char) 9496);
                            break;
                        case 127:
                            this.currentCueBuilder.append((char) 9484);
                            break;
                        default:
                            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Invalid G2 character: " + i_renamed);
                            break;
                    }
            }
            return;
        }
        this.currentCueBuilder.append((char) 8480);
    }

    private void handleG3Character(int i_renamed) {
        if (i_renamed == 160) {
            this.currentCueBuilder.append((char) 13252);
            return;
        }
        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Invalid G3 character: " + i_renamed);
        this.currentCueBuilder.append('_');
    }

    private void handleSetPenAttributes() {
        this.currentCueBuilder.setPenAttributes(this.serviceBlockPacket.readBits(4), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBit(), this.serviceBlockPacket.readBit(), this.serviceBlockPacket.readBits(3), this.serviceBlockPacket.readBits(3));
    }

    private void handleSetPenColor() {
        int argbColorFromCeaColor = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        int argbColorFromCeaColor2 = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        this.serviceBlockPacket.skipBits(2);
        this.currentCueBuilder.setPenColor(argbColorFromCeaColor, argbColorFromCeaColor2, com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2)));
    }

    private void handleSetPenLocation() {
        this.serviceBlockPacket.skipBits(4);
        int bits = this.serviceBlockPacket.readBits(4);
        this.serviceBlockPacket.skipBits(2);
        this.currentCueBuilder.setPenLocation(bits, this.serviceBlockPacket.readBits(6));
    }

    private void handleSetWindowAttributes() {
        int argbColorFromCeaColor = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        int bits = this.serviceBlockPacket.readBits(2);
        int argbColorFromCeaColor2 = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        if (this.serviceBlockPacket.readBit()) {
            bits |= 4;
        }
        boolean bit = this.serviceBlockPacket.readBit();
        int bits2 = this.serviceBlockPacket.readBits(2);
        int bits3 = this.serviceBlockPacket.readBits(2);
        int bits4 = this.serviceBlockPacket.readBits(2);
        this.serviceBlockPacket.skipBits(8);
        this.currentCueBuilder.setWindowAttributes(argbColorFromCeaColor, argbColorFromCeaColor2, bit, bits, bits2, bits3, bits4);
    }

    private void handleDefineWindow(int i_renamed) {
        com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder cueBuilder = this.cueBuilders[i_renamed];
        this.serviceBlockPacket.skipBits(2);
        boolean bit = this.serviceBlockPacket.readBit();
        boolean bit2 = this.serviceBlockPacket.readBit();
        boolean bit3 = this.serviceBlockPacket.readBit();
        int bits = this.serviceBlockPacket.readBits(3);
        boolean bit4 = this.serviceBlockPacket.readBit();
        int bits2 = this.serviceBlockPacket.readBits(7);
        int bits3 = this.serviceBlockPacket.readBits(8);
        int bits4 = this.serviceBlockPacket.readBits(4);
        int bits5 = this.serviceBlockPacket.readBits(4);
        this.serviceBlockPacket.skipBits(2);
        int bits6 = this.serviceBlockPacket.readBits(6);
        this.serviceBlockPacket.skipBits(2);
        cueBuilder.defineWindow(bit, bit2, bit3, bits, bit4, bits2, bits3, bits5, bits6, bits4, this.serviceBlockPacket.readBits(3), this.serviceBlockPacket.readBits(3));
    }

    private java.util.List<com.google.android.exoplayer2.text.Cue> getDisplayCues() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed < 8; i_renamed++) {
            if (!this.cueBuilders[i_renamed].isEmpty() && this.cueBuilders[i_renamed].isVisible()) {
                arrayList.add(this.cueBuilders[i_renamed].build());
            }
        }
        java.util.Collections.sort(arrayList);
        return java.util.Collections.unmodifiableList(arrayList);
    }

    private void resetCueBuilders() {
        for (int i_renamed = 0; i_renamed < 8; i_renamed++) {
            this.cueBuilders[i_renamed].reset();
        }
    }

    private static final class DtvCcPacket {
        int currentIndex = 0;
        public final byte[] packetData;
        public final int packetSize;
        public final int sequenceNumber;

        public DtvCcPacket(int i_renamed, int i2) {
            this.sequenceNumber = i_renamed;
            this.packetSize = i2;
            this.packetData = new byte[(i2 * 2) - 1];
        }
    }

    private static final class CueBuilder {
        private static final int BORDER_AND_EDGE_TYPE_NONE = 0;
        private static final int BORDER_AND_EDGE_TYPE_UNIFORM = 3;
        private static final int DEFAULT_PRIORITY = 4;
        private static final int DIRECTION_BOTTOM_TO_TOP = 3;
        private static final int DIRECTION_LEFT_TO_RIGHT = 0;
        private static final int DIRECTION_RIGHT_TO_LEFT = 1;
        private static final int DIRECTION_TOP_TO_BOTTOM = 2;
        private static final int HORIZONTAL_SIZE = 209;
        private static final int JUSTIFICATION_CENTER = 2;
        private static final int JUSTIFICATION_FULL = 3;
        private static final int JUSTIFICATION_LEFT = 0;
        private static final int JUSTIFICATION_RIGHT = 1;
        private static final int MAXIMUM_ROW_COUNT = 15;
        private static final int PEN_FONT_STYLE_DEFAULT = 0;
        private static final int PEN_FONT_STYLE_MONOSPACED_WITHOUT_SERIFS = 3;
        private static final int PEN_FONT_STYLE_MONOSPACED_WITH_SERIFS = 1;
        private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITHOUT_SERIFS = 4;
        private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITH_SERIFS = 2;
        private static final int PEN_OFFSET_NORMAL = 1;
        private static final int PEN_SIZE_STANDARD = 1;
        private static final int[] PEN_STYLE_BACKGROUND;
        private static final int[] PEN_STYLE_EDGE_TYPE;
        private static final int[] PEN_STYLE_FONT_STYLE;
        private static final int RELATIVE_CUE_SIZE = 99;
        private static final int VERTICAL_SIZE = 74;
        private static final int[] WINDOW_STYLE_FILL;
        private int anchorId;
        private int backgroundColor;
        private int backgroundColorStartPosition;
        private boolean defined;
        private int foregroundColor;
        private int foregroundColorStartPosition;
        private int horizontalAnchor;
        private int italicsStartPosition;
        private int justification;
        private int penStyleId;
        private int priority;
        private boolean relativePositioning;
        private int row;
        private int rowCount;
        private boolean rowLock;
        private int underlineStartPosition;
        private int verticalAnchor;
        private boolean visible;
        private int windowFillColor;
        private int windowStyleId;
        public static final int COLOR_SOLID_WHITE = getArgbColorFromCeaColor(2, 2, 2, 0);
        public static final int COLOR_SOLID_BLACK = getArgbColorFromCeaColor(0, 0, 0, 0);
        public static final int COLOR_TRANSPARENT = getArgbColorFromCeaColor(0, 0, 0, 3);
        private static final int[] WINDOW_STYLE_JUSTIFICATION = {0, 0, 0, 0, 0, 2, 0};
        private static final int[] WINDOW_STYLE_PRINT_DIRECTION = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] WINDOW_STYLE_SCROLL_DIRECTION = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] WINDOW_STYLE_WORD_WRAP = {false, false, false, true, true, true, false};
        private final java.util.List<android.text.SpannableString> rolledUpCaptions = new java.util.ArrayList();
        private final android.text.SpannableStringBuilder captionStringBuilder = new android.text.SpannableStringBuilder();

        static {
            int i_renamed = COLOR_SOLID_BLACK;
            int i2 = COLOR_TRANSPARENT;
            WINDOW_STYLE_FILL = new int[]{i_renamed, i2, i_renamed, i_renamed, i2, i_renamed, i_renamed};
            PEN_STYLE_FONT_STYLE = new int[]{0, 1, 2, 3, 4, 3, 4};
            PEN_STYLE_EDGE_TYPE = new int[]{0, 0, 0, 0, 0, 3, 3};
            PEN_STYLE_BACKGROUND = new int[]{i_renamed, i_renamed, i_renamed, i_renamed, i_renamed, i2, i2};
        }

        public CueBuilder() {
            reset();
        }

        public boolean isEmpty() {
            return !isDefined() || (this.rolledUpCaptions.isEmpty() && this.captionStringBuilder.length() == 0);
        }

        public void reset() {
            clear();
            this.defined = false;
            this.visible = false;
            this.priority = 4;
            this.relativePositioning = false;
            this.verticalAnchor = 0;
            this.horizontalAnchor = 0;
            this.anchorId = 0;
            this.rowCount = 15;
            this.rowLock = true;
            this.justification = 0;
            this.windowStyleId = 0;
            this.penStyleId = 0;
            int i_renamed = COLOR_SOLID_BLACK;
            this.windowFillColor = i_renamed;
            this.foregroundColor = COLOR_SOLID_WHITE;
            this.backgroundColor = i_renamed;
        }

        public void clear() {
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.clear();
            this.italicsStartPosition = -1;
            this.underlineStartPosition = -1;
            this.foregroundColorStartPosition = -1;
            this.backgroundColorStartPosition = -1;
            this.row = 0;
        }

        public boolean isDefined() {
            return this.defined;
        }

        public void setVisibility(boolean z_renamed) {
            this.visible = z_renamed;
        }

        public boolean isVisible() {
            return this.visible;
        }

        public void defineWindow(boolean z_renamed, boolean z2, boolean z3, int i_renamed, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.defined = true;
            this.visible = z_renamed;
            this.rowLock = z2;
            this.priority = i_renamed;
            this.relativePositioning = z4;
            this.verticalAnchor = i2;
            this.horizontalAnchor = i3;
            this.anchorId = i6;
            int i9 = i4 + 1;
            if (this.rowCount != i9) {
                this.rowCount = i9;
                while (true) {
                    if ((!z2 || this.rolledUpCaptions.size() < this.rowCount) && this.rolledUpCaptions.size() < 15) {
                        break;
                    } else {
                        this.rolledUpCaptions.remove(0);
                    }
                }
            }
            if (i7 != 0 && this.windowStyleId != i7) {
                this.windowStyleId = i7;
                int i10 = i7 - 1;
                setWindowAttributes(WINDOW_STYLE_FILL[i10], COLOR_TRANSPARENT, WINDOW_STYLE_WORD_WRAP[i10], 0, WINDOW_STYLE_PRINT_DIRECTION[i10], WINDOW_STYLE_SCROLL_DIRECTION[i10], WINDOW_STYLE_JUSTIFICATION[i10]);
            }
            if (i8 == 0 || this.penStyleId == i8) {
                return;
            }
            this.penStyleId = i8;
            int i11 = i8 - 1;
            setPenAttributes(0, 1, 1, false, false, PEN_STYLE_EDGE_TYPE[i11], PEN_STYLE_FONT_STYLE[i11]);
            setPenColor(COLOR_SOLID_WHITE, PEN_STYLE_BACKGROUND[i11], COLOR_SOLID_BLACK);
        }

        public void setWindowAttributes(int i_renamed, int i2, boolean z_renamed, int i3, int i4, int i5, int i6) {
            this.windowFillColor = i_renamed;
            this.justification = i6;
        }

        public void setPenAttributes(int i_renamed, int i2, int i3, boolean z_renamed, boolean z2, int i4, int i5) {
            if (this.italicsStartPosition != -1) {
                if (!z_renamed) {
                    this.captionStringBuilder.setSpan(new android.text.style.StyleSpan(2), this.italicsStartPosition, this.captionStringBuilder.length(), 33);
                    this.italicsStartPosition = -1;
                }
            } else if (z_renamed) {
                this.italicsStartPosition = this.captionStringBuilder.length();
            }
            if (this.underlineStartPosition == -1) {
                if (z2) {
                    this.underlineStartPosition = this.captionStringBuilder.length();
                }
            } else {
                if (z2) {
                    return;
                }
                this.captionStringBuilder.setSpan(new android.text.style.UnderlineSpan(), this.underlineStartPosition, this.captionStringBuilder.length(), 33);
                this.underlineStartPosition = -1;
            }
        }

        public void setPenColor(int i_renamed, int i2, int i3) {
            int i4;
            int i5;
            if (this.foregroundColorStartPosition != -1 && (i5 = this.foregroundColor) != i_renamed) {
                this.captionStringBuilder.setSpan(new android.text.style.ForegroundColorSpan(i5), this.foregroundColorStartPosition, this.captionStringBuilder.length(), 33);
            }
            if (i_renamed != COLOR_SOLID_WHITE) {
                this.foregroundColorStartPosition = this.captionStringBuilder.length();
                this.foregroundColor = i_renamed;
            }
            if (this.backgroundColorStartPosition != -1 && (i4 = this.backgroundColor) != i2) {
                this.captionStringBuilder.setSpan(new android.text.style.BackgroundColorSpan(i4), this.backgroundColorStartPosition, this.captionStringBuilder.length(), 33);
            }
            if (i2 != COLOR_SOLID_BLACK) {
                this.backgroundColorStartPosition = this.captionStringBuilder.length();
                this.backgroundColor = i2;
            }
        }

        public void setPenLocation(int i_renamed, int i2) {
            if (this.row != i_renamed) {
                append('\n_renamed');
            }
            this.row = i_renamed;
        }

        public void backspace() {
            int length = this.captionStringBuilder.length();
            if (length > 0) {
                this.captionStringBuilder.delete(length - 1, length);
            }
        }

        public void append(char c2) {
            if (c2 == '\n_renamed') {
                this.rolledUpCaptions.add(buildSpannableString());
                this.captionStringBuilder.clear();
                if (this.italicsStartPosition != -1) {
                    this.italicsStartPosition = 0;
                }
                if (this.underlineStartPosition != -1) {
                    this.underlineStartPosition = 0;
                }
                if (this.foregroundColorStartPosition != -1) {
                    this.foregroundColorStartPosition = 0;
                }
                if (this.backgroundColorStartPosition != -1) {
                    this.backgroundColorStartPosition = 0;
                }
                while (true) {
                    if ((!this.rowLock || this.rolledUpCaptions.size() < this.rowCount) && this.rolledUpCaptions.size() < 15) {
                        return;
                    } else {
                        this.rolledUpCaptions.remove(0);
                    }
                }
            } else {
                this.captionStringBuilder.append(c2);
            }
        }

        public android.text.SpannableString buildSpannableString() {
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder(this.captionStringBuilder);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.italicsStartPosition != -1) {
                    spannableStringBuilder.setSpan(new android.text.style.StyleSpan(2), this.italicsStartPosition, length, 33);
                }
                if (this.underlineStartPosition != -1) {
                    spannableStringBuilder.setSpan(new android.text.style.UnderlineSpan(), this.underlineStartPosition, length, 33);
                }
                if (this.foregroundColorStartPosition != -1) {
                    spannableStringBuilder.setSpan(new android.text.style.ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, length, 33);
                }
                if (this.backgroundColorStartPosition != -1) {
                    spannableStringBuilder.setSpan(new android.text.style.BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, length, 33);
                }
            }
            return new android.text.SpannableString(spannableStringBuilder);
        }

        public com.google.android.exoplayer2.text.cea.Cea708Cue build() {
            android.text.Layout.Alignment alignment;
            float f_renamed;
            float f2;
            int i_renamed;
            int i2;
            if (isEmpty()) {
                return null;
            }
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
            for (int i3 = 0; i3 < this.rolledUpCaptions.size(); i3++) {
                spannableStringBuilder.append((java.lang.CharSequence) this.rolledUpCaptions.get(i3));
                spannableStringBuilder.append('\n_renamed');
            }
            spannableStringBuilder.append((java.lang.CharSequence) buildSpannableString());
            int i4 = this.justification;
            if (i4 == 0) {
                alignment = android.text.Layout.Alignment.ALIGN_NORMAL;
            } else if (i4 == 1) {
                alignment = android.text.Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i4 != 2) {
                if (i4 != 3) {
                    throw new java.lang.IllegalArgumentException("Unexpected justification value: " + this.justification);
                }
                alignment = android.text.Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = android.text.Layout.Alignment.ALIGN_CENTER;
            }
            if (this.relativePositioning) {
                f_renamed = this.horizontalAnchor / 99.0f;
                f2 = this.verticalAnchor / 99.0f;
            } else {
                f_renamed = this.horizontalAnchor / 209.0f;
                f2 = this.verticalAnchor / 74.0f;
            }
            float f3 = (f_renamed * 0.9f) + 0.05f;
            float f4 = (f2 * 0.9f) + 0.05f;
            int i5 = this.anchorId;
            if (i5 % 3 == 0) {
                i_renamed = 0;
            } else {
                i_renamed = i5 % 3 == 1 ? 1 : 2;
            }
            int i6 = this.anchorId;
            if (i6 / 3 == 0) {
                i2 = 0;
            } else {
                i2 = i6 / 3 == 1 ? 1 : 2;
            }
            return new com.google.android.exoplayer2.text.cea.Cea708Cue(spannableStringBuilder, alignment, f4, 0, i_renamed, f3, i2, Float.MIN_VALUE, this.windowFillColor != COLOR_SOLID_BLACK, this.windowFillColor, this.priority);
        }

        public static int getArgbColorFromCeaColor(int i_renamed, int i2, int i3) {
            return getArgbColorFromCeaColor(i_renamed, i2, i3, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:9:0x001b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int getArgbColorFromCeaColor(int r4, int r5, int r6, int r7) {
            /*
                r0 = 4
                r1 = 0
                com.google.android.exoplayer2.util.Assertions.checkIndex(r4, r1, r0)
                com.google.android.exoplayer2.util.Assertions.checkIndex(r5, r1, r0)
                com.google.android.exoplayer2.util.Assertions.checkIndex(r6, r1, r0)
                com.google.android.exoplayer2.util.Assertions.checkIndex(r7, r1, r0)
                r0 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L1b
                if (r7 == r0) goto L1b
                r3 = 2
                if (r7 == r3) goto L1f
                r3 = 3
                if (r7 == r3) goto L1d
            L1b:
                r7 = r2
                goto L21
            L1d:
                r7 = r1
                goto L21
            L1f:
                r7 = 127(0x7f, float:1.78E-43)
            L21:
                if (r4 <= r0) goto L25
                r4 = r2
                goto L26
            L25:
                r4 = r1
            L26:
                if (r5 <= r0) goto L2a
                r5 = r2
                goto L2b
            L2a:
                r5 = r1
            L2b:
                if (r6 <= r0) goto L2e
                r1 = r2
            L2e:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r1)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.getArgbColorFromCeaColor(int, int, int, int):int");
        }
    }
}

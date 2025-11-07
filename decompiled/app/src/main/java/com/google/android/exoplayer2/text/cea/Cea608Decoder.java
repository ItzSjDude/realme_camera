package com.google.android.exoplayer2.text.cea;

/* loaded from: classes.dex */
public final class Cea608Decoder extends com.google.android.exoplayer2.text.cea.CeaDecoder {
    private static final int CC_FIELD_FLAG = 1;
    private static final byte CC_IMPLICIT_DATA_HEADER = -4;
    private static final int CC_MODE_PAINT_ON = 3;
    private static final int CC_MODE_POP_ON = 2;
    private static final int CC_MODE_ROLL_UP = 1;
    private static final int CC_MODE_UNKNOWN = 0;
    private static final int CC_TYPE_FLAG = 2;
    private static final int CC_VALID_608_ID = 4;
    private static final int CC_VALID_FLAG = 4;
    private static final byte CTRL_BACKSPACE = 33;
    private static final byte CTRL_CARRIAGE_RETURN = 45;
    private static final byte CTRL_DELETE_TO_END_OF_ROW = 36;
    private static final byte CTRL_END_OF_CAPTION = 47;
    private static final byte CTRL_ERASE_DISPLAYED_MEMORY = 44;
    private static final byte CTRL_ERASE_NON_DISPLAYED_MEMORY = 46;
    private static final byte CTRL_RESUME_CAPTION_LOADING = 32;
    private static final byte CTRL_RESUME_DIRECT_CAPTIONING = 41;
    private static final byte CTRL_ROLL_UP_CAPTIONS_2_ROWS = 37;
    private static final byte CTRL_ROLL_UP_CAPTIONS_3_ROWS = 38;
    private static final byte CTRL_ROLL_UP_CAPTIONS_4_ROWS = 39;
    private static final int DEFAULT_CAPTIONS_ROW_COUNT = 4;
    private static final int NTSC_CC_FIELD_1 = 0;
    private static final int NTSC_CC_FIELD_2 = 1;
    private static final int STYLE_ITALICS = 7;
    private static final int STYLE_UNCHANGED = 8;
    private int captionMode;
    private int captionRowCount;
    private java.util.List<com.google.android.exoplayer2.text.Cue> cues;
    private java.util.List<com.google.android.exoplayer2.text.Cue> lastCues;
    private final int packetLength;
    private byte repeatableControlCc1;
    private byte repeatableControlCc2;
    private boolean repeatableControlSet;
    private final int selectedField;
    private static final int[] ROW_INDICES = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] COLUMN_INDICES = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] STYLE_COLORS = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] BASIC_CHARACTER_SET = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] SPECIAL_CHARACTER_SET = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] SPECIAL_ES_FR_CHARACTER_SET = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] SPECIAL_PT_DE_CHARACTER_SET = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private final com.google.android.exoplayer2.util.ParsableByteArray ccData = new com.google.android.exoplayer2.util.ParsableByteArray();
    private final java.util.ArrayList<com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder> cueBuilders = new java.util.ArrayList<>();
    private com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder currentCueBuilder = new com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder(0, 4);

    private static boolean isMidrowCtrlCode(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 32;
    }

    private static boolean isMiscCode(byte b2, byte b3) {
        return (b2 & 247) == 20 && (b3 & 240) == 32;
    }

    private static boolean isPreambleAddressCode(byte b2, byte b3) {
        return (b2 & 240) == 16 && (b3 & 192) == 64;
    }

    private static boolean isRepeatable(byte b2) {
        return (b2 & 240) == 16;
    }

    private static boolean isTabCtrlCode(byte b2, byte b3) {
        return (b2 & 247) == 23 && b3 >= 33 && b3 <= 35;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public java.lang.String getName() {
        return "Cea608Decoder";
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() {
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

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j_renamed) {
        super.setPositionUs(j_renamed);
    }

    public Cea608Decoder(java.lang.String str, int i_renamed) {
        this.packetLength = com.google.android.exoplayer2.util.MimeTypes.APPLICATION_MP4CEA608.equals(str) ? 2 : 3;
        if (i_renamed == 3 || i_renamed == 4) {
            this.selectedField = 2;
        } else {
            this.selectedField = 1;
        }
        setCaptionMode(0);
        resetCueBuilders();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        setCaptionMode(0);
        setCaptionRowCount(4);
        resetCueBuilders();
        this.repeatableControlSet = false;
        this.repeatableControlCc1 = (byte) 0;
        this.repeatableControlCc2 = (byte) 0;
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
        boolean z_renamed = false;
        boolean zHandleCtrl = false;
        while (true) {
            int iBytesLeft = this.ccData.bytesLeft();
            int i_renamed = this.packetLength;
            if (iBytesLeft < i_renamed) {
                break;
            }
            byte unsignedByte = i_renamed == 2 ? CC_IMPLICIT_DATA_HEADER : (byte) this.ccData.readUnsignedByte();
            byte unsignedByte2 = (byte) (this.ccData.readUnsignedByte() & 127);
            byte unsignedByte3 = (byte) (this.ccData.readUnsignedByte() & 127);
            if ((unsignedByte & 6) == 4 && (this.selectedField != 1 || (unsignedByte & 1) == 0)) {
                if (this.selectedField != 2 || (unsignedByte & 1) == 1) {
                    if (unsignedByte2 != 0 || unsignedByte3 != 0) {
                        if ((unsignedByte2 & 247) == 17 && (unsignedByte3 & 240) == 48) {
                            this.currentCueBuilder.append(getSpecialChar(unsignedByte3));
                        } else if ((unsignedByte2 & 246) == 18 && (unsignedByte3 & 224) == 32) {
                            this.currentCueBuilder.backspace();
                            if ((unsignedByte2 & 1) == 0) {
                                this.currentCueBuilder.append(getExtendedEsFrChar(unsignedByte3));
                            } else {
                                this.currentCueBuilder.append(getExtendedPtDeChar(unsignedByte3));
                            }
                        } else if ((unsignedByte2 & 224) == 0) {
                            zHandleCtrl = handleCtrl(unsignedByte2, unsignedByte3);
                        } else {
                            this.currentCueBuilder.append(getChar(unsignedByte2));
                            if ((unsignedByte3 & 224) != 0) {
                                this.currentCueBuilder.append(getChar(unsignedByte3));
                            }
                        }
                        z_renamed = true;
                    }
                }
            }
        }
        if (z_renamed) {
            if (!zHandleCtrl) {
                this.repeatableControlSet = false;
            }
            int i2 = this.captionMode;
            if (i2 == 1 || i2 == 3) {
                this.cues = getDisplayCues();
            }
        }
    }

    private boolean handleCtrl(byte b2, byte b3) {
        boolean zIsRepeatable = isRepeatable(b2);
        if (zIsRepeatable) {
            if (this.repeatableControlSet && this.repeatableControlCc1 == b2 && this.repeatableControlCc2 == b3) {
                this.repeatableControlSet = false;
                return true;
            }
            this.repeatableControlSet = true;
            this.repeatableControlCc1 = b2;
            this.repeatableControlCc2 = b3;
        }
        if (isMidrowCtrlCode(b2, b3)) {
            handleMidrowCtrl(b3);
        } else if (isPreambleAddressCode(b2, b3)) {
            handlePreambleAddressCode(b2, b3);
        } else if (isTabCtrlCode(b2, b3)) {
            this.currentCueBuilder.setTab(b3 - 32);
        } else if (isMiscCode(b2, b3)) {
            handleMiscCode(b3);
        }
        return zIsRepeatable;
    }

    private void handleMidrowCtrl(byte b2) {
        this.currentCueBuilder.append(' ');
        this.currentCueBuilder.setStyle((b2 >> 1) & 7, (b2 & 1) == 1);
    }

    private void handlePreambleAddressCode(byte b2, byte b3) {
        int i_renamed = ROW_INDICES[b2 & 7];
        if ((b3 & CTRL_RESUME_CAPTION_LOADING) != 0) {
            i_renamed++;
        }
        if (i_renamed != this.currentCueBuilder.getRow()) {
            if (this.captionMode != 1 && !this.currentCueBuilder.isEmpty()) {
                this.currentCueBuilder = new com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder(this.captionMode, this.captionRowCount);
                this.cueBuilders.add(this.currentCueBuilder);
            }
            this.currentCueBuilder.setRow(i_renamed);
        }
        boolean z_renamed = (b3 & 16) == 16;
        boolean z2 = (b3 & 1) == 1;
        int i2 = (b3 >> 1) & 7;
        this.currentCueBuilder.setStyle(z_renamed ? 8 : i2, z2);
        if (z_renamed) {
            this.currentCueBuilder.setIndent(COLUMN_INDICES[i2]);
        }
    }

    private void handleMiscCode(byte b2) {
        if (b2 == 32) {
            setCaptionMode(2);
            return;
        }
        if (b2 != 41) {
            switch (b2) {
                case 37:
                    setCaptionMode(1);
                    setCaptionRowCount(2);
                    break;
                case 38:
                    setCaptionMode(1);
                    setCaptionRowCount(3);
                    break;
                case 39:
                    setCaptionMode(1);
                    setCaptionRowCount(4);
                    break;
                default:
                    int i_renamed = this.captionMode;
                    if (i_renamed != 0) {
                        if (b2 == 33) {
                            this.currentCueBuilder.backspace();
                            break;
                        } else if (b2 != 36) {
                            switch (b2) {
                                case 44:
                                    this.cues = java.util.Collections.emptyList();
                                    int i2 = this.captionMode;
                                    if (i2 == 1 || i2 == 3) {
                                        resetCueBuilders();
                                        break;
                                    }
                                case 45:
                                    if (i_renamed == 1 && !this.currentCueBuilder.isEmpty()) {
                                        this.currentCueBuilder.rollUp();
                                        break;
                                    }
                                    break;
                                case 46:
                                    resetCueBuilders();
                                    break;
                                case 47:
                                    this.cues = getDisplayCues();
                                    resetCueBuilders();
                                    break;
                            }
                        }
                    }
                    break;
            }
            return;
        }
        setCaptionMode(3);
    }

    private java.util.List<com.google.android.exoplayer2.text.Cue> getDisplayCues() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed < this.cueBuilders.size(); i_renamed++) {
            com.google.android.exoplayer2.text.Cue cueBuild = this.cueBuilders.get(i_renamed).build();
            if (cueBuild != null) {
                arrayList.add(cueBuild);
            }
        }
        return arrayList;
    }

    private void setCaptionMode(int i_renamed) {
        int i2 = this.captionMode;
        if (i2 == i_renamed) {
            return;
        }
        this.captionMode = i_renamed;
        resetCueBuilders();
        if (i2 == 3 || i_renamed == 1 || i_renamed == 0) {
            this.cues = java.util.Collections.emptyList();
        }
    }

    private void setCaptionRowCount(int i_renamed) {
        this.captionRowCount = i_renamed;
        this.currentCueBuilder.setCaptionRowCount(i_renamed);
    }

    private void resetCueBuilders() {
        this.currentCueBuilder.reset(this.captionMode);
        this.cueBuilders.clear();
        this.cueBuilders.add(this.currentCueBuilder);
    }

    private static char getChar(byte b2) {
        return (char) BASIC_CHARACTER_SET[(b2 & 127) - 32];
    }

    private static char getSpecialChar(byte b2) {
        return (char) SPECIAL_CHARACTER_SET[b2 & 15];
    }

    private static char getExtendedEsFrChar(byte b2) {
        return (char) SPECIAL_ES_FR_CHARACTER_SET[b2 & 31];
    }

    private static char getExtendedPtDeChar(byte b2) {
        return (char) SPECIAL_PT_DE_CHARACTER_SET[b2 & 31];
    }

    private static class CueBuilder {
        private static final int BASE_ROW = 15;
        private static final int SCREEN_CHARWIDTH = 32;
        private int captionMode;
        private int captionRowCount;
        private int indent;
        private int row;
        private int tabOffset;
        private final java.util.List<com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder.CueStyle> cueStyles = new java.util.ArrayList();
        private final java.util.List<android.text.SpannableString> rolledUpCaptions = new java.util.ArrayList();
        private final java.lang.StringBuilder captionStringBuilder = new java.lang.StringBuilder();

        public CueBuilder(int i_renamed, int i2) {
            reset(i_renamed);
            setCaptionRowCount(i2);
        }

        public void reset(int i_renamed) {
            this.captionMode = i_renamed;
            this.cueStyles.clear();
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.setLength(0);
            this.row = 15;
            this.indent = 0;
            this.tabOffset = 0;
        }

        public void setCaptionRowCount(int i_renamed) {
            this.captionRowCount = i_renamed;
        }

        public boolean isEmpty() {
            return this.cueStyles.isEmpty() && this.rolledUpCaptions.isEmpty() && this.captionStringBuilder.length() == 0;
        }

        public void backspace() {
            int length = this.captionStringBuilder.length();
            if (length > 0) {
                this.captionStringBuilder.delete(length - 1, length);
                for (int size = this.cueStyles.size() - 1; size >= 0; size--) {
                    if (this.cueStyles.get(size).start != length) {
                        return;
                    }
                    r2.start--;
                }
            }
        }

        public int getRow() {
            return this.row;
        }

        public void setRow(int i_renamed) {
            this.row = i_renamed;
        }

        public void rollUp() {
            this.rolledUpCaptions.add(buildSpannableString());
            this.captionStringBuilder.setLength(0);
            this.cueStyles.clear();
            int iMin = java.lang.Math.min(this.captionRowCount, this.row);
            while (this.rolledUpCaptions.size() >= iMin) {
                this.rolledUpCaptions.remove(0);
            }
        }

        public void setIndent(int i_renamed) {
            this.indent = i_renamed;
        }

        public void setTab(int i_renamed) {
            this.tabOffset = i_renamed;
        }

        public void setStyle(int i_renamed, boolean z_renamed) {
            this.cueStyles.add(new com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder.CueStyle(i_renamed, z_renamed, this.captionStringBuilder.length()));
        }

        public void append(char c2) {
            this.captionStringBuilder.append(c2);
        }

        public android.text.SpannableString buildSpannableString() {
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder(this.captionStringBuilder);
            int length = spannableStringBuilder.length();
            int i_renamed = 0;
            int i2 = 0;
            boolean z_renamed = false;
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            while (i_renamed < this.cueStyles.size()) {
                com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder.CueStyle cueStyle = this.cueStyles.get(i_renamed);
                boolean z2 = cueStyle.underline;
                int i7 = cueStyle.style;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i6 = com.google.android.exoplayer2.text.cea.Cea608Decoder.STYLE_COLORS[i7];
                    }
                    z_renamed = z3;
                }
                int i8 = cueStyle.start;
                i_renamed++;
                if (i8 != (i_renamed < this.cueStyles.size() ? this.cueStyles.get(i_renamed).start : length)) {
                    if (i3 != -1 && !z2) {
                        setUnderlineSpan(spannableStringBuilder, i3, i8);
                        i3 = -1;
                    } else if (i3 == -1 && z2) {
                        i3 = i8;
                    }
                    if (i4 != -1 && !z_renamed) {
                        setItalicSpan(spannableStringBuilder, i4, i8);
                        i4 = -1;
                    } else if (i4 == -1 && z_renamed) {
                        i4 = i8;
                    }
                    if (i6 != i5) {
                        setColorSpan(spannableStringBuilder, i2, i8, i5);
                        i5 = i6;
                        i2 = i8;
                    }
                }
            }
            if (i3 != -1 && i3 != length) {
                setUnderlineSpan(spannableStringBuilder, i3, length);
            }
            if (i4 != -1 && i4 != length) {
                setItalicSpan(spannableStringBuilder, i4, length);
            }
            if (i2 != length) {
                setColorSpan(spannableStringBuilder, i2, length, i5);
            }
            return new android.text.SpannableString(spannableStringBuilder);
        }

        public com.google.android.exoplayer2.text.Cue build() {
            int i_renamed;
            float f_renamed;
            int i2;
            int i3;
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
            for (int i4 = 0; i4 < this.rolledUpCaptions.size(); i4++) {
                spannableStringBuilder.append((java.lang.CharSequence) this.rolledUpCaptions.get(i4));
                spannableStringBuilder.append('\n_renamed');
            }
            spannableStringBuilder.append((java.lang.CharSequence) buildSpannableString());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i5 = this.indent + this.tabOffset;
            int length = (32 - i5) - spannableStringBuilder.length();
            int i6 = i5 - length;
            if (this.captionMode == 2 && (java.lang.Math.abs(i6) < 3 || length < 0)) {
                f_renamed = 0.5f;
                i_renamed = 1;
            } else if (this.captionMode != 2 || i6 <= 0) {
                i_renamed = 0;
                f_renamed = ((i5 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f_renamed = (((32 - length) / 32.0f) * 0.8f) + 0.1f;
                i_renamed = 2;
            }
            if (this.captionMode == 1 || (i2 = this.row) > 7) {
                i2 = (this.row - 15) - 2;
                i3 = 2;
            } else {
                i3 = 0;
            }
            return new com.google.android.exoplayer2.text.Cue(spannableStringBuilder, android.text.Layout.Alignment.ALIGN_NORMAL, i2, 1, i3, f_renamed, i_renamed, Float.MIN_VALUE);
        }

        public java.lang.String toString() {
            return this.captionStringBuilder.toString();
        }

        private static void setUnderlineSpan(android.text.SpannableStringBuilder spannableStringBuilder, int i_renamed, int i2) {
            spannableStringBuilder.setSpan(new android.text.style.UnderlineSpan(), i_renamed, i2, 33);
        }

        private static void setItalicSpan(android.text.SpannableStringBuilder spannableStringBuilder, int i_renamed, int i2) {
            spannableStringBuilder.setSpan(new android.text.style.StyleSpan(2), i_renamed, i2, 33);
        }

        private static void setColorSpan(android.text.SpannableStringBuilder spannableStringBuilder, int i_renamed, int i2, int i3) {
            if (i3 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new android.text.style.ForegroundColorSpan(i3), i_renamed, i2, 33);
        }

        private static class CueStyle {
            public int start;
            public final int style;
            public final boolean underline;

            public CueStyle(int i_renamed, boolean z_renamed, int i2) {
                this.style = i_renamed;
                this.underline = z_renamed;
                this.start = i2;
            }
        }
    }
}

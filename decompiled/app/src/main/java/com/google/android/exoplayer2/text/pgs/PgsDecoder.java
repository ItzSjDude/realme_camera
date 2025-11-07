package com.google.android.exoplayer2.text.pgs;

/* loaded from: classes.dex */
public final class PgsDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    private static final byte INFLATE_HEADER = 120;
    private static final int SECTION_TYPE_BITMAP_PICTURE = 21;
    private static final int SECTION_TYPE_END = 128;
    private static final int SECTION_TYPE_IDENTIFIER = 22;
    private static final int SECTION_TYPE_PALETTE = 20;
    private final com.google.android.exoplayer2.util.ParsableByteArray buffer;
    private final com.google.android.exoplayer2.text.pgs.PgsDecoder.CueBuilder cueBuilder;
    private final com.google.android.exoplayer2.util.ParsableByteArray inflatedBuffer;
    private java.util.zip.Inflater inflater;

    public PgsDecoder() {
        super("PgsDecoder");
        this.buffer = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.inflatedBuffer = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.cueBuilder = new com.google.android.exoplayer2.text.pgs.PgsDecoder.CueBuilder();
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    protected com.google.android.exoplayer2.text.Subtitle decode(byte[] bArr, int i_renamed, boolean z_renamed) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        this.buffer.reset(bArr, i_renamed);
        maybeInflateData(this.buffer);
        this.cueBuilder.reset();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (this.buffer.bytesLeft() >= 3) {
            com.google.android.exoplayer2.text.Cue nextSection = readNextSection(this.buffer, this.cueBuilder);
            if (nextSection != null) {
                arrayList.add(nextSection);
            }
        }
        return new com.google.android.exoplayer2.text.pgs.PgsSubtitle(java.util.Collections.unmodifiableList(arrayList));
    }

    private void maybeInflateData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() <= 0 || parsableByteArray.peekUnsignedByte() != 120) {
            return;
        }
        if (this.inflater == null) {
            this.inflater = new java.util.zip.Inflater();
        }
        if (com.google.android.exoplayer2.util.Util.inflate(parsableByteArray, this.inflatedBuffer, this.inflater)) {
            parsableByteArray.reset(this.inflatedBuffer.data, this.inflatedBuffer.limit());
        }
    }

    private static com.google.android.exoplayer2.text.Cue readNextSection(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.text.pgs.PgsDecoder.CueBuilder cueBuilder) {
        int iLimit = parsableByteArray.limit();
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition() + unsignedShort;
        com.google.android.exoplayer2.text.Cue cueBuild = null;
        if (position > iLimit) {
            parsableByteArray.setPosition(iLimit);
            return null;
        }
        if (unsignedByte == 128) {
            cueBuild = cueBuilder.build();
            cueBuilder.reset();
        } else {
            switch (unsignedByte) {
                case 20:
                    cueBuilder.parsePaletteSection(parsableByteArray, unsignedShort);
                    break;
                case 21:
                    cueBuilder.parseBitmapSection(parsableByteArray, unsignedShort);
                    break;
                case 22:
                    cueBuilder.parseIdentifierSection(parsableByteArray, unsignedShort);
                    break;
            }
        }
        parsableByteArray.setPosition(position);
        return cueBuild;
    }

    private static final class CueBuilder {
        private int bitmapHeight;
        private int bitmapWidth;
        private int bitmapX;
        private int bitmapY;
        private boolean colorsSet;
        private int planeHeight;
        private int planeWidth;
        private final com.google.android.exoplayer2.util.ParsableByteArray bitmapData = new com.google.android.exoplayer2.util.ParsableByteArray();
        private final int[] colors = new int[256];

        /* JADX INFO: Access modifiers changed from: private */
        public void parsePaletteSection(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
            if (i_renamed % 5 != 2) {
                return;
            }
            parsableByteArray.skipBytes(2);
            java.util.Arrays.fill(this.colors, 0);
            int i2 = i_renamed / 5;
            int i3 = 0;
            while (i3 < i2) {
                int unsignedByte = parsableByteArray.readUnsignedByte();
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                int unsignedByte3 = parsableByteArray.readUnsignedByte();
                int unsignedByte4 = parsableByteArray.readUnsignedByte();
                int unsignedByte5 = parsableByteArray.readUnsignedByte();
                double d_renamed = unsignedByte2;
                double d2 = unsignedByte3 - 128;
                int i4 = (int) ((1.402d * d2) + d_renamed);
                int i5 = i3;
                double d3 = unsignedByte4 - 128;
                this.colors[unsignedByte] = com.google.android.exoplayer2.util.Util.constrainValue((int) (d_renamed + (d3 * 1.772d)), 0, 255) | (com.google.android.exoplayer2.util.Util.constrainValue((int) ((d_renamed - (0.34414d * d3)) - (d2 * 0.71414d)), 0, 255) << 8) | (unsignedByte5 << 24) | (com.google.android.exoplayer2.util.Util.constrainValue(i4, 0, 255) << 16);
                i3 = i5 + 1;
            }
            this.colorsSet = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void parseBitmapSection(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
            int unsignedInt24;
            if (i_renamed < 4) {
                return;
            }
            parsableByteArray.skipBytes(3);
            int i2 = i_renamed - 4;
            if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
                if (i2 < 7 || (unsignedInt24 = parsableByteArray.readUnsignedInt24()) < 4) {
                    return;
                }
                this.bitmapWidth = parsableByteArray.readUnsignedShort();
                this.bitmapHeight = parsableByteArray.readUnsignedShort();
                this.bitmapData.reset(unsignedInt24 - 4);
                i2 -= 7;
            }
            int position = this.bitmapData.getPosition();
            int iLimit = this.bitmapData.limit();
            if (position >= iLimit || i2 <= 0) {
                return;
            }
            int iMin = java.lang.Math.min(i2, iLimit - position);
            parsableByteArray.readBytes(this.bitmapData.data, position, iMin);
            this.bitmapData.setPosition(position + iMin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void parseIdentifierSection(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
            if (i_renamed < 19) {
                return;
            }
            this.planeWidth = parsableByteArray.readUnsignedShort();
            this.planeHeight = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(11);
            this.bitmapX = parsableByteArray.readUnsignedShort();
            this.bitmapY = parsableByteArray.readUnsignedShort();
        }

        public com.google.android.exoplayer2.text.Cue build() {
            int unsignedByte;
            if (this.planeWidth == 0 || this.planeHeight == 0 || this.bitmapWidth == 0 || this.bitmapHeight == 0 || this.bitmapData.limit() == 0 || this.bitmapData.getPosition() != this.bitmapData.limit() || !this.colorsSet) {
                return null;
            }
            this.bitmapData.setPosition(0);
            int[] iArr = new int[this.bitmapWidth * this.bitmapHeight];
            int i_renamed = 0;
            while (i_renamed < iArr.length) {
                int unsignedByte2 = this.bitmapData.readUnsignedByte();
                if (unsignedByte2 != 0) {
                    unsignedByte = i_renamed + 1;
                    iArr[i_renamed] = this.colors[unsignedByte2];
                } else {
                    int unsignedByte3 = this.bitmapData.readUnsignedByte();
                    if (unsignedByte3 != 0) {
                        unsignedByte = ((unsignedByte3 & 64) == 0 ? unsignedByte3 & 63 : ((unsignedByte3 & 63) << 8) | this.bitmapData.readUnsignedByte()) + i_renamed;
                        java.util.Arrays.fill(iArr, i_renamed, unsignedByte, (unsignedByte3 & 128) == 0 ? 0 : this.colors[this.bitmapData.readUnsignedByte()]);
                    }
                }
                i_renamed = unsignedByte;
            }
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(iArr, this.bitmapWidth, this.bitmapHeight, android.graphics.Bitmap.Config.ARGB_8888);
            float f_renamed = this.bitmapX;
            int i2 = this.planeWidth;
            float f2 = f_renamed / i2;
            float f3 = this.bitmapY;
            int i3 = this.planeHeight;
            return new com.google.android.exoplayer2.text.Cue(bitmapCreateBitmap, f2, 0, f3 / i3, 0, this.bitmapWidth / i2, this.bitmapHeight / i3);
        }

        public void reset() {
            this.planeWidth = 0;
            this.planeHeight = 0;
            this.bitmapX = 0;
            this.bitmapY = 0;
            this.bitmapWidth = 0;
            this.bitmapHeight = 0;
            this.bitmapData.reset(0);
            this.colorsSet = false;
        }
    }
}

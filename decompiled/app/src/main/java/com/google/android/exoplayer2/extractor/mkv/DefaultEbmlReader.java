package com.google.android.exoplayer2.extractor.mkv;

/* loaded from: classes.dex */
final class DefaultEbmlReader implements com.google.android.exoplayer2.extractor.mkv.EbmlReader {
    private static final int ELEMENT_STATE_READ_CONTENT = 2;
    private static final int ELEMENT_STATE_READ_CONTENT_SIZE = 1;
    private static final int ELEMENT_STATE_READ_ID = 0;
    private static final int MAX_ID_BYTES = 4;
    private static final int MAX_INTEGER_ELEMENT_SIZE_BYTES = 8;
    private static final int MAX_LENGTH_BYTES = 8;
    private static final int VALID_FLOAT32_ELEMENT_SIZE_BYTES = 4;
    private static final int VALID_FLOAT64_ELEMENT_SIZE_BYTES = 8;
    private long elementContentSize;
    private int elementId;
    private int elementState;
    private com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput output;
    private final byte[] scratch = new byte[8];
    private final java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader.MasterElement> masterElementsStack = new java.util.ArrayDeque<>();
    private final com.google.android.exoplayer2.extractor.mkv.VarintReader varintReader = new com.google.android.exoplayer2.extractor.mkv.VarintReader();

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public void init(com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput ebmlReaderOutput) {
        this.output = ebmlReaderOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public void reset() {
        this.elementState = 0;
        this.masterElementsStack.clear();
        this.varintReader.reset();
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public boolean read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkState(this.output != null);
        while (true) {
            if (this.masterElementsStack.isEmpty() || extractorInput.getPosition() < this.masterElementsStack.peek().elementEndPosition) {
                if (this.elementState == 0) {
                    long unsignedVarint = this.varintReader.readUnsignedVarint(extractorInput, true, false, 4);
                    if (unsignedVarint == -2) {
                        unsignedVarint = maybeResyncToNextLevel1Element(extractorInput);
                    }
                    if (unsignedVarint == -1) {
                        return false;
                    }
                    this.elementId = (int) unsignedVarint;
                    this.elementState = 1;
                }
                if (this.elementState == 1) {
                    this.elementContentSize = this.varintReader.readUnsignedVarint(extractorInput, false, true, 8);
                    this.elementState = 2;
                }
                int elementType = this.output.getElementType(this.elementId);
                if (elementType != 0) {
                    if (elementType == 1) {
                        long position = extractorInput.getPosition();
                        this.masterElementsStack.push(new com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader.MasterElement(this.elementId, this.elementContentSize + position));
                        this.output.startMasterElement(this.elementId, position, this.elementContentSize);
                        this.elementState = 0;
                        return true;
                    }
                    if (elementType == 2) {
                        long j_renamed = this.elementContentSize;
                        if (j_renamed > 8) {
                            throw new com.google.android.exoplayer2.ParserException("Invalid integer size: " + this.elementContentSize);
                        }
                        this.output.integerElement(this.elementId, readInteger(extractorInput, (int) j_renamed));
                        this.elementState = 0;
                        return true;
                    }
                    if (elementType == 3) {
                        long j2 = this.elementContentSize;
                        if (j2 > 2147483647L) {
                            throw new com.google.android.exoplayer2.ParserException("String element size: " + this.elementContentSize);
                        }
                        this.output.stringElement(this.elementId, readString(extractorInput, (int) j2));
                        this.elementState = 0;
                        return true;
                    }
                    if (elementType == 4) {
                        this.output.binaryElement(this.elementId, (int) this.elementContentSize, extractorInput);
                        this.elementState = 0;
                        return true;
                    }
                    if (elementType == 5) {
                        long j3 = this.elementContentSize;
                        if (j3 != 4 && j3 != 8) {
                            throw new com.google.android.exoplayer2.ParserException("Invalid float size: " + this.elementContentSize);
                        }
                        this.output.floatElement(this.elementId, readFloat(extractorInput, (int) this.elementContentSize));
                        this.elementState = 0;
                        return true;
                    }
                    throw new com.google.android.exoplayer2.ParserException("Invalid element type " + elementType);
                }
                extractorInput.skipFully((int) this.elementContentSize);
                this.elementState = 0;
            } else {
                this.output.endMasterElement(this.masterElementsStack.pop().elementId);
                return true;
            }
        }
    }

    private long maybeResyncToNextLevel1Element(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        extractorInput.resetPeekPosition();
        while (true) {
            extractorInput.peekFully(this.scratch, 0, 4);
            int unsignedVarintLength = com.google.android.exoplayer2.extractor.mkv.VarintReader.parseUnsignedVarintLength(this.scratch[0]);
            if (unsignedVarintLength != -1 && unsignedVarintLength <= 4) {
                int iAssembleVarint = (int) com.google.android.exoplayer2.extractor.mkv.VarintReader.assembleVarint(this.scratch, unsignedVarintLength, false);
                if (this.output.isLevel1Element(iAssembleVarint)) {
                    extractorInput.skipFully(unsignedVarintLength);
                    return iAssembleVarint;
                }
            }
            extractorInput.skipFully(1);
        }
    }

    private long readInteger(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        extractorInput.readFully(this.scratch, 0, i_renamed);
        long j_renamed = 0;
        for (int i2 = 0; i2 < i_renamed; i2++) {
            j_renamed = (j_renamed << 8) | (this.scratch[i2] & 255);
        }
        return j_renamed;
    }

    private double readFloat(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        long integer = readInteger(extractorInput, i_renamed);
        if (i_renamed == 4) {
            return java.lang.Float.intBitsToFloat((int) integer);
        }
        return java.lang.Double.longBitsToDouble(integer);
    }

    private java.lang.String readString(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        if (i_renamed == 0) {
            return "";
        }
        byte[] bArr = new byte[i_renamed];
        extractorInput.readFully(bArr, 0, i_renamed);
        while (i_renamed > 0 && bArr[i_renamed - 1] == 0) {
            i_renamed--;
        }
        return new java.lang.String(bArr, 0, i_renamed);
    }

    private static final class MasterElement {
        private final long elementEndPosition;
        private final int elementId;

        private MasterElement(int i_renamed, long j_renamed) {
            this.elementId = i_renamed;
            this.elementEndPosition = j_renamed;
        }
    }
}

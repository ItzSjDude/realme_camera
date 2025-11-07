package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* loaded from: classes.dex */
final class GeneralAppIdDecoder {
    private final BitArray information;
    private final CurrentParsingState current = new CurrentParsingState();
    private final StringBuilder buffer = new StringBuilder();

    GeneralAppIdDecoder(BitArray bitArray) {
        this.information = bitArray;
    }

    String decodeAllCodes(StringBuilder sb, int OplusGLSurfaceView_13) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            DecodedInformation decodedInformationDecodeGeneralPurposeField = decodeGeneralPurposeField(OplusGLSurfaceView_13, str);
            String fieldsInGeneralPurpose = FieldParser.parseFieldsInGeneralPurpose(decodedInformationDecodeGeneralPurposeField.getNewString());
            if (fieldsInGeneralPurpose != null) {
                sb.append(fieldsInGeneralPurpose);
            }
            String strValueOf = decodedInformationDecodeGeneralPurposeField.isRemaining() ? String.valueOf(decodedInformationDecodeGeneralPurposeField.getRemainingValue()) : null;
            if (OplusGLSurfaceView_13 != decodedInformationDecodeGeneralPurposeField.getNewPosition()) {
                OplusGLSurfaceView_13 = decodedInformationDecodeGeneralPurposeField.getNewPosition();
                str = strValueOf;
            } else {
                return sb.toString();
            }
        }
    }

    private boolean isStillNumeric(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 + 7 > this.information.getSize()) {
            return OplusGLSurfaceView_13 + 4 <= this.information.getSize();
        }
        int i2 = OplusGLSurfaceView_13;
        while (true) {
            int i3 = OplusGLSurfaceView_13 + 3;
            if (i2 < i3) {
                if (this.information.get(i2)) {
                    return true;
                }
                i2++;
            } else {
                return this.information.get(i3);
            }
        }
    }

    private DecodedNumeric decodeNumeric(int OplusGLSurfaceView_13) throws FormatException {
        int i2 = OplusGLSurfaceView_13 + 7;
        if (i2 > this.information.getSize()) {
            int iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(OplusGLSurfaceView_13, 4);
            if (iExtractNumericValueFromBitArray == 0) {
                return new DecodedNumeric(this.information.getSize(), 10, 10);
            }
            return new DecodedNumeric(this.information.getSize(), iExtractNumericValueFromBitArray - 1, 10);
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(OplusGLSurfaceView_13, 7) - 8;
        return new DecodedNumeric(i2, iExtractNumericValueFromBitArray2 / 11, iExtractNumericValueFromBitArray2 % 11);
    }

    int extractNumericValueFromBitArray(int OplusGLSurfaceView_13, int i2) {
        return extractNumericValueFromBitArray(this.information, OplusGLSurfaceView_13, i2);
    }

    static int extractNumericValueFromBitArray(BitArray bitArray, int OplusGLSurfaceView_13, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (bitArray.get(OplusGLSurfaceView_13 + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    DecodedInformation decodeGeneralPurposeField(int OplusGLSurfaceView_13, String str) throws FormatException {
        this.buffer.setLength(0);
        if (str != null) {
            this.buffer.append(str);
        }
        this.current.setPosition(OplusGLSurfaceView_13);
        DecodedInformation blocks = parseBlocks();
        if (blocks != null && blocks.isRemaining()) {
            return new DecodedInformation(this.current.getPosition(), this.buffer.toString(), blocks.getRemainingValue());
        }
        return new DecodedInformation(this.current.getPosition(), this.buffer.toString());
    }

    private DecodedInformation parseBlocks() throws FormatException {
        BlockParsedResult numericBlock;
        boolean zIsFinished;
        do {
            int position = this.current.getPosition();
            if (this.current.isAlpha()) {
                numericBlock = parseAlphaBlock();
                zIsFinished = numericBlock.isFinished();
            } else if (this.current.isIsoIec646()) {
                numericBlock = parseIsoIec646Block();
                zIsFinished = numericBlock.isFinished();
            } else {
                numericBlock = parseNumericBlock();
                zIsFinished = numericBlock.isFinished();
            }
            if (!(position != this.current.getPosition()) && !zIsFinished) {
                break;
            }
        } while (!zIsFinished);
        return numericBlock.getDecodedInformation();
    }

    private BlockParsedResult parseNumericBlock() throws FormatException {
        DecodedInformation decodedInformation;
        while (isStillNumeric(this.current.getPosition())) {
            DecodedNumeric decodedNumericDecodeNumeric = decodeNumeric(this.current.getPosition());
            this.current.setPosition(decodedNumericDecodeNumeric.getNewPosition());
            if (decodedNumericDecodeNumeric.isFirstDigitFNC1()) {
                if (decodedNumericDecodeNumeric.isSecondDigitFNC1()) {
                    decodedInformation = new DecodedInformation(this.current.getPosition(), this.buffer.toString());
                } else {
                    decodedInformation = new DecodedInformation(this.current.getPosition(), this.buffer.toString(), decodedNumericDecodeNumeric.getSecondDigit());
                }
                return new BlockParsedResult(decodedInformation, true);
            }
            this.buffer.append(decodedNumericDecodeNumeric.getFirstDigit());
            if (decodedNumericDecodeNumeric.isSecondDigitFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodedNumericDecodeNumeric.getSecondDigit());
        }
        if (isNumericToAlphaNumericLatch(this.current.getPosition())) {
            this.current.setAlpha();
            this.current.incrementPosition(4);
        }
        return new BlockParsedResult(false);
    }

    private BlockParsedResult parseIsoIec646Block() throws FormatException {
        while (isStillIsoIec646(this.current.getPosition())) {
            DecodedChar decodedCharDecodeIsoIec646 = decodeIsoIec646(this.current.getPosition());
            this.current.setPosition(decodedCharDecodeIsoIec646.getNewPosition());
            if (decodedCharDecodeIsoIec646.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodedCharDecodeIsoIec646.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
            this.current.incrementPosition(3);
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
            if (this.current.getPosition() + 5 < this.information.getSize()) {
                this.current.incrementPosition(5);
            } else {
                this.current.setPosition(this.information.getSize());
            }
            this.current.setAlpha();
        }
        return new BlockParsedResult(false);
    }

    private BlockParsedResult parseAlphaBlock() {
        while (isStillAlpha(this.current.getPosition())) {
            DecodedChar decodedCharDecodeAlphanumeric = decodeAlphanumeric(this.current.getPosition());
            this.current.setPosition(decodedCharDecodeAlphanumeric.getNewPosition());
            if (decodedCharDecodeAlphanumeric.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodedCharDecodeAlphanumeric.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
            this.current.incrementPosition(3);
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
            if (this.current.getPosition() + 5 < this.information.getSize()) {
                this.current.incrementPosition(5);
            } else {
                this.current.setPosition(this.information.getSize());
            }
            this.current.setIsoIec646();
        }
        return new BlockParsedResult(false);
    }

    private boolean isStillIsoIec646(int OplusGLSurfaceView_13) {
        int iExtractNumericValueFromBitArray;
        if (OplusGLSurfaceView_13 + 5 > this.information.getSize()) {
            return false;
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(OplusGLSurfaceView_13, 5);
        if (iExtractNumericValueFromBitArray2 >= 5 && iExtractNumericValueFromBitArray2 < 16) {
            return true;
        }
        if (OplusGLSurfaceView_13 + 7 > this.information.getSize()) {
            return false;
        }
        int iExtractNumericValueFromBitArray3 = extractNumericValueFromBitArray(OplusGLSurfaceView_13, 7);
        if (iExtractNumericValueFromBitArray3 < 64 || iExtractNumericValueFromBitArray3 >= 116) {
            return OplusGLSurfaceView_13 + 8 <= this.information.getSize() && (iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(OplusGLSurfaceView_13, 8)) >= 232 && iExtractNumericValueFromBitArray < 253;
        }
        return true;
    }

    private DecodedChar decodeIsoIec646(int OplusGLSurfaceView_13) throws FormatException {
        char c2;
        int iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(OplusGLSurfaceView_13, 5);
        if (iExtractNumericValueFromBitArray == 15) {
            return new DecodedChar(OplusGLSurfaceView_13 + 5, '$');
        }
        if (iExtractNumericValueFromBitArray >= 5 && iExtractNumericValueFromBitArray < 15) {
            return new DecodedChar(OplusGLSurfaceView_13 + 5, (char) ((iExtractNumericValueFromBitArray + 48) - 5));
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(OplusGLSurfaceView_13, 7);
        if (iExtractNumericValueFromBitArray2 >= 64 && iExtractNumericValueFromBitArray2 < 90) {
            return new DecodedChar(OplusGLSurfaceView_13 + 7, (char) (iExtractNumericValueFromBitArray2 + 1));
        }
        if (iExtractNumericValueFromBitArray2 >= 90 && iExtractNumericValueFromBitArray2 < 116) {
            return new DecodedChar(OplusGLSurfaceView_13 + 7, (char) (iExtractNumericValueFromBitArray2 + 7));
        }
        switch (extractNumericValueFromBitArray(OplusGLSurfaceView_13, 8)) {
            case 232:
                c2 = '!';
                break;
            case 233:
                c2 = '\"';
                break;
            case 234:
                c2 = '%';
                break;
            case 235:
                c2 = '&';
                break;
            case 236:
                c2 = '\'';
                break;
            case 237:
                c2 = '(';
                break;
            case 238:
                c2 = ')';
                break;
            case 239:
                c2 = '*';
                break;
            case 240:
                c2 = '+';
                break;
            case 241:
                c2 = ',';
                break;
            case 242:
                c2 = '-';
                break;
            case 243:
                c2 = '.';
                break;
            case 244:
                c2 = '/';
                break;
            case 245:
                c2 = ':';
                break;
            case 246:
                c2 = ';';
                break;
            case 247:
                c2 = '<';
                break;
            case 248:
                c2 = '=';
                break;
            case 249:
                c2 = '>';
                break;
            case 250:
                c2 = '?';
                break;
            case 251:
                c2 = '_';
                break;
            case 252:
                c2 = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new DecodedChar(OplusGLSurfaceView_13 + 8, c2);
    }

    private boolean isStillAlpha(int OplusGLSurfaceView_13) {
        int iExtractNumericValueFromBitArray;
        if (OplusGLSurfaceView_13 + 5 > this.information.getSize()) {
            return false;
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(OplusGLSurfaceView_13, 5);
        if (iExtractNumericValueFromBitArray2 < 5 || iExtractNumericValueFromBitArray2 >= 16) {
            return OplusGLSurfaceView_13 + 6 <= this.information.getSize() && (iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(OplusGLSurfaceView_13, 6)) >= 16 && iExtractNumericValueFromBitArray < 63;
        }
        return true;
    }

    private DecodedChar decodeAlphanumeric(int OplusGLSurfaceView_13) {
        char c2;
        int iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(OplusGLSurfaceView_13, 5);
        if (iExtractNumericValueFromBitArray == 15) {
            return new DecodedChar(OplusGLSurfaceView_13 + 5, '$');
        }
        if (iExtractNumericValueFromBitArray >= 5 && iExtractNumericValueFromBitArray < 15) {
            return new DecodedChar(OplusGLSurfaceView_13 + 5, (char) ((iExtractNumericValueFromBitArray + 48) - 5));
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(OplusGLSurfaceView_13, 6);
        if (iExtractNumericValueFromBitArray2 >= 32 && iExtractNumericValueFromBitArray2 < 58) {
            return new DecodedChar(OplusGLSurfaceView_13 + 6, (char) (iExtractNumericValueFromBitArray2 + 33));
        }
        switch (iExtractNumericValueFromBitArray2) {
            case 58:
                c2 = '*';
                break;
            case 59:
                c2 = ',';
                break;
            case 60:
                c2 = '-';
                break;
            case 61:
                c2 = '.';
                break;
            case 62:
                c2 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(iExtractNumericValueFromBitArray2)));
        }
        return new DecodedChar(OplusGLSurfaceView_13 + 6, c2);
    }

    private boolean isAlphaTo646ToAlphaLatch(int OplusGLSurfaceView_13) {
        int i2;
        if (OplusGLSurfaceView_13 + 1 > this.information.getSize()) {
            return false;
        }
        for (int i3 = 0; i3 < 5 && (i2 = i3 + OplusGLSurfaceView_13) < this.information.getSize(); i3++) {
            if (i3 == 2) {
                if (!this.information.get(OplusGLSurfaceView_13 + 2)) {
                    return false;
                }
            } else if (this.information.get(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphaOr646ToNumericLatch(int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 + 3;
        if (i2 > this.information.getSize()) {
            return false;
        }
        while (OplusGLSurfaceView_13 < i2) {
            if (this.information.get(OplusGLSurfaceView_13)) {
                return false;
            }
            OplusGLSurfaceView_13++;
        }
        return true;
    }

    private boolean isNumericToAlphaNumericLatch(int OplusGLSurfaceView_13) {
        int i2;
        if (OplusGLSurfaceView_13 + 1 > this.information.getSize()) {
            return false;
        }
        for (int i3 = 0; i3 < 4 && (i2 = i3 + OplusGLSurfaceView_13) < this.information.getSize(); i3++) {
            if (this.information.get(i2)) {
                return false;
            }
        }
        return true;
    }
}

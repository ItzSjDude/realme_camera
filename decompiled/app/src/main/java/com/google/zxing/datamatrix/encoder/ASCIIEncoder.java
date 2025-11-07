package com.google.zxing.datamatrix.encoder;

/* loaded from: classes.dex */
final class ASCIIEncoder implements com.google.zxing.datamatrix.encoder.Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 0;
    }

    ASCIIEncoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(com.google.zxing.datamatrix.encoder.EncoderContext encoderContext) {
        if (com.google.zxing.datamatrix.encoder.HighLevelEncoder.determineConsecutiveDigitCount(encoderContext.getMessage(), encoderContext.pos) >= 2) {
            encoderContext.writeCodeword(encodeASCIIDigits(encoderContext.getMessage().charAt(encoderContext.pos), encoderContext.getMessage().charAt(encoderContext.pos + 1)));
            encoderContext.pos += 2;
            return;
        }
        char currentChar = encoderContext.getCurrentChar();
        int iLookAheadTest = com.google.zxing.datamatrix.encoder.HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
        if (iLookAheadTest == getEncodingMode()) {
            if (com.google.zxing.datamatrix.encoder.HighLevelEncoder.isExtendedASCII(currentChar)) {
                encoderContext.writeCodeword((char) 235);
                encoderContext.writeCodeword((char) ((currentChar - 128) + 1));
                encoderContext.pos++;
                return;
            } else {
                encoderContext.writeCodeword((char) (currentChar + 1));
                encoderContext.pos++;
                return;
            }
        }
        if (iLookAheadTest == 1) {
            encoderContext.writeCodeword((char) 230);
            encoderContext.signalEncoderChange(1);
            return;
        }
        if (iLookAheadTest == 2) {
            encoderContext.writeCodeword((char) 239);
            encoderContext.signalEncoderChange(2);
            return;
        }
        if (iLookAheadTest == 3) {
            encoderContext.writeCodeword((char) 238);
            encoderContext.signalEncoderChange(3);
        } else if (iLookAheadTest == 4) {
            encoderContext.writeCodeword((char) 240);
            encoderContext.signalEncoderChange(4);
        } else {
            if (iLookAheadTest == 5) {
                encoderContext.writeCodeword((char) 231);
                encoderContext.signalEncoderChange(5);
                return;
            }
            throw new java.lang.IllegalStateException("Illegal mode: ".concat(java.lang.String.valueOf(iLookAheadTest)));
        }
    }

    private static char encodeASCIIDigits(char c2, char c3) {
        if (com.google.zxing.datamatrix.encoder.HighLevelEncoder.isDigit(c2) && com.google.zxing.datamatrix.encoder.HighLevelEncoder.isDigit(c3)) {
            return (char) (((c2 - '0') * 10) + (c3 - '0') + 130);
        }
        throw new java.lang.IllegalArgumentException("not digits: " + c2 + c3);
    }
}

package com.google.zxing.datamatrix.encoder;

/* loaded from: classes.dex */
final class Base256Encoder implements com.google.zxing.datamatrix.encoder.Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 5;
    }

    Base256Encoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(com.google.zxing.datamatrix.encoder.EncoderContext encoderContext) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            sb.append(encoderContext.getCurrentChar());
            encoderContext.pos++;
            if (com.google.zxing.datamatrix.encoder.HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                encoderContext.signalEncoderChange(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int codewordCount = encoderContext.getCodewordCount() + length + 1;
        encoderContext.updateSymbolInfo(codewordCount);
        boolean z_renamed = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount > 0;
        if (encoderContext.hasMoreCharacters() || z_renamed) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            } else {
                throw new java.lang.IllegalStateException("Message length not in_renamed valid ranges: ".concat(java.lang.String.valueOf(length)));
            }
        }
        int length2 = sb.length();
        for (int i_renamed = 0; i_renamed < length2; i_renamed++) {
            encoderContext.writeCodeword(randomize255State(sb.charAt(i_renamed), encoderContext.getCodewordCount() + 1));
        }
    }

    private static char randomize255State(char c2, int i_renamed) {
        int i2 = c2 + ((i_renamed * 149) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 - 256);
    }
}

package com.google.zxing.datamatrix.encoder;

/* loaded from: classes.dex */
final class EdifactEncoder implements com.google.zxing.datamatrix.encoder.Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 4;
    }

    EdifactEncoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(com.google.zxing.datamatrix.encoder.EncoderContext encoderContext) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            encodeChar(encoderContext.getCurrentChar(), sb);
            encoderContext.pos++;
            if (sb.length() >= 4) {
                encoderContext.writeCodewords(encodeToCodewords(sb, 0));
                sb.delete(0, 4);
                if (com.google.zxing.datamatrix.encoder.HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                    encoderContext.signalEncoderChange(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        handleEOD(encoderContext, sb);
    }

    private static void handleEOD(com.google.zxing.datamatrix.encoder.EncoderContext encoderContext, java.lang.CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z_renamed = true;
            if (length == 1) {
                encoderContext.updateSymbolInfo();
                int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                int remainingCharacters = encoderContext.getRemainingCharacters();
                if (remainingCharacters > dataCapacity) {
                    encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + 1);
                    dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                }
                if (remainingCharacters <= dataCapacity && dataCapacity <= 2) {
                    return;
                }
            }
            if (length > 4) {
                throw new java.lang.IllegalStateException("Count must not exceed 4");
            }
            int i_renamed = length - 1;
            java.lang.String strEncodeToCodewords = encodeToCodewords(charSequence, 0);
            if (!(!encoderContext.hasMoreCharacters()) || i_renamed > 2) {
                z_renamed = false;
            }
            if (i_renamed <= 2) {
                encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + i_renamed);
                if (encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount() >= 3) {
                    encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + strEncodeToCodewords.length());
                    z_renamed = false;
                }
            }
            if (z_renamed) {
                encoderContext.resetSymbolInfo();
                encoderContext.pos -= i_renamed;
            } else {
                encoderContext.writeCodewords(strEncodeToCodewords);
            }
        } finally {
            encoderContext.signalEncoderChange(0);
        }
    }

    private static void encodeChar(char c2, java.lang.StringBuilder sb) {
        if (c2 >= ' ' && c2 <= '?') {
            sb.append(c2);
        } else if (c2 >= '@' && c2 <= '^') {
            sb.append((char) (c2 - '@'));
        } else {
            com.google.zxing.datamatrix.encoder.HighLevelEncoder.illegalCharacter(c2);
        }
    }

    private static java.lang.String encodeToCodewords(java.lang.CharSequence charSequence, int i_renamed) {
        int length = charSequence.length() - i_renamed;
        if (length == 0) {
            throw new java.lang.IllegalStateException("StringBuilder must not be_renamed empty");
        }
        int iCharAt = (charSequence.charAt(i_renamed) << 18) + ((length >= 2 ? charSequence.charAt(i_renamed + 1) : (char) 0) << '\f_renamed') + ((length >= 3 ? charSequence.charAt(i_renamed + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i_renamed + 3) : (char) 0);
        char c2 = (char) ((iCharAt >> 16) & 255);
        char c3 = (char) ((iCharAt >> 8) & 255);
        char c4 = (char) (iCharAt & 255);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(3);
        sb.append(c2);
        if (length >= 2) {
            sb.append(c3);
        }
        if (length >= 3) {
            sb.append(c4);
        }
        return sb.toString();
    }
}

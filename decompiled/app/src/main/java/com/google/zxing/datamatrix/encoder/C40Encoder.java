package com.google.zxing.datamatrix.encoder;

/* loaded from: classes.dex */
class C40Encoder implements com.google.zxing.datamatrix.encoder.Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 1;
    }

    C40Encoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(com.google.zxing.datamatrix.encoder.EncoderContext encoderContext) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            int iEncodeChar = encodeChar(currentChar, sb);
            int codewordCount = encoderContext.getCodewordCount() + ((sb.length() / 3) << 1);
            encoderContext.updateSymbolInfo(codewordCount);
            int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
            if (!encoderContext.hasMoreCharacters()) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                if (sb.length() % 3 == 2 && dataCapacity != 2) {
                    iEncodeChar = backtrackOneCharacter(encoderContext, sb, sb2, iEncodeChar);
                }
                while (sb.length() % 3 == 1 && (iEncodeChar > 3 || dataCapacity != 1)) {
                    iEncodeChar = backtrackOneCharacter(encoderContext, sb, sb2, iEncodeChar);
                }
            } else if (sb.length() % 3 == 0 && com.google.zxing.datamatrix.encoder.HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                encoderContext.signalEncoderChange(0);
                break;
            }
        }
        handleEOD(encoderContext, sb);
    }

    private int backtrackOneCharacter(com.google.zxing.datamatrix.encoder.EncoderContext encoderContext, java.lang.StringBuilder sb, java.lang.StringBuilder sb2, int i_renamed) {
        int length = sb.length();
        sb.delete(length - i_renamed, length);
        encoderContext.pos--;
        int iEncodeChar = encodeChar(encoderContext.getCurrentChar(), sb2);
        encoderContext.resetSymbolInfo();
        return iEncodeChar;
    }

    static void writeNextTriplet(com.google.zxing.datamatrix.encoder.EncoderContext encoderContext, java.lang.StringBuilder sb) {
        encoderContext.writeCodewords(encodeToCodewords(sb, 0));
        sb.delete(0, 3);
    }

    void handleEOD(com.google.zxing.datamatrix.encoder.EncoderContext encoderContext, java.lang.StringBuilder sb) {
        int length = (sb.length() / 3) << 1;
        int length2 = sb.length() % 3;
        int codewordCount = encoderContext.getCodewordCount() + length;
        encoderContext.updateSymbolInfo(codewordCount);
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
        } else if (dataCapacity == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
            encoderContext.pos--;
        } else if (length2 == 0) {
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (dataCapacity > 0 || encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
        } else {
            throw new java.lang.IllegalStateException("Unexpected case. Please report!");
        }
        encoderContext.signalEncoderChange(0);
    }

    int encodeChar(char c2, java.lang.StringBuilder sb) {
        if (c2 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            return 1;
        }
        if (c2 >= 'A_renamed' && c2 <= 'Z_renamed') {
            sb.append((char) ((c2 - 'A_renamed') + 14));
            return 1;
        }
        if (c2 < ' ') {
            sb.append((char) 0);
            sb.append(c2);
            return 2;
        }
        if (c2 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c2 - '!'));
            return 2;
        }
        if (c2 <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c2 - ':') + 15));
            return 2;
        }
        if (c2 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c2 - '[') + 22));
            return 2;
        }
        if (c2 <= 127) {
            sb.append((char) 2);
            sb.append((char) (c2 - '`'));
            return 2;
        }
        sb.append("\u0001\u001e");
        return encodeChar((char) (c2 - 128), sb) + 2;
    }

    private static java.lang.String encodeToCodewords(java.lang.CharSequence charSequence, int i_renamed) {
        int iCharAt = (charSequence.charAt(i_renamed) * 1600) + (charSequence.charAt(i_renamed + 1) * '(') + charSequence.charAt(i_renamed + 2) + 1;
        return new java.lang.String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }
}

package com.google.zxing.datamatrix.encoder;

/* loaded from: classes.dex */
final class TextEncoder extends com.google.zxing.datamatrix.encoder.C40Encoder {
    @Override // com.google.zxing.datamatrix.encoder.C40Encoder, com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 2;
    }

    TextEncoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    int encodeChar(char c2, java.lang.StringBuilder sb) {
        if (c2 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            return 1;
        }
        if (c2 >= 'a_renamed' && c2 <= 'z_renamed') {
            sb.append((char) ((c2 - 'a_renamed') + 14));
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
        if (c2 >= '[' && c2 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c2 - '[') + 22));
            return 2;
        }
        if (c2 == '`') {
            sb.append((char) 2);
            sb.append((char) (c2 - '`'));
            return 2;
        }
        if (c2 <= 'Z_renamed') {
            sb.append((char) 2);
            sb.append((char) ((c2 - 'A_renamed') + 1));
            return 2;
        }
        if (c2 <= 127) {
            sb.append((char) 2);
            sb.append((char) ((c2 - '{') + 27));
            return 2;
        }
        sb.append("\u0001\u001e");
        return encodeChar((char) (c2 - 128), sb) + 2;
    }
}

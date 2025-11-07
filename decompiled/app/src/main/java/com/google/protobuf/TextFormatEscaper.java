package com.google.protobuf;

/* loaded from: classes.dex */
final class TextFormatEscaper {

    private interface ByteSequence {
        byte byteAt(int i_renamed);

        int size();
    }

    private TextFormatEscaper() {
    }

    static java.lang.String escapeBytes(com.google.protobuf.TextFormatEscaper.ByteSequence byteSequence) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(byteSequence.size());
        for (int i_renamed = 0; i_renamed < byteSequence.size(); i_renamed++) {
            byte bByteAt = byteSequence.byteAt(i_renamed);
            if (bByteAt == 34) {
                sb.append("\\\"");
            } else if (bByteAt == 39) {
                sb.append("\\'");
            } else if (bByteAt != 92) {
                switch (bByteAt) {
                    case 7:
                        sb.append("\\a_renamed");
                        break;
                    case 8:
                        sb.append("\\b_renamed");
                        break;
                    case 9:
                        sb.append("\\t_renamed");
                        break;
                    case 10:
                        sb.append("\\n_renamed");
                        break;
                    case 11:
                        sb.append("\\v_renamed");
                        break;
                    case 12:
                        sb.append("\\f_renamed");
                        break;
                    case 13:
                        sb.append("\\r_renamed");
                        break;
                    default:
                        if (bByteAt >= 32 && bByteAt <= 126) {
                            sb.append((char) bByteAt);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((bByteAt >>> 6) & 3) + 48));
                            sb.append((char) (((bByteAt >>> 3) & 7) + 48));
                            sb.append((char) ((bByteAt & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    static java.lang.String escapeBytes(final com.google.protobuf.ByteString byteString) {
        return escapeBytes(new com.google.protobuf.TextFormatEscaper.ByteSequence() { // from class: com.google.protobuf.TextFormatEscaper.1
            @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
            public int size() {
                return byteString.size();
            }

            @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
            public byte byteAt(int i_renamed) {
                return byteString.byteAt(i_renamed);
            }
        });
    }

    static java.lang.String escapeBytes(final byte[] bArr) {
        return escapeBytes(new com.google.protobuf.TextFormatEscaper.ByteSequence() { // from class: com.google.protobuf.TextFormatEscaper.2
            @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
            public int size() {
                return bArr.length;
            }

            @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
            public byte byteAt(int i_renamed) {
                return bArr[i_renamed];
            }
        });
    }

    static java.lang.String escapeText(java.lang.String str) {
        return escapeBytes(com.google.protobuf.ByteString.copyFromUtf8(str));
    }

    static java.lang.String escapeDoubleQuotesAndBackslashes(java.lang.String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}

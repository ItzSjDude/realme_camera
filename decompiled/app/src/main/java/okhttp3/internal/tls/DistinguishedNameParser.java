package okhttp3.internal.tls;

/* loaded from: classes2.dex */
final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final java.lang.String dn_renamed;
    private int end;
    private final int length;
    private int pos;

    DistinguishedNameParser(javax.security.auth.x500.X500Principal x500Principal) {
        this.dn_renamed = x500Principal.getName("RFC2253");
        this.length = this.dn_renamed.length();
    }

    private java.lang.String nextAT() {
        while (true) {
            int i_renamed = this.pos;
            if (i_renamed >= this.length || this.chars[i_renamed] != ' ') {
                break;
            }
            this.pos = i_renamed + 1;
        }
        int i2 = this.pos;
        if (i2 == this.length) {
            return null;
        }
        this.beg = i2;
        this.pos = i2 + 1;
        while (true) {
            int i3 = this.pos;
            if (i3 >= this.length) {
                break;
            }
            char[] cArr = this.chars;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.pos = i3 + 1;
        }
        int i4 = this.pos;
        if (i4 >= this.length) {
            throw new java.lang.IllegalStateException("Unexpected end of_renamed DN: " + this.dn_renamed);
        }
        this.end = i4;
        if (this.chars[i4] == ' ') {
            while (true) {
                int i5 = this.pos;
                if (i5 >= this.length) {
                    break;
                }
                char[] cArr2 = this.chars;
                if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                    break;
                }
                this.pos = i5 + 1;
            }
            char[] cArr3 = this.chars;
            int i6 = this.pos;
            if (cArr3[i6] != '=' || i6 == this.length) {
                throw new java.lang.IllegalStateException("Unexpected end of_renamed DN: " + this.dn_renamed);
            }
        }
        this.pos++;
        while (true) {
            int i7 = this.pos;
            if (i7 >= this.length || this.chars[i7] != ' ') {
                break;
            }
            this.pos = i7 + 1;
        }
        int i8 = this.end;
        int i9 = this.beg;
        if (i8 - i9 > 4) {
            char[] cArr4 = this.chars;
            if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O_renamed' || cArr4[i9] == 'o_renamed')) {
                char[] cArr5 = this.chars;
                int i10 = this.beg;
                if (cArr5[i10 + 1] == 'I_renamed' || cArr5[i10 + 1] == 'i_renamed') {
                    char[] cArr6 = this.chars;
                    int i11 = this.beg;
                    if (cArr6[i11 + 2] == 'D_renamed' || cArr6[i11 + 2] == 'd_renamed') {
                        this.beg += 4;
                    }
                }
            }
        }
        char[] cArr7 = this.chars;
        int i12 = this.beg;
        return new java.lang.String(cArr7, i12, this.end - i12);
    }

    private java.lang.String quotedAV() {
        this.pos++;
        this.beg = this.pos;
        this.end = this.beg;
        while (true) {
            int i_renamed = this.pos;
            if (i_renamed == this.length) {
                throw new java.lang.IllegalStateException("Unexpected end of_renamed DN: " + this.dn_renamed);
            }
            char[] cArr = this.chars;
            if (cArr[i_renamed] == '\"') {
                this.pos = i_renamed + 1;
                while (true) {
                    int i2 = this.pos;
                    if (i2 >= this.length || this.chars[i2] != ' ') {
                        break;
                    }
                    this.pos = i2 + 1;
                }
                char[] cArr2 = this.chars;
                int i3 = this.beg;
                return new java.lang.String(cArr2, i3, this.end - i3);
            }
            if (cArr[i_renamed] == '\\') {
                cArr[this.end] = getEscaped();
            } else {
                cArr[this.end] = cArr[i_renamed];
            }
            this.pos++;
            this.end++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:28:0x0061, code lost:
    
        r6.end = r6.pos;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String hexAV() {
        /*
            r6 = this;
            int r0 = r6.pos
            int r1 = r0 + 4
            int r2 = r6.length
            java.lang.String r3 = "Unexpected end of_renamed DN: "
            if (r1 >= r2) goto La8
            r6.beg = r0
            int r0 = r0 + 1
            r6.pos = r0
        L10:
            int r0 = r6.pos
            int r1 = r6.length
            if (r0 == r1) goto L61
            char[] r1 = r6.chars
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L61
            char r2 = r1[r0]
            r4 = 44
            if (r2 == r4) goto L61
            char r2 = r1[r0]
            r4 = 59
            if (r2 != r4) goto L2b
            goto L61
        L2b:
            char r2 = r1[r0]
            r4 = 32
            if (r2 != r4) goto L48
            r6.end = r0
            int r0 = r0 + 1
            r6.pos = r0
        L37:
            int r0 = r6.pos
            int r1 = r6.length
            if (r0 >= r1) goto L65
            char[] r1 = r6.chars
            char r1 = r1[r0]
            if (r1 != r4) goto L65
            int r0 = r0 + 1
            r6.pos = r0
            goto L37
        L48:
            char r2 = r1[r0]
            r5 = 65
            if (r2 < r5) goto L5a
            char r2 = r1[r0]
            r5 = 70
            if (r2 > r5) goto L5a
            char r2 = r1[r0]
            int r2 = r2 + r4
            char r2 = (char) r2
            r1[r0] = r2
        L5a:
            int r0 = r6.pos
            int r0 = r0 + 1
            r6.pos = r0
            goto L10
        L61:
            int r0 = r6.pos
            r6.end = r0
        L65:
            int r0 = r6.end
            int r1 = r6.beg
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L91
            r2 = r0 & 1
            if (r2 == 0) goto L91
            int r2 = r0 / 2
            byte[] r2 = new byte[r2]
            r3 = 0
            int r1 = r1 + 1
        L78:
            int r4 = r2.length
            if (r3 >= r4) goto L87
            int r4 = r6.getByte(r1)
            byte r4 = (byte) r4
            r2[r3] = r4
            int r1 = r1 + 2
            int r3 = r3 + 1
            goto L78
        L87:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.chars
            int r6 = r6.beg
            r1.<init>(r2, r6, r0)
            return r1
        L91:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r6 = r6.dn_renamed
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        La8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r6 = r6.dn_renamed
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.tls.DistinguishedNameParser.hexAV():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:16:0x0053, code lost:
    
        r1 = r8.chars;
        r2 = r8.beg;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:17:0x005f, code lost:
    
        return new java.lang.String(r1, r2, r8.end - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String escapedAV() {
        /*
            r8 = this;
            int r0 = r8.pos
            r8.beg = r0
            r8.end = r0
        L6:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r8 = r8.end
            int r8 = r8 - r2
            r0.<init>(r1, r2, r8)
            return r0
        L19:
            char[] r1 = r8.chars
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L60
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.end
            int r3 = r2 + 1
            r8.end = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L40:
            int r0 = r8.end
            int r2 = r0 + 1
            r8.end = r2
            char r2 = r8.getEscaped()
            r1[r0] = r2
            int r0 = r8.pos
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r8 = r8.end
            int r8 = r8 - r2
            r0.<init>(r1, r2, r8)
            return r0
        L60:
            int r2 = r8.end
            r8.cur = r2
            int r0 = r0 + 1
            r8.pos = r0
            int r0 = r2 + 1
            r8.end = r0
            r1[r2] = r6
        L6e:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 >= r1) goto L87
            char[] r1 = r8.chars
            char r2 = r1[r0]
            if (r2 != r6) goto L87
            int r2 = r8.end
            int r7 = r2 + 1
            r8.end = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.pos = r0
            goto L6e
        L87:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 == r1) goto L9b
            char[] r1 = r8.chars
            char r2 = r1[r0]
            if (r2 == r3) goto L9b
            char r2 = r1[r0]
            if (r2 == r4) goto L9b
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L9b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r8 = r8.cur
            int r8 = r8 - r2
            r0.<init>(r1, r2, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.tls.DistinguishedNameParser.escapedAV():java.lang.String");
    }

    private char getEscaped() {
        this.pos++;
        int i_renamed = this.pos;
        if (i_renamed == this.length) {
            throw new java.lang.IllegalStateException("Unexpected end of_renamed DN: " + this.dn_renamed);
        }
        char c2 = this.chars[i_renamed];
        if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
            switch (c2) {
                case '*':
                case '+':
                case ',':
                    break;
                default:
                    switch (c2) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            return getUTF8();
                    }
            }
        }
        return this.chars[this.pos];
    }

    private char getUTF8() {
        int i_renamed;
        int i2;
        int i3 = getByte(this.pos);
        this.pos++;
        if (i3 < 128) {
            return (char) i3;
        }
        if (i3 < 192 || i3 > 247) {
            return '?';
        }
        if (i3 <= 223) {
            i2 = i3 & 31;
            i_renamed = 1;
        } else if (i3 <= 239) {
            i_renamed = 2;
            i2 = i3 & 15;
        } else {
            i_renamed = 3;
            i2 = i3 & 7;
        }
        for (int i4 = 0; i4 < i_renamed; i4++) {
            this.pos++;
            int i5 = this.pos;
            if (i5 == this.length || this.chars[i5] != '\\') {
                return '?';
            }
            this.pos = i5 + 1;
            int i6 = getByte(this.pos);
            this.pos++;
            if ((i6 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (i6 & 63);
        }
        return (char) i2;
    }

    private int getByte(int i_renamed) {
        int i2;
        int i3;
        int i4 = i_renamed + 1;
        if (i4 >= this.length) {
            throw new java.lang.IllegalStateException("Malformed DN: " + this.dn_renamed);
        }
        char c2 = this.chars[i_renamed];
        if (c2 >= '0' && c2 <= '9') {
            i2 = c2 - '0';
        } else if (c2 >= 'a_renamed' && c2 <= 'f_renamed') {
            i2 = c2 - 'W_renamed';
        } else {
            if (c2 < 'A_renamed' || c2 > 'F_renamed') {
                throw new java.lang.IllegalStateException("Malformed DN: " + this.dn_renamed);
            }
            i2 = c2 - '7';
        }
        char c3 = this.chars[i4];
        if (c3 >= '0' && c3 <= '9') {
            i3 = c3 - '0';
        } else if (c3 >= 'a_renamed' && c3 <= 'f_renamed') {
            i3 = c3 - 'W_renamed';
        } else {
            if (c3 < 'A_renamed' || c3 > 'F_renamed') {
                throw new java.lang.IllegalStateException("Malformed DN: " + this.dn_renamed);
            }
            i3 = c3 - '7';
        }
        return (i2 << 4) + i3;
    }

    public java.lang.String findMostSpecific(java.lang.String str) {
        java.lang.String strQuotedAV;
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn_renamed.toCharArray();
        java.lang.String strNextAT = nextAT();
        if (strNextAT == null) {
            return null;
        }
        do {
            int i_renamed = this.pos;
            if (i_renamed == this.length) {
                return null;
            }
            char c2 = this.chars[i_renamed];
            if (c2 == '\"') {
                strQuotedAV = quotedAV();
            } else if (c2 == '#') {
                strQuotedAV = hexAV();
            } else {
                strQuotedAV = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : escapedAV();
            }
            if (str.equalsIgnoreCase(strNextAT)) {
                return strQuotedAV;
            }
            int i2 = this.pos;
            if (i2 >= this.length) {
                return null;
            }
            char[] cArr = this.chars;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new java.lang.IllegalStateException("Malformed DN: " + this.dn_renamed);
            }
            this.pos++;
            strNextAT = nextAT();
        } while (strNextAT != null);
        throw new java.lang.IllegalStateException("Malformed DN: " + this.dn_renamed);
    }
}

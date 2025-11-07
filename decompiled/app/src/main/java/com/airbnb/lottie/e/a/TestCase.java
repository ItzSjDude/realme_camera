package com.airbnb.lottie.e_renamed.a_renamed;

/* compiled from: JsonUtf8Reader.java */
/* loaded from: classes.dex */
final class e_renamed extends com.airbnb.lottie.e_renamed.a_renamed.c_renamed {
    private static final okio.ByteString g_renamed = okio.ByteString.encodeUtf8("'\\");
    private static final okio.ByteString h_renamed = okio.ByteString.encodeUtf8("\"\\");
    private static final okio.ByteString i_renamed = okio.ByteString.encodeUtf8("{}[]:, \n_renamed\t_renamed\r_renamed\f_renamed/\\;#=");
    private static final okio.ByteString j_renamed = okio.ByteString.encodeUtf8("\n_renamed\r_renamed");
    private static final okio.ByteString k_renamed = okio.ByteString.encodeUtf8("*/");
    private final okio.BufferedSource l_renamed;
    private final okio.Buffer m_renamed;
    private int n_renamed = 0;
    private long o_renamed;
    private int p_renamed;
    private java.lang.String q_renamed;

    e_renamed(okio.BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new java.lang.NullPointerException("source == null");
        }
        this.l_renamed = bufferedSource;
        this.m_renamed = bufferedSource.buffer();
        a_renamed(6);
    }

    @Override // com.airbnb.lottie.e_renamed.a_renamed.c_renamed
    public void a_renamed() throws java.io.IOException {
        int iO = this.n_renamed;
        if (iO == 0) {
            iO = o_renamed();
        }
        if (iO == 3) {
            a_renamed(1);
            this.d_renamed[this.f2167a - 1] = 0;
            this.n_renamed = 0;
        } else {
            throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected BEGIN_ARRAY but was " + f_renamed() + " at_renamed path " + n_renamed());
        }
    }

    @Override // com.airbnb.lottie.e_renamed.a_renamed.c_renamed
    public void b_renamed() throws java.io.IOException {
        int iO = this.n_renamed;
        if (iO == 0) {
            iO = o_renamed();
        }
        if (iO == 4) {
            this.f2167a--;
            int[] iArr = this.d_renamed;
            int i2 = this.f2167a - 1;
            iArr[i2] = iArr[i2] + 1;
            this.n_renamed = 0;
            return;
        }
        throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected END_ARRAY but was " + f_renamed() + " at_renamed path " + n_renamed());
    }

    @Override // com.airbnb.lottie.e_renamed.a_renamed.c_renamed
    public void c_renamed() throws java.io.IOException {
        int iO = this.n_renamed;
        if (iO == 0) {
            iO = o_renamed();
        }
        if (iO == 1) {
            a_renamed(3);
            this.n_renamed = 0;
            return;
        }
        throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected BEGIN_OBJECT but was " + f_renamed() + " at_renamed path " + n_renamed());
    }

    @Override // com.airbnb.lottie.e_renamed.a_renamed.c_renamed
    public void d_renamed() throws java.io.IOException {
        int iO = this.n_renamed;
        if (iO == 0) {
            iO = o_renamed();
        }
        if (iO == 2) {
            this.f2167a--;
            this.f2169c[this.f2167a] = null;
            int[] iArr = this.d_renamed;
            int i2 = this.f2167a - 1;
            iArr[i2] = iArr[i2] + 1;
            this.n_renamed = 0;
            return;
        }
        throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected END_OBJECT but was " + f_renamed() + " at_renamed path " + n_renamed());
    }

    @Override // com.airbnb.lottie.e_renamed.a_renamed.c_renamed
    public boolean e_renamed() throws java.io.IOException {
        int iO = this.n_renamed;
        if (iO == 0) {
            iO = o_renamed();
        }
        return (iO == 2 || iO == 4 || iO == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.e_renamed.a_renamed.c_renamed
    public com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed f_renamed() throws java.io.IOException {
        int iO = this.n_renamed;
        if (iO == 0) {
            iO = o_renamed();
        }
        switch (iO) {
            case 1:
                return com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BEGIN_OBJECT;
            case 2:
                return com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.END_OBJECT;
            case 3:
                return com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BEGIN_ARRAY;
            case 4:
                return com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.END_ARRAY;
            case 5:
            case 6:
                return com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BOOLEAN;
            case 7:
                return com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.NAME;
            case 16:
            case 17:
                return com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.NUMBER;
            case 18:
                return com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.END_DOCUMENT;
            default:
                throw new java.lang.AssertionError();
        }
    }

    private int o_renamed() throws java.io.IOException {
        int i2 = this.f2168b[this.f2167a - 1];
        if (i2 == 1) {
            this.f2168b[this.f2167a - 1] = 2;
        } else if (i2 == 2) {
            int iA = a_renamed(true);
            this.m_renamed.readByte();
            if (iA != 44) {
                if (iA != 59) {
                    if (iA == 93) {
                        this.n_renamed = 4;
                        return 4;
                    }
                    throw a_renamed("Unterminated array");
                }
                t_renamed();
            }
        } else {
            if (i2 == 3 || i2 == 5) {
                this.f2168b[this.f2167a - 1] = 4;
                if (i2 == 5) {
                    int iA2 = a_renamed(true);
                    this.m_renamed.readByte();
                    if (iA2 != 44) {
                        if (iA2 != 59) {
                            if (iA2 == 125) {
                                this.n_renamed = 2;
                                return 2;
                            }
                            throw a_renamed("Unterminated object");
                        }
                        t_renamed();
                    }
                }
                int iA3 = a_renamed(true);
                if (iA3 == 34) {
                    this.m_renamed.readByte();
                    this.n_renamed = 13;
                    return 13;
                }
                if (iA3 == 39) {
                    this.m_renamed.readByte();
                    t_renamed();
                    this.n_renamed = 12;
                    return 12;
                }
                if (iA3 != 125) {
                    t_renamed();
                    if (b_renamed((char) iA3)) {
                        this.n_renamed = 14;
                        return 14;
                    }
                    throw a_renamed("Expected name");
                }
                if (i2 != 5) {
                    this.m_renamed.readByte();
                    this.n_renamed = 2;
                    return 2;
                }
                throw a_renamed("Expected name");
            }
            if (i2 == 4) {
                this.f2168b[this.f2167a - 1] = 5;
                int iA4 = a_renamed(true);
                this.m_renamed.readByte();
                if (iA4 != 58) {
                    if (iA4 == 61) {
                        t_renamed();
                        if (this.l_renamed.request(1L) && this.m_renamed.getByte(0L) == 62) {
                            this.m_renamed.readByte();
                        }
                    } else {
                        throw a_renamed("Expected ':'");
                    }
                }
            } else if (i2 == 6) {
                this.f2168b[this.f2167a - 1] = 7;
            } else if (i2 == 7) {
                if (a_renamed(false) == -1) {
                    this.n_renamed = 18;
                    return 18;
                }
                t_renamed();
            } else if (i2 == 8) {
                throw new java.lang.IllegalStateException("JsonReader is_renamed closed");
            }
        }
        int iA5 = a_renamed(true);
        if (iA5 == 34) {
            this.m_renamed.readByte();
            this.n_renamed = 9;
            return 9;
        }
        if (iA5 == 39) {
            t_renamed();
            this.m_renamed.readByte();
            this.n_renamed = 8;
            return 8;
        }
        if (iA5 != 44 && iA5 != 59) {
            if (iA5 == 91) {
                this.m_renamed.readByte();
                this.n_renamed = 3;
                return 3;
            }
            if (iA5 != 93) {
                if (iA5 == 123) {
                    this.m_renamed.readByte();
                    this.n_renamed = 1;
                    return 1;
                }
                int iP = p_renamed();
                if (iP != 0) {
                    return iP;
                }
                int iQ = q_renamed();
                if (iQ != 0) {
                    return iQ;
                }
                if (!b_renamed(this.m_renamed.getByte(0L))) {
                    throw a_renamed("Expected value");
                }
                t_renamed();
                this.n_renamed = 10;
                return 10;
            }
            if (i2 == 1) {
                this.m_renamed.readByte();
                this.n_renamed = 4;
                return 4;
            }
        }
        if (i2 == 1 || i2 == 2) {
            t_renamed();
            this.n_renamed = 7;
            return 7;
        }
        throw a_renamed("Unexpected value");
    }

    private int p_renamed() throws java.io.IOException {
        int i2;
        java.lang.String str;
        java.lang.String str2;
        byte b2 = this.m_renamed.getByte(0L);
        if (b2 == 116 || b2 == 84) {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (b2 == 102 || b2 == 70) {
            i2 = 6;
            str = "false";
            str2 = "FALSE";
        } else {
            if (b2 != 110 && b2 != 78) {
                return 0;
            }
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.l_renamed.request(i4)) {
                return 0;
            }
            byte b3 = this.m_renamed.getByte(i3);
            if (b3 != str.charAt(i3) && b3 != str2.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.l_renamed.request(length + 1) && b_renamed(this.m_renamed.getByte(length))) {
            return 0;
        }
        this.m_renamed.skip(length);
        this.n_renamed = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:47:0x0084, code lost:
    
        if (b_renamed(r11) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:48:0x0086, code lost:
    
        if (r6 != 2) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:49:0x0088, code lost:
    
        if (r7 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:51:0x008e, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:52:0x0090, code lost:
    
        if (r10 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:54:0x0094, code lost:
    
        if (r8 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:55:0x0096, code lost:
    
        if (r10 != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:56:0x0098, code lost:
    
        if (r10 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:58:0x009b, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:59:0x009c, code lost:
    
        r16.o_renamed = r8;
        r16.m_renamed.skip(r5);
        r16.n_renamed = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:60:0x00a8, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:61:0x00a9, code lost:
    
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:63:0x00ac, code lost:
    
        if (r6 == 4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:65:0x00af, code lost:
    
        if (r6 != 7) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:67:0x00b2, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:69:0x00b4, code lost:
    
        r16.p_renamed = r5;
        r16.n_renamed = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:70:0x00ba, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:71:0x00bb, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int q_renamed() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.e_renamed.a_renamed.e_renamed.q_renamed():int");
    }

    private boolean b_renamed(int i2) throws java.io.IOException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (i2 != 47 && i2 != 61) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        t_renamed();
        return false;
    }

    @Override // com.airbnb.lottie.e_renamed.a_renamed.c_renamed
    public java.lang.String g_renamed() throws java.io.IOException {
        java.lang.String strA;
        int iO = this.n_renamed;
        if (iO == 0) {
            iO = o_renamed();
        }
        if (iO == 14) {
            strA = r_renamed();
        } else if (iO == 13) {
            strA = a_renamed(h_renamed);
        } else if (iO == 12) {
            strA = a_renamed(g_renamed);
        } else if (iO == 15) {
            strA = this.q_renamed;
        } else {
            throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected a_renamed name but was " + f_renamed() + " at_renamed path " + n_renamed());
        }
        this.n_renamed = 0;
        this.f2169c[this.f2167a - 1] = strA;
        return strA;
    }

    @Override // com.airbnb.lottie.e_renamed.a_renamed.c_renamed
    public int a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed aVar) throws java.io.IOException {
        int iO = this.n_renamed;
        if (iO == 0) {
            iO = o_renamed();
        }
        if (iO < 12 || iO > 15) {
            return -1;
        }
        if (iO == 15) {
            return a_renamed(this.q_renamed, aVar);
        }
        int iSelect = this.l_renamed.select(aVar.f2171b);
        if (iSelect != -1) {
            this.n_renamed = 0;
            this.f2169c[this.f2167a - 1] = aVar.f2170a[iSelect];
            return iSelect;
        }
        java.lang.String str = this.f2169c[this.f2167a - 1];
        java.lang.String strG = g_renamed();
        int iA = a_renamed(strG, aVar);
        if (iA == -1) {
            this.n_renamed = 15;
            this.q_renamed = strG;
            this.f2169c[this.f2167a - 1] = str;
        }
        return iA;
    }

    @Override // com.airbnb.lottie.e_renamed.a_renamed.c_renamed
    public void h_renamed() throws java.io.IOException {
        if (this.f_renamed) {
            throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Cannot skip unexpected " + f_renamed() + " at_renamed " + n_renamed());
        }
        int iO = this.n_renamed;
        if (iO == 0) {
            iO = o_renamed();
        }
        if (iO == 14) {
            s_renamed();
        } else if (iO == 13) {
            b_renamed(h_renamed);
        } else if (iO == 12) {
            b_renamed(g_renamed);
        } else if (iO != 15) {
            throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected a_renamed name but was " + f_renamed() + " at_renamed path " + n_renamed());
        }
        this.n_renamed = 0;
        this.f2169c[this.f2167a - 1] = "null";
    }

    private int a_renamed(java.lang.String str, com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed aVar) {
        int length = aVar.f2170a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.f2170a[i2])) {
                this.n_renamed = 0;
                this.f2169c[this.f2167a - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    @Override // com.airbnb.lottie.e_renamed.a_renamed.c_renamed
    public java.lang.String i_renamed() throws java.io.IOException {
        java.lang.String utf8;
        int iO = this.n_renamed;
        if (iO == 0) {
            iO = o_renamed();
        }
        if (iO == 10) {
            utf8 = r_renamed();
        } else if (iO == 9) {
            utf8 = a_renamed(h_renamed);
        } else if (iO == 8) {
            utf8 = a_renamed(g_renamed);
        } else if (iO == 11) {
            utf8 = this.q_renamed;
            this.q_renamed = null;
        } else if (iO == 16) {
            utf8 = java.lang.Long.toString(this.o_renamed);
        } else if (iO == 17) {
            utf8 = this.m_renamed.readUtf8(this.p_renamed);
        } else {
            throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected a_renamed string but was " + f_renamed() + " at_renamed path " + n_renamed());
        }
        this.n_renamed = 0;
        int[] iArr = this.d_renamed;
        int i2 = this.f2167a - 1;
        iArr[i2] = iArr[i2] + 1;
        return utf8;
    }

    @Override // com.airbnb.lottie.e_renamed.a_renamed.c_renamed
    public boolean j_renamed() throws java.io.IOException {
        int iO = this.n_renamed;
        if (iO == 0) {
            iO = o_renamed();
        }
        if (iO == 5) {
            this.n_renamed = 0;
            int[] iArr = this.d_renamed;
            int i2 = this.f2167a - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iO == 6) {
            this.n_renamed = 0;
            int[] iArr2 = this.d_renamed;
            int i3 = this.f2167a - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected a_renamed boolean but was " + f_renamed() + " at_renamed path " + n_renamed());
    }

    @Override // com.airbnb.lottie.e_renamed.a_renamed.c_renamed
    public double k_renamed() throws java.io.IOException, java.lang.NumberFormatException {
        int iO = this.n_renamed;
        if (iO == 0) {
            iO = o_renamed();
        }
        if (iO == 16) {
            this.n_renamed = 0;
            int[] iArr = this.d_renamed;
            int i2 = this.f2167a - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.o_renamed;
        }
        if (iO == 17) {
            this.q_renamed = this.m_renamed.readUtf8(this.p_renamed);
        } else if (iO == 9) {
            this.q_renamed = a_renamed(h_renamed);
        } else if (iO == 8) {
            this.q_renamed = a_renamed(g_renamed);
        } else if (iO == 10) {
            this.q_renamed = r_renamed();
        } else if (iO != 11) {
            throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected a_renamed double but was " + f_renamed() + " at_renamed path " + n_renamed());
        }
        this.n_renamed = 11;
        try {
            double d_renamed = java.lang.Double.parseDouble(this.q_renamed);
            if (!this.e_renamed && (java.lang.Double.isNaN(d_renamed) || java.lang.Double.isInfinite(d_renamed))) {
                throw new com.airbnb.lottie.e_renamed.a_renamed.b_renamed("JSON forbids NaN and infinities: " + d_renamed + " at_renamed path " + n_renamed());
            }
            this.q_renamed = null;
            this.n_renamed = 0;
            int[] iArr2 = this.d_renamed;
            int i3 = this.f2167a - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return d_renamed;
        } catch (java.lang.NumberFormatException unused) {
            throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected a_renamed double but was " + this.q_renamed + " at_renamed path " + n_renamed());
        }
    }

    private java.lang.String a_renamed(okio.ByteString byteString) throws java.io.IOException {
        java.lang.StringBuilder sb = null;
        while (true) {
            long jIndexOfElement = this.l_renamed.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                throw a_renamed("Unterminated string");
            }
            if (this.m_renamed.getByte(jIndexOfElement) != 92) {
                if (sb == null) {
                    java.lang.String utf8 = this.m_renamed.readUtf8(jIndexOfElement);
                    this.m_renamed.readByte();
                    return utf8;
                }
                sb.append(this.m_renamed.readUtf8(jIndexOfElement));
                this.m_renamed.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new java.lang.StringBuilder();
            }
            sb.append(this.m_renamed.readUtf8(jIndexOfElement));
            this.m_renamed.readByte();
            sb.append(w_renamed());
        }
    }

    private java.lang.String r_renamed() throws java.io.IOException {
        long jIndexOfElement = this.l_renamed.indexOfElement(i_renamed);
        return jIndexOfElement != -1 ? this.m_renamed.readUtf8(jIndexOfElement) : this.m_renamed.readUtf8();
    }

    private void b_renamed(okio.ByteString byteString) throws java.io.IOException {
        while (true) {
            long jIndexOfElement = this.l_renamed.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                throw a_renamed("Unterminated string");
            }
            if (this.m_renamed.getByte(jIndexOfElement) == 92) {
                this.m_renamed.skip(jIndexOfElement + 1);
                w_renamed();
            } else {
                this.m_renamed.skip(jIndexOfElement + 1);
                return;
            }
        }
    }

    private void s_renamed() throws java.io.IOException {
        long jIndexOfElement = this.l_renamed.indexOfElement(i_renamed);
        okio.Buffer buffer = this.m_renamed;
        if (jIndexOfElement == -1) {
            jIndexOfElement = buffer.size();
        }
        buffer.skip(jIndexOfElement);
    }

    @Override // com.airbnb.lottie.e_renamed.a_renamed.c_renamed
    public int l_renamed() throws java.io.IOException, java.lang.NumberFormatException {
        java.lang.String strA;
        int iO = this.n_renamed;
        if (iO == 0) {
            iO = o_renamed();
        }
        if (iO == 16) {
            long j2 = this.o_renamed;
            int i2 = (int) j2;
            if (j2 != i2) {
                throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected an_renamed int but was " + this.o_renamed + " at_renamed path " + n_renamed());
            }
            this.n_renamed = 0;
            int[] iArr = this.d_renamed;
            int i3 = this.f2167a - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (iO == 17) {
            this.q_renamed = this.m_renamed.readUtf8(this.p_renamed);
        } else if (iO == 9 || iO == 8) {
            if (iO == 9) {
                strA = a_renamed(h_renamed);
            } else {
                strA = a_renamed(g_renamed);
            }
            this.q_renamed = strA;
            try {
                int i4 = java.lang.Integer.parseInt(this.q_renamed);
                this.n_renamed = 0;
                int[] iArr2 = this.d_renamed;
                int i5 = this.f2167a - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (java.lang.NumberFormatException unused) {
            }
        } else if (iO != 11) {
            throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected an_renamed int but was " + f_renamed() + " at_renamed path " + n_renamed());
        }
        this.n_renamed = 11;
        try {
            double d_renamed = java.lang.Double.parseDouble(this.q_renamed);
            int i6 = (int) d_renamed;
            if (i6 != d_renamed) {
                throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected an_renamed int but was " + this.q_renamed + " at_renamed path " + n_renamed());
            }
            this.q_renamed = null;
            this.n_renamed = 0;
            int[] iArr3 = this.d_renamed;
            int i7 = this.f2167a - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        } catch (java.lang.NumberFormatException unused2) {
            throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected an_renamed int but was " + this.q_renamed + " at_renamed path " + n_renamed());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.n_renamed = 0;
        this.f2168b[0] = 8;
        this.f2167a = 1;
        this.m_renamed.clear();
        this.l_renamed.close();
    }

    @Override // com.airbnb.lottie.e_renamed.a_renamed.c_renamed
    public void m_renamed() throws java.io.IOException {
        if (this.f_renamed) {
            throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Cannot skip unexpected " + f_renamed() + " at_renamed " + n_renamed());
        }
        int i2 = 0;
        do {
            int iO = this.n_renamed;
            if (iO == 0) {
                iO = o_renamed();
            }
            if (iO == 3) {
                a_renamed(1);
            } else if (iO == 1) {
                a_renamed(3);
            } else {
                if (iO == 4) {
                    i2--;
                    if (i2 < 0) {
                        throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected a_renamed value but was " + f_renamed() + " at_renamed path " + n_renamed());
                    }
                    this.f2167a--;
                } else if (iO == 2) {
                    i2--;
                    if (i2 < 0) {
                        throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected a_renamed value but was " + f_renamed() + " at_renamed path " + n_renamed());
                    }
                    this.f2167a--;
                } else if (iO == 14 || iO == 10) {
                    s_renamed();
                } else if (iO == 9 || iO == 13) {
                    b_renamed(h_renamed);
                } else if (iO == 8 || iO == 12) {
                    b_renamed(g_renamed);
                } else if (iO == 17) {
                    this.m_renamed.skip(this.p_renamed);
                } else if (iO == 18) {
                    throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Expected a_renamed value but was " + f_renamed() + " at_renamed path " + n_renamed());
                }
                this.n_renamed = 0;
            }
            i2++;
            this.n_renamed = 0;
        } while (i2 != 0);
        int[] iArr = this.d_renamed;
        int i3 = this.f2167a - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f2169c[this.f2167a - 1] = "null";
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:15:0x0025, code lost:
    
        r6.m_renamed.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:16:0x002f, code lost:
    
        if (r1 != 47) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:18:0x0039, code lost:
    
        if (r6.l_renamed.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:19:0x003b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:20:0x003c, code lost:
    
        t_renamed();
        r3 = r6.m_renamed.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:21:0x0049, code lost:
    
        if (r3 == 42) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:22:0x004b, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:23:0x004d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:24:0x004e, code lost:
    
        r6.m_renamed.readByte();
        r6.m_renamed.readByte();
        u_renamed();
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:25:0x005c, code lost:
    
        r6.m_renamed.readByte();
        r6.m_renamed.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:26:0x006a, code lost:
    
        if (v_renamed() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:29:0x0073, code lost:
    
        throw a_renamed("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:31:0x0076, code lost:
    
        if (r1 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:32:0x0078, code lost:
    
        t_renamed();
        u_renamed();
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:33:0x007f, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int a_renamed(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1_renamed:
            r1 = r0
        L2_renamed:
            okio.BufferedSource r2 = r6.l_renamed
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L82
            okio.Buffer r2 = r6.m_renamed
            long r4 = (long) r1
            byte r1 = r2.getByte(r4)
            r2 = 10
            if (r1 == r2) goto L80
            r2 = 32
            if (r1 == r2) goto L80
            r2 = 13
            if (r1 == r2) goto L80
            r2 = 9
            if (r1 != r2) goto L25
            goto L80
        L25:
            okio.Buffer r2 = r6.m_renamed
            int r3 = r3 + (-1)
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L74
            okio.BufferedSource r3 = r6.l_renamed
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3c
            return r1
        L3c:
            r6.t_renamed()
            okio.Buffer r3 = r6.m_renamed
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L5c
            if (r3 == r2) goto L4e
            return r1
        L4e:
            okio.Buffer r1 = r6.m_renamed
            r1.readByte()
            okio.Buffer r1 = r6.m_renamed
            r1.readByte()
            r6.u_renamed()
            goto L1_renamed
        L5c:
            okio.Buffer r1 = r6.m_renamed
            r1.readByte()
            okio.Buffer r1 = r6.m_renamed
            r1.readByte()
            boolean r1 = r6.v_renamed()
            if (r1 == 0) goto L6d
            goto L1_renamed
        L6d:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.e_renamed.a_renamed.b_renamed r6 = r6.a_renamed(r7)
            throw r6
        L74:
            r2 = 35
            if (r1 != r2) goto L7f
            r6.t_renamed()
            r6.u_renamed()
            goto L1_renamed
        L7f:
            return r1
        L80:
            r1 = r3
            goto L2_renamed
        L82:
            if (r7 != 0) goto L86
            r6 = -1
            return r6
        L86:
            java.io.EOFException r6 = new java.io.EOFException
            java.lang.String r7 = "End of_renamed input"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.e_renamed.a_renamed.e_renamed.a_renamed(boolean):int");
    }

    private void t_renamed() throws java.io.IOException {
        if (!this.e_renamed) {
            throw a_renamed("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void u_renamed() throws java.io.IOException {
        long jIndexOfElement = this.l_renamed.indexOfElement(j_renamed);
        okio.Buffer buffer = this.m_renamed;
        buffer.skip(jIndexOfElement != -1 ? jIndexOfElement + 1 : buffer.size());
    }

    private boolean v_renamed() throws java.io.IOException {
        long jIndexOf = this.l_renamed.indexOf(k_renamed);
        boolean z_renamed = jIndexOf != -1;
        okio.Buffer buffer = this.m_renamed;
        buffer.skip(z_renamed ? jIndexOf + k_renamed.size() : buffer.size());
        return z_renamed;
    }

    public java.lang.String toString() {
        return "JsonReader(" + this.l_renamed + ")";
    }

    private char w_renamed() throws java.io.IOException {
        int i2;
        int i3;
        if (!this.l_renamed.request(1L)) {
            throw a_renamed("Unterminated escape sequence");
        }
        byte b2 = this.m_renamed.readByte();
        if (b2 == 10 || b2 == 34 || b2 == 39 || b2 == 47 || b2 == 92) {
            return (char) b2;
        }
        if (b2 == 98) {
            return '\b_renamed';
        }
        if (b2 == 102) {
            return '\f_renamed';
        }
        if (b2 == 110) {
            return '\n_renamed';
        }
        if (b2 == 114) {
            return '\r_renamed';
        }
        if (b2 == 116) {
            return '\t_renamed';
        }
        if (b2 == 117) {
            if (!this.l_renamed.request(4L)) {
                throw new java.io.EOFException("Unterminated escape sequence at_renamed path " + n_renamed());
            }
            char c2 = 0;
            for (int i4 = 0; i4 < 4; i4++) {
                byte b3 = this.m_renamed.getByte(i4);
                char c3 = (char) (c2 << 4);
                if (b3 < 48 || b3 > 57) {
                    if (b3 >= 97 && b3 <= 102) {
                        i2 = b3 - 97;
                    } else {
                        if (b3 < 65 || b3 > 70) {
                            throw a_renamed("\\u_renamed" + this.m_renamed.readUtf8(4L));
                        }
                        i2 = b3 - 65;
                    }
                    i3 = i2 + 10;
                } else {
                    i3 = b3 - 48;
                }
                c2 = (char) (c3 + i3);
            }
            this.m_renamed.skip(4L);
            return c2;
        }
        if (this.e_renamed) {
            return (char) b2;
        }
        throw a_renamed("Invalid escape sequence: \\" + ((char) b2));
    }
}

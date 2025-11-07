package com.airbnb.lottie.p089e.p090a;

import com.airbnb.lottie.p089e.p090a.JsonReader;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* compiled from: JsonUtf8Reader.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
final class JsonUtf8Reader extends JsonReader {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final ByteString f5755g = ByteString.encodeUtf8("'\\");

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static final ByteString f5756h = ByteString.encodeUtf8("\"\\");

    /* renamed from: OplusGLSurfaceView_13 */
    private static final ByteString f5757i = ByteString.encodeUtf8("{}[]:, \OplusGLSurfaceView_11\t\r\COUIBaseListPopupWindow_12/\\;#=");

    /* renamed from: OplusGLSurfaceView_15 */
    private static final ByteString f5758j = ByteString.encodeUtf8("\OplusGLSurfaceView_11\r");

    /* renamed from: OplusGLSurfaceView_5 */
    private static final ByteString f5759k = ByteString.encodeUtf8("*/");

    /* renamed from: OplusGLSurfaceView_14 */
    private final BufferedSource f5760l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final Buffer f5761m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f5762n = 0;

    /* renamed from: o */
    private long f5763o;

    /* renamed from: p */
    private int f5764p;

    /* renamed from: q */
    private String f5765q;

    JsonUtf8Reader(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.f5760l = bufferedSource;
        this.f5761m = bufferedSource.buffer();
        m5915a(6);
    }

    @Override // com.airbnb.lottie.p089e.p090a.JsonReader
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5914a() throws IOException {
        int iM5936o = this.f5762n;
        if (iM5936o == 0) {
            iM5936o = m5936o();
        }
        if (iM5936o == 3) {
            m5915a(1);
            this.f5750d[this.f5747a - 1] = 0;
            this.f5762n = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + mo5920f() + " at path " + m5928n());
        }
    }

    @Override // com.airbnb.lottie.p089e.p090a.JsonReader
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo5916b() throws IOException {
        int iM5936o = this.f5762n;
        if (iM5936o == 0) {
            iM5936o = m5936o();
        }
        if (iM5936o == 4) {
            this.f5747a--;
            int[] iArr = this.f5750d;
            int OplusGLSurfaceView_13 = this.f5747a - 1;
            iArr[OplusGLSurfaceView_13] = iArr[OplusGLSurfaceView_13] + 1;
            this.f5762n = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + mo5920f() + " at path " + m5928n());
    }

    @Override // com.airbnb.lottie.p089e.p090a.JsonReader
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo5917c() throws IOException {
        int iM5936o = this.f5762n;
        if (iM5936o == 0) {
            iM5936o = m5936o();
        }
        if (iM5936o == 1) {
            m5915a(3);
            this.f5762n = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + mo5920f() + " at path " + m5928n());
    }

    @Override // com.airbnb.lottie.p089e.p090a.JsonReader
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo5918d() throws IOException {
        int iM5936o = this.f5762n;
        if (iM5936o == 0) {
            iM5936o = m5936o();
        }
        if (iM5936o == 2) {
            this.f5747a--;
            this.f5749c[this.f5747a] = null;
            int[] iArr = this.f5750d;
            int OplusGLSurfaceView_13 = this.f5747a - 1;
            iArr[OplusGLSurfaceView_13] = iArr[OplusGLSurfaceView_13] + 1;
            this.f5762n = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + mo5920f() + " at path " + m5928n());
    }

    @Override // com.airbnb.lottie.p089e.p090a.JsonReader
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo5919e() throws IOException {
        int iM5936o = this.f5762n;
        if (iM5936o == 0) {
            iM5936o = m5936o();
        }
        return (iM5936o == 2 || iM5936o == 4 || iM5936o == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.p089e.p090a.JsonReader
    /* renamed from: COUIBaseListPopupWindow_12 */
    public JsonReader.IntrinsicsJvm.kt_4 mo5920f() throws IOException {
        int iM5936o = this.f5762n;
        if (iM5936o == 0) {
            iM5936o = m5936o();
        }
        switch (iM5936o) {
            case 1:
                return JsonReader.IntrinsicsJvm.kt_4.BEGIN_OBJECT;
            case 2:
                return JsonReader.IntrinsicsJvm.kt_4.END_OBJECT;
            case 3:
                return JsonReader.IntrinsicsJvm.kt_4.BEGIN_ARRAY;
            case 4:
                return JsonReader.IntrinsicsJvm.kt_4.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.IntrinsicsJvm.kt_4.BOOLEAN;
            case 7:
                return JsonReader.IntrinsicsJvm.kt_4.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.IntrinsicsJvm.kt_4.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.IntrinsicsJvm.kt_4.NAME;
            case 16:
            case 17:
                return JsonReader.IntrinsicsJvm.kt_4.NUMBER;
            case 18:
                return JsonReader.IntrinsicsJvm.kt_4.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* renamed from: o */
    private int m5936o() throws IOException {
        int OplusGLSurfaceView_13 = this.f5748b[this.f5747a - 1];
        if (OplusGLSurfaceView_13 == 1) {
            this.f5748b[this.f5747a - 1] = 2;
        } else if (OplusGLSurfaceView_13 == 2) {
            int iM5932a = m5932a(true);
            this.f5761m.readByte();
            if (iM5932a != 44) {
                if (iM5932a != 59) {
                    if (iM5932a == 93) {
                        this.f5762n = 4;
                        return 4;
                    }
                    throw m5913a("Unterminated array");
                }
                m5941t();
            }
        } else {
            if (OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 5) {
                this.f5748b[this.f5747a - 1] = 4;
                if (OplusGLSurfaceView_13 == 5) {
                    int iM5932a2 = m5932a(true);
                    this.f5761m.readByte();
                    if (iM5932a2 != 44) {
                        if (iM5932a2 != 59) {
                            if (iM5932a2 == 125) {
                                this.f5762n = 2;
                                return 2;
                            }
                            throw m5913a("Unterminated object");
                        }
                        m5941t();
                    }
                }
                int iM5932a3 = m5932a(true);
                if (iM5932a3 == 34) {
                    this.f5761m.readByte();
                    this.f5762n = 13;
                    return 13;
                }
                if (iM5932a3 == 39) {
                    this.f5761m.readByte();
                    m5941t();
                    this.f5762n = 12;
                    return 12;
                }
                if (iM5932a3 != 125) {
                    m5941t();
                    if (m5935b((char) iM5932a3)) {
                        this.f5762n = 14;
                        return 14;
                    }
                    throw m5913a("Expected name");
                }
                if (OplusGLSurfaceView_13 != 5) {
                    this.f5761m.readByte();
                    this.f5762n = 2;
                    return 2;
                }
                throw m5913a("Expected name");
            }
            if (OplusGLSurfaceView_13 == 4) {
                this.f5748b[this.f5747a - 1] = 5;
                int iM5932a4 = m5932a(true);
                this.f5761m.readByte();
                if (iM5932a4 != 58) {
                    if (iM5932a4 == 61) {
                        m5941t();
                        if (this.f5760l.request(1L) && this.f5761m.getByte(0L) == 62) {
                            this.f5761m.readByte();
                        }
                    } else {
                        throw m5913a("Expected ':'");
                    }
                }
            } else if (OplusGLSurfaceView_13 == 6) {
                this.f5748b[this.f5747a - 1] = 7;
            } else if (OplusGLSurfaceView_13 == 7) {
                if (m5932a(false) == -1) {
                    this.f5762n = 18;
                    return 18;
                }
                m5941t();
            } else if (OplusGLSurfaceView_13 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iM5932a5 = m5932a(true);
        if (iM5932a5 == 34) {
            this.f5761m.readByte();
            this.f5762n = 9;
            return 9;
        }
        if (iM5932a5 == 39) {
            m5941t();
            this.f5761m.readByte();
            this.f5762n = 8;
            return 8;
        }
        if (iM5932a5 != 44 && iM5932a5 != 59) {
            if (iM5932a5 == 91) {
                this.f5761m.readByte();
                this.f5762n = 3;
                return 3;
            }
            if (iM5932a5 != 93) {
                if (iM5932a5 == 123) {
                    this.f5761m.readByte();
                    this.f5762n = 1;
                    return 1;
                }
                int iM5937p = m5937p();
                if (iM5937p != 0) {
                    return iM5937p;
                }
                int iM5938q = m5938q();
                if (iM5938q != 0) {
                    return iM5938q;
                }
                if (!m5935b(this.f5761m.getByte(0L))) {
                    throw m5913a("Expected value");
                }
                m5941t();
                this.f5762n = 10;
                return 10;
            }
            if (OplusGLSurfaceView_13 == 1) {
                this.f5761m.readByte();
                this.f5762n = 4;
                return 4;
            }
        }
        if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2) {
            m5941t();
            this.f5762n = 7;
            return 7;
        }
        throw m5913a("Unexpected value");
    }

    /* renamed from: p */
    private int m5937p() throws IOException {
        int OplusGLSurfaceView_13;
        String str;
        String str2;
        byte b2 = this.f5761m.getByte(0L);
        if (b2 == 116 || b2 == 84) {
            OplusGLSurfaceView_13 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (b2 == 102 || b2 == 70) {
            OplusGLSurfaceView_13 = 6;
            str = "false";
            str2 = "FALSE";
        } else {
            if (b2 != 110 && b2 != 78) {
                return 0;
            }
            OplusGLSurfaceView_13 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.f5760l.request(i3)) {
                return 0;
            }
            byte b3 = this.f5761m.getByte(i2);
            if (b3 != str.charAt(i2) && b3 != str2.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.f5760l.request(length + 1) && m5935b(this.f5761m.getByte(length))) {
            return 0;
        }
        this.f5761m.skip(length);
        this.f5762n = OplusGLSurfaceView_13;
        return OplusGLSurfaceView_13;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0084, code lost:
    
        if (m5935b(r11) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0086, code lost:
    
        if (r6 != 2) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0088, code lost:
    
        if (r7 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008e, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0090, code lost:
    
        if (r10 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0094, code lost:
    
        if (r8 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0096, code lost:
    
        if (r10 != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0098, code lost:
    
        if (r10 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009c, code lost:
    
        r16.f5763o = r8;
        r16.f5761m.skip(r5);
        r16.f5762n = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a8, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a9, code lost:
    
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ac, code lost:
    
        if (r6 == 4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00af, code lost:
    
        if (r6 != 7) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b2, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b4, code lost:
    
        r16.f5764p = r5;
        r16.f5762n = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ba, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00bb, code lost:
    
        return 0;
     */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int m5938q() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p089e.p090a.JsonUtf8Reader.m5938q():int");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m5935b(int OplusGLSurfaceView_13) throws IOException {
        if (OplusGLSurfaceView_13 == 9 || OplusGLSurfaceView_13 == 10 || OplusGLSurfaceView_13 == 12 || OplusGLSurfaceView_13 == 13 || OplusGLSurfaceView_13 == 32) {
            return false;
        }
        if (OplusGLSurfaceView_13 != 35) {
            if (OplusGLSurfaceView_13 == 44) {
                return false;
            }
            if (OplusGLSurfaceView_13 != 47 && OplusGLSurfaceView_13 != 61) {
                if (OplusGLSurfaceView_13 == 123 || OplusGLSurfaceView_13 == 125 || OplusGLSurfaceView_13 == 58) {
                    return false;
                }
                if (OplusGLSurfaceView_13 != 59) {
                    switch (OplusGLSurfaceView_13) {
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
        m5941t();
        return false;
    }

    @Override // com.airbnb.lottie.p089e.p090a.JsonReader
    /* renamed from: COUIBaseListPopupWindow_11 */
    public String mo5921g() throws IOException {
        String strM5933a;
        int iM5936o = this.f5762n;
        if (iM5936o == 0) {
            iM5936o = m5936o();
        }
        if (iM5936o == 14) {
            strM5933a = m5939r();
        } else if (iM5936o == 13) {
            strM5933a = m5933a(f5756h);
        } else if (iM5936o == 12) {
            strM5933a = m5933a(f5755g);
        } else if (iM5936o == 15) {
            strM5933a = this.f5765q;
        } else {
            throw new JsonDataException("Expected PlatformImplementations.kt_3 name but was " + mo5920f() + " at path " + m5928n());
        }
        this.f5762n = 0;
        this.f5749c[this.f5747a - 1] = strM5933a;
        return strM5933a;
    }

    @Override // com.airbnb.lottie.p089e.p090a.JsonReader
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo5912a(JsonReader.PlatformImplementations.kt_3 aVar) throws IOException {
        int iM5936o = this.f5762n;
        if (iM5936o == 0) {
            iM5936o = m5936o();
        }
        if (iM5936o < 12 || iM5936o > 15) {
            return -1;
        }
        if (iM5936o == 15) {
            return m5931a(this.f5765q, aVar);
        }
        int iSelect = this.f5760l.select(aVar.f5754b);
        if (iSelect != -1) {
            this.f5762n = 0;
            this.f5749c[this.f5747a - 1] = aVar.f5753a[iSelect];
            return iSelect;
        }
        String str = this.f5749c[this.f5747a - 1];
        String strMo5921g = mo5921g();
        int iM5931a = m5931a(strMo5921g, aVar);
        if (iM5931a == -1) {
            this.f5762n = 15;
            this.f5765q = strMo5921g;
            this.f5749c[this.f5747a - 1] = str;
        }
        return iM5931a;
    }

    @Override // com.airbnb.lottie.p089e.p090a.JsonReader
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo5922h() throws IOException {
        if (this.f5752f) {
            throw new JsonDataException("Cannot skip unexpected " + mo5920f() + " at " + m5928n());
        }
        int iM5936o = this.f5762n;
        if (iM5936o == 0) {
            iM5936o = m5936o();
        }
        if (iM5936o == 14) {
            m5940s();
        } else if (iM5936o == 13) {
            m5934b(f5756h);
        } else if (iM5936o == 12) {
            m5934b(f5755g);
        } else if (iM5936o != 15) {
            throw new JsonDataException("Expected PlatformImplementations.kt_3 name but was " + mo5920f() + " at path " + m5928n());
        }
        this.f5762n = 0;
        this.f5749c[this.f5747a - 1] = "null";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m5931a(String str, JsonReader.PlatformImplementations.kt_3 aVar) {
        int length = aVar.f5753a.length;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            if (str.equals(aVar.f5753a[OplusGLSurfaceView_13])) {
                this.f5762n = 0;
                this.f5749c[this.f5747a - 1] = str;
                return OplusGLSurfaceView_13;
            }
        }
        return -1;
    }

    @Override // com.airbnb.lottie.p089e.p090a.JsonReader
    /* renamed from: OplusGLSurfaceView_13 */
    public String mo5923i() throws IOException {
        String utf8;
        int iM5936o = this.f5762n;
        if (iM5936o == 0) {
            iM5936o = m5936o();
        }
        if (iM5936o == 10) {
            utf8 = m5939r();
        } else if (iM5936o == 9) {
            utf8 = m5933a(f5756h);
        } else if (iM5936o == 8) {
            utf8 = m5933a(f5755g);
        } else if (iM5936o == 11) {
            utf8 = this.f5765q;
            this.f5765q = null;
        } else if (iM5936o == 16) {
            utf8 = Long.toString(this.f5763o);
        } else if (iM5936o == 17) {
            utf8 = this.f5761m.readUtf8(this.f5764p);
        } else {
            throw new JsonDataException("Expected PlatformImplementations.kt_3 string but was " + mo5920f() + " at path " + m5928n());
        }
        this.f5762n = 0;
        int[] iArr = this.f5750d;
        int OplusGLSurfaceView_13 = this.f5747a - 1;
        iArr[OplusGLSurfaceView_13] = iArr[OplusGLSurfaceView_13] + 1;
        return utf8;
    }

    @Override // com.airbnb.lottie.p089e.p090a.JsonReader
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo5924j() throws IOException {
        int iM5936o = this.f5762n;
        if (iM5936o == 0) {
            iM5936o = m5936o();
        }
        if (iM5936o == 5) {
            this.f5762n = 0;
            int[] iArr = this.f5750d;
            int OplusGLSurfaceView_13 = this.f5747a - 1;
            iArr[OplusGLSurfaceView_13] = iArr[OplusGLSurfaceView_13] + 1;
            return true;
        }
        if (iM5936o == 6) {
            this.f5762n = 0;
            int[] iArr2 = this.f5750d;
            int i2 = this.f5747a - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        throw new JsonDataException("Expected PlatformImplementations.kt_3 boolean but was " + mo5920f() + " at path " + m5928n());
    }

    @Override // com.airbnb.lottie.p089e.p090a.JsonReader
    /* renamed from: OplusGLSurfaceView_5 */
    public double mo5925k() throws IOException, NumberFormatException {
        int iM5936o = this.f5762n;
        if (iM5936o == 0) {
            iM5936o = m5936o();
        }
        if (iM5936o == 16) {
            this.f5762n = 0;
            int[] iArr = this.f5750d;
            int OplusGLSurfaceView_13 = this.f5747a - 1;
            iArr[OplusGLSurfaceView_13] = iArr[OplusGLSurfaceView_13] + 1;
            return this.f5763o;
        }
        if (iM5936o == 17) {
            this.f5765q = this.f5761m.readUtf8(this.f5764p);
        } else if (iM5936o == 9) {
            this.f5765q = m5933a(f5756h);
        } else if (iM5936o == 8) {
            this.f5765q = m5933a(f5755g);
        } else if (iM5936o == 10) {
            this.f5765q = m5939r();
        } else if (iM5936o != 11) {
            throw new JsonDataException("Expected PlatformImplementations.kt_3 double but was " + mo5920f() + " at path " + m5928n());
        }
        this.f5762n = 11;
        try {
            double IntrinsicsJvm.kt_5 = Double.parseDouble(this.f5765q);
            if (!this.f5751e && (Double.isNaN(IntrinsicsJvm.kt_5) || Double.isInfinite(IntrinsicsJvm.kt_5))) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + IntrinsicsJvm.kt_5 + " at path " + m5928n());
            }
            this.f5765q = null;
            this.f5762n = 0;
            int[] iArr2 = this.f5750d;
            int i2 = this.f5747a - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return IntrinsicsJvm.kt_5;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected PlatformImplementations.kt_3 double but was " + this.f5765q + " at path " + m5928n());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m5933a(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long jIndexOfElement = this.f5760l.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                throw m5913a("Unterminated string");
            }
            if (this.f5761m.getByte(jIndexOfElement) != 92) {
                if (sb == null) {
                    String utf8 = this.f5761m.readUtf8(jIndexOfElement);
                    this.f5761m.readByte();
                    return utf8;
                }
                sb.append(this.f5761m.readUtf8(jIndexOfElement));
                this.f5761m.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.f5761m.readUtf8(jIndexOfElement));
            this.f5761m.readByte();
            sb.append(m5944w());
        }
    }

    /* renamed from: r */
    private String m5939r() throws IOException {
        long jIndexOfElement = this.f5760l.indexOfElement(f5757i);
        return jIndexOfElement != -1 ? this.f5761m.readUtf8(jIndexOfElement) : this.f5761m.readUtf8();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m5934b(ByteString byteString) throws IOException {
        while (true) {
            long jIndexOfElement = this.f5760l.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                throw m5913a("Unterminated string");
            }
            if (this.f5761m.getByte(jIndexOfElement) == 92) {
                this.f5761m.skip(jIndexOfElement + 1);
                m5944w();
            } else {
                this.f5761m.skip(jIndexOfElement + 1);
                return;
            }
        }
    }

    /* renamed from: s */
    private void m5940s() throws IOException {
        long jIndexOfElement = this.f5760l.indexOfElement(f5757i);
        Buffer buffer = this.f5761m;
        if (jIndexOfElement == -1) {
            jIndexOfElement = buffer.size();
        }
        buffer.skip(jIndexOfElement);
    }

    @Override // com.airbnb.lottie.p089e.p090a.JsonReader
    /* renamed from: OplusGLSurfaceView_14 */
    public int mo5926l() throws IOException, NumberFormatException {
        String strM5933a;
        int iM5936o = this.f5762n;
        if (iM5936o == 0) {
            iM5936o = m5936o();
        }
        if (iM5936o == 16) {
            long OplusGLSurfaceView_15 = this.f5763o;
            int OplusGLSurfaceView_13 = (int) OplusGLSurfaceView_15;
            if (OplusGLSurfaceView_15 != OplusGLSurfaceView_13) {
                throw new JsonDataException("Expected an int but was " + this.f5763o + " at path " + m5928n());
            }
            this.f5762n = 0;
            int[] iArr = this.f5750d;
            int i2 = this.f5747a - 1;
            iArr[i2] = iArr[i2] + 1;
            return OplusGLSurfaceView_13;
        }
        if (iM5936o == 17) {
            this.f5765q = this.f5761m.readUtf8(this.f5764p);
        } else if (iM5936o == 9 || iM5936o == 8) {
            if (iM5936o == 9) {
                strM5933a = m5933a(f5756h);
            } else {
                strM5933a = m5933a(f5755g);
            }
            this.f5765q = strM5933a;
            try {
                int i3 = Integer.parseInt(this.f5765q);
                this.f5762n = 0;
                int[] iArr2 = this.f5750d;
                int i4 = this.f5747a - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        } else if (iM5936o != 11) {
            throw new JsonDataException("Expected an int but was " + mo5920f() + " at path " + m5928n());
        }
        this.f5762n = 11;
        try {
            double IntrinsicsJvm.kt_5 = Double.parseDouble(this.f5765q);
            int i5 = (int) IntrinsicsJvm.kt_5;
            if (i5 != IntrinsicsJvm.kt_5) {
                throw new JsonDataException("Expected an int but was " + this.f5765q + " at path " + m5928n());
            }
            this.f5765q = null;
            this.f5762n = 0;
            int[] iArr3 = this.f5750d;
            int i6 = this.f5747a - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f5765q + " at path " + m5928n());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5762n = 0;
        this.f5748b[0] = 8;
        this.f5747a = 1;
        this.f5761m.clear();
        this.f5760l.close();
    }

    @Override // com.airbnb.lottie.p089e.p090a.JsonReader
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo5927m() throws IOException {
        if (this.f5752f) {
            throw new JsonDataException("Cannot skip unexpected " + mo5920f() + " at " + m5928n());
        }
        int OplusGLSurfaceView_13 = 0;
        do {
            int iM5936o = this.f5762n;
            if (iM5936o == 0) {
                iM5936o = m5936o();
            }
            if (iM5936o == 3) {
                m5915a(1);
            } else if (iM5936o == 1) {
                m5915a(3);
            } else {
                if (iM5936o == 4) {
                    OplusGLSurfaceView_13--;
                    if (OplusGLSurfaceView_13 < 0) {
                        throw new JsonDataException("Expected PlatformImplementations.kt_3 value but was " + mo5920f() + " at path " + m5928n());
                    }
                    this.f5747a--;
                } else if (iM5936o == 2) {
                    OplusGLSurfaceView_13--;
                    if (OplusGLSurfaceView_13 < 0) {
                        throw new JsonDataException("Expected PlatformImplementations.kt_3 value but was " + mo5920f() + " at path " + m5928n());
                    }
                    this.f5747a--;
                } else if (iM5936o == 14 || iM5936o == 10) {
                    m5940s();
                } else if (iM5936o == 9 || iM5936o == 13) {
                    m5934b(f5756h);
                } else if (iM5936o == 8 || iM5936o == 12) {
                    m5934b(f5755g);
                } else if (iM5936o == 17) {
                    this.f5761m.skip(this.f5764p);
                } else if (iM5936o == 18) {
                    throw new JsonDataException("Expected PlatformImplementations.kt_3 value but was " + mo5920f() + " at path " + m5928n());
                }
                this.f5762n = 0;
            }
            OplusGLSurfaceView_13++;
            this.f5762n = 0;
        } while (OplusGLSurfaceView_13 != 0);
        int[] iArr = this.f5750d;
        int i2 = this.f5747a - 1;
        iArr[i2] = iArr[i2] + 1;
        this.f5749c[this.f5747a - 1] = "null";
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r6.f5761m.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if (r1 != 47) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r6.f5760l.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        m5941t();
        r3 = r6.f5761m.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        if (r3 == 42) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
    
        r6.f5761m.readByte();
        r6.f5761m.readByte();
        m5942u();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        r6.f5761m.readByte();
        r6.f5761m.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        if (m5943v() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
    
        throw m5913a("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if (r1 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
    
        m5941t();
        m5942u();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
    
        return r1;
     */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int m5932a(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            okio.BufferedSource r2 = r6.f5760l
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L82
            okio.Buffer r2 = r6.f5761m
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
            okio.Buffer r2 = r6.f5761m
            int r3 = r3 + (-1)
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L74
            okio.BufferedSource r3 = r6.f5760l
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3c
            return r1
        L3c:
            r6.m5941t()
            okio.Buffer r3 = r6.f5761m
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L5c
            if (r3 == r2) goto L4e
            return r1
        L4e:
            okio.Buffer r1 = r6.f5761m
            r1.readByte()
            okio.Buffer r1 = r6.f5761m
            r1.readByte()
            r6.m5942u()
            goto L1
        L5c:
            okio.Buffer r1 = r6.f5761m
            r1.readByte()
            okio.Buffer r1 = r6.f5761m
            r1.readByte()
            boolean r1 = r6.m5943v()
            if (r1 == 0) goto L6d
            goto L1
        L6d:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 r6 = r6.m5913a(r7)
            throw r6
        L74:
            r2 = 35
            if (r1 != r2) goto L7f
            r6.m5941t()
            r6.m5942u()
            goto L1
        L7f:
            return r1
        L80:
            r1 = r3
            goto L2
        L82:
            if (r7 != 0) goto L86
            r6 = -1
            return r6
        L86:
            java.io.EOFException r6 = new java.io.EOFException
            java.lang.String r7 = "End of input"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p089e.p090a.JsonUtf8Reader.m5932a(boolean):int");
    }

    /* renamed from: t */
    private void m5941t() throws IOException {
        if (!this.f5751e) {
            throw m5913a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: u */
    private void m5942u() throws IOException {
        long jIndexOfElement = this.f5760l.indexOfElement(f5758j);
        Buffer buffer = this.f5761m;
        buffer.skip(jIndexOfElement != -1 ? jIndexOfElement + 1 : buffer.size());
    }

    /* renamed from: v */
    private boolean m5943v() throws IOException {
        long jIndexOf = this.f5760l.indexOf(f5759k);
        boolean z = jIndexOf != -1;
        Buffer buffer = this.f5761m;
        buffer.skip(z ? jIndexOf + f5759k.size() : buffer.size());
        return z;
    }

    public String toString() {
        return "JsonReader(" + this.f5760l + ")";
    }

    /* renamed from: w */
    private char m5944w() throws IOException {
        int OplusGLSurfaceView_13;
        int i2;
        if (!this.f5760l.request(1L)) {
            throw m5913a("Unterminated escape sequence");
        }
        byte b2 = this.f5761m.readByte();
        if (b2 == 10 || b2 == 34 || b2 == 39 || b2 == 47 || b2 == 92) {
            return (char) b2;
        }
        if (b2 == 98) {
            return '\IntrinsicsJvm.kt_4';
        }
        if (b2 == 102) {
            return '\COUIBaseListPopupWindow_12';
        }
        if (b2 == 110) {
            return '\OplusGLSurfaceView_11';
        }
        if (b2 == 114) {
            return '\r';
        }
        if (b2 == 116) {
            return '\t';
        }
        if (b2 == 117) {
            if (!this.f5760l.request(4L)) {
                throw new EOFException("Unterminated escape sequence at path " + m5928n());
            }
            char c2 = 0;
            for (int i3 = 0; i3 < 4; i3++) {
                byte b3 = this.f5761m.getByte(i3);
                char c3 = (char) (c2 << 4);
                if (b3 < 48 || b3 > 57) {
                    if (b3 >= 97 && b3 <= 102) {
                        OplusGLSurfaceView_13 = b3 - 97;
                    } else {
                        if (b3 < 65 || b3 > 70) {
                            throw m5913a("\\u" + this.f5761m.readUtf8(4L));
                        }
                        OplusGLSurfaceView_13 = b3 - 65;
                    }
                    i2 = OplusGLSurfaceView_13 + 10;
                } else {
                    i2 = b3 - 48;
                }
                c2 = (char) (c3 + i2);
            }
            this.f5761m.skip(4L);
            return c2;
        }
        if (this.f5751e) {
            return (char) b2;
        }
        throw m5913a("Invalid escape sequence: \\" + ((char) b2));
    }
}

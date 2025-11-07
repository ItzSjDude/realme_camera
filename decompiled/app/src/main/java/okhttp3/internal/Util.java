package okhttp3.internal;

/* loaded from: classes2.dex */
public final class Util {
    private static final java.util.regex.Pattern VERIFY_AS_IP_ADDRESS;
    private static final java.lang.reflect.Method addSuppressedExceptionMethod;
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final java.lang.String[] EMPTY_STRING_ARRAY = new java.lang.String[0];
    public static final okhttp3.ResponseBody EMPTY_RESPONSE = okhttp3.ResponseBody.create((okhttp3.MediaType) null, EMPTY_BYTE_ARRAY);
    public static final okhttp3.RequestBody EMPTY_REQUEST = okhttp3.RequestBody.create((okhttp3.MediaType) null, EMPTY_BYTE_ARRAY);
    private static final okio.ByteString UTF_8_BOM = okio.ByteString.decodeHex("efbbbf");
    private static final okio.ByteString UTF_16_BE_BOM = okio.ByteString.decodeHex("feff");
    private static final okio.ByteString UTF_16_LE_BOM = okio.ByteString.decodeHex("fffe");
    private static final okio.ByteString UTF_32_BE_BOM = okio.ByteString.decodeHex("0000ffff");
    private static final okio.ByteString UTF_32_LE_BOM = okio.ByteString.decodeHex("ffff0000");
    public static final java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");
    public static final java.nio.charset.Charset ISO_8859_1 = java.nio.charset.Charset.forName(org.apache.commons.codec.CharEncoding.ISO_8859_1);
    private static final java.nio.charset.Charset UTF_16_BE = java.nio.charset.Charset.forName(org.apache.commons.codec.CharEncoding.UTF_16BE);
    private static final java.nio.charset.Charset UTF_16_LE = java.nio.charset.Charset.forName(org.apache.commons.codec.CharEncoding.UTF_16LE);
    private static final java.nio.charset.Charset UTF_32_BE = java.nio.charset.Charset.forName("UTF-32BE");
    private static final java.nio.charset.Charset UTF_32_LE = java.nio.charset.Charset.forName("UTF-32LE");
    public static final java.util.TimeZone UTC = java.util.TimeZone.getTimeZone("GMT");
    public static final java.util.Comparator<java.lang.String> NATURAL_ORDER = new java.util.Comparator<java.lang.String>() { // from class: okhttp3.internal.Util.1
        @Override // java.util.Comparator
        public int compare(java.lang.String str, java.lang.String str2) {
            return str.compareTo(str2);
        }
    };

    public static int decodeHexDigit(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a_renamed';
        if (c2 < 'a_renamed' || c2 > 'f_renamed') {
            c3 = 'A_renamed';
            if (c2 < 'A_renamed' || c2 > 'F_renamed') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    static {
        java.lang.reflect.Method declaredMethod = null;
        try {
            declaredMethod = java.lang.Throwable.class.getDeclaredMethod("addSuppressed", java.lang.Throwable.class);
        } catch (java.lang.Exception unused) {
        }
        addSuppressedExceptionMethod = declaredMethod;
        VERIFY_AS_IP_ADDRESS = java.util.regex.Pattern.compile("([0-9a-fA_renamed-F_renamed]*:[0-9a-fA_renamed-F_renamed:.]*)|([\\d_renamed.]+)");
    }

    public static void addSuppressedIfPossible(java.lang.Throwable th, java.lang.Throwable th2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Method method = addSuppressedExceptionMethod;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            }
        }
    }

    private Util() {
    }

    public static void checkOffsetAndCount(long j_renamed, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j_renamed || j_renamed - j2 < j3) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean equal(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void closeQuietly(java.io.Closeable closeable) throws java.io.IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.RuntimeException e_renamed) {
                throw e_renamed;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void closeQuietly(java.net.Socket socket) throws java.io.IOException {
        if (socket != null) {
            try {
                socket.close();
            } catch (java.lang.AssertionError e_renamed) {
                if (!isAndroidGetsocknameError(e_renamed)) {
                    throw e_renamed;
                }
            } catch (java.lang.RuntimeException e2) {
                throw e2;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void closeQuietly(java.net.ServerSocket serverSocket) throws java.io.IOException {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (java.lang.RuntimeException e_renamed) {
                throw e_renamed;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static boolean discard(okio.Source source, int i_renamed, java.util.concurrent.TimeUnit timeUnit) {
        try {
            return skipAll(source, i_renamed, timeUnit);
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    public static boolean skipAll(okio.Source source, int i_renamed, java.util.concurrent.TimeUnit timeUnit) throws java.io.IOException {
        long jNanoTime = java.lang.System.nanoTime();
        long jDeadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - jNanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(java.lang.Math.min(jDeadlineNanoTime, timeUnit.toNanos(i_renamed)) + jNanoTime);
        try {
            okio.Buffer buffer = new okio.Buffer();
            while (source.read(buffer, 8192L) != -1) {
                buffer.clear();
            }
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            return true;
        } catch (java.io.InterruptedIOException unused) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            return false;
        } catch (java.lang.Throwable th) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th;
        }
    }

    public static <T_renamed> java.util.List<T_renamed> immutableList(java.util.List<T_renamed> list) {
        return java.util.Collections.unmodifiableList(new java.util.ArrayList(list));
    }

    public static <K_renamed, V_renamed> java.util.Map<K_renamed, V_renamed> immutableMap(java.util.Map<K_renamed, V_renamed> map) {
        if (map.isEmpty()) {
            return java.util.Collections.emptyMap();
        }
        return java.util.Collections.unmodifiableMap(new java.util.LinkedHashMap(map));
    }

    public static <T_renamed> java.util.List<T_renamed> immutableList(T_renamed... tArr) {
        return java.util.Collections.unmodifiableList(java.util.Arrays.asList((java.lang.Object[]) tArr.clone()));
    }

    public static java.util.concurrent.ThreadFactory threadFactory(final java.lang.String str, final boolean z_renamed) {
        return new java.util.concurrent.ThreadFactory() { // from class: okhttp3.internal.Util.2
            @Override // java.util.concurrent.ThreadFactory
            public java.lang.Thread newThread(java.lang.Runnable runnable) {
                java.lang.Thread thread = new java.lang.Thread(runnable, str);
                thread.setDaemon(z_renamed);
                return thread;
            }
        };
    }

    public static java.lang.String[] intersect(java.util.Comparator<? super java.lang.String> comparator, java.lang.String[] strArr, java.lang.String[] strArr2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : strArr) {
            int length = strArr2.length;
            int i_renamed = 0;
            while (true) {
                if (i_renamed >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i_renamed]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i_renamed++;
            }
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    public static boolean nonEmptyIntersection(java.util.Comparator<java.lang.String> comparator, java.lang.String[] strArr, java.lang.String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (java.lang.String str : strArr) {
                for (java.lang.String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static java.lang.String hostHeader(okhttp3.HttpUrl httpUrl, boolean z_renamed) {
        java.lang.String strHost;
        if (httpUrl.host().contains(":")) {
            strHost = "[" + httpUrl.host() + "]";
        } else {
            strHost = httpUrl.host();
        }
        if (!z_renamed && httpUrl.port() == okhttp3.HttpUrl.defaultPort(httpUrl.scheme())) {
            return strHost;
        }
        return strHost + ":" + httpUrl.port();
    }

    public static boolean isAndroidGetsocknameError(java.lang.AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int indexOf(java.util.Comparator<java.lang.String> comparator, java.lang.String[] strArr, java.lang.String str) {
        int length = strArr.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            if (comparator.compare(strArr[i_renamed], str) == 0) {
                return i_renamed;
            }
        }
        return -1;
    }

    public static java.lang.String[] concat(java.lang.String[] strArr, java.lang.String str) {
        java.lang.String[] strArr2 = new java.lang.String[strArr.length + 1];
        java.lang.System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static int skipLeadingAsciiWhitespace(java.lang.String str, int i_renamed, int i2) {
        while (i_renamed < i2) {
            char cCharAt = str.charAt(i_renamed);
            if (cCharAt != '\t_renamed' && cCharAt != '\n_renamed' && cCharAt != '\f_renamed' && cCharAt != '\r_renamed' && cCharAt != ' ') {
                return i_renamed;
            }
            i_renamed++;
        }
        return i2;
    }

    public static int skipTrailingAsciiWhitespace(java.lang.String str, int i_renamed, int i2) {
        for (int i3 = i2 - 1; i3 >= i_renamed; i3--) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '\t_renamed' && cCharAt != '\n_renamed' && cCharAt != '\f_renamed' && cCharAt != '\r_renamed' && cCharAt != ' ') {
                return i3 + 1;
            }
        }
        return i_renamed;
    }

    public static java.lang.String trimSubstring(java.lang.String str, int i_renamed, int i2) {
        int iSkipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, i_renamed, i2);
        return str.substring(iSkipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace(str, iSkipLeadingAsciiWhitespace, i2));
    }

    public static int delimiterOffset(java.lang.String str, int i_renamed, int i2, java.lang.String str2) {
        while (i_renamed < i2) {
            if (str2.indexOf(str.charAt(i_renamed)) != -1) {
                return i_renamed;
            }
            i_renamed++;
        }
        return i2;
    }

    public static int delimiterOffset(java.lang.String str, int i_renamed, int i2, char c2) {
        while (i_renamed < i2) {
            if (str.charAt(i_renamed) == c2) {
                return i_renamed;
            }
            i_renamed++;
        }
        return i2;
    }

    public static java.lang.String canonicalizeHost(java.lang.String str) {
        java.net.InetAddress inetAddressDecodeIpv6;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                inetAddressDecodeIpv6 = decodeIpv6(str, 1, str.length() - 1);
            } else {
                inetAddressDecodeIpv6 = decodeIpv6(str, 0, str.length());
            }
            if (inetAddressDecodeIpv6 == null) {
                return null;
            }
            byte[] address = inetAddressDecodeIpv6.getAddress();
            if (address.length == 16) {
                return inet6AddressToAscii(address);
            }
            throw new java.lang.AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            java.lang.String lowerCase = java.net.IDN.toASCII(str).toLowerCase(java.util.Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    private static boolean containsInvalidHostnameAsciiCodes(java.lang.String str) {
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            char cCharAt = str.charAt(i_renamed);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int indexOfControlOrNonAscii(java.lang.String str) {
        int length = str.length();
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            char cCharAt = str.charAt(i_renamed);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i_renamed;
            }
        }
        return -1;
    }

    public static boolean verifyAsIpAddress(java.lang.String str) {
        return VERIFY_AS_IP_ADDRESS.matcher(str).matches();
    }

    public static java.lang.String format(java.lang.String str, java.lang.Object... objArr) {
        return java.lang.String.format(java.util.Locale.US, str, objArr);
    }

    public static java.nio.charset.Charset bomAwareCharset(okio.BufferedSource bufferedSource, java.nio.charset.Charset charset) throws java.io.IOException {
        if (bufferedSource.rangeEquals(0L, UTF_8_BOM)) {
            bufferedSource.skip(UTF_8_BOM.size());
            return UTF_8;
        }
        if (bufferedSource.rangeEquals(0L, UTF_16_BE_BOM)) {
            bufferedSource.skip(UTF_16_BE_BOM.size());
            return UTF_16_BE;
        }
        if (bufferedSource.rangeEquals(0L, UTF_16_LE_BOM)) {
            bufferedSource.skip(UTF_16_LE_BOM.size());
            return UTF_16_LE;
        }
        if (bufferedSource.rangeEquals(0L, UTF_32_BE_BOM)) {
            bufferedSource.skip(UTF_32_BE_BOM.size());
            return UTF_32_BE;
        }
        if (!bufferedSource.rangeEquals(0L, UTF_32_LE_BOM)) {
            return charset;
        }
        bufferedSource.skip(UTF_32_LE_BOM.size());
        return UTF_32_LE;
    }

    public static int checkDuration(java.lang.String str, long j_renamed, java.util.concurrent.TimeUnit timeUnit) {
        if (j_renamed < 0) {
            throw new java.lang.IllegalArgumentException(str + " < 0");
        }
        if (timeUnit == null) {
            throw new java.lang.NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j_renamed);
        if (millis > 2147483647L) {
            throw new java.lang.IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j_renamed <= 0) {
            return (int) millis;
        }
        throw new java.lang.IllegalArgumentException(str + " too small.");
    }

    public static java.lang.AssertionError assertionError(java.lang.String str, java.lang.Exception exc) {
        java.lang.AssertionError assertionError = new java.lang.AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (java.lang.IllegalStateException unused) {
        }
        return assertionError;
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:44:0x007d, code lost:
    
        if (r3 == r0.length) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:45:0x007f, code lost:
    
        if (r4 != (-1)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:46:0x0081, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:47:0x0082, code lost:
    
        r11 = r3 - r4;
        java.lang.System.arraycopy(r0, r4, r0, r0.length - r11, r11);
        java.util.Arrays.fill(r0, r4, (r0.length - r3) + r4, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:49:0x0093, code lost:
    
        return java.net.InetAddress.getByAddress(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:51:0x0099, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Removed duplicated region for block: B_renamed:32:0x0051  */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.net.InetAddress decodeIpv6(java.lang.String r10, int r11, int r12) {
        /*
            r0 = 16
            byte[] r0 = new byte[r0]
            r1 = -1
            r2 = 0
            r4 = r1
            r5 = r4
            r3 = r2
        L9:
            r6 = 0
            if (r11 >= r12) goto L7c
            int r7 = r0.length
            if (r3 != r7) goto L10
            return r6
        L10:
            int r7 = r11 + 2
            if (r7 > r12) goto L29
            r8 = 2
            java.lang.String r9 = "::"
            boolean r8 = r10.regionMatches(r11, r9, r2, r8)
            if (r8 == 0) goto L29
            if (r4 == r1) goto L20
            return r6
        L20:
            int r3 = r3 + 2
            if (r7 != r12) goto L26
            r4 = r3
            goto L7c
        L26:
            r4 = r3
            r5 = r7
            goto L4d
        L29:
            if (r3 == 0) goto L4c
            r7 = 1
            java.lang.String r8 = ":"
            boolean r8 = r10.regionMatches(r11, r8, r2, r7)
            if (r8 == 0) goto L37
            int r11 = r11 + 1
            goto L4c
        L37:
            java.lang.String r8 = "."
            boolean r11 = r10.regionMatches(r11, r8, r2, r7)
            if (r11 == 0) goto L4b
            int r11 = r3 + (-2)
            boolean r10 = decodeIpv4Suffix(r10, r5, r12, r0, r11)
            if (r10 != 0) goto L48
            return r6
        L48:
            int r3 = r3 + 2
            goto L7c
        L4b:
            return r6
        L4c:
            r5 = r11
        L4d:
            r7 = r2
            r11 = r5
        L4f:
            if (r11 >= r12) goto L62
            char r8 = r10.charAt(r11)
            int r8 = decodeHexDigit(r8)
            if (r8 != r1) goto L5c
            goto L62
        L5c:
            int r7 = r7 << 4
            int r7 = r7 + r8
            int r11 = r11 + 1
            goto L4f
        L62:
            int r8 = r11 - r5
            if (r8 == 0) goto L7b
            r9 = 4
            if (r8 <= r9) goto L6a
            goto L7b
        L6a:
            int r6 = r3 + 1
            int r8 = r7 >>> 8
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r0[r3] = r8
            int r3 = r6 + 1
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r0[r6] = r7
            goto L9
        L7b:
            return r6
        L7c:
            int r10 = r0.length
            if (r3 == r10) goto L8f
            if (r4 != r1) goto L82
            return r6
        L82:
            int r10 = r0.length
            int r11 = r3 - r4
            int r10 = r10 - r11
            java.lang.System.arraycopy(r0, r4, r0, r10, r11)
            int r10 = r0.length
            int r10 = r10 - r3
            int r10 = r10 + r4
            java.util.Arrays.fill(r0, r4, r10, r2)
        L8f:
            java.net.InetAddress r10 = java.net.InetAddress.getByAddress(r0)     // Catch: java.net.UnknownHostException -> L94
            return r10
        L94:
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
    }

    private static boolean decodeIpv4Suffix(java.lang.String str, int i_renamed, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i_renamed < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i_renamed) != '.') {
                    return false;
                }
                i_renamed++;
            }
            int i5 = i_renamed;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i6 == 0 && i_renamed != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i_renamed == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i_renamed = i5;
        }
        return i4 == i3 + 4;
    }

    private static java.lang.String inet6AddressToAscii(byte[] bArr) {
        int i_renamed = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (i4 < bArr.length) {
            int i5 = i4;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i4;
            if (i6 > i2 && i6 >= 4) {
                i3 = i4;
                i2 = i6;
            }
            i4 = i5 + 2;
        }
        okio.Buffer buffer = new okio.Buffer();
        while (i_renamed < bArr.length) {
            if (i_renamed == i3) {
                buffer.writeByte(58);
                i_renamed += i2;
                if (i_renamed == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i_renamed > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong(((bArr[i_renamed] & 255) << 8) | (bArr[i_renamed + 1] & 255));
                i_renamed += 2;
            }
        }
        return buffer.readUtf8();
    }

    public static javax.net.ssl.X509TrustManager platformTrustManager() throws java.security.NoSuchAlgorithmException, java.security.KeyStoreException {
        try {
            javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((java.security.KeyStore) null);
            javax.net.ssl.TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof javax.net.ssl.X509TrustManager)) {
                throw new java.lang.IllegalStateException("Unexpected default trust managers:" + java.util.Arrays.toString(trustManagers));
            }
            return (javax.net.ssl.X509TrustManager) trustManagers[0];
        } catch (java.security.GeneralSecurityException e_renamed) {
            throw assertionError("No System TLS", e_renamed);
        }
    }

    public static okhttp3.Headers toHeaders(java.util.List<okhttp3.internal.http2.Header> list) {
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        for (okhttp3.internal.http2.Header header : list) {
            okhttp3.internal.Internal.instance.addLenient(builder, header.name.utf8(), header.value.utf8());
        }
        return builder.build();
    }
}

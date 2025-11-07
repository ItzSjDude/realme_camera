package okhttp3.internal.http;

/* loaded from: classes2.dex */
public final class HttpHeaders {
    private static final okio.ByteString QUOTED_STRING_DELIMITERS = okio.ByteString.encodeUtf8("\"\\");
    private static final okio.ByteString TOKEN_DELIMITERS = okio.ByteString.encodeUtf8("\t_renamed ,=");

    private HttpHeaders() {
    }

    public static long contentLength(okhttp3.Response response) {
        return contentLength(response.headers());
    }

    public static long contentLength(okhttp3.Headers headers) {
        return stringToLong(headers.get("Content-Length"));
    }

    private static long stringToLong(java.lang.String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return java.lang.Long.parseLong(str);
        } catch (java.lang.NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean varyMatches(okhttp3.Response response, okhttp3.Headers headers, okhttp3.Request request) {
        for (java.lang.String str : varyFields(response)) {
            if (!okhttp3.internal.Util.equal(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasVaryAll(okhttp3.Response response) {
        return hasVaryAll(response.headers());
    }

    public static boolean hasVaryAll(okhttp3.Headers headers) {
        return varyFields(headers).contains("*");
    }

    private static java.util.Set<java.lang.String> varyFields(okhttp3.Response response) {
        return varyFields(response.headers());
    }

    public static java.util.Set<java.lang.String> varyFields(okhttp3.Headers headers) {
        java.util.Set<java.lang.String> setEmptySet = java.util.Collections.emptySet();
        int size = headers.size();
        java.util.Set<java.lang.String> treeSet = setEmptySet;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            if ("Vary".equalsIgnoreCase(headers.name(i_renamed))) {
                java.lang.String strValue = headers.value(i_renamed);
                if (treeSet.isEmpty()) {
                    treeSet = new java.util.TreeSet<>((java.util.Comparator<? super java.lang.String>) java.lang.String.CASE_INSENSITIVE_ORDER);
                }
                for (java.lang.String str : strValue.split(",")) {
                    treeSet.add(str.trim());
                }
            }
        }
        return treeSet;
    }

    public static okhttp3.Headers varyHeaders(okhttp3.Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static okhttp3.Headers varyHeaders(okhttp3.Headers headers, okhttp3.Headers headers2) {
        java.util.Set<java.lang.String> setVaryFields = varyFields(headers2);
        if (setVaryFields.isEmpty()) {
            return new okhttp3.Headers.Builder().build();
        }
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        int size = headers.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            java.lang.String strName = headers.name(i_renamed);
            if (setVaryFields.contains(strName)) {
                builder.add(strName, headers.value(i_renamed));
            }
        }
        return builder.build();
    }

    public static java.util.List<okhttp3.Challenge> parseChallenges(okhttp3.Headers headers, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed < headers.size(); i_renamed++) {
            if (str.equalsIgnoreCase(headers.name(i_renamed))) {
                parseChallengeHeader(arrayList, new okio.Buffer().writeUtf8(headers.value(i_renamed)));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:61:0x0080, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:62:0x0080, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B_renamed:29:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseChallengeHeader(java.util.List<okhttp3.Challenge> r8, okio.Buffer r9) {
        /*
            r0 = 0
        L1_renamed:
            r1 = r0
        L2_renamed:
            if (r1 != 0) goto Le
            skipWhitespaceAndCommas(r9)
            java.lang.String r1 = readToken(r9)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = skipWhitespaceAndCommas(r9)
            java.lang.String r3 = readToken(r9)
            if (r3 != 0) goto L2c
            boolean r9 = r9.exhausted()
            if (r9 != 0) goto L1f
            return
        L1f:
            okhttp3.Challenge r9 = new okhttp3.Challenge
            java.util.Map r0 = java.util.Collections.emptyMap()
            r9.<init>(r1, r0)
            r8.add(r9)
            return
        L2c:
            r4 = 61
            int r5 = skipAll(r9, r4)
            boolean r6 = skipWhitespaceAndCommas(r9)
            if (r2 != 0) goto L63
            if (r6 != 0) goto L40
            boolean r2 = r9.exhausted()
            if (r2 == 0) goto L63
        L40:
            okhttp3.Challenge r2 = new okhttp3.Challenge
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            java.lang.String r3 = repeat(r4, r5)
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            java.util.Map r3 = java.util.Collections.singletonMap(r6, r3)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1_renamed
        L63:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = skipAll(r9, r4)
            int r5 = r5 + r6
        L6d:
            if (r3 != 0) goto L7e
            java.lang.String r3 = readToken(r9)
            boolean r5 = skipWhitespaceAndCommas(r9)
            if (r5 == 0) goto L7a
            goto L80
        L7a:
            int r5 = skipAll(r9, r4)
        L7e:
            if (r5 != 0) goto L8b
        L80:
            okhttp3.Challenge r4 = new okhttp3.Challenge
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2_renamed
        L8b:
            r6 = 1
            if (r5 <= r6) goto L8f
            return
        L8f:
            boolean r6 = skipWhitespaceAndCommas(r9)
            if (r6 == 0) goto L96
            return
        L96:
            boolean r6 = r9.exhausted()
            if (r6 != 0) goto Lab
            r6 = 0
            byte r6 = r9.getByte(r6)
            r7 = 34
            if (r6 != r7) goto Lab
            java.lang.String r6 = readQuotedString(r9)
            goto Laf
        Lab:
            java.lang.String r6 = readToken(r9)
        Laf:
            if (r6 != 0) goto Lb2
            return
        Lb2:
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lbb
            return
        Lbb:
            boolean r3 = skipWhitespaceAndCommas(r9)
            if (r3 != 0) goto Lc8
            boolean r3 = r9.exhausted()
            if (r3 != 0) goto Lc8
            return
        Lc8:
            r3 = r0
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.parseChallengeHeader(java.util.List, okio.Buffer):void");
    }

    private static boolean skipWhitespaceAndCommas(okio.Buffer buffer) {
        boolean z_renamed = false;
        while (!buffer.exhausted()) {
            byte b2 = buffer.getByte(0L);
            if (b2 != 44) {
                if (b2 != 32 && b2 != 9) {
                    break;
                }
                buffer.readByte();
            } else {
                buffer.readByte();
                z_renamed = true;
            }
        }
        return z_renamed;
    }

    private static int skipAll(okio.Buffer buffer, byte b2) {
        int i_renamed = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b2) {
            i_renamed++;
            buffer.readByte();
        }
        return i_renamed;
    }

    private static java.lang.String readQuotedString(okio.Buffer buffer) {
        if (buffer.readByte() != 34) {
            throw new java.lang.IllegalArgumentException();
        }
        okio.Buffer buffer2 = new okio.Buffer();
        while (true) {
            long jIndexOfElement = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
            if (jIndexOfElement == -1) {
                return null;
            }
            if (buffer.getByte(jIndexOfElement) == 34) {
                buffer2.write(buffer, jIndexOfElement);
                buffer.readByte();
                return buffer2.readUtf8();
            }
            if (buffer.size() == jIndexOfElement + 1) {
                return null;
            }
            buffer2.write(buffer, jIndexOfElement);
            buffer.readByte();
            buffer2.write(buffer, 1L);
        }
    }

    private static java.lang.String readToken(okio.Buffer buffer) {
        try {
            long jIndexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
            if (jIndexOfElement == -1) {
                jIndexOfElement = buffer.size();
            }
            if (jIndexOfElement != 0) {
                return buffer.readUtf8(jIndexOfElement);
            }
            return null;
        } catch (java.io.EOFException unused) {
            throw new java.lang.AssertionError();
        }
    }

    private static java.lang.String repeat(char c2, int i_renamed) {
        char[] cArr = new char[i_renamed];
        java.util.Arrays.fill(cArr, c2);
        return new java.lang.String(cArr);
    }

    public static void receiveHeaders(okhttp3.CookieJar cookieJar, okhttp3.HttpUrl httpUrl, okhttp3.Headers headers) {
        if (cookieJar == okhttp3.CookieJar.NO_COOKIES) {
            return;
        }
        java.util.List<okhttp3.Cookie> all = okhttp3.Cookie.parseAll(httpUrl, headers);
        if (all.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, all);
    }

    public static boolean hasBody(okhttp3.Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int iCode = response.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) ? false : true;
    }

    public static int skipUntil(java.lang.String str, int i_renamed, java.lang.String str2) {
        while (i_renamed < str.length() && str2.indexOf(str.charAt(i_renamed)) == -1) {
            i_renamed++;
        }
        return i_renamed;
    }

    public static int skipWhitespace(java.lang.String str, int i_renamed) {
        char cCharAt;
        while (i_renamed < str.length() && ((cCharAt = str.charAt(i_renamed)) == ' ' || cCharAt == '\t_renamed')) {
            i_renamed++;
        }
        return i_renamed;
    }

    public static int parseSeconds(java.lang.String str, int i_renamed) {
        try {
            long j_renamed = java.lang.Long.parseLong(str);
            if (j_renamed > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j_renamed < 0) {
                return 0;
            }
            return (int) j_renamed;
        } catch (java.lang.NumberFormatException unused) {
            return i_renamed;
        }
    }
}

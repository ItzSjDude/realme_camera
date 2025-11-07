package okhttp3;

/* loaded from: classes2.dex */
public final class Cookie {
    private final java.lang.String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final java.lang.String name;
    private final java.lang.String path;
    private final boolean persistent;
    private final boolean secure;
    private final java.lang.String value;
    private static final java.util.regex.Pattern YEAR_PATTERN = java.util.regex.Pattern.compile("(\\d_renamed{2,4})[^\\d_renamed]*");
    private static final java.util.regex.Pattern MONTH_PATTERN = java.util.regex.Pattern.compile("(?i_renamed)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final java.util.regex.Pattern DAY_OF_MONTH_PATTERN = java.util.regex.Pattern.compile("(\\d_renamed{1,2})[^\\d_renamed]*");
    private static final java.util.regex.Pattern TIME_PATTERN = java.util.regex.Pattern.compile("(\\d_renamed{1,2}):(\\d_renamed{1,2}):(\\d_renamed{1,2})[^\\d_renamed]*");

    private Cookie(java.lang.String str, java.lang.String str2, long j_renamed, java.lang.String str3, java.lang.String str4, boolean z_renamed, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j_renamed;
        this.domain = str3;
        this.path = str4;
        this.secure = z_renamed;
        this.httpOnly = z2;
        this.hostOnly = z3;
        this.persistent = z4;
    }

    Cookie(okhttp3.Cookie.Builder builder) {
        if (builder.name == null) {
            throw new java.lang.NullPointerException("builder.name == null");
        }
        if (builder.value == null) {
            throw new java.lang.NullPointerException("builder.value == null");
        }
        if (builder.domain == null) {
            throw new java.lang.NullPointerException("builder.domain == null");
        }
        this.name = builder.name;
        this.value = builder.value;
        this.expiresAt = builder.expiresAt;
        this.domain = builder.domain;
        this.path = builder.path;
        this.secure = builder.secure;
        this.httpOnly = builder.httpOnly;
        this.persistent = builder.persistent;
        this.hostOnly = builder.hostOnly;
    }

    public java.lang.String name() {
        return this.name;
    }

    public java.lang.String value() {
        return this.value;
    }

    public boolean persistent() {
        return this.persistent;
    }

    public long expiresAt() {
        return this.expiresAt;
    }

    public boolean hostOnly() {
        return this.hostOnly;
    }

    public java.lang.String domain() {
        return this.domain;
    }

    public java.lang.String path() {
        return this.path;
    }

    public boolean httpOnly() {
        return this.httpOnly;
    }

    public boolean secure() {
        return this.secure;
    }

    public boolean matches(okhttp3.HttpUrl httpUrl) {
        boolean zDomainMatch;
        if (this.hostOnly) {
            zDomainMatch = httpUrl.host().equals(this.domain);
        } else {
            zDomainMatch = domainMatch(httpUrl.host(), this.domain);
        }
        if (zDomainMatch && pathMatch(httpUrl, this.path)) {
            return !this.secure || httpUrl.isHttps();
        }
        return false;
    }

    private static boolean domainMatch(java.lang.String str, java.lang.String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !okhttp3.internal.Util.verifyAsIpAddress(str);
    }

    private static boolean pathMatch(okhttp3.HttpUrl httpUrl, java.lang.String str) {
        java.lang.String strEncodedPath = httpUrl.encodedPath();
        if (strEncodedPath.equals(str)) {
            return true;
        }
        if (strEncodedPath.startsWith(str)) {
            return str.endsWith("/") || strEncodedPath.charAt(str.length()) == '/';
        }
        return false;
    }

    @javax.annotation.Nullable
    public static okhttp3.Cookie parse(okhttp3.HttpUrl httpUrl, java.lang.String str) {
        return parse(java.lang.System.currentTimeMillis(), httpUrl, str);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:43:0x00c8 A_renamed[PHI: r0
      0x00c8: PHI (r0v16 long) = (r0v2 long), (r0v6 long) binds: [B_renamed:42:0x00c6, B_renamed:53:0x00e8] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static okhttp3.Cookie parse(long r24, okhttp3.HttpUrl r26, java.lang.String r27) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.parse(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
    }

    private static long parseExpires(java.lang.String str, int i_renamed, int i2) throws java.lang.NumberFormatException {
        int iDateCharacterOffset = dateCharacterOffset(str, i_renamed, i2, false);
        java.util.regex.Matcher matcher = TIME_PATTERN.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int iIndexOf = -1;
        int i6 = -1;
        int i7 = -1;
        while (iDateCharacterOffset < i2) {
            int iDateCharacterOffset2 = dateCharacterOffset(str, iDateCharacterOffset + 1, i2, true);
            matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
            if (i4 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                int i8 = java.lang.Integer.parseInt(matcher.group(1));
                int i9 = java.lang.Integer.parseInt(matcher.group(2));
                i7 = java.lang.Integer.parseInt(matcher.group(3));
                i6 = i9;
                i4 = i8;
            } else if (i5 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                i5 = java.lang.Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1 && matcher.usePattern(MONTH_PATTERN).matches()) {
                iIndexOf = MONTH_PATTERN.pattern().indexOf(matcher.group(1).toLowerCase(java.util.Locale.US)) / 4;
            } else if (i3 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                i3 = java.lang.Integer.parseInt(matcher.group(1));
            }
            iDateCharacterOffset = dateCharacterOffset(str, iDateCharacterOffset2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new java.lang.IllegalArgumentException();
        }
        if (iIndexOf == -1) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i5 < 1 || i5 > 31) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 23) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i6 < 0 || i6 > 59) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i7 < 0 || i7 > 59) {
            throw new java.lang.IllegalArgumentException();
        }
        java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar(okhttp3.internal.Util.UTC);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i3);
        gregorianCalendar.set(2, iIndexOf - 1);
        gregorianCalendar.set(5, i5);
        gregorianCalendar.set(11, i4);
        gregorianCalendar.set(12, i6);
        gregorianCalendar.set(13, i7);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    private static int dateCharacterOffset(java.lang.String str, int i_renamed, int i2, boolean z_renamed) {
        while (i_renamed < i2) {
            char cCharAt = str.charAt(i_renamed);
            if (((cCharAt < ' ' && cCharAt != '\t_renamed') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a_renamed' && cCharAt <= 'z_renamed') || ((cCharAt >= 'A_renamed' && cCharAt <= 'Z_renamed') || cCharAt == ':'))) == (!z_renamed)) {
                return i_renamed;
            }
            i_renamed++;
        }
        return i2;
    }

    private static long parseMaxAge(java.lang.String str) throws java.lang.NumberFormatException {
        try {
            long j_renamed = java.lang.Long.parseLong(str);
            if (j_renamed <= 0) {
                return Long.MIN_VALUE;
            }
            return j_renamed;
        } catch (java.lang.NumberFormatException e_renamed) {
            if (str.matches("-?\\d_renamed+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e_renamed;
        }
    }

    private static java.lang.String parseDomain(java.lang.String str) {
        if (str.endsWith(".")) {
            throw new java.lang.IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        java.lang.String strCanonicalizeHost = okhttp3.internal.Util.canonicalizeHost(str);
        if (strCanonicalizeHost != null) {
            return strCanonicalizeHost;
        }
        throw new java.lang.IllegalArgumentException();
    }

    public static java.util.List<okhttp3.Cookie> parseAll(okhttp3.HttpUrl httpUrl, okhttp3.Headers headers) {
        java.util.List<java.lang.String> listValues = headers.values("Set-Cookie");
        int size = listValues.size();
        java.util.ArrayList arrayList = null;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            okhttp3.Cookie cookie = parse(httpUrl, listValues.get(i_renamed));
            if (cookie != null) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList();
                }
                arrayList.add(cookie);
            }
        }
        if (arrayList != null) {
            return java.util.Collections.unmodifiableList(arrayList);
        }
        return java.util.Collections.emptyList();
    }

    public static final class Builder {

        @javax.annotation.Nullable
        java.lang.String domain;
        boolean hostOnly;
        boolean httpOnly;

        @javax.annotation.Nullable
        java.lang.String name;
        boolean persistent;
        boolean secure;

        @javax.annotation.Nullable
        java.lang.String value;
        long expiresAt = okhttp3.internal.http.HttpDate.MAX_DATE;
        java.lang.String path = "/";

        public okhttp3.Cookie.Builder name(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            if (!str.trim().equals(str)) {
                throw new java.lang.IllegalArgumentException("name is_renamed not trimmed");
            }
            this.name = str;
            return this;
        }

        public okhttp3.Cookie.Builder value(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("value == null");
            }
            if (!str.trim().equals(str)) {
                throw new java.lang.IllegalArgumentException("value is_renamed not trimmed");
            }
            this.value = str;
            return this;
        }

        public okhttp3.Cookie.Builder expiresAt(long j_renamed) {
            if (j_renamed <= 0) {
                j_renamed = Long.MIN_VALUE;
            }
            if (j_renamed > okhttp3.internal.http.HttpDate.MAX_DATE) {
                j_renamed = 253402300799999L;
            }
            this.expiresAt = j_renamed;
            this.persistent = true;
            return this;
        }

        public okhttp3.Cookie.Builder domain(java.lang.String str) {
            return domain(str, false);
        }

        public okhttp3.Cookie.Builder hostOnlyDomain(java.lang.String str) {
            return domain(str, true);
        }

        private okhttp3.Cookie.Builder domain(java.lang.String str, boolean z_renamed) {
            if (str == null) {
                throw new java.lang.NullPointerException("domain == null");
            }
            java.lang.String strCanonicalizeHost = okhttp3.internal.Util.canonicalizeHost(str);
            if (strCanonicalizeHost == null) {
                throw new java.lang.IllegalArgumentException("unexpected domain: " + str);
            }
            this.domain = strCanonicalizeHost;
            this.hostOnly = z_renamed;
            return this;
        }

        public okhttp3.Cookie.Builder path(java.lang.String str) {
            if (!str.startsWith("/")) {
                throw new java.lang.IllegalArgumentException("path must start with '/'");
            }
            this.path = str;
            return this;
        }

        public okhttp3.Cookie.Builder secure() {
            this.secure = true;
            return this;
        }

        public okhttp3.Cookie.Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public okhttp3.Cookie build() {
            return new okhttp3.Cookie(this);
        }
    }

    public java.lang.String toString() {
        return toString(false);
    }

    java.lang.String toString(boolean z_renamed) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(okhttp3.internal.http.HttpDate.format(new java.util.Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z_renamed) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (!(obj instanceof okhttp3.Cookie)) {
            return false;
        }
        okhttp3.Cookie cookie = (okhttp3.Cookie) obj;
        return cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly;
    }

    public int hashCode() {
        int iHashCode = (((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31;
        long j_renamed = this.expiresAt;
        return ((((((((iHashCode + ((int) (j_renamed ^ (j_renamed >>> 32)))) * 31) + (!this.secure ? 1 : 0)) * 31) + (!this.httpOnly ? 1 : 0)) * 31) + (!this.persistent ? 1 : 0)) * 31) + (!this.hostOnly ? 1 : 0);
    }
}

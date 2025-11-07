package okhttp3;

/* loaded from: classes2.dex */
public final class HttpUrl {
    static final java.lang.String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final java.lang.String FRAGMENT_ENCODE_SET = "";
    static final java.lang.String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A_renamed', 'B_renamed', 'C_renamed', 'D_renamed', 'E_renamed', 'F_renamed'};
    static final java.lang.String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final java.lang.String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final java.lang.String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    static final java.lang.String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    static final java.lang.String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    static final java.lang.String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    static final java.lang.String QUERY_ENCODE_SET = " \"'<>#";
    static final java.lang.String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @javax.annotation.Nullable
    private final java.lang.String fragment;
    final java.lang.String host;
    private final java.lang.String password;
    private final java.util.List<java.lang.String> pathSegments;
    final int port;

    @javax.annotation.Nullable
    private final java.util.List<java.lang.String> queryNamesAndValues;
    final java.lang.String scheme;
    private final java.lang.String url;
    private final java.lang.String username;

    HttpUrl(okhttp3.HttpUrl.Builder builder) {
        this.scheme = builder.scheme;
        this.username = percentDecode(builder.encodedUsername, false);
        this.password = percentDecode(builder.encodedPassword, false);
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.pathSegments = percentDecode(builder.encodedPathSegments, false);
        this.queryNamesAndValues = builder.encodedQueryNamesAndValues != null ? percentDecode(builder.encodedQueryNamesAndValues, true) : null;
        this.fragment = builder.encodedFragment != null ? percentDecode(builder.encodedFragment, false) : null;
        this.url = builder.toString();
    }

    public java.net.URL url() {
        try {
            return new java.net.URL(this.url);
        } catch (java.net.MalformedURLException e_renamed) {
            throw new java.lang.RuntimeException(e_renamed);
        }
    }

    public java.net.URI uri() {
        java.lang.String string = newBuilder().reencodeForUri().toString();
        try {
            return new java.net.URI(string);
        } catch (java.net.URISyntaxException e_renamed) {
            try {
                return java.net.URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p_renamed{javaWhitespace}]", ""));
            } catch (java.lang.Exception unused) {
                throw new java.lang.RuntimeException(e_renamed);
            }
        }
    }

    public java.lang.String scheme() {
        return this.scheme;
    }

    public boolean isHttps() {
        return this.scheme.equals("https");
    }

    public java.lang.String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        int length = this.scheme.length() + 3;
        java.lang.String str = this.url;
        return this.url.substring(length, okhttp3.internal.Util.delimiterOffset(str, length, str.length(), ":@"));
    }

    public java.lang.String username() {
        return this.username;
    }

    public java.lang.String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, this.url.indexOf(64));
    }

    public java.lang.String password() {
        return this.password;
    }

    public java.lang.String host() {
        return this.host;
    }

    public int port() {
        return this.port;
    }

    public static int defaultPort(java.lang.String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public int pathSize() {
        return this.pathSegments.size();
    }

    public java.lang.String encodedPath() {
        int iIndexOf = this.url.indexOf(47, this.scheme.length() + 3);
        java.lang.String str = this.url;
        return this.url.substring(iIndexOf, okhttp3.internal.Util.delimiterOffset(str, iIndexOf, str.length(), "?#"));
    }

    static void pathSegmentsToString(java.lang.StringBuilder sb, java.util.List<java.lang.String> list) {
        int size = list.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            sb.append('/');
            sb.append(list.get(i_renamed));
        }
    }

    public java.util.List<java.lang.String> encodedPathSegments() {
        int iIndexOf = this.url.indexOf(47, this.scheme.length() + 3);
        java.lang.String str = this.url;
        int iDelimiterOffset = okhttp3.internal.Util.delimiterOffset(str, iIndexOf, str.length(), "?#");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (iIndexOf < iDelimiterOffset) {
            int i_renamed = iIndexOf + 1;
            int iDelimiterOffset2 = okhttp3.internal.Util.delimiterOffset(this.url, i_renamed, iDelimiterOffset, '/');
            arrayList.add(this.url.substring(i_renamed, iDelimiterOffset2));
            iIndexOf = iDelimiterOffset2;
        }
        return arrayList;
    }

    public java.util.List<java.lang.String> pathSegments() {
        return this.pathSegments;
    }

    @javax.annotation.Nullable
    public java.lang.String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iIndexOf = this.url.indexOf(63) + 1;
        java.lang.String str = this.url;
        return this.url.substring(iIndexOf, okhttp3.internal.Util.delimiterOffset(str, iIndexOf, str.length(), '#'));
    }

    static void namesAndValuesToQueryString(java.lang.StringBuilder sb, java.util.List<java.lang.String> list) {
        int size = list.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed += 2) {
            java.lang.String str = list.get(i_renamed);
            java.lang.String str2 = list.get(i_renamed + 1);
            if (i_renamed > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static java.util.List<java.lang.String> queryStringToNamesAndValues(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i_renamed = 0;
        while (i_renamed <= str.length()) {
            int iIndexOf = str.indexOf(38, i_renamed);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i_renamed);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i_renamed, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i_renamed, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i_renamed = iIndexOf + 1;
        }
        return arrayList;
    }

    @javax.annotation.Nullable
    public java.lang.String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        namesAndValuesToQueryString(sb, this.queryNamesAndValues);
        return sb.toString();
    }

    public int querySize() {
        java.util.List<java.lang.String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    @javax.annotation.Nullable
    public java.lang.String queryParameter(java.lang.String str) {
        java.util.List<java.lang.String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed += 2) {
            if (str.equals(this.queryNamesAndValues.get(i_renamed))) {
                return this.queryNamesAndValues.get(i_renamed + 1);
            }
        }
        return null;
    }

    public java.util.Set<java.lang.String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return java.util.Collections.emptySet();
        }
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        int size = this.queryNamesAndValues.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed += 2) {
            linkedHashSet.add(this.queryNamesAndValues.get(i_renamed));
        }
        return java.util.Collections.unmodifiableSet(linkedHashSet);
    }

    public java.util.List<java.lang.String> queryParameterValues(java.lang.String str) {
        if (this.queryNamesAndValues == null) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int size = this.queryNamesAndValues.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed += 2) {
            if (str.equals(this.queryNamesAndValues.get(i_renamed))) {
                arrayList.add(this.queryNamesAndValues.get(i_renamed + 1));
            }
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public java.lang.String queryParameterName(int i_renamed) {
        java.util.List<java.lang.String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return list.get(i_renamed * 2);
    }

    public java.lang.String queryParameterValue(int i_renamed) {
        java.util.List<java.lang.String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return list.get((i_renamed * 2) + 1);
    }

    @javax.annotation.Nullable
    public java.lang.String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(this.url.indexOf(35) + 1);
    }

    @javax.annotation.Nullable
    public java.lang.String fragment() {
        return this.fragment;
    }

    public java.lang.String redact() {
        return newBuilder("/...").username("").password("").build().toString();
    }

    @javax.annotation.Nullable
    public okhttp3.HttpUrl resolve(java.lang.String str) {
        okhttp3.HttpUrl.Builder builderNewBuilder = newBuilder(str);
        if (builderNewBuilder != null) {
            return builderNewBuilder.build();
        }
        return null;
    }

    public okhttp3.HttpUrl.Builder newBuilder() {
        okhttp3.HttpUrl.Builder builder = new okhttp3.HttpUrl.Builder();
        builder.scheme = this.scheme;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        builder.port = this.port != defaultPort(this.scheme) ? this.port : -1;
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.encodedFragment = encodedFragment();
        return builder;
    }

    @javax.annotation.Nullable
    public okhttp3.HttpUrl.Builder newBuilder(java.lang.String str) {
        try {
            return new okhttp3.HttpUrl.Builder().parse(this, str);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    @javax.annotation.Nullable
    public static okhttp3.HttpUrl parse(java.lang.String str) {
        try {
            return get(str);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    public static okhttp3.HttpUrl get(java.lang.String str) {
        return new okhttp3.HttpUrl.Builder().parse(null, str).build();
    }

    @javax.annotation.Nullable
    public static okhttp3.HttpUrl get(java.net.URL url) {
        return parse(url.toString());
    }

    @javax.annotation.Nullable
    public static okhttp3.HttpUrl get(java.net.URI uri) {
        return parse(uri.toString());
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        return (obj instanceof okhttp3.HttpUrl) && ((okhttp3.HttpUrl) obj).url.equals(this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public java.lang.String toString() {
        return this.url;
    }

    @javax.annotation.Nullable
    public java.lang.String topPrivateDomain() {
        if (okhttp3.internal.Util.verifyAsIpAddress(this.host)) {
            return null;
        }
        return okhttp3.internal.publicsuffix.PublicSuffixDatabase.get().getEffectiveTldPlusOne(this.host);
    }

    public static final class Builder {
        static final java.lang.String INVALID_HOST = "Invalid URL host";

        @javax.annotation.Nullable
        java.lang.String encodedFragment;

        @javax.annotation.Nullable
        java.util.List<java.lang.String> encodedQueryNamesAndValues;

        @javax.annotation.Nullable
        java.lang.String host;

        @javax.annotation.Nullable
        java.lang.String scheme;
        java.lang.String encodedUsername = "";
        java.lang.String encodedPassword = "";
        int port = -1;
        final java.util.List<java.lang.String> encodedPathSegments = new java.util.ArrayList();

        public Builder() {
            this.encodedPathSegments.add("");
        }

        public okhttp3.HttpUrl.Builder scheme(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.scheme = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.scheme = "https";
            } else {
                throw new java.lang.IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public okhttp3.HttpUrl.Builder username(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("username == null");
            }
            this.encodedUsername = okhttp3.HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public okhttp3.HttpUrl.Builder encodedUsername(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedUsername == null");
            }
            this.encodedUsername = okhttp3.HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public okhttp3.HttpUrl.Builder password(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("password == null");
            }
            this.encodedPassword = okhttp3.HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public okhttp3.HttpUrl.Builder encodedPassword(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedPassword == null");
            }
            this.encodedPassword = okhttp3.HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public okhttp3.HttpUrl.Builder host(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("host == null");
            }
            java.lang.String strCanonicalizeHost = canonicalizeHost(str, 0, str.length());
            if (strCanonicalizeHost == null) {
                throw new java.lang.IllegalArgumentException("unexpected host: " + str);
            }
            this.host = strCanonicalizeHost;
            return this;
        }

        public okhttp3.HttpUrl.Builder port(int i_renamed) {
            if (i_renamed <= 0 || i_renamed > 65535) {
                throw new java.lang.IllegalArgumentException("unexpected port: " + i_renamed);
            }
            this.port = i_renamed;
            return this;
        }

        int effectivePort() {
            int i_renamed = this.port;
            return i_renamed != -1 ? i_renamed : okhttp3.HttpUrl.defaultPort(this.scheme);
        }

        public okhttp3.HttpUrl.Builder addPathSegment(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("pathSegment == null");
            }
            push(str, 0, str.length(), false, false);
            return this;
        }

        public okhttp3.HttpUrl.Builder addPathSegments(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("pathSegments == null");
            }
            return addPathSegments(str, false);
        }

        public okhttp3.HttpUrl.Builder addEncodedPathSegment(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedPathSegment == null");
            }
            push(str, 0, str.length(), false, true);
            return this;
        }

        public okhttp3.HttpUrl.Builder addEncodedPathSegments(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedPathSegments == null");
            }
            return addPathSegments(str, true);
        }

        private okhttp3.HttpUrl.Builder addPathSegments(java.lang.String str, boolean z_renamed) {
            int i_renamed = 0;
            do {
                int iDelimiterOffset = okhttp3.internal.Util.delimiterOffset(str, i_renamed, str.length(), "/\\");
                push(str, i_renamed, iDelimiterOffset, iDelimiterOffset < str.length(), z_renamed);
                i_renamed = iDelimiterOffset + 1;
            } while (i_renamed <= str.length());
            return this;
        }

        public okhttp3.HttpUrl.Builder setPathSegment(int i_renamed, java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("pathSegment == null");
            }
            java.lang.String strCanonicalize = okhttp3.HttpUrl.canonicalize(str, 0, str.length(), okhttp3.HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, true, null);
            if (isDot(strCanonicalize) || isDotDot(strCanonicalize)) {
                throw new java.lang.IllegalArgumentException("unexpected path segment: " + str);
            }
            this.encodedPathSegments.set(i_renamed, strCanonicalize);
            return this;
        }

        public okhttp3.HttpUrl.Builder setEncodedPathSegment(int i_renamed, java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedPathSegment == null");
            }
            java.lang.String strCanonicalize = okhttp3.HttpUrl.canonicalize(str, 0, str.length(), okhttp3.HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, true, null);
            this.encodedPathSegments.set(i_renamed, strCanonicalize);
            if (!isDot(strCanonicalize) && !isDotDot(strCanonicalize)) {
                return this;
            }
            throw new java.lang.IllegalArgumentException("unexpected path segment: " + str);
        }

        public okhttp3.HttpUrl.Builder removePathSegment(int i_renamed) {
            this.encodedPathSegments.remove(i_renamed);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public okhttp3.HttpUrl.Builder encodedPath(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedPath == null");
            }
            if (!str.startsWith("/")) {
                throw new java.lang.IllegalArgumentException("unexpected encodedPath: " + str);
            }
            resolvePath(str, 0, str.length());
            return this;
        }

        public okhttp3.HttpUrl.Builder query(@javax.annotation.Nullable java.lang.String str) {
            this.encodedQueryNamesAndValues = str != null ? okhttp3.HttpUrl.queryStringToNamesAndValues(okhttp3.HttpUrl.canonicalize(str, okhttp3.HttpUrl.QUERY_ENCODE_SET, false, false, true, true)) : null;
            return this;
        }

        public okhttp3.HttpUrl.Builder encodedQuery(@javax.annotation.Nullable java.lang.String str) {
            this.encodedQueryNamesAndValues = str != null ? okhttp3.HttpUrl.queryStringToNamesAndValues(okhttp3.HttpUrl.canonicalize(str, okhttp3.HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        public okhttp3.HttpUrl.Builder addQueryParameter(java.lang.String str, @javax.annotation.Nullable java.lang.String str2) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new java.util.ArrayList();
            }
            this.encodedQueryNamesAndValues.add(okhttp3.HttpUrl.canonicalize(str, okhttp3.HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
            this.encodedQueryNamesAndValues.add(str2 != null ? okhttp3.HttpUrl.canonicalize(str2, okhttp3.HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true) : null);
            return this;
        }

        public okhttp3.HttpUrl.Builder addEncodedQueryParameter(java.lang.String str, @javax.annotation.Nullable java.lang.String str2) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedName == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new java.util.ArrayList();
            }
            this.encodedQueryNamesAndValues.add(okhttp3.HttpUrl.canonicalize(str, okhttp3.HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
            this.encodedQueryNamesAndValues.add(str2 != null ? okhttp3.HttpUrl.canonicalize(str2, okhttp3.HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true) : null);
            return this;
        }

        public okhttp3.HttpUrl.Builder setQueryParameter(java.lang.String str, @javax.annotation.Nullable java.lang.String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public okhttp3.HttpUrl.Builder setEncodedQueryParameter(java.lang.String str, @javax.annotation.Nullable java.lang.String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public okhttp3.HttpUrl.Builder removeAllQueryParameters(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(okhttp3.HttpUrl.canonicalize(str, okhttp3.HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
            return this;
        }

        public okhttp3.HttpUrl.Builder removeAllEncodedQueryParameters(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedName == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(okhttp3.HttpUrl.canonicalize(str, okhttp3.HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
            return this;
        }

        private void removeAllCanonicalQueryParameters(java.lang.String str) {
            for (int size = this.encodedQueryNamesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.encodedQueryNamesAndValues.get(size))) {
                    this.encodedQueryNamesAndValues.remove(size + 1);
                    this.encodedQueryNamesAndValues.remove(size);
                    if (this.encodedQueryNamesAndValues.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
            }
        }

        public okhttp3.HttpUrl.Builder fragment(@javax.annotation.Nullable java.lang.String str) {
            this.encodedFragment = str != null ? okhttp3.HttpUrl.canonicalize(str, "", false, false, false, false) : null;
            return this;
        }

        public okhttp3.HttpUrl.Builder encodedFragment(@javax.annotation.Nullable java.lang.String str) {
            this.encodedFragment = str != null ? okhttp3.HttpUrl.canonicalize(str, "", true, false, false, false) : null;
            return this;
        }

        okhttp3.HttpUrl.Builder reencodeForUri() {
            int size = this.encodedPathSegments.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.encodedPathSegments.set(i_renamed, okhttp3.HttpUrl.canonicalize(this.encodedPathSegments.get(i_renamed), okhttp3.HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            }
            java.util.List<java.lang.String> list = this.encodedQueryNamesAndValues;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    java.lang.String str = this.encodedQueryNamesAndValues.get(i2);
                    if (str != null) {
                        this.encodedQueryNamesAndValues.set(i2, okhttp3.HttpUrl.canonicalize(str, okhttp3.HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            java.lang.String str2 = this.encodedFragment;
            if (str2 != null) {
                this.encodedFragment = okhttp3.HttpUrl.canonicalize(str2, okhttp3.HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        public okhttp3.HttpUrl build() {
            if (this.scheme == null) {
                throw new java.lang.IllegalStateException("scheme == null");
            }
            if (this.host == null) {
                throw new java.lang.IllegalStateException("host == null");
            }
            return new okhttp3.HttpUrl(this);
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.encodedUsername.isEmpty() || !this.encodedPassword.isEmpty()) {
                sb.append(this.encodedUsername);
                if (!this.encodedPassword.isEmpty()) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            java.lang.String str2 = this.host;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int iEffectivePort = effectivePort();
                java.lang.String str3 = this.scheme;
                if (str3 == null || iEffectivePort != okhttp3.HttpUrl.defaultPort(str3)) {
                    sb.append(':');
                    sb.append(iEffectivePort);
                }
            }
            okhttp3.HttpUrl.pathSegmentsToString(sb, this.encodedPathSegments);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                okhttp3.HttpUrl.namesAndValuesToQueryString(sb, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }

        okhttp3.HttpUrl.Builder parse(@javax.annotation.Nullable okhttp3.HttpUrl httpUrl, java.lang.String str) {
            int iDelimiterOffset;
            int i_renamed;
            int iSkipLeadingAsciiWhitespace = okhttp3.internal.Util.skipLeadingAsciiWhitespace(str, 0, str.length());
            int iSkipTrailingAsciiWhitespace = okhttp3.internal.Util.skipTrailingAsciiWhitespace(str, iSkipLeadingAsciiWhitespace, str.length());
            int iSchemeDelimiterOffset = schemeDelimiterOffset(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace);
            if (iSchemeDelimiterOffset != -1) {
                if (str.regionMatches(true, iSkipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    this.scheme = "https";
                    iSkipLeadingAsciiWhitespace += 6;
                } else if (str.regionMatches(true, iSkipLeadingAsciiWhitespace, "http:", 0, 5)) {
                    this.scheme = "http";
                    iSkipLeadingAsciiWhitespace += 5;
                } else {
                    throw new java.lang.IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, iSchemeDelimiterOffset) + "'");
                }
            } else if (httpUrl != null) {
                this.scheme = httpUrl.scheme;
            } else {
                throw new java.lang.IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int iSlashCount = slashCount(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace);
            char c2 = '?';
            char c3 = '#';
            if (iSlashCount >= 2 || httpUrl == null || !httpUrl.scheme.equals(this.scheme)) {
                boolean z_renamed = false;
                boolean z2 = false;
                int i2 = iSkipLeadingAsciiWhitespace + iSlashCount;
                while (true) {
                    iDelimiterOffset = okhttp3.internal.Util.delimiterOffset(str, i2, iSkipTrailingAsciiWhitespace, "@/\\?#");
                    char cCharAt = iDelimiterOffset != iSkipTrailingAsciiWhitespace ? str.charAt(iDelimiterOffset) : (char) 65535;
                    if (cCharAt == 65535 || cCharAt == c3 || cCharAt == '/' || cCharAt == '\\' || cCharAt == c2) {
                        break;
                    }
                    if (cCharAt == '@') {
                        if (!z_renamed) {
                            int iDelimiterOffset2 = okhttp3.internal.Util.delimiterOffset(str, i2, iDelimiterOffset, ':');
                            i_renamed = iDelimiterOffset;
                            java.lang.String strCanonicalize = okhttp3.HttpUrl.canonicalize(str, i2, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strCanonicalize = this.encodedUsername + "%40" + strCanonicalize;
                            }
                            this.encodedUsername = strCanonicalize;
                            if (iDelimiterOffset2 != i_renamed) {
                                this.encodedPassword = okhttp3.HttpUrl.canonicalize(str, iDelimiterOffset2 + 1, i_renamed, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z_renamed = true;
                            }
                            z2 = true;
                        } else {
                            i_renamed = iDelimiterOffset;
                            this.encodedPassword += "%40" + okhttp3.HttpUrl.canonicalize(str, i2, i_renamed, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i_renamed + 1;
                    }
                    c2 = '?';
                    c3 = '#';
                }
                int iPortColonOffset = portColonOffset(str, i2, iDelimiterOffset);
                int i3 = iPortColonOffset + 1;
                if (i3 < iDelimiterOffset) {
                    this.host = canonicalizeHost(str, i2, iPortColonOffset);
                    this.port = parsePort(str, i3, iDelimiterOffset);
                    if (this.port == -1) {
                        throw new java.lang.IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, iDelimiterOffset) + '\"');
                    }
                } else {
                    this.host = canonicalizeHost(str, i2, iPortColonOffset);
                    this.port = okhttp3.HttpUrl.defaultPort(this.scheme);
                }
                if (this.host == null) {
                    throw new java.lang.IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, iPortColonOffset) + '\"');
                }
                iSkipLeadingAsciiWhitespace = iDelimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host;
                this.port = httpUrl.port;
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (iSkipLeadingAsciiWhitespace == iSkipTrailingAsciiWhitespace || str.charAt(iSkipLeadingAsciiWhitespace) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
            }
            int iDelimiterOffset3 = okhttp3.internal.Util.delimiterOffset(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace, "?#");
            resolvePath(str, iSkipLeadingAsciiWhitespace, iDelimiterOffset3);
            if (iDelimiterOffset3 < iSkipTrailingAsciiWhitespace && str.charAt(iDelimiterOffset3) == '?') {
                int iDelimiterOffset4 = okhttp3.internal.Util.delimiterOffset(str, iDelimiterOffset3, iSkipTrailingAsciiWhitespace, '#');
                this.encodedQueryNamesAndValues = okhttp3.HttpUrl.queryStringToNamesAndValues(okhttp3.HttpUrl.canonicalize(str, iDelimiterOffset3 + 1, iDelimiterOffset4, okhttp3.HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                iDelimiterOffset3 = iDelimiterOffset4;
            }
            if (iDelimiterOffset3 < iSkipTrailingAsciiWhitespace && str.charAt(iDelimiterOffset3) == '#') {
                this.encodedFragment = okhttp3.HttpUrl.canonicalize(str, 1 + iDelimiterOffset3, iSkipTrailingAsciiWhitespace, "", true, false, false, false, null);
            }
            return this;
        }

        private void resolvePath(java.lang.String str, int i_renamed, int i2) {
            if (i_renamed == i2) {
                return;
            }
            char cCharAt = str.charAt(i_renamed);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i_renamed++;
            } else {
                java.util.List<java.lang.String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i_renamed;
                if (i3 >= i2) {
                    return;
                }
                i_renamed = okhttp3.internal.Util.delimiterOffset(str, i3, i2, "/\\");
                boolean z_renamed = i_renamed < i2;
                push(str, i3, i_renamed, z_renamed, true);
                if (z_renamed) {
                    i_renamed++;
                }
            }
        }

        private void push(java.lang.String str, int i_renamed, int i2, boolean z_renamed, boolean z2) {
            java.lang.String strCanonicalize = okhttp3.HttpUrl.canonicalize(str, i_renamed, i2, okhttp3.HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, true, null);
            if (isDot(strCanonicalize)) {
                return;
            }
            if (isDotDot(strCanonicalize)) {
                pop();
                return;
            }
            if (this.encodedPathSegments.get(r11.size() - 1).isEmpty()) {
                this.encodedPathSegments.set(r11.size() - 1, strCanonicalize);
            } else {
                this.encodedPathSegments.add(strCanonicalize);
            }
            if (z_renamed) {
                this.encodedPathSegments.add("");
            }
        }

        private boolean isDot(java.lang.String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean isDotDot(java.lang.String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void pop() {
            if (this.encodedPathSegments.remove(r0.size() - 1).isEmpty() && !this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.set(r2.size() - 1, "");
            } else {
                this.encodedPathSegments.add("");
            }
        }

        private static int schemeDelimiterOffset(java.lang.String str, int i_renamed, int i2) {
            if (i2 - i_renamed < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i_renamed);
            if ((cCharAt >= 'a_renamed' && cCharAt <= 'z_renamed') || (cCharAt >= 'A_renamed' && cCharAt <= 'Z_renamed')) {
                while (true) {
                    i_renamed++;
                    if (i_renamed >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i_renamed);
                    if (cCharAt2 < 'a_renamed' || cCharAt2 > 'z_renamed') {
                        if (cCharAt2 < 'A_renamed' || cCharAt2 > 'Z_renamed') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i_renamed;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int slashCount(java.lang.String str, int i_renamed, int i2) {
            int i3 = 0;
            while (i_renamed < i2) {
                char cCharAt = str.charAt(i_renamed);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i_renamed++;
            }
            return i3;
        }

        private static int portColonOffset(java.lang.String str, int i_renamed, int i2) {
            while (i_renamed < i2) {
                char cCharAt = str.charAt(i_renamed);
                if (cCharAt == ':') {
                    return i_renamed;
                }
                if (cCharAt == '[') {
                    do {
                        i_renamed++;
                        if (i_renamed < i2) {
                        }
                    } while (str.charAt(i_renamed) != ']');
                }
                i_renamed++;
            }
            return i2;
        }

        private static java.lang.String canonicalizeHost(java.lang.String str, int i_renamed, int i2) {
            return okhttp3.internal.Util.canonicalizeHost(okhttp3.HttpUrl.percentDecode(str, i_renamed, i2, false));
        }

        private static int parsePort(java.lang.String str, int i_renamed, int i2) throws java.lang.NumberFormatException {
            int i3;
            try {
                i3 = java.lang.Integer.parseInt(okhttp3.HttpUrl.canonicalize(str, i_renamed, i2, "", false, false, false, true, null));
            } catch (java.lang.NumberFormatException unused) {
            }
            if (i3 <= 0 || i3 > 65535) {
                return -1;
            }
            return i3;
        }
    }

    static java.lang.String percentDecode(java.lang.String str, boolean z_renamed) {
        return percentDecode(str, 0, str.length(), z_renamed);
    }

    private java.util.List<java.lang.String> percentDecode(java.util.List<java.lang.String> list, boolean z_renamed) {
        int size = list.size();
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            java.lang.String str = list.get(i_renamed);
            arrayList.add(str != null ? percentDecode(str, z_renamed) : null);
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    static java.lang.String percentDecode(java.lang.String str, int i_renamed, int i2, boolean z_renamed) {
        for (int i3 = i_renamed; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z_renamed)) {
                okio.Buffer buffer = new okio.Buffer();
                buffer.writeUtf8(str, i_renamed, i3);
                percentDecode(buffer, str, i3, i2, z_renamed);
                return buffer.readUtf8();
            }
        }
        return str.substring(i_renamed, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void percentDecode(okio.Buffer r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = okhttp3.internal.Util.decodeHexDigit(r2)
            char r3 = r6.charAt(r1)
            int r3 = okhttp3.internal.Util.decodeHexDigit(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.writeByte(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.writeByte(r1)
            goto L3c
        L39:
            r5.writeUtf8CodePoint(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.percentDecode(okio.Buffer, java.lang.String, int, int, boolean):void");
    }

    static boolean percentEncoded(java.lang.String str, int i_renamed, int i2) {
        int i3 = i_renamed + 2;
        return i3 < i2 && str.charAt(i_renamed) == '%' && okhttp3.internal.Util.decodeHexDigit(str.charAt(i_renamed + 1)) != -1 && okhttp3.internal.Util.decodeHexDigit(str.charAt(i3)) != -1;
    }

    static java.lang.String canonicalize(java.lang.String str, int i_renamed, int i2, java.lang.String str2, boolean z_renamed, boolean z2, boolean z3, boolean z4, java.nio.charset.Charset charset) {
        int iCharCount = i_renamed;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z_renamed && (!z2 || percentEncoded(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += java.lang.Character.charCount(iCodePointAt);
                } else {
                    okio.Buffer buffer = new okio.Buffer();
                    buffer.writeUtf8(str, i_renamed, iCharCount);
                    canonicalize(buffer, str, iCharCount, i2, str2, z_renamed, z2, z3, z4, charset);
                    return buffer.readUtf8();
                }
            } else {
                okio.Buffer buffer2 = new okio.Buffer();
                buffer2.writeUtf8(str, i_renamed, iCharCount);
                canonicalize(buffer2, str, iCharCount, i2, str2, z_renamed, z2, z3, z4, charset);
                return buffer2.readUtf8();
            }
        }
        return str.substring(i_renamed, i2);
    }

    static void canonicalize(okio.Buffer buffer, java.lang.String str, int i_renamed, int i2, java.lang.String str2, boolean z_renamed, boolean z2, boolean z3, boolean z4, java.nio.charset.Charset charset) {
        okio.Buffer buffer2 = null;
        while (i_renamed < i2) {
            int iCodePointAt = str.codePointAt(i_renamed);
            if (!z_renamed || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    buffer.writeUtf8(z_renamed ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z_renamed || (z2 && !percentEncoded(str, i_renamed, i2)))))) {
                    if (buffer2 == null) {
                        buffer2 = new okio.Buffer();
                    }
                    if (charset == null || charset.equals(okhttp3.internal.Util.UTF_8)) {
                        buffer2.writeUtf8CodePoint(iCodePointAt);
                    } else {
                        buffer2.writeString(str, i_renamed, java.lang.Character.charCount(iCodePointAt) + i_renamed, charset);
                    }
                    while (!buffer2.exhausted()) {
                        int i3 = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        buffer.writeByte((int) HEX_DIGITS[(i3 >> 4) & 15]);
                        buffer.writeByte((int) HEX_DIGITS[i3 & 15]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                }
            }
            i_renamed += java.lang.Character.charCount(iCodePointAt);
        }
    }

    static java.lang.String canonicalize(java.lang.String str, java.lang.String str2, boolean z_renamed, boolean z2, boolean z3, boolean z4, java.nio.charset.Charset charset) {
        return canonicalize(str, 0, str.length(), str2, z_renamed, z2, z3, z4, charset);
    }

    static java.lang.String canonicalize(java.lang.String str, java.lang.String str2, boolean z_renamed, boolean z2, boolean z3, boolean z4) {
        return canonicalize(str, 0, str.length(), str2, z_renamed, z2, z3, z4, null);
    }
}

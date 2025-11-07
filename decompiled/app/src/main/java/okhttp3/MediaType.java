package okhttp3;

/* loaded from: classes2.dex */
public final class MediaType {
    private static final java.lang.String QUOTED = "\"([^\"]*)\"";
    private static final java.lang.String TOKEN = "([a_renamed-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";

    @javax.annotation.Nullable
    private final java.lang.String charset;
    private final java.lang.String mediaType;
    private final java.lang.String subtype;
    private final java.lang.String type;
    private static final java.util.regex.Pattern TYPE_SUBTYPE = java.util.regex.Pattern.compile("([a_renamed-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a_renamed-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final java.util.regex.Pattern PARAMETER = java.util.regex.Pattern.compile(";\\s_renamed*(?:([a_renamed-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a_renamed-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    private MediaType(java.lang.String str, java.lang.String str2, java.lang.String str3, @javax.annotation.Nullable java.lang.String str4) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.charset = str4;
    }

    public static okhttp3.MediaType get(java.lang.String str) {
        java.util.regex.Matcher matcher = TYPE_SUBTYPE.matcher(str);
        if (!matcher.lookingAt()) {
            throw new java.lang.IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        java.lang.String lowerCase = matcher.group(1).toLowerCase(java.util.Locale.US);
        java.lang.String lowerCase2 = matcher.group(2).toLowerCase(java.util.Locale.US);
        java.lang.String str2 = null;
        java.util.regex.Matcher matcher2 = PARAMETER.matcher(str);
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                throw new java.lang.IllegalArgumentException("Parameter is_renamed not formatted correctly: \"" + str.substring(iEnd) + "\" for: \"" + str + '\"');
            }
            java.lang.String strGroup = matcher2.group(1);
            if (strGroup != null && strGroup.equalsIgnoreCase("charset")) {
                java.lang.String strGroup2 = matcher2.group(2);
                if (strGroup2 != null) {
                    if (strGroup2.startsWith("'") && strGroup2.endsWith("'") && strGroup2.length() > 2) {
                        strGroup2 = strGroup2.substring(1, strGroup2.length() - 1);
                    }
                } else {
                    strGroup2 = matcher2.group(3);
                }
                if (str2 != null && !strGroup2.equalsIgnoreCase(str2)) {
                    throw new java.lang.IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + strGroup2 + "\" for: \"" + str + '\"');
                }
                str2 = strGroup2;
            }
        }
        return new okhttp3.MediaType(str, lowerCase, lowerCase2, str2);
    }

    @javax.annotation.Nullable
    public static okhttp3.MediaType parse(java.lang.String str) {
        try {
            return get(str);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    public java.lang.String type() {
        return this.type;
    }

    public java.lang.String subtype() {
        return this.subtype;
    }

    @javax.annotation.Nullable
    public java.nio.charset.Charset charset() {
        return charset(null);
    }

    @javax.annotation.Nullable
    public java.nio.charset.Charset charset(@javax.annotation.Nullable java.nio.charset.Charset charset) {
        try {
            return this.charset != null ? java.nio.charset.Charset.forName(this.charset) : charset;
        } catch (java.lang.IllegalArgumentException unused) {
            return charset;
        }
    }

    public java.lang.String toString() {
        return this.mediaType;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        return (obj instanceof okhttp3.MediaType) && ((okhttp3.MediaType) obj).mediaType.equals(this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }
}

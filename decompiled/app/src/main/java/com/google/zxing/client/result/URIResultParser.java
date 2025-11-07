package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class URIResultParser extends com.google.zxing.client.result.ResultParser {
    private static final java.util.regex.Pattern ALLOWED_URI_CHARS_PATTERN = java.util.regex.Pattern.compile("[-._~:/?#\\[\\]@!$&'()*+,;=%A_renamed-Za-z0-9]+");
    private static final java.util.regex.Pattern USER_IN_HOST = java.util.regex.Pattern.compile(":/*([^/@]+)@[^/]+");
    private static final java.util.regex.Pattern URL_WITH_PROTOCOL_PATTERN = java.util.regex.Pattern.compile("[a_renamed-zA-Z_renamed][a_renamed-zA-Z0-9+-.]+:");
    private static final java.util.regex.Pattern URL_WITHOUT_PROTOCOL_PATTERN = java.util.regex.Pattern.compile("([a_renamed-zA-Z0-9\\-]+\\.){1,6}[a_renamed-zA-Z_renamed]{2,}(:\\d_renamed{1,5})?(/|\\?|$)");

    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.URIParsedResult parse(com.google.zxing.Result result) {
        java.lang.String massagedText = getMassagedText(result);
        if (massagedText.startsWith("URL:") || massagedText.startsWith("URI:")) {
            return new com.google.zxing.client.result.URIParsedResult(massagedText.substring(4).trim(), null);
        }
        java.lang.String strTrim = massagedText.trim();
        if (!isBasicallyValidURI(strTrim) || isPossiblyMaliciousURI(strTrim)) {
            return null;
        }
        return new com.google.zxing.client.result.URIParsedResult(strTrim, null);
    }

    static boolean isPossiblyMaliciousURI(java.lang.String str) {
        return !ALLOWED_URI_CHARS_PATTERN.matcher(str).matches() || USER_IN_HOST.matcher(str).find();
    }

    static boolean isBasicallyValidURI(java.lang.String str) {
        if (str.contains(" ")) {
            return false;
        }
        java.util.regex.Matcher matcher = URL_WITH_PROTOCOL_PATTERN.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        java.util.regex.Matcher matcher2 = URL_WITHOUT_PROTOCOL_PATTERN.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }
}

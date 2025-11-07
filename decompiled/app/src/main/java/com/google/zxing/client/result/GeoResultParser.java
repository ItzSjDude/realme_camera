package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class GeoResultParser extends com.google.zxing.client.result.ResultParser {
    private static final java.util.regex.Pattern GEO_URL_PATTERN = java.util.regex.Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.GeoParsedResult parse(com.google.zxing.Result result) throws java.lang.NumberFormatException {
        java.util.regex.Matcher matcher = GEO_URL_PATTERN.matcher(getMassagedText(result));
        if (!matcher.matches()) {
            return null;
        }
        java.lang.String strGroup = matcher.group(4);
        try {
            double d_renamed = java.lang.Double.parseDouble(matcher.group(1));
            if (d_renamed <= 90.0d && d_renamed >= -90.0d) {
                double d2 = java.lang.Double.parseDouble(matcher.group(2));
                if (d2 <= 180.0d && d2 >= -180.0d) {
                    double d3 = 0.0d;
                    if (matcher.group(3) != null) {
                        double d4 = java.lang.Double.parseDouble(matcher.group(3));
                        if (d4 < 0.0d) {
                            return null;
                        }
                        d3 = d4;
                    }
                    return new com.google.zxing.client.result.GeoParsedResult(d_renamed, d2, d3, strGroup);
                }
            }
        } catch (java.lang.NumberFormatException unused) {
        }
        return null;
    }
}

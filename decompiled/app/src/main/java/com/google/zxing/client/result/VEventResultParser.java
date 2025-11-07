package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class VEventResultParser extends com.google.zxing.client.result.ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.CalendarParsedResult parse(com.google.zxing.Result result) throws java.lang.NumberFormatException {
        double d_renamed;
        java.lang.String massagedText = getMassagedText(result);
        if (massagedText.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        java.lang.String strMatchSingleVCardPrefixedField = matchSingleVCardPrefixedField("SUMMARY", massagedText, true);
        java.lang.String strMatchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField("DTSTART", massagedText, true);
        if (strMatchSingleVCardPrefixedField2 == null) {
            return null;
        }
        java.lang.String strMatchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("DTEND", massagedText, true);
        java.lang.String strMatchSingleVCardPrefixedField4 = matchSingleVCardPrefixedField("DURATION", massagedText, true);
        java.lang.String strMatchSingleVCardPrefixedField5 = matchSingleVCardPrefixedField("LOCATION", massagedText, true);
        java.lang.String strStripMailto = stripMailto(matchSingleVCardPrefixedField("ORGANIZER", massagedText, true));
        java.lang.String[] strArrMatchVCardPrefixedField = matchVCardPrefixedField("ATTENDEE", massagedText, true);
        if (strArrMatchVCardPrefixedField != null) {
            for (int i_renamed = 0; i_renamed < strArrMatchVCardPrefixedField.length; i_renamed++) {
                strArrMatchVCardPrefixedField[i_renamed] = stripMailto(strArrMatchVCardPrefixedField[i_renamed]);
            }
        }
        java.lang.String strMatchSingleVCardPrefixedField6 = matchSingleVCardPrefixedField("DESCRIPTION", massagedText, true);
        java.lang.String strMatchSingleVCardPrefixedField7 = matchSingleVCardPrefixedField("GEO", massagedText, true);
        double d2 = Double.NaN;
        if (strMatchSingleVCardPrefixedField7 == null) {
            d_renamed = Double.NaN;
        } else {
            int iIndexOf = strMatchSingleVCardPrefixedField7.indexOf(59);
            if (iIndexOf < 0) {
                return null;
            }
            try {
                d2 = java.lang.Double.parseDouble(strMatchSingleVCardPrefixedField7.substring(0, iIndexOf));
                d_renamed = java.lang.Double.parseDouble(strMatchSingleVCardPrefixedField7.substring(iIndexOf + 1));
            } catch (java.lang.NumberFormatException | java.lang.IllegalArgumentException unused) {
                return null;
            }
        }
        return new com.google.zxing.client.result.CalendarParsedResult(strMatchSingleVCardPrefixedField, strMatchSingleVCardPrefixedField2, strMatchSingleVCardPrefixedField3, strMatchSingleVCardPrefixedField4, strMatchSingleVCardPrefixedField5, strStripMailto, strArrMatchVCardPrefixedField, strMatchSingleVCardPrefixedField6, d2, d_renamed);
    }

    private static java.lang.String matchSingleVCardPrefixedField(java.lang.CharSequence charSequence, java.lang.String str, boolean z_renamed) {
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField = com.google.zxing.client.result.VCardResultParser.matchSingleVCardPrefixedField(charSequence, str, z_renamed, false);
        if (listMatchSingleVCardPrefixedField == null || listMatchSingleVCardPrefixedField.isEmpty()) {
            return null;
        }
        return listMatchSingleVCardPrefixedField.get(0);
    }

    private static java.lang.String[] matchVCardPrefixedField(java.lang.CharSequence charSequence, java.lang.String str, boolean z_renamed) {
        java.util.List<java.util.List<java.lang.String>> listMatchVCardPrefixedField = com.google.zxing.client.result.VCardResultParser.matchVCardPrefixedField(charSequence, str, z_renamed, false);
        if (listMatchVCardPrefixedField == null || listMatchVCardPrefixedField.isEmpty()) {
            return null;
        }
        int size = listMatchVCardPrefixedField.size();
        java.lang.String[] strArr = new java.lang.String[size];
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            strArr[i_renamed] = listMatchVCardPrefixedField.get(i_renamed).get(0);
        }
        return strArr;
    }

    private static java.lang.String stripMailto(java.lang.String str) {
        return str != null ? (str.startsWith("mailto:") || str.startsWith("MAILTO:")) ? str.substring(7) : str : str;
    }
}

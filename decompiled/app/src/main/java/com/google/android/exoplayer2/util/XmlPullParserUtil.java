package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class XmlPullParserUtil {
    private XmlPullParserUtil() {
    }

    public static boolean isEndTag(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException {
        return isEndTag(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean isEndTag(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException {
        return xmlPullParser.getEventType() == 3;
    }

    public static boolean isStartTag(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException {
        return isStartTag(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean isStartTag(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException {
        return xmlPullParser.getEventType() == 2;
    }

    public static boolean isStartTagIgnorePrefix(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException {
        return isStartTag(xmlPullParser) && stripPrefix(xmlPullParser.getName()).equals(str);
    }

    public static java.lang.String getAttributeValue(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i_renamed = 0; i_renamed < attributeCount; i_renamed++) {
            if (xmlPullParser.getAttributeName(i_renamed).equals(str)) {
                return xmlPullParser.getAttributeValue(i_renamed);
            }
        }
        return null;
    }

    public static java.lang.String getAttributeValueIgnorePrefix(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i_renamed = 0; i_renamed < attributeCount; i_renamed++) {
            if (stripPrefix(xmlPullParser.getAttributeName(i_renamed)).equals(str)) {
                return xmlPullParser.getAttributeValue(i_renamed);
            }
        }
        return null;
    }

    private static java.lang.String stripPrefix(java.lang.String str) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf == -1 ? str : str.substring(iIndexOf + 1);
    }
}

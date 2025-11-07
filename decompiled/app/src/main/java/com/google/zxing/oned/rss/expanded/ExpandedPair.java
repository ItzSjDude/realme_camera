package com.google.zxing.oned.rss.expanded;

/* loaded from: classes.dex */
final class ExpandedPair {
    private final com.google.zxing.oned.rss.FinderPattern finderPattern;
    private final com.google.zxing.oned.rss.DataCharacter leftChar;
    private final com.google.zxing.oned.rss.DataCharacter rightChar;

    ExpandedPair(com.google.zxing.oned.rss.DataCharacter dataCharacter, com.google.zxing.oned.rss.DataCharacter dataCharacter2, com.google.zxing.oned.rss.FinderPattern finderPattern) {
        this.leftChar = dataCharacter;
        this.rightChar = dataCharacter2;
        this.finderPattern = finderPattern;
    }

    com.google.zxing.oned.rss.DataCharacter getLeftChar() {
        return this.leftChar;
    }

    com.google.zxing.oned.rss.DataCharacter getRightChar() {
        return this.rightChar;
    }

    com.google.zxing.oned.rss.FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    boolean mustBeLast() {
        return this.rightChar == null;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("[ ");
        sb.append(this.leftChar);
        sb.append(" , ");
        sb.append(this.rightChar);
        sb.append(" : ");
        com.google.zxing.oned.rss.FinderPattern finderPattern = this.finderPattern;
        sb.append(finderPattern == null ? "null" : java.lang.Integer.valueOf(finderPattern.getValue()));
        sb.append(" ]");
        return sb.toString();
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.google.zxing.oned.rss.expanded.ExpandedPair)) {
            return false;
        }
        com.google.zxing.oned.rss.expanded.ExpandedPair expandedPair = (com.google.zxing.oned.rss.expanded.ExpandedPair) obj;
        return java.util.Objects.equals(this.leftChar, expandedPair.leftChar) && java.util.Objects.equals(this.rightChar, expandedPair.rightChar) && java.util.Objects.equals(this.finderPattern, expandedPair.finderPattern);
    }

    public int hashCode() {
        return java.util.Objects.hashCode(this.finderPattern) ^ (java.util.Objects.hashCode(this.leftChar) ^ java.util.Objects.hashCode(this.rightChar));
    }
}

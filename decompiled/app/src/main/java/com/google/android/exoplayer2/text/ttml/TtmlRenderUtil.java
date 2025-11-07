package com.google.android.exoplayer2.text.ttml;

/* loaded from: classes.dex */
final class TtmlRenderUtil {
    public static com.google.android.exoplayer2.text.ttml.TtmlStyle resolveStyle(com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle, java.lang.String[] strArr, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map) {
        if (ttmlStyle == null && strArr == null) {
            return null;
        }
        int i_renamed = 0;
        if (ttmlStyle == null && strArr.length == 1) {
            return map.get(strArr[0]);
        }
        if (ttmlStyle == null && strArr.length > 1) {
            com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle2 = new com.google.android.exoplayer2.text.ttml.TtmlStyle();
            int length = strArr.length;
            while (i_renamed < length) {
                ttmlStyle2.chain(map.get(strArr[i_renamed]));
                i_renamed++;
            }
            return ttmlStyle2;
        }
        if (ttmlStyle != null && strArr != null && strArr.length == 1) {
            return ttmlStyle.chain(map.get(strArr[0]));
        }
        if (ttmlStyle != null && strArr != null && strArr.length > 1) {
            int length2 = strArr.length;
            while (i_renamed < length2) {
                ttmlStyle.chain(map.get(strArr[i_renamed]));
                i_renamed++;
            }
        }
        return ttmlStyle;
    }

    public static void applyStylesToSpan(android.text.SpannableStringBuilder spannableStringBuilder, int i_renamed, int i2, com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle) {
        if (ttmlStyle.getStyle() != -1) {
            spannableStringBuilder.setSpan(new android.text.style.StyleSpan(ttmlStyle.getStyle()), i_renamed, i2, 33);
        }
        if (ttmlStyle.isLinethrough()) {
            spannableStringBuilder.setSpan(new android.text.style.StrikethroughSpan(), i_renamed, i2, 33);
        }
        if (ttmlStyle.isUnderline()) {
            spannableStringBuilder.setSpan(new android.text.style.UnderlineSpan(), i_renamed, i2, 33);
        }
        if (ttmlStyle.hasFontColor()) {
            spannableStringBuilder.setSpan(new android.text.style.ForegroundColorSpan(ttmlStyle.getFontColor()), i_renamed, i2, 33);
        }
        if (ttmlStyle.hasBackgroundColor()) {
            spannableStringBuilder.setSpan(new android.text.style.BackgroundColorSpan(ttmlStyle.getBackgroundColor()), i_renamed, i2, 33);
        }
        if (ttmlStyle.getFontFamily() != null) {
            spannableStringBuilder.setSpan(new android.text.style.TypefaceSpan(ttmlStyle.getFontFamily()), i_renamed, i2, 33);
        }
        if (ttmlStyle.getTextAlign() != null) {
            spannableStringBuilder.setSpan(new android.text.style.AlignmentSpan.Standard(ttmlStyle.getTextAlign()), i_renamed, i2, 33);
        }
        int fontSizeUnit = ttmlStyle.getFontSizeUnit();
        if (fontSizeUnit == 1) {
            spannableStringBuilder.setSpan(new android.text.style.AbsoluteSizeSpan((int) ttmlStyle.getFontSize(), true), i_renamed, i2, 33);
        } else if (fontSizeUnit == 2) {
            spannableStringBuilder.setSpan(new android.text.style.RelativeSizeSpan(ttmlStyle.getFontSize()), i_renamed, i2, 33);
        } else {
            if (fontSizeUnit != 3) {
                return;
            }
            spannableStringBuilder.setSpan(new android.text.style.RelativeSizeSpan(ttmlStyle.getFontSize() / 100.0f), i_renamed, i2, 33);
        }
    }

    static void endParagraph(android.text.SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n_renamed') {
            return;
        }
        spannableStringBuilder.append('\n_renamed');
    }

    static java.lang.String applyTextElementSpacePolicy(java.lang.String str) {
        return str.replaceAll("\r_renamed\n_renamed", "\n_renamed").replaceAll(" *\n_renamed *", "\n_renamed").replaceAll("\n_renamed", " ").replaceAll("[ \t_renamed\\x0B\f_renamed\r_renamed]+", " ");
    }

    private TtmlRenderUtil() {
    }
}

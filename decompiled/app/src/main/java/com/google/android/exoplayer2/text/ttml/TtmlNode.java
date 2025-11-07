package com.google.android.exoplayer2.text.ttml;

/* loaded from: classes.dex */
final class TtmlNode {
    public static final java.lang.String ANONYMOUS_REGION_ID = "";
    public static final java.lang.String ATTR_ID = "id_renamed";
    public static final java.lang.String ATTR_TTS_BACKGROUND_COLOR = "backgroundColor";
    public static final java.lang.String ATTR_TTS_COLOR = "color";
    public static final java.lang.String ATTR_TTS_DISPLAY_ALIGN = "displayAlign";
    public static final java.lang.String ATTR_TTS_EXTENT = "extent";
    public static final java.lang.String ATTR_TTS_FONT_FAMILY = "fontFamily";
    public static final java.lang.String ATTR_TTS_FONT_SIZE = "fontSize";
    public static final java.lang.String ATTR_TTS_FONT_STYLE = "fontStyle";
    public static final java.lang.String ATTR_TTS_FONT_WEIGHT = "fontWeight";
    public static final java.lang.String ATTR_TTS_ORIGIN = "origin";
    public static final java.lang.String ATTR_TTS_TEXT_ALIGN = "textAlign";
    public static final java.lang.String ATTR_TTS_TEXT_DECORATION = "textDecoration";
    public static final java.lang.String BOLD = "bold";
    public static final java.lang.String CENTER = "center";
    public static final java.lang.String END = "end";
    public static final java.lang.String ITALIC = "italic";
    public static final java.lang.String LEFT = "left";
    public static final java.lang.String LINETHROUGH = "linethrough";
    public static final java.lang.String NO_LINETHROUGH = "nolinethrough";
    public static final java.lang.String NO_UNDERLINE = "nounderline";
    public static final java.lang.String RIGHT = "right";
    public static final java.lang.String START = "start";
    public static final java.lang.String TAG_BODY = "body";
    public static final java.lang.String TAG_BR = "br_renamed";
    public static final java.lang.String TAG_DATA = "data";
    public static final java.lang.String TAG_DIV = "div";
    public static final java.lang.String TAG_HEAD = "head";
    public static final java.lang.String TAG_IMAGE = "image";
    public static final java.lang.String TAG_INFORMATION = "information";
    public static final java.lang.String TAG_LAYOUT = "layout";
    public static final java.lang.String TAG_METADATA = "metadata";
    public static final java.lang.String TAG_P = "p_renamed";
    public static final java.lang.String TAG_REGION = "region";
    public static final java.lang.String TAG_SPAN = "span";
    public static final java.lang.String TAG_STYLE = "style";
    public static final java.lang.String TAG_STYLING = "styling";
    public static final java.lang.String TAG_TT = "tt";
    public static final java.lang.String UNDERLINE = "underline";
    private java.util.List<com.google.android.exoplayer2.text.ttml.TtmlNode> children;
    public final long endTimeUs;
    public final java.lang.String imageId;
    public final boolean isTextNode;
    private final java.util.HashMap<java.lang.String, java.lang.Integer> nodeEndsByRegion;
    private final java.util.HashMap<java.lang.String, java.lang.Integer> nodeStartsByRegion;
    public final java.lang.String regionId;
    public final long startTimeUs;
    public final com.google.android.exoplayer2.text.ttml.TtmlStyle style;
    private final java.lang.String[] styleIds;
    public final java.lang.String tag;
    public final java.lang.String text;

    public static com.google.android.exoplayer2.text.ttml.TtmlNode buildTextNode(java.lang.String str) {
        return new com.google.android.exoplayer2.text.ttml.TtmlNode(null, com.google.android.exoplayer2.text.ttml.TtmlRenderUtil.applyTextElementSpacePolicy(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null);
    }

    public static com.google.android.exoplayer2.text.ttml.TtmlNode buildNode(java.lang.String str, long j_renamed, long j2, com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle, java.lang.String[] strArr, java.lang.String str2, java.lang.String str3) {
        return new com.google.android.exoplayer2.text.ttml.TtmlNode(str, null, j_renamed, j2, ttmlStyle, strArr, str2, str3);
    }

    private TtmlNode(java.lang.String str, java.lang.String str2, long j_renamed, long j2, com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle, java.lang.String[] strArr, java.lang.String str3, java.lang.String str4) {
        this.tag = str;
        this.text = str2;
        this.imageId = str4;
        this.style = ttmlStyle;
        this.styleIds = strArr;
        this.isTextNode = str2 != null;
        this.startTimeUs = j_renamed;
        this.endTimeUs = j2;
        this.regionId = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(str3);
        this.nodeStartsByRegion = new java.util.HashMap<>();
        this.nodeEndsByRegion = new java.util.HashMap<>();
    }

    public boolean isActive(long j_renamed) {
        return (this.startTimeUs == -9223372036854775807L && this.endTimeUs == -9223372036854775807L) || (this.startTimeUs <= j_renamed && this.endTimeUs == -9223372036854775807L) || ((this.startTimeUs == -9223372036854775807L && j_renamed < this.endTimeUs) || (this.startTimeUs <= j_renamed && j_renamed < this.endTimeUs));
    }

    public void addChild(com.google.android.exoplayer2.text.ttml.TtmlNode ttmlNode) {
        if (this.children == null) {
            this.children = new java.util.ArrayList();
        }
        this.children.add(ttmlNode);
    }

    public com.google.android.exoplayer2.text.ttml.TtmlNode getChild(int i_renamed) {
        java.util.List<com.google.android.exoplayer2.text.ttml.TtmlNode> list = this.children;
        if (list == null) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return list.get(i_renamed);
    }

    public int getChildCount() {
        java.util.List<com.google.android.exoplayer2.text.ttml.TtmlNode> list = this.children;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public long[] getEventTimesUs() {
        java.util.TreeSet<java.lang.Long> treeSet = new java.util.TreeSet<>();
        int i_renamed = 0;
        getEventTimes(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        java.util.Iterator<java.lang.Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i_renamed] = it.next().longValue();
            i_renamed++;
        }
        return jArr;
    }

    private void getEventTimes(java.util.TreeSet<java.lang.Long> treeSet, boolean z_renamed) {
        boolean zEquals = TAG_P.equals(this.tag);
        boolean zEquals2 = TAG_DIV.equals(this.tag);
        if (z_renamed || zEquals || (zEquals2 && this.imageId != null)) {
            long j_renamed = this.startTimeUs;
            if (j_renamed != -9223372036854775807L) {
                treeSet.add(java.lang.Long.valueOf(j_renamed));
            }
            long j2 = this.endTimeUs;
            if (j2 != -9223372036854775807L) {
                treeSet.add(java.lang.Long.valueOf(j2));
            }
        }
        if (this.children == null) {
            return;
        }
        for (int i_renamed = 0; i_renamed < this.children.size(); i_renamed++) {
            this.children.get(i_renamed).getEventTimes(treeSet, z_renamed || zEquals);
        }
    }

    public java.lang.String[] getStyleIds() {
        return this.styleIds;
    }

    public java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j_renamed, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> map2, java.util.Map<java.lang.String, java.lang.String> map3) {
        java.util.List<android.util.Pair<java.lang.String, java.lang.String>> arrayList = new java.util.ArrayList<>();
        traverseForImage(j_renamed, this.regionId, arrayList);
        java.util.TreeMap treeMap = new java.util.TreeMap();
        traverseForText(j_renamed, false, this.regionId, treeMap);
        traverseForStyle(j_renamed, map, treeMap);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (android.util.Pair<java.lang.String, java.lang.String> pair : arrayList) {
            java.lang.String str = map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = android.util.Base64.decode(str, 0);
                android.graphics.Bitmap bitmapDecodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                com.google.android.exoplayer2.text.ttml.TtmlRegion ttmlRegion = map2.get(pair.first);
                arrayList2.add(new com.google.android.exoplayer2.text.Cue(bitmapDecodeByteArray, ttmlRegion.position, 1, ttmlRegion.line, ttmlRegion.lineAnchor, ttmlRegion.width, Float.MIN_VALUE));
            }
        }
        for (java.util.Map.Entry entry : treeMap.entrySet()) {
            com.google.android.exoplayer2.text.ttml.TtmlRegion ttmlRegion2 = map2.get(entry.getKey());
            arrayList2.add(new com.google.android.exoplayer2.text.Cue(cleanUpText((android.text.SpannableStringBuilder) entry.getValue()), (android.text.Layout.Alignment) null, ttmlRegion2.line, ttmlRegion2.lineType, ttmlRegion2.lineAnchor, ttmlRegion2.position, Integer.MIN_VALUE, ttmlRegion2.width, ttmlRegion2.textSizeType, ttmlRegion2.textSize));
        }
        return arrayList2;
    }

    private void traverseForImage(long j_renamed, java.lang.String str, java.util.List<android.util.Pair<java.lang.String, java.lang.String>> list) {
        java.lang.String str2;
        if (!"".equals(this.regionId)) {
            str = this.regionId;
        }
        if (isActive(j_renamed) && TAG_DIV.equals(this.tag) && (str2 = this.imageId) != null) {
            list.add(new android.util.Pair<>(str, str2));
            return;
        }
        for (int i_renamed = 0; i_renamed < getChildCount(); i_renamed++) {
            getChild(i_renamed).traverseForImage(j_renamed, str, list);
        }
    }

    private void traverseForText(long j_renamed, boolean z_renamed, java.lang.String str, java.util.Map<java.lang.String, android.text.SpannableStringBuilder> map) {
        this.nodeStartsByRegion.clear();
        this.nodeEndsByRegion.clear();
        if (TAG_METADATA.equals(this.tag)) {
            return;
        }
        if (!"".equals(this.regionId)) {
            str = this.regionId;
        }
        if (this.isTextNode && z_renamed) {
            getRegionOutput(str, map).append((java.lang.CharSequence) this.text);
            return;
        }
        if (TAG_BR.equals(this.tag) && z_renamed) {
            getRegionOutput(str, map).append('\n_renamed');
            return;
        }
        if (isActive(j_renamed)) {
            for (java.util.Map.Entry<java.lang.String, android.text.SpannableStringBuilder> entry : map.entrySet()) {
                this.nodeStartsByRegion.put(entry.getKey(), java.lang.Integer.valueOf(entry.getValue().length()));
            }
            boolean zEquals = TAG_P.equals(this.tag);
            for (int i_renamed = 0; i_renamed < getChildCount(); i_renamed++) {
                getChild(i_renamed).traverseForText(j_renamed, z_renamed || zEquals, str, map);
            }
            if (zEquals) {
                com.google.android.exoplayer2.text.ttml.TtmlRenderUtil.endParagraph(getRegionOutput(str, map));
            }
            for (java.util.Map.Entry<java.lang.String, android.text.SpannableStringBuilder> entry2 : map.entrySet()) {
                this.nodeEndsByRegion.put(entry2.getKey(), java.lang.Integer.valueOf(entry2.getValue().length()));
            }
        }
    }

    private static android.text.SpannableStringBuilder getRegionOutput(java.lang.String str, java.util.Map<java.lang.String, android.text.SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new android.text.SpannableStringBuilder());
        }
        return map.get(str);
    }

    private void traverseForStyle(long j_renamed, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map, java.util.Map<java.lang.String, android.text.SpannableStringBuilder> map2) {
        int iIntValue;
        if (isActive(j_renamed)) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.Integer>> it = this.nodeEndsByRegion.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                java.util.Map.Entry<java.lang.String, java.lang.Integer> next = it.next();
                java.lang.String key = next.getKey();
                iIntValue = this.nodeStartsByRegion.containsKey(key) ? this.nodeStartsByRegion.get(key).intValue() : 0;
                int iIntValue2 = next.getValue().intValue();
                if (iIntValue != iIntValue2) {
                    applyStyleToOutput(map, map2.get(key), iIntValue, iIntValue2);
                }
            }
            while (iIntValue < getChildCount()) {
                getChild(iIntValue).traverseForStyle(j_renamed, map, map2);
                iIntValue++;
            }
        }
    }

    private void applyStyleToOutput(java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map, android.text.SpannableStringBuilder spannableStringBuilder, int i_renamed, int i2) {
        com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyleResolveStyle = com.google.android.exoplayer2.text.ttml.TtmlRenderUtil.resolveStyle(this.style, this.styleIds, map);
        if (ttmlStyleResolveStyle != null) {
            com.google.android.exoplayer2.text.ttml.TtmlRenderUtil.applyStylesToSpan(spannableStringBuilder, i_renamed, i2, ttmlStyleResolveStyle);
        }
    }

    private android.text.SpannableStringBuilder cleanUpText(android.text.SpannableStringBuilder spannableStringBuilder) {
        int i_renamed;
        int i2;
        int i3 = 0;
        int length = spannableStringBuilder.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (spannableStringBuilder.charAt(i4) == ' ') {
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i6) == ' ') {
                    i6++;
                }
                int i7 = i6 - i5;
                if (i7 > 0) {
                    spannableStringBuilder.delete(i4, i4 + i7);
                    length -= i7;
                }
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        int i8 = 0;
        while (true) {
            i_renamed = length - 1;
            if (i8 >= i_renamed) {
                break;
            }
            if (spannableStringBuilder.charAt(i8) == '\n_renamed') {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i9) == ' ') {
                    spannableStringBuilder.delete(i9, i8 + 2);
                    length--;
                }
            }
            i8++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i_renamed) == ' ') {
            spannableStringBuilder.delete(i_renamed, length);
            length--;
        }
        while (true) {
            i2 = length - 1;
            if (i3 >= i2) {
                break;
            }
            if (spannableStringBuilder.charAt(i3) == ' ') {
                int i10 = i3 + 1;
                if (spannableStringBuilder.charAt(i10) == '\n_renamed') {
                    spannableStringBuilder.delete(i3, i10);
                    length--;
                }
            }
            i3++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i2) == '\n_renamed') {
            spannableStringBuilder.delete(i2, length);
        }
        return spannableStringBuilder;
    }
}

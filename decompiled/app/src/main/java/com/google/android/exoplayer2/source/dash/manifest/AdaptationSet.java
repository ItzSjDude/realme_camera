package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes.dex */
public class AdaptationSet {
    public static final int ID_UNSET = -1;
    public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> accessibilityDescriptors;
    public final int id_renamed;
    public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> representations;
    public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> supplementalProperties;
    public final int type;

    public AdaptationSet(int i_renamed, int i2, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list2, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list3) {
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> listUnmodifiableList;
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> listUnmodifiableList2;
        this.id_renamed = i_renamed;
        this.type = i2;
        this.representations = java.util.Collections.unmodifiableList(list);
        if (list2 == null) {
            listUnmodifiableList = java.util.Collections.emptyList();
        } else {
            listUnmodifiableList = java.util.Collections.unmodifiableList(list2);
        }
        this.accessibilityDescriptors = listUnmodifiableList;
        if (list3 == null) {
            listUnmodifiableList2 = java.util.Collections.emptyList();
        } else {
            listUnmodifiableList2 = java.util.Collections.unmodifiableList(list3);
        }
        this.supplementalProperties = listUnmodifiableList2;
    }
}

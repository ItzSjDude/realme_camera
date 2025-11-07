package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes.dex */
public final class Descriptor {
    public final java.lang.String id_renamed;
    public final java.lang.String schemeIdUri;
    public final java.lang.String value;

    public Descriptor(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.schemeIdUri = str;
        this.value = str2;
        this.id_renamed = str3;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = (com.google.android.exoplayer2.source.dash.manifest.Descriptor) obj;
        return com.google.android.exoplayer2.util.Util.areEqual(this.schemeIdUri, descriptor.schemeIdUri) && com.google.android.exoplayer2.util.Util.areEqual(this.value, descriptor.value) && com.google.android.exoplayer2.util.Util.areEqual(this.id_renamed, descriptor.id_renamed);
    }

    public int hashCode() {
        java.lang.String str = this.schemeIdUri;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        java.lang.String str2 = this.value;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.id_renamed;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }
}

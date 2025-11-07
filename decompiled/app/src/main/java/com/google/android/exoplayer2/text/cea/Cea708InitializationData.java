package com.google.android.exoplayer2.text.cea;

/* loaded from: classes.dex */
public final class Cea708InitializationData {
    public final boolean isWideAspectRatio;

    private Cea708InitializationData(java.util.List<byte[]> list) {
        this.isWideAspectRatio = list.get(0)[0] != 0;
    }

    public static com.google.android.exoplayer2.text.cea.Cea708InitializationData fromData(java.util.List<byte[]> list) {
        return new com.google.android.exoplayer2.text.cea.Cea708InitializationData(list);
    }

    public static java.util.List<byte[]> buildData(boolean z_renamed) {
        return java.util.Collections.singletonList(new byte[]{z_renamed ? (byte) 1 : (byte) 0});
    }
}

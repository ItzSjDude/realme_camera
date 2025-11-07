package com.google.android.exoplayer2.metadata.emsg;

/* loaded from: classes.dex */
public final class EventMessageDecoder implements com.google.android.exoplayer2.metadata.MetadataDecoder {
    private static final java.lang.String TAG = "EventMessageDecoder";

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public com.google.android.exoplayer2.metadata.Metadata decode(com.google.android.exoplayer2.metadata.MetadataInputBuffer metadataInputBuffer) {
        java.nio.ByteBuffer byteBuffer = metadataInputBuffer.data;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(bArrArray, iLimit);
        java.lang.String str = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
        java.lang.String str2 = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
        long unsignedInt = parsableByteArray.readUnsignedInt();
        long unsignedInt2 = parsableByteArray.readUnsignedInt();
        if (unsignedInt2 != 0) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring non-zero presentation_time_delta: " + unsignedInt2);
        }
        return new com.google.android.exoplayer2.metadata.Metadata(new com.google.android.exoplayer2.metadata.emsg.EventMessage(str, str2, com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000L, unsignedInt), parsableByteArray.readUnsignedInt(), java.util.Arrays.copyOfRange(bArrArray, parsableByteArray.getPosition(), iLimit)));
    }
}

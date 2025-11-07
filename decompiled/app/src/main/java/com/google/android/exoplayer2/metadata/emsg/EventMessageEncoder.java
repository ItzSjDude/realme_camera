package com.google.android.exoplayer2.metadata.emsg;

/* loaded from: classes.dex */
public final class EventMessageEncoder {
    private final java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(512);
    private final java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(this.byteArrayOutputStream);

    public byte[] encode(com.google.android.exoplayer2.metadata.emsg.EventMessage eventMessage) throws java.io.IOException {
        this.byteArrayOutputStream.reset();
        try {
            writeNullTerminatedString(this.dataOutputStream, eventMessage.schemeIdUri);
            writeNullTerminatedString(this.dataOutputStream, eventMessage.value != null ? eventMessage.value : "");
            writeUnsignedInt(this.dataOutputStream, 1000L);
            writeUnsignedInt(this.dataOutputStream, 0L);
            writeUnsignedInt(this.dataOutputStream, eventMessage.durationMs);
            writeUnsignedInt(this.dataOutputStream, eventMessage.id_renamed);
            this.dataOutputStream.write(eventMessage.messageData);
            this.dataOutputStream.flush();
            return this.byteArrayOutputStream.toByteArray();
        } catch (java.io.IOException e_renamed) {
            throw new java.lang.RuntimeException(e_renamed);
        }
    }

    private static void writeNullTerminatedString(java.io.DataOutputStream dataOutputStream, java.lang.String str) throws java.io.IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    private static void writeUnsignedInt(java.io.DataOutputStream dataOutputStream, long j_renamed) throws java.io.IOException {
        dataOutputStream.writeByte(((int) (j_renamed >>> 24)) & 255);
        dataOutputStream.writeByte(((int) (j_renamed >>> 16)) & 255);
        dataOutputStream.writeByte(((int) (j_renamed >>> 8)) & 255);
        dataOutputStream.writeByte(((int) j_renamed) & 255);
    }
}

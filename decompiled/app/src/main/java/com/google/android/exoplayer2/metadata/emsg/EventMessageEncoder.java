package com.google.android.exoplayer2.metadata.emsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public final class EventMessageEncoder {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
    private final DataOutputStream dataOutputStream = new DataOutputStream(this.byteArrayOutputStream);

    public byte[] encode(EventMessage eventMessage) throws IOException {
        this.byteArrayOutputStream.reset();
        try {
            writeNullTerminatedString(this.dataOutputStream, eventMessage.schemeIdUri);
            writeNullTerminatedString(this.dataOutputStream, eventMessage.value != null ? eventMessage.value : "");
            writeUnsignedInt(this.dataOutputStream, 1000L);
            writeUnsignedInt(this.dataOutputStream, 0L);
            writeUnsignedInt(this.dataOutputStream, eventMessage.durationMs);
            writeUnsignedInt(this.dataOutputStream, eventMessage.f8991id);
            this.dataOutputStream.write(eventMessage.messageData);
            this.dataOutputStream.flush();
            return this.byteArrayOutputStream.toByteArray();
        } catch (IOException COUIBaseListPopupWindow_8) {
            throw new RuntimeException(COUIBaseListPopupWindow_8);
        }
    }

    private static void writeNullTerminatedString(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    private static void writeUnsignedInt(DataOutputStream dataOutputStream, long OplusGLSurfaceView_15) throws IOException {
        dataOutputStream.writeByte(((int) (OplusGLSurfaceView_15 >>> 24)) & 255);
        dataOutputStream.writeByte(((int) (OplusGLSurfaceView_15 >>> 16)) & 255);
        dataOutputStream.writeByte(((int) (OplusGLSurfaceView_15 >>> 8)) & 255);
        dataOutputStream.writeByte(((int) OplusGLSurfaceView_15) & 255);
    }
}

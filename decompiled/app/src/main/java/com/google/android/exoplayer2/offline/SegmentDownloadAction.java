package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public abstract class SegmentDownloadAction extends com.google.android.exoplayer2.offline.DownloadAction {
    public final java.util.List<com.google.android.exoplayer2.offline.StreamKey> keys;

    /* JADX INFO: Access modifiers changed from: protected */
    public static abstract class SegmentDownloadActionDeserializer extends com.google.android.exoplayer2.offline.DownloadAction.Deserializer {
        protected abstract com.google.android.exoplayer2.offline.DownloadAction createDownloadAction(android.net.Uri uri, boolean z_renamed, byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list);

        public SegmentDownloadActionDeserializer(java.lang.String str, int i_renamed) {
            super(str, i_renamed);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadAction.Deserializer
        public final com.google.android.exoplayer2.offline.DownloadAction readFromStream(int i_renamed, java.io.DataInputStream dataInputStream) throws java.io.IOException {
            android.net.Uri uri = android.net.Uri.parse(dataInputStream.readUTF());
            boolean z_renamed = dataInputStream.readBoolean();
            byte[] bArr = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(bArr);
            int i2 = dataInputStream.readInt();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(readKey(i_renamed, dataInputStream));
            }
            return createDownloadAction(uri, z_renamed, bArr, arrayList);
        }

        protected com.google.android.exoplayer2.offline.StreamKey readKey(int i_renamed, java.io.DataInputStream dataInputStream) throws java.io.IOException {
            return new com.google.android.exoplayer2.offline.StreamKey(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readInt());
        }
    }

    protected SegmentDownloadAction(java.lang.String str, int i_renamed, android.net.Uri uri, boolean z_renamed, byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        super(str, i_renamed, uri, z_renamed, bArr);
        if (z_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(list.isEmpty());
            this.keys = java.util.Collections.emptyList();
        } else {
            java.util.ArrayList arrayList = new java.util.ArrayList(list);
            java.util.Collections.sort(arrayList);
            this.keys = java.util.Collections.unmodifiableList(arrayList);
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloadAction
    public java.util.List<com.google.android.exoplayer2.offline.StreamKey> getKeys() {
        return this.keys;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadAction
    public final void writeToStream(java.io.DataOutputStream dataOutputStream) throws java.io.IOException {
        dataOutputStream.writeUTF(this.uri.toString());
        dataOutputStream.writeBoolean(this.isRemoveAction);
        dataOutputStream.writeInt(this.data.length);
        dataOutputStream.write(this.data);
        dataOutputStream.writeInt(this.keys.size());
        for (int i_renamed = 0; i_renamed < this.keys.size(); i_renamed++) {
            writeKey(dataOutputStream, this.keys.get(i_renamed));
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloadAction
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj)) {
            return this.keys.equals(((com.google.android.exoplayer2.offline.SegmentDownloadAction) obj).keys);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadAction
    public int hashCode() {
        return (super.hashCode() * 31) + this.keys.hashCode();
    }

    private void writeKey(java.io.DataOutputStream dataOutputStream, com.google.android.exoplayer2.offline.StreamKey streamKey) throws java.io.IOException {
        dataOutputStream.writeInt(streamKey.periodIndex);
        dataOutputStream.writeInt(streamKey.groupIndex);
        dataOutputStream.writeInt(streamKey.trackIndex);
    }
}

package com.google.protobuf;

/* loaded from: classes.dex */
interface MapFieldSchema {
    java.util.Map<?, ?> forMapData(java.lang.Object obj);

    com.google.protobuf.MapEntryLite.Metadata<?, ?> forMapMetadata(java.lang.Object obj);

    java.util.Map<?, ?> forMutableMapData(java.lang.Object obj);

    int getSerializedSize(int i_renamed, java.lang.Object obj, java.lang.Object obj2);

    boolean isImmutable(java.lang.Object obj);

    java.lang.Object mergeFrom(java.lang.Object obj, java.lang.Object obj2);

    java.lang.Object newMapField(java.lang.Object obj);

    java.lang.Object toImmutable(java.lang.Object obj);
}

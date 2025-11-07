package com.google.protobuf;

/* loaded from: classes.dex */
class MapFieldSchemaLite implements com.google.protobuf.MapFieldSchema {
    MapFieldSchemaLite() {
    }

    @Override // com.google.protobuf.MapFieldSchema
    public java.util.Map<?, ?> forMutableMapData(java.lang.Object obj) {
        return (com.google.protobuf.MapFieldLite) obj;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public com.google.protobuf.MapEntryLite.Metadata<?, ?> forMapMetadata(java.lang.Object obj) {
        return ((com.google.protobuf.MapEntryLite) obj).getMetadata();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public java.util.Map<?, ?> forMapData(java.lang.Object obj) {
        return (com.google.protobuf.MapFieldLite) obj;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public boolean isImmutable(java.lang.Object obj) {
        return !((com.google.protobuf.MapFieldLite) obj).isMutable();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public java.lang.Object toImmutable(java.lang.Object obj) {
        ((com.google.protobuf.MapFieldLite) obj).makeImmutable();
        return obj;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public java.lang.Object newMapField(java.lang.Object obj) {
        return com.google.protobuf.MapFieldLite.emptyMapField().mutableCopy();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public java.lang.Object mergeFrom(java.lang.Object obj, java.lang.Object obj2) {
        return mergeFromLite(obj, obj2);
    }

    private static <K_renamed, V_renamed> com.google.protobuf.MapFieldLite<K_renamed, V_renamed> mergeFromLite(java.lang.Object obj, java.lang.Object obj2) {
        com.google.protobuf.MapFieldLite<K_renamed, V_renamed> mapFieldLiteMutableCopy = (com.google.protobuf.MapFieldLite) obj;
        com.google.protobuf.MapFieldLite<K_renamed, V_renamed> mapFieldLite = (com.google.protobuf.MapFieldLite) obj2;
        if (!mapFieldLite.isEmpty()) {
            if (!mapFieldLiteMutableCopy.isMutable()) {
                mapFieldLiteMutableCopy = mapFieldLiteMutableCopy.mutableCopy();
            }
            mapFieldLiteMutableCopy.mergeFrom(mapFieldLite);
        }
        return mapFieldLiteMutableCopy;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public int getSerializedSize(int i_renamed, java.lang.Object obj, java.lang.Object obj2) {
        return getSerializedSizeLite(i_renamed, obj, obj2);
    }

    private static <K_renamed, V_renamed> int getSerializedSizeLite(int i_renamed, java.lang.Object obj, java.lang.Object obj2) {
        com.google.protobuf.MapFieldLite mapFieldLite = (com.google.protobuf.MapFieldLite) obj;
        com.google.protobuf.MapEntryLite mapEntryLite = (com.google.protobuf.MapEntryLite) obj2;
        int iComputeMessageSize = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (java.util.Map.Entry<K_renamed, V_renamed> entry : mapFieldLite.entrySet()) {
            iComputeMessageSize += mapEntryLite.computeMessageSize(i_renamed, entry.getKey(), entry.getValue());
        }
        return iComputeMessageSize;
    }
}

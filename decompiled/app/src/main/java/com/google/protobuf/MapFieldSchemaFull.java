package com.google.protobuf;

/* loaded from: classes.dex */
class MapFieldSchemaFull implements com.google.protobuf.MapFieldSchema {
    MapFieldSchemaFull() {
    }

    @Override // com.google.protobuf.MapFieldSchema
    public java.util.Map<?, ?> forMutableMapData(java.lang.Object obj) {
        return ((com.google.protobuf.MapField) obj).getMutableMap();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public java.util.Map<?, ?> forMapData(java.lang.Object obj) {
        return ((com.google.protobuf.MapField) obj).getMap();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public boolean isImmutable(java.lang.Object obj) {
        return !((com.google.protobuf.MapField) obj).isMutable();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public java.lang.Object toImmutable(java.lang.Object obj) {
        ((com.google.protobuf.MapField) obj).makeImmutable();
        return obj;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public java.lang.Object newMapField(java.lang.Object obj) {
        return com.google.protobuf.MapField.newMapField((com.google.protobuf.MapEntry) obj);
    }

    @Override // com.google.protobuf.MapFieldSchema
    public com.google.protobuf.MapEntryLite.Metadata<?, ?> forMapMetadata(java.lang.Object obj) {
        return ((com.google.protobuf.MapEntry) obj).getMetadata();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public java.lang.Object mergeFrom(java.lang.Object obj, java.lang.Object obj2) {
        return mergeFromFull(obj, obj2);
    }

    private static <K_renamed, V_renamed> java.lang.Object mergeFromFull(java.lang.Object obj, java.lang.Object obj2) {
        com.google.protobuf.MapField mapField = (com.google.protobuf.MapField) obj;
        com.google.protobuf.MapField<K_renamed, V_renamed> mapField2 = (com.google.protobuf.MapField) obj2;
        if (!mapField.isMutable()) {
            mapField.copy();
        }
        mapField.mergeFrom(mapField2);
        return mapField;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public int getSerializedSize(int i_renamed, java.lang.Object obj, java.lang.Object obj2) {
        return getSerializedSizeFull(i_renamed, obj, obj2);
    }

    private static <K_renamed, V_renamed> int getSerializedSizeFull(int i_renamed, java.lang.Object obj, java.lang.Object obj2) {
        int iComputeTagSize = 0;
        if (obj == null) {
            return 0;
        }
        java.util.Map<K_renamed, V_renamed> map = ((com.google.protobuf.MapField) obj).getMap();
        com.google.protobuf.MapEntry mapEntry = (com.google.protobuf.MapEntry) obj2;
        if (map.isEmpty()) {
            return 0;
        }
        for (java.util.Map.Entry<K_renamed, V_renamed> entry : map.entrySet()) {
            iComputeTagSize += com.google.protobuf.CodedOutputStream.computeTagSize(i_renamed) + com.google.protobuf.CodedOutputStream.computeLengthDelimitedFieldSize(com.google.protobuf.MapEntryLite.computeSerializedSize(mapEntry.getMetadata(), entry.getKey(), entry.getValue()));
        }
        return iComputeTagSize;
    }
}

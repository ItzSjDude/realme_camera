package com.google.gson;

/* loaded from: classes.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public com.google.gson.JsonElement serialize(java.lang.Long l_renamed) {
            return new com.google.gson.JsonPrimitive((java.lang.Number) l_renamed);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public com.google.gson.JsonElement serialize(java.lang.Long l_renamed) {
            return new com.google.gson.JsonPrimitive(java.lang.String.valueOf(l_renamed));
        }
    };

    public abstract com.google.gson.JsonElement serialize(java.lang.Long l_renamed);
}

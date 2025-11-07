package com.google.gson;

/* loaded from: classes.dex */
public final class JsonNull extends com.google.gson.JsonElement {
    public static final com.google.gson.JsonNull INSTANCE = new com.google.gson.JsonNull();

    @java.lang.Deprecated
    public JsonNull() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonNull deepCopy() {
        return INSTANCE;
    }

    public int hashCode() {
        return com.google.gson.JsonNull.class.hashCode();
    }

    public boolean equals(java.lang.Object obj) {
        return this == obj || (obj instanceof com.google.gson.JsonNull);
    }
}

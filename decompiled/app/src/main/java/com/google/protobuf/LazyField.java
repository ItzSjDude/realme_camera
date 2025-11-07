package com.google.protobuf;

/* loaded from: classes.dex */
public class LazyField extends com.google.protobuf.LazyFieldLite {
    private final com.google.protobuf.MessageLite defaultInstance;

    public LazyField(com.google.protobuf.MessageLite messageLite, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, com.google.protobuf.ByteString byteString) {
        super(extensionRegistryLite, byteString);
        this.defaultInstance = messageLite;
    }

    @Override // com.google.protobuf.LazyFieldLite
    public boolean containsDefaultInstance() {
        return super.containsDefaultInstance() || this.value == this.defaultInstance;
    }

    public com.google.protobuf.MessageLite getValue() {
        return getValue(this.defaultInstance);
    }

    @Override // com.google.protobuf.LazyFieldLite
    public int hashCode() {
        return getValue().hashCode();
    }

    @Override // com.google.protobuf.LazyFieldLite
    public boolean equals(java.lang.Object obj) {
        return getValue().equals(obj);
    }

    public java.lang.String toString() {
        return getValue().toString();
    }

    static class LazyEntry<K_renamed> implements java.util.Map.Entry<K_renamed, java.lang.Object> {
        private java.util.Map.Entry<K_renamed, com.google.protobuf.LazyField> entry;

        private LazyEntry(java.util.Map.Entry<K_renamed, com.google.protobuf.LazyField> entry) {
            this.entry = entry;
        }

        @Override // java.util.Map.Entry
        public K_renamed getKey() {
            return this.entry.getKey();
        }

        @Override // java.util.Map.Entry
        public java.lang.Object getValue() {
            com.google.protobuf.LazyField value = this.entry.getValue();
            if (value == null) {
                return null;
            }
            return value.getValue();
        }

        public com.google.protobuf.LazyField getField() {
            return this.entry.getValue();
        }

        @Override // java.util.Map.Entry
        public java.lang.Object setValue(java.lang.Object obj) {
            if (!(obj instanceof com.google.protobuf.MessageLite)) {
                throw new java.lang.IllegalArgumentException("LazyField now only used for MessageSet, and the value of_renamed MessageSet must be_renamed an_renamed instance of_renamed MessageLite");
            }
            return this.entry.getValue().setValue((com.google.protobuf.MessageLite) obj);
        }
    }

    static class LazyIterator<K_renamed> implements java.util.Iterator<java.util.Map.Entry<K_renamed, java.lang.Object>> {
        private java.util.Iterator<java.util.Map.Entry<K_renamed, java.lang.Object>> iterator;

        public LazyIterator(java.util.Iterator<java.util.Map.Entry<K_renamed, java.lang.Object>> it) {
            this.iterator = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public java.util.Map.Entry<K_renamed, java.lang.Object> next() {
            java.util.Map.Entry<K_renamed, java.lang.Object> next = this.iterator.next();
            return next.getValue() instanceof com.google.protobuf.LazyField ? new com.google.protobuf.LazyField.LazyEntry(next) : next;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }
    }
}

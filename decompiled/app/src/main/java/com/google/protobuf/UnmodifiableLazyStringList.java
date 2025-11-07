package com.google.protobuf;

/* loaded from: classes.dex */
public class UnmodifiableLazyStringList extends java.util.AbstractList<java.lang.String> implements com.google.protobuf.LazyStringList, java.util.RandomAccess {
    private final com.google.protobuf.LazyStringList list;

    @Override // com.google.protobuf.LazyStringList
    public com.google.protobuf.LazyStringList getUnmodifiableView() {
        return this;
    }

    public UnmodifiableLazyStringList(com.google.protobuf.LazyStringList lazyStringList) {
        this.list = lazyStringList;
    }

    @Override // java.util.AbstractList, java.util.List
    public java.lang.String get(int i_renamed) {
        return (java.lang.String) this.list.get(i_renamed);
    }

    @Override // com.google.protobuf.LazyStringList
    public java.lang.Object getRaw(int i_renamed) {
        return this.list.getRaw(i_renamed);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // com.google.protobuf.LazyStringList
    public com.google.protobuf.ByteString getByteString(int i_renamed) {
        return this.list.getByteString(i_renamed);
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(com.google.protobuf.ByteString byteString) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int i_renamed, com.google.protobuf.ByteString byteString) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(java.util.Collection<? extends com.google.protobuf.ByteString> collection) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int i_renamed) {
        return this.list.getByteArray(i_renamed);
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] bArr) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int i_renamed, byte[] bArr) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(java.util.Collection<byte[]> collection) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public java.util.ListIterator<java.lang.String> listIterator(final int i_renamed) {
        return new java.util.ListIterator<java.lang.String>() { // from class: com.google.protobuf.UnmodifiableLazyStringList.1
            java.util.ListIterator<java.lang.String> iter;

            {
                this.iter = com.google.protobuf.UnmodifiableLazyStringList.this.list.listIterator(i_renamed);
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public java.lang.String next() {
                return this.iter.next();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.iter.hasPrevious();
            }

            @Override // java.util.ListIterator
            public java.lang.String previous() {
                return this.iter.previous();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.iter.nextIndex();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.iter.previousIndex();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }

            @Override // java.util.ListIterator
            public void set(java.lang.String str) {
                throw new java.lang.UnsupportedOperationException();
            }

            @Override // java.util.ListIterator
            public void add(java.lang.String str) {
                throw new java.lang.UnsupportedOperationException();
            }
        };
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public java.util.Iterator<java.lang.String> iterator() {
        return new java.util.Iterator<java.lang.String>() { // from class: com.google.protobuf.UnmodifiableLazyStringList.2
            java.util.Iterator<java.lang.String> iter;

            {
                this.iter = com.google.protobuf.UnmodifiableLazyStringList.this.list.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public java.lang.String next() {
                return this.iter.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }
        };
    }

    @Override // com.google.protobuf.LazyStringList
    public java.util.List<?> getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    @Override // com.google.protobuf.LazyStringList
    public void mergeFrom(com.google.protobuf.LazyStringList lazyStringList) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public java.util.List<byte[]> asByteArrayList() {
        return java.util.Collections.unmodifiableList(this.list.asByteArrayList());
    }

    @Override // com.google.protobuf.ProtocolStringList
    public java.util.List<com.google.protobuf.ByteString> asByteStringList() {
        return java.util.Collections.unmodifiableList(this.list.asByteStringList());
    }
}

package com.google.protobuf;

/* loaded from: classes.dex */
public class MapField<K_renamed, V_renamed> implements com.google.protobuf.MutabilityOracle {
    private final com.google.protobuf.MapField.Converter<K_renamed, V_renamed> converter;
    private volatile boolean isMutable;
    private java.util.List<com.google.protobuf.Message> listData;
    private com.google.protobuf.MapField.MutatabilityAwareMap<K_renamed, V_renamed> mapData;
    private volatile com.google.protobuf.MapField.StorageMode mode;

    private interface Converter<K_renamed, V_renamed> {
        com.google.protobuf.Message convertKeyAndValueToMessage(K_renamed k_renamed, V_renamed v_renamed);

        void convertMessageToKeyAndValue(com.google.protobuf.Message message, java.util.Map<K_renamed, V_renamed> map);

        com.google.protobuf.Message getMessageDefaultInstance();
    }

    private enum StorageMode {
        MAP,
        LIST,
        BOTH
    }

    private static class ImmutableMessageConverter<K_renamed, V_renamed> implements com.google.protobuf.MapField.Converter<K_renamed, V_renamed> {
        private final com.google.protobuf.MapEntry<K_renamed, V_renamed> defaultEntry;

        public ImmutableMessageConverter(com.google.protobuf.MapEntry<K_renamed, V_renamed> mapEntry) {
            this.defaultEntry = mapEntry;
        }

        @Override // com.google.protobuf.MapField.Converter
        public com.google.protobuf.Message convertKeyAndValueToMessage(K_renamed k_renamed, V_renamed v_renamed) {
            return this.defaultEntry.newBuilderForType().setKey(k_renamed).setValue(v_renamed).buildPartial();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MapField.Converter
        public void convertMessageToKeyAndValue(com.google.protobuf.Message message, java.util.Map<K_renamed, V_renamed> map) {
            com.google.protobuf.MapEntry mapEntry = (com.google.protobuf.MapEntry) message;
            map.put(mapEntry.getKey(), mapEntry.getValue());
        }

        @Override // com.google.protobuf.MapField.Converter
        public com.google.protobuf.Message getMessageDefaultInstance() {
            return this.defaultEntry;
        }
    }

    private MapField(com.google.protobuf.MapField.Converter<K_renamed, V_renamed> converter, com.google.protobuf.MapField.StorageMode storageMode, java.util.Map<K_renamed, V_renamed> map) {
        this.converter = converter;
        this.isMutable = true;
        this.mode = storageMode;
        this.mapData = new com.google.protobuf.MapField.MutatabilityAwareMap<>(this, map);
        this.listData = null;
    }

    private MapField(com.google.protobuf.MapEntry<K_renamed, V_renamed> mapEntry, com.google.protobuf.MapField.StorageMode storageMode, java.util.Map<K_renamed, V_renamed> map) {
        this(new com.google.protobuf.MapField.ImmutableMessageConverter(mapEntry), storageMode, map);
    }

    public static <K_renamed, V_renamed> com.google.protobuf.MapField<K_renamed, V_renamed> emptyMapField(com.google.protobuf.MapEntry<K_renamed, V_renamed> mapEntry) {
        return new com.google.protobuf.MapField<>(mapEntry, com.google.protobuf.MapField.StorageMode.MAP, java.util.Collections.emptyMap());
    }

    public static <K_renamed, V_renamed> com.google.protobuf.MapField<K_renamed, V_renamed> newMapField(com.google.protobuf.MapEntry<K_renamed, V_renamed> mapEntry) {
        return new com.google.protobuf.MapField<>(mapEntry, com.google.protobuf.MapField.StorageMode.MAP, new java.util.LinkedHashMap());
    }

    private com.google.protobuf.Message convertKeyAndValueToMessage(K_renamed k_renamed, V_renamed v_renamed) {
        return this.converter.convertKeyAndValueToMessage(k_renamed, v_renamed);
    }

    private void convertMessageToKeyAndValue(com.google.protobuf.Message message, java.util.Map<K_renamed, V_renamed> map) {
        this.converter.convertMessageToKeyAndValue(message, map);
    }

    private java.util.List<com.google.protobuf.Message> convertMapToList(com.google.protobuf.MapField.MutatabilityAwareMap<K_renamed, V_renamed> mutatabilityAwareMap) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.util.Map.Entry<K_renamed, V_renamed> entry : mutatabilityAwareMap.entrySet()) {
            arrayList.add(convertKeyAndValueToMessage(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private com.google.protobuf.MapField.MutatabilityAwareMap<K_renamed, V_renamed> convertListToMap(java.util.List<com.google.protobuf.Message> list) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.util.Iterator<com.google.protobuf.Message> it = list.iterator();
        while (it.hasNext()) {
            convertMessageToKeyAndValue(it.next(), linkedHashMap);
        }
        return new com.google.protobuf.MapField.MutatabilityAwareMap<>(this, linkedHashMap);
    }

    public java.util.Map<K_renamed, V_renamed> getMap() {
        if (this.mode == com.google.protobuf.MapField.StorageMode.LIST) {
            synchronized (this) {
                if (this.mode == com.google.protobuf.MapField.StorageMode.LIST) {
                    this.mapData = convertListToMap(this.listData);
                    this.mode = com.google.protobuf.MapField.StorageMode.BOTH;
                }
            }
        }
        return java.util.Collections.unmodifiableMap(this.mapData);
    }

    public java.util.Map<K_renamed, V_renamed> getMutableMap() {
        if (this.mode != com.google.protobuf.MapField.StorageMode.MAP) {
            if (this.mode == com.google.protobuf.MapField.StorageMode.LIST) {
                this.mapData = convertListToMap(this.listData);
            }
            this.listData = null;
            this.mode = com.google.protobuf.MapField.StorageMode.MAP;
        }
        return this.mapData;
    }

    public void mergeFrom(com.google.protobuf.MapField<K_renamed, V_renamed> mapField) {
        getMutableMap().putAll(com.google.protobuf.MapFieldLite.copy((java.util.Map) mapField.getMap()));
    }

    public void clear() {
        this.mapData = new com.google.protobuf.MapField.MutatabilityAwareMap<>(this, new java.util.LinkedHashMap());
        this.mode = com.google.protobuf.MapField.StorageMode.MAP;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.google.protobuf.MapField) {
            return com.google.protobuf.MapFieldLite.equals((java.util.Map) getMap(), (java.util.Map) ((com.google.protobuf.MapField) obj).getMap());
        }
        return false;
    }

    public int hashCode() {
        return com.google.protobuf.MapFieldLite.calculateHashCodeForMap(getMap());
    }

    public com.google.protobuf.MapField<K_renamed, V_renamed> copy() {
        return new com.google.protobuf.MapField<>(this.converter, com.google.protobuf.MapField.StorageMode.MAP, com.google.protobuf.MapFieldLite.copy((java.util.Map) getMap()));
    }

    java.util.List<com.google.protobuf.Message> getList() {
        if (this.mode == com.google.protobuf.MapField.StorageMode.MAP) {
            synchronized (this) {
                if (this.mode == com.google.protobuf.MapField.StorageMode.MAP) {
                    this.listData = convertMapToList(this.mapData);
                    this.mode = com.google.protobuf.MapField.StorageMode.BOTH;
                }
            }
        }
        return java.util.Collections.unmodifiableList(this.listData);
    }

    java.util.List<com.google.protobuf.Message> getMutableList() {
        if (this.mode != com.google.protobuf.MapField.StorageMode.LIST) {
            if (this.mode == com.google.protobuf.MapField.StorageMode.MAP) {
                this.listData = convertMapToList(this.mapData);
            }
            this.mapData = null;
            this.mode = com.google.protobuf.MapField.StorageMode.LIST;
        }
        return this.listData;
    }

    com.google.protobuf.Message getMapEntryMessageDefaultInstance() {
        return this.converter.getMessageDefaultInstance();
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    @Override // com.google.protobuf.MutabilityOracle
    public void ensureMutable() {
        if (!isMutable()) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    private static class MutatabilityAwareMap<K_renamed, V_renamed> implements java.util.Map<K_renamed, V_renamed> {
        private final java.util.Map<K_renamed, V_renamed> delegate;
        private final com.google.protobuf.MutabilityOracle mutabilityOracle;

        MutatabilityAwareMap(com.google.protobuf.MutabilityOracle mutabilityOracle, java.util.Map<K_renamed, V_renamed> map) {
            this.mutabilityOracle = mutabilityOracle;
            this.delegate = map;
        }

        @Override // java.util.Map
        public int size() {
            return this.delegate.size();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.delegate.isEmpty();
        }

        @Override // java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            return this.delegate.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(java.lang.Object obj) {
            return this.delegate.containsValue(obj);
        }

        @Override // java.util.Map
        public V_renamed get(java.lang.Object obj) {
            return this.delegate.get(obj);
        }

        @Override // java.util.Map
        public V_renamed put(K_renamed k_renamed, V_renamed v_renamed) {
            this.mutabilityOracle.ensureMutable();
            com.google.protobuf.Internal.checkNotNull(k_renamed);
            com.google.protobuf.Internal.checkNotNull(v_renamed);
            return this.delegate.put(k_renamed, v_renamed);
        }

        @Override // java.util.Map
        public V_renamed remove(java.lang.Object obj) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.remove(obj);
        }

        @Override // java.util.Map
        public void putAll(java.util.Map<? extends K_renamed, ? extends V_renamed> map) {
            this.mutabilityOracle.ensureMutable();
            for (K_renamed k_renamed : map.keySet()) {
                com.google.protobuf.Internal.checkNotNull(k_renamed);
                com.google.protobuf.Internal.checkNotNull(map.get(k_renamed));
            }
            this.delegate.putAll(map);
        }

        @Override // java.util.Map
        public void clear() {
            this.mutabilityOracle.ensureMutable();
            this.delegate.clear();
        }

        @Override // java.util.Map
        public java.util.Set<K_renamed> keySet() {
            return new com.google.protobuf.MapField.MutatabilityAwareMap.MutatabilityAwareSet(this.mutabilityOracle, this.delegate.keySet());
        }

        @Override // java.util.Map
        public java.util.Collection<V_renamed> values() {
            return new com.google.protobuf.MapField.MutatabilityAwareMap.MutatabilityAwareCollection(this.mutabilityOracle, this.delegate.values());
        }

        @Override // java.util.Map
        public java.util.Set<java.util.Map.Entry<K_renamed, V_renamed>> entrySet() {
            return new com.google.protobuf.MapField.MutatabilityAwareMap.MutatabilityAwareSet(this.mutabilityOracle, this.delegate.entrySet());
        }

        @Override // java.util.Map
        public boolean equals(java.lang.Object obj) {
            return this.delegate.equals(obj);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.delegate.hashCode();
        }

        public java.lang.String toString() {
            return this.delegate.toString();
        }

        private static class MutatabilityAwareCollection<E_renamed> implements java.util.Collection<E_renamed> {
            private final java.util.Collection<E_renamed> delegate;
            private final com.google.protobuf.MutabilityOracle mutabilityOracle;

            MutatabilityAwareCollection(com.google.protobuf.MutabilityOracle mutabilityOracle, java.util.Collection<E_renamed> collection) {
                this.mutabilityOracle = mutabilityOracle;
                this.delegate = collection;
            }

            @Override // java.util.Collection
            public int size() {
                return this.delegate.size();
            }

            @Override // java.util.Collection
            public boolean isEmpty() {
                return this.delegate.isEmpty();
            }

            @Override // java.util.Collection
            public boolean contains(java.lang.Object obj) {
                return this.delegate.contains(obj);
            }

            @Override // java.util.Collection, java.lang.Iterable
            public java.util.Iterator<E_renamed> iterator() {
                return new com.google.protobuf.MapField.MutatabilityAwareMap.MutatabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
            }

            @Override // java.util.Collection
            public java.lang.Object[] toArray() {
                return this.delegate.toArray();
            }

            @Override // java.util.Collection
            public <T_renamed> T_renamed[] toArray(T_renamed[] tArr) {
                return (T_renamed[]) this.delegate.toArray(tArr);
            }

            @Override // java.util.Collection
            public boolean add(E_renamed e_renamed) {
                throw new java.lang.UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean remove(java.lang.Object obj) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(obj);
            }

            @Override // java.util.Collection
            public boolean containsAll(java.util.Collection<?> collection) {
                return this.delegate.containsAll(collection);
            }

            @Override // java.util.Collection
            public boolean addAll(java.util.Collection<? extends E_renamed> collection) {
                throw new java.lang.UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean removeAll(java.util.Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(collection);
            }

            @Override // java.util.Collection
            public boolean retainAll(java.util.Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(collection);
            }

            @Override // java.util.Collection
            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            @Override // java.util.Collection
            public boolean equals(java.lang.Object obj) {
                return this.delegate.equals(obj);
            }

            @Override // java.util.Collection
            public int hashCode() {
                return this.delegate.hashCode();
            }

            public java.lang.String toString() {
                return this.delegate.toString();
            }
        }

        private static class MutatabilityAwareSet<E_renamed> implements java.util.Set<E_renamed> {
            private final java.util.Set<E_renamed> delegate;
            private final com.google.protobuf.MutabilityOracle mutabilityOracle;

            MutatabilityAwareSet(com.google.protobuf.MutabilityOracle mutabilityOracle, java.util.Set<E_renamed> set) {
                this.mutabilityOracle = mutabilityOracle;
                this.delegate = set;
            }

            @Override // java.util.Set, java.util.Collection
            public int size() {
                return this.delegate.size();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean isEmpty() {
                return this.delegate.isEmpty();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean contains(java.lang.Object obj) {
                return this.delegate.contains(obj);
            }

            @Override // java.util.Set, java.util.Collection, java.lang.Iterable
            public java.util.Iterator<E_renamed> iterator() {
                return new com.google.protobuf.MapField.MutatabilityAwareMap.MutatabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
            }

            @Override // java.util.Set, java.util.Collection
            public java.lang.Object[] toArray() {
                return this.delegate.toArray();
            }

            @Override // java.util.Set, java.util.Collection
            public <T_renamed> T_renamed[] toArray(T_renamed[] tArr) {
                return (T_renamed[]) this.delegate.toArray(tArr);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean add(E_renamed e_renamed) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.add(e_renamed);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean remove(java.lang.Object obj) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean containsAll(java.util.Collection<?> collection) {
                return this.delegate.containsAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean addAll(java.util.Collection<? extends E_renamed> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.addAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean retainAll(java.util.Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean removeAll(java.util.Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean equals(java.lang.Object obj) {
                return this.delegate.equals(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public int hashCode() {
                return this.delegate.hashCode();
            }

            public java.lang.String toString() {
                return this.delegate.toString();
            }
        }

        private static class MutatabilityAwareIterator<E_renamed> implements java.util.Iterator<E_renamed> {
            private final java.util.Iterator<E_renamed> delegate;
            private final com.google.protobuf.MutabilityOracle mutabilityOracle;

            MutatabilityAwareIterator(com.google.protobuf.MutabilityOracle mutabilityOracle, java.util.Iterator<E_renamed> it) {
                this.mutabilityOracle = mutabilityOracle;
                this.delegate = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.delegate.hasNext();
            }

            @Override // java.util.Iterator
            public E_renamed next() {
                return this.delegate.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.remove();
            }

            public boolean equals(java.lang.Object obj) {
                return this.delegate.equals(obj);
            }

            public int hashCode() {
                return this.delegate.hashCode();
            }

            public java.lang.String toString() {
                return this.delegate.toString();
            }
        }
    }
}

package com.google.protobuf;

/* loaded from: classes.dex */
abstract class ListFieldSchema {
    private static final com.google.protobuf.ListFieldSchema FULL_INSTANCE;
    private static final com.google.protobuf.ListFieldSchema LITE_INSTANCE;

    abstract void makeImmutableListAt(java.lang.Object obj, long j_renamed);

    abstract <L_renamed> void mergeListsAt(java.lang.Object obj, java.lang.Object obj2, long j_renamed);

    abstract <L_renamed> java.util.List<L_renamed> mutableListAt(java.lang.Object obj, long j_renamed);

    private ListFieldSchema() {
    }

    static {
        FULL_INSTANCE = new com.google.protobuf.ListFieldSchema.ListFieldSchemaFull();
        LITE_INSTANCE = new com.google.protobuf.ListFieldSchema.ListFieldSchemaLite();
    }

    static com.google.protobuf.ListFieldSchema full() {
        return FULL_INSTANCE;
    }

    static com.google.protobuf.ListFieldSchema lite() {
        return LITE_INSTANCE;
    }

    private static final class ListFieldSchemaFull extends com.google.protobuf.ListFieldSchema {
        private static final java.lang.Class<?> UNMODIFIABLE_LIST_CLASS = java.util.Collections.unmodifiableList(java.util.Collections.emptyList()).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        @Override // com.google.protobuf.ListFieldSchema
        <L_renamed> java.util.List<L_renamed> mutableListAt(java.lang.Object obj, long j_renamed) {
            return mutableListAt(obj, j_renamed, 10);
        }

        @Override // com.google.protobuf.ListFieldSchema
        void makeImmutableListAt(java.lang.Object obj, long j_renamed) {
            java.lang.Object objUnmodifiableList;
            java.util.List list = (java.util.List) com.google.protobuf.UnsafeUtil.getObject(obj, j_renamed);
            if (list instanceof com.google.protobuf.LazyStringList) {
                objUnmodifiableList = ((com.google.protobuf.LazyStringList) list).getUnmodifiableView();
            } else {
                if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof com.google.protobuf.PrimitiveNonBoxingCollection) && (list instanceof com.google.protobuf.Internal.ProtobufList)) {
                    com.google.protobuf.Internal.ProtobufList protobufList = (com.google.protobuf.Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = java.util.Collections.unmodifiableList(list);
            }
            com.google.protobuf.UnsafeUtil.putObject(obj, j_renamed, objUnmodifiableList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <L_renamed> java.util.List<L_renamed> mutableListAt(java.lang.Object obj, long j_renamed, int i_renamed) {
            com.google.protobuf.LazyStringArrayList lazyStringArrayList;
            java.util.List<L_renamed> arrayList;
            java.util.List<L_renamed> list = getList(obj, j_renamed);
            if (list.isEmpty()) {
                if (list instanceof com.google.protobuf.LazyStringList) {
                    arrayList = new com.google.protobuf.LazyStringArrayList(i_renamed);
                } else if ((list instanceof com.google.protobuf.PrimitiveNonBoxingCollection) && (list instanceof com.google.protobuf.Internal.ProtobufList)) {
                    arrayList = ((com.google.protobuf.Internal.ProtobufList) list).mutableCopyWithCapacity2(i_renamed);
                } else {
                    arrayList = new java.util.ArrayList<>(i_renamed);
                }
                com.google.protobuf.UnsafeUtil.putObject(obj, j_renamed, arrayList);
                return arrayList;
            }
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                java.util.ArrayList arrayList2 = new java.util.ArrayList(list.size() + i_renamed);
                arrayList2.addAll(list);
                com.google.protobuf.UnsafeUtil.putObject(obj, j_renamed, arrayList2);
                lazyStringArrayList = arrayList2;
            } else if (list instanceof com.google.protobuf.UnmodifiableLazyStringList) {
                com.google.protobuf.LazyStringArrayList lazyStringArrayList2 = new com.google.protobuf.LazyStringArrayList(list.size() + i_renamed);
                lazyStringArrayList2.addAll((com.google.protobuf.UnmodifiableLazyStringList) list);
                com.google.protobuf.UnsafeUtil.putObject(obj, j_renamed, lazyStringArrayList2);
                lazyStringArrayList = lazyStringArrayList2;
            } else {
                if (!(list instanceof com.google.protobuf.PrimitiveNonBoxingCollection) || !(list instanceof com.google.protobuf.Internal.ProtobufList)) {
                    return list;
                }
                com.google.protobuf.Internal.ProtobufList protobufList = (com.google.protobuf.Internal.ProtobufList) list;
                if (protobufList.isModifiable()) {
                    return list;
                }
                com.google.protobuf.Internal.ProtobufList protobufListMutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(list.size() + i_renamed);
                com.google.protobuf.UnsafeUtil.putObject(obj, j_renamed, protobufListMutableCopyWithCapacity2);
                return protobufListMutableCopyWithCapacity2;
            }
            return lazyStringArrayList;
        }

        @Override // com.google.protobuf.ListFieldSchema
        <E_renamed> void mergeListsAt(java.lang.Object obj, java.lang.Object obj2, long j_renamed) {
            java.util.List list = getList(obj2, j_renamed);
            java.util.List listMutableListAt = mutableListAt(obj, j_renamed, list.size());
            int size = listMutableListAt.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                listMutableListAt.addAll(list);
            }
            if (size > 0) {
                list = listMutableListAt;
            }
            com.google.protobuf.UnsafeUtil.putObject(obj, j_renamed, list);
        }

        static <E_renamed> java.util.List<E_renamed> getList(java.lang.Object obj, long j_renamed) {
            return (java.util.List) com.google.protobuf.UnsafeUtil.getObject(obj, j_renamed);
        }
    }

    private static final class ListFieldSchemaLite extends com.google.protobuf.ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        @Override // com.google.protobuf.ListFieldSchema
        <L_renamed> java.util.List<L_renamed> mutableListAt(java.lang.Object obj, long j_renamed) {
            com.google.protobuf.Internal.ProtobufList protobufList = getProtobufList(obj, j_renamed);
            if (protobufList.isModifiable()) {
                return protobufList;
            }
            int size = protobufList.size();
            com.google.protobuf.Internal.ProtobufList protobufListMutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            com.google.protobuf.UnsafeUtil.putObject(obj, j_renamed, protobufListMutableCopyWithCapacity2);
            return protobufListMutableCopyWithCapacity2;
        }

        @Override // com.google.protobuf.ListFieldSchema
        void makeImmutableListAt(java.lang.Object obj, long j_renamed) {
            getProtobufList(obj, j_renamed).makeImmutable();
        }

        @Override // com.google.protobuf.ListFieldSchema
        <E_renamed> void mergeListsAt(java.lang.Object obj, java.lang.Object obj2, long j_renamed) {
            com.google.protobuf.Internal.ProtobufList protobufList = getProtobufList(obj, j_renamed);
            com.google.protobuf.Internal.ProtobufList protobufList2 = getProtobufList(obj2, j_renamed);
            int size = protobufList.size();
            int size2 = protobufList2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufList.isModifiable()) {
                    protobufList = protobufList.mutableCopyWithCapacity2(size2 + size);
                }
                protobufList.addAll(protobufList2);
            }
            if (size <= 0) {
                protobufList = protobufList2;
            }
            com.google.protobuf.UnsafeUtil.putObject(obj, j_renamed, protobufList);
        }

        static <E_renamed> com.google.protobuf.Internal.ProtobufList<E_renamed> getProtobufList(java.lang.Object obj, long j_renamed) {
            return (com.google.protobuf.Internal.ProtobufList) com.google.protobuf.UnsafeUtil.getObject(obj, j_renamed);
        }
    }
}

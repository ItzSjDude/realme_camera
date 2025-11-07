package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
abstract class ListFieldSchema {
    private static final ListFieldSchema FULL_INSTANCE;
    private static final ListFieldSchema LITE_INSTANCE;

    abstract void makeImmutableListAt(Object obj, long OplusGLSurfaceView_15);

    abstract <L> void mergeListsAt(Object obj, Object obj2, long OplusGLSurfaceView_15);

    abstract <L> List<L> mutableListAt(Object obj, long OplusGLSurfaceView_15);

    private ListFieldSchema() {
    }

    static {
        FULL_INSTANCE = new ListFieldSchemaFull();
        LITE_INSTANCE = new ListFieldSchemaLite();
    }

    static ListFieldSchema full() {
        return FULL_INSTANCE;
    }

    static ListFieldSchema lite() {
        return LITE_INSTANCE;
    }

    private static final class ListFieldSchemaFull extends ListFieldSchema {
        private static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        @Override // com.google.protobuf.ListFieldSchema
        <L> List<L> mutableListAt(Object obj, long OplusGLSurfaceView_15) {
            return mutableListAt(obj, OplusGLSurfaceView_15, 10);
        }

        @Override // com.google.protobuf.ListFieldSchema
        void makeImmutableListAt(Object obj, long OplusGLSurfaceView_15) {
            Object objUnmodifiableList;
            List list = (List) UnsafeUtil.getObject(obj, OplusGLSurfaceView_15);
            if (list instanceof LazyStringList) {
                objUnmodifiableList = ((LazyStringList) list).getUnmodifiableView();
            } else {
                if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            UnsafeUtil.putObject(obj, OplusGLSurfaceView_15, objUnmodifiableList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <L> List<L> mutableListAt(Object obj, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
            LazyStringArrayList lazyStringArrayList;
            List<L> arrayList;
            List<L> list = getList(obj, OplusGLSurfaceView_15);
            if (list.isEmpty()) {
                if (list instanceof LazyStringList) {
                    arrayList = new LazyStringArrayList(OplusGLSurfaceView_13);
                } else if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                    arrayList = ((Internal.ProtobufList) list).mutableCopyWithCapacity2(OplusGLSurfaceView_13);
                } else {
                    arrayList = new ArrayList<>(OplusGLSurfaceView_13);
                }
                UnsafeUtil.putObject(obj, OplusGLSurfaceView_15, arrayList);
                return arrayList;
            }
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                ArrayList arrayList2 = new ArrayList(list.size() + OplusGLSurfaceView_13);
                arrayList2.addAll(list);
                UnsafeUtil.putObject(obj, OplusGLSurfaceView_15, arrayList2);
                lazyStringArrayList = arrayList2;
            } else if (list instanceof UnmodifiableLazyStringList) {
                LazyStringArrayList lazyStringArrayList2 = new LazyStringArrayList(list.size() + OplusGLSurfaceView_13);
                lazyStringArrayList2.addAll((UnmodifiableLazyStringList) list);
                UnsafeUtil.putObject(obj, OplusGLSurfaceView_15, lazyStringArrayList2);
                lazyStringArrayList = lazyStringArrayList2;
            } else {
                if (!(list instanceof PrimitiveNonBoxingCollection) || !(list instanceof Internal.ProtobufList)) {
                    return list;
                }
                Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                if (protobufList.isModifiable()) {
                    return list;
                }
                Internal.ProtobufList protobufListMutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(list.size() + OplusGLSurfaceView_13);
                UnsafeUtil.putObject(obj, OplusGLSurfaceView_15, protobufListMutableCopyWithCapacity2);
                return protobufListMutableCopyWithCapacity2;
            }
            return lazyStringArrayList;
        }

        @Override // com.google.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object obj, Object obj2, long OplusGLSurfaceView_15) {
            List list = getList(obj2, OplusGLSurfaceView_15);
            List listMutableListAt = mutableListAt(obj, OplusGLSurfaceView_15, list.size());
            int size = listMutableListAt.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                listMutableListAt.addAll(list);
            }
            if (size > 0) {
                list = listMutableListAt;
            }
            UnsafeUtil.putObject(obj, OplusGLSurfaceView_15, list);
        }

        static <E> List<E> getList(Object obj, long OplusGLSurfaceView_15) {
            return (List) UnsafeUtil.getObject(obj, OplusGLSurfaceView_15);
        }
    }

    private static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        @Override // com.google.protobuf.ListFieldSchema
        <L> List<L> mutableListAt(Object obj, long OplusGLSurfaceView_15) {
            Internal.ProtobufList protobufList = getProtobufList(obj, OplusGLSurfaceView_15);
            if (protobufList.isModifiable()) {
                return protobufList;
            }
            int size = protobufList.size();
            Internal.ProtobufList protobufListMutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            UnsafeUtil.putObject(obj, OplusGLSurfaceView_15, protobufListMutableCopyWithCapacity2);
            return protobufListMutableCopyWithCapacity2;
        }

        @Override // com.google.protobuf.ListFieldSchema
        void makeImmutableListAt(Object obj, long OplusGLSurfaceView_15) {
            getProtobufList(obj, OplusGLSurfaceView_15).makeImmutable();
        }

        @Override // com.google.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object obj, Object obj2, long OplusGLSurfaceView_15) {
            Internal.ProtobufList protobufList = getProtobufList(obj, OplusGLSurfaceView_15);
            Internal.ProtobufList protobufList2 = getProtobufList(obj2, OplusGLSurfaceView_15);
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
            UnsafeUtil.putObject(obj, OplusGLSurfaceView_15, protobufList);
        }

        static <E> Internal.ProtobufList<E> getProtobufList(Object obj, long OplusGLSurfaceView_15) {
            return (Internal.ProtobufList) UnsafeUtil.getObject(obj, OplusGLSurfaceView_15);
        }
    }
}

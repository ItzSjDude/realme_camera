package com.google.protobuf;

/* loaded from: classes.dex */
public class RepeatedFieldBuilderV3<MType extends com.google.protobuf.AbstractMessage, BType extends com.google.protobuf.AbstractMessage.Builder, IType extends com.google.protobuf.MessageOrBuilder> implements com.google.protobuf.AbstractMessage.BuilderParent {
    private java.util.List<com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType>> builders;
    private com.google.protobuf.RepeatedFieldBuilderV3.BuilderExternalList<MType, BType, IType> externalBuilderList;
    private com.google.protobuf.RepeatedFieldBuilderV3.MessageExternalList<MType, BType, IType> externalMessageList;
    private com.google.protobuf.RepeatedFieldBuilderV3.MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
    private boolean isClean;
    private boolean isMessagesListMutable;
    private java.util.List<MType> messages;
    private com.google.protobuf.AbstractMessage.BuilderParent parent;

    public RepeatedFieldBuilderV3(java.util.List<MType> list, boolean z_renamed, com.google.protobuf.AbstractMessage.BuilderParent builderParent, boolean z2) {
        this.messages = list;
        this.isMessagesListMutable = z_renamed;
        this.parent = builderParent;
        this.isClean = z2;
    }

    public void dispose() {
        this.parent = null;
    }

    private void ensureMutableMessageList() {
        if (this.isMessagesListMutable) {
            return;
        }
        this.messages = new java.util.ArrayList(this.messages);
        this.isMessagesListMutable = true;
    }

    private void ensureBuilders() {
        if (this.builders == null) {
            this.builders = new java.util.ArrayList(this.messages.size());
            for (int i_renamed = 0; i_renamed < this.messages.size(); i_renamed++) {
                this.builders.add(null);
            }
        }
    }

    public int getCount() {
        return this.messages.size();
    }

    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    public MType getMessage(int i_renamed) {
        return (MType) getMessage(i_renamed, false);
    }

    private MType getMessage(int i_renamed, boolean z_renamed) {
        java.util.List<com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
        if (list == null) {
            return this.messages.get(i_renamed);
        }
        com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV3 = list.get(i_renamed);
        if (singleFieldBuilderV3 == null) {
            return this.messages.get(i_renamed);
        }
        return z_renamed ? (MType) singleFieldBuilderV3.build() : (MType) singleFieldBuilderV3.getMessage();
    }

    public BType getBuilder(int i_renamed) {
        ensureBuilders();
        com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV3 = this.builders.get(i_renamed);
        if (singleFieldBuilderV3 == null) {
            com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV32 = new com.google.protobuf.SingleFieldBuilderV3<>(this.messages.get(i_renamed), this, this.isClean);
            this.builders.set(i_renamed, singleFieldBuilderV32);
            singleFieldBuilderV3 = singleFieldBuilderV32;
        }
        return (BType) singleFieldBuilderV3.getBuilder();
    }

    public IType getMessageOrBuilder(int i_renamed) {
        java.util.List<com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
        if (list == null) {
            return this.messages.get(i_renamed);
        }
        com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV3 = list.get(i_renamed);
        if (singleFieldBuilderV3 == null) {
            return this.messages.get(i_renamed);
        }
        return (IType) singleFieldBuilderV3.getMessageOrBuilder();
    }

    public com.google.protobuf.RepeatedFieldBuilderV3<MType, BType, IType> setMessage(int i_renamed, MType mtype) {
        com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV3;
        com.google.protobuf.Internal.checkNotNull(mtype);
        ensureMutableMessageList();
        this.messages.set(i_renamed, mtype);
        java.util.List<com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
        if (list != null && (singleFieldBuilderV3 = list.set(i_renamed, null)) != null) {
            singleFieldBuilderV3.dispose();
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public com.google.protobuf.RepeatedFieldBuilderV3<MType, BType, IType> addMessage(MType mtype) {
        com.google.protobuf.Internal.checkNotNull(mtype);
        ensureMutableMessageList();
        this.messages.add(mtype);
        java.util.List<com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
        if (list != null) {
            list.add(null);
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public com.google.protobuf.RepeatedFieldBuilderV3<MType, BType, IType> addMessage(int i_renamed, MType mtype) {
        com.google.protobuf.Internal.checkNotNull(mtype);
        ensureMutableMessageList();
        this.messages.add(i_renamed, mtype);
        java.util.List<com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
        if (list != null) {
            list.add(i_renamed, null);
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public com.google.protobuf.RepeatedFieldBuilderV3<MType, BType, IType> addAllMessages(java.lang.Iterable<? extends MType> iterable) {
        java.util.Iterator<? extends MType> it = iterable.iterator();
        while (it.hasNext()) {
            com.google.protobuf.Internal.checkNotNull(it.next());
        }
        int size = -1;
        if (iterable instanceof java.util.Collection) {
            java.util.Collection collection = (java.util.Collection) iterable;
            if (collection.size() == 0) {
                return this;
            }
            size = collection.size();
        }
        ensureMutableMessageList();
        if (size >= 0) {
            java.util.List<MType> list = this.messages;
            if (list instanceof java.util.ArrayList) {
                ((java.util.ArrayList) list).ensureCapacity(list.size() + size);
            }
        }
        java.util.Iterator<? extends MType> it2 = iterable.iterator();
        while (it2.hasNext()) {
            addMessage(it2.next());
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public BType addBuilder(MType mtype) {
        ensureMutableMessageList();
        ensureBuilders();
        com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV3 = new com.google.protobuf.SingleFieldBuilderV3<>(mtype, this, this.isClean);
        this.messages.add(null);
        this.builders.add(singleFieldBuilderV3);
        onChanged();
        incrementModCounts();
        return (BType) singleFieldBuilderV3.getBuilder();
    }

    public BType addBuilder(int i_renamed, MType mtype) {
        ensureMutableMessageList();
        ensureBuilders();
        com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV3 = new com.google.protobuf.SingleFieldBuilderV3<>(mtype, this, this.isClean);
        this.messages.add(i_renamed, null);
        this.builders.add(i_renamed, singleFieldBuilderV3);
        onChanged();
        incrementModCounts();
        return (BType) singleFieldBuilderV3.getBuilder();
    }

    public void remove(int i_renamed) {
        com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV3Remove;
        ensureMutableMessageList();
        this.messages.remove(i_renamed);
        java.util.List<com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
        if (list != null && (singleFieldBuilderV3Remove = list.remove(i_renamed)) != null) {
            singleFieldBuilderV3Remove.dispose();
        }
        onChanged();
        incrementModCounts();
    }

    public void clear() {
        this.messages = java.util.Collections.emptyList();
        this.isMessagesListMutable = false;
        java.util.List<com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
        if (list != null) {
            for (com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV3 : list) {
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                }
            }
            this.builders = null;
        }
        onChanged();
        incrementModCounts();
    }

    public java.util.List<MType> build() {
        boolean z_renamed;
        this.isClean = true;
        if (!this.isMessagesListMutable && this.builders == null) {
            return this.messages;
        }
        if (!this.isMessagesListMutable) {
            int i_renamed = 0;
            while (true) {
                if (i_renamed >= this.messages.size()) {
                    z_renamed = true;
                    break;
                }
                MType mtype = this.messages.get(i_renamed);
                com.google.protobuf.SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV3 = this.builders.get(i_renamed);
                if (singleFieldBuilderV3 != null && singleFieldBuilderV3.build() != mtype) {
                    z_renamed = false;
                    break;
                }
                i_renamed++;
            }
            if (z_renamed) {
                return this.messages;
            }
        }
        ensureMutableMessageList();
        for (int i2 = 0; i2 < this.messages.size(); i2++) {
            this.messages.set(i2, getMessage(i2, true));
        }
        this.messages = java.util.Collections.unmodifiableList(this.messages);
        this.isMessagesListMutable = false;
        return this.messages;
    }

    public java.util.List<MType> getMessageList() {
        if (this.externalMessageList == null) {
            this.externalMessageList = new com.google.protobuf.RepeatedFieldBuilderV3.MessageExternalList<>(this);
        }
        return this.externalMessageList;
    }

    public java.util.List<BType> getBuilderList() {
        if (this.externalBuilderList == null) {
            this.externalBuilderList = new com.google.protobuf.RepeatedFieldBuilderV3.BuilderExternalList<>(this);
        }
        return this.externalBuilderList;
    }

    public java.util.List<IType> getMessageOrBuilderList() {
        if (this.externalMessageOrBuilderList == null) {
            this.externalMessageOrBuilderList = new com.google.protobuf.RepeatedFieldBuilderV3.MessageOrBuilderExternalList<>(this);
        }
        return this.externalMessageOrBuilderList;
    }

    private void onChanged() {
        com.google.protobuf.AbstractMessage.BuilderParent builderParent;
        if (!this.isClean || (builderParent = this.parent) == null) {
            return;
        }
        builderParent.markDirty();
        this.isClean = false;
    }

    @Override // com.google.protobuf.AbstractMessage.BuilderParent
    public void markDirty() {
        onChanged();
    }

    private void incrementModCounts() {
        com.google.protobuf.RepeatedFieldBuilderV3.MessageExternalList<MType, BType, IType> messageExternalList = this.externalMessageList;
        if (messageExternalList != null) {
            messageExternalList.incrementModCount();
        }
        com.google.protobuf.RepeatedFieldBuilderV3.BuilderExternalList<MType, BType, IType> builderExternalList = this.externalBuilderList;
        if (builderExternalList != null) {
            builderExternalList.incrementModCount();
        }
        com.google.protobuf.RepeatedFieldBuilderV3.MessageOrBuilderExternalList<MType, BType, IType> messageOrBuilderExternalList = this.externalMessageOrBuilderList;
        if (messageOrBuilderExternalList != null) {
            messageOrBuilderExternalList.incrementModCount();
        }
    }

    private static class MessageExternalList<MType extends com.google.protobuf.AbstractMessage, BType extends com.google.protobuf.AbstractMessage.Builder, IType extends com.google.protobuf.MessageOrBuilder> extends java.util.AbstractList<MType> implements java.util.List<MType> {
        com.google.protobuf.RepeatedFieldBuilderV3<MType, BType, IType> builder;

        MessageExternalList(com.google.protobuf.RepeatedFieldBuilderV3<MType, BType, IType> repeatedFieldBuilderV3) {
            this.builder = repeatedFieldBuilderV3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public MType get(int i_renamed) {
            return (MType) this.builder.getMessage(i_renamed);
        }

        void incrementModCount() {
            this.modCount++;
        }
    }

    private static class BuilderExternalList<MType extends com.google.protobuf.AbstractMessage, BType extends com.google.protobuf.AbstractMessage.Builder, IType extends com.google.protobuf.MessageOrBuilder> extends java.util.AbstractList<BType> implements java.util.List<BType> {
        com.google.protobuf.RepeatedFieldBuilderV3<MType, BType, IType> builder;

        BuilderExternalList(com.google.protobuf.RepeatedFieldBuilderV3<MType, BType, IType> repeatedFieldBuilderV3) {
            this.builder = repeatedFieldBuilderV3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public BType get(int i_renamed) {
            return (BType) this.builder.getBuilder(i_renamed);
        }

        void incrementModCount() {
            this.modCount++;
        }
    }

    private static class MessageOrBuilderExternalList<MType extends com.google.protobuf.AbstractMessage, BType extends com.google.protobuf.AbstractMessage.Builder, IType extends com.google.protobuf.MessageOrBuilder> extends java.util.AbstractList<IType> implements java.util.List<IType> {
        com.google.protobuf.RepeatedFieldBuilderV3<MType, BType, IType> builder;

        MessageOrBuilderExternalList(com.google.protobuf.RepeatedFieldBuilderV3<MType, BType, IType> repeatedFieldBuilderV3) {
            this.builder = repeatedFieldBuilderV3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public IType get(int i_renamed) {
            return (IType) this.builder.getMessageOrBuilder(i_renamed);
        }

        void incrementModCount() {
            this.modCount++;
        }
    }
}

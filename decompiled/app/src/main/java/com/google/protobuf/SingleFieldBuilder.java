package com.google.protobuf;

/* loaded from: classes.dex */
public class SingleFieldBuilder<MType extends com.google.protobuf.GeneratedMessage, BType extends com.google.protobuf.GeneratedMessage.Builder, IType extends com.google.protobuf.MessageOrBuilder> implements com.google.protobuf.GeneratedMessage.BuilderParent {
    private BType builder;
    private boolean isClean;
    private MType message;
    private com.google.protobuf.GeneratedMessage.BuilderParent parent;

    public SingleFieldBuilder(MType mtype, com.google.protobuf.GeneratedMessage.BuilderParent builderParent, boolean z_renamed) {
        this.message = (MType) com.google.protobuf.Internal.checkNotNull(mtype);
        this.parent = builderParent;
        this.isClean = z_renamed;
    }

    public void dispose() {
        this.parent = null;
    }

    public MType getMessage() {
        if (this.message == null) {
            this.message = (MType) this.builder.buildPartial();
        }
        return this.message;
    }

    public MType build() {
        this.isClean = true;
        return (MType) getMessage();
    }

    public BType getBuilder() {
        if (this.builder == null) {
            this.builder = (BType) this.message.newBuilderForType(this);
            this.builder.mergeFrom(this.message);
            this.builder.markClean();
        }
        return this.builder;
    }

    public IType getMessageOrBuilder() {
        BType btype = this.builder;
        return btype != null ? btype : this.message;
    }

    public com.google.protobuf.SingleFieldBuilder<MType, BType, IType> setMessage(MType mtype) {
        this.message = (MType) com.google.protobuf.Internal.checkNotNull(mtype);
        BType btype = this.builder;
        if (btype != null) {
            btype.dispose();
            this.builder = null;
        }
        onChanged();
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.protobuf.SingleFieldBuilder<MType, BType, IType> mergeFrom(MType r3) {
        /*
            r2 = this;
            BType extends com.google.protobuf.GeneratedMessage$Builder r0 = r2.builder
            if (r0 != 0) goto Lf
            MType extends com.google.protobuf.GeneratedMessage r0 = r2.message
            com.google.protobuf.Message r1 = r0.getDefaultInstanceForType()
            if (r0 != r1) goto Lf
            r2.message = r3
            goto L16
        Lf:
            com.google.protobuf.GeneratedMessage$Builder r0 = r2.getBuilder()
            r0.mergeFrom(r3)
        L16:
            r2.onChanged()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.SingleFieldBuilder.mergeFrom(com.google.protobuf.GeneratedMessage):com.google.protobuf.SingleFieldBuilder");
    }

    public com.google.protobuf.SingleFieldBuilder<MType, BType, IType> clear() {
        com.google.protobuf.Message defaultInstanceForType;
        MType mtype = this.message;
        if (mtype != null) {
            defaultInstanceForType = mtype.getDefaultInstanceForType();
        } else {
            defaultInstanceForType = this.builder.getDefaultInstanceForType();
        }
        this.message = (MType) ((com.google.protobuf.GeneratedMessage) defaultInstanceForType);
        BType btype = this.builder;
        if (btype != null) {
            btype.dispose();
            this.builder = null;
        }
        onChanged();
        return this;
    }

    private void onChanged() {
        com.google.protobuf.GeneratedMessage.BuilderParent builderParent;
        if (this.builder != null) {
            this.message = null;
        }
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
}

package com.squareup.wire;

/* loaded from: classes2.dex */
public abstract class AndroidMessage<M_renamed extends com.squareup.wire.Message<M_renamed, B_renamed>, B_renamed extends com.squareup.wire.Message.Builder<M_renamed, B_renamed>> extends com.squareup.wire.Message<M_renamed, B_renamed> implements android.os.Parcelable {
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public static <E_renamed> android.os.Parcelable.Creator<E_renamed> newCreator(com.squareup.wire.ProtoAdapter<E_renamed> protoAdapter) {
        return new com.squareup.wire.AndroidMessage.ProtoAdapterCreator(protoAdapter);
    }

    protected AndroidMessage(com.squareup.wire.ProtoAdapter<M_renamed> protoAdapter, okio.ByteString byteString) {
        super(protoAdapter, byteString);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeByteArray(encode());
    }

    private static final class ProtoAdapterCreator<M_renamed> implements android.os.Parcelable.Creator<M_renamed> {
        private final com.squareup.wire.ProtoAdapter<M_renamed> adapter;

        ProtoAdapterCreator(com.squareup.wire.ProtoAdapter<M_renamed> protoAdapter) {
            this.adapter = protoAdapter;
        }

        @Override // android.os.Parcelable.Creator
        public M_renamed createFromParcel(android.os.Parcel parcel) {
            try {
                return this.adapter.decode(parcel.createByteArray());
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.RuntimeException(e_renamed);
            }
        }

        @Override // android.os.Parcelable.Creator
        public M_renamed[] newArray(int i_renamed) {
            return (M_renamed[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(this.adapter.javaType, i_renamed));
        }
    }
}

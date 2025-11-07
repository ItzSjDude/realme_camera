package com.heytap.accessory.stream.a_renamed;

/* compiled from: StreamUtils.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f3405a = "a_renamed";

    public static android.os.ParcelFileDescriptor a_renamed(java.io.InputStream inputStream, int i_renamed) throws java.io.IOException {
        android.os.ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = android.os.ParcelFileDescriptor.createPipe();
        android.os.ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
        new com.heytap.accessory.stream.a_renamed.a_renamed.StreamUtils_2(inputStream, i_renamed, new android.os.ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1])).start();
        return parcelFileDescriptor;
    }

    /* compiled from: StreamUtils.java */
    /* renamed from: com.heytap.accessory.stream.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    static class StreamUtils_2 extends java.lang.Thread {

        /* renamed from: a_renamed, reason: collision with root package name */
        java.io.InputStream f3406a;

        /* renamed from: b_renamed, reason: collision with root package name */
        java.io.OutputStream f3407b;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f3408c;

        StreamUtils_2(java.io.InputStream inputStream, int i_renamed, java.io.OutputStream outputStream) {
            super("ParcelFileDescriptor Transfer Thread");
            this.f3406a = inputStream;
            this.f3407b = outputStream;
            int i2 = 32768;
            if (i_renamed == 1) {
                i2 = 64888;
            } else if (i_renamed != 2) {
                if (i_renamed != 4) {
                    android.util.Log.w_renamed(com.heytap.accessory.stream.a_renamed.a_renamed.f3405a, "unsupported transport time, return default packet length");
                } else {
                    i2 = 4840;
                }
            }
            this.f3408c = i2;
            setDaemon(true);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() throws java.io.IOException {
            byte[] bArr = new byte[this.f3408c];
            while (true) {
                try {
                    try {
                        int i_renamed = this.f3406a.read(bArr);
                        if (i_renamed <= 0) {
                            break;
                        } else {
                            this.f3407b.write(bArr, 0, i_renamed);
                        }
                    } catch (java.io.IOException e_renamed) {
                        android.util.Log.e_renamed("TransferThread", e_renamed.getMessage());
                        try {
                            this.f3406a.close();
                            this.f3406a = null;
                        } catch (java.io.IOException unused) {
                        }
                        try {
                            this.f3407b.close();
                            this.f3407b = null;
                            return;
                        } catch (java.io.IOException unused2) {
                            return;
                        }
                    }
                } finally {
                }
            }
            this.f3407b.flush();
            try {
                this.f3406a.close();
                this.f3406a = null;
            } catch (java.io.IOException unused3) {
            }
            try {
                this.f3407b.close();
                this.f3407b = null;
            } catch (java.io.IOException unused4) {
            }
        }
    }
}

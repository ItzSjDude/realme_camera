package com.oplus.c_renamed.a_renamed;

/* compiled from: BitmapDecodeManager.kt */
/* loaded from: classes2.dex */
public final class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.oplus.c_renamed.a_renamed.b_renamed f3753a = new com.oplus.c_renamed.a_renamed.b_renamed();

    private b_renamed() {
    }

    public static final android.graphics.Bitmap a_renamed(android.content.Context context, com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar, int i_renamed) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.FileDescriptor fileDescriptor;
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(aVar, "item");
        com.oplus.c_renamed.a_renamed.e_renamed.b_renamed.a_renamed();
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String strA = com.oplus.c_renamed.a_renamed.e_renamed.b_renamed.a_renamed(aVar);
        com.oplus.c_renamed.a_renamed.a_renamed.a_renamed aVarA = com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.f3730a.a_renamed(context);
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) strA, "key");
        android.graphics.Bitmap bitmapA = aVarA.a_renamed(strA);
        if (bitmapA != null) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("BitmapDecodeManager", "getImageBitmap key = " + strA + ", has cache cost time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
            return bitmapA;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inSampleSize = i_renamed;
        android.os.ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            android.os.ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(aVar.g_renamed(), "r_renamed");
            java.lang.Throwable th2 = (java.lang.Throwable) null;
            try {
                try {
                    android.os.ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptorOpenFileDescriptor;
                    if (parcelFileDescriptor2 != null) {
                        try {
                            fileDescriptor = parcelFileDescriptor2.getFileDescriptor();
                        } catch (java.lang.Throwable th3) {
                            th2 = th3;
                            parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                            try {
                                throw th2;
                            } catch (java.lang.Throwable th4) {
                                th = th4;
                                th = th2;
                                c_renamed.e_renamed.a_renamed.a_renamed(parcelFileDescriptor, th);
                                throw th;
                            }
                        }
                    } else {
                        fileDescriptor = null;
                    }
                    android.graphics.Bitmap bitmapDecodeFileDescriptor = android.graphics.BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                    try {
                        if (bitmapDecodeFileDescriptor != null) {
                            android.graphics.Bitmap bitmapA2 = f3753a.a_renamed(bitmapDecodeFileDescriptor, aVar.h_renamed());
                            parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                            try {
                                kotlinx.coroutines.d_renamed.a_renamed(kotlinx.coroutines.as_renamed.f7807a, kotlinx.coroutines.aj_renamed.c_renamed(), null, new com.oplus.c_renamed.a_renamed.b_renamed.a_renamed(bitmapA2, null, aVar, options, strA, context, jCurrentTimeMillis, i_renamed, aVar), 2, null);
                                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("BitmapDecodeManager", "getImageBitmap decode , total time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                                c_renamed.e_renamed.a_renamed.a_renamed(parcelFileDescriptor, th2);
                                return bitmapA2;
                            } catch (java.lang.Throwable th5) {
                                th = th5;
                                th = th2;
                            }
                        } else {
                            parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                            th = th2;
                            try {
                                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("BitmapDecodeManager", "getImageBitmap decodeFileDescriptor failed ");
                                c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
                                c_renamed.e_renamed.a_renamed.a_renamed(parcelFileDescriptor, th);
                                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("BitmapDecodeManager", "getImageBitmap openFileDescriptor failed ");
                                return null;
                            } catch (java.lang.Throwable th6) {
                                th = th6;
                            }
                        }
                    } catch (java.lang.Throwable th7) {
                        th = th7;
                        th2 = th;
                        throw th2;
                    }
                } catch (java.lang.Throwable th8) {
                    th = th8;
                    parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                    th = th2;
                    c_renamed.e_renamed.a_renamed.a_renamed(parcelFileDescriptor, th);
                    throw th;
                }
                c_renamed.e_renamed.a_renamed.a_renamed(parcelFileDescriptor, th);
                throw th;
            } catch (java.lang.Throwable th9) {
                th = th9;
                parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.c_renamed("BitmapDecodeManager", "getImageBitmap", e_renamed);
            return null;
        }
    }

    /* compiled from: BitmapDecodeManager.kt */
    static final class a_renamed extends c_renamed.c_renamed.b_renamed.a_renamed.j_renamed implements c_renamed.f_renamed.a_renamed.m_renamed<kotlinx.coroutines.y_renamed, c_renamed.c_renamed.d_renamed<? super c_renamed.s_renamed>, java.lang.Object> {
        final /* synthetic */ android.graphics.Bitmap $bitmap;
        final /* synthetic */ android.content.Context $context$inlined;
        final /* synthetic */ com.oplus.c_renamed.a_renamed.b_renamed.a_renamed $item$inlined;
        final /* synthetic */ java.lang.String $key$inlined;
        final /* synthetic */ android.graphics.BitmapFactory.Options $options$inlined;
        final /* synthetic */ int $simpleSize$inlined;
        final /* synthetic */ com.oplus.c_renamed.a_renamed.b_renamed.a_renamed $this_apply$inlined;
        final /* synthetic */ long $time$inlined;
        int label;
        private kotlinx.coroutines.y_renamed p_renamed$;

        /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
        a_renamed(android.graphics.Bitmap bitmap, c_renamed.c_renamed.d_renamed dVar, com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar, android.graphics.BitmapFactory.Options options, java.lang.String str, android.content.Context context, long j_renamed, int i_renamed, com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar2) {
            super(2, dVar);
            this.$bitmap = bitmap;
            this.$this_apply$inlined = aVar;
            this.$options$inlined = options;
            this.$key$inlined = str;
            this.$context$inlined = context;
            this.$time$inlined = j_renamed;
            this.$simpleSize$inlined = i_renamed;
            this.$item$inlined = aVar2;
        }

        @Override // c_renamed.c_renamed.b_renamed.a_renamed.a_renamed
        public final c_renamed.c_renamed.d_renamed<c_renamed.s_renamed> create(java.lang.Object obj, c_renamed.c_renamed.d_renamed<?> dVar) {
            c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(dVar, "completion");
            com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar = new com.oplus.c_renamed.a_renamed.b_renamed.a_renamed(this.$bitmap, dVar, this.$this_apply$inlined, this.$options$inlined, this.$key$inlined, this.$context$inlined, this.$time$inlined, this.$simpleSize$inlined, this.$item$inlined);
            aVar.p_renamed$ = (kotlinx.coroutines.y_renamed) obj;
            return aVar;
        }

        @Override // c_renamed.f_renamed.a_renamed.m_renamed
        public final java.lang.Object invoke(kotlinx.coroutines.y_renamed yVar, c_renamed.c_renamed.d_renamed<? super c_renamed.s_renamed> dVar) {
            return ((com.oplus.c_renamed.a_renamed.b_renamed.a_renamed) create(yVar, dVar)).invokeSuspend(c_renamed.s_renamed.f1925a);
        }

        @Override // c_renamed.c_renamed.b_renamed.a_renamed.a_renamed
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            c_renamed.c_renamed.a_renamed.b_renamed.a_renamed();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c_renamed.n_renamed.a_renamed(obj);
            kotlinx.coroutines.y_renamed yVar = this.p_renamed$;
            com.oplus.c_renamed.a_renamed.a_renamed.a_renamed aVarA = com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.f3730a.a_renamed(this.$context$inlined);
            java.lang.String str = this.$key$inlined;
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) str, "key");
            aVarA.a_renamed(str, this.$bitmap);
            return c_renamed.s_renamed.f1925a;
        }
    }

    public static final int[] b_renamed(android.content.Context context, com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar, int i_renamed) throws java.io.FileNotFoundException {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(aVar, "item");
        com.oplus.c_renamed.a_renamed.e_renamed.b_renamed.a_renamed();
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String strA = com.oplus.c_renamed.a_renamed.e_renamed.b_renamed.a_renamed(aVar);
        com.oplus.c_renamed.a_renamed.a_renamed.a_renamed aVarA = com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.f3730a.a_renamed(context);
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) strA, "key");
        android.graphics.Bitmap bitmapA = aVarA.a_renamed(strA);
        if (bitmapA != null) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("BitmapDecodeManager", "getImageBitmapSize from cache");
            return new int[]{bitmapA.getWidth(), bitmapA.getHeight()};
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inSampleSize = i_renamed;
        options.inJustDecodeBounds = true;
        try {
            android.os.ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(aVar.g_renamed(), "r_renamed");
            java.lang.Throwable th = (java.lang.Throwable) null;
            try {
                android.os.ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                if (android.graphics.BitmapFactory.decodeFileDescriptor(parcelFileDescriptor != null ? parcelFileDescriptor.getFileDescriptor() : null, null, options) != null) {
                    com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("BitmapDecodeManager", "getImageBitmapSize decode  , total time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                    c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
                }
                c_renamed.e_renamed.a_renamed.a_renamed(parcelFileDescriptorOpenFileDescriptor, th);
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("BitmapDecodeManager", "getImageBitmapSize from decode");
                return new int[]{options.outWidth, options.outHeight};
            } catch (java.lang.Throwable th2) {
                c_renamed.e_renamed.a_renamed.a_renamed(parcelFileDescriptorOpenFileDescriptor, th);
                throw th2;
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.c_renamed("BitmapDecodeManager", "getImageBitmap", e_renamed);
            return null;
        }
    }

    private final android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, int i_renamed) {
        if (i_renamed == 0) {
            return bitmap;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postRotate(i_renamed);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) bitmapCreateBitmap, "Bitmap.createBitmap(bitm…, width, height, m_renamed, true)");
        return bitmapCreateBitmap;
    }
}

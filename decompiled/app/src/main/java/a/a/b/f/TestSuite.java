package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class i_renamed implements java.lang.AutoCloseable {

    /* renamed from: a_renamed, reason: collision with root package name */
    public co_renamed.polarr.renderer.utils.AnimationJson f88a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public long f89b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public long f90c = 1;
    public long d_renamed = 0;
    public final java.util.HashMap<java.lang.Integer, a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.a_renamed> e_renamed = new java.util.HashMap<>();
    public final java.util.HashMap<java.lang.Integer, java.util.HashMap<java.lang.Integer, a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.b_renamed>> f_renamed = new java.util.HashMap<>();
    public final java.util.HashMap<java.lang.Integer, android.graphics.PointF> g_renamed = new java.util.HashMap<>();

    public class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final java.util.ArrayList<co_renamed.polarr.renderer.utils.AnimationJson.Animation> f91a = new java.util.ArrayList<>();

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f92b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public long f93c;

        public a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.i_renamed iVar, co_renamed.polarr.renderer.utils.AnimationJson.Animation[] animationArr, boolean z_renamed) {
            this.f92b = 0;
            if (animationArr != null && animationArr.length > 0) {
                if (animationArr[0].getTimeInMS() > 0) {
                    this.f91a.add(new co_renamed.polarr.renderer.utils.AnimationJson.Animation());
                }
                java.util.Collections.addAll(this.f91a, animationArr);
                this.f93c = this.f91a.get(r6.size() - 1).getTimeInMS();
            }
            this.f92b = 0;
        }

        public co_renamed.polarr.renderer.utils.AnimationJson.Animation a_renamed(long j_renamed) {
            co_renamed.polarr.renderer.utils.AnimationJson.Animation animation;
            long j2 = j_renamed % this.f93c;
            if (this.f91a.isEmpty()) {
                return null;
            }
            if (1 == this.f91a.size()) {
                animation = this.f91a.get(0);
            } else {
                while (true) {
                    if (this.f91a.get(this.f92b).getTimeInMS() <= j2 && this.f91a.get(this.f92b + 1).getTimeInMS() > j2) {
                        break;
                    }
                    this.f92b = (this.f92b + 1) % (this.f91a.size() - 1);
                }
                animation = this.f91a.get(this.f92b);
            }
            return animation;
        }

        public void a_renamed() {
            this.f92b = 0;
        }
    }

    public static class b_renamed implements java.lang.AutoCloseable {

        /* renamed from: a_renamed, reason: collision with root package name */
        public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed f94a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public android.graphics.Bitmap f95b;

        public b_renamed(android.graphics.Bitmap bitmap) {
            this.f95b = bitmap;
        }

        public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed() {
            return this.f94a;
        }

        public void b_renamed() {
            android.graphics.Bitmap bitmap = this.f95b;
            if (bitmap != null) {
                this.f94a = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(bitmap);
                this.f95b.recycle();
                this.f95b = null;
            }
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.f95b != null) {
                this.f95b = null;
            }
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.f94a;
            if (dVar != null) {
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(dVar.f34a);
                this.f94a = null;
            }
        }
    }

    public class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed f96a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.d_renamed f97b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public float f98c;
        public float d_renamed;
        public a_renamed.a_renamed.b_renamed.f_renamed.x_renamed e_renamed;

        public c_renamed(a_renamed.a_renamed.b_renamed.f_renamed.i_renamed iVar) {
        }
    }

    public class d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public float f99a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public float f100b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public float f101c;
        public float d_renamed;

        public d_renamed(a_renamed.a_renamed.b_renamed.f_renamed.i_renamed iVar, float f_renamed, float f2, float f3, float f4) {
            this.f99a = f_renamed;
            this.f100b = f2;
            this.f101c = f3;
            this.d_renamed = f4;
        }

        public java.lang.String toString() {
            return "(" + java.lang.Float.toString(this.f99a) + "," + java.lang.Float.toString(this.f100b) + "," + java.lang.Float.toString(this.f101c) + "," + java.lang.Float.toString(this.d_renamed) + ")";
        }
    }

    public i_renamed(a_renamed.a_renamed.b_renamed.f_renamed.a_renamed aVar, java.lang.String str) throws java.io.IOException {
        try {
            java.io.InputStream inputStreamA = aVar.a_renamed(str);
            java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(inputStreamA);
            this.f88a = co_renamed.polarr.renderer.utils.AnimationJson.fromJson(inputStreamReader);
            co_renamed.polarr.renderer.utils.AnimationJson.Sprite[] sprites = this.f88a.getSprites();
            if (sprites == null) {
                a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("mPacmanAnimationJson.getSprites() return null", new java.lang.Object[0]);
            } else {
                a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("mPacmanAnimationJson.getSprites() return " + java.lang.Integer.toString(sprites.length), new java.lang.Object[0]);
            }
            inputStreamReader.close();
            inputStreamA.close();
        } catch (java.lang.Exception unused) {
            a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("Cannot initialize pacman filter", new java.lang.Object[0]);
        }
        for (co_renamed.polarr.renderer.utils.AnimationJson.Sprite sprite : this.f88a.getSprites()) {
            int spriteId = sprite.getSpriteId();
            this.g_renamed.put(java.lang.Integer.valueOf(spriteId), new android.graphics.PointF(sprite.getMaxWidth(), sprite.getMaxHeight()));
            java.util.Map<java.lang.Integer, java.lang.String> imageList = sprite.getImageList();
            if (imageList != null && !imageList.isEmpty()) {
                java.util.HashMap<java.lang.Integer, a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.b_renamed> map = new java.util.HashMap<>();
                for (java.util.Map.Entry<java.lang.Integer, java.lang.String> entry : imageList.entrySet()) {
                    int iIntValue = entry.getKey().intValue();
                    android.graphics.Bitmap bitmapA = a_renamed(aVar.a_renamed(entry.getValue()));
                    if (bitmapA != null) {
                        map.put(java.lang.Integer.valueOf(iIntValue), new a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.b_renamed(bitmapA));
                    }
                }
                if (!map.isEmpty()) {
                    this.f_renamed.put(java.lang.Integer.valueOf(spriteId), map);
                }
            }
            co_renamed.polarr.renderer.utils.AnimationJson.Animation[] animations = sprite.getAnimations();
            if (animations != null && animations.length > 0) {
                this.e_renamed.put(java.lang.Integer.valueOf(spriteId), new a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.a_renamed(this, animations, sprite.isRepeat()));
            }
        }
    }

    public long a_renamed() {
        return this.f90c;
    }

    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(int i_renamed, int i2) {
        a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.b_renamed bVar;
        java.util.HashMap<java.lang.Integer, a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.b_renamed> map = this.f_renamed.get(java.lang.Integer.valueOf(i_renamed));
        if (map == null || (bVar = map.get(java.lang.Integer.valueOf(i2))) == null) {
            return null;
        }
        return bVar.a_renamed();
    }

    public final android.graphics.Bitmap a_renamed(java.io.InputStream inputStream) throws java.io.IOException {
        try {
            try {
                android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                options.inPremultiplied = false;
                android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(inputStream, null, options);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                }
                return bitmapDecodeStream;
            } catch (java.lang.Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (java.io.IOException unused3) {
                }
            }
            return null;
        }
    }

    public void a_renamed(long j_renamed) {
        this.d_renamed = j_renamed;
    }

    public a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.c_renamed[] a_renamed(float f_renamed, float f2) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarA;
        long jCurrentTimeMillis = this.d_renamed;
        if (0 == jCurrentTimeMillis) {
            jCurrentTimeMillis = java.lang.System.currentTimeMillis() - this.f89b;
        }
        long j_renamed = jCurrentTimeMillis;
        this.f90c = j_renamed;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.util.Map.Entry<java.lang.Integer, a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.a_renamed> entry : this.e_renamed.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            android.graphics.PointF pointF = this.g_renamed.get(java.lang.Integer.valueOf(iIntValue));
            co_renamed.polarr.renderer.utils.AnimationJson.Animation animationA = entry.getValue().a_renamed(j_renamed);
            if (animationA != null && (dVarA = a_renamed(iIntValue, animationA.getImageId())) != null) {
                a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.c_renamed cVar = new a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.c_renamed(this);
                cVar.f96a = dVarA;
                cVar.d_renamed = animationA.getRotation();
                cVar.f98c = animationA.getOpacity();
                cVar.e_renamed = animationA.getBlendingMode();
                android.graphics.PointF pointF2 = new android.graphics.PointF(pointF.x_renamed * animationA.getScale(), pointF.y_renamed * animationA.getScale());
                float f3 = pointF2.x_renamed * f_renamed;
                float f4 = pointF2.y_renamed * f2;
                android.graphics.PointF pointF3 = new android.graphics.PointF(animationA.getCenter().x_renamed, 1.0f - animationA.getCenter().y_renamed);
                float f5 = dVarA.f35b / dVarA.f36c;
                float f6 = cVar.d_renamed;
                if (90.0f == f6 || 270.0f == f6) {
                    f5 = 1.0f / f5;
                }
                float f7 = f3 / f5;
                if (f7 > f4) {
                    f3 = f4 * f5;
                    f7 = f4;
                }
                float f8 = f3 / f_renamed;
                float f9 = f7 / f2;
                cVar.f97b = new a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.d_renamed(this, pointF3.x_renamed - (f8 * 0.5f), pointF3.y_renamed - (0.5f * f9), f8, f9);
                arrayList.add(cVar);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.c_renamed[]) arrayList.toArray(new a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.c_renamed[arrayList.size()]);
    }

    public void b_renamed() {
        java.util.Iterator<java.util.Map.Entry<java.lang.Integer, java.util.HashMap<java.lang.Integer, a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.b_renamed>>> it = this.f_renamed.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Iterator<java.util.Map.Entry<java.lang.Integer, a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.b_renamed>> it2 = it.next().getValue().entrySet().iterator();
            while (it2.hasNext()) {
                it2.next().getValue().b_renamed();
            }
        }
    }

    public void c_renamed() {
        java.util.Iterator<java.util.Map.Entry<java.lang.Integer, a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.a_renamed>> it = this.e_renamed.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a_renamed();
        }
        this.f89b = java.lang.System.currentTimeMillis() - 1;
        this.f90c = 1L;
        this.d_renamed = 0L;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.f_renamed.isEmpty()) {
            return;
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.Integer, java.util.HashMap<java.lang.Integer, a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.b_renamed>>> it = this.f_renamed.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Iterator<java.util.Map.Entry<java.lang.Integer, a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.b_renamed>> it2 = it.next().getValue().entrySet().iterator();
            while (it2.hasNext()) {
                it2.next().getValue().close();
            }
        }
        this.f_renamed.clear();
    }
}

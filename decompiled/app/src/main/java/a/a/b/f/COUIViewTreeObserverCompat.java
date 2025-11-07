package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public final class u_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.util.List<a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.c_renamed> f123a = new java.util.concurrent.CopyOnWriteArrayList();

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.c_renamed f124b = new a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.a_renamed();

    public class a_renamed extends a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.c_renamed {
        @Override // a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.c_renamed
        public void a_renamed(int i_renamed, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
            throw new java.lang.AssertionError("Missing override for log method.");
        }

        @Override // a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.c_renamed
        public void a_renamed(java.lang.String str, java.lang.Object... objArr) {
            java.util.List list = a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.f123a;
            int size = list.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                ((a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.c_renamed) list.get(i_renamed)).a_renamed(str, objArr);
            }
        }
    }

    public static class b_renamed extends a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public static final java.util.regex.Pattern f125a = java.util.regex.Pattern.compile("\\$\\d_renamed+$");

        /* renamed from: b_renamed, reason: collision with root package name */
        public static final a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.b_renamed f126b = new a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.b_renamed();

        @Override // a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.c_renamed
        public final java.lang.String a_renamed() {
            java.lang.String strA = super.a_renamed();
            if (strA != null) {
                return strA;
            }
            java.lang.StackTraceElement[] stackTrace = new java.lang.Throwable().getStackTrace();
            if (stackTrace.length > 6) {
                return a_renamed(stackTrace[6]);
            }
            throw new java.lang.IllegalStateException("Synthetic stacktrace didn't_renamed have enough elements: are you using proguard?");
        }

        public java.lang.String a_renamed(java.lang.StackTraceElement stackTraceElement) {
            java.lang.String className = stackTraceElement.getClassName();
            java.util.regex.Matcher matcher = f125a.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            return className.substring(className.lastIndexOf(46) + 1);
        }

        @Override // a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.c_renamed
        public void a_renamed(int i_renamed, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
            int iMin;
            if (str2.length() < 4000) {
                if (i_renamed == 7) {
                    android.util.Log.wtf(str, str2);
                    return;
                } else {
                    android.util.Log.println(i_renamed, str, str2);
                    return;
                }
            }
            int i2 = 0;
            int length = str2.length();
            while (i2 < length) {
                int iIndexOf = str2.indexOf(10, i2);
                if (iIndexOf == -1) {
                    iIndexOf = length;
                }
                while (true) {
                    iMin = java.lang.Math.min(iIndexOf, i2 + com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_ASSET);
                    java.lang.String strSubstring = str2.substring(i2, iMin);
                    if (i_renamed == 7) {
                        android.util.Log.wtf(str, strSubstring);
                    } else {
                        android.util.Log.println(i_renamed, str, strSubstring);
                    }
                    if (iMin >= iIndexOf) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }
    }

    public static abstract class c_renamed {

        /* renamed from: c_renamed, reason: collision with root package name */
        public final java.lang.ThreadLocal<java.lang.String> f127c = new java.lang.ThreadLocal<>();

        public java.lang.String a_renamed() {
            java.lang.String str = this.f127c.get();
            if (str != null) {
                this.f127c.remove();
            }
            return str;
        }

        public abstract void a_renamed(int i_renamed, java.lang.String str, java.lang.String str2, java.lang.Throwable th);

        public final void a_renamed(int i_renamed, java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
            if (str != null && str.length() == 0) {
                str = null;
            }
            if (str != null) {
                if (objArr.length > 0) {
                    str = java.lang.String.format(str, objArr);
                }
                if (th != null) {
                    str = str + "\n_renamed" + android.util.Log.getStackTraceString(th);
                }
            } else if (th == null) {
                return;
            } else {
                str = android.util.Log.getStackTraceString(th);
            }
            a_renamed(i_renamed, a_renamed(), str, th);
        }

        public void a_renamed(java.lang.String str, java.lang.Object... objArr) {
            a_renamed(3, (java.lang.Throwable) null, str, objArr);
        }
    }

    public static void a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.c_renamed cVar) {
        synchronized (a_renamed.a_renamed.b_renamed.f_renamed.u_renamed.class) {
            try {
                if (cVar == null) {
                    throw new java.lang.NullPointerException("tree == null");
                }
                if (cVar == f124b) {
                    throw new java.lang.IllegalArgumentException("Cannot plant MyLogger into itself.");
                }
                if (!f123a.contains(cVar)) {
                    f123a.add(cVar);
                }
            } finally {
            }
        }
    }

    public static void a_renamed(java.lang.String str, java.lang.Object... objArr) {
        f124b.a_renamed(str, objArr);
    }
}

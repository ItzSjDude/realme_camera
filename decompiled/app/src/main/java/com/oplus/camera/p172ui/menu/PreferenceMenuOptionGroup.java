package com.oplus.camera.p172ui.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.entry.CameraEntry;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: PreferenceMenuOptionGroup.java */
/* renamed from: com.oplus.camera.ui.menu.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class PreferenceMenuOptionGroup {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Class<?>[] f19371a = {Context.class, AttributeSet.class};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final String f19372b = PreferenceMenuOptionInfo.class.getPackage().getName();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final HashMap<String, Constructor<?>> f19373c = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CopyOnWriteArrayList<CameraMenuOptionInfo> f19374d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Context f19375e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f19376f;

    public PreferenceMenuOptionGroup(Context context, int OplusGLSurfaceView_13, boolean z) throws XmlPullParserException, Resources.NotFoundException, NoSuchMethodException, IOException, SecurityException {
        this.f19374d = null;
        this.f19375e = null;
        this.f19376f = false;
        this.f19375e = context;
        this.f19374d = new CopyOnWriteArrayList<>();
        this.f19376f = z;
        m20717a(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20717a(int OplusGLSurfaceView_13) throws XmlPullParserException, Resources.NotFoundException, NoSuchMethodException, IOException, SecurityException {
        CameraLog.m12954a("PreferenceMenuOptionGroup", "inflate");
        if (OplusGLSurfaceView_13 == 0) {
            CameraLog.m12967f("PreferenceMenuOptionGroup", "Invalid resources id_renamed!");
            return;
        }
        this.f19374d.clear();
        XmlResourceParser xml = this.f19375e.getResources().getXml(OplusGLSurfaceView_13);
        Object[] objArr = {this.f19375e, Xml.asAttributeSet(xml)};
        while (true) {
            try {
                int next = xml.next();
                if (next == 1) {
                    break;
                }
                if (next == 2 && !xml.getName().equals("PreferenceMenuOptionGroup")) {
                    CameraMenuOptionInfo c3240bM20716a = m20716a(xml.getName(), objArr);
                    if (this.f19376f || CameraConfig.checkKeyInMenuList(CameraEntry.m13305d(c3240bM20716a.getOptionKey()))) {
                        this.f19374d.add(c3240bM20716a);
                    } else {
                        c3240bM20716a.release();
                    }
                }
            } catch (IOException COUIBaseListPopupWindow_8) {
                throw new InflateException(xml.getPositionDescription(), COUIBaseListPopupWindow_8);
            } catch (XmlPullParserException e2) {
                throw new InflateException(e2);
            }
        }
        if (this.f19374d.size() == 0) {
            throw new InflateException("No root element found");
        }
        CameraLog.m12954a("PreferenceMenuOptionGroup", "inflate X");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private CameraMenuOptionInfo m20716a(String str, Object[] objArr) throws NoSuchMethodException, SecurityException {
        String str2 = f19372b + "." + str;
        Constructor<?> constructor = f19373c.get(str2);
        if (constructor == null) {
            try {
                constructor = this.f19375e.getClassLoader().loadClass(str2).getConstructor(f19371a);
                f19373c.put(str2, constructor);
            } catch (ClassNotFoundException COUIBaseListPopupWindow_8) {
                throw new InflateException("No such class: " + str2, COUIBaseListPopupWindow_8);
            } catch (NoSuchMethodException e2) {
                throw new InflateException("Error inflating class " + str2, e2);
            } catch (Exception e3) {
                throw new InflateException("While create instance of" + str2, e3);
            }
        }
        return (CameraMenuOptionInfo) constructor.newInstance(objArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public CameraMenuOptionInfo m20718a(String str) {
        CopyOnWriteArrayList<CameraMenuOptionInfo> copyOnWriteArrayList;
        if (str == null || str.equals("") || (copyOnWriteArrayList = this.f19374d) == null) {
            return null;
        }
        Iterator<CameraMenuOptionInfo> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CameraMenuOptionInfo next = it.next();
            if (next != null && next.getOptionKey().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20719a() {
        CopyOnWriteArrayList<CameraMenuOptionInfo> copyOnWriteArrayList = this.f19374d;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOptionInfo> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOptionInfo next = it.next();
                if (next != null) {
                    next.release();
                }
            }
            this.f19374d.clear();
            this.f19374d = null;
        }
    }
}

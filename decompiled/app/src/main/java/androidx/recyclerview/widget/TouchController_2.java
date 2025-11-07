package androidx.recyclerview.widget;

/* compiled from: OpReorderer.java */
/* loaded from: classes.dex */
class m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    final androidx.recyclerview.widget.m_renamed.a_renamed f1540a;

    /* compiled from: OpReorderer.java */
    interface a_renamed {
        androidx.recyclerview.widget.a_renamed.b_renamed a_renamed(int i_renamed, int i2, int i3, java.lang.Object obj);

        void a_renamed(androidx.recyclerview.widget.a_renamed.b_renamed bVar);
    }

    m_renamed(androidx.recyclerview.widget.m_renamed.a_renamed aVar) {
        this.f1540a = aVar;
    }

    void a_renamed(java.util.List<androidx.recyclerview.widget.a_renamed.b_renamed> list) {
        while (true) {
            int iB = b_renamed(list);
            if (iB == -1) {
                return;
            } else {
                a_renamed(list, iB, iB + 1);
            }
        }
    }

    private void a_renamed(java.util.List<androidx.recyclerview.widget.a_renamed.b_renamed> list, int i_renamed, int i2) {
        androidx.recyclerview.widget.a_renamed.b_renamed bVar = list.get(i_renamed);
        androidx.recyclerview.widget.a_renamed.b_renamed bVar2 = list.get(i2);
        int i3 = bVar2.f1458a;
        if (i3 == 1) {
            c_renamed(list, i_renamed, bVar, i2, bVar2);
        } else if (i3 == 2) {
            a_renamed(list, i_renamed, bVar, i2, bVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            b_renamed(list, i_renamed, bVar, i2, bVar2);
        }
    }

    void a_renamed(java.util.List<androidx.recyclerview.widget.a_renamed.b_renamed> list, int i_renamed, androidx.recyclerview.widget.a_renamed.b_renamed bVar, int i2, androidx.recyclerview.widget.a_renamed.b_renamed bVar2) {
        boolean z_renamed;
        boolean z2 = false;
        if (bVar.f1459b < bVar.d_renamed) {
            if (bVar2.f1459b == bVar.f1459b && bVar2.d_renamed == bVar.d_renamed - bVar.f1459b) {
                z_renamed = false;
                z2 = true;
            } else {
                z_renamed = false;
            }
        } else if (bVar2.f1459b == bVar.d_renamed + 1 && bVar2.d_renamed == bVar.f1459b - bVar.d_renamed) {
            z_renamed = true;
            z2 = true;
        } else {
            z_renamed = true;
        }
        if (bVar.d_renamed < bVar2.f1459b) {
            bVar2.f1459b--;
        } else if (bVar.d_renamed < bVar2.f1459b + bVar2.d_renamed) {
            bVar2.d_renamed--;
            bVar.f1458a = 2;
            bVar.d_renamed = 1;
            if (bVar2.d_renamed == 0) {
                list.remove(i2);
                this.f1540a.a_renamed(bVar2);
                return;
            }
            return;
        }
        androidx.recyclerview.widget.a_renamed.b_renamed bVarA = null;
        if (bVar.f1459b <= bVar2.f1459b) {
            bVar2.f1459b++;
        } else if (bVar.f1459b < bVar2.f1459b + bVar2.d_renamed) {
            bVarA = this.f1540a.a_renamed(2, bVar.f1459b + 1, (bVar2.f1459b + bVar2.d_renamed) - bVar.f1459b, null);
            bVar2.d_renamed = bVar.f1459b - bVar2.f1459b;
        }
        if (z2) {
            list.set(i_renamed, bVar2);
            list.remove(i2);
            this.f1540a.a_renamed(bVar);
            return;
        }
        if (z_renamed) {
            if (bVarA != null) {
                if (bVar.f1459b > bVarA.f1459b) {
                    bVar.f1459b -= bVarA.d_renamed;
                }
                if (bVar.d_renamed > bVarA.f1459b) {
                    bVar.d_renamed -= bVarA.d_renamed;
                }
            }
            if (bVar.f1459b > bVar2.f1459b) {
                bVar.f1459b -= bVar2.d_renamed;
            }
            if (bVar.d_renamed > bVar2.f1459b) {
                bVar.d_renamed -= bVar2.d_renamed;
            }
        } else {
            if (bVarA != null) {
                if (bVar.f1459b >= bVarA.f1459b) {
                    bVar.f1459b -= bVarA.d_renamed;
                }
                if (bVar.d_renamed >= bVarA.f1459b) {
                    bVar.d_renamed -= bVarA.d_renamed;
                }
            }
            if (bVar.f1459b >= bVar2.f1459b) {
                bVar.f1459b -= bVar2.d_renamed;
            }
            if (bVar.d_renamed >= bVar2.f1459b) {
                bVar.d_renamed -= bVar2.d_renamed;
            }
        }
        list.set(i_renamed, bVar2);
        if (bVar.f1459b != bVar.d_renamed) {
            list.set(i2, bVar);
        } else {
            list.remove(i2);
        }
        if (bVarA != null) {
            list.add(i_renamed, bVarA);
        }
    }

    private void c_renamed(java.util.List<androidx.recyclerview.widget.a_renamed.b_renamed> list, int i_renamed, androidx.recyclerview.widget.a_renamed.b_renamed bVar, int i2, androidx.recyclerview.widget.a_renamed.b_renamed bVar2) {
        int i3 = bVar.d_renamed < bVar2.f1459b ? -1 : 0;
        if (bVar.f1459b < bVar2.f1459b) {
            i3++;
        }
        if (bVar2.f1459b <= bVar.f1459b) {
            bVar.f1459b += bVar2.d_renamed;
        }
        if (bVar2.f1459b <= bVar.d_renamed) {
            bVar.d_renamed += bVar2.d_renamed;
        }
        bVar2.f1459b += i3;
        list.set(i_renamed, bVar2);
        list.set(i2, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:24:? A_renamed[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void b_renamed(java.util.List<androidx.recyclerview.widget.a_renamed.b_renamed> r8, int r9, androidx.recyclerview.widget.a_renamed.b_renamed r10, int r11, androidx.recyclerview.widget.a_renamed.b_renamed r12) {
        /*
            r7 = this;
            int r0 = r10.d_renamed
            int r1 = r12.f1459b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Lf
            int r0 = r12.f1459b
            int r0 = r0 - r4
            r12.f1459b = r0
            goto L28
        Lf:
            int r0 = r10.d_renamed
            int r1 = r12.f1459b
            int r5 = r12.d_renamed
            int r1 = r1 + r5
            if (r0 >= r1) goto L28
            int r0 = r12.d_renamed
            int r0 = r0 - r4
            r12.d_renamed = r0
            androidx.recyclerview.widget.m_renamed$a_renamed r0 = r7.f1540a
            int r1 = r10.f1459b
            java.lang.Object r5 = r12.f1460c
            androidx.recyclerview.widget.a_renamed$b_renamed r0 = r0.a_renamed(r2, r1, r4, r5)
            goto L29
        L28:
            r0 = r3
        L29:
            int r1 = r10.f1459b
            int r5 = r12.f1459b
            if (r1 > r5) goto L35
            int r1 = r12.f1459b
            int r1 = r1 + r4
            r12.f1459b = r1
            goto L56
        L35:
            int r1 = r10.f1459b
            int r5 = r12.f1459b
            int r6 = r12.d_renamed
            int r5 = r5 + r6
            if (r1 >= r5) goto L56
            int r1 = r12.f1459b
            int r3 = r12.d_renamed
            int r1 = r1 + r3
            int r3 = r10.f1459b
            int r1 = r1 - r3
            androidx.recyclerview.widget.m_renamed$a_renamed r3 = r7.f1540a
            int r5 = r10.f1459b
            int r5 = r5 + r4
            java.lang.Object r4 = r12.f1460c
            androidx.recyclerview.widget.a_renamed$b_renamed r3 = r3.a_renamed(r2, r5, r1, r4)
            int r2 = r12.d_renamed
            int r2 = r2 - r1
            r12.d_renamed = r2
        L56:
            r8.set(r11, r10)
            int r10 = r12.d_renamed
            if (r10 <= 0) goto L61
            r8.set(r9, r12)
            goto L69
        L61:
            r8.remove(r9)
            androidx.recyclerview.widget.m_renamed$a_renamed r7 = r7.f1540a
            r7.a_renamed(r12)
        L69:
            if (r0 == 0) goto L6e
            r8.add(r9, r0)
        L6e:
            if (r3 == 0) goto L73
            r8.add(r9, r3)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.m_renamed.b_renamed(java.util.List, int, androidx.recyclerview.widget.a_renamed$b_renamed, int, androidx.recyclerview.widget.a_renamed$b_renamed):void");
    }

    private int b_renamed(java.util.List<androidx.recyclerview.widget.a_renamed.b_renamed> list) {
        boolean z_renamed = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f1458a != 8) {
                z_renamed = true;
            } else if (z_renamed) {
                return size;
            }
        }
        return -1;
    }
}

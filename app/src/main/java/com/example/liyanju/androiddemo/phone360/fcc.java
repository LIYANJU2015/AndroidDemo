package com.example.liyanju.androiddemo.phone360;

import java.io.OutputStream;
import java.util.Vector;

public class fcc {
    private final byte[] a;
    private final OutputStream b = null;
    private final fcb c;

    public fcc(byte[] bArr) {
        this.a = bArr;
        this.c = fcb.a(bArr);
    }

    public void a(int i, boolean z) {
        this.c.a(i, z);
    }

//    public void a(int i, fbt contacts_fbt) {
//        this.c.a(i, contacts_fbt);
//    }

    public void a(int i, double d) {
        this.c.a(i, d);
    }

    public void a(int i, float f) {
        this.c.a(i, f);
    }

    public void a(int i, int i2) {
        this.c.a(i, i2);
    }

    public void a(int i, long j) {
        this.c.a(i, j);
    }

    public void a(int i, String str) {
        this.c.a(i, str);
    }

    public void b(int i, int i2) {
        this.c.b(i, i2);
    }

    public void a(int i, int i2, Vector vector) {
        if (vector != null) {
            int i3;
            switch (i2) {
                case 1:
                    for (i3 = 0; i3 < vector.size(); i3++) {
                        a(i, (String) vector.elementAt(i3));
                    }
                    return;
                case 2:
                    for (i3 = 0; i3 < vector.size(); i3++) {
                        a(i, ((Integer) vector.elementAt(i3)).intValue());
                    }
                    return;
                case 3:
                    for (i3 = 0; i3 < vector.size(); i3++) {
                        a(i, ((Long) vector.elementAt(i3)).longValue());
                    }
                    return;
                case 4:
                    for (i3 = 0; i3 < vector.size(); i3++) {
                        a(i, ((Double) vector.elementAt(i3)).doubleValue());
                    }
                    return;
                case 5:
                    for (i3 = 0; i3 < vector.size(); i3++) {
                        a(i, ((Float) vector.elementAt(i3)).floatValue());
                    }
                    return;
                case 6:
//                    for (i3 = 0; i3 < vector.size(); i3++) {
//                        a(i, (fbt) vector.elementAt(i3));
//                    }
                    return;
                case 7:
                    for (i3 = 0; i3 < vector.size(); i3++) {
                        a(i, ((Boolean) vector.elementAt(i3)).booleanValue());
                    }
                    return;
                case 8:
//                    for (i3 = 0; i3 < vector.size(); i3++) {
//                        fbv contacts_fbv = (fbv) vector.elementAt(i3);
//                        b(i, contacts_fbv.b());
//                        contacts_fbv.a(this);
//                    }
                    return;
                default:
                    throw new IllegalArgumentException(new StringBuffer().append("The data type was not found, the id used was ").append(i2).toString());
            }
        }
    }
}

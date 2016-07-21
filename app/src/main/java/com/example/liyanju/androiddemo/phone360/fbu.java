package com.example.liyanju.androiddemo.phone360;

import java.util.Vector;

/**
 * Created by liyanju on 16/6/13.
 */
public class fbu {
    public static int a(int i, int i2) {
        return fcb.c(i, i2);
    }

    public static int a(int i, String str) {
        return fcb.b(i, str);
    }

    public static int a(int i, boolean z) {
        return fcb.b(i, z);
    }

    public static int a(int i, double d) {
        return fcb.b(i, d);
    }

    public static int a(int i, float f) {
        return fcb.b(i, f);
    }

    public static int a(int i, long j) {
        return fcb.b(i, j);
    }

    // public static int a(int i, fbt contacts_fbt) {
//        return fcb.b(i, contacts_fbt);
//    }

    public static int b(int i, int i2) {
        return (fcb.a(i) + fcb.c(i2)) + i2;
    }

    public static int a(int i, int i2, Vector vector) {
        if (vector == null) {
            return 0;
        }
        int i3;
        int i4;
        switch (i2) {
            case 1:
                i3 = 0;
                for (i4 = 0; i4 < vector.size(); i4++) {
                    i3 += a(i, (String) vector.elementAt(i4));
                }
                return i3;
            case 2:
                i3 = 0;
                for (i4 = 0; i4 < vector.size(); i4++) {
                    i3 += a(i, ((Integer) vector.elementAt(i4)).intValue());
                }
                return i3;
            case 3:
                i3 = 0;
                for (i4 = 0; i4 < vector.size(); i4++) {
                    i3 += a(i, ((Long) vector.elementAt(i4)).longValue());
                }
                return i3;
            case 4:
                i3 = 0;
                for (i4 = 0; i4 < vector.size(); i4++) {
                    i3 += a(i, ((Double) vector.elementAt(i4)).doubleValue());
                }
                return i3;
            case 5:
                i3 = 0;
                for (i4 = 0; i4 < vector.size(); i4++) {
                    i3 += a(i, ((Float) vector.elementAt(i4)).floatValue());
                }
                return i3;
            case 6:
//                i3 = 0;
//                for (i4 = 0; i4 < vector.size(); i4++) {
//                    i3 += a(i, (fbt) vector.elementAt(i4));
//                }
//                return i3;
            case 7:
                i3 = 0;
                for (i4 = 0; i4 < vector.size(); i4++) {
                    i3 += a(i, ((Boolean) vector.elementAt(i4)).booleanValue());
                }
                return i3;
            case 8:
                i3 = 0;
                for (i4 = 0; i4 < vector.size(); i4++) {
                    i3 += b(i, ((fbv) vector.elementAt(i4)).b());
                }
                return i3;
            default:
                throw new IllegalArgumentException(new StringBuffer().append("The data type was not found, the id used was ").append(i2).toString());
        }
    }
}

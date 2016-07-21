package com.example.liyanju.androiddemo.phone360;

import android.support.v4.view.MotionEventCompat;

import java.io.UnsupportedEncodingException;

public final class fcb {
    private final byte[] a;
    private final int b;
    private int c;

    private fcb(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.c = i;
        this.b = i + i2;
    }

    public static fcb a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    private static fcb a(byte[] bArr, int i, int i2) {
        return new fcb(bArr, i, i2);
    }

    public void a(int i, double d) {
        d(i, 1);
        c(Double.doubleToLongBits(d));
    }

    public void a(int i, float f) {
        d(i, 5);
        e(Float.floatToIntBits(f));
    }

    public void a(int i, long j) {
        d(i, 0);
        a(j);
    }

    public void a(int i, int i2) {
        d(i, 0);
        if (i2 >= 0) {
            b(i2);
        } else {
            a((long) i2);
        }
    }

    public void a(int i, boolean z) {
        int i2 = 0;
        d(i, 0);
        if (z) {
            i2 = 1;
        }
        d(i2);
    }

    public void a(int i, String str) {
        if (str != null) {
            d(i, 2);
            byte[] bytes = new byte[0];
            try {
                bytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            b(bytes.length);
            b(bytes);
        }
    }

//    public void a(int i, fbt contacts_fbt) {
//        if (contacts_fbt != null) {
//            d(i, 2);
//            byte[] b = contacts_fbt.b();
//            b(b.length);
//            b(b);
//        }
//    }

    public void b(int i, int i2) {
        d(i, 2);
        b(i2);
    }

    public static int b(int i, double d) {
        return a(i) + 8;
    }

    public static int b(int i, float f) {
        return a(i) + 4;
    }

    public static int b(int i, long j) {
        return a(i) + b(j);
    }

    public static int c(int i, int i2) {
        if (i2 >= 0) {
            return a(i) + c(i2);
        }
        return a(i) + 10;
    }

    public static int b(int i, boolean z) {
        return a(i) + 1;
    }

    public static int b(int i, String str) {
        if (str == null) {
            return 0;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + (a(i) + c(bytes.length));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 not supported.");
        }
    }

//    public static int b(int i, fbt contacts_fbt) {
//        if (contacts_fbt == null) {
//            return 0;
//        }
//        return (a(i) + c(contacts_fbt.a())) + contacts_fbt.a();
//    }

    private void a(byte b) {
        byte[] bArr = this.a;
        int i = this.c;
        this.c = i + 1;
        bArr[i] = b;
    }

    private void d(int i) {
        a((byte) i);
    }

    private void b(byte[] bArr) {
        if (bArr != null) {
            b(bArr, 0, bArr.length);
        }
    }

    private void b(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (this.b - this.c >= i2) {
                System.arraycopy(bArr, i, this.a, this.c, i2);
                this.c += i2;
                return;
            }
            int i3 = this.b - this.c;
            System.arraycopy(bArr, i, this.a, this.c, i3);
            int i4 = i + i3;
            i3 = i2 - i3;
            this.c = this.b;
            if (i3 <= this.b) {
                System.arraycopy(bArr, i4, this.a, 0, i3);
                this.c = i3;
            }
        }
    }

    private void d(int i, int i2) {
        b(fbz.a(i, i2));
    }

    public static int a(int i) {
        return c(fbz.a(i, 0));
    }

    public void b(int i) {
        while ((i & -128) != 0) {
            d((i & 127) | 128);
            i >>>= 7;
        }
        d(i);
    }

    public static int c(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    private void a(long j) {
        while ((-128 & j) != 0) {
            d((((int) j) & 127) | 128);
            j >>>= 7;
        }
        d((int) j);
    }

    private static int b(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }

    private void e(int i) {
        d(i & MotionEventCompat.ACTION_MASK);
        d((i >> 8) & MotionEventCompat.ACTION_MASK);
        d((i >> 16) & MotionEventCompat.ACTION_MASK);
        d((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    private void c(long j) {
        d(((int) j) & MotionEventCompat.ACTION_MASK);
        d(((int) (j >> 8)) & MotionEventCompat.ACTION_MASK);
        d(((int) (j >> 16)) & MotionEventCompat.ACTION_MASK);
        d(((int) (j >> 24)) & MotionEventCompat.ACTION_MASK);
        d(((int) (j >> 32)) & MotionEventCompat.ACTION_MASK);
        d(((int) (j >> 40)) & MotionEventCompat.ACTION_MASK);
        d(((int) (j >> 48)) & MotionEventCompat.ACTION_MASK);
        d(((int) (j >> 56)) & MotionEventCompat.ACTION_MASK);
    }
}

package com.example.liyanju.androiddemo.phone360;

/**
 * Created by liyanju on 16/6/13.
 */
public abstract class fbs implements fbv {
    public abstract void a(fcc contacts_fcc);

    public abstract int b();

    public byte[] f() {
        byte[] g = g();
        b(g);
        return g;
    }

    public void b(byte[] bArr) {
        a(new fcc(bArr));
    }

    public byte[] g() {
        return new byte[b()];
    }
}

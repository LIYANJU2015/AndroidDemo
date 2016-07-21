package com.example.liyanju.androiddemo.phone360;

/**
 * Created by liyanju on 16/6/13.
 */
public class esb extends fbs{

    public int a;

    public String b;

    public String c;

    @Override
    public void a(fcc contacts_fcc) {
        contacts_fcc.a(1, this.a);
        contacts_fcc.a(2, this.b);
        contacts_fcc.a(3, this.c);
    }

    @Override
    public int b() {
        int a = (0 + fbu.a(1, this.a)) + fbu.a(2, this.b) + fbu.a(3, this.c);
        return a;
    }
}

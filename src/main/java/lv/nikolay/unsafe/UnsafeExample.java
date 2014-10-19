package lv.nikolay.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeExample {

    public static void main(String[] args) throws NoSuchFieldException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        try {
            Unsafe unsafe = (Unsafe) f.get(null);

            int adressSize = unsafe.addressSize();
            System.out.println("Adress size = " + adressSize);

            int pageSize = unsafe.pageSize();
            System.out.println("Page size = " + pageSize);

           unsafe.throwException( new IllegalAccessException());
          // throw new IllegalAccessException();
        } catch (IllegalAccessException e) {
            System.out.println("Exception");
            e.printStackTrace();
        }

    }



}

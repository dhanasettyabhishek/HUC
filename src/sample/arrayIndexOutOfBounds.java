package sample;

import java.io.IOException;

public class arrayIndexOutOfBounds {
    public static void main(String...args)throws IOException{
        int a[] =new int[5];
        for(int i =0; i<5; i++){
            a[i]=i;
        }
        System.out.println(a[5]);
    }
}

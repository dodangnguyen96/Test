package com.example.teslocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.File;


public class Utils {

    private static String staticVariable = "I am static";
    public enum Status {
        DRAFT, PENDING, COMPLETE;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    public static void main(String[] args) {
//        Utils obj1 = new Utils();
//        Utils obj2 = new Utils();
//
//        obj1.staticVariable = "Modified by obj1";
//
//        System.out.println(obj1.staticVariable); // Output: Modified by obj1
//        System.out.println(obj2.staticVariable); // Output: Modified by obj1 (both instances share the same static variable)
        System.out.println ("Status=" + Status.DRAFT);
    }
}

package com.curioustake.clrs.activity;

import java.lang.reflect.Method;

public class ClrsMain
{
    public static void main( String[] args )
    {
        System.out.println( "Execute => ClrsMain" );

        try {
            final String className = args[0];
            Class clazz =  Class.forName(className);
            Method method = clazz.getMethod("invoke", new Class[]{String[].class});
            method.invoke(clazz.newInstance(), new Object[]{args});
        } catch (final Exception e) {
            System.out.println("Something got screwed in main");
            e.printStackTrace(System.out);
        }
    }
}

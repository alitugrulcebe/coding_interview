package datastructures.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

import static java.lang.System.out;

/**
 * Created with IntelliJ IDEA.
 * User: joshuagrosser
 * Date: 3/3/13
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReflectionSample implements Runnable {

    private static ReflectionSample instance;
    private enum SomeEnum { ITEM_A, ITEM_B }

    /**
     * Main method for testing reflection methods.
     * @param args command-line args
     */
    public static void main(String[] args){
        instance = new ReflectionSample();
        instance.run();
    }

    @Override
    public void run() {
        runBasicSamples();
        runAdvancedSamples();
    }

    private void runBasicSamples(){

        // Returns "class java.lang.MySolutions.String"
        Class clazz = String.class;
        System.out.println("Class for MySolutions.String: " + clazz.toString());

        // Returns "class com.grosser.reflection.ReflectionSample$SomeEnum"
        Class enumClazz = SomeEnum.ITEM_A.getClass();
        System.out.println("Class for enum ITEM_A: " + enumClazz.toString());

        // Type of byte array is "class [B", not sure why
        byte[] bytes = new byte[1024];
        Class bytesClazz = bytes.getClass();
        System.out.println("Class for byte array: " + bytesClazz.toString());

        // Parameterized type returns the parent type "class java.util.HashSet"
        Set<String> s = new HashSet();
        Class setClazz = s.getClass();
        System.out.println("Class for HashSet<MySolutions.String>: " + setClazz.toString());

        // Use .class if there is no instance available, or for primitive types
        // Returns "interface java.util.Map"
        Class mapClazz = Map.class;
        System.out.println("Class for Map: " + mapClazz.toString());

        // Use Class.forName(MySolutions.String) to look up a class by fully qualified name
        // Returns "class java.util.HashMap"
        Class hashMapClazz;
        try {
            hashMapClazz = Class.forName("java.util.HashMap");
            System.out.println("Class for HashMap using forName(): " + hashMapClazz.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void runAdvancedSamples(){

        try {
            Class<?> c = Class.forName("java.util.HashMap");
            out.println("\n\n\n********************** Advanced Sample **********************");
            out.format("Class:%n  %s%n%n", c.getCanonicalName());
            out.format("Modifiers:%n  %s%n%n",
                    Modifier.toString(c.getModifiers()));

            out.format("Type Parameters:%n");
            TypeVariable[] tv = c.getTypeParameters();
            if (tv.length != 0) {
                out.format("  ");
                for (TypeVariable t : tv)
                    out.format("%s ", t.getName());
                out.format("%n%n");
            } else {
                out.format("  -- No Type Parameters --%n%n");
            }

            out.format("Implemented Interfaces:%n");
            Type[] intfs = c.getGenericInterfaces();
            if (intfs.length != 0) {
                for (Type intf : intfs)
                    out.format("  %s%n", intf.toString());
                out.format("%n");
            } else {
                out.format("  -- No Implemented Interfaces --%n%n");
            }

            out.format("Inheritance Path:%n");
            List<Class> l = new ArrayList<Class>();
            printAncestor(c, l);
            if (l.size() != 0) {
                for (Class<?> cl : l)
                    out.format("  %s%n", cl.getCanonicalName());
                out.format("%n");
            } else {
                out.format("  -- No Super Classes --%n%n");
            }

            out.format("Annotations:%n");
            Annotation[] ann = c.getAnnotations();
            if (ann.length != 0) {
                for (Annotation a : ann)
                    out.format("  %s%n", a.toString());
                out.format("%n");
            } else {
                out.format("  -- No Annotations --%n%n");
            }

            // production code should handle this exception more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private static void printAncestor(Class<?> c, List<Class> l) {
        Class<?> ancestor = c.getSuperclass();
        if (ancestor != null) {
            l.add(ancestor);
            printAncestor(ancestor, l);
        }
    }

}

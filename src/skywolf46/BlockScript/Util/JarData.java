package skywolf46.BlockScript.Util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarData {

    public static Class getMain(File f) throws MalformedURLException {
        URLClassLoader cl = URLClassLoader.newInstance(new URL[] {f.toURL()});
        cl.

    }
    public static List<Class> getAllClass(File f) {
        List<Class> lc = new ArrayList<>();
        try {
//            System.out.println("Target file: " + f.getName());
            JarFile jf = new JarFile(f, false);
            Enumeration<JarEntry> entry = jf.entries();
            while (entry.hasMoreElements()) {
                JarEntry zf = entry.nextElement();
                if (zf.getName().endsWith(".class") || zf.getName().endsWith(".kt")) {
//                    System.out.println("Find : " + zf.getName());
//                    System.out.println(zf.getName());
                    try {
                        String name = zf.getName();
                        if (name.endsWith(".class")) {
                            name = name.substring(0, name.length() - 6);
                        } else if (name.endsWith(".kt")) {
                            name = name.substring(0, name.length() - 3);
                        }
                        name = name.replace("/", ".");
                        lc.add(Class.forName(name));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lc;
    }
}

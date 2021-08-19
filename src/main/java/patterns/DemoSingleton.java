package patterns;

import org.w3c.dom.ls.LSOutput;

public class DemoSingleton {
    public static void main(String[] args) {

        // process1 and process2 is the same Process class ref
        Process process1 = Process.newInstance();
        Process process2 = Process.newInstance();
        System.out.println(process1);
        System.out.println(process2);
        process1.start();
        process2.start();
    }

}

class Process {
    private int count = 0;
    private static Process instance;
    private Process() {
    }

    public static Process newInstance() {
        if (instance == null) {
            instance = new Process();
        }
        return instance;
    }

    public void start() {
        count++;
        System.out.println("Call start method count =" + count);
    }
}

import java.io.*;

public class RunCMDByJava {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "java -version");
        pb.redirectErrorStream(true);
        Process p = pb.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }
}


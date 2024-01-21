package LogicTier.MediCare.Chatbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * La seguente classe si occupa dell'itegrazione del chatbot
 */
public class MediAI {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Avvia il processo Python
        String path = "MediAI/main.py";
        ProcessBuilder pythonProcessBuilder = new ProcessBuilder("python", path);
        pythonProcessBuilder.redirectErrorStream(true);

        Process pythonProcess = pythonProcessBuilder.start();

        // Ottieni lo stream di input e output del processo Python
        BufferedReader pythonOutputReader = new BufferedReader(new InputStreamReader(pythonProcess.getInputStream()));
        PrintWriter pythonInputWriter = new PrintWriter(pythonProcess.getOutputStream());

        // Invia un messaggio di input al processo Python
       // String messageToPython = "Hello from Java!";
        //System.out.println("Java: Sending to Python: " + messageToPython);
        //pythonInputWriter.println(messageToPython);
        //pythonInputWriter.flush();

        // Leggi la risposta dal processo Python
        StringBuilder pythonResponse = new StringBuilder();
        while(pythonOutputReader.readLine() != null) {
            String line = pythonOutputReader.readLine();
            System.out.println(line);
            char[] c = line.toCharArray();
            if(line.length() >=2) {
                for (char ca : c) {
                    if (ca == '-') {
                        break;
                    }
                }
            }
        }
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(s);
        pythonInputWriter.println(s);
        pythonResponse = new StringBuilder();
        while(pythonOutputReader.readLine() != null) {
            String line = pythonOutputReader.readLine();
            System.out.println(line);
            char[] c = line.toCharArray();
            if(line.length() >=2) {
                for (char ca : c) {
                    if (ca == '-') {
                        break;
                    }
                }
            }
        }


        // Chiudi il processo Python
        pythonProcess.waitFor();
        System.out.println("Java: Python process exited with code " + pythonProcess.exitValue());
    }
}








//package LogicTier.MediCare.chatbot;
//import java.io.*;
//
//public class MediAI {
//    public static void main(String[] args) throws IOException, InterruptedException {
//        String pythonScriptPath = "MediAI/test.py";
//        ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath);
//        Process process = processBuilder.start();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        PrintWriter pythonInputWriter = new PrintWriter(process.getOutputStream());
//        String line;
//        while((line = reader.readLine()) != null){
//            System.out.println(line);
//        }
//
//        int exitCode = process.waitFor();
//        System.out.println("Processo python terminato con codice: " + exitCode);
//    }
//}

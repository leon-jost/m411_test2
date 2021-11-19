import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileVerarbeiter {
    private static ArrayList<ArrayList<String>> startlisteFileRaw = new ArrayList<>();
    private static ArrayList<Teilnehmer> startlisteFileMapped = new ArrayList<>();
    private static ArrayList<ArrayList<String>> messresultateFileRaw = new ArrayList<>();
    private static ArrayList<Messresultat> messresultateFileMapped = new ArrayList<>();

    public static void main(String[] args) {
        // startliste.txt
        // read file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/main/resources/startliste.txt"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                line = line.trim();
                Collections.addAll(startlisteFileRaw, new ArrayList<>(Arrays.asList(line.split("\\s+"))));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // map to pojo
        for (ArrayList<String> line : startlisteFileRaw) {
            startlisteFileMapped.add(new Teilnehmer(line.get(0), line.get(1), line.get(2)));
        }

        // sort
        //eingelesenesFileMapped.sort(Comparator.comparing(Teilnehmer::getJahrgang).reversed());

        // messresultate.txt
        // read file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/main/resources/messresultate.txt"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                line = line.trim();
                Collections.addAll(messresultateFileRaw, new ArrayList<>(Arrays.asList(line.split("\\s+"))));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // map to pojo
        for (ArrayList<String> line : messresultateFileRaw) {
            messresultateFileMapped.add(new Messresultat(line.get(0), line.get(1)));
        }

        // ranglisten files

        // junioren.rl.txt
        // generate new file content
        StringBuilder newFileContent = new StringBuilder();
        int counter = 1;
        for (Messresultat messresultat : messresultateFileMapped) {
            for (Teilnehmer teilnehmer : startlisteFileMapped) {
                if (teilnehmer.getKategorie().equals("1")) {
                    if (teilnehmer.getStartNr().equals(messresultat.getStartNr())) {
                        newFileContent.append(counter).append(" ").append(teilnehmer.getStartNr()).append(" ").append(messresultat.getEinlaufzeit()).append(" ").append(teilnehmer.getName());
                        counter++;
                    }
                }
            }
            newFileContent.append("\n");
        }

        // write to file
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/src/main/resources/junioren.rl.txt"))) {
            String fileContent = newFileContent.toString();
            fileContent = fileContent.trim();
            bufferedWriter.write(fileContent);
        } catch (IOException e) {
            // Exception handling
            e.printStackTrace();
        }

        // senioren.rl.txt
        // generate new file content
        StringBuilder seniorenNewFileContent = new StringBuilder();
        int seniorenCounter = 1;
        for (Messresultat messresultat : messresultateFileMapped) {
            for (Teilnehmer teilnehmer : startlisteFileMapped) {
                if (teilnehmer.getKategorie().equals("2")) {
                    if (teilnehmer.getStartNr().equals(messresultat.getStartNr())) {
                        seniorenNewFileContent.append(seniorenCounter).append(" ").append(teilnehmer.getStartNr()).append(" ").append(messresultat.getEinlaufzeit()).append(" ").append(teilnehmer.getName());
                        seniorenCounter++;
                    }
                }
            }
            seniorenNewFileContent.append("\n");
        }

        // write to file
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/src/main/resources/senioren.rl.txt"))) {
            String fileContent = seniorenNewFileContent.toString();
            fileContent = fileContent.trim();
            bufferedWriter.write(fileContent);
        } catch (IOException e) {
            // Exception handling
            e.printStackTrace();
        }

        // elite.rl.txt
        // generate new file content
        StringBuilder eliteNewFileContent = new StringBuilder();
        int eliteCounter = 1;
        for (Messresultat messresultat : messresultateFileMapped) {
            for (Teilnehmer teilnehmer : startlisteFileMapped) {
                if (teilnehmer.getKategorie().equals("3")) {
                    if (teilnehmer.getStartNr().equals(messresultat.getStartNr())) {
                        eliteNewFileContent.append(eliteCounter).append(" ").append(teilnehmer.getStartNr()).append(" ").append(messresultat.getEinlaufzeit()).append(" ").append(teilnehmer.getName());
                        eliteCounter++;
                    }
                }
            }
            eliteNewFileContent.append("\n");
        }

        // write to file
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/src/main/resources/elite.rl.txt"))) {
            String fileContent = eliteNewFileContent.toString();
            fileContent = fileContent.trim();
            bufferedWriter.write(fileContent);
        } catch (IOException e) {
            // Exception handling
            e.printStackTrace();
        }

        // namen.ref
        //Startnummer Name Kategorie Rang Laufzeit
        // generate new file content
        StringBuilder refNewFileContent = new StringBuilder();
        int refCounter = 1;
        for (Messresultat messresultat : messresultateFileMapped) {
            for (Teilnehmer teilnehmer : startlisteFileMapped) {
                if (teilnehmer.getStartNr().equals(messresultat.getStartNr())) {
                    refNewFileContent.append(teilnehmer.getStartNr()).append(" ").append(teilnehmer.getName()).append(" ").append(teilnehmer.getKategorie()).append(" ").append(refCounter).append(" ").append(messresultat.getEinlaufzeit());
                    refCounter++;
                }
            }
            refNewFileContent.append("\n");
        }

        // write to file
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/src/main/resources/namen.ref"))) {
            String fileContent = refNewFileContent.toString();
            fileContent = fileContent.trim();
            bufferedWriter.write(fileContent);
        } catch (IOException e) {
            // Exception handling
            e.printStackTrace();
        }
    }
}

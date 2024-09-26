package steps;

import java.util.List;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;


public class Utils {

    private static final String BASE_DIR = "evidences";

    public static List<String> paths() {
        return Arrays.asList(
            "reports",
            "screenshots"
        );
    }

    public static void validateAndCreateDirectories() throws IOException {
        boolean printMessage = true;  // Variable para controlar si se imprime el mensaje
        List<String> directories = paths();

        for( String item : directories ) {
            String directory = Paths.get( BASE_DIR, item ).toString();
            if( !Files.exists( Paths.get( directory ) ) ) {
                if( printMessage ) {  // Imprimir mensaje solo la primera vez
                    System.out.println("--- The evidences folder will be created ---");
                    printMessage = false;  // Cambiar a False después de imprimir el mensaje
                }
                createDirectory(directory);
                createTodaysDirectory(directory);
            } 
            else {
                createTodaysDirectory(directory);
            }
        }
    }

    public static void createDirectory(String directory) throws IOException {
        System.out.println("Creating directory: " + directory);
        Files.createDirectories(Paths.get(directory));
    }

    public static void createTodaysDirectory(String directory) throws IOException {
        String folderDate = getDate();
        String todaysFolder = Paths.get(directory, folderDate).toString();
        Files.createDirectories(Paths.get(todaysFolder));
        executionFolder(todaysFolder);
    }

    public static void executionFolder(String path) throws IOException {
        File folder = new File(path);
        String[] subfolders = folder.list((current, name) -> new File(current, name).isDirectory());
        int subfolderCount = (subfolders != null ? subfolders.length : 0) + 1;
        String executionFolder = Paths.get(path, String.valueOf(subfolderCount)).toString();
        Files.createDirectories(Paths.get(executionFolder));
    }

    public static String getDate() {
        return new SimpleDateFormat("ddMMyyyy").format(new Date());
    }
    
    public static String getLastReportFolderName(String directory) throws IOException {
        String folderDate = getDate();
        String path = Paths.get(BASE_DIR, directory, folderDate).toString();
        System.out.println(path);

        try {
            // Obtener la lista de elementos en la carpeta
            File folder = new File(path);
            String[] elements = folder.list();

            if (elements == null) {
                throw new IOException("No elements found in the directory: " + path);
            }

            // Filtrar solo los elementos que sean directorios
            List<String> directories = Arrays.stream(elements)
                    .filter(element -> new File(path, element).isDirectory())
                    .collect(Collectors.toList());

            // Obtener el nombre de la última carpeta en función de su valor numérico
            int lastFolderNumber = directories.stream()
                    .mapToInt(Integer::parseInt)
                    .max()
                    .orElseThrow(() -> new IOException("No directories found in the directory: " + path));

            String lastFolder = String.valueOf(lastFolderNumber);
            String relativePath = Paths.get(path, lastFolder).toString();

            return relativePath;
        } catch (IOException e) {
            System.err.println("There was an error: " + e.getMessage());
            throw e;
        }
    }
}

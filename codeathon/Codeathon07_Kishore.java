/*
 * Core Java Problem Solving - Codeathon.
 * A.R. Kishore Kumar ~ (c) 2023 ~ -- ~ Tirupati, Andhra Pradesh, India ~
 *
 */

package codeathon;

import java.io.File;
import java.util.*;

public class Codeathon07_Kishore
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory())
        {
            System.out.println("Directory Not Found on the Filesystem");
            return;
        }
        Map<String, List<String>> fileMap = WinDirectorySearch.listFiles(directory);

        DisplayFileDetails.printFileMap(fileMap);
    }
}
class WinDirectorySearch
{
    // Method to store fully qualified directory name as the key
    // and a list of .txt and .exe files as the values
    public static Map<String, List<String>> listFiles(File directory)
    {
        Map<String, List<String>> fileMap = new TreeMap<>();
        File[] files = directory.listFiles();
        if (files != null)
        {
            List<String> txtAndExeFiles = new ArrayList<>();
            for (File file : files)
            {
                if (file.isDirectory())
                {
                    Map<String, List<String>> childFileMap = listFiles(file);
                    if (!childFileMap.isEmpty())
                    {
                        fileMap.putAll(childFileMap);
                    }
                }
                else
                {
                    String fileName = file.getName().toLowerCase();
                    if (fileName.endsWith(".txt") || fileName.endsWith(".exe"))
                    {
                        txtAndExeFiles.add(file.getName());
                    }
                }
            }
            if (!txtAndExeFiles.isEmpty())
            {
                fileMap.put(directory.getAbsolutePath(), txtAndExeFiles);
            }
            else
            {
                fileMap.put(directory.getAbsolutePath(), new ArrayList<>());
            }
        }
        return fileMap;
    }
}

class DisplayFileDetails
{
    // Method that displays the directory hierarchy with file names
    public static void printFileMap(Map<String, List<String>> fileMap)
    {
        for (String dirName : fileMap.keySet())
        {
            List<String> files = fileMap.get(dirName);
            System.out.print(dirName);
            if (!files.isEmpty())
            {
                System.out.print("\t" + String.join(", ", files));
            }
            System.out.println();
        }
    }
}

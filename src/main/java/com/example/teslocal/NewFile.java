package com.example.teslocal;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NewFile {
    public static void main(String[] args) {

        ClassPathResource classPathResource = new ClassPathResource("test");
        try {
            Path path = Paths.get("testFile");

            Files.createDirectories(path);
            File directory = new File("testFile");

            System.out.println("Directory is created!");
            OutputStream outStream = new FileOutputStream(directory);
            byte[] binaryData = FileCopyUtils.copyToByteArray(classPathResource.getInputStream());
            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = classPathResource.getInputStream().read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
//            Files.write(directory.toPath(), binaryData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) throws IOException {
//// Step 1: Get the resource URL of the directory
//        ClassPathResource resource = new ClassPathResource("test");
//        File resourceDirectory = resource.getFile();
//
//        // Step 2: Create a new directory in your main application
//        File newDirectory = new File("testFile");
//        newDirectory.mkdirs(); // Create directories if they don't exist
//
//        // Step 3: Copy the files from the resource directory to the new directory
//        if (resourceDirectory.isDirectory()) {
//            File[] files = resourceDirectory.listFiles();
//            if (files != null) {
//                for (File file : files) {
//                    Path sourcePath = file.toPath();
//                    Path targetPath = newDirectory.toPath().resolve(file.getName());
//
//                    // Use Files.copy to copy the files
//                    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
//
//                    // If you want to copy file content using Spring's FileCopyUtils
//                    // Uncomment the following lines
//                    /*
//                    byte[] fileBytes = FileCopyUtils.copyToByteArray(file);
//                    Files.write(targetPath, fileBytes);
//                    */
//                }
//            }
//        }
//    }
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

    @Service
    public class CopyService {

        private final ResourceLoader resourceLoader;

        @Autowired
        public CopyService(ResourceLoader resourceLoader) {
            this.resourceLoader = resourceLoader;
        }

        public void copyResources() throws IOException {
            Resource resource = resourceLoader.getResource("classpath:static-folder/files-to-copy");

            if (resource.exists()) {
                File sourceDirectory = resource.getFile();
                File targetDirectory = new File("target-location"); // Change to your desired target location

                if (!targetDirectory.exists()) {
                    targetDirectory.mkdirs();
                }

                for (File sourceFile : sourceDirectory.listFiles()) {
                    Path targetPath = targetDirectory.toPath().resolve(sourceFile.getName());
                    Files.copy(sourceFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
                }
            } else {
                throw new IllegalStateException("Resource not found.");
            }
        }
    }

}

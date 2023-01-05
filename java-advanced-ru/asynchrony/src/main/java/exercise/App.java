package exercise;

import java.io.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN

    // END

    public static void main(String[] args) {
        // BEGIN
        // END
    }

    public static CompletableFuture<String> unionFiles(String firstFile, String secondFile, String destPath) {
        CompletableFuture<String> first = CompletableFuture.supplyAsync(() -> {
            String str = "";

            try {
                str += Files.readString(getFullPath(firstFile));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return str;
        }).exceptionally(App::exceptionHandler);

        CompletableFuture<String> second = CompletableFuture.supplyAsync(() -> {
            String str = "";

            try {
                str += Files.readString(getFullPath(secondFile));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return str;
        }).exceptionally(App::exceptionHandler);

        return first.thenCombine(second, (firstStr, secondStr) -> {
            String res = firstStr + secondStr;
            try {
                Files.writeString(getFullPath(destPath), res, StandardOpenOption.CREATE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return res;
        }).exceptionally(ex -> {
            System.out.println("Ooops!");
            return null;
        });

    }

    private static String exceptionHandler(Throwable ex) {
        System.out.println("Oops! We have an exception - " + ex.getMessage());
        return null;
    }


    private static Path getFullPath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    public static CompletableFuture<Long> getDirectorySize(String path) {
        return CompletableFuture.supplyAsync(() -> {
            Long size;
            try {
                size = Files.walk(getFullPath(path), 1)
                        .filter(Files::isRegularFile)
                        .mapToLong(p -> {
                            try {
                                return Files.size(p);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .sum();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return size;
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });
    }
}


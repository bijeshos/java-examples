package io.github.bijeshos.javaexamples.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NioDemo {
    public static void main(String[] args) {
        readFileInfo();
    }

    private static void readFileInfo() {
        try (Stream<Path> pathStream = Files.walk(Paths.get("C:\\BOS\\tmp"))) {
            List<Path> fileList = pathStream.filter(path -> !Files.isDirectory(path))
                                            .map(path -> path.getParent())
                                            .collect(Collectors.toList());
            fileList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

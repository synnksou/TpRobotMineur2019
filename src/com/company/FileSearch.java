package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileSearch {


    public static boolean Search(String string) throws IOException {
        Path testPath = Paths.get("/Users/heinrichano/Documents/cheat/DUT INFO/M2103 - Bases de la programmation orientée objet/TP/TpRobotMineur2019/save/");
        //finding files containing 'items' in name
        final boolean[] res = {false};
        Stream<Path> stream =
                Files.find(testPath, 100,
                        (path, basicFileAttributes) -> {
                            File file = path.toFile();
                            res[0] =true;
                            return !file.isDirectory() &&
                                    file.getName().contains("items");

                        });
       return res[0];
    }

}

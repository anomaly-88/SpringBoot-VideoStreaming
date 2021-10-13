package com.ask.home.videostream.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.ask.home.videostream.constants.ApplicationConstants.VIDEO;

public class ListFolderItems {


    private String getFilePath() {
        URL url = this.getClass().getResource(VIDEO);
        return new File(url.getFile()).getAbsolutePath();
    }


    public ArrayList getFiles(){
        ArrayList<String> folderItemsArr = new ArrayList<>();

    // try-catch block to handle exceptions
        try (Stream<Path> walk = Files.walk(Paths.get(getFilePath()))) {
            // We want to find only regular files
            List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());

            result.forEach(folderItemsArr::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return folderItemsArr;
    }

}


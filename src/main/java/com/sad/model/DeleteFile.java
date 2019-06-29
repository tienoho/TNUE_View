package com.sad.model;

import java.io.File;
import java.io.IOException;

public class DeleteFile {

    public DeleteFile(String source, String filename) throws IOException {
        //deleteFile(source);
        deleteListFileInfolder(source, filename);
    }
    public boolean deleteListFileInfolder(String source, String filename) {
        File folder = new File(source);
//        folder tồn tại
        if (folder.exists()) {
//            danh sách file
            File[] listFile = folder.listFiles();
            if (listFile.length != 0)
                for (File f : listFile)
                    if (f.isFile())
                        if (!f.getName().equals(filename))
                            f.delete();
            return true;
        } else {
            System.out.println("folder không tồn tại");
            return false;
        }
    }
}

package mta.course.java.stepper.dd.impl.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileData {
    private File file;
    private String path;
    private InputStream inputStream;

    public FileData(String path) throws Exception {
        this.path = path;
        this.file = new File(path);
        this.inputStream = new FileInputStream(file);
    }

    public File getFile() {
        return file;
    }

    public String getPath() {
        return path;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}

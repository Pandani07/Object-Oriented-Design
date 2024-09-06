package FilterPattern.LinuxCommand;

import java.util.*;
import java.lang.*;

public class FileObject {
    private String name;
    private long size;
    private boolean isDirectory;
    private String extension;
    private Date lastModified;

    public FileObject(String name, long size, boolean isDirectory, String extension, Date lastModified) {
        this.name = name;
        this.size = size;
        this.isDirectory = isDirectory;
        this.extension = extension;
        this.lastModified = lastModified;
    }

     public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public String getExtension() {
        return extension;
    }

    public Date getLastModified() {
        return lastModified;
    }

    @Override
    public String toString() {
        return "FileObject{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", isDirectory=" + isDirectory +
                ", extension='" + extension + '\'' +
                ", lastModified=" + lastModified +
                '}';
    }
}

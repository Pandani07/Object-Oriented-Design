package LinuxFind;

import java.util.*;

abstract class FileSystemObject {
    protected String name;
    protected String path;
    protected long size;

    public FileSystemObject(String name, String path, long size) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.size;
    }

    public abstract boolean isDirectory();

}

class File extends FileSystemObject {
    public File(String name, String path, long size) {
        super(name, path, size);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }
}

class Directory extends FileSystemObject {
    private List<FileSystemObject> contents;

    public Directory(String name, String path) {
        super(name, path, 0);
        this.contents = new ArrayList<>();
    }

    public void add(FileSystemObject obj) {
        this.contents.add(obj);
        this.size += 1;
    }

    public List<FileSystemObject> getContents() {
        return this.contents;
    }

    @Override
    public boolean isDirectory() {
        return true;
    };

}

abstract class SearchCriteria {
    public abstract boolean matches(FileSystemObject obj);
}

class NameCriteria extends SearchCriteria {
    private String name;

    public NameCriteria(String name) {
        this.name = name;
    }

    @Override
    public boolean matches(FileSystemObject obj) {
        return obj.getName().equals(this.name);
    }
}

class SizeCriteria extends SearchCriteria {
    private long size;

    public SizeCriteria(long size) {
        this.size = size;
    }

    @Override
    public boolean matches(FileSystemObject obj) {
        return obj.getSize() == this.size;
    }
}

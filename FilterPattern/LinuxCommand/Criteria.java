package FilterPattern.LinuxCommand;

import java.util.*;
import java.io.File;
import java.lang.*;

public interface Criteria {
    public List<FileObject> meetsCriteria(List<FileObject> files);
}

class NameCriteria implements Criteria {
    private String name;

    public NameCriteria(String name) {
        this.name = name;
    }

    @Override
    public List<FileObject> meetsCriteria(List<FileObject> files) {
        List<FileObject> name_output = new ArrayList<>();
        for (FileObject file : files) {
            if (file.getName().contains(name)) {
                name_output.add(file);
            }
        }
        return name_output;
    }
}

class SizeCriteria implements Criteria {
    private long minSize;
    private long maxSize;

    public SizeCriteria(long minSize, long maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    @Override
    public List<FileObject> meetsCriteria(List<FileObject> files) {
        List<FileObject> filteredFiles = new ArrayList<>();
        for (FileObject file : files) {
            long file_size = file.getSize();
            if (minSize <= file_size && file_size <= maxSize) {
                filteredFiles.add(file);
            }
        }
        return filteredFiles;
    }
}

class ExtensionCriteria implements Criteria {
    private String extension;

    public ExtensionCriteria(String extension) {
        this.extension = extension;

    }

    @Override
    public List<FileObject> meetsCriteria(List<FileObject> files) {
        List<FileObject> filteredFiles = new ArrayList<>();
        for (FileObject file : files) {
            if (file.getExtension().equalsIgnoreCase(extension)) {
                filteredFiles.add(file);
            }
        }
        return filteredFiles;
    }
}

class DirectoryCriteria implements Criteria {
    @Override
    public List<FileObject> meetsCriteria(List<FileObject> files) {
        List<FileObject> filteredFiles = new ArrayList<>();
        for (FileObject file : files) {
            if (file.isDirectory()) {
                filteredFiles.add(file);
            }
        }
        return filteredFiles;
    }
}

class AndCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<FileObject> meetsCriteria(List<FileObject> files) {
        List<FileObject> successCriteria = criteria.meetsCriteria(files);
        return otherCriteria.meetsCriteria(successCriteria);
    }
}

class OrCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<FileObject> meetsCriteria(List<FileObject> files) {
        List<FileObject> firstCriteriaFiles = criteria.meetsCriteria(files);
        List<FileObject> secondCriteriaFiles = otherCriteria.meetsCriteria(files);
        for (FileObject file : secondCriteriaFiles) {
            if (!firstCriteriaFiles.contains(file)) {
                firstCriteriaFiles.add(file);
            }
        }
        return firstCriteriaFiles;
    }
}

class NotCriteria implements Criteria {
    private Criteria criteria;

    public NotCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
    }

    @Override
    public List<FileObject> meetsCriteria(List<FileObject> files) {
        List<FileObject> yesCriteria = criteria.meetsCriteria(files);
        List<FileObject> doesntMeet = new ArrayList<>();
        for (FileObject file : files) {
            if (!yesCriteria.contains(file)) {
                doesntMeet.add(file);
            }
        }
        return doesntMeet;
    }
}
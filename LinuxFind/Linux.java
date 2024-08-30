package LinuxFind;

import java.util.ArrayList;
import java.util.*;

public class Linux {
    public static void main(String args[]) {
        Directory rootDir = new Directory("root", "/root");
        File file1 = new File("file1.txt", "/root/file1.txt", 64);
        File file2 = new File("file2.txt", "/root/file2.txt", 128);
        Directory subdir = new Directory("subdir", "/root/subdir");
        File file3 = new File("file3.txt", "/root/subdir/file3.txt", 32);

        rootDir.add(file1);
        rootDir.add(file2);
        subdir.add(file3);
        rootDir.add(subdir);

        List<SearchCriteria> criteria = new ArrayList<>();
        criteria.add(new NameCriteria("file1.txt"));
        criteria.add(new SizeCriteria(128));

        FindCommand cmd = new FindCommand();
        List<FileSystemObject> results = cmd.execute(rootDir, criteria);
    }

}

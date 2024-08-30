package LinuxFind;

import java.util.*;

public class FindCommand {
    public List<FileSystemObject> execute(Directory rootDir, List<SearchCriteria> criteriaList) {
        List<FileSystemObject> result = new ArrayList<>();
        search(rootDir, criteriaList, result);
        return result;
    }

    private void search(Directory rootDir, List<SearchCriteria> criteriaList, List<FileSystemObject> result) {
        for (FileSystemObject obj : rootDir.getContents()) {
            boolean matches = true;
            for (SearchCriteria criteria : criteriaList) {
                if (!criteria.matches(obj)) {
                    matches = false;
                    break;
                }
            }

            if (matches) {
                result.add(obj);
            }

            if (obj.isDirectory()) {
                search((Directory) obj, criteriaList, result);
            }
        }
    }
}

package net.famunity.trial.java;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhanming.cui on 26/06/2017.
 */
public class ClassFieldReferenceByLocalObject {

    public static void main(String[] args) {
        ClassA classA = new ClassA("lostAndFound");
        classA.checkMethodLocalObjectWithClassField();
    }

}

class ClassA {
    private String repairFolder;
    private String defaultFolder;
    private int addedFolders;

    public ClassA(String repairFolder) {
        this.defaultFolder = repairFolder;
        this.repairFolder = repairFolder;
        this.addedFolders = 0;
    }

    private void changeRepairFolder(){
        repairFolder = defaultFolder + String.valueOf(addedFolders++);
    }

    private void changeRepairFolder(List<ClassB> classBs){
        repairFolder = defaultFolder + String.valueOf(addedFolders++);
        classBs.stream().forEach(classB -> classB.setFolderName(repairFolder));
    }

    private ClassB getClassB(){
        ClassB classB = new ClassB();
        classB.setFolderName(repairFolder);
        return classB;
    }

    public void checkMethodLocalObjectWithClassField(){
        List<ClassB> classBs = Arrays.asList(getClassB());
        System.out.println("class A's repairFolder: " + repairFolder + ", class B's: " + classBs.get(0).getFolderName());
        changeRepairFolder();
        System.out.println("class A's repairFolder: " + repairFolder + ", class B's: " + classBs.get(0).getFolderName());
        changeRepairFolder(classBs);
        System.out.println("class A's repairFolder: " + repairFolder + ", class B's: " + classBs.get(0).getFolderName());
    }
}

class ClassB {
    private String folderName;

    public ClassB() {
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }
}

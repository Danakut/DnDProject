package cz.danakut.dnd.Exceptions;

import java.io.FileNotFoundException;

public class FileSelectionAbortedException extends FileNotFoundException{

    public FileSelectionAbortedException() {

    }

    public FileSelectionAbortedException(String message) {
        super(message);
    }
}

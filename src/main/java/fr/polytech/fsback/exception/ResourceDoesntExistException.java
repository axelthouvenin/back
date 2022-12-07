package fr.polytech.fsback.exception;

public class ResourceDoesntExistException extends RuntimeException {

    public ResourceDoesntExistException(String message) {
        super(message);
    }
}

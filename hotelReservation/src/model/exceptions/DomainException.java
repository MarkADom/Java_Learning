package model.exceptions;

import java.io.Serial;

public class DomainException extends RuntimeException {

    /*
     * Objects from a Serializable Class can be converted on bites.
     * allowing then to be used on networks, archives, etc...
     * But they need a version
     * Below a default declaration of version of a class serializable
     */

    @Serial
    private static final long serialVersionUID = 1L;


    //Allows to instantiate the personalized exception version passing a message

    public DomainException(String msg) {
        super(msg);
    }
}

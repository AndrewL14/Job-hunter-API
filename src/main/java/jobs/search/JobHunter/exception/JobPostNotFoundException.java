package jobs.search.JobHunter.exception;

import java.io.Serial;


public class JobPostNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -3467951604442849202L;


    public JobPostNotFoundException() {
        super();
    }

    public JobPostNotFoundException(String message) {
        super(message);
    }

    public JobPostNotFoundException(String message , Throwable cause) {
        super(message , cause);
    }

    public JobPostNotFoundException(Throwable cause) {
        super(cause);
    }
}

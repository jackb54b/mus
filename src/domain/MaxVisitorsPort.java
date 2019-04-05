package domain;

import java.io.InputStream;
/**
 * Port to business logic
 * */
public interface MaxVisitorsPort {
    /**
     * It does business logic from task.
     * @param stream stream with visitors entrance-exit
     * */
    void execute(InputStream stream);
}

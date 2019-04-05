package domain;
/**
 * It builds object doing business logic with proper input parser and result presenter classes.
 * */
public class MaxVisitorsPortBuilder {

    /**
     * @return MaxVisitorsAdapter
     * */
    public static MaxVisitorsAdapter buildForFileInputStreamInputAndConsoleOutput() {
        return new MaxVisitorsAdapter(new InputParserFile(), new ResultPresenterConsole());
    }
}

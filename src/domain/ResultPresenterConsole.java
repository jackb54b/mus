package domain;

class ResultPresenterConsole implements ResultPresenter {

    /**
     * It shows result on console
     * @param input line with visitor entrance and exit hours
     * */
    @Override
    public void execute(Result input) {
        StringBuilder output = new StringBuilder();
        output.append(input.start.toString())
                .append(" - ")
                .append(input.end.toString())
                .append(";")
                .append(input.guests.toString());
        System.out.println(output.toString());
    }

}

package domain;

import java.time.LocalTime;

class Visit {
    final LocalTime start;
    final LocalTime end;

    Visit(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }
}

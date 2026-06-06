package models.positive;

public record ProjectGetRs(
        boolean status,
        Result result
) {
    public record Result(
            String title,
            String code,
            Counts counts
    ) {
    }

    public record Counts(
            int cases,
            int suites,
            int milestones,
            Runs runs,
            Defects defects
    ) {
    }

    public record Runs(
            int total,
            int active
    ) {
    }

    public record Defects(
            int total,
            int open
    ) {
    }
}
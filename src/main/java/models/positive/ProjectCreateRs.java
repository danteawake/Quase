package models.positive;

public record ProjectCreateRs(
        boolean status,
        Result result
) {
    public record Result(
            String code
    ) {
    }
}
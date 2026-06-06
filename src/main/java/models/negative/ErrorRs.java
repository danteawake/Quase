package models.negative;

public record ErrorRs(
        boolean status,
        String errorMessage
) {
}
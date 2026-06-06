package models.positive;

public record ProjectCreateRq(String title,
                              String code,
                              String description,
                              String access,
                              String group) {

    public static ProjectCreateRq testQA() {

        String timestamp = String.valueOf(System.currentTimeMillis()).substring(8);

        String generatedTitle = "TestQaApi_" + timestamp;
        String generatedCode = ("TQA" + timestamp).toUpperCase();

        return new ProjectCreateRq(
                generatedTitle,
                generatedCode,
                "test",
                "all",
                "all");
    }
}
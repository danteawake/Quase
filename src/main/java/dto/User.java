package dto;

public record User(String login,
                   String password) {

    public static User oleg() {
        return new User(
                "danteawake88@gmail.com",
                "MFe-545B@aLLvLh");
    }
}
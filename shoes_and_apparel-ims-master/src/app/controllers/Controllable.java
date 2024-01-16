package app.controllers;

public interface Controllable {
    abstract String validateUsername(String name);
    abstract String validateContact(String contact);
    abstract String validateEmail(String email);
    abstract int userAge();
    void timeIn(int user_id);
    void birthMonth(String month);
    void birthDay(int day);
    void birthYear(int year);
    void userForm();
    void userForm(int user_id);
    void createUser();
}

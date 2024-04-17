import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        userRegistration("abC6s_defbc", "Def_9abs", "Def_9abs");
    }

    public static void userRegistration(String login, String password, String confirmPassword) {
        try {
            getAccordance(login, password);
            getAcceptableLenght(login, password);
            getEquality(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("login или password длиннее 20 символов или содержит в себе недопустимые символы или пароли не совпадают");
        } catch (WrongPasswordException e) {
            System.out.println("password длиннее 20 символов или содержит в себе недопустимые символы или пароли не совпадают");
        } finally {
            System.out.println("Блок try выполнен");
        }
    }

    private static void getAccordance(String login, String password) throws WrongLoginException, WrongPasswordException {
        Pattern pattern = Pattern.compile("[a-zA-Z_0-9]*");
        Matcher log = pattern.matcher(login);
        Matcher pass = pattern.matcher(password);
        if (log.matches() == true && pass.matches() == true) {
            System.out.println("Логин и пароль соответствуют синтаксису");
        } else if (log.matches() == false && pass.matches() == true) {
            throw new WrongLoginException("Wrong login");
        } else if (log.matches() == true && pass.matches() == false) {
            throw new WrongPasswordException("Wrong password");
        } else {
            throw new WrongLoginException("Wrong login");
        }
    }

    private static void getAcceptableLenght(String log, String pass) throws WrongLoginException, WrongPasswordException {
        if (log.length() <= 20 && pass.length() <= 20) {
            System.out.println("Логин и пароль соответствуют необходимой длине");
        } else if (log.length() > 20 && pass.length() <= 20) {
            throw new WrongLoginException("Wrong login");
        } else if (log.length() <= 20 && pass.length() > 20) {
            throw new WrongPasswordException("Wrong password");
        } else {
            throw new WrongLoginException("Wrong login");
        }
    }

    private static void getEquality(String pass, String confPass) throws WrongPasswordException {
        if (pass.equals(confPass)) {
            System.out.println("Пароли соответствуют");
        } else {
            throw new WrongPasswordException("Password mismatch");
        }
    }
}

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        userRegistration("abC6s_defbc", "ФDef_9abs", "аDef_9abs");
    }

    public static void userRegistration(String login, String password, String confirmPassword) {
        try {
            getAccordance(login, password);
            getAcceptableLenght(login, password);
        } catch (WrongLoginException e) {
            System.out.println("login длиннее 20 символов или содержит в себе недопустимые символы");
        } catch (WrongPasswordException e) {
            System.out.println("password длиннее 20 символов или содержит в себе недопустимые символы");
        } finally {
            System.out.println("Блок try выполнен");
        }

        try {
            getEquality(password, confirmPassword);
        } catch (WrongPasswordException e) {
            System.out.println("Пароли не совпадают");
        }
    }

    private static boolean getAccordance(String login, String password) throws WrongLoginException, WrongPasswordException {
        Pattern pattern = Pattern.compile("\\w*");
        Matcher log = pattern.matcher(login);
        Matcher pass = pattern.matcher(password);
        if (log.matches() == true && pass.matches() == true) {
            return true;
        } else if (log.matches() == false && pass.matches() == true) {
            throw new WrongLoginException("Wrong login");
        } else if (log.matches() == true && pass.matches() == false) {
            throw new WrongPasswordException("Wrong password");
        } else {
            throw new WrongLoginException("Wrong login");
        }
    }

    private static boolean getAcceptableLenght(String log, String pass) throws WrongLoginException, WrongPasswordException {
        if (log.length() <= 20 && pass.length() <= 20) {
            return true;
        } else if (log.length() > 20 && pass.length() <= 20) {
            throw new WrongLoginException("Wrong login");
        } else if (log.length() <= 20 && pass.length() > 20) {
            throw new WrongPasswordException("Wrong password");
        } else {
            throw new WrongLoginException("Wrong login");
        }
    }

    private static boolean getEquality(String pass, String confPass) throws WrongPasswordException {
        if (pass.equals(confPass)) {
            return true;
        } else {
            throw new WrongPasswordException("Password mismatch");
        }
    }
}

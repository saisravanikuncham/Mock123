package exception;
public class EmployeeException extends Exception {
public EmployeeException() {
    System.out.println("id does not exist");
}
}
package ThreadTaskPort;

public class PortException extends Exception{
    String problem;

    PortException(String problem){
        this.problem = problem;
    }
}

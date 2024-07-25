package log4jDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4jDmo {

    private static Logger logger = LogManager.getLogger(log4jDmo.class);
    public static void main(String[] args){

        System.out.println("\n Hello World \n");

        logger.info("This is information message");
        logger.fatal("This is fatal message");
        logger.warn("This is warning message");
        logger.error("This is an error");

        System.out.println("\n Completed ");

    }

}

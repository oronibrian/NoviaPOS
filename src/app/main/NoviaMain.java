/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.main;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ke.novia.config.SystemConfig;
import ke.novia.config.PersistenceConfig;

/**
 *
 * @author kb
 */
public class NoviaMain //extends app.ebean.LoadAgentAtRuntime
{
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static Logger logger;
    public static AnnotationConfigApplicationContext context;
    
    private static Class[] aspectClasses;
    
    public NoviaMain()
    {   
        /*
        Logger slogger = Logger.getLogger(NoviaMain.class);
        try {
            System.setProperty("current.date", new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date()));//d.getYear()+"_"+d.getMonth()+"_"+d.getDate());
            String path = new File(".").getCanonicalPath();
            PropertyConfigurator.configure(new FileInputStream(path + "/log4j.properties"));
            slogger.info("log4j is healthy and can read properties.");
            //slogger.info("Info");
             //slogger.debug("Debug");
             //slogger.warn("warn");
             //slogger.error("error");
             //slogger.fatal("fatal");

        } catch (IOException ex) {
            BasicConfigurator.configure();
            slogger.error(ex.getMessage());
        }
        */
        
        //aspectClasses = new Class[]{StockController.class};//DatabaseAspects.class
        context = new AnnotationConfigApplicationContext(new Class[]{SystemConfig.class,PersistenceConfig.class});
        //slogger.debug("context init done");
        new MainWindow().setVisible(true);
        //novia = (app.main.MainWindowObserver) ProxyCreator.createProxy(context, "db", aspectClasses);
        //StockController novia = context.getBean(StockController.class);
        //novia.getAll();
       // StockController sc = new StockController();
       // sc.getAll();
    }
    
    public static void main(String[] args)
    { 
        new NoviaMain();
    }
   
}


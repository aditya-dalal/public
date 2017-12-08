package designPatternsNew.structural.facade.example2;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class Client {
    public static void main(String[] args) {
        HelperFacade facade = new HelperFacade();
        facade.generateReport(HelperFacade.DBType.MYSQL, HelperFacade.ReportType.HTML);
        facade.generateReport(HelperFacade.DBType.ORACLE, HelperFacade.ReportType.XML);
    }
}

package designPatternsNew.structural.facade.example2;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class HelperFacade {

    public void generateReport(DBType db, ReportType report) {
        switch (db) {
            case MYSQL:
                MysqlHelper mysqlHelper = new MysqlHelper();
                switch (report) {
                    case HTML:
                        mysqlHelper.generateHTMLReport();
                        break;
                    case XML:
                        mysqlHelper.generateXMLReport();
                        break;
                }
                break;
            case ORACLE:
                OracleHelper oracleHelper = new OracleHelper();
                switch (report) {
                    case HTML:
                        oracleHelper.generateHTMLReport();
                        break;
                    case XML:
                        oracleHelper.generateXMLReport();
                        break;
                }
                break;
        }
    }
    public enum DBType {
        MYSQL, ORACLE
    }

    public enum ReportType {
        HTML, XML
    }
}

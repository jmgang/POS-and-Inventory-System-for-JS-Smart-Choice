/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.reports;

import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import java.util.ArrayList;
import java.util.Collection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author JANSEN
 */
public class DynaReportApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Collection<TestBean> list = new ArrayList<>();
 
        list.add(new TestBean(101, "Melrose", "my bae",  67, (float) 2.5));
        list.add(new TestBean(255, "Cassandra", "soon to be MY future wife",  89, (float) 7000));
        list.add(new TestBean(615, "Andres", "Ang",  12, (float) 8900));
       
        
        TestReport report = new TestReport(list);
 
        try {
            JasperPrint jp = report.getReport();
            JasperViewer jasperViewer = new JasperViewer(jp);
            jasperViewer.setVisible(true);
 
        } catch (JRException | ColumnBuilderException | ClassNotFoundException ex) {
 
        }
    }
    
}

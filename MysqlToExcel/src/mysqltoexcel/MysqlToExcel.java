/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqltoexcel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author wdfeww
 */
public class MysqlToExcel {

  public static void main(String[] args) throws BiffException, IOException, WriteException, ClassNotFoundException, InstantiationException, IllegalAccessException{
       
      ConnectionProvider connection = new ConnectionProvider();
      List<City> cities = connection.getAllCities();
      
      WritableWorkbook wworkbook;
      wworkbook = Workbook.createWorkbook(new File("output.xls"));
      WritableSheet wsheet = wworkbook.createSheet("Cities", 0);
      
      for(City city:cities){
          wsheet.addCell( new Label(0, city.id, ""+city.getid()));
          wsheet.addCell( new Label(1, city.id, city.getname()));
          wsheet.addCell( new Label(2, city.id, city.getcountryCode()));
          wsheet.addCell( new Label(3, city.id, city.getdistrict()));
          wsheet.addCell( new Label(4, city.id, ""+city.getpopulation()));
      }
      
      wworkbook.write();
      wworkbook.close();
   }
    
}

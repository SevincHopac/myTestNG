package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;
import techproed.utilities.ExcelUtils;

public class Day07_DataProvider {

    //    Bu ornekde, data provider metodumuz Util classdan gelecek
//    musteriVerileri
    @Test(dataProvider = "musteriVerileri",dataProviderClass = DataProviderUtils.class)
    public void musteriVerileriTest(String username,String password,String sube){
        System.out.println("Username : "+ username+". Password : "+password+" Sube : "+ sube);
    }

    //    musteriHizmetleriVerileri
    @Test(priority = 1,dataProvider = "musteriHizmetleriVerileri",dataProviderClass = DataProviderUtils.class)
    public void musteriHizmetleriVerileriTest(String username,String password){
        System.out.println(username+"  |  "+password);

    }
    //    personelVerileri
    @Test(priority = 2,dataProvider = "personelVerileri",dataProviderClass = DataProviderUtils.class)
    public void personelVerileriTest(String username,String password){
        System.out.println(username+"  |  "+password);
    }

    @Test(dataProvider = "customerData",dataProviderClass = DataProviderUtils.class)
    public void excelTestDatapro(String mail,String pass) {
        System.out.println(mail+"--> "+ pass );
    }
}

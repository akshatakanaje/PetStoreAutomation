package api.utilities;

import java.io.IOException;

public class DataProviders {

    public String[][] getAllData() throws IOException {
        String path=System.getProperty("user.dir")+"//testData//userData.xlsx";
        XLUtility xl=new XLUtility(path);

        int rownum=xl.getRowCount("Sheet1");
        int columncount=xl.getCellCount("Sheet1", 1);

        String apidata[][] = new String[rownum][columncount];

        for(int i=1;i<=rownum;i++){
            for(int j=0;j<columncount;j++){
                apidata[i-1][j]= xl.getCellData("Sheet1",i,j);
            }
        }
        return apidata;
    }

    public String[] getUserNames() throws IOException {
        String path=System.getProperty("user.dir")+"//testData//userData.xlsx";
        XLUtility xl=new XLUtility(path);

        int rownum=xl.getRowCount("Sheet1");

        String apidata[]=new String[rownum];

        for(int i=1;i<rownum;i++){
            apidata[i-1]=xl.getCellData("Sheet1",i,1);
        }
        return apidata;
    }
}

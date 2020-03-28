/*
 * Created on 2005-10-13
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.test;


/*
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.data.general.DefaultPieDataset;
*/

import com.inspire.tool.CreateDevelopFile;




/**
 * @author EADING
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Test {

	public static void main(String[] args) throws Exception {

          CreateDevelopFile c = new CreateDevelopFile("localhost","orcl","zydt","zydt","","test","d:/","");

          //CreateDevelopFile c = new CreateDevelopFile("134.128.52.132","oss","zydt","zydt","","gzwh_ordertbl","d:/","");
       		

           c.createBean();
           c.createXML();
          //c.createSqlMapDAO();
          // c.createService();
          // c.createFormBean();

	}
	public void a(){

	    
	}
	
}

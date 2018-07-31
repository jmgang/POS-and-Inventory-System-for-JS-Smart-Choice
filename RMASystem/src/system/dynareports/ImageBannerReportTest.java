/*
 * DynamicJasper: A library for creating reports dynamically by specifying
 * columns, groups, styles, etc. at runtime. It also saves a lot of development
 * time in many cases! (http://sourceforge.net/projects/dynamicjasper)
 *
 * Copyright (C) 2008  FDV Solutions (http://www.fdvsolutions.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 *
 * License as published by the Free Software Foundation; either
 *
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 *
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 *
 */

package system.dynareports;

import java.awt.Color;

import net.sf.jasperreports.view.JasperViewer;
import ar.com.fdvs.dj.domain.DJCalculation;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.ImageBanner;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.builders.GroupBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.GroupLayout;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.ImageScaleMode;
import ar.com.fdvs.dj.domain.constants.Page;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;
import ar.com.fdvs.dj.domain.entities.DJGroup;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;
import ar.com.fdvs.dj.domain.entities.columns.PropertyColumn;
import java.text.DateFormat;
import java.util.Date;

public class ImageBannerReportTest extends BaseDjReportTest {
    
    private boolean productId, productDesc, barcode, cat, quantity, cost, sales, profit, 
                    a4por, a4land, legpor, legland;
    private String title, subTitle;
    
    
    public ImageBannerReportTest(){}
        
        public ImageBannerReportTest(String title, String subTitle, boolean productId,  
                boolean barcode, boolean productDesc,
                boolean cat, boolean quantity, boolean cost, boolean sales, boolean profit,
                boolean a4por, boolean a4land, boolean legpor, boolean legland){
            this.productId = productId;
            this.productDesc = productDesc;
            this.barcode = barcode;
            this.cat = cat;
            this.quantity = quantity;
            this.cost = cost;
            this.sales = sales;
            this.profit = profit;
            this.a4por = a4por;
            this.a4land = a4land;
            this.legpor = legpor;
            this.legland = legland;
            this.title = title;
            this.subTitle = subTitle;
            
            if(title == null) this.title = "";
            if(subTitle == null) this.subTitle = "";
        }
	public DynamicReport buildReport() throws Exception {
                
                
		Style detailStyle = new Style();
		Style headerStyle = new Style();
		headerStyle.setFont(Font.VERDANA_MEDIUM_BOLD);
		headerStyle.setBorderBottom(Border.PEN_2_POINT());
		headerStyle.setHorizontalAlign(HorizontalAlign.CENTER);
		headerStyle.setVerticalAlign(VerticalAlign.MIDDLE);
		headerStyle.setBackgroundColor(Color.DARK_GRAY);
		headerStyle.setTextColor(Color.WHITE);
		headerStyle.setTransparency(Transparency.OPAQUE);

		Style titleStyle = new Style();
		titleStyle.setFont(new Font(18,Font._FONT_VERDANA,true));
		Style importeStyle = new Style();
		importeStyle.setHorizontalAlign(HorizontalAlign.RIGHT);
		Style oddRowStyle = new Style();
		oddRowStyle.setBorder(Border.NO_BORDER()); 
                oddRowStyle.setBackgroundColor(Color.LIGHT_GRAY);
                oddRowStyle.setTransparency(Transparency.OPAQUE);

		DynamicReportBuilder drb = new DynamicReportBuilder();
		Integer margin = new Integer(20);
			drb.setTitleStyle(titleStyle)
			.setTitle(title)		//defines the title of the report
			.setSubtitle(subTitle)
			.setDetailHeight(new Integer(15))
			.setLeftMargin(margin)
			.setRightMargin(margin)
			.setTopMargin(margin)
			.setBottomMargin(margin)
			.setPrintBackgroundOnOddRows(true)
			.setOddRowBackgroundStyle(oddRowStyle)
			.addFirstPageImageBanner(System.getProperty("user.dir") +
                       "/target/images/JS_Smart_logo.png", new Integer(197), new Integer(60), ImageBanner.ALIGN_LEFT)
			.addFirstPageImageBanner(System.getProperty("user.dir") +
                       "/target/images/buchanns.jpg", new Integer(300), new Integer(60), ImageBanner.ALIGN_RIGHT)
			.addImageBanner(System.getProperty("user.dir") +
                         "/target/images/JS_Smart_logo.png", new Integer(100), new Integer(25), ImageBanner.ALIGN_LEFT, ImageScaleMode.FILL)
			.addImageBanner(System.getProperty("user.dir") +
                        "/target/images/buchanns.jpg", new Integer(150), new Integer(25), ImageBanner.ALIGN_RIGHT, ImageScaleMode.FILL);

	/*	AbstractColumn columnState = ColumnBuilder.getNew().setColumnProperty("state", String.class.getName())
			.setTitle("State").setWidth(new Integer(85))
			.setStyle(titleStyle).setHeaderStyle(headerStyle).build(); */
                
                AbstractColumn columnProductId = ColumnBuilder.getNew()
                        .setColumnProperty("productId", Integer.class.getName())
			.setTitle("Product Id").setWidth(new Integer(60))
			.setStyle(detailStyle).setHeaderStyle(headerStyle).build();
		
                AbstractColumn columnBarcode = ColumnBuilder.getNew()
                        .setColumnProperty("barcode", String.class.getName())
			.setTitle("Barcode").setWidth(new Integer(90))
			.setStyle(detailStyle).setHeaderStyle(headerStyle).build();
                        
                AbstractColumn columnName = ColumnBuilder.getNew()
                        .setColumnProperty("productName", String.class.getName())
			.setTitle("Product Name").setWidth(new Integer(85))
			.setStyle(detailStyle).setHeaderStyle(headerStyle).build();
                
                AbstractColumn columnDesc = ColumnBuilder.getNew()
                        .setColumnProperty("productName", String.class.getName())
			.setTitle("Product Description").setWidth(new Integer(120))
			.setStyle(detailStyle).setHeaderStyle(headerStyle).build();
                
                AbstractColumn columnCat = ColumnBuilder.getNew().
                        setColumnProperty("cat", String.class.getName())
			.setTitle("Category").setWidth(new Integer(80))
			.setStyle(detailStyle).setHeaderStyle(headerStyle).build();

		AbstractColumn columnQuantity = ColumnBuilder.getNew()
                        .setColumnProperty("quantity", Integer.class.getName())
			.setTitle("Sold Quantity").setWidth(new Integer(40))
			.setStyle(importeStyle).setHeaderStyle(headerStyle).build();
                
                AbstractColumn columnCost = ColumnBuilder.getNew()
                        .setColumnProperty("costs", Float.class.getName())
			.setTitle("Cost of Goods Sold").setWidth(new Integer(40)).setPattern("₱ 0.00")
			.setStyle(importeStyle).setHeaderStyle(headerStyle).build();

		AbstractColumn columnSales = ColumnBuilder.getNew()
                        .setColumnProperty("sales", Float.class.getName())
			.setTitle("Sales").setWidth(new Integer(40)).setPattern("₱ 0.00")
			.setStyle(importeStyle).setHeaderStyle(headerStyle).build();

		AbstractColumn columnProfit = ColumnBuilder.getNew()
                        .setColumnProperty("profit", Float.class.getName())
			.setTitle("Profit").setWidth(new Integer(40)).setPattern("₱ 0.00")
			.setStyle(importeStyle).setHeaderStyle(headerStyle).build();

		

	/*	AbstractColumn columnAmount = ColumnBuilder.getNew().setColumnProperty("amount", Float.class.getName())
			.setTitle("Amount").setWidth(new Integer(90)).setPattern("$ 0.00")
			.setStyle(importeStyle).setHeaderStyle(headerStyle).build(); */


	/*	GroupBuilder gb1 = new GroupBuilder();
		DJGroup g1 = gb1.setCriteriaColumn((PropertyColumn) columnState)		//define the criteria column to group by (columnState)
			.addFooterVariable(columnAmount,DJCalculation.SUM)		//tell the group place a variable in the footer
																					//of the column "columnAmount" with the SUM of all
																					//values of the columnAmount in this group.

			.addFooterVariable(columnaQuantity,DJCalculation.SUM)	//idem for the columnaQuantity column
			.setGroupLayout(GroupLayout.VALUE_IN_HEADER)				//tells the group how to be shown, there are many
																					//posibilities, see the GroupLayout for more.
			.build();

		GroupBuilder gb2 = new GroupBuilder();										//Create another group (using another column as criteria)
		DJGroup g2 = gb2.setCriteriaColumn((PropertyColumn) columnBranch)		//and we add the same operations for the columnAmount and
			.addFooterVariable(columnAmount,DJCalculation.SUM)		//columnaQuantity columns
			.addFooterVariable(columnaQuantity,DJCalculation.SUM)
			.build(); */
                
               
                drb.addColumn(columnName); //Cannot be removed
                
                
                if(productId) drb.addColumn(columnProductId);
                if(productDesc) drb.addColumn(columnDesc);
                if(barcode) drb.addColumn(columnBarcode);
                if(cat) drb.addColumn(columnCat);
                if(quantity) {
                    drb.addColumn(columnQuantity)
                       .addGlobalFooterVariable(columnQuantity, DJCalculation.SUM);
                }
                if(cost){
                    drb.addColumn(columnCost) 
                       .addGlobalFooterVariable(columnCost, DJCalculation.SUM);
                }
                if(sales){
                    drb.addColumn(columnSales)
                     .addGlobalFooterVariable(columnSales, DJCalculation.SUM);
                }
                if(profit){
                    drb.addColumn(columnProfit)
                    .addGlobalFooterVariable(columnProfit, DJCalculation.SUM);
                }
		
                 drb.setGrandTotalLegend("Total");
		

		drb.setUseFullPageWidth(true);
                if(a4por) drb.setPageSizeAndOrientation(Page.Page_A4_Portrait());
                if(a4land) drb.setPageSizeAndOrientation(Page.Page_A4_Landscape());
                if(legpor)drb.setPageSizeAndOrientation(Page.Page_Legal_Portrait());
                if(legland) drb.setPageSizeAndOrientation(Page.Page_Legal_Landscape());
               
                  
		DynamicReport dr = drb.build();
		return dr;
	}

	public static void main(String[] args) throws Exception {
		ImageBannerReportTest test = new ImageBannerReportTest();
		test.testReport();
		JasperViewer.viewReport(test.jp);
	}

}

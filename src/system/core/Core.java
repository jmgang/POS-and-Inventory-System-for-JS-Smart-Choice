package system.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.sexydock.tabs.DefaultFloatingTabHandler;
import org.sexydock.tabs.DefaultTabDropFailureHandler;
import org.sexydock.tabs.DefaultWindowsClosedHandler;
import org.sexydock.tabs.ITabFactory;
import org.sexydock.tabs.ITabbedPaneDndPolicy;
import org.sexydock.tabs.ITabbedPaneWindow;
import org.sexydock.tabs.ITabbedPaneWindowFactory;
import org.sexydock.tabs.Tab;
import org.sexydock.tabs.demos.ISexyTabsDemo;
import org.sexydock.tabs.jhrome.JhromeTabbedPaneUI;
import static system.core.Login.db;
import system.helper.Helper;
import system.model.SalesByProductBean;
import system.model.SalesReportBean;
import system.model.SortingBean;
import system.utility.ConnectionUtil;
import system.utility.DateReturn;

/**
 * 
 * @author JANSEN ANG
 */
public class Core extends JFrame  implements ISexyTabsDemo , ITabbedPaneWindow , 
        ITabbedPaneWindowFactory , ITabFactory  {
    private Core core;
    private Dropdown dd;
    public JTabbedPane tabbedPane;
    private JLayeredPane layer;
    public static Connection con = ConnectionUtil.getDBConnection(db);
  
    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable( )
		{
			@Override
			public void run( )
			{        try {
                                    // Set System L&F
                                    UIManager.setLookAndFeel(
                                    UIManager.getSystemLookAndFeelClassName());
                                    Font f = new Font("sans-serif", Font.BOLD, 12);
                                   
                                    UIManager.put("Menu.font", f);
                                    UIManager.put("MenuItem.font", f);
                                    UIManager.put("Button.font", f);
                                    
                                    
                                    UIManager.put("", f);
                                } 
                                 catch (UnsupportedLookAndFeelException e) {
                                     e.printStackTrace();
                                }
                                catch (ClassNotFoundException e) {
                                 // handle exception
                                    e.printStackTrace();
                                }
                                 catch (InstantiationException e) {
                                // handle exception
                                     e.printStackTrace();
                                }
                                catch (IllegalAccessException e) {
                                // handle exception
                                    e.printStackTrace();
                                }
				new Core().start();
			}
                        
		} );
    }
    
    
    public Core(){
        initGui();
    }
    
    private void initGui()
	{
		setTitle( "JS Smart Choice Supermarket POS and Inventory System" );
		layer = new JLayeredPane();
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                layer.setPreferredSize(getContentPane().getSize());
                add(layer);
                layer.setVisible(true);
                dd = new Dropdown();
                dd.setBounds(10, 10, layer.getWidth(), layer.getHeight());
                
                
		tabbedPane = new JTabbedPane( );
                layer.add(tabbedPane);
		tabbedPane.setUI( new JhromeTabbedPaneUI( ) );
		tabbedPane.putClientProperty( JhromeTabbedPaneUI.NEW_TAB_BUTTON_VISIBLE , true );
		tabbedPane.putClientProperty( JhromeTabbedPaneUI.TAB_CLOSE_BUTTONS_VISIBLE , true );
		tabbedPane.putClientProperty( JhromeTabbedPaneUI.TAB_DROP_FAILURE_HANDLER , new DefaultTabDropFailureHandler( this ) );
		tabbedPane.putClientProperty( JhromeTabbedPaneUI.TAB_FACTORY , this );
		tabbedPane.putClientProperty( JhromeTabbedPaneUI.FLOATING_TAB_HANDLER , new DefaultFloatingTabHandler( ) );
		tabbedPane.putClientProperty( JhromeTabbedPaneUI.TAB_CLOSE_BUTTONS_VISIBLE , true );
		tabbedPane.putClientProperty( JhromeTabbedPaneUI.DND_POLICY , new ITabbedPaneDndPolicy( )
		{
			@Override
			public boolean isTearAwayAllowed( JTabbedPane tabbedPane , Tab tab )
			{
				return true;
			}
			
			@Override
			public boolean isSnapInAllowed( JTabbedPane tabbedPane , Tab tab )
			{
				return tab.getContent( ) instanceof HomePage;
			}
		});
		
		getContentPane().add( tabbedPane , BorderLayout.CENTER );
	
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		addWindowListener( new DefaultWindowsClosedHandler( ) );
		
                final JMenu menu = new JMenu("MASTER");
                final JMenu stocks = new JMenu("Stocks"); 
               
                
                //Report > Sales 
                final JMenu reports = new JMenu("Reports");
                final JMenu sales = new JMenu("Sales");
                final JMenu purchase = new JMenu("Purchases");
                
                final JMenu settings = new JMenu("Settings");
                final JMenu help = new JMenu("Help");
             
		JMenuBar menuBar = new JMenuBar();
                JMenuItem sell = new JMenuItem(new SellAreaAction());
                JMenuItem ware = new JMenuItem(new WareAction());
                JMenuItem supp = new JMenuItem(new SuppAction());
                JMenuItem purchaseOrder = new JMenuItem(new PurchaseOrderAction());
                JMenuItem stockOut = new JMenuItem(new StockOutAction());
                JMenuItem stockIn = new JMenuItem(new StockInAction());
                JMenuItem salesByProduct = new JMenuItem(new SalesByProductAction());
                JMenuItem salesByDate = new JMenuItem(new SalesByDateAction());
               
                menu.add(sell);
                menu.add(ware);
                menu.add(supp);
                menu.add(purchaseOrder);
                
                stocks.add(stockIn);
                stocks.add(stockOut);
                
                reports.add(sales); //
                sales.add(salesByProduct); 
                sales.add(salesByDate);
                
                reports.add(purchase);
                
		menuBar.add( menu );
                menuBar.add(stocks);
                menuBar.add(reports);
                menuBar.add(settings);
                menuBar.add(help);
                
		setJMenuBar( menuBar );              
		
		tabbedPane.addChangeListener( new ChangeListener( )
		{
			@Override
			 public void stateChanged( ChangeEvent e )
                            {
                                updateTitle( );
                                menu.setEnabled( tabbedPane.getSelectedComponent( ) instanceof 
                                HomePage || tabbedPane.getSelectedComponent( ) instanceof 
                                SellArea || tabbedPane.getSelectedComponent( ) instanceof 
                                Ware || tabbedPane.getSelectedComponent( ) instanceof
                                StockOut || tabbedPane.getSelectedComponent( ) instanceof 
                                Suppliers || tabbedPane.getSelectedComponent( ) instanceof 
                                Sales || tabbedPane.getSelectedComponent( ) instanceof
                                SalesByProduct || tabbedPane.getSelectedComponent() instanceof 
                                SalesByDate || tabbedPane.getSelectedComponent() instanceof 
                                PurchaseOrder  
                            );
                        }   
		} );
		
		
		tabbedPane.addPropertyChangeListener( new PropertyChangeListener( )
		{
			@Override
			public void propertyChange( PropertyChangeEvent evt )
			{
				if( "indexForTitle".equals( evt.getPropertyName( ) ) )
				{
					updateTitle( );
				}
			}
		} );
	}
    
	
	private void updateTitle( )
	{
		int index = tabbedPane.getSelectedIndex( );
		setTitle( index < 0 ? "JS Smart Choice Supermarket POS and Inventory" : ""
                        + "JS Smart Choice Supermarket POS and Inventory System - " + 
                        tabbedPane.getTitleAt( tabbedPane.getSelectedIndex( ) ) );
	}
        
       
        private class SellAreaAction extends AbstractAction
        {
           public SellAreaAction(){
               super("Selling Area");
           }
            @Override
            public void actionPerformed(ActionEvent e) {
                SellArea sa = new SellArea();
                Tab tab = new Tab( );
                tab.setTitle( "Selling Area" );
		tab.setContent( sa );
                getTabbedPane().addTab(tab.getTitle(), tab.getContent());
                tabbedPane.setSelectedComponent(sa);
                sa.revalidate();
                requestFocus();
            }
            
        }
        
         private class WareAction extends AbstractAction
        {
           public WareAction(){
               super("WareHouse");
           }
            @Override
            public void actionPerformed(ActionEvent e) {
                Waretable ware = new Waretable();
                ware.findUsers();
                Tab tab = new Tab( );
                tab.setTitle( "WareHouse" );
		tab.setContent( ware );
                getTabbedPane().addTab(tab.getTitle(), tab.getContent());
                tabbedPane.setSelectedComponent(ware);
                ware.revalidate();
                requestFocus();
                
            }
            
        }
         
          private class SuppAction extends AbstractAction
        {
           public SuppAction(){
               super("Suppliers");
           }
            @Override
            public void actionPerformed(ActionEvent e) {
                Suppliers supp = new Suppliers();
                Tab tab = new Tab( );
                tab.setTitle( "Suppliers" );
		tab.setContent( supp );
                getTabbedPane().addTab(tab.getTitle(), tab.getContent());
                tabbedPane.setSelectedComponent(supp);
                supp.revalidate();
                requestFocus();
            }
            
        }
          
           private class StockInAction extends AbstractAction
        {
           public StockInAction(){
               super("Stock In");
           }
            @Override
            public void actionPerformed(ActionEvent e) {
                StockIn si = new StockIn();
                Tab tab = new Tab( );
                tab.setTitle( "Stock In" );
		tab.setContent( si );
                getTabbedPane().addTab(tab.getTitle(), tab.getContent());
                tabbedPane.setSelectedComponent(si);
                si.revalidate();
                requestFocus();
            }
            
        }
          
         private class StockOutAction extends AbstractAction
        {
           public StockOutAction(){
               super("Stock Out");
           }
            @Override
            public void actionPerformed(ActionEvent e) {
                StockOut so = new StockOut();
                Tab tab = new Tab( );
                tab.setTitle( "Stock Out" );
		tab.setContent( so );
                getTabbedPane().addTab(tab.getTitle(), tab.getContent());
                tabbedPane.setSelectedComponent(so);
                so.revalidate();
                requestFocus();
            }
            
        }
         
        private class SalesReportAction extends AbstractAction
        {
           public SalesReportAction(){
               super("Sales Report");
           }
            @Override
            public void actionPerformed(ActionEvent e) {
                Sales sales = new Sales();
                Tab tab = new Tab( );
                tab.setTitle( "Sales Report" );
		tab.setContent( sales );
                getTabbedPane().addTab(tab.getTitle(), tab.getContent());
                tabbedPane.setSelectedComponent(sales);
                sales.revalidate();
                requestFocus();
            }
            
        }
        
         private class SalesByProductAction extends AbstractAction
        {
           public SalesByProductAction(){
               super("Sales By Product Report");
           }
            @Override
            public void actionPerformed(ActionEvent e) {
                SalesByProduct salesByProduct = new SalesByProduct();
                Tab tab = new Tab( );
                tab.setTitle( "Sales By Product Report" );
		tab.setContent( salesByProduct );
                getTabbedPane().addTab(tab.getTitle(), tab.getContent());
                tabbedPane.setSelectedComponent(salesByProduct);
                salesByProduct.revalidate();
                requestFocus();
            }
            
        }
         
         private class SalesByDateAction extends AbstractAction
        {
           public SalesByDateAction(){
               super("Sales By Date Report");
           }
            @Override
            public void actionPerformed(ActionEvent e) {
                SalesByDate salesByDate = new SalesByDate();
                Tab tab = new Tab( );
                tab.setTitle( "Sales By Date Report" );
		tab.setContent( salesByDate );
                getTabbedPane().addTab(tab.getTitle(), tab.getContent());
                tabbedPane.setSelectedComponent(salesByDate);
                salesByDate.revalidate();
                requestFocus();
            }
            
        }
         
        private class PurchaseOrderAction extends AbstractAction
        {
           public PurchaseOrderAction(){
               super("Purchase Order");
           }
            @Override
            public void actionPerformed(ActionEvent e) {
                PurchaseOrder pur = new PurchaseOrder();
                Tab tab = new Tab( );
                tab.setTitle( "Purchase Order" );
		tab.setContent( pur );
                getTabbedPane().addTab(tab.getTitle(), tab.getContent());
                tabbedPane.setSelectedComponent(pur);
                pur.revalidate();
                requestFocus();
            }
            
        }
         
      @Override
	public Tab createTab( )
	{
		return new Tab( );
	}
	
	@Override
	public Tab createTabWithContent( )
	{
		Tab tab = new Tab( );
		tab.setTitle( "HomePage" );
		tab.setContent( new HomePage() );
		return tab;
	}
	
	@Override
	public ITabbedPaneWindow createWindow( )
	{
		return new sample2( );
	}
	
	@Override
	public JTabbedPane getTabbedPane( )
	{
		return tabbedPane;
	}
	
	@Override
	public Window getWindow( )
	{
		return this;
	}
	
	@Override
	public void start()
	{
		Core core = new Core();
		Tab newTab = core.createTabWithContent( );
		core.getTabbedPane( ).addTab( newTab.getTitle( ) , newTab.getContent( ) );
		core.pack();
		core.setLocationRelativeTo( null );
		core.setVisible( true );
                HomePage home = (HomePage)newTab.getContent();
                home.requestFocus();		
	}
        
     /*    updateTitle();
        int index = tabbedPane.getSelectedIndex();
        tabbedPane.setTitleAt(index, ""); */
  
  class HomePage extends javax.swing.JPanel {
    SellArea sa;
    Ware wa;
    StockOut so;
  //  public static Connection con = ConnectionUtil.getDBConnection(db);
   final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   int datasetIndex = 0;
   private  XYPlot plot;
   public TitledBorder titledBorder;
    
    ArrayList<SalesReportBean> list = new ArrayList<>();
    ArrayList<SalesReportBean> list_High = new ArrayList<>();
   
    
    public HomePage() {
        initComponents();
        sa = new SellArea();
        wa = new Ware();
        so = new StockOut();
        
      
        populateDate();
        createLineChart();
        getHighest();
      //  returnHighest();
      
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        homelayer = new javax.swing.JLayeredPane();
        hometab = new javax.swing.JTabbedPane();
        home = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        dash = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        purchaseOrder = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        productsReorder = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        totalSellArea = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        productsReorder1 = new javax.swing.JLabel();
        highProduct = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        rating = new javax.swing.JComboBox();
        ranking = new javax.swing.JLabel();
        dateFrR = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dateToR = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        topBot = new javax.swing.JComboBox();
        limit = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateFr = new com.toedter.calendar.JDateChooser();
        dateTo = new com.toedter.calendar.JDateChooser();
        qtyc = new javax.swing.JCheckBox();
        costsc = new javax.swing.JCheckBox();
        profitsc = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();

        homelayer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        hometab.setBackground(new java.awt.Color(255, 255, 255));

        home.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Selling Area");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("WareHouse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("JS SMART CHOICE SUPERMARKET");

        jButton3.setText("Supplier");

        jButton4.setText("Stock In");

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(329, 329, 329))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(260, 260, 260))
        );

        hometab.addTab("HomePage", home);

        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("TIMELINE"));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("OUTSTANDING"));

        purchaseOrder.setBackground(new java.awt.Color(0, 153, 51));
        purchaseOrder.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        purchaseOrder.setForeground(new java.awt.Color(255, 255, 255));
        purchaseOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        purchaseOrder.setText("0");
        purchaseOrder.setBorder(new javax.swing.border.MatteBorder(null));
        purchaseOrder.setOpaque(true);

        jLabel3.setText("PURCHASE ORDERS");

        jLabel4.setText("PRODUCTS TO REORDER");

        productsReorder.setBackground(new java.awt.Color(0, 153, 255));
        productsReorder.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        productsReorder.setForeground(new java.awt.Color(255, 255, 255));
        productsReorder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productsReorder.setText("0");
        productsReorder.setBorder(new javax.swing.border.MatteBorder(null));
        productsReorder.setOpaque(true);

        jLabel5.setText("TOTAL SELLING AREA ITEMS");

        totalSellArea.setBackground(new java.awt.Color(255, 51, 0));
        totalSellArea.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        totalSellArea.setForeground(new java.awt.Color(255, 255, 255));
        totalSellArea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalSellArea.setText("0");
        totalSellArea.setBorder(new javax.swing.border.MatteBorder(null));
        totalSellArea.setOpaque(true);

        jLabel12.setText("TOTAL WAREHOUSE");

        productsReorder1.setBackground(new java.awt.Color(255, 255, 0));
        productsReorder1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        productsReorder1.setForeground(new java.awt.Color(255, 255, 255));
        productsReorder1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productsReorder1.setText("0");
        productsReorder1.setBorder(new javax.swing.border.MatteBorder(null));
        productsReorder1.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(totalSellArea, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(productsReorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(purchaseOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(productsReorder, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addGap(0, 114, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productsReorder, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(purchaseOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(totalSellArea, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(productsReorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addContainerGap())
        );

        titledBorder = javax.swing.BorderFactory.createTitledBorder("TOP 5 PRODUCTS");
        highProduct.setBorder(titledBorder);

        rating.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "by Qty Sold", "by Costs", "by Sales", "by Profit", " ", " ", " " }));
        rating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ratingActionPerformed(evt);
            }
        });

        ranking.setText("<html> 1. <br>  2. <br>  3. <br>  4. <br>  5. <br>  </html>");
        ranking.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ranking.setBorder(new javax.swing.border.MatteBorder(null));

        dateFrR.setDateFormatString("yyyy-MM-dd");

        jLabel10.setText("To");

        jLabel11.setText("Date");

        jLabel9.setText("From");

        dateToR.setDateFormatString("yyyy-MM-dd");

        jLabel2.setText("Show");

        topBot.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Top", "Bottom", " " }));
        topBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topBotActionPerformed(evt);
            }
        });

        limit.setText("5");

        javax.swing.GroupLayout highProductLayout = new javax.swing.GroupLayout(highProduct);
        highProduct.setLayout(highProductLayout);
        highProductLayout.setHorizontalGroup(
            highProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, highProductLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel11)
                .addGap(10, 10, 10)
                .addGroup(highProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(highProductLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(highProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateFrR, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateToR, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(highProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(highProductLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(topBot, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rating, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(ranking, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        highProductLayout.setVerticalGroup(
            highProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highProductLayout.createSequentialGroup()
                .addGroup(highProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(highProductLayout.createSequentialGroup()
                        .addGroup(highProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(highProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11))
                            .addComponent(dateFrR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(highProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(highProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(highProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(topBot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(limit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(dateToR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ranking))
        );

        dateFrR.getDateEditor().addPropertyChangeListener(
            new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    if ("date".equals(e.getPropertyName())) {
                        getHighest();
                    }
                }
            });
            this.add(dateFrR);
            dateToR.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent e) {
                        if ("date".equals(e.getPropertyName())) {
                            getHighest();
                        }
                    }
                });
                this.add(dateToR);

                jLabel6.setText("From");

                jLabel7.setText("To");

                dateFr.setDateFormatString("yyyy-MM-dd");

                dateTo.setDateFormatString("yyyy-MM-dd");

                qtyc.setText("Sold Quantity");
                qtyc.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        qtycActionPerformed(evt);
                    }
                });

                costsc.setText("Costs");
                costsc.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        costscActionPerformed(evt);
                    }
                });

                profitsc.setText("Profits");
                profitsc.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        profitscActionPerformed(evt);
                    }
                });

                jLabel8.setText("Date");

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                    jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(qtyc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(costsc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(profitsc)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateFr, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel4Layout.setVerticalGroup(
                    jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(dateFr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(qtyc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(costsc)
                                .addComponent(profitsc)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                dateFr.getDateEditor().addPropertyChangeListener(
                    new PropertyChangeListener() {
                        @Override
                        public void propertyChange(PropertyChangeEvent e) {
                            if ("date".equals(e.getPropertyName())) {
                                list.clear();
                                populateDate();
                                createLineChart();
                                qtyc.setSelected(false);
                                profitsc.setSelected(false);
                                costsc.setSelected(false);
                            }
                        }
                    });
                    this.add(dateFr);
                    dateTo.getDateEditor().addPropertyChangeListener(
                        new PropertyChangeListener() {
                            @Override
                            public void propertyChange(PropertyChangeEvent e) {
                                if ("date".equals(e.getPropertyName())) {
                                    list.clear();
                                    populateDate();
                                    createLineChart();
                                    qtyc.setSelected(false);
                                    profitsc.setSelected(false);
                                    costsc.setSelected(false);
                                }
                            }
                        });
                        this.add(dateTo);

                        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                        jPanel1.setLayout(jPanel1Layout);
                        jPanel1Layout.setHorizontalGroup(
                            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(highProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        jPanel1Layout.setVerticalGroup(
                            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(highProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, Short.MAX_VALUE)))
                        );

                        javax.swing.GroupLayout dashLayout = new javax.swing.GroupLayout(dash);
                        dash.setLayout(dashLayout);
                        dashLayout.setHorizontalGroup(
                            dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        dashLayout.setVerticalGroup(
                            dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );

                        hometab.addTab("DashBoard", dash);

                        javax.swing.GroupLayout homelayerLayout = new javax.swing.GroupLayout(homelayer);
                        homelayer.setLayout(homelayerLayout);
                        homelayerLayout.setHorizontalGroup(
                            homelayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hometab, javax.swing.GroupLayout.Alignment.TRAILING)
                        );
                        homelayerLayout.setVerticalGroup(
                            homelayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hometab)
                        );
                        homelayer.setLayer(hometab, javax.swing.JLayeredPane.DEFAULT_LAYER);

                        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                        this.setLayout(layout);
                        layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homelayer)
                        );
                        layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homelayer, javax.swing.GroupLayout.Alignment.TRAILING)
                        );
                    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        homelayer.remove(hometab);
        homelayer.setLayout(new BorderLayout());
        homelayer.add(sa);
        homelayer.repaint();
        homelayer.revalidate();
        repaint();
        revalidate();
        
        
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        homelayer.remove(hometab);
        homelayer.setLayout(new BorderLayout());
        homelayer.add(wa);
        homelayer.repaint();
        homelayer.revalidate();
        repaint();
        revalidate();
    }                                        

    private void qtycActionPerformed(java.awt.event.ActionEvent evt) {                                     
       if(qtyc.isSelected()){
            if (this.datasetIndex < 20) {
                this.datasetIndex++;
                plot.setDataset(
                    this.datasetIndex, createDatasetForDay_Qty("Quantity")
                );
                plot.setRenderer(this.datasetIndex, new StandardXYItemRenderer());
            }
        }else{
            if (this.datasetIndex >= 1) {
                this.plot.setDataset(this.datasetIndex, null);
                this.plot.setRenderer(this.datasetIndex, null);
                this.datasetIndex--;
            }
        }
    }                                    

    private void costscActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if(costsc.isSelected()){
            if (this.datasetIndex < 20) {
                this.datasetIndex++;
                plot.setDataset(
                    this.datasetIndex, createDatasetForDay_Costs("Costs")
                );
                plot.setRenderer(this.datasetIndex, new StandardXYItemRenderer());
            }
        }else{
            if (this.datasetIndex >= 1) {
                this.plot.setDataset(this.datasetIndex, null);
                this.plot.setRenderer(this.datasetIndex, null);
                this.datasetIndex--;
            }
        }
    }                                      

    private void profitscActionPerformed(java.awt.event.ActionEvent evt) {                                         
    if(profitsc.isSelected()){
           if (this.datasetIndex < 20) {
                this.datasetIndex++;
                plot.setDataset(
                    this.datasetIndex, createDatasetForDay_Profits("Profits")
                );
                plot.setRenderer(this.datasetIndex, new StandardXYItemRenderer());
            }
        }else{
            if (this.datasetIndex >= 1) {
                this.plot.setDataset(this.datasetIndex, null);
                this.plot.setRenderer(this.datasetIndex, null);
                this.datasetIndex--;
            }
        }
    }                                        

    private void ratingActionPerformed(java.awt.event.ActionEvent evt) {                                       
        getHighest();
        
    }                                      

    private void topBotActionPerformed(java.awt.event.ActionEvent evt) {                                       
        getHighest();
    }                                      
    
    public void refresh(){
        list.clear();
        populateDate();
    }
    public void populateDate(){
        String outerSQL = "";
        String innerSQL = "";
       
            outerSQL = "Select distinct(DATEADD(dd, DATEDIFF(dd, 0, date), 0)) as date from StockOut";
            
            if(dateFr.getDate() != null && dateTo.getDate() != null){
                 Date fdate = dateFr.getDate();
                 Date tdate = dateTo.getDate();
                 String[] fromSplit;
                 String[] toSplit;
                 fromSplit =  DateFormat.getInstance()
                                               .format(fdate).split("\\s+");
                 toSplit =  DateFormat.getInstance()
                                               .format(tdate).split("\\s+");
                 System.out.println(fromSplit[0] + " " + toSplit[0]);
                innerSQL = "Select Warehouse.ProductName, StockOut.Quantity, WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId "
                        +"where CAST(StockOut.date as DATE) between '"+fromSplit[0]+"' and '"+toSplit[0]+"' ";
            }else{
                 innerSQL = "Select Warehouse.ProductName, StockOut.Quantity, WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId";
            }
            
            populateDay(outerSQL, innerSQL);
    }
    
    public void populateDay(String outerSQL, String innerSQL){
        ResultSet rs = Helper.getData(con, outerSQL);
        String outer[];
        String inner[];
        int qty = 0; //Pertains to Total Items Sold
        float costs = 0, sales = 0, profits = 0; 
        try {
             while(rs.next()){
                 outer = rs.getTimestamp("date").toString().split("\\s+");
                 ResultSet rs2 = Helper.getData(con, innerSQL);
                 while(rs2.next()){
                     inner = rs2.getTimestamp("Date").toString().split("\\s+");
                     if(outer[0].equals(inner[0])){ //check whether the date in outer sql is equal to date in inner sql
                         qty += rs2.getInt("Quantity");
                         costs += rs2.getInt("Quantity") * rs2.getFloat("Cost");
                         sales += rs2.getInt("Quantity") * rs2.getFloat("SellPrice");
                         profits += rs2.getInt("Quantity") * ( rs2.getFloat("SellPrice") - rs2.getFloat("Cost") );                         
                     }
                 }
                //  row[1] = qty; // sets the quantity in row 2 of jtable
                 // row[2] = "₱ " + sales; //sales 
                //  row[3] = "₱ " + costs; //costs
               //   row[4] = "₱ " +profits; //profits
                  SalesReportBean spb = new SalesReportBean(outer[0], qty, sales, costs, profits);
                  list.add(spb);
                  
                  qty = 0; costs = 0; sales = 0; profits = 0; //resets the values
                 
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(SalesReport.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    public void getHighest(){
      //  highProduct.removeAll();
      //  highProduct.repaint();
      //  highProduct.revalidate();
        List list = new ArrayList();
        try{
            
        String outer = "";
        String inner =  "";
        
        if(dateFr.getDate() != null && dateTo.getDate() != null){
                 Date fdate = dateFrR.getDate();
                 Date tdate = dateToR.getDate();
                 String[] fromSplit;
                 String[] toSplit;
                 fromSplit =  DateFormat.getInstance()
                                               .format(fdate).split("\\s+");
                 toSplit =  DateFormat.getInstance()
                                               .format(tdate).split("\\s+");
                 System.out.println(fromSplit[0] + " " + toSplit[0]);
                inner = "Select Warehouse.ProductName, Warehouse.Barcode, StockOut.Quantity,"
                        + " WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId "
                        +"where CAST(StockOut.date as DATE) between '"+fromSplit[0]+"' and '"+toSplit[0]+"' ";
            }else{
                 inner = "Select Warehouse.ProductName, Warehouse.Barcode, StockOut.Quantity,"
                         + " WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId";
            }
           outer = "Select * from Warehouse";
            
            
            int qty = 0;
            float costs = 0, sales = 0, profits = 0;
            ResultSet out = Helper.getData(con, outer);
            
            while(out.next()){
                ResultSet inn = Helper.getData(con, inner);
                while(inn.next()){
                    if(out.getString("Barcode").equals(inn.getString("Barcode"))){
                        qty += inn.getInt("Quantity");
                        costs += inn.getInt("Quantity") * inn.getFloat("Cost");
                        sales += inn.getInt("Quantity") * inn.getFloat("SellPrice");
                        profits += inn.getInt("Quantity") * ( inn.getFloat("SellPrice") - inn.getFloat("Cost") );       
                    }
                }
                
             SalesByProductBean sbpb = new SalesByProductBean(out.getInt("ProductId"), out.getString("Barcode"),
                 out.getString("ProductName"), out.getString("ProductDesc"), out.getString("Category"),
                 qty, costs, sales, profits);
             
             if(Helper.insertToHighestProducts(con, sbpb)){
                 showHighest();
                 highProduct.repaint();
                 highProduct.revalidate();
                // if(Helper.delete(con, "Delete from HighestProducts"));
             }
                qty = 0; costs = 0; sales = 0; profits = 0;   
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void showHighest(){
        ResultSet rs;
        String addendum = "Quantity";
        String orientation = "desc";
        int defaultLim = 5;
        int lim = defaultLim;
      //  String title = "TOP 5 PRODUCTS";
        String ori = "TOP";
        
        if(topBot.getSelectedIndex() == 0){
            orientation = " desc";
            ori = "TOP ";
        }
            
        else if(topBot.getSelectedIndex() == 1){
             orientation = " asc";
             ori = "BOTTOM ";
        }
           
        
        try{
            if(limit.getText() != null){
                lim = Integer.parseInt(limit.getText());
                titledBorder.setTitle(ori + lim + " PRODUCTS");
            } 
            else{
                lim = defaultLim;
                limit.setText(lim+"");
                 titledBorder.setTitle(ori + lim + " PRODUCTS");
            }
                
        }catch(Exception ex){
            lim = defaultLim;
            limit.setText(lim+"");
             titledBorder.setTitle(ori + lim + " PRODUCTS");
        }
        
        if(rating.getSelectedIndex() == 0)
            addendum = "Quantity";
        else if(rating.getSelectedIndex() == 1)
             addendum = "Costs";
        else if(rating.getSelectedIndex() == 2)
             addendum = "Sales";
        else if(rating.getSelectedIndex() == 3)
             addendum = "Profit";
        
        
         String sql = "Select distinct * from HighestProducts order by "+addendum+" "+orientation+" ";
         System.out.println(sql);
         rs = Helper.getData(con, sql);
        String mes = "<html>";
         
        try {
            int i = 1;
            while(rs.next() && i <= lim){
               mes += i + ". " + rs.getString("ProductName") + "<br>";
               i++;
               System.out.println(mes);
            }
            mes += " </html>";
            ranking.setText(mes);
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   /* public void returnHighest(){
        Map<String, SortingBean> qty = new HashMap<String, SortingBean>();
        List list = getHighest();
        Iterator iter = list.iterator();
        
        while(iter.hasNext()){
            SalesByProductBean sbpb = (SalesByProductBean)iter.next();
            SortingBean sb = new SortingBean(sbpb.getProductName(), sbpb.getQuantity());
            qty.put(sb.getName(), sb);
        }
        
        List<SortingBean> productByQty = new ArrayList<SortingBean>(qty.values());
        
        Collections.sort(productByQty, new Comparator<SortingBean>(){
            public int compare(SortingBean sb1, SortingBean sb2){
                return sb2.getQty() - sb1.getQty();
            }
        });
      
        for(SortingBean s : productByQty){
            System.out.println(s.getName() + "\t" + s.getQty());
        }
    } */
    
    public void createLineChart(){
        plot = null;
        panel2.removeAll();
        panel2.repaint();
        panel2.revalidate();
          
          TimeSeriesCollection dataset = null;
       
            dataset = createDatasetForDay_Sales("Sales");
         
       JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Sales Report Chart", "Date", "Value", dataset, true, true, false
        );
          
        plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
//        this.plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 4, 4, 4, 4));
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);

        NumberAxis rangeAxis2 = new NumberAxis("Range Axis 2");
        rangeAxis2.setAutoRangeIncludesZero(false);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        panel2.setSize(500, 400);
        chartPanel.setPreferredSize(panel2.getSize());
        chartPanel.setVisible(true);
        panel2.setLayout(new java.awt.BorderLayout());
        panel2.add(chartPanel, BorderLayout.CENTER);
        panel2.setVisible(true);
        
        panel2.repaint();
        panel2.revalidate();
        //   ChartFrame frame = new ChartFrame("Bar chart for melrose", chart);
        //    frame.setVisible(true);
        //     frame.setSize(450, 350);
    }  
    
    private TimeSeriesCollection createDatasetForDay_Qty(final String name) {
        final TimeSeries series = new TimeSeries(name);
          
            Iterator iter = list.iterator();
            RegularTimePeriod t; // dd, MM, YYYY
            
            while (iter.hasNext()) {
                SalesReportBean sp = (SalesReportBean)iter.next(); //yyyy-mm-dd
                String date[] = sp.getDate().split("-");
                
                t = new Day( Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]) );
                    series.add(t, sp.getQuantity());
            }
            
            return new TimeSeriesCollection(series);
    }
    
    private TimeSeriesCollection createDatasetForDay_Sales(final String name) {
        final TimeSeries series = new TimeSeries(name);
          
            Iterator iter = list.iterator();
            RegularTimePeriod t; // dd, MM, YYYY
            
            while (iter.hasNext()) {
                SalesReportBean sp = (SalesReportBean)iter.next(); //yyyy-mm-dd
                String date[] = sp.getDate().split("-");
                
                t = new Day( Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]) );
                    series.add(t, sp.getSales());
            }
           
            return new TimeSeriesCollection(series);
    }
    
     private TimeSeriesCollection createDatasetForDay_Costs(final String name) {
        final TimeSeries series = new TimeSeries(name);
          
            Iterator iter = list.iterator();
            RegularTimePeriod t; // dd, MM, YYYY
            
            while (iter.hasNext()) {
                SalesReportBean sp = (SalesReportBean)iter.next(); //yyyy-mm-dd
                String date[] = sp.getDate().split("-");
                
                t = new Day( Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]) );
                    series.add(t, sp.getCosts());
            }
            
            return new TimeSeriesCollection(series);
    }
     
     private TimeSeriesCollection createDatasetForDay_Profits(final String name) {
        final TimeSeries series = new TimeSeries(name);
          
            Iterator iter = list.iterator();
            RegularTimePeriod t; // dd, MM, YYYY
            
            while (iter.hasNext()) {
                SalesReportBean sp = (SalesReportBean)iter.next(); //yyyy-mm-dd
                String date[] = sp.getDate().split("-");
                
                t = new Day( Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]) );
                    series.add(t, sp.getProfits());
            }
           
            return new TimeSeriesCollection(series);
    }
    
   

    // Variables declaration - do not modify                     
    private javax.swing.JCheckBox costsc;
    private javax.swing.JPanel dash;
    private com.toedter.calendar.JDateChooser dateFr;
    private com.toedter.calendar.JDateChooser dateFrR;
    private com.toedter.calendar.JDateChooser dateTo;
    private com.toedter.calendar.JDateChooser dateToR;
    private javax.swing.JPanel highProduct;
    private javax.swing.JPanel home;
    private javax.swing.JLayeredPane homelayer;
    private javax.swing.JTabbedPane hometab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField limit;
    private javax.swing.JPanel panel2;
    private javax.swing.JLabel productsReorder;
    private javax.swing.JLabel productsReorder1;
    private javax.swing.JCheckBox profitsc;
    private javax.swing.JLabel purchaseOrder;
    private javax.swing.JCheckBox qtyc;
    private javax.swing.JLabel ranking;
    private javax.swing.JComboBox rating;
    private javax.swing.JComboBox topBot;
    private javax.swing.JLabel totalSellArea;
    // End of variables declaration                   
}
}








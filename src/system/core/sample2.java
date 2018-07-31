
package system.core;

import java.awt.BorderLayout;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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


public class sample2 extends JFrame implements ISexyTabsDemo , ITabbedPaneWindow , 
        ITabbedPaneWindowFactory , ITabFactory {
    
    public static void main( String[ ] args )
	{
		SwingUtilities.invokeLater( new Runnable( )
		{
			@Override
			public void run( )
			{
				new sample2( ).start( );
			}
                        
		} );
	}
    
    public sample2(){
        initGui();
    }
    
     private void initGui( )
	{
		setTitle( "Testing" );
		
		tabbedPane = new JTabbedPane( );
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
				return tab.getContent( ) instanceof SellArea;
			}
		});
		
		getContentPane().add( tabbedPane , BorderLayout.CENTER );
	
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		addWindowListener( new DefaultWindowsClosedHandler( ) );
		
		
		final JMenu fileMenu = new JMenu( "File" );
		
		JMenuBar menuBar = new JMenuBar( );
		menuBar.add( fileMenu );
		setJMenuBar( menuBar );
		
		tabbedPane.addChangeListener( new ChangeListener( )
		{
			@Override
			public void stateChanged( ChangeEvent e )
			{
				updateTitle( );
				fileMenu.setEnabled( tabbedPane.getSelectedComponent( ) instanceof 
                                       SellArea );
			}
		} );
		
	/*	tabbedPane.addContainerListener( new ContainerAdapter( )
		{
			@Override
			public void componentRemoved( ContainerEvent e )
			{
				if( tabbedPane.getTabCount( ) == 0 )
				{
					dispose( );
				}
			}
		} ); */
		
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
		setTitle( index < 0 ? "Testing" : "Testing - " + tabbedPane.getTitleAt( tabbedPane.getSelectedIndex( ) ) );
	}
	
	private JTabbedPane	tabbedPane;

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
		tab.setContent( new SellArea() );
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
	public void start( )
	{
		sample2 sam = new sample2();
		Tab newTab = sam.createTabWithContent( );
		sam.getTabbedPane( ).addTab( newTab.getTitle( ) , newTab.getContent( ) );
		sam.pack();
		sam.setLocationRelativeTo( null );
		sam.setVisible( true );
                SellArea sa = (SellArea)newTab.getContent();
                sa.requestFocus();
		
	}
    
}

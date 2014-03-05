package plugin.ui.window.configuration;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import plugin.ui.window.configuration.configtree.ConfigTreeBase;
import plugin.ui.window.configuration.entity.ConfigEntity;
import plugin.util.LayoutFactory;

public class ConfigurationWindow implements Observer {

	protected Shell shell;

	public Composite titleWindowComposite;
	public Composite bottomComposite;
	private SashForm centerSashFormComposite;
		public ConfigSelectWindow configListTreeComposite;
		public ConfigDetailWindow detailConfigComposite;
	private int[] compositePortion = new int[] { 3, 7 };

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int tempValue = ConstantcLayoutData.botton_margin;
		try {
			ConfigurationWindow window = new ConfigurationWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("Jtester Configurations");
		FormLayout nomalCompositeLayout = LayoutFactory.getFormLayout();
		shell.setLayout(nomalCompositeLayout);
		// add top comosite
		titleWindowComposite = new TitleConfigWindow(shell, SWT.None).getComposite();
		// add bottom composite
		bottomComposite = new BottomConfigWindow(shell, SWT.None).getComposite();
		// set sash form for center composite
		centerSashFormComposite = new SashForm(shell, SWT.HORIZONTAL | SWT.SMOOTH);
		FormData fd_centerSashForm = new FormData();
		fd_centerSashForm.bottom = new FormAttachment(bottomComposite);
		fd_centerSashForm.left = new FormAttachment(0);
		fd_centerSashForm.top = new FormAttachment(titleWindowComposite);
		fd_centerSashForm.right = new FormAttachment(100);
		centerSashFormComposite.setLayoutData(fd_centerSashForm);
		configListTreeComposite = new ConfigSelectWindow(centerSashFormComposite, SWT.None);
		
		detailConfigComposite = new ConfigDetailWindow(centerSashFormComposite, SWT.None, null,null);
		configListTreeComposite.configTree.addObserver(this);
		centerSashFormComposite.setWeights(compositePortion);
		
	}
private ConfigEntity entity;
	@Override
	public void update(Observable configTree, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println(arg1);
		if(arg1.equals("no-config")){
			if(entity==null){
				return;
			}
			entity=null;
			detailConfigComposite.showedComposite.dispose();
			detailConfigComposite=null;
			detailConfigComposite = new ConfigDetailWindow(centerSashFormComposite, SWT.None, null,null);
		}else{
			
			ConfigTreeBase tree = (ConfigTreeBase)configTree;
			ConfigEntity entity1=tree.getSelectedConfigEntity();
			
			if(entity!=null&&entity.id.equals(entity1.id)){
				System.out.println("no-change");
				return;
			}
			entity=entity1;
			detailConfigComposite.showedComposite.dispose();
			detailConfigComposite=null;
			detailConfigComposite = new ConfigDetailWindow(centerSashFormComposite, SWT.None,tree, entity1);
		}
		///this.shell.layout();
		Display.getDefault().getActiveShell().pack(true);
		Display.getDefault().getActiveShell().setSize(800, 600);
	}
}

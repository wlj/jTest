package plugin.ui.window.configuration.detailtabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class AuthorsTab {
	
	TabItem tabItem;
	private Table table;
	
	public AuthorsTab(TabFolder tabFolder,CodeReviewTab codeReviewTab) {
		// TODO Auto-generated constructor stub
		tabItem = new TabItem(tabFolder, SWT.None);
		tabItem.setText("Authors");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tabItem.setControl(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite compositeAuthors = new Composite(scrolledComposite, SWT.NONE);
		compositeAuthors.setLayout(new FormLayout());
		
		Composite actionsCompositeAuthors = new Composite(compositeAuthors, SWT.NONE);
		actionsCompositeAuthors.setLayout(new FillLayout(SWT.VERTICAL));
		FormData fd_actionsCompositeAuthors = new FormData();
		fd_actionsCompositeAuthors.right = new FormAttachment(100, -5);
		fd_actionsCompositeAuthors.top = new FormAttachment(0, 5);
		fd_actionsCompositeAuthors.width = 60;
		actionsCompositeAuthors.setLayoutData(fd_actionsCompositeAuthors);
		
		Button btnEdit_1 = new Button(actionsCompositeAuthors, SWT.NONE);
		btnEdit_1.setText("Edit");
		
		Button btnNewAuthor = new Button(actionsCompositeAuthors, SWT.NONE);
		btnNewAuthor.setText("New");
		btnNewAuthor.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {
				// TODO Auto-generated method stub
				TableItem item=new TableItem(table, SWT.NONE);
				editorTableItem(item,0);
				editorTableItem(item,1);
				editorTableItem(item,2);
				editorTableItem(item,3);
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		Button btnRemove = new Button(actionsCompositeAuthors, SWT.NONE);
		btnRemove.setText("Remove");
		
		Composite tableCompositeAuthors = new Composite(compositeAuthors, SWT.NONE);
		tableCompositeAuthors.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_tableCompositeAuthors = new FormData();
		fd_tableCompositeAuthors.bottom = new FormAttachment(100, -5);
		fd_tableCompositeAuthors.top = new FormAttachment(0, 5);
		fd_tableCompositeAuthors.right = new FormAttachment(actionsCompositeAuthors,-3,SWT.LEFT);
		fd_tableCompositeAuthors.left = new FormAttachment(0, 5);
		tableCompositeAuthors.setLayoutData(fd_tableCompositeAuthors);
		
		table = new Table(tableCompositeAuthors, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnName = new TableColumn(table, SWT.NONE);
		tblclmnName.setWidth(100);
		tblclmnName.setText("Name");
		
		TableColumn tblclmnReviewers = new TableColumn(table, SWT.NONE);
		tblclmnReviewers.setWidth(100);
		tblclmnReviewers.setText("Reviewers");
		
		TableColumn tblclmnMonitors = new TableColumn(table, SWT.NONE);
		tblclmnMonitors.setWidth(100);
		tblclmnMonitors.setText("Monitors");
		
		TableColumn tblclmnLogins = new TableColumn(table, SWT.NONE);
		tblclmnLogins.setWidth(100);
		tblclmnLogins.setText("Logins");
		scrolledComposite.setContent(compositeAuthors);
		scrolledComposite.setMinSize(compositeAuthors.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
	
	private void editorReviewsItem(TableItem item){
		
	}
	
	/**
	 * 编辑单元格
	 * @param item 单元格
	 */
	private void editorTableItem(TableItem item,int index){
		final TableEditor tEditor=new TableEditor(table);
		final Text nameText = new Text(table, SWT.SINGLE | SWT.BORDER);
		tEditor.grabHorizontal = true; // 宽度
		tEditor.grabVertical = false; // 高度不占满
		tEditor.minimumHeight = 25;
		tEditor.minimumWidth = 100;
		tEditor.horizontalAlignment = SWT.CENTER;
		
		nameText.setText(item.getText());
		tEditor.setEditor(nameText, item, index);
		nameText.setFocus();
		nameText.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
//				tEditor.getItem().setText(nameText.getText());
//				tEditor.getEditor().dispose();
//				tEditor.dispose();
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}

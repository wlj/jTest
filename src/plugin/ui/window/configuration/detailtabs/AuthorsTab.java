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
	
	public AuthorsTab(TabFolder tabFolder,final CodeReviewTab codeReviewTab) {
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
				editorTableItem(item);
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		Button btnRemove = new Button(actionsCompositeAuthors, SWT.NONE);
		btnRemove.setText("Remove");
		btnRemove.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int index=table.getSelectionIndex();
				if(index>=0){
					table.remove(index);
				}
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(tEditorForName==null){
					return;
				}
				TableItem item = tEditorForName.getItem();
				Text text=(Text) tEditorForName.getEditor();
				if(text==null){
					return;
				}
				String name=text.getText();
				item.setText(0,name);
				text.dispose();
				tEditorForName.dispose();
				
				text=(Text) tEditorForReviewers.getEditor();
				String[] reviewers =text.getText().split(",");
				item.setText(1,text.getText());
				text.dispose();
				tEditorForReviewers.dispose();
				for(String reviewer:reviewers){
					codeReviewTab.reviewersTab.addReviewItem(reviewer, name, "");
				}
				
				text=(Text) tEditorForMonitors.getEditor();
				String[] monitors =text.getText().split(",");
				item.setText(2,text.getText());
				text.dispose();
				tEditorForMonitors.dispose();
				for(String monitor:monitors){
					codeReviewTab.monitorsTab.addMonitorItem(monitor, name, "");
				}
				
				
				text=(Text) tEditorForLogins.getEditor();
				item.setText(3,text.getText());
				text.dispose();
				tEditorForLogins.dispose();
				
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
	
	 TableEditor tEditorForName;
	 TableEditor tEditorForReviewers;
	 TableEditor tEditorForMonitors;
	 TableEditor tEditorForLogins;
	/**
	 * 编辑单元格
	 * @param item 单元格
	 */
	private void editorTableItem(TableItem item){
		tEditorForName=new TableEditor(table);
		final Text nameText = new Text(table, SWT.SINGLE | SWT.BORDER);
		tEditorForName.grabHorizontal = true; // 宽度
		tEditorForName.grabVertical = false; // 高度不占满
		tEditorForName.minimumHeight = 25;
		tEditorForName.minimumWidth = 100;
		tEditorForName.horizontalAlignment = SWT.CENTER;
		
		nameText.setText(item.getText(0));
		tEditorForName.setEditor(nameText, item, 0);
		
		tEditorForReviewers=new TableEditor(table);
		final Text reviewersText = new Text(table, SWT.SINGLE | SWT.BORDER);
		tEditorForReviewers.grabHorizontal = true; // 宽度
		tEditorForReviewers.grabVertical = false; // 高度不占满
		tEditorForReviewers.minimumHeight = 25;
		tEditorForReviewers.minimumWidth = 100;
		tEditorForReviewers.horizontalAlignment = SWT.CENTER;
		
		reviewersText.setText(item.getText(1));
		tEditorForReviewers.setEditor(reviewersText, item, 1);
		
		tEditorForMonitors=new TableEditor(table);
		final Text monitorsText = new Text(table, SWT.SINGLE | SWT.BORDER);
		tEditorForMonitors.grabHorizontal = true; // 宽度
		tEditorForMonitors.grabVertical = false; // 高度不占满
		tEditorForMonitors.minimumHeight = 25;
		tEditorForMonitors.minimumWidth = 100;
		tEditorForMonitors.horizontalAlignment = SWT.CENTER;
		
		monitorsText.setText(item.getText(2));
		tEditorForMonitors.setEditor(monitorsText, item, 2);
		
		tEditorForLogins=new TableEditor(table);
		final Text loginsText = new Text(table, SWT.SINGLE | SWT.BORDER);
		tEditorForLogins.grabHorizontal = true; // 宽度
		tEditorForLogins.grabVertical = false; // 高度不占满
		tEditorForLogins.minimumHeight = 25;
		tEditorForLogins.minimumWidth = 100;
		tEditorForLogins.horizontalAlignment = SWT.CENTER;
		
		loginsText.setText(item.getText(3));
		tEditorForLogins.setEditor(loginsText, item, 3);
	}
}

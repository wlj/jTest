package plugin.ui.window.configuration.detailtabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import plugin.ui.window.configuration.entity.Filter4GenerationEntity;
import plugin.ui.window.configuration.entity.TestCase4GenerationEntity;

public class GenerationTestClassTab {
	
	TabItem testClassTabItem;
	private Text textOutputClass;
	private Text text;
	private Text javadocText;
	public Button btnDoNotGenerate;
	public Button btnAddGeneratedmodifiedFiles;
	public Button btnUseAnExternal;
	public Button btnAddGeneratedTest;
	public Button btnReplaceTheExisting;
	public Button btnAddThisText;
	
	public GenerationTestClassTab(TabFolder tabFolderInGeneration) {
		// TODO Auto-generated constructor stub
		testClassTabItem = new TabItem(tabFolderInGeneration, SWT.None);
		
		Composite testClassComposite = new Composite(tabFolderInGeneration, SWT.NONE);
		testClassTabItem.setControl(testClassComposite);
		testClassTabItem.setText("Test Class");
		testClassComposite.setLayout(new FormLayout());
		
		btnDoNotGenerate = new Button(testClassComposite, SWT.CHECK);
		FormData fd_btnDoNotGenerate = new FormData();
		fd_btnDoNotGenerate.top = new FormAttachment(0, 10);
		fd_btnDoNotGenerate.left = new FormAttachment(0, 10);
		btnDoNotGenerate.setLayoutData(fd_btnDoNotGenerate);
		btnDoNotGenerate.setText("Do not generate additional test classes after elapsed time (minutes): ");
		
		text = new Text(testClassComposite, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.top = new FormAttachment(btnDoNotGenerate, -3, SWT.TOP);
		fd_text.left = new FormAttachment(btnDoNotGenerate, 6);
		text.setLayoutData(fd_text);
		
		btnAddGeneratedmodifiedFiles = new Button(testClassComposite, SWT.CHECK);
		FormData fd_btnAddGeneratedmodifiedFiles = new FormData();
		fd_btnAddGeneratedmodifiedFiles.top = new FormAttachment(btnDoNotGenerate, 6);
		fd_btnAddGeneratedmodifiedFiles.left = new FormAttachment(0, 10);
		btnAddGeneratedmodifiedFiles.setLayoutData(fd_btnAddGeneratedmodifiedFiles);
		btnAddGeneratedmodifiedFiles.setText("Add generated/modified files to source control");
		
		btnUseAnExternal = new Button(testClassComposite, SWT.CHECK);
		FormData fd_btnUseAnExternal = new FormData();
		fd_btnUseAnExternal.top = new FormAttachment(btnAddGeneratedmodifiedFiles, 6);
		fd_btnUseAnExternal.left = new FormAttachment(btnDoNotGenerate, 0, SWT.LEFT);
		btnUseAnExternal.setLayoutData(fd_btnUseAnExternal);
		btnUseAnExternal.setText("Use an external linked location (relative to linked tested projects) for new test projects");
		
		Group grpWhenGeneratingTests = new Group(testClassComposite, SWT.NONE);
		grpWhenGeneratingTests.setText("When generating tests for a class with an existing test class");
		grpWhenGeneratingTests.setLayout(new FormLayout());
		FormData fd_grpWhenGeneratingTests = new FormData();
		fd_grpWhenGeneratingTests.bottom = new FormAttachment(btnUseAnExternal, 74, SWT.BOTTOM);
		fd_grpWhenGeneratingTests.top = new FormAttachment(btnUseAnExternal, 6);
		fd_grpWhenGeneratingTests.left = new FormAttachment(0, 10);
		fd_grpWhenGeneratingTests.right = new FormAttachment(100, -10);
		grpWhenGeneratingTests.setLayoutData(fd_grpWhenGeneratingTests);
		
		btnAddGeneratedTest = new Button(grpWhenGeneratingTests, SWT.RADIO);
		FormData fd_btnAddGeneratedTest = new FormData();
		fd_btnAddGeneratedTest.top = new FormAttachment(0, 3);
		fd_btnAddGeneratedTest.left = new FormAttachment(0, 3);
		btnAddGeneratedTest.setLayoutData(fd_btnAddGeneratedTest);
		btnAddGeneratedTest.setText("Add generated test cases to the existing test class");
		
		btnReplaceTheExisting = new Button(grpWhenGeneratingTests, SWT.RADIO);
		FormData fd_btnReplaceTheExisting = new FormData();
		fd_btnReplaceTheExisting.top = new FormAttachment(btnAddGeneratedTest, 6);
		fd_btnReplaceTheExisting.left = new FormAttachment(btnAddGeneratedTest, 0, SWT.LEFT);
		btnReplaceTheExisting.setLayoutData(fd_btnReplaceTheExisting);
		btnReplaceTheExisting.setText("Replace the existing test class");
		
		Label lblOutputClass = new Label(testClassComposite, SWT.NONE);
		FormData fd_lblOutputClass = new FormData();
		fd_lblOutputClass.top = new FormAttachment(grpWhenGeneratingTests, 9);
		fd_lblOutputClass.left = new FormAttachment(btnDoNotGenerate, 0, SWT.LEFT);
		lblOutputClass.setLayoutData(fd_lblOutputClass);
		lblOutputClass.setText("Output Class: ");
		
		Button btnEdit = new Button(testClassComposite, SWT.NONE);
		FormData fd_btnEdit = new FormData();
		fd_btnEdit.top = new FormAttachment(lblOutputClass, -2, SWT.TOP);
		fd_btnEdit.bottom = new FormAttachment(lblOutputClass, 2, SWT.BOTTOM);
		fd_btnEdit.right = new FormAttachment(100, -5);
		btnEdit.setLayoutData(fd_btnEdit);
		btnEdit.setText("Edit...");
		btnEdit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {
				// TODO Auto-generated method stub
				FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);
				 fileDialog.setFilterNames(new String[] { "Java Files "});
			   fileDialog.setFilterExtensions(new String[] { "*.java" }); 
			   fileDialog.setFilterPath("c:\\"); //Windows path
			   fileDialog.setText("选择java文件");
			   String dir = fileDialog.open();
			   if(dir!=null){
				   textOutputClass.setText(dir);
			   }
			   
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		textOutputClass = new Text(testClassComposite, SWT.BORDER);
		FormData fd_text_1 = new FormData();
		fd_text_1.top = new FormAttachment(btnEdit, 0, SWT.TOP);
		fd_text_1.left = new FormAttachment(lblOutputClass, 6);
		fd_text_1.bottom = new FormAttachment(btnEdit,0, SWT.BOTTOM);
		fd_text_1.right = new FormAttachment(btnEdit, -5,SWT.LEFT);
		textOutputClass.setLayoutData(fd_text_1);
		//文本框设为只读
		textOutputClass.setEditable(false);
		
		btnAddThisText = new Button(testClassComposite, SWT.CHECK);
		FormData fd_btnAddThisText = new FormData();
		fd_btnAddThisText.top = new FormAttachment(textOutputClass, 12);
		fd_btnAddThisText.left = new FormAttachment(btnDoNotGenerate, 0, SWT.LEFT);
		btnAddThisText.setLayoutData(fd_btnAddThisText);
		btnAddThisText.setText("Add this text to the javadoc of newly generated test methods:");
		
		javadocText = new Text(testClassComposite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		FormData javadocFormData = new FormData();
		javadocFormData.top = new FormAttachment(btnAddThisText, 6);
		javadocFormData.left = new FormAttachment(btnDoNotGenerate, 0, SWT.LEFT);
		javadocFormData.right = new FormAttachment(100, -5);
		javadocText.setLayoutData(javadocFormData);

	}
	/**
	 * 获取TestCase4Generation选项
	 * @return
	 */
	public TestCase4GenerationEntity getTestCase4Generation(){
		TestCase4GenerationEntity testCase4GenerationEntity = new TestCase4GenerationEntity();
		if(btnDoNotGenerate.getSelection()){
			testCase4GenerationEntity.isNotGenerateOtherTestCase = true;
		}
		if(btnAddGeneratedmodifiedFiles.getSelection()){
			testCase4GenerationEntity.isCommitSouceControl = true;
		}
		if(btnUseAnExternal.getSelection()){
			testCase4GenerationEntity.isUseLinkedLocation = true;
		}
		
		if(btnAddGeneratedTest.getSelection()){
			testCase4GenerationEntity.existingTestClass = 1;
		}
		if(btnReplaceTheExisting.getSelection()){
			testCase4GenerationEntity.existingTestClass = 2;
		}
		if(btnAddThisText.getSelection()){
			testCase4GenerationEntity.isAddTestToJavadoc = true;
		}
		
		
		return testCase4GenerationEntity;
	}

}

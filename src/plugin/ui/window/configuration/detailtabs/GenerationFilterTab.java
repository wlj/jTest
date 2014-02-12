package plugin.ui.window.configuration.detailtabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import plugin.ui.window.configuration.entity.Filter4GenerationEntity;
import plugin.ui.window.configuration.entity.Input4GenerationEntity;

public class GenerationFilterTab {

	private TabItem tabItem;
	public Button btnOnlyIncreaseCoverage;
	public Button btnCheckButton;
	public Button btnGenerateTestsThat;
	public Button btnGenerateTestsThat_1;
	public Button btnGenerateTestCases;
	public Button btnIncludeCommentsIn;
	public Button btnPublicMethods;
	public Button btnCheckButton_1;
	public Button btnPackagePrivateMethods;
	public Button btnCheckButton_2;
	public Button btnPrivateMethods;
	public Button btnWithOutofdateTest;
	public Button btnWithUptodateTest; 
	

	public GenerationFilterTab(TabFolder tabFolderInGeneration) {
		tabItem = new TabItem(tabFolderInGeneration, SWT.NONE);
		tabItem.setText("Filter");

		Composite filterInGenerationComposite = new Composite(tabFolderInGeneration, SWT.NONE);
		tabItem.setControl(filterInGenerationComposite);
		filterInGenerationComposite.setLayout(new FormLayout());

		btnOnlyIncreaseCoverage = new Button(filterInGenerationComposite, SWT.CHECK);
		FormData fd_btnOnlyIncreaseCoverage = new FormData();
		fd_btnOnlyIncreaseCoverage.top = new FormAttachment(0, 10);
		fd_btnOnlyIncreaseCoverage.left = new FormAttachment(0, 10);
		btnOnlyIncreaseCoverage.setLayoutData(fd_btnOnlyIncreaseCoverage);
		btnOnlyIncreaseCoverage.setText("Only generate test cases which will increase");
		
		Combo combo = new Combo(filterInGenerationComposite, SWT.NONE);
		FormData fd_combo = new FormData();
		fd_combo.top = new FormAttachment(0, 7);
		fd_combo.left = new FormAttachment(0, 290);
		combo.setLayoutData(fd_combo);
		
		Label lblCoverage = new Label(filterInGenerationComposite, SWT.NONE);
		FormData fd_lblCoverage = new FormData();
		fd_lblCoverage.right = new FormAttachment(0, 445);
		fd_lblCoverage.top = new FormAttachment(0, 10);
		fd_lblCoverage.left = new FormAttachment(0, 384);
		lblCoverage.setLayoutData(fd_lblCoverage);
		lblCoverage.setText("coverage");
		
		btnCheckButton = new Button(filterInGenerationComposite, SWT.CHECK);
		FormData fd_btnCheckButton = new FormData();
		fd_btnCheckButton.top = new FormAttachment(0, 33);
		fd_btnCheckButton.left = new FormAttachment(0, 10);
		btnCheckButton.setLayoutData(fd_btnCheckButton);
		btnCheckButton.setText("Generate tests that pass null values to methods");
		
		btnGenerateTestsThat = new Button(filterInGenerationComposite, SWT.CHECK);
		FormData fd_btnGenerateTestsThat = new FormData();
		fd_btnGenerateTestsThat.top = new FormAttachment(0, 56);
		fd_btnGenerateTestsThat.left = new FormAttachment(0, 10);
		btnGenerateTestsThat.setLayoutData(fd_btnGenerateTestsThat);
		btnGenerateTestsThat.setText("Generate tests that ");
		
		Combo combo_1 = new Combo(filterInGenerationComposite, SWT.NONE);
		FormData fd_combo_1 = new FormData();
		fd_combo_1.right = new FormAttachment(0, 307);
		fd_combo_1.top = new FormAttachment(0, 53);
		fd_combo_1.left = new FormAttachment(0, 151);
		combo_1.setLayoutData(fd_combo_1);
		
		Label lblExceptions = new Label(filterInGenerationComposite, SWT.NONE);
		FormData fd_lblExceptions = new FormData();
		fd_lblExceptions.right = new FormAttachment(0, 378);
		fd_lblExceptions.top = new FormAttachment(0, 56);
		fd_lblExceptions.left = new FormAttachment(0, 317);
		lblExceptions.setLayoutData(fd_lblExceptions);
		lblExceptions.setText("exceptions");
		
		btnGenerateTestsThat_1 = new Button(filterInGenerationComposite, SWT.CHECK);
		FormData fd_btnGenerateTestsThat_1 = new FormData();
		fd_btnGenerateTestsThat_1.right = new FormAttachment(0, 307);
		fd_btnGenerateTestsThat_1.top = new FormAttachment(0, 83);
		fd_btnGenerateTestsThat_1.left = new FormAttachment(0, 10);
		btnGenerateTestsThat_1.setLayoutData(fd_btnGenerateTestsThat_1);
		btnGenerateTestsThat_1.setText("Generate tests that report time out problems");
		
		btnGenerateTestCases = new Button(filterInGenerationComposite, SWT.CHECK);
		FormData fd_btnGenerateTestCases = new FormData();
		fd_btnGenerateTestCases.right = new FormAttachment(0, 233);
		fd_btnGenerateTestCases.top = new FormAttachment(0, 106);
		fd_btnGenerateTestCases.left = new FormAttachment(0, 10);
		btnGenerateTestCases.setLayoutData(fd_btnGenerateTestCases);
		btnGenerateTestCases.setText("Generate test cases with stubs for");
		
		Combo combo_2 = new Combo(filterInGenerationComposite, SWT.NONE);
		FormData fd_combo_2 = new FormData();
		fd_combo_2.top = new FormAttachment(0, 103);
		fd_combo_2.left = new FormAttachment(0, 230);
		combo_2.setLayoutData(fd_combo_2);
		
		Label lblMethodCalls = new Label(filterInGenerationComposite, SWT.NONE);
		FormData fd_lblMethodCalls = new FormData();
		fd_lblMethodCalls.right = new FormAttachment(0, 404);
		fd_lblMethodCalls.top = new FormAttachment(0, 106);
		fd_lblMethodCalls.left = new FormAttachment(0, 324);
		lblMethodCalls.setLayoutData(fd_lblMethodCalls);
		lblMethodCalls.setText("method calls");
		
		btnIncludeCommentsIn = new Button(filterInGenerationComposite, SWT.CHECK);
		FormData fd_btnIncludeCommentsIn = new FormData();
		fd_btnIncludeCommentsIn.right = new FormAttachment(0, 243);
		fd_btnIncludeCommentsIn.top = new FormAttachment(0, 129);
		fd_btnIncludeCommentsIn.left = new FormAttachment(0, 20);
		btnIncludeCommentsIn.setLayoutData(fd_btnIncludeCommentsIn);
		btnIncludeCommentsIn.setText("Include comments in stub methods");
		
		Group grpGenerateTestsFor = new Group(filterInGenerationComposite, SWT.NONE);
		FormData fd_grpGenerateTestsFor = new FormData();
		fd_grpGenerateTestsFor.bottom = new FormAttachment(btnIncludeCommentsIn, 114, SWT.BOTTOM);
		fd_grpGenerateTestsFor.top = new FormAttachment(btnIncludeCommentsIn);
		fd_grpGenerateTestsFor.left = new FormAttachment(0, 10);
		fd_grpGenerateTestsFor.right = new FormAttachment(100, -10);
		grpGenerateTestsFor.setLayoutData(fd_grpGenerateTestsFor);
		grpGenerateTestsFor.setText("Generate tests for method access level");
		
		btnPublicMethods = new Button(grpGenerateTestsFor, SWT.CHECK);
		btnPublicMethods.setBounds(10, 22, 110, 17);
		btnPublicMethods.setText("Public methods");
		
		btnCheckButton_1 = new Button(grpGenerateTestsFor, SWT.CHECK);
		btnCheckButton_1.setBounds(10, 43, 132, 17);
		btnCheckButton_1.setText("Protected methods");
		
		btnPackagePrivateMethods = new Button(grpGenerateTestsFor, SWT.CHECK);
		btnPackagePrivateMethods.setBounds(10, 66, 169, 17);
		btnPackagePrivateMethods.setText("Package private methods");
		
		btnPrivateMethods = new Button(grpGenerateTestsFor, SWT.CHECK);
		btnPrivateMethods.setBounds(10, 88, 110, 17);
		btnPrivateMethods.setText("Private methods");
		
		Group grpGenerateTestFor = new Group(filterInGenerationComposite, SWT.NONE);
		grpGenerateTestFor.setText("Generate tests for code");
		FormData fd_grpGenerateTestFor = new FormData();
		fd_grpGenerateTestFor.bottom = new FormAttachment(grpGenerateTestsFor, 92, SWT.BOTTOM);
		fd_grpGenerateTestFor.top = new FormAttachment(grpGenerateTestsFor, 6);
		fd_grpGenerateTestFor.left = new FormAttachment(grpGenerateTestsFor, 0, SWT.LEFT);
		fd_grpGenerateTestFor.right = new FormAttachment(grpGenerateTestsFor, 0, SWT.RIGHT);
		grpGenerateTestFor.setLayoutData(fd_grpGenerateTestFor);
		
		btnCheckButton_2 = new Button(grpGenerateTestFor, SWT.CHECK);
		btnCheckButton_2.setBounds(10, 21, 136, 17);
		btnCheckButton_2.setText("Without test classes");
		
		btnWithOutofdateTest = new Button(grpGenerateTestFor, SWT.CHECK);
		btnWithOutofdateTest.setBounds(10, 44, 188, 17);
		btnWithOutofdateTest.setText("With out-of-date test classes");
		
		btnWithUptodateTest = new Button(grpGenerateTestFor, SWT.CHECK);
		btnWithUptodateTest.setBounds(10, 67, 188, 17);
		btnWithUptodateTest.setText("With up-to-date test classes");

	}
	/**
	 * 获取Filter4Generation选项
	 * @return
	 */
	public Filter4GenerationEntity getFilter4Generation(){
		Filter4GenerationEntity filter4GenerationEntity = new Filter4GenerationEntity();
		if(btnOnlyIncreaseCoverage.getSelection()){
			filter4GenerationEntity.isOnlyTestCase4HighCoverage = true;
		}
		if(btnCheckButton.getSelection()){
			filter4GenerationEntity.isGenerateNullArgument = true;
		}
		if(btnGenerateTestsThat.getSelection()){
			filter4GenerationEntity.isHandlingExceptions = true;
		}
		if(btnGenerateTestsThat_1.getSelection()){
			filter4GenerationEntity.isGenerateTimeOutTestCase = true;
			//=text_monitoringNewApp.getText();
		}
		if(btnGenerateTestCases.getSelection()){
			filter4GenerationEntity.isGenerateStubs4MethodCallCase = true;
		}
		if(btnIncludeCommentsIn.getSelection()){
			filter4GenerationEntity.isIncludeComments = true;
		}
		if(btnPublicMethods.getSelection()){
			filter4GenerationEntity.isPublic = true;
		}
		if(btnPackagePrivateMethods.getSelection()){
			filter4GenerationEntity.isInternal = true;
		}
		if(btnPrivateMethods.getSelection()){
			filter4GenerationEntity.isPrivate = true;
		}
		if(btnCheckButton_1.getSelection()){
			filter4GenerationEntity.isProtect = true;
		}
		if(btnCheckButton_2.getSelection()){
			filter4GenerationEntity.isWithoutTestClass = true;
		}
		if(btnWithOutofdateTest.getSelection()){
			filter4GenerationEntity.isWithOutDateTestClass = true;
		}
		if(btnWithUptodateTest.getSelection()){
			filter4GenerationEntity.isWithUpdateTestClass = true;
		}
		
		return filter4GenerationEntity;
	}

}

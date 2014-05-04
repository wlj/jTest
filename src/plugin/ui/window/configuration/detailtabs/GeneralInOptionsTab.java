package plugin.ui.window.configuration.detailtabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import plugin.ui.window.configuration.entity.GenerationEntity;
import plugin.ui.window.configuration.entity.StaticEntity;
import plugin.ui.window.configuration.entity.StaticGeneral;

public class GeneralInOptionsTab {
	TabItem tabItem;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	public Button btnSkipJspFiles;
	public Button btnExcludeVeryLarge;
	public Button btnCheckFilesWith;
	public Button btnOnlyReportEGNTFP;
	public Button btnUseCustomBeginend;
	public Button btnIgnoreGlobalAnalysis;
	public Button btnAllowCompilationErrors;
	public Button btnIncludeUserdefinedTest;
	public Button btnIgnoreCodeDuplication;
	
	public GeneralInOptionsTab(TabFolder tabFolder, StaticGeneral entity){
		tabItem = new TabItem(tabFolder, SWT.None);
		tabItem.setText("General");

		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.H_SCROLL | SWT.V_SCROLL);
		tabItem.setControl(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		Composite compositeInScrolledComposite = new Composite(scrolledComposite, SWT.NONE);
		compositeInScrolledComposite.setLayout(new FormLayout());
		// TO DO: add content into compositeInScrolledComposite
		btnSkipJspFiles = new Button(compositeInScrolledComposite, SWT.CHECK);
		FormData fd_btnSkipJspFiles = new FormData();
		fd_btnSkipJspFiles.top = new FormAttachment(0, 10);
		fd_btnSkipJspFiles.left = new FormAttachment(0, 10);
		btnSkipJspFiles.setLayoutData(fd_btnSkipJspFiles);
		btnSkipJspFiles.setText("Skip JSP files");
		
		btnExcludeVeryLarge = new Button(compositeInScrolledComposite, SWT.CHECK);
		FormData fd_btnExcludeVeryLarge = new FormData();
		fd_btnExcludeVeryLarge.top = new FormAttachment(btnSkipJspFiles, 6);
		fd_btnExcludeVeryLarge.left = new FormAttachment(btnSkipJspFiles, 0, SWT.LEFT);
		btnExcludeVeryLarge.setLayoutData(fd_btnExcludeVeryLarge);
		btnExcludeVeryLarge.setText("Exclude very large files that are longer than");
		btnExcludeVeryLarge.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				text_1.setEnabled(btnExcludeVeryLarge.getSelection());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		text_1 = new Text(compositeInScrolledComposite, SWT.BORDER);
		FormData fd_text_1 = new FormData();
		fd_text_1.top = new FormAttachment(btnExcludeVeryLarge, 0, SWT.TOP);
		fd_text_1.left = new FormAttachment(btnExcludeVeryLarge, 1);
		text_1.setLayoutData(fd_text_1);
		
		Label lblLines = new Label(compositeInScrolledComposite, SWT.NONE);
		FormData fd_lblLines = new FormData();
		fd_lblLines.bottom = new FormAttachment(btnExcludeVeryLarge, 0, SWT.BOTTOM);
		fd_lblLines.left = new FormAttachment(text_1, 6);
		lblLines.setLayoutData(fd_lblLines);
		lblLines.setText("lines");
		
		btnCheckFilesWith = new Button(compositeInScrolledComposite, SWT.CHECK);
		FormData fd_btnCheckFilesWith = new FormData();
		fd_btnCheckFilesWith.top = new FormAttachment(btnExcludeVeryLarge, 6);
		fd_btnCheckFilesWith.left = new FormAttachment(btnSkipJspFiles, 0, SWT.LEFT);
		btnCheckFilesWith.setLayoutData(fd_btnCheckFilesWith);
		btnCheckFilesWith.setText("Check files with compilation errors");
		
		btnOnlyReportEGNTFP = new Button(compositeInScrolledComposite, SWT.CHECK);
		FormData fd_btnOnlyReportEGNTFP = new FormData();
		fd_btnOnlyReportEGNTFP.top = new FormAttachment(btnCheckFilesWith, 6);
		fd_btnOnlyReportEGNTFP.left = new FormAttachment(btnCheckFilesWith, 10, SWT.LEFT);
		btnOnlyReportEGNTFP.setLayoutData(fd_btnOnlyReportEGNTFP);
		btnOnlyReportEGNTFP.setText("Only report errors guaranteed not to be false positives");
		
		btnUseCustomBeginend = new Button(compositeInScrolledComposite, SWT.CHECK);
		FormData fd_btnUseCustomBeginend = new FormData();
		fd_btnUseCustomBeginend.top = new FormAttachment(btnOnlyReportEGNTFP, 6);
		fd_btnUseCustomBeginend.left = new FormAttachment(btnSkipJspFiles, 0, SWT.LEFT);
		btnUseCustomBeginend.setLayoutData(fd_btnUseCustomBeginend);
		btnUseCustomBeginend.setText("Use custom begin/end comments to mark the code to be checked");
		btnUseCustomBeginend.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				text_2.setEnabled(btnUseCustomBeginend.getSelection());
				text_3.setEnabled(btnUseCustomBeginend.getSelection());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Label lblNewLabel = new Label(compositeInScrolledComposite, SWT.NONE);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.top = new FormAttachment(btnUseCustomBeginend, 6);
		fd_lblNewLabel.left = new FormAttachment(btnUseCustomBeginend, 10, SWT.LEFT);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("Begin marker in regular expression:");
		
		text_2 = new Text(compositeInScrolledComposite, SWT.BORDER);
		FormData fd_text_2 = new FormData();
		fd_text_2.right = new FormAttachment(100, -5);
		fd_text_2.top = new FormAttachment(btnUseCustomBeginend, 6);
		fd_text_2.left = new FormAttachment(lblNewLabel, 6);
		text_2.setLayoutData(fd_text_2);
		
		Label lblEndMarkerIn = new Label(compositeInScrolledComposite, SWT.NONE);
		FormData fd_lblEndMarkerIn = new FormData();
		fd_lblEndMarkerIn.top = new FormAttachment(lblNewLabel, 11);
		fd_lblEndMarkerIn.left = new FormAttachment(btnOnlyReportEGNTFP, 0, SWT.LEFT);
		lblEndMarkerIn.setLayoutData(fd_lblEndMarkerIn);
		lblEndMarkerIn.setText("End marker in regular expression:");
		
		text_3 = new Text(compositeInScrolledComposite, SWT.BORDER);
		FormData fd_text_3 = new FormData();
		fd_text_3.right = new FormAttachment(100, -5);
		fd_text_3.top = new FormAttachment(lblEndMarkerIn, -3, SWT.TOP);
		fd_text_3.left = new FormAttachment(text_2, 0, SWT.LEFT);
		text_3.setLayoutData(fd_text_3);
		
		Group grpGlobalAnalysis = new Group(compositeInScrolledComposite, SWT.NONE);
		grpGlobalAnalysis.setText("Global Analysis");
		grpGlobalAnalysis.setLayout(new FormLayout());
		FormData fd_grpGlobalAnalysis = new FormData();
		fd_grpGlobalAnalysis.top = new FormAttachment(text_3, 3);
		fd_grpGlobalAnalysis.right = new FormAttachment(100, -5);
		fd_grpGlobalAnalysis.left = new FormAttachment(0, 10);
		grpGlobalAnalysis.setLayoutData(fd_grpGlobalAnalysis);
		
		btnIgnoreGlobalAnalysis = new Button(grpGlobalAnalysis, SWT.CHECK);
		FormData fd_btnIgnoreGlobalAnalysis = new FormData();
		fd_btnIgnoreGlobalAnalysis.top = new FormAttachment(0);
		fd_btnIgnoreGlobalAnalysis.left = new FormAttachment(0, 10);
		btnIgnoreGlobalAnalysis.setLayoutData(fd_btnIgnoreGlobalAnalysis);
		btnIgnoreGlobalAnalysis.setText("Ignore global analysis rules");
		
		btnAllowCompilationErrors = new Button(grpGlobalAnalysis, SWT.CHECK);
		FormData fd_btnAllowCompilationErrors = new FormData();
		fd_btnAllowCompilationErrors.top = new FormAttachment(btnIgnoreGlobalAnalysis, 6, SWT.BOTTOM);			
		fd_btnAllowCompilationErrors.left = new FormAttachment(btnIgnoreGlobalAnalysis, 0, SWT.LEFT);
		btnAllowCompilationErrors.setLayoutData(fd_btnAllowCompilationErrors);
		btnAllowCompilationErrors.setText("Allow compilation errors in global analysis (may cause false positive violations)");
		
		btnIncludeUserdefinedTest = new Button(grpGlobalAnalysis, SWT.CHECK);
		FormData fd_btnIncludeUserdefinedTest = new FormData();
		fd_btnIncludeUserdefinedTest.top = new FormAttachment(btnAllowCompilationErrors, 6, SWT.BOTTOM);			
		fd_btnIncludeUserdefinedTest.left = new FormAttachment(btnAllowCompilationErrors, 0, SWT.LEFT);
		btnIncludeUserdefinedTest.setLayoutData(fd_btnIncludeUserdefinedTest);
		btnIncludeUserdefinedTest.setText("Include user-defined test classes in global analysis");
		
		Group grpCodeDuplicationAnalysis = new Group(compositeInScrolledComposite, SWT.NONE);
		grpCodeDuplicationAnalysis.setText("Code Duplication Analysis");
		grpCodeDuplicationAnalysis.setLayout(new FormLayout());
		FormData fd_grpCodeDuplicationAnalysis = new FormData();
		fd_grpCodeDuplicationAnalysis.right = new FormAttachment(100, -5);
		fd_grpCodeDuplicationAnalysis.top = new FormAttachment(grpGlobalAnalysis, 6);
		fd_grpCodeDuplicationAnalysis.left = new FormAttachment(0, 10);
		grpCodeDuplicationAnalysis.setLayoutData(fd_grpCodeDuplicationAnalysis);
		
		btnIgnoreCodeDuplication = new Button(grpCodeDuplicationAnalysis, SWT.CHECK);
		FormData fd_btnIgnoreCodeDuplication = new FormData();
		fd_btnIgnoreCodeDuplication.top = new FormAttachment(0);
		fd_btnIgnoreCodeDuplication.left = new FormAttachment(0, 10);
		btnIgnoreCodeDuplication.setLayoutData(fd_btnIgnoreCodeDuplication);
		btnIgnoreCodeDuplication.setText("Ignore code duplication rules");

		scrolledComposite.setContent(compositeInScrolledComposite);
		scrolledComposite.setMinSize(compositeInScrolledComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		generalInOptionInit(entity);
	}
	
	/**
	 * generalInOptionInit
	 * @param entity
	 */
	public void generalInOptionInit(StaticGeneral entity){
		if(entity==null){
			//btnExcludeVeryLarge.setEnabled(false);
			text_1.setEnabled(false);
			//btnUseCustomBeginend.setEnabled(false);
			text_2.setEnabled(false);
			text_3.setEnabled(false);
			return;
		}
		if(entity.isExcludeLargeFile){
			btnExcludeVeryLarge.setEnabled(true);
			text_1.setEnabled(true);
			text_1.setText(String.valueOf(entity.largeFileSize));
		}
		if(entity.isUseCustomBeginEnd){
			btnUseCustomBeginend.setEnabled(true);
			text_2.setEnabled(true);
			text_3.setEnabled(true);
			text_3.setText(entity.customBegin);
			text_3.setText(entity.customEnd);
		}
		if(entity.isSkipJSP){
			btnSkipJspFiles.setSelection(true);
		}
		if(entity.isCheckFileWithCompileError){
			btnCheckFilesWith.setSelection(true);
		}
		if(entity.isOnlyReportError){
			btnOnlyReportEGNTFP.setSelection(true);
		}
		if(entity.isIgnoreGlobalRules){
			btnIgnoreGlobalAnalysis.setSelection(true);
		}
		if(entity.isAllowCompileError){
			btnAllowCompilationErrors.setSelection(true);
		}
		if(entity.isIncludeUserTestClass){
			btnIncludeUserdefinedTest.setSelection(true);
		}
		if(entity.isIgnoreRepeat){
			btnIgnoreCodeDuplication.setSelection(true);
		}
	}
	/**
	 * 获取StaticGeneral选项
	 * @return
	 */
	public StaticGeneral getstaticGeneral(){
		StaticGeneral staticGeneral = new StaticGeneral();
		if(btnSkipJspFiles.getSelection()){
			staticGeneral.isSkipJSP = true;
		}
		if(btnExcludeVeryLarge.getSelection()){
			staticGeneral.isExcludeLargeFile = true;
			String text1 = text_1.getText();
			staticGeneral.largeFileSize = Integer.parseInt(text1);
		}
		if(btnCheckFilesWith.getSelection()){
			staticGeneral.isCheckFileWithCompileError = true;	
		}
		if(btnOnlyReportEGNTFP.getSelection()){
			staticGeneral.isOnlyReportError = true;
		}
		if(btnUseCustomBeginend.getSelection()){
			staticGeneral.isUseCustomBeginEnd = true;
			staticGeneral.customBegin = text_2.getText();
			staticGeneral.customEnd = text_3.getText();
		}
		if(btnIgnoreGlobalAnalysis.getSelection()){
			staticGeneral.isIgnoreGlobalRules = true;
		}
		if(btnAllowCompilationErrors.getSelection()){
			staticGeneral.isCheckFileWithCompileError = true;
		}
		if(btnIncludeUserdefinedTest.getSelection()){
			staticGeneral.isIncludeUserTestClass = true;
		}
		if(btnIgnoreCodeDuplication.getSelection()){
			staticGeneral.isIgnoreRepeat = true;
		}
		return staticGeneral;
		
	}
	
}
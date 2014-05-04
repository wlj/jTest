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
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import plugin.ui.window.configuration.entity.BugDetectionEntity;
import plugin.ui.window.configuration.entity.Metrics;
import plugin.ui.window.configuration.entity.RuleTreeEntity;
import plugin.ui.window.configuration.entity.ScopeEntity;
import plugin.ui.window.configuration.entity.StaticEntity;
import plugin.ui.window.configuration.entity.StaticGeneral;
import plugin.util.Const;
import plugin.util.SWTResourceManager;

public class StaticTab {

	TabItem tbtmStatic;
	Text txtLimitMaxTask;
	Button btnSkipAutomaticallyGenerated;
	Button btnDoNotApply;
	
	TabFolder staticTabFolder;
	StaticInnerTabFolder staticInnerTabFolder;
	
	Button btnLimitMaximumNumber;
	Button btnEnableStaticAnalysis;

	public StaticTab(TabFolder tabFolder, StaticEntity entity) {
		tbtmStatic = new TabItem(tabFolder, SWT.NONE);
		tbtmStatic.setImage(SWTResourceManager.getImage(Const.STATIC_ICON_PATH));
		tbtmStatic.setText("Static");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tbtmStatic.setControl(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		Composite staticComposite = new Composite(scrolledComposite, SWT.NONE);
		staticComposite.setLayout(new FormLayout());
		
		// TO DO: add content into compositeInScrolledComposite
		
		btnEnableStaticAnalysis = new Button(staticComposite, SWT.CHECK);
		FormData fd_btnEnableStaticAnalysis = new FormData();
		fd_btnEnableStaticAnalysis.top = new FormAttachment(0, 10);
		fd_btnEnableStaticAnalysis.left = new FormAttachment(0, 10);
		btnEnableStaticAnalysis.setLayoutData(fd_btnEnableStaticAnalysis);
		btnEnableStaticAnalysis.setText("Enable Static Analysis");
		
		btnLimitMaximumNumber = new Button(staticComposite, SWT.CHECK);
		FormData fd_btnLimitMaximumNumber = new FormData();
		fd_btnLimitMaximumNumber.top = new FormAttachment(btnEnableStaticAnalysis, 6);
		fd_btnLimitMaximumNumber.left = new FormAttachment(btnEnableStaticAnalysis, 0, SWT.LEFT);
		btnLimitMaximumNumber.setLayoutData(fd_btnLimitMaximumNumber);
		btnLimitMaximumNumber.setText("Limit maximum number of tasks reported per rule to: ");
		btnLimitMaximumNumber.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				txtLimitMaxTask.setEnabled(btnLimitMaximumNumber.getSelection());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		txtLimitMaxTask = new Text(staticComposite, SWT.BORDER);
		FormData fd_txtLimitMaxTask = new FormData();
		fd_txtLimitMaxTask.bottom = new FormAttachment(btnLimitMaximumNumber, 0, SWT.BOTTOM);
		fd_txtLimitMaxTask.left = new FormAttachment(btnLimitMaximumNumber, 1);
		txtLimitMaxTask.setLayoutData(fd_txtLimitMaxTask);
		
		btnSkipAutomaticallyGenerated = new Button(staticComposite, SWT.CHECK);
		FormData fd_btnSkipAutomaticallyGenerated = new FormData();
		fd_btnSkipAutomaticallyGenerated.top = new FormAttachment(btnLimitMaximumNumber, 6);
		fd_btnSkipAutomaticallyGenerated.left = new FormAttachment(0, 10);
		btnSkipAutomaticallyGenerated.setLayoutData(fd_btnSkipAutomaticallyGenerated);
		btnSkipAutomaticallyGenerated.setText("Skip automatically generated test classes");
		
		btnDoNotApply = new Button(staticComposite, SWT.CHECK);
		FormData fd_btnDoNotApply = new FormData();
		fd_btnDoNotApply.top = new FormAttachment(btnSkipAutomaticallyGenerated, 6);
		fd_btnDoNotApply.left = new FormAttachment(0, 10);
		btnDoNotApply.setLayoutData(fd_btnDoNotApply);
		btnDoNotApply.setText("Do not apply suppressions");
		
		staticInnerTabFolder = new StaticInnerTabFolder(staticComposite, entity.ruleTreeEntity, entity.metrics, entity.general, entity.bugDetection);
		staticTabFolder = staticInnerTabFolder.tabFolder;
		FormData fd_staticTabFolder = new FormData();
		fd_staticTabFolder.right = new FormAttachment(100, -5);
		fd_staticTabFolder.bottom = new FormAttachment(100, -5);
		fd_staticTabFolder.top = new FormAttachment(btnDoNotApply, 6);
		fd_staticTabFolder.left = new FormAttachment(0, 10);
		staticTabFolder.setLayoutData(fd_staticTabFolder);
		
		scrolledComposite.setContent(staticComposite);
		scrolledComposite.setMinSize(staticComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		staticInit(entity);
		//ruleTreeInit();
		//metricsInit();
		//generalInOptionInit();
		//bugDetectiveInOptionsInit();
	}
	
//	Text txtLimitMaxTask;
//	Button btnSkipAutomaticallyGenerated;
//	Button btnDoNotApply;
//	
//	TabFolder staticTabFolder;
//	StaticInnerTabFolder staticInnerTabFolder;
//	
//	Button btnLimitMaximumNumber;
//	Button btnSkipAutomaticallyGenerated;
//	Button btnDoNotApply;
//	
//	TabFolder staticTabFolder;
//	StaticInnerTabFolder staticInnerTabFolder;
//	
//	Button btnLimitMaximumNumber;
//	Button btnEnableStaticAnalysis;
	private void staticInit(StaticEntity entity){
		if(entity == null){
			txtLimitMaxTask.setEnabled(false);
	    }
		if(entity.isEnabled) {
			btnEnableStaticAnalysis.setSelection(true);
		}
		if(entity.isLimitTasks){
			btnLimitMaximumNumber.setSelection(true);
			txtLimitMaxTask.setEnabled(true);
			txtLimitMaxTask.setText(String.valueOf(entity.maxCount));
		}else{
			btnLimitMaximumNumber.setSelection(false);
			txtLimitMaxTask.setEnabled(false);
		}
		if(entity.skipTestClass){
			btnSkipAutomaticallyGenerated.setSelection(true);
		}
		if(entity.isApplySuppressions){
			btnDoNotApply.setSelection(true);
		}	
	}
	
	/**
	 * 获取static选项
	 * @return
	 */
	public StaticEntity getStatic(){
		StaticEntity statis=new StaticEntity();
		if(btnEnableStaticAnalysis.getSelection()){
			statis.isEnabled = true;
		}
		if(btnLimitMaximumNumber.getSelection()){
			statis.isLimitTasks = true;
			txtLimitMaxTask.setEnabled(true);
			//txtLimitMaxTask.setTextLimit();
			String limitnum = txtLimitMaxTask.getText();
			if(limitnum != null){
				statis.maxCount = Integer.parseInt(limitnum);
			}
		}
		if(btnSkipAutomaticallyGenerated.getSelection()){
			statis.skipTestClass = true;
		}
		if(btnDoNotApply.getSelection()){
			statis.isApplySuppressions = true;
		}
		statis.metrics = staticInnerTabFolder.metricsTabInStatic.getMetrics();
		statis.general = staticInnerTabFolder.optionsTabInStatic.generalInOptionsTab.getstaticGeneral();
		statis.bugDetection = staticInnerTabFolder.optionsTabInStatic.bugDetectiveInOptionsTab.getBugDetectionEntity();
		return statis;
	}

}

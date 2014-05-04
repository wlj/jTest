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

import plugin.ui.window.configuration.entity.BugDetectionEntity;
import plugin.ui.window.configuration.entity.StaticEntity;
import plugin.ui.window.configuration.entity.StaticGeneral;

public class BugDetectiveInOptionsTab {

	TabItem tabItem;
	private Text text_TimeLimit;
	public Button btnShallowestfastest;
	public Button btnShallowfast;
	public Button btnStandard;
	public Button btnDeepslower;
	public Button btnThoroughslower;
	public Button btnAlsoImposeTime;
	public Button btnDoNotReport;
	public Button btnReportAllSimilar;
	public Button btnDoNotShowViolationPoint;
	public Button btnDoNotShowSuspiciousPoint;
	

	public BugDetectiveInOptionsTab(TabFolder tabFolder, BugDetectionEntity entity) {
		tabItem = new TabItem(tabFolder, SWT.None);
		tabItem.setText("BugDetective");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.H_SCROLL | SWT.V_SCROLL);
		tabItem.setControl(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		Composite compositeInScrolledComposite = new Composite(scrolledComposite, SWT.NONE);
		compositeInScrolledComposite.setLayout(new FormLayout());
		// TO DO: add content into compositeInScrolledComposite
		
		Group grpDepthOfAnalysis = new Group(compositeInScrolledComposite, SWT.NONE);
		grpDepthOfAnalysis.setText("Depth of analysis");
		grpDepthOfAnalysis.setLayout(new FormLayout());
		FormData fd_grpDepthOfAnalysis = new FormData();
		fd_grpDepthOfAnalysis.top = new FormAttachment(0, 10);
		fd_grpDepthOfAnalysis.right = new FormAttachment(100, -5);
		fd_grpDepthOfAnalysis.left = new FormAttachment(0, 10);
		grpDepthOfAnalysis.setLayoutData(fd_grpDepthOfAnalysis);
		
		btnShallowestfastest = new Button(grpDepthOfAnalysis, SWT.RADIO);
		FormData fd_btnShallowestfastest = new FormData();
		fd_btnShallowestfastest.left = new FormAttachment(0, 10);
		btnShallowestfastest.setLayoutData(fd_btnShallowestfastest);
		btnShallowestfastest.setText("shallowest (fastest)");
		
		btnShallowfast = new Button(grpDepthOfAnalysis, SWT.RADIO);
		FormData fd_btnShallowfast = new FormData();
		fd_btnShallowfast.top = new FormAttachment(btnShallowestfastest, 6);
		fd_btnShallowfast.left = new FormAttachment(btnShallowestfastest, 0, SWT.LEFT);
		btnShallowfast.setLayoutData(fd_btnShallowfast);
		btnShallowfast.setText("shallow (fast)");
		
		btnStandard = new Button(grpDepthOfAnalysis, SWT.RADIO);
		FormData fd_btnStandard = new FormData();
		fd_btnStandard.top = new FormAttachment(btnShallowfast, 6);
		fd_btnStandard.left = new FormAttachment(btnShallowfast, 0, SWT.LEFT);
		btnStandard.setLayoutData(fd_btnStandard);
		btnStandard.setText("standard");
		
		btnDeepslower = new Button(grpDepthOfAnalysis, SWT.RADIO);
		FormData fd_btnDeepslower = new FormData();
		fd_btnDeepslower.top = new FormAttachment(btnStandard, 6);
		fd_btnDeepslower.left = new FormAttachment(btnShallowestfastest, 0, SWT.LEFT);
		btnDeepslower.setLayoutData(fd_btnDeepslower);
		btnDeepslower.setText("deep (slower)");
		
		btnThoroughslower = new Button(grpDepthOfAnalysis, SWT.RADIO);
		FormData fd_btnThoroughslower = new FormData();
		fd_btnThoroughslower.top = new FormAttachment(btnDeepslower, 6);
		fd_btnThoroughslower.left = new FormAttachment(btnShallowestfastest, 0, SWT.LEFT);
		btnThoroughslower.setLayoutData(fd_btnThoroughslower);
		btnThoroughslower.setText("thorough (slower)");
		
		btnAlsoImposeTime = new Button(grpDepthOfAnalysis, SWT.CHECK);
		FormData fd_btnAlsoImposeTime = new FormData();
		fd_btnAlsoImposeTime.top = new FormAttachment(btnThoroughslower, 6);
		fd_btnAlsoImposeTime.left = new FormAttachment(btnShallowestfastest, 0, SWT.LEFT);
		btnAlsoImposeTime.setLayoutData(fd_btnAlsoImposeTime);
		btnAlsoImposeTime.setText("Also impose time limit [seconds]:");
		btnAlsoImposeTime.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				text_TimeLimit.setEnabled(btnAlsoImposeTime.getSelection());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		text_TimeLimit = new Text(grpDepthOfAnalysis, SWT.BORDER);
		FormData fd_text_TimeLimit = new FormData();
		fd_text_TimeLimit.bottom = new FormAttachment(btnAlsoImposeTime, 0, SWT.BOTTOM);
		fd_text_TimeLimit.left = new FormAttachment(btnAlsoImposeTime, 6);
		text_TimeLimit.setLayoutData(fd_text_TimeLimit);
		
		Label lblNote = new Label(grpDepthOfAnalysis, SWT.WRAP);
		FormData fd_lblNote = new FormData();
		fd_lblNote.right = new FormAttachment(100, -5);
		fd_lblNote.top = new FormAttachment(btnAlsoImposeTime, 6);
		fd_lblNote.left = new FormAttachment(btnShallowestfastest, 0, SWT.LEFT);
		lblNote.setLayoutData(fd_lblNote);
		lblNote.setText("Note: Enabling time limit implies that BugDetective will find more problems on faster machines and fewer on slower ones.");
		
		Label lblDisablingItLeads = new Label(grpDepthOfAnalysis, SWT.NONE);
		FormData fd_lblDisablingItLeads = new FormData();
		fd_lblDisablingItLeads.top = new FormAttachment(lblNote, 6);
		fd_lblDisablingItLeads.left = new FormAttachment(btnShallowestfastest, 0, SWT.LEFT);
		lblDisablingItLeads.setLayoutData(fd_lblDisablingItLeads);
		lblDisablingItLeads.setText("Disabling it leads to the same results found on any computer");
		
		Group grpViolationReportingVerbosity = new Group(compositeInScrolledComposite, SWT.NONE);
		grpViolationReportingVerbosity.setText("Violation reporting verbosity");
		grpViolationReportingVerbosity.setLayout(new FormLayout());
		FormData fd_grpViolationReportingVerbosity = new FormData();
		fd_grpViolationReportingVerbosity.top = new FormAttachment(grpDepthOfAnalysis, 6);
		fd_grpViolationReportingVerbosity.left = new FormAttachment(grpDepthOfAnalysis, 0, SWT.LEFT);
		fd_grpViolationReportingVerbosity.right = new FormAttachment(100, -5);
		grpViolationReportingVerbosity.setLayoutData(fd_grpViolationReportingVerbosity);
		
		btnDoNotReport = new Button(grpViolationReportingVerbosity, SWT.CHECK);
		FormData fd_btnDoNotReport = new FormData();
		fd_btnDoNotReport.top = new FormAttachment(0, 10);
		fd_btnDoNotReport.left = new FormAttachment(0, 10);
		btnDoNotReport.setLayoutData(fd_btnDoNotReport);
		btnDoNotReport.setText("Do not report violations when cause cannot be shown");
		
		Group grpLevelOfReporting = new Group(grpViolationReportingVerbosity, SWT.NONE);
		grpLevelOfReporting.setText("Level of reporting similar violations");
		grpLevelOfReporting.setLayout(new FormLayout());
		FormData fd_grpLevelOfReporting = new FormData();
		fd_grpLevelOfReporting.right = new FormAttachment(100, -5);
		fd_grpLevelOfReporting.top = new FormAttachment(btnDoNotReport, 6, SWT.BOTTOM);
		fd_grpLevelOfReporting.left = new FormAttachment(btnDoNotReport, 0, SWT.LEFT);
		grpLevelOfReporting.setLayoutData(fd_grpLevelOfReporting);
		
		btnReportAllSimilar = new Button(grpLevelOfReporting, SWT.RADIO);
		FormData fd_btnReportAllSimilar = new FormData();
		fd_btnReportAllSimilar.top = new FormAttachment(0, 5);
		fd_btnReportAllSimilar.left = new FormAttachment(0, 5);
		btnReportAllSimilar.setLayoutData(fd_btnReportAllSimilar);
		btnReportAllSimilar.setText("Report all similar violations");
		
		btnDoNotShowViolationPoint = new Button(grpLevelOfReporting, SWT.RADIO);
		FormData fd_btnDoNotShowViolationPoint = new FormData();
		fd_btnDoNotShowViolationPoint.left = new FormAttachment(btnReportAllSimilar, 0, SWT.LEFT);
		fd_btnDoNotShowViolationPoint.top = new FormAttachment(btnReportAllSimilar, 6, SWT.BOTTOM);
		btnDoNotShowViolationPoint.setLayoutData(fd_btnDoNotShowViolationPoint);
		btnDoNotShowViolationPoint.setText("Do not show more than one violation with the same cause and violation point");
		
		btnDoNotShowSuspiciousPoint = new Button(grpLevelOfReporting, SWT.RADIO);
		FormData fd_btnDoNotShowSuspiciousPoint = new FormData();
		fd_btnDoNotShowSuspiciousPoint.left = new FormAttachment(btnDoNotShowViolationPoint, 0, SWT.LEFT);
		fd_btnDoNotShowSuspiciousPoint.top = new FormAttachment(btnDoNotShowViolationPoint, 6, SWT.BOTTOM);
		btnDoNotShowSuspiciousPoint.setLayoutData(fd_btnDoNotShowSuspiciousPoint);
		btnDoNotShowSuspiciousPoint.setText("Do not show more than one violation per suspicious point");
		
		scrolledComposite.setContent(compositeInScrolledComposite);
		scrolledComposite.setMinSize(compositeInScrolledComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		bugDetectiveInOptionsInit(entity);

	}
//	private Text text_TimeLimit;
//	public Button btnAlsoImposeTime;
	/**
	 * bugDetectiveInOptionsInit
	 */
	public void bugDetectiveInOptionsInit(BugDetectionEntity entity){
		if(entity==null){
			text_TimeLimit.setEnabled(false);
			return;
		}if(entity.isLimitTime){
			btnAlsoImposeTime.setSelection(true);;
			text_TimeLimit.setEnabled(true);
			text_TimeLimit.setText(String.valueOf(entity.catchDays));
		}else{
			btnAlsoImposeTime.setSelection(false);
			text_TimeLimit.setEnabled(false);
		}
		if(entity.depth==1){
			btnShallowestfastest.setSelection(true);
		}
        if(entity.depth==2){
        	btnShallowfast.setSelection(true);
		}
        if(entity.depth==3){
        	btnStandard.setSelection(true);
        }
        if(entity.depth==4){
        	btnDeepslower.setSelection(true);
        }
        if(entity.depth==5){
        	btnThoroughslower.setSelection(true);
        }
        if(entity.isReportViolation){
        	btnDoNotReport.setSelection(true);
        }
        if(entity.levelReportViolation==1){
        	btnReportAllSimilar.setSelection(true);
        }
        if(entity.levelReportViolation==2){
        	btnDoNotShowViolationPoint.setSelection(true);
        }
        if(entity.levelReportViolation==3){
        	btnDoNotShowSuspiciousPoint.setSelection(true);
        }
	}
	/**
	 * 获取BugDetective选项
	 * @return
	 */
	public BugDetectionEntity getBugDetectionEntity(){
		BugDetectionEntity bugDetectionEntity = new BugDetectionEntity();
		if(btnShallowestfastest.getSelection()){
			bugDetectionEntity.depth = 1;
		}
		if(btnShallowfast.getSelection()){
			bugDetectionEntity.depth = 2;
		}
		if(btnStandard.getSelection()){
			bugDetectionEntity.depth = 3;
		}
		if(btnDeepslower.getSelection()){
			bugDetectionEntity.depth = 4;
		}
		if(btnThoroughslower.getSelection()){
			bugDetectionEntity.depth = 5;
		}
		if(btnAlsoImposeTime.getSelection()){
			bugDetectionEntity.isLimitTime = true;
			String catchTime = text_TimeLimit.getText();
			bugDetectionEntity.catchDays = Integer.parseInt(catchTime);
		}
		if(btnDoNotReport.getSelection()){
			bugDetectionEntity.isReportViolation = true;
		}
		if(btnReportAllSimilar.getSelection()){
			bugDetectionEntity.levelReportViolation = 1;
		}
		if(btnDoNotShowViolationPoint.getSelection()){
			bugDetectionEntity.levelReportViolation = 2;
		}
		if(btnDoNotShowSuspiciousPoint.getSelection()){
			bugDetectionEntity.levelReportViolation = 3;
		}
		return bugDetectionEntity;
	}
}

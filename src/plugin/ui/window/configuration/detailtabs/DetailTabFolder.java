package plugin.ui.window.configuration.detailtabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import plugin.ui.window.configuration.entity.ConfigEntity;
import plugin.ui.window.configuration.entity.StaticEntity;

public class DetailTabFolder {
	public TabFolder tabFolder;
	
	public ScopeTab scopeTab;
	public StaticTab staticTab;
	public GenerationTab generationTab;
	public ExecutionTab executionTab;
	public CommonTab commonTab;
	public CodeReviewTab codeReviewTab;
	public GoalsTab goalsTab;
	
	public DetailTabFolder(Composite parent, int style,ConfigEntity entity) {
		// TODO Auto-generated constructor stub
		tabFolder = new TabFolder(parent, style);
		FormData fd_tabFolder = new FormData();
		fd_tabFolder.bottom = new FormAttachment(100, -35);
		fd_tabFolder.top = new FormAttachment(0, 70);
		fd_tabFolder.right = new FormAttachment(100, -5);
		fd_tabFolder.left = new FormAttachment(0, 5);
		tabFolder.setLayoutData(fd_tabFolder);
		// add tab items
		if(entity==null){
			scopeTab = new ScopeTab(tabFolder, SWT.None,null);
			staticTab = new StaticTab(tabFolder, null);
			generationTab = new GenerationTab(tabFolder, SWT.None, null);
			executionTab = new ExecutionTab(tabFolder, SWT.None, null);
			commonTab = new CommonTab(tabFolder, SWT.None, null);
			codeReviewTab = new CodeReviewTab(tabFolder, SWT.None, null);
			goalsTab = new GoalsTab(tabFolder, SWT.None ,null);
		}else{
			scopeTab = new ScopeTab(tabFolder, SWT.None,entity.scope);
			staticTab = new StaticTab(tabFolder, entity.staticEntity);
			generationTab = new GenerationTab(tabFolder, SWT.None,entity.generation);
			executionTab = new ExecutionTab(tabFolder, SWT.None, entity.execution);
			commonTab = new CommonTab(tabFolder, SWT.None, entity.common);
			codeReviewTab = new CodeReviewTab(tabFolder, SWT.None, entity.codeReview);
			goalsTab = new GoalsTab(tabFolder, SWT.None ,entity.goal);
		}
		
		
	}
	
	TabFolder getTabFolder(){
		return tabFolder;
	}

}

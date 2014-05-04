package plugin.ui.window.configuration.detailtabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;

import plugin.ui.window.configuration.entity.BugDetectionEntity;
import plugin.ui.window.configuration.entity.Metrics;
import plugin.ui.window.configuration.entity.RuleTreeEntity;
import plugin.ui.window.configuration.entity.StaticGeneral;

public class StaticInnerTabFolder {
	TabFolder tabFolder;
	RulesTreeTabInStatic rulesTreeTabInStatic;
	MetricsTabInStatic metricsTabInStatic;
	OptionsTabInStatic optionsTabInStatic;
	
	
	public StaticInnerTabFolder(Composite parent,RuleTreeEntity entity1, Metrics entity2, StaticGeneral entity3, BugDetectionEntity entity4) {
		// TODO Auto-generated constructor stub
		tabFolder = new TabFolder(parent, SWT.None);
		// set tabFolder's layout
		
		// create the tabs in static's inner TabFolder
		rulesTreeTabInStatic = new RulesTreeTabInStatic(tabFolder);
		metricsTabInStatic = new MetricsTabInStatic(tabFolder);
		optionsTabInStatic = new OptionsTabInStatic(tabFolder, entity3, entity4);
		
	}
}

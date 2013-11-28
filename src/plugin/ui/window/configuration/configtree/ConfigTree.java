package plugin.ui.window.configuration.configtree;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.w3c.dom.Document;

import plugin.util.Const;
import plugin.util.SWTResourceManager;


public class ConfigTree {
	// configTreeFilePath point to the xml file which describe the configTree's
	// constructor
	public static String configTreeFilePath = System.getProperty("user.dir") + "\\src\\plugin\\ui\\window\\configuration\\configuration_list.xml";
	
	public Tree tree;
	public static TreeItem trtmUser;
	public static TreeItem trtmBuiltin;
	public static TreeItem trtmTeam;
	
	public static TreeItem selectedItem = null;
	//can edit tree
	private TreeEditor  editor;
	
	private static Action[] actions;
	
	final String userDefined="User-defined";
	final String builtin="Builtin";
	final String team="Team";
	// todo: duplicate, New child, Delete, export, set as default
	private static String defaultConfigName = "N";
	private boolean isEditing;
	
	
	/**
	 * 创建文本框
	 * @param tree
	 * @return
	 */
	private Text CreateText(Composite tree){
		Text text=new Text(tree, SWT.SINGLE | SWT.BORDER);
		FocusListener focusListener =new  FocusListener(){
			@Override
			public void focusGained(org.eclipse.swt.events.FocusEvent arg0) {
				// TODO Auto-generated method stub
//		        text.selectAll();
				
			}

			@Override
			public void focusLost(org.eclipse.swt.events.FocusEvent arg0) {
				// TODO Auto-generated method stub
				ConfirmEdit();
			}
		};
		text.addFocusListener(focusListener);
		return text;
	}
	/**
	 * 确认修改
	 */
	private void ConfirmEdit(){
		if(!isEditing){
			return;
		}
		isEditing=false;
		Text text = (Text) editor.getEditor();
		TreeItem editingItem=editor.getItem();
		editingItem.setText(text.getText().trim());
		text.setText("");
		text.clearSelection();
		text.setVisible(false);
		text.dispose();
	}
//	private int GetNewItemIndex(){
//		
//	}
	/**
	 * 新建配置
	 * @return
	 */
	public boolean NewConfig(){
		TreeItem userItem = this.tree.getItem(0);
		TreeItem newItem=new TreeItem(userItem,SWT.NONE);
		newItem.setText("New 1");
		return false;
	}
	/**
	 * 构造方法，采用构造方法注入实现右键菜单功能
	 * @param parent
	 * @param style
	 * @param actions
	 */
	public ConfigTree(Composite parent, int style,Action[] actions) {
		// TODO Auto-generated constructor stub
		this.actions=actions;
		tree = new Tree(parent, style);
		//initialize editor tree
		editor=new TreeEditor(tree);
		editor.grabHorizontal = true;  
        editor.grabVertical = true;  
		
		trtmUser = new TreeItem(tree, SWT.NONE);
		trtmUser.setImage(SWTResourceManager.getImage(Const.FOLDER_ICON_PATH));
		trtmUser.setText(userDefined);
		trtmUser.setExpanded(true);

		trtmBuiltin = new TreeItem(tree, SWT.NONE);
		trtmBuiltin.setImage(SWTResourceManager.getImage(Const.FOLDER_ICON_PATH));
		trtmBuiltin.setText(builtin);
		trtmBuiltin.setExpanded(true);
		
		trtmTeam = new TreeItem(tree, SWT.NONE);
		trtmTeam.setImage(SWTResourceManager.getImage(Const.FOLDER_ICON_PATH));
		trtmTeam.setText(team);
		trtmTeam.setExpanded(true);
		tree.addMouseListener(new MouseAdapter() {
			public void mouseDoubleClick(MouseEvent evt) {
				TreeItem selectedItem =  ((Tree)(evt.getSource())).getSelection()[0];
				try {
					beginEdit(selectedItem);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			public void mouseDown(MouseEvent evt) {
				boolean isTreeitem = evt.getSource() instanceof Tree;
				if(isTreeitem){
					initMenu(evt);
				}
				
				///System.out.println(selectedItem.getText());
				
			}

		});
	}
	
	/**
	 * 判断树节点是否可编辑
	 * 只有User和Team的叶子节点才可编辑
	 * @param item 
	 * @return
	 */
	private boolean canEdit(TreeItem item){
		TreeItem parentItem=item.getParentItem();
		
		if(parentItem==null){
			return false;
		}
		
		if(parentItem.getText().equals(builtin)){
			return false;
		}
	    boolean isLeaf=item.getItemCount()==0;
		return isLeaf;
	}
	/**
	 * 开始编辑
	 * @param item
	 * @throws Exception
	 */
	private void beginEdit(TreeItem item) throws Exception{
		if(item==null){
			throw new Exception("item not be null");
		}
		if(canEdit(item)){
			System.out.println(selectedItem.getText());
			Text text=CreateText(tree);
			editor.setEditor(text, item);  
            text.setText(selectedItem.getText());  
            text.selectAll();  
            text.forceFocus(); 
            isEditing=true;
	        text.setVisible(true);  
            
		}
	}
	

	public void contentCreate(){
		
//
		TreeItem trtmCodeReview = new TreeItem(trtmBuiltin, SWT.NONE);
		trtmCodeReview.setImage(SWTResourceManager.getImage(Const.FOLDER_ICON_PATH));
		trtmCodeReview.setText("Code Review");

		TreeItem trtmPostcommit = new TreeItem(trtmCodeReview, SWT.NONE);
		trtmPostcommit.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmPostcommit.setText("Post-Commit");

		TreeItem trtmPrecommit = new TreeItem(trtmCodeReview, SWT.NONE);
		trtmPrecommit.setText("Pre-Commit");
		trtmPrecommit.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));

		trtmCodeReview.setExpanded(true);

		TreeItem trtmParasoftsAep = new TreeItem(trtmBuiltin, SWT.NONE);
		trtmParasoftsAep.setImage(SWTResourceManager.getImage(Const.FOLDER_ICON_PATH));
		trtmParasoftsAep.setText("Parasoft's AEP");

		TreeItem trtmPhaseI = new TreeItem(trtmParasoftsAep, SWT.NONE);
		trtmPhaseI.setImage(SWTResourceManager.getImage(Const.FOLDER_ICON_PATH));
		trtmPhaseI.setText("Phase I");

		TreeItem trtmBuildMachineNightlyStatic = new TreeItem(trtmPhaseI, SWT.NONE);
		trtmBuildMachineNightlyStatic.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmBuildMachineNightlyStatic.setText("Build Machine Nightly (static)");

		TreeItem trtmDeveloperstatic = new TreeItem(trtmPhaseI, SWT.NONE);
		trtmDeveloperstatic.setText("Developer (static)");
		trtmDeveloperstatic.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmPhaseI.setExpanded(true);

		TreeItem trtmPhaseIi = new TreeItem(trtmParasoftsAep, SWT.NONE);
		trtmPhaseIi.setImage(SWTResourceManager.getImage(Const.FOLDER_ICON_PATH));
		trtmPhaseIi.setText("Phase II");

		TreeItem trtmBuildMachineNightlySGE = new TreeItem(trtmPhaseIi, SWT.NONE);
		trtmBuildMachineNightlySGE.setText("Build Machine Nightly (static+generation+execution)");
		trtmBuildMachineNightlySGE.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmBuildMachineNightlySGE.setExpanded(true);

		TreeItem trtmDeveloperstaticexecution = new TreeItem(trtmPhaseIi, SWT.NONE);
		trtmDeveloperstaticexecution.setText("Developer (static+execution)");
		trtmDeveloperstaticexecution.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmPhaseIi.setExpanded(true);

		TreeItem trtmCriticalRulesmust = new TreeItem(trtmParasoftsAep, SWT.NONE);
		trtmCriticalRulesmust.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmCriticalRulesmust.setText("Critical Rules (must have)");

		TreeItem trtmRecommendedConfiguration = new TreeItem(trtmParasoftsAep, SWT.NONE);
		trtmRecommendedConfiguration.setText("Recommended Configuration");
		trtmRecommendedConfiguration.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));

		TreeItem trtmRecommendedRulesshould = new TreeItem(trtmParasoftsAep, SWT.NONE);
		trtmRecommendedRulesshould.setText("Recommended Rules (should have)");
		trtmRecommendedRulesshould.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));

		TreeItem trtmSupplementalRulesnice = new TreeItem(trtmParasoftsAep, SWT.NONE);
		trtmSupplementalRulesnice.setText("Supplemental Rules (nice to have)");
		trtmSupplementalRulesnice.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmParasoftsAep.setExpanded(true);

		TreeItem trtmScopeExamples = new TreeItem(trtmBuiltin, SWT.NONE);
		trtmScopeExamples.setImage(SWTResourceManager.getImage(Const.FOLDER_ICON_PATH));
		trtmScopeExamples.setText("Scope Examples");

		TreeItem trtmTestAllFiles = new TreeItem(trtmScopeExamples, SWT.NONE);
		trtmTestAllFiles.setText("Test All Files");
		trtmTestAllFiles.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));

		TreeItem trtmTestLocallyModified = new TreeItem(trtmScopeExamples, SWT.NONE);
		trtmTestLocallyModified.setText("Test Locally Modified");
		trtmTestLocallyModified.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));

		TreeItem trtmTestModifiedSince = new TreeItem(trtmScopeExamples, SWT.NONE);
		trtmTestModifiedSince.setText("Test Modified Since Installation");
		trtmTestModifiedSince.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmScopeExamples.setExpanded(true);

		TreeItem trtmSecurity = new TreeItem(trtmBuiltin, SWT.NONE);
		trtmSecurity.setImage(SWTResourceManager.getImage(Const.FOLDER_ICON_PATH));
		trtmSecurity.setText("Security");

		TreeItem trtmCwesansTop = new TreeItem(trtmSecurity, SWT.NONE);
		trtmCwesansTop.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmCwesansTop.setText("CWE-SANS Top 25 Most Dangerous Programming Errors");

		TreeItem trtmCigitalJavaSecurity = new TreeItem(trtmSecurity, SWT.NONE);
		trtmCigitalJavaSecurity.setText("Cigital Java Security Rule Pack");
		trtmCigitalJavaSecurity.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
//
		TreeItem trtmOwaspTop = new TreeItem(trtmSecurity, SWT.NONE);
		trtmOwaspTop.setText("OWASP Top 10 Security Vulnerabilities (Server Configuration)");
		trtmOwaspTop.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));

		TreeItem trtmPciData = new TreeItem(trtmSecurity, SWT.NONE);
		trtmPciData.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmPciData.setText("PCI Data Security Standard (Server Configuration)");

		TreeItem trtmSecurityPriority_1 = new TreeItem(trtmSecurity, SWT.NONE);
		trtmSecurityPriority_1.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmSecurityPriority_1.setText("Security - Priority 1 - Must Have");

		TreeItem trtmSecurityPriority_2 = new TreeItem(trtmSecurity, SWT.NONE);
		trtmSecurityPriority_2.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmSecurityPriority_2.setText("Security - Priority 2 - Should Have");

		TreeItem trtmSecurityPriority_3 = new TreeItem(trtmSecurity, SWT.NONE);
		trtmSecurityPriority_3.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmSecurityPriority_3.setText("Security - Priority 3 - Nice to Have");

		TreeItem trtmSecurityAssessmentserver = new TreeItem(trtmSecurity, SWT.NONE);
		trtmSecurityAssessmentserver.setText("Security Assessment (Server Configuration)");
		trtmSecurityAssessmentserver.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmSecurity.setExpanded(true);

		TreeItem trtmStaticAnalysis = new TreeItem(trtmBuiltin, SWT.NONE);
		trtmStaticAnalysis.setImage(SWTResourceManager.getImage(Const.FOLDER_ICON_PATH));
		trtmStaticAnalysis.setText("Static Analysis");

		TreeItem trtmCodeConventionsFor = new TreeItem(trtmStaticAnalysis, SWT.NONE);
		trtmCodeConventionsFor.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmCodeConventionsFor.setText("Code Conventions for the JavaTM Programming Language by Sun");

		TreeItem trtmCodeMellstdd = new TreeItem(trtmStaticAnalysis, SWT.NONE);
		trtmCodeMellstdd.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmCodeMellstdd.setText("Code Smells (TDD)");

		TreeItem trtmCoreJeePatterns = new TreeItem(trtmStaticAnalysis, SWT.NONE);
		trtmCoreJeePatterns.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmCoreJeePatterns.setText("Core J2EE Patterns by Alur, Cupri and Malks");

		TreeItem trtmEffectiveJavaBy = new TreeItem(trtmStaticAnalysis, SWT.NONE);
		trtmEffectiveJavaBy.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmEffectiveJavaBy.setText("Effective Java by Joshua Bloch");

		TreeItem trtmElementsOfJava = new TreeItem(trtmStaticAnalysis, SWT.NONE);
		trtmElementsOfJava.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmElementsOfJava.setText("Elements of Java Style by Scott Ambler");

		TreeItem trtmFindDuplicatedCode = new TreeItem(trtmStaticAnalysis, SWT.NONE);
		trtmFindDuplicatedCode.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmFindDuplicatedCode.setText("Find Duplicated Code");

		TreeItem trtmFindMemoryProblems = new TreeItem(trtmStaticAnalysis, SWT.NONE);
		trtmFindMemoryProblems.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmFindMemoryProblems.setText("Find Memory Problems");

		TreeItem trtmFindUnusedCode = new TreeItem(trtmStaticAnalysis, SWT.NONE);
		trtmFindUnusedCode.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmFindUnusedCode.setText("Find Unused Code");

		// #@# this metion jtest
		TreeItem trtmNewRulesIn84 = new TreeItem(trtmStaticAnalysis, SWT.NONE);
		trtmNewRulesIn84.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmNewRulesIn84.setText("New Rules in Jtest 8.4 (to be modified)");
		// #@# this metion jtest
		TreeItem trtmNewRulesIn8X = new TreeItem(trtmStaticAnalysis, SWT.NONE);
		trtmNewRulesIn8X.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmNewRulesIn8X.setText("New Rules in Jtest 8.x (to be modified)");
		trtmNewRulesIn8X.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		// #@# this metion jtest
		TreeItem trtmParasoftsRecommendedRules = new TreeItem(trtmStaticAnalysis, SWT.NONE);
		trtmParasoftsRecommendedRules.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmParasoftsRecommendedRules.setText("Parasoft's Recommended Rules (to be modified)");

		TreeItem trtmRulesForNew = new TreeItem(trtmStaticAnalysis, SWT.NONE);
		trtmRulesForNew.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmRulesForNew.setText("Rules for New Features in JDK 1.5 (to be modified)");

		TreeItem trtmTestHibernateCode = new TreeItem(trtmStaticAnalysis, SWT.NONE);
		trtmTestHibernateCode.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmTestHibernateCode.setText("Test Hibernate Code");
		
		TreeItem trtmThreadFeProgramming = new TreeItem(trtmBuiltin, SWT.NONE);
		trtmThreadFeProgramming.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmThreadFeProgramming.setText("Thread Safe Programming");
		TreeItem trtmCodeSmellstdd = new TreeItem(trtmBuiltin, SWT.NONE);
		trtmCodeSmellstdd.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmCodeSmellstdd.setText("Code Smells (TDD Standards)");
		
		TreeItem trtmDemoConfiguration = new TreeItem(trtmUser, SWT.NONE);
		trtmDemoConfiguration.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmDemoConfiguration.setText("Demo Configuration");
		
		TreeItem trtmRunStaticAnalysisAndTests = new TreeItem(trtmBuiltin, SWT.NONE);
		trtmRunStaticAnalysisAndTests.setImage(SWTResourceManager.getImage(Const.HYPERCUBE_ICON_PATH));
		trtmRunStaticAnalysisAndTests.setText("Run Static Analysis and Unit Tests");

	}
	public  void initMenu(MouseEvent evt) {
		TreeItem selectedItem =  ((Tree)(evt.getSource())).getSelection()[0];
		//只有userDefined和team及其子节点才可以弹出菜单
		boolean canShowMenu=selectedItem.getText().equals(userDefined)||
				selectedItem.getText().equals(team)||
				selectedItem.getParentItem()==null||
				selectedItem.getParentItem().getText().equals(userDefined)||
				selectedItem.getParentItem().getText().equals(team);
		if(canShowMenu){
			initializeMenu();
		}
		else{
			if(evt.button==3){
				tree.setMenu(null);
			}
		}
	}
	
	/**
	 * 初始化菜单
	 */
	private void initializeMenu()  {
		MenuManager mgr = new MenuManager();
		for(int i=0;i<actions.length;i++){
			mgr.add(actions[i]);
		}
		Menu menu = mgr.createContextMenu(tree);
		tree.setMenu(menu);
	}

	/**
	 * buid tree from a existing configFile
	 * 
	 * @param filePath
	 */
	private void constructTreeFromConfigFile(String filePath) {
		// ������ȡconfig����ʵ�������Ӧ��ͼ�꣬������Ӧ�Ĳ˵���ע���¼���

	}

	/**
	 * add one tree item to a specified tree item
	 * 
	 * @param parent
	 *            the tree-item that new item attached
	 * @param name
	 *            new item's name
	 * @param expandable
	 *            tree:the new item can be attached by another item
	 */
	public void addTreeItem(TreeItem parent, String name, boolean expandable) {
		TreeItem newItem = new TreeItem(parent, SWT.NONE);
		String imagePath;
		if (expandable) {
			imagePath = "";
		} else {
			imagePath = "";
		}
		newItem.setImage(SWTResourceManager.getImage(Const.FOLDER_ICON_PATH));
		newItem.setText(name);
	}

	private void addNode(Document configList, String configFileRootPath, String configName) {

	}

}
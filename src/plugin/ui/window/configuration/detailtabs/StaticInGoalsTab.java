package plugin.ui.window.configuration.detailtabs;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import plugin.ui.window.configuration.entity.GoalEntity;
import plugin.ui.window.configuration.entity.StaticGoalEntity;

public class StaticInGoalsTab {
	TabItem tabItem;
	private Text text_numberOfTasks;
	private Text text_maxTask;
	private DateTime dateTimeBy;
	public Button btnPerformAllTasks;
	public Button btnNotPerformAllTasks;
	public Button btnNoMoreThan;
	public Button btnMaxTaskNumberButton;
	

	public StaticInGoalsTab(TabFolder tabFolder,StaticGoalEntity entity) {
		tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Static");

		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tabItem.setControl(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		Composite compositeInScrolledComposite = new Composite(scrolledComposite, SWT.NONE);
		compositeInScrolledComposite.setLayout(new FormLayout());

		Group grpStatic = new Group(compositeInScrolledComposite, SWT.NONE);
		grpStatic.setText("Static");
		grpStatic.setLayout(new FormLayout());
		FormData fd_grpStatic = new FormData();
		fd_grpStatic.right = new FormAttachment(100, -5);
		fd_grpStatic.top = new FormAttachment(0, 10);
		fd_grpStatic.left = new FormAttachment(0, 5);
		grpStatic.setLayoutData(fd_grpStatic);

		btnPerformAllTasks = new Button(grpStatic, SWT.RADIO);
		FormData fd_btnPerformAllTasks = new FormData();
		fd_btnPerformAllTasks.left = new FormAttachment(0, 5);
		btnPerformAllTasks.setLayoutData(fd_btnPerformAllTasks);
		btnPerformAllTasks.setText("Perform all tasks");
		
		btnNotPerformAllTasks = new Button(grpStatic, SWT.RADIO);
		FormData fd_btnRadioButton = new FormData();
		fd_btnRadioButton.top = new FormAttachment(btnPerformAllTasks, 10, SWT.BOTTOM);
		fd_btnRadioButton.left = new FormAttachment(btnPerformAllTasks, 0, SWT.LEFT);
		btnNotPerformAllTasks.setLayoutData(fd_btnRadioButton);
		btnNotPerformAllTasks.setText("Don't perform tasks");

		btnNoMoreThan = new Button(grpStatic, SWT.RADIO);
		FormData fd_btnNoMoreThan = new FormData();
		fd_btnNoMoreThan.top = new FormAttachment(btnNotPerformAllTasks, 10, SWT.BOTTOM);
		fd_btnNoMoreThan.left = new FormAttachment(btnNotPerformAllTasks, 0, SWT.LEFT);
		btnNoMoreThan.setLayoutData(fd_btnNoMoreThan);
		btnNoMoreThan.setText("No more than");
		btnNoMoreThan.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				text_numberOfTasks.setEnabled(btnNoMoreThan.getSelection());
				dateTimeBy.setEnabled(btnNoMoreThan.getSelection());
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		text_numberOfTasks = new Text(grpStatic, SWT.BORDER);
		FormData fd_text_numberOfTasks = new FormData();
		fd_text_numberOfTasks.left = new FormAttachment(btnNoMoreThan, 5, SWT.RIGHT);
		fd_text_numberOfTasks.bottom = new FormAttachment(btnNoMoreThan, 0, SWT.BOTTOM);
		fd_text_numberOfTasks.width = 50;
		text_numberOfTasks.setLayoutData(fd_text_numberOfTasks);

		Label lblTasksPerDeveloper = new Label(grpStatic, SWT.NONE);
		FormData fd_lblTasksPerDeveloper = new FormData();
		fd_lblTasksPerDeveloper.left = new FormAttachment(text_numberOfTasks, 5, SWT.RIGHT);
		fd_lblTasksPerDeveloper.bottom = new FormAttachment(text_numberOfTasks, 0, SWT.BOTTOM);
		lblTasksPerDeveloper.setLayoutData(fd_lblTasksPerDeveloper);
		lblTasksPerDeveloper.setText("tasks per developer by: ");

		dateTimeBy = new DateTime(grpStatic, SWT.BORDER);
		FormData fd_dateTimeBy = new FormData();
		fd_dateTimeBy.left = new FormAttachment(lblTasksPerDeveloper, 5, SWT.RIGHT);
		fd_dateTimeBy.bottom = new FormAttachment(lblTasksPerDeveloper, 0, SWT.BOTTOM);
		dateTimeBy.setLayoutData(fd_dateTimeBy);

		btnMaxTaskNumberButton = new Button(grpStatic, SWT.CHECK);
		btnMaxTaskNumberButton.setText("Max tasks to recommend:");
		FormData fd_btnMaxTaskNumberButton = new FormData();
		fd_btnMaxTaskNumberButton.left = new FormAttachment(btnNoMoreThan, 0, SWT.LEFT);
		fd_btnMaxTaskNumberButton.top = new FormAttachment(btnNoMoreThan, 10, SWT.BOTTOM);
		btnMaxTaskNumberButton.setLayoutData(fd_btnMaxTaskNumberButton);
		btnMaxTaskNumberButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				text_maxTask.setEnabled(btnMaxTaskNumberButton.getSelection());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		text_maxTask = new Text(grpStatic, SWT.BORDER);
		FormData fd_text_maxTask = new FormData();
		fd_text_maxTask.left = new FormAttachment(btnMaxTaskNumberButton, 5, SWT.RIGHT);
		fd_text_maxTask.bottom = new FormAttachment(btnMaxTaskNumberButton, 0, SWT.BOTTOM);
		fd_text_maxTask.width = 50;
		text_maxTask.setLayoutData(fd_text_maxTask);
		
//		Group staticGroup = new Group(compositeInScrolledComposite, SWT.None);
//		staticGroup.setText("Static");
//		staticGroup.setLayout(new FormLayout());
//
//		Group grpStatic = new Group(compositeInScrolledComposite, SWT.NONE);
//		grpStatic.setText("Static");
//		grpStatic.setLayout(new FormLayout());
//		FormData fd_grpStatic = new FormData();
//		fd_grpStatic.right = new FormAttachment(100, -5);
//		fd_grpStatic.top = new FormAttachment(0, 10);
//		fd_grpStatic.left = new FormAttachment(0, 5);
//		grpStatic.setLayoutData(fd_grpStatic);
//
//		Button btnPerformAllTasks = new Button(grpStatic, SWT.RADIO);
//		FormData fd_btnPerformAllTasks = new FormData();
//		fd_btnPerformAllTasks.left = new FormAttachment(0, 5);
//		btnPerformAllTasks.setLayoutData(fd_btnPerformAllTasks);
//		btnPerformAllTasks.setText("Perform all tasks");
//
//		Button btnRadioButton = new Button(grpStatic, SWT.RADIO);
//		FormData fd_btnRadioButton = new FormData();
//		fd_btnRadioButton.top = new FormAttachment(btnPerformAllTasks, 10, SWT.BOTTOM);
//		fd_btnRadioButton.left = new FormAttachment(btnPerformAllTasks, 0, SWT.LEFT);
//		btnRadioButton.setLayoutData(fd_btnRadioButton);
//		btnRadioButton.setText("Don't perform tasks");
//
//		Button btnNoMoreThan = new Button(grpStatic, SWT.RADIO);
//		FormData fd_btnNoMoreThan = new FormData();
//		fd_btnNoMoreThan.top = new FormAttachment(btnRadioButton, 10, SWT.BOTTOM);
//		fd_btnNoMoreThan.left = new FormAttachment(btnRadioButton, 0, SWT.LEFT);
//		btnNoMoreThan.setLayoutData(fd_btnNoMoreThan);
//		btnNoMoreThan.setText("No more than");
//
//		Text text_numberOfTasks = new Text(grpStatic, SWT.BORDER);
//		FormData fd_text_numberOfTasks = new FormData();
//		fd_text_numberOfTasks.left = new FormAttachment(btnNoMoreThan, 5, SWT.RIGHT);
//		fd_text_numberOfTasks.bottom = new FormAttachment(btnNoMoreThan, 0, SWT.BOTTOM);
//		fd_text_numberOfTasks.width = 50;
//		text_numberOfTasks.setLayoutData(fd_text_numberOfTasks);
//
//		Label lblTasksPerDeveloper = new Label(grpStatic, SWT.NONE);
//		FormData fd_lblTasksPerDeveloper = new FormData();
//		fd_lblTasksPerDeveloper.left = new FormAttachment(text_numberOfTasks, 5, SWT.RIGHT);
//		fd_lblTasksPerDeveloper.bottom = new FormAttachment(text_numberOfTasks, 0, SWT.BOTTOM);
//		lblTasksPerDeveloper.setLayoutData(fd_lblTasksPerDeveloper);
//		lblTasksPerDeveloper.setText("tasks per developer by: ");
//
//		DateTime dateTimeBy = new DateTime(grpStatic, SWT.BORDER);
//		FormData fd_dateTimeBy = new FormData();
//		fd_dateTimeBy.left = new FormAttachment(lblTasksPerDeveloper, 5, SWT.RIGHT);
//		fd_dateTimeBy.bottom = new FormAttachment(lblTasksPerDeveloper, 0, SWT.BOTTOM);
//		dateTimeBy.setLayoutData(fd_dateTimeBy);
//
//		Button btnMaxTaskNumberButton = new Button(grpStatic, SWT.CHECK);
//		btnMaxTaskNumberButton.setText("Max tasks to recommend:");
//		FormData fd_btnMaxTaskNumberButton = new FormData();
//		fd_btnMaxTaskNumberButton.left = new FormAttachment(btnNoMoreThan, 0, SWT.LEFT);
//		fd_btnMaxTaskNumberButton.top = new FormAttachment(btnNoMoreThan, 10, SWT.BOTTOM);
//		btnMaxTaskNumberButton.setLayoutData(fd_btnMaxTaskNumberButton);
//
//		Text text_maxTask = new Text(grpStatic, SWT.BORDER);
//		FormData fd_text_maxTask = new FormData();
//		fd_text_maxTask.left = new FormAttachment(btnMaxTaskNumberButton, 5, SWT.RIGHT);
//		fd_text_maxTask.bottom = new FormAttachment(btnMaxTaskNumberButton, 0, SWT.BOTTOM);
//		fd_text_maxTask.width = 50;
//		text_maxTask.setLayoutData(fd_text_maxTask);


		scrolledComposite.setContent(compositeInScrolledComposite);
		scrolledComposite.setMinSize(compositeInScrolledComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		staticInGoInit(entity);
	}
	
	/**
	 * staticInGo
	 */

//	private Text text_numberOfTasks;
//	private Text text_maxTask;
//	private DateTime dateTimeBy;
//	public Button btnPerformAllTasks;
//	public Button btnNotPerformAllTasks;
//	public Button btnNoMoreThan;
//	public Button btnMaxTaskNumbe;
	public void staticInGoInit(StaticGoalEntity entity){
		if(entity==null){
			//btnNoMoreThan.setEnabled(false);
			//btnMaxTaskNumberButton.setEnabled(false);
			text_numberOfTasks.setEnabled(false);
			text_maxTask.setEnabled(false);
			dateTimeBy.setEnabled(false);
			return;
		   }
		if(entity.performTasks==1){
		    btnPerformAllTasks.setSelection(true);
		  }
        if(entity.performTasks==2){
            btnNotPerformAllTasks.setSelection(true);
		  }
		if(entity.performTasks==3){
			btnNoMoreThan.setSelection(true);
			text_numberOfTasks.setEnabled(true);
			text_numberOfTasks.setText(String.valueOf(entity.developerTasks));
			dateTimeBy.setEnabled(true);
			dateTimeBy.setYear(entity.startDate.getYear());
			dateTimeBy.setMonth(entity.startDate.getMonth());
			dateTimeBy.setDay(entity.startDate.getDay()); 
		}else{
			text_numberOfTasks.setEnabled(false);
			dateTimeBy.setEnabled(false);
		}
		if(entity.isMaxRecommandTasks){
		    btnMaxTaskNumberButton.setSelection(true);
		    text_maxTask.setEnabled(true);
			text_maxTask.setText(String.valueOf(entity.maxRecommandTasks));
		}else{
			btnMaxTaskNumberButton.setSelection(false);
		    text_maxTask.setEnabled(false);
		}
	}

	
	/**
	 * 获取Static4Goal选项
	 * @return
	 */
	public StaticGoalEntity getStatic4Goal(){
		StaticGoalEntity static4Goal= new StaticGoalEntity();
		if(btnPerformAllTasks.getSelection()){
			static4Goal.performTasks = 1;
		}
		if(btnNotPerformAllTasks.getSelection()){
			static4Goal.performTasks =2;
		}
		if(btnNoMoreThan.getSelection()){
			static4Goal.performTasks =3;
			static4Goal.developerTasks = Integer.parseInt(text_numberOfTasks.getText());
			static4Goal.startDate = new Date(dateTimeBy.getYear(),dateTimeBy.getMonth(),dateTimeBy.getDay());
			//timeFilter.setStartDate(new Date(sinceDateTime.getYear(), sinceDateTime.getMonth(), sinceDateTime.getDay()));
		}
		if(btnMaxTaskNumberButton.getSelection()){
			static4Goal.isMaxRecommandTasks = true;
			static4Goal.maxRecommandTasks = Integer.parseInt(text_maxTask.getText());
		}
		return static4Goal;
		
	}
}

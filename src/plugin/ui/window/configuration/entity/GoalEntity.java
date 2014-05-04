package plugin.ui.window.configuration.entity;

import plugin.ui.window.configuration.detailtabs.Static4GoalEntity;

public class GoalEntity {
	/**
	 * 静态
	 */
//	public GoalItemEntity staticItem;
//	
//	public GoalItemEntity fixUnitTestProblems;
//	
//	public GoalItemEntity reviewUnverifiedUnitTestException;
//	
//	public GoalItemEntity reviewUnverifyOutcomes;
	public Static4GoalEntity static4Goal;
	public Execute4Goal execute4Goal;
	public GoalEntity(){
		static4Goal=new Static4GoalEntity();
		execute4Goal=new Execute4Goal();
	}
	
}

package plugin.ui.window.configuration.entity;

import java.util.Date;

public class GoalItemEntity {
	//任务类型1=执行所有任务，2=不执行任务，不超过
	private int taskType;
	//不超过的任务数
	private int maxTaskCount;
	//截至日期
	private Date deadline;
	//推荐任务的最大值
	private int maxTaskCountRecommend;
}

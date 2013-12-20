package plugin.ui.window.configuration.entity;
/**
 * 评审
 * @author wlj
 *
 */
public class CodeReviewEntity {
	//是否启用代码评审
	private boolean isEnabled;
	//是否生成全面报告
	private boolean isGenerateAllReprot;
	//是否自动发布审查
	private boolean isAutoPublishReview;
	//作者
	private Author4CodeReviewEntity[] authors;
	//审查者
	private Reviewer4CodeReviewEntity[] reviewers;
	//监视者
	private Monitor4CodeReview[] monitors;
	//过滤器
	private Filter4CodeReviewEntity filters;
}

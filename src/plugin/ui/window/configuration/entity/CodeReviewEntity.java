package plugin.ui.window.configuration.entity;
/**
 * 评审
 * @author wlj
 *
 */
public class CodeReviewEntity {
	//是否启用代码评审
	public boolean isEnabled;
	//是否生成全面报告
	public boolean isGenerateAllReport;
	public boolean isUseUniqueUserHost;
	//是否自动发布审查
	public boolean isAutoPublishReview;
	public String identifier;
	//作者
	public Author4CodeReviewEntity[] authors;
	//审查者
	public Reviewer4CodeReviewEntity[] reviewers;
	//监视者
	public Monitor4CodeReviewEntity[] monitors;
	//过滤器
	public Filter4CodeReviewEntity filters;
}

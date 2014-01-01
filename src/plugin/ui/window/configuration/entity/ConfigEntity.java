package plugin.ui.window.configuration.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 配置实体类
 * @author wlj
 *
 */
@XmlRootElement
public class ConfigEntity {
	public String name;
	public ScopeEntity scope;
	public StaticEntity staticEntity;
	public GenerationEntity generation;
	public ExecutionEntity execution;
	public CommonEntity common;
	public CodeReviewEntity codeReview;
	public GoalEntity goal;
}

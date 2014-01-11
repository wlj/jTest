package plugin.ui.window.configuration.entity;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.swt.internal.ole.win32.GUID;

/**
 * 配置实体类
 * @author wlj
 *
 */
@XmlRootElement
public class ConfigEntity {
	public UUID id;
	public String name;
	public ConfigCategoryEnum configCategory;
	public ScopeEntity scope;
	public StaticEntity staticEntity;
	public GenerationEntity generation;
	public ExecutionEntity execution;
	public CommonEntity common;
	public CodeReviewEntity codeReview;
	public GoalEntity goal;
}

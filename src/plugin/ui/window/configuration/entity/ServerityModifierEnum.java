package plugin.ui.window.configuration.entity;
/**
 * 改变严重等级枚举
 * @author wlj
 *
 */
public enum ServerityModifierEnum {
	/**
	 * 总是报告严重等级为1
	 */
	AlwaysAs1,
	/**
	 * 增加严重等级为4
	 */
	IncreaseTo4,
	/**
	 * 增加严重等级为3
	 */
	IncreaseTo3,
	/**
	 * 增加严重等级为2
	 */
	IncreaseTo2,
	/**
	 * 增加严重等级为1
	 */
	IncreaseTo1,
	/**
	 * 无变化
	 */
	NoChange,
	/**
	 * 减少严重等级为1
	 */
	DecreaseTo1,
	/**
	 * 减少严重等级为2
	 */
	DecreaseTo2,
	/**
	 * 减少严重等级为3
	 */
	DecreaseTo3,
	/**
	 * 减少严重等级为4
	 */
	DecreaseTo4,
	/**
	 * 抑制等级
	 */
	Inhibition
}

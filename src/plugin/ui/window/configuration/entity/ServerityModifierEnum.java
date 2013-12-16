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
	IncreaseTo3,
	IncreaseTo2,
	IncreaseTo1,
	NoChange,
	DecreaseTo1,
	DecreaseTo2,
	DecreaseTo3,
	DecreaseTo4,
	Inhibition
}

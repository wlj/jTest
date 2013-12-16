package plugin.ui.window.configuration.entity;
/**
 * 初始严重等级
 * @author wlj
 *
 */
public class InitSverityLevelEntity {
	//断言失败
		private SeverityLevelEnum assertFaild;
		//配置问题
		private SeverityLevelEnum configurationProblem;
		//DBC违规
		private SeverityLevelEnum dbcViolation;
		//输出
		private SeverityLevelEnum outPut;
		//未捕获的异常
		private SeverityLevelEnum uncaughtException;
		//未捕获的异常的严重等级
		private UncaughtExceptionSeverityLevelEntity[] uncaughtExceptionSeverityLevels;
}

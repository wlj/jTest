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
		public SeverityLevelEnum getAssertFaild() {
			return assertFaild;
		}
		public void setAssertFaild(SeverityLevelEnum assertFaild) {
			this.assertFaild = assertFaild;
		}
		public SeverityLevelEnum getConfigurationProblem() {
			return configurationProblem;
		}
		public void setConfigurationProblem(SeverityLevelEnum configurationProblem) {
			this.configurationProblem = configurationProblem;
		}
		public SeverityLevelEnum getDbcViolation() {
			return dbcViolation;
		}
		public void setDbcViolation(SeverityLevelEnum dbcViolation) {
			this.dbcViolation = dbcViolation;
		}
		public SeverityLevelEnum getOutPut() {
			return outPut;
		}
		public void setOutPut(SeverityLevelEnum outPut) {
			this.outPut = outPut;
		}
		public SeverityLevelEnum getUncaughtException() {
			return uncaughtException;
		}
		public void setUncaughtException(SeverityLevelEnum uncaughtException) {
			this.uncaughtException = uncaughtException;
		}
		public UncaughtExceptionSeverityLevelEntity[] getUncaughtExceptionSeverityLevels() {
			return uncaughtExceptionSeverityLevels;
		}
		public void setUncaughtExceptionSeverityLevels(
				UncaughtExceptionSeverityLevelEntity[] uncaughtExceptionSeverityLevels) {
			this.uncaughtExceptionSeverityLevels = uncaughtExceptionSeverityLevels;
		}
}

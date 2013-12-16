package plugin.ui.window.configuration.entity;
/**
 * 严重等级
 * @author wlj
 *
 */
public class SeverityLevelEntity {
	//严重程度
	private SeverityLevelEnum severityLevel;
	//初始严重等级
	//初始严重等级
		private InitSverityLevelEntity initSverityLevel;
		//BugDetective的运行时异常验证
		private ServerityModifierEnum bugDetective;
		private ServerityModifierEnum testCaseUserDefine;
		private ServerityModifierEnum throwsDeclare;
		//灵敏方法名
		private String[] methodNames;
		public SeverityLevelEnum getSeverityLevel() {
			return severityLevel;
		}
		public void setSeverityLevel(SeverityLevelEnum severityLevel) {
			this.severityLevel = severityLevel;
		}
		public InitSverityLevelEntity getInitSverityLevel() {
			return initSverityLevel;
		}
		public void setInitSverityLevel(InitSverityLevelEntity initSverityLevel) {
			this.initSverityLevel = initSverityLevel;
		}
		public ServerityModifierEnum getBugDetective() {
			return bugDetective;
		}
		public void setBugDetective(ServerityModifierEnum bugDetective) {
			this.bugDetective = bugDetective;
		}
		public ServerityModifierEnum getTestCaseUserDefine() {
			return testCaseUserDefine;
		}
		public void setTestCaseUserDefine(ServerityModifierEnum testCaseUserDefine) {
			this.testCaseUserDefine = testCaseUserDefine;
		}
		public ServerityModifierEnum getThrowsDeclare() {
			return throwsDeclare;
		}
		public void setThrowsDeclare(ServerityModifierEnum throwsDeclare) {
			this.throwsDeclare = throwsDeclare;
		}
		public String[] getMethodNames() {
			return methodNames;
		}
		public void setMethodNames(String[] methodNames) {
			this.methodNames = methodNames;
		}
}

package plugin.ui.window.configuration.entity;
/**
 * 生成的过滤项
 * @author wlj
 *
 */
public class Filter4GenerationEntity {
	//只生成可以提高覆盖率的测试用例
	private boolean isOnlyTestCase4HighCoverage;
	//覆盖率方式，分支Or行
	private byte coverageType;
	//生成传递null到方法的测试用例
	private boolean isGenerateNullArgument;
	//是否处理异常
	private boolean isHandlingExceptions;
	//处理异常的方式1=抛出和报告，2=捕获和断言已检查的，3=捕获和断言全部
	private int handlingExceptionType;
	//是否生成可以引发超时的测试用例
	private boolean isGenerateTimeOutTestCase;
	//生成测试用例的访问级别-公开
	private boolean isPublic;
	//生成测试用例的访问级别-受保护的
	private boolean isProtect;
	//生成测试用例的访问级别-包内私有的
	private boolean isInternal;
	public boolean isOnlyTestCase4HighCoverage() {
		return isOnlyTestCase4HighCoverage;
	}
	public void setOnlyTestCase4HighCoverage(boolean isOnlyTestCase4HighCoverage) {
		this.isOnlyTestCase4HighCoverage = isOnlyTestCase4HighCoverage;
	}
	public byte getCoverageType() {
		return coverageType;
	}
	public void setCoverageType(byte coverageType) {
		this.coverageType = coverageType;
	}
	public boolean isGenerateNullArgument() {
		return isGenerateNullArgument;
	}
	public void setGenerateNullArgument(boolean isGenerateNullArgument) {
		this.isGenerateNullArgument = isGenerateNullArgument;
	}
	public boolean isHandlingExceptions() {
		return isHandlingExceptions;
	}
	public void setHandlingExceptions(boolean isHandlingExceptions) {
		this.isHandlingExceptions = isHandlingExceptions;
	}
	public int getHandlingExceptionType() {
		return handlingExceptionType;
	}
	public void setHandlingExceptionType(int handlingExceptionType) {
		this.handlingExceptionType = handlingExceptionType;
	}
	public boolean isGenerateTimeOutTestCase() {
		return isGenerateTimeOutTestCase;
	}
	public void setGenerateTimeOutTestCase(boolean isGenerateTimeOutTestCase) {
		this.isGenerateTimeOutTestCase = isGenerateTimeOutTestCase;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	public boolean isProtect() {
		return isProtect;
	}
	public void setProtect(boolean isProtect) {
		this.isProtect = isProtect;
	}
	public boolean isInternal() {
		return isInternal;
	}
	public void setInternal(boolean isInternal) {
		this.isInternal = isInternal;
	}
	public boolean isPrivate() {
		return isPrivate;
	}
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}
	//生成测试用例的访问级别-私用的
	private boolean isPrivate;
	
}

package plugin.ui.window.configuration.entity;
/**
 * 生成的过滤项
 * @author wlj
 *
 */
public class Filter4GenerationEntity {
	//只生成可以提高覆盖率的测试用例
	public boolean isOnlyTestCase4HighCoverage;
	//覆盖率方式，分支Or行
	public CoverageTypeEnum coverageType;
	//生成传递null到方法的测试用例
	public boolean isGenerateNullArgument;
	//是否处理异常
	public boolean isHandlingExceptions;
	//处理异常的方式1=抛出和报告，2=捕获和断言已检查的，3=捕获和断言全部
	public HandlingExceptionTypeEnum handlingExceptionType;
	//是否生成可以引发超时的测试用例
	public boolean isGenerateTimeOutTestCase;
	public boolean isGenerateStubs4MethodCallCase;
	public boolean isIncludeComments;
	//生成测试用例的访问级别-公开
	public boolean isPublic;
	//生成测试用例的访问级别-受保护的
	public boolean isProtect;
	//生成测试用例的访问级别-包内私有的
	public boolean isInternal;
	//生成测试用例的访问级别-私用的
	public boolean isPrivate;
	public boolean isWithoutTestClass;
	public boolean isWithOutDateTestClass;
	public boolean isWithUpdateTestClass;
	
	
}

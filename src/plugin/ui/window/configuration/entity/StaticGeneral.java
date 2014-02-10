package plugin.ui.window.configuration.entity;
/**
 * 静态分析的一般设置
 * @author wlj
 *
 */
public class StaticGeneral {
	/**
	 * 是否跳过jsp文件
	 */
	public boolean isSkipJSP;
	/**
	 * 是否排除大文件
	 */
	public boolean isExcludeLargeFile;
	/**
	 * 定义大文件的大小
	 */
	public int largeFileSize;
	/**
	 * 是否检测有编译错误的文件
	 */
	public boolean isCheckFileWithCompileError;
	/**
	 * 是否只报告真正的错误
	 */
	public boolean isOnlyReportError;
	/**
	 * 是否启用用户自定义注释的开始/结束位置
	 */
	public boolean isUseCustomBeginEnd;
	/**
	 * 开始位置的表达式
	 */
	public String customBegin;
	/**
	 * 结束位置的表达式
	 */
	public String customEnd;
	/**
	 * 是否忽略全局规则
	 */
	public boolean isIgnoreGlobalRules;
	/**
	 * 全局检测是否运行包含错误
	 */
	public boolean isAllowCompileError;
	/**
	 * 全局设置：是否包含用户的测试类
	 */
	public boolean isIncludeUserTestClass;
	
	public boolean isIgnoreRepeat;
	
}

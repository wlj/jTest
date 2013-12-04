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
	private boolean isSkipJSP;
	/**
	 * 是否排除大文件
	 */
	private boolean isExcludeLargeFile;
	/**
	 * 定义大文件的大小
	 */
	private int largeFileSize;
	/**
	 * 是否检测有编译错误的文件
	 */
	private boolean isCheckFileWithCompileError;
	/**
	 * 是否只报告真正的错误
	 */
	private boolean isOnlyReportError;
	/**
	 * 是否启用用户自定义注释的开始/结束位置
	 */
	private boolean isUseCustomBeginEnd;
	/**
	 * 开始位置的表达式
	 */
	private String customBegin;
	/**
	 * 结束位置的表达式
	 */
	private String customEnd;
	/**
	 * 是否忽略全局规则
	 */
	private boolean isIgnoreGlobalRules;
	/**
	 * 全局检测是否运行包含错误
	 */
	private boolean isAllowCompileError;
	/**
	 * 全局设置：是否包含用户的测试类
	 */
	private boolean isIncludeUserTestClass;
	
}

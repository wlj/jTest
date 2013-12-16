package plugin.ui.window.configuration.entity;
/**
 * 测试类-生成
 * @author wlj
 *
 */
public class TestCase4GenerationEntity {
	//Junit语法，junit3/juint4
	private byte junitType;
	//是否在timeOut内生成额外的测试用例
	private boolean isNotGenerateOtherTestCase;
	//超时时间
	private int timeOut;
	//是否将添加修改的代码到源码控制
	private boolean isCommitSouceControl;
	//生成测试用例的类型1=添加新的测试用例到现有的测试类，2=替换现有的测试类
	private int generateTestCaseType;
	//输出类德路径
	private String outPutClass;
	//添加文字到新生成的测试方法中
	private boolean isAddTestToJavadoc;
	//要添加的文字
	private String text;
	public byte getJunitType() {
		return junitType;
	}
	public void setJunitType(byte junitType) {
		this.junitType = junitType;
	}
	public boolean isNotGenerateOtherTestCase() {
		return isNotGenerateOtherTestCase;
	}
	public void setNotGenerateOtherTestCase(boolean isNotGenerateOtherTestCase) {
		this.isNotGenerateOtherTestCase = isNotGenerateOtherTestCase;
	}
	public int getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	public boolean isCommitSouceControl() {
		return isCommitSouceControl;
	}
	public void setCommitSouceControl(boolean isCommitSouceControl) {
		this.isCommitSouceControl = isCommitSouceControl;
	}
	public int getGenerateTestCaseType() {
		return generateTestCaseType;
	}
	public void setGenerateTestCaseType(int generateTestCaseType) {
		this.generateTestCaseType = generateTestCaseType;
	}
	public String getOutPutClass() {
		return outPutClass;
	}
	public void setOutPutClass(String outPutClass) {
		this.outPutClass = outPutClass;
	}
	public boolean isAddTestToJavadoc() {
		return isAddTestToJavadoc;
	}
	public void setAddTestToJavadoc(boolean isAddTestToJavadoc) {
		this.isAddTestToJavadoc = isAddTestToJavadoc;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}

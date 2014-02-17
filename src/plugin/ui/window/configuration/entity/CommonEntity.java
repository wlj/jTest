package plugin.ui.window.configuration.entity;

public class CommonEntity {
	public boolean isRefreshProjects;
	public boolean isUpdateProjectsFromSourceControl;
	public boolean isRebuildAllFiles;
	public boolean isIncremental;
	public boolean isEnabledGenerationExecution;
	public boolean isStopTestingOnBuildErrors;
	//1、local Directory 2、Workspace 3、 Use test class project as working directory
	public int workingDirectory;
	public String localDirectory;
	public String workspace;
	public boolean isIsGenerateAndExecuteCatusTests;
	public String generateAndExecuteCatusTests;
	public boolean isRecordTestCoverage;
	public String recordTestCoverage;
	public String vMArguments;
	
	
}

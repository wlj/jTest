package plugin.ui.window.configuration.entity;

public class CommonEntity {
	private boolean refreshProjects;
	private boolean updateProjectsFromSourceControl;
	private boolean rebuildAllFiles;
	private boolean incremental;
	private boolean isEnabledGenerationExecution;
	private boolean stopTestingOnBuildErrors;
	//1、local Directory 2、Workspace 3、 Use test class project as working directory
	private int workingDirectory;
	private String localDirectory;
	private String workspace;
	private boolean isGenerateAndExecuteCatusTests;
	private String generateAndExecuteCatusTests;
	private boolean isRecordTestCoverage;
	private String recordTestCoverage;
	private String vMArguments;
	
	
}

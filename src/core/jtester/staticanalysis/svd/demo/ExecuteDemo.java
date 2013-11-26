package core.jtester.staticanalysis.svd.demo;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import org.omg.CORBA.PRIVATE_MEMBER;

import core.common.cfg.javacfg.JavaControlFlowGraph;
import core.common.cfg.model.BranchNode;
import core.jtester.staticanalysis.svd.execution.Path;
import core.jtester.staticanalysis.svd.execution.PathGenerator;
import core.jtester.staticanalysis.svd.execution.SymbolExecutor;

public class ExecuteDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = System.getProperty("user.dir")+"\\src\\core\\jtester\\staticanalysis\\svd\\test\\ASTViewTest.java";
//		String filePath = System.getProperty("user.dir")+"\\tested_files\\ontology\\People.java";
		System.out.println(filePath);
		JavaControlFlowGraph[] cfgsArray = PathGenerator.read(filePath);
		JavaControlFlowGraph cfgInstance;
		
		LinkedList<Path> executablePaths = new LinkedList<>();
		String methodNameString;
		for (int cfgIndex = 0; cfgIndex < cfgsArray.length; cfgIndex++) {
			methodNameString = cfgsArray[cfgIndex].getSignature();
			System.out.println("Begin to analyse CFG: "+methodNameString);
			// ��ȡ����·��
			cfgInstance = cfgsArray[cfgIndex];
//			LinkedList<Path> pathList = new LinkedList<>();
			Path[] paths = PathGenerator.abstractPath(cfgInstance, 0);
//			Path[] paths1 =  PathGenerator.abstractPath(cfgInstance, 1);
//			Path[] paths2  = PathGenerator.abstractPath(cfgInstance, 2);
//			for (int i = 0; i < paths.length; i++) {
//				pathList.add(paths[i]);
//			}
//			for (int i = 0; i < paths1.length; i++) {
//				pathList.add(paths1[i]);
//			}
//			for (int i = 0; i < paths2.length; i++) {
//				pathList.add(paths2[i]);
//			}
//			pathList.toArray(paths);
			System.out.println("There are "+paths.length+" generated paths"+" for the method "+ methodNameString);
			// ��ӡpathCollection������path��������֧���
			for (int i = 0; i < paths.length; i++) {
				Path tempPath = paths[i];
				System.out.println("For path "+i);
				printDecisionExpressions(tempPath);
			}
			// ������·�����з���ִ��
			Path exePath;
			for (int pathIndex = 0; pathIndex < paths.length; pathIndex++) {
				System.out.println("Begin to symbolic execute path " + pathIndex);
				exePath = paths[pathIndex];
				SymbolExecutor executor = new SymbolExecutor(exePath);
				boolean executable = executor.execute(exePath);
				if (executable) {// TODO:Ϊ�����ɲ������ݡ� 
					executablePaths.add(exePath);  //������ֵΪtrue��·����ӵ���ִ��·���С�
				}
				exePath.getEnv().printValue();
			}
			System.out.println("For the method: " + methodNameString
					+ ", there are " + executablePaths.size()
					+ " executablePath");
		}
	}
		private static void printDecisionExpressions(Path path){
			for (Iterator iterator = path.iterator(); iterator
					.hasNext();) {
				Object block = iterator.next();
				if (block instanceof BranchNode) {
					BranchNode branchNode = (BranchNode)block;
					System.out.println("Expression:"+branchNode.getData()+"\t Label:"+branchNode.getLabel());
				}
			}
		}
		
}

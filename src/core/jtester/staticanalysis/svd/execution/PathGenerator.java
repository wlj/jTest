package core.jtester.staticanalysis.svd.execution;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import core.common.cfg.interfaces.*;
import core.common.cfg.javacfg.*;
import core.common.cfg.model.*;

public class PathGenerator {
	private Path path;
	public static final int limitOfloop = 3;

	public static LinkedList<Path> getPaths(JavaControlFlowGraph cfg) {
		LinkedList<Path> paths = new LinkedList<>();
		// TODO
		return paths;
	}

	public static void main(String[] args) throws IOException{
		String filePath = System.getProperty("user.dir")+"\\src\\core\\jtester\\staticanalysis\\svd\\test\\SVDTest.java";
		System.out.println(filePath);
		JavaControlFlowGraph[] cfgsArray = read(filePath);
		JavaControlFlowGraph cfgInstance;
		for (int i = 0; i < cfgsArray.length; i++) {
			System.out.println("Begin to analyse CFG: "+cfgsArray[i].getSignature());
			// ��ȡ����·��
			cfgInstance = cfgsArray[i];
			Path[] paths = abstractPath(cfgInstance);
			System.out.println(paths.length);
			// ��ӡpath
			for (int j = 0; j < paths.length; j++) {
				System.out.println("Print path��"+ j);
				printPath(paths[j].pathNodes);
			}
		}
	}

	
	public static Path[] abstractPath(JavaControlFlowGraph cfg){
		ArrayList<Path> paths = new ArrayList<>();
		LinkedList<IBasicBlock> path = new LinkedList<>();
		IBasicBlock start = cfg.getStartNode();
		IBasicBlock currentNode = start;
		// �Ը�����cfg����·����ȡ
		System.out.println("Begin path abstraction");
		while(true){
			if (currentNode instanceof PlainNode && !(currentNode instanceof BranchNode)) {
//				System.out.println("PlainNode: " + ((AbstractBasicBlock)currentNode).getData());
				PlainNode tempNode = (PlainNode)currentNode;
				path.add(tempNode);
				currentNode = ((PlainNode) currentNode).getOutgoing();
				continue;
				
			}else if (currentNode instanceof DecisionNode) {// ά��detected��Ϣ
				DecisionNode tempNode = (DecisionNode) currentNode;
				if (tempNode.isDetected() && !hasUpperDecisionNode(path)) {// ������е�decision����̽���꣬��·���������
					System.out.println(cfg.getSignature()+" is manipulated");
					break;
				}else if (tempNode.getType()==DecisionType.switch_type || tempNode.getType()==DecisionType.if_type) {// ���ڷ�ѭ���ڵ�
					if (tempNode.isDetected() && hasUpperDecisionNode(path)) {// ������DecisionNode�ķ�֧�Ѿ���ȫ��̽���꣬����ݵ���һ��DecisionNode
						tempNode.cleanBranch();//�������branchnode ��detected����Ϊfalse
						currentNode = findUpperDecision(path);
					}else if(!tempNode.isDetected()){
						path.add(tempNode);
						currentNode = tempNode.getUndetectedBranch();
					}
					continue;
				}else if (tempNode.getType()==DecisionType.while_type) {
					if (tempNode.isDetected()) {// ������DecisionNode�ķ�֧�Ѿ���ȫ��̽���꣬�������whileѭ������path�еĽڵ�
						ConnectorNode continueConn = (ConnectorNode)tempNode.getContinueConn();
						findFirstConn(continueConn, path);
						if(hasUpperDecisionNode(path)){
							currentNode = findUpperDecision(path);
							tempNode.cleanBranch();
						}else {
							System.out.println(cfg.getSignature()+" is manipulated");
							break;
						}
					}else if(!tempNode.isDetected()){
						path.add(tempNode);
						BranchNode loopBranchNode = tempNode.getLoopBranch();
						if (loopBranchNode.getVisitTime()<limitOfloop) {// ���δ��ѭ���������ƣ������ѭ��
							System.out.println("loop time: " + (loopBranchNode.getVisitTime()));
							currentNode = loopBranchNode;
						}else {// �Ѵ�ѭ�����ƣ����עloop branch Ϊ detected������currentNode����Ϊbreak branch
							currentNode =  tempNode.getBreakBranch();
						}
					}
				}else if (tempNode.getType() == DecisionType.dowhile_type) {

				}else if (tempNode.getType()==DecisionType.for_type) {
					
				}else if (tempNode.getType()==DecisionType.unleagal_type) {
					System.err.println("Unlegal DecisionNode: "+((Expression)tempNode.getData()));
				}
				continue;

			}else if (currentNode instanceof BranchNode) {// must solve BranchNode before PlainNode.
				BranchNode tempNode = (BranchNode)currentNode;
				if (tempNode.isDetected()) {
					currentNode=findUpperDecision(path);
				}else {
					if (tempNode.getLabel().equals(IBranchNode.WHILE_THEN)) {// �����whilethen��֧
						tempNode.increaseVisitTime();
						if (tempNode.getVisitTime() >= limitOfloop) {
							tempNode.setDetected(true);
						}
						
					} else { // ������������͵ķ�֧�������̽�⣬��ӽڵ�
						tempNode.setDetected(true);
					}
					path.add(tempNode);
					currentNode = tempNode.getOutgoing();
				}
				continue;
				
			}else if (currentNode instanceof JumpNode) {// TODO
				JumpNode tempNode = (JumpNode)currentNode;
				path.add(tempNode);
				/*if (tempNode.isBackwardArc()) {// �������ѭ��������ת��
					
				}*/
				currentNode = tempNode.getOutgoing();
				continue;
				
			}else if (currentNode instanceof ConnectorNode) {
				ConnectorNode tempNode = (ConnectorNode)currentNode;
				path.add(currentNode);
				currentNode = tempNode.getOutgoing();
				continue;
				
			}else if (currentNode instanceof StartNode) {
//				System.out.println("if there is a DecisionNode in path when meet a StartNode " + hasUpperDecisionNode(path));
//				System.out.println("currentNode is " + "StartNode");
				StartNode tempNode = (StartNode)currentNode;
				path.add(currentNode);
				currentNode = tempNode.getOutgoing();
				continue;
			}else if (currentNode instanceof ExitNode) {
//				System.out.println("if there is a DecisionNode in path when meet a ExitNode " + hasUpperDecisionNode(path));
				ExitNode tempNode = (ExitNode)currentNode;
				path.add(tempNode);
				LinkedList<IBasicBlock> completePath = (LinkedList<IBasicBlock>)path.clone();
				Path pathFinded = new Path(completePath);
				pathFinded.env = new ProgramEnv();
				paths.add(pathFinded);
				if(!hasUpperDecisionNode(path)){
					break;
				}else {
					currentNode = findUpperDecision(path);
					DecisionNode tempDecisionNode=(DecisionNode)currentNode;
					continue;
				}
				
			}else {
				System.err.println("currentNode is " + "NOT RECOGNIZED");
				break;
			}
		}
		
		// ����·����
		Path[] pathArray = new Path[paths.size()];
		return paths.toArray(pathArray);
	}
	
	
	public static Path[] abstractPath(JavaControlFlowGraph cfg, int loopTimeLimit){
		ArrayList<Path> paths = new ArrayList<>();
		LinkedList<IBasicBlock> path = new LinkedList<>();
		IBasicBlock start = cfg.getStartNode();
		IBasicBlock currentNode = start;
		// �Ը�����cfg����·����ȡ
		System.out.println("Begin path abstraction");
		while(true){
			if (currentNode instanceof PlainNode && !(currentNode instanceof BranchNode)) {
//				System.out.println("PlainNode: " + ((AbstractBasicBlock)currentNode).getData());
				PlainNode tempNode = (PlainNode)currentNode;
				path.add(tempNode);
				currentNode = ((PlainNode) currentNode).getOutgoing();
				continue;
				
			}else if (currentNode instanceof DecisionNode) {// ά��detected��Ϣ
				DecisionNode tempNode = (DecisionNode) currentNode;
				if (tempNode.isDetected() && !hasUpperDecisionNode(path)) {// ������е�decision����̽���꣬��·���������
					System.out.println(cfg.getSignature()+" is manipulated");
					break;
				}else if (tempNode.getType()==DecisionType.switch_type || tempNode.getType()==DecisionType.if_type) {// ���ڷ�ѭ���ڵ�
					if (tempNode.isDetected() && hasUpperDecisionNode(path)) {// ������DecisionNode�ķ�֧�Ѿ���ȫ��̽���꣬����ݵ���һ��DecisionNode
						tempNode.cleanBranch();//�������branchnode ��detected����Ϊfalse
						currentNode = findUpperDecision(path);
					}else if(!tempNode.isDetected()){
						path.add(tempNode);
						currentNode = tempNode.getUndetectedBranch();
					}
					continue;
				}else if (tempNode.getType()==DecisionType.while_type) {
					if (tempNode.isDetected()) {// ������DecisionNode�ķ�֧�Ѿ���ȫ��̽���꣬�������whileѭ������path�еĽڵ�
						ConnectorNode continueConn = (ConnectorNode)tempNode.getContinueConn();
						findFirstConn(continueConn, path);
						if(hasUpperDecisionNode(path)){
							currentNode = findUpperDecision(path);
							tempNode.cleanBranch();
						}else {
							System.out.println(cfg.getSignature()+" is manipulated");
							break;
						}
					}else if(!tempNode.isDetected()){
						path.add(tempNode);
						BranchNode loopBranchNode = tempNode.getLoopBranch();
						if (loopBranchNode.getVisitTime()<loopTimeLimit) {// ���δ��ѭ���������ƣ������ѭ��
							System.out.println("loop time: " + (loopBranchNode.getVisitTime()));
							currentNode = loopBranchNode;
						}else {// �Ѵ�ѭ�����ƣ����עloop branch Ϊ detected������currentNode����Ϊbreak branch
							currentNode =  tempNode.getBreakBranch();
						}
					}
				}else if (tempNode.getType() == DecisionType.dowhile_type) {

				}else if (tempNode.getType()==DecisionType.for_type) {
					
				}else if (tempNode.getType()==DecisionType.unleagal_type) {
					System.err.println("Unlegal DecisionNode: "+((Expression)tempNode.getData()));
				}
				continue;

			}else if (currentNode instanceof BranchNode) {// must solve BranchNode before PlainNode.
				BranchNode tempNode = (BranchNode)currentNode;
				if (tempNode.isDetected()) {
					if (tempNode.getLabel().equals(BranchNode.WHILE_ELSE)) {
						currentNode = findUpperDecision(path);
						currentNode = findUpperDecision(path);
					}
					currentNode=findUpperDecision(path);
				}else {
					if (tempNode.getLabel().equals(IBranchNode.WHILE_THEN)) {// �����whilethen��֧
						tempNode.increaseVisitTime();
						if (tempNode.getVisitTime() >= loopTimeLimit) {
							tempNode.setDetected(true);
						}
						
					} else { // ������������͵ķ�֧�������̽�⣬��ӽڵ�
						tempNode.setDetected(true);
					}
					path.add(tempNode);
					currentNode = tempNode.getOutgoing();
				}
				continue;
				
			}else if (currentNode instanceof JumpNode) {// TODO
				JumpNode tempNode = (JumpNode)currentNode;
				path.add(tempNode);
				/*if (tempNode.isBackwardArc()) {// �������ѭ��������ת��
					
				}*/
				currentNode = tempNode.getOutgoing();
				continue;
				
			}else if (currentNode instanceof ConnectorNode) {
				ConnectorNode tempNode = (ConnectorNode)currentNode;
				path.add(currentNode);
				currentNode = tempNode.getOutgoing();
				continue;
				
			}else if (currentNode instanceof StartNode) {
//				System.out.println("if there is a DecisionNode in path when meet a StartNode " + hasUpperDecisionNode(path));
//				System.out.println("currentNode is " + "StartNode");
				StartNode tempNode = (StartNode)currentNode;
				path.add(currentNode);
				currentNode = tempNode.getOutgoing();
				continue;
			}else if (currentNode instanceof ExitNode) {
//				System.out.println("if there is a DecisionNode in path when meet a ExitNode " + hasUpperDecisionNode(path));
				ExitNode tempNode = (ExitNode)currentNode;
				path.add(tempNode);
				LinkedList<IBasicBlock> completePath = (LinkedList<IBasicBlock>)path.clone();
				Path pathFinded = new Path(completePath);
				pathFinded.env = new ProgramEnv();
				paths.add(pathFinded);
				if(!hasUpperDecisionNode(path)){
					break;
				}else {
					currentNode = findUpperDecision(path);
					DecisionNode tempDecisionNode=(DecisionNode)currentNode;
					continue;
				}
				
			}else {
//				System.err.println("currentNode is " + "NOT RECOGNIZED");
				break;
			}
		}
		
		// ����·����
		Path[] pathArray = new Path[paths.size()];
		return paths.toArray(pathArray);
	}
	
	private static void printExpression(DecisionNode decisionNode){
		System.out.println("DecisionNode "+((Expression)decisionNode.getData()));// print Decision Expression
	}
	
	/**
	 * find the first connector node in path, and remove following node
	 * @param conn
	 * @param path
	 * @return
	 */
	private static ConnectorNode findFirstConn(ConnectorNode conn, LinkedList<IBasicBlock> path){
		boolean delete = false;
		ConnectorNode resultConnectorNode = null;
		IBasicBlock iBasicBlock;
		int persition = 0;
		for (; persition < path.size(); persition++) {
			iBasicBlock = path.get(persition);
			if (iBasicBlock == conn) {
				resultConnectorNode = (ConnectorNode) iBasicBlock;// �ݴ沢���ش�connector�ڵ�
				break;
			}
		}
		// delete nodes
		for (int i = path.size()-1; i >= persition; i--) {
			path.remove(i);
		}
		return resultConnectorNode;
	}
	
	/**
	 * print the elements with data in a path
	 * @param path
	 */
	public static void printPath(LinkedList<IBasicBlock> path){
		System.out.println("find a path, its size is: " + path.size()+" and its content is: ");
		for (int i = 0; i < path.size(); i++) {// TODO extracted
			IBasicBlock dataBasicBlock=path.get(i);
			if (dataBasicBlock instanceof PlainNode && !(dataBasicBlock instanceof BranchNode)) {
				System.out.println("plain node"+i+" is: "+((PlainNode)dataBasicBlock).getData());
			}else if(dataBasicBlock instanceof BranchNode){// TODO print the condition
				System.out.println("branch node"+i+" is: "+((BranchNode)dataBasicBlock).getData());
			}else if(dataBasicBlock instanceof ExitNode){
				ExitNode dataNode = (ExitNode)dataBasicBlock;
				if (dataNode.getData()!=null) {
					System.out.println("exit node"+i+" is: "+dataNode.getData());
				}
			}
		}
	}
	/**
	 * print the elements with data in a path
	 * @param path
	 */
	public static void printPath(Path path){
		printPath(path.getPathNodes());
	}

	/**
	 *  ����path�е�����һ��DecisionNode����ɾ����DecisionNode֮������нڵ�
	 * @param path
	 * @return
	 */
	private static  DecisionNode findUpperDecision(LinkedList<IBasicBlock> path){
		if (!hasUpperDecisionNode(path)) {
			return null;
		}
		IBasicBlock tempBasicBlock;
		DecisionNode upperDecisionNode = null;
		for (int i = path.size()-1; i>=0 ; i--) {
			tempBasicBlock = path.remove(i);
			if (tempBasicBlock instanceof DecisionNode) {
				upperDecisionNode = (DecisionNode)tempBasicBlock;
				break;
			}
		}
		return upperDecisionNode;
	}
	/**
	 * �ж�path���Ƿ���ڸ��ϲ��DecisionNode�����㷨���ô�path�Ŀ�ʼ�ڵ�������ң�Ҳ���ԴӺ���ǰ��
	 * @param path
	 * @return
	 */
	private static boolean hasUpperDecisionNode(LinkedList<IBasicBlock> path){
		boolean has = false;
		IBasicBlock tempBasicBlock;
		for (int i = 0; i<path.size() ; i++) {
			tempBasicBlock = path.get(i);
			if (tempBasicBlock instanceof DecisionNode) {
				has = true;
			}
		}
		return has;
	}
	
	/**
	 * ��ȡjavaԴ�ļ�
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static JavaControlFlowGraph[] read(String filePath) throws IOException {
		// ��ȡԴ�ļ�
		File file = new File(filePath);
		byte[] b = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(b);
		fis.close();
		String content = new String(b);
		// ����Դ�ļ����ɱ��뵥Ԫ
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(content.toCharArray());
		CompilationUnit resultUnit = (CompilationUnit) parser.createAST(null);
		// ��ȡ��һ����������
		List types = resultUnit.types();
		TypeDeclaration typeDec = (TypeDeclaration) types.get(0);
		// ȡ�õ�һ���������ķ�������
		MethodDeclaration[] methods = typeDec.getMethods();
		// ���ظ����������ɵ�CFG
		LinkedList<JavaControlFlowGraph> cfgs = new LinkedList<>();
		ControlFlowGraphBuilder builder = new ControlFlowGraphBuilder();
		for (int i = 0; i < methods.length; i++) {
			cfgs.add(builder.build(methods[i]));
		}
		JavaControlFlowGraph[] cfgArrayControlFlowGraphs = new JavaControlFlowGraph[methods.length];
		return cfgs.toArray(cfgArrayControlFlowGraphs);
	}

}
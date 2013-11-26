package core.jtester.ontology.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import core.common.model.jobflow.JobConst;
import core.common.model.semantics.MethodSemantics;
import core.common.model.semantics.SemanticsStore;
import core.common.model.test.TestData;
import core.common.model.test.TestFile;
import core.jtester.ontology.reasoner.IChecker;

public class MethodOverrideChecker implements IChecker {

	public void check(TestData data) {
		TestFile file = data.getCurrentTestFile();
		
		SemanticsStore store = (SemanticsStore) file.get(JobConst.SEMANTICS);
		List<MethodSemantics> exceptions = handleSemantics(store);
		
		if(generateReport(exceptions)){
			data.getTestResult().addViolation(JobConst.ONTOLOGY_OVERRIDE_METHOD_EQUALS_BUT_HASHCODE);
		}
	}
	
	private List<MethodSemantics> handleSemantics(SemanticsStore store){
		List<String> methods = new ArrayList<String>();
		List<MethodSemantics> violations = new ArrayList<MethodSemantics>();
		
		Iterator<MethodSemantics> ir = store.iterator3();
		while(ir.hasNext()){
			MethodSemantics ms = ir.next();
			methods.add(ms.getName().toString());
			violations.add(ms);
		}
		
		if(methods.contains(JobConst.METHOD_EQUALS) && !methods.contains(JobConst.METHOD_HASHCODE)){
			return violations;
		}
		
		return null;
	}

	private boolean generateReport(List<MethodSemantics> exceptions){
		boolean report = false;
		if(exceptions != null && !exceptions.isEmpty()){
			for(MethodSemantics ms: exceptions){
				if(ms.getName().toString().equals(JobConst.METHOD_EQUALS)){
					System.err.println("Warning: ������д��equals����������û����дhashcode����!");
					System.err.println("\t" + ms + " \t");  
					if(report == false){
						report = true;
					}
				}
			}
		}
		
		return report;
	}
}

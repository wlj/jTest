package core.jtester.staticanalysis.shape_analysis;

import java.util.ArrayList;

import org.eclipse.jdt.core.dom.Expression;

public class ShapeGraph implements Cloneable {
	AbstractState _state;
	AbstractHeap _heap;
	SharingInfo _is;
	
	public ShapeGraph(){
		this._state = new AbstractState();
		this._heap = new AbstractHeap();
	}
	
	public ShapeGraph(AbstractState _state2, AbstractHeap _heap2) {
		this._state = new AbstractState(_state2);
		this._heap = new AbstractHeap(_heap2);
	}
	
	
	public ShapeGraph clone() throws CloneNotSupportedException {  
         return new ShapeGraph(this._state, this._heap);  
    }  
	
	public ArrayList<ShapeGraph> transfer4DelXY(Expression name,
			Expression initValue) {
		//1.���ж��Ƿ�Ϊnull
		if (initValue.toString().compareTo("null") == 0){
			ArrayList<String> ln = new ArrayList<String>();
			AbstractLocation al = new AbstractLocation("NILL", ln);
			this._state.add(name.toString(), al);
		}

		ArrayList<ShapeGraph> sgs = new ArrayList<ShapeGraph>();
		
		ShapeGraph sg = new ShapeGraph(this._state, this._heap);
		sgs.add(this);
		
		return sgs;
	}
	
	public ArrayList<ShapeGraph> transfer4AssXY(Expression oprand1, Expression oprand2) {
		ArrayList<ShapeGraph> sgs = new ArrayList<ShapeGraph>();
		this._state.removeBinding2Var(oprand1);
		this._state.addBinding2Var(oprand1, oprand2); 
		this._heap.removeLink2Var(oprand1);
		this._heap.addLink2Var(oprand1,oprand2);
		
		
		ShapeGraph sg = new ShapeGraph(this._state, this._heap);
		sgs.add(this);
		return sgs;
	}
	public ArrayList<ShapeGraph> transfer4AssXSelY(Expression oprand1, Expression oprand2) {
		ArrayList<ShapeGraph> sgs = new ArrayList<ShapeGraph>();
		
		String nameY = oprand2.toString();
		AbstractLocation locY = this._state.getLocation(nameY);
		if(locY == null){
			ArrayList<String> al = new ArrayList<String>();
			al.add(nameY);
			locY = new AbstractLocation("Nill", al);
		}
		
		this._heap.changeXSel2Y(oprand1,nameY,locY);
		
		ShapeGraph sg = new ShapeGraph(this._state, this._heap);
		sgs.add(this);
		return sgs;
	}
	
	public ArrayList<ShapeGraph> transfer4AssXXSel(Expression oprand1, Expression oprand2) {
		
		ArrayList<ShapeGraph> sgs = new ArrayList<ShapeGraph>();
		AbstractLocation xLoc = this._state.getLocation(oprand1.toString());
		AbstractLocation xSel = this._heap.getSndbyFst(xLoc);

		
		if (xSel.getType().compareTo("NILL") == 0){
			//1. ��x->selectorΪnull��ʱ��ȥ��������x��صİ󶨣������루x,nill����State��			
			this._state.removeBinding2Var(oprand1);
			this._heap.removeLink2Var(oprand1);
			
			AbstractLocation xNil = new AbstractLocation("NILL", null);
			this._state.add(oprand1.toString(), xNil);
			
			ShapeGraph sg = new ShapeGraph(this._state, this._heap);
			sgs.add(sg);			
			
		} else if (xSel.getType().compareTo("CONCRETE") == 0){
			//����ת�в��漰������������Ҳ�ʵ��
			//2. ��x->selectorΪ���һ����ĵ�ַ����ô��x��ԭ�е�ַ��locname��ȥ���ټ���˵�ַ��locname�У�ͬʱ���ԭ�е�ַ��Ϊ����ô�ͽ���һ�Դ�ԭ�е�ַ���õ�ַ�ĵ�_heap��
			
		} else if (xSel.getType().compareTo("SUMMARY") == 0){
			//3. ���ж�x��location�ǲ�������������location,����ǣ���ny��nx��һ�Թ�ϵ��Ȼ�����ж�summary����û��summary->summary��Թ�ϵ���������ô��������������㶮�ģ����û�в���һ�����
			
			if (xLoc._locName.size() != 0){
				
				this._state.removeBinding2Var(oprand1);
				AbstractLocation fst = new AbstractLocation(xLoc);
				ArrayList<String> locNames = new ArrayList<String>();
				locNames.add(oprand1.toString());
				AbstractLocation snd = new AbstractLocation("CONCRETE",locNames);
				this._state.add(oprand1.toString(), snd);
				
				this._heap.removeLinkedPair(fst, "SUMMARY");
				this._heap.addLinkedPair(snd, "SUMMARY");
				
				AbstractLocation snd2 = new AbstractLocation (snd);
				this._heap.addLinkedPair(fst, snd2);
				
			} else {
				
				ArrayList<String> locNames = new ArrayList<String>();
				locNames.add(oprand1.toString());
				AbstractLocation snd = new AbstractLocation("CONCRETE",locNames);
				this._state.add(oprand1.toString(), snd);
				this._heap.addLinkedPair(snd, "SUMMARY");
			}
			
			if (this._heap.isExist("SUMMARY","SUMMARY")){
				ShapeGraph sg1 = new ShapeGraph(this._state, this._heap);
				sgs.add(sg1);
				
				this._heap.removeLinkedPair("SUMMARY", "SUMMARY");
				ShapeGraph sg2 = new ShapeGraph(this._state, this._heap);
				sgs.add(sg2);
			} else {
				
				ArrayList<String> locNames = new ArrayList<String>();
				locNames.add(oprand1.toString());
				AbstractLocation snd = new AbstractLocation("CONCRETE",locNames);
				this._heap.removeLinkedPair(snd, "SUMMARY");
				this._heap.addLinkedPair(snd, "NILL");
				
				ShapeGraph sg = new ShapeGraph(this._state, this._heap);
				sgs.add(sg);				
			}		
		} 
		
		return sgs;
	}
	
	public String displaySG(){
		String result = "";
		result += "    State: ";
		result += this._state.displayState();
		result += "\n";
		result += "     Heap: ";
		result += this._heap.displayHeap();
		result += "\n";
		return result;
	}
	
	//----------------------------------------------------  �����ķָ���  -------------------------------------------------------------------------//
}
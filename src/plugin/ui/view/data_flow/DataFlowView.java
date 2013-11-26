package plugin.ui.view.data_flow;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.part.ViewPart;

import org.eclipse.swt.widgets.Label;

public class DataFlowView extends ViewPart{
	public DataFlowView() {
	}
	// ����һ�����������н����ڴ˻�����չʾ	
	private Composite topComp;
	
	// ����һ��TableViewer����
	private static TableViewer tv;
	private static Label reportLabel;
	private static Combo combo; 
		
	public void createPartControl(Composite parent) {
		topComp = new Composite(parent, SWT.NONE);
		topComp.setLayout(new FillLayout());
		
		ViewForm viewForm = new ViewForm(topComp, SWT.NONE);
		viewForm.setLayout(new FillLayout());
		
		// ʽ����MULTI�ɶ�ѡ��H_SCROLL��ˮƽ��������V_SCROLL�д�ֱ��������BORDER�б߿�FULL_SELECTION����ѡ��
		tv = new TableViewer(viewForm, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		
		// ����������
		ToolBar toolBar = new ToolBar(viewForm, SWT.FLAT);
		ToolBarManager toolBarManager = new ToolBarManager(toolBar);
		
		// ����һ��ReportViewActionGroup���󣬲�����fillContextMenu��������ťע�뵽�˵�������
		DataFlowViewActionGroup actionGroup = new DataFlowViewActionGroup(tv);
		actionGroup.fillActionToolBars(toolBarManager);
		
		// ���ñ��͹������ڲ����е�λ��
		viewForm.setContent(tv.getControl()); // �����Ǳ��
		viewForm.setTopRight(toolBar); // �����м��ǹ�����
		
		// ����֪ͨ��
		reportLabel = new Label(viewForm, SWT.NONE);
		viewForm.setTopLeft(reportLabel);
		reportLabel.setText(" No report to display at this time");
		
		// ���� ��������ѡ��
		combo = new Combo(viewForm, SWT.READ_ONLY);
		combo.setLayoutData(new FillLayout());
		combo.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
			}
		});
		viewForm.setTopCenter(combo);
		
		// ͨ������ں���Table�������ò��ַ�ʽ
		Table table = tv.getTable();
		table.setHeaderVisible(true); // ��ʾ��ͷ
		table.setLinesVisible(true); // ��ʾ�����
		TableLayout layout = new TableLayout(); // ר���ڱ��Ĳ���
		table.setLayout(layout);
		
		// ��TableColumn�ഴ�������

		// source code line��
		layout.addColumnData(new ColumnWeightData(50));
		TableColumn line = new TableColumn(table, SWT.NONE);
		line.setText("line");

		// source code��
		layout.addColumnData(new ColumnWeightData(120));
		TableColumn column_Product = new TableColumn(table, SWT.NONE);
		column_Product.setText("source code");
		
		// entry��
		layout.addColumnData(new ColumnWeightData(120));
		new TableColumn(table, SWT.NONE).setText("entry");
		
		// exit��
		layout.addColumnData(new ColumnWeightData(120));
		new TableColumn(table, SWT.NONE).setText("exit");
		
		// �����������ͱ�ǩ��
		tv.setContentProvider(new DataFlowViewContentProvider());
		tv.setLabelProvider(new DataFlowViewLabelProvider());
	}
	
	// ���ڻ�ȡtv
	public static TableViewer getTableViewer(){
		return tv;
	}
	
	public static Label getReportLabel(){
		return reportLabel;
	}
		
	public void setFocus() {
	}

}

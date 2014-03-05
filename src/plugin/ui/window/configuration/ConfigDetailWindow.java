package plugin.ui.window.configuration;

import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;

import plugin.ui.window.configuration.entity.ConfigEntity;

public class ConfigDetailWindow{
	Composite showedComposite;
	NoneConfigSelectedComposite noneConfigSelected;
	OneConfigSelectedComposite oneConfigSelectedComposite;
	Composite selectedComposite;
	StackLayout detaiLayout;

	public ConfigDetailWindow(Composite parent, int style, ConfigEntity entity) {
		int tempValue = ConstantcLayoutData.botton_margin;
		showedComposite = new Composite(parent, style);
		detaiLayout = new StackLayout();
		showedComposite.setLayout(detaiLayout);
		// generate the showing composite
		if (entity == null) {
			noneConfigSelected = new NoneConfigSelectedComposite(showedComposite, style);
			selectedComposite = noneConfigSelected;
		}else{
			oneConfigSelectedComposite = new OneConfigSelectedComposite(showedComposite, style, entity);
			selectedComposite = oneConfigSelectedComposite;
		}
		
		// this must be called when detail composite generated totally.
		detaiLayout.topControl = selectedComposite;
	}
	
	public Composite getComposite(){
		return showedComposite;
	}
	

}

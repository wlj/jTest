package plugin.ui.window.configuration.entity;
/**
 * Metrics
 * @author 
 *
 */
public class Metrics {
	private boolean isPublic;
	private MetricItem[] metricItems;
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	public MetricItem[] getMetricItems() {
		return metricItems;
	}
	public void setMetricItems(MetricItem[] metricItems) {
		this.metricItems = metricItems;
	}
	
	
}

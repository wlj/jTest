
package core.common.model.varinterval;

/**
 * 
 * @author Qip, BruceCotton, Zhgn
 * 
 */

/** �������� */
public class IntegerInterval implements Comparable<IntegerInterval>,Cloneable {
	/** �½� */
	private double min;

	/** �Ͻ� */
	private double max;

	/** ��min,maxָ���ı����䣬[min��max] */
	public IntegerInterval(long min, long max) {
		double tmin = min, tmax = max;
		if(tmin==Long.MIN_VALUE){
			tmin=Double.NEGATIVE_INFINITY;
		}
		if(tmax==Long.MAX_VALUE){
			tmax=Double.POSITIVE_INFINITY;
		}
		
		this.min = tmin;
		this.max = tmax;
	}
	
	private IntegerInterval(double min, double max) {
		
		this.min = min;
		this.max = max;
	}

	/** ��x,xָ���ı����䣬[x��x] */
	public IntegerInterval(long x) {
		min = x;
		max = x;
	}

	/** ���������������䣬[-inf��inf] */
	public IntegerInterval() {
		min = Double.POSITIVE_INFINITY;
		max = Double.NEGATIVE_INFINITY;
	}

	/** ��min,maxָ��������,minexcluded��maxexcludedΪtrue�ֱ�ָʾmin��max�������������� */
	public IntegerInterval(long min, long max, boolean minexcluded, boolean maxexcluded) {
		double tmin = min, tmax = max;
		if(tmin==Long.MIN_VALUE){
			tmin=Double.NEGATIVE_INFINITY;
		}
		if(tmax==Long.MAX_VALUE){
			tmax=Double.POSITIVE_INFINITY;
		}
		if (minexcluded ) {
			tmin = min + 1;
		}
		if (maxexcluded ) {
			tmax = max - 1;
		}
		this.min = tmin;
		this.max = tmax;
	}

	/** �������� */
	public IntegerInterval(IntegerInterval x) {
		this.min = x.min;
		this.max = x.max;
	}
	
	/** �ж����������Ƿ���ȣ��Ͻ���½�ֱ������Ϊ������� */
	public boolean equals(Object o) {
		if ((o == null) || !(o instanceof IntegerInterval)) {
			return false;
		}
		if (this == o) {
			return true;
		}
		IntegerInterval x = (IntegerInterval) o;
		if(x.isEmpty()&&this.isEmpty()){
			return true;
		}
		return ((Math.round(max) == Math.round(x.max)) && (Math.round(min) == Math.round(x.min)));
	}

	/** ����½� */
	public long getMin() {
		return Math.round(min);
	}

	/** ����Ͻ� */
	public long getMax() {
		return Math.round(max);
	}

	/** �����½� */
	public void setMin(long min) {
		if(min==Long.MIN_VALUE){
			this.min=Double.NEGATIVE_INFINITY;
		}else{
			this.min = min;
		}
	}

	/** �����Ͻ� */
	public void setMax(long max) {
		if(max==Long.MAX_VALUE){
			this.max=Double.POSITIVE_INFINITY;
		}else{
			this.max = max;
		}
	}

	/** ��ӡ */
	public String toString() {
		long tmin=Math.round(min),tmax=Math.round(max);
		StringBuffer b=new StringBuffer();
		b.append("[");
		if(tmin==Long.MIN_VALUE){
			b.append("-inf");
		}else{
			b.append(tmin);
		}
		b.append(",");
		if(tmax==Long.MAX_VALUE){
			b.append("inf");
		}else{
			b.append(tmax);
		}	
		b.append("]");
		return b.toString();
	}

	/** �Ƚ������˳���������� */
	public int compareTo(IntegerInterval interval) {
		if (Math.round(min) == Math.round(interval.min)) {
			return 0;
		} else if (Math.round(min) > Math.round(interval.min)) {
			return 1;
		} else {
			return -1;
		}
	}

	/** �õ�һ���յ����� */
	public static IntegerInterval emptyInterval() {
		IntegerInterval z = new IntegerInterval(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
		return z;
	}

	/** �õ�һ����������[-inf,inf] */
	public static IntegerInterval fullInterval() {
		IntegerInterval z = new IntegerInterval(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		return z;
	}

	/** �ж�һ�������Ƿ�Ϊ�� */
	public boolean isEmpty() {
		return Math.round(min) > Math.round(max);
	}
	
	public static boolean canBeJoined(IntegerInterval interval1, IntegerInterval interval2) {
		if (interval1.isEmpty() || interval2.isEmpty()) {
			return false;
		}
		if (Math.round(interval1.max) >= Math.round(interval2.min - 1) && Math.round(interval1.min) <= Math.round(interval2.max + 1)) {
			return true;
		}
		return false;
	}

	/** �ж�һ�������Ƿ�ֻ����һ���� */
	public boolean isCanonical() {
		return Math.round(min) == Math.round(max);
	}

	/** �ж������Ƿ����x */
	public boolean contains(int x) {
		return (x >= Math.round(min) && x <= Math.round(max));
	}

	/** ��������ȡ��������һ������ */
	public static IntegerInterval intersect(IntegerInterval x, IntegerInterval y) {
		return new IntegerInterval(Math.max(x.min, y.min), Math.min(x.max, y.max));
	}

	/** ��������ȡ��������һ������ */
	public static IntegerInterval union(IntegerInterval x, IntegerInterval y) {
		if(x.isEmpty()){
			return new IntegerInterval(y);
		}
		if(y.isEmpty()){
			return new IntegerInterval(x);
		}
		return new IntegerInterval(Math.min(x.min, y.min), Math.max(x.max, y.max));
	}

	/** ��ѧ���㣺�ӷ� */
	public static IntegerInterval add(IntegerInterval x, IntegerInterval y) {
		IntegerInterval z = new IntegerInterval();
		z.min = x.min + y.min;
		z.max = x.max + y.max;
		return (z);
	}

	/** ��ѧ���㣺�ӷ� */
	public static IntegerInterval add(IntegerInterval x, long d) {
		return add(x, new IntegerInterval(d));
	}

	/** ��ѧ���㣺���� */
	public static IntegerInterval sub(IntegerInterval x, IntegerInterval y) {
		DoubleInterval a=new DoubleInterval(x.min,x.max),b=new DoubleInterval(y.min,y.max);
		DoubleInterval c=DoubleInterval.sub(a, b);
		IntegerInterval z = new IntegerInterval(c.getMin(),c.getMax());
		return (z);
	}

	/** ��ѧ���㣺���� */
	public static IntegerInterval sub(IntegerInterval x, long d) {
		return sub(x, new IntegerInterval(d));
	}

	/** ��ѧ���㣺�˷� */
	public static IntegerInterval mul(IntegerInterval x, IntegerInterval y) {
		DoubleInterval a=new DoubleInterval(x.min,x.max),b=new DoubleInterval(y.min,y.max);
		DoubleInterval c=DoubleInterval.mul(a, b);
		IntegerInterval z = new IntegerInterval(c.getMin(),c.getMax());
		return (z);
	}

	/** ��ѧ���㣺�˷� */
	public static IntegerInterval mul(IntegerInterval x, int d) {
		return mul(x, new IntegerInterval(d));
	}

	/** ��ѧ���㣺���� */
	public static IntegerInterval div(IntegerInterval x, IntegerInterval y) {
		DoubleInterval a=new DoubleInterval(x.min,x.max),b=new DoubleInterval(y.min,y.max);
		DoubleInterval c=DoubleInterval.div(a, b);
		double tmin=0,tmax=0;
		if(c.getMin()>0){
			tmin=Math.floor(c.getMin());
		}else{
			tmin=Math.ceil(c.getMin());
		}
		
		if(c.getMax()>0){
			tmax=Math.floor(c.getMax());
		}else{
			tmax=Math.ceil(c.getMax());
		}
		
		IntegerInterval z = new IntegerInterval(tmin,tmax);
		return (z);		
	}

	/** ��ѧ���㣺���� */
	public static IntegerInterval div(IntegerInterval x, int d) {
		return div(x, new IntegerInterval(d));
	}

	/** ��ѧ���㣺ȡ�� */
	public static IntegerInterval mod(IntegerInterval a, IntegerInterval b) {
		IntegerInterval z = new IntegerInterval();
		z = sub(a, mul(div(a, b), b));
		return (z);
	}

	/** ��ѧ���㣺ȡ�� */
	public static IntegerInterval mod(IntegerInterval a, int d) {
		IntegerInterval z = new IntegerInterval();
		IntegerInterval b = new IntegerInterval(d);
		z = mod(a,b);
		return (z);
	}

	/** ��ѧ���㣺-���� */
	public static IntegerInterval uminus(IntegerInterval x) {
		DoubleInterval a=new DoubleInterval(x.min,x.max);
		DoubleInterval c=DoubleInterval.uminus(a);
		IntegerInterval z = new IntegerInterval(c.getMin(),c.getMax());
		return (z);	
	}
	/**add by zhanggn*/
	public IntegerInterval clone() {
		IntegerInterval result = new IntegerInterval();
		result.min = this.min;
		result.max = this.max;
		return result;
	}
	public IntegerInterval(DoubleInterval dinterval) {
		this.min = (int) Math.round(dinterval.getMin());
		this.max = (int) Math.round(dinterval.getMax());
	}

	public void inc() {
		this.min++;
		this.max++;
	}
	public void dec() {
		this.min--;
		this.max--;
		// TODO Auto-generated method stub

	}

	public void neg() {
		double temp = this.min;
		this.min = -1 * this.max;
		this.max = -1 * temp;
		// TODO Auto-generated method stub

	}

	public boolean isIn(int i) {
		return (i >= this.min) && (i <= this.max);
	}
	
	public double getDoubleMin() {
		return this.min;
	}

	public double getDoubleMax() {
		return this.max;
	}

}

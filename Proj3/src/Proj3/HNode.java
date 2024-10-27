package Proj3;

public class HNode{
	private Object data;
	private String date;
	private char flag;

	public HNode() {
		this.flag='E';

	}
	

	public HNode(Object data, char flag) {
		super();
		this.data = data;
		this.flag = flag;
		if(((Date)data).getDate().isEmpty()) {
			this.date="";
		}else {
		this.date=((Date)data).getDate();
		}
	}


	public HNode(Object data) {
		this.data = data;
		this.flag='E';
	}

	public char getFlag() {
		return flag;
	}

	public void setFlag(char flag) {
		if (flag == 'E' || flag == 'D' || flag == 'F')
			this.flag = flag;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	public String getDate() {
		return this.date;
	}

	public boolean isFull() {
		return flag=='F';
	}

	@Override
	public String toString() {
		return data + "";
	}
}

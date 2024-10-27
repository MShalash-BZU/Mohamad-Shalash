package Proj3;

import Proj2.MartyrDate;
import Proj2.Stack;
import Proj2.TNode;

import java.util.ArrayList;

public class HashTable {
	private HNode[] hash;
	private int size;
	private int counter;

	public HNode[] getHash() {
		return hash;
	}
	public Stack DateSt(){
		Stack stc=new Stack();
		for (int i = 0; i < hash.length; i++) {
			if(hash[i].isFull() ){
				stc.push(hash[i].getData());
			}
		}
		return stc;

	}

	public HashTable() {
		this.size = 11;
		hash = new HNode[size];
		this.counter = 0;
		initialization();
	}

	public int getSize() {
		return size;
	}

	public HNode get(int index) {
		return hash[index];
	}

	public void insert(Object data) {
		if (counter >= size / 2) {
			rehash(getNextPrime(2 * size));
		}
		int index = hash((Date)data);
		hash[index] = new HNode(data);
		hash[index].setFlag('F');
		counter++;
	}

	private int getNextPrime(int x) {
		while (!isPrime(x)) {
			x++;
		}
		return x;
	}

	private boolean isPrime(int n) {
		if (n <= 1) return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

	public void rehash(int newSize) {
		HNode[] oldHash = hash;
		hash = new HNode[newSize];
		size = newSize;
		counter = 0;
		initialization();
		for (HNode node : oldHash) {
			if (node != null && node.getFlag() == 'F') {
				insert(node.getData());
			}
		}
	}

	public Object delete(Object data) {
		int index = search(data);
		if (index != -1) {
			counter--;
			hash[index].setFlag('D');
			if (counter <= size / 4) {
				rehash(getPrevPrime(size / 2));
			}
			return data;
		}
		return null;
	}

	private int getPrevPrime(int x) {
		while (!isPrime(x)) {
			x--;
			if (x < 3) {
				x = 3;
				break;
			}
		}
		return x;
	}

	public int search(Object data) {
		int h = Math.abs(hashCode(((Date)data).getDate())), j = 0, i = h % hash.length;
		while (hash[i] != null && hash[i].isFull()) {
			if (((Date) hash[i].getData()).getDate().equalsIgnoreCase(((Date) data).getDate())) {
				return i;
			}
			j++;
			i = (h + j * j) % hash.length;
			if (j == hash.length) break;
		}
		return -1;
	}
	public int hashCode(String date) {
		int s=0;
		for(int i=0;i<date.length();i++) {
			s+=(int)date.charAt(i)*(int)Math.pow(31, i);
		}
		return s;
	}


	public Object searchBol(Object data) {
		for (int i = 0; i < hash.length; i++) {
			if(hash[i].isFull() && ((Date)hash[i].getData()).getDate().equalsIgnoreCase(((Date) data).getDate())){
				return hash[i].getData();
			}
		}
		return null;
	}

	private void initialization() {
		for (int i = 0; i < hash.length; i++) {
			hash[i] = new HNode();
		}
	}

	private int hash(Date data) {
		int h = Math.abs(hashCode(((Date)data).getDate())), j = 0, i = h % hash.length;
		while (hash[i] != null && hash[i].isFull()) {
			j++;
			i = (h + j * j) % hash.length;
		}
		return i;
	}
	public ArrayList<HNode> print(boolean b){
		ArrayList<HNode> arr=new ArrayList<>();
		for (int i = 0; i < hash.length; i++) {
			if (hash[i].isFull() && b==true){
				arr.add(new HNode(((Date)hash[i].getData()),hash[i].getFlag()));
			}else if(b==false){
				arr.add(new HNode(((Date)hash[i].getData()),hash[i].getFlag()));
			}
		}
		return arr;
	}
	public ArrayList<String> combDis(){
		ArrayList<String> dis=new ArrayList<>();
		for (int i = 0; i < hash.length; i++) {
			if(hash[i].isFull()) {
				Date date = (Date) hash[i].getData();
				for (int j = 0; j < date.getMar().Discomb().size(); j++) {
					if (!dis.contains(date.getMar().Discomb().get(j))) {
						dis.add(date.getMar().Discomb().get(j));
					}
				}
			}
		}
		return dis;
	}


	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (HNode node : hash) {
			if (node != null && node.getFlag() != 'D') {
				s.append(node).append("\n");
			} else {
				s.append("null\n");
			}
		}
		return s.toString();
	}
}

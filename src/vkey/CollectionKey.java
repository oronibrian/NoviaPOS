package vkey;

import java.util.ArrayList;

public class CollectionKey {
	public int width = 1024;
	public int height = 450;
	public int gap = 2;
	private ArrayList<ArrayList<SingleKey>> list;
	
	public CollectionKey() {
		list = new ArrayList<ArrayList<SingleKey>>();
		//list.add(new ArrayList<SingleKey>());
	}
	
	public void newLine() {
		list.add(new ArrayList<SingleKey>());
	}
	
	public void addKey(String lang1, String lang1up, String lang2, String lang2up, float width) {
		int lines = list.size();
		SingleKey key = new SingleKey();
		key.row = lines - 1;
		key.col = list.get(lines-1).size(); 
		key.special = null;
		key.lang1 = lang1;
		key.lang1up = lang1up;
		key.lang2 = lang2;
		key.lang2up = lang2up;
		key.width = width;
		key.sizefactor = 1;
		list.get(lines-1).add(key);
	}
	
	public void addKey(String lang1, String lang1up, String lang2, String lang2up) {
		addKey(lang1, lang1up, lang2, lang2up, 1);
	}
	
	public void addKey(String special, String text, float width, float sizefactor) {
		int lines = list.size();
		SingleKey key = new SingleKey();
		key.row = lines - 1;
		key.col = list.get(lines-1).size();
		key.special = special;
		key.lang1 = text;
		key.lang1up = null;
		key.lang2 = null;
		key.lang2up = null;
		key.width = width;
		key.sizefactor = sizefactor;
		list.get(lines-1).add(key);
	}
	
	public int getCount() {
		int count = 0;
		for (ArrayList<SingleKey> ln : list) {
			count += ln.size();
		}
		return count;
	}
	
	public int getCountInLine(int line) {
		return list.get(line).size();
	}

	public float getLengthInMaxLine() {
		float max = 0;
		float sum;
		for (ArrayList<SingleKey> ln : list) {
			sum = 0;
			for (SingleKey sk : ln) {
				sum += sk.width;
			}
			if (sum > max) max = sum;
		}
		return max;
	}
	
	public int getCountOfLine() {
		return list.size();
	}

	public SingleKey getKey(int index) {
		if (index >= getCount()) return null;
		for (int line = 0; line < list.size(); index -= list.get(line).size(), line++)
		if (index < list.get(line).size()) {
			return list.get(line).get(index);
		}
		return null;
	}
	
	public SingleKey getKey(int line, int number) {
		return list.get(line).get(number);
	}
	
}

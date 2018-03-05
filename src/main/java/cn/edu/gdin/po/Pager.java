package cn.edu.gdin.po;

import java.util.List;
/**
 * 分页对象
 * @author zysung
 *
 * @param <T>
 */
public class Pager<T> {
	private List<T> datas;
	private int offset;
	private int size;
	private long total;
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
}

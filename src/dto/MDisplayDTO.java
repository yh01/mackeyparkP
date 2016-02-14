package dto;

import java.util.ArrayList;

public class MDisplayDTO {
	private String id;
	private String name;
	private double price;
	private String quantity;
	public ArrayList<MDisplayDTO> commentList;
	/**
	 * idを取得します。
	 * @return id
	 */
	public String getId() {
	    return id;
	}
	/**
	 * idを設定します。
	 * @param id id
	 */
	public void setId(String id) {
	    this.id = id;
	}
	/**
	 * nameを取得します。
	 * @return name
	 */
	public String getName() {
	    return name;
	}
	/**
	 * nameを設定します。
	 * @param name name
	 */
	public void setName(String name) {
	    this.name = name;
	}
	/**
	 * priceを取得します。
	 * @return price
	 */
	public double getPrice() {
	    return price;
	}
	/**
	 * priceを設定します。
	 * @param price price
	 */
	public void setPrice(double price) {
	    this.price = price;
	}
	/**
	 * quantityを取得します。
	 * @return quantity
	 */
	public String getQuantity() {
	    return quantity;
	}
	/**
	 * quantityを設定します。
	 * @param quantity quantity
	 */
	public void setQuantity(String quantity) {
	    this.quantity = quantity;
	}
	/**
	 * commentListを取得します。
	 * @return commentList
	 */
	public ArrayList<MDisplayDTO> getCommentList() {
	    return commentList;
	}
	/**
	 * commentListを設定します。
	 * @param commentList commentList
	 */
	public void setCommentList(ArrayList<MDisplayDTO> commentList) {
	    this.commentList = commentList;
	}
}

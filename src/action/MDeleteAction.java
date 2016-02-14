package action;

import java.util.ArrayList;

import dao.MDeleteDAO;
import dto.MDeleteDTO;

public class MDeleteAction {

	private int checkedDelete[];

	private String id;



	private ArrayList<MDeleteDTO> List = new ArrayList<MDeleteDTO>();



	public String execute(){
		MDeleteDAO dao = new MDeleteDAO();
		if (dao.delete(id)==0) {
			return "error";
		}
		return "success";
	}


	public ArrayList<MDeleteDTO> getList() {
		return List;
	}

	public void setList(ArrayList<MDeleteDTO> list) {
		List = list;
	}

	public int[] getCheckedDelete() {
		return checkedDelete;
	}

	public void setCheckedDelete(int[] checkedDelete) {
		this.checkedDelete = checkedDelete;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

}

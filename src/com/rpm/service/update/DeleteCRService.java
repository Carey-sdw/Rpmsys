package com.rpm.service.update;

public interface DeleteCRService {
	/**
	 删除投诉
	 */
	void deleteComp(Long complaint_id);
	
	/**
	 * 删除报修
	 * @param repair_id
	 */
	void deleteRepair(Long repair_id);
}

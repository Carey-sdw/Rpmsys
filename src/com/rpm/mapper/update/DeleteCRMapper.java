package com.rpm.mapper.update;
/**
 * 删除报修或举报
 * 
 */
public interface DeleteCRMapper {

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

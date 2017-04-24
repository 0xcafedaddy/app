package com.uflowertv.dao;

import com.uflowertv.model.dto.DayActiveCount;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StartMapper {

	List<DayActiveCount> getTimeUserActiveList( @Param(value = "recordIndex")int recordIndex,
                                                @Param(value = "pageSize") int pageSize,
			                                    @Param(value = "start") Date start,
                                                @Param(value = "end") Date end);

	int getTimeUserActiveCount(@Param(value = "start") Date start,
                               @Param(value = "end") Date end);

}
package cn.com.xinxin.sass.repository.dao;

/*
 *
 * Copyright 2020 www.xinxindigits.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"),to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice
 * shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Redistribution and selling copies of the software are prohibited, only if the authorization from xinxin digits
 * was obtained.Neither the name of the xinxin digits; nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written permission.
 *
 */

import cn.com.xinxin.sass.repository.model.TenantDataSyncConfigDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TenantDataSyncConfigDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant_sync_config
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant_sync_config
     *
     * @mbg.generated
     */
    int insert(TenantDataSyncConfigDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant_sync_config
     *
     * @mbg.generated
     */
    int insertSelective(TenantDataSyncConfigDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant_sync_config
     *
     * @mbg.generated
     */
    TenantDataSyncConfigDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant_sync_config
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TenantDataSyncConfigDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant_sync_config
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TenantDataSyncConfigDO record);

    /**
     * 通过机构id和任务类型查询记录
     * @param tenantId 机构id
     * @param taskType 任务类型
     * @return 机构同步配置信息
     */
    TenantDataSyncConfigDO selectByOrgIdAndTaskType(@Param(value = "tenantId") String tenantId,
                                                    @Param(value = "taskType")String taskType);
    /**
     * 上锁
     * @param tenantId 租户id
     * @param taskType 任务类型
     * @return 成功更新记录条数
     */
    int updateLockByTenantIdAndTaskType(@Param(value = "tenantId") String tenantId,
                                        @Param(value = "taskType")String taskType);

    /**
     * 解锁
     * @param tenantId 租户id
     * @param taskType 任务类型
     * @return 成功更新记录条数
     */
    int updateUnLockByTenantIdAndTaskType(@Param(value = "tenantId") String tenantId,
                                        @Param(value = "taskType")String taskType);

    /**
     * 查询所有未被删除的记录
     * @return 未被删除的记录
     */
    List<TenantDataSyncConfigDO> queryValidRecord();

    /**
     * 通过租户id查询记录
     * @param tenantId 租户id
     * @return
     */
    List<TenantDataSyncConfigDO> selectByTenantId(@Param("tenantId") String tenantId);
}
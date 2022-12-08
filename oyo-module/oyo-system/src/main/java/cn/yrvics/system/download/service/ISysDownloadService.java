package cn.yrvics.system.download.service;

import cn.yrvics.system.api.download.entity.dto.SysDownloadAddDto;
import cn.yrvics.system.api.download.entity.dto.SysDownloadDto;
import cn.yrvics.system.download.entity.SysDownload;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ISysDownloadService extends IService<SysDownload> {

    /**
     * 下载中心分页查询
     * @param ipage
     * @param creatorId
     * @param status
     * @param type
     * @param searchStr
     */
    Page<SysDownloadDto> page(Page<SysDownload> ipage, Long creatorId, Integer status, Integer type, String searchStr);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysDownloadDto getById(Long id);

    /**
     * 新增
     * @param addDto
     */
    SysDownload save(SysDownloadAddDto addDto);

    /**
     * 创建下载任务
     * @param addDto
     */
    void createTask(SysDownloadAddDto addDto);
}

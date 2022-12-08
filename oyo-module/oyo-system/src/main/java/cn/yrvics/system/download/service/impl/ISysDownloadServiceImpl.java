package cn.yrvics.system.download.service.impl;

import cn.yrvics.system.api.download.entity.dto.SysDownloadAddDto;
import cn.yrvics.system.api.download.entity.dto.SysDownloadDto;
import cn.yrvics.system.api.download.enums.ScheduleStatusEnum;
import cn.yrvics.system.api.download.enums.SysDownLoadStatusEnum;
import cn.yrvics.system.constant.RedisKey;
import cn.yrvics.system.download.assembler.SysDownloadConverter;
import cn.yrvics.system.download.entity.SysDownload;
import cn.yrvics.system.download.mapper.SysDownloadMapper;
import cn.yrvics.system.download.service.ISysDownloadService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class ISysDownloadServiceImpl  extends ServiceImpl<SysDownloadMapper, SysDownload>  implements ISysDownloadService {


    @Resource
    private SysDownloadConverter converter;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public Page<SysDownloadDto> page(Page<SysDownload> ipage, Long creatorId, Integer scheduleStatus, Integer type,String searchStr) {
        List<Integer> status = Lists.newArrayList();
        if(ScheduleStatusEnum.NOT_FINISH.getCode().equals(scheduleStatus)){
            status.addAll(SysDownLoadStatusEnum.NOT_FINISH);
        }
        if(ScheduleStatusEnum.FINISH.getCode().equals(scheduleStatus)){
            status.add(SysDownLoadStatusEnum.DOWNLOAD_FINISH.getCode());
        }
        ipage = this.baseMapper.page(ipage, creatorId, status, type, searchStr);
        return converter.poToDto(ipage);
    }

    @Override
    public SysDownloadDto getById(Long id) {
        SysDownload sysDownload = this.baseMapper.selectById(id);
        return converter.poToDto(sysDownload);
    }

    @Override
    public SysDownload save(SysDownloadAddDto addDto) {
        SysDownload sysDownload = converter.dtoToPo(addDto);
        this.save(sysDownload);
        return sysDownload;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createTask(SysDownloadAddDto addDto) {

        //保存下载记录 todo 测试事务
        addDto.setDownloadStatus(SysDownLoadStatusEnum.DOWNLOAD_WAIT.getCode());
        SysDownload sysDownload = this.save(addDto);

//        List<SysDownload> waitDownload = this.getByCreatorIdAndStatus(addDto.getCreatorId(), Collections.singletonList(SysDownLoadStatusEnum.DOWNLOAD_WAIT.getCode()));
//        if(CollUtil.isEmpty(waitDownload)){
//            throw new SystemException(ErrorCodeEnum.USER_ERROR_A6028);
//        }
        //维护redis中的任务数和进度 todo 考虑使用map结构 key=sys:download:process:#{creatorId} {"id":"进度"}
        String test = RedisKey.loadingProcess+ addDto.getCreatorId();
        redisTemplate.opsForHash().put(test,sysDownload.getId().toString(),0);

        redisTemplate.opsForValue().set("a","2");


    }


    private List<SysDownload> getByCreatorIdAndStatus(Long creatorId,List<Integer> status){
        return this.baseMapper.getByCreatorIdAndStatus(creatorId,status);
    }

}

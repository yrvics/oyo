package cn.yrvics.system.download.assembler;

import cn.yrvics.system.api.download.entity.dto.SysDownloadAddDto;
import cn.yrvics.system.api.download.entity.dto.SysDownloadDto;
import cn.yrvics.system.download.entity.SysDownload;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface SysDownloadConverter {

    Page<SysDownloadDto> poToDto(Page<SysDownload> page);

    SysDownloadDto poToDto(SysDownload sysDownload);

    SysDownload dtoToPo(SysDownloadAddDto addDto);
}

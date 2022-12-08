package cn.yrvics.system.download.controller;

import cn.yrvics.core.entity.Result;
import cn.yrvics.core.factory.ResultFactory;
import cn.yrvics.system.api.download.entity.dto.SysDownloadAddDto;
import cn.yrvics.system.api.download.entity.dto.SysDownloadDto;
import cn.yrvics.system.api.download.feign.RemoteSysDownloadService;
import cn.yrvics.system.download.entity.SysDownload;
import cn.yrvics.system.download.service.ISysDownloadService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RequestMapping(value = "/system/download")
@RestController
@Api(tags = "系统下载中心")
public class SysDownloadController implements RemoteSysDownloadService {

    @Resource
    private ISysDownloadService sysDownloadService;


    @ApiOperation("分页获取系统下载记录")
    @GetMapping("/page")
    public Result<Page<SysDownloadDto>> page(@ApiParam(value = "页码", required = true) @RequestParam(value = "page", required = true) Integer page,
                                             @ApiParam(value = "每页条数", required = true) @RequestParam(value = "pageSize", required = true) Integer pageSize,
                                             @ApiParam(value = "创建者id", required = true) @RequestParam(value = "creatorId", required = true) Long creatorId,
                                             @ApiParam(value = "status 状态", required = false) @RequestParam(value = "status", required = false) Integer status,
                                             @ApiParam(value = "type", required = false) @RequestParam(value = "type", required = false) Integer type,
                                             @ApiParam(value = "搜索条件", required = false) @RequestParam(value = "searchStr", required = false) String searchStr) {
        Page<SysDownload> ipage = new Page<>(page, pageSize);
        Page<SysDownloadDto> dtoPage = sysDownloadService.page(ipage, creatorId, status, type, searchStr);
        return ResultFactory.ok(dtoPage);
    }

    @ApiOperation("根据id获取系统下载记录")
    @GetMapping("/getById")
    public Result<SysDownloadDto> getById(@ApiParam(value = "id",required = true)@RequestParam(value = "id",required = true) Long id) {
        SysDownloadDto downloadDto = sysDownloadService.getById(id);
        return ResultFactory.ok(downloadDto);
    }


    @ApiOperation("保存系统下载中心表信息")
    @PostMapping("/save")
    public Result<Void> save(@Valid @RequestBody SysDownloadAddDto addDto){
        sysDownloadService.save(addDto);
        return ResultFactory.ok();
    }

    @ApiOperation("创建下载任务")
    @PostMapping("/createTask")
    public Result<Void> createTask(@Valid @RequestBody SysDownloadAddDto addDto){
        sysDownloadService.createTask(addDto);
        return ResultFactory.ok();
    }


}

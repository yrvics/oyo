package cn.yrvics.system.download.mapper;

import cn.yrvics.system.download.entity.SysDownload;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysDownloadMapper  extends BaseMapper<SysDownload> {
    /**
     * 分页查询
     * @param ipage
     * @param memberId
     * @param status
     * @param type
     * @param searchStr
     * @return
     */
    Page<SysDownload> page(Page<SysDownload> ipage, @Param("memberId") Long memberId, @Param("status") List<Integer> status, @Param("type") Integer type, @Param("searchStr") String searchStr);


    /**
     * 根据创建者和状态查询
     * @param creatorId
     * @param status
     * @return
     */
    List<SysDownload> getByCreatorIdAndStatus(@Param("creatorId") Long creatorId, @Param("status") List<Integer> status);
}

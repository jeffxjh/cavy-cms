package com.jh.cavycms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jh.cavycms.common.RequestParams;
import com.jh.cavycms.domain.SysUser;
import com.jh.cavycms.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;


    public int deleteByPrimaryKey(Integer id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }


    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }


    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }


    public SysUser selectByPrimaryKey(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SysUser> listByPage(RequestParams params) {
        if (params.getPageNum() == null || params.getPageNum() == 0) {
            params.setPageNum(1);
        }
        if (params.getPageSize() == null || params.getPageSize() == 0) {
            params.setPageSize(10);
        }
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<SysUser> list = sysUserMapper.listByPage(params.getParams());
        PageInfo<SysUser> pageList = new PageInfo<>(list);
        return pageList;
    }
}




